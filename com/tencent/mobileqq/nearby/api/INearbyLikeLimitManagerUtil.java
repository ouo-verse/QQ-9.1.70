package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyLikeLimitManagerUtil extends QRouteApi {
    boolean isNeedNewLimitCheck(long j3);

    void report(Object obj, String str, String str2);

    void report(Object obj, String str, String str2, String str3, String str4, String str5, String str6);
}
