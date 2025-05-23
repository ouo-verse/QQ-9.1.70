package com.tencent.mobileqq.mediafocus;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import eipc.EIPClientConnectListener;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f245793f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f245794d;

    /* renamed from: e, reason: collision with root package name */
    private String f245795e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mediafocus.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class C8022a implements EIPClientConnectListener {
        static IPatchRedirector $redirector_;

        C8022a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // eipc.EIPClientConnectListener
        public void connectFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                a.this.f245794d = false;
                if (QLog.isColorLevel()) {
                    QLog.d("MediaFocusIpcClient", 2, "connectFailed");
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // eipc.EIPClientConnectListener
        public void connectSuccess(EIPCConnection eIPCConnection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCConnection);
                return;
            }
            if (eIPCConnection != null) {
                a.this.f245795e = eIPCConnection.procName;
            }
            a.this.f245794d = true;
            if (QLog.isColorLevel()) {
                QLog.d("MediaFocusIpcClient", 2, "connectSuccess");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements EIPCOnGetConnectionListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(EIPCConnection eIPCConnection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) eIPCConnection);
                return;
            }
            if (eIPCConnection != null) {
                a.this.f245795e = eIPCConnection.procName;
            }
            a.this.f245794d = true;
            if (QLog.isColorLevel()) {
                QLog.d("MediaFocusIpcClient", 2, "onConnectBind");
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(EIPCConnection eIPCConnection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCConnection);
                return;
            }
            if (eIPCConnection != null) {
                a.this.f245795e = eIPCConnection.procName;
            }
            a.this.f245794d = false;
            if (QLog.isColorLevel()) {
                QLog.d("MediaFocusIpcClient", 2, "onConnectUnbind");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static a f245798a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36622);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f245798a = new a();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36624);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f245793f = false;
        }
    }

    a() {
        super("MediaFocusModuleClient");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f245794d = false;
            e();
        }
    }

    public static a d() {
        return c.f245798a;
    }

    private void e() {
        QIPCClientHelper.getInstance().getClient().connect(new C8022a());
        QIPCClientHelper.getInstance().getClient().addListener(new b());
    }

    public static void registerModule() {
        a d16 = d();
        if (!f245793f) {
            QIPCClientHelper.getInstance().register(d16);
            f245793f = true;
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("MediaFocusIpcClient", 2, "action = " + str + ", params = " + bundle);
        }
        Bundle bundle2 = new Bundle();
        if ("actionCheckItemExist".equals(str)) {
            bundle.setClassLoader(getClass().getClassLoader());
            MediaFocusStackItem mediaFocusStackItem = (MediaFocusStackItem) bundle.getParcelable("focusItem");
            if (mediaFocusStackItem != null) {
                z16 = com.tencent.mobileqq.mediafocus.b.i().j(mediaFocusStackItem.a(), mediaFocusStackItem.c());
            }
            bundle2.putBoolean("isItemExist", z16);
            bundle2.putBoolean("isConnected", this.f245794d);
            bundle2.putParcelable("focusItem", mediaFocusStackItem);
        }
        return EIPCResult.createSuccessResult(bundle2);
    }
}
