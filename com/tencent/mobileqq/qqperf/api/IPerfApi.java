package com.tencent.mobileqq.qqperf.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IPerfApi extends QRouteApi {
    void addFragmentForFilterFragment(String... strArr);

    String getGuardConfigID();

    String getSimpleClassName(String str);

    String getTopActivityName();

    void init();

    void traceEnd(String str);

    void traceStart(String str);
}
