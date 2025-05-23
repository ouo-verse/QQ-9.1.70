package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CompoundRigidbody3DComponent extends Rigidbody3DComponent {
    private ArrayList<CollisionShapeData> shape_data_array_ = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Rigidbody3DComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof CompoundRigidbody3DComponent) {
            this.shape_data_array_ = ((CompoundRigidbody3DComponent) componentBase).shape_data_array_;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<CollisionShapeData> getShape_data_array_() {
        return this.shape_data_array_;
    }

    public void setShape_data_array_(ArrayList<CollisionShapeData> arrayList) {
        this.shape_data_array_ = arrayList;
        reportPropertyChange("shape_data_array_", arrayList);
    }

    @Override // org.light.lightAssetKit.components.Rigidbody3DComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "CompoundRigidbody3DComponent";
    }
}
