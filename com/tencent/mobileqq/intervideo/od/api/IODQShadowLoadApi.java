package com.tencent.mobileqq.intervideo.od.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = true)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IODQShadowLoadApi extends QRouteApi {
    boolean isInTroophomeworkRoom();
}
