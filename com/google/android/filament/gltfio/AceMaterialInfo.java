package com.google.android.filament.gltfio;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AceMaterialInfo {
    private long mNativeObject;

    public AceMaterialInfo(long j3) {
        this.mNativeObject = j3;
    }

    public static String getEngineVersion() {
        return nGetEngineVersion();
    }

    public static String getGlbInfo(String str) {
        return nGetGlbInfo(str);
    }

    private static native boolean nAddBone(long j3, String str);

    private static native boolean nDeleteBone(long j3, String str);

    private static native float[] nGetDirectionColor(long j3);

    private static native int nGetDirectionIntensity(long j3);

    private static native String nGetEngineVersion();

    private static native String nGetGlbInfo(String str);

    private static native int nGetIblIntensity(long j3);

    private static native int nGetIblRotation(long j3);

    private static native float[] nGetLightDirection(long j3);

    private static native float[] nGetPosition(long j3);

    private static native float[] nGetRotation(long j3);

    private static native float[] nGetScale(long j3);

    private static native void nSetDirectionColor(long j3, float f16, float f17, float f18);

    private static native void nSetDirectionIntensity(long j3, int i3);

    private static native void nSetIblDegree(long j3, float f16);

    private static native void nSetIblIntensity(long j3, int i3);

    private static native void nSetLightDirection(long j3, float f16, float f17, float f18);

    private static native void nSetPosition(long j3, float f16, float f17, float f18);

    private static native void nSetRotation(long j3, float f16, float f17, float f18);

    private static native void nSetScale(long j3, float f16, float f17, float f18);

    private static native boolean nUpdateBoneGravity(long j3, String str, float[] fArr);

    private static native boolean nUpdateBoneNoRotation(long j3, String str, int i3);

    private static native boolean nUpdateBoneParams(long j3, String str, int i3, String str2, float f16);

    private static native void nUpdateIntensityMap(long j3, float[] fArr, float[] fArr2);

    public void addBone(String str) {
        nAddBone(this.mNativeObject, str);
    }

    public void deleteBone(String str) {
        nDeleteBone(this.mNativeObject, str);
    }

    public float[] getDirectionColor() {
        return nGetDirectionColor(this.mNativeObject);
    }

    public int getDirectionIntensity() {
        return nGetDirectionIntensity(this.mNativeObject);
    }

    public int getIblIntensity() {
        return nGetIblIntensity(this.mNativeObject);
    }

    public int getIblRotation() {
        return nGetIblRotation(this.mNativeObject);
    }

    public float[] getLightDirection() {
        return nGetLightDirection(this.mNativeObject);
    }

    public float[] getPosition() {
        return nGetPosition(this.mNativeObject);
    }

    public float[] getRotation() {
        return nGetRotation(this.mNativeObject);
    }

    public float[] getScale() {
        return nGetScale(this.mNativeObject);
    }

    public void setDirectionColor(float f16, float f17, float f18) {
        nSetDirectionColor(this.mNativeObject, f16, f17, f18);
    }

    public void setDirectionIntensity(int i3) {
        nSetDirectionIntensity(this.mNativeObject, i3);
    }

    public void setIblDegree(float f16) {
        nSetIblDegree(this.mNativeObject, f16);
    }

    public void setIblIntensity(int i3) {
        nSetIblIntensity(this.mNativeObject, i3);
    }

    public void setLightDirection(float f16, float f17, float f18) {
        nSetLightDirection(this.mNativeObject, f16, f17, f18);
    }

    public void setPosition(float f16, float f17, float f18) {
        nSetPosition(this.mNativeObject, f16, f17, f18);
    }

    public void setRotation(float f16, float f17, float f18) {
        nSetRotation(this.mNativeObject, f16, f17, f18);
    }

    public void setScale(float f16, float f17, float f18) {
        nSetScale(this.mNativeObject, f16, f17, f18);
    }

    public boolean updateBoneGravity(String str, float[] fArr) {
        return nUpdateBoneGravity(this.mNativeObject, str, fArr);
    }

    public boolean updateBoneNoRotation(String str, int i3) {
        return nUpdateBoneNoRotation(this.mNativeObject, str, i3);
    }

    public boolean updateBoneParams(String str, int i3, String str2, float f16) {
        return nUpdateBoneParams(this.mNativeObject, str, i3, str2, f16);
    }

    public void updateIntensityMap(float[] fArr, float[] fArr2) {
        nUpdateIntensityMap(this.mNativeObject, fArr, fArr2);
    }
}
