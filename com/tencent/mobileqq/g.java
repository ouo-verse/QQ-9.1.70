package com.tencent.mobileqq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f211804a;

    /* renamed from: b, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Lottie/Inject_IDebugVersion.yml", version = 1)
    private static q f211805b;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f211806c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41510);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f211806c = arrayList;
        arrayList.add(u13.a.class);
        f211804a = false;
        a();
    }

    @QAutoInitMethod
    public static void a() {
        q qVar = (q) com.tencent.mobileqq.qroute.utils.b.a(f211806c);
        f211805b = qVar;
        if (qVar == null) {
            return;
        }
        f211804a = qVar.isDebugVersion();
    }
}
