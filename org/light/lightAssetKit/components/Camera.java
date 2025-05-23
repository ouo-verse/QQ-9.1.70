package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Camera extends Component {
    private int duplicateInput;
    private String renderTargetKey;
    private int sizeConfig;

    public Camera() {
        this.sizeConfig = 1280;
        this.renderTargetKey = "";
        this.duplicateInput = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Camera) {
            Camera camera2 = (Camera) componentBase;
            this.sizeConfig = camera2.sizeConfig;
            this.renderTargetKey = camera2.renderTargetKey;
            this.duplicateInput = camera2.duplicateInput;
        }
        super.doUpdate(componentBase);
    }

    public int getDuplicateInput() {
        return this.duplicateInput;
    }

    public String getRenderTargetKey() {
        return this.renderTargetKey;
    }

    public int getSizeConfig() {
        return this.sizeConfig;
    }

    public void setDuplicateInput(int i3) {
        this.duplicateInput = i3;
        reportPropertyChange("duplicateInput", Integer.valueOf(i3));
    }

    public void setRenderTargetKey(String str) {
        this.renderTargetKey = str;
        reportPropertyChange("renderTargetKey", str);
    }

    public void setSizeConfig(int i3) {
        this.sizeConfig = i3;
        reportPropertyChange("sizeConfig", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Camera";
    }

    public Camera(int i3, String str, int i16) {
        this.sizeConfig = i3;
        this.renderTargetKey = str;
        this.duplicateInput = i16;
    }
}
