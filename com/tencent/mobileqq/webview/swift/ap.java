package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ap {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Webview/Inject_webview_wrapper.yml", version = 2)
    public static ArrayList<Class<? extends j>> f314205a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49168);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends j>> arrayList = new ArrayList<>();
        f314205a = arrayList;
        arrayList.add(com.tencent.mobileqq.webview.o.class);
    }
}
