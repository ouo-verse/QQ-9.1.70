package com.tencent.icgame.game.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.icgame.trpcprotocol.qlive.TrpcFansGroupOuterClass$GetFansGroupInfoReq;
import com.tencent.icgame.trpcprotocol.qlive.TrpcFansGroupOuterClass$GetFansGroupInfoRsp;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J!\u0010\u000b\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/icgame/game/sso/request/QQLiveFansGroupInfoRequest;", "T", "Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "getRequestByteData", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "", "anchorUid", "J", "<init>", "(J)V", "Companion", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class QQLiveFansGroupInfoRequest<T> extends LiveBaseRequest<T> {

    @NotNull
    public static final String TAG = "ICGameVSRequest|ICGameFansGroupInfo";
    private final long anchorUid;

    public QQLiveFansGroupInfoRequest(long j3) {
        super("1078");
        this.anchorUid = j3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.pb.MessageMicro, T, com.tencent.icgame.trpcprotocol.qlive.TrpcFansGroupOuterClass$GetFansGroupInfoRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            ?? r06 = (T) new TrpcFansGroupOuterClass$GetFansGroupInfoRsp();
            r06.mergeFrom(convertInputStreamtoByteArray);
            return r06;
        } catch (Exception e16) {
            a.INSTANCE.i(TAG, "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.qlive.trpc_fans_group.trpc_fans_group";
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        throw new RuntimeException("this request cannot use this method");
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        TrpcFansGroupOuterClass$GetFansGroupInfoReq trpcFansGroupOuterClass$GetFansGroupInfoReq = new TrpcFansGroupOuterClass$GetFansGroupInfoReq();
        trpcFansGroupOuterClass$GetFansGroupInfoReq.anchor_uid.set(this.anchorUid);
        byte[] byteArray = trpcFansGroupOuterClass$GetFansGroupInfoReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "GetFansGroupInfoReq().ap\u2026)\n        }.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "GetFansGroupInfo";
    }
}
