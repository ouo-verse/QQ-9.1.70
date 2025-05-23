package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProVideo implements Serializable {
    public GProImage cover;
    public int displayIndex;
    public int duration;
    public String fileId;
    public int fileSize;
    public int height;
    public String playUrl;
    public int prior;
    public int rate;
    long serialVersionUID;
    public ArrayList<GProTransVideo> transVideos;
    public int width;

    public GProVideo() {
        this.serialVersionUID = 1L;
        this.playUrl = "";
        this.cover = new GProImage();
        this.transVideos = new ArrayList<>();
        this.fileId = "";
    }

    public GProImage getCover() {
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

    public ArrayList<GProTransVideo> getTransVideos() {
        return this.transVideos;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "GProVideo{fileSize=" + this.fileSize + ",duration=" + this.duration + ",width=" + this.width + ",height=" + this.height + ",playUrl=" + this.playUrl + ",prior=" + this.prior + ",rate=" + this.rate + ",cover=" + this.cover + ",displayIndex=" + this.displayIndex + ",transVideos=" + this.transVideos + ",fileId=" + this.fileId + ",}";
    }

    public GProVideo(int i3, int i16, int i17, int i18, String str, int i19, int i26, GProImage gProImage, int i27, ArrayList<GProTransVideo> arrayList, String str2) {
        this.serialVersionUID = 1L;
        this.playUrl = "";
        this.cover = new GProImage();
        new ArrayList();
        this.fileSize = i3;
        this.duration = i16;
        this.width = i17;
        this.height = i18;
        this.playUrl = str;
        this.prior = i19;
        this.rate = i26;
        this.cover = gProImage;
        this.displayIndex = i27;
        this.transVideos = arrayList;
        this.fileId = str2;
    }
}
