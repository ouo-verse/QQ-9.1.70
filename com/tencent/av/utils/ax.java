package com.tencent.av.utils;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ax {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f77065a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f77066b;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f77067c;

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f77068d;

    public static JSONObject a(String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        return ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getJSONObject(str, "{}");
    }

    public static boolean b() {
        if (f77066b == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return false;
            }
            f77066b = Boolean.valueOf(((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(AppConstants.Preferences.QAV_MOBILE_NET_SUPPORT));
        }
        if (QLog.isColorLevel()) {
            QLog.i("ToggleUtils", 2, "isMobileNetSupportEnable " + f77066b);
        }
        return f77066b.booleanValue();
    }

    public static boolean c() {
        if (f77065a == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return false;
            }
            f77065a = Boolean.valueOf(((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("qav_round_corner"));
        }
        return f77065a.booleanValue();
    }

    public static boolean d() {
        if (f77067c == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return false;
            }
            f77067c = Boolean.valueOf(((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("simplify_mav_channel"));
        }
        if (QLog.isColorLevel()) {
            QLog.i("ToggleUtils", 2, "isSimplifyManChannel " + f77067c);
        }
        return f77067c.booleanValue();
    }

    public static boolean e() {
        if (f77068d == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return true;
            }
            f77068d = Boolean.valueOf(((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("qav_speaking_when_close_mic_tips", true));
        }
        if (QLog.isColorLevel()) {
            QLog.i("ToggleUtils", 2, "sIsSpeakingWhenCloseMicTipsShow " + f77068d);
        }
        return f77068d.booleanValue();
    }
}
