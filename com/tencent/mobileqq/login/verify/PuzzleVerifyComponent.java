package com.tencent.mobileqq.login.verify;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.loginregister.utils.WebViewBridge;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.as;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes15.dex */
public class PuzzleVerifyComponent {
    static IPatchRedirector $redirector_;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes15.dex */
    public @interface Scene {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a implements WebViewBridge.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f242677a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f242678b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f242679c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f242680d;

        a(long j3, int i3, b bVar, AtomicBoolean atomicBoolean) {
            this.f242677a = j3;
            this.f242678b = i3;
            this.f242679c = bVar;
            this.f242680d = atomicBoolean;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PuzzleVerifyComponent.this, Long.valueOf(j3), Integer.valueOf(i3), bVar, atomicBoolean);
            }
        }

        private boolean c() {
            boolean andSet = this.f242680d.getAndSet(false);
            if (!andSet) {
                QLog.w("PuzzleVerifyComponent", 1, "duplicate callback");
            }
            return !andSet;
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void a(int i3, String str, Bundle bundle) {
            Bundle bundle2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle);
                return;
            }
            if (bundle == null) {
                bundle2 = new Bundle();
            } else {
                bundle2 = bundle;
            }
            boolean z16 = bundle2.getBoolean("result");
            String string = bundle2.getString("ticket");
            String string2 = bundle2.getString(MQPSecJsPlugin.KEY_RANDSTR);
            String string3 = bundle2.getString("appid");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("puzzle verify callback result:");
            sb5.append(z16);
            sb5.append(" ticketValid:");
            sb5.append(!TextUtils.isEmpty(string));
            QLog.i("PuzzleVerifyComponent", 1, sb5.toString());
            WebViewBridge.f().n(i3);
            if (!c()) {
                PuzzleVerifyComponent.this.c("0X800C27E", this.f242678b, 0, String.valueOf(System.currentTimeMillis() - this.f242677a), "", "", "");
                if (3 == this.f242678b) {
                    ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport(null, com.tencent.mobileqq.dt.api.c.f203655r, "");
                }
                b bVar = this.f242679c;
                if (bVar != null) {
                    bVar.b(z16, string, string2, string3);
                }
            }
        }

        @Override // com.tencent.mobileqq.loginregister.utils.WebViewBridge.c
        public void b(int i3, int i16, int i17, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), bundle);
                return;
            }
            QLog.i("PuzzleVerifyComponent", 1, "onActivityResult requestCode:" + i16 + " resultCode:" + i17);
            if (i17 != -1) {
                QLog.i("PuzzleVerifyComponent", 1, "puzzle verify cancel");
                WebViewBridge.f().n(i3);
                if (!c()) {
                    PuzzleVerifyComponent.this.c("0X800C27E", this.f242678b, 2, String.valueOf(System.currentTimeMillis() - this.f242677a), "", "", "");
                    b bVar = this.f242679c;
                    if (bVar != null) {
                        bVar.a();
                    }
                }
            }
        }
    }

    /* loaded from: classes15.dex */
    public interface b {
        void a();

        void b(boolean z16, String str, String str2, String str3);
    }

    public PuzzleVerifyComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putLong("business", 2097152L);
        bundle.putBoolean("hide_operation_bar", true);
        bundle.putBoolean("hide_more_button", true);
        bundle.putBoolean("isShowAd", false);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, int i3, int i16, String str2, String str3, String str4, String str5) {
        as.b("puzzle_verify_component", str, "", i3, i16, false, str2, str3, str4, str5);
    }

    public void d(int i3, String str, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bVar);
            return;
        }
        QLog.i("PuzzleVerifyComponent", 1, "startPuzzleVerify scene = " + i3);
        WebViewBridge.f().l(new a(System.currentTimeMillis(), i3, bVar, new AtomicBoolean(true))).a(QBaseActivity.sTopActivity, z.h(str), b(), 34952);
        ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginPuzzleVerify();
        c("0X800C27D", i3, 0, "", "", "", "");
        if (3 == i3) {
            ((IQSecChannel) QRoute.api(IQSecChannel.class)).regReport(null, com.tencent.mobileqq.dt.api.c.f203654q, "");
        }
    }
}
