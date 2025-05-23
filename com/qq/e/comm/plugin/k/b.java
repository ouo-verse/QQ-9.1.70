package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    public static String a(JSONObject jSONObject) {
        return jSONObject != null ? jSONObject.optJSONObject("ext").optString("pkg_name") : "";
    }

    public static int b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("reltarget");
        }
        return 0;
    }

    public static boolean c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        int optInt = jSONObject.optInt("wx_minigame_jump_type", Integer.MIN_VALUE);
        if (optInt != Integer.MIN_VALUE) {
            return optInt == 1;
        }
        if (jSONObject.optInt("producttype") != 46) {
            return false;
        }
        StatTracer.trackEvent(1600300, new JSONObject(), new JSONObject());
        return true;
    }

    public static boolean d(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt(MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE) == 3;
    }

    public static boolean e(JSONObject jSONObject) {
        return c(jSONObject) || d(jSONObject);
    }

    public static boolean f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.optBoolean("is_qq_mini_game", false);
    }

    public static boolean g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return !TextUtils.isEmpty(jSONObject.optString("mini_program_app_id"));
    }

    public static String h(JSONObject jSONObject) {
        if (!y.a(jSONObject)) {
            return "0";
        }
        Context appContext = GDTADManager.getInstance().getAppContext();
        String b16 = d.c(jSONObject).b();
        if (!d.a(jSONObject)) {
            return "0";
        }
        if (c.a(appContext, b16)) {
            return "2";
        }
        return "1";
    }

    public static boolean i(JSONObject jSONObject) {
        if (jSONObject == null || !d.a(jSONObject) || TextUtils.isEmpty(jSONObject.optString("bottom_card_url"))) {
            return false;
        }
        return true;
    }

    public static boolean j(JSONObject jSONObject) {
        return !TextUtils.isEmpty(y.e(jSONObject, "net_log_req_id"));
    }

    public static boolean b(com.qq.e.comm.plugin.base.ad.model.f fVar) {
        return a(fVar) || fVar.N();
    }

    public static String d(String str) {
        return (TextUtils.isEmpty(str) || !com.qq.e.comm.plugin.j.c.a("splashExposureRealTimeAppend", 0, 1)) ? str : ay.d(str, "r_imp_time", String.valueOf(System.currentTimeMillis()));
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("_viewid_");
        if (indexOf != -1) {
            return str.substring(indexOf + 8);
        }
        return null;
    }

    public static JSONArray a(JSONObject jSONObject, String str) {
        if (jSONObject != null && str.length() > 0) {
            try {
                if (jSONObject.optInt("ret") != 0) {
                    return null;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject(str);
                if (optJSONObject.optInt("ret") != 0) {
                    return null;
                }
                return optJSONObject.optJSONArray("list");
            } catch (Exception e16) {
                GDTLogger.e("getAdListFromResult error: " + e16);
            }
        }
        return null;
    }

    public static JSONArray b() {
        JSONArray a16 = w.a();
        w.a(a16, 9999);
        return a16;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a16 = ay.a(str, "viewid");
        if (TextUtils.isEmpty(a16)) {
            a16 = e(ay.a(str, "ping_data"));
        }
        if (TextUtils.isEmpty(a16)) {
            a16 = e(ay.a(str, "click_data"));
        }
        return !TextUtils.isEmpty(a16) ? ay.d(ay.d(str, "tk", Md5Util.encode(a16.concat("2022v587"))), "mvr", HiAnalyticsConstant.KeyAndValue.NUMBER_01) : str;
    }

    public static String b(String str) {
        Pair<Boolean, String> b16 = ay.b(str, "report_source", "2");
        return ((Boolean) b16.first).booleanValue() ? (String) b16.second : str;
    }

    public static boolean a(com.qq.e.comm.plugin.base.ad.model.f fVar) {
        return (fVar instanceof com.qq.e.comm.plugin.base.ad.model.r) && ((com.qq.e.comm.plugin.base.ad.model.r) fVar).bf() != 2;
    }

    public static com.qq.e.comm.plugin.base.ad.model.d a(String str) {
        List<com.qq.e.comm.plugin.base.ad.model.d> downloadingOrPausedTasks = ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).getDownloadingOrPausedTasks();
        if (downloadingOrPausedTasks != null && downloadingOrPausedTasks.size() > 0) {
            for (com.qq.e.comm.plugin.base.ad.model.d dVar : downloadingOrPausedTasks) {
                if (dVar.e().equals(str)) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public static boolean c() {
        String a16 = com.qq.e.comm.plugin.j.c.a((String) null, "judge_quick_app_support_list", "hap://app/");
        if (TextUtils.isEmpty(a16)) {
            GDTLogger.e("hap schema config is empty");
            return false;
        }
        String[] split = a16.split(";");
        if (!g.a((Object[]) split)) {
            GDTLogger.e("hap schema config array resolve fail!");
            return false;
        }
        for (String str : split) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (com.qq.e.comm.plugin.base.ad.e.a.a.a(GDTADManager.getInstance().getAppContext(), (String) null, (String) null, str)) {
                        GDTLogger.d("The current device support hap apps!");
                        return true;
                    }
                    continue;
                } catch (Exception unused) {
                    GDTLogger.e("The current device does not support hap apps with\u3010" + str + "\u3011");
                }
            }
        }
        GDTLogger.d("The current device does not support hap apps");
        return false;
    }

    public static String a(String str, int i3, String str2) {
        if (str != null && str.contains("__ACTION_ID__") && str.contains("__CLICK_ID__") && str2 != null) {
            try {
                String replaceAll = str.replaceAll("__ACTION_ID__", String.valueOf(i3)).replaceAll("__CLICK_ID__", str2);
                return TextUtils.isEmpty(replaceAll) ? str : b(replaceAll);
            } catch (Throwable unused) {
                GDTLogger.e(String.format("replaceEffectUrl replace error. effectUrl: %s, actionId: %d, clickId: %s", str, Integer.valueOf(i3), str2));
                return str;
            }
        }
        GDTLogger.e(String.format("replaceEffectUrl params error. effectUrl: %s, actionId: %d, clickId: %s", str, Integer.valueOf(i3), str2));
        return str;
    }

    public static String a(String str, JSONObject jSONObject, String str2) {
        if (str != null && str.contains("__VIEW_PERCENT__") && str.contains("__VIEW_TIME__") && str.contains("__ACTION_TYPE__")) {
            if (TextUtils.isEmpty(str2)) {
                str2 = h(jSONObject);
            }
            String replaceAll = str.replaceAll("__VIEW_PERCENT__", String.valueOf(1)).replaceAll("__VIEW_TIME__", String.valueOf(0)).replaceAll("__ACTION_TYPE__", str2);
            return TextUtils.isEmpty(replaceAll) ? str : b(replaceAll);
        }
        GDTLogger.e("getOriginalExposureUrl error.");
        return str;
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            Boolean bool = Boolean.TRUE;
            jSONObject.putOpt("support_c2s", bool);
            jSONObject.putOpt("support_deep_link", bool);
            jSONObject.putOpt("support_quick_app_link", Boolean.valueOf(com.qq.e.comm.plugin.base.ad.clickcomponent.d.f.a()));
            jSONObject.putOpt("support_app_preorder", bool);
            jSONObject.putOpt("support_wechat_canvas", Boolean.valueOf(com.qq.e.comm.plugin.base.ad.clickcomponent.d.g.a()));
            JSONArray jSONArray = new JSONArray();
            if (com.qq.e.comm.plugin.base.ad.clickcomponent.d.e.a()) {
                jSONArray.put(11);
            }
            if (bb.f()) {
                jSONArray.put(3);
            }
            if (!y.a(jSONArray)) {
                jSONObject.putOpt("support_mini_program_type", jSONArray);
            }
            jSONObject.putOpt("web_wx_mgame", bool);
            jSONObject.putOpt("web_wx_canvas", bool);
        } catch (Throwable th5) {
            GDTLogger.e("submit targetingAbility error, " + th5.getMessage());
        }
        return jSONObject;
    }

    public static JSONObject a(int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean z16 = true;
            jSONObject.putOpt("support_cdn_xj_native", Boolean.valueOf(com.qq.e.comm.plugin.c.a.a() && !com.qq.e.comm.plugin.c.a.c()));
            if (!com.qq.e.comm.plugin.l.a.a() || !com.qq.e.comm.plugin.l.a.a(i3)) {
                z16 = false;
            }
            jSONObject.putOpt("support_velen", Boolean.valueOf(z16));
            jSONObject.putOpt("support_landingpage_hippy", Boolean.FALSE);
            jSONObject.putOpt("qb_webview", Boolean.TRUE);
        } catch (Throwable th5) {
            GDTLogger.e("submit configureAbility error, " + th5.getMessage());
        }
        return jSONObject;
    }
}
