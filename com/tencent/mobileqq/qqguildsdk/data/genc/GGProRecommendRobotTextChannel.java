package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendRobotTextChannel;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProRecommendRobotTextChannel implements IGProRecommendRobotTextChannel {
    public final GProRecommendRobotTextChannel mInfo;

    public GGProRecommendRobotTextChannel(GProRecommendRobotTextChannel gProRecommendRobotTextChannel) {
        this.mInfo = gProRecommendRobotTextChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotTextChannel
    public ArrayList<String> getAvatars() {
        return this.mInfo.getAvatars();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotTextChannel
    public IGProRecommendChannelInfo getChannelInfo() {
        return new GGProRecommendChannelInfo(this.mInfo.getChannelInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotTextChannel
    public ArrayList<com.tencent.mobileqq.qqguildsdk.data.fe> getMsgAbstracts() {
        ArrayList<MsgAbstract> msgAbstracts = this.mInfo.getMsgAbstracts();
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.fe> arrayList = new ArrayList<>();
        Iterator<MsgAbstract> it = msgAbstracts.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.tencent.mobileqq.qqguildsdk.data.s(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendRobotTextChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
