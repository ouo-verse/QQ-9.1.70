package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class KickedInfo implements IKernelModel {
    public int appId;
    public int instanceId;
    public KickedType kickedType;
    public boolean sameDevice;
    public int securityKickedType;
    public String tipsDesc;
    public String tipsTitle;

    public KickedInfo() {
        this.tipsDesc = "";
        this.tipsTitle = "";
        this.kickedType = KickedType.values()[0];
    }

    public int getAppId() {
        return this.appId;
    }

    public int getInstanceId() {
        return this.instanceId;
    }

    public KickedType getKickedType() {
        return this.kickedType;
    }

    public boolean getSameDevice() {
        return this.sameDevice;
    }

    public int getSecurityKickedType() {
        return this.securityKickedType;
    }

    public String getTipsDesc() {
        return this.tipsDesc;
    }

    public String getTipsTitle() {
        return this.tipsTitle;
    }

    public void setAppId(int i3) {
        this.appId = i3;
    }

    public void setInstanceId(int i3) {
        this.instanceId = i3;
    }

    public void setKickedType(KickedType kickedType) {
        this.kickedType = kickedType;
    }

    public void setSameDevice(boolean z16) {
        this.sameDevice = z16;
    }

    public void setSecurityKickedType(int i3) {
        this.securityKickedType = i3;
    }

    public void setTipsDesc(String str) {
        this.tipsDesc = str;
    }

    public void setTipsTitle(String str) {
        this.tipsTitle = str;
    }

    public String toString() {
        return "KickedInfo{appId=" + this.appId + ",instanceId=" + this.instanceId + ",sameDevice=" + this.sameDevice + ",tipsDesc=" + this.tipsDesc + ",tipsTitle=" + this.tipsTitle + ",kickedType=" + this.kickedType + ",securityKickedType=" + this.securityKickedType + ",}";
    }

    public KickedInfo(int i3, int i16, boolean z16, String str, String str2, KickedType kickedType, int i17) {
        this.tipsDesc = "";
        this.tipsTitle = "";
        KickedType kickedType2 = KickedType.values()[0];
        this.appId = i3;
        this.instanceId = i16;
        this.sameDevice = z16;
        this.tipsDesc = str;
        this.tipsTitle = str2;
        this.kickedType = kickedType;
        this.securityKickedType = i17;
    }
}
