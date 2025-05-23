package com.google.android.filament;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FilamentJNI {

    /* renamed from: camera, reason: collision with root package name */
    private Camera f32957camera;
    private long currentTime = 0;
    private Engine engine;
    private long mNativeObject;
    private View view;

    FilamentJNI(long j3) {
        this.mNativeObject = j3;
    }

    @NonNull
    public static FilamentJNI create(@NonNull Object obj, Object obj2, int i3, int i16, String str, String str2, byte[] bArr, boolean z16, int i17) {
        if (obj2 == null) {
            return new FilamentJNI(nCreateFilamentAsset(obj, 0L, i3, i16, str, str2, bArr, z16, i17));
        }
        return new FilamentJNI(nCreateFilamentAsset(obj, Platform.get().getSharedContextNativeHandle(obj2), i3, i16, str, str2, bArr, z16, i17));
    }

    private static native void nAdjustKapuModelView(long j3, int i3, float[] fArr, float[] fArr2, float f16);

    private static native boolean nCanUseShareContext(long j3);

    private static native void nChangeAssetsDynamic(long j3, int[] iArr, int i3, int[] iArr2, int i16);

    private static native long nCreateFilamentAsset(Object obj, long j3, int i3, int i16, String str, String str2, byte[] bArr, boolean z16, int i17);

    private static native void nDestroy(long j3);

    private static native void nFitIntoUnitCube(long j3);

    private static native boolean nGetAnimationOver(long j3);

    private static native float[] nGetAnimationTime(long j3, String str);

    private static native long nGetCamera(long j3);

    private static native long nGetEngine(long j3);

    private static native float[] nGetFilamentAssetPosition(long j3);

    private static native long[] nGetFilamentAssets(long j3);

    private static native long[] nGetHitTestFilamentAssets(long j3, float[] fArr);

    private static native int nGetMaxFaceCount(long j3);

    private static native long nGetView(long j3);

    private static native boolean nIsAnimationRunning(long j3, String str);

    private static native void nLoadAllData(long j3);

    private static native void nLoadData(long j3);

    private static native void nNewFurLayers(long j3, int i3);

    private static native void nPauseAnimation(long j3);

    private static native void nPlayAnimation(long j3, String str, int i3);

    private static native void nPlayKapuAnimation(long j3);

    private static native void nRegisterAnimation(long j3, String[] strArr);

    private static native void nRender(long j3, float f16);

    private static native void nReset(long j3);

    private static native void nResize(long j3, int i3, int i16);

    private static native void nResumeAnimation(long j3);

    private static native void nRotateArModelToFront(long j3, int i3);

    private static native void nSetAssetRotate(long j3, float[] fArr);

    private static native void nSetAverageL(long j3, float f16);

    private static native void nSetBaseColorImage(long j3, String str, String str2, long j16);

    private static native void nSetCameraAnimation(long j3, float[] fArr, float[] fArr2, float f16, int i3);

    private static native void nSetDisplayMaterialTypeList(long j3, int i3, String[] strArr);

    private static native void nSetDynamicTexture(long j3, String[] strArr, long[] jArr);

    private static native void nSetFilamentAssetRotate(long j3, int i3, float[] fArr);

    private static native void nSetFilamentAssetScale(long j3, int i3, float f16, float[] fArr);

    private static native boolean nSetGlbData(long j3, String str, byte[] bArr);

    private static native void nSetHeadCount(long j3, int i3);

    private static native void nSetHitTestAfterUnprojection(long j3, int i3, float[] fArr);

    private static native void nSetImage(long j3, long j16);

    private static native void nSetKapuAnimation(long j3);

    private static native void nSetKapuHeadTransform(long j3, int i3, float[] fArr);

    private static native void nSetKapuMorphWeights(long j3, int i3, String[] strArr, float[] fArr);

    private static native void nSetMaterialImage(long j3, int i3, int i16, String str, String str2, String str3, boolean z16);

    private static native void nSetMaterialTransform(long j3, int i3, float[] fArr, float[] fArr2, float[] fArr3);

    private static native void nSetMorphWeights(long j3, String str, float[] fArr, int i3, int i16);

    private static native void nSetMvpMatrix(long j3, float[] fArr, float f16);

    private static native void nSetOutputPath(long j3, String str);

    private static native void nSetupKapuModelTransform(long j3);

    private static native void nSetupLoaders(long j3, long[] jArr);

    private static native void nShowArShadowPlane(long j3, float[] fArr, float[] fArr2);

    private static native void nShowOrHideAsset(long j3, int i3, int i16, boolean z16);

    private static native void nShowOrHideAssetEntity(long j3, int i3, int i16, String str, boolean z16);

    private static native void nStopAnimation(long j3, String str);

    private static native void nUpdateAnimationTrigger(long j3, String[] strArr);

    private static native void nUpdateEyeNodeEuler(long j3, String str, float[] fArr, int i3, int i16);

    private static native void nUpdateFaceVertices(long j3, int i3, float[] fArr);

    private static native void nUpdateMesh(long j3, String str, float[] fArr);

    private static native void nUpdateMeshMorph(long j3, String str, int i3, float[] fArr);

    private static native void nUpdateMeshMorphBase(long j3, String str, float[] fArr);

    public boolean canUseShareContext() {
        return nCanUseShareContext(this.mNativeObject);
    }

    public void changeAssetsDynamic(int[] iArr, int i3, int[] iArr2, int i16) {
        nChangeAssetsDynamic(this.mNativeObject, iArr, i3, iArr2, i16);
    }

    public void destroy() {
        nDestroy(this.mNativeObject);
    }

    public void fitIntoUnitCube() {
        nFitIntoUnitCube(this.mNativeObject);
    }

    public boolean getAnimationOver() {
        return nGetAnimationOver(this.mNativeObject);
    }

    public float[] getAnimationTime(String str) {
        return nGetAnimationTime(this.mNativeObject, str);
    }

    public Camera getCamera() {
        if (this.f32957camera == null) {
            this.f32957camera = new Camera(nGetCamera(this.mNativeObject), 0);
        }
        return this.f32957camera;
    }

    public Engine getEngine() {
        if (this.engine == null) {
            this.engine = new Engine(nGetEngine(this.mNativeObject));
        }
        return this.engine;
    }

    public float[] getFilamentAssetPosition() {
        return nGetFilamentAssetPosition(this.mNativeObject);
    }

    public long[] getFilamentAssets() {
        return nGetFilamentAssets(this.mNativeObject);
    }

    public long[] getHitTestFilamentAssets(float[] fArr) {
        return nGetHitTestFilamentAssets(this.mNativeObject, fArr);
    }

    public int getMaxFaceCount() {
        return nGetMaxFaceCount(this.mNativeObject);
    }

    public long getNativeObject() {
        return this.mNativeObject;
    }

    public View getView() {
        if (this.view == null) {
            this.view = new View(nGetView(this.mNativeObject));
        }
        return this.view;
    }

    public boolean isAnimationRunning(String str) {
        return nIsAnimationRunning(this.mNativeObject, str);
    }

    public void loadAllData() {
        nLoadAllData(this.mNativeObject);
    }

    public void loadDataForCMShow() {
        nLoadData(this.mNativeObject);
    }

    public void pauseAnimation() {
        nPauseAnimation(this.mNativeObject);
    }

    public void playAnimation(String str, int i3) {
        nPlayAnimation(this.mNativeObject, str, i3);
    }

    public void registerAnimation(String[] strArr) {
        nRegisterAnimation(this.mNativeObject, strArr);
    }

    public void render() {
        if (this.currentTime == 0) {
            this.currentTime = System.currentTimeMillis();
        }
        long currentTimeMillis = System.currentTimeMillis();
        nRender(this.mNativeObject, ((float) (currentTimeMillis - this.currentTime)) / 1000.0f);
        this.currentTime = currentTimeMillis;
    }

    public void reset() {
        nReset(this.mNativeObject);
    }

    public void resize(int i3, int i16) {
        nResize(this.mNativeObject, i3, i16);
    }

    public void resumeAnimation() {
        nResumeAnimation(this.mNativeObject);
    }

    public void rotateArModelToFront(int i3) {
        nRotateArModelToFront(this.mNativeObject, i3);
    }

    public void setAssetRotate(float[] fArr) {
        nSetAssetRotate(this.mNativeObject, fArr);
    }

    public void setAverageL(float f16) {
        nSetAverageL(this.mNativeObject, f16);
    }

    public void setCameraAnimation(float[] fArr, float[] fArr2, float f16, int i3) {
        nSetCameraAnimation(this.mNativeObject, fArr, fArr2, f16, i3);
    }

    public void setDynamicTexture(String[] strArr, long[] jArr) {
        nSetDynamicTexture(this.mNativeObject, strArr, jArr);
    }

    public void setFilamentAssetRotate(int i3, float[] fArr) {
        nSetFilamentAssetRotate(this.mNativeObject, i3, fArr);
    }

    public void setFilamentAssetScale(int i3, float f16, float[] fArr) {
        nSetFilamentAssetScale(this.mNativeObject, i3, f16, fArr);
    }

    public boolean setGlbData(String str, byte[] bArr) {
        return nSetGlbData(this.mNativeObject, str, bArr);
    }

    public void setHeadCount(int i3) {
        nSetHeadCount(this.mNativeObject, i3);
    }

    public void setHitTestAfterUnprojection(int i3, float[] fArr) {
        nSetHitTestAfterUnprojection(this.mNativeObject, i3, fArr);
    }

    public void setImage(Texture texture) {
        nSetImage(this.mNativeObject, texture.getNativeObject());
    }

    public void setMaterialImage(String str, String str2, Texture texture) {
        nSetBaseColorImage(this.mNativeObject, str, str2, texture.getNativeObject());
    }

    public void setMaterialTransform(int i3, float[] fArr, float[] fArr2, float[] fArr3) {
        nSetMaterialTransform(this.mNativeObject, i3, fArr, fArr2, fArr3);
    }

    public void setMorphWeights(String str, float[] fArr, int i3, int i16) {
        nSetMorphWeights(this.mNativeObject, str, fArr, i3, i16);
    }

    public void setMvpMatrix(float[] fArr, float f16) {
        nSetMvpMatrix(this.mNativeObject, fArr, f16);
    }

    public void setNewFurLayers(int i3) {
        nNewFurLayers(this.mNativeObject, i3);
    }

    public void setOutputPath(String str) {
        nSetOutputPath(this.mNativeObject, str);
    }

    public void setupLoaders(long[] jArr) {
        nSetupLoaders(this.mNativeObject, jArr);
    }

    public void showArShadowPlane(float[] fArr, float[] fArr2) {
        nShowArShadowPlane(this.mNativeObject, fArr, fArr2);
    }

    public void showOrHideAsset(int i3, int i16, boolean z16) {
        nShowOrHideAsset(this.mNativeObject, i3, i16, z16);
    }

    public void showOrHideAssetEntity(int i3, int i16, String str, boolean z16) {
        nShowOrHideAssetEntity(this.mNativeObject, i3, i16, str, z16);
    }

    public void stopAnimation(String str) {
        nStopAnimation(this.mNativeObject, str);
    }

    public void updateAnimationTrigger(String[] strArr) {
        nUpdateAnimationTrigger(this.mNativeObject, strArr);
    }

    public void updateEyeNodeEuler(String str, float[] fArr, int i3, int i16) {
        nUpdateEyeNodeEuler(this.mNativeObject, str, fArr, i3, i16);
    }

    public void updateFaceVertices(int i3, float[] fArr) {
        nUpdateFaceVertices(this.mNativeObject, i3, fArr);
    }

    public void updateMesh(String str, float[] fArr) {
        nUpdateMesh(this.mNativeObject, str, fArr);
    }

    public void updateMeshMorph(String str, int i3, float[] fArr) {
        nUpdateMeshMorph(this.mNativeObject, str, i3, fArr);
    }

    public void updateMeshMorphBase(String str, float[] fArr) {
        nUpdateMeshMorphBase(this.mNativeObject, str, fArr);
    }

    public void setMaterialImage(int i3, int i16, String str, String str2, String str3, boolean z16) {
        nSetMaterialImage(this.mNativeObject, i3, i16, str, str2, str3, z16);
    }

    public void initKapuModelPosition() {
    }

    public void playKapuAnimation() {
    }

    public void setKapuAnimation() {
    }

    public void setKapuDisplayMaterialTypeList(int i3, String[] strArr) {
    }

    public void setKapuHeadTransform(int i3, float[] fArr) {
    }

    public void setKapuWeights(int i3, String[] strArr, float[] fArr) {
    }

    public void adjustKapuModelView(int i3, float[] fArr, float[] fArr2, float f16) {
    }
}
