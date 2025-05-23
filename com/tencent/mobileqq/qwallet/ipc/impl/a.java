package com.tencent.mobileqq.qwallet.ipc.impl;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPClientConnectListener;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static volatile a f278505e;

    /* renamed from: c, reason: collision with root package name */
    private String f278508c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f278506a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f278507b = false;

    /* renamed from: d, reason: collision with root package name */
    private Object f278509d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qwallet.ipc.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public class C8471a implements EIPCOnGetConnectionListener {
        C8471a() {
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(EIPCConnection eIPCConnection) {
            if (eIPCConnection != null) {
                a.this.f278508c = eIPCConnection.procName;
            }
            a.this.f278506a = true;
            if (QLog.isColorLevel()) {
                QLog.d("QWalletIPCConnector", 2, "onConnectBind");
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(EIPCConnection eIPCConnection) {
            if (eIPCConnection != null) {
                a.this.f278508c = eIPCConnection.procName;
            }
            a.this.f278506a = false;
            if (QLog.isColorLevel()) {
                QLog.d("QWalletIPCConnector", 2, "onConnectUnbind");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements EIPClientConnectListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f278511d;

        b(long j3) {
            this.f278511d = j3;
        }

        @Override // eipc.EIPClientConnectListener
        public void connectFailed() {
            a.this.f278506a = false;
            a.this.f278507b = false;
            synchronized (a.this.f278509d) {
                a.this.f278509d.notifyAll();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QWalletIPCConnector", 2, "connectFailed:" + a.this.f278508c);
            }
        }

        @Override // eipc.EIPClientConnectListener
        public void connectSuccess(EIPCConnection eIPCConnection) {
            long currentTimeMillis = System.currentTimeMillis();
            if (eIPCConnection != null) {
                a.this.f278508c = eIPCConnection.procName;
            }
            a.this.f278506a = true;
            a.this.f278507b = false;
            synchronized (a.this.f278509d) {
                a.this.f278509d.notifyAll();
            }
            if (QLog.isColorLevel()) {
                QLog.d("QWalletIPCConnector", 2, "connectSuccess:" + a.this.f278508c + "|" + (currentTimeMillis - this.f278511d));
            }
        }
    }

    a() {
    }

    private void g() {
        this.f278507b = true;
        if (QLog.isColorLevel()) {
            QLog.d("QWalletIPCConnector", 2, "begin connect:");
        }
        QIPCClientHelper.getInstance().getClient().addListener(new C8471a());
        QIPCClientHelper.getInstance().getClient().connect(new b(System.currentTimeMillis()));
    }

    public static a h() {
        if (f278505e == null) {
            synchronized (a.class) {
                if (f278505e == null) {
                    f278505e = new a();
                }
            }
        }
        return f278505e;
    }

    public void f() {
        if (!this.f278506a && !this.f278507b) {
            g();
        }
        if (!this.f278506a) {
            synchronized (this.f278509d) {
                if (!this.f278506a) {
                    try {
                        this.f278509d.wait(500L);
                    } catch (InterruptedException e16) {
                        QLog.e("QWalletIPCConnector", 1, "error msg in qqpay-impl module: ", e16);
                    }
                }
            }
        }
    }
}
