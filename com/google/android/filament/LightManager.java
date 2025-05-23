package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LightManager {
    public static final float EFFICIENCY_FLUORESCENT = 0.0878f;
    public static final float EFFICIENCY_HALOGEN = 0.0707f;
    public static final float EFFICIENCY_INCANDESCENT = 0.022f;
    public static final float EFFICIENCY_LED = 0.1171f;
    private static final Type[] sTypeValues = Type.values();
    private long mNativeObject;

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
                LightManager.nDestroyBuilder(this.mNativeObject);
            }
        }

        public Builder(@NonNull Type type) {
            long nCreateBuilder = LightManager.nCreateBuilder(type.ordinal());
            this.mNativeBuilder = nCreateBuilder;
            this.mFinalizer = new BuilderFinalizer(nCreateBuilder);
        }

        public void build(@NonNull Engine engine, @Entity int i3) {
            if (LightManager.nBuilderBuild(this.mNativeBuilder, engine.getNativeObject(), i3)) {
                return;
            }
            throw new IllegalStateException("Couldn't create Light component for entity " + i3 + ", see log.");
        }

        @NonNull
        public Builder castLight(boolean z16) {
            LightManager.nBuilderCastLight(this.mNativeBuilder, z16);
            return this;
        }

        @NonNull
        public Builder castShadows(boolean z16) {
            LightManager.nBuilderCastShadows(this.mNativeBuilder, z16);
            return this;
        }

        @NonNull
        public Builder color(float f16, float f17, float f18) {
            LightManager.nBuilderColor(this.mNativeBuilder, f16, f17, f18);
            return this;
        }

        @NonNull
        public Builder direction(float f16, float f17, float f18) {
            LightManager.nBuilderDirection(this.mNativeBuilder, f16, f17, f18);
            return this;
        }

        @NonNull
        public Builder falloff(float f16) {
            LightManager.nBuilderFalloff(this.mNativeBuilder, f16);
            return this;
        }

        @NonNull
        public Builder intensity(float f16) {
            LightManager.nBuilderIntensity(this.mNativeBuilder, f16);
            return this;
        }

        @NonNull
        public Builder intensityCandela(float f16) {
            LightManager.nBuilderIntensityCandela(this.mNativeBuilder, f16);
            return this;
        }

        @NonNull
        public Builder lightChannel(@IntRange(from = 0, to = 7) int i3, boolean z16) {
            LightManager.nBuilderLightChannel(this.mNativeBuilder, i3, z16);
            return this;
        }

        @NonNull
        public Builder position(float f16, float f17, float f18) {
            LightManager.nBuilderPosition(this.mNativeBuilder, f16, f17, f18);
            return this;
        }

        @NonNull
        public Builder shadowOptions(@NonNull ShadowOptions shadowOptions) {
            LightManager.nBuilderShadowOptions(this.mNativeBuilder, shadowOptions.mapSize, shadowOptions.shadowCascades, shadowOptions.cascadeSplitPositions, shadowOptions.constantBias, shadowOptions.normalBias, shadowOptions.shadowFar, shadowOptions.shadowNearHint, shadowOptions.shadowFarHint, shadowOptions.stable, shadowOptions.polygonOffsetConstant, shadowOptions.polygonOffsetSlope, shadowOptions.screenSpaceContactShadows, shadowOptions.stepCount, shadowOptions.maxShadowDistance, shadowOptions.vsmMsaaSamples, shadowOptions.blurWidth, shadowOptions.shadowBulbRadius);
            return this;
        }

        @NonNull
        public Builder spotLightCone(float f16, float f17) {
            LightManager.nBuilderSpotLightCone(this.mNativeBuilder, f16, f17);
            return this;
        }

        @NonNull
        public Builder sunAngularRadius(float f16) {
            LightManager.nBuilderAngularRadius(this.mNativeBuilder, f16);
            return this;
        }

        @NonNull
        public Builder sunHaloFalloff(float f16) {
            LightManager.nBuilderHaloFalloff(this.mNativeBuilder, f16);
            return this;
        }

        @NonNull
        public Builder sunHaloSize(float f16) {
            LightManager.nBuilderHaloSize(this.mNativeBuilder, f16);
            return this;
        }

        @NonNull
        public Builder intensity(float f16, float f17) {
            LightManager.nBuilderIntensity(this.mNativeBuilder, f16, f17);
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ShadowOptions {
        public int mapSize = 1024;

        @IntRange(from = 1, to = 4)
        public int shadowCascades = 1;

        @NonNull
        @Size(min = 3)
        public float[] cascadeSplitPositions = {0.25f, 0.5f, 0.75f};
        public float constantBias = 0.001f;
        public float normalBias = 1.0f;
        public float shadowFar = 0.0f;
        public float shadowNearHint = 1.0f;
        public float shadowFarHint = 100.0f;
        public boolean stable = false;
        float polygonOffsetConstant = 0.5f;
        float polygonOffsetSlope = 2.0f;
        public boolean screenSpaceContactShadows = false;
        public int stepCount = 8;
        public float maxShadowDistance = 0.3f;

        @IntRange(from = 1)
        public int vsmMsaaSamples = 1;
        public float blurWidth = 0.0f;
        public float shadowBulbRadius = 0.02f;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum Type {
        SUN,
        DIRECTIONAL,
        POINT,
        FOCUSED_SPOT,
        SPOT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LightManager(long j3) {
        this.mNativeObject = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderAngularRadius(long j3, float f16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean nBuilderBuild(long j3, long j16, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderCastLight(long j3, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderCastShadows(long j3, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderColor(long j3, float f16, float f17, float f18);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderDirection(long j3, float f16, float f17, float f18);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderFalloff(long j3, float f16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderHaloFalloff(long j3, float f16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderHaloSize(long j3, float f16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderIntensity(long j3, float f16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderIntensity(long j3, float f16, float f17);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderIntensityCandela(long j3, float f16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderLightChannel(long j3, int i3, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderPosition(long j3, float f16, float f17, float f18);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderShadowOptions(long j3, int i3, int i16, float[] fArr, float f16, float f17, float f18, float f19, float f26, boolean z16, float f27, float f28, boolean z17, int i17, float f29, int i18, float f36, float f37);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderSpotLightCone(long j3, float f16, float f17);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nComputeLogSplits(float[] fArr, int i3, float f16, float f17);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nComputePracticalSplits(float[] fArr, int i3, float f16, float f17, float f18);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nComputeUniformSplits(float[] fArr, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nCreateBuilder(int i3);

    private static native void nDestroy(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDestroyBuilder(long j3);

    private static native void nGetColor(long j3, int i3, float[] fArr);

    private static native int nGetComponentCount(long j3);

    private static native void nGetDirection(long j3, int i3, float[] fArr);

    private static native float nGetFalloff(long j3, int i3);

    private static native float nGetInnerConeAngle(long j3, int i3);

    private static native int nGetInstance(long j3, int i3);

    private static native float nGetIntensity(long j3, int i3);

    private static native boolean nGetLightChannel(long j3, int i3, int i16);

    private static native float nGetOuterConeAngle(long j3, int i3);

    private static native void nGetPosition(long j3, int i3, float[] fArr);

    private static native float nGetSunAngularRadius(long j3, int i3);

    private static native float nGetSunHaloFalloff(long j3, int i3);

    private static native float nGetSunHaloSize(long j3, int i3);

    private static native int nGetType(long j3, int i3);

    private static native boolean nHasComponent(long j3, int i3);

    private static native boolean nIsShadowCaster(long j3, int i3);

    private static native void nSetColor(long j3, int i3, float f16, float f17, float f18);

    private static native void nSetDirection(long j3, int i3, float f16, float f17, float f18);

    private static native void nSetFalloff(long j3, int i3, float f16);

    private static native void nSetIntensity(long j3, int i3, float f16);

    private static native void nSetIntensity(long j3, int i3, float f16, float f17);

    private static native void nSetIntensityCandela(long j3, int i3, float f16);

    private static native void nSetLightChannel(long j3, int i3, int i16, boolean z16);

    private static native void nSetPosition(long j3, int i3, float f16, float f17, float f18);

    private static native void nSetShadowCaster(long j3, int i3, boolean z16);

    private static native void nSetSpotLightCone(long j3, int i3, float f16, float f17);

    private static native void nSetSunAngularRadius(long j3, int i3, float f16);

    private static native void nSetSunHaloFalloff(long j3, int i3, float f16);

    private static native void nSetSunHaloSize(long j3, int i3, float f16);

    public void destroy(@Entity int i3) {
        nDestroy(this.mNativeObject, i3);
    }

    @NonNull
    public float[] getColor(@EntityInstance int i3, @Nullable @Size(min = 3) float[] fArr) {
        float[] assertFloat3 = Asserts.assertFloat3(fArr);
        nGetColor(this.mNativeObject, i3, assertFloat3);
        return assertFloat3;
    }

    public int getComponentCount() {
        return nGetComponentCount(this.mNativeObject);
    }

    @NonNull
    public float[] getDirection(@EntityInstance int i3, @Nullable @Size(min = 3) float[] fArr) {
        float[] assertFloat3 = Asserts.assertFloat3(fArr);
        nGetDirection(this.mNativeObject, i3, assertFloat3);
        return assertFloat3;
    }

    public float getFalloff(@EntityInstance int i3) {
        return nGetFalloff(this.mNativeObject, i3);
    }

    public float getInnerConeAngle(@EntityInstance int i3) {
        return nGetInnerConeAngle(this.mNativeObject, i3);
    }

    @EntityInstance
    public int getInstance(@Entity int i3) {
        return nGetInstance(this.mNativeObject, i3);
    }

    public float getIntensity(@EntityInstance int i3) {
        return nGetIntensity(this.mNativeObject, i3);
    }

    public boolean getLightChannel(@EntityInstance int i3, @IntRange(from = 0, to = 7) int i16) {
        return nGetLightChannel(this.mNativeObject, i3, i16);
    }

    public long getNativeObject() {
        return this.mNativeObject;
    }

    public float getOuterConeAngle(@EntityInstance int i3) {
        return nGetOuterConeAngle(this.mNativeObject, i3);
    }

    @NonNull
    public float[] getPosition(@EntityInstance int i3, @Nullable @Size(min = 3) float[] fArr) {
        float[] assertFloat3 = Asserts.assertFloat3(fArr);
        nGetPosition(this.mNativeObject, i3, assertFloat3);
        return assertFloat3;
    }

    public float getSunAngularRadius(@EntityInstance int i3) {
        return nGetSunAngularRadius(this.mNativeObject, i3);
    }

    public float getSunHaloFalloff(@EntityInstance int i3) {
        return nGetSunHaloFalloff(this.mNativeObject, i3);
    }

    public float getSunHaloSize(@EntityInstance int i3) {
        return nGetSunHaloSize(this.mNativeObject, i3);
    }

    @NonNull
    public Type getType(@EntityInstance int i3) {
        return sTypeValues[nGetType(this.mNativeObject, i3)];
    }

    public boolean hasComponent(@Entity int i3) {
        return nHasComponent(this.mNativeObject, i3);
    }

    boolean isDirectional(@EntityInstance int i3) {
        Type type = getType(i3);
        if (type != Type.DIRECTIONAL && type != Type.SUN) {
            return false;
        }
        return true;
    }

    boolean isPointLight(@EntityInstance int i3) {
        if (getType(i3) == Type.POINT) {
            return true;
        }
        return false;
    }

    public boolean isShadowCaster(@EntityInstance int i3) {
        return nIsShadowCaster(this.mNativeObject, i3);
    }

    boolean isSpotLight(@EntityInstance int i3) {
        Type type = getType(i3);
        if (type != Type.SPOT && type != Type.FOCUSED_SPOT) {
            return false;
        }
        return true;
    }

    public void setColor(@EntityInstance int i3, float f16, float f17, float f18) {
        nSetColor(this.mNativeObject, i3, f16, f17, f18);
    }

    public void setDirection(@EntityInstance int i3, float f16, float f17, float f18) {
        nSetDirection(this.mNativeObject, i3, f16, f17, f18);
    }

    public void setFalloff(@EntityInstance int i3, float f16) {
        nSetFalloff(this.mNativeObject, i3, f16);
    }

    public void setIntensity(@EntityInstance int i3, float f16) {
        nSetIntensity(this.mNativeObject, i3, f16);
    }

    public void setIntensityCandela(@EntityInstance int i3, float f16) {
        nSetIntensityCandela(this.mNativeObject, i3, f16);
    }

    public void setLightChannel(@EntityInstance int i3, @IntRange(from = 0, to = 7) int i16, boolean z16) {
        nSetLightChannel(this.mNativeObject, i3, i16, z16);
    }

    public void setPosition(@EntityInstance int i3, float f16, float f17, float f18) {
        nSetPosition(this.mNativeObject, i3, f16, f17, f18);
    }

    public void setShadowCaster(@EntityInstance int i3, boolean z16) {
        nSetShadowCaster(this.mNativeObject, i3, z16);
    }

    public void setSpotLightCone(@EntityInstance int i3, float f16, float f17) {
        nSetSpotLightCone(this.mNativeObject, i3, f16, f17);
    }

    public void setSunAngularRadius(@EntityInstance int i3, float f16) {
        nSetSunAngularRadius(this.mNativeObject, i3, f16);
    }

    public void setSunHaloFalloff(@EntityInstance int i3, float f16) {
        nSetSunHaloFalloff(this.mNativeObject, i3, f16);
    }

    public void setSunHaloSize(@EntityInstance int i3, float f16) {
        nSetSunHaloSize(this.mNativeObject, i3, f16);
    }

    public void setIntensity(@EntityInstance int i3, float f16, float f17) {
        nSetIntensity(this.mNativeObject, i3, f16, f17);
    }
}
