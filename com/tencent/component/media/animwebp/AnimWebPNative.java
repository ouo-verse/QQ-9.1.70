package com.tencent.component.media.animwebp;

import com.tencent.component.media.utils.ImageManagerLog;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class AnimWebPNative {
    private static final String TAG = "AnimWebPNative";
    private ByteBuffer currentFrameByteBuffer;
    private byte[] fileContentBytes;

    public AnimWebPNative(byte[] bArr) {
        this.fileContentBytes = bArr;
    }

    public static boolean isAnimWebP(byte[] bArr) {
        try {
            return nativeIsAnimWebP(bArr);
        } catch (Throwable th5) {
            ImageManagerLog.e(TAG, th5.getMessage());
            return false;
        }
    }

    private native AnimWebPInfo nativeInit(byte[] bArr);

    private static native boolean nativeIsAnimWebP(byte[] bArr);

    private native AnimWebPInfo nativeNextFrame(ByteBuffer byteBuffer);

    private native void nativeRelease();

    public ByteBuffer getCurrentFrameByteBuffer() {
        return this.currentFrameByteBuffer;
    }

    public AnimWebPInfo initialize() {
        try {
            AnimWebPInfo nativeInit = nativeInit(this.fileContentBytes);
            this.currentFrameByteBuffer = ByteBuffer.allocateDirect(nativeInit.getCanvasWidth() * nativeInit.getCanvasHeight() * 4);
            return nativeInit;
        } catch (Throwable th5) {
            ImageManagerLog.e(TAG, th5.getMessage());
            return null;
        }
    }

    public AnimWebPInfo nextFrame() {
        try {
            return nativeNextFrame(this.currentFrameByteBuffer);
        } catch (Throwable th5) {
            ImageManagerLog.e(TAG, th5.getMessage());
            return null;
        }
    }

    public void release() {
        try {
            nativeRelease();
        } catch (Throwable th5) {
            ImageManagerLog.e(TAG, th5.getMessage());
        }
    }
}
