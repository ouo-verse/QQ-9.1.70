package com.tencent.component.media.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.Surface;
import com.tencent.component.media.gif.NewGifDecoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes5.dex */
final class GifInfoHandle {
    static final GifInfoHandle NULL_INFO = new GifInfoHandle(0, 0, 0, 0);
    int frameCount;
    private volatile long gifInfoPtr;
    final int height;
    final int width;

    static {
        System.loadLibrary("image_gif");
    }

    GifInfoHandle(long j3, int i3, int i16, int i17) {
        this.gifInfoPtr = j3;
        this.width = i3;
        this.height = i16;
        this.frameCount = i17;
    }

    private static native void bindSurface(long j3, Surface surface, long[] jArr, boolean z16);

    static native long changeFile(long j3, String str, boolean z16);

    private static native long doRender(long j3, Bitmap bitmap);

    private static native void free(long j3);

    private static native long getAllocationByteCount(long j3);

    private static native String getComment(long j3);

    private static native int getCurrentFrameIndex(long j3);

    private static native int getCurrentLoop(long j3);

    private static native int getCurrentPosition(long j3);

    private static native int getDuration(long j3);

    private static native int getFrameDuration(long j3, int i3);

    private static native int getImageCount(long j3);

    private static native int getLoopCount(long j3);

    private static native int getNativeErrorCode(long j3);

    private static native int getPreferConfig(long j3);

    private static native long[] getSavedState(long j3);

    private static native long getSourceLength(long j3);

    private static native boolean isAnimationCompleted(long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifInfoHandle openAssetFileDescriptor(AssetFileDescriptor assetFileDescriptor, boolean z16, NewGifDecoder.Options options) throws IOException {
        try {
            return openFd(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), z16, options);
        } finally {
            assetFileDescriptor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native GifInfoHandle openByteArray(byte[] bArr, boolean z16, NewGifDecoder.Options options) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native GifInfoHandle openDirectByteBuffer(ByteBuffer byteBuffer, boolean z16, NewGifDecoder.Options options) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native GifInfoHandle openFd(FileDescriptor fileDescriptor, long j3, boolean z16, NewGifDecoder.Options options) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native GifInfoHandle openFile(String str, boolean z16, NewGifDecoder.Options options) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native GifInfoHandle openFileForGifPlaying(String str, boolean z16, NewGifDecoder.Options options) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifInfoHandle openMarkableInputStream(InputStream inputStream, boolean z16, NewGifDecoder.Options options) throws GifIOException {
        if (inputStream.markSupported()) {
            return openStream(inputStream, z16, options);
        }
        throw new IllegalArgumentException("InputStream does not support marking");
    }

    static native GifInfoHandle openStream(InputStream inputStream, boolean z16, NewGifDecoder.Options options) throws GifIOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifInfoHandle openUri(ContentResolver contentResolver, Uri uri, boolean z16, NewGifDecoder.Options options) throws IOException {
        if ("file".equals(uri.getScheme())) {
            return openFile(uri.getPath(), z16, null);
        }
        return openAssetFileDescriptor(contentResolver.openAssetFileDescriptor(uri, "r"), z16, options);
    }

    private static native void postUnbindSurface(long j3);

    private static native int prepareData(long j3);

    private static native long renderFrame(long j3, Bitmap bitmap);

    private static native long renderFrameForGifPlay(long j3, Bitmap bitmap, boolean z16);

    private static native boolean reset(long j3);

    private static native long restoreRemainder(long j3);

    private static native int restoreSavedState(long j3, long[] jArr, Bitmap bitmap);

    private static native void saveRemainder(long j3);

    private static native void seekToFrame(long j3, int i3, Bitmap bitmap);

    private static native long seekToFrameGetTime(long j3, int i3, Bitmap bitmap);

    private static native void seekToTime(long j3, int i3, Bitmap bitmap);

    private static native void setLoopCount(long j3, int i3);

    private static native void setSpeedFactor(long j3, float f16);

    static native long updateFile(long j3, String str, boolean z16);

    void bindSurface(Surface surface, long[] jArr, boolean z16) {
        bindSurface(this.gifInfoPtr, surface, jArr, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void changeFile(String str) {
        changeFile(this.gifInfoPtr, str, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long doRender(Bitmap bitmap) {
        return doRender(this.gifInfoPtr, bitmap);
    }

    protected void finalize() throws Throwable {
        try {
            recycle();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getAllocationByteCount() {
        return getAllocationByteCount(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getComment() {
        return getComment(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getCurrentFrameIndex() {
        return getCurrentFrameIndex(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getCurrentLoop() {
        return getCurrentLoop(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getCurrentPosition() {
        return getCurrentPosition(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getDuration() {
        return getDuration(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getFrameDuration(int i3) {
        if (i3 >= 0) {
            if (i3 < this.frameCount) {
            }
        }
        throw new IndexOutOfBoundsException("Frame index is out of bounds");
        return getFrameDuration(this.gifInfoPtr, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getImageCount() {
        int imageCount;
        imageCount = getImageCount(this.gifInfoPtr);
        this.frameCount = imageCount;
        return imageCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getLoopCount() {
        return getLoopCount(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int getNativeErrorCode() {
        return getNativeErrorCode(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPreferConfig() {
        return getPreferConfig(this.gifInfoPtr);
    }

    synchronized long[] getSavedState() {
        return getSavedState(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getSourceLength() {
        return getSourceLength(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isAnimationCompleted() {
        return isAnimationCompleted(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean isRecycled() {
        boolean z16;
        if (this.gifInfoPtr == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    synchronized void postUnbindSurface() {
        postUnbindSurface(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void prepareData() {
        prepareData(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void recycle() {
        free(this.gifInfoPtr);
        this.gifInfoPtr = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long renderFrame(Bitmap bitmap) {
        return renderFrame(this.gifInfoPtr, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long renderFrameForGifPlay(Bitmap bitmap, boolean z16) {
        return renderFrameForGifPlay(this.gifInfoPtr, bitmap, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean reset() {
        return reset(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long restoreRemainder() {
        return restoreRemainder(this.gifInfoPtr);
    }

    synchronized int restoreSavedState(long[] jArr, Bitmap bitmap) {
        return restoreSavedState(this.gifInfoPtr, jArr, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void saveRemainder() {
        saveRemainder(this.gifInfoPtr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void seekToFrame(int i3, Bitmap bitmap) {
        seekToFrame(this.gifInfoPtr, i3, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long seekToFrameGetTime(int i3, Bitmap bitmap) {
        return seekToFrameGetTime(this.gifInfoPtr, i3, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void seekToTime(int i3, Bitmap bitmap) {
        seekToTime(this.gifInfoPtr, i3, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLoopCount(int i3) {
        if (i3 >= 0 && i3 <= 65535) {
            synchronized (this) {
                setLoopCount(this.gifInfoPtr, i3);
            }
            return;
        }
        throw new IllegalArgumentException("Loop count of range <0, 65535>");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSpeedFactor(float f16) {
        if (f16 > 0.0f && !Float.isNaN(f16)) {
            if (f16 < 0.0f) {
                f16 = 0.0f;
            }
            synchronized (this) {
                setSpeedFactor(this.gifInfoPtr, f16);
            }
            return;
        }
        throw new IllegalArgumentException("Speed factor is not positive");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updateFile(String str) {
        updateFile(this.gifInfoPtr, str, false);
    }
}
