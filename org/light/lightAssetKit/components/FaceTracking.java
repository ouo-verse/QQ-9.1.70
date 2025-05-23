package org.light.lightAssetKit.components;

import java.util.ArrayList;
import java.util.Arrays;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FaceTracking extends TrackingComponent {
    private boolean isWaitFirstFrameDetect = false;
    private boolean isAllFrameDetect = false;
    private boolean isRefine = true;
    private float zOffset = 0.0f;
    private ArrayList<Integer> faceIndex = new ArrayList<>(Arrays.asList(0));
    private String genderBinding = "";
    private int maxTrackingNum = 5;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.TrackingComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof FaceTracking) {
            FaceTracking faceTracking = (FaceTracking) componentBase;
            this.isWaitFirstFrameDetect = faceTracking.isWaitFirstFrameDetect;
            this.isAllFrameDetect = faceTracking.isAllFrameDetect;
            this.isRefine = faceTracking.isRefine;
            this.zOffset = faceTracking.zOffset;
            this.faceIndex = faceTracking.faceIndex;
            this.genderBinding = faceTracking.genderBinding;
            this.maxTrackingNum = faceTracking.maxTrackingNum;
        }
        super.doUpdate(componentBase);
    }

    public ArrayList<Integer> getFaceIndex() {
        return this.faceIndex;
    }

    public String getGenderBinding() {
        return this.genderBinding;
    }

    public boolean getIsAllFrameDetect() {
        return this.isAllFrameDetect;
    }

    public boolean getIsRefine() {
        return this.isRefine;
    }

    public boolean getIsWaitFirstFrameDetect() {
        return this.isWaitFirstFrameDetect;
    }

    public int getMaxTrackingNum() {
        return this.maxTrackingNum;
    }

    public float getZOffset() {
        return this.zOffset;
    }

    public void setFaceIndex(ArrayList<Integer> arrayList) {
        this.faceIndex = arrayList;
        reportPropertyChange("faceIndex", arrayList);
    }

    public void setGenderBinding(String str) {
        this.genderBinding = str;
        reportPropertyChange("genderBinding", str);
    }

    public void setIsAllFrameDetect(boolean z16) {
        this.isAllFrameDetect = z16;
        reportPropertyChange("isAllFrameDetect", Boolean.valueOf(z16));
    }

    public void setIsRefine(boolean z16) {
        this.isRefine = z16;
        reportPropertyChange("isRefine", Boolean.valueOf(z16));
    }

    public void setIsWaitFirstFrameDetect(boolean z16) {
        this.isWaitFirstFrameDetect = z16;
        reportPropertyChange("isWaitFirstFrameDetect", Boolean.valueOf(z16));
    }

    public void setMaxTrackingNum(int i3) {
        this.maxTrackingNum = i3;
        reportPropertyChange("maxTrackingNum", Integer.valueOf(i3));
    }

    public void setZOffset(float f16) {
        this.zOffset = f16;
        reportPropertyChange("zOffset", Float.valueOf(f16));
    }

    @Override // org.light.lightAssetKit.components.TrackingComponent, org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "FaceTracking";
    }
}
