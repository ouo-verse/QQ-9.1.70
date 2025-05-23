package com.tencent.mobileqq.icgame.sso.request;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.data.common.UserFileds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mz0.c;
import mz0.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u0012*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0013B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/icgame/sso/request/GetUserInfoRequest;", "T", "Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "", "wantUid", "J", "wantAppId", "<init>", "(Ljava/lang/String;J)V", "Companion", "a", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class GetUserInfoRequest<T> extends LiveBaseRequest<T> {
    private final long wantUid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUserInfoRequest(@NotNull String wantAppId, long j3) {
        super(wantAppId);
        Intrinsics.checkNotNullParameter(wantAppId, "wantAppId");
        this.wantUid = j3;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            return (T) d.c(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferNanoException e16) {
            a.INSTANCE.i("ICGameVSRequest|ICGameGetUserInfoRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.qlive.trpc_user_info_svr.trpc_user_info_svr";
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        c cVar = new c();
        cVar.f417847a = this.wantUid;
        cVar.f417848b = new int[]{UserFileds.Fileds_Base.ordinal(), UserFileds.Fileds_Medal.ordinal()};
        return cVar;
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "GetUserInfo";
    }
}
