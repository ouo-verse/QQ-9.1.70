package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ThumbOpt {
    public Integer density;
    public Float longLimit;
    public Integer maxSide;
    public Integer minSide;

    public ThumbOpt() {
    }

    public Integer getDensity() {
        return this.density;
    }

    public Float getLongLimit() {
        return this.longLimit;
    }

    public Integer getMaxSide() {
        return this.maxSide;
    }

    public Integer getMinSide() {
        return this.minSide;
    }

    public String toString() {
        return "ThumbOpt{maxSide=" + this.maxSide + ",minSide=" + this.minSide + ",longLimit=" + this.longLimit + ",density=" + this.density + ",}";
    }

    public ThumbOpt(Integer num, Integer num2, Float f16, Integer num3) {
        this.maxSide = num;
        this.minSide = num2;
        this.longLimit = f16;
        this.density = num3;
    }
}
