package com.tencent.map.sdk.comps.vis;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Options;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VisualLayerOptions implements Options<VisualLayerOptions, VisualLayerOptionsBuilder> {
    String mLayerId;
    int mZIndex;
    int mLevel = 1;
    int mTimeInternal = 0;
    float mAlpha = 1.0f;
    boolean mIsVisible = true;
    boolean mClickEnabled = false;

    public VisualLayerOptions(String str) {
        this.mLayerId = str;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public String getLayerId() {
        return this.mLayerId;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public int getTimeInterval() {
        return this.mTimeInternal;
    }

    public int getZIndex() {
        return this.mZIndex;
    }

    public boolean isClickEnabled() {
        return this.mClickEnabled;
    }

    public boolean isVisible() {
        return this.mIsVisible;
    }

    public String toString() {
        return "VisualLayerOptions{mLayerId='" + this.mLayerId + "', mLevel=" + this.mLevel + ", mZIndex=" + this.mZIndex + ", mTimeInternal=" + this.mTimeInternal + ", mAlpha=" + this.mAlpha + ", mIsVisible=" + this.mIsVisible + ", mClickEnabled=" + this.mClickEnabled + '}';
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Options
    public VisualLayerOptionsBuilder newBuilder() {
        return new VisualLayerOptionsBuilder(this);
    }
}
