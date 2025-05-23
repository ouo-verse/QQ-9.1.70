package com.qq.e.comm.plugin.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.qq.e.comm.managers.GDTADManager;

/* loaded from: classes3.dex */
public class IPCConnection {
    boolean active = true;
    public IPCBinderEntity binderEntity;
    public IPCModuleManager callbackManager;
    public String procName;

    public IPCConnection(String str, IPCBinderEntity iPCBinderEntity) {
        this.procName = str;
        this.binderEntity = iPCBinderEntity;
    }

    public IPCResult callModule(String str, String str2, Bundle bundle) throws RemoteException {
        if (bundle != null) {
            bundle.setClassLoader(GDTADManager.getInstance().getPM().getPluginClassLoader());
        }
        return this.binderEntity.sync(str, str2, bundle, -99999);
    }

    public IPCResult callModuleAsync(String str, String str2, Bundle bundle, IPCResultCallback iPCResultCallback) throws RemoteException {
        if (bundle != null) {
            bundle.setClassLoader(GDTADManager.getInstance().getPM().getPluginClassLoader());
        }
        return this.binderEntity.async(str, str2, bundle, this.callbackManager.registerCallback(iPCResultCallback), -1);
    }

    public boolean isAvailable() {
        IBinder asBinder = this.binderEntity.asBinder();
        if (this.active && asBinder != null && asBinder.isBinderAlive() && asBinder.pingBinder()) {
            return true;
        }
        return false;
    }
}
