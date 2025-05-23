package com.tencent.aelight.camera.ae.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f65771a = false;

    @Deprecated
    public static boolean a() {
        return false;
    }

    public static boolean b() {
        return f65771a;
    }

    public static void c() {
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        boolean isNowThemeIsNight2 = QQTheme.isNowThemeIsNight();
        ms.a.f("AEThemeUtil", "refreshThemeInfo---utilResult=" + isNowThemeIsNight + ", qqThemeResult=" + isNowThemeIsNight2);
        f65771a = isNowThemeIsNight || isNowThemeIsNight2;
    }
}
