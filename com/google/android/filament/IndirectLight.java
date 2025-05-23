package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* compiled from: P */
/* loaded from: classes2.dex */
public class IndirectLight {
    long mNativeObject;

    public IndirectLight(long j3) {
        this.mNativeObject = j3;
    }

    static /* synthetic */ long access$000() {
        return nCreateBuilder();
    }

    @NonNull
    @Size(min = 4)
    public static float[] getColorEstimate(@Nullable @Size(min = 4) float[] fArr, @NonNull float[] fArr2, float f16, float f17, float f18) {
        if (fArr2.length >= 27) {
            float[] assertFloat4 = Asserts.assertFloat4(fArr);
            nGetColorEstimateStatic(assertFloat4, fArr2, f16, f17, f18);
            return assertFloat4;
        }
        throw new ArrayIndexOutOfBoundsException("3 bands SH required, array must be at least 9 x float3");
    }

    @NonNull
    @Size(min = 3)
    public static float[] getDirectionEstimate(@NonNull float[] fArr, @Nullable @Size(min = 3) float[] fArr2) {
        if (fArr.length >= 27) {
            float[] assertFloat3 = Asserts.assertFloat3(fArr2);
            nGetDirectionEstimateStatic(fArr, assertFloat3);
            return assertFloat3;
        }
        throw new ArrayIndexOutOfBoundsException("3 bands SH required, array must be at least 9 x float3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nBuilderBuild(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderReflections(long j3, long j16);

    private static native long nCreateBuilder();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDestroyBuilder(long j3);

    private static native void nGetColorEstimate(long j3, float[] fArr, float f16, float f17, float f18);

    private static native void nGetColorEstimateStatic(float[] fArr, float[] fArr2, float f16, float f17, float f18);

    private static native void nGetDirectionEstimate(long j3, float[] fArr);

    private static native void nGetDirectionEstimateStatic(float[] fArr, float[] fArr2);

    private static native float nGetIntensity(long j3);

    private static native long nGetIrradianceTexture(long j3);

    private static native long nGetReflectionsTexture(long j3);

    private static native void nGetRotation(long j3, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nIntensity(long j3, float f16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nIrradiance(long j3, int i3, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nIrradianceAsTexture(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nRadiance(long j3, int i3, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nRotation(long j3, float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36);

    private static native void nSetIntensity(long j3, float f16);

    private static native void nSetRotation(long j3, float f16, float f17, float f18, float f19, float f26, float f27, float f28, float f29, float f36);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    public float getIntensity() {
        return nGetIntensity(getNativeObject());
    }

    @Nullable
    public Texture getIrradianceTexture() {
        long nGetIrradianceTexture = nGetIrradianceTexture(getNativeObject());
        if (nGetIrradianceTexture == 0) {
            return null;
        }
        return new Texture(nGetIrradianceTexture);
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed IndirectLight");
    }

    @Nullable
    public Texture getReflectionsTexture() {
        long nGetReflectionsTexture = nGetReflectionsTexture(getNativeObject());
        if (nGetReflectionsTexture == 0) {
            return null;
        }
        return new Texture(nGetReflectionsTexture);
    }

    @NonNull
    @Size(min = SemanticAttributes.RpcGrpcStatusCodeValues.FAILED_PRECONDITION)
    public float[] getRotation(@Nullable @Size(min = 9) float[] fArr) {
        float[] assertMat3f = Asserts.assertMat3f(fArr);
        nGetRotation(getNativeObject(), assertMat3f);
        return assertMat3f;
    }

    public void setIntensity(float f16) {
        nSetIntensity(getNativeObject(), f16);
    }

    public void setRotation(@NonNull @Size(min = 9) float[] fArr) {
        Asserts.assertMat3fIn(fArr);
        nSetRotation(getNativeObject(), fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7], fArr[8]);
    }

    @NonNull
    @Size(min = 4)
    @Deprecated
    public float[] getColorEstimate(@Nullable @Size(min = 4) float[] fArr, float f16, float f17, float f18) {
        float[] assertFloat4 = Asserts.assertFloat4(fArr);
        nGetColorEstimate(getNativeObject(), assertFloat4, f16, f17, f18);
        return assertFloat4;
    }

    @NonNull
    @Size(min = 3)
    @Deprecated
    public float[] getDirectionEstimate(@Nullable @Size(min = 3) float[] fArr) {
        float[] assertFloat3 = Asserts.assertFloat3(fArr);
        nGetDirectionEstimate(getNativeObject(), assertFloat3);
        return assertFloat3;
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
                IndirectLight.nDestroyBuilder(this.mNativeObject);
            }
        }

        public Builder() {
            long access$000 = IndirectLight.access$000();
            this.mNativeBuilder = access$000;
            this.mFinalizer = new BuilderFinalizer(access$000);
        }

        @NonNull
        public IndirectLight build(@NonNull Engine engine) {
            long nBuilderBuild = IndirectLight.nBuilderBuild(this.mNativeBuilder, engine.getNativeObject());
            if (nBuilderBuild != 0) {
                return new IndirectLight(nBuilderBuild);
            }
            throw new IllegalStateException("Couldn't create IndirectLight");
        }

        @NonNull
        public Builder intensity(float f16) {
            IndirectLight.nIntensity(this.mNativeBuilder, f16);
            return this;
        }

        @NonNull
        public Builder irradiance(@IntRange(from = 1, to = 3) int i3, @NonNull float[] fArr) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (fArr.length < 27) {
                            throw new ArrayIndexOutOfBoundsException("3 bands SH, array must be at least 9 x float3");
                        }
                    } else {
                        throw new IllegalArgumentException("bands must be 1, 2 or 3");
                    }
                } else if (fArr.length < 12) {
                    throw new ArrayIndexOutOfBoundsException("2 bands SH, array must be at least 4 x float3");
                }
            } else if (fArr.length < 3) {
                throw new ArrayIndexOutOfBoundsException("1 band SH, array must be at least 1 x float3");
            }
            IndirectLight.nIrradiance(this.mNativeBuilder, i3, fArr);
            return this;
        }

        @NonNull
        public Builder radiance(@IntRange(from = 1, to = 3) int i3, @NonNull float[] fArr) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (fArr.length < 27) {
                            throw new ArrayIndexOutOfBoundsException("3 bands SH, array must be at least 9 x float3");
                        }
                    } else {
                        throw new IllegalArgumentException("bands must be 1, 2 or 3");
                    }
                } else if (fArr.length < 12) {
                    throw new ArrayIndexOutOfBoundsException("2 bands SH, array must be at least 4 x float3");
                }
            } else if (fArr.length < 3) {
                throw new ArrayIndexOutOfBoundsException("1 band SH, array must be at least 1 x float3");
            }
            IndirectLight.nRadiance(this.mNativeBuilder, i3, fArr);
            return this;
        }

        @NonNull
        public Builder reflections(@NonNull Texture texture) {
            IndirectLight.nBuilderReflections(this.mNativeBuilder, texture.getNativeObject());
            return this;
        }

        @NonNull
        public Builder rotation(@NonNull @Size(min = 9) float[] fArr) {
            IndirectLight.nRotation(this.mNativeBuilder, fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6], fArr[7], fArr[8]);
            return this;
        }

        @NonNull
        public Builder irradiance(@NonNull Texture texture) {
            IndirectLight.nIrradianceAsTexture(this.mNativeBuilder, texture.getNativeObject());
            return this;
        }
    }
}
