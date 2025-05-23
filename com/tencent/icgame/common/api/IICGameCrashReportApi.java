package com.tencent.icgame.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import tt0.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IICGameCrashReportApi extends QRouteApi {
    boolean isICGameCrash(String str, String str2, String str3, long j3, String str4);

    void reportCrash(b bVar);
}
