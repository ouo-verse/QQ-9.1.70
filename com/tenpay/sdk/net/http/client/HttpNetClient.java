package com.tenpay.sdk.net.http.client;

import com.tenpay.sdk.net.core.client.INetClient;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import com.tenpay.sdk.net.core.task.NetTask;
import com.tenpay.sdk.net.http.request.HttpRequest;
import com.tenpay.sdk.net.http.result.HttpResult;
import com.tenpay.sdk.net.http.task.HttpTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tenpay/sdk/net/http/client/HttpNetClient;", "Lcom/tenpay/sdk/net/core/client/INetClient;", "Lcom/tenpay/sdk/net/http/task/HttpTask;", "Lcom/tenpay/sdk/net/http/result/HttpResult;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "sendRequest", "", "netTask", "Lcom/tenpay/sdk/net/core/task/NetTask;", "callback", "Lkotlin/Function1;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class HttpNetClient implements INetClient<HttpTask, HttpResult> {

    @NotNull
    private final OkHttpClient client;

    public HttpNetClient(@NotNull OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    @Override // com.tenpay.sdk.net.core.client.INetClient
    public void sendRequest(@NotNull NetTask<?> netTask, @NotNull Function1<? super HttpResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(netTask, "netTask");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(netTask instanceof HttpTask)) {
            return;
        }
        HttpTask httpTask = (HttpTask) netTask;
        HttpResult buildResult = httpTask.buildResult();
        HttpRequest httpRequest = httpTask.getHttpRequest();
        try {
            DLog dLog = DLog.INSTANCE;
            ILogAgent.DefaultImpls.d$default(dLog, netTask.tag(), "connect ===> [" + httpRequest.getRequestUrl() + "]", null, 4, null);
            Call newCall = this.client.newCall(((HttpTask) netTask).buildRequest());
            ((HttpTask) netTask).setRealCall(newCall);
            Response execute = newCall.execute();
            ILogAgent.DefaultImpls.i$default(dLog, netTask.tag(), "connect finish: " + execute.isSuccessful(), null, 4, null);
            buildResult.setOkResponse(execute);
            StatisticInfo statisticsInfo = buildResult.getStatisticsInfo();
            if (statisticsInfo != null) {
                statisticsInfo.setReceiveTime(System.currentTimeMillis());
            }
            NetTask.ResponseProcessor<Response, HttpResult> responseProcessor = ((HttpTask) netTask).getResponseProcessor();
            if (responseProcessor != null) {
                responseProcessor.processResponse(execute, buildResult);
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
