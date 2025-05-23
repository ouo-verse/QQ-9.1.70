package com.tencent.ark;

import javax.microedition.khronos.egl.EGL10;

/* compiled from: P */
/* loaded from: classes3.dex */
class ArkEGLApplicationContextManagerBase {
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    protected static final String TAG = "ArkApp.ContextManager";

    public static EGLContextHolder createOffscreenContext() {
        if (!ENV.isHardwareAcceleration()) {
            return null;
        }
        EGLContextHolder eGLContextHolder = new EGLContextHolder();
        if (!eGLContextHolder.create(EGL10.EGL_NO_CONTEXT, null, 1, 1)) {
            Logger.logE(TAG, "createOffscreenContext.create.fail");
            eGLContextHolder.release();
            return null;
        }
        return eGLContextHolder;
    }
}
