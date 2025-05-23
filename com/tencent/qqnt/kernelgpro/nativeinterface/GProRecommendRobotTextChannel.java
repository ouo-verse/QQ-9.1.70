package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendRobotTextChannel implements Serializable {
    public ArrayList<String> avatars;
    public GProRecommendChannelInfo channelInfo;
    public ArrayList<MsgAbstract> msgAbstracts;
    long serialVersionUID;

    public GProRecommendRobotTextChannel() {
        this.serialVersionUID = 1L;
        this.channelInfo = new GProRecommendChannelInfo();
        this.msgAbstracts = new ArrayList<>();
        this.avatars = new ArrayList<>();
    }

    public ArrayList<String> getAvatars() {
        return this.avatars;
    }

    public GProRecommendChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public ArrayList<MsgAbstract> getMsgAbstracts() {
        return this.msgAbstracts;
    }

    public String toString() {
        return "GProRecommendRobotTextChannel{channelInfo=" + this.channelInfo + ",msgAbstracts=" + this.msgAbstracts + ",avatars=" + this.avatars + ",}";
    }

    public GProRecommendRobotTextChannel(GProRecommendChannelInfo gProRecommendChannelInfo, ArrayList<MsgAbstract> arrayList, ArrayList<String> arrayList2) {
        this.serialVersionUID = 1L;
        this.channelInfo = new GProRecommendChannelInfo();
        this.msgAbstracts = new ArrayList<>();
        new ArrayList();
        this.channelInfo = gProRecommendChannelInfo;
        this.msgAbstracts = arrayList;
        this.avatars = arrayList2;
    }
}
