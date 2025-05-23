package com.tencent.mobileqq.nearbypro.request;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/request/ErrorRequest;", "Lcom/tencent/mobileqq/nearbypro/request/NearbyProBaseRequest;", "()V", "decode", "T", "data", "", "([B)Ljava/lang/Object;", "getCmdName", "", "getRequestByteData", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class ErrorRequest extends NearbyProBaseRequest {

    @NotNull
    public static final ErrorRequest INSTANCE = new ErrorRequest();

    ErrorRequest() {
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    public String getCmdName() {
        return "ErrorRequest";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @NotNull
    protected byte[] getRequestByteData() {
        return new byte[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public <T> T decode(@Nullable byte[] data) {
        return data;
    }
}
