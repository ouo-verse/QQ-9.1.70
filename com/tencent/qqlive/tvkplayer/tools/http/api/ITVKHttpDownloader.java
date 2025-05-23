package com.tencent.qqlive.tvkplayer.tools.http.api;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKHttpDownloader {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ITVKDownloadCallback {
        void onDataReceived(Map<String, List<String>> map, byte[] bArr, int i3) throws IOException;

        void onFailure(IOException iOException);

        void onFinished();
    }

    void execute(@NonNull ITVKHttpProcessor.TVKHttpRequest tVKHttpRequest, @NonNull ITVKDownloadCallback iTVKDownloadCallback) throws IOException;

    void executeAsync(@NonNull ITVKHttpProcessor.TVKHttpRequest tVKHttpRequest, @NonNull ITVKDownloadCallback iTVKDownloadCallback);
}
