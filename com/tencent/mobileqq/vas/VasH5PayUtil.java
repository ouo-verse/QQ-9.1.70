package com.tencent.mobileqq.vas;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.vas.pay.VasH5PayConstants;
import com.tencent.mobileqq.vas.pay.api.IVasH5PayAdapter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import mqq.app.MobileQQ;

/* loaded from: classes20.dex */
public class VasH5PayUtil {
    public static final String BIG_VIP_H5_PAY_URL = "https://h5.qzone.qq.com/vip/payBigDialog/{openUin}/{openMonth}?_wv={wv}&_wwv=13&aid={aid}";
    public static final String H5_PAY_BASE_URL = "https://h5.vip.qq.com/p/pay/index";
    public static final String H5_PAY_URL = "https://h5.vip.qq.com/p/pay/index?_wv=524289&_fv=0&aid=";
    private static final String TAG = "VasH5PayUtil";
    private static Long mLastRequestTime = 0L;
    public static String SENDUIN = "sendUin";
    public static String OPENMONTH = "openMonth";
    public static String AID = "aid";
    public static String OFFERID = "offerId";
    public static String SERVICENAME = "serviceName";
    public static String SERVICECODE = "serviceCode";
    public static String VIPTYPE = "type";
    public static String CALLBACKSN = "callbacksn";
    public static String PAY_URL = "payUrl";

    private static StringBuilder getH5PayUrlString(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder(H5_PAY_URL);
        sb5.append(str);
        sb5.append("&type=" + str2);
        sb5.append("&month=" + str3);
        return sb5;
    }

    public static String getOpenClubPayParamForGrayTips(String str, int i3, int i16, int i17, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("|");
        sb5.append(i3);
        sb5.append("|");
        sb5.append(i16);
        sb5.append("|");
        sb5.append(i17);
        sb5.append("|");
        sb5.append(str2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getOpenVipParam result = " + sb5.toString());
        }
        return sb5.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0046, code lost:
    
        if (r20.equals(r2 + r1) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void openClubPay(Context context, String str, int i3, String str2, String str3, String str4, String str5) {
        String svipCallbackSN = ((IVasH5PayAdapter) QRoute.api(IVasH5PayAdapter.class)).getSvipCallbackSN();
        String diyCardH5Pay = ((IVasH5PayAdapter) QRoute.api(IVasH5PayAdapter.class)).getDiyCardH5Pay();
        if (!TextUtils.isEmpty(str5)) {
            if (!str5.equals(svipCallbackSN + diyCardH5Pay)) {
            }
            openH5Pay(context, str, str3, i3, false, false, "hfpay");
            return;
        }
        openH5Pay(context, str, str3, i3, false, false);
    }

    public static void openClubPayWithParam(String str, Context context) {
        boolean z16;
        boolean z17;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 2, "openClubPayWithParam param is empty");
            return;
        }
        if (context == null) {
            QLog.e(TAG, 2, "openClubPayWithParam context is null");
            return;
        }
        String[] split = str.split("\\|");
        if (split.length != 5) {
            QLog.e(TAG, 2, "openClubPayWithParam param not correct: " + split);
            return;
        }
        String str2 = split[0];
        String str3 = split[1];
        String str4 = split[2];
        String str5 = split[3];
        String str6 = split[4];
        if (str3.equals("1")) {
            z16 = true;
        } else if (str3.equals("0")) {
            z16 = false;
        } else {
            QLog.e(TAG, 2, "openClubPayWithParam param hardType not correct: " + str3);
            return;
        }
        if (str5.equals("1")) {
            z17 = true;
        } else if (str5.equals("0")) {
            z17 = false;
        } else {
            QLog.e(TAG, 2, "openClubPayWithParam param hardMonth not correct: " + str5);
            return;
        }
        if (!TextUtils.isDigitsOnly(str4)) {
            QLog.e(TAG, 2, "openClubPayWithParam param openMonth not correct: " + str4);
            return;
        }
        openH5Pay(context, str6, str2, Integer.parseInt(str4), z17, z16);
    }

    public static void openH5Pay(Context context, String str, String str2, int i3, boolean z16, boolean z17) {
        openH5Pay(context, str, str2, i3, z16, z17, "");
    }

    public static void openH5PayByURL(Context context, String str) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, VasH5PayConstants.ROUTE_NAME);
        activityURIRequest.extra().putString("url", str);
        if (!(context instanceof Activity)) {
            activityURIRequest.setFlags(268435456);
        }
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    public static void openH5PayByURLForResult(Activity activity, String str, int i3) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, VasH5PayConstants.ROUTE_NAME);
        activityURIRequest.setRequestCode(i3);
        activityURIRequest.extra().putString("url", str);
        if (!(activity instanceof Activity)) {
            activityURIRequest.setFlags(268435456);
        }
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    public static void openH5PayForResult(Activity activity, String str, String str2, String str3, int i3) {
        if (System.currentTimeMillis() - mLastRequestTime.longValue() > 1000) {
            mLastRequestTime = Long.valueOf(System.currentTimeMillis());
            StringBuilder h5PayUrlString = getH5PayUrlString(str, str2, str3);
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, VasH5PayConstants.ROUTE_NAME);
            activityURIRequest.setRequestCode(i3);
            activityURIRequest.extra().putString("url", h5PayUrlString.toString());
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        }
    }

    public static void openH5Pay(Context context, String str, String str2, int i3, boolean z16, boolean z17, String str3) {
        openH5Pay(context, str, str2, i3, z16, z17, str3, "", false, false);
    }

    public static void openH5Pay(Context context, String str, String str2, int i3, boolean z16, boolean z17, String str3, String str4, boolean z18, boolean z19) {
        if (System.currentTimeMillis() - mLastRequestTime.longValue() > 1000) {
            mLastRequestTime = Long.valueOf(System.currentTimeMillis());
            StringBuilder h5PayUrlString = getH5PayUrlString(str, str2, i3, z16, z17, z19);
            if (!TextUtils.isEmpty(str3)) {
                h5PayUrlString.append("&disableChannel=" + str3);
            }
            if (z18) {
                h5PayUrlString.append("&disableMobile=1");
            }
            if (!TextUtils.isEmpty(str4)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "openH5Pay callback = " + str4);
                }
                h5PayUrlString.append("&return_url=" + str4);
            }
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, VasH5PayConstants.ROUTE_NAME);
            activityURIRequest.extra().putString("url", h5PayUrlString.toString());
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        }
    }

    private static StringBuilder getH5PayUrlString(String str, String str2, int i3, boolean z16, boolean z17, boolean z18) {
        if ("SVHHZLH".equals(str2)) {
            return new StringBuilder(BIG_VIP_H5_PAY_URL.replace("{openUin}", "0").replace("{openMonth}", i3 > 0 ? String.valueOf(i3) : "0").replace("{aid}", str).replace("{wv}", String.valueOf(z18 ? 16781315 | ((IVasH5PayAdapter) QRoute.api(IVasH5PayAdapter.class)).getWebViewTransparentConstants() : 16781315L)));
        }
        StringBuilder sb5 = new StringBuilder(H5_PAY_URL);
        sb5.append(str);
        if ("CJCLUBT".equals(str2)) {
            if (z17) {
                sb5.append("&type=!svip");
            } else {
                sb5.append("&type=svip");
            }
        } else if ("LTMCLUB".equals(str2)) {
            sb5.append("&type=vip");
        }
        if (i3 > 0) {
            if (z16) {
                sb5.append("&month=!" + i3);
            } else {
                sb5.append("&month=" + i3);
            }
        }
        return sb5;
    }

    public static void openClubPay(Context context, String str, int i3, String str2, String str3, String str4, String str5, boolean z16, boolean z17) {
        openH5Pay(context, str, str3, i3, z16, z17);
    }

    public static void openClubPay(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            return;
        }
        String string = bundle.getString(AID);
        String string2 = bundle.getString(VIPTYPE);
        int i3 = bundle.getInt(OPENMONTH);
        String string3 = bundle.getString(SENDUIN);
        bundle.getString(OFFERID);
        bundle.getString(SERVICENAME);
        bundle.getString(SERVICECODE);
        bundle.getString(CALLBACKSN);
        openH5Pay(context, string, string2, i3, string3, bundle.getString(PAY_URL));
    }

    public static void openH5PayForResult(Activity activity, String str, String str2, int i3, boolean z16, boolean z17, int i16) {
        if (System.currentTimeMillis() - mLastRequestTime.longValue() > 1000) {
            mLastRequestTime = Long.valueOf(System.currentTimeMillis());
            StringBuilder h5PayUrlString = getH5PayUrlString(str, str2, i3, z16, z17, false);
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, VasH5PayConstants.ROUTE_NAME);
            activityURIRequest.setRequestCode(i16);
            activityURIRequest.extra().putString("url", h5PayUrlString.toString());
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        }
    }

    private static void openH5Pay(Context context, String str, String str2, int i3, String str3, String str4) {
        if (System.currentTimeMillis() - mLastRequestTime.longValue() > 1000) {
            mLastRequestTime = Long.valueOf(System.currentTimeMillis());
            StringBuilder sb5 = new StringBuilder();
            if (TextUtils.isEmpty(str4)) {
                sb5.append(H5_PAY_URL);
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(str);
                }
            } else {
                sb5.append(str4);
                if (!TextUtils.isEmpty(str) && !str4.contains("aid=")) {
                    if (str4.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        sb5.append("&aid=" + str);
                    } else {
                        sb5.append("?aid=" + str);
                    }
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb5.append("&type=" + str2);
            }
            if (i3 > 0) {
                sb5.append("&month=" + i3);
            }
            if (VasToggle.BUG_31032000175.isEnable(true)) {
                if (!TextUtils.isEmpty(str3) && !str3.equals(MobileQQ.sMobileQQ.waitAppRuntime().getCurrentAccountUin())) {
                    sb5.append("&provideUin=" + str3);
                    sb5.append("&isSend=1");
                }
            } else {
                if (!TextUtils.isEmpty(str3)) {
                    sb5.append("&provideUin=" + str3);
                }
                sb5.append("&isSend=1");
            }
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, VasH5PayConstants.ROUTE_NAME);
            activityURIRequest.extra().putString("url", sb5.toString());
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
        }
    }
}
