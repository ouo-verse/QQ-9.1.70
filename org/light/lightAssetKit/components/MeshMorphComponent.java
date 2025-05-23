package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.MeshMorphModel;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MeshMorphComponent extends Component {
    private String morphName = "";
    private MeshMorphModel meshMorphModel = MeshMorphModel.POSITION;
    private ArrayList<BlendShapeItem> blendShapeGroup = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MeshMorphComponent) {
            MeshMorphComponent meshMorphComponent = (MeshMorphComponent) componentBase;
            this.morphName = meshMorphComponent.morphName;
            this.meshMorphModel = meshMorphComponent.meshMorphModel;
            this.blendShapeGroup = meshMorphComponent.blendShapeGroup;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<BlendShapeItem> getBlendShapeGroup() {
        return this.blendShapeGroup;
    }

    public MeshMorphModel getMeshMorphModel() {
        return this.meshMorphModel;
    }

    public String getMorphName() {
        return this.morphName;
    }

    public void setBlendShapeGroup(ArrayList<BlendShapeItem> arrayList) {
        this.blendShapeGroup = arrayList;
        reportPropertyChange("blendShapeGroup", arrayList);
    }

    public void setMeshMorphModel(MeshMorphModel meshMorphModel) {
        this.meshMorphModel = meshMorphModel;
        reportPropertyChange("meshMorphModel", meshMorphModel);
    }

    public void setMorphName(String str) {
        this.morphName = str;
        reportPropertyChange("morphName", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MeshMorphComponent";
    }
}
