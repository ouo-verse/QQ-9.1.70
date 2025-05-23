package com.tencent.mobileqq.qqecommerce.biz.qcircle;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\f\u001a\u00020\u0007H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/qcircle/ECQCircleGetDeviceInfoRequest;", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "()V", "decode", "T", "", "convertInputStreamtoByteArray", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getDeviceInfo", "getRequestByteData", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ECQCircleGetDeviceInfoRequest extends VSBaseRequest {
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(byte[] convertInputStreamtoByteArray) {
        return "";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "";
    }

    public final String getDeviceInfo() {
        String generateDeviceInfo = generateDeviceInfo();
        Intrinsics.checkNotNullExpressionValue(generateDeviceInfo, "generateDeviceInfo()");
        return generateDeviceInfo;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return new byte[0];
    }
}
