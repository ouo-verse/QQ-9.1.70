package com.tencent.tav.core;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.CodecHelper;
import com.tencent.tav.decoder.EncoderWriter;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ExportConfig implements Cloneable {
    public static final int OUTPUT_AUDIO_SAMPLE_COUNT = 2048;
    private int audioAacProfile;
    private int audioBitRate;
    private int audioChannelCount;

    @Nullable
    private MediaFormat audioFormat;
    private int audioSampleCount;
    private int audioSampleRateHz;
    public boolean enableAVSync;
    private boolean enableAudioEncodeAsync;
    private boolean enableBFrame;
    private boolean fixOutputFrameRate;
    private boolean fixOutputSize;
    private ByteBuffer hdrStaticInfo;
    private boolean highProfile;
    private int minOutputFrameRate;
    private String outputFilePath;
    private int outputHeight;
    private int outputRotate;
    private String outputVideoMimeType;
    private int outputWidth;
    private int videoBitRate;

    @Nullable
    private MediaFormat videoFormat;
    private int videoFrameRate;
    private int videoIFrameInterval;

    public ExportConfig(int i3, int i16) {
        this.videoBitRate = 8000000;
        this.videoFrameRate = 30;
        this.videoIFrameInterval = 1;
        this.outputVideoMimeType = "video/avc";
        this.highProfile = false;
        this.enableBFrame = false;
        this.fixOutputSize = true;
        this.fixOutputFrameRate = false;
        this.outputRotate = 0;
        this.hdrStaticInfo = null;
        this.enableAVSync = false;
        this.enableAudioEncodeAsync = false;
        this.audioBitRate = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
        this.audioAacProfile = 2;
        this.audioChannelCount = 1;
        this.audioSampleRateHz = 44100;
        this.audioSampleCount = 2048;
        this.outputWidth = i3;
        this.outputHeight = i16;
    }

    private int findFormatValue(String str, int i3, MediaFormat mediaFormat) {
        if (mediaFormat != null && mediaFormat.containsKey(str)) {
            return mediaFormat.getInteger(str);
        }
        return i3;
    }

    private int findVideoFormatValue(String str, int i3) {
        return findFormatValue(str, i3, this.videoFormat);
    }

    private void initAudioChannelCount() {
        setToFormat("channel-count", this.audioChannelCount, this.audioFormat);
    }

    private void initFrameRate() {
        initFrameRate(null);
    }

    private void initHdrInfo() {
        ByteBuffer byteBuffer;
        if (Build.VERSION.SDK_INT >= 24 && (byteBuffer = this.hdrStaticInfo) != null) {
            setToVideoFormat("hdr-static-info", byteBuffer);
        }
    }

    private void initHighProfile() {
        MediaFormat mediaFormat = this.videoFormat;
        if (mediaFormat == null) {
            return;
        }
        if (this.highProfile) {
            CodecHelper.selectProfileAndLevel(mediaFormat, this.outputVideoMimeType);
        } else {
            removeProfile(mediaFormat);
        }
    }

    private void initIFrameInterval() {
        setToVideoFormat("i-frame-interval", this.videoIFrameInterval);
    }

    private void initMaxBFrame() {
        if (this.enableBFrame) {
            setToFormat("max-bframes", 1, this.videoFormat);
        }
    }

    private void initOutputSize() {
        initOutputSize(false, false, null);
    }

    private void initOutputVideoMimeType() {
        setToFormat("mime", this.outputVideoMimeType, this.videoFormat);
    }

    private void initVideoBitrate() {
        setToVideoFormat("bitrate", this.videoBitRate);
    }

    private void removeProfile(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey("profile")) {
            setToFormat("profile", 0, mediaFormat);
        }
        if (mediaFormat.containsKey("level")) {
            setToFormat("level", 0, mediaFormat);
        }
    }

    private void setOutputRotate(int i3) {
        this.outputRotate = i3;
    }

    private void setToFormat(String str, String str2, MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return;
        }
        mediaFormat.setString(str, str2);
    }

    private void setToVideoFormat(String str, int i3) {
        setToFormat(str, i3, this.videoFormat);
    }

    private CGSize strictMatchClampSize(boolean z16, MediaCodec mediaCodec, CGSize cGSize) {
        CGSize correctSupportSizeByCodecName = CodecHelper.correctSupportSizeByCodecName(cGSize, getOutputVideoMimeType(), mediaCodec);
        if (correctSupportSizeByCodecName != null) {
            return correctSupportSizeByCodecName;
        }
        return CodecHelper.correctSupportSize(cGSize, this.outputVideoMimeType, z16);
    }

    public boolean available() {
        if (getOutputWidth() > 0 && getOutputHeight() > 0) {
            return true;
        }
        return false;
    }

    public int getAudioAacProfile() {
        return this.audioAacProfile;
    }

    public int getAudioBitRate() {
        return this.audioBitRate;
    }

    public int getAudioChannelCount() {
        return findFormatValue("channel-count", this.audioChannelCount, this.audioFormat);
    }

    public boolean getAudioEncodeAsync() {
        if (this.enableAudioEncodeAsync && EncoderWriter.USE_NEW_AUDIO_ENCODE) {
            return true;
        }
        return false;
    }

    @NonNull
    public MediaFormat getAudioFormat() {
        if (this.audioFormat == null) {
            MediaFormat mediaFormat = new MediaFormat();
            this.audioFormat = mediaFormat;
            mediaFormat.setString("mime", "audio/mp4a-latm");
            this.audioFormat.setInteger("sample-rate", this.audioSampleRateHz);
            initAudioChannelCount();
            this.audioFormat.setInteger("bitrate", this.audioBitRate);
            this.audioFormat.setInteger("aac-profile", this.audioAacProfile);
        }
        return this.audioFormat;
    }

    public int getAudioSampleCount() {
        return this.audioSampleCount;
    }

    public int getAudioSampleRateHz() {
        return findFormatValue("sample-rate", this.audioSampleRateHz, this.audioFormat);
    }

    @NonNull
    public CGSize getFormatOutputSize() {
        if (this.outputRotate % 2 != 0) {
            return new CGSize(getOutputHeight(), getOutputWidth());
        }
        return new CGSize(getOutputWidth(), getOutputHeight());
    }

    public String getOutputFilePath() {
        return this.outputFilePath;
    }

    public int getOutputHeight() {
        if (this.outputRotate % 2 != 0) {
            return findVideoFormatValue("width", this.outputHeight);
        }
        return findVideoFormatValue("height", this.outputHeight);
    }

    public int getOutputRotate() {
        return this.outputRotate;
    }

    public CGSize getOutputSize() {
        return new CGSize(getOutputWidth(), getOutputHeight());
    }

    public String getOutputVideoMimeType() {
        return this.outputVideoMimeType;
    }

    public int getOutputWidth() {
        if (this.outputRotate % 2 != 0) {
            return findVideoFormatValue("height", this.outputWidth);
        }
        return findVideoFormatValue("width", this.outputWidth);
    }

    public int getVideoBitRate() {
        return findVideoFormatValue("bitrate", this.videoBitRate);
    }

    @NonNull
    public MediaFormat getVideoFormat() {
        if (this.videoFormat == null) {
            MediaFormat mediaFormat = new MediaFormat();
            this.videoFormat = mediaFormat;
            mediaFormat.setInteger("color-format", 2130708361);
            initOutputSize();
            initVideoBitrate();
            initFrameRate();
            initIFrameInterval();
            initOutputVideoMimeType();
            initHighProfile();
            initMaxBFrame();
        }
        return this.videoFormat;
    }

    public int getVideoFrameRate() {
        return findVideoFormatValue("frame-rate", this.videoFrameRate);
    }

    public int getVideoIFrameInterval() {
        return this.videoIFrameInterval;
    }

    public boolean isHighProfile() {
        return this.highProfile;
    }

    public void reset() {
        this.audioFormat = null;
        this.videoFormat = null;
    }

    public void setAudioChannelCount(int i3) {
        this.audioChannelCount = i3;
        initAudioChannelCount();
    }

    public void setAudioEncodeAsync(Boolean bool) {
        this.enableAudioEncodeAsync = bool.booleanValue();
    }

    public void setAudioSampleCount(int i3) {
        this.audioSampleCount = i3;
    }

    public void setEnableBFrame(boolean z16) {
        this.enableBFrame = z16;
        initMaxBFrame();
    }

    @Deprecated
    public void setEncodeHevc(boolean z16) {
        if (z16) {
            setOutputVideoMimeType("video/hevc");
        } else {
            setOutputVideoMimeType("video/avc");
        }
    }

    public void setFixOutputFrameRate(boolean z16, int i3) {
        this.fixOutputFrameRate = z16;
        this.minOutputFrameRate = i3;
    }

    public void setFixOutputSize(boolean z16) {
        this.fixOutputSize = z16;
    }

    @RequiresApi(24)
    public void setHdrStaticInfo(ByteBuffer byteBuffer) {
        this.hdrStaticInfo = byteBuffer;
        initHdrInfo();
    }

    public void setHighProfile(boolean z16) {
        this.highProfile = z16;
        initHighProfile();
    }

    public void setOutputFilePath(String str) {
        this.outputFilePath = str;
    }

    public void setOutputSize(int i3, int i16) {
        this.outputWidth = i3;
        this.outputHeight = i16;
        initOutputSize();
    }

    public void setOutputVideoMimeType(String str) {
        this.outputVideoMimeType = str;
        initOutputVideoMimeType();
    }

    public void setVideoBitRate(int i3) {
        this.videoBitRate = i3;
        initVideoBitrate();
    }

    public void setVideoFrameRate(int i3) {
        this.videoFrameRate = i3;
        initFrameRate();
    }

    public void setVideoIFrameInterval(int i3) {
        this.videoIFrameInterval = i3;
        initIFrameInterval();
    }

    private void setToFormat(String str, int i3, MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return;
        }
        mediaFormat.setInteger(str, i3);
    }

    private void setToVideoFormat(String str, ByteBuffer byteBuffer) {
        if (this.videoFormat == null) {
            getVideoFormat();
        }
        setToFormat(str, byteBuffer, this.videoFormat);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ExportConfig m255clone() {
        ExportConfig exportConfig = new ExportConfig(this.outputWidth, this.outputHeight);
        exportConfig.videoFormat = this.videoFormat;
        exportConfig.audioFormat = this.audioFormat;
        exportConfig.videoBitRate = this.videoBitRate;
        exportConfig.videoFrameRate = this.videoFrameRate;
        exportConfig.videoIFrameInterval = this.videoIFrameInterval;
        exportConfig.outputVideoMimeType = this.outputVideoMimeType;
        exportConfig.outputWidth = this.outputWidth;
        exportConfig.outputHeight = this.outputHeight;
        exportConfig.highProfile = this.highProfile;
        exportConfig.outputRotate = this.outputRotate;
        exportConfig.fixOutputSize = this.fixOutputSize;
        exportConfig.hdrStaticInfo = this.hdrStaticInfo;
        exportConfig.audioBitRate = this.audioBitRate;
        exportConfig.audioAacProfile = this.audioAacProfile;
        exportConfig.audioChannelCount = this.audioChannelCount;
        exportConfig.audioSampleRateHz = this.audioSampleRateHz;
        exportConfig.enableAudioEncodeAsync = this.enableAudioEncodeAsync;
        return exportConfig;
    }

    public void initFrameRate(MediaCodec mediaCodec) {
        if (this.fixOutputFrameRate && mediaCodec != null) {
            this.videoFrameRate = Math.max(this.minOutputFrameRate, (int) CodecHelper.correctSupportFps(getOutputSize(), this.videoFrameRate, getOutputVideoMimeType(), mediaCodec));
        }
        setToVideoFormat("frame-rate", this.videoFrameRate);
    }

    public void initOutputSize(boolean z16, boolean z17, MediaCodec mediaCodec) {
        CGSize formatOutputSize = getFormatOutputSize();
        if (this.fixOutputSize && z16) {
            formatOutputSize = strictMatchClampSize(z17, mediaCodec, formatOutputSize);
        }
        setToVideoFormat("width", (int) formatOutputSize.width);
        setToVideoFormat("height", (int) formatOutputSize.height);
    }

    private void setToFormat(String str, ByteBuffer byteBuffer, MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return;
        }
        mediaFormat.setByteBuffer(str, byteBuffer);
    }

    @Deprecated
    public ExportConfig(EncoderWriter.OutputConfig outputConfig) {
        this.videoBitRate = 8000000;
        this.videoFrameRate = 30;
        this.videoIFrameInterval = 1;
        this.outputVideoMimeType = "video/avc";
        this.highProfile = false;
        this.enableBFrame = false;
        this.fixOutputSize = true;
        this.fixOutputFrameRate = false;
        this.outputRotate = 0;
        this.hdrStaticInfo = null;
        this.enableAVSync = false;
        this.enableAudioEncodeAsync = false;
        this.audioBitRate = EncoderWriter.OUTPUT_AUDIO_BIT_RATE;
        this.audioAacProfile = 2;
        this.audioChannelCount = 1;
        this.audioSampleRateHz = 44100;
        this.audioSampleCount = 2048;
        this.outputWidth = outputConfig.VIDEO_TARGET_WIDTH;
        this.outputHeight = outputConfig.VIDEO_TARGET_HEIGHT;
        this.videoIFrameInterval = outputConfig.VIDEO_IFRAME_INTERVAL;
        this.videoBitRate = outputConfig.VIDEO_BIT_RATE;
        this.videoFrameRate = outputConfig.VIDEO_FRAME_RATE;
        this.highProfile = outputConfig.HIGH_PROFILE;
        this.audioChannelCount = outputConfig.AUDIO_CHANNEL_COUNT;
        this.audioBitRate = outputConfig.AUDIO_BIT_RATE;
        this.audioAacProfile = outputConfig.AUDIO_AAC_PROFILE;
    }
}
