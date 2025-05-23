package mqq.app.msghandle;

import android.os.Debug;
import android.os.Handler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.msf.sdk.MsfRespHandleUtil;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.IDialogUtilService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.Arrays;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.inject.MqqInjectorManager;
import mqq.util.AbstractUnifiedMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MsgRespHandler {
    private static final int SHOW_DIALOG_LIMIT = 5000;
    private static final String TAG = "MsgRespHandler";
    private Handler mCommonPriorityHandler;
    private final List<String> mHighPriorityCMDList = Arrays.asList(new HighPriorityCMDProvider().get());
    private Handler mHighPriorityHandler;

    private static void handleRespTooLong(MobileQQ mobileQQ, FromServiceMsg fromServiceMsg, long j3) {
        if (!MqqInjectorManager.instance().isDebugVersion() || j3 < 5000 || Debug.isDebuggerConnected()) {
            return;
        }
        ((IDialogUtilService) QRoute.api(IDialogUtilService.class)).showMSFRespCustomDialog(0, mobileQQ.getString(R.string.f168202f0), mobileQQ.getString(R.string.f168192ez, fromServiceMsg.getServiceCmd(), Long.valueOf(j3)), null, null);
    }

    private boolean isHighPriorityCMD(String str) {
        return this.mHighPriorityCMDList.contains(str);
    }

    public static void onRespHandleFinish(MobileQQ mobileQQ, AbstractUnifiedMonitor abstractUnifiedMonitor, FromServiceMsg fromServiceMsg, long j3, MsfServiceSdk msfServiceSdk) {
        boolean z16;
        stopUnifiedMonitorReport(abstractUnifiedMonitor, fromServiceMsg, j3);
        String serviceCmd = fromServiceMsg.getServiceCmd();
        boolean isGrayVersion = MqqInjectorManager.instance().isGrayVersion();
        boolean isPublicVersion = MqqInjectorManager.instance().isPublicVersion();
        if (Thread.currentThread() == ThreadManagerV2.getMSFHighPriorityThread()) {
            z16 = true;
        } else {
            z16 = false;
        }
        MsgRespHandleReporter.reportRespHandleCost(serviceCmd, j3, msfServiceSdk, isGrayVersion, isPublicVersion, z16);
    }

    public static void onRespHandleStart(AbstractUnifiedMonitor abstractUnifiedMonitor) {
        startUnifiedMonitorReport(abstractUnifiedMonitor);
    }

    static void startUnifiedMonitorReport(AbstractUnifiedMonitor abstractUnifiedMonitor) {
        MonitorEntity monitorEntity = MSFRespHandleTask.THREAD_LOCAL.get();
        if (monitorEntity.reportThreshold == -1 && abstractUnifiedMonitor != null) {
            if (abstractUnifiedMonitor.whetherReportDuringThisStartup(monitorEntity.eventFamily)) {
                monitorEntity.reportThreshold = abstractUnifiedMonitor.getThreshold(monitorEntity.eventFamily);
                abstractUnifiedMonitor.setMonitoredThread(monitorEntity.eventFamily, Thread.currentThread(), null);
            } else {
                monitorEntity.reportThreshold = -2;
            }
        }
        if (abstractUnifiedMonitor != null && abstractUnifiedMonitor.whetherStackEnabled(monitorEntity.eventFamily)) {
            abstractUnifiedMonitor.reportStackIfTimeout(monitorEntity.eventFamily);
        }
    }

    static void stopUnifiedMonitorReport(AbstractUnifiedMonitor abstractUnifiedMonitor, FromServiceMsg fromServiceMsg, long j3) {
        MonitorEntity monitorEntity = MSFRespHandleTask.THREAD_LOCAL.get();
        int i3 = monitorEntity.reportThreshold;
        if (i3 <= 0) {
            return;
        }
        if (j3 > i3) {
            if (abstractUnifiedMonitor.whetherReportThisTime(monitorEntity.eventFamily)) {
                abstractUnifiedMonitor.addEvent(monitorEntity.eventFamily, fromServiceMsg.getServiceCmd(), (int) j3, monitorEntity.umNotReported, null);
            }
            monitorEntity.umNotReported = 0;
        } else {
            if (abstractUnifiedMonitor.whetherStackEnabled(monitorEntity.eventFamily)) {
                abstractUnifiedMonitor.notifyNotTimeout(monitorEntity.eventFamily);
            }
            monitorEntity.umNotReported++;
        }
    }

    public void dispatchRespMsg(MobileQQ mobileQQ, MsfMessagePair msfMessagePair, MsfRespHandleUtil msfRespHandleUtil, MsfServiceSdk msfServiceSdk) {
        if (isHighPriorityCMD(msfMessagePair.fromServiceMsg.getServiceCmd())) {
            handleHighPriorityCMD(mobileQQ, msfMessagePair, msfRespHandleUtil, msfServiceSdk);
        } else {
            handleCommonPriorityCMD(mobileQQ, msfMessagePair, msfRespHandleUtil, msfServiceSdk);
        }
    }

    void handleCommonPriorityCMD(MobileQQ mobileQQ, MsfMessagePair msfMessagePair, MsfRespHandleUtil msfRespHandleUtil, MsfServiceSdk msfServiceSdk) {
        if (this.mCommonPriorityHandler == null) {
            this.mCommonPriorityHandler = new Handler(ThreadManagerV2.getMSFCommonPriorityThread().getLooper());
        }
        this.mCommonPriorityHandler.post(new MSFRespHandleTask(mobileQQ, msfMessagePair, msfRespHandleUtil, msfServiceSdk));
    }

    void handleHighPriorityCMD(MobileQQ mobileQQ, MsfMessagePair msfMessagePair, MsfRespHandleUtil msfRespHandleUtil, MsfServiceSdk msfServiceSdk) {
        if (this.mHighPriorityHandler == null) {
            this.mHighPriorityHandler = new Handler(ThreadManagerV2.getMSFHighPriorityThread().getLooper());
        }
        this.mHighPriorityHandler.post(new MSFRespHandleTask(mobileQQ, msfMessagePair, msfRespHandleUtil, msfServiceSdk));
    }
}
