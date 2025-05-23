package com.tencent.timi.game.sso.request;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yq4.d;
import yq4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0014B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/sso/request/QQLiveGetLikeRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "resBytes", "decode", "([B)Ljava/lang/Object;", "", "reqRoomId", "J", "reqProgramId", "Ljava/lang/String;", "<init>", "(JLjava/lang/String;)V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveGetLikeRequest<T> extends LiveBaseRequest<T> {

    @NotNull
    private final String reqProgramId;
    private final long reqRoomId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveGetLikeRequest(long j3, @NotNull String reqProgramId) {
        super(QQLiveBusinessConfig.QQLIVE_APP_ID);
        Intrinsics.checkNotNullParameter(reqProgramId, "reqProgramId");
        this.reqRoomId = j3;
        this.reqProgramId = reqProgramId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] resBytes) {
        try {
            return (T) e.c(resBytes);
        } catch (InvalidProtocolBufferNanoException e16) {
            AegisLogger.INSTANCE.e("VSRequest|QQLiveLikeRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.qlive.live_room_like_svr.LiveRoomLikeSvr";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        d dVar = new d();
        dVar.f451033a = this.reqRoomId;
        dVar.f451034b = this.reqProgramId;
        return dVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "UserLikeGetSum";
    }
}
