package com.tencent.mobileqq.nearbypro.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.pb.ByteStringMicro;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u0011\u0010\u0006\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseProxyRequest;", "Req", "Lcom/google/protobuf/nano/MessageNano;", "Rsp", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBasePBRequest;", "()V", "cmd", "", "getCmd", "()Ljava/lang/String;", "proxyed_method", "getProxyed_method", "proxyed_service", "getProxyed_service", "getRequestWrapper", "", "requestBizData", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public abstract class NearbyProBaseProxyRequest<Req extends MessageNano, Rsp extends MessageNano> extends NearbyProBasePBRequest<Req, Rsp> {
    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public final String getCmd() {
        return "trpc.lplan.proxy_svr.Proxy.SsoNearbyProxy";
    }

    @NotNull
    public abstract String getProxyed_method();

    @NotNull
    public abstract String getProxyed_service();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest, com.tencent.biz.richframework.network.request.VSBaseRequest
    @NotNull
    public byte[] getRequestWrapper(@Nullable ByteStringMicro requestBizData) {
        byte[] bArr;
        aq4.a aVar = new aq4.a();
        aVar.f26754b = getProxyed_service();
        aVar.f26755c = getProxyed_method();
        aVar.f26753a = a.a();
        if (requestBizData != null) {
            bArr = requestBizData.toByteArray();
        } else {
            bArr = null;
        }
        aVar.f26756d = bArr;
        return c.c(aVar);
    }
}
