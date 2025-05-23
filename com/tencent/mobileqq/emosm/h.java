package com.tencent.mobileqq.emosm;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f204367a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f204368b;

    public static boolean a() {
        if (f204368b == null) {
            f204368b = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_emotion_tab_sinking_nt_kernel", true));
        }
        if (f204368b.booleanValue()) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        if (f204367a == null) {
            f204367a = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("fav_panel_gif_enable_custom_first_frame_8985_115585263", false));
        }
        if (!f204367a.booleanValue()) {
            return false;
        }
        return true;
    }
}
