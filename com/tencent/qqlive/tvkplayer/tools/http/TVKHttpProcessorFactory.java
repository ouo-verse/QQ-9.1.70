package com.tencent.qqlive.tvkplayer.tools.http;

import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpDownloader;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.http.okhttp.TVKOKHttpClient;

/* loaded from: classes23.dex */
public class TVKHttpProcessorFactory {
    TVKHttpProcessorFactory() {
    }

    public static ITVKHttpDownloader getHttpDownloader() {
        return TVKOKHttpClient.getInstance();
    }

    public static ITVKHttpProcessor getHttpRequester() {
        return TVKOKHttpClient.getInstance();
    }
}
