package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class VASPersonalVipNumberInfo {
    public Integer appId;
    public Integer itemId;
    public Integer numberIdx;
    public Integer numberItemId;

    public VASPersonalVipNumberInfo() {
    }

    public Integer getAppId() {
        return this.appId;
    }

    public Integer getItemId() {
        return this.itemId;
    }

    public Integer getNumberIdx() {
        return this.numberIdx;
    }

    public Integer getNumberItemId() {
        return this.numberItemId;
    }

    public String toString() {
        return "VASPersonalVipNumberInfo{appId=" + this.appId + ",itemId=" + this.itemId + ",numberItemId=" + this.numberItemId + ",numberIdx=" + this.numberIdx + ",}";
    }

    public VASPersonalVipNumberInfo(Integer num, Integer num2, Integer num3, Integer num4) {
        this.appId = num;
        this.itemId = num2;
        this.numberItemId = num3;
        this.numberIdx = num4;
    }
}
