package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.poi;

import com.tencent.kuikly.core.base.w;

/* loaded from: classes31.dex */
public final class NBPPOIMarkerUIConfig {
    public final float focusedScale;
    public final float height;
    public final w size;
    public final float targetXPercent;
    public final float targetYPercent;
    public final int titleLines;
    public final float width;

    public NBPPOIMarkerUIConfig(boolean z16) {
        float f16 = z16 ? 122.0f : 146.0f;
        this.width = f16;
        this.height = 61.0f;
        this.size = new w(f16, 61.0f);
        this.titleLines = 2;
        this.targetXPercent = 0.5f;
        this.targetYPercent = 1.0f;
        this.focusedScale = 1.25f;
    }

    public final float getFocusedScale() {
        return this.focusedScale;
    }

    public final float getTargetXPercent() {
        return this.targetXPercent;
    }

    public final float getTargetYPercent() {
        return this.targetYPercent;
    }
}
