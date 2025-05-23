package com.tencent.mobileqq.highway.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HwStatisticMgr {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_CONNCNT = "ConnCnt";
    public static final String KEY_CONNFAILCNT = "ConnFailCnt";
    public static final String KEY_CONNSUCCCNT = "ConnSuccCnt";
    public static final String KEY_CTIMECOST = "param_cost";
    public static final String KEY_IPINFO = "connDetail";
    public static final String REPORT_TAG_ACTBDHCHANNEL = "actBDHChannel";
    public static long sLastReportTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16673);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sLastReportTime = -1L;
        }
    }

    public HwStatisticMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void doReportConnection(int i3, String str, boolean z16, int i16, int i17, int i18, List<EndPoint> list, long j3) {
        if (sLastReportTime == -1) {
            sLastReportTime = SystemClock.uptimeMillis();
        } else if (SystemClock.uptimeMillis() - sLastReportTime < 480000) {
            return;
        }
        sLastReportTime = SystemClock.uptimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put(KEY_CONNCNT, String.valueOf(i16));
        hashMap.put(KEY_CONNSUCCCNT, String.valueOf(i17));
        hashMap.put(KEY_CONNFAILCNT, String.valueOf(i18));
        hashMap.put(KEY_CTIMECOST, String.valueOf(j3));
        if (list.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i19 = 0; i19 < list.size(); i19++) {
                if (i19 > 0) {
                    sb5.append(";");
                } else if (i19 > 20) {
                    break;
                }
                EndPoint endPoint = list.get(i19);
                if (endPoint != null) {
                    sb5.append(endPoint.connIndex + "_" + endPoint.ipIndex + "_" + endPoint.host + "_" + endPoint.port + "_" + endPoint.connResult + "_" + endPoint.cost);
                }
            }
            hashMap.put(KEY_IPINFO, sb5.toString());
        }
        report(i3, str, REPORT_TAG_ACTBDHCHANNEL, z16, j3, 0L, hashMap);
        BdhLogUtil.LogEvent("HwStatisticMgr", "REPORT event= actBDHChannel value= " + hashMap.toString());
    }

    public static void report(int i3, String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap) {
        RdmReq rdmReq = new RdmReq();
        rdmReq.eventName = str2;
        rdmReq.elapse = j3;
        rdmReq.size = j16;
        rdmReq.isSucceed = z16;
        rdmReq.isRealTime = true;
        rdmReq.isMerge = false;
        rdmReq.params = hashMap;
        try {
            ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(MsfServiceSdk.get().getMsfServiceName(), rdmReq);
            rdmReportMsg.setAppId(i3);
            rdmReportMsg.setTimeout(30000L);
            MsfServiceSdk.get().sendMsg(rdmReportMsg);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
