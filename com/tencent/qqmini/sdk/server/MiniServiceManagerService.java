package com.tencent.qqmini.sdk.server;

import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniServiceManagerService extends IMiniServiceManager.Stub {
    private static HashMap<String, IBinder> services;

    public MiniServiceManagerService() {
        services = new HashMap<>();
    }

    public static IMiniServiceManager asInterface() {
        return new MiniServiceManagerService();
    }

    @Override // com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager
    public void addService(String str, IBinder iBinder) throws RemoteException {
        if (checkService(str) == null) {
            services.put(str, iBinder);
            return;
        }
        throw new RemoteException("MiniService already exists. " + str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager
    public IBinder checkService(String str) throws RemoteException {
        return services.get(str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.ipc.IMiniServiceManager
    public IBinder getService(String str) throws RemoteException {
        return services.get(str);
    }
}
