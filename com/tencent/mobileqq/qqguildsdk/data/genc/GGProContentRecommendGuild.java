package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendGuild;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildLabel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMedalInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProContentRecommendGuild implements IGProContentRecommendGuild {
    public final GProContentRecommendGuild mInfo;

    public GGProContentRecommendGuild(GProContentRecommendGuild gProContentRecommendGuild) {
        this.mInfo = gProContentRecommendGuild;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public String getCover() {
        return this.mInfo.getCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public IGProGameGiftInfo getGiftInfo() {
        return new GGProGameGiftInfo(this.mInfo.getGiftInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public String getGuildAvatar() {
        return this.mInfo.getGuildAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public String getGuildIntro() {
        return this.mInfo.getGuildIntro();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public String getGuildProfile() {
        return this.mInfo.getGuildProfile();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public byte[] getJoinSig() {
        return this.mInfo.getJoinSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public ArrayList<IGProMedalInfo> getMedals() {
        ArrayList<GProMedalInfo> medals = this.mInfo.getMedals();
        ArrayList<IGProMedalInfo> arrayList = new ArrayList<>();
        Iterator<GProMedalInfo> it = medals.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMedalInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public ArrayList<IGProGuildLabel> getTagList() {
        ArrayList<GProGuildLabel> tagList = this.mInfo.getTagList();
        ArrayList<IGProGuildLabel> arrayList = new ArrayList<>();
        Iterator<GProGuildLabel> it = tagList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildLabel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild
    public String toString() {
        return this.mInfo.toString();
    }
}
