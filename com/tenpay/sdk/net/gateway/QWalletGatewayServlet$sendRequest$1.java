package com.tenpay.sdk.net.gateway;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tenpay.sdk.net.core.log.DLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.g;
import pl2.i;
import pl2.k;
import pl2.o;
import pl2.p;

/* JADX WARN: Incorrect field signature: TRsp; */
/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tenpay/sdk/net/gateway/QWalletGatewayServlet$sendRequest$1", "Lpl2/k;", "", "Lpl2/i;", "rsp", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "Lpl2/g;", "getAbility", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class QWalletGatewayServlet$sendRequest$1 implements k<byte[]>, i {
    final /* synthetic */ o<Rsp> $bizCallback;
    final /* synthetic */ MessageMicro $targetRsp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Incorrect types in method signature: (TRsp;Lpl2/o<TRsp;>;)V */
    public QWalletGatewayServlet$sendRequest$1(MessageMicro messageMicro, o oVar) {
        this.$targetRsp = messageMicro;
        this.$bizCallback = oVar;
    }

    @Override // pl2.i
    @Nullable
    public g getAbility() {
        Object obj = this.$bizCallback;
        if (obj instanceof g) {
            return (g) obj;
        }
        return null;
    }

    @Override // pl2.k
    public void onFail(int errCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.$bizCallback.onFail(errCode, errMsg);
    }

    @Override // pl2.k
    public void onSuccess(@NotNull byte[] rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        try {
            MessageMicro mergeFrom = this.$targetRsp.mergeFrom(rsp);
            Intrinsics.checkNotNullExpressionValue(mergeFrom, "targetRsp.mergeFrom(rsp)");
            this.$bizCallback.onSuccess((o<Rsp>) mergeFrom);
        } catch (Exception e16) {
            DLog.INSTANCE.w(QWalletGatewayBaseServlet.TAG, "merge rsp error: " + this.$targetRsp, e16);
            this.$bizCallback.onFail(-1003, p.INSTANCE.a());
        }
    }
}
