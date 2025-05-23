package org.light.lightAssetKit.components;

import com.tencent.hippy.qq.view.gridview.HippyQQDragGridViewController;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ManipulateComponent extends Component {
    private boolean enableDrag;
    private boolean enableRotation;
    private boolean enableScale;
    private float maxDistance;
    private float maxScale;
    private float minDistance;
    private float minScale;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof ManipulateComponent) {
            ManipulateComponent manipulateComponent = (ManipulateComponent) componentBase;
            this.enableScale = manipulateComponent.enableScale;
            this.enableRotation = manipulateComponent.enableRotation;
            this.enableDrag = manipulateComponent.enableDrag;
            this.minDistance = manipulateComponent.minDistance;
            this.maxDistance = manipulateComponent.maxDistance;
            this.minScale = manipulateComponent.minScale;
            this.maxScale = manipulateComponent.maxScale;
        }
        super.doUpdate(componentBase);
    }

    public boolean getEnableDrag() {
        return this.enableDrag;
    }

    public boolean getEnableRotation() {
        return this.enableRotation;
    }

    public boolean getEnableScale() {
        return this.enableScale;
    }

    public float getMaxDistance() {
        return this.maxDistance;
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public float getMinDistance() {
        return this.minDistance;
    }

    public float getMinScale() {
        return this.minScale;
    }

    public void setEnableDrag(boolean z16) {
        this.enableDrag = z16;
        reportPropertyChange(HippyQQDragGridViewController.PropertyName.ENABLE_DRAG, Boolean.valueOf(z16));
    }

    public void setEnableRotation(boolean z16) {
        this.enableRotation = z16;
        reportPropertyChange("enableRotation", Boolean.valueOf(z16));
    }

    public void setEnableScale(boolean z16) {
        this.enableScale = z16;
        reportPropertyChange("enableScale", Boolean.valueOf(z16));
    }

    public void setMaxDistance(float f16) {
        this.maxDistance = f16;
        reportPropertyChange("maxDistance", Float.valueOf(f16));
    }

    public void setMaxScale(float f16) {
        this.maxScale = f16;
        reportPropertyChange("maxScale", Float.valueOf(f16));
    }

    public void setMinDistance(float f16) {
        this.minDistance = f16;
        reportPropertyChange("minDistance", Float.valueOf(f16));
    }

    public void setMinScale(float f16) {
        this.minScale = f16;
        reportPropertyChange("minScale", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "ManipulateComponent";
    }
}
