package com.tencent.ark;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes3.dex */
public final class ArkEGLApplicationContextManager extends ArkEGLApplicationContextManagerBase implements IArkEGLContextManager {
    private final HashMap<String, AppEGLContext> _appContextMap = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class AppEGLContext {
        public EGLContextHolder context;
        public int refCount;

        AppEGLContext() {
            this.refCount = 0;
        }
    }

    @Override // com.tencent.ark.IArkEGLContextManager
    public EGLContextHolder createContext(String str) {
        EGLContextHolder eGLContextHolder;
        Logger.logI("ArkApp.ContextManager", String.format("ArkEGLApplicationContextManager.createContext.%s", str));
        synchronized (this._appContextMap) {
            AppEGLContext appEGLContext = this._appContextMap.get(str);
            if (appEGLContext != null) {
                appEGLContext.refCount++;
            } else {
                appEGLContext = new AppEGLContext();
                appEGLContext.refCount = 1;
                appEGLContext.context = ArkEGLApplicationContextManagerBase.createOffscreenContext();
                this._appContextMap.put(str, appEGLContext);
            }
            eGLContextHolder = appEGLContext.context;
        }
        return eGLContextHolder;
    }

    @Override // com.tencent.ark.IArkEGLContextManager
    public EGLContextHolder getContext(String str) {
        synchronized (this._appContextMap) {
            AppEGLContext appEGLContext = this._appContextMap.get(str);
            if (appEGLContext != null && appEGLContext.refCount > 0) {
                return appEGLContext.context;
            }
            return null;
        }
    }

    @Override // com.tencent.ark.IArkEGLContextManager
    public boolean releaseContext(String str) {
        synchronized (this._appContextMap) {
            AppEGLContext appEGLContext = this._appContextMap.get(str);
            if (appEGLContext == null) {
                Logger.logE("ArkApp.ContextManager", String.format("release context unexpectedly, appid is %s", str));
                return false;
            }
            int i3 = appEGLContext.refCount - 1;
            appEGLContext.refCount = i3;
            if (i3 != 0) {
                return false;
            }
            Logger.logI("ArkApp.ContextManager", String.format("release context, appid is %s", str));
            this._appContextMap.remove(str);
            EGLContextHolder eGLContextHolder = appEGLContext.context;
            if (eGLContextHolder != null) {
                eGLContextHolder.release();
                appEGLContext.context = null;
            }
            return true;
        }
    }
}
