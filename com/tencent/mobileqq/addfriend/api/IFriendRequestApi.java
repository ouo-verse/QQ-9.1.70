package com.tencent.mobileqq.addfriend.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IFriendRequestApi extends QRouteApi {
    void friendRequestTag(AppInterface appInterface, long j3);
}
