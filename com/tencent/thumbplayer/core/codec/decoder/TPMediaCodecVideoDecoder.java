package com.tencent.thumbplayer.core.codec.decoder;

import android.annotation.TargetApi;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.thumbplayer.core.codec.common.TPDecoderUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.TMediaCodec;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@RequiresApi(api = 16)
/* loaded from: classes26.dex */
public class TPMediaCodecVideoDecoder extends TPBaseMediaCodecDecoder {
    private static final String DEVICE_NAME_VIVO_X5L = "vivo X5L";
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int PIXEL_STRIDE_CONTINUOUS = 1;
    private static final String TAG = "TPMediaCodecVideoDecode";
    private static final int YUV420P_PLANAR_COUNT = 3;
    private int mCropBottom;
    private int mCropLeft;
    private int mCropRight;
    private int mCropTop;
    private byte[] mCsd0Data;
    private byte[] mCsd1Data;
    private byte[] mCsd2Data;
    private boolean mDisableDolbyVisionComponent;
    private int mDolbyVisionLevel;
    private int mDolbyVisionProfile;
    private boolean mEnableMediaCodecOutputData;
    private ArrayList<String> mMimeCandidates;
    private int mRotation;
    private int mVideoHeight;
    private int mVideoWidth;

    public TPMediaCodecVideoDecoder(int i3) {
        super(i3);
        this.mEnableMediaCodecOutputData = false;
        this.mMimeCandidates = new ArrayList<>();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mCropLeft = 0;
        this.mCropRight = 0;
        this.mCropTop = 0;
        this.mCropBottom = 0;
        this.mRotation = 0;
        this.mDolbyVisionProfile = 0;
        this.mDolbyVisionLevel = 0;
        this.mCsd0Data = null;
        this.mCsd1Data = null;
        this.mCsd2Data = null;
        this.mDisableDolbyVisionComponent = false;
    }

    @RequiresApi(api = 21)
    private void copyVideoDataFromImage(@NonNull Image image, @NonNull TPFrameInfo tPFrameInfo) {
        int i3;
        if (image.getFormat() != 35) {
            tPFrameInfo.format = -1;
            tPFrameInfo.errCode = 3;
            TPNativeLog.printLog(0, TAG, "copyVideoDataFromImage: image format not support!");
            return;
        }
        tPFrameInfo.format = 0;
        int width = image.getWidth();
        int height = image.getHeight();
        Image.Plane[] planes = image.getPlanes();
        int[] iArr = tPFrameInfo.lineSize;
        if (iArr == null || iArr.length < 3) {
            tPFrameInfo.lineSize = new int[3];
        }
        byte[][] bArr = tPFrameInfo.videoData;
        if (bArr == null || bArr.length < 3) {
            tPFrameInfo.videoData = new byte[3];
        }
        for (int i16 = 0; i16 < 3; i16++) {
            if (i16 == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            copyVideoDataFromPlane(planes[i16], width >> i3, height >> i3, i16, tPFrameInfo);
        }
    }

    @RequiresApi(api = 21)
    private void copyVideoDataFromPlane(@NonNull Image.Plane plane, int i3, int i16, @IntRange(from = 0) int i17, @NonNull TPFrameInfo tPFrameInfo) {
        ByteBuffer buffer = plane.getBuffer();
        tPFrameInfo.lineSize[i17] = i3;
        int i18 = i3 * i16;
        byte[][] bArr = tPFrameInfo.videoData;
        byte[] bArr2 = bArr[i17];
        if (bArr2 == null || bArr2.length < i18) {
            bArr[i17] = new byte[i18];
        }
        if (plane.getPixelStride() == 1) {
            buffer.get(tPFrameInfo.videoData[i17], 0, i18);
            return;
        }
        for (int i19 = 0; i19 < i18; i19++) {
            tPFrameInfo.videoData[i17][i19] = buffer.get(plane.getPixelStride() * i19);
        }
    }

    @TargetApi(21)
    private void processOutputData(@NonNull TMediaCodec tMediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo, @NonNull TPFrameInfo tPFrameInfo) {
        if (bufferInfo.flags == 4 && bufferInfo.size <= 0) {
            TPNativeLog.printLog(2, TAG, "processOutputBuffer: bufferInfo.flags is BUFFER_FLAG_END_OF_STREAM, return EOS!");
            tPFrameInfo.format = -1;
            tPFrameInfo.errCode = 2;
            tMediaCodec.releaseOutputBuffer(i3, false);
            return;
        }
        Image outputImage = tMediaCodec.getOutputImage(i3);
        if (outputImage == null) {
            tPFrameInfo.format = -1;
            tPFrameInfo.errCode = 3;
            tMediaCodec.releaseOutputBuffer(i3, false);
            TPNativeLog.printLog(0, TAG, "processOutputBuffer: getOutputImage return null");
            return;
        }
        copyVideoDataFromImage(outputImage, tPFrameInfo);
        tMediaCodec.releaseOutputBuffer(i3, false);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    void configCodec(@NonNull TMediaCodec tMediaCodec, @NonNull String str) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, this.mVideoWidth, this.mVideoHeight);
        createVideoFormat.setInteger("rotation-degrees", this.mRotation);
        if (TPSystemInfo.getDeviceName().equalsIgnoreCase(DEVICE_NAME_VIVO_X5L)) {
            createVideoFormat.setInteger("max-input-size", this.mVideoWidth * this.mVideoHeight);
        }
        byte[] bArr = this.mCsd0Data;
        if (bArr != null) {
            createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
        }
        byte[] bArr2 = this.mCsd1Data;
        if (bArr2 != null) {
            createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(bArr2));
        }
        byte[] bArr3 = this.mCsd2Data;
        if (bArr3 != null) {
            createVideoFormat.setByteBuffer("csd-2", ByteBuffer.wrap(bArr3));
        }
        if ("video/dolby-vision".equals(str)) {
            createVideoFormat.setInteger("profile", TPDecoderUtils.convertDolbyVisionProfileToOmxProfile(this.mDolbyVisionProfile));
            createVideoFormat.setInteger("level", TPDecoderUtils.convertDolbyVisionLevelToOmxLevel(this.mDolbyVisionLevel));
        }
        if (this.mEnableMediaCodecOutputData) {
            createVideoFormat.setInteger("color-format", HWColorFormat.COLOR_FormatYUV420Flexible);
            tMediaCodec.configure(createVideoFormat, (Surface) null, this.mMediaCrypto, 0);
        } else {
            tMediaCodec.configure(createVideoFormat, this.mSurface, this.mMediaCrypto, 0);
        }
        tMediaCodec.setVideoScalingMode(1);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    String getCodecName(@NonNull String str, boolean z16) {
        int i3 = this.mDolbyVisionProfile;
        if (i3 > 0 && !this.mDisableDolbyVisionComponent) {
            String dolbyVisionDecoderName = TPDecoderUtils.getDolbyVisionDecoderName(str, i3, this.mDolbyVisionLevel, z16);
            if (dolbyVisionDecoderName == null) {
                return TPDecoderUtils.getDecoderName(str, z16);
            }
            return dolbyVisionDecoderName;
        }
        return TPDecoderUtils.getDecoderName(str, z16);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int getMediaType() {
        return 0;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean initDecoder(String str, int i3, int i16, int i17, int i18) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    void processOutputBuffer(@NonNull TMediaCodec tMediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo, @NonNull TPFrameInfo tPFrameInfo) {
        tPFrameInfo.width = this.mVideoWidth;
        tPFrameInfo.height = this.mVideoHeight;
        tPFrameInfo.cropLeft = this.mCropLeft;
        tPFrameInfo.cropRight = this.mCropRight;
        tPFrameInfo.cropTop = this.mCropTop;
        tPFrameInfo.cropBottom = this.mCropBottom;
        tPFrameInfo.format = 167;
        if (this.mEnableMediaCodecOutputData) {
            processOutputData(tMediaCodec, i3, bufferInfo, tPFrameInfo);
        }
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    void processOutputConfigData(@NonNull TMediaCodec tMediaCodec, int i3, @NonNull MediaCodec.BufferInfo bufferInfo, @NonNull TPFrameInfo tPFrameInfo) {
        tPFrameInfo.errCode = 0;
        processOutputBuffer(tMediaCodec, i3, bufferInfo, tPFrameInfo);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    void processOutputFormatChanged(@NonNull MediaFormat mediaFormat) {
        boolean z16;
        if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mVideoWidth = mediaFormat.getInteger("width");
        this.mVideoHeight = mediaFormat.getInteger("height");
        if (z16) {
            this.mCropLeft = mediaFormat.getInteger("crop-left");
            this.mCropRight = mediaFormat.getInteger("crop-right");
            this.mCropTop = mediaFormat.getInteger("crop-top");
            this.mCropBottom = mediaFormat.getInteger("crop-bottom");
        }
        TPNativeLog.printLog(2, TAG, "processOutputFormatChanged: mVideoWidth: " + this.mVideoWidth + ", mVideoHeight: " + this.mVideoHeight + ", mCropLeft: " + this.mCropLeft + ", mCropRight: " + this.mCropRight + ", mCropTop: " + this.mCropTop + ", mCropBottom: " + this.mCropBottom);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int setOperateRate(float f16) {
        return super.setOperateRate(f16);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public int setOutputSurface(Surface surface) {
        if (this.mEnableMediaCodecOutputData) {
            return 3;
        }
        return super.setOutputSurface(surface);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamBool(int i3, boolean z16) {
        if (5 == i3) {
            if (!this.mStarted) {
                this.mEnableMediaCodecOutputData = z16;
            } else {
                TPNativeLog.printLog(1, getLogTag(), "BOOL_ENABLE_MEDIACODEC_OUTPUT_DATA failed. need set before start, mStart=" + this.mStarted + ", api level is " + Build.VERSION.SDK_INT + ", support api level = 21");
            }
        } else if (6 == i3) {
            if (!this.mStarted) {
                this.mDisableDolbyVisionComponent = z16;
            } else {
                TPNativeLog.printLog(1, getLogTag(), "BOOL_FORCE_DOLBY_VISION_USE_HEVC_CODEC failed. need set before start, mStart=" + this.mStarted);
            }
        }
        return super.setParamBool(i3, z16);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamBytes(int i3, byte[] bArr) {
        if (i3 == 200) {
            this.mCsd0Data = bArr;
        } else if (i3 == 201) {
            this.mCsd1Data = bArr;
        } else if (i3 == 202) {
            this.mCsd2Data = bArr;
        }
        return super.setParamBytes(i3, bArr);
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean setParamObject(int i3, Object obj) {
        return super.setParamObject(i3, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    public ArrayList<String> getMimeCandidates() {
        return this.mMimeCandidates;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder
    public boolean initDecoder(String str, int i3, int i16, int i17, Surface surface, int i18, int i19, int i26) {
        this.mVideoWidth = i3;
        this.mVideoHeight = i16;
        this.mRotation = i17;
        this.mSurface = surface;
        this.mDrmType = i18;
        this.mDolbyVisionProfile = i19;
        this.mDolbyVisionLevel = i26;
        buildMediaCryptoIfNeeded();
        TPNativeLog.printLog(2, TAG, "initDecoder, mimeType:" + str + " width:" + i3 + " height:" + i16 + " rotation:" + i17 + " dvProfile:" + i19 + " dvLevel:" + i26 + ", mediaCrypto:" + this.mMediaCrypto);
        this.mMimeCandidates.clear();
        if ("video/dolby-vision".equals(str)) {
            int convertDolbyVisionProfileToOmxProfile = TPDecoderUtils.convertDolbyVisionProfileToOmxProfile(this.mDolbyVisionProfile);
            boolean z16 = convertDolbyVisionProfileToOmxProfile >= 4 && convertDolbyVisionProfileToOmxProfile <= 256;
            if (this.mDisableDolbyVisionComponent && z16) {
                this.mMimeCandidates.add("video/hevc");
            } else {
                this.mMimeCandidates.add(str);
                if (z16) {
                    this.mMimeCandidates.add("video/hevc");
                }
            }
        } else {
            this.mMimeCandidates.add(str);
        }
        return true;
    }

    @Override // com.tencent.thumbplayer.core.codec.decoder.TPBaseMediaCodecDecoder
    void processMediaCodecException(Exception exc) {
    }
}
