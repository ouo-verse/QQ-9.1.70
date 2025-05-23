package com.tencent.mobileqq.qqfloatingwindow.impl.inject;

import com.tencent.mobileqq.inject.b;
import com.tencent.mobileqq.injector.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/qqfloatingwindow-impl/Inject_AppSetting.yml", version = 1)
    private static b f264358a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f264359b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34873);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f264359b = arrayList;
        arrayList.add(d.class);
    }

    private static void a() {
        if (f264358a == null) {
            b();
        }
    }

    @QAutoInitMethod
    static void b() {
        f264358a = (b) com.tencent.mobileqq.qroute.utils.b.a(f264359b);
    }

    public static boolean c() {
        a();
        b bVar = f264358a;
        if (bVar == null) {
            QLog.w("FloatingSetting", 1, "inject failed, call isDebugVersion");
            return false;
        }
        return bVar.isDebugVersion();
    }
}
