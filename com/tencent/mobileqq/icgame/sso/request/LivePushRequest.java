package com.tencent.mobileqq.icgame.sso.request;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import ez0.a;
import ez0.b;
import ez0.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0019B3\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/icgame/sso/request/LivePushRequest;", "T", "Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "", "roomId", "J", "maxMsgNum", "cookie", "[B", "Lez0/a;", "ext", "Lez0/a;", "wantAppId", "<init>", "(Ljava/lang/String;JJ[BLez0/a;)V", "Companion", "a", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LivePushRequest<T> extends LiveBaseRequest<T> {

    @NotNull
    public static final String MAIN_CMD = "trpc.icggame.room_msg_read_proxy_svr.RoomMsgReadProxySvr";

    @NotNull
    public static final String SUB_CMD = "PullMsgProxy";

    @Nullable
    private final byte[] cookie;

    @Nullable
    private final a ext;
    private final long maxMsgNum;
    private final long roomId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePushRequest(@NotNull String wantAppId, long j3, long j16, @Nullable byte[] bArr, @Nullable a aVar) {
        super(wantAppId);
        Intrinsics.checkNotNullParameter(wantAppId, "wantAppId");
        this.roomId = j3;
        this.maxMsgNum = j16;
        this.cookie = bArr;
        this.ext = aVar;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            return (T) c.c(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferNanoException e16) {
            rt0.a.INSTANCE.i("ICGamePush|ICGameLivePushRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.icggame.room_msg_read_proxy_svr.RoomMsgReadProxySvr";
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        b bVar = new b();
        bVar.f397451a = this.roomId;
        bVar.f397454d = this.maxMsgNum;
        byte[] bArr = this.cookie;
        if (bArr == null) {
            bArr = WireFormatNano.EMPTY_BYTES;
        }
        bVar.f397452b = bArr;
        bVar.f397453c = this.ext;
        return bVar;
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "PullMsgProxy";
    }
}
