package com.tencent.relation.common.api;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRelationNTRecentListApi extends QRouteApi {
    int getChatTypeForRecentList(int i3);

    void getRecentList(AppRuntime appRuntime, RecentContactListener recentContactListener, boolean z16);

    List<RecentUser> getRecentListFromCache();

    ArrayList<Object> getRecentListFromCacheInObject();
}
