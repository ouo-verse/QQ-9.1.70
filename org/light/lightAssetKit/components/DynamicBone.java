package org.light.lightAssetKit.components;

import com.tencent.ditto.shell.LayoutAttrDefine;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DynamicBone extends Component {
    private Position gravity = new Position(0.0f, -0.2f, 0.0f);
    private int resetType = 0;
    private boolean noRotationUpdate = false;
    private boolean disableAnimationReset = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof DynamicBone) {
            DynamicBone dynamicBone = (DynamicBone) componentBase;
            this.gravity = dynamicBone.gravity;
            this.resetType = dynamicBone.resetType;
            this.noRotationUpdate = dynamicBone.noRotationUpdate;
            this.disableAnimationReset = dynamicBone.disableAnimationReset;
        }
        super.doUpdate(componentBase);
    }

    public boolean getDisableAnimationReset() {
        return this.disableAnimationReset;
    }

    public Position getGravity() {
        return this.gravity;
    }

    public boolean getNoRotationUpdate() {
        return this.noRotationUpdate;
    }

    public int getResetType() {
        return this.resetType;
    }

    public void setDisableAnimationReset(boolean z16) {
        this.disableAnimationReset = z16;
        reportPropertyChange("disableAnimationReset", Boolean.valueOf(z16));
    }

    public void setGravity(Position position) {
        this.gravity = position;
        reportPropertyChange(LayoutAttrDefine.Gravity.Gravity, position);
    }

    public void setNoRotationUpdate(boolean z16) {
        this.noRotationUpdate = z16;
        reportPropertyChange("noRotationUpdate", Boolean.valueOf(z16));
    }

    public void setResetType(int i3) {
        this.resetType = i3;
        reportPropertyChange("resetType", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "DynamicBone";
    }
}
