package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupInfoForGrayTipsRsp {
    public int groupClassExt;
    public long groupCode;
    public int joinMsgSeq;
    public int joinRealMsgSeq;
    public int joinTime;

    public int getGroupClassExt() {
        return this.groupClassExt;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getJoinMsgSeq() {
        return this.joinMsgSeq;
    }

    public int getJoinRealMsgSeq() {
        return this.joinRealMsgSeq;
    }

    public int getJoinTime() {
        return this.joinTime;
    }

    public String toString() {
        return "GroupInfoForGrayTipsRsp{groupCode=" + this.groupCode + ",joinMsgSeq=" + this.joinMsgSeq + ",joinTime=" + this.joinTime + ",joinRealMsgSeq=" + this.joinRealMsgSeq + ",groupClassExt=" + this.groupClassExt + ",}";
    }
}
