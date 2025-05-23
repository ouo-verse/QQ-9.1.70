package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StVideo {
    public StImage cover;
    public int height;

    /* renamed from: id, reason: collision with root package name */
    public String f359227id;
    public String url;
    public long videoTime;
    public ArrayList<StPicSpecUrlEntry> videoUrl;
    public int width;

    public StVideo() {
        this.f359227id = "";
        this.url = "";
        this.cover = new StImage();
        this.videoUrl = new ArrayList<>();
    }

    public StImage getCover() {
        return this.cover;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f359227id;
    }

    public String getUrl() {
        return this.url;
    }

    public long getVideoTime() {
        return this.videoTime;
    }

    public ArrayList<StPicSpecUrlEntry> getVideoUrl() {
        return this.videoUrl;
    }

    public int getWidth() {
        return this.width;
    }

    public void setCover(StImage stImage) {
        this.cover = stImage;
    }

    public void setHeight(int i3) {
        this.height = i3;
    }

    public void setId(String str) {
        this.f359227id = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVideoTime(long j3) {
        this.videoTime = j3;
    }

    public void setVideoUrl(ArrayList<StPicSpecUrlEntry> arrayList) {
        this.videoUrl = arrayList;
    }

    public void setWidth(int i3) {
        this.width = i3;
    }

    public StVideo(String str, String str2, StImage stImage, int i3, int i16, long j3, ArrayList<StPicSpecUrlEntry> arrayList) {
        this.f359227id = "";
        this.url = "";
        this.cover = new StImage();
        new ArrayList();
        this.f359227id = str;
        this.url = str2;
        this.cover = stImage;
        this.width = i3;
        this.height = i16;
        this.videoTime = j3;
        this.videoUrl = arrayList;
    }
}
