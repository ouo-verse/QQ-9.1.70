package com.tencent.mobileqq.sharehelper;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "Business/qqactionsheet/src/main/resources/Inject_actionsheet_share_config.yml", version = 1)
    public static HashMap<String, Class<? extends c>> f287106a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "Business/qqactionsheet/src/main/resources/Inject_actionsheet_share_config.yml", version = 1)
    public static ArrayList<Class<? extends b>> f287107b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27264);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f287106a = new HashMap<>();
        ArrayList<Class<? extends b>> arrayList = new ArrayList<>();
        f287107b = arrayList;
        arrayList.add(f.class);
    }
}
