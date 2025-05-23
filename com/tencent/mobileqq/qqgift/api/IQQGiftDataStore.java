package com.tencent.mobileqq.qqgift.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGiftDataStore extends QRouteApi {
    void clear();

    String getSceneId();

    void setSceneId(String str);
}
