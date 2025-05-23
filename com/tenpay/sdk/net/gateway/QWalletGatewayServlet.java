package com.tenpay.sdk.net.gateway;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$TransInfo;
import com.tenpay.sdk.net.core.log.DLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0088\u0001\u0010\u0013\u001a\u00020\u0012\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0010\b\u0001\u0010\u0004\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010H\u0086\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0085\u0001\u0010\u0013\u001a\u00020\u0012\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tenpay/sdk/net/gateway/QWalletGatewayServlet;", "", "Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "service", "method", "req", "", "needEncrypt", "silentMode", "needLoading", "", "Lcom/tencent/mobileqq/pb/qwallet/PayGatewayProto$TransInfo;", "transInfo", "Lpl2/o;", "bizCallback", "", "sendRequest", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;ZZZLjava/util/List;Lpl2/o;)V", "targetRsp", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;Lcom/tencent/mobileqq/pb/MessageMicro;ZZZLjava/util/List;Lpl2/o;)V", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class QWalletGatewayServlet {

    @NotNull
    public static final QWalletGatewayServlet INSTANCE = new QWalletGatewayServlet();

    QWalletGatewayServlet() {
    }

    public static /* synthetic */ void sendRequest$default(QWalletGatewayServlet qWalletGatewayServlet, String service, String method, MessageMicro req, boolean z16, boolean z17, boolean z18, List list, o bizCallback, int i3, Object obj) {
        boolean z19 = (i3 & 8) != 0 ? false : z16;
        boolean z26 = (i3 & 16) != 0 ? false : z17;
        boolean z27 = (i3 & 32) != 0 ? false : z18;
        List list2 = (i3 & 64) != 0 ? null : list;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(bizCallback, "bizCallback");
        Intrinsics.reifiedOperationMarker(4, "Rsp");
        Object newInstance = MessageMicro.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest(service, method, req, (MessageMicro) newInstance, z19, z26, z27, list2, bizCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <Req extends MessageMicro<Req>, Rsp extends MessageMicro<Rsp>> void sendRequest(String service, String method, Req req, boolean needEncrypt, boolean silentMode, boolean needLoading, List<PayGatewayProto$TransInfo> transInfo, o<Rsp> bizCallback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(bizCallback, "bizCallback");
        Intrinsics.reifiedOperationMarker(4, "Rsp");
        Object newInstance = MessageMicro.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        sendRequest(service, method, req, (MessageMicro) newInstance, needEncrypt, silentMode, needLoading, transInfo, bizCallback);
    }

    public final <Req extends MessageMicro<Req>, Rsp extends MessageMicro<Rsp>> void sendRequest(@NotNull String service, @NotNull String method, @NotNull Req req, @NotNull Rsp targetRsp, boolean needEncrypt, boolean silentMode, boolean needLoading, @Nullable List<PayGatewayProto$TransInfo> transInfo, @NotNull o<Rsp> bizCallback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(targetRsp, "targetRsp");
        Intrinsics.checkNotNullParameter(bizCallback, "bizCallback");
        try {
            QWalletGatewayBaseServlet.INSTANCE.sendRequest(service, method, req.toByteArray(), needEncrypt, silentMode, needLoading, transInfo, new QWalletGatewayServlet$sendRequest$1(targetRsp, bizCallback));
        } catch (Exception e16) {
            DLog.INSTANCE.w(QWalletGatewayBaseServlet.TAG, "req toByteArray error: " + req, e16);
            bizCallback.onFail(-1001, p.INSTANCE.a());
        }
    }
}
