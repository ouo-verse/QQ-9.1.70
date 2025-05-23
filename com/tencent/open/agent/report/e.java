package com.tencent.open.agent.report;

import com.tencent.mobileqq.app.AppConstants;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {
    public static int a(int i3) {
        if (i3 != 1) {
            int i16 = 2;
            if (i3 == 2) {
                return 1;
            }
            if (i3 != 3) {
                i16 = 4;
                if (i3 == 4) {
                    return 3;
                }
                if (i3 != 9) {
                    return -1;
                }
            }
            return i16;
        }
        return 0;
    }

    public static int b(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 4) {
            return 2;
        }
        if (i3 == 5) {
            return 1;
        }
        return 3;
    }

    public static int c(int i3, String str) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 3000) {
            return 2;
        }
        if (AppConstants.QZONE_UIN.equals(str)) {
            return 3;
        }
        if (AppConstants.FAVORITES_UIN.equals(str)) {
            return 4;
        }
        if (AppConstants.DATALINE_IPAD_UIN.equals(str)) {
            return 5;
        }
        return -1;
    }
}
