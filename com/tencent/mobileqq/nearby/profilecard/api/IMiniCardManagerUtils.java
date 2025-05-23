package com.tencent.mobileqq.nearby.profilecard.api;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import u92.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniCardManagerUtils extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a(List<RecentBaseData> list);
    }

    boolean containsKey(String str);

    Object getMiniCard(String str);

    void handleMiniCardReq(List<RecentBaseData> list, b bVar, a aVar);

    void putMiniCard(String str, Object obj);
}
