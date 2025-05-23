package mqq.app.msghandle;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MsgRespHandleReporter {
    private static final String EVENT_MSF_RESP_HANDLE = "msfRespHandleEvent";
    private static final String KEY_CMD = "cmd";
    private static final String KEY_COST = "cost";
    private static final String KEY_IS_HIGH_PRIORITY_CMD = "isHighPriorityCMD";
    private static final String KEY_SEND_TIME = "sendTime";
    private static final int RANDOM_GRAY_END = 200000;
    private static final int RANDOM_NUMBER = 10;
    private static final int RANDOM_PUBLIC_END = 20000000;
    private static final int RANDOM_START = 0;
    private static final String REPORT_VALUE_COMMON_CMD = "0";
    private static final String REPORT_VALUE_HIGH_CMD = "1";
    private static final String TAG = "MsgRespHandleReporter";

    private static int nextInt(int i3, int i16) {
        if (i3 == i16) {
            return i3;
        }
        return i3 + new Random().nextInt(i16 - i3);
    }

    public static void reportRespHandleCost(String str, long j3, MsfServiceSdk msfServiceSdk, boolean z16, boolean z17, boolean z18) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG, 1, "reportRespHandleCost empty cmd,  cost: " + j3);
            return;
        }
        if (!shouldReport(z16, z17)) {
            return;
        }
        if (z18) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", str);
        hashMap.put("cost", String.valueOf(j3));
        hashMap.put(KEY_IS_HIGH_PRIORITY_CMD, str2);
        RdmReq rdmReq = new RdmReq();
        rdmReq.eventName = EVENT_MSF_RESP_HANDLE;
        rdmReq.elapse = j3;
        rdmReq.size = 0L;
        rdmReq.isSucceed = true;
        rdmReq.isRealTime = false;
        rdmReq.params = hashMap;
        ToServiceMsg rdmReportMsg = MsfMsgUtil.getRdmReportMsg(msfServiceSdk.getMsfServiceName(), rdmReq);
        rdmReportMsg.setNeedCallback(false);
        rdmReportMsg.extraData.putLong("sendTime", System.currentTimeMillis());
        msfServiceSdk.sendMsg(rdmReportMsg);
    }

    static boolean shouldReport(boolean z16, boolean z17) {
        if (z17) {
            if (nextInt(0, 20000000) < 10) {
                return true;
            }
            return false;
        }
        if (MqqInjectorManager.instance().isDebugVersion() || nextInt(0, 200000) < 10) {
            return true;
        }
        return false;
    }
}
