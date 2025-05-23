package com.tencent.upgrade.network;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.upgrade.bean.HttpPostParams;
import com.tencent.upgrade.bean.ReportParam;
import com.tencent.upgrade.bean.UpgradeStrategy;
import com.tencent.upgrade.core.IBasePkgFile;
import com.tencent.upgrade.core.j;
import com.tencent.upgrade.util.e;
import com.tencent.upgrade.util.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, String> f383881a;

    private static synchronized void a() {
        String str;
        synchronized (a.class) {
            if (f383881a == null) {
                String b16 = e.b(b());
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
                f383881a = concurrentHashMap;
                g(concurrentHashMap, "userId", j.l().o());
                g(f383881a, "appId", j.l().d());
                g(f383881a, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "1");
                g(f383881a, "versionName", com.tencent.upgrade.util.a.f());
                g(f383881a, "versionCode", String.valueOf(j.l().k()));
                g(f383881a, "buildNo", String.valueOf(j.l().j()));
                g(f383881a, "bundleId", j.l().i().getPackageName());
                g(f383881a, "businessId", b16);
                g(f383881a, WadlProxyConsts.CHANNEL, com.tencent.upgrade.util.a.c());
                g(f383881a, "sdkVer", "2.1.3-RC02");
                if (!j.l().w()) {
                    g(f383881a, "md5", com.tencent.upgrade.util.a.d(j.l().i(), j.l().k(), j.l().j(), com.tencent.upgrade.util.a.f()));
                }
                if (com.tencent.upgrade.util.b.a()) {
                    str = IPreloadResource.ABI_64;
                } else {
                    str = "32";
                }
                g(f383881a, "abiSupport", str);
            }
        }
    }

    private static String b() {
        com.tencent.upgrade.storage.b bVar = new com.tencent.upgrade.storage.b("gray_sdk_androidId", "", j.l().n());
        String str = (String) bVar.a();
        if (TextUtils.isEmpty(str)) {
            String b16 = com.tencent.upgrade.util.a.b();
            bVar.b(b16);
            return b16;
        }
        return str;
    }

    public static Map<String, String> c(Map<String, String> map) {
        a();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        f(f383881a, concurrentHashMap);
        f(map, concurrentHashMap);
        concurrentHashMap.put("netType", f.b());
        concurrentHashMap.put("requestTime", String.valueOf(System.currentTimeMillis()));
        return concurrentHashMap;
    }

    public static HttpPostParams d(ReportParam reportParam) {
        HttpPostParams httpPostParams = new HttpPostParams(HttpPostParams.ContentType.JSON);
        httpPostParams.addHeadParams(c(reportParam.getExtraHeadParams()));
        httpPostParams.jsonContent(reportParam.getJsonObject().toString());
        return httpPostParams;
    }

    public static HttpPostParams e(Map<String, String> map, boolean z16) {
        HttpPostParams httpPostParams = new HttpPostParams(HttpPostParams.ContentType.JSON);
        JSONObject jSONObject = new JSONObject();
        UpgradeStrategy h16 = j.l().h();
        IBasePkgFile e16 = j.l().e();
        httpPostParams.addHeadParams(c(map));
        try {
            jSONObject.put("localTacticsId", h16.getTacticsId());
            jSONObject.put("localTacticsTime", System.currentTimeMillis());
            jSONObject.put("strategyType", 1);
            jSONObject.put("ignoreNoDisturbPeriod", z16);
            if (e16 != null) {
                jSONObject.put("diffType", e16.a().getValue());
            }
            httpPostParams.jsonContent(jSONObject.toString());
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        return httpPostParams;
    }

    private static void f(Map<String, String> map, Map<String, String> map2) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private static void g(Map<String, String> map, String str, String str2) {
        if (str == null) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        map.put(str, str2);
    }
}
