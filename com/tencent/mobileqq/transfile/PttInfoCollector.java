package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.m;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes19.dex */
public class PttInfoCollector {
    static IPatchRedirector $redirector_ = null;
    public static final int CLICK_COPY = 3;
    public static final int CLICK_DELETE = 2;
    public static final int CLICK_EAR_MODE = 9;
    public static final int CLICK_FAVORIATE = 1;
    public static final int CLICK_FORWARD = 4;
    public static final int CLICK_HANDS_FREE_MODE = 10;
    public static final int CLICK_MORE = 6;
    public static final int CLICK_STT = 5;
    public static final int DECODE_SILK = 1;
    public static final int DISMISS = 7;
    public static final int ENCODE_SILK = 0;
    public static final int FAILED = 3;
    public static final int FINISH = 1;
    public static final int MORE_FORWARD = 8;
    public static final int RECEIVING = 2;
    public static final int SOUND_CHANGE = 2;
    public static final String TAG = "PttInfoCollector";
    public static final int VOICE_CHANGING = 4;
    public static boolean changeLoadedV7;
    private static Random random;
    public static long sTotalSendCost;
    public static boolean silkLoadedV7;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76009);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        random = new Random();
        silkLoadedV7 = false;
        changeLoadedV7 = false;
        sTotalSendCost = 0L;
    }

    public PttInfoCollector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void innerReportPttItemBuilderType(QQAppInterface qQAppInterface, int i3) {
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X80059B1", "0X80059B1", i3, 0, "", "", "", AppSetting.f99551k);
    }

    public static void reportCostUntilPrepare(int i3) {
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        long uptimeMillis = SystemClock.uptimeMillis() - ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).getsCostUntilPrepare();
        if (uptimeMillis > 0) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
            statisticCollector.collectPerformance("", "PTTCostUntilPrepare", true, uptimeMillis, i3, hashMap, "");
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "COST : " + uptimeMillis + " from : " + i3);
            }
        }
    }

    public static void reportLongPressPtt(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(i3));
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.PTT_LONG_PRESS_FATE_STATISTIC_TAG, false, 0L, 0L, hashMap, "");
    }

    public static void reportMyCpuArch() {
        int cpuArchitecture = AVCoreSystemInfo.getCpuArchitecture();
        int numCores = AVCoreSystemInfo.getNumCores();
        long maxCpuFreq = AVCoreSystemInfo.getMaxCpuFreq();
        long c16 = m.c() / 1048576;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("cpuArch", String.valueOf(cpuArchitecture));
        hashMap.put("numCores", String.valueOf(numCores));
        hashMap.put("maxFreq", String.valueOf(maxCpuFreq));
        hashMap.put("memory", String.valueOf(c16));
        hashMap.put("param_FailCode", String.valueOf(cpuArchitecture));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actPttCpuArch", false, 0L, 0L, hashMap, "");
    }

    public static void reportPttDownloadStream2Offline(boolean z16) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.PTT_DOWNLOAD_STREAM_2_OFFLINE_STATISTIC_TAG, z16, 0L, 0L, new HashMap<>(), "");
    }

    public static void reportPttItemBuilderType(QQAppInterface qQAppInterface, int i3, MessageRecord messageRecord) {
        if (!(messageRecord instanceof MessageForPtt) || messageRecord.getPttStreamFlag() == 10001) {
            return;
        }
        boolean z16 = true;
        if (messageRecord.isSend()) {
            if (((MessageForPtt) messageRecord).voiceChangeFlag != 1) {
                z16 = false;
            }
            if (z16 && i3 == 1001) {
                innerReportPttItemBuilderType(qQAppInterface, 4);
                return;
            }
            return;
        }
        if (i3 != 2001) {
            if (i3 != 2003) {
                if (i3 == 2005 || i3 == 2006) {
                    innerReportPttItemBuilderType(qQAppInterface, 3);
                    return;
                }
                return;
            }
            innerReportPttItemBuilderType(qQAppInterface, 1);
            return;
        }
        innerReportPttItemBuilderType(qQAppInterface, 2);
    }

    public static void reportPttPlay(QQAppInterface qQAppInterface, int i3, int i16) {
        if (i3 == 0) {
            i3 = 9999;
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8005C1D", "0X8005C1D", i3, i16, "", "", "", AppSetting.f99551k);
    }

    public static void reportPttSoUpdate(boolean z16, String str) {
        int i3 = 1;
        if (str.equals("codecsilk")) {
            if (z16) {
                silkLoadedV7 = true;
                i3 = 0;
            } else {
                silkLoadedV7 = false;
            }
        } else if (z16) {
            changeLoadedV7 = true;
            i3 = 2;
        } else {
            changeLoadedV7 = false;
            i3 = 3;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(i3));
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.PTT_SO_UPDATE_STATISTIC_TAG, false, 0L, 0L, hashMap, "");
    }

    public static void reportRecordCounts(int i3) {
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        hashMap.put("param_FailCode", String.valueOf(i3));
        statisticCollector.collectPerformance("", "PTTStraightRecordCount", false, 0L, 0L, hashMap, "");
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "pttStraightRecordCount " + i3);
        }
    }
}
