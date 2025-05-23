package cooperation.qqcircle.report.perf;

import android.app.ActivityManager;
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
public class QFSAMSMemoryInfoReportBean {
    public static final String EVENT_ID_AFTER_ENTER = "ams_memory_tracker_after_enter";
    public static final String EVENT_ID_AFTER_EXIT = "ams_memory_tracker_after_exit";
    public static final String EVENT_ID_REGULAR = "ams_memory_tracker";
    private static final String KEY_AVG_USE_MEMORY = "avgUseMemory";
    private static final String KEY_IS_FIRST = "isFirst";
    private static final String KEY_MAX_USE_MEMORY = "maxUseMemory";
    private static final String KEY_MEMORY_INC_USE = "memoryUseInc";
    private static final String KEY_MOBILE_MEMORY = "mobileMemory";
    private static final String KEY_RECYCLED = "exitRecycled";
    private static final String KEY_SCENE = "scene";
    private static final String TAG = "QFSAMSMemoryInfoTracker";
    private float mAvgMemoryUsage;
    private ActivityManager.MemoryInfo mInitMemroy;
    private boolean mIsFirstReport;
    private float mMaxMemoryUsage;
    private float mMemoryInc;
    private float mMemoryRecycled;
    private String mReportScene;
    private String mReportSeq;
    private int mReportType;

    public QFSAMSMemoryInfoReportBean(float f16, float f17) {
        this.mAvgMemoryUsage = f16;
        this.mMaxMemoryUsage = f17;
    }

    public void report(String str) {
        String currentAv1ExpName;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (EVENT_ID_REGULAR.equals(str)) {
                jSONObject.put(KEY_AVG_USE_MEMORY, this.mAvgMemoryUsage);
                jSONObject.put(KEY_MAX_USE_MEMORY, this.mMaxMemoryUsage);
            } else {
                jSONObject.put(KEY_MEMORY_INC_USE, this.mMemoryInc);
            }
            if (EVENT_ID_AFTER_EXIT.equals(str)) {
                jSONObject.put(KEY_RECYCLED, this.mMemoryRecycled);
            }
            String str2 = this.mReportScene;
            if (str2 != null) {
                jSONObject.put("scene", str2);
            }
            if (this.mInitMemroy != null) {
                jSONObject.put(KEY_MOBILE_MEMORY, ((float) r5.totalMem) / 1048576.0f);
            }
            jSONObject.put(KEY_IS_FIRST, this.mIsFirstReport);
            String jSONObject2 = jSONObject.toString();
            RFWLog.d("QFSAMSMemoryInfoTracker", RFWLog.USR, "memory reportJson:" + jSONObject2);
            ASEngineQualityReport.ReportData ext1 = new ASEngineQualityReport.ReportData().setEventId(str).setPluginType(String.valueOf(this.mReportType)).setPluginVersion((long) QCircleVideoDeviceInfoUtils.getVideoDeviceLevel()).setExt1(this.mReportSeq);
            if (TextUtils.isEmpty(((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getCurrentAv1ExpName())) {
                currentAv1ExpName = "";
            } else {
                currentAv1ExpName = ((IQFSPlayerStrategyApi) QRoute.api(IQFSPlayerStrategyApi.class)).getCurrentAv1ExpName();
            }
            ASEngineQualityReport.report(ext1.setExt2(currentAv1ExpName).setExt3(jSONObject2));
        } catch (Exception e16) {
            RFWLog.d("QFSAMSMemoryInfoTracker", RFWLog.CLR, e16);
        }
    }

    public QFSAMSMemoryInfoReportBean setInitMemory(ActivityManager.MemoryInfo memoryInfo) {
        this.mInitMemroy = memoryInfo;
        return this;
    }

    public QFSAMSMemoryInfoReportBean setIsFirst(boolean z16) {
        this.mIsFirstReport = z16;
        return this;
    }

    public QFSAMSMemoryInfoReportBean setRecycledMemory(float f16) {
        this.mMemoryRecycled = f16;
        return this;
    }

    public QFSAMSMemoryInfoReportBean setReportScene(String str) {
        this.mReportScene = str;
        return this;
    }

    public QFSAMSMemoryInfoReportBean setReportSeq(@NotNull String str) {
        this.mReportSeq = str;
        return this;
    }

    public QFSAMSMemoryInfoReportBean setType(int i3) {
        this.mReportType = i3;
        return this;
    }

    public QFSAMSMemoryInfoReportBean(float f16) {
        this.mMemoryInc = f16;
    }
}
