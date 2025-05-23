package com.tencent.mobileqq.relation.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IFriendsUtils extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(String str, boolean z16);

        void b(boolean z16, long j3, String str);
    }

    BusinessObserver createFriendObserver(a aVar);

    int getNetworkType(int i3, int i16, int i17);
}
