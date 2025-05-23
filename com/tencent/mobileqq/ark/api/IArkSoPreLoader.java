package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkSoPreLoader extends QRouteApi {
    String getLibJscPath();

    void setLibJscPath(String str);
}
