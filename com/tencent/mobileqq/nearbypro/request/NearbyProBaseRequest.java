package com.tencent.mobileqq.nearbypro.request;

import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.fh;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\b&\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J#\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "Lcom/tencent/biz/richframework/network/request/VSBaseRequest;", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "requestBizData", "", "getRequestWrapper", "bytes", "", "", "parseResponseHeadInfo", "([B)[Ljava/lang/Object;", "<init>", "()V", "Companion", "a", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class NearbyProBaseRequest extends VSBaseRequest {

    @NotNull
    public static final String TAG = "NBP.Net";

    public NearbyProBaseRequest() {
        setRetryCount(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    @Nullable
    public byte[] getRequestWrapper(@Nullable ByteStringMicro requestBizData) {
        if (requestBizData == null) {
            return new byte[0];
        }
        return requestBizData.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest, com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public Object[] parseResponseHeadInfo(@Nullable byte[] bytes) {
        return new Object[]{0L, getSsoFailMsg(), fh.a(bytes)};
    }
}
