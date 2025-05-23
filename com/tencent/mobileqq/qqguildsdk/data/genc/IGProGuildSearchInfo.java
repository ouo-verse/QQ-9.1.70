package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IRecallInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildSearchInfo extends Serializable {
    String getCoverUrl();

    long getGuildIdLong();

    String getGuildNumber();

    ArrayList<IGProGuildChannelState> getGuildStates();

    String getHeadUrl();

    ArrayList<String> getHighlightWords();

    String getJoinGuildSig();

    int getJoinedGuild();

    ArrayList<IGProRecommendLabel> getLabelList();

    ArrayList<IGProMedalInfo> getMedalInfoList();

    int getMedalLevel();

    String getName();

    IGProRecommendLabel getPeopleLabel();

    String getProfile();

    ArrayList<IGProSearchRankInfo> getRankList();

    IRecallInfo getRecallInfo();

    IGProRecommendLabel getRecommendReason();

    int getShowType();

    IGProSuggestedSearch getSuggestedSearchInfo();

    ArrayList<String> getTags();

    String toString();
}
