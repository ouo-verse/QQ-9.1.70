package com.tencent.biz.map;

import android.content.Context;
import android.provider.Settings;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MapUtils {
    public static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException unused) {
            QLog.i("MapUtils", 1, "encodeURIComponent UnsupportedEncodingException");
            return str;
        }
    }

    private static double b(double d16, double d17, double d18, double d19) {
        double g16 = g(d16);
        double g17 = g(d18);
        return Math.asin(Math.sqrt(Math.pow(Math.sin((g16 - g17) / 2.0d), 2.0d) + (Math.cos(g16) * Math.cos(g17) * Math.pow(Math.sin((g(d17) - g(d19)) / 2.0d), 2.0d)))) * 2.0d * 6378137.0d;
    }

    public static double c(LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null) {
            return b(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude);
        }
        return 0.0d;
    }

    public static int d(Context context) {
        int i3;
        try {
            i3 = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
        } catch (Settings.SettingNotFoundException e16) {
            e16.printStackTrace();
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MapUtils", 2, "getLocationMode: invoked. locationMode: " + i3);
        }
        return i3;
    }

    public static String e(String str, LatLng latLng) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("latitude", latLng.latitude);
            jSONObject.put("longitude", latLng.longitude);
            return a(jSONObject.toString());
        } catch (JSONException e16) {
            QLog.i("MapUtils", 1, e16.toString());
            return "";
        }
    }

    public static boolean f() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_relation_map_detail_car_button", false) || StudyModeManager.t()) {
            return false;
        }
        return true;
    }

    private static double g(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    public static void h(final String str, final String str2, final TextView textView) {
        if (textView.getWidth() == 0) {
            textView.post(new Runnable() { // from class: com.tencent.biz.map.MapUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    MapUtils.h(str, str2, textView);
                }
            });
            return;
        }
        String str3 = str + str2;
        float width = textView.getWidth();
        float measureText = textView.getPaint().measureText(str);
        float measureText2 = textView.getPaint().measureText(str2);
        if (measureText + measureText2 <= width) {
            textView.setText(str3);
            return;
        }
        float measureText3 = textView.getPaint().measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        while (measureText + measureText3 + measureText2 > width && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
            measureText = textView.getPaint().measureText(str);
        }
        textView.setText(str + MiniBoxNoticeInfo.APPNAME_SUFFIX + str2);
    }
}
