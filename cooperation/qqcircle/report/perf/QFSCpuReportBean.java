package cooperation.qqcircle.report.perf;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.IQFSPlayerStrategyApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.report.ASEngineQualityReport;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSCpuReportBean {
    private static final String EVENT_ID = "qfs_cpu_tracker";
    private static final String TAG = "QFSCpuTracker";
    private final float mCpuUsage;
    private final float mMaxCupUsage;
    private String mReportSeq;
    private int mReportType;
    private String mScene;

    public QFSCpuReportBean(float f16, float f17) {
        this.mCpuUsage = f16;
        this.mMaxCupUsage = f17;
    }

    public void report() {
        String currentAv1ExpName;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cupAvUsg", this.mCpuUsage);
            jSONObject.put("maxCupUsg", this.mMaxCupUsage);
            if (!TextUtils.isEmpty(this.mScene)) {
                jSONObject.put("scene", this.mScene);
            }
            String jSONObject2 = jSONObject.toString();
            RFWLog.d("QFSCpuTracker", RFWLog.USR, "cpu reportJson:" + jSONObject2);
            ASEngineQualityReport.ReportData ext1 = new ASEngineQualityReport.ReportData().setEventId(EVENT_ID).setPluginType(String.valueOf(this.mReportType)).setPluginVersion((long) QCircleVideoDeviceInfoUtils.getVideoDeviceLevel()).setExt1(this.mReportSeq);
            if (TextUtils.isEmpty(((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getCurrentAv1ExpName())) {
                currentAv1ExpName = "";
            } else {
                currentAv1ExpName = ((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getCurrentAv1ExpName();
            }
            ASEngineQualityReport.report(ext1.setExt2(currentAv1ExpName).setExt3(jSONObject2));
        } catch (Exception e16) {
            RFWLog.d("QFSCpuTracker", RFWLog.CLR, e16);
        }
    }

    public QFSCpuReportBean setReportSeq(@NotNull String str) {
        this.mReportSeq = str;
        return this;
    }

    public QFSCpuReportBean setScene(String str) {
        this.mScene = str;
        return this;
    }

    public QFSCpuReportBean setType(@NotNull int i3) {
        this.mReportType = i3;
        return this;
    }
}
