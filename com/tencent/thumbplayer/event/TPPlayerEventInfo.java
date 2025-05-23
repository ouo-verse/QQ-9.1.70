package com.tencent.thumbplayer.event;

import android.os.SystemClock;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.common.TPDynamicStatisticParams;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;

/* loaded from: classes26.dex */
public class TPPlayerEventInfo {

    /* loaded from: classes26.dex */
    public static class BaseEventInfo {
        private long mEventTimeSinceBootMs = SystemClock.elapsedRealtime();
        private long mEventTimeSince1970Ms = System.currentTimeMillis();
        private int mEventId = -1;

        public int getEventId() {
            return this.mEventId;
        }

        public long getEventTimeSince1970Ms() {
            return this.mEventTimeSince1970Ms;
        }

        public long getEventTimeSinceBootMs() {
            return this.mEventTimeSinceBootMs;
        }

        protected void setEventId(int i3) {
            this.mEventId = i3;
        }
    }

    /* loaded from: classes26.dex */
    public static class BufferingEndEventInfo extends BaseEventInfo {
        public BufferingEndEventInfo() {
            setEventId(12);
        }
    }

    /* loaded from: classes26.dex */
    public static class BufferingStartEventInfo extends BaseEventInfo {
        public BufferingStartEventInfo() {
            setEventId(11);
        }
    }

    /* loaded from: classes26.dex */
    public static class DTCdnUrlUpdataEventInfo extends BaseEventInfo {
        private String mCdnIp;
        private String mUserIp;

        public DTCdnUrlUpdataEventInfo() {
            setEventId(1002);
        }

        public String getCdnIp() {
            return this.mCdnIp;
        }

        public String getUserIp() {
            return this.mUserIp;
        }

        public void setCdnIp(String str) {
            this.mCdnIp = str;
        }

        public void setUserIp(String str) {
            this.mUserIp = str;
        }
    }

    /* loaded from: classes26.dex */
    public static class DTDownloadProgressUpdataEventInfo extends BaseEventInfo {
        private int mDownloadSpeedbps;

        public DTDownloadProgressUpdataEventInfo() {
            setEventId(1001);
        }

        public int getDownloadSpeedKbps() {
            return this.mDownloadSpeedbps;
        }

        public void setDownloadSpeedKbps(int i3) {
            this.mDownloadSpeedbps = i3;
        }
    }

    /* loaded from: classes26.dex */
    public static class DTProtocalUpdateEventInfo extends BaseEventInfo {
        private String mProtocol;
        private String mProtocolVer;

        public DTProtocalUpdateEventInfo() {
            setEventId(1003);
        }

        public String getProtocol() {
            return this.mProtocol;
        }

        public String getProtocolVer() {
            return this.mProtocolVer;
        }

        public void setProtocol(String str) {
            this.mProtocol = str;
        }

        public void setProtocolVer(String str) {
            this.mProtocolVer = str;
        }
    }

    /* loaded from: classes26.dex */
    public static class DTReturnConvertedUrlEventInfo extends BaseEventInfo {
        public DTReturnConvertedUrlEventInfo() {
            setEventId(1004);
        }
    }

    /* loaded from: classes26.dex */
    public static class DrmEventInfo extends BaseEventInfo {
        private TPGeneralPlayFlowParams.TPPlayerDrmParams mDrmPlayFlow;

        public DrmEventInfo() {
            setEventId(16);
        }

        public TPGeneralPlayFlowParams.TPPlayerDrmParams getDrmPlayFlow() {
            return this.mDrmPlayFlow;
        }

        public void setDrmPlayFlow(TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams) {
            this.mDrmPlayFlow = tPPlayerDrmParams;
        }
    }

    /* loaded from: classes26.dex */
    public static class PlayErrorEventInfo extends BaseEventInfo {
        private TPDynamicStatisticParams mDynamicStatisticParams;
        private TPError mError;
        private TPGeneralPlayFlowParams mGeneralPlayFlowParams;

        public PlayErrorEventInfo() {
            setEventId(6);
        }

        public TPDynamicStatisticParams getDynamicStatisticParams() {
            return this.mDynamicStatisticParams;
        }

        public TPError getError() {
            return this.mError;
        }

        public TPGeneralPlayFlowParams getGeneralPlayFlowParams() {
            return this.mGeneralPlayFlowParams;
        }

        public void setDynamicStatisticParams(TPDynamicStatisticParams tPDynamicStatisticParams) {
            this.mDynamicStatisticParams = tPDynamicStatisticParams;
        }

        public void setError(TPError tPError) {
            this.mError = tPError;
        }

        public void setGeneralPlayFlowParams(TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
            this.mGeneralPlayFlowParams = tPGeneralPlayFlowParams;
        }
    }

    /* loaded from: classes26.dex */
    public static class PlayPauseEventInfo extends BaseEventInfo {
        public PlayPauseEventInfo() {
            setEventId(4);
        }
    }

    /* loaded from: classes26.dex */
    public static class PlayReleaseEventInfo extends BaseEventInfo {
        public PlayReleaseEventInfo() {
            setEventId(8);
        }
    }

    /* loaded from: classes26.dex */
    public static class PlayResetEventInfo extends BaseEventInfo {
        private TPDynamicStatisticParams mDynamicStatisticParams;
        private TPGeneralPlayFlowParams mGeneralPlayFlowParams;

        public PlayResetEventInfo() {
            setEventId(7);
        }

        public TPDynamicStatisticParams getDynamicStatisticParams() {
            return this.mDynamicStatisticParams;
        }

        public TPGeneralPlayFlowParams getGeneralPlayFlowParams() {
            return this.mGeneralPlayFlowParams;
        }

        public void setDynamicStatisticParams(TPDynamicStatisticParams tPDynamicStatisticParams) {
            this.mDynamicStatisticParams = tPDynamicStatisticParams;
        }

        public void setGeneralPlayFlowParams(TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
            this.mGeneralPlayFlowParams = tPGeneralPlayFlowParams;
        }
    }

    /* loaded from: classes26.dex */
    public static class PlayStartEventInfo extends BaseEventInfo {
        public PlayStartEventInfo() {
            setEventId(3);
        }
    }

    /* loaded from: classes26.dex */
    public static class PlayStopEventInfo extends BaseEventInfo {
        private TPDynamicStatisticParams mDynamicStatisticParams;
        private TPGeneralPlayFlowParams mGeneralPlayFlowParams;

        public PlayStopEventInfo() {
            setEventId(5);
        }

        public TPDynamicStatisticParams getDynamicStatisticParams() {
            return this.mDynamicStatisticParams;
        }

        public TPGeneralPlayFlowParams getGeneralPlayFlowParams() {
            return this.mGeneralPlayFlowParams;
        }

        public void setDynamicStatisticParams(TPDynamicStatisticParams tPDynamicStatisticParams) {
            this.mDynamicStatisticParams = tPDynamicStatisticParams;
        }

        public void setGeneralPlayFlowParams(TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
            this.mGeneralPlayFlowParams = tPGeneralPlayFlowParams;
        }
    }

    /* loaded from: classes26.dex */
    public static class PrepareEndEventInfo extends BaseEventInfo {
        private long mDurationMs;
        private int mPlayerCoreType;

        public PrepareEndEventInfo() {
            setEventId(2);
        }

        public long getDurationMs() {
            return this.mDurationMs;
        }

        public int getPlayerCoreType() {
            return this.mPlayerCoreType;
        }

        public void setDurationMs(long j3) {
            this.mDurationMs = j3;
        }

        public void setPlayerCoreType(int i3) {
            this.mPlayerCoreType = i3;
        }
    }

    /* loaded from: classes26.dex */
    public static class PrepareStartEventInfo extends BaseEventInfo {
        private String mFlowId = "";

        public PrepareStartEventInfo() {
            setEventId(1);
        }

        public String getFlowId() {
            return this.mFlowId;
        }

        public void setFlowId(String str) {
            this.mFlowId = str;
        }
    }

    /* loaded from: classes26.dex */
    public static class SeekEndEventInfo extends BaseEventInfo {
        public SeekEndEventInfo() {
            setEventId(10);
        }
    }

    /* loaded from: classes26.dex */
    public static class SeekStartEventInfo extends BaseEventInfo {
        public SeekStartEventInfo() {
            setEventId(9);
        }
    }

    /* loaded from: classes26.dex */
    public static class SelectTrackEndEventInfo extends BaseEventInfo {
        private TPError mError;
        private long mOpaque;

        public SelectTrackEndEventInfo() {
            setEventId(15);
        }

        public TPError getError() {
            return this.mError;
        }

        public long getOpaque() {
            return this.mOpaque;
        }

        public void setError(TPError tPError) {
            this.mError = tPError;
        }

        public void setOpaque(long j3) {
            this.mOpaque = j3;
        }
    }

    /* loaded from: classes26.dex */
    public static class SelectTrackStartEventInfo extends BaseEventInfo {
        private long mOpaque;
        private int mTrackIndex;
        private TPTrackInfo mTrackInfo;

        public SelectTrackStartEventInfo() {
            setEventId(14);
        }

        public long getOpaque() {
            return this.mOpaque;
        }

        public int getTrackIndex() {
            return this.mTrackIndex;
        }

        public TPTrackInfo getTrackInfo() {
            return this.mTrackInfo;
        }

        public void setOpaque(long j3) {
            this.mOpaque = j3;
        }

        public void setTrackIndex(int i3) {
            this.mTrackIndex = i3;
        }

        public void setTrackInfo(TPTrackInfo tPTrackInfo) {
            this.mTrackInfo = tPTrackInfo;
        }
    }

    /* loaded from: classes26.dex */
    public static class SetDataSourceEventInfo extends BaseEventInfo {
        private boolean mIsUseProxy;
        private String mUrl;
        private int mUrlProtocol;

        public SetDataSourceEventInfo() {
            setEventId(17);
        }

        public String getUrl() {
            return this.mUrl;
        }

        public int getUrlProtocol() {
            return this.mUrlProtocol;
        }

        public boolean isIsUseProxy() {
            return this.mIsUseProxy;
        }

        public void setIsUseProxy(boolean z16) {
            this.mIsUseProxy = z16;
        }

        public void setUrl(String str) {
            this.mUrl = str;
        }

        public void setUrlProtocol(int i3) {
            this.mUrlProtocol = i3;
        }
    }

    /* loaded from: classes26.dex */
    public static class SetPlaySpeedEventInfo extends BaseEventInfo {
        private float mPlaySpeedRatio;

        public SetPlaySpeedEventInfo() {
            setEventId(13);
        }

        public float getPlaySpeedRatio() {
            return this.mPlaySpeedRatio;
        }

        public void setPlaySpeedRatio(float f16) {
            this.mPlaySpeedRatio = f16;
        }
    }

    TPPlayerEventInfo() {
    }
}
