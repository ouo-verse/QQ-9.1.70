package com.tencent.mobileqq.qqsec.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.security.SecControllerInjectImpl;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/QQSafeBlockApi/Inject_SecurityBlockConfig.yml", version = 1)
    public static ArrayList<Class<? extends c>> f274417a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27570);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends c>> arrayList = new ArrayList<>();
        f274417a = arrayList;
        arrayList.add(SecControllerInjectImpl.class);
    }
}
