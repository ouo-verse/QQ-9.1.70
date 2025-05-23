package com.tenpay.proxy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.qwallet.temp.IQWalletTemp;
import com.qwallet.utils.QWalletCorpUtils;
import com.qwallet.utils.QWalletUtils;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.j;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntstartup.nativeinterface.StartupSessionConstant;
import com.tenpay.QwLog;
import cooperation.qwallet.plugin.ipc.BaseResp;
import cooperation.qwallet.plugin.ipc.CorpReq;
import cooperation.qwallet.plugin.ipc.CorpResp;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* loaded from: classes27.dex */
public class DataProxy {
    private static final String TAG = "DataProxy";
    protected static HashMap<String, Long> ipForbiddenMap = new HashMap<>();

    public static Bundle getBaseRespResult(Bundle bundle) {
        BaseResp resp = BaseResp.getResp(bundle);
        if (resp != null) {
            return ((CorpResp) resp).encryptionData;
        }
        return null;
    }

    public static void getByIPC(int i3, ResultReceiver resultReceiver, Bundle bundle) {
        new QWalletCorpUtils(Integer.valueOf(i3), resultReceiver, bundle);
    }

    private static int getCFTDomain() {
        return ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getInnerDnsCFTDomain();
    }

    public static Class<?> getCorpClazz() {
        return QWalletCorpUtils.class;
    }

    public static int getRedPacketGuideMoney() {
        return MobileQQ.sMobileQQ.getSharedPreferences("MOBILEQQ HONGBAO_SCENESRECOMMEND_INFO", 4).getInt("HONGBAO_SCENES_MONEY_LIMIT", 100);
    }

    public static long getServerTimeMillis() {
        return NetConnInfoCenter.getServerTimeMillis();
    }

    public static String getTenpayExternalPath() {
        String str = j.f279282a;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String getTenpayInternalPath() {
        String str = j.f279284c;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static void logUpload(Bundle bundle) {
        String str;
        String str2;
        String str3;
        if (QLog.isDevelopLevel()) {
            str = StartupSessionConstant.KNTMODULENAME;
            QLog.i("QWalletCorpUtils", 4, "QWalletCorpUtils REQ_ID_LOG_UPLOAD");
        } else {
            str = StartupSessionConstant.KNTMODULENAME;
        }
        String string = bundle.getString("uin");
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("uin", string);
            if (bundle.containsKey("co")) {
                hashMap.put("co", bundle.getString("co"));
            }
            if (bundle.containsKey("wt")) {
                hashMap.put("wt", bundle.getString("wt"));
            }
            if (bundle.containsKey("rc")) {
                str3 = bundle.getString("rc");
                hashMap.put("rc", str3);
            } else {
                str3 = "-1";
            }
            if (bundle.containsKey("dip")) {
                hashMap.put("dip", bundle.getString("dip"));
            }
            if (bundle.containsKey(GdtADFlyingStreamingReportHelper.PARAM_KEY_MN)) {
                hashMap.put(GdtADFlyingStreamingReportHelper.PARAM_KEY_MN, bundle.getString(GdtADFlyingStreamingReportHelper.PARAM_KEY_MN));
            }
            String str4 = "";
            if (bundle.containsKey("ec")) {
                str4 = bundle.getString("ec");
                hashMap.put("ec", str4);
            }
            if (bundle.containsKey("cgi")) {
                hashMap.put("cgi", bundle.getString("cgi"));
            }
            if (bundle.containsKey("r5")) {
                hashMap.put("r5", bundle.getString("r5"));
            }
            if (bundle.containsKey("th")) {
                hashMap.put("th", bundle.getString("th"));
            }
            if (bundle.containsKey("cp")) {
                hashMap.put("cp", bundle.getString("cp"));
            }
            if (bundle.containsKey("c")) {
                hashMap.put("c", bundle.getString("c"));
            }
            if (bundle.containsKey("d")) {
                hashMap.put("d", bundle.getString("d"));
            }
            String str5 = str;
            if (bundle.containsKey(str5)) {
                hashMap.put(str5, bundle.getString(str5));
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(string, "qpay_logupload", "0".equals(str4), Integer.valueOf(str3).intValue(), -1L, hashMap, "", false);
            if (QLog.isDevelopLevel()) {
                str2 = "QWalletCorpUtils";
                try {
                    QLog.i(str2, 4, "after collectPerformance");
                } catch (Exception e16) {
                    e = e16;
                    if (QLog.isDevelopLevel()) {
                        QLog.i(str2, 4, "error = " + e.getMessage());
                    }
                }
            }
        } catch (Exception e17) {
            e = e17;
            str2 = "QWalletCorpUtils";
        }
    }

    public static void openAio(Bundle bundle) {
        CorpReq corpReq = new CorpReq();
        CorpReq.corpReqType = 10;
        corpReq.data = bundle;
        QWalletUtils.u(corpReq);
    }

    public static void receiveResult(int i3, Bundle bundle, Bundle bundle2) {
        new QWalletCorpUtils(Integer.valueOf(i3), bundle, bundle2);
    }

    public static void reportBadIp(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            ipForbiddenMap.put(str2, Long.valueOf(System.currentTimeMillis()));
            InnerDns.getInstance().reportBadIp(str, str2, getCFTDomain());
            QwLog.i("reportBadIp: domain:" + str + ",ip:" + str2);
        }
    }

    public static void reqAvatar(ResultReceiver resultReceiver, Bundle bundle) {
        CorpReq corpReq = new CorpReq();
        CorpReq.corpReqType = 12;
        corpReq.fromReceiver = resultReceiver;
        corpReq.data = bundle;
        QWalletUtils.u(corpReq);
    }

    public static void reqGetEncryption(ResultReceiver resultReceiver) {
        CorpReq corpReq = new CorpReq();
        CorpReq.corpReqType = 8;
        corpReq.fromReceiver = resultReceiver;
        QWalletUtils.u(corpReq);
    }

    public static void reqGroupNickname(ResultReceiver resultReceiver, Bundle bundle) {
        CorpReq corpReq = new CorpReq();
        CorpReq.corpReqType = 11;
        corpReq.fromReceiver = resultReceiver;
        corpReq.data = bundle;
        QWalletUtils.u(corpReq);
    }

    public static void reqPutEncryption(Bundle bundle) {
        CorpReq corpReq = new CorpReq();
        CorpReq.corpReqType = 7;
        CorpReq.encryptionData = bundle;
        QWalletUtils.u(corpReq);
    }

    public static void reqRecentFowrad(ResultReceiver resultReceiver, Bundle bundle) {
        CorpReq corpReq = new CorpReq();
        CorpReq.corpReqType = 9;
        corpReq.fromReceiver = resultReceiver;
        corpReq.data = bundle;
        QWalletUtils.u(corpReq);
    }

    public static void sendRedPacketFinishNotify(Context context, String str, String str2) {
        Intent intent = new Intent("mqq.scenesrecommendemo.notify.action");
        intent.putExtra("scenes_kov", "SendRedPacketFinishNotify");
        intent.putExtra("check_uin", str);
        intent.putExtra("HONGBAO_KEY_SENDERUIN", str2);
        context.sendBroadcast(intent);
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "sendRedPacketFinishNotify...curFriendUin:" + str + ",senderUin:" + str2);
        }
    }

    public static void reportSpringHbAwardPage(String str, int i3, int i16, String str2, String str3, String str4, String str5) {
    }
}
