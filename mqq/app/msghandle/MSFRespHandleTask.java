package mqq.app.msghandle;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.util.MqqConnRateReport;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MSFRespHandleTask implements Runnable {
    static final int ELAPSE_AFTER_PWD_PACKET = 40000;
    private static final long HANDLE_RESP_MAX_COST = 3000;
    static final String SHARP_SVR_S2C = "SharpSvr.s2c";
    private static final String TAG = "MSFRespHandleTask";
    static final ThreadLocal<MonitorEntity> THREAD_LOCAL = new ThreadLocal<>();
    private static final int THREAD_REST_TIME = 120;
    private final MobileQQ mApplication;
    private final MsfRespHandleUtil mMsfRespHandleUtil;
    private final MsfServiceSdk mMsfSub;
    private final MsfMessagePair mRespMsg;

    public MSFRespHandleTask(MobileQQ mobileQQ, MsfMessagePair msfMessagePair, MsfRespHandleUtil msfRespHandleUtil, MsfServiceSdk msfServiceSdk) {
        this.mApplication = mobileQQ;
        this.mRespMsg = msfMessagePair;
        this.mMsfRespHandleUtil = msfRespHandleUtil;
        this.mMsfSub = msfServiceSdk;
    }

    void busyCheck() {
        if (MainService.sPwdPacketTime == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - MainService.sPwdPacketTime;
        if (currentTimeMillis < 40000 && currentTimeMillis > 0) {
            if (this.mMsfSub.getQueueSize() > 0 || this.mMsfSub.getPreHandleQueueSize() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "busyCheck [MSF Receive] busyCheck UI_BUSY");
                }
                try {
                    LockMethodProxy.sleep(120L);
                } catch (InterruptedException e16) {
                    QLog.e(TAG, 1, "busyCheck [MSF Receive] busyCheck", e16);
                }
            }
        }
    }

    void doHandleResp(MsfMessagePair msfMessagePair, MsfRespHandleUtil msfRespHandleUtil) {
        msfMessagePair.fromServiceMsg.setAppSeq(msfMessagePair.toServiceMsg.getAppSeq());
        msfRespHandleUtil.handleRespMsg(msfMessagePair.toServiceMsg, msfMessagePair.fromServiceMsg);
    }

    void handleCommonMsg() {
        doHandleResp(this.mRespMsg, this.mMsfRespHandleUtil);
    }

    void handlePushMsg(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return;
        }
        if (TextUtils.equals(fromServiceMsg.getServiceCmd(), SHARP_SVR_S2C)) {
            MqqConnRateReport.getInstance().doReport(MqqConnRateReport.EventType.eVideoMSFReceiverProcess, fromServiceMsg.getWupBuffer(), 0);
        }
        if (!this.mMsfRespHandleUtil.handlePushMsg(fromServiceMsg) && QLog.isColorLevel()) {
            QLog.w(TAG, 2, "handlePushMsg [MSF Receive] No handler for " + fromServiceMsg.getServiceCmd());
        }
    }

    void initThreadLocal() {
        int i3;
        ThreadLocal<MonitorEntity> threadLocal = THREAD_LOCAL;
        if (threadLocal.get() != null) {
            return;
        }
        if (Thread.currentThread() == ThreadManagerV2.getMSFHighPriorityThread()) {
            i3 = 21;
        } else {
            i3 = 7;
        }
        threadLocal.set(new MonitorEntity(i3));
    }

    @Override // java.lang.Runnable
    public void run() {
        String serviceCmd;
        initThreadLocal();
        FromServiceMsg fromServiceMsg = this.mRespMsg.fromServiceMsg;
        if (fromServiceMsg == null) {
            serviceCmd = "null";
        } else {
            serviceCmd = fromServiceMsg.getServiceCmd();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mRespMsg.toServiceMsg == null) {
            handlePushMsg(fromServiceMsg);
        } else {
            handleCommonMsg();
        }
        busyCheck();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 3000) {
            QLog.d(TAG, 1, "process resp, cost=", Long.valueOf(currentTimeMillis2), ", cmd=", serviceCmd);
        }
    }
}
