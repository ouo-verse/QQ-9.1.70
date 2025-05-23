package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LayerSetComponent extends Component {
    private int layers = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof LayerSetComponent) {
            this.layers = ((LayerSetComponent) componentBase).layers;
        }
        super.doUpdate(componentBase);
    }

    public int getLayers() {
        return this.layers;
    }

    public void setLayers(int i3) {
        this.layers = i3;
        reportPropertyChange("layers", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "LayerSetComponent";
    }
}
