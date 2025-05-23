package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.google.android.filament.proguard.UsedByReflection;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Texture {
    public static final int BASE_LEVEL = 0;
    private long mNativeObject;
    private static final Sampler[] sSamplerValues = Sampler.values();
    private static final InternalFormat[] sInternalFormatValues = InternalFormat.values();

    /* compiled from: P */
    /* renamed from: com.google.android.filament.Texture$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$filament$Texture$Format;
        static final /* synthetic */ int[] $SwitchMap$com$google$android$filament$Texture$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$google$android$filament$Texture$Type = iArr;
            try {
                iArr[Type.UBYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Type[Type.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Type[Type.COMPRESSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Type[Type.USHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Type[Type.SHORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Type[Type.HALF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Type[Type.UINT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Type[Type.INT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Type[Type.FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Type[Type.UINT_10F_11F_11F_REV.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Type[Type.USHORT_565.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr2 = new int[Format.values().length];
            $SwitchMap$com$google$android$filament$Texture$Format = iArr2;
            try {
                iArr2[Format.R.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Format[Format.R_INTEGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Format[Format.DEPTH_COMPONENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Format[Format.ALPHA.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Format[Format.RG.ordinal()] = 5;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Format[Format.RG_INTEGER.ordinal()] = 6;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Format[Format.DEPTH_STENCIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Format[Format.STENCIL_INDEX.ordinal()] = 8;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Format[Format.RGB.ordinal()] = 9;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Format[Format.RGB_INTEGER.ordinal()] = 10;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Format[Format.RGBA.ordinal()] = 11;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$android$filament$Texture$Format[Format.RGBA_INTEGER.ordinal()] = 12;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private final BuilderFinalizer mFinalizer;
        private final long mNativeBuilder;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        private static class BuilderFinalizer {
            private final long mNativeObject;

            BuilderFinalizer(long j3) {
                this.mNativeObject = j3;
            }

            public void finalize() {
                try {
                    super.finalize();
                } catch (Throwable unused) {
                }
                Texture.nDestroyBuilder(this.mNativeObject);
            }
        }

        public Builder() {
            long access$000 = Texture.access$000();
            this.mNativeBuilder = access$000;
            this.mFinalizer = new BuilderFinalizer(access$000);
        }

        @NonNull
        public Texture build(@NonNull Engine engine) {
            long nBuilderBuild = Texture.nBuilderBuild(this.mNativeBuilder, engine.getNativeObject());
            if (nBuilderBuild != 0) {
                return new Texture(nBuilderBuild);
            }
            throw new IllegalStateException("Couldn't create Texture");
        }

        @NonNull
        public Builder depth(@IntRange(from = 1) int i3) {
            Texture.nBuilderDepth(this.mNativeBuilder, i3);
            return this;
        }

        @NonNull
        public Builder format(@NonNull InternalFormat internalFormat) {
            Texture.nBuilderFormat(this.mNativeBuilder, internalFormat.ordinal());
            return this;
        }

        @NonNull
        public Builder height(@IntRange(from = 1) int i3) {
            Texture.nBuilderHeight(this.mNativeBuilder, i3);
            return this;
        }

        @NonNull
        public Builder importTexture(long j3) {
            Texture.nBuilderImportTexture(this.mNativeBuilder, j3);
            return this;
        }

        @NonNull
        public Builder levels(@IntRange(from = 1) int i3) {
            Texture.nBuilderLevels(this.mNativeBuilder, i3);
            return this;
        }

        @NonNull
        public Builder sampler(@NonNull Sampler sampler) {
            Texture.nBuilderSampler(this.mNativeBuilder, sampler.ordinal());
            return this;
        }

        @NonNull
        public Builder swizzle(@NonNull Swizzle swizzle, @NonNull Swizzle swizzle2, @NonNull Swizzle swizzle3, @NonNull Swizzle swizzle4) {
            Texture.nBuilderSwizzle(this.mNativeBuilder, swizzle.ordinal(), swizzle2.ordinal(), swizzle3.ordinal(), swizzle4.ordinal());
            return this;
        }

        @NonNull
        public Builder usage(int i3) {
            Texture.nBuilderUsage(this.mNativeBuilder, i3);
            return this;
        }

        @NonNull
        public Builder width(@IntRange(from = 1) int i3) {
            Texture.nBuilderWidth(this.mNativeBuilder, i3);
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum CompressedFormat {
        EAC_R11,
        EAC_R11_SIGNED,
        EAC_RG11,
        EAC_RG11_SIGNED,
        ETC2_RGB8,
        ETC2_SRGB8,
        ETC2_RGB8_A1,
        ETC2_SRGB8_A1,
        ETC2_EAC_RGBA8,
        ETC2_EAC_SRGBA8,
        DXT1_RGB,
        DXT1_RGBA,
        DXT3_RGBA,
        DXT5_RGBA,
        DXT1_SRGB,
        DXT1_SRGBA,
        DXT3_SRGBA,
        DXT5_SRGBA,
        RGBA_ASTC_4x4,
        RGBA_ASTC_5x4,
        RGBA_ASTC_5x5,
        RGBA_ASTC_6x5,
        RGBA_ASTC_6x6,
        RGBA_ASTC_8x5,
        RGBA_ASTC_8x6,
        RGBA_ASTC_8x8,
        RGBA_ASTC_10x5,
        RGBA_ASTC_10x6,
        RGBA_ASTC_10x8,
        RGBA_ASTC_10x10,
        RGBA_ASTC_12x10,
        RGBA_ASTC_12x12,
        SRGB8_ALPHA8_ASTC_4x4,
        SRGB8_ALPHA8_ASTC_5x4,
        SRGB8_ALPHA8_ASTC_5x5,
        SRGB8_ALPHA8_ASTC_6x5,
        SRGB8_ALPHA8_ASTC_6x6,
        SRGB8_ALPHA8_ASTC_8x5,
        SRGB8_ALPHA8_ASTC_8x6,
        SRGB8_ALPHA8_ASTC_8x8,
        SRGB8_ALPHA8_ASTC_10x5,
        SRGB8_ALPHA8_ASTC_10x6,
        SRGB8_ALPHA8_ASTC_10x8,
        SRGB8_ALPHA8_ASTC_10x10,
        SRGB8_ALPHA8_ASTC_12x10,
        SRGB8_ALPHA8_ASTC_12x12
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum CubemapFace {
        POSITIVE_X,
        NEGATIVE_X,
        POSITIVE_Y,
        NEGATIVE_Y,
        POSITIVE_Z,
        NEGATIVE_Z
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Format {
        R,
        R_INTEGER,
        RG,
        RG_INTEGER,
        RGB,
        RGB_INTEGER,
        RGBA,
        RGBA_INTEGER,
        UNUSED,
        DEPTH_COMPONENT,
        DEPTH_STENCIL,
        STENCIL_INDEX,
        ALPHA
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum InternalFormat {
        R8,
        R8_SNORM,
        R8UI,
        R8I,
        STENCIL8,
        R16F,
        R16UI,
        R16I,
        RG8,
        RG8_SNORM,
        RG8UI,
        RG8I,
        RGB565,
        RGB9_E5,
        RGB5_A1,
        RGBA4,
        DEPTH16,
        RGB8,
        SRGB8,
        RGB8_SNORM,
        RGB8UI,
        RGB8I,
        DEPTH24,
        R32F,
        R32UI,
        R32I,
        RG16F,
        RG16UI,
        RG16I,
        R11F_G11F_B10F,
        RGBA8,
        SRGB8_A8,
        RGBA8_SNORM,
        UNUSED,
        RGB10_A2,
        RGBA8UI,
        RGBA8I,
        DEPTH32F,
        DEPTH24_STENCIL8,
        DEPTH32F_STENCIL8,
        RGB16F,
        RGB16UI,
        RGB16I,
        RG32F,
        RG32UI,
        RG32I,
        RGBA16F,
        RGBA16UI,
        RGBA16I,
        RGB32F,
        RGB32UI,
        RGB32I,
        RGBA32F,
        RGBA32UI,
        RGBA32I,
        EAC_R11,
        EAC_R11_SIGNED,
        EAC_RG11,
        EAC_RG11_SIGNED,
        ETC2_RGB8,
        ETC2_SRGB8,
        ETC2_RGB8_A1,
        ETC2_SRGB8_A1,
        ETC2_EAC_RGBA8,
        ETC2_EAC_SRGBA8,
        DXT1_RGB,
        DXT1_RGBA,
        DXT3_RGBA,
        DXT5_RGBA,
        DXT1_SRGB,
        DXT1_SRGBA,
        DXT3_SRGBA,
        DXT5_SRGBA,
        RGBA_ASTC_4x4,
        RGBA_ASTC_5x4,
        RGBA_ASTC_5x5,
        RGBA_ASTC_6x5,
        RGBA_ASTC_6x6,
        RGBA_ASTC_8x5,
        RGBA_ASTC_8x6,
        RGBA_ASTC_8x8,
        RGBA_ASTC_10x5,
        RGBA_ASTC_10x6,
        RGBA_ASTC_10x8,
        RGBA_ASTC_10x10,
        RGBA_ASTC_12x10,
        RGBA_ASTC_12x12,
        SRGB8_ALPHA8_ASTC_4x4,
        SRGB8_ALPHA8_ASTC_5x4,
        SRGB8_ALPHA8_ASTC_5x5,
        SRGB8_ALPHA8_ASTC_6x5,
        SRGB8_ALPHA8_ASTC_6x6,
        SRGB8_ALPHA8_ASTC_8x5,
        SRGB8_ALPHA8_ASTC_8x6,
        SRGB8_ALPHA8_ASTC_8x8,
        SRGB8_ALPHA8_ASTC_10x5,
        SRGB8_ALPHA8_ASTC_10x6,
        SRGB8_ALPHA8_ASTC_10x8,
        SRGB8_ALPHA8_ASTC_10x10,
        SRGB8_ALPHA8_ASTC_12x10,
        SRGB8_ALPHA8_ASTC_12x12
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class PrefilterOptions {
        public int sampleCount = 8;
        public boolean mirror = true;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Sampler {
        SAMPLER_2D,
        SAMPLER_2D_ARRAY,
        SAMPLER_CUBEMAP,
        SAMPLER_EXTERNAL,
        SAMPLER_3D
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Swizzle {
        SUBSTITUTE_ZERO,
        SUBSTITUTE_ONE,
        CHANNEL_0,
        CHANNEL_1,
        CHANNEL_2,
        CHANNEL_3
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Type {
        UBYTE,
        BYTE,
        USHORT,
        SHORT,
        UINT,
        INT,
        HALF,
        FLOAT,
        COMPRESSED,
        UINT_10F_11F_11F_REV,
        USHORT_565
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Usage {
        public static final int COLOR_ATTACHMENT = 1;
        public static final int DEFAULT = 24;
        public static final int DEPTH_ATTACHMENT = 2;
        public static final int SAMPLEABLE = 16;
        public static final int STENCIL_ATTACHMENT = 4;
        public static final int SUBPASS_INPUT = 32;
        public static final int UPLOADABLE = 8;
    }

    public Texture(long j3) {
        this.mNativeObject = j3;
    }

    static /* synthetic */ long access$000() {
        return nCreateBuilder();
    }

    public static boolean isTextureFormatSupported(@NonNull Engine engine, @NonNull InternalFormat internalFormat) {
        return nIsTextureFormatSupported(engine.getNativeObject(), internalFormat.ordinal());
    }

    public static boolean isTextureSwizzleSupported(@NonNull Engine engine) {
        return nIsTextureSwizzleSupported(engine.getNativeObject());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nBuilderBuild(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderDepth(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderFormat(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderHeight(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderImportTexture(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderLevels(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderSampler(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderSwizzle(long j3, int i3, int i16, int i17, int i18);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderUsage(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderWidth(long j3, int i3);

    private static native long nCreateBuilder();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDestroyBuilder(long j3);

    private static native void nGenerateMipmaps(long j3, long j16);

    private static native int nGeneratePrefilterMipmap(long j3, long j16, int i3, int i16, Buffer buffer, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int[] iArr, Object obj, Runnable runnable, int i36, boolean z16);

    private static native int nGetDepth(long j3, int i3);

    private static native int nGetHeight(long j3, int i3);

    private static native int nGetId(long j3, long j16);

    private static native int nGetInternalFormat(long j3);

    private static native int nGetLevels(long j3);

    private static native int nGetTarget(long j3);

    private static native int nGetWidth(long j3, int i3);

    private static native boolean nIsStreamValidForTexture(long j3, long j16);

    private static native boolean nIsTextureFormatSupported(long j3, int i3);

    private static native boolean nIsTextureSwizzleSupported(long j3);

    private static native void nSetExternalImage(long j3, long j16, long j17);

    private static native void nSetExternalStream(long j3, long j16, long j17);

    private static native int nSetImage(long j3, long j16, int i3, int i16, int i17, int i18, int i19, Buffer buffer, int i26, int i27, int i28, int i29, int i36, int i37, int i38, Object obj, Runnable runnable);

    private static native int nSetImage3D(long j3, long j16, int i3, int i16, int i17, int i18, int i19, int i26, int i27, Buffer buffer, int i28, int i29, int i36, int i37, int i38, int i39, int i46, Object obj, Runnable runnable);

    private static native int nSetImage3DCompressed(long j3, long j16, int i3, int i16, int i17, int i18, int i19, int i26, int i27, Buffer buffer, int i28, int i29, int i36, int i37, int i38, int i39, int i46, Object obj, Runnable runnable);

    private static native int nSetImageCompressed(long j3, long j16, int i3, int i16, int i17, int i18, int i19, Buffer buffer, int i26, int i27, int i28, int i29, int i36, int i37, int i38, Object obj, Runnable runnable);

    private static native int nSetImageCubemap(long j3, long j16, int i3, Buffer buffer, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int[] iArr, Object obj, Runnable runnable);

    private static native int nSetImageCubemapCompressed(long j3, long j16, int i3, Buffer buffer, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int[] iArr, Object obj, Runnable runnable);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    public void generateMipmaps(@NonNull Engine engine) {
        nGenerateMipmaps(getNativeObject(), engine.getNativeObject());
    }

    public void generatePrefilterMipmap(@NonNull Engine engine, @NonNull PixelBufferDescriptor pixelBufferDescriptor, @NonNull @Size(min = 6) int[] iArr, PrefilterOptions prefilterOptions) {
        int i3;
        boolean z16;
        int width = getWidth(0);
        int height = getHeight(0);
        if (prefilterOptions != null) {
            int i16 = prefilterOptions.sampleCount;
            z16 = prefilterOptions.mirror;
            i3 = i16;
        } else {
            i3 = 8;
            z16 = true;
        }
        long nativeObject = getNativeObject();
        long nativeObject2 = engine.getNativeObject();
        Buffer buffer = pixelBufferDescriptor.storage;
        if (nGeneratePrefilterMipmap(nativeObject, nativeObject2, width, height, buffer, buffer.remaining(), pixelBufferDescriptor.left, pixelBufferDescriptor.top, pixelBufferDescriptor.type.ordinal(), pixelBufferDescriptor.alignment, pixelBufferDescriptor.stride, pixelBufferDescriptor.format.ordinal(), iArr, pixelBufferDescriptor.handler, pixelBufferDescriptor.callback, i3, z16) >= 0) {
        } else {
            throw new BufferOverflowException();
        }
    }

    public int getDepth(@IntRange(from = 0) int i3) {
        return nGetDepth(getNativeObject(), i3);
    }

    @NonNull
    public InternalFormat getFormat() {
        return sInternalFormatValues[nGetInternalFormat(getNativeObject())];
    }

    public int getHeight(@IntRange(from = 0) int i3) {
        return nGetHeight(getNativeObject(), i3);
    }

    public int getId(@NonNull Engine engine) {
        return nGetId(engine.getNativeObject(), getNativeObject());
    }

    public int getLevels() {
        return nGetLevels(getNativeObject());
    }

    @UsedByReflection("TextureHelper.java")
    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed Texture");
    }

    @NonNull
    public Sampler getTarget() {
        return sSamplerValues[nGetTarget(getNativeObject())];
    }

    public int getWidth(@IntRange(from = 0) int i3) {
        return nGetWidth(getNativeObject(), i3);
    }

    public void setExternalImage(@NonNull Engine engine, long j3) {
        nSetExternalImage(getNativeObject(), engine.getNativeObject(), j3);
    }

    public void setExternalStream(@NonNull Engine engine, @NonNull Stream stream) {
        long nativeObject = getNativeObject();
        long nativeObject2 = stream.getNativeObject();
        if (nIsStreamValidForTexture(nativeObject, nativeObject2)) {
            nSetExternalStream(nativeObject, engine.getNativeObject(), nativeObject2);
            return;
        }
        throw new IllegalStateException("Invalid texture sampler: When used with a stream, a texture must use a SAMPLER_EXTERNAL");
    }

    public void setImage(@NonNull Engine engine, @IntRange(from = 0) int i3, @NonNull PixelBufferDescriptor pixelBufferDescriptor) {
        setImage(engine, i3, 0, 0, getWidth(i3), getHeight(i3), pixelBufferDescriptor);
    }

    public void setImage(@NonNull Engine engine, @IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18, @IntRange(from = 0) int i19, @NonNull PixelBufferDescriptor pixelBufferDescriptor) {
        int nSetImage;
        if (pixelBufferDescriptor.type == Type.COMPRESSED) {
            long nativeObject = getNativeObject();
            long nativeObject2 = engine.getNativeObject();
            Buffer buffer = pixelBufferDescriptor.storage;
            nSetImage = nSetImageCompressed(nativeObject, nativeObject2, i3, i16, i17, i18, i19, buffer, buffer.remaining(), pixelBufferDescriptor.left, pixelBufferDescriptor.top, pixelBufferDescriptor.type.ordinal(), pixelBufferDescriptor.alignment, pixelBufferDescriptor.compressedSizeInBytes, pixelBufferDescriptor.compressedFormat.ordinal(), pixelBufferDescriptor.handler, pixelBufferDescriptor.callback);
        } else {
            long nativeObject3 = getNativeObject();
            long nativeObject4 = engine.getNativeObject();
            Buffer buffer2 = pixelBufferDescriptor.storage;
            nSetImage = nSetImage(nativeObject3, nativeObject4, i3, i16, i17, i18, i19, buffer2, buffer2.remaining(), pixelBufferDescriptor.left, pixelBufferDescriptor.top, pixelBufferDescriptor.type.ordinal(), pixelBufferDescriptor.alignment, pixelBufferDescriptor.stride, pixelBufferDescriptor.format.ordinal(), pixelBufferDescriptor.handler, pixelBufferDescriptor.callback);
        }
        if (nSetImage < 0) {
            throw new BufferOverflowException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class PixelBufferDescriptor {
        public int alignment;

        @Nullable
        public Runnable callback;
        public CompressedFormat compressedFormat;
        public int compressedSizeInBytes;
        public Format format;

        @Nullable
        public Object handler;
        public int left;
        public Buffer storage;
        public int stride;
        public int top;
        public Type type;

        public PixelBufferDescriptor(@NonNull Buffer buffer, @NonNull Format format, @NonNull Type type, @IntRange(from = 1, to = 8) int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18, @Nullable Object obj, @Nullable Runnable runnable) {
            this.storage = buffer;
            this.left = i16;
            this.top = i17;
            this.type = type;
            this.alignment = i3;
            this.stride = i18;
            this.format = format;
            this.handler = obj;
            this.callback = runnable;
        }

        public static int computeDataSize(@NonNull Format format, @NonNull Type type, int i3, int i16, @IntRange(from = 1, to = 8) int i17) {
            int i18;
            if (type == Type.COMPRESSED) {
                return 0;
            }
            int i19 = 4;
            switch (AnonymousClass1.$SwitchMap$com$google$android$filament$Texture$Format[format.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    i18 = 1;
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    i18 = 2;
                    break;
                case 9:
                case 10:
                    i18 = 3;
                    break;
                case 11:
                case 12:
                    i18 = 4;
                    break;
                default:
                    throw new IllegalStateException("unsupported format enum");
            }
            switch (AnonymousClass1.$SwitchMap$com$google$android$filament$Texture$Type[type.ordinal()]) {
                case 4:
                case 5:
                case 6:
                    i19 = i18 * 2;
                    break;
                case 7:
                case 8:
                case 9:
                    i19 = i18 * 4;
                    break;
                case 10:
                    break;
                case 11:
                    i19 = 2;
                    break;
                default:
                    i19 = i18;
                    break;
            }
            return ((-i17) & ((i19 * i3) + (i17 - 1))) * i16;
        }

        public void setCallback(@Nullable Object obj, @Nullable Runnable runnable) {
            this.handler = obj;
            this.callback = runnable;
        }

        public PixelBufferDescriptor(@NonNull Buffer buffer, @NonNull Format format, @NonNull Type type) {
            this(buffer, format, type, 1, 0, 0, 0, null, null);
        }

        public PixelBufferDescriptor(@NonNull Buffer buffer, @NonNull Format format, @NonNull Type type, @IntRange(from = 1, to = 8) int i3) {
            this(buffer, format, type, i3, 0, 0, 0, null, null);
        }

        public PixelBufferDescriptor(@NonNull Buffer buffer, @NonNull Format format, @NonNull Type type, @IntRange(from = 1, to = 8) int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17) {
            this(buffer, format, type, i3, i16, i17, 0, null, null);
        }

        public PixelBufferDescriptor(@NonNull ByteBuffer byteBuffer, @NonNull CompressedFormat compressedFormat, @IntRange(from = 0) int i3) {
            this.alignment = 1;
            this.left = 0;
            this.top = 0;
            this.stride = 0;
            this.storage = byteBuffer;
            this.type = Type.COMPRESSED;
            this.alignment = 1;
            this.compressedFormat = compressedFormat;
            this.compressedSizeInBytes = i3;
        }
    }

    public void setImage(@NonNull Engine engine, @IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18, @IntRange(from = 0) int i19, @IntRange(from = 0) int i26, @IntRange(from = 0) int i27, @NonNull PixelBufferDescriptor pixelBufferDescriptor) {
        int nSetImage3D;
        if (pixelBufferDescriptor.type == Type.COMPRESSED) {
            long nativeObject = getNativeObject();
            long nativeObject2 = engine.getNativeObject();
            Buffer buffer = pixelBufferDescriptor.storage;
            nSetImage3D = nSetImage3DCompressed(nativeObject, nativeObject2, i3, i16, i17, i18, i19, i26, i27, buffer, buffer.remaining(), pixelBufferDescriptor.left, pixelBufferDescriptor.top, pixelBufferDescriptor.type.ordinal(), pixelBufferDescriptor.alignment, pixelBufferDescriptor.compressedSizeInBytes, pixelBufferDescriptor.compressedFormat.ordinal(), pixelBufferDescriptor.handler, pixelBufferDescriptor.callback);
        } else {
            long nativeObject3 = getNativeObject();
            long nativeObject4 = engine.getNativeObject();
            Buffer buffer2 = pixelBufferDescriptor.storage;
            nSetImage3D = nSetImage3D(nativeObject3, nativeObject4, i3, i16, i17, i18, i19, i26, i27, buffer2, buffer2.remaining(), pixelBufferDescriptor.left, pixelBufferDescriptor.top, pixelBufferDescriptor.type.ordinal(), pixelBufferDescriptor.alignment, pixelBufferDescriptor.stride, pixelBufferDescriptor.format.ordinal(), pixelBufferDescriptor.handler, pixelBufferDescriptor.callback);
        }
        if (nSetImage3D < 0) {
            throw new BufferOverflowException();
        }
    }

    public void setImage(@NonNull Engine engine, @IntRange(from = 0) int i3, @NonNull PixelBufferDescriptor pixelBufferDescriptor, @NonNull @Size(min = 6) int[] iArr) {
        int nSetImageCubemap;
        if (pixelBufferDescriptor.type == Type.COMPRESSED) {
            long nativeObject = getNativeObject();
            long nativeObject2 = engine.getNativeObject();
            Buffer buffer = pixelBufferDescriptor.storage;
            nSetImageCubemap = nSetImageCubemapCompressed(nativeObject, nativeObject2, i3, buffer, buffer.remaining(), pixelBufferDescriptor.left, pixelBufferDescriptor.top, pixelBufferDescriptor.type.ordinal(), pixelBufferDescriptor.alignment, pixelBufferDescriptor.compressedSizeInBytes, pixelBufferDescriptor.compressedFormat.ordinal(), iArr, pixelBufferDescriptor.handler, pixelBufferDescriptor.callback);
        } else {
            long nativeObject3 = getNativeObject();
            long nativeObject4 = engine.getNativeObject();
            Buffer buffer2 = pixelBufferDescriptor.storage;
            nSetImageCubemap = nSetImageCubemap(nativeObject3, nativeObject4, i3, buffer2, buffer2.remaining(), pixelBufferDescriptor.left, pixelBufferDescriptor.top, pixelBufferDescriptor.type.ordinal(), pixelBufferDescriptor.alignment, pixelBufferDescriptor.stride, pixelBufferDescriptor.format.ordinal(), iArr, pixelBufferDescriptor.handler, pixelBufferDescriptor.callback);
        }
        if (nSetImageCubemap < 0) {
            throw new BufferOverflowException();
        }
    }
}
