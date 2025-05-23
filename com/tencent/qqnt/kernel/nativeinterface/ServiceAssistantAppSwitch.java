package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ServiceAssistantAppSwitch {
    public long appId;
    public int appType;
    public String logo;
    public String name;
    public int switchValue;

    public ServiceAssistantAppSwitch() {
        this.name = "";
        this.logo = "";
    }

    public long getAppId() {
        return this.appId;
    }

    public int getAppType() {
        return this.appType;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getName() {
        return this.name;
    }

    public int getSwitchValue() {
        return this.switchValue;
    }

    public ServiceAssistantAppSwitch(long j3, int i3, int i16, String str, String str2) {
        this.appId = j3;
        this.appType = i3;
        this.switchValue = i16;
        this.name = str;
        this.logo = str2;
    }
}
