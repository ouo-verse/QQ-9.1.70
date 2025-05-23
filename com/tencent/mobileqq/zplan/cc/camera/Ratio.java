package com.tencent.mobileqq.zplan.cc.camera;

/* compiled from: P */
/* loaded from: classes35.dex */
public enum Ratio {
    RATIO_Full(0),
    RATIO_9_16(1),
    RATIO_4_3(2),
    RATIO_1_1(3);

    public int value;

    Ratio(int i3) {
        this.value = i3;
    }

    public static Ratio parseFrom(int i3) {
        if (i3 == 0) {
            return RATIO_Full;
        }
        if (i3 == 1) {
            return RATIO_9_16;
        }
        if (i3 == 2) {
            return RATIO_4_3;
        }
        if (i3 != 3) {
            return RATIO_Full;
        }
        return RATIO_1_1;
    }
}
