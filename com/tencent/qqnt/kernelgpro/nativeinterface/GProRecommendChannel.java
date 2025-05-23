package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendChannel implements Serializable {
    public long channelId;
    public String coverUrl;
    public String icon;
    public String joinGuildSig;
    public int joinedGuild;
    public String name;
    public String profile;
    long serialVersionUID;
    public ArrayList<GProGuildChannelState> stateList;
    public ArrayList<String> tagList;

    public GProRecommendChannel() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.profile = "";
        this.icon = "";
        this.stateList = new ArrayList<>();
        this.tagList = new ArrayList<>();
        this.coverUrl = "";
        this.joinGuildSig = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinedGuild() {
        return this.joinedGuild;
    }

    public String getName() {
        return this.name;
    }

    public String getProfile() {
        return this.profile;
    }

    public ArrayList<GProGuildChannelState> getStateList() {
        return this.stateList;
    }

    public ArrayList<String> getTagList() {
        return this.tagList;
    }

    public String toString() {
        return "GProRecommendChannel{channelId=" + this.channelId + ",name=" + this.name + ",profile=" + this.profile + ",icon=" + this.icon + ",stateList=" + this.stateList + ",tagList=" + this.tagList + ",joinedGuild=" + this.joinedGuild + ",coverUrl=" + this.coverUrl + ",joinGuildSig=" + this.joinGuildSig + ",}";
    }

    public GProRecommendChannel(long j3, String str, String str2, String str3, ArrayList<GProGuildChannelState> arrayList, ArrayList<String> arrayList2, int i3, String str4, String str5) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.profile = "";
        this.icon = "";
        this.stateList = new ArrayList<>();
        new ArrayList();
        this.channelId = j3;
        this.name = str;
        this.profile = str2;
        this.icon = str3;
        this.stateList = arrayList;
        this.tagList = arrayList2;
        this.joinedGuild = i3;
        this.coverUrl = str4;
        this.joinGuildSig = str5;
    }
}
