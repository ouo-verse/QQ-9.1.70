package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.MakeupExtraFlag;
import org.light.lightAssetKit.enums.MakeupVisMethod;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MakeupComponent extends Component {
    private String faceImage = "";
    private String faceMask = "";
    private String facePointsFile = "";
    private MakeupVisMethod visMethod = MakeupVisMethod.Default;
    private float minVisibility = 0.8f;
    private MakeupExtraFlag extraFlag = MakeupExtraFlag.MakeupDefault;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MakeupComponent) {
            MakeupComponent makeupComponent = (MakeupComponent) componentBase;
            this.faceImage = makeupComponent.faceImage;
            this.faceMask = makeupComponent.faceMask;
            this.facePointsFile = makeupComponent.facePointsFile;
            this.visMethod = makeupComponent.visMethod;
            this.minVisibility = makeupComponent.minVisibility;
            this.extraFlag = makeupComponent.extraFlag;
        }
        super.doUpdate(componentBase);
    }

    public MakeupExtraFlag getExtraFlag() {
        return this.extraFlag;
    }

    public String getFaceImage() {
        return this.faceImage;
    }

    public String getFaceMask() {
        return this.faceMask;
    }

    public String getFacePointsFile() {
        return this.facePointsFile;
    }

    public float getMinVisibility() {
        return this.minVisibility;
    }

    public MakeupVisMethod getVisMethod() {
        return this.visMethod;
    }

    public void setExtraFlag(MakeupExtraFlag makeupExtraFlag) {
        this.extraFlag = makeupExtraFlag;
        reportPropertyChange("extraFlag", makeupExtraFlag);
    }

    public void setFaceImage(String str) {
        this.faceImage = str;
        reportPropertyChange("faceImage", str);
    }

    public void setFaceMask(String str) {
        this.faceMask = str;
        reportPropertyChange("faceMask", str);
    }

    public void setFacePointsFile(String str) {
        this.facePointsFile = str;
        reportPropertyChange("facePointsFile", str);
    }

    public void setMinVisibility(float f16) {
        this.minVisibility = f16;
        reportPropertyChange("minVisibility", Float.valueOf(f16));
    }

    public void setVisMethod(MakeupVisMethod makeupVisMethod) {
        this.visMethod = makeupVisMethod;
        reportPropertyChange("visMethod", makeupVisMethod);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MakeupComponent";
    }
}
