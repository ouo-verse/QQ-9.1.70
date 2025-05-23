package com.tencent.thumbplayer.api.common;

import android.os.SystemClock;

/* loaded from: classes26.dex */
public class TPDebugTrackingInfo {
    public static final int TP_DEBUG_TRACKING_INFO_ID_AUDIOTRACK_RENDER_TIMEOUT = 20;
    public static final int TP_DEBUG_TRACKING_INFO_ID_AUDIO_MEDIACODEC_CONFIGURE_END = 16;
    public static final int TP_DEBUG_TRACKING_INFO_ID_AUDIO_MEDIACODEC_CONFIGURE_START = 15;
    public static final int TP_DEBUG_TRACKING_INFO_ID_AUDIO_MEDIACODEC_START_END = 18;
    public static final int TP_DEBUG_TRACKING_INFO_ID_AUDIO_MEDIACODEC_START_START = 17;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DEMUXER_FILE_OPEN_END = 4;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DEMUXER_FILE_OPEN_START = 3;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DEMUXER_THREAD_ON_PREPARED = 5;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DEMUXER_THREAD_PREPARE_START = 2;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_GET_KEY_REQ_END = 111;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_GET_KEY_REQ_START = 110;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_GET_PROVISION_REQ_END = 105;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_GET_PROVISION_REQ_START = 104;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_KEY_REQ_DNS_RESOLVED = 116;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_KEY_REQ_SOCKET_CONNECTED = 117;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_OPEN_SESSION_END = 103;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_OPEN_SESSION_START = 102;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_PREPARE_END = 101;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_PREPARE_START = 100;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_PROVIDE_KEY_RESP_END = 115;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_PROVIDE_KEY_RESP_START = 114;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_PROVIDE_PROVISION_RESP_END = 109;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_PROVIDE_PROVISION_RESP_START = 108;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_RECV_KEY_RESP = 113;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_RECV_PROVISION_RESP = 107;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_SEND_KEY_REQ = 112;
    public static final int TP_DEBUG_TRACKING_INFO_ID_DRM_SEND_PROVISION_REQ = 106;
    public static final int TP_DEBUG_TRACKING_INFO_ID_FIRST_AUDIO_DECODER_CREATE_START = 8;
    public static final int TP_DEBUG_TRACKING_INFO_ID_FIRST_AUDIO_FRAME_RENDERED = 10;
    public static final int TP_DEBUG_TRACKING_INFO_ID_FIRST_PACKET_READ = 19;
    public static final int TP_DEBUG_TRACKING_INFO_ID_FIRST_START = 0;
    public static final int TP_DEBUG_TRACKING_INFO_ID_FIRST_VIDEO_DECODER_CREATE_START = 7;
    public static final int TP_DEBUG_TRACKING_INFO_ID_FIRST_VIDEO_FRAME_RENDERED = 9;
    public static final int TP_DEBUG_TRACKING_INFO_ID_PLAYER_SCHEDULING_THREAD_ON_PREPARED = 6;
    public static final int TP_DEBUG_TRACKING_INFO_ID_PLAYER_SCHEDULING_THREAD_PREPARE_START = 1;
    public static final int TP_DEBUG_TRACKING_INFO_ID_TP_API_ON_FIRST_AUDIO_FRAME_RENDERED = 1006;
    public static final int TP_DEBUG_TRACKING_INFO_ID_TP_API_ON_FIRST_VIDEO_FRAME_RENDERED = 1005;
    public static final int TP_DEBUG_TRACKING_INFO_ID_TP_API_ON_PREPARED = 1004;
    public static final int TP_DEBUG_TRACKING_INFO_ID_TP_API_PREPARE_START = 1003;
    public static final int TP_DEBUG_TRACKING_INFO_ID_TP_API_SET_DATA_SOURCE_END = 1001;
    public static final int TP_DEBUG_TRACKING_INFO_ID_TP_API_SET_DATA_SOURCE_START = 1000;
    public static final int TP_DEBUG_TRACKING_INFO_ID_UNKNOWN = -1;
    public static final int TP_DEBUG_TRACKING_INFO_ID_VIDEO_MEDIACODEC_CONFIGURE_END = 12;
    public static final int TP_DEBUG_TRACKING_INFO_ID_VIDEO_MEDIACODEC_CONFIGURE_START = 11;
    public static final int TP_DEBUG_TRACKING_INFO_ID_VIDEO_MEDIACODEC_START_END = 14;
    public static final int TP_DEBUG_TRACKING_INFO_ID_VIDEO_MEDIACODEC_START_START = 13;
    private long mElapsedTimeSinceBootMs;
    private long mTimeSince1970Ms;
    private int mTrackingInfoID;

    public TPDebugTrackingInfo(int i3) {
        this(i3, System.currentTimeMillis(), SystemClock.elapsedRealtime());
    }

    public long getElapsedTimeSinceBootMs() {
        return this.mElapsedTimeSinceBootMs;
    }

    public long getTimeSince1970Ms() {
        return this.mTimeSince1970Ms;
    }

    public int getTrackingInfoID() {
        return this.mTrackingInfoID;
    }

    public TPDebugTrackingInfo(int i3, long j3, long j16) {
        this.mTrackingInfoID = i3;
        this.mTimeSince1970Ms = j3;
        this.mElapsedTimeSinceBootMs = j16;
    }
}
