package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSearchType {
    public int feedType;
    public int msgType;
    public int type;

    public GProSearchType() {
    }

    public int getFeedType() {
        return this.feedType;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public int getType() {
        return this.type;
    }

    public void setFeedType(int i3) {
        this.feedType = i3;
    }

    public void setMsgType(int i3) {
        this.msgType = i3;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public String toString() {
        return "GProSearchType{type=" + this.type + ",msgType=" + this.msgType + ",feedType=" + this.feedType + ",}";
    }

    public GProSearchType(int i3, int i16, int i17) {
        this.type = i3;
        this.msgType = i16;
        this.feedType = i17;
    }
}
