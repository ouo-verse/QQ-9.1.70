package com.tencent.mobileqq.qwallet.api;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J{\u0010\u0011\u001a\u00020\u0010\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH&\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/IQWalletServletApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "service", "method", "req", "targetRsp", "", "needEncrypt", "silentMode", "needLoading", "Lpl2/o;", "rawCallback", "", "sendGatewayRequest", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;Lcom/tencent/mobileqq/pb/MessageMicro;ZZZLpl2/o;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQWalletServletApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        public static /* synthetic */ void a(IQWalletServletApi iQWalletServletApi, String str, String str2, MessageMicro messageMicro, MessageMicro messageMicro2, boolean z16, boolean z17, boolean z18, o oVar, int i3, Object obj) {
            boolean z19;
            boolean z26;
            boolean z27;
            if (obj == null) {
                if ((i3 & 16) != 0) {
                    z19 = false;
                } else {
                    z19 = z16;
                }
                if ((i3 & 32) != 0) {
                    z26 = false;
                } else {
                    z26 = z17;
                }
                if ((i3 & 64) != 0) {
                    z27 = false;
                } else {
                    z27 = z18;
                }
                iQWalletServletApi.sendGatewayRequest(str, str2, messageMicro, messageMicro2, z19, z26, z27, oVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendGatewayRequest");
        }
    }

    <Req extends MessageMicro<Req>, Rsp extends MessageMicro<Rsp>> void sendGatewayRequest(@NotNull String service, @NotNull String method, @NotNull Req req, @NotNull Rsp targetRsp, boolean needEncrypt, boolean silentMode, boolean needLoading, @NotNull o<Rsp> rawCallback);
}
