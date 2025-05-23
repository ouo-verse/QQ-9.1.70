package com.tencent.mobileqq.participle.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IParticipleApi extends QRouteApi {
    void participleTheContent(AppInterface appInterface, String str);

    void participleTheContent(AppInterface appInterface, String str, String str2);
}
