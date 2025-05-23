package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BoneRigidbodyComponent extends Component {
    private boolean enableParentConstraint;
    private int priority;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof BoneRigidbodyComponent) {
            BoneRigidbodyComponent boneRigidbodyComponent = (BoneRigidbodyComponent) componentBase;
            this.priority = boneRigidbodyComponent.priority;
            this.enableParentConstraint = boneRigidbodyComponent.enableParentConstraint;
        }
        super.doUpdate(componentBase);
    }

    public boolean getEnableParentConstraint() {
        return this.enableParentConstraint;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setEnableParentConstraint(boolean z16) {
        this.enableParentConstraint = z16;
        reportPropertyChange("enableParentConstraint", Boolean.valueOf(z16));
    }

    public void setPriority(int i3) {
        this.priority = i3;
        reportPropertyChange("priority", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "BoneRigidbodyComponent";
    }
}
