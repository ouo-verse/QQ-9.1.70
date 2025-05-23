package com.tencent.timi.game.sso.request;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kp4.a;
import kp4.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u0011*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0012B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/timi/game/sso/request/QQLiveAnchorGetLiveStatRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "", "requestUid", "J", "<init>", "(J)V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveAnchorGetLiveStatRequest<T> extends LiveBaseRequest<T> {
    private final long requestUid;

    public QQLiveAnchorGetLiveStatRequest(long j3) {
        super(QQLiveBusinessConfig.QQLIVE_APP_ID);
        this.requestUid = j3;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            return (T) c.c(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferNanoException e16) {
            AegisLogger.INSTANCE.e("VSRequest|QQLiveAnchorGetLiveStatRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.ilive_av.ilive_tencent_cloud_proxy_svr.ilive_tencent_cloud_proxy_svr";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        a aVar = new a();
        aVar.f412845a = new long[]{this.requestUid};
        return aVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "GetLiveStat";
    }
}
