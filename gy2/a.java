package gy2;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseArray f403873a;

    /* renamed from: b, reason: collision with root package name */
    private static final SparseBooleanArray f403874b;

    /* renamed from: c, reason: collision with root package name */
    private static String f403875c;

    /* renamed from: d, reason: collision with root package name */
    private static long f403876d;

    /* renamed from: e, reason: collision with root package name */
    private static long f403877e;

    /* renamed from: f, reason: collision with root package name */
    private static String f403878f;

    static {
        SparseArray sparseArray = new SparseArray();
        f403873a = sparseArray;
        f403874b = new SparseBooleanArray();
        f403876d = 0L;
        f403877e = 0L;
        sparseArray.put(1, "enter_tvideo");
        sparseArray.put(2, "start_launch");
        sparseArray.put(3, QCircleFolderFunnelCollect.PERIOD_INIT_FOLDER_PAGE);
        sparseArray.put(4, "sub_page_init");
        sparseArray.put(5, QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_AUTO_PLAY);
        sparseArray.put(6, QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_PREPARED);
        sparseArray.put(7, QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_START_PLAY);
        sparseArray.put(8, QCircleFolderFunnelCollect.PERIOD_FOLDER_VIDEO_FIRST_RENDER);
    }

    private static boolean a() {
        return "native".equals(f403878f);
    }

    public static void b(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (1 == i3) {
            d();
            f403876d = currentTimeMillis;
            f403877e = currentTimeMillis;
        }
        SparseBooleanArray sparseBooleanArray = f403874b;
        if (sparseBooleanArray.get(i3)) {
            QLog.d("TVideoLaunchReportUtil", 1, "reportLaunchStep step : " + i3 + " hasrecord");
            return;
        }
        if (i3 > 2 && !a()) {
            QLog.d("TVideoLaunchReportUtil", 1, "notNativePlay step : " + i3 + " ; targetType : " + f403878f);
            return;
        }
        long j3 = currentTimeMillis - f403877e;
        f403877e = currentTimeMillis;
        QLog.d("TVideoLaunchReportUtil", 1, "reportLaunchStep step : " + i3 + " timeCost = " + j3);
        sparseBooleanArray.put(i3, true);
        c(i3, j3);
    }

    private static void c(int i3, long j3) {
        HashMap hashMap = new HashMap();
        hashMap.put("step_idx", Integer.valueOf(i3));
        hashMap.put("flow_id", Long.valueOf(f403876d));
        hashMap.put("duration", Long.valueOf(j3));
        hashMap.put("target_type", f403878f);
        hashMap.put("sub_event_id", f403873a.get(i3));
        hashMap.put("lm_experiment_id", f403875c);
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND0N9K8652HOG8");
        VideoReport.reportEvent("qqoa_tech", hashMap);
    }

    private static void d() {
        QLog.d("TVideoLaunchReportUtil", 1, "reset");
        f403874b.clear();
        f403878f = "";
        f403875c = "";
    }
}
