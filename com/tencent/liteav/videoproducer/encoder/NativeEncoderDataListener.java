package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import java.nio.ByteBuffer;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class NativeEncoderDataListener extends VideoEncoderDef.b {
    public static final String TAG = "NativeEncoderDataListener";
    private long mNativeVideoEncodeDataListener;
    private int mStreamType;

    public NativeEncoderDataListener(long j3, int i3) {
        this.mNativeVideoEncodeDataListener = j3;
        this.mStreamType = i3;
    }

    private native void nativeOnEncodedFail(long j3, int i3, int i16);

    private native void nativeOnEncodedNAL(long j3, int i3, EncodedVideoFrame encodedVideoFrame, ByteBuffer byteBuffer, ProducerChainTimestamp producerChainTimestamp, int i16, int i17, int i18, int i19, long j16, long j17, long j18, long j19, long j26, long j27, int i26, int i27, boolean z16, int i28);

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.b
    public synchronized void onEncodedFail(e.a aVar) {
        long j3 = this.mNativeVideoEncodeDataListener;
        if (j3 != 0) {
            nativeOnEncodedFail(j3, this.mStreamType, com.tencent.liteav.videobase.videobase.e.a(aVar));
        } else {
            LiteavLog.i(TAG, "onEncodedFail nativeclient is zero.");
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.b
    public synchronized void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z16) {
        boolean z17;
        int i3;
        int intValue;
        long j3 = this.mNativeVideoEncodeDataListener;
        if (j3 != 0 && !z16) {
            int i16 = this.mStreamType;
            ByteBuffer byteBuffer = encodedVideoFrame.data;
            ProducerChainTimestamp producerChainTimestamp = encodedVideoFrame.producerChainTimestamp;
            int i17 = encodedVideoFrame.nalType.mValue;
            int i18 = encodedVideoFrame.profileType.mValue;
            int i19 = encodedVideoFrame.codecType.mValue;
            int i26 = encodedVideoFrame.rotation;
            long j16 = encodedVideoFrame.dts;
            long j17 = encodedVideoFrame.pts;
            long j18 = encodedVideoFrame.gopIndex;
            long j19 = encodedVideoFrame.gopFrameIndex;
            long j26 = encodedVideoFrame.frameIndex;
            long j27 = encodedVideoFrame.refFrameIndex;
            int i27 = encodedVideoFrame.width;
            int i28 = encodedVideoFrame.height;
            Integer num = encodedVideoFrame.svcInfo;
            if (num != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (num == null) {
                i3 = i27;
                intValue = 0;
            } else {
                i3 = i27;
                intValue = num.intValue();
            }
            nativeOnEncodedNAL(j3, i16, encodedVideoFrame, byteBuffer, producerChainTimestamp, i17, i18, i19, i26, j16, j17, j18, j19, j26, j27, i3, i28, z17, intValue);
            return;
        }
        LiteavLog.d(TAG, "onEncodedNAL mNativeVideoEncodeDataListener=%d,isEos=%b", Long.valueOf(j3), Boolean.valueOf(z16));
    }

    public synchronized void reset() {
        this.mNativeVideoEncodeDataListener = 0L;
    }
}
