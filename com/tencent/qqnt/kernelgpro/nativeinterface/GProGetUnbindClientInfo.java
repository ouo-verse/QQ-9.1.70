package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetUnbindClientInfo {
    public boolean canBind;
    public int clientId;
    public int clientSourceType;
    public int openType;
    public String clientName = "";
    public String icon = "";
    public String openUrl = "";
    public String toastMsg = "";

    public boolean getCanBind() {
        return this.canBind;
    }

    public int getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public int getClientSourceType() {
        return this.clientSourceType;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getOpenType() {
        return this.openType;
    }

    public String getOpenUrl() {
        return this.openUrl;
    }

    public String getToastMsg() {
        return this.toastMsg;
    }

    public String toString() {
        return "GProGetUnbindClientInfo{clientId=" + this.clientId + ",clientName=" + this.clientName + ",icon=" + this.icon + ",openType=" + this.openType + ",openUrl=" + this.openUrl + ",clientSourceType=" + this.clientSourceType + ",canBind=" + this.canBind + ",toastMsg=" + this.toastMsg + ",}";
    }
}
