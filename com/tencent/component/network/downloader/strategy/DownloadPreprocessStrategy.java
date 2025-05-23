package com.tencent.component.network.downloader.strategy;

import com.tencent.component.network.downloader.impl.DownloaderImpl;
import okhttp3.Request;
import org.apache.http.HttpRequest;

/* loaded from: classes5.dex */
public interface DownloadPreprocessStrategy {

    /* loaded from: classes5.dex */
    public enum DownloadPool {
        COMMON("common"),
        SPECIFIC("specific"),
        SPECIFIC1("specific1"),
        HTTP2("http2");

        private static final int SIZE = DownloaderImpl.THREAD_POOL_SIZE;
        final String name;

        DownloadPool(String str) {
            this.name = str;
        }

        public static int size() {
            return SIZE;
        }

        public String getName() {
            return this.name;
        }
    }

    DownloadPool downloadPool(String str, String str2);

    void prepareRequest(String str, String str2, HttpRequest httpRequest, Request.Builder builder, int i3);

    String prepareUrl(String str);
}
