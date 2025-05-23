package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildChannelState;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchRankInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSuggestedSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes17.dex */
public interface IGProSearchGuildInfo extends IGProGuildSearchInfo {
    String getCoverUrl();

    List<Object> getGuildChannelStates();

    String getGuildId();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    /* synthetic */ long getGuildIdLong();

    String getGuildNumber();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    /* synthetic */ ArrayList<IGProGuildChannelState> getGuildStates();

    String getHeadUrl();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    /* synthetic */ ArrayList<String> getHighlightWords();

    String getJoinGuildSig();

    int getJoinedGuild();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    ArrayList<IGProRecommendLabel> getLabelList();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    ArrayList<IGProMedalInfo> getMedalInfoList();

    int getMedalLevel();

    String getName();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    /* synthetic */ IGProRecommendLabel getPeopleLabel();

    String getProfile();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    /* synthetic */ ArrayList<IGProSearchRankInfo> getRankList();

    IRecallInfo getRecallInfo();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    /* synthetic */ IGProRecommendLabel getRecommendReason();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    /* synthetic */ int getShowType();

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchInfo
    /* synthetic */ IGProSuggestedSearch getSuggestedSearchInfo();

    ArrayList<String> getTags();
}
