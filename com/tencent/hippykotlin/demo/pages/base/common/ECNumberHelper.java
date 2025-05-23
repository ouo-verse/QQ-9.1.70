package com.tencent.hippykotlin.demo.pages.base.common;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECNumberHelper {
    public static final ECNumberHelper INSTANCE = new ECNumberHelper();

    public static String formatString$default(int i3, int i16, int i17) {
        if ((i17 & 2) != 0) {
            i16 = 2;
        }
        String str = (i17 & 4) != 0 ? "w" : null;
        if (i3 < 10000) {
            return String.valueOf(i3);
        }
        int i18 = i3 / 10000;
        if (i16 == 1) {
            return i18 + str;
        }
        int i19 = i3 % 1000;
        for (int i26 = 0; i26 < BoxType$EnumUnboxingSharedUtility.ordinal(i16); i26++) {
            i19 *= 10;
        }
        int i27 = i19 / 1000;
        if (i27 > 0) {
            return i18 + '.' + i27 + str;
        }
        return i18 + str;
    }
}
