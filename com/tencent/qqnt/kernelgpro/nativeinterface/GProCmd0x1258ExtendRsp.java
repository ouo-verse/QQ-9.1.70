package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCmd0x1258ExtendRsp {
    public int guildFeedNum;
    public String inviterName = "";

    public int getGuildFeedNum() {
        return this.guildFeedNum;
    }

    public String getInviterName() {
        return this.inviterName;
    }

    public String toString() {
        return "GProCmd0x1258ExtendRsp{guildFeedNum=" + this.guildFeedNum + ",inviterName=" + this.inviterName + ",}";
    }
}
