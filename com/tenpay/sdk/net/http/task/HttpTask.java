package com.tenpay.sdk.net.http.task;

import com.tenpay.sdk.net.core.client.INetClient;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.core.statistic.StatisticHandler;
import com.tenpay.sdk.net.core.task.NetTask;
import com.tenpay.sdk.net.core.task.base.TaskStatus;
import com.tenpay.sdk.net.http.request.HttpRequest;
import com.tenpay.sdk.net.http.result.HttpResult;
import com.tenpay.sdk.net.http.statisitc.HttpStatisticMonitor;
import com.tenpay.sdk.net.http.task.HttpTask;
import com.tenpay.sdk.net.utils.ThreadUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0002H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tenpay/sdk/net/http/task/HttpTask;", "Lcom/tenpay/sdk/net/core/task/NetTask;", "Lcom/tenpay/sdk/net/http/result/HttpResult;", "client", "Lcom/tenpay/sdk/net/core/client/INetClient;", "httpRequest", "Lcom/tenpay/sdk/net/http/request/HttpRequest;", "responseProcessor", "Lcom/tenpay/sdk/net/core/task/NetTask$ResponseProcessor;", "Lokhttp3/Response;", "statisticHandler", "Lcom/tenpay/sdk/net/core/statistic/StatisticHandler;", "(Lcom/tenpay/sdk/net/core/client/INetClient;Lcom/tenpay/sdk/net/http/request/HttpRequest;Lcom/tenpay/sdk/net/core/task/NetTask$ResponseProcessor;Lcom/tenpay/sdk/net/core/statistic/StatisticHandler;)V", "getHttpRequest", "()Lcom/tenpay/sdk/net/http/request/HttpRequest;", "realCall", "Lokhttp3/Call;", "getRealCall", "()Lokhttp3/Call;", "setRealCall", "(Lokhttp3/Call;)V", "getResponseProcessor", "()Lcom/tenpay/sdk/net/core/task/NetTask$ResponseProcessor;", "buildRequest", "Lokhttp3/Request;", "buildResult", "cancel", "", "getCallbackUrl", "", "getCmd", "isCanceled", "", "onSendRequestFinish", "result", "onTaskFinish", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class HttpTask extends NetTask<HttpResult> {

    @NotNull
    private final HttpRequest httpRequest;

    @Nullable
    private Call realCall;

    @Nullable
    private final NetTask.ResponseProcessor<Response, HttpResult> responseProcessor;

    @Nullable
    private StatisticHandler statisticHandler;

    public /* synthetic */ HttpTask(INetClient iNetClient, HttpRequest httpRequest, NetTask.ResponseProcessor responseProcessor, StatisticHandler statisticHandler, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(iNetClient, httpRequest, responseProcessor, (i3 & 8) != 0 ? null : statisticHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTaskFinish$lambda$1$lambda$0(StatisticHandler it, HttpTask this$0) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.handleStatistic(this$0.getStatisticInfo());
    }

    @NotNull
    public final Request buildRequest() {
        return this.httpRequest.buildRequest(getStatisticInfo());
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask, com.tenpay.sdk.net.core.task.base.Task
    public void cancel() {
        Call call = this.realCall;
        if (call != null) {
            call.cancel();
        }
        super.cancel();
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask
    @NotNull
    public String getCallbackUrl() {
        return this.httpRequest.getOriginUrl();
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask
    @NotNull
    public String getCmd() {
        return this.httpRequest.getRequestUrl();
    }

    @NotNull
    public final HttpRequest getHttpRequest() {
        return this.httpRequest;
    }

    @Nullable
    public final Call getRealCall() {
        return this.realCall;
    }

    @Nullable
    public final NetTask.ResponseProcessor<Response, HttpResult> getResponseProcessor() {
        return this.responseProcessor;
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask, com.tenpay.sdk.net.core.task.base.Task
    public boolean isCanceled() {
        Call call = this.realCall;
        if (call != null) {
            return call.getCanceled();
        }
        return false;
    }

    public final void setRealCall(@Nullable Call call) {
        this.realCall = call;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpTask(@NotNull INetClient<HttpTask, HttpResult> client, @NotNull HttpRequest httpRequest, @Nullable NetTask.ResponseProcessor<Response, HttpResult> responseProcessor, @Nullable StatisticHandler statisticHandler) {
        super(client, httpRequest);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
        this.httpRequest = httpRequest;
        this.responseProcessor = responseProcessor;
        this.statisticHandler = statisticHandler;
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask
    @NotNull
    public HttpResult buildResult() {
        return new HttpResult(this.httpRequest.getOriginUrl(), this.httpRequest, false, false, null, null, null, null, getStatisticInfo(), 252, null);
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask
    public void onSendRequestFinish(@NotNull HttpResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        HttpStatisticMonitor.INSTANCE.onConnectFinish(getStatisticInfo(), result.getOkResponse());
        super.onSendRequestFinish((HttpTask) result);
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask
    public void onTaskFinish(@NotNull HttpResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        final StatisticHandler statisticHandler = this.statisticHandler;
        if (statisticHandler != null) {
            ThreadUtils.INSTANCE.runOnSubThread(new Runnable() { // from class: jy4.a
                @Override // java.lang.Runnable
                public final void run() {
                    HttpTask.onTaskFinish$lambda$1$lambda$0(StatisticHandler.this, this);
                }
            });
        }
        if (getStatus() == TaskStatus.Status.FAIL) {
            ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, tag(), "callback fail <=== " + result.getBizResponse() + " " + result.getResponseHeaders() + " " + result.toHttpString(), null, 4, null);
        }
        super.onTaskFinish((HttpTask) result);
    }
}
