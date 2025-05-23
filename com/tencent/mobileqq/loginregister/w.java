package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class w implements s, t {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLoginImpl/Inject_login_register_config.yml", version = 1)
    private static ArrayList<Class<? extends s>> f243055c;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLoginImpl/Inject_login_register_config.yml", version = 1)
    private static ArrayList<Class<? extends t>> f243056d;

    /* renamed from: a, reason: collision with root package name */
    private List<s> f243057a;

    /* renamed from: b, reason: collision with root package name */
    private List<t> f243058b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        ArrayList<Class<? extends s>> arrayList = new ArrayList<>();
        f243055c = arrayList;
        arrayList.add(am.class);
        f243055c.add(c.class);
        f243055c.add(an.class);
        f243055c.add(aj.class);
        f243055c.add(CheckAuthLoginAction.class);
        f243055c.add(ar.class);
        f243055c.add(af.class);
        f243055c.add(d.class);
        f243055c.add(ap.class);
        f243055c.add(ae.class);
        ArrayList<Class<? extends t>> arrayList2 = new ArrayList<>();
        f243056d = arrayList2;
        arrayList2.add(b.class);
        f243056d.add(ah.class);
        f243056d.add(JumpLoginResult.class);
        f243056d.add(InitLoginResult.class);
        f243056d.add(al.class);
        f243056d.add(ag.class);
        f243056d.add(i.class);
        f243056d.add(SwitchSimpleModeResult.class);
        f243056d.add(com.tencent.mobileqq.subaccount.m.class);
    }

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243057a = new ArrayList();
        this.f243058b = new ArrayList();
        QLog.d("LoginProxy", 1, "sLoginActionClasses size : ", Integer.valueOf(f243055c.size()));
        Iterator<Class<? extends s>> it = f243055c.iterator();
        while (it.hasNext()) {
            try {
                this.f243057a.add(it.next().newInstance());
            } catch (Exception e16) {
                QLog.e("LoginProxy", 1, "ILoginAction newInstance", e16);
            }
        }
        QLog.d("LoginProxy", 1, "sLoginResultClasses size : ", Integer.valueOf(f243056d.size()));
        Iterator<Class<? extends t>> it5 = f243056d.iterator();
        while (it5.hasNext()) {
            try {
                this.f243058b.add(it5.next().newInstance());
            } catch (Exception e17) {
                QLog.e("LoginProxy", 1, "ILoginResult newInstance", e17);
            }
        }
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public boolean a(AppRuntime appRuntime, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, appRuntime, activity, str)).booleanValue();
        }
        Iterator<t> it = this.f243058b.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            z16 &= it.next().a(appRuntime, activity, str);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.loginregister.s
    public boolean b(AppRuntime appRuntime, Class<?> cls, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, appRuntime, cls, Long.valueOf(j3))).booleanValue();
        }
        Iterator<s> it = this.f243057a.iterator();
        while (it.hasNext()) {
            z16 |= it.next().b(appRuntime, cls, j3);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public boolean c(Activity activity, int i3, String str, Bundle bundle, x xVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, this, activity, Integer.valueOf(i3), str, bundle, xVar)).booleanValue();
        }
        Iterator<t> it = this.f243058b.iterator();
        while (it.hasNext()) {
            if (it.next().c(activity, i3, str, bundle, xVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public boolean d(Activity activity, String str, x xVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, activity, str, xVar)).booleanValue();
        }
        Iterator<t> it = this.f243058b.iterator();
        while (it.hasNext()) {
            if (it.next().d(activity, str, xVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public void e(Activity activity, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity, (Object) appRuntime);
            return;
        }
        Iterator<t> it = this.f243058b.iterator();
        while (it.hasNext()) {
            it.next().e(activity, appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public boolean f(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity, (Object) str)).booleanValue();
        }
        Iterator<t> it = this.f243058b.iterator();
        while (it.hasNext()) {
            if (it.next().f(activity, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.s
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<s> it = this.f243057a.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    @Override // com.tencent.mobileqq.loginregister.s
    public void h(QBaseActivity qBaseActivity, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qBaseActivity, str, Boolean.valueOf(z16));
            return;
        }
        Iterator<s> it = this.f243057a.iterator();
        while (it.hasNext()) {
            it.next().h(qBaseActivity, str, z16);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.s
    public void i(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Iterator<s> it = this.f243057a.iterator();
        while (it.hasNext()) {
            it.next().i(context);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.s
    public void j(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        Iterator<s> it = this.f243057a.iterator();
        while (it.hasNext()) {
            it.next().j(activity, bundle);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public void k(Activity activity, AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, activity, appRuntime, str);
            return;
        }
        Iterator<t> it = this.f243058b.iterator();
        while (it.hasNext()) {
            it.next().k(activity, appRuntime, str);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.s
    public void l(QBaseActivity qBaseActivity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) qBaseActivity, (Object) str);
            return;
        }
        Iterator<s> it = this.f243057a.iterator();
        while (it.hasNext()) {
            it.next().l(qBaseActivity, str);
        }
    }
}
