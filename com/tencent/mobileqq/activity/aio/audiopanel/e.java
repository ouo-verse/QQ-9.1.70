package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {
    public static int a(int i3) {
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
            return i3 + 100;
        }
        return i3;
    }

    public static int b(int i3, int i16) {
        int i17 = 1;
        if (i3 != 0 || i16 != 1) {
            if (i3 == 1 && i16 == 0) {
                i17 = 2;
            } else if (i3 == 1 && i16 == 2) {
                i17 = 3;
            } else if (i3 == 2 && i16 == 1) {
                i17 = 4;
            } else if (i3 == 0 && i16 == 2) {
                i17 = 7;
            } else if (i3 == 2 && i16 == 0) {
                i17 = 6;
            }
        }
        try {
            if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
                return i17 + 100;
            }
            return i17;
        } catch (Exception unused) {
            return i17;
        }
    }

    public static float c(float f16, int i3) {
        return Math.abs(f16) / i3;
    }

    public static boolean d(int i3) {
        if (i3 <= 107) {
            return true;
        }
        return false;
    }

    public static boolean e(int i3) {
        if (i3 == 1 || i3 == 101 || i3 == 3 || i3 == 103 || i3 == 201 || i3 == 301 || i3 == 203 || i3 == 303 || i3 == 6 || i3 == 106) {
            return true;
        }
        return false;
    }
}
