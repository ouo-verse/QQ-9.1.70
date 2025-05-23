package eipc;

import android.os.Bundle;

/* loaded from: classes28.dex */
public abstract class EIPCModule {
    int[] listenMessages;
    EIPCModuleManager mgr;
    public String name;

    public EIPCModule(String str) {
        this.listenMessages = new int[0];
        this.name = str;
    }

    public void callbackResult(int i3, EIPCResult eIPCResult) {
        this.mgr.callbackResult(i3, eIPCResult);
    }

    public abstract EIPCResult onCall(String str, Bundle bundle, int i3);

    public String toString() {
        return "name:" + this.name;
    }

    public EIPCModule(String str, int[] iArr) {
        this.name = str;
        this.listenMessages = iArr;
    }

    public void onReceiveMsg(int i3, Bundle bundle) {
    }
}
