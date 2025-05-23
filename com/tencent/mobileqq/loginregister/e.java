package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e implements p {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLoginImpl/Inject_login_register_config.yml", version = 1)
    private static ArrayList<Class<? extends p>> f242841b;

    /* renamed from: a, reason: collision with root package name */
    protected final List<p> f242842a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41289);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        ArrayList<Class<? extends p>> arrayList = new ArrayList<>();
        f242841b = arrayList;
        arrayList.add(k.class);
        f242841b.add(o.class);
        f242841b.add(com.tencent.mobileqq.impl.a.class);
        f242841b.add(j.class);
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f242842a = new ArrayList();
        QLog.d("AuthDevVerifyProxy", 1, "sAuthApiList size : ", Integer.valueOf(f242841b.size()));
        Iterator<Class<? extends p>> it = f242841b.iterator();
        while (it.hasNext()) {
            try {
                this.f242842a.add(it.next().newInstance());
            } catch (Exception e16) {
                QLog.e("AuthDevVerifyProxy", 1, "IAuthDevVerifyApi newInstance", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void a(QBaseActivity qBaseActivity, int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, qBaseActivity, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        Iterator<p> it = this.f242842a.iterator();
        while (it.hasNext()) {
            it.next().a(qBaseActivity, i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean b(QBaseActivity qBaseActivity, q qVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, qBaseActivity, qVar, str)).booleanValue();
        }
        Iterator<p> it = this.f242842a.iterator();
        while (it.hasNext()) {
            if (it.next().b(qBaseActivity, qVar, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean c(QBaseActivity qBaseActivity, q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) qVar)).booleanValue();
        }
        Iterator<p> it = this.f242842a.iterator();
        while (it.hasNext()) {
            if (it.next().c(qBaseActivity, qVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void d(QBaseActivity qBaseActivity, q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) qVar);
            return;
        }
        Iterator<p> it = this.f242842a.iterator();
        while (it.hasNext()) {
            it.next().d(qBaseActivity, qVar);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public boolean e(QBaseActivity qBaseActivity, q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity, (Object) qVar)).booleanValue();
        }
        Iterator<p> it = this.f242842a.iterator();
        while (it.hasNext()) {
            if (it.next().e(qBaseActivity, qVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void onActivityDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Iterator<p> it = this.f242842a.iterator();
        while (it.hasNext()) {
            it.next().onActivityDestroy();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.p
    public void onActivityResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Iterator<p> it = this.f242842a.iterator();
        while (it.hasNext()) {
            it.next().onActivityResume();
        }
    }
}
