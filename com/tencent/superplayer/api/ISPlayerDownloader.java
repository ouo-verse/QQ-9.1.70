package com.tencent.superplayer.api;

import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import java.util.Map;

/* loaded from: classes26.dex */
public interface ISPlayerDownloader {

    /* loaded from: classes26.dex */
    public interface Listener {
        void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo);

        @Deprecated
        void onDownloadCdnUrlExpired(int i3, Map<String, String> map);

        @Deprecated
        void onDownloadCdnUrlInfoUpdate(int i3, String str, String str2, String str3, String str4);

        @Deprecated
        void onDownloadCdnUrlUpdate(int i3, String str);

        void onDownloadError(int i3, int i16, int i17, String str);

        void onDownloadFinish(int i3);

        void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str);

        @Deprecated
        void onDownloadProtocolUpdate(int i3, String str, String str2);

        @Deprecated
        void onDownloadStatusUpdate(int i3, int i16);
    }

    void pauseOfflineDownload(int i3);

    void resumeOfflineDownload(int i3);

    int startOfflineDownload(SuperPlayerVideoInfo superPlayerVideoInfo, Listener listener);

    void stopOfflineDownload(int i3);
}
