package com.tenpay.sdk.net.sso;

import com.tenpay.sdk.net.core.result.NetResult;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import com.tenpay.sdk.net.utils.ExceptionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u000fJ\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/tenpay/sdk/net/sso/PaySsoResult;", "Lcom/tenpay/sdk/net/core/result/NetResult;", "url", "", "httpRequest", "Lcom/tenpay/sdk/net/sso/PaySsoRequest;", "isConnectSucceed", "", "isBizSucceed", "throwable", "", "bizResponse", "", "statisticsInfo", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;", "(Ljava/lang/String;Lcom/tenpay/sdk/net/sso/PaySsoRequest;ZZLjava/lang/Throwable;Ljava/lang/Object;Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;)V", "getHttpRequest", "()Lcom/tenpay/sdk/net/sso/PaySsoRequest;", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaySsoResult extends NetResult {

    @NotNull
    private final PaySsoRequest httpRequest;

    public /* synthetic */ PaySsoResult(String str, PaySsoRequest paySsoRequest, boolean z16, boolean z17, Throwable th5, Object obj, StatisticInfo statisticInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, paySsoRequest, (i3 & 4) != 0 ? false : z16, (i3 & 8) != 0 ? false : z17, (i3 & 16) != 0 ? null : th5, (i3 & 32) != 0 ? null : obj, (i3 & 64) != 0 ? null : statisticInfo);
    }

    @NotNull
    public final PaySsoRequest getHttpRequest() {
        return this.httpRequest;
    }

    @NotNull
    public String toString() {
        return "[" + getUrl() + "][biz=" + getIsBizSucceed() + "][e=" + ExceptionUtils.INSTANCE.toSimpleString(getThrowable()) + "]";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaySsoResult(@NotNull String url, @NotNull PaySsoRequest httpRequest, boolean z16, boolean z17, @Nullable Throwable th5, @Nullable Object obj, @Nullable StatisticInfo statisticInfo) {
        super(url, httpRequest, z16, z17, th5, obj, statisticInfo);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
        this.httpRequest = httpRequest;
    }
}
