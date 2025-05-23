package com.tencent.statemachine.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes26.dex */
public interface IStateManager extends QRouteApi {
    void addMainStateObserver(StateObserver stateObserver);

    void onMainDrawerChange(boolean z16);

    void onMainFragmentChange(int i3, boolean z16);

    void onMainTabChange(int i3);

    void removeMainStateObserver(StateObserver stateObserver);
}
