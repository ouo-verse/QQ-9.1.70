package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface IHippyCrashHandler extends QRouteApi {
    String getHippyStatus();

    boolean isSaveHippyStatus();

    void reportCrash(String str, String str2);
}
