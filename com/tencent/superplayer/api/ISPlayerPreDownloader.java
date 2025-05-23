package com.tencent.superplayer.api;

import com.tencent.superplayer.tvkplayer.datatransport.ITVKPlayerPreDownloader;

/* loaded from: classes26.dex */
public interface ISPlayerPreDownloader extends ITVKPlayerPreDownloader {

    /* loaded from: classes26.dex */
    public interface Listener {
        void onInfo(int i3, long j3, long j16, Object obj);

        void onPrepareDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str);

        void onPrepareError(int i3, int i16, int i17, String str);

        void onPrepareSuccess(int i3);
    }

    void destory();

    void setOnPreDownloadListener(Listener listener);

    int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3);

    int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, long j16);

    int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, long j16, SuperPlayerDownOption superPlayerDownOption);

    int startPreDownload(SuperPlayerVideoInfo superPlayerVideoInfo, long j3, SuperPlayerDownOption superPlayerDownOption);

    void stopAllPreDownload();

    void stopPreDownload(int i3);
}
