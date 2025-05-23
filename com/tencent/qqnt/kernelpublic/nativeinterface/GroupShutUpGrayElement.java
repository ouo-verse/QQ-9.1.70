package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupShutUpGrayElement implements Serializable {
    public GrayTipGroupMember admin;
    public long curTime;
    public long duration;
    public GrayTipGroupMember member;
    long serialVersionUID;

    public GroupShutUpGrayElement() {
        this.serialVersionUID = 1L;
        this.admin = new GrayTipGroupMember();
        this.member = new GrayTipGroupMember();
    }

    public GrayTipGroupMember getAdmin() {
        return this.admin;
    }

    public long getCurTime() {
        return this.curTime;
    }

    public long getDuration() {
        return this.duration;
    }

    public GrayTipGroupMember getMember() {
        return this.member;
    }

    public String toString() {
        return "GroupShutUpGrayElement{curTime=" + this.curTime + ",duration=" + this.duration + ",admin=" + this.admin + ",member=" + this.member + ",}";
    }

    public GroupShutUpGrayElement(long j3, long j16, GrayTipGroupMember grayTipGroupMember, GrayTipGroupMember grayTipGroupMember2) {
        this.serialVersionUID = 1L;
        this.admin = new GrayTipGroupMember();
        new GrayTipGroupMember();
        this.curTime = j3;
        this.duration = j16;
        this.admin = grayTipGroupMember;
        this.member = grayTipGroupMember2;
    }
}
