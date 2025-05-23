package org.light.lightAssetKit.components;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Transform extends Component {
    private boolean visible;
    private Position anchor = new Position();
    private Position position = new Position();
    private Size size = new Size();
    private float rotation = 0.0f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Transform) {
            Transform transform = (Transform) componentBase;
            this.anchor = transform.anchor;
            this.position = transform.position;
            this.size = transform.size;
            this.rotation = transform.rotation;
            this.visible = transform.visible;
        }
        super.doUpdate(componentBase);
    }

    public Position getAnchor() {
        return this.anchor;
    }

    public Position getPosition() {
        return this.position;
    }

    public float getRotation() {
        return this.rotation;
    }

    public Size getSize() {
        return this.size;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public void setAnchor(Position position) {
        this.anchor = position;
        reportPropertyChange("anchor", position);
    }

    public void setPosition(Position position) {
        this.position = position;
        reportPropertyChange("position", position);
    }

    public void setRotation(float f16) {
        this.rotation = f16;
        reportPropertyChange(BasicAnimation.KeyPath.ROTATION, Float.valueOf(f16));
    }

    public void setSize(Size size) {
        this.size = size;
        reportPropertyChange("size", size);
    }

    public void setVisible(boolean z16) {
        this.visible = z16;
        reportPropertyChange(NodeProps.VISIBLE, Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Transform";
    }
}
