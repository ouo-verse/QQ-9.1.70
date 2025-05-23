package com.tencent.mobileqq.triton.engine;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.Display;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.triton.annotation.JNIModule;
import com.tencent.mobileqq.triton.api.TTChannel;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.exception.TritonInitException;
import com.tencent.mobileqq.triton.font.FontBitmapManager;
import com.tencent.mobileqq.triton.game.GameLauncher;
import com.tencent.mobileqq.triton.internal.debug.JankCanaryAgent;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl;
import com.tencent.mobileqq.triton.internal.engine.TTAppAgent;
import com.tencent.mobileqq.triton.internal.game.EngineScriptPackageBridge;
import com.tencent.mobileqq.triton.internal.game.GameDataFileSystemBridge;
import com.tencent.mobileqq.triton.internal.game.GameScriptPackageBridge;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.model.PlatformConfig;
import com.tencent.mobileqq.triton.internal.script.InspectorBridge;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.jni.JNICaller;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import com.tencent.mobileqq.triton.statistic.NativeLibraryLoadStatistic;
import com.tencent.mobileqq.triton.utils.CanvasRecorder;
import com.tencent.mobileqq.triton.utils.TritonKeep;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import io.github.landerlyoung.jenny.NativeProxyForClasses;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@TritonKeep
@NativeProxy(allFields = false, allMethods = false, namespace = "jni")
@NativeProxyForClasses(classes = {Runnable.class}, namespace = "jni")
@JNIModule
/* loaded from: classes19.dex */
public class TTEngine {
    private static WeakReference<Context> sContextRef;

    @TritonKeep
    private final CanvasRecorder mCanvasRecorder;
    private final Context mContext;
    private final EngineContext mEngineContext;
    private long mEngineInitLoadSoEndTime;
    private long mEngineInitStartTime;
    private final GameLauncher mGameLauncher;
    private InspectorBridge mInspectorBridge;
    private JankCanaryAgent mJankCanary;
    private EngineScriptLoader mJsRuntimeLoader;
    private final ArrayList<NativeLibraryLoadStatistic> mNativeLibraryLoadStatistics;
    private final PlatformConfig mPlatformConfig;
    private volatile RenderContext mRenderContext;
    private volatile ScriptService mScriptEngine;

    @TritonKeep
    private final TTChannel mTTChannel;
    private TouchProviderBridge mTouchEventManager;
    private long nativeTTAppHandle;
    private final String tag;

    public TTEngine(PlatformConfig platformConfig, EngineContext engineContext, List<NativeLibraryLoadStatistic> list) throws TritonInitException {
        ArrayList<NativeLibraryLoadStatistic> arrayList = new ArrayList<>();
        this.mNativeLibraryLoadStatistics = arrayList;
        this.tag = "TTEngine@" + Integer.toHexString(System.identityHashCode(this));
        this.mPlatformConfig = platformConfig;
        this.mEngineContext = engineContext;
        arrayList.addAll(list);
        Context context = platformConfig.getContext();
        this.mContext = context;
        sContextRef = new WeakReference<>(context.getApplicationContext());
        this.nativeTTAppHandle = 0L;
        this.mTTChannel = new TTChannel(platformConfig.getDebugConfig());
        this.mGameLauncher = new GameLauncher(this);
        this.mJsRuntimeLoader = new EngineScriptLoader(engineContext);
        this.mCanvasRecorder = new CanvasRecorder(this);
        bindErrorCallback(engineContext);
        initEngine();
    }

    private void bindErrorCallback(final EngineContext engineContext) {
        this.mTTChannel.setOnScriptErrorCallback(new Function1<byte[], Unit>() { // from class: com.tencent.mobileqq.triton.engine.TTEngine.1
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(byte[] bArr) {
                ErrorCallback value = engineContext.getStatisticsManager().getErrorCallback().getValue();
                if (value != null) {
                    value.onScriptError(bArr != null ? new String(bArr) : "unknown error", "");
                }
                return Unit.INSTANCE;
            }
        });
        this.mTTChannel.setOnRenderErrorCallback(new Function0<Unit>() { // from class: com.tencent.mobileqq.triton.engine.TTEngine.2
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ErrorCallback value = engineContext.getStatisticsManager().getErrorCallback().getValue();
                if (value != null) {
                    value.onError("black screen detected", new TritonException("black screen detected", ErrorCodes.RENDER_BLACK_SCREEN));
                }
                return Unit.INSTANCE;
            }
        });
        this.mTTChannel.setV8OOMCallback(new Function0<Unit>() { // from class: com.tencent.mobileqq.triton.engine.TTEngine.3
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                TTEngine.this.getGameLauncher().onV8OOM();
                try {
                    LockMethodProxy.sleep(TTL.MAX_VALUE);
                } catch (InterruptedException e16) {
                    Logger.e(TTEngine.this.tag, "v8OOMCallback sleep exception.", e16);
                }
                return Unit.INSTANCE;
            }
        });
    }

    private boolean checkOpenGLES30(Context context) {
        try {
            if (((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getDeviceConfigurationInfo().reqGlEsVersion < 196608) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            Logger.e(this.tag, "checkOpenGLES30 fail, exception=", e16);
            return false;
        }
    }

    private static float getScreenRefreshRate(Context context) {
        Display[] displays = ((DisplayManager) context.getSystemService("display")).getDisplays();
        if (displays != null && displays.length > 0) {
            return displays[0].getRefreshRate();
        }
        return 60.0f;
    }

    private void initEngine() throws TritonInitException {
        boolean z16;
        synchronized (this) {
            this.mEngineInitStartTime = System.currentTimeMillis();
            Logger.i(this.tag, "initEngine load triton version : " + JNICaller.TTEngine.nativeGetTTVersion() + " classLoader:" + getClass().getClassLoader());
            this.mEngineContext.getStatisticsManager().getTargetFPSHolder().setValue(Float.valueOf(getScreenRefreshRate(this.mContext)));
            if (this.mPlatformConfig.getEnableOpenGlEs3() && checkOpenGLES30(this.mContext)) {
                z16 = true;
            } else {
                z16 = false;
            }
            long nativeEnvInit = JNICaller.TTEngine.nativeEnvInit(this, z16);
            if (nativeEnvInit != 0) {
                this.nativeTTAppHandle = nativeEnvInit;
                this.mInspectorBridge = new InspectorBridge(getEngineContext().getLifeCycleOwner());
                this.mJankCanary = new JankCanaryAgent(TTAppAgent.nativeGetInstance(this.nativeTTAppHandle, 1), new Executor() { // from class: com.tencent.mobileqq.triton.engine.TTEngine.4
                    @Override // java.util.concurrent.Executor
                    public void execute(Runnable runnable) {
                        TTEngine.this.postRunnable(runnable);
                    }
                }, this.mEngineContext.getMainThreadExecutor(), getEngineContext().getStatisticsManager().getJankTraceLevelHolder(), getEngineContext().getStatisticsManager().getTraceInfoCallbackHolder());
                ValueHolder valueHolder = new ValueHolder(Boolean.FALSE, getEngineContext());
                valueHolder.observe(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.triton.engine.TTEngine.5
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(Boolean bool) {
                        if (!bool.booleanValue()) {
                            return null;
                        }
                        TTEngine.this.getGameLauncher().onFirstRender();
                        return null;
                    }
                });
                this.mTouchEventManager = new TouchProviderBridge(getEngineContext().getLifeCycleOwner(), getEngineContext().getStatisticsManager().getLastClicksHolder(), getEngineContext().getStatisticsManager().getLastClickInfoHolder(), getEngineContext().getStatisticsManager().getLastTouchTimestampHolder());
                StatisticsManagerImpl statisticsManager = getEngineContext().getStatisticsManager();
                this.mRenderContext = new RenderContext(new Function0<Unit>() { // from class: com.tencent.mobileqq.triton.engine.TTEngine.6
                    @Override // kotlin.jvm.functions.Function0
                    public Unit invoke() {
                        TTEngine.this.onInitFinish(ErrorCodes.SUCCESS);
                        return null;
                    }
                }, getEngineContext().getLifeCycleOwner(), this.nativeTTAppHandle, statisticsManager.getFpsListenerHolder(), statisticsManager.getLastBlackScreenTimeMillisHolder(), valueHolder, statisticsManager.getAccumulatedDrawCallsHolder(), getEngineContext().getScreenShotCallbackHolder(), this.mPlatformConfig.getWorkerExecutor(), this.mPlatformConfig.getMainThreadExecutor(), this.mTouchEventManager);
                this.mEngineInitLoadSoEndTime = System.currentTimeMillis();
                this.mScriptEngine = new ScriptService(this, this.mEngineContext.getStatisticsManager().getTargetFPSHolder(), this.mEngineContext.getStatisticsManager().getFrameCallbackHolder(), this.mEngineContext.getStatisticsManager().getAccumulatedDrawCallsHolder(), this.mEngineContext.getStatisticsManager().getCurrentDrawCallsHolder(), this.mEngineContext.getStatisticsManager().getAccumulatedFramesHolder(), this.mPlatformConfig.getDebugConfig().getDebugEnabled());
                this.mScriptEngine.awaitStart();
            } else {
                Logger.e(this.tag, "initEngine nativeEnvInit fail!");
                ErrorCodes errorCodes = ErrorCodes.NATIVE_FUNCTION_CALL;
                onInitFinish(errorCodes);
                throw new TritonInitException("initEngine nativeEnvInit fail!", errorCodes);
            }
        }
    }

    public static native void nativeFontManagerInit(AssetManager assetManager, String str);

    public static native String nativeGetTTVersion();

    @TritonKeep
    @NativeMethodProxy
    private void setTargetFPS(int i3) {
        if (i3 > 0) {
            getEngineContext().getStatisticsManager().getTargetFPSHolder().setValue(Float.valueOf(i3));
        }
    }

    @TritonKeep
    public static void staticHandleV8OOM() {
        final Context context;
        WeakReference<Context> weakReference = sContextRef;
        if (weakReference != null) {
            context = weakReference.get();
        } else {
            context = null;
        }
        if (context == null) {
            Logger.i("ScriptEngine", "staticHandleV8OOM callback, finish it.");
            SystemMethodProxy.killProcess(Process.myPid());
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.triton.engine.TTEngine.7
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(context, "\u5f53\u524d\u6e38\u620f\u8fd0\u884c\u5185\u5b58\u5df2\u8fbe\u4e0a\u9650\uff0c\u8bf7\u9000\u51fa\u91cd\u8fdb\u3002", 0).show();
            }
        });
        handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.triton.engine.TTEngine.8
            @Override // java.lang.Runnable
            public void run() {
                Logger.e("ScriptEngine", "staticHandleV8OOM finish with toast.");
                SystemMethodProxy.killProcess(Process.myPid());
            }
        }, 3000L);
        try {
            LockMethodProxy.sleep(TTL.MAX_VALUE);
        } catch (InterruptedException e16) {
            Logger.e("ScriptEngine", "staticHandleV8OOM sleep exception.", e16);
        }
    }

    public void createTTApp() {
        JNICaller.TTEngine.nativeCreateTTApp(this, this.nativeTTAppHandle, getRenderContext(), getCanvasRecorder(), getTTChannel(), this.mEngineContext.getFontBitmapManager(), this.mInspectorBridge, new EngineScriptPackageBridge(this.mEngineContext.getEnginePackage()), this.mEngineContext.getScriptSystem());
        JNICaller.TTEngine.nativeSetPremultiplyAlpha(this, this.nativeTTAppHandle, this.mPlatformConfig.getDebugConfig().getEnablePremultipliedAlpha());
        JNICaller.TTEngine.nativeSetWebAudioEnable(this, this.nativeTTAppHandle, this.mPlatformConfig.getDebugConfig().getEnableWebAudio());
    }

    public void disposeTTApp() {
        JNICaller.TTEngine.nativeDiposeTTApp(this, this.nativeTTAppHandle);
        this.nativeTTAppHandle = 0L;
    }

    public CanvasRecorder getCanvasRecorder() {
        return this.mCanvasRecorder;
    }

    public long getCurrentDrawCount() {
        return getEngineContext().getStatisticsManager().getCurrentDrawCalls();
    }

    public EngineContext getEngineContext() {
        return this.mEngineContext;
    }

    public GameLauncher getGameLauncher() {
        return this.mGameLauncher;
    }

    public EngineScriptLoader getJsRuntimeLoader() {
        return this.mJsRuntimeLoader;
    }

    public long getNativeTTAppHandle() {
        return this.nativeTTAppHandle;
    }

    public native int getProcessedMessageCount(long j3);

    public RenderContext getRenderContext() {
        return this.mRenderContext;
    }

    public TTChannel getTTChannel() {
        return this.mTTChannel;
    }

    public void initGameInfo() {
        JNICaller.TTEngine.nativeInitGameInfo(this, this.nativeTTAppHandle, new GameScriptPackageBridge(this.mEngineContext.getGamePackage()), new GameDataFileSystemBridge(this.mEngineContext.getDataFileSystem()));
    }

    public native void interruptLoop(long j3);

    public native long nativeCanvasPresent(long j3);

    public native void nativeCreateTTApp(long j3, RenderContext renderContext, CanvasRecorder canvasRecorder, TTChannel tTChannel, FontBitmapManager fontBitmapManager, InspectorBridge inspectorBridge, EngineScriptPackageBridge engineScriptPackageBridge, ScriptSystem scriptSystem);

    public native void nativeDiposeTTApp(long j3);

    public native long nativeEnvInit(boolean z16);

    public native void nativeFinalize(long j3);

    public native long nativeGetCurrentFrameDrawCallCount(long j3);

    public native void nativeInitGameInfo(long j3, GameScriptPackageBridge gameScriptPackageBridge, GameDataFileSystemBridge gameDataFileSystemBridge);

    public native void nativeOnTouchEvent(long j3, long j16);

    public native void nativeOnVSync(long j3, long j16);

    public native void nativeSaveScriptCodeCache(long j3);

    public native void nativeSetJankTraceLevel(long j3, int i3);

    public native void nativeSetPremultiplyAlpha(long j3, boolean z16);

    public native void nativeSetWebAudioEnable(long j3, boolean z16);

    public native void nativeSetWebglTwoEnable(long j3, boolean z16);

    public native boolean nativeStartDrawCall(long j3);

    public void onDestroy() {
        Logger.i(this.tag, "~TTEngine " + this);
        if (this.mRenderContext != null) {
            this.mRenderContext.onDestroy();
        }
        if (this.mScriptEngine != null) {
            this.mScriptEngine.onDestroy();
        }
    }

    public void onInitFinish(ErrorCodes errorCodes) {
        this.mGameLauncher.onInitDone(errorCodes, this.mEngineInitLoadSoEndTime - this.mEngineInitStartTime, getJsRuntimeLoader().getLoadScriptScriptTimeMs(), System.currentTimeMillis() - getJsRuntimeLoader().getLoadEngineScriptEndTime(), System.currentTimeMillis() - this.mEngineInitStartTime, this.mJsRuntimeLoader.getEngineScriptLoadStatics(), this.mJsRuntimeLoader.getEngineScriptInitException(), this.mNativeLibraryLoadStatistics, this.mEngineInitStartTime, getJsRuntimeLoader().getLoadEngineScriptEndTime() - getJsRuntimeLoader().getLoadScriptScriptTimeMs());
    }

    public void onPause() {
        if (this.mScriptEngine != null) {
            this.mScriptEngine.onPause();
        }
    }

    public void onResume() {
        if (this.mScriptEngine != null) {
            this.mScriptEngine.onResume();
        }
    }

    public boolean postRunnable(@NonNull Runnable runnable) {
        return postRunnableDelayed(runnable, 0L);
    }

    public boolean postRunnableDelayed(@NonNull Runnable runnable, long j3) {
        try {
            this.mEngineContext.getLock().lock();
            if (this.mEngineContext.getEngineState() == EngineState.DESTROYED) {
                Logger.w(this.tag, "postRunnable after engine is destroyed " + runnable + " to " + this);
                this.mEngineContext.getLock().unlock();
                return false;
            }
            JNICaller.TTEngine.postRunnableDelayedWithPriority(this, this.nativeTTAppHandle, new WrappedTask(this.tag, runnable, this), j3, 0);
            this.mEngineContext.getLock().unlock();
            return true;
        } catch (Throwable th5) {
            this.mEngineContext.getLock().unlock();
            throw th5;
        }
    }

    public native void postRunnableDelayedWithPriority(long j3, @NonNull Runnable runnable, long j16, int i3);

    public native boolean runLoop(long j3, boolean z16);

    public void saveScriptCodeCache() {
        JNICaller.TTEngine.nativeSaveScriptCodeCache(this, this.nativeTTAppHandle);
    }

    public void setInspectorAgent(InspectorAgent inspectorAgent) {
        if (inspectorAgent != null) {
            this.mInspectorBridge.setProxy(inspectorAgent);
        }
    }

    public String toString() {
        return super.toString() + " " + this.mEngineContext.getId();
    }
}
