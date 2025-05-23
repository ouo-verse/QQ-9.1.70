package com.tencent.mobileqq.troop.troopcard.api;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IVisitorTroopCardApi extends QRouteApi {
    Class<? extends QPublicBaseFragment> getVisitorTroopCardFragmentClass(int i3, boolean z16);
}
