package eipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;

/* loaded from: classes28.dex */
public class EIPCServer extends EIPCModuleManager {
    static volatile EIPCServer sServer;
    final SparseArray<EIPCChannel> channelSparseArr;
    final ArrayList<EIPCConnection> clients;
    AtomicInteger instanceCount;

    /* loaded from: classes28.dex */
    public static class ServerRecipient implements IBinder.DeathRecipient {
        public IBinder binder;
        public EIPCConnection connection;
        public EIPCServer eipcServer;

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (this.eipcServer.clients) {
                if (this.eipcServer.clients.remove(this.connection)) {
                    this.eipcServer.notifyUnbind(this.connection);
                }
            }
            this.binder.unlinkToDeath(this, 0);
            if (QLog.isColorLevel()) {
                QLog.d(EIPCConst.TAG, 2, "ServerRecipient " + this.connection);
            }
        }
    }

    public EIPCServer(Context context) {
        super(context);
        this.instanceCount = new AtomicInteger(1);
        this.clients = new ArrayList<>();
        this.channelSparseArr = new SparseArray<>();
    }

    public static EIPCServer getServer() {
        if (sServer == null) {
            synchronized (EIPCServer.class) {
                if (sServer == null) {
                    sServer = new EIPCServer(MobileQQ.sMobileQQ);
                }
            }
        }
        return sServer;
    }

    public EIPCResult callClient(String str, int i3, String str2, String str3, Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
            } catch (Throwable th5) {
                QLog.e(EIPCConst.TAG, 1, "EIPCServer callClient1: ", th5);
                return EIPCResult.createExceptionResult(th5);
            }
        }
        EIPCConnection clientConnection = getClientConnection(str, i3);
        if (clientConnection == null) {
            return EIPCResult.createResult(-1, null);
        }
        if (!clientConnection.isAvailable()) {
            return EIPCResult.createResult(-2, null);
        }
        return clientConnection.callModule(str2, str3, bundle);
    }

    @Override // eipc.EIPCModuleManager
    public void callbackResult(int i3, EIPCResult eIPCResult) {
        EIPCChannel eIPCChannel;
        try {
            int i16 = i3 / 1000000;
            int i17 = i3 % 1000000;
            synchronized (this.channelSparseArr) {
                eIPCChannel = this.channelSparseArr.get(i16);
            }
            if (eIPCChannel != null) {
                eIPCChannel.callback(i17, eIPCResult);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(EIPCConst.TAG, 2, "callbackResult error", e16);
            }
        }
    }

    public EIPCConnection getClientConnection(String str, int i3) {
        synchronized (this.clients) {
            Iterator<EIPCConnection> it = this.clients.iterator();
            while (it.hasNext()) {
                EIPCConnection next = it.next();
                if (TextUtils.equals(str, next.procName) && i3 == next.clientId) {
                    return next;
                }
            }
            return null;
        }
    }

    public ArrayList<EIPCConnection> getClientConnectionList() {
        return new ArrayList<>(this.clients);
    }

    IBinder onServiceBind(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i(EIPCConst.TAG, 2, "EIPCServer onServiceBind");
        }
        return (IBinder) this.channel;
    }

    boolean onServiceUnbind(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i(EIPCConst.TAG, 2, "EIPCServer onServiceUnbind");
        }
        synchronized (this.clients) {
            for (int size = this.clients.size() - 1; size >= 0; size--) {
                EIPCConnection eIPCConnection = this.clients.get(size);
                IBinder asBinder = eIPCConnection.channel.asBinder();
                if (!asBinder.isBinderAlive() || !asBinder.pingBinder()) {
                    this.clients.remove(size);
                    notifyUnbind(eIPCConnection);
                }
            }
        }
        return true;
    }

    public void sendMsgToRemoteModule(int i3, Bundle bundle) {
        synchronized (this.clients) {
            Iterator<EIPCConnection> it = this.clients.iterator();
            while (it.hasNext()) {
                try {
                    it.next().callModule("__event_module", null, bundle, i3);
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    @Override // eipc.EIPCModuleManager
    public int setClient(String str, int i3, EIPCChannel eIPCChannel, int i16) throws RemoteException {
        synchronized (this.clients) {
            if (eIPCChannel != null) {
                EIPCConnection eIPCConnection = new EIPCConnection(eIPCChannel, str);
                eIPCConnection.callbackManager = this;
                eIPCConnection.clientId = i16;
                eIPCConnection.logMark = "EIPCClient";
                if (QLog.isColorLevel()) {
                    QLog.i(EIPCConst.TAG, 2, "EIPCServer setClient, " + eIPCConnection);
                }
                this.clients.add(eIPCConnection);
                notifyBind(eIPCConnection);
                int addAndGet = this.instanceCount.addAndGet(1);
                synchronized (this.channelSparseArr) {
                    this.channelSparseArr.put(addAndGet, eIPCChannel);
                }
                ServerRecipient serverRecipient = new ServerRecipient();
                serverRecipient.eipcServer = this;
                serverRecipient.connection = eIPCConnection;
                serverRecipient.binder = eIPCChannel.asBinder();
                eIPCChannel.asBinder().linkToDeath(serverRecipient, 0);
                return addAndGet;
            }
            for (int size = this.clients.size() - 1; size >= 0; size--) {
                EIPCConnection eIPCConnection2 = this.clients.get(size);
                IBinder asBinder = eIPCConnection2.channel.asBinder();
                if ((!asBinder.isBinderAlive() && !asBinder.pingBinder()) || (TextUtils.equals(str, eIPCConnection2.procName) && i16 == eIPCConnection2.clientId)) {
                    this.clients.remove(size);
                    notifyUnbind(eIPCConnection2);
                }
            }
            return -1;
        }
    }

    public void callClient(String str, int i3, String str2, String str3, Bundle bundle, EIPCResultCallback eIPCResultCallback) {
        EIPCResult createExceptionResult;
        if (bundle != null) {
            try {
                bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
            } catch (Throwable th5) {
                QLog.e(EIPCConst.TAG, 1, "EIPCServer callClient2: ", th5);
                createExceptionResult = EIPCResult.createExceptionResult(th5);
            }
        }
        EIPCConnection clientConnection = getClientConnection(str, i3);
        if (clientConnection == null) {
            createExceptionResult = EIPCResult.createResult(-1, null);
        } else if (!clientConnection.isAvailable()) {
            createExceptionResult = EIPCResult.createResult(-2, null);
        } else {
            clientConnection.callModuleAsync(str2, str3, bundle, eIPCResultCallback);
            return;
        }
        if (eIPCResultCallback != null) {
            eIPCResultCallback.onCallback(createExceptionResult);
        }
    }
}
