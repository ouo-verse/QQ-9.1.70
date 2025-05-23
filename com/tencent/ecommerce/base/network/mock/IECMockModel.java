package com.tencent.ecommerce.base.network.mock;

import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/network/mock/IECMockModel;", "", "", "reqData", "", "codingType", "Lcom/tencent/ecommerce/base/network/api/e;", "mockResponse", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface IECMockModel {
    ECRemoteResponse mockResponse(byte[] reqData, int codingType);
}
