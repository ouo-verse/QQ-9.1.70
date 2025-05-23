package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.Buffer;
import java.nio.BufferOverflowException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class VertexBuffer {
    private long mNativeObject;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum AttributeType {
        BYTE,
        BYTE2,
        BYTE3,
        BYTE4,
        UBYTE,
        UBYTE2,
        UBYTE3,
        UBYTE4,
        SHORT,
        SHORT2,
        SHORT3,
        SHORT4,
        USHORT,
        USHORT2,
        USHORT3,
        USHORT4,
        INT,
        UINT,
        FLOAT,
        FLOAT2,
        FLOAT3,
        FLOAT4,
        HALF,
        HALF2,
        HALF3,
        HALF4
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
                VertexBuffer.nDestroyBuilder(this.mNativeObject);
            }
        }

        public Builder() {
            long access$000 = VertexBuffer.access$000();
            this.mNativeBuilder = access$000;
            this.mFinalizer = new BuilderFinalizer(access$000);
        }

        @NonNull
        public Builder attribute(@NonNull VertexAttribute vertexAttribute, @IntRange(from = 0) int i3, @NonNull AttributeType attributeType, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17) {
            VertexBuffer.nBuilderAttribute(this.mNativeBuilder, vertexAttribute.ordinal(), i3, attributeType.ordinal(), i16, i17);
            return this;
        }

        @NonNull
        public Builder bufferCount(@IntRange(from = 1) int i3) {
            VertexBuffer.nBuilderBufferCount(this.mNativeBuilder, i3);
            return this;
        }

        @NonNull
        public VertexBuffer build(@NonNull Engine engine) {
            long nBuilderBuild = VertexBuffer.nBuilderBuild(this.mNativeBuilder, engine.getNativeObject());
            if (nBuilderBuild != 0) {
                return new VertexBuffer(nBuilderBuild);
            }
            throw new IllegalStateException("Couldn't create VertexBuffer");
        }

        @NonNull
        public Builder enableBufferObjects(boolean z16) {
            VertexBuffer.nBuilderEnableBufferObjects(this.mNativeBuilder, z16);
            return this;
        }

        @NonNull
        public Builder normalized(@NonNull VertexAttribute vertexAttribute) {
            VertexBuffer.nBuilderNormalized(this.mNativeBuilder, vertexAttribute.ordinal(), true);
            return this;
        }

        @NonNull
        public Builder vertexCount(@IntRange(from = 1) int i3) {
            VertexBuffer.nBuilderVertexCount(this.mNativeBuilder, i3);
            return this;
        }

        @NonNull
        public Builder normalized(@NonNull VertexAttribute vertexAttribute, boolean z16) {
            VertexBuffer.nBuilderNormalized(this.mNativeBuilder, vertexAttribute.ordinal(), z16);
            return this;
        }

        @NonNull
        public Builder attribute(@NonNull VertexAttribute vertexAttribute, @IntRange(from = 0) int i3, @NonNull AttributeType attributeType) {
            return attribute(vertexAttribute, i3, attributeType, 0, 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum VertexAttribute {
        POSITION,
        TANGENTS,
        COLOR,
        UV0,
        UV1,
        BONE_INDICES,
        BONE_WEIGHTS,
        UNUSED,
        CUSTOM0,
        CUSTOM1,
        CUSTOM2,
        CUSTOM3,
        CUSTOM4,
        CUSTOM5,
        CUSTOM6,
        CUSTOM7
    }

    static /* synthetic */ long access$000() {
        return nCreateBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderAttribute(long j3, int i3, int i16, int i17, int i18, int i19);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderBufferCount(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nBuilderBuild(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderEnableBufferObjects(long j3, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderNormalized(long j3, int i3, boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderVertexCount(long j3, int i3);

    private static native long nCreateBuilder();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDestroyBuilder(long j3);

    private static native int nGetVertexCount(long j3);

    private static native int nSetBufferAt(long j3, long j16, int i3, Buffer buffer, int i16, int i17, int i18, Object obj, Runnable runnable);

    private static native void nSetBufferObjectAt(long j3, long j16, int i3, long j17);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed VertexBuffer");
    }

    @IntRange(from = 0)
    public int getVertexCount() {
        return nGetVertexCount(getNativeObject());
    }

    public void setBufferAt(@NonNull Engine engine, int i3, @NonNull Buffer buffer) {
        setBufferAt(engine, i3, buffer, 0, 0, null, null);
    }

    public void setBufferObjectAt(@NonNull Engine engine, int i3, @NonNull BufferObject bufferObject) {
        nSetBufferObjectAt(getNativeObject(), engine.getNativeObject(), i3, bufferObject.a());
    }

    VertexBuffer(long j3) {
        this.mNativeObject = j3;
    }

    public void setBufferAt(@NonNull Engine engine, int i3, @NonNull Buffer buffer, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17) {
        setBufferAt(engine, i3, buffer, i16, i17, null, null);
    }

    public void setBufferAt(@NonNull Engine engine, int i3, @NonNull Buffer buffer, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @Nullable Object obj, @Nullable Runnable runnable) {
        if (nSetBufferAt(getNativeObject(), engine.getNativeObject(), i3, buffer, buffer.remaining(), i16, i17 == 0 ? buffer.remaining() : i17, obj, runnable) < 0) {
            throw new BufferOverflowException();
        }
    }
}
