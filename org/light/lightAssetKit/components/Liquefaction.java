package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Liquefaction extends Component {
    private String resourcePath = "";
    private float strength = 0.0f;
    private String shortFaceResourcePath = "";
    private float shortFaceStrength = 0.0f;
    private int boundaryFixMode = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Liquefaction) {
            Liquefaction liquefaction = (Liquefaction) componentBase;
            this.resourcePath = liquefaction.resourcePath;
            this.strength = liquefaction.strength;
            this.shortFaceResourcePath = liquefaction.shortFaceResourcePath;
            this.shortFaceStrength = liquefaction.shortFaceStrength;
            this.boundaryFixMode = liquefaction.boundaryFixMode;
        }
        super.doUpdate(componentBase);
    }

    public int getBoundaryFixMode() {
        return this.boundaryFixMode;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public String getShortFaceResourcePath() {
        return this.shortFaceResourcePath;
    }

    public float getShortFaceStrength() {
        return this.shortFaceStrength;
    }

    public float getStrength() {
        return this.strength;
    }

    public void setBoundaryFixMode(int i3) {
        this.boundaryFixMode = i3;
        reportPropertyChange("boundaryFixMode", Integer.valueOf(i3));
    }

    public void setResourcePath(String str) {
        this.resourcePath = str;
        reportPropertyChange("resourcePath", str);
    }

    public void setShortFaceResourcePath(String str) {
        this.shortFaceResourcePath = str;
        reportPropertyChange("shortFaceResourcePath", str);
    }

    public void setShortFaceStrength(float f16) {
        this.shortFaceStrength = f16;
        reportPropertyChange("shortFaceStrength", Float.valueOf(f16));
    }

    public void setStrength(float f16) {
        this.strength = f16;
        reportPropertyChange("strength", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Liquefaction";
    }
}
