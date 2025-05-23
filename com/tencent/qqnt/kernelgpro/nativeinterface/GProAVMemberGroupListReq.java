package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAVMemberGroupListReq implements Serializable {
    public long channelId;
    public ArrayList<GProGroupClaim> groupTypes;
    public long guildId;
    long serialVersionUID;

    public GProAVMemberGroupListReq() {
        this.serialVersionUID = 1L;
        this.groupTypes = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public ArrayList<GProGroupClaim> getGroupTypes() {
        return this.groupTypes;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setGroupTypes(ArrayList<GProGroupClaim> arrayList) {
        this.groupTypes = arrayList;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public String toString() {
        return "GProAVMemberGroupListReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",groupTypes=" + this.groupTypes + ",}";
    }

    public GProAVMemberGroupListReq(long j3, long j16, ArrayList<GProGroupClaim> arrayList) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.guildId = j3;
        this.channelId = j16;
        this.groupTypes = arrayList;
    }
}
