package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProChannelMsgNotify {
    public long channelId;
    public int msgNotifyType;

    public GProChannelMsgNotify() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public String toString() {
        return "GProChannelMsgNotify{channelId=" + this.channelId + ",msgNotifyType=" + this.msgNotifyType + ",}";
    }

    public GProChannelMsgNotify(long j3, int i3) {
        this.channelId = j3;
        this.msgNotifyType = i3;
    }
}
