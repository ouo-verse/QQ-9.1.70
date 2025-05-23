package com.tencent.mobileqq.kandian.biz.common.api.impl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vip.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class PublicAccountReportUtils {

    /* renamed from: b, reason: collision with root package name */
    private static final SimpleDateFormat f239286b = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.CHINA);

    /* renamed from: a, reason: collision with root package name */
    public static int f239285a;

    /* renamed from: c, reason: collision with root package name */
    public static int f239287c = f239285a;

    protected static String c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            a(jSONObject);
            f(jSONObject);
            b(jSONObject);
            d(jSONObject);
            g(str, jSONObject);
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e("PublicAccountReportUtils", 1, "addExtraInfo error! msg=" + e16);
            return str2;
        }
    }

    private static void e(String str, final String str2) {
        if ("0X8007625".equals(str)) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new JSONObject(str2).getInt("channel_id");
                        ReadinjoySPEventReport.j0(2);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            });
        }
    }

    private static void f(JSONObject jSONObject) {
        try {
            if (j() && PrivacyPolicyHelper.isUserAllow()) {
                jSONObject.put("wifi_ssid", "");
                jSONObject.put("wifi_mac", "");
            }
        } catch (Exception e16) {
            QLog.e("PublicAccountReportUtils", 1, "addWifiInfo error! msg=" + e16);
        }
    }

    public static void i(final AppInterface appInterface, final String str, final String str2, final String str3, final int i3, final int i16, final String str4, final String str5, final String str6, final String str7, final boolean z16) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils.1
            @Override // java.lang.Runnable
            public void run() {
                String str8;
                String str9 = str7;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str7);
                        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
                        if (qQAppInterface != null) {
                            if (((IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(str))) {
                                str8 = "1";
                            } else {
                                str8 = "0";
                            }
                            jSONObject.put(QCircleDaTongConstant.ElementParamValue.MEDAL_FANS, str8);
                        }
                        str9 = jSONObject.toString();
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("PublicAccountReportUtils", 2, "doVideoDataReportWithFansInfoInR5() error exception = " + e16.getMessage());
                        }
                    }
                }
                PublicAccountReportUtils.l(appInterface, str, str2, str3, i3, i16, str4, str5, str6, str9, z16);
            }
        }, 5, null, true);
    }

    private static boolean j() {
        AppRuntime runtime;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null || (runtime = application.getRuntime()) == null) {
            return false;
        }
        return runtime.isLogin();
    }

    public static void k(AppInterface appInterface, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7) {
        e(str3, str7);
        String c16 = c(str3, str7);
        ReportController.o(appInterface, "dc01160", IPublicAccountHandler.MAIN_ACTION, str, str2.toUpperCase(), str3.toUpperCase(), i3, i16, h(str4), h(str5), h(str6), h(c16));
    }

    public static void m(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        e(str5, str9);
        String c16 = c(str5, str9);
        String h16 = h(str6);
        String h17 = h(str7);
        String h18 = h(str8);
        String h19 = h(c16);
        ReportController.o(appInterface, str, str2, str3, str4, str5, i3, i16, h16, h17, h18, h19);
        ReportController.o(appInterface, "dc01160", IPublicAccountHandler.MAIN_ACTION, str3, str4.toUpperCase(), str5.toUpperCase(), i3, i16, h16, h17, h18, h19);
    }

    public static void n(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9, boolean z16) {
        e(str5, str9);
        String c16 = c(str5, str9);
        if (z16) {
            m(appInterface, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, c16);
        } else {
            ReportController.o(appInterface, str, str2, str3, str4, str5, i3, i16, str6, str7, str8, c16);
            ReportController.o(appInterface, "dc01160", IPublicAccountHandler.MAIN_ACTION, str3, str4.toUpperCase(), str5.toUpperCase(), i3, i16, str6, str7, str8, c16);
        }
    }

    public static void o(AppInterface appInterface, String str, int i3) {
        int reportAccountType = ((IPublicAccountDetail) QRoute.api(IPublicAccountDetail.class)).getReportAccountType(appInterface, String.valueOf(str));
        if (reportAccountType == 2 || ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(appInterface, str) == -7) {
            return;
        }
        l(null, str, "0X800827B", "0X800827B", 0, 0, "" + i3, "" + reportAccountType, "", "", false);
    }

    public static void r(AppInterface appInterface, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7, boolean z16) {
        if (BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface) {
            i(appInterface, str, str2, str3, i3, i16, str4, str5, str6, str7, z16);
        }
    }

    private static void d(JSONObject jSONObject) {
        String str;
        try {
            if (e.a() == 1) {
                str = "1";
            } else {
                str = "0";
            }
            jSONObject.put("is_kind_card", str);
        } catch (Exception e16) {
            QLog.e("PublicAccountReportUtils", 1, "addKingCard error! msg=" + e16);
        }
    }

    public static String h(String str) {
        if (str == null) {
            str = "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return str;
        }
    }

    public static void q(List<MessageRecord> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        for (MessageRecord messageRecord : list) {
            if (messageRecord.istroop == 1008) {
                if (!TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("public_account_send_flag")) && !TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr(AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID)) && !TextUtils.equals(messageRecord.frienduin, messageRecord.selfuin)) {
                    final String str = messageRecord.frienduin;
                    final String str2 = messageRecord.selfuin;
                    final String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID);
                    final long j3 = messageRecord.time;
                    final String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("public_account_send_flag");
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils.3
                        @Override // java.lang.Runnable
                        public void run() {
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("fromUin", str);
                            hashMap.put("toUin", str2);
                            hashMap.put("msgId", extInfoFromExtStr);
                            hashMap.put(WadlProxyConsts.CREATE_TIME, String.valueOf(j3));
                            hashMap.put("recvTime", String.valueOf(currentTimeMillis));
                            hashMap.put("sendFlag", extInfoFromExtStr2);
                            hashMap.put("nodeNo", String.valueOf(3000));
                            long j16 = currentTimeMillis - j3;
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPubAccMsgReceipt", true, (j16 <= 0 || j16 > 86400) ? 0L : j16, 0L, hashMap, null);
                        }
                    }, 5, null, false);
                } else if (QLog.isColorLevel()) {
                    QLog.d("PublicAccountReportUtils", 2, "reportPubAccMsg exception, public_account_send_flag null || public_account_msg_id null || ");
                }
            }
        }
    }

    public static void l(AppInterface appInterface, String str, String str2, String str3, int i3, int i16, String str4, String str5, String str6, String str7, boolean z16) {
        e(str3, str7);
        String c16 = c(str3, str7);
        if (z16) {
            k(appInterface, str, str2, str3, i3, i16, str4, str5, str6, c16);
        } else {
            ReportController.o(appInterface, "dc01160", IPublicAccountHandler.MAIN_ACTION, str, str2.toUpperCase(), str3.toUpperCase(), i3, i16, str4, str5, str6, c16);
        }
    }

    public static void p(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7 = "kandian_" + str;
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(PreDownloadConstants.RPORT_KEY_BUSINESS_DEPARTMENT, IPublicAccountWebviewPlugin.SCHEME);
        hashMap.put("fromuin", account);
        hashMap.put("touin", str2);
        hashMap.put("d1", str3);
        hashMap.put("d2", str4);
        hashMap.put("d3", str5);
        hashMap.put("d4", str6);
        StatisticCollector.getInstance(com.tencent.qphone.base.util.BaseApplication.getContext()).collectPerformance(account, str7, true, 0L, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.d("reportPAinfoToLighthouse", 2, "reportPAinfoToLighthouse-->", "kandianT" + str7 + ", fromuin:" + account + ", touin:" + str2 + ", d1:" + str3 + ", d2:" + str4 + ", d3:" + str5 + ", d4:" + str6);
        }
    }

    private static void a(JSONObject jSONObject) {
    }

    private static void b(JSONObject jSONObject) {
    }

    private static void g(String str, JSONObject jSONObject) {
    }
}
