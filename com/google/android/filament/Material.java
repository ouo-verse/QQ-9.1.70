package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import com.google.android.filament.Colors;
import com.google.android.filament.MaterialInstance;
import com.google.android.filament.VertexBuffer;
import com.google.android.filament.proguard.UsedByNative;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Material {
    private final MaterialInstance mDefaultInstance;
    private long mNativeObject;
    private Set<VertexBuffer.VertexAttribute> mRequiredAttributes;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum BlendingMode {
        OPAQUE,
        TRANSPARENT,
        ADD,
        MASKED,
        FADE,
        MULTIPLY,
        SCREEN
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private Buffer mBuffer;
        private int mSize;

        @NonNull
        public Material build(@NonNull Engine engine) {
            long nBuilderBuild = Material.nBuilderBuild(engine.getNativeObject(), this.mBuffer, this.mSize);
            if (nBuilderBuild != 0) {
                return new Material(nBuilderBuild);
            }
            throw new IllegalStateException("Couldn't create Material");
        }

        @NonNull
        public Builder payload(@NonNull Buffer buffer, @IntRange(from = 0) int i3) {
            this.mBuffer = buffer;
            this.mSize = i3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum CullingMode {
        NONE,
        FRONT,
        BACK,
        FRONT_AND_BACK
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Interpolation {
        SMOOTH,
        FLAT
    }

    /* compiled from: P */
    @UsedByNative("Material.cpp")
    /* loaded from: classes2.dex */
    public static class Parameter {

        @IntRange(from = 1)
        public final int count;

        @NonNull
        public final String name;

        @NonNull
        public final Precision precision;

        @NonNull
        public final Type type;
        private static final Type[] sTypeValues = Type.values();

        @UsedByNative("Material.cpp")
        private static final int SAMPLER_OFFSET = Type.MAT4.ordinal() + 1;

        @UsedByNative("Material.cpp")
        private static final int SUBPASS_OFFSET = Type.SAMPLER_3D.ordinal() + 1;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public enum Precision {
            LOW,
            MEDIUM,
            HIGH,
            DEFAULT
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public enum Type {
            BOOL,
            BOOL2,
            BOOL3,
            BOOL4,
            FLOAT,
            FLOAT2,
            FLOAT3,
            FLOAT4,
            INT,
            INT2,
            INT3,
            INT4,
            UINT,
            UINT2,
            UINT3,
            UINT4,
            MAT3,
            MAT4,
            SAMPLER_2D,
            SAMPLER_2D_ARRAY,
            SAMPLER_CUBEMAP,
            SAMPLER_EXTERNAL,
            SAMPLER_3D,
            SUBPASS_INPUT
        }

        Parameter(@NonNull String str, @NonNull Type type, @NonNull Precision precision, @IntRange(from = 1) int i3) {
            this.name = str;
            this.type = type;
            this.precision = precision;
            this.count = i3;
        }

        @UsedByNative("Material.cpp")
        private static void add(@NonNull List<Parameter> list, @NonNull String str, @IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @IntRange(from = 1) int i17) {
            list.add(new Parameter(str, sTypeValues[i3], Precision.values()[i16], i17));
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum RefractionMode {
        NONE,
        CUBEMAP,
        SCREEN_SPACE
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum RefractionType {
        SOLID,
        THIN
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Shading {
        UNLIT,
        LIT,
        SUBSURFACE,
        CLOTH,
        SPECULAR_GLOSSINESS
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum VertexDomain {
        OBJECT,
        WORLD,
        VIEW,
        DEVICE
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final Shading[] f32958a = Shading.values();

        /* renamed from: b, reason: collision with root package name */
        static final Interpolation[] f32959b = Interpolation.values();

        /* renamed from: c, reason: collision with root package name */
        static final BlendingMode[] f32960c = BlendingMode.values();

        /* renamed from: d, reason: collision with root package name */
        static final RefractionMode[] f32961d = RefractionMode.values();

        /* renamed from: e, reason: collision with root package name */
        static final RefractionType[] f32962e = RefractionType.values();

        /* renamed from: f, reason: collision with root package name */
        static final VertexDomain[] f32963f = VertexDomain.values();

        /* renamed from: g, reason: collision with root package name */
        static final CullingMode[] f32964g = CullingMode.values();

        /* renamed from: h, reason: collision with root package name */
        static final VertexBuffer.VertexAttribute[] f32965h = VertexBuffer.VertexAttribute.values();
    }

    public Material(long j3) {
        this.mNativeObject = j3;
        this.mDefaultInstance = new MaterialInstance(this, nGetDefaultInstance(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nBuilderBuild(long j3, @NonNull Buffer buffer, int i3);

    private static native long nCreateInstance(long j3);

    private static native long nCreateInstanceWithName(long j3, @NonNull String str);

    private static native int nGetBlendingMode(long j3);

    private static native int nGetCullingMode(long j3);

    private static native long nGetDefaultInstance(long j3);

    private static native int nGetInterpolation(long j3);

    private static native float nGetMaskThreshold(long j3);

    private static native String nGetName(long j3);

    private static native int nGetParameterCount(long j3);

    private static native void nGetParameters(long j3, @NonNull List<Parameter> list, @IntRange(from = 1) int i3);

    private static native int nGetRefractionMode(long j3);

    private static native int nGetRefractionType(long j3);

    private static native int nGetRequiredAttributes(long j3);

    private static native int nGetShading(long j3);

    private static native float nGetSpecularAntiAliasingThreshold(long j3);

    private static native float nGetSpecularAntiAliasingVariance(long j3);

    private static native int nGetVertexDomain(long j3);

    private static native boolean nHasParameter(long j3, @NonNull String str);

    private static native boolean nIsColorWriteEnabled(long j3);

    private static native boolean nIsDepthCullingEnabled(long j3);

    private static native boolean nIsDepthWriteEnabled(long j3);

    private static native boolean nIsDoubleSided(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    @NonNull
    public MaterialInstance createInstance() {
        long nCreateInstance = nCreateInstance(getNativeObject());
        if (nCreateInstance != 0) {
            return new MaterialInstance(this, nCreateInstance);
        }
        throw new IllegalStateException("Couldn't create MaterialInstance");
    }

    public BlendingMode getBlendingMode() {
        return a.f32960c[nGetBlendingMode(getNativeObject())];
    }

    public CullingMode getCullingMode() {
        return a.f32964g[nGetCullingMode(getNativeObject())];
    }

    @NonNull
    public MaterialInstance getDefaultInstance() {
        return this.mDefaultInstance;
    }

    public Interpolation getInterpolation() {
        return a.f32959b[nGetInterpolation(getNativeObject())];
    }

    public float getMaskThreshold() {
        return nGetMaskThreshold(getNativeObject());
    }

    public String getName() {
        return nGetName(getNativeObject());
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed Material");
    }

    public int getParameterCount() {
        return nGetParameterCount(getNativeObject());
    }

    public List<Parameter> getParameters() {
        int parameterCount = getParameterCount();
        ArrayList arrayList = new ArrayList(parameterCount);
        if (parameterCount > 0) {
            nGetParameters(getNativeObject(), arrayList, parameterCount);
        }
        return arrayList;
    }

    public RefractionMode getRefractionMode() {
        return a.f32961d[nGetRefractionMode(getNativeObject())];
    }

    public RefractionType getRefractionType() {
        return a.f32962e[nGetRefractionType(getNativeObject())];
    }

    public Set<VertexBuffer.VertexAttribute> getRequiredAttributes() {
        if (this.mRequiredAttributes == null) {
            int nGetRequiredAttributes = nGetRequiredAttributes(getNativeObject());
            this.mRequiredAttributes = EnumSet.noneOf(VertexBuffer.VertexAttribute.class);
            VertexBuffer.VertexAttribute[] vertexAttributeArr = a.f32965h;
            for (int i3 = 0; i3 < vertexAttributeArr.length; i3++) {
                if (((1 << i3) & nGetRequiredAttributes) != 0) {
                    this.mRequiredAttributes.add(vertexAttributeArr[i3]);
                }
            }
            this.mRequiredAttributes = Collections.unmodifiableSet(this.mRequiredAttributes);
        }
        return this.mRequiredAttributes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getRequiredAttributesAsInt() {
        return nGetRequiredAttributes(getNativeObject());
    }

    public Shading getShading() {
        return a.f32958a[nGetShading(getNativeObject())];
    }

    public float getSpecularAntiAliasingThreshold() {
        return nGetSpecularAntiAliasingThreshold(getNativeObject());
    }

    public float getSpecularAntiAliasingVariance() {
        return nGetSpecularAntiAliasingVariance(getNativeObject());
    }

    public VertexDomain getVertexDomain() {
        return a.f32963f[nGetVertexDomain(getNativeObject())];
    }

    public boolean hasParameter(@NonNull String str) {
        return nHasParameter(getNativeObject(), str);
    }

    public boolean isColorWriteEnabled() {
        return nIsColorWriteEnabled(getNativeObject());
    }

    public boolean isDepthCullingEnabled() {
        return nIsDepthCullingEnabled(getNativeObject());
    }

    public boolean isDepthWriteEnabled() {
        return nIsDepthWriteEnabled(getNativeObject());
    }

    public boolean isDoubleSided() {
        return nIsDoubleSided(getNativeObject());
    }

    public void setDefaultParameter(@NonNull String str, boolean z16) {
        this.mDefaultInstance.setParameter(str, z16);
    }

    public void setDefaultParameter(@NonNull String str, float f16) {
        this.mDefaultInstance.setParameter(str, f16);
    }

    public void setDefaultParameter(@NonNull String str, int i3) {
        this.mDefaultInstance.setParameter(str, i3);
    }

    @NonNull
    public MaterialInstance createInstance(@NonNull String str) {
        long nCreateInstanceWithName = nCreateInstanceWithName(getNativeObject(), str);
        if (nCreateInstanceWithName != 0) {
            return new MaterialInstance(this, nCreateInstanceWithName);
        }
        throw new IllegalStateException("Couldn't create MaterialInstance");
    }

    public void setDefaultParameter(@NonNull String str, boolean z16, boolean z17) {
        this.mDefaultInstance.setParameter(str, z16, z17);
    }

    public void setDefaultParameter(@NonNull String str, float f16, float f17) {
        this.mDefaultInstance.setParameter(str, f16, f17);
    }

    public void setDefaultParameter(@NonNull String str, int i3, int i16) {
        this.mDefaultInstance.setParameter(str, i3, i16);
    }

    public void setDefaultParameter(@NonNull String str, boolean z16, boolean z17, boolean z18) {
        this.mDefaultInstance.setParameter(str, z16, z17, z18);
    }

    public void setDefaultParameter(@NonNull String str, float f16, float f17, float f18) {
        this.mDefaultInstance.setParameter(str, f16, f17, f18);
    }

    public void setDefaultParameter(@NonNull String str, int i3, int i16, int i17) {
        this.mDefaultInstance.setParameter(str, i3, i16, i17);
    }

    public void setDefaultParameter(@NonNull String str, boolean z16, boolean z17, boolean z18, boolean z19) {
        this.mDefaultInstance.setParameter(str, z16, z17, z18, z19);
    }

    public void setDefaultParameter(@NonNull String str, float f16, float f17, float f18, float f19) {
        this.mDefaultInstance.setParameter(str, f16, f17, f18, f19);
    }

    public void setDefaultParameter(@NonNull String str, int i3, int i16, int i17, int i18) {
        this.mDefaultInstance.setParameter(str, i3, i16, i17, i18);
    }

    public void setDefaultParameter(@NonNull String str, @NonNull MaterialInstance.BooleanElement booleanElement, @NonNull @Size(min = 1) boolean[] zArr, @IntRange(from = 0) int i3, @IntRange(from = 1) int i16) {
        this.mDefaultInstance.setParameter(str, booleanElement, zArr, i3, i16);
    }

    public void setDefaultParameter(@NonNull String str, @NonNull MaterialInstance.IntElement intElement, @NonNull @Size(min = 1) int[] iArr, @IntRange(from = 0) int i3, @IntRange(from = 1) int i16) {
        this.mDefaultInstance.setParameter(str, intElement, iArr, i3, i16);
    }

    public void setDefaultParameter(@NonNull String str, @NonNull MaterialInstance.FloatElement floatElement, @NonNull @Size(min = 1) float[] fArr, @IntRange(from = 0) int i3, @IntRange(from = 1) int i16) {
        this.mDefaultInstance.setParameter(str, floatElement, fArr, i3, i16);
    }

    public void setDefaultParameter(@NonNull String str, @NonNull Colors.RgbType rgbType, float f16, float f17, float f18) {
        this.mDefaultInstance.setParameter(str, rgbType, f16, f17, f18);
    }

    public void setDefaultParameter(@NonNull String str, @NonNull Colors.RgbaType rgbaType, float f16, float f17, float f18, float f19) {
        this.mDefaultInstance.setParameter(str, rgbaType, f16, f17, f18, f19);
    }

    public void setDefaultParameter(@NonNull String str, @NonNull Texture texture, @NonNull TextureSampler textureSampler) {
        this.mDefaultInstance.setParameter(str, texture, textureSampler);
    }
}
