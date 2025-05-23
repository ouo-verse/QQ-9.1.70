package com.tencent.timi.game.sso.request;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import mq4.a;
import mq4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/sso/request/QQLiveAnchorFansQQGroupEntryRequest;", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "Lmq4/b;", "", "getMainCmd", "getSubCmd", "Lmq4/a;", "getMessageNano", "T", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "", "_roomId", "J", "<init>", "(J)V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveAnchorFansQQGroupEntryRequest extends LiveBaseRequest<b> {
    private final long _roomId;

    public QQLiveAnchorFansQQGroupEntryRequest(long j3) {
        super(QQLiveBusinessConfig.QQLIVE_APP_ID);
        this._roomId = j3;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            return (T) b.c(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferNanoException e16) {
            AegisLogger.INSTANCE.e("VSRequest|QQLiveAnchorGetLiveStatRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.qlive.anchor_fans_group_server.FansGroup";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "GetFansGroupEntryByUser";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public a getMessageNano() {
        a aVar = new a();
        aVar.f417198a = this._roomId;
        return aVar;
    }
}
