package com.tencent.mobileqq.immersive;

import android.os.Build;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f238045a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f238046b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41514);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f238045a = null;
            f238046b = null;
        }
    }

    public static boolean a() {
        if (!k() && ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion()) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("enable_use_blur_view_color_fetcher", true);
    }

    public static boolean d() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("enable_use_scanning_light_color_fetcher", true);
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT <= 28) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("enable_navigation_bar_immersive_new", true) && (Build.VERSION.SDK_INT >= 30 || ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("rfw_navigation_bar_open_in_android10", true))) {
            return true;
        }
        return false;
    }

    public static final Boolean g() {
        int i3 = 28;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qzone_personal_album_activity_immersive_min_sdk", String.valueOf(28));
        boolean z16 = false;
        QLog.e("QUIImmersiveConfig", 1, "enableOpenQZonePersonalAlbumImmersive, value = ", loadAsString);
        try {
            i3 = Integer.parseInt(loadAsString);
        } catch (Exception unused) {
            QLog.e("QUIImmersiveConfig", 1, "enableOpenQZonePersonalAlbumImmersive is fail, value = ", loadAsString);
        }
        if (Build.VERSION.SDK_INT > i3) {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }

    public static Boolean h() {
        if (f238045a == null) {
            f238045a = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("enable_use_attach_view", true));
        }
        return f238045a;
    }

    public static Boolean i() {
        if (f238046b == null) {
            boolean z16 = true;
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("immersive_can_used_clip_padding_view", true) && ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion()) {
                z16 = false;
            }
            f238046b = Boolean.valueOf(z16);
        }
        return f238046b;
    }

    public static float j() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qui_immersive_open_switch", "70");
        try {
            return (Integer.parseInt(loadAsString) * 1.0f) / 100.0f;
        } catch (Exception unused) {
            QLog.e("QUIImmersiveConfig", 1, "getLightThreshold is fail, value = ", loadAsString);
            return 0.7f;
        }
    }

    private static boolean k() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qui_immersive_open_switch", true);
    }

    public static boolean l() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static boolean m() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26 && i3 <= 33 && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("ENABLE_ART_HOOK", true)) {
            return true;
        }
        return false;
    }
}
