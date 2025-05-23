package com.tencent.mobileqq.troop.troopmanager.api;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopManagerFragmentApi extends QRouteApi {
    Class<? extends QPublicBaseFragment> getTroopBindGuildListFragmentClass();

    Class<? extends QPublicBaseFragment> getTroopJumpQRPageFragmentClass();

    Class<? extends QPublicBaseFragment> getTroopMemberDistinctFragmentClass();
}
