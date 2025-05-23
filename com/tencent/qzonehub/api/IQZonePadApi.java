package com.tencent.qzonehub.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZonePadApi extends QRouteApi {
    int getScreenWidth(Context context);

    boolean isMomentSwitchClosed();

    boolean isPadOrFold();

    boolean shouldAdapt(Context context);
}
