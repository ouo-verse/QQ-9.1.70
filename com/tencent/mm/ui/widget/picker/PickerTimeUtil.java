package com.tencent.mm.ui.widget.picker;

/* loaded from: classes9.dex */
public final class PickerTimeUtil {
    PickerTimeUtil() {
    }

    public static int a(String str, int i3) {
        try {
            return Integer.parseInt(str, 10);
        } catch (Exception unused) {
            return i3;
        }
    }

    public static boolean checkHourIntValid(int i3) {
        if (i3 >= 0 && i3 <= 23) {
            return true;
        }
        return false;
    }

    public static boolean checkMinuteIntValid(int i3) {
        if (i3 >= 0 && i3 <= 59) {
            return true;
        }
        return false;
    }

    public static int[] parseHHMM(String str) {
        String[] split;
        if (str == null || str.length() <= 0 || (split = str.split(":")) == null || split.length != 2) {
            return null;
        }
        int a16 = a(split[0], -1);
        int a17 = a(split[1], -1);
        if (!checkHourIntValid(a16) || !checkMinuteIntValid(a17)) {
            return null;
        }
        return new int[]{a16, a17};
    }
}
