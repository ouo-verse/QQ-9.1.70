package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ScanQrRsp {
    public boolean needA1;
    public LoginRspInfo rspInfo = new LoginRspInfo();
    public String dstAppName = "";
    public String loginCity = "";
    public String loginDevType = "";
    public String loginDevName = "";
    public QrOpenAppInfo dstOpenAppInfo = new QrOpenAppInfo();
    public QrSecCheckResult secCheckResult = QrSecCheckResult.values()[0];
    public QrTipsCtrl tips = new QrTipsCtrl();
    public QrAutoLoginInfo autoLogin = new QrAutoLoginInfo();
    public QrLoginPlat loginPlat = QrLoginPlat.values()[0];

    public QrAutoLoginInfo getAutoLogin() {
        return this.autoLogin;
    }

    public String getDstAppName() {
        return this.dstAppName;
    }

    public QrOpenAppInfo getDstOpenAppInfo() {
        return this.dstOpenAppInfo;
    }

    public String getLoginCity() {
        return this.loginCity;
    }

    public String getLoginDevName() {
        return this.loginDevName;
    }

    public String getLoginDevType() {
        return this.loginDevType;
    }

    public QrLoginPlat getLoginPlat() {
        return this.loginPlat;
    }

    public boolean getNeedA1() {
        return this.needA1;
    }

    public LoginRspInfo getRspInfo() {
        return this.rspInfo;
    }

    public QrSecCheckResult getSecCheckResult() {
        return this.secCheckResult;
    }

    public QrTipsCtrl getTips() {
        return this.tips;
    }

    public String toString() {
        return "ScanQrRsp{rspInfo=" + this.rspInfo + ",dstAppName=" + this.dstAppName + ",loginCity=" + this.loginCity + ",loginDevType=" + this.loginDevType + ",loginDevName=" + this.loginDevName + ",needA1=" + this.needA1 + ",dstOpenAppInfo=" + this.dstOpenAppInfo + ",secCheckResult=" + this.secCheckResult + ",tips=" + this.tips + ",autoLogin=" + this.autoLogin + ",loginPlat=" + this.loginPlat + ",}";
    }
}
