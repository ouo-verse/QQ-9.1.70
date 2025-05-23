package com.tencent.qzonehub.api.report.lp;

import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.report.lp.LpReportNewIntent;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ILpReportUtils extends QRouteApi {
    public static final int DC00518_NETWORK_TYPE_2G = 2;
    public static final int DC00518_NETWORK_TYPE_3G = 3;
    public static final int DC00518_NETWORK_TYPE_4G = 4;
    public static final int DC00518_NETWORK_TYPE_5G = 5;
    public static final int DC00518_NETWORK_TYPE_CABLE = 6;
    public static final int DC00518_NETWORK_TYPE_UNKNOWN = 9;
    public static final int DC00518_NETWORK_TYPE_WIFI = 1;

    int convertNetworkTypeToFitInDc00518(int i3);

    int detectLoginFromInIntent(Intent intent);

    String getAPN();

    String getAccount();

    String getAlphaConfig(String str, String str2, String str3);

    int getChatSettingForTroopQZONEPHOTOCode();

    String getDeviceInfor();

    String getIMEI();

    String getIMSI();

    String getInternalCacheDir();

    long getLongAccountUin();

    String getModuleFilePath(String str);

    int getNetworkType();

    String getQUA3();

    String getReportUserType(BaseQQAppInterface baseQQAppInterface);

    long getServerTimeMillis();

    SharedPreferences getSharedPreferences(String str);

    String getVersionForHabo();

    int getnetworkType();

    boolean isBackgroundPause();

    boolean isWap();

    boolean loadModule(String str, ClassLoader classLoader, boolean z16, boolean z17);

    void showToast(String str, int i3);

    void startServlet(LpReportNewIntent lpReportNewIntent);
}
