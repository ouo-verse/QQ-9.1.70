package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.constants.TangramAppConstants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    public static boolean a(int i3) {
        return i3 == 19 || i3 == 12 || i3 == 5;
    }

    public static JSONObject b(JSONObject jSONObject) {
        com.qq.e.comm.plugin.base.ad.model.e c16 = c(jSONObject);
        if (!StringUtil.isEmpty(c16.f()) && !StringUtil.isEmpty(c16.g())) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (SDKStatus.getSDKVersionCode() >= 430) {
                    jSONObject2.put("name", c16.f());
                    jSONObject2.put(TangramAppConstants.ICON_URL, c16.g());
                    jSONObject2.put("packageName", c16.b());
                } else {
                    jSONObject2.put("name", c16.f());
                    jSONObject2.put(TangramAppConstants.ICON_URL, c16.g());
                }
                return jSONObject2;
            } catch (JSONException e16) {
                GDTLogger.e("ExceptionWhileLoadAPPDetail", e16);
                return null;
            }
        }
        return null;
    }

    public static com.qq.e.comm.plugin.base.ad.model.e c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        com.qq.e.comm.plugin.base.ad.model.e eVar = new com.qq.e.comm.plugin.base.ad.model.e();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("ext");
        if (a(jSONObject) && optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("alist")) != null) {
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("2022");
            if (optJSONObject3 != null) {
                eVar.b(optJSONObject3.optString("aid"));
            } else {
                eVar.b(optJSONObject.optString("packagename"));
            }
            if (GDTADManager.getInstance().getSM().getInteger(Constants.KEYS.GDT_SDK_IDENTITY, 1) == 2 && TextUtils.isEmpty(eVar.b())) {
                eVar.b(optJSONObject2.optString("pkg_name"));
            }
            eVar.a(optJSONObject2.optInt("appscore"));
            eVar.a(optJSONObject2.optDouble("appprice"));
            eVar.c(optJSONObject2.optString("appname"));
            eVar.a(optJSONObject2.optString("appvername"));
            eVar.a(optJSONObject2.optLong("pkgsize"));
            eVar.e(optJSONObject2.optString("pkgurl"));
            eVar.b(((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getStatus(eVar.b()));
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("2025");
            if (optJSONObject4 != null) {
                JSONObject optJSONObject5 = optJSONObject4.optJSONObject("aid");
                if (optJSONObject5 != null) {
                    eVar.b(optJSONObject5.optLong("total"));
                    eVar.d(optJSONObject5.optString(TangramAppConstants.ICON_URL));
                } else {
                    eVar.b(optJSONObject2.optLong("appdownloadnum"));
                }
            } else {
                eVar.b(optJSONObject2.optLong("downloadnum"));
                eVar.d(optJSONObject2.optString(AppDownloadCallback.APP_LOGO));
            }
        }
        return eVar;
    }

    public static boolean d(JSONObject jSONObject) {
        if (!y.a(jSONObject)) {
            return false;
        }
        int optInt = jSONObject.optInt("producttype");
        int i3 = -1;
        try {
            i3 = jSONObject.getJSONObject("ext").optInt("desttype", -1);
        } catch (JSONException e16) {
            GDTLogger.e("isCanvasAd optInt error: ", e16);
        }
        String optString = jSONObject.optString("canvas_json");
        if (((optInt != 12 || (i3 != 1 && i3 != 0)) && (optInt != 1000 || i3 != 4)) || TextUtils.isEmpty(optString)) {
            return false;
        }
        return true;
    }

    public static boolean e(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.optInt("app_landing_page") == 1) {
            return true;
        }
        return false;
    }

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return a(y.c(jSONObject, "producttype"));
    }

    public static String a() {
        return a("com.tencent.mobileqq", GDTADManager.getInstance().getSM().getInteger("qqNotFoundSampleRate", 1000));
    }

    private static String a(String str, int i3) {
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("getVersionName error, packageName == null");
            StatTracer.trackEvent(100192, 1, (com.qq.e.comm.plugin.stat.b) null, cVar);
            return null;
        }
        cVar.a("pkg", str);
        Context appContext = GDTADManager.getInstance().getAppContext();
        if (appContext == null) {
            GDTLogger.e("getVersionName error, context == null, pkg = " + str);
            StatTracer.trackEvent(100192, 2, (com.qq.e.comm.plugin.stat.b) null, cVar);
            return null;
        }
        try {
            PackageManager packageManager = appContext.getPackageManager();
            if (packageManager == null) {
                GDTLogger.e("getVersionName error, pm == null, pkg = " + str);
                StatTracer.trackEvent(100192, 3, (com.qq.e.comm.plugin.stat.b) null, cVar);
                return null;
            }
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 16384);
            if (packageInfo == null) {
                GDTLogger.e("getVersionName error, info == null, pkg = " + str);
                StatTracer.trackEvent(100192, 4, (com.qq.e.comm.plugin.stat.b) null, cVar);
                return null;
            }
            return packageInfo.versionName;
        } catch (Exception e16) {
            GDTLogger.d(String.format("getVersionName error, exception = %s", e16.toString()));
            if (new Random().nextInt(10000) < i3) {
                StatTracer.trackEvent(100192, 5, (com.qq.e.comm.plugin.stat.b) null, cVar);
            }
            return null;
        }
    }
}
