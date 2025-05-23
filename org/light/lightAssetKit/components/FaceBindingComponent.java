package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.BindTrackingType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FaceBindingComponent extends Component {
    private BindTrackingType trackingType = BindTrackingType.kFaceBindTypeFace;
    private Vec3 posOffset = new Vec3();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof FaceBindingComponent) {
            FaceBindingComponent faceBindingComponent = (FaceBindingComponent) componentBase;
            this.trackingType = faceBindingComponent.trackingType;
            this.posOffset = faceBindingComponent.posOffset;
        }
        super.doUpdate(componentBase);
    }

    public Vec3 getPosOffset() {
        return this.posOffset;
    }

    public BindTrackingType getTrackingType() {
        return this.trackingType;
    }

    public void setPosOffset(Vec3 vec3) {
        this.posOffset = vec3;
        reportPropertyChange("posOffset", vec3);
    }

    public void setTrackingType(BindTrackingType bindTrackingType) {
        this.trackingType = bindTrackingType;
        reportPropertyChange("trackingType", bindTrackingType);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "FaceBindingComponent";
    }
}
