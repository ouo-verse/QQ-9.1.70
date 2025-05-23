package cooperation.qqcircle.report.perf;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.qcircle.api.IQFSPlayerStrategyApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qcircle.cooperation.config.debug.QCircleDebugKey$SwitchStateKey;
import com.tencent.qcircle.cooperation.config.debug.c;
import com.tencent.qqperf.tools.e;
import com.tencent.richframework.sender.util.EventControlUtils;
import cooperation.qqcircle.report.ASEngineQualityReport;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSFileDescriptorTracker extends AbsPerfTracker {
    private static String TAG = "QFSFileDescriptorTracker";
    private static QFSFileDescriptorTracker instance;
    private int lastCachedFdCount = 0;
    private String mScene;

    public static QFSFileDescriptorTracker getInstance() {
        if (instance == null) {
            synchronized (QFSFileDescriptorTracker.class) {
                if (instance == null) {
                    instance = new QFSFileDescriptorTracker();
                }
            }
        }
        return instance;
    }

    private void initScene(Message message) {
        Object obj = message.obj;
        if (obj instanceof String) {
            this.mScene = (String) obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEnterTracker(Message message) {
        PerfTrackerTimerManager.g().registerTimerListener(this);
        generateSeq();
        initScene(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExitTracker(Message message) {
        PerfTrackerTimerManager.g().unRegisterTimerListener(this);
        removeMessage(2);
    }

    private void report(int i3) {
        String currentAv1ExpName;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fildDescriptor", i3);
            if (!TextUtils.isEmpty(this.mScene)) {
                jSONObject.put("scene", this.mScene);
            }
            String jSONObject2 = jSONObject.toString();
            RFWLog.d(TAG, RFWLog.USR, "fd reportJson:" + jSONObject2);
            ASEngineQualityReport.ReportData ext1 = new ASEngineQualityReport.ReportData().setEventId("qfs_fd_tracker").setPluginType("2").setPluginVersion((long) QCircleVideoDeviceInfoUtils.getVideoDeviceLevel()).setExt1(this.mReportSeq);
            if (TextUtils.isEmpty(((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getCurrentAv1ExpName())) {
                currentAv1ExpName = "";
            } else {
                currentAv1ExpName = ((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getCurrentAv1ExpName();
            }
            ASEngineQualityReport.report(ext1.setExt2(currentAv1ExpName).setExt3(jSONObject2));
        } catch (Exception e16) {
            RFWLog.d(TAG, RFWLog.CLR, e16);
        }
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    protected boolean enableReport() {
        try {
            double parseDouble = Double.parseDouble(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_low_device_render_file_descriptor_tracker_report_ratio", "0.01"));
            if (enableTracker() && QCircleVideoDeviceInfoUtils.isLowDevice()) {
                if (Math.random() <= parseDouble) {
                    return true;
                }
            }
            return false;
        } catch (Exception e16) {
            RFWLog.d(TAG, RFWLog.CLR, e16);
            return false;
        }
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    protected boolean enableTracker() {
        boolean h16 = c.h(QCircleDebugKey$SwitchStateKey.QCIRCLE_ENABLE_PERF_TRACKER, 0);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_low_device_render_enable_file_descriptor_tracker", true);
        if (!h16 && (!this.mEnableTrackerRatio || !isSwitchOn)) {
            return false;
        }
        return true;
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    public void enter(String str) {
        if (!enableTracker()) {
            RFWLog.d(TAG, RFWLog.USR, "tracker disabled");
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "tracker enabled");
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = str;
        sendMessage(obtain);
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    public void exit() {
        if (!enableTracker()) {
            RFWLog.d(TAG, RFWLog.USR, "tracker disabled");
            return;
        }
        RFWLog.d(TAG, RFWLog.USR, "tracker enabled");
        Message obtain = Message.obtain();
        obtain.what = 3;
        sendMessage(obtain);
    }

    public int getCachedFdCount() {
        return this.lastCachedFdCount;
    }

    public int getFdCount() {
        int a16 = e.a();
        this.lastCachedFdCount = a16;
        return a16;
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    protected Handler.Callback getHandlerCallBack() {
        return new Handler.Callback() { // from class: cooperation.qqcircle.report.perf.QFSFileDescriptorTracker.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(@NonNull Message message) {
                int i3 = message.what;
                if (i3 == 1) {
                    QFSFileDescriptorTracker.this.onEnterTracker(message);
                } else if (i3 != 2) {
                    if (i3 == 3) {
                        QFSFileDescriptorTracker.this.onExitTracker(message);
                    }
                } else {
                    QFSFileDescriptorTracker.this.onRegularTracker(message);
                }
                return true;
            }
        };
    }

    @Override // cooperation.qqcircle.report.perf.AbsPerfTracker
    protected String getLogTag() {
        return TAG;
    }

    public void onRegularTracker(Message message) {
        report(getFdCount());
    }

    @Override // cooperation.qqcircle.report.perf.ITimerListener
    public void onTimerCallback() {
        GuardManager guardManager;
        if (!enableTracker() || (guardManager = GuardManager.sInstance) == null || !guardManager.isApplicationForeground()) {
            return;
        }
        try {
            long parseLong = Long.parseLong(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_low_device_render_file_descriptor_tracker_report_interval", "1000"));
            if (parseLong <= 0) {
                return;
            }
            if (!EventControlUtils.throttlingAtOnce(getLogTag() + "timeUpdateCallBack", parseLong)) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            sendMessage(obtain);
        } catch (Exception e16) {
            RFWLog.d(TAG, RFWLog.CLR, e16);
        }
    }
}
