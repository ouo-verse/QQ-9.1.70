package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendMyFeed implements Serializable {
    public byte[] data;
    public GProPosterInfo poster;
    long serialVersionUID;
    public GProRecommendFeedShareInfo shareInfo;

    public GProRecommendMyFeed() {
        this.serialVersionUID = 1L;
        this.data = new byte[0];
        this.shareInfo = new GProRecommendFeedShareInfo();
        this.poster = new GProPosterInfo();
    }

    public byte[] getData() {
        return this.data;
    }

    public GProPosterInfo getPoster() {
        return this.poster;
    }

    public GProRecommendFeedShareInfo getShareInfo() {
        return this.shareInfo;
    }

    public String toString() {
        return "GProRecommendMyFeed{data=" + this.data + ",shareInfo=" + this.shareInfo + ",poster=" + this.poster + ",}";
    }

    public GProRecommendMyFeed(byte[] bArr, GProRecommendFeedShareInfo gProRecommendFeedShareInfo, GProPosterInfo gProPosterInfo) {
        this.serialVersionUID = 1L;
        this.data = new byte[0];
        this.shareInfo = new GProRecommendFeedShareInfo();
        new GProPosterInfo();
        this.data = bArr;
        this.shareInfo = gProRecommendFeedShareInfo;
        this.poster = gProPosterInfo;
    }
}
