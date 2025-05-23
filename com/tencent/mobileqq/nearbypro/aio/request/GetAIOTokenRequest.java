package com.tencent.mobileqq.nearbypro.aio.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/request/GetAIOTokenRequest;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lfq4/a;", "req", "Lfq4/a;", "tinyId", "<init>", "(Ljava/lang/String;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class GetAIOTokenRequest extends NearbyProBaseRequest {

    @NotNull
    private fq4.a req;

    public GetAIOTokenRequest(@NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        fq4.a aVar = new fq4.a();
        aVar.f400328b = Long.parseLong(tinyId);
        np4.c cVar = new np4.c();
        com.tencent.mobileqq.nearbypro.request.a.c(cVar);
        aVar.f400327a = cVar;
        this.req = aVar;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        T t16 = (T) new fq4.b();
        try {
            T t17 = (T) fq4.b.c(convertInputStreamtoByteArray);
            Intrinsics.checkNotNullExpressionValue(t17, "parseFrom(convertInputStreamtoByteArray)");
            return t17;
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            return t16;
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "trpc.lplan.safety_svr.Safety.SsoGetC2CToken";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = MessageNano.toByteArray(this.req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        return byteArray;
    }
}
