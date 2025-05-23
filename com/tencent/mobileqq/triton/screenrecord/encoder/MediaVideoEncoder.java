package com.tencent.mobileqq.triton.screenrecord.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class MediaVideoEncoder extends MediaEncoder {
    private static final float BPP = 0.15f;
    private static final boolean DEBUG = true;
    private static final int FRAME_RATE = 30;
    private static final int IFRAME_INTERVAL = 5;
    private static final String MIME_TYPE = "video/avc";
    private static final String TAG = "MediaVideoEncoder";
    private static int[] recognizedFormats = {2130708361};
    private final int mHeight;
    private Surface mSurface;
    private final int mWidth;

    public MediaVideoEncoder(MediaMuxerController mediaMuxerController, int i3, int i16) {
        super(mediaMuxerController);
        this.mWidth = i3;
        this.mHeight = i16;
    }

    private int calcBitRate() {
        int i3 = (int) (this.mWidth * 4.5f * this.mHeight);
        Logger.i(TAG, String.format("bitrate=%5.2f[Mbps]", Float.valueOf((i3 / 1024.0f) / 1024.0f)));
        return i3;
    }

    private static boolean isRecognizedColorFormat(int i3) {
        int i16;
        Logger.i(TAG, "isRecognizedColorFormat:colorFormat=" + i3);
        int[] iArr = recognizedFormats;
        if (iArr != null) {
            i16 = iArr.length;
        } else {
            i16 = 0;
        }
        for (int i17 = 0; i17 < i16; i17++) {
            if (recognizedFormats[i17] == i3) {
                return true;
            }
        }
        return false;
    }

    protected static int selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        Logger.i(TAG, "selectColorFormat: ");
        int i3 = 0;
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            int i16 = 0;
            while (true) {
                int[] iArr = capabilitiesForType.colorFormats;
                if (i16 >= iArr.length) {
                    break;
                }
                int i17 = iArr[i16];
                if (isRecognizedColorFormat(i17)) {
                    i3 = i17;
                    break;
                }
                i16++;
            }
            if (i3 == 0) {
                Logger.e(TAG, "couldn't find a good color format for " + mediaCodecInfo.getName() + " / " + str);
            }
            return i3;
        } catch (Exception e16) {
            Logger.e(TAG, "failed to getCapabilitiesForType for " + mediaCodecInfo.getName() + " / " + str, e16);
            return 0;
        }
    }

    protected static final MediaCodecInfo selectVideoCodec(String str) {
        Logger.d(TAG, "selectVideoCodec:");
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (int i16 = 0; i16 < supportedTypes.length; i16++) {
                    if (supportedTypes[i16].equalsIgnoreCase(str)) {
                        Logger.i(TAG, "codec:" + codecInfoAt.getName() + ",MIME=" + supportedTypes[i16]);
                        if (selectColorFormat(codecInfoAt, str) > 0) {
                            return codecInfoAt;
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.triton.screenrecord.encoder.MediaEncoder
    protected MediaCodec createMediaCodec() throws IOException {
        MediaCodecInfo selectVideoCodec = selectVideoCodec("video/avc");
        if (selectVideoCodec != null) {
            Logger.i(TAG, "selected codec: " + selectVideoCodec.getName());
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.mWidth, this.mHeight);
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", calcBitRate());
            createVideoFormat.setInteger("frame-rate", 30);
            createVideoFormat.setInteger("i-frame-interval", 5);
            Logger.i(TAG, "format: " + createVideoFormat);
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
            createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            return createEncoderByType;
        }
        Logger.e(TAG, "Unable to find an appropriate codec for video/avc");
        throw new IOException("no codec for video/avc");
    }

    public Surface getInputSurface() {
        return this.mSurface;
    }

    @Override // com.tencent.mobileqq.triton.screenrecord.encoder.MediaEncoder
    protected void onMediaCodecCreated(MediaCodec mediaCodec) {
        this.mSurface = mediaCodec.createInputSurface();
        mediaCodec.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.triton.screenrecord.encoder.MediaEncoder
    public void release(boolean z16) {
        super.release(z16);
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
    }

    @Override // com.tencent.mobileqq.triton.screenrecord.encoder.MediaEncoder
    protected void signalEndOfInputStream(MediaCodec mediaCodec) {
        Logger.d(TAG, "sending EOS to encoder");
        mediaCodec.signalEndOfInputStream();
    }
}
