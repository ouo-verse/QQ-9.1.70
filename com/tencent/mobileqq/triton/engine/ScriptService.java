package com.tencent.mobileqq.triton.engine;

import android.os.SystemClock;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.triton.engine.JSThread;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.render.VSyncScheduler;
import com.tencent.mobileqq.triton.internal.statistic.FrameCallbackHelper;
import com.tencent.mobileqq.triton.internal.touch.TouchProviderBridge;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.jni.JNICaller;
import com.tencent.mobileqq.triton.render.RenderContext;
import com.tencent.mobileqq.triton.statistic.FrameCallback;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001.B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\b\u0010&\u001a\u00020$H\u0016J\u0006\u0010'\u001a\u00020$J\b\u0010(\u001a\u00020\u000eH\u0016J\b\u0010)\u001a\u00020$H\u0002J\u0006\u0010*\u001a\u00020$J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020$H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/triton/engine/ScriptService;", "Lcom/tencent/mobileqq/triton/engine/JSThread$IListener;", "mEngine", "Lcom/tencent/mobileqq/triton/engine/TTEngine;", "targetFPSHolder", "Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;", "", "frameCallback", "Lcom/tencent/mobileqq/triton/statistic/FrameCallback;", "accumulatedDrawCallsHolder", "", "currentDrawCallsHolder", "accumulatedFramesHolder", "debugEnabled", "", "(Lcom/tencent/mobileqq/triton/engine/TTEngine;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Lcom/tencent/mobileqq/triton/internal/lifecycle/ValueHolder;Z)V", "isJSThread", "()Z", "mDebugEnabled", "mDrawCallsSinceLastLiveLog", "", "mFrameCallback", "Lcom/tencent/mobileqq/triton/internal/statistic/FrameCallbackHelper;", "mIsDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mJSThread", "Lcom/tencent/mobileqq/triton/engine/JSThread;", "mLastLiveLogProcessedMessages", "mLiveLogRunnable", "Ljava/lang/Runnable;", "mStartLatch", "Ljava/util/concurrent/CountDownLatch;", "mVSyncScheduler", "Lcom/tencent/mobileqq/triton/internal/render/VSyncScheduler;", "mVSyncsSinceLastLiveLog", "awaitStart", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onExit", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onPrepare", "onPrepareJsRuntime", "onResume", "onVSync", "drawTime", "printLiveLog", "Companion", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class ScriptService implements JSThread.IListener {
    private static final long LIVE_LOG_DURATION_MS = TimeUnit.SECONDS.toMillis(20);
    private static final boolean LOG_LOOPER_TIME_COST = false;
    private static final String TAG = "ScriptService";
    private final ValueHolder<Long> accumulatedDrawCallsHolder;
    private final ValueHolder<Long> accumulatedFramesHolder;
    private final ValueHolder<Long> currentDrawCallsHolder;
    private final boolean mDebugEnabled;
    private int mDrawCallsSinceLastLiveLog;
    private final TTEngine mEngine;
    private final FrameCallbackHelper mFrameCallback;
    private final AtomicBoolean mIsDestroyed;
    private final JSThread mJSThread;
    private int mLastLiveLogProcessedMessages;
    private final Runnable mLiveLogRunnable;
    private final CountDownLatch mStartLatch;
    private final VSyncScheduler mVSyncScheduler;
    private int mVSyncsSinceLastLiveLog;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "drawTime", "invoke"}, k = 3, mv = {1, 1, 16})
    /* renamed from: com.tencent.mobileqq.triton.engine.ScriptService$1, reason: invalid class name */
    /* loaded from: classes19.dex */
    static final /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<Long, Unit> {
        AnonymousClass1(ScriptService scriptService) {
            super(1, scriptService);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "onVSync";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection.getOrCreateKotlinClass(ScriptService.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "onVSync(J)V";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
            invoke(l3.longValue());
            return Unit.INSTANCE;
        }

        public final void invoke(long j3) {
            ((ScriptService) this.receiver).onVSync(j3);
        }
    }

    public ScriptService(@NotNull TTEngine mEngine, @NotNull ValueHolder<Float> targetFPSHolder, @NotNull ValueHolder<FrameCallback> frameCallback, @NotNull ValueHolder<Long> accumulatedDrawCallsHolder, @NotNull ValueHolder<Long> currentDrawCallsHolder, @NotNull ValueHolder<Long> accumulatedFramesHolder, boolean z16) {
        Intrinsics.checkParameterIsNotNull(mEngine, "mEngine");
        Intrinsics.checkParameterIsNotNull(targetFPSHolder, "targetFPSHolder");
        Intrinsics.checkParameterIsNotNull(frameCallback, "frameCallback");
        Intrinsics.checkParameterIsNotNull(accumulatedDrawCallsHolder, "accumulatedDrawCallsHolder");
        Intrinsics.checkParameterIsNotNull(currentDrawCallsHolder, "currentDrawCallsHolder");
        Intrinsics.checkParameterIsNotNull(accumulatedFramesHolder, "accumulatedFramesHolder");
        this.mEngine = mEngine;
        this.accumulatedDrawCallsHolder = accumulatedDrawCallsHolder;
        this.currentDrawCallsHolder = currentDrawCallsHolder;
        this.accumulatedFramesHolder = accumulatedFramesHolder;
        this.mStartLatch = new CountDownLatch(1);
        this.mFrameCallback = new FrameCallbackHelper(frameCallback);
        this.mIsDestroyed = new AtomicBoolean(false);
        this.mDebugEnabled = z16;
        JSThread jSThread = new JSThread(mEngine, this);
        this.mJSThread = jSThread;
        jSThread.start();
        this.mVSyncScheduler = new VSyncScheduler(new AnonymousClass1(this), targetFPSHolder, new Executor() { // from class: com.tencent.mobileqq.triton.engine.ScriptService.2
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                ScriptService.this.mEngine.postRunnable(runnable);
            }
        });
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.triton.engine.ScriptService.3
            @Override // java.lang.Runnable
            public void run() {
                EngineState engineState = ScriptService.this.mEngine.getEngineContext().getEngineState();
                if (engineState == EngineState.STARTED) {
                    ScriptService.this.printLiveLog();
                }
                if (engineState != EngineState.DESTROYED) {
                    ScriptService.this.mEngine.postRunnableDelayed(this, ScriptService.LIVE_LOG_DURATION_MS);
                }
            }
        };
        this.mLiveLogRunnable = runnable;
        runnable.run();
    }

    private final void onPrepareJsRuntime() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mEngine.createTTApp();
        this.mStartLatch.countDown();
        this.mEngine.getJsRuntimeLoader().initJsRuntime();
        Logger.i$default(TAG, "injectJS BaseLib cost time:" + (SystemClock.uptimeMillis() - uptimeMillis) + "ms", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVSync(long drawTime) {
        TouchProviderBridge touchEventManager;
        if (this.mIsDestroyed.get()) {
            Logger.e$default(TAG, "onVsync: destroyed, but still post vsync, return it.", null, 4, null);
            return;
        }
        this.mFrameCallback.onFrameBegin(drawTime);
        SystemClock.uptimeMillis();
        ValueHolder<Long> valueHolder = this.accumulatedFramesHolder;
        valueHolder.setValue(Long.valueOf(valueHolder.getValue().longValue() + 1));
        RenderContext renderContext = this.mEngine.getRenderContext();
        if (renderContext != null && (touchEventManager = renderContext.getTouchEventManager()) != null) {
            touchEventManager.flushTouchEvents(this.mEngine);
        }
        TTEngine tTEngine = this.mEngine;
        JNICaller.TTEngine.nativeOnVSync(tTEngine, tTEngine.getNativeTTAppHandle(), drawTime);
        TTEngine tTEngine2 = this.mEngine;
        long nativeGetCurrentFrameDrawCallCount = JNICaller.TTEngine.nativeGetCurrentFrameDrawCallCount(tTEngine2, tTEngine2.getNativeTTAppHandle());
        this.currentDrawCallsHolder.setValue(Long.valueOf(nativeGetCurrentFrameDrawCallCount));
        ValueHolder<Long> valueHolder2 = this.accumulatedDrawCallsHolder;
        valueHolder2.setValue(Long.valueOf(valueHolder2.getValue().longValue() + nativeGetCurrentFrameDrawCallCount));
        TTEngine tTEngine3 = this.mEngine;
        JNICaller.TTEngine.nativeCanvasPresent(tTEngine3, tTEngine3.getNativeTTAppHandle());
        this.mFrameCallback.onFrameEnd();
        this.mVSyncsSinceLastLiveLog++;
        this.mDrawCallsSinceLastLiveLog += (int) nativeGetCurrentFrameDrawCallCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printLiveLog() {
        int processedMessageCount;
        try {
            TTEngine tTEngine = this.mEngine;
            processedMessageCount = tTEngine.getProcessedMessageCount(tTEngine.getNativeTTAppHandle());
        } catch (UnsatisfiedLinkError unused) {
            TTEngine tTEngine2 = this.mEngine;
            processedMessageCount = tTEngine2.getProcessedMessageCount(tTEngine2.getNativeTTAppHandle());
        }
        Logger.i$default(TAG, "JSThread liveLog in 20s Frame=[" + this.mVSyncsSinceLastLiveLog + "] DrawCall=[" + this.mDrawCallsSinceLastLiveLog + "] Message=[" + (processedMessageCount - this.mLastLiveLogProcessedMessages) + ']', null, 4, null);
        this.mVSyncsSinceLastLiveLog = 0;
        this.mDrawCallsSinceLastLiveLog = 0;
        this.mLastLiveLogProcessedMessages = processedMessageCount;
    }

    public final void awaitStart() {
        long uptimeMillis = SystemClock.uptimeMillis();
        while (this.mStartLatch.getCount() != 0) {
            try {
                this.mStartLatch.await(1L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
            }
            if (this.mStartLatch.getCount() != 0) {
                Logger.w$default(TAG, "awaitStart cost too long!!! " + (SystemClock.uptimeMillis() - uptimeMillis) + "ms", null, 4, null);
            }
        }
        Logger.i$default(TAG, "awaitStartCostTime:" + (SystemClock.uptimeMillis() - uptimeMillis) + "ms", null, 4, null);
    }

    public final boolean isJSThread() {
        JSThread jSThread = this.mJSThread;
        if (jSThread != null && jSThread.isJSThread()) {
            return true;
        }
        return false;
    }

    public final void onDestroy() {
        this.mIsDestroyed.set(true);
        JSThread jSThread = this.mJSThread;
        if (jSThread == null) {
            Intrinsics.throwNpe();
        }
        jSThread.shutdown();
    }

    @Override // com.tencent.mobileqq.triton.engine.JSThread.IListener
    public void onExit() {
        this.mEngine.disposeTTApp();
    }

    public final void onPause() {
        Logger.i$default(TAG, "============onPause==============", null, 4, null);
        this.mVSyncScheduler.stopScheduleVSync();
        JSThread jSThread = this.mJSThread;
        if (jSThread == null) {
            Intrinsics.throwNpe();
        }
        jSThread.onPause();
    }

    @Override // com.tencent.mobileqq.triton.engine.JSThread.IListener
    public boolean onPrepare() {
        onPrepareJsRuntime();
        return false;
    }

    public final void onResume() {
        Logger.i$default(TAG, "============onResume==============", null, 4, null);
        JSThread jSThread = this.mJSThread;
        if (jSThread == null) {
            Intrinsics.throwNpe();
        }
        jSThread.onResume();
        this.mVSyncScheduler.startScheduleVSync();
    }
}
