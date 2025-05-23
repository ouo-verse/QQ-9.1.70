package com.tencent.aelight.camera.aioeditor.editipc;

import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import eipc.EIPClientConnectListener;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends QIPCModule {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f67433f = false;

    /* renamed from: h, reason: collision with root package name */
    private static b f67434h;

    /* renamed from: d, reason: collision with root package name */
    private boolean f67435d;

    /* renamed from: e, reason: collision with root package name */
    private String f67436e;

    b() {
        super("PeakIpcModuleClient");
        this.f67435d = false;
        f();
    }

    public static synchronized b e() {
        b bVar;
        synchronized (b.class) {
            if (f67434h == null) {
                synchronized (b.class) {
                    if (f67434h == null) {
                        f67434h = new b();
                    }
                }
            }
            bVar = f67434h;
        }
        return bVar;
    }

    private void f() {
        QIPCClientHelper.getInstance().getClient().connect(new a());
        QIPCClientHelper.getInstance().getClient().addListener(new C0584b());
    }

    public static void registerModule() {
        b e16 = e();
        if (f67433f) {
            return;
        }
        QIPCClientHelper.getInstance().register(e16);
        f67433f = true;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        Bundle bundle2 = new Bundle();
        if ("action_update_status".equals(str) && bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            int i16 = bundle.getInt("key_status");
            int i17 = bundle.getInt("key_progress");
            String string = bundle.getString("uin");
            int i18 = bundle.getInt("uintype");
            bundle.getString("key_file_md5");
            SendPanelManager.k().C(string, i18, i16, i17, bundle.getLong("key_uinsequence"));
            bundle2.putBoolean("key_result", false);
        }
        return EIPCResult.createSuccessResult(bundle2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements EIPClientConnectListener {
        a() {
        }

        @Override // eipc.EIPClientConnectListener
        public void connectFailed() {
            b.this.f67435d = false;
            if (QLog.isColorLevel()) {
                QLog.d("PeakIpcModuleClient", 2, "connectFailed!");
            }
        }

        @Override // eipc.EIPClientConnectListener
        public void connectSuccess(EIPCConnection eIPCConnection) {
            if (eIPCConnection != null) {
                b.this.f67436e = eIPCConnection.procName;
            }
            b.this.f67435d = true;
            if (QLog.isColorLevel()) {
                QLog.d("PeakIpcModuleClient", 2, "connectSuccess:" + b.this.f67436e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.editipc.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0584b implements EIPCOnGetConnectionListener {
        C0584b() {
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(EIPCConnection eIPCConnection) {
            if (eIPCConnection != null) {
                b.this.f67436e = eIPCConnection.procName;
            }
            b.this.f67435d = true;
            if (QLog.isColorLevel()) {
                QLog.d("PeakIpcModuleClient", 2, "onConnectBind!");
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(EIPCConnection eIPCConnection) {
            if (eIPCConnection != null) {
                b.this.f67436e = eIPCConnection.procName;
            }
            b.this.f67435d = false;
            if (QLog.isColorLevel()) {
                QLog.d("PeakIpcModuleClient", 2, "onConnectUnbind:" + b.this.f67436e);
            }
        }
    }
}
