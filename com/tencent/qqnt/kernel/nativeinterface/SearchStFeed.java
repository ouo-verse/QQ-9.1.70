package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchStFeed {
    public SearchStImage cover = new SearchStImage();
    public SearchStVideo video = new SearchStVideo();

    public SearchStImage getCover() {
        return this.cover;
    }

    public SearchStVideo getVideo() {
        return this.video;
    }

    public String toString() {
        return "SearchStFeed{cover=" + this.cover + ",video=" + this.video + ",}";
    }
}
