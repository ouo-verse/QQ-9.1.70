package com.google.android.filament;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Camera {

    @Entity
    private final int mEntity;
    private long mNativeObject;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Fov {
        VERTICAL,
        HORIZONTAL
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Projection {
        PERSPECTIVE,
        ORTHO
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Camera(long j3, @Entity int i3) {
        this.mNativeObject = j3;
        this.mEntity = i3;
    }

    static double computeEffectiveFocalLength(double d16, double d17) {
        return nComputeEffectiveFocalLength(d16, d17);
    }

    static double computeEffectiveFov(double d16, double d17) {
        return nComputeEffectiveFov(d16, d17);
    }

    private static native double nComputeEffectiveFocalLength(double d16, double d17);

    private static native double nComputeEffectiveFov(double d16, double d17);

    private static native float nGetAperture(long j3);

    private static native float nGetCullingFar(long j3);

    private static native void nGetCullingProjectionMatrix(long j3, double[] dArr);

    private static native double nGetFocalLength(long j3);

    private static native float nGetFocusDistance(long j3);

    private static native void nGetForwardVector(long j3, float[] fArr);

    private static native void nGetLeftVector(long j3, float[] fArr);

    private static native void nGetModelMatrix(long j3, float[] fArr);

    private static native void nGetModelMatrixFp64(long j3, double[] dArr);

    private static native float nGetNear(long j3);

    private static native void nGetPosition(long j3, float[] fArr);

    private static native void nGetProjectionMatrix(long j3, double[] dArr);

    private static native void nGetScaling(long j3, double[] dArr);

    private static native float nGetSensitivity(long j3);

    private static native float nGetShutterSpeed(long j3);

    private static native void nGetUpVector(long j3, float[] fArr);

    private static native void nGetViewMatrix(long j3, float[] fArr);

    private static native void nGetViewMatrixFp64(long j3, double[] dArr);

    private static native void nLookAt(long j3, double d16, double d17, double d18, double d19, double d26, double d27, double d28, double d29, double d36);

    private static native void nSetCustomProjection(long j3, double[] dArr, double[] dArr2, double d16, double d17);

    private static native void nSetExposure(long j3, float f16, float f17, float f18);

    private static native void nSetFocusDistance(long j3, float f16);

    private static native void nSetLensProjection(long j3, double d16, double d17, double d18, double d19);

    private static native void nSetModelMatrix(long j3, float[] fArr);

    private static native void nSetModelMatrixFp64(long j3, double[] dArr);

    private static native void nSetProjection(long j3, int i3, double d16, double d17, double d18, double d19, double d26, double d27);

    private static native void nSetProjectionFov(long j3, double d16, double d17, double d18, double d19, int i3);

    private static native void nSetScaling(long j3, double d16, double d17);

    private static native void nSetShift(long j3, double d16, double d17);

    void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    public float getAperture() {
        return nGetAperture(getNativeObject());
    }

    public float getCullingFar() {
        return nGetCullingFar(getNativeObject());
    }

    @NonNull
    @Size(min = 16)
    public double[] getCullingProjectionMatrix(@Nullable @Size(min = 16) double[] dArr) {
        double[] assertMat4d = Asserts.assertMat4d(dArr);
        nGetCullingProjectionMatrix(getNativeObject(), assertMat4d);
        return assertMat4d;
    }

    @Entity
    public int getEntity() {
        return this.mEntity;
    }

    public double getFocalLength() {
        return nGetFocalLength(getNativeObject());
    }

    public float getFocusDistance() {
        return nGetFocusDistance(getNativeObject());
    }

    @NonNull
    @Size(min = 3)
    public float[] getForwardVector(@Nullable @Size(min = 3) float[] fArr) {
        float[] assertFloat3 = Asserts.assertFloat3(fArr);
        nGetForwardVector(getNativeObject(), assertFloat3);
        return assertFloat3;
    }

    @NonNull
    @Size(min = 3)
    public float[] getLeftVector(@Nullable @Size(min = 3) float[] fArr) {
        float[] assertFloat3 = Asserts.assertFloat3(fArr);
        nGetLeftVector(getNativeObject(), assertFloat3);
        return assertFloat3;
    }

    @NonNull
    @Size(min = 16)
    public float[] getModelMatrix(@Nullable @Size(min = 16) float[] fArr) {
        float[] assertMat4f = Asserts.assertMat4f(fArr);
        nGetModelMatrix(getNativeObject(), assertMat4f);
        return assertMat4f;
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed Camera");
    }

    public float getNear() {
        return nGetNear(getNativeObject());
    }

    @NonNull
    @Size(min = 3)
    public float[] getPosition(@Nullable @Size(min = 3) float[] fArr) {
        float[] assertFloat3 = Asserts.assertFloat3(fArr);
        nGetPosition(getNativeObject(), assertFloat3);
        return assertFloat3;
    }

    @NonNull
    @Size(min = 16)
    public double[] getProjectionMatrix(@Nullable @Size(min = 16) double[] dArr) {
        double[] assertMat4d = Asserts.assertMat4d(dArr);
        nGetProjectionMatrix(getNativeObject(), assertMat4d);
        return assertMat4d;
    }

    @NonNull
    @Size(min = 4)
    public double[] getScaling(@Nullable @Size(min = 4) double[] dArr) {
        double[] assertDouble4 = Asserts.assertDouble4(dArr);
        nGetScaling(getNativeObject(), assertDouble4);
        return assertDouble4;
    }

    public float getSensitivity() {
        return nGetSensitivity(getNativeObject());
    }

    public float getShutterSpeed() {
        return nGetShutterSpeed(getNativeObject());
    }

    @NonNull
    @Size(min = 3)
    public float[] getUpVector(@Nullable @Size(min = 3) float[] fArr) {
        float[] assertFloat3 = Asserts.assertFloat3(fArr);
        nGetUpVector(getNativeObject(), assertFloat3);
        return assertFloat3;
    }

    @NonNull
    @Size(min = 16)
    public float[] getViewMatrix(@Nullable @Size(min = 16) float[] fArr) {
        float[] assertMat4f = Asserts.assertMat4f(fArr);
        nGetViewMatrix(getNativeObject(), assertMat4f);
        return assertMat4f;
    }

    public void lookAt(double d16, double d17, double d18, double d19, double d26, double d27, double d28, double d29, double d36) {
        nLookAt(getNativeObject(), d16, d17, d18, d19, d26, d27, d28, d29, d36);
    }

    public void setCustomProjection(@NonNull @Size(min = 16) double[] dArr, double d16, double d17) {
        Asserts.assertMat4dIn(dArr);
        nSetCustomProjection(getNativeObject(), dArr, dArr, d16, d17);
    }

    public void setExposure(float f16, float f17, float f18) {
        nSetExposure(getNativeObject(), f16, f17, f18);
    }

    public void setFocusDistance(float f16) {
        nSetFocusDistance(getNativeObject(), f16);
    }

    public void setLensProjection(double d16, double d17, double d18, double d19) {
        nSetLensProjection(getNativeObject(), d16, d17, d18, d19);
    }

    public void setModelMatrix(@NonNull @Size(min = 16) float[] fArr) {
        Asserts.assertMat4fIn(fArr);
        nSetModelMatrix(getNativeObject(), fArr);
    }

    public void setProjection(@NonNull Projection projection, double d16, double d17, double d18, double d19, double d26, double d27) {
        nSetProjection(getNativeObject(), projection.ordinal(), d16, d17, d18, d19, d26, d27);
    }

    public void setScaling(double d16, double d17) {
        nSetScaling(getNativeObject(), d16, d17);
    }

    public void setShift(double d16, double d17) {
        nSetShift(getNativeObject(), d16, d17);
    }

    public void setExposure(float f16) {
        setExposure(1.0f, 1.2f, (1.0f / f16) * 100.0f);
    }

    public void setProjection(double d16, double d17, double d18, double d19, @NonNull Fov fov) {
        nSetProjectionFov(getNativeObject(), d16, d17, d18, d19, fov.ordinal());
    }

    @Deprecated
    public void setScaling(@NonNull @Size(min = 4) double[] dArr) {
        Asserts.assertDouble4In(dArr);
        setScaling(dArr[0], dArr[1]);
    }

    @NonNull
    @Size(min = 16)
    public double[] getModelMatrix(@Nullable @Size(min = 16) double[] dArr) {
        double[] assertMat4 = Asserts.assertMat4(dArr);
        nGetModelMatrixFp64(getNativeObject(), assertMat4);
        return assertMat4;
    }

    @NonNull
    @Size(min = 16)
    public double[] getViewMatrix(@Nullable @Size(min = 16) double[] dArr) {
        double[] assertMat4 = Asserts.assertMat4(dArr);
        nGetViewMatrixFp64(getNativeObject(), assertMat4);
        return assertMat4;
    }

    public void setCustomProjection(@NonNull @Size(min = 16) double[] dArr, @NonNull @Size(min = 16) double[] dArr2, double d16, double d17) {
        Asserts.assertMat4dIn(dArr);
        Asserts.assertMat4dIn(dArr2);
        nSetCustomProjection(getNativeObject(), dArr, dArr2, d16, d17);
    }

    public void setModelMatrix(@NonNull @Size(min = 16) double[] dArr) {
        Asserts.assertMat4In(dArr);
        nSetModelMatrixFp64(getNativeObject(), dArr);
    }
}
