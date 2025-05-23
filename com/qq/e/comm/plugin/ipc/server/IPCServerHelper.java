package com.qq.e.comm.plugin.ipc.server;

import android.os.Bundle;
import com.qq.e.comm.plugin.ipc.IPCModule;
import com.qq.e.comm.plugin.ipc.IPCResult;
import com.qq.e.comm.plugin.ipc.IPCResultCallback;

/* loaded from: classes3.dex */
public class IPCServerHelper {
    private static volatile IPCServerHelper sInstance;

    IPCServerHelper() {
    }

    public static IPCServerHelper getInstance() {
        if (sInstance == null) {
            synchronized (IPCServerHelper.class) {
                if (sInstance == null) {
                    sInstance = new IPCServerHelper();
                }
            }
        }
        return sInstance;
    }

    private IPCServer getServer() {
        return IPCServer.getServer();
    }

    private void register(IPCModule iPCModule) {
        getServer().register(iPCModule);
    }

    private void unRegister(IPCModule iPCModule) {
        getServer().unRegister(iPCModule);
    }

    public IPCResult callClient(String str, String str2, String str3, Bundle bundle) {
        return getServer().callClient(str, str2, str3, bundle);
    }

    public void callClientAsync(String str, String str2, String str3, Bundle bundle, IPCResultCallback iPCResultCallback) {
        getServer().callClientAsync(str, str2, str3, bundle, iPCResultCallback);
    }
}
