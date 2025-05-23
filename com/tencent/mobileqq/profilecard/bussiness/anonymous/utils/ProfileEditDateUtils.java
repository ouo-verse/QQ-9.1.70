package com.tencent.mobileqq.profilecard.bussiness.anonymous.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Calendar;

/* loaded from: classes16.dex */
public class ProfileEditDateUtils {
    static IPatchRedirector $redirector_;

    public ProfileEditDateUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean checkBirthDayValid(int i3, int i16, int i17) {
        Calendar calendar = Calendar.getInstance();
        int i18 = calendar.get(1);
        int i19 = calendar.get(2) + 1;
        int i26 = calendar.get(5);
        if (i3 > i18 || i3 < i18 - 120 || ((i3 == i18 && i16 > i19) || i16 < 1 || i16 > 12 || (i3 == i18 && i16 == i19 && i17 > i26))) {
            return false;
        }
        int monthLastDay = getMonthLastDay(i3, i16);
        if (i17 >= 1 && i17 <= monthLastDay) {
            return true;
        }
        return false;
    }

    public static int getAge(int i3, int i16, int i17) {
        Calendar calendar = Calendar.getInstance();
        int i18 = calendar.get(1);
        int i19 = calendar.get(2) + 1;
        int i26 = calendar.get(5);
        if (i3 != 0) {
            int i27 = i18 - i3;
            if (i16 > i19 || (i16 == i19 && i17 > i26)) {
                return i27 - 1;
            }
            return i27;
        }
        return 0;
    }

    public static int getBirthdayCode(int i3, int i16, int i17) {
        return (i3 << 16) | (i16 << 8) | i17;
    }

    public static int[] getDefaultBirthday() {
        return new int[]{Calendar.getInstance().get(1) - 18, 1, 1};
    }

    public static int getMonthLastDay(int i3, int i16) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i3);
        calendar.set(2, i16 - 1);
        calendar.set(5, 1);
        calendar.roll(5, -1);
        return calendar.get(5);
    }

    public static int[] parseBirthdayCode(int i3) {
        return new int[]{((-65536) & i3) >>> 16, (65280 & i3) >>> 8, i3 & 255};
    }
}
