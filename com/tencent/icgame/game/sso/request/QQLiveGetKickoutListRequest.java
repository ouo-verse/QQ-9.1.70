package com.tencent.icgame.game.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$BatchGetKickOutUserReq;
import com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$BatchGetKickOutUserRsp;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/icgame/game/sso/request/QQLiveGetKickoutListRequest;", "T", "Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", "roomId", "", "anchorUid", "pageSize", "", "(JJI)V", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getMainCmd", "", "getMessageNano", "Lcom/google/protobuf/nano/MessageNano;", "getRequestByteData", "getSubCmd", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class QQLiveGetKickoutListRequest<T> extends LiveBaseRequest<T> {
    private final long anchorUid;
    private final int pageSize;
    private final long roomId;

    public QQLiveGetKickoutListRequest(long j3, long j16, int i3) {
        super("1078");
        this.roomId = j3;
        this.anchorUid = j16;
        this.pageSize = i3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.pb.MessageMicro, T, com.tencent.icgame.trpcprotocol.qlive.livechatcheck.LiveChatCheck$BatchGetKickOutUserRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            ?? r06 = (T) new LiveChatCheck$BatchGetKickOutUserRsp();
            r06.mergeFrom(convertInputStreamtoByteArray);
            return r06;
        } catch (Exception e16) {
            a.INSTANCE.i("ICGameVSRequest|QQLiveGetKickoutListRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.qlive.ilive_chat_svr_mod.ChatSvrMod";
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        throw new RuntimeException("this request cannot use this method");
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        LiveChatCheck$BatchGetKickOutUserReq liveChatCheck$BatchGetKickOutUserReq = new LiveChatCheck$BatchGetKickOutUserReq();
        liveChatCheck$BatchGetKickOutUserReq.roomid.set(this.roomId);
        liveChatCheck$BatchGetKickOutUserReq.master_tinyid.set(this.anchorUid);
        liveChatCheck$BatchGetKickOutUserReq.page_num.set(this.pageSize);
        liveChatCheck$BatchGetKickOutUserReq.qunatity.set(20);
        byte[] byteArray = liveChatCheck$BatchGetKickOutUserReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "BatchGetKickOutUserReq()\u2026)\n        }.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "BatchGetKickOutUser";
    }
}
