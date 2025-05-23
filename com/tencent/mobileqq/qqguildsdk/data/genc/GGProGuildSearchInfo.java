package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProRecallInfoData;
import com.tencent.mobileqq.qqguildsdk.data.IRecallInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildChannelState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMedalInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendLabel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProSearchRankInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProGuildSearchInfo implements IGProGuildSearchInfo {
    public final GProGuildSearchInfo mInfo;

    public GGProGuildSearchInfo(GProGuildSearchInfo gProGuildSearchInfo) {
        this.mInfo = gProGuildSearchInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getCoverUrl() {
        return this.mInfo.getCoverUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    public long getGuildIdLong() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getGuildNumber() {
        return this.mInfo.getGuildNumber();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    public ArrayList<IGProGuildChannelState> getGuildStates() {
        ArrayList<GProGuildChannelState> guildStates = this.mInfo.getGuildStates();
        ArrayList<IGProGuildChannelState> arrayList = new ArrayList<>();
        Iterator<GProGuildChannelState> it = guildStates.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuildChannelState(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getHeadUrl() {
        return this.mInfo.getHeadUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    public ArrayList<String> getHighlightWords() {
        return this.mInfo.getHighlightWords();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getJoinGuildSig() {
        return this.mInfo.getJoinGuildSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public int getJoinedGuild() {
        return this.mInfo.getJoinedGuild();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    public ArrayList<IGProRecommendLabel> getLabelList() {
        ArrayList<GProRecommendLabel> labelList = this.mInfo.getLabelList();
        ArrayList<IGProRecommendLabel> arrayList = new ArrayList<>();
        Iterator<GProRecommendLabel> it = labelList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendLabel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    public ArrayList<IGProMedalInfo> getMedalInfoList() {
        ArrayList<GProMedalInfo> medalInfoList = this.mInfo.getMedalInfoList();
        ArrayList<IGProMedalInfo> arrayList = new ArrayList<>();
        Iterator<GProMedalInfo> it = medalInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProMedalInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public int getMedalLevel() {
        return this.mInfo.getMedalLevel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    public IGProRecommendLabel getPeopleLabel() {
        return new GGProRecommendLabel(this.mInfo.getPeopleLabel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public String getProfile() {
        return this.mInfo.getProfile();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    public ArrayList<IGProSearchRankInfo> getRankList() {
        ArrayList<GProSearchRankInfo> rankList = this.mInfo.getRankList();
        ArrayList<IGProSearchRankInfo> arrayList = new ArrayList<>();
        Iterator<GProSearchRankInfo> it = rankList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProSearchRankInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public IRecallInfo getRecallInfo() {
        return new GProRecallInfoData(this.mInfo.getRecallInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    public IGProRecommendLabel getRecommendReason() {
        return new GGProRecommendLabel(this.mInfo.getRecommendReason());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    public int getShowType() {
        return this.mInfo.getShowType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    public IGProSuggestedSearch getSuggestedSearchInfo() {
        return new GGProSuggestedSearch(this.mInfo.getSuggestedSearchInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo, com.tencent.mobileqq.qqguildsdk.data.IGProSearchGuildInfo
    public ArrayList<String> getTags() {
        return this.mInfo.getTags();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
