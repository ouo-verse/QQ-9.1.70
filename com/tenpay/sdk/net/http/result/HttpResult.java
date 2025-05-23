package com.tenpay.sdk.net.http.result;

import com.tenpay.sdk.net.core.result.NetResult;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import com.tenpay.sdk.net.http.request.HttpRequest;
import com.tenpay.sdk.net.utils.ExceptionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0013J\u0006\u0010\u001e\u001a\u00020\u0003J\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tenpay/sdk/net/http/result/HttpResult;", "Lcom/tenpay/sdk/net/core/result/NetResult;", "url", "", "httpRequest", "Lcom/tenpay/sdk/net/http/request/HttpRequest;", "isConnectSucceed", "", "isBizSucceed", "throwable", "", "responseHeaders", "Lokhttp3/Headers;", "bizResponse", "", "okResponse", "Lokhttp3/Response;", "statisticsInfo", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;", "(Ljava/lang/String;Lcom/tenpay/sdk/net/http/request/HttpRequest;ZZLjava/lang/Throwable;Lokhttp3/Headers;Ljava/lang/Object;Lokhttp3/Response;Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;)V", "getHttpRequest", "()Lcom/tenpay/sdk/net/http/request/HttpRequest;", "getOkResponse", "()Lokhttp3/Response;", "setOkResponse", "(Lokhttp3/Response;)V", "getResponseHeaders", "()Lokhttp3/Headers;", "setResponseHeaders", "(Lokhttp3/Headers;)V", "toHttpString", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class HttpResult extends NetResult {

    @NotNull
    private final HttpRequest httpRequest;

    @Nullable
    private Response okResponse;

    @Nullable
    private Headers responseHeaders;

    public /* synthetic */ HttpResult(String str, HttpRequest httpRequest, boolean z16, boolean z17, Throwable th5, Headers headers, Object obj, Response response, StatisticInfo statisticInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, httpRequest, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17, (i3 & 16) != 0 ? null : th5, (i3 & 32) != 0 ? null : headers, (i3 & 64) != 0 ? null : obj, (i3 & 128) != 0 ? null : response, (i3 & 256) != 0 ? null : statisticInfo);
    }

    @NotNull
    public final HttpRequest getHttpRequest() {
        return this.httpRequest;
    }

    @Nullable
    public final Response getOkResponse() {
        return this.okResponse;
    }

    @Nullable
    public final Headers getResponseHeaders() {
        return this.responseHeaders;
    }

    public final void setOkResponse(@Nullable Response response) {
        this.okResponse = response;
    }

    public final void setResponseHeaders(@Nullable Headers headers) {
        this.responseHeaders = headers;
    }

    @NotNull
    public final String toHttpString() {
        StatisticInfo.StatisticUnit statisticUnit;
        Long l3;
        Long l16;
        Long l17;
        Long l18;
        Long l19;
        StatisticInfo statisticsInfo = getStatisticsInfo();
        Long l26 = null;
        if (statisticsInfo != null) {
            statisticUnit = statisticsInfo.getLastUnit();
        } else {
            statisticUnit = null;
        }
        boolean isConnectSucceed = getIsConnectSucceed();
        StatisticInfo statisticsInfo2 = getStatisticsInfo();
        if (statisticsInfo2 != null) {
            l3 = Long.valueOf(statisticsInfo2.getTotalTime());
        } else {
            l3 = null;
        }
        if (statisticUnit != null) {
            l16 = Long.valueOf(statisticUnit.getUnitTotalTime());
        } else {
            l16 = null;
        }
        if (statisticUnit != null) {
            l17 = Long.valueOf(statisticUnit.getHttpConnectTime());
        } else {
            l17 = null;
        }
        if (statisticUnit != null) {
            l18 = Long.valueOf(statisticUnit.getTlsTime());
        } else {
            l18 = null;
        }
        if (statisticUnit != null) {
            l19 = Long.valueOf(statisticUnit.getTcpConnectTime());
        } else {
            l19 = null;
        }
        if (statisticUnit != null) {
            l26 = Long.valueOf(statisticUnit.getDnsTime());
        }
        return "[cnt=" + isConnectSucceed + "][total=" + l3 + "][unit=" + l16 + "][http=" + l17 + "][tls=" + l18 + "][tcp=" + l19 + "][dns=" + l26 + "][e=" + ExceptionUtils.INSTANCE.toSimpleString(getThrowable()) + "]";
    }

    @NotNull
    public String toString() {
        Long l3;
        String url = getUrl();
        boolean isBizSucceed = getIsBizSucceed();
        StatisticInfo statisticsInfo = getStatisticsInfo();
        if (statisticsInfo != null) {
            l3 = Long.valueOf(statisticsInfo.getTotalTime());
        } else {
            l3 = null;
        }
        return "[" + url + "][biz=" + isBizSucceed + "][total=" + l3 + "][e=" + ExceptionUtils.INSTANCE.toSimpleString(getThrowable()) + "]";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpResult(@NotNull String url, @NotNull HttpRequest httpRequest, boolean z16, boolean z17, @Nullable Throwable th5, @Nullable Headers headers, @Nullable Object obj, @Nullable Response response, @Nullable StatisticInfo statisticInfo) {
        super(url, httpRequest, z16, z17, th5, obj, statisticInfo);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
        this.httpRequest = httpRequest;
        this.responseHeaders = headers;
        this.okResponse = response;
    }
}
