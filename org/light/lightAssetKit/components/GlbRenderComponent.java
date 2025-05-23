package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GlbRenderComponent extends Component {
    private String gltfResourceKey;

    public GlbRenderComponent() {
        this.gltfResourceKey = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof GlbRenderComponent) {
            this.gltfResourceKey = ((GlbRenderComponent) componentBase).gltfResourceKey;
        }
        super.doUpdate(componentBase);
    }

    public String getGltfResourceKey() {
        return this.gltfResourceKey;
    }

    public void setGltfResourceKey(String str) {
        this.gltfResourceKey = str;
        reportPropertyChange("gltfResourceKey", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "GlbRenderComponent";
    }

    public GlbRenderComponent(String str) {
        this.gltfResourceKey = str;
    }
}
