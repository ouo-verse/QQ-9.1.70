package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes2.dex */
public class GrsApi {
    private static final String TAG = "GrsApi";
    private static GrsClient grsClient;

    @Deprecated
    public static void ayncGetGrsUrl(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            Logger.w(TAG, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        GrsClient grsClient2 = grsClient;
        if (grsClient2 != null && str != null && str2 != null) {
            grsClient2.ayncGetGrsUrl(str, str2, iQueryUrlCallBack);
        } else {
            iQueryUrlCallBack.onCallBackFail(-6);
        }
    }

    @Deprecated
    public static void ayncGetGrsUrls(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(TAG, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        GrsClient grsClient2 = grsClient;
        if (grsClient2 != null && str != null) {
            grsClient2.ayncGetGrsUrls(str, iQueryUrlsCallBack);
        } else {
            iQueryUrlsCallBack.onCallBackFail(-6);
        }
    }

    @Deprecated
    public static void clearSp() {
        GrsClient grsClient2 = grsClient;
        if (grsClient2 == null) {
            Logger.w(TAG, "GrsApi.clearSp return because grsClient is null.");
        } else {
            grsClient2.clearSp();
        }
    }

    @Deprecated
    public static boolean forceExpire() {
        GrsClient grsClient2 = grsClient;
        if (grsClient2 == null) {
            Logger.w(TAG, "GrsApi.forceExpire return false because grsClient is null.");
            return false;
        }
        return grsClient2.forceExpire();
    }

    @Deprecated
    public static CountryCodeBean getCountryCode(Context context, boolean z16) {
        return a.a(context, z16);
    }

    @Deprecated
    public static int grsSdkInit(Context context, GrsBaseInfo grsBaseInfo) {
        Logger.w(TAG, "GrsApi.grsSdkInit is @Deprecated,  And Only Application Can Call Once");
        grsClient = new GrsClient(context, grsBaseInfo);
        return 0;
    }

    @Deprecated
    public static String synGetGrsUrl(String str, String str2) {
        GrsClient grsClient2 = grsClient;
        if (grsClient2 != null && str != null && str2 != null) {
            return grsClient2.synGetGrsUrl(str, str2);
        }
        Logger.w(TAG, "GrsApi.synGetGrsUrl method maybe grsSdkInit has not completed and grsClient is null.");
        return null;
    }

    @Deprecated
    public static Map<String, String> synGetGrsUrls(String str) {
        GrsClient grsClient2 = grsClient;
        if (grsClient2 != null && str != null) {
            return grsClient2.synGetGrsUrls(str);
        }
        Logger.w(TAG, "GrsApi.synGetGrsUrls method maybe grsSdkInit has not completed and grsClient is null.");
        return new HashMap();
    }
}
