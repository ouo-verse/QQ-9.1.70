package com.tenpay.sdk.net.sso;

import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$OriginCgiRsp;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.comm.SessionKey;
import com.tenpay.sdk.net.core.processor.EncryptProcessor;
import com.tenpay.sdk.net.core.task.NetTask;
import com.tenpay.sdk.net.gateway.TranInfoAbility;
import com.tenpay.sdk.net.gateway.data.TransInfoOutput;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tenpay/sdk/net/sso/GatewayNetClient$sendRequest$ssoCallback$1", "Lpl2/o;", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$OriginCgiRsp;", "Lcom/tenpay/sdk/net/gateway/TranInfoAbility;", "rsp", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "Lcom/tenpay/sdk/net/gateway/data/TransInfoOutput;", "transInfoOutput", "handleTranInfo", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class GatewayNetClient$sendRequest$ssoCallback$1 implements o<PayGatewayProto$OriginCgiRsp>, TranInfoAbility {
    final /* synthetic */ Function1<PaySsoResult, Unit> $callback;
    final /* synthetic */ String $cgi;
    final /* synthetic */ String $cmd;
    final /* synthetic */ EncryptProcessor.ProcessResult $encryptProcessResult;
    final /* synthetic */ NetTask<?> $netTask;
    final /* synthetic */ SessionKey $sessionKey;
    final /* synthetic */ GatewayNetClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public GatewayNetClient$sendRequest$ssoCallback$1(NetTask<?> netTask, GatewayNetClient gatewayNetClient, SessionKey sessionKey, EncryptProcessor.ProcessResult processResult, Function1<? super PaySsoResult, Unit> function1, String str, String str2) {
        this.$netTask = netTask;
        this.this$0 = gatewayNetClient;
        this.$sessionKey = sessionKey;
        this.$encryptProcessResult = processResult;
        this.$callback = function1;
        this.$cmd = str;
        this.$cgi = str2;
    }

    @Override // com.tenpay.sdk.net.gateway.TranInfoAbility
    public void handleTranInfo(@Nullable TransInfoOutput transInfoOutput) {
        PaySsoCookie.INSTANCE.saveFromResponse(this.$cgi, transInfoOutput);
    }

    @Override // pl2.k
    public void onFail(int errCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.w("QWalletHttp-GatewayCgi", 1, "send sso " + this.$cmd + " fail: " + errMsg);
        this.this$0.onSsoRequestFail((PaySsoTask) this.$netTask, -3001, null, this.$callback);
    }

    @Override // pl2.k
    public void onSuccess(@NotNull PayGatewayProto$OriginCgiRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        String stringUtf8 = rsp.data.get().toStringUtf8();
        QLog.d("QWalletHttp-GatewayCgi", 1, ((PaySsoTask) this.$netTask).getSsoRequest().getPaySsoCmd() + " onSuccess: rsp=" + stringUtf8);
        this.this$0.onRequestSuccess(stringUtf8, (PaySsoTask) this.$netTask, this.$sessionKey, this.$encryptProcessResult, this.$callback);
    }
}
