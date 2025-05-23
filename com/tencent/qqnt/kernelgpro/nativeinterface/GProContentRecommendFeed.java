package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProContentRecommendFeed implements Serializable {
    public int auditStatus;
    public GProMVPBusinessCard businessCard;
    public long createTime;
    public GProImage customCover;
    public int feedContentType;
    public GProFeedStat feedStat;
    public int feedType;
    public ArrayList<Integer> functionList;
    public GProFeedGuildInfo guildInfo;
    public String idd;
    public GProImage image;
    public long lastModifiedTime;
    public boolean needWebview;
    public GProPoster poster;
    public GProMVPRichText richText;
    long serialVersionUID;
    public ArrayList<GProGuildLabel> tags;
    public String title;
    public int totalImageCount;
    public ArrayList<GProVideo> videos;

    public GProContentRecommendFeed() {
        this.serialVersionUID = 1L;
        this.idd = "";
        this.title = "";
        this.image = new GProImage();
        this.videos = new ArrayList<>();
        this.feedStat = new GProFeedStat();
        this.guildInfo = new GProFeedGuildInfo();
        this.poster = new GProPoster();
        this.richText = new GProMVPRichText();
        this.customCover = new GProImage();
        this.businessCard = new GProMVPBusinessCard();
        this.functionList = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public int getAuditStatus() {
        return this.auditStatus;
    }

    public GProMVPBusinessCard getBusinessCard() {
        return this.businessCard;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public GProImage getCustomCover() {
        return this.customCover;
    }

    public int getFeedContentType() {
        return this.feedContentType;
    }

    public GProFeedStat getFeedStat() {
        return this.feedStat;
    }

    public int getFeedType() {
        return this.feedType;
    }

    public ArrayList<Integer> getFunctionList() {
        return this.functionList;
    }

    public GProFeedGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public String getIdd() {
        return this.idd;
    }

    public GProImage getImage() {
        return this.image;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public boolean getNeedWebview() {
        return this.needWebview;
    }

    public GProPoster getPoster() {
        return this.poster;
    }

    public GProMVPRichText getRichText() {
        return this.richText;
    }

    public ArrayList<GProGuildLabel> getTags() {
        return this.tags;
    }

    public String getTitle() {
        return this.title;
    }

    public int getTotalImageCount() {
        return this.totalImageCount;
    }

    public ArrayList<GProVideo> getVideos() {
        return this.videos;
    }

    public String toString() {
        return "GProContentRecommendFeed{idd=" + this.idd + ",title=" + this.title + ",image=" + this.image + ",videos=" + this.videos + ",feedStat=" + this.feedStat + ",guildInfo=" + this.guildInfo + ",feedType=" + this.feedType + ",feedContentType=" + this.feedContentType + ",poster=" + this.poster + ",createTime=" + this.createTime + ",richText=" + this.richText + ",lastModifiedTime=" + this.lastModifiedTime + ",totalImageCount=" + this.totalImageCount + ",customCover=" + this.customCover + ",businessCard=" + this.businessCard + ",functionList=" + this.functionList + ",tags=" + this.tags + ",auditStatus=" + this.auditStatus + ",needWebview=" + this.needWebview + ",}";
    }

    public GProContentRecommendFeed(String str, String str2, GProImage gProImage, ArrayList<GProVideo> arrayList, GProFeedStat gProFeedStat, GProFeedGuildInfo gProFeedGuildInfo, int i3, int i16, GProPoster gProPoster, long j3, GProMVPRichText gProMVPRichText, long j16, int i17, GProImage gProImage2, boolean z16) {
        this.serialVersionUID = 1L;
        this.idd = "";
        this.title = "";
        this.image = new GProImage();
        this.videos = new ArrayList<>();
        this.feedStat = new GProFeedStat();
        this.guildInfo = new GProFeedGuildInfo();
        this.poster = new GProPoster();
        this.richText = new GProMVPRichText();
        this.customCover = new GProImage();
        this.businessCard = new GProMVPBusinessCard();
        this.functionList = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.idd = str;
        this.title = str2;
        this.image = gProImage;
        this.videos = arrayList;
        this.feedStat = gProFeedStat;
        this.guildInfo = gProFeedGuildInfo;
        this.feedType = i3;
        this.feedContentType = i16;
        this.poster = gProPoster;
        this.createTime = j3;
        this.richText = gProMVPRichText;
        this.lastModifiedTime = j16;
        this.totalImageCount = i17;
        this.customCover = gProImage2;
        this.needWebview = z16;
    }
}
