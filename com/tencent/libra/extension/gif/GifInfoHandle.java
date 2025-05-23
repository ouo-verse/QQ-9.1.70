package com.tencent.libra.extension.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.view.Surface;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public final class GifInfoHandle {

    /* renamed from: a, reason: collision with root package name */
    private volatile long f118732a;

    static {
        j.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle() {
    }

    private void H(@IntRange(from = 0) int i3) {
        int numberOfFrames = getNumberOfFrames(this.f118732a);
        if (i3 >= 0 && i3 < numberOfFrames) {
            return;
        }
        throw new IndexOutOfBoundsException("Frame index is not in range <0;" + numberOfFrames + Typography.greater);
    }

    private static native void bindSurface(long j3, Surface surface, long[] jArr);

    static native int createTempNativeFileDescriptor() throws GifIOException;

    static native int extractNativeFileDescriptor(FileDescriptor fileDescriptor, boolean z16) throws GifIOException;

    private static native void free(long j3);

    private static native long getAllocationByteCount(long j3);

    private static native String getComment(long j3);

    private static native int getCurrentFrameIndex(long j3);

    private static native int getCurrentLoop(long j3);

    private static native int getCurrentPosition(long j3);

    private static native int getDuration(long j3);

    private static native int getFrameDuration(long j3, int i3);

    private static native int getHeight(long j3);

    private static native int getLoopCount(long j3);

    private static native long getMetadataByteCount(long j3);

    private static native int getNativeErrorCode(long j3);

    private static native int getNumberOfFrames(long j3);

    private static native int getSampledHeight(long j3);

    private static native int getSampledWidth(long j3);

    private static native long[] getSavedState(long j3);

    private static native long getSourceLength(long j3);

    private static native int getWidth(long j3);

    private static native void glTexImage2D(long j3, int i3, int i16);

    private static native void glTexSubImage2D(long j3, int i3, int i16);

    private static native void initTexImageDescriptor(long j3);

    private static native boolean isAnimationCompleted(long j3);

    private static native boolean isOpaque(long j3);

    @RequiresApi(21)
    private static int l(FileDescriptor fileDescriptor, boolean z16) throws GifIOException, ErrnoException {
        try {
            int createTempNativeFileDescriptor = createTempNativeFileDescriptor();
            Os.dup2(fileDescriptor, createTempNativeFileDescriptor);
            return createTempNativeFileDescriptor;
        } finally {
            if (z16) {
                Os.close(fileDescriptor);
            }
        }
    }

    static native long openByteArray(byte[] bArr) throws GifIOException;

    static native long openDirectByteBuffer(ByteBuffer byteBuffer) throws GifIOException;

    static native long openFile(String str) throws GifIOException;

    static native long openNativeFileDescriptor(int i3, long j3) throws GifIOException;

    static native long openStream(InputStream inputStream) throws GifIOException;

    private static native void postUnbindSurface(long j3);

    private static native long renderFrame(long j3, Bitmap bitmap);

    private static native boolean reset(long j3);

    private static native long restoreRemainder(long j3);

    private static native int restoreSavedState(long j3, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j3);

    private static native void seekToFrame(long j3, int i3, Bitmap bitmap);

    private static native void seekToFrameGL(long j3, int i3);

    private static native void seekToTime(long j3, int i3, Bitmap bitmap);

    private static native void setLoopCount(long j3, char c16);

    private static native void setOptions(long j3, char c16, boolean z16);

    private static native void setSpeedFactor(long j3, float f16);

    private static native void startDecoderThread(long j3);

    private static native void stopDecoderThread(long j3);

    private static long t(FileDescriptor fileDescriptor, long j3, boolean z16) throws GifIOException {
        int l3;
        if (Build.VERSION.SDK_INT > 27) {
            try {
                l3 = l(fileDescriptor, z16);
            } catch (Exception e16) {
                throw new GifIOException(GifError.OPEN_FAILED.errorCode, e16.getMessage());
            }
        } else {
            l3 = extractNativeFileDescriptor(fileDescriptor, z16);
        }
        return openNativeFileDescriptor(l3, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifInfoHandle u(ContentResolver contentResolver, Uri uri) throws IOException {
        if ("file".equals(uri.getScheme())) {
            return new GifInfoHandle(uri.getPath());
        }
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return new GifInfoHandle(openAssetFileDescriptor);
        }
        throw new IOException("Could not open AssetFileDescriptor for " + uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int A(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.f118732a, jArr, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void B() {
        saveRemainder(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void C(@IntRange(from = 0, to = 2147483647L) int i3, Bitmap bitmap) {
        seekToFrame(this.f118732a, i3, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void D(@IntRange(from = 0, to = 2147483647L) int i3, Bitmap bitmap) {
        seekToTime(this.f118732a, i3, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(@IntRange(from = 0, to = 65535) int i3) {
        if (i3 >= 0 && i3 <= 65535) {
            synchronized (this) {
                setLoopCount(this.f118732a, (char) i3);
            }
            return;
        }
        throw new IllegalArgumentException("Loop count of range <0, 65535>");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(char c16, boolean z16) {
        setOptions(this.f118732a, c16, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(@FloatRange(from = 0.0d, fromInclusive = false) float f16) {
        if (f16 > 0.0f && !Float.isNaN(f16)) {
            if (f16 < 4.656613E-10f) {
                f16 = 4.656613E-10f;
            }
            synchronized (this) {
                setSpeedFactor(this.f118732a, f16);
            }
            return;
        }
        throw new IllegalArgumentException("Speed factor is not positive");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Surface surface, long[] jArr) {
        bindSurface(this.f118732a, surface, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long b() {
        return getAllocationByteCount(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int c() {
        return getCurrentFrameIndex(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int d() {
        return getCurrentLoop(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int e() {
        return getCurrentPosition(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int f() {
        return getDuration(this.f118732a);
    }

    protected void finalize() throws Throwable {
        try {
            w();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int g(@IntRange(from = 0) int i3) {
        H(i3);
        return getFrameDuration(this.f118732a, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return getHeight(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int i() {
        return getLoopCount(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long j() {
        return getMetadataByteCount(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int k() {
        return getNativeErrorCode(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return getNumberOfFrames(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return getSampledHeight(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return getSampledWidth(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long[] p() {
        return getSavedState(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return getWidth(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return isOpaque(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean s() {
        boolean z16;
        if (this.f118732a == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void v() {
        postUnbindSurface(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void w() {
        free(this.f118732a);
        this.f118732a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long x(Bitmap bitmap) {
        return renderFrame(this.f118732a, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean y() {
        return reset(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long z() {
        return restoreRemainder(this.f118732a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(FileDescriptor fileDescriptor) throws GifIOException {
        this.f118732a = t(fileDescriptor, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(byte[] bArr) throws GifIOException {
        this.f118732a = openByteArray(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(ByteBuffer byteBuffer) throws GifIOException {
        this.f118732a = openDirectByteBuffer(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(String str) throws GifIOException {
        this.f118732a = openFile(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(InputStream inputStream) throws GifIOException {
        if (inputStream.markSupported()) {
            this.f118732a = openStream(inputStream);
            return;
        }
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifInfoHandle(AssetFileDescriptor assetFileDescriptor) throws IOException {
        try {
            this.f118732a = t(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), false);
        } finally {
            try {
                assetFileDescriptor.close();
            } catch (IOException unused) {
            }
        }
    }
}
