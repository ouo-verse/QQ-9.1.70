package com.qzone.preview.service;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAlbumMediaRequestBuilder {
    public boolean isExpose;
    public int localType = 0;
    public int remoteType = 0;
    public String traceInfo = "";
    public String uin = "";
    public String videoShareUrl = "";
    public String videoDownloadUrl = "";

    public QZoneAlbumMediaRequestBuilder setIsExpose(boolean z16) {
        this.isExpose = z16;
        return this;
    }

    public QZoneAlbumMediaRequestBuilder setLocalType(int i3) {
        this.localType = i3;
        return this;
    }

    public QZoneAlbumMediaRequestBuilder setRemoteType(int i3) {
        this.remoteType = i3;
        return this;
    }

    public QZoneAlbumMediaRequestBuilder setTraceInfo(String str) {
        this.traceInfo = str;
        return this;
    }

    public QZoneAlbumMediaRequestBuilder setUin(String str) {
        this.uin = str;
        return this;
    }

    public QZoneAlbumMediaRequestBuilder setVideoDownloadUrl(String str) {
        this.videoDownloadUrl = str;
        return this;
    }

    public QZoneAlbumMediaRequestBuilder setVideoShareUrl(String str) {
        this.videoShareUrl = str;
        return this;
    }
}
