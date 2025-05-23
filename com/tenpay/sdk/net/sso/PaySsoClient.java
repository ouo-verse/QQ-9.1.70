package com.tenpay.sdk.net.sso;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.callback.NetCallback;
import com.tenpay.sdk.net.core.client.INetClient;
import com.tenpay.sdk.net.core.dispatcher.TaskDispatcher;
import com.tenpay.sdk.net.core.result.NetResult;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import com.tenpay.sdk.net.core.task.base.Task;
import com.tenpay.sdk.net.sso.PaySsoCmd;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J%\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u00a2\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tenpay/sdk/net/sso/PaySsoClient;", "", "()V", "dispatcher", "Lcom/tenpay/sdk/net/core/dispatcher/TaskDispatcher;", "gatewayClient", "Lcom/tenpay/sdk/net/sso/GatewayNetClient;", "hbProxyClient", "Lcom/tenpay/sdk/net/sso/HbProxyNetClient;", "newInstance", "aliasName", "", "maxConnection", "", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "newInstance$qwallet_impl_release", "send", "Lcom/tenpay/sdk/net/core/task/base/Task;", Const.BUNDLE_KEY_REQUEST, "Lcom/tenpay/sdk/net/sso/PaySsoRequest;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaySsoClient {

    @NotNull
    public static final String TAG = "QWalletHttp-PaySsoClient";
    private TaskDispatcher dispatcher;

    @NotNull
    private final HbProxyNetClient hbProxyClient = new HbProxyNetClient();

    @NotNull
    private final GatewayNetClient gatewayClient = new GatewayNetClient();

    @NotNull
    public final PaySsoClient newInstance$qwallet_impl_release(@NotNull String aliasName, int maxConnection, @NotNull ThreadPoolExecutor threadPoolExecutor) {
        Intrinsics.checkNotNullParameter(aliasName, "aliasName");
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "threadPoolExecutor");
        this.dispatcher = new TaskDispatcher(aliasName, maxConnection, maxConnection, threadPoolExecutor);
        return this;
    }

    @NotNull
    public final Task send(@NotNull PaySsoRequest request) throws IllegalArgumentException {
        INetClient iNetClient;
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.getPaySsoCmd() instanceof PaySsoCmd.Gateway) {
            iNetClient = this.gatewayClient;
        } else {
            iNetClient = this.hbProxyClient;
        }
        PaySsoTask paySsoTask = new PaySsoTask(iNetClient, request);
        StatisticInfo statisticInfo = paySsoTask.getStatisticInfo();
        TaskDispatcher taskDispatcher = this.dispatcher;
        TaskDispatcher taskDispatcher2 = null;
        if (taskDispatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatcher");
            taskDispatcher = null;
        }
        statisticInfo.setConcurrentCount(taskDispatcher.runningCallsCount());
        try {
            TaskDispatcher taskDispatcher3 = this.dispatcher;
            if (taskDispatcher3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dispatcher");
            } else {
                taskDispatcher2 = taskDispatcher3;
            }
            taskDispatcher2.enqueue(paySsoTask);
        } catch (RejectedExecutionException e16) {
            QLog.e(TAG, 1, "send error: ", e16);
            NetCallback<NetResult> netCallback = request.getNetCallback();
            if (netCallback != null) {
                netCallback.onNetFailed(request.getOriginUrl(), paySsoTask.buildResult());
            }
        }
        return paySsoTask;
    }
}
