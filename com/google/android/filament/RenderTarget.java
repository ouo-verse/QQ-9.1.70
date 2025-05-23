package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.filament.Texture;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RenderTarget {
    private static final int ATTACHMENT_COUNT = AttachmentPoint.values().length;
    private static final Texture.CubemapFace[] sCubemapFaceValues = Texture.CubemapFace.values();
    private long mNativeObject;
    private final Texture[] mTextures;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum AttachmentPoint {
        COLOR,
        COLOR1,
        COLOR2,
        COLOR3,
        COLOR4,
        COLOR5,
        COLOR6,
        COLOR7,
        DEPTH
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Builder {
        private final BuilderFinalizer mFinalizer;
        private final long mNativeBuilder;
        private final Texture[] mTextures = new Texture[RenderTarget.ATTACHMENT_COUNT];

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
                RenderTarget.nDestroyBuilder(this.mNativeObject);
            }
        }

        public Builder() {
            long access$200 = RenderTarget.access$200();
            this.mNativeBuilder = access$200;
            this.mFinalizer = new BuilderFinalizer(access$200);
        }

        @NonNull
        public RenderTarget build(@NonNull Engine engine) {
            long nBuilderBuild = RenderTarget.nBuilderBuild(this.mNativeBuilder, engine.getNativeObject());
            if (nBuilderBuild != 0) {
                return new RenderTarget(nBuilderBuild, this);
            }
            throw new IllegalStateException("Couldn't create RenderTarget");
        }

        @NonNull
        public Builder face(@NonNull AttachmentPoint attachmentPoint, Texture.CubemapFace cubemapFace) {
            RenderTarget.nBuilderFace(this.mNativeBuilder, attachmentPoint.ordinal(), cubemapFace.ordinal());
            return this;
        }

        @NonNull
        public Builder layer(@NonNull AttachmentPoint attachmentPoint, @IntRange(from = 0) int i3) {
            RenderTarget.nBuilderLayer(this.mNativeBuilder, attachmentPoint.ordinal(), i3);
            return this;
        }

        @NonNull
        public Builder mipLevel(@NonNull AttachmentPoint attachmentPoint, @IntRange(from = 0) int i3) {
            RenderTarget.nBuilderMipLevel(this.mNativeBuilder, attachmentPoint.ordinal(), i3);
            return this;
        }

        @NonNull
        public Builder texture(@NonNull AttachmentPoint attachmentPoint, @Nullable Texture texture) {
            long j3;
            this.mTextures[attachmentPoint.ordinal()] = texture;
            long j16 = this.mNativeBuilder;
            int ordinal = attachmentPoint.ordinal();
            if (texture != null) {
                j3 = texture.getNativeObject();
            } else {
                j3 = 0;
            }
            RenderTarget.nBuilderTexture(j16, ordinal, j3);
            return this;
        }
    }

    static /* synthetic */ long access$200() {
        return nCreateBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nBuilderBuild(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderFace(long j3, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderLayer(long j3, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderMipLevel(long j3, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderTexture(long j3, int i3, long j16);

    private static native long nCreateBuilder();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDestroyBuilder(long j3);

    private static native int nGetFace(long j3, int i3);

    private static native int nGetLayer(long j3, int i3);

    private static native int nGetMipLevel(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    public Texture.CubemapFace getFace(AttachmentPoint attachmentPoint) {
        return sCubemapFaceValues[nGetFace(getNativeObject(), attachmentPoint.ordinal())];
    }

    @IntRange(from = 0)
    public int getLayer(@NonNull AttachmentPoint attachmentPoint) {
        return nGetLayer(getNativeObject(), attachmentPoint.ordinal());
    }

    @IntRange(from = 0)
    public int getMipLevel(@NonNull AttachmentPoint attachmentPoint) {
        return nGetMipLevel(getNativeObject(), attachmentPoint.ordinal());
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed RenderTarget");
    }

    @Nullable
    public Texture getTexture(@NonNull AttachmentPoint attachmentPoint) {
        return this.mTextures[attachmentPoint.ordinal()];
    }

    RenderTarget(long j3, Builder builder) {
        int i3 = ATTACHMENT_COUNT;
        Texture[] textureArr = new Texture[i3];
        this.mTextures = textureArr;
        this.mNativeObject = j3;
        System.arraycopy(builder.mTextures, 0, textureArr, 0, i3);
    }
}
