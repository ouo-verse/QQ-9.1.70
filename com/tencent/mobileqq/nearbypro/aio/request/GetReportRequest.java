package com.tencent.mobileqq.nearbypro.aio.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/request/GetReportRequest;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "", "getRequestByteData", "", "getCmdName", "T", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lfq4/c;", "req", "Lfq4/c;", "", "tinyId", "<init>", "(J)V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class GetReportRequest extends NearbyProBaseRequest {
    public static final int C2C_MESSAGE = 1;

    @NotNull
    private fq4.c req;

    public GetReportRequest(long j3) {
        fq4.c cVar = new fq4.c();
        cVar.f400333c = 1;
        cVar.f400332b = j3;
        np4.c cVar2 = new np4.c();
        com.tencent.mobileqq.nearbypro.request.a.c(cVar2);
        cVar.f400331a = cVar2;
        this.req = cVar;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        T t16 = (T) new fq4.d();
        try {
            T t17 = (T) fq4.d.c(convertInputStreamtoByteArray);
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
        return "trpc.lplan.safety_svr.Safety.SsoReportReq";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        byte[] byteArray = MessageNano.toByteArray(this.req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        return byteArray;
    }
}
