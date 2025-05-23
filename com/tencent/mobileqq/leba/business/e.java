package com.tencent.mobileqq.leba.business;

import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLebaImpl/Inject_LebaBusiness.yml", version = 1)
    public static ArrayList<Class<? extends c>> f240103b;

    /* renamed from: a, reason: collision with root package name */
    public List<c> f240104a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20518);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        ArrayList<Class<? extends c>> arrayList = new ArrayList<>();
        f240103b = arrayList;
        arrayList.add(com.tencent.mobileqq.leba.business.itemfilter.a.class);
        f240103b.add(com.tencent.mobileqq.leba.business.itemfilter.b.class);
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f240104a = new ArrayList();
        }
    }

    public boolean a(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) nVar)).booleanValue();
        }
        Iterator<c> it = this.f240104a.iterator();
        while (it.hasNext()) {
            if (it.next().a(nVar)) {
                return true;
            }
        }
        return false;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
