package com.tencent.now.linkpkanchorplay.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.n;
import g55.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/sso/request/GetAnchorPKHistoryRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "roomId", "", "extra", "", "(JLjava/lang/String;)V", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getMainCmd", "getMessageNano", "Lcom/google/protobuf/nano/MessageNano;", "getSubCmd", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class GetAnchorPKHistoryRequest<T> extends LiveBaseRequest<T> {

    @NotNull
    private final String extra;
    private final long roomId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetAnchorPKHistoryRequest(long j3, @NotNull String extra) {
        super(QQLiveBusinessConfig.QQLIVE_APP_ID);
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.roomId = j3;
        this.extra = extra;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            return (T) o.c(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("VSRequest|GetAnchorPKHistoryRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.qlive.link_play.LinkPlay";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        n nVar = new n();
        nVar.f401370a = this.roomId;
        nVar.f401371b = this.extra;
        return nVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "GetAnchorPKHistory";
    }
}
