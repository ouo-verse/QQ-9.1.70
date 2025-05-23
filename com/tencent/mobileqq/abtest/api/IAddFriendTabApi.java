package com.tencent.mobileqq.abtest.api;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes9.dex */
public interface IAddFriendTabApi extends QRouteApi {
    FrameLayout createPermissionSwitchForContacts(Context context);

    FrameLayout createPermissionSwitchGeneral(Context context);

    int getReportParam(FrameLayout frameLayout);

    boolean getSwitchExpRes(String str);

    int getSwitchResult(FrameLayout frameLayout);

    boolean isAddQZonePermissionSwitch(int i3);

    void showBlockLayoutOnly(FrameLayout frameLayout);
}
