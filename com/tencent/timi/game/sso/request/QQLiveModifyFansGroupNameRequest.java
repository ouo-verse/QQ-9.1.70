package com.tencent.timi.game.sso.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.trpcprotocol.qlive.TrpcFansGroupOuterClass$ModifyGroupNameReq;
import com.tencent.trpcprotocol.qlive.TrpcFansGroupOuterClass$ModifyGroupNameRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\u0018\u0000 \u0011*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0012B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J!\u0010\u000b\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/timi/game/sso/request/QQLiveModifyFansGroupNameRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "getRequestByteData", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "name", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveModifyFansGroupNameRequest<T> extends LiveBaseRequest<T> {

    @NotNull
    public static final String TAG = "VSRequest|QQLiveModifyFansGroupNameRequest";

    @NotNull
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveModifyFansGroupNameRequest(@NotNull String name) {
        super(QQLiveBusinessConfig.QQLIVE_APP_ID);
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.pb.MessageMicro, T, com.tencent.trpcprotocol.qlive.TrpcFansGroupOuterClass$ModifyGroupNameRsp] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            ?? r06 = (T) new TrpcFansGroupOuterClass$ModifyGroupNameRsp();
            r06.mergeFrom(convertInputStreamtoByteArray);
            return r06;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e(TAG, "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.qlive.trpc_fans_group.trpc_fans_group";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        throw new RuntimeException("this request cannot use this method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public byte[] getRequestByteData() {
        TrpcFansGroupOuterClass$ModifyGroupNameReq trpcFansGroupOuterClass$ModifyGroupNameReq = new TrpcFansGroupOuterClass$ModifyGroupNameReq();
        trpcFansGroupOuterClass$ModifyGroupNameReq.new_group_name.set(this.name);
        byte[] byteArray = trpcFansGroupOuterClass$ModifyGroupNameReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "ModifyGroupNameReq().app\u2026)\n        }.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "ModifyGroupName";
    }
}
