package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildSearchInfo {
    public long guildId;
    public int joinedGuild;
    public int medalLevel;
    public int showType;
    public String name = "";
    public String profile = "";
    public String coverUrl = "";
    public String joinGuildSig = "";
    public String headUrl = "";
    public ArrayList<GProGuildChannelState> guildStates = new ArrayList<>();
    public ArrayList<String> tags = new ArrayList<>();
    public String guildNumber = "";
    public GProRecallInfo recallInfo = new GProRecallInfo();
    public ArrayList<GProMedalInfo> medalInfoList = new ArrayList<>();
    public ArrayList<GProRecommendLabel> labelList = new ArrayList<>();
    public ArrayList<GProSearchRankInfo> rankList = new ArrayList<>();
    public GProRecommendLabel peopleLabel = new GProRecommendLabel();
    public GProRecommendLabel recommendReason = new GProRecommendLabel();
    public ArrayList<String> highlightWords = new ArrayList<>();
    public GProSuggestedSearch suggestedSearchInfo = new GProSuggestedSearch();

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildNumber() {
        return this.guildNumber;
    }

    public ArrayList<GProGuildChannelState> getGuildStates() {
        return this.guildStates;
    }

    public String getHeadUrl() {
        return this.headUrl;
    }

    public ArrayList<String> getHighlightWords() {
        return this.highlightWords;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinedGuild() {
        return this.joinedGuild;
    }

    public ArrayList<GProRecommendLabel> getLabelList() {
        return this.labelList;
    }

    public ArrayList<GProMedalInfo> getMedalInfoList() {
        return this.medalInfoList;
    }

    public int getMedalLevel() {
        return this.medalLevel;
    }

    public String getName() {
        return this.name;
    }

    public GProRecommendLabel getPeopleLabel() {
        return this.peopleLabel;
    }

    public String getProfile() {
        return this.profile;
    }

    public ArrayList<GProSearchRankInfo> getRankList() {
        return this.rankList;
    }

    public GProRecallInfo getRecallInfo() {
        return this.recallInfo;
    }

    public GProRecommendLabel getRecommendReason() {
        return this.recommendReason;
    }

    public int getShowType() {
        return this.showType;
    }

    public GProSuggestedSearch getSuggestedSearchInfo() {
        return this.suggestedSearchInfo;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public String toString() {
        return "GProGuildSearchInfo{joinedGuild=" + this.joinedGuild + ",name=" + this.name + ",profile=" + this.profile + ",coverUrl=" + this.coverUrl + ",joinGuildSig=" + this.joinGuildSig + ",guildId=" + this.guildId + ",headUrl=" + this.headUrl + ",guildStates=" + this.guildStates + ",tags=" + this.tags + ",guildNumber=" + this.guildNumber + ",recallInfo=" + this.recallInfo + ",medalLevel=" + this.medalLevel + ",medalInfoList=" + this.medalInfoList + ",labelList=" + this.labelList + ",rankList=" + this.rankList + ",peopleLabel=" + this.peopleLabel + ",recommendReason=" + this.recommendReason + ",highlightWords=" + this.highlightWords + ",suggestedSearchInfo=" + this.suggestedSearchInfo + ",showType=" + this.showType + ",}";
    }
}
