package com.tencent.mobileqq.troop.createtroopblacklist.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.SecurityInfo;
import mqq.util.WeakReference;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ICreateTroopBlackListUtilApi extends QRouteApi {
    void onCreateTroopFailure(int i3, String str, SecurityInfo securityInfo, WeakReference<Activity> weakReference);

    void showCreateTroopSecurityDialog(Activity activity, a aVar);
}
