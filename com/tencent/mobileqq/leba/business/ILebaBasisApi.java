package com.tencent.mobileqq.leba.business;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface ILebaBasisApi extends QRouteApi {
    boolean isLocaleUpdatedByUser();

    void jumpByScheme(Context context, String str);
}
