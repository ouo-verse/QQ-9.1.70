package com.tencent.mobileqq.download.unite.util;

import android.os.Bundle;
import com.tencent.mobileqq.download.unite.util.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f203594d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.download.unite.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    class C7485a implements b.InterfaceC7486b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f203595d;

        C7485a(int i3) {
            this.f203595d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.download.unite.util.b.InterfaceC7486b
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("result", i3);
            a.this.callbackResult(this.f203595d, EIPCResult.createResult(0, bundle));
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class b implements b.InterfaceC7486b, EIPCResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private b.InterfaceC7486b f203597d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(b.InterfaceC7486b interfaceC7486b) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) interfaceC7486b);
            } else {
                this.f203597d = interfaceC7486b;
            }
        }

        @Override // com.tencent.mobileqq.download.unite.util.b.InterfaceC7486b
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[2];
                boolean z16 = false;
                objArr[0] = "listener is null: ";
                if (this.f203597d == null) {
                    z16 = true;
                }
                objArr[1] = Boolean.valueOf(z16);
                QLog.d("[UniteDownload] UniteDownloadIPCModule", 1, objArr);
            }
            b.InterfaceC7486b interfaceC7486b = this.f203597d;
            if (interfaceC7486b != null) {
                interfaceC7486b.a(i3);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle bundle;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[2];
                objArr[0] = "IPC onCallBack: ";
                if (eIPCResult != null) {
                    i3 = eIPCResult.code;
                } else {
                    i3 = -1;
                }
                objArr[1] = Integer.valueOf(i3);
                QLog.d("[UniteDownload] UniteDownloadIPCModule", 1, objArr);
            }
            if (eIPCResult != null && eIPCResult.code == 0) {
                bundle = eIPCResult.data;
            } else {
                bundle = null;
            }
            if (bundle != null) {
                i16 = bundle.getInt("result");
            }
            a(i16);
        }
    }

    public a(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }

    public static a b() {
        if (f203594d == null) {
            synchronized (a.class) {
                if (f203594d == null) {
                    f203594d = new a("UniteDownloadIPCModule");
                }
            }
        }
        return f203594d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("[UniteDownload] UniteDownloadIPCModule", 1, "downloadIPC onCall: ", str, " callBackid: ", Integer.valueOf(i3));
        }
        if ("showDialogAction".equals(str)) {
            bundle.setClassLoader(DownloadInfo.class.getClassLoader());
            com.tencent.mobileqq.download.unite.util.b.e((DownloadInfo) bundle.getParcelable("downloadInfoKey"), new C7485a(i3));
        }
        return EIPCResult.createResult(-100, null);
    }
}
