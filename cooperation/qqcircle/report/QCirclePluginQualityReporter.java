package cooperation.qqcircle.report;

import android.os.Build;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import qqcircle.QQCircleReport$SingleDcData;

/* loaded from: classes28.dex */
public class QCirclePluginQualityReporter {
    public static final String EVENT_PLUGIN_BACK_PRELOAD = "qcircle_plugin_back_proload";
    public static final String EVENT_PLUGIN_CMD_REQ = "qcircle_plugin_cmd_req";
    public static final String EVENT_PLUGIN_CMD_RSP = "qcircle_plugin_cmd_rsp";
    public static final String EVENT_PLUGIN_DOWNLOAD = "qcircle_plugin_download";
    public static final String EVENT_PLUGIN_EXCEPTION = "qcircle_plugin_exception_msg";
    public static final String EVENT_PLUGIN_FLUTTER_GET = "qcircle_plugin_flutter_get";
    public static final String EVENT_PLUGIN_GET = "qcircle_plugin_get";
    public static final String EVENT_PLUGIN_LOAD = "qcircle_plugin_load_result";
    public static final String EVENT_PLUGIN_LOAD_START = "qcircle_plugin_load_start";
    public static final String EVENT_PLUGIN_NET_BEGIN_CHECK = "qcircle_net_compare_begin";
    public static final String EVENT_PLUGIN_NET_CHECK_SUCCESS = "qcircle_net_check_success";
    public static final String EVENT_PLUGIN_NET_COMPARE_ASSET = "qcircle_net_compare_asset";
    public static final String EVENT_PLUGIN_NET_COMPARE_MINVERSION = "qcircle_net_compare_minversion";
    public static final String EVENT_PLUGIN_NET_CRASH_MAX = "qcircle_net_crash_max";
    public static final String EVENT_PLUGIN_SET_PLUGIN_INVALID = "qcircle_plugin_set_plugin_invalid";
    public static final String EVENT_PLUGIN_SYS_NOT_SUPPORT = "qcircle_plugin_system_unsupport";
    public static final String EVENT_PLUGIN_WNS_LOAD_ASSET = "qcircle_plugin_wns_load_asset";
    private static final String KEY_DEVICE_INFO = "device_info";
    private static final String KEY_EVENT_ID = "event_id";
    private static final String KEY_EX1 = "ext1";
    private static final String KEY_EX2 = "ext2";
    private static final String KEY_NETWORK_TYPE = "network_type";
    private static final String KEY_PLUGIN_TYPE = "plugintype";
    private static final String KEY_PLUGIN_VERSION = "pluginVersion";
    private static final String KEY_QUA = "qua";
    private static final String KEY_RET_CODE = "retcode";
    private static final String KEY_UIN = "uin";
    private static final String kEY_TIME_COST = "timecost";

    /* loaded from: classes28.dex */
    public static class ReportData {
        private String flutterVersion;
        private long pluginVersion;
        private long retCode;
        private String eventId = "";
        private String qua = QUA.getQUA3();
        private String pluginType = "";
        private String uin = QCircleHostStubUtil.getCurrentAccount();
        private String ext1 = "";
        private String ext2 = "";
        private String timeCost = "";
        private String netWorkTyp = QCircleReportHelper.getNetworkType();
        private String clientTime = String.valueOf(System.currentTimeMillis());

        public String getClientTime() {
            return this.clientTime;
        }

        public String getEventId() {
            return this.eventId;
        }

        public String getExt1() {
            return this.ext1;
        }

        public String getExt2() {
            return this.ext2;
        }

        public String getNetWorkTyp() {
            return this.netWorkTyp;
        }

        public String getPluginType() {
            return this.pluginType;
        }

        public long getPluginVersion() {
            return this.pluginVersion;
        }

        public String getQua() {
            return this.qua;
        }

        public long getRetCode() {
            return this.retCode;
        }

        public String getTimeCost() {
            return this.timeCost;
        }

        public String getUin() {
            return this.uin;
        }

        public ReportData setClientTime(String str) {
            this.clientTime = str;
            return this;
        }

        public ReportData setEventId(String str) {
            this.eventId = str;
            return this;
        }

        public ReportData setExt1(String str) {
            this.ext1 = str;
            return this;
        }

        public ReportData setExt2(String str) {
            this.ext2 = str;
            return this;
        }

        public ReportData setFlutterPluginVersion(String str) {
            this.flutterVersion = str;
            return this;
        }

        public ReportData setNetWorkTyp(String str) {
            this.netWorkTyp = str;
            return this;
        }

        public ReportData setPluginType(String str) {
            this.pluginType = str;
            return this;
        }

        public ReportData setPluginVersion(long j3) {
            this.pluginVersion = j3;
            return this;
        }

        public ReportData setQua(String str) {
            this.qua = str;
            return this;
        }

        public ReportData setRetCode(long j3) {
            this.retCode = j3;
            return this;
        }

        public ReportData setTimeCost(String str) {
            this.timeCost = str;
            return this;
        }

        public ReportData setUin(String str) {
            this.uin = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<FeedCloudCommon$Entry> createEntries(ReportData reportData) {
        return new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("uin", QCircleHostStubUtil.getCurrentAccount()), QCircleReportHelper.newEntry("qua", reportData.getQua()), QCircleReportHelper.newEntry("network_type", reportData.getNetWorkTyp()), QCircleReportHelper.newEntry("event_id", reportData.getEventId()), QCircleReportHelper.newEntry("retcode", String.valueOf(reportData.getRetCode())), QCircleReportHelper.newEntry(KEY_PLUGIN_VERSION, String.valueOf(reportData.getPluginVersion())), QCircleReportHelper.newEntry(KEY_PLUGIN_TYPE, reportData.getPluginType()), QCircleReportHelper.newEntry("ext1", reportData.getExt1()), QCircleReportHelper.newEntry("ext2", reportData.getExt2()), QCircleReportHelper.newEntry(kEY_TIME_COST, reportData.getTimeCost()), QCircleReportHelper.newEntry(KEY_DEVICE_INFO, Build.DEVICE)));
    }

    public static void report(final ReportData reportData) {
        if (reportData != null) {
            QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCirclePluginQualityReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
                    qQCircleReport$SingleDcData.dcid.set(10004);
                    qQCircleReport$SingleDcData.report_data.addAll(QCirclePluginQualityReporter.createEntries(ReportData.this));
                    QCircleReporter.getInstance().addQualityReportData(qQCircleReport$SingleDcData);
                }
            });
        }
    }
}
