package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMVPVideo {
    public int displayIndex;
    public int duration;
    public int fileSize;
    public int height;
    public int prior;
    public int rate;
    public int width;
    public String playUrl = "";
    public GProMVPImage cover = new GProMVPImage();
    public ArrayList<GProMVPTransVideo> transVideos = new ArrayList<>();
    public String fileId = "";

    public GProMVPImage getCover() {
        return this.cover;
    }

    public int getDisplayIndex() {
        return this.displayIndex;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getFileId() {
        return this.fileId;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public int getHeight() {
        return this.height;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public int getPrior() {
        return this.prior;
    }

    public int getRate() {
        return this.rate;
    }

    public ArrayList<GProMVPTransVideo> getTransVideos() {
        return this.transVideos;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProMVPVideo{fileSize=" + this.fileSize + ",duration=" + this.duration + ",width=" + this.width + ",height=" + this.height + ",playUrl=" + this.playUrl + ",prior=" + this.prior + ",rate=" + this.rate + ",cover=" + this.cover + ",displayIndex=" + this.displayIndex + ",transVideos=" + this.transVideos + ",fileId=" + this.fileId + ",}";
    }
}
