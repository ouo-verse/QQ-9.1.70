package com.tencent.mobileqq.highway.utils;

import android.os.SystemClock;
import android.text.format.Time;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.segment.RequestFinishQuery;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TransactionReport {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_TIME = "key_time";
    public static final String KEY_UIN = "key_uin";
    public static final String REPORT_QUERY_FINISH_COUNT = "param_query_finish_flag";
    public static final String REPORT_QUERY_FINISH_PROBLEM = "report_query_finish_beyond";
    public static final String REPORT_TAG_ACTBDHCHANNEL = "actBDHTask";
    public static final String REPORT_TAG_SUCC = "param_succ_flag";

    public TransactionReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void reportFunction(String str, Transaction transaction, HashMap<String, String> hashMap) {
        String str2;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        boolean z16 = transaction.isSuccess.get();
        if (!z16) {
            hashMap.put("param_FailCode", String.valueOf(transaction.mErrorCode));
        }
        hashMap.put("param_buz_id", String.valueOf(transaction.mBuzCmdId));
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("param_succ_flag", str2);
        hashMap.put(TransReport.rep_is_ipv6, String.valueOf(transaction.mTransReport.isIpv6 ? 1 : 0));
        hashMap.put(TransReport.rep_has_ipv6_list, String.valueOf(transaction.mTransReport.mIPv6Fast ? 1 : 0));
        hashMap.put(TransReport.rep_ipv6_first, String.valueOf(transaction.mTransReport.mHasIpv6List ? 1 : 0));
        RdmReq rdmReq = new RdmReq();
        rdmReq.eventName = str;
        rdmReq.elapse = SystemClock.uptimeMillis() - transaction.startTime;
        rdmReq.size = transaction.totalLength;
        rdmReq.isSucceed = z16;
        rdmReq.params = hashMap;
        try {
            ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq);
            rdmReportMsg.setAppId(HwEngine.appId);
            rdmReportMsg.setTimeout(30000L);
            MsfServiceSdk.get().sendMsg(rdmReportMsg);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void reportQueryFinishQuality(Transaction transaction, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(REPORT_QUERY_FINISH_COUNT, String.valueOf(i3));
        reportFunction(REPORT_QUERY_FINISH_COUNT, transaction, hashMap);
        if (QLog.isColorLevel() && i3 > RequestFinishQuery.QUERY_HOLE_MAX_COUNT) {
            hashMap.put("key_uin", transaction.peerUin);
            hashMap.put(REPORT_QUERY_FINISH_COUNT, String.valueOf(i3));
            Time time = new Time();
            time.setToNow();
            hashMap.put("key_time", time.hour + "_" + time.minute);
            reportFunction(REPORT_QUERY_FINISH_PROBLEM, transaction, hashMap);
        }
    }
}
