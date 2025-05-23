package com.tencent.mobileqq.wink.utils;

import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ax {
    public static boolean a() {
        if (!ThemeUtil.isNowThemeIsNight(com.tencent.mobileqq.wink.b.b(), false, null) && !QQTheme.isNowThemeIsNight()) {
            return false;
        }
        return true;
    }
}
