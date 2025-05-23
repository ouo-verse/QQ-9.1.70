package com.tencent.qzonehub.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.sim.SimInfo;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ISimManagerApi extends QRouteApi {
    ISimManagerApi createProduct(String str, int i3);

    SimInfo getDataSimInfo();

    void initAllInfo(Context context);
}
