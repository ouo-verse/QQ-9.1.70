package com.tencent.mobileqq.nearbypro.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.fh;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J!\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0002\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseOIDBRequest;", "Req", "Lcom/google/protobuf/nano/MessageNano;", "Rsp", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBasePBRequest;", "()V", "cmd", "", "getCmd", "()Ljava/lang/String;", "oidb_cmd", "", "getOidb_cmd", "()I", "oidb_service_type", "getOidb_service_type", "getRequestWrapper", "", "requestBizData", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "parseResponseHeadInfo", "", "", "bytes", "([B)[Ljava/lang/Object;", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public abstract class NearbyProBaseOIDBRequest<Req extends MessageNano, Rsp extends MessageNano> extends NearbyProBasePBRequest<Req, Rsp> {
    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBasePBRequest
    @NotNull
    public final String getCmd() {
        int checkRadix;
        int oidb_cmd = getOidb_cmd();
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(oidb_cmd, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return "OidbSvcTrpcTcp.0x" + num + "_" + getOidb_service_type();
    }

    public abstract int getOidb_cmd();

    public abstract int getOidb_service_type();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest, com.tencent.biz.richframework.network.request.VSBaseRequest
    @NotNull
    public byte[] getRequestWrapper(@Nullable ByteStringMicro requestBizData) {
        byte[] bArr;
        int oidb_cmd = getOidb_cmd();
        int oidb_service_type = getOidb_service_type();
        if (requestBizData != null) {
            bArr = requestBizData.toByteArray();
        } else {
            bArr = null;
        }
        byte[] byteArray = c.a(oidb_cmd, oidb_service_type, bArr).toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "makeOIDBPkg(oidb_cmd, oi\u2026yteArray()).toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.mobileqq.nearbypro.request.NearbyProBaseRequest, com.tencent.biz.richframework.network.request.VSBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public Object[] parseResponseHeadInfo(@Nullable byte[] bytes) {
        oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(fh.a(bytes));
        return new Object[]{Long.valueOf(mergeFrom.uint32_result.get()), mergeFrom.str_error_msg.get(), mergeFrom.bytes_bodybuffer.get().toByteArray()};
    }
}
