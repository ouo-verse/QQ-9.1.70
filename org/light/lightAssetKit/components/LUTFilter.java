package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LUTFilter extends Component {
    private float intensity = 1.0f;
    private String src = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof LUTFilter) {
            LUTFilter lUTFilter = (LUTFilter) componentBase;
            this.intensity = lUTFilter.intensity;
            this.src = lUTFilter.src;
        }
        super.doUpdate(componentBase);
    }

    public float getIntensity() {
        return this.intensity;
    }

    public String getSrc() {
        return this.src;
    }

    public void setIntensity(float f16) {
        this.intensity = f16;
        reportPropertyChange("intensity", Float.valueOf(f16));
    }

    public void setSrc(String str) {
        this.src = str;
        reportPropertyChange("src", str);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "LUTFilter";
    }
}
