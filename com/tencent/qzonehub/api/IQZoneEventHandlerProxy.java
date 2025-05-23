package com.tencent.qzonehub.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneEventHandlerProxy extends QRouteApi {
    boolean handleActivityEvent(Object obj, int i3, int i16, Intent intent);
}
