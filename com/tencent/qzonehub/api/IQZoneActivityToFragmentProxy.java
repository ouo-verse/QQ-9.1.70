package com.tencent.qzonehub.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneActivityToFragmentProxy extends QRouteApi {
    Intent convertIntent(Context context, Intent intent, String str);

    boolean isConvertToFragment(String str);
}
