package com.tencent.mobileqq.qqlivehall.iv.api.hall;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQIvLiveHallApi extends QRouteApi {
    boolean isTestEnv(Context context);

    void openQQIvLiveHall(Context context, a aVar);

    void setTestEnv(Context context, boolean z16);
}
