package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONException;

@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public final class VideoEncodeParams implements Cloneable {
    public boolean annexb;
    public long baseFrameIndex;
    public long baseGopIndex;
    public int bitrate;
    public VideoEncoderDef.BitrateMode bitrateMode;
    public CodecType codecType;
    public GLConstants.ColorRange colorRange;
    public GLConstants.ColorSpace colorSpace;
    public boolean enableAutoQP;
    public boolean enableBFrame;
    public VideoEncoderDef.EncodeScene encodeScene;
    public VideoEncoderDef.EncoderComplexity encoderComplexity;
    public VideoEncoderDef.EncoderProfile encoderProfile;
    public int fps;
    public boolean fullIFrame;
    public int gop;
    public int height;
    public boolean isTranscodingMode;
    public JSONArray mediaCodecDeviceRelatedParams;
    public VideoEncoderDef.ReferenceStrategy referenceStrategy;
    public int width;

    public VideoEncodeParams() {
        this.width = 0;
        this.height = 0;
        this.fps = 20;
        this.gop = 3;
        this.bitrate = 0;
        this.annexb = true;
        this.encoderProfile = null;
        this.bitrateMode = VideoEncoderDef.BitrateMode.CBR;
        this.baseFrameIndex = 0L;
        this.baseGopIndex = 0L;
        this.fullIFrame = false;
        this.enableBFrame = false;
        this.referenceStrategy = VideoEncoderDef.ReferenceStrategy.FIX_GOP;
        this.codecType = CodecType.H264;
        this.colorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.colorRange = GLConstants.ColorRange.UNKNOWN;
        this.isTranscodingMode = false;
        this.encoderComplexity = null;
        this.encodeScene = VideoEncoderDef.EncodeScene.kCameraRealTime;
        this.enableAutoQP = false;
        this.mediaCodecDeviceRelatedParams = null;
    }

    private int checkFieldDiffCounts(Object obj, Object obj2) {
        int i3 = 0;
        for (Field field : VideoEncodeParams.class.getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                if (!CommonUtil.equals(field.get(obj), field.get(obj2))) {
                    i3++;
                }
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            }
        }
        return i3;
    }

    public static VideoEncoderDef.EncodeScene createEncodeScene(int i3) {
        return VideoEncoderDef.EncodeScene.a(i3);
    }

    public static VideoEncoderDef.BitrateMode createEncoderBitrateMode(int i3) {
        return VideoEncoderDef.BitrateMode.a(i3);
    }

    public static VideoEncoderDef.EncoderComplexity createEncoderComplexity(int i3) {
        return VideoEncoderDef.EncoderComplexity.a(i3);
    }

    public static VideoEncoderDef.EncoderProfile createEncoderProfileType(int i3) {
        return VideoEncoderDef.EncoderProfile.a(i3);
    }

    public static CodecType createEncoderVideoCodec(int i3) {
        return CodecType.a(i3);
    }

    public static VideoEncoderDef.ReferenceStrategy createReferenceStrategy(int i3) {
        return VideoEncoderDef.ReferenceStrategy.a(i3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof VideoEncodeParams) || checkFieldDiffCounts(this, obj) != 0) {
            return false;
        }
        return true;
    }

    public final long getBaseFrameIndex() {
        return this.baseFrameIndex;
    }

    public final long getBaseGopIndex() {
        return this.baseGopIndex;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getBitrateMode() {
        return this.bitrateMode.mValue;
    }

    public final int getCodecType() {
        return this.codecType.mValue;
    }

    public final int getEncodeScene() {
        VideoEncoderDef.EncodeScene encodeScene = this.encodeScene;
        if (encodeScene == null) {
            return VideoEncoderDef.EncodeScene.kCameraRealTime.mValue;
        }
        return encodeScene.mValue;
    }

    public final int getEncoderComplexity() {
        VideoEncoderDef.EncoderComplexity encoderComplexity = this.encoderComplexity;
        if (encoderComplexity == null) {
            return VideoEncoderDef.EncoderComplexity.VERY_FAST.mValue;
        }
        return encoderComplexity.mValue;
    }

    public final int getEncoderProfile() {
        return this.encoderProfile.mValue;
    }

    public final int getFps() {
        return this.fps;
    }

    public final int getGop() {
        return this.gop;
    }

    public final int getHeight() {
        return this.height;
    }

    public final VideoEncoderDef.ReferenceStrategy getReferenceStrategy() {
        return this.referenceStrategy;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isAnnexb() {
        return this.annexb;
    }

    public final boolean isEnableAutoQP() {
        return this.enableAutoQP;
    }

    public final boolean isEnablesBframe() {
        return this.enableBFrame;
    }

    public final boolean isEnablesRps() {
        if (this.referenceStrategy == VideoEncoderDef.ReferenceStrategy.RPS) {
            return true;
        }
        return false;
    }

    public final boolean isEnablesSvc() {
        if (this.referenceStrategy == VideoEncoderDef.ReferenceStrategy.SVC) {
            return true;
        }
        return false;
    }

    public final boolean isEnablesUnlimitedGop() {
        if (this.referenceStrategy == VideoEncoderDef.ReferenceStrategy.UNLIMITED_GOP) {
            return true;
        }
        return false;
    }

    public final boolean isFullIFrame() {
        return this.fullIFrame;
    }

    public final boolean isTranscodingMode() {
        return this.isTranscodingMode;
    }

    public final void setAnnexb(boolean z16) {
        this.annexb = z16;
    }

    public final void setAutoQPEnabeled(boolean z16) {
        this.enableAutoQP = z16;
    }

    public final void setBFrameEnabled(boolean z16) {
        this.enableBFrame = z16;
    }

    public final void setBaseFrameIndex(long j3) {
        this.baseFrameIndex = j3;
    }

    public final void setBaseGopIndex(long j3) {
        this.baseGopIndex = j3;
    }

    public final void setBitrate(int i3) {
        this.bitrate = i3;
    }

    public final void setBitrateMode(VideoEncoderDef.BitrateMode bitrateMode) {
        this.bitrateMode = bitrateMode;
    }

    public final void setCodecType(CodecType codecType) {
        this.codecType = codecType;
    }

    public final void setColorRangeInt(int i3) {
        this.colorRange = GLConstants.ColorRange.a(i3);
    }

    public final void setColorSpaceInt(int i3) {
        this.colorSpace = GLConstants.ColorSpace.a(i3);
    }

    public final void setEncodeScene(VideoEncoderDef.EncodeScene encodeScene) {
        this.encodeScene = encodeScene;
    }

    public final void setEncoderComplexity(VideoEncoderDef.EncoderComplexity encoderComplexity) {
        this.encoderComplexity = encoderComplexity;
    }

    public final void setEncoderProfile(VideoEncoderDef.EncoderProfile encoderProfile) {
        this.encoderProfile = encoderProfile;
    }

    public final void setFps(int i3) {
        this.fps = i3;
    }

    public final void setFullIFrame(boolean z16) {
        this.fullIFrame = z16;
    }

    public final void setGop(int i3) {
        this.gop = i3;
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setReferenceStrategy(VideoEncoderDef.ReferenceStrategy referenceStrategy) {
        this.referenceStrategy = referenceStrategy;
    }

    public final void setTranscodingModeEnabled(boolean z16) {
        this.isTranscodingMode = z16;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    public final String toString() {
        return "width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", gop=" + this.gop + ", bitrate=" + this.bitrate + ", annexb=" + this.annexb + ", encoderProfile=" + this.encoderProfile + ", bitrateMode=" + this.bitrateMode + ", baseFrameIndex=" + this.baseFrameIndex + ", baseGopIndex=" + this.baseGopIndex + ", fullIFrame=" + this.fullIFrame + ", enableBFrame=" + this.enableBFrame + ", referenceStrategy=" + this.referenceStrategy + ", codecType=" + this.codecType + ", isTransCodingMode=" + this.isTranscodingMode + ", mediaCodecDeviceRelatedParams=" + this.mediaCodecDeviceRelatedParams + ", encoderComplexity=" + this.encoderComplexity + ", encodeScene=" + this.encodeScene + ", enableAutoQP=" + this.enableAutoQP + ", colorSpace=" + this.colorSpace + ", colorRange=" + this.colorRange;
    }

    public VideoEncodeParams(VideoEncodeParams videoEncodeParams) {
        this.width = 0;
        this.height = 0;
        this.fps = 20;
        this.gop = 3;
        this.bitrate = 0;
        this.annexb = true;
        this.encoderProfile = null;
        this.bitrateMode = VideoEncoderDef.BitrateMode.CBR;
        this.baseFrameIndex = 0L;
        this.baseGopIndex = 0L;
        this.fullIFrame = false;
        this.enableBFrame = false;
        this.referenceStrategy = VideoEncoderDef.ReferenceStrategy.FIX_GOP;
        this.codecType = CodecType.H264;
        this.colorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.colorRange = GLConstants.ColorRange.UNKNOWN;
        this.isTranscodingMode = false;
        this.encoderComplexity = null;
        this.encodeScene = VideoEncoderDef.EncodeScene.kCameraRealTime;
        this.enableAutoQP = false;
        this.mediaCodecDeviceRelatedParams = null;
        if (videoEncodeParams == null) {
            return;
        }
        this.width = videoEncodeParams.width;
        this.height = videoEncodeParams.height;
        this.fps = videoEncodeParams.fps;
        this.gop = videoEncodeParams.gop;
        this.bitrate = videoEncodeParams.bitrate;
        this.annexb = videoEncodeParams.annexb;
        this.encoderProfile = videoEncodeParams.encoderProfile;
        this.bitrateMode = videoEncodeParams.bitrateMode;
        this.baseFrameIndex = videoEncodeParams.baseFrameIndex;
        this.baseGopIndex = videoEncodeParams.baseGopIndex;
        this.fullIFrame = videoEncodeParams.fullIFrame;
        this.enableBFrame = videoEncodeParams.enableBFrame;
        this.codecType = videoEncodeParams.codecType;
        this.referenceStrategy = videoEncodeParams.referenceStrategy;
        this.isTranscodingMode = videoEncodeParams.isTranscodingMode;
        this.encoderComplexity = videoEncodeParams.encoderComplexity;
        this.encodeScene = videoEncodeParams.encodeScene;
        this.enableAutoQP = videoEncodeParams.enableAutoQP;
        this.colorSpace = videoEncodeParams.colorSpace;
        this.colorRange = videoEncodeParams.colorRange;
        JSONArray jSONArray = videoEncodeParams.mediaCodecDeviceRelatedParams;
        if (jSONArray != null) {
            try {
                this.mediaCodecDeviceRelatedParams = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
        }
    }
}
