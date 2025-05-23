package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FaceMeshComponent extends Component {
    private int face_index_ = 0;
    private int face_type_ = 0;
    private String mappingPath = "";
    private boolean useMesh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof FaceMeshComponent) {
            FaceMeshComponent faceMeshComponent = (FaceMeshComponent) componentBase;
            this.useMesh = faceMeshComponent.useMesh;
            this.face_index_ = faceMeshComponent.face_index_;
            this.face_type_ = faceMeshComponent.face_type_;
            this.mappingPath = faceMeshComponent.mappingPath;
        }
        super.doUpdate(componentBase);
    }

    public int getFace_index_() {
        return this.face_index_;
    }

    public int getFace_type_() {
        return this.face_type_;
    }

    public String getMappingPath() {
        return this.mappingPath;
    }

    public boolean getUseMesh() {
        return this.useMesh;
    }

    public void setFace_index_(int i3) {
        this.face_index_ = i3;
        reportPropertyChange("face_index_", Integer.valueOf(i3));
    }

    public void setFace_type_(int i3) {
        this.face_type_ = i3;
        reportPropertyChange("face_type_", Integer.valueOf(i3));
    }

    public void setMappingPath(String str) {
        this.mappingPath = str;
        reportPropertyChange("mappingPath", str);
    }

    public void setUseMesh(boolean z16) {
        this.useMesh = z16;
        reportPropertyChange("useMesh", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "FaceMeshComponent";
    }
}
