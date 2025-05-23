package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsSearchMainGuildChannelItem {
    public long guildId;
    public long guildOwnerUin;
    public int joinStatus;
    public int status;
    public String coverUrl = "";
    public String title = "";
    public String subTitle = "";
    public ArrayList<String> icons = new ArrayList<>();
    public ArrayList<UfsLabel> topLabelList = new ArrayList<>();
    public ArrayList<UfsLabel> bottomLabelList = new ArrayList<>();
    public String joinGuildSig = "";
    public String query = "";
    public ArrayList<UfsLabel> mixedLabelList = new ArrayList<>();

    public ArrayList<UfsLabel> getBottomLabelList() {
        return this.bottomLabelList;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getGuildOwnerUin() {
        return this.guildOwnerUin;
    }

    public ArrayList<String> getIcons() {
        return this.icons;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinStatus() {
        return this.joinStatus;
    }

    public ArrayList<UfsLabel> getMixedLabelList() {
        return this.mixedLabelList;
    }

    public String getQuery() {
        return this.query;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<UfsLabel> getTopLabelList() {
        return this.topLabelList;
    }

    public String toString() {
        return "UfsSearchMainGuildChannelItem{status=" + this.status + ",coverUrl=" + this.coverUrl + ",title=" + this.title + ",subTitle=" + this.subTitle + ",icons=" + this.icons + ",topLabelList=" + this.topLabelList + ",bottomLabelList=" + this.bottomLabelList + ",guildId=" + this.guildId + ",guildOwnerUin=" + this.guildOwnerUin + ",joinGuildSig=" + this.joinGuildSig + ",query=" + this.query + ",joinStatus=" + this.joinStatus + ",mixedLabelList=" + this.mixedLabelList + ",}";
    }
}
