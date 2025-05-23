package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendTextChannel;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProRecommendTextChannel implements IGProRecommendTextChannel {
    public final GProRecommendTextChannel mInfo;

    public GGProRecommendTextChannel(GProRecommendTextChannel gProRecommendTextChannel) {
        this.mInfo = gProRecommendTextChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public ArrayList<String> getAvatars() {
        return this.mInfo.getAvatars();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public boolean getIsActive() {
        return this.mInfo.getIsActive();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public ArrayList<String> getMemberAvatars() {
        return this.mInfo.getMemberAvatars();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public ArrayList<com.tencent.mobileqq.qqguildsdk.data.fe> getMsgAbstracts() {
        ArrayList<MsgAbstract> msgAbstracts = this.mInfo.getMsgAbstracts();
        ArrayList<com.tencent.mobileqq.qqguildsdk.data.fe> arrayList = new ArrayList<>();
        Iterator<MsgAbstract> it = msgAbstracts.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.tencent.mobileqq.qqguildsdk.data.s(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public String getMsgSummary() {
        return this.mInfo.getMsgSummary();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public int getNoreadNum() {
        return this.mInfo.getNoreadNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public String getTagMsg() {
        return this.mInfo.getTagMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTextChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
