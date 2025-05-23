package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProUserLiveRoomInfo {
    public String coverUrl;
    public String title;

    public GProUserLiveRoomInfo() {
        this.title = "";
        this.coverUrl = "";
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProUserLiveRoomInfo{title=" + this.title + ",coverUrl=" + this.coverUrl + ",}";
    }

    public GProUserLiveRoomInfo(String str, String str2) {
        this.title = str;
        this.coverUrl = str2;
    }
}
