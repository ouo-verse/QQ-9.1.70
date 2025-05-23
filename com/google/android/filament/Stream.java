package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.nio.Buffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Stream {
    private static final StreamType[] sStreamTypeValues = StreamType.values();
    private long mNativeEngine;
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
                Stream.nDestroyBuilder(this.mNativeObject);
            }
        }

        public Builder() {
            long access$000 = Stream.access$000();
            this.mNativeBuilder = access$000;
            this.mFinalizer = new BuilderFinalizer(access$000);
        }

        @NonNull
        public Stream build(@NonNull Engine engine) {
            long nBuilderBuild = Stream.nBuilderBuild(this.mNativeBuilder, engine.getNativeObject());
            if (nBuilderBuild != 0) {
                return new Stream(nBuilderBuild, engine);
            }
            throw new IllegalStateException("Couldn't create Stream");
        }

        @NonNull
        public Builder height(int i3) {
            Stream.nBuilderHeight(this.mNativeBuilder, i3);
            return this;
        }

        @NonNull
        public Builder stream(@NonNull Object obj) {
            if (Platform.get().validateStreamSource(obj)) {
                Stream.nBuilderStreamSource(this.mNativeBuilder, obj);
                return this;
            }
            throw new IllegalArgumentException("Invalid stream source: " + obj);
        }

        @NonNull
        public Builder width(int i3) {
            Stream.nBuilderWidth(this.mNativeBuilder, i3);
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum StreamType {
        NATIVE,
        ACQUIRED
    }

    Stream(long j3, Engine engine) {
        this.mNativeObject = j3;
        this.mNativeEngine = engine.getNativeObject();
    }

    static /* synthetic */ long access$000() {
        return nCreateBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nBuilderBuild(long j3, long j16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderHeight(long j3, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderStreamSource(long j3, Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nBuilderWidth(long j3, int i3);

    private static native long nCreateBuilder();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDestroyBuilder(long j3);

    private static native int nGetStreamType(long j3);

    private static native long nGetTimestamp(long j3);

    private static native int nReadPixels(long j3, long j16, int i3, int i16, int i17, int i18, Buffer buffer, int i19, int i26, int i27, int i28, int i29, int i36, int i37, Object obj, Runnable runnable);

    private static native void nSetAcquiredImage(long j3, long j16, Object obj, Object obj2, Runnable runnable);

    private static native void nSetDimensions(long j3, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed Stream");
    }

    public StreamType getStreamType() {
        return sStreamTypeValues[nGetStreamType(getNativeObject())];
    }

    public long getTimestamp() {
        return nGetTimestamp(getNativeObject());
    }

    public void setAcquiredImage(Object obj, Object obj2, Runnable runnable) {
        nSetAcquiredImage(getNativeObject(), this.mNativeEngine, obj, obj2, runnable);
    }

    public void setDimensions(@IntRange(from = 0) int i3, @IntRange(from = 0) int i16) {
        nSetDimensions(getNativeObject(), i3, i16);
    }
}
