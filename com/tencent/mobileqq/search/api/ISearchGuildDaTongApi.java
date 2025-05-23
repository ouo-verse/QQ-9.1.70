package com.tencent.mobileqq.search.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.model.v;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchGuildDaTongApi extends QRouteApi {
    void reportDaTongForGuildItem(View view, v vVar, int i3);

    void reportGuildSearchTitle(View view, Object obj);
}
