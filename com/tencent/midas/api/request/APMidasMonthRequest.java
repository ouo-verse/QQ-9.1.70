package com.tencent.midas.api.request;

/* loaded from: classes9.dex */
public class APMidasMonthRequest extends APMidasBaseRequest {
    public static final int SERVICETYPE_NORMAL = 1;
    public static final int SERVICETYPE_RENEW = 2;
    public static final int SERVICETYPE_UPGRADE = 3;
    private static final long serialVersionUID = -557287896140460926L;
    public String provideType;
    public String provideUin;
    public int gameLogo = 0;
    public String serviceCode = "";
    public String serviceName = "";
    public boolean autoPay = false;
    public int serviceType = 1;

    public boolean getAutoPay() {
        return this.autoPay;
    }

    public int getGameLogo() {
        return this.gameLogo;
    }

    public String getProvideType() {
        return this.provideType;
    }

    public String getProvideUin() {
        return this.provideUin;
    }

    public String getServiceCode() {
        return this.serviceCode;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public void setAutoPay(boolean z16) {
        this.autoPay = z16;
    }

    public void setGameLogo(int i3) {
        this.gameLogo = i3;
    }

    public void setProvideType(String str) {
        this.provideType = str;
    }

    public void setProvideUin(String str) {
        this.provideUin = str;
    }

    public void setServiceCode(String str) {
        this.serviceCode = str;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void setServiceType(int i3) {
        this.serviceType = i3;
    }
}
