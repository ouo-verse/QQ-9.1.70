package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AiAvatarVipInfo {
    public boolean isVip;
    public int payType;
    public int quota;
    public String vipName = "";
    public int vipType;

    public boolean getIsVip() {
        return this.isVip;
    }

    public int getPayType() {
        return this.payType;
    }

    public int getQuota() {
        return this.quota;
    }

    public String getVipName() {
        return this.vipName;
    }

    public int getVipType() {
        return this.vipType;
    }

    public String toString() {
        return "AiAvatarVipInfo{vipType=" + this.vipType + ",vipName=" + this.vipName + ",isVip=" + this.isVip + ",quota=" + this.quota + ",payType=" + this.payType + ",}";
    }
}
