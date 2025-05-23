package com.tencent.common.config.provider;

import NS_UNDEAL_COUNT.entrance_cfg;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQZConfigProviderUtilProxy;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f99591a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23506);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f99591a = false;
        }
    }

    public static void a() {
        ((IQZConfigProviderUtilProxy) QRoute.api(IQZConfigProviderUtilProxy.class)).cleanAll();
    }

    public static String b() {
        return ((IQZConfigProviderUtilProxy) QRoute.api(IQZConfigProviderUtilProxy.class)).getConfigCookie();
    }

    public static long c() {
        return ((IQZConfigProviderUtilProxy) QRoute.api(IQZConfigProviderUtilProxy.class)).getLastCheckTime();
    }

    public static boolean d(String str, ArrayList<entrance_cfg> arrayList) {
        return ((IQZConfigProviderUtilProxy) QRoute.api(IQZConfigProviderUtilProxy.class)).getNavigatorConfigs(str, arrayList);
    }

    public static Map<String, String> e() {
        return ((IQZConfigProviderUtilProxy) QRoute.api(IQZConfigProviderUtilProxy.class)).loadIspConfigs();
    }

    public static void f(long j3) {
        ((IQZConfigProviderUtilProxy) QRoute.api(IQZConfigProviderUtilProxy.class)).saveIspCheckTime(j3);
    }

    public static void g(Map<String, String> map) {
        ((IQZConfigProviderUtilProxy) QRoute.api(IQZConfigProviderUtilProxy.class)).saveIspConfig(map);
    }

    public static void h(String str, ArrayList<entrance_cfg> arrayList) {
        ((IQZConfigProviderUtilProxy) QRoute.api(IQZConfigProviderUtilProxy.class)).saveNavigatorBar(str, arrayList);
    }

    public static void i(Map<String, byte[]> map, String str, String str2, AppRuntime appRuntime) {
        ((IQZConfigProviderUtilProxy) QRoute.api(IQZConfigProviderUtilProxy.class)).updateConfigAndCookie(map, str, str2, appRuntime);
    }
}
