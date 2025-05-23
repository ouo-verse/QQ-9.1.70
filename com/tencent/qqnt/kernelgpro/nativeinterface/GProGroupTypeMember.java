package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGroupTypeMember implements Serializable {
    public long channelId;
    public int groupType;
    public ArrayList<GProUser> memberList;
    long serialVersionUID;

    public GProGroupTypeMember() {
        this.serialVersionUID = 1L;
        this.memberList = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public ArrayList<GProUser> getMemberList() {
        return this.memberList;
    }

    public String toString() {
        return "GProGroupTypeMember{channelId=" + this.channelId + ",groupType=" + this.groupType + ",memberList=" + this.memberList + ",}";
    }

    public GProGroupTypeMember(long j3, int i3, ArrayList<GProUser> arrayList) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.channelId = j3;
        this.groupType = i3;
        this.memberList = arrayList;
    }
}
