package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    private static int a(int i3) {
        if (b(i3)) {
            return 1;
        }
        if (c(i3)) {
            return 2;
        }
        if (i3 == 140) {
            return 3;
        }
        if (i3 == 141) {
            return 4;
        }
        if (i3 == 142) {
            return 5;
        }
        if (i3 == 143) {
            return 6;
        }
        return 100;
    }

    private static boolean b(int i3) {
        if (i3 != 11 && i3 != 9 && i3 != 10 && i3 != 100) {
            return false;
        }
        return true;
    }

    private static boolean c(int i3) {
        if (i3 != 125 && i3 != 126 && i3 != 127 && i3 != 128 && i3 != 129 && i3 != 130) {
            return false;
        }
        return true;
    }

    public static void d(String str, int i3) {
        ReportController.o(null, "dc00898", "", "", str, str, a(i3), 0, "", "", "", "");
    }
}
