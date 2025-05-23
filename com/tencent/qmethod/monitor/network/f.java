package com.tencent.qmethod.monitor.network;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qmethod.pandoraex.core.o;
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
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0019\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ,\u0010\u0007\u001a\u0004\u0018\u00010\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\n\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qmethod/monitor/network/f;", "Lcom/tencent/qmethod/monitor/network/a;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "headers", "Ljava/net/HttpURLConnection;", "b", "", "e", "I", "getProtocol", "()I", "setProtocol", "(I)V", AudienceReportConst.PROTOCOL, "Ljava/net/URL;", "f", "Ljava/net/URL;", "()Ljava/net/URL;", "setUrl", "(Ljava/net/URL;)V", "url", h.F, "timeoutTime", "<init>", "(Ljava/net/URL;I)V", "i", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public abstract class f extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int protocol;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private URL url;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int timeoutTime;

    public f(@NotNull URL url, int i3) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        this.url = url;
        this.timeoutTime = i3;
        this.protocol = a(url);
    }

    @Nullable
    public final HttpURLConnection b(@NotNull HashMap<String, String> headers) {
        HttpURLConnection httpURLConnection;
        Intrinsics.checkParameterIsNotNull(headers, "headers");
        try {
            URLConnection openConnection = this.url.openConnection();
            if (!(openConnection instanceof HttpURLConnection)) {
                openConnection = null;
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.setConnectTimeout(this.timeoutTime);
                httpURLConnection2.setReadTimeout(this.timeoutTime);
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
                        httpsURLConnection.setHostnameVerifier(lr3.b.f415472c.a());
                        httpsURLConnection.connect();
                    }
                }
            }
            return httpURLConnection2;
        } catch (Throwable th5) {
            o.d("QAPMUpload", "connectionBuilder", th5);
            return null;
        }
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final URL getUrl() {
        return this.url;
    }
}
