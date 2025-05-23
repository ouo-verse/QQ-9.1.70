package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MeshRigidbody3DComponent extends Rigidbody3DComponent {
    private String triangle_file_path_ = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Rigidbody3DComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MeshRigidbody3DComponent) {
            this.triangle_file_path_ = ((MeshRigidbody3DComponent) componentBase).triangle_file_path_;
        }
        super.doUpdate(componentBase);
    }

    public String getTriangle_file_path_() {
        return this.triangle_file_path_;
    }

    public void setTriangle_file_path_(String str) {
        this.triangle_file_path_ = str;
        reportPropertyChange("triangle_file_path_", str);
    }

    @Override // org.light.lightAssetKit.components.Rigidbody3DComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MeshRigidbody3DComponent";
    }
}
