package com.tencent.bugly.common.reporter.upload;

import com.tencent.bugly.common.network.ssl.NameVerifierFactory;
import com.tencent.bugly.common.network.ssl.SslFactory;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.rmonitor.common.logger.Logger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J@\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012`\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/bugly/common/reporter/upload/QAPMUpload;", "Lcom/tencent/bugly/common/reporter/upload/BaseUpload;", "url", "Ljava/net/URL;", "(Ljava/net/URL;)V", AudienceReportConst.PROTOCOL, "", "getProtocol", "()I", "setProtocol", "(I)V", "getUrl", "()Ljava/net/URL;", "setUrl", "connectionBuilder", "Ljava/net/HttpURLConnection;", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "connectTimeout", "readTimeout", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public abstract class QAPMUpload extends BaseUpload {
    public static final int CHUNK_SIZE = 1048576;
    public static final int ERROR_CLIENT = 400;
    public static final int ERROR_FILE_NOT_EXIT = 601;
    public static final int ERROR_MAX_LIMIT = 800;
    public static final int ERROR_NET_NOT_AVAILABLE = 602;
    public static final int ERROR_NOT_FATAL = 603;
    public static final int ERROR_OOM = 600;
    public static final int ERROR_OTHER = 700;
    public static final int ERROR_SERVICE = 500;
    public static final int HTTP_OK = 200;
    public static final int SOCKET_TIMEOUT_MILLI = 30000;
    private static final String TAG = "RMonitor_upload";
    private int protocol;

    @NotNull
    private URL url;

    public QAPMUpload(@NotNull URL url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        this.url = url;
        this.protocol = getProtocol(url);
    }

    public static /* synthetic */ HttpURLConnection connectionBuilder$default(QAPMUpload qAPMUpload, HashMap hashMap, int i3, int i16, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 2) != 0) {
                i3 = 30000;
            }
            if ((i17 & 4) != 0) {
                i16 = 30000;
            }
            return qAPMUpload.connectionBuilder(hashMap, i3, i16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connectionBuilder");
    }

    @Nullable
    public final HttpURLConnection connectionBuilder(@NotNull HashMap<String, String> headers, int connectTimeout, int readTimeout) {
        HttpURLConnection httpURLConnection;
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        try {
            URLConnection openConnection = this.url.openConnection();
            if (!(openConnection instanceof HttpURLConnection)) {
                openConnection = null;
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.setConnectTimeout(connectTimeout);
                httpURLConnection2.setReadTimeout(readTimeout);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setChunkedStreamingMode(1048576);
                httpURLConnection2.setRequestProperty("Connection", "close");
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                }
                if (this.protocol == 1) {
                    if (!(httpURLConnection2 instanceof HttpsURLConnection)) {
                        httpURLConnection = null;
                    } else {
                        httpURLConnection = httpURLConnection2;
                    }
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                    if (httpsURLConnection != null) {
                        httpsURLConnection.setSSLSocketFactory(SslFactory.INSTANCE.getSslSocketFactory());
                        httpsURLConnection.setHostnameVerifier(NameVerifierFactory.INSTANCE.getNameVerifier());
                        httpsURLConnection.connect();
                    }
                }
            }
            return httpURLConnection2;
        } catch (Throwable th5) {
            Logger.f365497g.c(TAG, th5);
            return null;
        }
    }

    public final int getProtocol() {
        return this.protocol;
    }

    @NotNull
    public final URL getUrl() {
        return this.url;
    }

    public final void setProtocol(int i3) {
        this.protocol = i3;
    }

    public final void setUrl(@NotNull URL url) {
        Intrinsics.checkParameterIsNotNull(url, "<set-?>");
        this.url = url;
    }
}
