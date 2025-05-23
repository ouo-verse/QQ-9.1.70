package com.tencent.mobileqq.register;

import android.os.Bundle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.loginregister.callback.RegisterResult;
import com.tencent.mobileqq.loginregister.servlet.IRegisterServletService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.cb;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class q {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile q f280547d;

    /* renamed from: a, reason: collision with root package name */
    private int f280548a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.register.bean.b f280549b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.mobileqq.loginregister.callback.b f280550c;

    q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            e();
        }
    }

    public static q c() {
        if (f280547d == null) {
            synchronized (q.class) {
                if (f280547d == null) {
                    f280547d = new q();
                }
            }
        }
        return f280547d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(com.tencent.mobileqq.loginregister.callback.b bVar, RegisterResult registerResult) {
        QLog.d("RegisterManager", 1, "RegisterResult :" + registerResult.getResult());
        if (bVar != null) {
            bVar.a(registerResult);
        }
        cb.f("0X800C3BB", "0X800C3AA", registerResult.getResult(), "");
        h();
    }

    private Bundle g(Bundle bundle) {
        if (this.f280549b != null) {
            QLog.d("RegisterManager", 1, "onSendRegisterBySetPass: sendRegisterBySetPass has face result.");
            if (bundle == null) {
                bundle = new Bundle();
            }
            HashMap<String, Object> hashMap = (HashMap) bundle.getParcelable("mapSt");
            if (hashMap != null) {
                hashMap.putAll(this.f280549b.a());
            } else {
                hashMap = this.f280549b.a();
            }
            bundle.putSerializable("mapSt", hashMap);
        }
        return bundle;
    }

    public com.tencent.mobileqq.register.bean.b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.register.bean.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f280549b;
    }

    public com.tencent.mobileqq.loginregister.callback.b d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.loginregister.callback.b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f280550c;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f280548a = 1;
            this.f280549b = null;
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f280549b = null;
        this.f280548a = 7;
        this.f280550c = null;
    }

    public void i(AppRuntime appRuntime, String str, String str2, String str3, String str4, boolean z16, Bundle bundle, String str5, com.tencent.mobileqq.loginregister.servlet.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, str2, str3, str4, Boolean.valueOf(z16), bundle, str5, dVar);
        } else {
            QLog.d("RegisterManager", 1, "sendRegisterBySetPass");
            ((IRegisterServletService) appRuntime.getRuntimeService(IRegisterServletService.class, "all")).sendRegisterBySetPass(str, str2, str3, str4, z16, AppSetting.f99551k, g(bundle), str5, dVar);
        }
    }

    public void j(com.tencent.mobileqq.register.bean.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.f280549b = bVar;
        }
    }

    public void k(final com.tencent.mobileqq.loginregister.callback.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
        } else {
            this.f280550c = new com.tencent.mobileqq.loginregister.callback.b() { // from class: com.tencent.mobileqq.register.p
                @Override // com.tencent.mobileqq.loginregister.callback.b
                public final void a(RegisterResult registerResult) {
                    q.this.f(bVar, registerResult);
                }
            };
        }
    }

    public void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        this.f280548a = i3;
        if (i3 == 1) {
            e();
        }
    }
}
