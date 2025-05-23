package com.tenpay.sdk.net.http.common;

import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00065"}, d2 = {"Lcom/tenpay/sdk/net/http/common/HttpOptions;", "", "()V", "connManagerTimeout", "", "getConnManagerTimeout", "()I", "setConnManagerTimeout", "(I)V", "connTimeout", "getConnTimeout", "setConnTimeout", "hostNameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "getHostNameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "setHostNameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)V", "maxConnection", "getMaxConnection", "setMaxConnection", "maxConnectionPerRoute", "getMaxConnectionPerRoute", "setMaxConnectionPerRoute", "multiConnection", "", "getMultiConnection", "()Z", "setMultiConnection", "(Z)V", "soTimeout", "getSoTimeout", "setSoTimeout", "supportProtocol", "", "Lokhttp3/Protocol;", "getSupportProtocol", "()Ljava/util/List;", "setSupportProtocol", "(Ljava/util/List;)V", "timeToLive", "", "getTimeToLive", "()J", "setTimeToLive", "(J)V", "timeToLiveUnit", "Ljava/util/concurrent/TimeUnit;", "getTimeToLiveUnit", "()Ljava/util/concurrent/TimeUnit;", "setTimeToLiveUnit", "(Ljava/util/concurrent/TimeUnit;)V", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class HttpOptions {
    public static final int DEFAULT_CONNECTION_TIMEOUT = 5000;
    public static final int DEFAULT_MAX_CONNECTION = 20;
    public static final int DEFAULT_MAX_CONNECTION_PER_ROUTE = 5;
    public static final int DEFAULT_SO_TIMEOUT = 10000;
    public static final long DEFAULT_TIME_TO_LIVE = 120000;
    private int connManagerTimeout;
    private int connTimeout;

    @NotNull
    private HostnameVerifier hostNameVerifier;
    private int maxConnection;
    private int maxConnectionPerRoute;
    private boolean multiConnection = true;
    private int soTimeout;

    @NotNull
    private List<? extends Protocol> supportProtocol;
    private long timeToLive;

    @NotNull
    private TimeUnit timeToLiveUnit;

    public HttpOptions() {
        List<? extends Protocol> mutableListOf;
        this.timeToLive = -1L;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.timeToLiveUnit = timeUnit;
        this.maxConnection = -1;
        this.maxConnectionPerRoute = -1;
        this.connTimeout = 5000;
        this.connManagerTimeout = 5000;
        this.soTimeout = 10000;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Protocol.HTTP_1_1);
        this.supportProtocol = mutableListOf;
        X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
        Intrinsics.checkNotNullExpressionValue(BROWSER_COMPATIBLE_HOSTNAME_VERIFIER, "BROWSER_COMPATIBLE_HOSTNAME_VERIFIER");
        this.hostNameVerifier = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
        if (this.multiConnection) {
            this.maxConnection = 20;
            this.maxConnectionPerRoute = 5;
            this.timeToLive = 120000L;
            this.timeToLiveUnit = timeUnit;
        }
    }

    public final int getConnManagerTimeout() {
        return this.connManagerTimeout;
    }

    public final int getConnTimeout() {
        return this.connTimeout;
    }

    @NotNull
    public final HostnameVerifier getHostNameVerifier() {
        return this.hostNameVerifier;
    }

    public final int getMaxConnection() {
        return this.maxConnection;
    }

    public final int getMaxConnectionPerRoute() {
        return this.maxConnectionPerRoute;
    }

    public final boolean getMultiConnection() {
        return this.multiConnection;
    }

    public final int getSoTimeout() {
        return this.soTimeout;
    }

    @NotNull
    public final List<Protocol> getSupportProtocol() {
        return this.supportProtocol;
    }

    public final long getTimeToLive() {
        return this.timeToLive;
    }

    @NotNull
    public final TimeUnit getTimeToLiveUnit() {
        return this.timeToLiveUnit;
    }

    public final void setConnManagerTimeout(int i3) {
        this.connManagerTimeout = i3;
    }

    public final void setConnTimeout(int i3) {
        this.connTimeout = i3;
    }

    public final void setHostNameVerifier(@NotNull HostnameVerifier hostnameVerifier) {
        Intrinsics.checkNotNullParameter(hostnameVerifier, "<set-?>");
        this.hostNameVerifier = hostnameVerifier;
    }

    public final void setMaxConnection(int i3) {
        this.maxConnection = i3;
    }

    public final void setMaxConnectionPerRoute(int i3) {
        this.maxConnectionPerRoute = i3;
    }

    public final void setMultiConnection(boolean z16) {
        this.multiConnection = z16;
    }

    public final void setSoTimeout(int i3) {
        this.soTimeout = i3;
    }

    public final void setSupportProtocol(@NotNull List<? extends Protocol> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.supportProtocol = list;
    }

    public final void setTimeToLive(long j3) {
        this.timeToLive = j3;
    }

    public final void setTimeToLiveUnit(@NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "<set-?>");
        this.timeToLiveUnit = timeUnit;
    }
}
