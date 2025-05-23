package com.tencent.mobileqq.leba.business;

import android.app.Activity;
import com.tencent.mobileqq.leba.qcircle.more.LebaMoreQCircleBiz;
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
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLebaImpl/Inject_LebaBusiness.yml", version = 1)
    public static ArrayList<Class<? extends b>> f240107b;

    /* renamed from: a, reason: collision with root package name */
    public List<b> f240108a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20524);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        ArrayList<Class<? extends b>> arrayList = new ArrayList<>();
        f240107b = arrayList;
        arrayList.add(com.tencent.mobileqq.leba.business.more.a.class);
        f240107b.add(LebaMoreQCircleBiz.class);
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f240108a = new ArrayList();
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f240108a.isEmpty()) {
            Iterator<Class<? extends b>> it = f240107b.iterator();
            while (it.hasNext()) {
                try {
                    this.f240108a.add(it.next().newInstance());
                } catch (Exception e16) {
                    QLog.e("LebaMoreVipBizProxy", 1, e16, new Object[0]);
                }
            }
            QLog.i("LebaMoreVipBizProxy", 1, "initBizList size = " + this.f240108a.size());
        }
    }

    public void b(com.tencent.mobileqq.leba.entity.i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iVar);
            return;
        }
        Iterator<b> it = this.f240108a.iterator();
        while (it.hasNext() && !it.next().b(iVar)) {
        }
    }

    public void c(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        Iterator<b> it = this.f240108a.iterator();
        while (it.hasNext()) {
            it.next().c(activity);
        }
    }

    public void d(AppRuntime appRuntime, boolean z16, com.tencent.mobileqq.leba.entity.i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, appRuntime, Boolean.valueOf(z16), iVar);
            return;
        }
        Iterator<b> it = this.f240108a.iterator();
        while (it.hasNext()) {
            it.next().d(appRuntime, z16, iVar);
        }
    }
}
