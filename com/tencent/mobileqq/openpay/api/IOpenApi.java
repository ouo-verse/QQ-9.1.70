package com.tencent.mobileqq.openpay.api;

import android.content.Intent;
import com.tencent.mobileqq.openpay.data.base.BaseApi;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IOpenApi {
    boolean execApi(BaseApi baseApi);

    boolean handleIntent(Intent intent, IOpenApiListener iOpenApiListener);

    boolean isMobileQQInstalled();

    boolean isMobileQQSupportApi(String str);
}
