package com.tencent.mobileqq.beacon;

import com.tencent.mobileqq.inject.o;
import com.tencent.mobileqq.injector.z;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.qroute.utils.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Coms/BaseActivity/Inject_QQBeaconReport.yml", version = 1)
    private static o f200336a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f200337b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44314);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f200337b = arrayList;
        arrayList.add(z.class);
    }

    private static void a() {
        if (f200336a == null) {
            b();
        }
    }

    @QAutoInitMethod
    static void b() {
        f200336a = (o) b.a(f200337b);
    }

    public static void c(String str, String str2, Map<String, String> map) {
        a();
        o oVar = f200336a;
        if (oVar == null) {
            QLog.w("QQBeaconReportUtil", 1, "inject failed, call is report");
        } else {
            oVar.a(str, str2, map);
        }
    }
}
