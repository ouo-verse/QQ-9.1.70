package com.huawei.hms.common;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface HuaweiApiInterface {
    void setHostContext(Context context);

    void setInnerHms();

    void setSubAppId(String str) throws ApiException;
}
