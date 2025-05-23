package com.tencent.mobileqq.troop.troopapps.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ITroopCardAppInfoHelperApi extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void onFailed();

        void onSuccess(ArrayList<TroopAppInfo> arrayList);
    }

    void destroy();

    boolean getAppInfoBriefList(String str, a aVar);

    boolean getAppInfoBriefList(String str, a aVar, boolean z16);

    void init(AppRuntime appRuntime);
}
