package com.tencent.mobileqq.winkpublish.util;

import android.content.Context;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes21.dex */
public class FSTransUtils {
    public static String getAccount() {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static Context getContext() {
        return HostUIHelper.getInstance().getHostApplicationContext();
    }

    public static long getLongAccountUin() {
        return Long.valueOf(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()).longValue();
    }

    public static String getSubVersion() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getSubVersion();
    }
}
