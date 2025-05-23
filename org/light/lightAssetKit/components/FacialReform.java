package org.light.lightAssetKit.components;

import java.util.ArrayList;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FacialReform extends Component {
    private boolean stretchEnabled = false;
    private boolean pinchFaceEnabled = false;
    private float overallFactor = 0.0f;
    private float basicFace = 0.0f;
    private float vFace = 0.0f;
    private float chin = 0.0f;
    private float thinFace = 0.0f;
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
    private float facejaw = 0.0f;
    private float shortFace = 0.0f;
    private float longNose = 0.0f;
    private float basicFaceEyelarge = 0.0f;
    private ArrayList<PointItem> points = new ArrayList<>();
    private ArrayList<PointItem> lastPoints = new ArrayList<>();
    private float strength = 1.0f;
    private boolean symmetry = true;
    private boolean fixPoints = false;
    private boolean editMode = false;
    private int width = 720;
    private int height = 960;
    private String reformSubType = "";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof FacialReform) {
            FacialReform facialReform = (FacialReform) componentBase;
            this.stretchEnabled = facialReform.stretchEnabled;
            this.pinchFaceEnabled = facialReform.pinchFaceEnabled;
            this.overallFactor = facialReform.overallFactor;
            this.basicFace = facialReform.basicFace;
            this.vFace = facialReform.vFace;
            this.chin = facialReform.chin;
            this.thinFace = facialReform.thinFace;
            this.cheekboneThin = facialReform.cheekboneThin;
            this.enlargeEye = facialReform.enlargeEye;
            this.noseSize = facialReform.noseSize;
            this.foreHead = facialReform.foreHead;
            this.eyeDistance = facialReform.eyeDistance;
            this.eyeAngle = facialReform.eyeAngle;
            this.noseWing = facialReform.noseWing;
            this.noseHeight = facialReform.noseHeight;
            this.mouthSize = facialReform.mouthSize;
            this.mouthWidth = facialReform.mouthWidth;
            this.mouthHeight = facialReform.mouthHeight;
            this.mouthPosition = facialReform.mouthPosition;
            this.facejaw = facialReform.facejaw;
            this.shortFace = facialReform.shortFace;
            this.longNose = facialReform.longNose;
            this.basicFaceEyelarge = facialReform.basicFaceEyelarge;
            this.points = facialReform.points;
            this.lastPoints = facialReform.lastPoints;
            this.strength = facialReform.strength;
            this.symmetry = facialReform.symmetry;
            this.fixPoints = facialReform.fixPoints;
            this.editMode = facialReform.editMode;
            this.width = facialReform.width;
            this.height = facialReform.height;
            this.reformSubType = facialReform.reformSubType;
        }
        super.doUpdate(componentBase);
    }

    public float getBasicFace() {
        return this.basicFace;
    }

    public float getBasicFaceEyelarge() {
        return this.basicFaceEyelarge;
    }

    public float getCheekboneThin() {
        return this.cheekboneThin;
    }

    public float getChin() {
        return this.chin;
    }

    public boolean getEditMode() {
        return this.editMode;
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

    public float getFacejaw() {
        return this.facejaw;
    }

    public boolean getFixPoints() {
        return this.fixPoints;
    }

    public float getForeHead() {
        return this.foreHead;
    }

    public int getHeight() {
        return this.height;
    }

    public ArrayList<PointItem> getLastPoints() {
        return this.lastPoints;
    }

    public float getLongNose() {
        return this.longNose;
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

    public float getOverallFactor() {
        return this.overallFactor;
    }

    public boolean getPinchFaceEnabled() {
        return this.pinchFaceEnabled;
    }

    public ArrayList<PointItem> getPoints() {
        return this.points;
    }

    public String getReformSubType() {
        return this.reformSubType;
    }

    public float getShortFace() {
        return this.shortFace;
    }

    public float getStrength() {
        return this.strength;
    }

    public boolean getStretchEnabled() {
        return this.stretchEnabled;
    }

    public boolean getSymmetry() {
        return this.symmetry;
    }

    public float getThinFace() {
        return this.thinFace;
    }

    public float getVFace() {
        return this.vFace;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBasicFace(float f16) {
        this.basicFace = f16;
        reportPropertyChange("basicFace", Float.valueOf(f16));
    }

    public void setBasicFaceEyelarge(float f16) {
        this.basicFaceEyelarge = f16;
        reportPropertyChange("basicFaceEyelarge", Float.valueOf(f16));
    }

    public void setCheekboneThin(float f16) {
        this.cheekboneThin = f16;
        reportPropertyChange("cheekboneThin", Float.valueOf(f16));
    }

    public void setChin(float f16) {
        this.chin = f16;
        reportPropertyChange("chin", Float.valueOf(f16));
    }

    public void setEditMode(boolean z16) {
        this.editMode = z16;
        reportPropertyChange("editMode", Boolean.valueOf(z16));
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

    public void setFacejaw(float f16) {
        this.facejaw = f16;
        reportPropertyChange("facejaw", Float.valueOf(f16));
    }

    public void setFixPoints(boolean z16) {
        this.fixPoints = z16;
        reportPropertyChange("fixPoints", Boolean.valueOf(z16));
    }

    public void setForeHead(float f16) {
        this.foreHead = f16;
        reportPropertyChange("foreHead", Float.valueOf(f16));
    }

    public void setHeight(int i3) {
        this.height = i3;
        reportPropertyChange("height", Integer.valueOf(i3));
    }

    public void setLastPoints(ArrayList<PointItem> arrayList) {
        this.lastPoints = arrayList;
        reportPropertyChange("lastPoints", arrayList);
    }

    public void setLongNose(float f16) {
        this.longNose = f16;
        reportPropertyChange("longNose", Float.valueOf(f16));
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

    public void setOverallFactor(float f16) {
        this.overallFactor = f16;
        reportPropertyChange("overallFactor", Float.valueOf(f16));
    }

    public void setPinchFaceEnabled(boolean z16) {
        this.pinchFaceEnabled = z16;
        reportPropertyChange("pinchFaceEnabled", Boolean.valueOf(z16));
    }

    public void setPoints(ArrayList<PointItem> arrayList) {
        this.points = arrayList;
        reportPropertyChange("points", arrayList);
    }

    public void setReformSubType(String str) {
        this.reformSubType = str;
        reportPropertyChange("reformSubType", str);
    }

    public void setShortFace(float f16) {
        this.shortFace = f16;
        reportPropertyChange("shortFace", Float.valueOf(f16));
    }

    public void setStrength(float f16) {
        this.strength = f16;
        reportPropertyChange("strength", Float.valueOf(f16));
    }

    public void setStretchEnabled(boolean z16) {
        this.stretchEnabled = z16;
        reportPropertyChange("stretchEnabled", Boolean.valueOf(z16));
    }

    public void setSymmetry(boolean z16) {
        this.symmetry = z16;
        reportPropertyChange("symmetry", Boolean.valueOf(z16));
    }

    public void setThinFace(float f16) {
        this.thinFace = f16;
        reportPropertyChange("thinFace", Float.valueOf(f16));
    }

    public void setVFace(float f16) {
        this.vFace = f16;
        reportPropertyChange("vFace", Float.valueOf(f16));
    }

    public void setWidth(int i3) {
        this.width = i3;
        reportPropertyChange("width", Integer.valueOf(i3));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "FacialReform";
    }
}
