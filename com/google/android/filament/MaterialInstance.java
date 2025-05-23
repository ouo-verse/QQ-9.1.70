package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import com.google.android.filament.Colors;
import com.google.android.filament.Material;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialInstance {
    private Material mMaterial;
    private String mName;
    private long mNativeMaterial;
    private long mNativeObject;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum BooleanElement {
        BOOL,
        BOOL2,
        BOOL3,
        BOOL4
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum FloatElement {
        FLOAT,
        FLOAT2,
        FLOAT3,
        FLOAT4,
        MAT3,
        MAT4
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum IntElement {
        INT,
        INT2,
        INT3,
        INT4
    }

    public MaterialInstance(Engine engine, long j3) {
        this.mNativeObject = j3;
        this.mNativeMaterial = nGetMaterial(j3);
    }

    @NonNull
    public static MaterialInstance duplicate(@NonNull MaterialInstance materialInstance, String str) {
        long nDuplicate = nDuplicate(materialInstance.mNativeObject, str);
        if (nDuplicate != 0) {
            return new MaterialInstance(materialInstance.getMaterial(), nDuplicate);
        }
        throw new IllegalStateException("Couldn't duplicate MaterialInstance");
    }

    private static native long nDuplicate(long j3, String str);

    private static native long nGetMaterial(long j3);

    private static native String nGetName(long j3);

    private static native void nSetBooleanParameterArray(long j3, @NonNull String str, int i3, @NonNull @Size(min = 1) boolean[] zArr, @IntRange(from = 0) int i16, @IntRange(from = 1) int i17);

    private static native void nSetColorWrite(long j3, boolean z16);

    private static native void nSetCullingMode(long j3, long j16);

    private static native void nSetDepthCulling(long j3, boolean z16);

    private static native void nSetDepthWrite(long j3, boolean z16);

    private static native void nSetDoubleSided(long j3, boolean z16);

    private static native void nSetFloatParameterArray(long j3, @NonNull String str, int i3, @NonNull @Size(min = 1) float[] fArr, @IntRange(from = 0) int i16, @IntRange(from = 1) int i17);

    private static native void nSetIntParameterArray(long j3, @NonNull String str, int i3, @NonNull @Size(min = 1) int[] iArr, @IntRange(from = 0) int i16, @IntRange(from = 1) int i17);

    private static native void nSetMaskThreshold(long j3, float f16);

    private static native void nSetParameterBool(long j3, @NonNull String str, boolean z16);

    private static native void nSetParameterBool2(long j3, @NonNull String str, boolean z16, boolean z17);

    private static native void nSetParameterBool3(long j3, @NonNull String str, boolean z16, boolean z17, boolean z18);

    private static native void nSetParameterBool4(long j3, @NonNull String str, boolean z16, boolean z17, boolean z18, boolean z19);

    private static native void nSetParameterFloat(long j3, @NonNull String str, float f16);

    private static native void nSetParameterFloat2(long j3, @NonNull String str, float f16, float f17);

    private static native void nSetParameterFloat3(long j3, @NonNull String str, float f16, float f17, float f18);

    private static native void nSetParameterFloat4(long j3, @NonNull String str, float f16, float f17, float f18, float f19);

    private static native void nSetParameterInt(long j3, @NonNull String str, int i3);

    private static native void nSetParameterInt2(long j3, @NonNull String str, int i3, int i16);

    private static native void nSetParameterInt3(long j3, @NonNull String str, int i3, int i16, int i17);

    private static native void nSetParameterInt4(long j3, @NonNull String str, int i3, int i16, int i17, int i18);

    private static native void nSetParameterTexture(long j3, @NonNull String str, long j16, int i3);

    private static native void nSetPolygonOffset(long j3, float f16, float f17);

    private static native void nSetScissor(long j3, @IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18);

    private static native void nSetSpecularAntiAliasingThreshold(long j3, float f16);

    private static native void nSetSpecularAntiAliasingVariance(long j3, float f16);

    private static native void nUnsetScissor(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    @NonNull
    public Material getMaterial() {
        if (this.mMaterial == null) {
            this.mMaterial = new Material(this.mNativeMaterial);
        }
        return this.mMaterial;
    }

    @NonNull
    public String getName() {
        if (this.mName == null) {
            this.mName = nGetName(getNativeObject());
        }
        return this.mName;
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed MaterialInstance");
    }

    public void setColorWrite(boolean z16) {
        nSetColorWrite(getNativeObject(), z16);
    }

    public void setCullingMode(Material.CullingMode cullingMode) {
        nSetCullingMode(getNativeObject(), cullingMode.ordinal());
    }

    public void setDepthCulling(boolean z16) {
        nSetDepthCulling(getNativeObject(), z16);
    }

    public void setDepthWrite(boolean z16) {
        nSetDepthWrite(getNativeObject(), z16);
    }

    public void setDoubleSided(boolean z16) {
        nSetDoubleSided(getNativeObject(), z16);
    }

    public void setMaskThreshold(float f16) {
        nSetMaskThreshold(getNativeObject(), f16);
    }

    public void setParameter(@NonNull String str, boolean z16) {
        nSetParameterBool(getNativeObject(), str, z16);
    }

    public void setPolygonOffset(float f16, float f17) {
        nSetPolygonOffset(getNativeObject(), f16, f17);
    }

    public void setScissor(@IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18) {
        nSetScissor(getNativeObject(), i3, i16, i17, i18);
    }

    public void setSpecularAntiAliasingThreshold(float f16) {
        nSetSpecularAntiAliasingThreshold(getNativeObject(), f16);
    }

    public void setSpecularAntiAliasingVariance(float f16) {
        nSetSpecularAntiAliasingVariance(getNativeObject(), f16);
    }

    public void unsetScissor() {
        nUnsetScissor(getNativeObject());
    }

    public void setParameter(@NonNull String str, float f16) {
        nSetParameterFloat(getNativeObject(), str, f16);
    }

    public void setParameter(@NonNull String str, int i3) {
        nSetParameterInt(getNativeObject(), str, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialInstance(@NonNull Material material, long j3) {
        this.mMaterial = material;
        this.mNativeMaterial = material.getNativeObject();
        this.mNativeObject = j3;
    }

    public void setParameter(@NonNull String str, boolean z16, boolean z17) {
        nSetParameterBool2(getNativeObject(), str, z16, z17);
    }

    public void setParameter(@NonNull String str, float f16, float f17) {
        nSetParameterFloat2(getNativeObject(), str, f16, f17);
    }

    public void setParameter(@NonNull String str, int i3, int i16) {
        nSetParameterInt2(getNativeObject(), str, i3, i16);
    }

    public void setParameter(@NonNull String str, boolean z16, boolean z17, boolean z18) {
        nSetParameterBool3(getNativeObject(), str, z16, z17, z18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialInstance(long j3) {
        this.mNativeObject = j3;
        this.mNativeMaterial = nGetMaterial(j3);
    }

    public void setParameter(@NonNull String str, float f16, float f17, float f18) {
        nSetParameterFloat3(getNativeObject(), str, f16, f17, f18);
    }

    public void setParameter(@NonNull String str, int i3, int i16, int i17) {
        nSetParameterInt3(getNativeObject(), str, i3, i16, i17);
    }

    public void setParameter(@NonNull String str, boolean z16, boolean z17, boolean z18, boolean z19) {
        nSetParameterBool4(getNativeObject(), str, z16, z17, z18, z19);
    }

    public void setParameter(@NonNull String str, float f16, float f17, float f18, float f19) {
        nSetParameterFloat4(getNativeObject(), str, f16, f17, f18, f19);
    }

    public void setParameter(@NonNull String str, int i3, int i16, int i17, int i18) {
        nSetParameterInt4(getNativeObject(), str, i3, i16, i17, i18);
    }

    public void setParameter(@NonNull String str, @NonNull Texture texture, @NonNull TextureSampler textureSampler) {
        nSetParameterTexture(getNativeObject(), str, texture.getNativeObject(), textureSampler.mSampler);
    }

    public void setParameter(@NonNull String str, @NonNull BooleanElement booleanElement, @NonNull boolean[] zArr, @IntRange(from = 0) int i3, @IntRange(from = 1) int i16) {
        nSetBooleanParameterArray(getNativeObject(), str, booleanElement.ordinal(), zArr, i3, i16);
    }

    public void setParameter(@NonNull String str, @NonNull IntElement intElement, @NonNull int[] iArr, @IntRange(from = 0) int i3, @IntRange(from = 1) int i16) {
        nSetIntParameterArray(getNativeObject(), str, intElement.ordinal(), iArr, i3, i16);
    }

    public void setParameter(@NonNull String str, @NonNull FloatElement floatElement, @NonNull float[] fArr, @IntRange(from = 0) int i3, @IntRange(from = 1) int i16) {
        nSetFloatParameterArray(getNativeObject(), str, floatElement.ordinal(), fArr, i3, i16);
    }

    public void setParameter(@NonNull String str, @NonNull Colors.RgbType rgbType, float f16, float f17, float f18) {
        float[] linear = Colors.toLinear(rgbType, f16, f17, f18);
        nSetParameterFloat3(getNativeObject(), str, linear[0], linear[1], linear[2]);
    }

    public void setParameter(@NonNull String str, @NonNull Colors.RgbaType rgbaType, float f16, float f17, float f18, float f19) {
        float[] linear = Colors.toLinear(rgbaType, f16, f17, f18, f19);
        nSetParameterFloat4(getNativeObject(), str, linear[0], linear[1], linear[2], linear[3]);
    }
}
