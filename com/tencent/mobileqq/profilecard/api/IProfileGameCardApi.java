package com.tencent.mobileqq.profilecard.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IProfileGameCardApi extends QRouteApi {
    void getAuthFromServer();

    Class getGameCardComponentClazz();

    void onInterestSwitchEditActivityCreate(Activity activity);

    void onInterestSwitchEditActivityDestroy();

    void showGameInfoActionSheet(boolean z16, Object obj);
}
