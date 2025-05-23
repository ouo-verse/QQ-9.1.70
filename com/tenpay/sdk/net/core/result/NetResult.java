package com.tenpay.sdk.net.core.result;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tenpay.sdk.net.core.request.NetRequest;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0013\"\u0004\b\u0016\u0010\u0015R\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u0006#"}, d2 = {"Lcom/tenpay/sdk/net/core/result/NetResult;", "", "url", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tenpay/sdk/net/core/request/NetRequest;", "isConnectSucceed", "", "isBizSucceed", "throwable", "", "bizResponse", "statisticsInfo", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;", "(Ljava/lang/String;Lcom/tenpay/sdk/net/core/request/NetRequest;ZZLjava/lang/Throwable;Ljava/lang/Object;Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;)V", "getBizResponse", "()Ljava/lang/Object;", "setBizResponse", "(Ljava/lang/Object;)V", "()Z", "setBizSucceed", "(Z)V", "setConnectSucceed", "getRequest", "()Lcom/tenpay/sdk/net/core/request/NetRequest;", "getStatisticsInfo", "()Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;", "setStatisticsInfo", "(Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;)V", "getThrowable", "()Ljava/lang/Throwable;", "setThrowable", "(Ljava/lang/Throwable;)V", "getUrl", "()Ljava/lang/String;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public class NetResult {

    @Nullable
    private Object bizResponse;
    private boolean isBizSucceed;
    private boolean isConnectSucceed;

    @NotNull
    private final NetRequest<?> request;

    @Nullable
    private StatisticInfo statisticsInfo;

    @Nullable
    private Throwable throwable;

    @NotNull
    private final String url;

    public NetResult(@NotNull String url, @NotNull NetRequest<?> request, boolean z16, boolean z17, @Nullable Throwable th5, @Nullable Object obj, @Nullable StatisticInfo statisticInfo) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(request, "request");
        this.url = url;
        this.request = request;
        this.isConnectSucceed = z16;
        this.isBizSucceed = z17;
        this.throwable = th5;
        this.bizResponse = obj;
        this.statisticsInfo = statisticInfo;
    }

    @Nullable
    public final Object getBizResponse() {
        return this.bizResponse;
    }

    @NotNull
    public final NetRequest<?> getRequest() {
        return this.request;
    }

    @Nullable
    public final StatisticInfo getStatisticsInfo() {
        return this.statisticsInfo;
    }

    @Nullable
    public final Throwable getThrowable() {
        return this.throwable;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: isBizSucceed, reason: from getter */
    public final boolean getIsBizSucceed() {
        return this.isBizSucceed;
    }

    /* renamed from: isConnectSucceed, reason: from getter */
    public final boolean getIsConnectSucceed() {
        return this.isConnectSucceed;
    }

    public final void setBizResponse(@Nullable Object obj) {
        this.bizResponse = obj;
    }

    public final void setBizSucceed(boolean z16) {
        this.isBizSucceed = z16;
    }

    public final void setConnectSucceed(boolean z16) {
        this.isConnectSucceed = z16;
    }

    public final void setStatisticsInfo(@Nullable StatisticInfo statisticInfo) {
        this.statisticsInfo = statisticInfo;
    }

    public final void setThrowable(@Nullable Throwable th5) {
        this.throwable = th5;
    }

    public /* synthetic */ NetResult(String str, NetRequest netRequest, boolean z16, boolean z17, Throwable th5, Object obj, StatisticInfo statisticInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, netRequest, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17, (i3 & 16) != 0 ? null : th5, (i3 & 32) != 0 ? null : obj, (i3 & 64) != 0 ? null : statisticInfo);
    }
}
