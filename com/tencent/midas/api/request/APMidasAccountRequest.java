package com.tencent.midas.api.request;

/* loaded from: classes9.dex */
public class APMidasAccountRequest extends APMidasBaseRequest {
    public static String NET_REQ_ACCOUNT = "account";
    public String provideUin = "";
    public String provideType = "";
    public String balanceType = "";
    public String balanceExtras = "";

    public String getBalanceExtras() {
        return this.balanceExtras;
    }

    public String getBalanceType() {
        return this.balanceType;
    }

    public String getProvideType() {
        return this.provideType;
    }

    public String getProvideUin() {
        return this.provideUin;
    }

    public void setBalanceExtras(String str) {
        this.balanceExtras = str;
    }

    public void setBalanceType(String str) {
        this.balanceType = str;
    }

    public void setProvideType(String str) {
        this.provideType = str;
    }

    public void setProvideUin(String str) {
        this.provideUin = str;
    }

    public String toString() {
        return super.toString() + "---{ provideUin=" + this.provideUin + " | provideType=" + this.provideType + " | balanceType=" + this.balanceType + " | balanceExtras=" + this.balanceExtras + " }";
    }
}
