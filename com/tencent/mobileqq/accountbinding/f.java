package com.tencent.mobileqq.accountbinding;

import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Bundle f174634a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements WebViewBridge.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f174635a;

        a(b bVar) {
            this.f174635a = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void a(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void b(int i3, int i16, int i17, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bundle);
                return;
            }
            QLog.d("SecurityVerifyComponent", 1, "onActivityResult requestCode:" + i16 + " resultCode:" + i17);
            WebViewBridge.f().n(i3);
            if (i17 != -1) {
                b bVar = this.f174635a;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            b bVar2 = this.f174635a;
            if (bVar2 != null) {
                bVar2.b(bundle);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface b {
        void a();

        void b(Bundle bundle);
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f174634a = new Bundle();
        }
    }

    private Bundle a() {
        return this.f174634a;
    }

    public void b(String str, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) bVar);
            return;
        }
        Bundle a16 = a();
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        WebViewBridge.f().k(qBaseActivity, new a(bVar)).a(qBaseActivity, str, a16, 25465);
    }
}
