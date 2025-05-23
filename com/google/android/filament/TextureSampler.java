package com.google.android.filament;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TextureSampler {
    int mSampler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.google.android.filament.TextureSampler$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$filament$TextureSampler$MagFilter;

        static {
            int[] iArr = new int[MagFilter.values().length];
            $SwitchMap$com$google$android$filament$TextureSampler$MagFilter = iArr;
            try {
                iArr[MagFilter.NEAREST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$filament$TextureSampler$MagFilter[MagFilter.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum CompareFunction {
        LESS_EQUAL,
        GREATER_EQUAL,
        LESS,
        GREATER,
        EQUAL,
        NOT_EQUAL,
        ALWAYS,
        NEVER
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum CompareMode {
        NONE,
        COMPARE_TO_TEXTURE
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum MagFilter {
        NEAREST,
        LINEAR
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum MinFilter {
        NEAREST,
        LINEAR,
        NEAREST_MIPMAP_NEAREST,
        LINEAR_MIPMAP_NEAREST,
        NEAREST_MIPMAP_LINEAR,
        LINEAR_MIPMAP_LINEAR
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum WrapMode {
        CLAMP_TO_EDGE,
        REPEAT,
        MIRRORED_REPEAT
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final MinFilter[] f32978a = MinFilter.values();

        /* renamed from: b, reason: collision with root package name */
        static final MagFilter[] f32979b = MagFilter.values();

        /* renamed from: c, reason: collision with root package name */
        static final WrapMode[] f32980c = WrapMode.values();

        /* renamed from: d, reason: collision with root package name */
        static final CompareMode[] f32981d = CompareMode.values();

        /* renamed from: e, reason: collision with root package name */
        static final CompareFunction[] f32982e = CompareFunction.values();
    }

    public TextureSampler() {
        this(MinFilter.LINEAR_MIPMAP_LINEAR, MagFilter.LINEAR, WrapMode.REPEAT);
    }

    private static MinFilter minFilterFromMagFilter(@NonNull MagFilter magFilter) {
        if (AnonymousClass1.$SwitchMap$com$google$android$filament$TextureSampler$MagFilter[magFilter.ordinal()] != 1) {
            return MinFilter.LINEAR;
        }
        return MinFilter.NEAREST;
    }

    private static native int nCreateCompareSampler(int i3, int i16);

    private static native int nCreateSampler(int i3, int i16, int i17, int i18, int i19);

    private static native float nGetAnisotropy(int i3);

    private static native int nGetCompareFunction(int i3);

    private static native int nGetCompareMode(int i3);

    private static native int nGetMagFilter(int i3);

    private static native int nGetMinFilter(int i3);

    private static native int nGetWrapModeR(int i3);

    private static native int nGetWrapModeS(int i3);

    private static native int nGetWrapModeT(int i3);

    private static native int nSetAnisotropy(int i3, float f16);

    private static native int nSetCompareFunction(int i3, int i16);

    private static native int nSetCompareMode(int i3, int i16);

    private static native int nSetMagFilter(int i3, int i16);

    private static native int nSetMinFilter(int i3, int i16);

    private static native int nSetWrapModeR(int i3, int i16);

    private static native int nSetWrapModeS(int i3, int i16);

    private static native int nSetWrapModeT(int i3, int i16);

    public float getAnisotropy() {
        return nGetAnisotropy(this.mSampler);
    }

    public CompareFunction getCompareFunction() {
        return a.f32982e[nGetCompareFunction(this.mSampler)];
    }

    public CompareMode getCompareMode() {
        return a.f32981d[nGetCompareMode(this.mSampler)];
    }

    public MagFilter getMagFilter() {
        return a.f32979b[nGetMagFilter(this.mSampler)];
    }

    public MinFilter getMinFilter() {
        return a.f32978a[nGetMinFilter(this.mSampler)];
    }

    public WrapMode getWrapModeR() {
        return a.f32980c[nGetWrapModeR(this.mSampler)];
    }

    public WrapMode getWrapModeS() {
        return a.f32980c[nGetWrapModeS(this.mSampler)];
    }

    public WrapMode getWrapModeT() {
        return a.f32980c[nGetWrapModeT(this.mSampler)];
    }

    public void setAnisotropy(float f16) {
        this.mSampler = nSetAnisotropy(this.mSampler, f16);
    }

    public void setCompareFunction(CompareFunction compareFunction) {
        this.mSampler = nSetCompareFunction(this.mSampler, compareFunction.ordinal());
    }

    public void setCompareMode(CompareMode compareMode) {
        this.mSampler = nSetCompareMode(this.mSampler, compareMode.ordinal());
    }

    public void setMagFilter(MagFilter magFilter) {
        this.mSampler = nSetMagFilter(this.mSampler, magFilter.ordinal());
    }

    public void setMinFilter(MinFilter minFilter) {
        this.mSampler = nSetMinFilter(this.mSampler, minFilter.ordinal());
    }

    public void setWrapModeR(WrapMode wrapMode) {
        this.mSampler = nSetWrapModeR(this.mSampler, wrapMode.ordinal());
    }

    public void setWrapModeS(WrapMode wrapMode) {
        this.mSampler = nSetWrapModeS(this.mSampler, wrapMode.ordinal());
    }

    public void setWrapModeT(WrapMode wrapMode) {
        this.mSampler = nSetWrapModeT(this.mSampler, wrapMode.ordinal());
    }

    public TextureSampler(@NonNull MagFilter magFilter) {
        this(magFilter, WrapMode.CLAMP_TO_EDGE);
    }

    public TextureSampler(@NonNull MagFilter magFilter, @NonNull WrapMode wrapMode) {
        this(minFilterFromMagFilter(magFilter), magFilter, wrapMode);
    }

    public TextureSampler(@NonNull MinFilter minFilter, @NonNull MagFilter magFilter, @NonNull WrapMode wrapMode) {
        this(minFilter, magFilter, wrapMode, wrapMode, wrapMode);
    }

    public TextureSampler(@NonNull MinFilter minFilter, @NonNull MagFilter magFilter, @NonNull WrapMode wrapMode, @NonNull WrapMode wrapMode2, @NonNull WrapMode wrapMode3) {
        this.mSampler = 0;
        this.mSampler = nCreateSampler(minFilter.ordinal(), magFilter.ordinal(), wrapMode.ordinal(), wrapMode2.ordinal(), wrapMode3.ordinal());
    }

    public TextureSampler(@NonNull CompareMode compareMode) {
        this(compareMode, CompareFunction.LESS_EQUAL);
    }

    public TextureSampler(@NonNull CompareMode compareMode, @NonNull CompareFunction compareFunction) {
        this.mSampler = 0;
        this.mSampler = nCreateCompareSampler(compareMode.ordinal(), compareFunction.ordinal());
    }
}
