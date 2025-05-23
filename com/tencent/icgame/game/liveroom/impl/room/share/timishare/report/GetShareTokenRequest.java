package com.tencent.icgame.game.liveroom.impl.room.share.timishare.report;

import ap4.d;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import d32.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u0011*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0012B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/share/timishare/report/GetShareTokenRequest;", "T", "Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "resBytes", "decode", "([B)Ljava/lang/Object;", "", "shareRoomId", "J", "<init>", "(J)V", "d", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class GetShareTokenRequest<T> extends LiveBaseRequest<T> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final a f115646d = new a(null);
    private final long shareRoomId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/share/timishare/report/GetShareTokenRequest$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public GetShareTokenRequest(long j3) {
        super(c.f392737b.a().getAppId());
        this.shareRoomId = j3;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] resBytes) {
        try {
            return (T) d.c(resBytes);
        } catch (InvalidProtocolBufferNanoException e16) {
            rt0.a.INSTANCE.i("ICGameVSRequest|GetShareTokenRequest", "decode", "error, ", e16);
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
        ap4.c cVar = new ap4.c();
        cVar.f26700a = this.shareRoomId;
        return cVar;
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "GetShareMsgToken";
    }
}
