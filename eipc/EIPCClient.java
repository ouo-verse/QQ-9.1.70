package eipc;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCChannel;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* loaded from: classes28.dex */
public class EIPCClient extends EIPCModuleManager {
    public ArrayList<String> guardServerProcList;
    String mAction;
    int mClientId;
    EIPCConnection mServerConnection;
    ArrayList<EIPClientConnectListener> sListener;

    /* loaded from: classes28.dex */
    public static class ClientDeathRecipient implements IBinder.DeathRecipient {
        public IBinder binder;
        public EIPCConnection connection;
        public EIPCClient eipcClient;

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            EIPCClient eIPCClient = this.eipcClient;
            if (eIPCClient != null) {
                eIPCClient.connect(new EIPClientConnectListener() { // from class: eipc.EIPCClient.ClientDeathRecipient.1
                    @Override // eipc.EIPClientConnectListener
                    public void connectFailed() {
                        QLog.d(EIPCConst.TAG, 2, "client binderDied connectFailed");
                    }

                    @Override // eipc.EIPClientConnectListener
                    public void connectSuccess(EIPCConnection eIPCConnection) {
                        QLog.d(EIPCConst.TAG, 2, "client binderDied connectSuccess");
                    }
                });
            }
            if (QLog.isColorLevel()) {
                QLog.d(EIPCConst.TAG, 2, "client binderDied, " + this.connection);
            }
            this.binder.unlinkToDeath(this, 0);
        }
    }

    public EIPCClient(Context context, int i3) {
        super(context);
        this.mServerConnection = null;
        this.sListener = new ArrayList<>();
        this.guardServerProcList = new ArrayList<>();
        this.mClientId = i3;
    }

    public EIPCResult callServer(String str, String str2, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d(EIPCConst.TAG, 2, "callServerLock, module=", str, ", action=", str2, ", params=", bundle);
        }
        connect(null);
        if (bundle != null) {
            bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        }
        try {
            EIPCConnection eIPCConnection = this.mServerConnection;
            if (eIPCConnection == null) {
                return EIPCResult.createResult(-1, null);
            }
            if (!eIPCConnection.isAvailable()) {
                return EIPCResult.createResult(-2, null);
            }
            return eIPCConnection.callModule(str, str2, bundle, -99999);
        } catch (Throwable th5) {
            QLog.e(EIPCConst.TAG, 1, "EIPCClient, callServer1: ", th5);
            return EIPCResult.createExceptionResult(th5);
        }
    }

    @Override // eipc.EIPCModuleManager
    public void callbackResult(int i3, EIPCResult eIPCResult) {
        try {
            this.mServerConnection.channel.callback(i3 % 1000000, eIPCResult);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(EIPCConst.TAG, 2, "callbackResult error", e16);
            }
        }
    }

    public void connect(EIPClientConnectListener eIPClientConnectListener) {
        EIPCChannel eIPCChannel;
        EIPCChannel eIPCChannel2;
        EIPCConnection eIPCConnection = this.mServerConnection;
        if (eIPCConnection == null || (eIPCChannel2 = eIPCConnection.channel) == null || !eIPCChannel2.asBinder().isBinderAlive() || !eIPCConnection.channel.asBinder().pingBinder()) {
            connectProvider();
        }
        EIPCConnection eIPCConnection2 = this.mServerConnection;
        if (eIPCConnection2 != null && (eIPCChannel = eIPCConnection2.channel) != null && eIPCChannel.asBinder().isBinderAlive() && eIPCConnection2.channel.asBinder().pingBinder()) {
            if (eIPClientConnectListener != null) {
                eIPClientConnectListener.connectSuccess(this.mServerConnection);
            }
        } else if (eIPClientConnectListener != null) {
            eIPClientConnectListener.connectFailed();
        }
    }

    public void connectProvider() {
        try {
            IBinder queryBinder = EIPCContentProvider.queryBinder(this.mContext);
            EIPCChannel asInterface = EIPCChannel.Stub.asInterface(queryBinder);
            int client = asInterface.setClient(MobileQQ.processName, Process.myPid(), this.channel, this.mClientId);
            String procName = asInterface.getProcName();
            EIPCConnection eIPCConnection = new EIPCConnection(asInterface, asInterface.getProcName());
            this.mServerConnection = eIPCConnection;
            eIPCConnection.remoteIndex = client;
            eIPCConnection.callbackManager = this;
            eIPCConnection.logMark = "EIPCServer";
            Iterator<String> it = this.guardServerProcList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (TextUtils.equals(procName, it.next())) {
                    if (QLog.isColorLevel()) {
                        QLog.d(EIPCConst.TAG, 2, MobileQQ.processName + " guard " + procName);
                    }
                    ClientDeathRecipient clientDeathRecipient = new ClientDeathRecipient();
                    clientDeathRecipient.eipcClient = this;
                    clientDeathRecipient.binder = queryBinder;
                    clientDeathRecipient.connection = this.mServerConnection;
                    queryBinder.linkToDeath(clientDeathRecipient, 0);
                }
            }
            QLog.d(EIPCConst.TAG, 1, "connectProvider success");
        } catch (Exception e16) {
            QLog.d(EIPCConst.TAG, 1, "connectProvider ", e16);
        }
    }

    public void disConnect() {
        if (QLog.isColorLevel()) {
            QLog.d(EIPCConst.TAG, 2, "EIPCClient.disConnect,");
        }
    }

    public void sendMessageToRemote(int i3, Bundle bundle) {
        EIPCConnection eIPCConnection = this.mServerConnection;
        if (eIPCConnection != null) {
            try {
                eIPCConnection.callModule("__event_module", null, bundle, i3);
            } catch (RemoteException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void callServer(final String str, final String str2, final Bundle bundle, final EIPCResultCallback eIPCResultCallback) {
        connect(new EIPClientConnectListener() { // from class: eipc.EIPCClient.1
            @Override // eipc.EIPClientConnectListener
            public void connectFailed() {
                EIPCResultCallback eIPCResultCallback2 = eIPCResultCallback;
                if (eIPCResultCallback2 != null) {
                    eIPCResultCallback2.onCallback(EIPCResult.createResult(-2, null));
                }
            }

            @Override // eipc.EIPClientConnectListener
            public void connectSuccess(EIPCConnection eIPCConnection) {
                EIPCResult createExceptionResult;
                EIPCResultCallback eIPCResultCallback2;
                try {
                    Bundle bundle2 = bundle;
                    if (bundle2 != null) {
                        bundle2.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
                    }
                    EIPCConnection eIPCConnection2 = EIPCClient.this.mServerConnection;
                    createExceptionResult = null;
                    if (eIPCConnection2 == null) {
                        createExceptionResult = EIPCResult.createResult(-1, null);
                    } else if (!eIPCConnection2.isAvailable()) {
                        createExceptionResult = EIPCResult.createResult(-2, null);
                    } else {
                        eIPCConnection2.callModuleAsync(str, str2, bundle, eIPCResultCallback);
                    }
                } catch (Throwable th5) {
                    QLog.e(EIPCConst.TAG, 1, "EIPCClient, callServer2: ", th5);
                    createExceptionResult = EIPCResult.createExceptionResult(th5);
                }
                if (createExceptionResult != null && (eIPCResultCallback2 = eIPCResultCallback) != null) {
                    eIPCResultCallback2.onCallback(createExceptionResult);
                }
            }
        });
    }
}
