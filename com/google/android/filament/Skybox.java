package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Skybox {
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
                Skybox.nDestroyBuilder(this.mNativeObject);
            }
        }

        public Builder() {
            long access$000 = Skybox.access$000();
            this.mNativeBuilder = access$000;
            this.mFinalizer = new BuilderFinalizer(access$000);
        }

        @NonNull
        public Skybox build(@NonNull Engine engine) {
            long nBuilderBuild = Skybox.nBuilderBuild(this.mNativeBuilder, engine.getNativeObject());
            if (nBuilderBuild != 0) {
                return new Skybox(nBuilderBuild);
            }
            throw new IllegalStateException("Couldn't create Skybox");
        }

        @NonNull
        public Builder color(float f16, float f17, float f18, float f19) {
            Skybox.nBuilderColor(this.mNativeBuilder, f16, f17, f18, f19);
            return this;
        }

        @NonNull
        public Builder environment(@NonNull Texture texture) {
            Skybox.nBuilderEnvironment(this.mNativeBuilder, texture.getNativeObject());
            return this;
        }

        @NonNull
        public Builder intensity(float f16) {
            Skybox.nBuilderIntensity(this.mNativeBuilder, f16);
            return this;
        }

        @NonNull
        public Builder showSun(boolean z16) {
            Skybox.nBuilderShowSun(this.mNativeBuilder, z16);
            return this;
        }

        @NonNull
        public Builder color(@NonNull @Size(min = 4) float[] fArr) {
            Skybox.nBuilderColor(this.mNativeBuilder, fArr[0], fArr[1], fArr[2], fArr[3]);
            return this;
        }
    }

    public Skybox(long j3) {
        this.mNativeObject = j3;
    }

    static /* synthetic */ long access$000() {
        return nCreateBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nBuilderBuild(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderColor(long j3, float f16, float f17, float f18, float f19);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderEnvironment(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderIntensity(long j3, float f16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderShowSun(long j3, boolean z16);

    private static native long nCreateBuilder();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDestroyBuilder(long j3);

    private static native float nGetIntensity(long j3);

    private static native int nGetLayerMask(long j3);

    private static native long nGetTexture(long j3);

    private static native void nSetColor(long j3, float f16, float f17, float f18, float f19);

    private static native void nSetLayerMask(long j3, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    public float getIntensity() {
        return nGetIntensity(getNativeObject());
    }

    public int getLayerMask() {
        return nGetLayerMask(getNativeObject());
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed Skybox");
    }

    @Nullable
    public Texture getTexture() {
        long nGetTexture = nGetTexture(getNativeObject());
        if (nGetTexture == 0) {
            return null;
        }
        return new Texture(nGetTexture);
    }

    public void setColor(float f16, float f17, float f18, float f19) {
        nSetColor(getNativeObject(), f16, f17, f18, f19);
    }

    public void setLayerMask(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i16) {
        nSetLayerMask(getNativeObject(), i3 & 255, i16 & 255);
    }

    public void setColor(@NonNull @Size(min = 4) float[] fArr) {
        nSetColor(getNativeObject(), fArr[0], fArr[1], fArr[2], fArr[3]);
    }
}
