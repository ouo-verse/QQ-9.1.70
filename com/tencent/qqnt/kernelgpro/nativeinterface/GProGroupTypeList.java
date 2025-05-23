package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGroupTypeList implements Serializable {
    public long channelId;
    public ArrayList<GProGroupTypeMember> groupTypeMembers;
    long serialVersionUID;

    public GProGroupTypeList() {
        this.serialVersionUID = 1L;
        this.groupTypeMembers = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public ArrayList<GProGroupTypeMember> getGroupTypeMembers() {
        return this.groupTypeMembers;
    }

    public String toString() {
        return "GProGroupTypeList{channelId=" + this.channelId + ",groupTypeMembers=" + this.groupTypeMembers + ",}";
    }

    public GProGroupTypeList(long j3, ArrayList<GProGroupTypeMember> arrayList) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.channelId = j3;
        this.groupTypeMembers = arrayList;
    }
}
