package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BGMHiddenComponent extends Component {
    private boolean hidden = true;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof BGMHiddenComponent) {
            this.hidden = ((BGMHiddenComponent) componentBase).hidden;
        }
        super.doUpdate(componentBase);
    }

    public boolean getHidden() {
        return this.hidden;
    }

    public void setHidden(boolean z16) {
        this.hidden = z16;
        reportPropertyChange("hidden", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "BGMHiddenComponent";
    }
}
