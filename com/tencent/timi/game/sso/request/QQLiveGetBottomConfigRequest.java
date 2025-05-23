package com.tencent.timi.game.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.trpcprotocol.qlive.trpc_room_global_config.trpc_room_global_config.trpcRoomGlobalConfig$GetBottomConfigReq;
import com.tencent.trpcprotocol.qlive.trpc_room_global_config.trpc_room_global_config.trpcRoomGlobalConfig$GetBottomConfigRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0014J\b\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/sso/request/QQLiveGetBottomConfigRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "roomId", "", "roomType", "", "(JI)V", "decode", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getMainCmd", "", "getMessageNano", "Lcom/google/protobuf/nano/MessageNano;", "getRequestByteData", "getSubCmd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class QQLiveGetBottomConfigRequest<T> extends LiveBaseRequest<T> {
    private final long roomId;
    private final int roomType;

    public QQLiveGetBottomConfigRequest(long j3, int i3) {
        super(QQLiveBusinessConfig.QQLIVE_APP_ID);
        this.roomId = j3;
        this.roomType = i3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.pb.MessageMicro, T, com.tencent.trpcprotocol.qlive.trpc_room_global_config.trpc_room_global_config.trpcRoomGlobalConfig$GetBottomConfigRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            ?? r06 = (T) new trpcRoomGlobalConfig$GetBottomConfigRsp();
            r06.mergeFrom(convertInputStreamtoByteArray);
            return r06;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("VSRequest|QQLiveGetBottomConfigRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getMainCmd */
    public String getService() {
        return "trpc.qlive.trpc_room_global_config.TrpcRoomGlobalConfig";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        throw new RuntimeException("this request cannot use this method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    /* renamed from: getRequestByteData */
    public byte[] get$pbReqBytes() {
        trpcRoomGlobalConfig$GetBottomConfigReq trpcroomglobalconfig_getbottomconfigreq = new trpcRoomGlobalConfig$GetBottomConfigReq();
        trpcroomglobalconfig_getbottomconfigreq.room_id.set(this.roomId);
        trpcroomglobalconfig_getbottomconfigreq.room_type.set(this.roomType);
        byte[] byteArray = trpcroomglobalconfig_getbottomconfigreq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "GetBottomConfigReq().app\u2026)\n        }.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getSubCmd */
    public String getMethod() {
        return "GetBottomConfig";
    }
}
