package com.tencent.biz.richframework.monitor.memory;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BitmapCheckedOption {
    private boolean mIsEnabledChecked;
    private float mLimitMultiple;

    public BitmapCheckedOption(float f16, boolean z16) {
        this.mLimitMultiple = f16;
        this.mIsEnabledChecked = z16;
    }

    public float getLimitMultiple() {
        return this.mLimitMultiple;
    }

    public boolean isEnabledChecked() {
        return this.mIsEnabledChecked;
    }

    public void setEnabledChecked(boolean z16) {
        this.mIsEnabledChecked = z16;
    }

    public void setLimitMultiple(float f16) {
        this.mLimitMultiple = f16;
    }
}
