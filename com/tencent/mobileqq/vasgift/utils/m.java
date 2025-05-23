package com.tencent.mobileqq.vasgift.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static int f312039a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static String f312040b = "";

    public static boolean a() {
        try {
            return ((IFeatureRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("vas_live_gift_cache_time", false);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static int b() {
        String string;
        try {
            if (f312039a == 0) {
                IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
                if (iFeatureRuntimeService.isFeatureSwitchEnable("vas_live_gift_cache_time", false) && (string = iFeatureRuntimeService.getString("vas_live_gift_cache_time", "0")) != null && !string.isEmpty()) {
                    f312039a = Integer.parseInt(string);
                }
            }
            QLog.e("ToggleHelper", 2, "getCacheTime:" + f312039a);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("ToggleHelper", 2, "getCacheTime: error" + e16);
        }
        return f312039a;
    }

    public static String c() {
        String string;
        try {
            if (TextUtils.isEmpty(f312040b)) {
                f312040b = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/vasgiftpanel/animation.zip";
                IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
                if (iFeatureRuntimeService.isFeatureSwitchEnable("vas_live_gift_combo_url", false) && (string = iFeatureRuntimeService.getString("vas_live_gift_combo_url", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/vasgiftpanel/animation.zip")) != null && !string.isEmpty()) {
                    f312040b = string;
                }
            }
            QLog.e("ToggleHelper", 2, "getComboUrl:" + f312040b);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("ToggleHelper", 2, "getComboUrl: error" + e16);
        }
        return f312040b;
    }
}
