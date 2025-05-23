package cooperation.qqcircle.report;

import android.os.Build;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import qqcircle.QQCircleReport$SingleDcData;
import uq3.c;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleQualityReporter {
    public static final String KEY_ATTACH_INFO = "attach_info";
    public static final String KEY_CLIENT_TIME = "client_time";
    public static final String KEY_COUNT = "count";
    public static final String KEY_EVENT_ID = "event_id";
    public static final String KEY_EVENT_ID_IMAGE_DECODE = "image_decode_ret";
    public static final String KEY_EVENT_ID_IMAGE_DOWNLOAD = "image_download_ret";
    public static final String KEY_EVENT_ID_IMAGE_DOWNLOAD_SPEED = "net_work_speed";
    public static final String KEY_EVENT_ID_IMAGE_GREY = "imgae_show_grey";
    public static final String KEY_EVENT_ID_IMAGE_LOAD = "image_load_ret";
    public static final String KEY_EVENT_PLAYER_LEAK = "qfs_player_leak";
    public static final String KEY_HOST_UIN = "host_uin";
    public static final String KEY_ID = "identify";
    public static final String KEY_IMAGE_PUBLISH_FULL_LINK = "image_publish_full_link";
    public static final String KEY_MOBILE_TYPE = "mobile_type";
    public static final String KEY_NETWORK_TYPE = "network_type";
    public static final String KEY_OBJ_ID = "obj_id";
    public static final String KEY_OUTBOX_TASK_RESEND_EVENT = "outbox_task_resend_event";
    public static final String KEY_OUTBOX_TASK_RESEND_EVENT_FINAL = "outbox_task_resend_event_final";
    public static final String KEY_PAGE_LEAK_EVENT = "page_leak_event";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_PRELOAD_QQ_LIVE_SDK = "preload_qq_live_sdk";
    public static final String KEY_QFS_AD_FEED_TRANSFORMER_MERGE_ERROR = "qfs_ad_feed_transformer_merge_error";
    public static final String KEY_QFS_AUTHOR_UIN_MONITOR = "qfs_author_uin_monitor";
    public static final String KEY_QFS_H5_TAB_PERF_EVENT = "qfs_h5_tab_perf_event";
    public static final String KEY_QFS_TEST_PERF_EVENT = "qfs_test_perf_event";
    public static final String KEY_QFS_WEAK_NETWORK_REFRESH_FIRST_PLAY_EVENT = "qfs_weak_network_refresh_first_play_event";
    public static final String KEY_QUA = "qua";
    public static final String KEY_RATE = "rate";
    public static final String KEY_REFER = "refer";
    public static final String KEY_RET_CODE = "ret_code";
    public static final String KEY_SKIN_PACKAGE_DOWNLOAD_EVENT = "skin_package_download_event";
    public static final String KEY_SKIN_PACKAGE_LOAD_EVENT = "skin_package_load_event";
    public static final String KEY_TIME_COST = "time_cost";
    public static final String KEY_TRACE_ID = "trace_id";
    public static final String KEY_TYPE = "type";
    public static final String KEY_UNIQUE_ID = "unique_id";
    public static final String KEY_URL = "url";
    public static final String KEY_VERSION = "version";
    public static final String KEY_VIDEO_PUBLISH_FULL_LINK = "video_publish_full_link";
    private static String PERF_LEVEL = null;
    private static final String TAG = "QCircleQualityReporter";
    private static long sFinalUniqueId = 0;
    private static boolean sIsSampled = true;

    private static void checkIsSampled() {
        boolean z16;
        int X3 = c.X3();
        if (QCircleHostStubUtil.getCurrentAccountLongUin() != 0 && X3 != 0) {
            int nextInt = new Random().nextInt(100);
            if (nextInt < X3) {
                z16 = true;
            } else {
                z16 = false;
            }
            sIsSampled = z16;
            QLog.d(TAG, 1, "checkIsSampled:", Boolean.valueOf(z16), "  randomInt = ", Integer.valueOf(nextInt), " reportSampleRate = ", Integer.valueOf(X3));
        }
    }

    public static List<FeedCloudCommon$Entry> createBaseEntries(String str) {
        return new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("host_uin", QCircleHostStubUtil.getCurrentAccount()), QCircleReportHelper.newEntry("qua", QUA.getQUA3()), QCircleReportHelper.newEntry("network_type", QCircleReportHelper.getNetworkType()), QCircleReportHelper.newEntry("client_time", String.valueOf(System.currentTimeMillis())), QCircleReportHelper.newEntry("event_id", str), QCircleReportHelper.newEntry("mobile_type", DeviceInfoMonitor.getModel() + "_" + Build.VERSION.RELEASE), QCircleReportHelper.newEntry("version", ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName()), QCircleReportHelper.newEntry("platform", "AND"), QCircleReportHelper.newEntry("unique_id", String.valueOf(obtainUniqueId()))));
    }

    private static void generateUniqueId() {
        sFinalUniqueId = ((System.currentTimeMillis() / 1000) << 32) | QCircleHostStubUtil.getCurrentAccountLongUin();
    }

    public static boolean isSimpleReport(boolean z16) {
        obtainUniqueId();
        if (!((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion() && z16 && !sIsSampled && !QLog.isColorLevel()) {
            return true;
        }
        return false;
    }

    private static long obtainUniqueId() {
        if (sFinalUniqueId == 0) {
            generateUniqueId();
            checkIsSampled();
        }
        return sFinalUniqueId;
    }

    public static void reportImageQualityEvent(String str, String str2, String str3, String str4, int i3, List<FeedCloudCommon$Entry> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleReportHelper.newEntry("time_cost", str2));
        arrayList.add(QCircleReportHelper.newEntry("ret_code", str3));
        arrayList.add(QCircleReportHelper.newEntry("url", str4));
        arrayList.add(QCircleReportHelper.newEntry("type", i3 + ""));
        if (list != null) {
            arrayList.addAll(list);
        }
        reportQualityEvent(str, arrayList);
    }

    public static void reportQualityEvent(String str, List<FeedCloudCommon$Entry> list) {
        reportQualityEvent(str, list, true);
    }

    public static void reportQualityEvent(String str, List<FeedCloudCommon$Entry> list, boolean z16) {
        reportQualityEvent(5531, str, list, z16);
    }

    public static void reportQualityEvent(final int i3, final String str, final List<FeedCloudCommon$Entry> list, boolean z16) {
        if (isSimpleReport(z16)) {
            QLog.d(TAG, 4, "reportQualityEvent miss hit Sample,direct return!");
        } else {
            QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleQualityReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
                    qQCircleReport$SingleDcData.dcid.set(i3);
                    qQCircleReport$SingleDcData.report_data.addAll(QCircleQualityReporter.createBaseEntries(str));
                    List list2 = list;
                    if (list2 != null && !list2.isEmpty()) {
                        qQCircleReport$SingleDcData.report_data.addAll(list);
                    }
                    QCircleReporter.getInstance().addQualityReportData(qQCircleReport$SingleDcData);
                }
            });
        }
    }

    public static void reportQualityEvent(final int i3, final ArrayList<FeedCloudCommon$Entry> arrayList) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleQualityReporter.2
            @Override // java.lang.Runnable
            public void run() {
                QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
                qQCircleReport$SingleDcData.dcid.set(i3);
                ArrayList arrayList2 = arrayList;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    qQCircleReport$SingleDcData.report_data.addAll(arrayList);
                }
                QCircleReporter.getInstance().addQualityReportData(qQCircleReport$SingleDcData);
            }
        });
    }
}
