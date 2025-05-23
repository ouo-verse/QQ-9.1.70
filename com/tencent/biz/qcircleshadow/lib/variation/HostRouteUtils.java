package com.tencent.biz.qcircleshadow.lib.variation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostRouteUtils {
    public static String decodeRemoteCode(long j3) {
        return ((IQQBaseService) QRoute.api(IQQBaseService.class)).decodeRemoteCode(j3);
    }

    public static int encodeLocCode(String str) {
        return ((IQQBaseService) QRoute.api(IQQBaseService.class)).encodeLocCode(str);
    }

    public static Intent getQQBrowserDelegationActivityIntent(Context context, String str) {
        return ((IQQBaseService) QRoute.api(IQQBaseService.class)).getQQBrowserDelegationActivityIntent(context, str);
    }

    public static Intent getUnlockActivityIntent(Context context) {
        return ((IQQBaseService) QRoute.api(IQQBaseService.class)).startUnlockActivityIntent(context);
    }

    public static void openLocationSelectActivity(Context context, Bundle bundle) {
        ((IQQBaseService) QRoute.api(IQQBaseService.class)).openLocationSelectActivity(context, bundle);
    }

    public static void openSplashActivity(Context context, HashMap<String, String> hashMap) {
        ((IQQBaseService) QRoute.api(IQQBaseService.class)).openSplashActivity(context, hashMap);
    }

    public static void openTroopInfoActivity(Context context, Bundle bundle) {
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openTroopInfoActivity(context, bundle, 2);
    }
}
