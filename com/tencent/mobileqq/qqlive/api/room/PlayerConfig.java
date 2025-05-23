package com.tencent.mobileqq.qqlive.api.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.room.AudienceRoomConfig;
import java.util.Map;

/* loaded from: classes17.dex */
public class PlayerConfig {
    static IPatchRedirector $redirector_ = null;
    private static final long DEFAULT_BUFFERING_TIMEOUT_MS = 15000;
    private static final long DEFAULT_BUFFER_PACKET_MAX_DURATION = 60000;
    private static final long DEFAULT_MAX_BUFFERING_TIME_MS = 10000;
    private static final long DEFAULT_MIN_BUFFERING_TIME_MS = 1000;
    private static final long DEFAULT_MIN_BUFFER_DURATION = 2000;
    public long bufferingPacketDurationMin;
    public long bufferingTimeOut;
    public boolean enableOpenPlayerAllLog;
    public boolean enableQUIC;
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
    public int playerSceneID;
    public float speedUpRate;
    public int updateDownloadInfoDuration;

    public PlayerConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
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
        this.playerSceneID = 130;
        this.enableOpenPlayerAllLog = false;
        this.updateDownloadInfoDuration = 0;
        this.enableQUIC = false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "PlayerConfig{isUseTextureView=" + this.isUseTextureView + ", isZOrderMediaOverlay=" + this.isZOrderMediaOverlay + ", format=" + this.format + ", minBufferDuration=" + this.minBufferDuration + ", maxBufferDuration=" + this.maxBufferDuration + ", bufferingPacketDurationMin=" + this.bufferingPacketDurationMin + ", minBufferingTime=" + this.minBufferingTime + ", maxBufferingTime=" + this.maxBufferingTime + ", bufferingTimeOut=" + this.bufferingTimeOut + ", latencyStrategy=" + this.latencyStrategy + ", speedUpRate=" + this.speedUpRate + ", isSupportQuicFLv=" + this.isSupportQuicFLv + ", enableQuicPlaintext=" + this.enableQuicPlaintext + ", isEnableDownloadProxy=" + this.isEnableDownloadProxy + ", playerSceneID=" + this.playerSceneID + ", enableOpenPlayerAllLog=" + this.enableOpenPlayerAllLog + ", updateDownloadInfoDuration=" + this.updateDownloadInfoDuration + ", enableQUIC=" + this.enableQUIC + '}';
    }

    public PlayerConfig(PlayerConfig playerConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) playerConfig);
            return;
        }
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
        this.playerSceneID = 130;
        this.enableOpenPlayerAllLog = false;
        this.updateDownloadInfoDuration = 0;
        this.enableQUIC = false;
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
        this.playerSceneID = playerConfig.playerSceneID;
        this.enableOpenPlayerAllLog = playerConfig.enableOpenPlayerAllLog;
        this.updateDownloadInfoDuration = playerConfig.updateDownloadInfoDuration;
        this.enableQUIC = playerConfig.enableQUIC;
    }
}
