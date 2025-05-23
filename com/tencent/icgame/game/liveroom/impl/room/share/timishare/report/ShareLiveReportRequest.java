package com.tencent.icgame.game.liveroom.impl.room.share.timishare.report;

import ap4.b;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import d32.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u0000 \u0010*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0011B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/share/timishare/report/ShareLiveReportRequest;", "T", "Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "resBytes", "decode", "([B)Ljava/lang/Object;", "shareToken", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class ShareLiveReportRequest<T> extends LiveBaseRequest<T> {

    @NotNull
    private final String shareToken;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareLiveReportRequest(@NotNull String shareToken) {
        super(c.f392737b.a().getAppId());
        Intrinsics.checkNotNullParameter(shareToken, "shareToken");
        this.shareToken = shareToken;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] resBytes) {
        try {
            return (T) b.c(resBytes);
        } catch (InvalidProtocolBufferNanoException e16) {
            a.INSTANCE.i("ICGameVSRequest|ICGameShareLiveReportRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.icggame.ark_msg.ArkMsg";
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        ap4.a aVar = new ap4.a();
        aVar.f26699a = this.shareToken;
        return aVar;
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "ConfirmShareOK";
    }
}
