package com.tencent.mobileqq.leba.business;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQLebaImpl/Inject_LebaBusiness.yml", version = 1)
    public static ArrayList<Class<Object>> f240111b;

    /* renamed from: a, reason: collision with root package name */
    public List<Object> f240112a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20544);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        ArrayList<Class<Object>> arrayList = new ArrayList<>();
        f240111b = arrayList;
        arrayList.add(com.tencent.mobileqq.leba.business.impl.a.class);
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f240112a = new ArrayList();
        }
    }
}
