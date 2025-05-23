package com.tencent.qqnt.aio.adapter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qqnt.aio.adapter.richmedia.RichMediaBrowserFallbackImpl;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Inject_Adapter_API.yml", version = 2)
    static HashMap<String, QRouteApi> f348718a;

    /* renamed from: b, reason: collision with root package name */
    private static HashMap f348719b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37335);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap hashMap = new HashMap();
        f348719b = hashMap;
        hashMap.put("com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi", RichMediaBrowserFallbackImpl.class);
        f348718a = new HashMap<>();
        a();
    }

    @QAutoInitMethod
    static void a() {
        com.tencent.mobileqq.qroute.utils.b.b(f348719b, f348718a);
    }
}
