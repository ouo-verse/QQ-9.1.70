package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RendererV2Component extends Component {
    private String materialResourceKey = "";
    private String special_type = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof RendererV2Component) {
            RendererV2Component rendererV2Component = (RendererV2Component) componentBase;
            this.materialResourceKey = rendererV2Component.materialResourceKey;
            this.special_type = rendererV2Component.special_type;
        }
        super.doUpdate(componentBase);
    }

    public String getMaterialResourceKey() {
        return this.materialResourceKey;
    }

    public String getSpecial_type() {
        return this.special_type;
    }

    public void setMaterialResourceKey(String str) {
        this.materialResourceKey = str;
        reportPropertyChange("materialResourceKey", str);
    }

    public void setSpecial_type(String str) {
        this.special_type = str;
        reportPropertyChange("special_type", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "RendererV2Component";
    }
}
