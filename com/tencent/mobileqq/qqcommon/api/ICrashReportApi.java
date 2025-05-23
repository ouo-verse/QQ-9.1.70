package com.tencent.mobileqq.qqcommon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ICrashReportApi extends QRouteApi {
    void postException(int i3, String str, String str2, String str3, Map<String, String> map);

    void postException(Thread thread, int i3, String str, String str2, String str3, Map<String, String> map);
}
