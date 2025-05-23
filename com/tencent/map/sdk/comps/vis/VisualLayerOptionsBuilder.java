package com.tencent.map.sdk.comps.vis;

import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Builder;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VisualLayerOptionsBuilder implements Builder<VisualLayerOptions> {
    protected final VisualLayerOptions mLayerOptions;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VisualLayerOptionsBuilder(VisualLayerOptions visualLayerOptions) {
        this.mLayerOptions = visualLayerOptions;
    }

    public VisualLayerOptionsBuilder setAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.mLayerOptions.mAlpha = f16;
        return this;
    }

    public VisualLayerOptionsBuilder setClickEnable(boolean z16) {
        this.mLayerOptions.mClickEnabled = z16;
        return this;
    }

    public VisualLayerOptionsBuilder setLevel(int i3) {
        this.mLayerOptions.mLevel = i3;
        return this;
    }

    public VisualLayerOptionsBuilder setTimeInterval(@IntRange(from = 15) int i3) {
        this.mLayerOptions.mTimeInternal = i3;
        return this;
    }

    public VisualLayerOptionsBuilder setZIndex(int i3) {
        this.mLayerOptions.mZIndex = i3;
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Builder
    public VisualLayerOptions build() {
        return this.mLayerOptions;
    }
}
