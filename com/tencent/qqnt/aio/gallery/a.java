package com.tencent.qqnt.aio.gallery;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Gallery/Inject_NTGalleryAppSetting.yml", version = 1)
    private static com.tencent.mobileqq.inject.b f349992a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f349993b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27998);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f349993b = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
    }

    private static void a() {
        if (f349992a == null) {
            c();
        }
    }

    public static String b() {
        a();
        com.tencent.mobileqq.inject.b bVar = f349992a;
        if (bVar == null) {
            QLog.w("NTGalleryAppSetting", 1, "inject failed, call isGooglePlayVersion");
            return "";
        }
        return bVar.getReportVersionName();
    }

    @QAutoInitMethod
    static void c() {
        f349992a = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(f349993b);
    }
}
