package com.tenpay.sdk.net.core.request;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.result.NetResult;
import com.tenpay.sdk.net.core.task.base.Priority;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001d*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001dB;\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tenpay/sdk/net/core/request/NetRequest;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tenpay/sdk/net/core/result/NetResult;", "", "paramMap", "", "", "priority", "Lcom/tenpay/sdk/net/core/task/base/Priority;", "netCallback", "Lcom/tenpay/sdk/net/core/callback/NetCallback;", "(Ljava/util/Map;Lcom/tenpay/sdk/net/core/task/base/Priority;Lcom/tenpay/sdk/net/core/callback/NetCallback;)V", "getNetCallback", "()Lcom/tenpay/sdk/net/core/callback/NetCallback;", "setNetCallback", "(Lcom/tenpay/sdk/net/core/callback/NetCallback;)V", "getParamMap", "()Ljava/util/Map;", "getPriority", "()Lcom/tenpay/sdk/net/core/task/base/Priority;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "getRequestId", "()I", "equals", "", "other", "getAccount", "hashCode", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public class NetRequest<R extends NetResult> {

    @Nullable
    private NetCallback<NetResult> netCallback;

    @Nullable
    private final Map<String, String> paramMap;

    @NotNull
    private final Priority priority;
    private final int requestId;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final AtomicInteger ATOMIC_REQUEST_ID = new AtomicInteger(1);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/net/core/request/NetRequest$Companion;", "", "()V", "ATOMIC_REQUEST_ID", "Ljava/util/concurrent/atomic/AtomicInteger;", "getATOMIC_REQUEST_ID", "()Ljava/util/concurrent/atomic/AtomicInteger;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AtomicInteger getATOMIC_REQUEST_ID() {
            return NetRequest.ATOMIC_REQUEST_ID;
        }

        Companion() {
        }
    }

    public NetRequest() {
        this(null, null, null, 7, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof NetRequest) && this.requestId == ((NetRequest) other).requestId) {
            return true;
        }
        return false;
    }

    @NotNull
    public String getAccount() {
        return "";
    }

    @Nullable
    public final NetCallback<NetResult> getNetCallback() {
        return this.netCallback;
    }

    @Nullable
    public final Map<String, String> getParamMap() {
        return this.paramMap;
    }

    @NotNull
    public final Priority getPriority() {
        return this.priority;
    }

    public final int getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        return this.requestId;
    }

    public final void setNetCallback(@Nullable NetCallback<NetResult> netCallback) {
        this.netCallback = netCallback;
    }

    public NetRequest(@Nullable Map<String, String> map, @NotNull Priority priority, @Nullable NetCallback<NetResult> netCallback) {
        Intrinsics.checkNotNullParameter(priority, "priority");
        this.paramMap = map;
        this.priority = priority;
        this.netCallback = netCallback;
        this.requestId = ATOMIC_REQUEST_ID.getAndAdd(1);
    }

    public /* synthetic */ NetRequest(Map map, Priority priority, NetCallback netCallback, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : map, (i3 & 2) != 0 ? Priority.NORMAL_PRIORITY : priority, (i3 & 4) != 0 ? null : netCallback);
    }
}
