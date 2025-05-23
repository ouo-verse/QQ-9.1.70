package com.tencent.mobileqq.intervideo.huayang;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IHuayangCrashReport extends QRouteApi {
    void handleReport(Throwable th5);

    void report(Throwable th5);
}
