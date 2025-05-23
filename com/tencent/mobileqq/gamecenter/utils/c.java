package com.tencent.mobileqq.gamecenter.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.Cgi;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static QQProgressDialog f213419a;

    /* renamed from: b, reason: collision with root package name */
    public static final Long f213420b = Long.valueOf(PushRecommend.MAX_SAVE_TIME);

    /* renamed from: c, reason: collision with root package name */
    private static Set<String> f213421c = new HashSet();

    public static void b() {
        try {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            String str = "mmkv_key_gamecenter_action_ids" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            f213421c.addAll(from.decodeStringSet(str, new HashSet()));
            Iterator<String> it = f213421c.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (TextUtils.isEmpty(next)) {
                    QLog.e("CommUtils", 1, "[cleanExpiredUrls] str is empty, return");
                } else {
                    String[] split = next.split(";");
                    if (split.length != 2) {
                        QLog.e("CommUtils", 1, "[cleanExpiredUrls] invalid param, str:" + next);
                    } else if (System.currentTimeMillis() / 1000 > Long.parseLong(split[1])) {
                        it.remove();
                        String i3 = i(split[0]);
                        from.removeKey(i3);
                        QLog.i("CommUtils", 1, "[cleanExpiredUrls] remove:" + i3);
                    }
                }
            }
            from.encodeStringSet(str, f213421c);
        } catch (Exception e16) {
            QLog.e("CommUtils", 1, "[cleanExpiredUrls] " + e16);
        }
    }

    public static void c() {
        QQProgressDialog qQProgressDialog = f213419a;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                f213419a.cancel();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        f213419a = null;
    }

    public static final int d(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0;
        }
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static Map<String, String> e(String str) {
        String str2;
        HashMap hashMap = new HashMap();
        try {
            String query = new URI(str).getQuery();
            if (query != null) {
                for (String str3 : query.split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] split = str3.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    String str4 = split[0];
                    if (split.length > 1) {
                        str2 = split[1];
                    } else {
                        str2 = "";
                    }
                    hashMap.put(str4, str2);
                }
            }
        } catch (Throwable th5) {
            QLog.e("CommUtils", 1, "[extractParams], e:", th5);
        }
        return hashMap;
    }

    public static BusinessInfoCheckUpdate.AppInfo f(String str) {
        AppInterface g16;
        if (TextUtils.isEmpty(str) || (g16 = g()) == null) {
            return null;
        }
        return ((IRedTouchManager) g16.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(str);
    }

    public static AppInterface g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    public static String h(String str) {
        String str2 = "";
        try {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            String i3 = i(str);
            str2 = from.decodeString(i3, "");
            if (QLog.isColorLevel()) {
                QLog.d("CommUtils", 1, "[getHitUrl]  key:" + i3 + ", url:" + str2);
            }
        } catch (Exception e16) {
            QLog.e("CommUtils", 1, "[getHitUrl]:" + e16);
        }
        return str2;
    }

    private static String i(String str) {
        return "mmkv_key_gamecenter_hit_url_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin() + "_" + str;
    }

    public static long j(@NonNull AppRuntime appRuntime, @NonNull String str, long j3) {
        return QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(str + "_" + appRuntime.getCurrentAccountUin(), j3);
    }

    public static JSONObject k(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return null;
        }
        String str = appInfo.buffer.get();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("msg");
            String optString = jSONObject.optString("_show_mission");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                return optJSONObject.optJSONObject(optString);
            }
        } catch (JSONException e16) {
            QLog.e("CommUtils", 1, "getMissionsByAppInfo e:", e16);
        }
        return null;
    }

    public static boolean l(String str) {
        if (str != null) {
            if (str.startsWith("http://") || str.startsWith("https://")) {
                if (s.i(str).equalsIgnoreCase("qq.com") || s.i(str).equalsIgnoreCase(Cgi.DOMAIN_YUN_SERVER) || s.i(str).equalsIgnoreCase(Cgi.TENPAY_DOMAIN) || s.i(str).equalsIgnoreCase("wanggou.com") || s.i(str).equalsIgnoreCase("tencent.com") || s.i(str).equalsIgnoreCase("jd.com") || s.i(str).equalsIgnoreCase("qcloud.com") || s.i(str).equalsIgnoreCase("webank.com") || s.i(str).equalsIgnoreCase("qqumall.com")) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean m(String str) {
        if (str != null && str.startsWith("mqqapi://")) {
            return true;
        }
        return false;
    }

    public static boolean n(String str) {
        if (str != null && (str.startsWith("http://") || str.startsWith("https://"))) {
            return true;
        }
        return false;
    }

    public static void o(Context context, String str) {
        if (n(str)) {
            r(context, str);
        } else if (m(str)) {
            q(context, str);
        } else {
            QLog.e("CommUtils", 1, "jumpUrl invalid url:", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(ArrayList arrayList, com.tencent.biz.common.offline.a aVar) {
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                HtmlOffline.k(str, MobileQQ.sMobileQQ.peekAppRuntime(), aVar, true, 0, true);
                QLog.i("GameActWeb.updateOfflineRes", 1, "bid:" + str + ",version:" + HtmlOffline.z(str));
            }
        } catch (Throwable th5) {
            QLog.e("CommUtils", 1, "[updateOfflineRes], th" + th5);
        }
    }

    public static void q(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.putExtra("big_brother_source_key", "biz_src_zf_games");
        intent.setData(Uri.parse(str));
        intent.setPackage("com.tencent.mobileqq");
        s(context, intent);
    }

    public static void r(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        s(context, intent);
    }

    private static void s(Context context, Intent intent) {
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e16) {
            QLog.e("CommUtils", 1, "safeStartActivity error:", e16);
        }
    }

    public static void t(String str, String str2, long j3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.contains(";")) {
                    QLog.e("CommUtils", 1, "[saveHitUrl] invalid param, action:" + str);
                    return;
                }
                if (str2.contains(";")) {
                    QLog.e("CommUtils", 1, "[saveHitUrl] invalid param, hitUrl:" + str2);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("CommUtils", 1, "[saveHitUrl] actionId:" + str + ", url:" + str2);
                }
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
                String i3 = i(str);
                from.encodeString(i3, str2);
                f213421c.add(str + ";" + j3);
                if (QLog.isColorLevel()) {
                    QLog.d("CommUtils", 1, "[saveHitUrl] add key:" + i3 + ", url:" + str2 + "time:" + j3);
                }
                from.encodeStringSet("mmkv_key_gamecenter_hit_url" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), f213421c);
                return;
            }
            QLog.e("CommUtils", 1, "[saveHitUrl] url or hitUrl is empty, return.");
        } catch (Exception e16) {
            QLog.e("CommUtils", 1, "[saveHitUrl]:" + e16);
        }
    }

    public static void u(@NonNull AppRuntime appRuntime, @NonNull String str, long j3) {
        QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(str + "_" + appRuntime.getCurrentAccountUin(), j3);
    }

    public static void v(String str, Context context, String str2, String str3) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_GAME_CENTER_ACTIVITY);
        activityURIRequest.extra().putString("url", str);
        activityURIRequest.extra().putString(GameCenterCommonApiImpl.KEY_ACT_ID, str2);
        activityURIRequest.extra().putString(GameCenterCommonApiImpl.KEY_ACT_FLAG, str3);
        activityURIRequest.extra().putString("big_brother_source_key", "biz_src_zf_games");
        activityURIRequest.extra().putLong("startOpenPageTime", System.currentTimeMillis());
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public static void w(String str, com.tencent.biz.common.offline.a aVar) {
        try {
            String[] split = str.split("\\|");
            ArrayList arrayList = new ArrayList();
            for (String str2 : split) {
                arrayList.add(str2);
            }
            x(arrayList, aVar);
        } catch (Throwable th5) {
            QLog.e("CommUtils", 1, "[handleGameActScheme], th:", th5);
        }
    }

    public static void x(final ArrayList<String> arrayList, final com.tencent.biz.common.offline.a aVar) {
        QLog.i("GameActWeb.updateOfflineRes", 1, "[updateOfflineRes], bidList:" + arrayList);
        if (arrayList != null && arrayList.size() != 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.utils.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.p(arrayList, aVar);
                }
            }, 128, null, true);
        }
    }
}
