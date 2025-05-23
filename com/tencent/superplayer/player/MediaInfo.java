package com.tencent.superplayer.player;

import android.text.TextUtils;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.common.TPPropertyID;
import com.tencent.thumbplayer.api.player.ITPPlayer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MediaInfo {
    private static final String FILENAME = "MediaInfo.java";
    private long audioBitRate;
    private String audioCodec;
    private String audioProfile;
    private int channels;
    private String codecMimeType;
    private String containerFormat;
    private long durationMs;
    private boolean hasInit;
    private String mediaInfoStr;
    private String originalAudioTrackName;
    private long sampleRate;
    private String tag;
    private long videoBitRate;
    private String videoCodec;
    private int videoFps;
    private int videoHeight;
    private String videoProfile;
    private int videoRotation;
    private int videoWidth;

    public MediaInfo(String str) {
        this.tag = str + "_" + FILENAME;
    }

    public static MediaInfo obtainMediaInfoFromPlayer(String str, ITPPlayer iTPPlayer) {
        MediaInfo mediaInfo = new MediaInfo(str);
        try {
            mediaInfo.containerFormat = iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_STRING_CONTAINER_FORMAT);
            String property = iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_VIDEO_CODEC_TYPE);
            if (TextUtils.isEmpty(property)) {
                property = "-1";
            }
            mediaInfo.videoCodec = a.a(Integer.parseInt(property));
            mediaInfo.videoProfile = iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_VIDEO_CODEC_PROFILE);
            mediaInfo.videoWidth = iTPPlayer.getWidth();
            mediaInfo.videoHeight = iTPPlayer.getHeight();
            if (!TextUtils.isEmpty(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_VIDEO_BITRATE))) {
                mediaInfo.videoBitRate = Long.parseLong(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_VIDEO_BITRATE));
            }
            mediaInfo.audioCodec = iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_AUDIO_CODEC_TYPE);
            mediaInfo.audioProfile = iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_AUDIO_CODEC_PROFILE);
            if (!TextUtils.isEmpty(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_AUDIO_BITRATE))) {
                mediaInfo.audioBitRate = Long.parseLong(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_AUDIO_BITRATE));
            }
            if (!TextUtils.isEmpty(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_AUDIO_CHANNEL_COUNT))) {
                mediaInfo.channels = Integer.parseInt(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_AUDIO_CHANNEL_COUNT));
            }
            if (!TextUtils.isEmpty(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_AUDIO_SAMPLE_RATE))) {
                mediaInfo.sampleRate = Long.parseLong(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_AUDIO_SAMPLE_RATE));
            }
            if (!TextUtils.isEmpty(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_VIDEO_ROTATION))) {
                mediaInfo.setVideoRotation(Integer.parseInt(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_LONG_VIDEO_ROTATION)));
            }
            if (!TextUtils.isEmpty(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_FLOAT_VIDEO_FRAMERATE))) {
                mediaInfo.setVideoFps(Integer.parseInt(iTPPlayer.getProperty(TPPropertyID.TP_PROPERTY_ID_FLOAT_VIDEO_FRAMERATE)));
            }
        } catch (Exception e16) {
            LogUtil.e(LogUtil.TAG, e16);
        }
        mediaInfo.setHasInit(true);
        return mediaInfo;
    }

    public long getAudioBitRate() {
        return this.audioBitRate;
    }

    public String getAudioCodec() {
        return this.audioCodec;
    }

    public String getAudioProfile() {
        return this.audioProfile;
    }

    public int getChannels() {
        return this.channels;
    }

    public String getCodecMimeType() {
        return this.codecMimeType;
    }

    public String getContainerFormat() {
        return this.containerFormat;
    }

    public long getDurationMs() {
        return this.durationMs;
    }

    public String getMediaInfoStr() {
        return this.mediaInfoStr;
    }

    public long getSampleRate() {
        return this.sampleRate;
    }

    public long getVideoBitRate() {
        return this.videoBitRate;
    }

    public String getVideoCodec() {
        return this.videoCodec;
    }

    public int getVideoFps() {
        return this.videoFps;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public String getVideoProfile() {
        return this.videoProfile;
    }

    public int getVideoRotation() {
        return this.videoRotation;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public boolean isInit() {
        return this.hasInit;
    }

    public void setAudioBitRate(long j3) {
        if (j3 <= 0) {
            return;
        }
        this.audioBitRate = j3;
    }

    public void setAudioCodec(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.audioCodec = str;
    }

    public void setAudioProfile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.audioProfile = str;
    }

    public void setChannels(int i3) {
        if (i3 <= 0) {
            return;
        }
        this.channels = i3;
    }

    public void setCodecMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.codecMimeType = str;
    }

    public void setContainerFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.containerFormat = str;
    }

    public void setDurationMs(long j3) {
        if (j3 <= 0) {
            return;
        }
        this.durationMs = j3;
    }

    public void setHasInit(boolean z16) {
        this.hasInit = z16;
    }

    public void setMediaInfoStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mediaInfoStr = str;
    }

    public void setSampleRate(long j3) {
        if (j3 <= 0) {
            return;
        }
        this.sampleRate = j3;
    }

    public void setVideoBitRate(long j3) {
        if (j3 <= 0) {
            return;
        }
        this.videoBitRate = j3;
    }

    public void setVideoCodec(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.videoCodec = str;
    }

    public void setVideoFps(int i3) {
        this.videoFps = i3;
    }

    public void setVideoHeight(int i3) {
        if (i3 <= 0) {
            return;
        }
        this.videoHeight = i3;
    }

    public void setVideoProfile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.videoProfile = str;
    }

    public void setVideoRotation(int i3) {
        this.videoRotation = i3;
    }

    public void setVideoWidth(int i3) {
        if (i3 <= 0) {
            return;
        }
        this.videoWidth = i3;
    }

    public String toString() {
        return "MediaInfo{tag='" + this.tag + "', containerFormat='" + this.containerFormat + "', videoCodec='" + this.videoCodec + "', videoProfile='" + this.videoProfile + "', codecMimeType='" + this.codecMimeType + "', videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoBitRate=" + this.videoBitRate + ", videoFps=" + this.videoFps + ", audioCodec='" + this.audioCodec + "', audioProfile='" + this.audioProfile + "', audioBitRate=" + this.audioBitRate + ", channels=" + this.channels + ", sampleRate=" + this.sampleRate + ", durationMs=" + this.durationMs + ", videoRotation=" + this.videoRotation + ", mediaInfoStr='" + this.mediaInfoStr + "', originalAudioTrackName='" + this.originalAudioTrackName + "'}";
    }
}
