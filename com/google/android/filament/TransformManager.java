package com.google.android.filament;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TransformManager {
    private long mNativeObject;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformManager(long j3) {
        this.mNativeObject = j3;
    }

    private static native void nCommitLocalTransformTransaction(long j3);

    private static native int nCreate(long j3, int i3);

    private static native int nCreateArray(long j3, int i3, int i16, float[] fArr);

    private static native int nCreateArrayFp64(long j3, int i3, int i16, double[] dArr);

    private static native void nDestroy(long j3, int i3);

    private static native int nGetInstance(long j3, int i3);

    private static native int nGetParent(long j3, int i3);

    private static native void nGetTransform(long j3, int i3, float[] fArr);

    private static native void nGetTransformFp64(long j3, int i3, double[] dArr);

    private static native void nGetWorldTransform(long j3, int i3, float[] fArr);

    private static native void nGetWorldTransformFp64(long j3, int i3, double[] dArr);

    private static native boolean nHasComponent(long j3, int i3);

    private static native boolean nIsAccurateTranslationsEnabled(long j3);

    private static native void nOpenLocalTransformTransaction(long j3);

    private static native void nSetAccurateTranslationsEnabled(long j3, boolean z16);

    private static native void nSetParent(long j3, int i3, int i16);

    private static native void nSetTransform(long j3, int i3, float[] fArr);

    private static native void nSetTransformFp64(long j3, int i3, double[] dArr);

    public void commitLocalTransformTransaction() {
        nCommitLocalTransformTransaction(this.mNativeObject);
    }

    @EntityInstance
    public int create(@Entity int i3) {
        return nCreate(this.mNativeObject, i3);
    }

    public void destroy(@Entity int i3) {
        nDestroy(this.mNativeObject, i3);
    }

    @EntityInstance
    public int getInstance(@Entity int i3) {
        return nGetInstance(this.mNativeObject, i3);
    }

    public long getNativeObject() {
        return this.mNativeObject;
    }

    @Entity
    public int getParent(@EntityInstance int i3) {
        return nGetParent(this.mNativeObject, i3);
    }

    @NonNull
    @Size(min = 16)
    public float[] getTransform(@EntityInstance int i3, @Nullable @Size(min = 16) float[] fArr) {
        float[] assertMat4f = Asserts.assertMat4f(fArr);
        nGetTransform(this.mNativeObject, i3, assertMat4f);
        return assertMat4f;
    }

    @NonNull
    @Size(min = 16)
    public float[] getWorldTransform(@EntityInstance int i3, @Nullable @Size(min = 16) float[] fArr) {
        float[] assertMat4f = Asserts.assertMat4f(fArr);
        nGetWorldTransform(this.mNativeObject, i3, assertMat4f);
        return assertMat4f;
    }

    public boolean hasComponent(@Entity int i3) {
        return nHasComponent(this.mNativeObject, i3);
    }

    public boolean isAccurateTranslationsEnabled() {
        return nIsAccurateTranslationsEnabled(this.mNativeObject);
    }

    public void openLocalTransformTransaction() {
        nOpenLocalTransformTransaction(this.mNativeObject);
    }

    public void setAccurateTranslationsEnabled(boolean z16) {
        nSetAccurateTranslationsEnabled(this.mNativeObject, z16);
    }

    public void setParent(@EntityInstance int i3, @EntityInstance int i16) {
        nSetParent(this.mNativeObject, i3, i16);
    }

    public void setTransform(@EntityInstance int i3, @NonNull @Size(min = 16) float[] fArr) {
        Asserts.assertMat4fIn(fArr);
        nSetTransform(this.mNativeObject, i3, fArr);
    }

    @EntityInstance
    public int create(@Entity int i3, @EntityInstance int i16, @Nullable @Size(min = 16) float[] fArr) {
        return nCreateArray(this.mNativeObject, i3, i16, fArr);
    }

    @EntityInstance
    public int create(@Entity int i3, @EntityInstance int i16, @Nullable @Size(min = 16) double[] dArr) {
        return nCreateArrayFp64(this.mNativeObject, i3, i16, dArr);
    }

    @NonNull
    @Size(min = 16)
    public double[] getTransform(@EntityInstance int i3, @Nullable @Size(min = 16) double[] dArr) {
        double[] assertMat4 = Asserts.assertMat4(dArr);
        nGetTransformFp64(this.mNativeObject, i3, assertMat4);
        return assertMat4;
    }

    @NonNull
    @Size(min = 16)
    public double[] getWorldTransform(@EntityInstance int i3, @Nullable @Size(min = 16) double[] dArr) {
        double[] assertMat4 = Asserts.assertMat4(dArr);
        nGetWorldTransformFp64(this.mNativeObject, i3, assertMat4);
        return assertMat4;
    }

    public void setTransform(@EntityInstance int i3, @NonNull @Size(min = 16) double[] dArr) {
        Asserts.assertMat4In(dArr);
        nSetTransformFp64(this.mNativeObject, i3, dArr);
    }
}
