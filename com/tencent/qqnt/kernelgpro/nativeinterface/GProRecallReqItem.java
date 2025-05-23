package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecallReqItem {
    public String channelId;
    public int directMsgFlag;
    public ArrayList<Long> msgIds;

    public GProRecallReqItem() {
        this.channelId = "";
        this.msgIds = new ArrayList<>();
    }

    public String getChannelId() {
        return this.channelId;
    }

    public int getDirectMsgFlag() {
        return this.directMsgFlag;
    }

    public ArrayList<Long> getMsgIds() {
        return this.msgIds;
    }

    public String toString() {
        return "GProRecallReqItem{channelId=" + this.channelId + ",msgIds=" + this.msgIds + ",directMsgFlag=" + this.directMsgFlag + ",}";
    }

    public GProRecallReqItem(String str, ArrayList<Long> arrayList, int i3) {
        this.channelId = "";
        new ArrayList();
        this.channelId = str;
        this.msgIds = arrayList;
        this.directMsgFlag = i3;
    }
}
