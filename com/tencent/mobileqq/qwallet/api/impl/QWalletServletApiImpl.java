package com.tencent.mobileqq.qwallet.api.impl;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qwallet.api.IQWalletServletApi;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014Ju\u0010\u0011\u001a\u00020\u0010\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/impl/QWalletServletApiImpl;", "Lcom/tencent/mobileqq/qwallet/api/IQWalletServletApi;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "service", "method", "req", "targetRsp", "", "needEncrypt", "silentMode", "needLoading", "Lpl2/o;", "rawCallback", "", "sendGatewayRequest", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;Lcom/tencent/mobileqq/pb/MessageMicro;ZZZLpl2/o;)V", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletServletApiImpl implements IQWalletServletApi {
    @Override // com.tencent.mobileqq.qwallet.api.IQWalletServletApi
    public <Req extends MessageMicro<Req>, Rsp extends MessageMicro<Rsp>> void sendGatewayRequest(@NotNull String service, @NotNull String method, @NotNull Req req, @NotNull Rsp targetRsp, boolean needEncrypt, boolean silentMode, boolean needLoading, @NotNull o<Rsp> rawCallback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(targetRsp, "targetRsp");
        Intrinsics.checkNotNullParameter(rawCallback, "rawCallback");
        QWalletGatewayServlet.INSTANCE.sendRequest(service, method, req, targetRsp, needEncrypt, silentMode, needLoading, null, rawCallback);
    }
}
