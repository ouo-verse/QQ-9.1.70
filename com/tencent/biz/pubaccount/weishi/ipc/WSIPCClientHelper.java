package com.tencent.biz.pubaccount.weishi.ipc;

import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCConnection;
import eipc.EIPClientConnectListener;

/* loaded from: classes32.dex */
public class WSIPCClientHelper {

    /* renamed from: b, reason: collision with root package name */
    private static WSIPCClientHelper f80895b;

    /* renamed from: a, reason: collision with root package name */
    private boolean f80896a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements EIPClientConnectListener {
        a() {
        }

        @Override // eipc.EIPClientConnectListener
        public void connectFailed() {
            WSIPCClientHelper.this.f80896a = false;
            x.j("WSIPCClientHelper", "connectFailed");
        }

        @Override // eipc.EIPClientConnectListener
        public void connectSuccess(EIPCConnection eIPCConnection) {
            WSIPCClientHelper.this.f80896a = true;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("connectSuccess ");
            sb5.append(eIPCConnection == null ? null : eIPCConnection.procName);
            x.j("WSIPCClientHelper", sb5.toString());
        }
    }

    WSIPCClientHelper() {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f80896a) {
            x.j("WSIPCClientHelper", "has connected");
        } else {
            QIPCClientHelper.getInstance().getClient().connect(new a());
        }
    }

    public static WSIPCClientHelper e() {
        if (f80895b == null) {
            synchronized (WSIPCClientHelper.class) {
                if (f80895b == null) {
                    f80895b = new WSIPCClientHelper();
                }
            }
        }
        return f80895b;
    }

    public void c(final String str) {
        if (str == null) {
            return;
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.ipc.WSIPCClientHelper.2
            @Override // java.lang.Runnable
            public void run() {
                WSIPCClientHelper.this.d();
                QIPCClientHelper.getInstance().callServer(IWSManager.IPC_MODULE_NAME, str, null, null);
            }
        });
    }
}
