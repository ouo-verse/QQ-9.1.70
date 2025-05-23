package com.tencent.gamecenter.wadl.api;

import com.tencent.gamecenter.wadl.biz.entity.ApkInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"tool"})
/* loaded from: classes6.dex */
public interface IQQGameInterruptService extends QRouteApi {
    void checkConfigUpdate();

    ApkInfo matchByJointRegex(String str, String str2, String str3);
}
