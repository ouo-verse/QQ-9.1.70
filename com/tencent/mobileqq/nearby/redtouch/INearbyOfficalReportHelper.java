package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyOfficalReportHelper extends QRouteApi {
    void reportLebaRedDotEvent(Object obj, String str, String str2);

    void reportRedDotReceive(Object obj, Object obj2);
}
