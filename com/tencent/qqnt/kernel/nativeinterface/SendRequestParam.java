package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class SendRequestParam {
    public String account;
    public int accountType;
    public int reqTargetAccountType;
    public int resendNum;
    public int sendOptions;
    public int sendTimeout;
    public int sendTimeoutOnSlowNet;

    public SendRequestParam() {
        this.account = "";
    }

    public String getAccount() {
        return this.account;
    }

    public int getAccountType() {
        return this.accountType;
    }

    public int getReqTargetAccountType() {
        return this.reqTargetAccountType;
    }

    public int getResendNum() {
        return this.resendNum;
    }

    public int getSendOptions() {
        return this.sendOptions;
    }

    public int getSendTimeout() {
        return this.sendTimeout;
    }

    public int getSendTimeoutOnSlowNet() {
        return this.sendTimeoutOnSlowNet;
    }

    public String toString() {
        return "SendRequestParam{sendTimeout=" + this.sendTimeout + ",sendTimeoutOnSlowNet=" + this.sendTimeoutOnSlowNet + ",resendNum=" + this.resendNum + ",sendOptions=" + this.sendOptions + ",reqTargetAccountType=" + this.reqTargetAccountType + ",account=" + this.account + ",accountType=" + this.accountType + ",}";
    }

    public SendRequestParam(int i3, int i16, int i17, int i18, int i19, String str, int i26) {
        this.sendTimeout = i3;
        this.sendTimeoutOnSlowNet = i16;
        this.resendNum = i17;
        this.sendOptions = i18;
        this.reqTargetAccountType = i19;
        this.account = str;
        this.accountType = i26;
    }
}
