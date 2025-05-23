package com.tencent.karaoke.audiobasesdk;

import com.tencent.component.utils.LogUtil;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SimpleKaraResampler implements IKaraResampler {
    private static final short DEPTH_PER_SAMPLE = 2;
    private static final String TAG = "SimpleKaraResampler";
    private static boolean mIsLoaded = AudiobaseContext.loadLibrary();
    private boolean mIsValid = false;
    private long nativeHandle;

    private native int native_init(int i3, int i16, int i17, int i18);

    private native int native_maxOutSize();

    private native void native_release();

    private native int native_resample(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2);

    @Override // com.tencent.karaoke.audiobasesdk.IKaraResampler
    public synchronized int init(int i3, int i16, int i17, int i18) {
        boolean z16;
        if (mIsLoaded) {
            int native_init = native_init(i3, i16, i17, i18 * 2);
            if (native_init == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsValid = z16;
            return native_init;
        }
        LogUtil.w(TAG, "SimpleKara Resampler Invalid because load library failed");
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.IKaraResampler
    public synchronized int maxOutFrameCount() {
        if (this.mIsValid) {
            return native_maxOutSize() / 2;
        }
        return -1;
    }

    @Override // com.tencent.karaoke.audiobasesdk.IKaraResampler
    public synchronized void release() {
        if (this.mIsValid) {
            native_release();
            this.mIsValid = false;
        }
    }

    @Override // com.tencent.karaoke.audiobasesdk.IKaraResampler
    public synchronized int resample(ByteBuffer byteBuffer, int i3, ByteBuffer byteBuffer2) {
        if (this.mIsValid) {
            return native_resample(byteBuffer, i3 * 2, byteBuffer2) / 2;
        }
        return -1;
    }
}
