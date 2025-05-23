package ih;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.util.ad.QZoneAdStyleManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.shake.GdtShakeSensor;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final Set f407637a = new HashSet();

    public static String a(BusinessFeedData businessFeedData) {
        if (!QZoneAdFeedUtils.f55717a.Z(businessFeedData)) {
            return "";
        }
        return businessFeedData.getValueFromCurrencyPassField("easter_egg");
    }

    public static String b(BusinessFeedData businessFeedData) {
        if (!QZoneAdFeedUtils.f55717a.Z(businessFeedData)) {
            return "";
        }
        return businessFeedData.getValueFromCurrencyPassField("track_interactive");
    }

    public static GdtShakeSensor.Params c(BusinessFeedData businessFeedData) {
        GdtShakeSensor.Params params = new GdtShakeSensor.Params();
        try {
            params.factorX = Integer.parseInt(h(businessFeedData, "shake_acceleration_factor_x")) / 1000.0f;
            params.factorY = Integer.parseInt(h(businessFeedData, "shake_acceleration_factor_y")) / 1000.0f;
            params.factorZ = Integer.parseInt(h(businessFeedData, "shake_acceleration_factor_z")) / 1000.0f;
            params.threshold = Integer.parseInt(g(businessFeedData)) / 100.0f;
            params.validCount = Integer.parseInt(h(businessFeedData, "shake_times"));
            return params;
        } catch (Throwable unused) {
            GdtShakeSensor.Params params2 = new GdtShakeSensor.Params();
            GdtLog.e("QZoneShakeAdFeedUtils", "[getShakeSensorParams] error");
            return params2;
        }
    }

    public static int d(BusinessFeedData businessFeedData) {
        String b16 = b(businessFeedData);
        if (!TextUtils.isEmpty(b16)) {
            try {
                return new JSONObject(b16).optInt("shake_animation_time");
            } catch (Exception e16) {
                GdtLog.e("QZoneShakeAdFeedUtils", "getShakeStartTime error " + e16);
            }
        }
        return -1;
    }

    public static int e(BusinessFeedData businessFeedData) {
        String b16 = b(businessFeedData);
        if (TextUtils.isEmpty(b16)) {
            return -1;
        }
        try {
            return new JSONObject(b16).optInt("mask_appear_time", -1);
        } catch (Exception e16) {
            GdtLog.e("QZoneShakeAdFeedUtils", "getShakeStartTime error " + e16);
            return -1;
        }
    }

    public static long f() {
        return 500L;
    }

    private static String g(BusinessFeedData businessFeedData) {
        String h16 = h(businessFeedData, "shake_sensitiveness");
        return TextUtils.isEmpty(h16) ? h(businessFeedData, "shake_acceleration") : h16;
    }

    private static String h(BusinessFeedData businessFeedData, String str) {
        try {
            return new JSONObject(b(businessFeedData)).optString(str);
        } catch (Throwable unused) {
            GdtLog.e("QZoneShakeAdFeedUtils", "[getValueFromTrackInteractiveField] error");
            return "";
        }
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return f407637a.contains(str);
    }

    public static boolean j(BusinessFeedData businessFeedData, long j3) {
        return System.currentTimeMillis() - j3 <= f();
    }

    public static boolean k(BusinessFeedData businessFeedData) {
        return QZoneAdStyleManager.f55731a.e(businessFeedData, "ShakeAndClickInteractive") && !QZoneAdFeedDataExtKt.isMDPAStyleB(businessFeedData);
    }

    public static boolean l(BusinessFeedData businessFeedData) {
        return o(businessFeedData) || n(businessFeedData);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0035 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m(BusinessFeedData businessFeedData) {
        int optInt;
        String b16 = b(businessFeedData);
        if (!TextUtils.isEmpty(b16)) {
            try {
                optInt = new JSONObject(b16).optInt("component_position", 0);
            } catch (Exception e16) {
                GdtLog.e("QZoneShakeAdFeedUtils", "isShakeCaiDanNewStyle error " + e16);
            }
            return optInt != 4;
        }
        optInt = 0;
        if (optInt != 4) {
        }
    }

    public static boolean n(BusinessFeedData businessFeedData) {
        return QZoneAdStyleManager.f55731a.e(businessFeedData, "ShakePlusInteractive") && QZoneAdFeedDataExtKt.getGdtInnerAdShowType(businessFeedData) == 1;
    }

    public static boolean o(BusinessFeedData businessFeedData) {
        return QZoneAdStyleManager.f55731a.e(businessFeedData, "ShakePlusInteractive") && QZoneAdFeedDataExtKt.getGdtInnerAdShowType(businessFeedData) == 3;
    }

    public static void p(float f16, float f17, float f18, float f19, long j3) {
        HashMap hashMap = new HashMap();
        hashMap.put("shake_duration", String.valueOf(j3));
        hashMap.put("shake_acc", String.valueOf(f19));
        hashMap.put("shake_x", String.valueOf(f16));
        hashMap.put("shake_y", String.valueOf(f17));
        hashMap.put("shake_z", String.valueOf(f18));
        ((IAdApi) QRoute.api(IAdApi.class)).report("qzone_ad_shake", hashMap);
    }

    public static void q(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Set set = f407637a;
        if (set.size() > 200) {
            set.clear();
        }
        QLog.i("QZoneShakeAdFeedUtils", 1, "[updateShakeShieldMap] ad shielded, traceId:" + str);
        set.add(str);
    }
}
