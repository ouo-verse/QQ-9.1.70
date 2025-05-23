package com.qzone.reborn.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQZoneFriendFeedxApi extends QRouteApi {
    void saveLeaveTime(Long l3);

    boolean shouldRefresh();
}
