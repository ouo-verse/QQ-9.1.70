package cooperation.qqcircle.report.perf;

import android.os.Debug;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.minigame.report.MiniGameMemoryLimitReport;
import com.tencent.mobileqq.qcircle.api.IQFSPlayerStrategyApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.report.ASEngineQualityReport;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSMemoryReportBean {
    private static final String EVENT_ID = "qfs_memory_tracker";
    private static final long INVALID = -1;
    private static final String TAG = "QFSMemoryTracker";
    private final Debug.MemoryInfo mMemoryInfo;
    private String mReportSeq;
    private int mReportType;
    private String mScene;

    public QFSMemoryReportBean(Debug.MemoryInfo memoryInfo) {
        this.mMemoryInfo = memoryInfo;
    }

    public void report() {
        long j3;
        String currentAv1ExpName;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("totalPass", this.mMemoryInfo.getTotalPss() / 1024);
            jSONObject.put(MiniGameMemoryLimitReport.BeaconKey.DALVIKPSS, this.mMemoryInfo.dalvikPss / 1024);
            jSONObject.put(MiniGameMemoryLimitReport.BeaconKey.OTHERPSS, this.mMemoryInfo.otherPss / 1024);
            jSONObject.put(MiniGameMemoryLimitReport.BeaconKey.NATIVEPSS, this.mMemoryInfo.nativePss / 1024);
            try {
                j3 = Long.parseLong(this.mMemoryInfo.getMemoryStat("summary.graphics")) / 1024;
            } catch (Exception e16) {
                RFWLog.d("QFSMemoryTracker", RFWLog.CLR, e16);
                j3 = -1;
            }
            if (!TextUtils.isEmpty(this.mScene)) {
                jSONObject.put("scene", this.mScene);
            }
            jSONObject.put("graphicPss", j3);
            String jSONObject2 = jSONObject.toString();
            RFWLog.d("QFSMemoryTracker", RFWLog.USR, "memory reportJson:" + jSONObject2);
            ASEngineQualityReport.ReportData ext1 = new ASEngineQualityReport.ReportData().setEventId(EVENT_ID).setPluginType(String.valueOf(this.mReportType)).setPluginVersion((long) QCircleVideoDeviceInfoUtils.getVideoDeviceLevel()).setExt1(this.mReportSeq);
            if (TextUtils.isEmpty(((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getCurrentAv1ExpName())) {
                currentAv1ExpName = "";
            } else {
                currentAv1ExpName = ((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getCurrentAv1ExpName();
            }
            ASEngineQualityReport.report(ext1.setExt2(currentAv1ExpName).setExt3(jSONObject2));
        } catch (Exception e17) {
            RFWLog.d("QFSMemoryTracker", RFWLog.CLR, e17);
        }
    }

    public QFSMemoryReportBean setReportSeq(@NotNull String str) {
        this.mReportSeq = str;
        return this;
    }

    public QFSMemoryReportBean setScene(String str) {
        this.mScene = str;
        return this;
    }

    public QFSMemoryReportBean setType(int i3) {
        this.mReportType = i3;
        return this;
    }
}
