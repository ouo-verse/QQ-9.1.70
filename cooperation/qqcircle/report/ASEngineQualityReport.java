package cooperation.qqcircle.report;

import android.os.Build;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import qqcircle.QQCircleReport$SingleDcData;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ASEngineQualityReport {
    public static final int DEFAULT_FAILED = -1;
    public static final String EVENT_ENTER_PLUGIN = "autoshadow_plugin_enter";
    public static final String EVENT_PLAYER_AV1_BACK = "event_player_av1_back";
    public static final String EVENT_PLAYER_AV1_HIT = "event_player_av1_hit";
    public static final String EVENT_PLAYER_DROP_FRAME = "event_player_drop_frame";
    public static final String EVENT_PLUGIN_CMD_REQ = "autoshadow_plugin_cmd_req";
    public static final String EVENT_PLUGIN_CMD_RSP = "autoshadow_plugin_cmd_rsp";
    public static final String EVENT_PLUGIN_DOWNLOAD = "autoshadow_plugin_download";
    public static final String EVENT_PLUGIN_GET = "autoshadow_plugin_get";
    public static final String EVENT_PLUGIN_LOAD = "autoshadow_plugin_load_result";
    public static final String EVENT_PLUGIN_LOAD_PLUGIN_LOADER = "autoshadow_load_plugin_loader";
    public static final String EVENT_PLUGIN_LOAD_RUNTIME = "autoshadow_load_runtime";
    public static final String EVENT_PLUGIN_ODEX_INSTALL = "autoshadow_odex_install";
    public static final String EVENT_PLUGIN_ON_CREATE = "autoshadow_on_create";
    public static final String EVENT_PLUGIN_SET_PLUGIN_INVALID = "autoshadow_plugin_set_plugin_invalid";
    public static final String EVENT_PLUGIN_WAIT_FOR_SERVICE = "autoshadow_wait_service_connect";
    public static final String EVENT_SCROLL_PAGE_FRAME = "event_scroll_page_frame";
    private static final String KEY_DEVICE_INFO = "device_info";
    private static final String KEY_EVENT_ID = "event_id";
    private static final String KEY_EX1 = "ext1";
    private static final String KEY_EX2 = "ext2";
    private static final String KEY_EX3 = "ext3";
    private static final String KEY_NETWORK_TYPE = "network_type";
    private static final String KEY_PLUGIN_TYPE = "plugintype";
    private static final String KEY_PLUGIN_VERSION = "pluginVersion";
    private static final String KEY_QUA = "qua";
    private static final String KEY_RET_CODE = "retcode";
    private static final String KEY_UIN = "uin";
    public static final int LOAD_CRASH_INVALID = 6;
    public static final int LOAD_EXCEPTION_FAILED = 5;
    public static final int LOAD_FILE_DELETE = 2;
    public static final int LOAD_NOT_SUPPORT = 1;
    public static final int LOAD_NOT_SUPPORT_VERSION = 4;
    public static final int LOAD_PARAMS_ERROR = 3;
    public static final int LOAD_SUCCESS = 0;
    private static final String kEY_TIME_COST = "timecost";

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class ReportData {
        private long pluginVersion;
        private long retCode;
        private String eventId = "";
        private String qua = QUA.getQUA3();
        private String pluginType = "";
        private String uin = QCircleHostStubUtil.getCurrentAccount();
        private String ext1 = "";
        private String ext2 = "";
        private String ext3 = "";
        private String timeCost = "";
        private String netWorkTyp = QCircleReportHelper.getNetworkType();

        public String getEventId() {
            return this.eventId;
        }

        public String getExt1() {
            return this.ext1;
        }

        public String getExt2() {
            return this.ext2;
        }

        public String getExt3() {
            return this.ext3;
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

        public ReportData setExt3(String str) {
            this.ext3 = str;
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
        return new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("uin", QCircleHostStubUtil.getCurrentAccount()), QCircleReportHelper.newEntry("qua", reportData.getQua()), QCircleReportHelper.newEntry("network_type", reportData.getNetWorkTyp()), QCircleReportHelper.newEntry("event_id", reportData.getEventId()), QCircleReportHelper.newEntry("retcode", String.valueOf(reportData.getRetCode())), QCircleReportHelper.newEntry(KEY_PLUGIN_VERSION, String.valueOf(reportData.getPluginVersion())), QCircleReportHelper.newEntry(KEY_PLUGIN_TYPE, reportData.getPluginType()), QCircleReportHelper.newEntry("ext1", reportData.getExt1()), QCircleReportHelper.newEntry("ext2", reportData.getExt2()), QCircleReportHelper.newEntry("ext3", reportData.getExt3()), QCircleReportHelper.newEntry(kEY_TIME_COST, reportData.getTimeCost()), QCircleReportHelper.newEntry(KEY_DEVICE_INFO, Build.DEVICE)));
    }

    public static void report(final ReportData reportData) {
        if (reportData != null) {
            QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.ASEngineQualityReport.1
                @Override // java.lang.Runnable
                public void run() {
                    QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
                    qQCircleReport$SingleDcData.dcid.set(10004);
                    qQCircleReport$SingleDcData.report_data.addAll(ASEngineQualityReport.createEntries(ReportData.this));
                    QCircleReporter.getInstance().addQualityReportData(qQCircleReport$SingleDcData);
                }
            });
        }
    }
}
