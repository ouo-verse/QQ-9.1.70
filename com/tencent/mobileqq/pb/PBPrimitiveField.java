package com.tencent.mobileqq.pb;

/* loaded from: classes16.dex */
public abstract class PBPrimitiveField<T> extends PBField<T> {
    private boolean hasFlag = false;

    public final boolean has() {
        return this.hasFlag;
    }

    public final void setHasFlag(boolean z16) {
        this.hasFlag = z16;
    }
}
