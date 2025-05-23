package com.tencent.crossengine;

import android.content.Context;
import com.tencent.crossengine.debugJs.InspectorBridge;
import com.tencent.crossengine.debugJs.WebSocketServerInspectAgent;
import com.tencent.crossengine.font.SpineTextPainter;
import com.tencent.crossengine.log.LogDelegate;
import org.json.JSONObject;
import tf0.a;
import tf0.b;
import tf0.c;
import tf0.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CEApplication {
    private static final String NATIVE_LOG_TAG = "CrossEngine";
    private static final String TAG = "CEApplication";
    public static final int WORLD_TIME_SCALE_FIXED_DELTA_TIME = 1000;
    public static final int WORLD_TIME_SCALE_HALF = 2;
    public static final int WORLD_TIME_SCALE_OFF = 1;
    public static final int WORLD_TIME_SCALE_ONETHIRD = 3;
    public static final int WORLD_TIME_SCALE_QUATER = 4;
    private String mAssetsPath;
    private a mCEJSEventListener;
    private b mCELifeCycle;
    private CERenderView mCERenderView;
    private Context mContext;
    private int mDefaultFPS;
    private com.tencent.crossengine.util.a mDisplayInfo;
    private c mFrameCallback;
    private long mNativeHandle;
    private com.tencent.crossengine.offscreen.a mOffscreenWorldCallback;
    private RenderContext mRenderContext;
    private String mStartUpWorld;
    private d mTouchProcessor;
    private boolean mEnableDebugJS = false;
    private boolean mEnableGPUSkinning = false;
    private boolean mOptimizeSpineUpdate = false;
    private GameMainThread mGameMainThread = new GameMainThread(this);

    public CEApplication(Context context, boolean z16) {
        this.mContext = context;
        com.tencent.crossengine.util.a aVar = new com.tencent.crossengine.util.a(context, z16);
        this.mDisplayInfo = aVar;
        this.mRenderContext = new RenderContext(aVar);
        this.mTouchProcessor = new d(this);
    }

    private native long nCreateNativeCEApp(long j3, String str, String str2, InspectorBridge inspectorBridge, int i3, boolean z16);

    private native void nCreateOffScreenWorld(long j3, String str, String str2, int i3, int i16, boolean z16, InspectorBridge inspectorBridge);

    private native void nDestroyWorld(long j3, String str);

    private native void nDispatchTouchEvent(long j3, int i3, int i16, float f16, float f17);

    private native void nEvaluateJs(long j3, String str);

    private native void nEvaluateJsSync(long j3, String str);

    private native void nEvaluateWorldJs(long j3, String str, String str2);

    private native void nExit(long j3);

    private native void nGameLoop(long j3);

    private native void nResizeOffscreenWorld(long j3, String str, int i3, int i16);

    private native void nRunScriptFile(long j3, String str);

    private native void nRunWorldScriptFile(long j3, String str, String str2);

    private native void nSetOptimizeSpineUpdate(long j3, boolean z16);

    private native void nSetTimeScaleForWorld(long j3, String str, int i3, float f16);

    private void printNativeLog(int i3, String str) {
        if (i3 == 0 || i3 == 1) {
            com.tencent.crossengine.log.a.a(NATIVE_LOG_TAG, str);
            return;
        }
        if (i3 == 2) {
            com.tencent.crossengine.log.a.g(NATIVE_LOG_TAG, str);
            return;
        }
        if (i3 == 3) {
            com.tencent.crossengine.log.a.k(NATIVE_LOG_TAG, str);
        } else if (i3 == 4 || i3 == 5) {
            com.tencent.crossengine.log.a.d(NATIVE_LOG_TAG, str);
        }
    }

    public void createOffScreenWorld(String str, String str2, int i3, int i16, boolean z16) {
        InspectorBridge inspectorBridge;
        if (this.mEnableDebugJS) {
            inspectorBridge = new InspectorBridge();
            inspectorBridge.c(new WebSocketServerInspectAgent(str));
        } else {
            inspectorBridge = null;
        }
        nCreateOffScreenWorld(this.mNativeHandle, str, str2, i3, i16, z16, inspectorBridge);
    }

    public CERenderView createRenderView(Context context) {
        if (this.mCERenderView == null) {
            this.mCERenderView = new CERenderView(context, this.mRenderContext, this.mTouchProcessor);
        }
        return this.mCERenderView;
    }

    public void destoryWorld(String str) {
        nDestroyWorld(this.mNativeHandle, str);
    }

    public void destroy() {
        this.mRenderContext.a();
    }

    public void dispatchTouchEvent(int i3, int i16, float f16, float f17) {
        nDispatchTouchEvent(this.mNativeHandle, i3, i16, f16, f17);
    }

    public void evaluateJs(String str) {
        nEvaluateJs(this.mNativeHandle, str);
    }

    public void evaluateJsSync(String str) {
        nEvaluateJsSync(this.mNativeHandle, str);
    }

    public void evaluateWorldJs(String str, String str2) {
        nEvaluateWorldJs(this.mNativeHandle, str, str2);
    }

    public void exit() {
        nExit(this.mNativeHandle);
    }

    public void gameLoop() {
        nGameLoop(this.mNativeHandle);
    }

    public int getHeight() {
        return this.mRenderContext.c();
    }

    public long getNativeHandle() {
        return this.mNativeHandle;
    }

    public RenderContext getRenderContext() {
        return this.mRenderContext;
    }

    public float getScale() {
        return this.mDisplayInfo.a();
    }

    public d getTouchProcessor() {
        return this.mTouchProcessor;
    }

    public int getWidth() {
        return this.mRenderContext.e();
    }

    public String onScriptEvent(String str, String str2) {
        return new JSONObject().toString();
    }

    public void pause() {
        this.mRenderContext.g();
    }

    public void resizeOffscreenWorld(String str, int i3, int i16) {
        nResizeOffscreenWorld(this.mNativeHandle, str, i3, i16);
    }

    public void resume() {
        this.mRenderContext.h();
    }

    public void runScriptFile(String str) {
        nRunScriptFile(this.mNativeHandle, str);
    }

    public void runWorldScriptFile(String str, String str2) {
        nRunWorldScriptFile(this.mNativeHandle, str, str2);
    }

    public void setAssetsPath(String str) {
        this.mAssetsPath = str;
    }

    public void setDefaultFPS(int i3) {
        this.mDefaultFPS = i3;
    }

    public void setEnableDebugJS(boolean z16) {
        this.mEnableDebugJS = z16;
    }

    public void setEnableGPUSkinning(boolean z16) {
        this.mEnableGPUSkinning = z16;
    }

    public void setFontPixelsFactory(uf0.a aVar) {
        SpineTextPainter.setFontPixelsFactory(aVar);
    }

    public void setOptimizeSpineUpdate(boolean z16) {
        this.mOptimizeSpineUpdate = z16;
    }

    public void setStartUpWorld(String str) {
        this.mStartUpWorld = str;
    }

    public void setTimeScaleForWorld(String str, int i3, float f16) {
        nSetTimeScaleForWorld(this.mNativeHandle, str, i3, f16);
    }

    public void startGame() {
        InspectorBridge inspectorBridge;
        if (this.mEnableDebugJS) {
            inspectorBridge = new InspectorBridge();
            inspectorBridge.c(new WebSocketServerInspectAgent(this.mStartUpWorld));
        } else {
            inspectorBridge = null;
        }
        long nCreateNativeCEApp = nCreateNativeCEApp(this.mRenderContext.d(), this.mAssetsPath, this.mStartUpWorld, inspectorBridge, this.mDefaultFPS, this.mEnableGPUSkinning);
        this.mNativeHandle = nCreateNativeCEApp;
        try {
            nSetOptimizeSpineUpdate(nCreateNativeCEApp, this.mOptimizeSpineUpdate);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        this.mGameMainThread.start();
    }

    public void setLogger(LogDelegate logDelegate) {
        if (logDelegate != null) {
            com.tencent.crossengine.log.a.f100479a.j(logDelegate);
        }
    }

    private void onFrameCallback(String str, byte[] bArr, int i3, int i16, int i17) {
    }

    private void onFirstFrame() {
    }

    private void onGameEnd() {
    }

    private void onInit() {
    }

    private void onOffscreenSurfaceReady(String str) {
    }

    private void onOffscreenWorldCreated(String str) {
    }

    public void setCEJSEventListener(a aVar) {
    }

    public void setCELifeCycle(b bVar) {
    }

    public void setFrameCallback(c cVar) {
    }

    public void setOffscreenWorldCallback(com.tencent.crossengine.offscreen.a aVar) {
    }
}
