package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.LipsType;
import org.light.lightAssetKit.enums.MakeupVisMethod;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MakeupLips extends Component {
    private String lipsMask = "";
    private LipsType lipsType = LipsType.Color;
    private String lipsLut = "";
    private String lipsColor = "";
    private String lipsImage = "";
    private MakeupVisMethod visMethod = MakeupVisMethod.Default;
    private float minVisibility = 0.8f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MakeupLips) {
            MakeupLips makeupLips = (MakeupLips) componentBase;
            this.lipsMask = makeupLips.lipsMask;
            this.lipsType = makeupLips.lipsType;
            this.lipsLut = makeupLips.lipsLut;
            this.lipsColor = makeupLips.lipsColor;
            this.lipsImage = makeupLips.lipsImage;
            this.visMethod = makeupLips.visMethod;
            this.minVisibility = makeupLips.minVisibility;
        }
        super.doUpdate(componentBase);
    }

    public String getLipsColor() {
        return this.lipsColor;
    }

    public String getLipsImage() {
        return this.lipsImage;
    }

    public String getLipsLut() {
        return this.lipsLut;
    }

    public String getLipsMask() {
        return this.lipsMask;
    }

    public LipsType getLipsType() {
        return this.lipsType;
    }

    public float getMinVisibility() {
        return this.minVisibility;
    }

    public MakeupVisMethod getVisMethod() {
        return this.visMethod;
    }

    public void setLipsColor(String str) {
        this.lipsColor = str;
        reportPropertyChange("lipsColor", str);
    }

    public void setLipsImage(String str) {
        this.lipsImage = str;
        reportPropertyChange("lipsImage", str);
    }

    public void setLipsLut(String str) {
        this.lipsLut = str;
        reportPropertyChange("lipsLut", str);
    }

    public void setLipsMask(String str) {
        this.lipsMask = str;
        reportPropertyChange("lipsMask", str);
    }

    public void setLipsType(LipsType lipsType) {
        this.lipsType = lipsType;
        reportPropertyChange("lipsType", lipsType);
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
        return "MakeupLips";
    }
}
