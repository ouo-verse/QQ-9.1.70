package com.tencent.mobileqq.profilecard.utils;

import java.util.Calendar;

/* loaded from: classes35.dex */
public class ProfileDateUtils {
    public static int getAge(int i3, int i16, int i17) {
        Calendar calendar = Calendar.getInstance();
        int i18 = calendar.get(1);
        int i19 = calendar.get(2) + 1;
        int i26 = calendar.get(5);
        if (i3 == 0) {
            return 0;
        }
        int i27 = i18 - i3;
        return (i16 > i19 || (i16 == i19 && i17 > i26)) ? i27 - 1 : i27;
    }

    public static int getBirthdayCode(int i3, int i16, int i17) {
        return (i3 << 16) | (i16 << 8) | i17;
    }

    public static int[] getDefaultBirthday() {
        return new int[]{Calendar.getInstance().get(1) - 18, 1, 1};
    }

    public static int[] parseBirthdayCode(int i3) {
        return new int[]{((-65536) & i3) >>> 16, (65280 & i3) >>> 8, i3 & 255};
    }
}
