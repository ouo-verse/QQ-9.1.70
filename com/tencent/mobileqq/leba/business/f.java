package com.tencent.mobileqq.leba.business;

import android.view.View;
import com.tencent.mobileqq.leba.business.mainbiz.LebaSearchPart;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLebaImpl/Inject_LebaBusiness.yml", version = 1)
    public static ArrayList<Class<? extends a>> f240105b;

    /* renamed from: a, reason: collision with root package name */
    public List<a> f240106a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20520);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
            return;
        }
        ArrayList<Class<? extends a>> arrayList = new ArrayList<>();
        f240105b = arrayList;
        arrayList.add(LebaSearchPart.class);
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f240106a = new ArrayList();
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f240106a.isEmpty()) {
            Iterator<Class<? extends a>> it = f240105b.iterator();
            while (it.hasNext()) {
                try {
                    this.f240106a.add(it.next().newInstance());
                } catch (Exception e16) {
                    QLog.e("LebaMainBizProxy", 1, e16, new Object[0]);
                }
            }
            QLog.i("LebaMainBizProxy", 1, "initBizList size = " + this.f240106a.size());
        }
    }

    public void b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
            return;
        }
        Iterator<a> it = this.f240106a.iterator();
        while (it.hasNext()) {
            it.next().a(view);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        Iterator<a> it = this.f240106a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void d(y62.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        a();
        for (a aVar2 : this.f240106a) {
            aVar2.j(aVar);
            aVar2.c();
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        Iterator<a> it = this.f240106a.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Iterator<a> it = this.f240106a.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<a> it = this.f240106a.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Iterator<a> it = this.f240106a.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        Iterator<a> it = this.f240106a.iterator();
        while (it.hasNext()) {
            it.next().h(z16);
        }
    }
}
