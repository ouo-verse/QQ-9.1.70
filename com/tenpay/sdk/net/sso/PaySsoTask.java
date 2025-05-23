package com.tenpay.sdk.net.sso;

import com.tenpay.sdk.net.core.client.INetClient;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.core.task.NetTask;
import com.tenpay.sdk.net.core.task.base.TaskStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tenpay/sdk/net/sso/PaySsoTask;", "Lcom/tenpay/sdk/net/core/task/NetTask;", "Lcom/tenpay/sdk/net/sso/PaySsoResult;", "client", "Lcom/tenpay/sdk/net/core/client/INetClient;", "ssoRequest", "Lcom/tenpay/sdk/net/sso/PaySsoRequest;", "(Lcom/tenpay/sdk/net/core/client/INetClient;Lcom/tenpay/sdk/net/sso/PaySsoRequest;)V", "getSsoRequest", "()Lcom/tenpay/sdk/net/sso/PaySsoRequest;", "buildResult", "getCallbackUrl", "", "getCmd", "onSendRequestFinish", "", "result", "onTaskFinish", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaySsoTask extends NetTask<PaySsoResult> {

    @NotNull
    private final PaySsoRequest ssoRequest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaySsoTask(@NotNull INetClient<PaySsoTask, PaySsoResult> client, @NotNull PaySsoRequest ssoRequest) {
        super(client, ssoRequest);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(ssoRequest, "ssoRequest");
        this.ssoRequest = ssoRequest;
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask
    @NotNull
    public String getCallbackUrl() {
        return this.ssoRequest.getOriginUrl();
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask
    @NotNull
    public String getCmd() {
        return this.ssoRequest.getOriginUrl();
    }

    @NotNull
    public final PaySsoRequest getSsoRequest() {
        return this.ssoRequest;
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask
    @NotNull
    public PaySsoResult buildResult() {
        return new PaySsoResult(this.ssoRequest.getOriginUrl(), this.ssoRequest, false, false, null, null, getStatisticInfo(), 60, null);
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask
    public void onSendRequestFinish(@NotNull PaySsoResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        getStatisticInfo().setConnectSucceed(result.getIsConnectSucceed());
        super.onSendRequestFinish((PaySsoTask) result);
    }

    @Override // com.tenpay.sdk.net.core.task.NetTask
    public void onTaskFinish(@NotNull PaySsoResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (getStatus() == TaskStatus.Status.FAIL) {
            ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, tag(), "callback fail <=== " + result.getBizResponse(), null, 4, null);
        }
        super.onTaskFinish((PaySsoTask) result);
    }
}
