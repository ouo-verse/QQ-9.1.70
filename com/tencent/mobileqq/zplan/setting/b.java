package com.tencent.mobileqq.zplan.setting;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class b {
    public static String a(Context context, boolean z16) {
        if (context == null) {
            return "";
        }
        String g16 = c.g("key_quality_quality_features", "");
        int c16 = c.c(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, -1);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CustomImageProps.QUALITY, c16);
            jSONObject.put("recommended", z16 ? 1 : 0);
            jSONObject.put("platformType", "Android");
            if (!TextUtils.isEmpty(g16) && c16 == 4) {
                jSONObject.put("qualityFeatures", new JSONObject(g16));
            }
            return jSONObject.toString();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return "";
        }
    }

    public static List<a> c(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return arrayList;
        }
        String g16 = c.g("key_quality_recommended_list", "");
        if (TextUtils.isEmpty(g16)) {
            return arrayList;
        }
        arrayList.addAll(d(g16));
        return arrayList;
    }

    private static List<a> d(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            for (int i3 = 0; i3 < 4; i3++) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(String.valueOf(i3), ""));
                a aVar = new a();
                aVar.f335440a = i3;
                aVar.f335442c.f335444a = jSONObject2.optInt("AntiAlias", 2);
                aVar.f335442c.f335445b = jSONObject2.optInt("Texture", 2);
                aVar.f335442c.f335447d = jSONObject2.optInt("Effects", 2);
                aVar.f335442c.f335446c = jSONObject2.optInt("Shadow", 2);
                arrayList.add(aVar);
                QLog.d("QualityUtil", 2, "parseRecommendedList item" + aVar.toString());
            }
        } catch (Exception e16) {
            QLog.e("QualityUtil", 1, "parseRecommendedList json error:" + e16.getMessage());
        }
        return arrayList;
    }

    private static void e(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("recommendedQuality", -1);
            QLog.d("QualityUtil", 2, "parseRspMsg recommendedQuality:" + optInt);
            if (optInt == -1) {
                return;
            }
            c.k("key_quality_recommended_type", optInt);
            if (c.c(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, -1) == -1) {
                c.k(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, optInt);
            }
            String optString = jSONObject.optString("qualityFeatures", "");
            QLog.d("QualityUtil", 2, "parseRspMsg recommendedListStr:" + optString);
            if (TextUtils.isEmpty(optString) || "{}".equals(optString)) {
                return;
            }
            c.l("key_quality_recommended_list", optString);
        } catch (Exception e16) {
            QLog.e("QualityUtil", 1, "parseRspMsg json error:" + e16.getMessage());
        }
    }

    public static void g(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        e(context, str);
    }

    public static a b(Context context) {
        if (context == null) {
            return null;
        }
        String g16 = c.g("key_quality_quality_features", "");
        try {
            if (!TextUtils.isEmpty(g16)) {
                JSONObject jSONObject = new JSONObject(g16);
                a aVar = new a();
                aVar.f335440a = 4;
                aVar.f335442c.f335444a = jSONObject.optInt("AntiAlias", 2);
                aVar.f335442c.f335445b = jSONObject.optInt("Texture", 2);
                aVar.f335442c.f335447d = jSONObject.optInt("Effects", 2);
                aVar.f335442c.f335446c = jSONObject.optInt("Shadow", 2);
                return aVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return null;
    }

    public static void f(Context context, a aVar) {
        if (aVar == null || context == null) {
            return;
        }
        c.k(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, aVar.f335440a);
        try {
            if (aVar.f335440a != 4) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("AntiAlias", aVar.f335442c.f335444a);
            jSONObject.put("Texture", aVar.f335442c.f335445b);
            jSONObject.put("Shadow", aVar.f335442c.f335446c);
            jSONObject.put("Effects", aVar.f335442c.f335447d);
            c.l("key_quality_quality_features", jSONObject.toString());
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
