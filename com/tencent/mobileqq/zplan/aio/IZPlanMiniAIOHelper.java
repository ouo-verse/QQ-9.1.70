package com.tencent.mobileqq.zplan.aio;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanMiniAIOHelper extends QRouteApi {
    Object getMiniAioObserver();

    void notifyUnreadCount();

    void openMiniMsgTab(Activity activity);
}
