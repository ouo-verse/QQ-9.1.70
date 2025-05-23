package com.pay.api;

/* loaded from: classes2.dex */
public class APPayResponseInfo {
    public static final int PAYCHANEL_ACCT_QBQD = 11;
    public static final int PAYCHANEL_ACCT_QDQB = 0;
    public static final int PAYCHANEL_GOLDCOUPONS = 10;
    public static final int PAYCHANEL_HF = 9;
    public static final int PAYCHANEL_MCARD = 5;
    public static final int PAYCHANEL_QQCARD = 4;
    public static final int PAYCHANEL_TENPAY_BANK = 2;
    public static final int PAYCHANEL_TENPAY_CFT = 1;
    public static final int PAYCHANEL_TENPAY_KJ = 3;
    public static final int PAYCHANEL_UNKOWN = -1;
    public static final int PAYCHANEL_WECHAT = 8;
    public static final int PAYCHANEL_YB = 7;
    public static final int PAYPROVIDESTATE_SUCC = 0;
    public static final int PAYPROVIDESTATE_UNKOWN = -1;
    public static final int PAYRESULT_CANCEL = 2;
    public static final int PAYRESULT_ERROR = -1;
    public static final int PAYRESULT_PARAMERROR = 3;
    public static final int PAYRESULT_SUCC = 0;
    public static final int PAYSTATE_PAYCANCEL = 1;
    public static final int PAYSTATE_PAYERROR = 2;
    public static final int PAYSTATE_PAYSUCC = 0;
    public static final int PAYSTATE_PAYUNKOWN = -1;
    public int realSaveNum = 0;
    public int resultCode = -1;
    public int resultInerCode = 0;
    public int payChannel = -1;
    public int payState = -1;
    public int provideState = -1;
    public String resultMsg = "";
    public String extendInfo = "";
    public String payReserve1 = "";
    public String payReserve2 = "";
    public String payReserve3 = "";

    public void reset() {
        this.realSaveNum = 0;
        this.resultCode = -1;
        this.resultInerCode = 0;
        this.payChannel = -1;
        this.payState = -1;
        this.provideState = -1;
        this.resultMsg = "";
        this.extendInfo = "";
        this.payReserve1 = "";
        this.payReserve2 = "";
        this.payReserve3 = "";
    }

    public void setExtendInfo(String str) {
        this.extendInfo = str;
    }

    public void setPayChannel(int i3) {
        this.payChannel = i3;
    }

    public void setPayReserve1(String str) {
        this.payReserve1 = str;
    }

    public void setPayReserve2(String str) {
        this.payReserve2 = str;
    }

    public void setPayReserve3(String str) {
        this.payReserve3 = str;
    }

    public void setPayState(int i3) {
        this.payState = i3;
    }

    public void setProvideState(int i3) {
        this.provideState = i3;
    }

    public void setRealSaveNum(int i3) {
        this.realSaveNum = i3;
    }

    public void setResultCode(int i3) {
        this.resultCode = i3;
    }

    public void setResultInerCode(int i3) {
        this.resultInerCode = i3;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }
}
