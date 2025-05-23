package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TeamUpOption {
    public int optionId;
    public int optionType;
    public TeamUpOptionValue optionValue = new TeamUpOptionValue();

    public int getOptionId() {
        return this.optionId;
    }

    public int getOptionType() {
        return this.optionType;
    }

    public TeamUpOptionValue getOptionValue() {
        return this.optionValue;
    }

    public String toString() {
        return "TeamUpOption{optionId=" + this.optionId + ",optionType=" + this.optionType + ",optionValue=" + this.optionValue + ",}";
    }
}
