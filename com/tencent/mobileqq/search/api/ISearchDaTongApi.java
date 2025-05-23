package com.tencent.mobileqq.search.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.model.v;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchDaTongApi extends QRouteApi {
    String getDisplayType(v vVar);

    String getDocId(int i3, String str);

    String getFavoritDocType(v vVar);

    int getSearchHistoryType(Object obj);
}
