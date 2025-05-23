package com.tencent.mobileqq.nearbypro.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0002\u0010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0014R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00028\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/NearbyProBasePBRequest;", "Req", "Lcom/google/protobuf/nano/MessageNano;", "Rsp", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "()V", "cmd", "", "getCmd", "()Ljava/lang/String;", "pbReq", "getPbReq", "()Lcom/google/protobuf/nano/MessageNano;", "pbRspConstructor", "Lkotlin/Function0;", "getPbRspConstructor", "()Lkotlin/jvm/functions/Function0;", "decode", "T", "data", "", "([B)Ljava/lang/Object;", "getCmdName", "getRequestByteData", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public abstract class NearbyProBasePBRequest<Req extends MessageNano, Rsp extends MessageNano> extends NearbyProBaseRequest {
    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.google.protobuf.nano.MessageNano] */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] data) {
        Rsp invoke = getPbRspConstructor().invoke();
        try {
            c.b(invoke, data);
        } catch (InvalidProtocolBufferMicroException e16) {
            j.c().d(NearbyProBaseRequest.TAG, "decode error cmd: " + getCmd() + " msg: " + e16);
            if (j.a().debug()) {
                throw e16;
            }
        }
        return invoke;
    }

    @NotNull
    public abstract String getCmd();

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return getCmd();
    }

    @NotNull
    public abstract Req getPbReq();

    @NotNull
    public abstract Function0<Rsp> getPbRspConstructor();

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        return c.c(getPbReq());
    }
}
