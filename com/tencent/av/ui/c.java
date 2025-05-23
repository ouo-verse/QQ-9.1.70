package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    public static void a() {
        ReportController.o(null, "dc00898", "", "", "0X8006F88", "0X8006F88", 0, 0, "", "", "", "");
    }

    public static void b(int i3, long j3) {
        String str;
        if (i3 != 1) {
            if (i3 != 2) {
                str = "0X8006F87";
            } else {
                str = "0X8007F25";
            }
        } else {
            str = "0X8007F2B";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            ReportController.o(null, "dc00898", "", "", str2, str2, 0, 0, "", "", String.valueOf(j3), "");
        }
    }

    public static void c(int i3, String str, String str2) {
        boolean z16;
        int i16 = 2;
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            i16 = 1;
        }
        ReportController.o(null, "dc00898", "", "", "0X8008395", "0X8008395", 0, 0, "", String.valueOf(i16), str, str2);
    }

    public static void d(int i3, String str, String str2) {
        boolean z16;
        int i16 = 2;
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            i16 = 1;
        }
        ReportController.o(null, "dc00898", "", "", "0X800BB5B", "0X800BB5B", 0, 0, "", String.valueOf(i16), str, str2);
    }
}
