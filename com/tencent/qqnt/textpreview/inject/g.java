package com.tencent.qqnt.textpreview.inject;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/TextPreview/Inject_TextPreviewInject.yml", version = 4)
    private static final ArrayList<Class<? extends d>> f362316a;

    /* renamed from: b, reason: collision with root package name */
    private static d f362317b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30984);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends d>> arrayList = new ArrayList<>();
        f362316a = arrayList;
        arrayList.add(com.tencent.mobileqq.textpreview.b.class);
        try {
            f362317b = arrayList.get(0).newInstance();
        } catch (IllegalAccessException | InstantiationException unused) {
        }
    }

    public static d a() {
        return f362317b;
    }
}
