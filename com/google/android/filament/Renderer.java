package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.filament.Texture;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.nio.ReadOnlyBufferException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Renderer {
    public static final int MIRROR_FRAME_FLAG_CLEAR = 4;
    public static final int MIRROR_FRAME_FLAG_COMMIT = 1;
    public static final int MIRROR_FRAME_FLAG_SET_PRESENTATION_TIME = 2;
    private a mClearOptions;
    private b mDisplayInfo;
    private final Engine mEngine;
    private c mFrameRateOptions;
    private long mNativeObject;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public float[] f32967a = {0.0f, 0.0f, 0.0f, 0.0f};

        /* renamed from: b, reason: collision with root package name */
        public boolean f32968b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f32969c = true;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public float f32970a = 60.0f;

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public long f32971b = 0;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public long f32972c = 0;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public float f32973a = 0.016666668f;

        /* renamed from: b, reason: collision with root package name */
        public float f32974b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f32975c = 0.06666667f;

        /* renamed from: d, reason: collision with root package name */
        public int f32976d = 15;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Renderer(@NonNull Engine engine, long j3) {
        this.mEngine = engine;
        this.mNativeObject = j3;
    }

    private static native boolean nBeginFrame(long j3, long j16, long j17);

    private static native void nCopyFrame(long j3, long j16, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29);

    private static native void nEndFrame(long j3);

    private static native double nGetUserTime(long j3);

    private static native int nReadPixels(long j3, long j16, int i3, int i16, int i17, int i18, Buffer buffer, int i19, int i26, int i27, int i28, int i29, int i36, int i37, Object obj, Runnable runnable);

    private static native int nReadPixelsEx(long j3, long j16, long j17, int i3, int i16, int i17, int i18, Buffer buffer, int i19, int i26, int i27, int i28, int i29, int i36, int i37, Object obj, Runnable runnable);

    private static native void nRender(long j3, long j16);

    private static native void nRenderStandaloneView(long j3, long j16);

    private static native void nResetUserTime(long j3);

    private static native void nSetClearOptions(long j3, float f16, float f17, float f18, float f19, boolean z16, boolean z17);

    private static native void nSetDisplayInfo(long j3, float f16);

    private static native void nSetFrameRateOptions(long j3, float f16, float f17, float f18, int i3);

    private static native void nSetPresentationTime(long j3, long j16);

    public boolean beginFrame(@NonNull SwapChain swapChain, long j3) {
        return nBeginFrame(getNativeObject(), swapChain.getNativeObject(), j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearNativeObject() {
        this.mNativeObject = 0L;
    }

    public void copyFrame(@NonNull SwapChain swapChain, @NonNull Viewport viewport, @NonNull Viewport viewport2, int i3) {
        nCopyFrame(getNativeObject(), swapChain.getNativeObject(), viewport.left, viewport.bottom, viewport.width, viewport.height, viewport2.left, viewport2.bottom, viewport2.width, viewport2.height, i3);
    }

    public void endFrame() {
        nEndFrame(getNativeObject());
    }

    @NonNull
    public a getClearOptions() {
        if (this.mClearOptions == null) {
            this.mClearOptions = new a();
        }
        return this.mClearOptions;
    }

    @NonNull
    public b getDisplayInfo() {
        if (this.mDisplayInfo == null) {
            this.mDisplayInfo = new b();
        }
        return this.mDisplayInfo;
    }

    @NonNull
    public Engine getEngine() {
        return this.mEngine;
    }

    @NonNull
    public c getFrameRateOptions() {
        if (this.mFrameRateOptions == null) {
            this.mFrameRateOptions = new c();
        }
        return this.mFrameRateOptions;
    }

    public long getNativeObject() {
        long j3 = this.mNativeObject;
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalStateException("Calling method on destroyed Renderer");
    }

    public double getUserTime() {
        return nGetUserTime(getNativeObject());
    }

    @Deprecated
    public void mirrorFrame(@NonNull SwapChain swapChain, @NonNull Viewport viewport, @NonNull Viewport viewport2, int i3) {
        copyFrame(swapChain, viewport, viewport2, i3);
    }

    public void readPixels(@IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18, @NonNull Texture.PixelBufferDescriptor pixelBufferDescriptor) {
        if (!pixelBufferDescriptor.storage.isReadOnly()) {
            long nativeObject = getNativeObject();
            long nativeObject2 = this.mEngine.getNativeObject();
            Buffer buffer = pixelBufferDescriptor.storage;
            if (nReadPixels(nativeObject, nativeObject2, i3, i16, i17, i18, buffer, buffer.remaining(), pixelBufferDescriptor.left, pixelBufferDescriptor.top, pixelBufferDescriptor.type.ordinal(), pixelBufferDescriptor.alignment, pixelBufferDescriptor.stride, pixelBufferDescriptor.format.ordinal(), pixelBufferDescriptor.handler, pixelBufferDescriptor.callback) < 0) {
                throw new BufferOverflowException();
            }
            return;
        }
        throw new ReadOnlyBufferException();
    }

    public void render(@NonNull View view) {
        nRender(getNativeObject(), view.getNativeObject());
    }

    public void renderStandaloneView(@NonNull View view) {
        nRenderStandaloneView(getNativeObject(), view.getNativeObject());
    }

    public void resetUserTime() {
        nResetUserTime(getNativeObject());
    }

    public void setClearOptions(@NonNull a aVar) {
        this.mClearOptions = aVar;
        long nativeObject = getNativeObject();
        float[] fArr = aVar.f32967a;
        nSetClearOptions(nativeObject, fArr[0], fArr[1], fArr[2], fArr[3], aVar.f32968b, aVar.f32969c);
    }

    public void setDisplayInfo(@NonNull b bVar) {
        this.mDisplayInfo = bVar;
        nSetDisplayInfo(getNativeObject(), bVar.f32970a);
    }

    public void setFrameRateOptions(@NonNull c cVar) {
        this.mFrameRateOptions = cVar;
        nSetFrameRateOptions(getNativeObject(), cVar.f32973a, cVar.f32974b, cVar.f32975c, cVar.f32976d);
    }

    public void setPresentationTime(long j3) {
        nSetPresentationTime(getNativeObject(), j3);
    }

    public void readPixels(@NonNull RenderTarget renderTarget, @IntRange(from = 0) int i3, @IntRange(from = 0) int i16, @IntRange(from = 0) int i17, @IntRange(from = 0) int i18, @NonNull Texture.PixelBufferDescriptor pixelBufferDescriptor) {
        if (!pixelBufferDescriptor.storage.isReadOnly()) {
            long nativeObject = getNativeObject();
            long nativeObject2 = this.mEngine.getNativeObject();
            long nativeObject3 = renderTarget.getNativeObject();
            Buffer buffer = pixelBufferDescriptor.storage;
            if (nReadPixelsEx(nativeObject, nativeObject2, nativeObject3, i3, i16, i17, i18, buffer, buffer.remaining(), pixelBufferDescriptor.left, pixelBufferDescriptor.top, pixelBufferDescriptor.type.ordinal(), pixelBufferDescriptor.alignment, pixelBufferDescriptor.stride, pixelBufferDescriptor.format.ordinal(), pixelBufferDescriptor.handler, pixelBufferDescriptor.callback) < 0) {
                throw new BufferOverflowException();
            }
            return;
        }
        throw new ReadOnlyBufferException();
    }
}
