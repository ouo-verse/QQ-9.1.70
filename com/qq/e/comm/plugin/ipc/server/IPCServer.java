package com.qq.e.comm.plugin.ipc.server;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ipc.IPCBinderEntity;
import com.qq.e.comm.plugin.ipc.IPCConnection;
import com.qq.e.comm.plugin.ipc.IPCModuleManager;
import com.qq.e.comm.plugin.ipc.IPCResult;
import com.qq.e.comm.plugin.ipc.IPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class IPCServer extends IPCModuleManager {
    private static volatile IPCServer sInstance;
    private final ArrayList<IPCConnection> clients;

    /* loaded from: classes3.dex */
    public static class ServerRecipient implements IBinder.DeathRecipient {
        public IBinder binder;
        public IPCConnection connection;
        public IPCServer ipcServer;

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (this.ipcServer.clients) {
                this.ipcServer.clients.remove(this.connection);
            }
            this.binder.unlinkToDeath(this, 0);
        }
    }

    IPCServer(Context context) {
        super(context);
        this.clients = new ArrayList<>();
    }

    public static IPCServer getServer() {
        if (sInstance == null) {
            synchronized (IPCServer.class) {
                if (sInstance == null) {
                    sInstance = new IPCServer(GDTADManager.getInstance().getAppContext());
                }
            }
        }
        return sInstance;
    }

    public IPCResult callClient(String str, String str2, String str3, Bundle bundle) {
        IPCResult callModule;
        IPCConnection clientConnection = getClientConnection(str);
        try {
            if (clientConnection == null) {
                callModule = IPCResult.createResult(-1, null);
            } else if (!clientConnection.isAvailable()) {
                callModule = IPCResult.createResult(-2, null);
            } else {
                callModule = clientConnection.callModule(str2, str3, bundle);
            }
            return callModule;
        } catch (RemoteException e16) {
            e16.printStackTrace();
            return IPCResult.createExceptionResult(e16);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return IPCResult.createExceptionResult(th5);
        }
    }

    public void callClientAsync(String str, String str2, String str3, Bundle bundle, IPCResultCallback iPCResultCallback) {
        IPCResult createExceptionResult;
        IPCConnection clientConnection = getClientConnection(str);
        try {
            if (clientConnection == null) {
                createExceptionResult = IPCResult.createResult(-1, null);
            } else if (!clientConnection.isAvailable()) {
                createExceptionResult = IPCResult.createResult(-2, null);
            } else {
                clientConnection.callModuleAsync(str2, str3, bundle, iPCResultCallback);
                return;
            }
        } catch (RemoteException e16) {
            e16.printStackTrace();
            createExceptionResult = IPCResult.createExceptionResult(e16);
        } catch (Throwable th5) {
            th5.printStackTrace();
            createExceptionResult = IPCResult.createExceptionResult(th5);
        }
        if (createExceptionResult != null && iPCResultCallback != null) {
            iPCResultCallback.onCallback(createExceptionResult);
        }
    }

    @Override // com.qq.e.comm.plugin.ipc.IPCModuleManager
    public void callbackResult(int i3, IPCResult iPCResult) {
        synchronized (this.mCallbackMap) {
            IPCResultCallback iPCResultCallback = this.mCallbackMap.get(i3);
            if (iPCResultCallback != null) {
                iPCResultCallback.onCallback(iPCResult);
            }
        }
    }

    public IPCConnection getClientConnection(String str) {
        synchronized (this.clients) {
            Iterator<IPCConnection> it = this.clients.iterator();
            while (it.hasNext()) {
                IPCConnection next = it.next();
                if (TextUtils.equals(str, next.procName)) {
                    return next;
                }
            }
            return null;
        }
    }

    @Override // com.qq.e.comm.plugin.ipc.IPCModuleManager
    public int setClient(String str, int i3, IPCBinderEntity iPCBinderEntity) throws RemoteException {
        IPCBinderEntity iPCBinderEntity2;
        IBinder asBinder;
        synchronized (this.clients) {
            if (iPCBinderEntity == null) {
                for (int size = this.clients.size() - 1; size >= 0; size--) {
                    IPCConnection iPCConnection = this.clients.get(size);
                    if (iPCConnection != null && (iPCBinderEntity2 = iPCConnection.binderEntity) != null && (((asBinder = iPCBinderEntity2.asBinder()) != null && !asBinder.isBinderAlive() && !asBinder.pingBinder()) || TextUtils.equals(iPCConnection.procName, str))) {
                        this.clients.remove(iPCConnection);
                    }
                }
            } else {
                IPCConnection iPCConnection2 = new IPCConnection(str, iPCBinderEntity);
                iPCConnection2.callbackManager = this;
                this.clients.add(iPCConnection2);
                ServerRecipient serverRecipient = new ServerRecipient();
                serverRecipient.ipcServer = this;
                serverRecipient.connection = iPCConnection2;
                serverRecipient.binder = iPCBinderEntity.asBinder();
                if (iPCBinderEntity.asBinder() != null) {
                    iPCBinderEntity.asBinder().linkToDeath(serverRecipient, 0);
                }
            }
        }
        return -1;
    }
}
