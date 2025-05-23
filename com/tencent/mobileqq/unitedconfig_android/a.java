package com.tencent.mobileqq.unitedconfig_android;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Foundation/UnitedConfig-sdk/Inject_AppSetting.yml", version = 1)
    private static com.tencent.mobileqq.inject.b f306020a;

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f306021b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35370);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f306021b = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
    }

    private static void a() {
        if (f306020a == null) {
            e();
        }
    }

    public static int b() {
        a();
        com.tencent.mobileqq.inject.b bVar = f306020a;
        if (bVar == null) {
            QLog.w("UnitedConfig_AppSetting", 1, "sAppSetting is null");
            return 0;
        }
        return bVar.getAppId();
    }

    public static String c() {
        a();
        com.tencent.mobileqq.inject.b bVar = f306020a;
        if (bVar == null) {
            QLog.w("UnitedConfig_AppSetting", 1, "sAppSetting is null");
            return "";
        }
        return bVar.f();
    }

    public static String d() {
        a();
        com.tencent.mobileqq.inject.b bVar = f306020a;
        if (bVar == null) {
            QLog.w("UnitedConfig_AppSetting", 1, "sAppSetting is null");
            return "";
        }
        return bVar.getSubVersion();
    }

    @QAutoInitMethod
    static void e() {
        f306020a = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(f306021b);
    }

    public static boolean f() {
        a();
        com.tencent.mobileqq.inject.b bVar = f306020a;
        if (bVar == null) {
            QLog.w("UnitedConfig_AppSetting", 1, "sAppSetting is null");
            return false;
        }
        return bVar.isGrayVersion();
    }

    public static boolean g() {
        a();
        com.tencent.mobileqq.inject.b bVar = f306020a;
        if (bVar == null) {
            QLog.w("UnitedConfig_AppSetting", 1, "sAppSetting is null");
            return false;
        }
        return bVar.isPublicVersion();
    }
}
