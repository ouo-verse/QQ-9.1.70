package org.light.lightAssetKit.components;

import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Stretch extends Component {
    private float basicFace = 0.0f;
    private float vFace = 0.0f;
    private float chin = 0.0f;
    private float thinFace = 0.0f;
    private float shortFace = 0.0f;
    private float cheekboneThin = 0.0f;
    private float enlargeEye = 0.0f;
    private float noseSize = 0.0f;
    private float foreHead = 0.0f;
    private float eyeDistance = 0.0f;
    private float eyeAngle = 0.0f;
    private float noseWing = 0.0f;
    private float noseHeight = 0.0f;
    private float mouthSize = 0.0f;
    private float mouthWidth = 0.0f;
    private float mouthHeight = 0.0f;
    private float mouthPosition = 0.0f;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof Stretch) {
            Stretch stretch = (Stretch) componentBase;
            this.basicFace = stretch.basicFace;
            this.vFace = stretch.vFace;
            this.chin = stretch.chin;
            this.thinFace = stretch.thinFace;
            this.shortFace = stretch.shortFace;
            this.cheekboneThin = stretch.cheekboneThin;
            this.enlargeEye = stretch.enlargeEye;
            this.noseSize = stretch.noseSize;
            this.foreHead = stretch.foreHead;
            this.eyeDistance = stretch.eyeDistance;
            this.eyeAngle = stretch.eyeAngle;
            this.noseWing = stretch.noseWing;
            this.noseHeight = stretch.noseHeight;
            this.mouthSize = stretch.mouthSize;
            this.mouthWidth = stretch.mouthWidth;
            this.mouthHeight = stretch.mouthHeight;
            this.mouthPosition = stretch.mouthPosition;
        }
        super.doUpdate(componentBase);
    }

    public float getBasicFace() {
        return this.basicFace;
    }

    public float getCheekboneThin() {
        return this.cheekboneThin;
    }

    public float getChin() {
        return this.chin;
    }

    public float getEnlargeEye() {
        return this.enlargeEye;
    }

    public float getEyeAngle() {
        return this.eyeAngle;
    }

    public float getEyeDistance() {
        return this.eyeDistance;
    }

    public float getForeHead() {
        return this.foreHead;
    }

    public float getMouthHeight() {
        return this.mouthHeight;
    }

    public float getMouthPosition() {
        return this.mouthPosition;
    }

    public float getMouthSize() {
        return this.mouthSize;
    }

    public float getMouthWidth() {
        return this.mouthWidth;
    }

    public float getNoseHeight() {
        return this.noseHeight;
    }

    public float getNoseSize() {
        return this.noseSize;
    }

    public float getNoseWing() {
        return this.noseWing;
    }

    public float getShortFace() {
        return this.shortFace;
    }

    public float getThinFace() {
        return this.thinFace;
    }

    public float getVFace() {
        return this.vFace;
    }

    public void setBasicFace(float f16) {
        this.basicFace = f16;
        reportPropertyChange("basicFace", Float.valueOf(f16));
    }

    public void setCheekboneThin(float f16) {
        this.cheekboneThin = f16;
        reportPropertyChange("cheekboneThin", Float.valueOf(f16));
    }

    public void setChin(float f16) {
        this.chin = f16;
        reportPropertyChange("chin", Float.valueOf(f16));
    }

    public void setEnlargeEye(float f16) {
        this.enlargeEye = f16;
        reportPropertyChange("enlargeEye", Float.valueOf(f16));
    }

    public void setEyeAngle(float f16) {
        this.eyeAngle = f16;
        reportPropertyChange("eyeAngle", Float.valueOf(f16));
    }

    public void setEyeDistance(float f16) {
        this.eyeDistance = f16;
        reportPropertyChange("eyeDistance", Float.valueOf(f16));
    }

    public void setForeHead(float f16) {
        this.foreHead = f16;
        reportPropertyChange("foreHead", Float.valueOf(f16));
    }

    public void setMouthHeight(float f16) {
        this.mouthHeight = f16;
        reportPropertyChange("mouthHeight", Float.valueOf(f16));
    }

    public void setMouthPosition(float f16) {
        this.mouthPosition = f16;
        reportPropertyChange("mouthPosition", Float.valueOf(f16));
    }

    public void setMouthSize(float f16) {
        this.mouthSize = f16;
        reportPropertyChange("mouthSize", Float.valueOf(f16));
    }

    public void setMouthWidth(float f16) {
        this.mouthWidth = f16;
        reportPropertyChange("mouthWidth", Float.valueOf(f16));
    }

    public void setNoseHeight(float f16) {
        this.noseHeight = f16;
        reportPropertyChange("noseHeight", Float.valueOf(f16));
    }

    public void setNoseSize(float f16) {
        this.noseSize = f16;
        reportPropertyChange("noseSize", Float.valueOf(f16));
    }

    public void setNoseWing(float f16) {
        this.noseWing = f16;
        reportPropertyChange("noseWing", Float.valueOf(f16));
    }

    public void setShortFace(float f16) {
        this.shortFace = f16;
        reportPropertyChange("shortFace", Float.valueOf(f16));
    }

    public void setThinFace(float f16) {
        this.thinFace = f16;
        reportPropertyChange("thinFace", Float.valueOf(f16));
    }

    public void setVFace(float f16) {
        this.vFace = f16;
        reportPropertyChange("vFace", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "Stretch";
    }
}
