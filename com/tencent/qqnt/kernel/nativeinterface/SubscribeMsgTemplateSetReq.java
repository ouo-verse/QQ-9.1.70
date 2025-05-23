package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SubscribeMsgTemplateSetReq {
    public long groupId;
    public long guildId;
    public long robotUin;
    public ArrayList<SubscribeMsgTemplateOp> setOp;

    public SubscribeMsgTemplateSetReq() {
        this.setOp = new ArrayList<>();
    }

    public long getGroupId() {
        return this.groupId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public ArrayList<SubscribeMsgTemplateOp> getSetOp() {
        return this.setOp;
    }

    public String toString() {
        return "SubscribeMsgTemplateSetReq{groupId=" + this.groupId + ",guildId=" + this.guildId + ",robotUin=" + this.robotUin + ",setOp=" + this.setOp + ",}";
    }

    public SubscribeMsgTemplateSetReq(long j3, long j16, long j17, ArrayList<SubscribeMsgTemplateOp> arrayList) {
        new ArrayList();
        this.groupId = j3;
        this.guildId = j16;
        this.robotUin = j17;
        this.setOp = arrayList;
    }
}
