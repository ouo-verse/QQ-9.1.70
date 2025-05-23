package com.tencent.mobileqq.search.api;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.model.u;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchGameFriendApi extends QRouteApi {
    Fragment getSearchFragment(u uVar);

    void onDestroy();

    void startSearch(String str);
}
