package com.huawei.hms.hihealth.data;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public enum SleepFragmentCategory {
    SLEEP_LIGHT(1),
    SLEEP_DREAM(2),
    SLEEP_DEEP(3),
    SLEEP_AWAKE(4),
    SLEEP_NAP(5);

    private int value;

    SleepFragmentCategory(int i3) {
        this.value = i3;
    }

    public int getValue() {
        return this.value;
    }
}
