package eipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import mqq.app.MobileQQ;

/* loaded from: classes28.dex */
public class EIPCConnection {
    EIPCModuleManager callbackManager;
    EIPCChannel channel;
    public int clientId;
    public String procName;
    int remoteIndex;
    String logMark = "";
    boolean active = true;

    public EIPCConnection(EIPCChannel eIPCChannel, String str) {
        this.channel = eIPCChannel;
        this.procName = str;
    }

    public EIPCResult callModule(String str, String str2, Bundle bundle, int i3) throws RemoteException {
        if (bundle != null) {
            bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
        return this.channel.sync(str, str2, bundle, i3);
    }

    public void callModuleAsync(String str, String str2, Bundle bundle, EIPCResultCallback eIPCResultCallback) throws RemoteException {
        if (bundle != null) {
            bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
        this.channel.async(str, str2, bundle, this.callbackManager.registerCallback(eIPCResultCallback), this.remoteIndex);
    }

    public boolean isAvailable() {
        IBinder asBinder = this.channel.asBinder();
        if (this.active && asBinder.isBinderAlive() && asBinder.pingBinder()) {
            return true;
        }
        return false;
    }

    public IBinder setStubBinder(int i3, IBinder iBinder) throws RemoteException {
        return this.channel.setStubBinder(i3, iBinder);
    }

    public String toString() {
        return this.logMark + ", EIPCConnection[procName=" + this.procName + ", clientId=" + this.clientId + "]";
    }

    public EIPCResult callModule(String str, String str2, Bundle bundle) throws RemoteException {
        if (bundle != null) {
            bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
        return this.channel.sync(str, str2, bundle, -99999);
    }
}
