package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProAVMemberGroupListRsp implements Serializable {
    public GProChannelUserNum channelUserNum;
    public GProGroupTypeList groupTypeList;
    public long nextReadInterval;
    long serialVersionUID;

    public GProAVMemberGroupListRsp() {
        this.serialVersionUID = 1L;
        this.channelUserNum = new GProChannelUserNum();
        this.groupTypeList = new GProGroupTypeList();
    }

    public GProChannelUserNum getChannelUserNum() {
        return this.channelUserNum;
    }

    public GProGroupTypeList getGroupTypeList() {
        return this.groupTypeList;
    }

    public long getNextReadInterval() {
        return this.nextReadInterval;
    }

    public String toString() {
        return "GProAVMemberGroupListRsp{channelUserNum=" + this.channelUserNum + ",groupTypeList=" + this.groupTypeList + ",nextReadInterval=" + this.nextReadInterval + ",}";
    }

    public GProAVMemberGroupListRsp(GProChannelUserNum gProChannelUserNum, GProGroupTypeList gProGroupTypeList, long j3) {
        this.serialVersionUID = 1L;
        this.channelUserNum = new GProChannelUserNum();
        new GProGroupTypeList();
        this.channelUserNum = gProChannelUserNum;
        this.groupTypeList = gProGroupTypeList;
        this.nextReadInterval = j3;
    }
}
