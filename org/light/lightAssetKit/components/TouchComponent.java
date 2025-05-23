package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TouchComponent extends Component {
    private boolean enable;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof TouchComponent) {
            this.enable = ((TouchComponent) componentBase).enable;
        }
        super.doUpdate(componentBase);
    }

    public boolean getEnable() {
        return this.enable;
    }

    public void setEnable(boolean z16) {
        this.enable = z16;
        reportPropertyChange("enable", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "TouchComponent";
    }
}
