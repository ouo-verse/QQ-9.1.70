package com.tencent.ark;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class ArkEGLContextManager {
    public static final int ApplicationContext = 2;
    public static final int GlobalContext = 1;
    private static final ArkEGLGlobalContextManager _globalMgr = new ArkEGLGlobalContextManager();
    private static final ArkEGLApplicationContextManager _appMgr = new ArkEGLApplicationContextManager();

    ArkEGLContextManager() {
    }

    public static IArkEGLContextManager getManager(int i3) {
        if (i3 == 1) {
            return _globalMgr;
        }
        if (i3 == 2) {
            return _appMgr;
        }
        throw new IllegalArgumentException("unknown context manager type");
    }
}
