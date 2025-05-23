package com.tencent.qqlive.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import et3.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IAegisLogApi extends QRouteApi {
    @Deprecated
    void a(String str, int i3, String str2);

    @Deprecated
    void a(String str, int i3, String str2, a aVar);

    void a(String str, String str2);

    void a(String str, String str2, a aVar);

    void d(String str, String str2);

    @Deprecated
    void e(String str, int i3, String str2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th5);

    @Deprecated
    void i(String str, int i3, String str2);

    void i(String str, String str2);

    void reportEvent(String str, String str2, String str3);

    @Deprecated
    void w(String str, int i3, String str2);

    void w(String str, String str2);
}
