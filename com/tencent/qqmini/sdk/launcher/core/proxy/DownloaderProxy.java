package com.tencent.qqmini.sdk.launcher.core.proxy;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Map;

/* loaded from: classes23.dex */
public abstract class DownloaderProxy {

    /* loaded from: classes23.dex */
    public interface DownloadListener {

        /* loaded from: classes23.dex */
        public static class DownloadResult {
            public long connectionTimeMs;
            public final long contentLength;
            public long dnsTimeMs;

            @NonNull
            public final Map<String, List<String>> headers;
            public long httpStatusCode;
            public boolean isFromReusedConnection;
            public String message;
            public long queueTimeMs;
            public long receiveTimeMs;
            public long startTimeMs;
            public boolean success;
            public final long totalTimeMs;
            public String url;

            public DownloadResult(String str, long j3, boolean z16, String str2, boolean z17, long j16, long j17, long j18, long j19, long j26, long j27, @NonNull Map<String, List<String>> map) {
                this(str, j3, z16, str2, z17, j16, j17, j18, j19, j26, j27, map, 0L);
            }

            public DownloadResult(String str, long j3, boolean z16, String str2, boolean z17, long j16, long j17, long j18, long j19, long j26, long j27, @NonNull Map<String, List<String>> map, long j28) {
                this.url = str;
                this.httpStatusCode = j3;
                this.success = z16;
                this.message = str2;
                this.isFromReusedConnection = z17;
                this.queueTimeMs = j16;
                this.dnsTimeMs = j17;
                this.connectionTimeMs = j18;
                this.receiveTimeMs = j19;
                this.totalTimeMs = j26;
                this.contentLength = j27;
                this.headers = map;
                this.startTimeMs = j28;
            }
        }

        void onDownloadFailed(int i3, String str);

        void onDownloadHeadersReceived(int i3, Map<String, List<String>> map);

        void onDownloadProgress(float f16, long j3, long j16);

        void onDownloadSucceed(int i3, String str, DownloadResult downloadResult);
    }

    /* loaded from: classes23.dex */
    public interface SoLoadListener {
        void onFail(int i3);

        void onSuccess(String str);
    }

    public abstract void abort(String str);

    public abstract boolean download(String str, Map<String, String> map, String str2, int i3, DownloadListener downloadListener);

    public abstract void loadMiniGameSo(String str, SoLoadListener soLoadListener);

    public boolean miniAppDownload(boolean z16, String str, Map<String, String> map, String str2, int i3, long j3, DownloadListener downloadListener) {
        return download(str, map, str2, i3, downloadListener);
    }

    public abstract void preConnectDownloadHost();
}
