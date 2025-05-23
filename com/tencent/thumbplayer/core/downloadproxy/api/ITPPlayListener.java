package com.tencent.thumbplayer.core.downloadproxy.api;

import java.util.Map;

/* loaded from: classes26.dex */
public interface ITPPlayListener {
    public static final int MESSAGE_FLV_PRELOAD_STATUS = 5;
    public static final int MESSAGE_HTTP_HEADER = 3;
    public static final int MESSAGE_MULTI_NETWORK_LOW_SPEED = 10;
    public static final int MESSAGE_MULTI_NETWORK_STATUS = 11;
    public static final int MESSAGE_NOTIFY_M3U8_CONTENT = 4;
    public static final int MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION = 2;
    public static final int MESSAGE_PLAY_VIDEO_NO_MORE_CACHE = 1;
    public static final int MESSAGE_QUIC_DOWNLOAD_STATUS = 6;
    public static final int MESSAGE_READ_INVALID = 12;
    public static final int MESSAGE_TAB_TESTID = 8;
    public static final int MESSAGE_VERIFY_TOKEN_FAILED = 13;
    public static final int MSG_M3U8_REFRESH = 9;

    long getAdvRemainTime();

    String getContentType(int i3, String str);

    int getCurrentPlayClipNo();

    long getCurrentPlayOffset();

    long getCurrentPosition();

    String getDataFilePath(int i3, String str);

    long getDataTotalSize(int i3, String str);

    Object getPlayInfo(long j3);

    Object getPlayInfo(String str);

    long getPlayerBufferLength();

    void onDownloadCdnUrlExpired(Map<String, String> map);

    void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4);

    void onDownloadCdnUrlUpdate(String str);

    void onDownloadError(int i3, int i16, String str);

    void onDownloadFinish();

    void onDownloadProgressUpdate(int i3, int i16, long j3, long j16, String str);

    void onDownloadProtocolUpdate(String str, String str2);

    void onDownloadStatusUpdate(int i3);

    void onPcdnDownloadFailed(String str);

    Object onPlayCallback(int i3, Object obj, Object obj2, Object obj3, Object obj4);

    void onQuicDownloadStatusUpdate(String str);

    int onReadData(int i3, String str, long j3, long j16);

    int onStartReadData(int i3, String str, long j3, long j16);

    int onStopReadData(int i3, String str, int i16);
}
