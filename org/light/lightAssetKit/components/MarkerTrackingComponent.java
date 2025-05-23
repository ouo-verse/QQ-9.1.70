package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MarkerTrackingComponent extends Component {
    private String imageMarker = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MarkerTrackingComponent) {
            this.imageMarker = ((MarkerTrackingComponent) componentBase).imageMarker;
        }
        super.doUpdate(componentBase);
    }

    public String getImageMarker() {
        return this.imageMarker;
    }

    public void setImageMarker(String str) {
        this.imageMarker = str;
        reportPropertyChange("imageMarker", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MarkerTrackingComponent";
    }
}
