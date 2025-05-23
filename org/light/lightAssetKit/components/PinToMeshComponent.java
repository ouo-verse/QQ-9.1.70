package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* loaded from: classes29.dex */
public class PinToMeshComponent extends Component {
    private int pinToEntityId = 1;
    private int pinPointVertexIndex = 1;
    private int pinDirectionVertexIndex = 1;
    private int pinTriangleVertexIndex = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof PinToMeshComponent) {
            PinToMeshComponent pinToMeshComponent = (PinToMeshComponent) componentBase;
            this.pinToEntityId = pinToMeshComponent.pinToEntityId;
            this.pinPointVertexIndex = pinToMeshComponent.pinPointVertexIndex;
            this.pinDirectionVertexIndex = pinToMeshComponent.pinDirectionVertexIndex;
            this.pinTriangleVertexIndex = pinToMeshComponent.pinTriangleVertexIndex;
        }
        super.doUpdate(componentBase);
    }

    public int getPinDirectionVertexIndex() {
        return this.pinDirectionVertexIndex;
    }

    public int getPinPointVertexIndex() {
        return this.pinPointVertexIndex;
    }

    public int getPinToEntityId() {
        return this.pinToEntityId;
    }

    public int getPinTriangleVertexIndex() {
        return this.pinTriangleVertexIndex;
    }

    public void setPinDirectionVertexIndex(int i3) {
        this.pinDirectionVertexIndex = i3;
        reportPropertyChange("pinDirectionVertexIndex", Integer.valueOf(i3));
    }

    public void setPinPointVertexIndex(int i3) {
        this.pinPointVertexIndex = i3;
        reportPropertyChange("pinPointVertexIndex", Integer.valueOf(i3));
    }

    public void setPinToEntityId(int i3) {
        this.pinToEntityId = i3;
        reportPropertyChange("pinToEntityId", Integer.valueOf(i3));
    }

    public void setPinTriangleVertexIndex(int i3) {
        this.pinTriangleVertexIndex = i3;
        reportPropertyChange("pinTriangleVertexIndex", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "PinToMeshComponent";
    }
}
