package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProVoiceSmobaGameUserActionPush {
    public long currentMemberNum;
    public long newLeaderId;
    public long roomId;
    public long seq;
    public ArrayList<GProVoiceSmobaGameUserAction> userAction;

    public GProVoiceSmobaGameUserActionPush() {
        this.userAction = new ArrayList<>();
    }

    public long getCurrentMemberNum() {
        return this.currentMemberNum;
    }

    public long getNewLeaderId() {
        return this.newLeaderId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public long getSeq() {
        return this.seq;
    }

    public ArrayList<GProVoiceSmobaGameUserAction> getUserAction() {
        return this.userAction;
    }

    public String toString() {
        return "GProVoiceSmobaGameUserActionPush{roomId=" + this.roomId + ",userAction=" + this.userAction + ",newLeaderId=" + this.newLeaderId + ",currentMemberNum=" + this.currentMemberNum + ",seq=" + this.seq + ",}";
    }

    public GProVoiceSmobaGameUserActionPush(long j3, ArrayList<GProVoiceSmobaGameUserAction> arrayList, long j16, long j17, long j18) {
        new ArrayList();
        this.roomId = j3;
        this.userAction = arrayList;
        this.newLeaderId = j16;
        this.currentMemberNum = j17;
        this.seq = j18;
    }
}
