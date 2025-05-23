package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecallRspItem {
    public long channelCode;
    public String channelId;
    public int directMsgFlag;
    public String msgBytes;
    public ArrayList<Long> msgSeqs;

    public GProRecallRspItem() {
        this.channelId = "";
        this.msgSeqs = new ArrayList<>();
        this.msgBytes = "";
    }

    public long getChannelCode() {
        return this.channelCode;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public int getDirectMsgFlag() {
        return this.directMsgFlag;
    }

    public String getMsgBytes() {
        return this.msgBytes;
    }

    public ArrayList<Long> getMsgSeqs() {
        return this.msgSeqs;
    }

    public String toString() {
        return "GProRecallRspItem{channelId=" + this.channelId + ",msgSeqs=" + this.msgSeqs + ",directMsgFlag=" + this.directMsgFlag + ",channelCode=" + this.channelCode + ",msgBytes=" + this.msgBytes + ",}";
    }

    public GProRecallRspItem(String str, ArrayList<Long> arrayList, int i3, long j3, String str2) {
        this.channelId = "";
        new ArrayList();
        this.channelId = str;
        this.msgSeqs = arrayList;
        this.directMsgFlag = i3;
        this.channelCode = j3;
        this.msgBytes = str2;
    }
}
