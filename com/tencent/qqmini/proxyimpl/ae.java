package com.tencent.qqmini.proxyimpl;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.minigame.utils.PathUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.AdReportData;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.xweb.FileReaderHelper;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Long> f347771a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, String> f347772b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static long f347773c;

    /* renamed from: d, reason: collision with root package name */
    private static long f347774d;

    /* renamed from: e, reason: collision with root package name */
    private static long f347775e;

    private static Bundle a(String str, int i3, String str2, String str3, long j3, String str4, int i16, String str5) {
        long longValue;
        Long l3;
        Bundle bundle = new Bundle();
        try {
            String m3 = m(str);
            bundle.putString("viewid", m3);
            bundle.putInt("lt", i3);
            bundle.putInt("ig", 1);
            bundle.putString("refer", "");
            bundle.putInt("at", 0);
            bundle.putInt("fh", 0);
            bundle.putString("wlv", str2);
            bundle.putString("dl", "");
            bundle.putInt(ReportConstant.COSTREPORT_PREFIX, 0);
            bundle.putString("lc", str3);
            bundle.putString("s_p", str4);
            bundle.putInt("sc_c", i16);
            bundle.putString("sc_sn", str5);
            if (i3 == 0) {
                longValue = System.currentTimeMillis();
                if (!TextUtils.isEmpty(m3)) {
                    f347771a.put(m3, Long.valueOf(longValue));
                }
            } else {
                longValue = (TextUtils.isEmpty(m3) || (l3 = f347771a.get(m3)) == null) ? 0L : l3.longValue();
            }
            bundle.putLong("it", longValue);
            bundle.putLong("st", f347773c);
            bundle.putLong("ent", g());
            bundle.putLong(FileReaderHelper.ET_EXT, j3);
            bundle.putLong("ud", i());
        } catch (Exception e16) {
            QLog.e("MiniAdAntiSpamReportUtil", 1, "createReportString error.", e16);
        }
        return bundle;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:6|(1:29)(7:10|(3:12|(1:14)(1:18)|(1:16))|19|20|(1:22)(1:26)|23|24)|17|19|20|(0)(0)|23|24) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00aa, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ab, code lost:
    
        r10.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject b(IMiniAppContext iMiniAppContext, long j3, String str) {
        int i3;
        String str2;
        LaunchParam launchParam;
        JSONObject jSONObject = new JSONObject();
        if (iMiniAppContext == null) {
            QLog.e("MiniAdAntiSpamReportUtil", 1, "miniAppContext == null");
            return jSONObject;
        }
        String baseLibVersion = iMiniAppContext.getBaseLibVersion();
        String str3 = (String) iMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        String str4 = "";
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null) {
            i3 = launchParam.scene;
            str2 = launchParam.fromMiniAppId;
            if (TextUtils.isEmpty(str2)) {
                JSONObject jSONQueryString = !TextUtils.isEmpty(miniAppInfo.launchParam.reportData) ? PathUtil.getJSONQueryString(miniAppInfo.launchParam.reportData) : null;
                if (jSONQueryString != null) {
                    str2 = jSONQueryString.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, "");
                }
            }
            jSONObject.put("at", 0);
            jSONObject.put("ent", g());
            jSONObject.put("ig", 1);
            jSONObject.put("it", j3);
            jSONObject.put("lc", str3);
            jSONObject.put("s_p", str);
            jSONObject.put("sc_s", i3);
            if (str2 == null) {
                str4 = str2;
            }
            jSONObject.put("sc_sn", str4);
            jSONObject.put("st", f347773c);
            jSONObject.put("ud", i());
            jSONObject.put("wlv", baseLibVersion);
            return jSONObject;
        }
        i3 = 0;
        str2 = "";
        jSONObject.put("at", 0);
        jSONObject.put("ent", g());
        jSONObject.put("ig", 1);
        jSONObject.put("it", j3);
        jSONObject.put("lc", str3);
        jSONObject.put("s_p", str);
        jSONObject.put("sc_s", i3);
        if (str2 == null) {
        }
        jSONObject.put("sc_sn", str4);
        jSONObject.put("st", f347773c);
        jSONObject.put("ud", i());
        jSONObject.put("wlv", baseLibVersion);
        return jSONObject;
    }

    private static JSONObject c(String str, int i3, String str2, String str3, long j3, String str4, int i16, String str5) {
        return l(a(str, i3, str2, str3, j3, str4, i16, str5));
    }

    private static String d(AdReportData adReportData, String str, String str2) {
        String str3 = "";
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("ap_p", adReportData.path);
            jSONObject.put("at", 0);
            jSONObject.put("cn_t", adReportData.networkType);
            jSONObject.put("dl", "");
            jSONObject.put("ent", adReportData.lastOnResumeTime);
            jSONObject.put(FileReaderHelper.ET_EXT, currentTimeMillis);
            jSONObject.put("fh", 0);
            jSONObject.put("ic", 0);
            jSONObject.put("ig", adReportData.isGame);
            if (f347771a.containsKey(str)) {
                jSONObject.put("it", f347771a.get(str));
            }
            jSONObject.put("lc", adReportData.lastClicks);
            jSONObject.put("lt", 2);
            jSONObject.put("refer", adReportData.referPath);
            jSONObject.put(ReportConstant.COSTREPORT_PREFIX, 0);
            jSONObject.put("s_p", str2);
            jSONObject.put("sc_s", adReportData.scene);
            if (!TextUtils.isEmpty(adReportData.sceneSn)) {
                str3 = adReportData.sceneSn;
            }
            jSONObject.put("sc_sn", str3);
            jSONObject.put("st", adReportData.startTime);
            jSONObject.put("ud", adReportData.stayTime);
            if (f347772b.containsKey(str)) {
                jSONObject.put("viewid", m(f347772b.get(str)));
            }
            jSONObject.put("wlv", adReportData.baseLibVersion);
            QLog.d("MiniAdAntiSpamReportUtil", 2, "spam data: " + jSONObject.toString());
        } catch (Exception e16) {
            QLog.e("MiniAdAntiSpamReportUtil", 1, "createRewardedVideoAdReportParams error.", e16);
        }
        return jSONObject.toString();
    }

    public static void e() {
        f347773c = System.currentTimeMillis();
        f347774d = System.currentTimeMillis();
        f347775e = 0L;
    }

    private static long g() {
        return Math.max(f347774d, f347773c);
    }

    private static long i() {
        return (f347775e + System.currentTimeMillis()) - g();
    }

    public static void j() {
        f347774d = System.currentTimeMillis();
    }

    public static void k() {
        f347775e += System.currentTimeMillis() - f347774d;
    }

    private static JSONObject l(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    jSONObject.put(str, bundle.getString(str));
                } else if (obj instanceof Integer) {
                    jSONObject.put(str, bundle.getInt(str));
                } else if (obj instanceof Long) {
                    jSONObject.put(str, bundle.getLong(str));
                }
            }
        } catch (Exception e16) {
            QLog.e("MiniAdAntiSpamReportUtil", 1, "paramsToJson error.", e16);
        }
        return jSONObject;
    }

    private static String m(String str) {
        String queryParameter;
        return (TextUtils.isEmpty(str) || (queryParameter = Uri.parse(str).getQueryParameter("viewid")) == null) ? "" : queryParameter;
    }

    public static void n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f347772b.put(str, str2);
    }

    public static void o(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f347771a.put(str, Long.valueOf(currentTimeMillis));
    }

    public static String h(IMiniAppContext iMiniAppContext, String str, String str2) {
        if (iMiniAppContext != null && !TextUtils.isEmpty(str)) {
            try {
                return d(iMiniAppContext.getAdReportData(), str, str2);
            } catch (Throwable th5) {
                QLog.e("MiniAdAntiSpamReportUtil", 1, "getRewardedVideoAdExposeReportParamForSDK get an Exception:" + th5.toString());
                return new JSONObject().toString();
            }
        }
        return new JSONObject().toString();
    }

    public static JSONObject f(IMiniAppContext iMiniAppContext, String str, String str2) {
        int i3;
        String str3;
        LaunchParam launchParam;
        if (iMiniAppContext == null || !iMiniAppContext.isMiniGame() || TextUtils.isEmpty(str)) {
            return null;
        }
        String baseLibVersion = iMiniAppContext.getBaseLibVersion();
        String str4 = (String) iMiniAppContext.performAction(ActionBridge.GetLastClicksActionBridge.obtain());
        MiniAppInfo miniAppInfo = iMiniAppContext.getMiniAppInfo();
        String str5 = "";
        if (miniAppInfo == null || (launchParam = miniAppInfo.launchParam) == null) {
            i3 = 0;
            str3 = "";
        } else {
            int i16 = launchParam.scene;
            String str6 = launchParam.fromMiniAppId;
            if (TextUtils.isEmpty(str6)) {
                JSONObject jSONQueryString = TextUtils.isEmpty(miniAppInfo.launchParam.reportData) ? null : PathUtil.getJSONQueryString(miniAppInfo.launchParam.reportData);
                if (jSONQueryString != null) {
                    str5 = jSONQueryString.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, "");
                }
                str3 = str5;
            } else {
                str3 = str6;
            }
            i3 = i16;
        }
        return c(str, 3, baseLibVersion, str4, 0L, str2, i3, str3);
    }
}
