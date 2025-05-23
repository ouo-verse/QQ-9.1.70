package org.light.lightAssetKit.components;

import java.util.ArrayList;
import java.util.Arrays;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BodyTracking extends TrackingComponent {
    private boolean isDetectSmooth = false;
    private ArrayList<Integer> bodyIndex = new ArrayList<>(Arrays.asList(0));

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.TrackingComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof BodyTracking) {
            BodyTracking bodyTracking = (BodyTracking) componentBase;
            this.isDetectSmooth = bodyTracking.isDetectSmooth;
            this.bodyIndex = bodyTracking.bodyIndex;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<Integer> getBodyIndex() {
        return this.bodyIndex;
    }

    public boolean getIsDetectSmooth() {
        return this.isDetectSmooth;
    }

    public void setBodyIndex(ArrayList<Integer> arrayList) {
        this.bodyIndex = arrayList;
        reportPropertyChange("bodyIndex", arrayList);
    }

    public void setIsDetectSmooth(boolean z16) {
        this.isDetectSmooth = z16;
        reportPropertyChange("isDetectSmooth", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.TrackingComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "BodyTracking";
    }
}
