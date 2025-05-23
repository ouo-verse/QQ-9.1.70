package com.tencent.qqprotect.qsec.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IO3CollectDataApi extends QRouteApi {
    String collectInfo();

    void sampling(Context context, String str, String str2);

    void startCollectInfo();

    void stopCollectInfo();
}
