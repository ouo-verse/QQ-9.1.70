package com.tencent.ark;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class ArkEGLGlobalContextManager extends ArkEGLApplicationContextManagerBase implements IArkEGLContextManager {
    EGLContextHolder _globalContext;

    @Override // com.tencent.ark.IArkEGLContextManager
    public EGLContextHolder createContext(String str) {
        EGLContextHolder eGLContextHolder;
        Logger.logI("ArkApp.ContextManager", String.format("ArkEGLGlobalContextManager.createContext.%s", str));
        synchronized (this) {
            if (this._globalContext == null) {
                EGLContextHolder createOffscreenContext = ArkEGLApplicationContextManagerBase.createOffscreenContext();
                this._globalContext = createOffscreenContext;
                if (createOffscreenContext == null) {
                    Logger.logE("ArkApp.ContextManager", "failed to create global offscreen context");
                } else {
                    EGLContextHolder.setOffscreenContext(createOffscreenContext);
                    Logger.logI("ArkApp.ContextManager", "create global offscreen context");
                }
            }
            eGLContextHolder = this._globalContext;
        }
        return eGLContextHolder;
    }

    @Override // com.tencent.ark.IArkEGLContextManager
    public EGLContextHolder getContext(String str) {
        EGLContextHolder eGLContextHolder;
        synchronized (this) {
            eGLContextHolder = this._globalContext;
        }
        return eGLContextHolder;
    }

    @Override // com.tencent.ark.IArkEGLContextManager
    public boolean releaseContext(String str) {
        return false;
    }
}
