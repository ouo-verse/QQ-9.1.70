package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.Face3DMeshType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Face3DMeshComponent extends Component {
    private int faceIndex = 0;
    private boolean updateNormal = false;
    private Face3DMeshType faceType = Face3DMeshType.HEAD;
    private String indexPath = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Face3DMeshComponent) {
            Face3DMeshComponent face3DMeshComponent = (Face3DMeshComponent) componentBase;
            this.faceIndex = face3DMeshComponent.faceIndex;
            this.updateNormal = face3DMeshComponent.updateNormal;
            this.faceType = face3DMeshComponent.faceType;
            this.indexPath = face3DMeshComponent.indexPath;
        }
        super.doUpdate(componentBase);
    }

    public int getFaceIndex() {
        return this.faceIndex;
    }

    public Face3DMeshType getFaceType() {
        return this.faceType;
    }

    public String getIndexPath() {
        return this.indexPath;
    }

    public boolean getUpdateNormal() {
        return this.updateNormal;
    }

    public void setFaceIndex(int i3) {
        this.faceIndex = i3;
        reportPropertyChange("faceIndex", Integer.valueOf(i3));
    }

    public void setFaceType(Face3DMeshType face3DMeshType) {
        this.faceType = face3DMeshType;
        reportPropertyChange("faceType", face3DMeshType);
    }

    public void setIndexPath(String str) {
        this.indexPath = str;
        reportPropertyChange("indexPath", str);
    }

    public void setUpdateNormal(boolean z16) {
        this.updateNormal = z16;
        reportPropertyChange("updateNormal", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Face3DMeshComponent";
    }
}
