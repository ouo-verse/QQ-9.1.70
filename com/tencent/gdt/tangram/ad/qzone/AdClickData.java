package com.tencent.gdt.tangram.ad.qzone;

import android.view.View;
import com.qzone.commoncode.module.videorecommend.model.VideoRecommendInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdClickData {

    /* renamed from: a, reason: collision with root package name */
    private Object f108397a;

    /* renamed from: b, reason: collision with root package name */
    private BusinessFeedData f108398b;

    /* renamed from: c, reason: collision with root package name */
    private View f108399c;

    /* renamed from: d, reason: collision with root package name */
    private FeedElement f108400d;

    /* renamed from: e, reason: collision with root package name */
    private int f108401e;

    /* renamed from: f, reason: collision with root package name */
    private Object f108402f;

    /* renamed from: g, reason: collision with root package name */
    private int f108403g;

    /* renamed from: h, reason: collision with root package name */
    private int f108404h;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static class Builder {
        Object args;
        Object component;
        FeedElement element;
        BusinessFeedData feedData;
        int feedIndex;
        VideoRecommendInfo videoRecommendInfo;
        View view;
        int areaId = 0;
        int sceneId = -1;

        public AdClickData create() {
            VideoRecommendInfo videoRecommendInfo;
            AdClickData adClickData = new AdClickData();
            adClickData.f108402f = this.args;
            adClickData.f108397a = this.component;
            adClickData.f108400d = this.element;
            adClickData.f108398b = this.feedData;
            adClickData.f108399c = this.view;
            adClickData.f108401e = this.feedIndex;
            adClickData.f108403g = this.areaId;
            adClickData.f108404h = this.sceneId;
            if (this.feedData == null && (videoRecommendInfo = this.videoRecommendInfo) != null) {
                adClickData.f108398b = BusinessFeedData.createBusinessFeedData(videoRecommendInfo);
            }
            return adClickData;
        }

        public Builder setAreaId(int i3) {
            this.areaId = i3;
            return this;
        }

        public Builder setArgs(Object obj) {
            this.args = obj;
            return this;
        }

        public Builder setContext(Object obj) {
            this.component = obj;
            return this;
        }

        public Builder setFeedData(BusinessFeedData businessFeedData) {
            this.feedData = businessFeedData;
            return this;
        }

        public Builder setFeedElement(FeedElement feedElement) {
            this.element = feedElement;
            return this;
        }

        public Builder setFeedIndex(int i3) {
            this.feedIndex = i3;
            return this;
        }

        public Builder setSceneId(int i3) {
            this.sceneId = i3;
            return this;
        }

        public Builder setVideoRecommendInfo(VideoRecommendInfo videoRecommendInfo) {
            this.videoRecommendInfo = videoRecommendInfo;
            return this;
        }

        public Builder setView(View view) {
            this.view = view;
            return this;
        }
    }

    public int i() {
        return this.f108403g;
    }

    public Object j() {
        return this.f108402f;
    }

    public Object k() {
        return this.f108397a;
    }

    public FeedElement l() {
        return this.f108400d;
    }

    public BusinessFeedData m() {
        return this.f108398b;
    }

    public int n() {
        return this.f108401e;
    }

    public int o() {
        return this.f108404h;
    }

    public View p() {
        return this.f108399c;
    }

    public boolean q() {
        BusinessFeedData businessFeedData = this.f108398b;
        return businessFeedData != null && businessFeedData.isCornerAdv() && this.f108403g == 5;
    }

    public boolean r() {
        BusinessFeedData businessFeedData;
        return s() || q() || ((businessFeedData = this.f108398b) != null && businessFeedData.isGDTAdvFeed());
    }

    public boolean s() {
        BusinessFeedData businessFeedData = this.f108398b;
        return businessFeedData != null && businessFeedData.isWindowAd() && this.f108403g == 31;
    }

    AdClickData() {
        this.f108403g = 0;
        this.f108404h = -1;
    }
}
