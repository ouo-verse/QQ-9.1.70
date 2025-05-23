package com.tencent.timi.game.sso.request;

import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.PremadesTeamServerOuterClass$GetAnchorRoomInfoReq;
import trpc.yes.common.PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/timi/game/sso/request/QQLiveGetAnchorRoomInfoRequest;", "T", "Lcom/tencent/timi/game/sso/request/QQLiveYesBaseRequest;", "roomId", "", "anchorUid", VirtualAppProxy.KEY_GAME_ID, "", "(JJI)V", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getHeaderCmd", "getRequestByteData", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class QQLiveGetAnchorRoomInfoRequest<T> extends QQLiveYesBaseRequest<T> {
    private final long anchorUid;
    private final int gameId;
    private final long roomId;

    public QQLiveGetAnchorRoomInfoRequest(long j3, long j16, int i3) {
        this.roomId = j3;
        this.anchorUid = j16;
        this.gameId = i3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.pb.MessageMicro, T, trpc.yes.common.PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            ?? r06 = (T) new PremadesTeamServerOuterClass$GetAnchorRoomInfoRsp();
            r06.mergeFrom(convertInputStreamtoByteArray);
            return r06;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("VSRequest|QQLiveGetAnchorRoomInfoRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.timi.game.sso.request.QQLiveYesBaseRequest
    public int getHeaderCmd() {
        return 315;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    public byte[] get$pbReqBytes() {
        PremadesTeamServerOuterClass$GetAnchorRoomInfoReq premadesTeamServerOuterClass$GetAnchorRoomInfoReq = new PremadesTeamServerOuterClass$GetAnchorRoomInfoReq();
        premadesTeamServerOuterClass$GetAnchorRoomInfoReq.room_id.set(this.roomId);
        premadesTeamServerOuterClass$GetAnchorRoomInfoReq.anchor_id.set("");
        premadesTeamServerOuterClass$GetAnchorRoomInfoReq.anchor_uid.set(this.anchorUid);
        premadesTeamServerOuterClass$GetAnchorRoomInfoReq.game_id.set(this.gameId);
        byte[] byteArray = premadesTeamServerOuterClass$GetAnchorRoomInfoReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "GetAnchorRoomInfoReq().a\u2026)\n        }.toByteArray()");
        return byteArray;
    }
}
