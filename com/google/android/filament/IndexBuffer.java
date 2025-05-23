package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.Buffer;
import java.nio.BufferOverflowException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class IndexBuffer {
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
                IndexBuffer.nDestroyBuilder(this.mNativeObject);
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        public enum IndexType {
            USHORT,
            UINT
        }

        public Builder() {
            long access$000 = IndexBuffer.access$000();
            this.mNativeBuilder = access$000;
            this.mFinalizer = new BuilderFinalizer(access$000);
        }

        @NonNull
        public Builder bufferType(@NonNull IndexType indexType) {
            IndexBuffer.nBuilderBufferType(this.mNativeBuilder, indexType.ordinal());
            return this;
        }

        @NonNull
        public IndexBuffer build(@NonNull Engine engine) {
            long nBuilderBuild = IndexBuffer.nBuilderBuild(this.mNativeBuilder, engine.getNativeObject());
            if (nBuilderBuild != 0) {
                return new IndexBuffer(nBuilderBuild);
            }
            throw new IllegalStateException("Couldn't create IndexBuffer");
        }

        @NonNull
        public Builder indexCount(@IntRange(from = 1) int i3) {
            IndexBuffer.nBuilderIndexCount(this.mNativeBuilder, i3);
            return this;
        }
    }

    static /* synthetic */ long access$000() {
        return nCreateBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderBufferType(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nBuilderBuild(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderIndexCount(long j3, int i3);

    private static native long nCreateBuilder();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDestroyBuilder(long j3);

    private static native int nGetIndexCount(long j3);

    private static native int nSetBuffer(long j3, long j16, Buffer buffer, int i3, int i16, int i17, Object obj, Runnable runnable);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    @IntRange(from = 0)
    public int getIndexCount() {
        return nGetIndexCount(getNativeObject());
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed IndexBuffer");
    }

    public void setBuffer(@NonNull Engine engine, @NonNull Buffer buffer) {
        setBuffer(engine, buffer, 0, 0, null, null);
    }

    IndexBuffer(long j3) {
        this.mNativeObject = j3;
    }

    public void setBuffer(@NonNull Engine engine, @NonNull Buffer buffer, @IntRange(from = 0) int i3, @IntRange(from = 0) int i16) {
        setBuffer(engine, buffer, i3, i16, null, null);
    }

    public void setBuffer(@NonNull Engine engine, @NonNull Buffer buffer, @IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @Nullable Object obj, @Nullable Runnable runnable) {
        if (nSetBuffer(getNativeObject(), engine.getNativeObject(), buffer, buffer.remaining(), i3, i16 == 0 ? buffer.remaining() : i16, obj, runnable) < 0) {
            throw new BufferOverflowException();
        }
    }
}
