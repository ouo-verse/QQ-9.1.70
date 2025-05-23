package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GroupMedalSVIPInfo {
    public boolean medalSVIPInfoIsVip;
    public String medalSVIPInfoVipTips = "";
    public String medalSVIPInfoTips = "";
    public String medalSVIPInfoRechargeUrl = "";

    public boolean getMedalSVIPInfoIsVip() {
        return this.medalSVIPInfoIsVip;
    }

    public String getMedalSVIPInfoRechargeUrl() {
        return this.medalSVIPInfoRechargeUrl;
    }

    public String getMedalSVIPInfoTips() {
        return this.medalSVIPInfoTips;
    }

    public String getMedalSVIPInfoVipTips() {
        return this.medalSVIPInfoVipTips;
    }

    public String toString() {
        return "GroupMedalSVIPInfo{medalSVIPInfoVipTips=" + this.medalSVIPInfoVipTips + ",medalSVIPInfoTips=" + this.medalSVIPInfoTips + ",medalSVIPInfoIsVip=" + this.medalSVIPInfoIsVip + ",medalSVIPInfoRechargeUrl=" + this.medalSVIPInfoRechargeUrl + ",}";
    }
}
