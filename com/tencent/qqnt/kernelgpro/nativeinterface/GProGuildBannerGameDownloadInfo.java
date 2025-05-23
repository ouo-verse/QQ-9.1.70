package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildBannerGameDownloadInfo implements Serializable {
    long serialVersionUID = 1;
    public String gameId = "";
    public String title = "";
    public String content = "";
    public ArrayList<String> picUrl = new ArrayList<>();
    public ArrayList<GProGameDownloadLink> links = new ArrayList<>();
    public String jumpText = "";
    public String tagText = "";

    public String getContent() {
        return this.content;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getJumpText() {
        return this.jumpText;
    }

    public ArrayList<GProGameDownloadLink> getLinks() {
        return this.links;
    }

    public ArrayList<String> getPicUrl() {
        return this.picUrl;
    }

    public String getTagText() {
        return this.tagText;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProGuildBannerGameDownloadInfo{gameId=" + this.gameId + ",title=" + this.title + ",content=" + this.content + ",picUrl=" + this.picUrl + ",links=" + this.links + ",jumpText=" + this.jumpText + ",tagText=" + this.tagText + ",}";
    }
}
