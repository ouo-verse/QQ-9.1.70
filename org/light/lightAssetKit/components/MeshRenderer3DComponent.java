package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MeshRenderer3DComponent extends Component {
    private String meshName = "";
    private int meshIndex = -1;
    private boolean skinned = false;
    private ArrayList<PrimitiveConfig> primitiveConfigs = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MeshRenderer3DComponent) {
            MeshRenderer3DComponent meshRenderer3DComponent = (MeshRenderer3DComponent) componentBase;
            this.meshName = meshRenderer3DComponent.meshName;
            this.meshIndex = meshRenderer3DComponent.meshIndex;
            this.skinned = meshRenderer3DComponent.skinned;
            this.primitiveConfigs = meshRenderer3DComponent.primitiveConfigs;
        }
        super.doUpdate(componentBase);
    }

    public int getMeshIndex() {
        return this.meshIndex;
    }

    public String getMeshName() {
        return this.meshName;
    }

    public ArrayList<PrimitiveConfig> getPrimitiveConfigs() {
        return this.primitiveConfigs;
    }

    public boolean getSkinned() {
        return this.skinned;
    }

    public void setMeshIndex(int i3) {
        this.meshIndex = i3;
        reportPropertyChange("meshIndex", Integer.valueOf(i3));
    }

    public void setMeshName(String str) {
        this.meshName = str;
        reportPropertyChange("meshName", str);
    }

    public void setPrimitiveConfigs(ArrayList<PrimitiveConfig> arrayList) {
        this.primitiveConfigs = arrayList;
        reportPropertyChange("primitiveConfigs", arrayList);
    }

    public void setSkinned(boolean z16) {
        this.skinned = z16;
        reportPropertyChange("skinned", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MeshRenderer3DComponent";
    }
}
