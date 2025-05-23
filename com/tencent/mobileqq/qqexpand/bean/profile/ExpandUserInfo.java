package com.tencent.mobileqq.qqexpand.bean.profile;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExpandUserInfo extends Entity {
    public static final int FROM_CAMPUS = 1;
    public static final int FROM_CHAT = 3;
    public static final int FROM_SIGNAL = 4;
    public static final int FROM_VOICE = 2;
    private static final int SUB_ID_OTHERS = 11;
    public int fromType;

    @unique
    public String uin;

    public static int fromTypeToSubID(int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                return 2;
            }
            if (i3 == 3 || i3 != 4) {
                return 8;
            }
            return 12;
        }
        return 10;
    }

    public static int getReportSubId(int i3) {
        if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4) {
            if (i3 != 5) {
                if (i3 != 12 && i3 != 102 && i3 != 105 && i3 != 106) {
                    switch (i3) {
                        case 301:
                            return 20;
                        case 302:
                            return 18;
                        case 303:
                            return 17;
                        default:
                            return 11;
                    }
                }
                return 15;
            }
            return 16;
        }
        return 15;
    }

    public static int subIDToFromType(int i3) {
        if (i3 == 10 || i3 == 3) {
            return 1;
        }
        if (i3 == 1 || i3 == 2) {
            return 2;
        }
        if (i3 != 11 && i3 != 12) {
            return 3;
        }
        return 4;
    }

    @NonNull
    public String toString() {
        return "uin:" + this.uin + ",fromType:" + this.fromType + ",";
    }
}
