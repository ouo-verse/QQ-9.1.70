package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUnionSearchResult {
    public long feedInfoTotalCount;
    public long guildInfoTotalCount;
    public long liveInfoTotalCount;
    public long scheduleInfoTotalCount;
    public int version;
    public ArrayList<GProGuildSearchInfo> guildInfoList = new ArrayList<>();
    public byte[] guildInfoCookie = new byte[0];
    public ArrayList<GProFeedSearchInfo> feedInfoList = new ArrayList<>();
    public byte[] feedInfoCookie = new byte[0];
    public ArrayList<GProLiveSearchInfo> liveInfoList = new ArrayList<>();
    public byte[] liveInfoCookie = new byte[0];
    public ArrayList<GProScheduleSearchInfo> scheduleInfoList = new ArrayList<>();
    public byte[] scheduleInfoCookie = new byte[0];
    public ArrayList<GProGuildSearchInfo> guildRcdInfoList = new ArrayList<>();
    public byte[] guildRcdInfoCookie = new byte[0];
    public GProSuggestedSearch suggestedContent = new GProSuggestedSearch();

    public byte[] getFeedInfoCookie() {
        return this.feedInfoCookie;
    }

    public ArrayList<GProFeedSearchInfo> getFeedInfoList() {
        return this.feedInfoList;
    }

    public long getFeedInfoTotalCount() {
        return this.feedInfoTotalCount;
    }

    public byte[] getGuildInfoCookie() {
        return this.guildInfoCookie;
    }

    public ArrayList<GProGuildSearchInfo> getGuildInfoList() {
        return this.guildInfoList;
    }

    public long getGuildInfoTotalCount() {
        return this.guildInfoTotalCount;
    }

    public byte[] getGuildRcdInfoCookie() {
        return this.guildRcdInfoCookie;
    }

    public ArrayList<GProGuildSearchInfo> getGuildRcdInfoList() {
        return this.guildRcdInfoList;
    }

    public byte[] getLiveInfoCookie() {
        return this.liveInfoCookie;
    }

    public ArrayList<GProLiveSearchInfo> getLiveInfoList() {
        return this.liveInfoList;
    }

    public long getLiveInfoTotalCount() {
        return this.liveInfoTotalCount;
    }

    public byte[] getScheduleInfoCookie() {
        return this.scheduleInfoCookie;
    }

    public ArrayList<GProScheduleSearchInfo> getScheduleInfoList() {
        return this.scheduleInfoList;
    }

    public long getScheduleInfoTotalCount() {
        return this.scheduleInfoTotalCount;
    }

    public GProSuggestedSearch getSuggestedContent() {
        return this.suggestedContent;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        return "GProUnionSearchResult{guildInfoTotalCount=" + this.guildInfoTotalCount + ",guildInfoList=" + this.guildInfoList + ",guildInfoCookie=" + this.guildInfoCookie + ",feedInfoTotalCount=" + this.feedInfoTotalCount + ",feedInfoList=" + this.feedInfoList + ",feedInfoCookie=" + this.feedInfoCookie + ",liveInfoTotalCount=" + this.liveInfoTotalCount + ",liveInfoList=" + this.liveInfoList + ",liveInfoCookie=" + this.liveInfoCookie + ",scheduleInfoTotalCount=" + this.scheduleInfoTotalCount + ",scheduleInfoList=" + this.scheduleInfoList + ",scheduleInfoCookie=" + this.scheduleInfoCookie + ",guildRcdInfoList=" + this.guildRcdInfoList + ",guildRcdInfoCookie=" + this.guildRcdInfoCookie + ",suggestedContent=" + this.suggestedContent + MttLoader.QQBROWSER_PARAMS_VERSION + this.version + ",}";
    }
}
