package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* loaded from: classes29.dex */
public class PreferredCoverTime extends Component {
    private long coverTime = 0;
    private float coverTimePercent = -1.0f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof PreferredCoverTime) {
            PreferredCoverTime preferredCoverTime = (PreferredCoverTime) componentBase;
            this.coverTime = preferredCoverTime.coverTime;
            this.coverTimePercent = preferredCoverTime.coverTimePercent;
        }
        super.doUpdate(componentBase);
    }

    public long getCoverTime() {
        return this.coverTime;
    }

    public float getCoverTimePercent() {
        return this.coverTimePercent;
    }

    public void setCoverTime(long j3) {
        this.coverTime = j3;
        reportPropertyChange("coverTime", Long.valueOf(j3));
    }

    public void setCoverTimePercent(float f16) {
        this.coverTimePercent = f16;
        reportPropertyChange("coverTimePercent", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "PreferredCoverTime";
    }
}
