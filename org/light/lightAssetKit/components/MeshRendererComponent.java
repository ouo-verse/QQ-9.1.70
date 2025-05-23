package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MeshRendererComponent extends RendererV2Component {
    private ArrayList<String> meshResourceKey = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.RendererV2Component, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MeshRendererComponent) {
            this.meshResourceKey = ((MeshRendererComponent) componentBase).meshResourceKey;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<String> getMeshResourceKey() {
        return this.meshResourceKey;
    }

    public void setMeshResourceKey(ArrayList<String> arrayList) {
        this.meshResourceKey = arrayList;
        reportPropertyChange("meshResourceKey", arrayList);
    }

    @Override // org.light.lightAssetKit.components.RendererV2Component, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MeshRendererComponent";
    }
}
