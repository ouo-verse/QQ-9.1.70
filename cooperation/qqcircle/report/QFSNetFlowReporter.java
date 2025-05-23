package cooperation.qqcircle.report;

import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.reporter.flow.TrafficFlowReporter;
import com.tencent.qqperf.reporter.flow.b;
import com.tencent.richframework.thread.RFWThreadManager;
import uq3.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QFSNetFlowReporter {
    public static final String QFS_FLOW_COST_SCENE_IMAGE_DOWNLOAD = "qfs_flow_cost_scene_image_download";
    public static final String QFS_FLOW_COST_SCENE_SPLIT_VIDEO_DOWNLOAD = "qfs_flow_cost_scene_split_video_download";
    public static final String QFS_FLOW_COST_SCENE_VIDEO_DOWNLOAD = "qfs_flow_cost_scene_video_download";
    public static final String QFS_FLOW_COST_SCENE_VIDEO_MIX_FLOW_COUNT = "qfs_flow_cost_scene_video_mix_flow_count";
    public static final String QFS_FLOW_COST_SCENE_VIDEO_PRELOAD_FLOW_COUNT = "qfs_flow_cost_scene_video_preload_flow_count";
    private static final String TAG = "QFSNetFlowReporter";

    static /* synthetic */ b.a access$000() {
        return buildQCircleFlowReportParamsBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.qqperf.reporter.flow.b$a] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    private static b.a buildQCircleFlowReportParamsBuilder() {
        ?? r16;
        boolean isWifiConnected = NetworkUtil.isWifiConnected(BaseApplication.getContext());
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            r16 = guardManager.isApplicationForeground();
        } else {
            r16 = 0;
        }
        return new b.a().b(3).g(!isWifiConnected ? 1 : 0).f(r16);
    }

    private static boolean checkReportEnable(String str) {
        if (!c.y()) {
            return false;
        }
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1328248666:
                if (str.equals(QFS_FLOW_COST_SCENE_SPLIT_VIDEO_DOWNLOAD)) {
                    c16 = 0;
                    break;
                }
                break;
            case -1121343551:
                if (str.equals(QFS_FLOW_COST_SCENE_IMAGE_DOWNLOAD)) {
                    c16 = 1;
                    break;
                }
                break;
            case -209010527:
                if (str.equals(QFS_FLOW_COST_SCENE_VIDEO_DOWNLOAD)) {
                    c16 = 2;
                    break;
                }
                break;
            case 166705626:
                if (str.equals(QFS_FLOW_COST_SCENE_VIDEO_MIX_FLOW_COUNT)) {
                    c16 = 3;
                    break;
                }
                break;
            case 1181024141:
                if (str.equals(QFS_FLOW_COST_SCENE_VIDEO_PRELOAD_FLOW_COUNT)) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return c.x0();
            case 1:
                return c.R();
            case 2:
                return c.u0();
            case 3:
                return c.v0();
            case 4:
                return c.w0();
            default:
                return false;
        }
    }

    public static void reportFlowCost(final String str, final String str2, final String str3, long j3, final long j16, final String str4, final String str5) {
        if (!checkReportEnable(str)) {
            return;
        }
        final long j17 = j3 / 1024;
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qqcircle.report.QFSNetFlowReporter.1
            @Override // java.lang.Runnable
            public void run() {
                TrafficFlowReporter.r(QFSNetFlowReporter.access$000().c(str).k(str2).d(str3).e(j17 + "").h(j16 + "").i(str4).j(str5).a());
                QLog.i(QFSNetFlowReporter.TAG, 1, "[reportFlowCost] -> scene = " + str + ", url = " + str2 + ", entrancePath = " + str3 + ", flowAmountKb = " + j17 + ", costTime = " + j16 + ", ext1 = " + str4 + ", ext2 = " + str5);
            }
        });
    }
}
