package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.MakeupEyeMeshOptType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MakeupEyeV6 extends MakeupComponent {
    private String eyeImageName = "";
    private String eyeCropImageName = "";
    private Rect cropRect = new Rect();
    private MakeupEyeMeshOptType eyeMeshOptType = MakeupEyeMeshOptType.MakeupEyeMeshOptTypeNormal;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.MakeupComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MakeupEyeV6) {
            MakeupEyeV6 makeupEyeV6 = (MakeupEyeV6) componentBase;
            this.eyeImageName = makeupEyeV6.eyeImageName;
            this.eyeCropImageName = makeupEyeV6.eyeCropImageName;
            this.cropRect = makeupEyeV6.cropRect;
            this.eyeMeshOptType = makeupEyeV6.eyeMeshOptType;
        }
        super.doUpdate(componentBase);
    }

    public Rect getCropRect() {
        return this.cropRect;
    }

    public String getEyeCropImageName() {
        return this.eyeCropImageName;
    }

    public String getEyeImageName() {
        return this.eyeImageName;
    }

    public MakeupEyeMeshOptType getEyeMeshOptType() {
        return this.eyeMeshOptType;
    }

    public void setCropRect(Rect rect) {
        this.cropRect = rect;
        reportPropertyChange("cropRect", rect);
    }

    public void setEyeCropImageName(String str) {
        this.eyeCropImageName = str;
        reportPropertyChange("eyeCropImageName", str);
    }

    public void setEyeImageName(String str) {
        this.eyeImageName = str;
        reportPropertyChange("eyeImageName", str);
    }

    public void setEyeMeshOptType(MakeupEyeMeshOptType makeupEyeMeshOptType) {
        this.eyeMeshOptType = makeupEyeMeshOptType;
        reportPropertyChange("eyeMeshOptType", makeupEyeMeshOptType);
    }

    @Override // org.light.lightAssetKit.components.MakeupComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MakeupEyeV6";
    }
}
