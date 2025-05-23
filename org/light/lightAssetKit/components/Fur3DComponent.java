package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Fur3DComponent extends Component {
    private String furFile = "";
    private boolean furAutoScaling = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Fur3DComponent) {
            Fur3DComponent fur3DComponent = (Fur3DComponent) componentBase;
            this.furFile = fur3DComponent.furFile;
            this.furAutoScaling = fur3DComponent.furAutoScaling;
        }
        super.doUpdate(componentBase);
    }

    public boolean getFurAutoScaling() {
        return this.furAutoScaling;
    }

    public String getFurFile() {
        return this.furFile;
    }

    public void setFurAutoScaling(boolean z16) {
        this.furAutoScaling = z16;
        reportPropertyChange("furAutoScaling", Boolean.valueOf(z16));
    }

    public void setFurFile(String str) {
        this.furFile = str;
        reportPropertyChange("furFile", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Fur3DComponent";
    }
}
