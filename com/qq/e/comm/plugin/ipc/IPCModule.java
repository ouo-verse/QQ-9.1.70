package com.qq.e.comm.plugin.ipc;

import android.os.Bundle;

/* loaded from: classes3.dex */
public abstract class IPCModule {
    IPCModuleManager mIPCModuleManager;
    public String moduleName;

    public IPCModule(String str) {
        this.moduleName = str;
    }

    public void callbackResult(int i3, IPCResult iPCResult) {
        this.mIPCModuleManager.callbackResult(i3, iPCResult);
    }

    public abstract IPCResult onCall(String str, Bundle bundle);
}
