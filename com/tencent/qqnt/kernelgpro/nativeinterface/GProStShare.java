package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.mobileqq.haoliyou.JefsClass;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStShare implements Serializable {
    public int contentType;
    public int publishTotalUser;
    public int sharedCount;
    public int type;
    long serialVersionUID = 1;
    public String title = "";
    public String desc = "";
    public String url = "";
    public GProStUser author = new GProStUser();
    public GProStUser poster = new GProStUser();
    public ArrayList<GProStVideo> videos = new ArrayList<>();
    public String shorturl = "";
    public String shareCardInfo = "";
    public GProStShareQzoneInfo shareQzoneInfo = new GProStShareQzoneInfo();
    public ArrayList<GProStImage> images = new ArrayList<>();
    public GProStChannelShareInfo channelShareInfo = new GProStChannelShareInfo();

    public GProStUser getAuthor() {
        return this.author;
    }

    public GProStChannelShareInfo getChannelShareInfo() {
        return this.channelShareInfo;
    }

    public int getContentType() {
        return this.contentType;
    }

    public String getDesc() {
        return this.desc;
    }

    public ArrayList<GProStImage> getImages() {
        return this.images;
    }

    public GProStUser getPoster() {
        return this.poster;
    }

    public int getPublishTotalUser() {
        return this.publishTotalUser;
    }

    public String getShareCardInfo() {
        return this.shareCardInfo;
    }

    public GProStShareQzoneInfo getShareQzoneInfo() {
        return this.shareQzoneInfo;
    }

    public int getSharedCount() {
        return this.sharedCount;
    }

    public String getShorturl() {
        return this.shorturl;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public ArrayList<GProStVideo> getVideos() {
        return this.videos;
    }

    public String toString() {
        return "GProStShare{title=" + this.title + ",desc=" + this.desc + ",type=" + this.type + JefsClass.INDEX_URL + this.url + ",author=" + this.author + ",poster=" + this.poster + ",videos=" + this.videos + ",shorturl=" + this.shorturl + ",shareCardInfo=" + this.shareCardInfo + ",shareQzoneInfo=" + this.shareQzoneInfo + ",images=" + this.images + ",publishTotalUser=" + this.publishTotalUser + ",sharedCount=" + this.sharedCount + ",channelShareInfo=" + this.channelShareInfo + ",contentType=" + this.contentType + ",}";
    }
}
