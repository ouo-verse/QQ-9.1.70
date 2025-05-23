package com.tencent.mobileqq.qqlive.api.verified;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLiveDataStore extends QRouteApi {
    void clear();

    String getAppId();

    void setAppId(String str);
}
