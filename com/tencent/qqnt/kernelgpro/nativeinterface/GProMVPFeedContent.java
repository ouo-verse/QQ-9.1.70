package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMVPFeedContent {
    public boolean needWebview;
    public int totalImageCount;
    public int totalVideoCount;
    public GProMVPRichText richText = new GProMVPRichText();
    public ArrayList<GProMVPImage> images = new ArrayList<>();
    public ArrayList<GProMVPVideo> videos = new ArrayList<>();
    public String summary = "";
    public String defaultBackgroundImg = "";
    public GProMVPImage cover = new GProMVPImage();
    public GProMVPBusinessCard businessCard = new GProMVPBusinessCard();

    public GProMVPBusinessCard getBusinessCard() {
        return this.businessCard;
    }

    public GProMVPImage getCover() {
        return this.cover;
    }

    public String getDefaultBackgroundImg() {
        return this.defaultBackgroundImg;
    }

    public ArrayList<GProMVPImage> getImages() {
        return this.images;
    }

    public boolean getNeedWebview() {
        return this.needWebview;
    }

    public GProMVPRichText getRichText() {
        return this.richText;
    }

    public String getSummary() {
        return this.summary;
    }

    public int getTotalImageCount() {
        return this.totalImageCount;
    }

    public int getTotalVideoCount() {
        return this.totalVideoCount;
    }

    public ArrayList<GProMVPVideo> getVideos() {
        return this.videos;
    }

    public String toString() {
        return "GProMVPFeedContent{richText=" + this.richText + ",images=" + this.images + ",videos=" + this.videos + ",totalImageCount=" + this.totalImageCount + ",totalVideoCount=" + this.totalVideoCount + ",summary=" + this.summary + ",defaultBackgroundImg=" + this.defaultBackgroundImg + ",cover=" + this.cover + ",businessCard=" + this.businessCard + ",needWebview=" + this.needWebview + ",}";
    }
}
