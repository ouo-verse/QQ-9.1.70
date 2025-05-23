package com.tencent.gamecenter.wadl.biz.ipc;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPClientConnectListener;

/* loaded from: classes6.dex */
public class WadlQIPCConnector {
    private static final String TAG = "Wadl_QIPCConnector";
    private static final long WAIT_CONNECT_TIMEOUT = 500;
    private static volatile WadlQIPCConnector sInstance;
    private String mServerProcName;
    private boolean mConnected = false;
    private boolean mIsConnecting = false;
    private Object mWaitConnectObj = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements EIPCOnGetConnectionListener {
        a() {
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(EIPCConnection eIPCConnection) {
            if (eIPCConnection != null) {
                WadlQIPCConnector.this.mServerProcName = eIPCConnection.procName;
            }
            WadlQIPCConnector.this.mConnected = true;
            QLog.d(WadlQIPCConnector.TAG, 1, "onConnectBind");
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(EIPCConnection eIPCConnection) {
            if (eIPCConnection != null) {
                WadlQIPCConnector.this.mServerProcName = eIPCConnection.procName;
            }
            WadlQIPCConnector.this.mConnected = false;
            QLog.d(WadlQIPCConnector.TAG, 1, "onConnectUnbind");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements EIPClientConnectListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f106838d;

        b(long j3) {
            this.f106838d = j3;
        }

        @Override // eipc.EIPClientConnectListener
        public void connectFailed() {
            WadlQIPCConnector.this.mConnected = false;
            WadlQIPCConnector.this.mIsConnecting = false;
            synchronized (WadlQIPCConnector.this.mWaitConnectObj) {
                WadlQIPCConnector.this.mWaitConnectObj.notifyAll();
            }
            QLog.d(WadlQIPCConnector.TAG, 1, "connectFailed:" + WadlQIPCConnector.this.mServerProcName);
        }

        @Override // eipc.EIPClientConnectListener
        public void connectSuccess(EIPCConnection eIPCConnection) {
            long currentTimeMillis = System.currentTimeMillis();
            if (eIPCConnection != null) {
                WadlQIPCConnector.this.mServerProcName = eIPCConnection.procName;
            }
            WadlQIPCConnector.this.mConnected = true;
            WadlQIPCConnector.this.mIsConnecting = false;
            synchronized (WadlQIPCConnector.this.mWaitConnectObj) {
                WadlQIPCConnector.this.mWaitConnectObj.notifyAll();
            }
            QLog.d(WadlQIPCConnector.TAG, 1, "connectSuccess:" + WadlQIPCConnector.this.mServerProcName + "|" + (currentTimeMillis - this.f106838d));
        }
    }

    WadlQIPCConnector() {
    }

    public static WadlQIPCConnector getInstance() {
        if (sInstance == null) {
            synchronized (WadlQIPCConnector.class) {
                if (sInstance == null) {
                    sInstance = new WadlQIPCConnector();
                }
            }
        }
        return sInstance;
    }

    public void checkConnect() {
        if (!this.mConnected && !this.mIsConnecting) {
            connect();
        }
        if (!this.mConnected) {
            synchronized (this.mWaitConnectObj) {
                if (!this.mConnected) {
                    try {
                        this.mWaitConnectObj.wait(500L);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
    }

    protected void connect() {
        this.mIsConnecting = true;
        QLog.d(TAG, 1, "begin connect:");
        QIPCClientHelper.getInstance().getClient().addListener(new a());
        QIPCClientHelper.getInstance().getClient().connect(new b(System.currentTimeMillis()));
    }
}
