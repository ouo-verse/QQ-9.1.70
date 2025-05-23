package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProChannelOpenStateResultInfo implements Serializable {
    public int msgNotifyTypeGuildNumber;
    public boolean peakActivityGuildFlag;
    long serialVersionUID;
    public ArrayList<GProSwitchInfo> switchInfoList;

    public GProChannelOpenStateResultInfo() {
        this.serialVersionUID = 1L;
        this.switchInfoList = new ArrayList<>();
    }

    public int getMsgNotifyTypeGuildNumber() {
        return this.msgNotifyTypeGuildNumber;
    }

    public boolean getPeakActivityGuildFlag() {
        return this.peakActivityGuildFlag;
    }

    public ArrayList<GProSwitchInfo> getSwitchInfoList() {
        return this.switchInfoList;
    }

    public String toString() {
        return "GProChannelOpenStateResultInfo{switchInfoList=" + this.switchInfoList + ",peakActivityGuildFlag=" + this.peakActivityGuildFlag + ",msgNotifyTypeGuildNumber=" + this.msgNotifyTypeGuildNumber + ",}";
    }

    public GProChannelOpenStateResultInfo(ArrayList<GProSwitchInfo> arrayList, boolean z16) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.switchInfoList = arrayList;
        this.peakActivityGuildFlag = z16;
    }
}
