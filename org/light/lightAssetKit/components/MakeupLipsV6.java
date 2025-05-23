package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.LipsDetailType;
import org.light.lightAssetKit.enums.LipsTextureType;
import org.light.lightAssetKit.enums.LipsType;
import org.light.lightAssetKit.enums.MakeupVisMethod;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MakeupLipsV6 extends Component {
    private String lipsMask = "";
    private LipsType lipsType = LipsType.Color;
    private LipsDetailType lipsDetailType = LipsDetailType.Default;
    private LipsTextureType lipsTextureType = LipsTextureType.Default;
    private String shimmerColor = "";
    private String glossColor = "";
    private String lipsLut = "";
    private String lipsColor = "";
    private String lipsImage = "";
    private String lipsImageCrop = "";
    private String lipsMaskCrop = "";
    private String shimmerTextureDefault = "";
    private String shimmerTextureUser = "";
    private Rect lipsImageCropRect = new Rect();
    private Rect lipsMaskCropRect = new Rect();
    private float glossStrength = 0.0f;
    private float shimmerStrength = 0.0f;
    private MakeupVisMethod visMethod = MakeupVisMethod.Default;
    private float minVisibility = 0.8f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof MakeupLipsV6) {
            MakeupLipsV6 makeupLipsV6 = (MakeupLipsV6) componentBase;
            this.lipsMask = makeupLipsV6.lipsMask;
            this.lipsType = makeupLipsV6.lipsType;
            this.lipsDetailType = makeupLipsV6.lipsDetailType;
            this.lipsTextureType = makeupLipsV6.lipsTextureType;
            this.shimmerColor = makeupLipsV6.shimmerColor;
            this.glossColor = makeupLipsV6.glossColor;
            this.lipsLut = makeupLipsV6.lipsLut;
            this.lipsColor = makeupLipsV6.lipsColor;
            this.lipsImage = makeupLipsV6.lipsImage;
            this.lipsImageCrop = makeupLipsV6.lipsImageCrop;
            this.lipsMaskCrop = makeupLipsV6.lipsMaskCrop;
            this.shimmerTextureDefault = makeupLipsV6.shimmerTextureDefault;
            this.shimmerTextureUser = makeupLipsV6.shimmerTextureUser;
            this.lipsImageCropRect = makeupLipsV6.lipsImageCropRect;
            this.lipsMaskCropRect = makeupLipsV6.lipsMaskCropRect;
            this.glossStrength = makeupLipsV6.glossStrength;
            this.shimmerStrength = makeupLipsV6.shimmerStrength;
            this.visMethod = makeupLipsV6.visMethod;
            this.minVisibility = makeupLipsV6.minVisibility;
        }
        super.doUpdate(componentBase);
    }

    public String getGlossColor() {
        return this.glossColor;
    }

    public float getGlossStrength() {
        return this.glossStrength;
    }

    public String getLipsColor() {
        return this.lipsColor;
    }

    public LipsDetailType getLipsDetailType() {
        return this.lipsDetailType;
    }

    public String getLipsImage() {
        return this.lipsImage;
    }

    public String getLipsImageCrop() {
        return this.lipsImageCrop;
    }

    public Rect getLipsImageCropRect() {
        return this.lipsImageCropRect;
    }

    public String getLipsLut() {
        return this.lipsLut;
    }

    public String getLipsMask() {
        return this.lipsMask;
    }

    public String getLipsMaskCrop() {
        return this.lipsMaskCrop;
    }

    public Rect getLipsMaskCropRect() {
        return this.lipsMaskCropRect;
    }

    public LipsTextureType getLipsTextureType() {
        return this.lipsTextureType;
    }

    public LipsType getLipsType() {
        return this.lipsType;
    }

    public float getMinVisibility() {
        return this.minVisibility;
    }

    public String getShimmerColor() {
        return this.shimmerColor;
    }

    public float getShimmerStrength() {
        return this.shimmerStrength;
    }

    public String getShimmerTextureDefault() {
        return this.shimmerTextureDefault;
    }

    public String getShimmerTextureUser() {
        return this.shimmerTextureUser;
    }

    public MakeupVisMethod getVisMethod() {
        return this.visMethod;
    }

    public void setGlossColor(String str) {
        this.glossColor = str;
        reportPropertyChange("glossColor", str);
    }

    public void setGlossStrength(float f16) {
        this.glossStrength = f16;
        reportPropertyChange("glossStrength", Float.valueOf(f16));
    }

    public void setLipsColor(String str) {
        this.lipsColor = str;
        reportPropertyChange("lipsColor", str);
    }

    public void setLipsDetailType(LipsDetailType lipsDetailType) {
        this.lipsDetailType = lipsDetailType;
        reportPropertyChange("lipsDetailType", lipsDetailType);
    }

    public void setLipsImage(String str) {
        this.lipsImage = str;
        reportPropertyChange("lipsImage", str);
    }

    public void setLipsImageCrop(String str) {
        this.lipsImageCrop = str;
        reportPropertyChange("lipsImageCrop", str);
    }

    public void setLipsImageCropRect(Rect rect) {
        this.lipsImageCropRect = rect;
        reportPropertyChange("lipsImageCropRect", rect);
    }

    public void setLipsLut(String str) {
        this.lipsLut = str;
        reportPropertyChange("lipsLut", str);
    }

    public void setLipsMask(String str) {
        this.lipsMask = str;
        reportPropertyChange("lipsMask", str);
    }

    public void setLipsMaskCrop(String str) {
        this.lipsMaskCrop = str;
        reportPropertyChange("lipsMaskCrop", str);
    }

    public void setLipsMaskCropRect(Rect rect) {
        this.lipsMaskCropRect = rect;
        reportPropertyChange("lipsMaskCropRect", rect);
    }

    public void setLipsTextureType(LipsTextureType lipsTextureType) {
        this.lipsTextureType = lipsTextureType;
        reportPropertyChange("lipsTextureType", lipsTextureType);
    }

    public void setLipsType(LipsType lipsType) {
        this.lipsType = lipsType;
        reportPropertyChange("lipsType", lipsType);
    }

    public void setMinVisibility(float f16) {
        this.minVisibility = f16;
        reportPropertyChange("minVisibility", Float.valueOf(f16));
    }

    public void setShimmerColor(String str) {
        this.shimmerColor = str;
        reportPropertyChange("shimmerColor", str);
    }

    public void setShimmerStrength(float f16) {
        this.shimmerStrength = f16;
        reportPropertyChange("shimmerStrength", Float.valueOf(f16));
    }

    public void setShimmerTextureDefault(String str) {
        this.shimmerTextureDefault = str;
        reportPropertyChange("shimmerTextureDefault", str);
    }

    public void setShimmerTextureUser(String str) {
        this.shimmerTextureUser = str;
        reportPropertyChange("shimmerTextureUser", str);
    }

    public void setVisMethod(MakeupVisMethod makeupVisMethod) {
        this.visMethod = makeupVisMethod;
        reportPropertyChange("visMethod", makeupVisMethod);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "MakeupLipsV6";
    }
}
