package com.google.android.filament.gltfio;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.filament.Box;
import com.google.android.filament.Engine;
import com.google.android.filament.Entity;
import com.google.android.filament.MaterialInstance;

/* compiled from: P */
/* loaded from: classes2.dex */
public class FilamentAsset {
    private Animator mAnimator = null;
    private Engine mEngine;
    private long mNativeObject;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilamentAsset(Engine engine, long j3) {
        this.mEngine = engine;
        this.mNativeObject = j3;
    }

    private static native void nApplyMaterialVariant(long j3, int i3);

    private static native void nAttachSkin(long j3, int i3, int i16);

    private static native void nDetachSkin(long j3, int i3, int i16);

    private static native long nGetAnimator(long j3);

    private static native void nGetBoundingBox(long j3, float[] fArr);

    private static native void nGetCameraEntities(long j3, int[] iArr);

    private static native int nGetCameraEntityCount(long j3);

    private static native void nGetEntities(long j3, int[] iArr);

    private static native int nGetEntitiesByName(long j3, String str, int[] iArr);

    private static native int nGetEntitiesByPrefix(long j3, String str, int[] iArr);

    private static native int nGetEntityCount(long j3);

    private static native String nGetExtras(long j3, int i3);

    private static native int nGetFirstEntityByName(long j3, String str);

    private static native int nGetJointCountAt(long j3, int i3);

    private static native void nGetJointsAt(long j3, int i3, int[] iArr);

    private static native void nGetLightEntities(long j3, int[] iArr);

    private static native int nGetLightEntityCount(long j3);

    private static native int nGetMaterialInstanceCount(long j3);

    private static native void nGetMaterialInstances(long j3, long[] jArr);

    private static native int nGetMaterialVariantCount(long j3);

    private static native void nGetMaterialVariantNames(long j3, String[] strArr);

    private static native int nGetMorphTargetCount(long j3, int i3);

    private static native void nGetMorphTargetNames(long j3, int i3, String[] strArr);

    private static native String nGetName(long j3, int i3);

    private static native void nGetRenderableEntities(long j3, int[] iArr);

    private static native int nGetRenderableEntityCount(long j3);

    private static native int nGetResourceUriCount(long j3);

    private static native void nGetResourceUris(long j3, String[] strArr);

    private static native int nGetRoot(long j3);

    private static native int nGetSkinCount(long j3);

    private static native void nGetSkinNames(long j3, String[] strArr);

    private static native int nPopRenderable(long j3);

    private static native int nPopRenderables(long j3, int[] iArr);

    private static native void nReleaseSourceData(long j3);

    private static native void nSetMorphBuffer(long j3, String str);

    private static native void nSetMorphWeights(long j3, String str, float[] fArr);

    private static native void nUpdateMorphWeights(long j3, String str, float[] fArr);

    public void applyMaterialVariant(@IntRange(from = 0) int i3) {
        nApplyMaterialVariant(getNativeObject(), i3);
    }

    public void attachSkin(@IntRange(from = 0) int i3, @Entity int i16) {
        nAttachSkin(getNativeObject(), i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.clearNativeObject();
        }
        this.mNativeObject = 0L;
    }

    public void detachSkin(@IntRange(from = 0) int i3, @Entity int i16) {
        nDetachSkin(getNativeObject(), i3, i16);
    }

    @NonNull
    public Animator getAnimator() {
        Animator animator = this.mAnimator;
        if (animator != null) {
            return animator;
        }
        long nGetAnimator = nGetAnimator(getNativeObject());
        if (nGetAnimator != 0) {
            Animator animator2 = new Animator(nGetAnimator);
            this.mAnimator = animator2;
            return animator2;
        }
        throw new IllegalStateException("Unable to create animator");
    }

    @NonNull
    public Box getBoundingBox() {
        float[] fArr = new float[6];
        nGetBoundingBox(this.mNativeObject, fArr);
        return new Box(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
    }

    @NonNull
    @Entity
    public int[] getCameraEntities() {
        int[] iArr = new int[nGetCameraEntityCount(this.mNativeObject)];
        nGetCameraEntities(this.mNativeObject, iArr);
        return iArr;
    }

    @NonNull
    @Entity
    public int[] getEntities() {
        int[] iArr = new int[nGetEntityCount(this.mNativeObject)];
        nGetEntities(this.mNativeObject, iArr);
        return iArr;
    }

    @NonNull
    @Entity
    public int[] getEntitiesByName(String str) {
        int[] iArr = new int[nGetEntitiesByName(this.mNativeObject, str, null)];
        nGetEntitiesByName(this.mNativeObject, str, iArr);
        return iArr;
    }

    @NonNull
    @Entity
    public int[] getEntitiesByPrefix(String str) {
        int[] iArr = new int[nGetEntitiesByPrefix(this.mNativeObject, str, null)];
        nGetEntitiesByPrefix(this.mNativeObject, str, iArr);
        return iArr;
    }

    @Nullable
    public String getExtras(@Entity int i3) {
        return nGetExtras(this.mNativeObject, i3);
    }

    @Entity
    public int getFirstEntityByName(String str) {
        return nGetFirstEntityByName(this.mNativeObject, str);
    }

    public int getJointCountAt(@IntRange(from = 0) int i3) {
        return nGetJointCountAt(getNativeObject(), i3);
    }

    @NonNull
    @Entity
    public int[] getJointsAt(@IntRange(from = 0) int i3) {
        int[] iArr = new int[getJointCountAt(i3)];
        nGetJointsAt(getNativeObject(), i3, iArr);
        return iArr;
    }

    @NonNull
    @Entity
    public int[] getLightEntities() {
        int[] iArr = new int[nGetLightEntityCount(this.mNativeObject)];
        nGetLightEntities(this.mNativeObject, iArr);
        return iArr;
    }

    @NonNull
    public MaterialInstance[] getMaterialInstances() {
        int nGetMaterialInstanceCount = nGetMaterialInstanceCount(this.mNativeObject);
        MaterialInstance[] materialInstanceArr = new MaterialInstance[nGetMaterialInstanceCount];
        long[] jArr = new long[nGetMaterialInstanceCount];
        nGetMaterialInstances(this.mNativeObject, jArr);
        for (int i3 = 0; i3 < nGetMaterialInstanceCount; i3++) {
            materialInstanceArr[i3] = new MaterialInstance(this.mEngine, jArr[i3]);
        }
        return materialInstanceArr;
    }

    @NonNull
    public String[] getMaterialVariantNames() {
        String[] strArr = new String[nGetMaterialVariantCount(this.mNativeObject)];
        nGetMaterialVariantNames(this.mNativeObject, strArr);
        return strArr;
    }

    @NonNull
    public String[] getMorphTargetNames(@Entity int i3) {
        String[] strArr = new String[nGetMorphTargetCount(this.mNativeObject, i3)];
        nGetMorphTargetNames(this.mNativeObject, i3, strArr);
        return strArr;
    }

    public String getName(@Entity int i3) {
        return nGetName(getNativeObject(), i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNativeObject() {
        return this.mNativeObject;
    }

    @NonNull
    @Entity
    public int[] getRenderableEntities() {
        int[] iArr = new int[nGetRenderableEntityCount(this.mNativeObject)];
        nGetRenderableEntities(this.mNativeObject, iArr);
        return iArr;
    }

    @NonNull
    public String[] getResourceUris() {
        String[] strArr = new String[nGetResourceUriCount(this.mNativeObject)];
        nGetResourceUris(this.mNativeObject, strArr);
        return strArr;
    }

    @Entity
    public int getRoot() {
        return nGetRoot(this.mNativeObject);
    }

    public int getSkinCount() {
        return nGetSkinCount(getNativeObject());
    }

    @NonNull
    public String[] getSkinNames() {
        String[] strArr = new String[getSkinCount()];
        nGetSkinNames(getNativeObject(), strArr);
        return strArr;
    }

    @Entity
    public int popRenderable() {
        return nPopRenderable(this.mNativeObject);
    }

    public int popRenderables(@Nullable @Entity int[] iArr) {
        return nPopRenderables(this.mNativeObject, iArr);
    }

    public void releaseSourceData() {
        nReleaseSourceData(this.mNativeObject);
    }

    public void setMorphWeights(String str, float[] fArr) {
        nSetMorphWeights(getNativeObject(), str, fArr);
    }

    public void updateMorphWeights(String str, float[] fArr) {
        nUpdateMorphWeights(getNativeObject(), str, fArr);
    }

    public void setMorphWeights(String str) {
        nSetMorphBuffer(getNativeObject(), str);
    }
}
