package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StatusInfo implements IKernelModel {
    public int abiFlag;
    public int batteryStatus;
    public CustomStatus customStatus;
    public CustomStatusDescInfo customStatusDescInfo;
    public int eNetworkType;
    public int extStatus;
    public int iconType;
    public int netType;
    public long setTime;
    public int specialFlag;
    public int status;
    public int termType;
    public long uin;
    public String uid = "";
    public String showName = "";
    public String termDesc = "";
    public StatusMusicInfo musicInfo = new StatusMusicInfo();
    public StatusBusinessInfo extOnlineBusinessInfo = new StatusBusinessInfo();
    public StatusExtBuffer extBuffer = new StatusExtBuffer();

    public int getAbiFlag() {
        return this.abiFlag;
    }

    public int getBatteryStatus() {
        return this.batteryStatus;
    }

    public CustomStatus getCustomStatus() {
        return this.customStatus;
    }

    public CustomStatusDescInfo getCustomStatusDescInfo() {
        return this.customStatusDescInfo;
    }

    public int getENetworkType() {
        return this.eNetworkType;
    }

    public StatusExtBuffer getExtBuffer() {
        return this.extBuffer;
    }

    public StatusBusinessInfo getExtOnlineBusinessInfo() {
        return this.extOnlineBusinessInfo;
    }

    public int getExtStatus() {
        return this.extStatus;
    }

    public int getIconType() {
        return this.iconType;
    }

    public StatusMusicInfo getMusicInfo() {
        return this.musicInfo;
    }

    public int getNetType() {
        return this.netType;
    }

    public long getSetTime() {
        return this.setTime;
    }

    public String getShowName() {
        return this.showName;
    }

    public int getSpecialFlag() {
        return this.specialFlag;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTermDesc() {
        return this.termDesc;
    }

    public int getTermType() {
        return this.termType;
    }

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public void setAbiFlag(int i3) {
        this.abiFlag = i3;
    }

    public void setBatteryStatus(int i3) {
        this.batteryStatus = i3;
    }

    public void setCustomStatus(CustomStatus customStatus) {
        this.customStatus = customStatus;
    }

    public void setCustomStatusDescInfo(CustomStatusDescInfo customStatusDescInfo) {
        this.customStatusDescInfo = customStatusDescInfo;
    }

    public void setENetworkType(int i3) {
        this.eNetworkType = i3;
    }

    public void setExtBuffer(StatusExtBuffer statusExtBuffer) {
        this.extBuffer = statusExtBuffer;
    }

    public void setExtOnlineBusinessInfo(StatusBusinessInfo statusBusinessInfo) {
        this.extOnlineBusinessInfo = statusBusinessInfo;
    }

    public void setExtStatus(int i3) {
        this.extStatus = i3;
    }

    public void setIconType(int i3) {
        this.iconType = i3;
    }

    public void setMusicInfo(StatusMusicInfo statusMusicInfo) {
        this.musicInfo = statusMusicInfo;
    }

    public void setNetType(int i3) {
        this.netType = i3;
    }

    public void setSetTime(long j3) {
        this.setTime = j3;
    }

    public void setShowName(String str) {
        this.showName = str;
    }

    public void setSpecialFlag(int i3) {
        this.specialFlag = i3;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public void setTermDesc(String str) {
        this.termDesc = str;
    }

    public void setTermType(int i3) {
        this.termType = i3;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUin(long j3) {
        this.uin = j3;
    }
}
