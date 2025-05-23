package com.tencent.mobileqq.icgame.api.room;

import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import java.util.Map;

/* loaded from: classes15.dex */
public class PlayerConfig {
    private static final long DEFAULT_BUFFERING_TIMEOUT_MS = 15000;
    private static final long DEFAULT_BUFFER_PACKET_MAX_DURATION = 60000;
    private static final long DEFAULT_MAX_BUFFERING_TIME_MS = 10000;
    private static final long DEFAULT_MIN_BUFFERING_TIME_MS = 1000;
    private static final long DEFAULT_MIN_BUFFER_DURATION = 2000;
    public long bufferingPacketDurationMin;
    public long bufferingTimeOut;
    public boolean enableOpenPlayerAllLog;
    public boolean enableQuicPlaintext;
    public AudienceRoomConfig.VideoFormat format;
    public Map<String, String> httpHeader;
    public boolean isEnableDownloadProxy;
    public boolean isSupportQuicFLv;
    public boolean isUseTextureView;
    public boolean isZOrderMediaOverlay;
    public AudienceRoomConfig.LiveLatencyStrategy latencyStrategy;
    public long maxBufferDuration;
    public long maxBufferingTime;
    public long minBufferDuration;
    public long minBufferingTime;
    public float speedUpRate;
    public int updateDownloadInfoDuration;

    public PlayerConfig() {
        this.isUseTextureView = false;
        this.isZOrderMediaOverlay = false;
        this.format = AudienceRoomConfig.VideoFormat.RTMP;
        this.minBufferDuration = 2000L;
        this.maxBufferDuration = 60000L;
        this.bufferingPacketDurationMin = 0L;
        this.minBufferingTime = 1000L;
        this.maxBufferingTime = 10000L;
        this.bufferingTimeOut = 15000L;
        this.latencyStrategy = AudienceRoomConfig.LiveLatencyStrategy.NONE;
        this.speedUpRate = 1.0f;
        this.isEnableDownloadProxy = false;
        this.isSupportQuicFLv = false;
        this.enableQuicPlaintext = false;
        this.enableOpenPlayerAllLog = false;
        this.updateDownloadInfoDuration = 0;
    }

    public String toString() {
        return "PlayerConfig{isUseTextureView=" + this.isUseTextureView + ", isZOrderMediaOverlay=" + this.isZOrderMediaOverlay + ", format=" + this.format + ", minBufferDuration=" + this.minBufferDuration + ", maxBufferDuration=" + this.maxBufferDuration + ", bufferingPacketDurationMin=" + this.bufferingPacketDurationMin + ", minBufferingTime=" + this.minBufferingTime + ", maxBufferingTime=" + this.maxBufferingTime + ", bufferingTimeOut=" + this.bufferingTimeOut + ", latencyStrategy=" + this.latencyStrategy + ", speedUpRate=" + this.speedUpRate + ", isSupportQuicFLv=" + this.isSupportQuicFLv + ", enableQuicPlaintext=" + this.enableQuicPlaintext + ", isEnableDownloadProxy=" + this.isEnableDownloadProxy + ", enableOpenPlayerAllLog=" + this.enableOpenPlayerAllLog + ", updateDownloadInfoDuration=" + this.updateDownloadInfoDuration + '}';
    }

    public PlayerConfig(PlayerConfig playerConfig) {
        this.isUseTextureView = false;
        this.isZOrderMediaOverlay = false;
        this.format = AudienceRoomConfig.VideoFormat.RTMP;
        this.minBufferDuration = 2000L;
        this.maxBufferDuration = 60000L;
        this.bufferingPacketDurationMin = 0L;
        this.minBufferingTime = 1000L;
        this.maxBufferingTime = 10000L;
        this.bufferingTimeOut = 15000L;
        this.latencyStrategy = AudienceRoomConfig.LiveLatencyStrategy.NONE;
        this.speedUpRate = 1.0f;
        this.isEnableDownloadProxy = false;
        this.isSupportQuicFLv = false;
        this.enableQuicPlaintext = false;
        this.enableOpenPlayerAllLog = false;
        this.updateDownloadInfoDuration = 0;
        this.isUseTextureView = playerConfig.isUseTextureView;
        this.isZOrderMediaOverlay = playerConfig.isZOrderMediaOverlay;
        this.format = playerConfig.format;
        this.minBufferDuration = playerConfig.minBufferDuration;
        this.maxBufferDuration = playerConfig.maxBufferDuration;
        this.bufferingPacketDurationMin = playerConfig.bufferingPacketDurationMin;
        this.minBufferingTime = playerConfig.minBufferingTime;
        this.maxBufferingTime = playerConfig.maxBufferingTime;
        this.bufferingTimeOut = playerConfig.bufferingTimeOut;
        this.latencyStrategy = playerConfig.latencyStrategy;
        this.speedUpRate = playerConfig.speedUpRate;
        this.isSupportQuicFLv = playerConfig.isSupportQuicFLv;
        this.enableQuicPlaintext = playerConfig.enableQuicPlaintext;
        this.isEnableDownloadProxy = playerConfig.isEnableDownloadProxy;
        this.enableOpenPlayerAllLog = playerConfig.enableOpenPlayerAllLog;
        this.updateDownloadInfoDuration = playerConfig.updateDownloadInfoDuration;
    }
}
