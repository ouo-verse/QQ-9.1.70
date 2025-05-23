package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProClientAccount {
    public long bindTimeStamp;
    public int clientId;
    public int clientSourceType;
    public int openType;
    public int type;
    public String clientName = "";
    public String accountSecret = "";
    public String accountName = "";
    public GProClientShowCfg clientConfig = new GProClientShowCfg();
    public String icon = "";
    public String unbindUrl = "";
    public String openUrl = "";

    public String getAccountName() {
        return this.accountName;
    }

    public String getAccountSecret() {
        return this.accountSecret;
    }

    public long getBindTimeStamp() {
        return this.bindTimeStamp;
    }

    public GProClientShowCfg getClientConfig() {
        return this.clientConfig;
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

    public int getType() {
        return this.type;
    }

    public String getUnbindUrl() {
        return this.unbindUrl;
    }

    public String toString() {
        return "GProClientAccount{clientId=" + this.clientId + ",clientName=" + this.clientName + ",accountSecret=" + this.accountSecret + ",accountName=" + this.accountName + ",clientConfig=" + this.clientConfig + ",icon=" + this.icon + ",bindTimeStamp=" + this.bindTimeStamp + ",unbindUrl=" + this.unbindUrl + ",type=" + this.type + ",clientSourceType=" + this.clientSourceType + ",openType=" + this.openType + ",openUrl=" + this.openUrl + ",}";
    }
}
