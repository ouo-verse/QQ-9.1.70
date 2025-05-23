package cooperation.qqcircle.report;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
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
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import qqcircle.QQCircleReport$SingleDcData;
import uq3.c;
import uq3.o;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleAlphaUserReporter {
    private static final int DEF_BOUND = 100;
    public static final String DEF_RATE_CMD_LIST = "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedList|FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetCommentList|FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetFeedDetail|FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetMainpage|FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetNoticeList|FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.PublishFeed|FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoReply|FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoFollow|FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoPush|FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoLike|FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoReward|FeedCloudSvr.trpc.feedcloud.commwriter.ComWriter.DoTop|FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetWaterfallOfficialAccountFeeds|FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetWaterfallOfficialAccountSecondaryPageFeeds|FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetQQContactFriendHeadFeedList";
    private static final int DEF_REPORT_QUALITY_SAMPLE_RATE = 10;
    private static final String DEVICE_SPLIT_DIVISION = "\\|";
    public static final String KEY_ATTACH_INFO = "attachInfo";
    public static final String KEY_CLIENT_REPORT_CMD_SUCCESS_RATE_EVENT = "client_report_cmd_success_rate_event";
    public static final String KEY_CLIENT_REPORT_FOLDER_FUNNEL_EVENT = "client_report_folder_funnel_event";
    public static final String KEY_CLIENT_REPORT_LAUNCH_PERIOD_DURATION_EVENT = "client_launch_period_duration_event";
    public static final String KEY_CLIENT_REPORT_LOG_EVENT = "key_client_report_log_event";
    public static final String KEY_CLIENT_TIME = "client_time";
    public static final String KEY_CMD = "cmd";
    public static final String KEY_COUNT = "count";
    public static final String KEY_EVENT_ID = "event_id";
    public static final String KEY_EXTRA_INFO = "extraInfo";
    public static final String KEY_EXT_1 = "ext1";
    public static final String KEY_EXT_2 = "ext2";
    public static final String KEY_EXT_3 = "ext3";
    public static final String KEY_EXT_4 = "ext4";
    public static final String KEY_EXT_5 = "ext5";
    public static final String KEY_FEED_ID = "feed_id";
    public static final String KEY_FEED_ITEM_VIEW_NP_EXCEPTION_EVENT = "feed_item_view_np_exception_event";
    public static final String KEY_GW_RP_TRANSFER = "gw_rp_transfer";
    public static final String KEY_HOST_UIN = "host_uin";
    public static final String KEY_INFO = "info";
    public static final String KEY_MOBILE_TYPE = "mobile_type";
    public static final String KEY_MSG = "msg";
    public static final String KEY_NETWORK_TYPE = "network_type";
    public static final String KEY_PART_INIT_VIEW_NP_EXCEPTION_EVENT = "part_init_view_np_exception_event";
    public static final String KEY_PLATFORM = "platfrom";
    public static final String KEY_QUA = "qua";
    public static final String KEY_RATE = "rate";
    public static final String KEY_REFER = "refer";
    public static final String KEY_REPORT_SELF_SYSTEM_RESULT_EVENT = "report_self_check_system_result_event";
    public static final String KEY_RET_CODE = "ret_code";
    public static final String KEY_STATE = "state";
    public static final String KEY_SVR_RET_CODE = "svr_ret_code";
    public static final String KEY_TIME_COST = "time_cost";
    public static final String KEY_TRACE_ID = "trace_id";
    public static final String KEY_TYPE = "type";
    public static final String KEY_URL = "url";
    public static final String KEY_USER = "user";
    public static final String KEY_VERSION = "version";
    private static final String TAG = "QAR-QCircleAlphaUserReporter";
    private static final List<String> sCmdLists = new CopyOnWriteArrayList();
    private static final AtomicBoolean mHasReportSampleRate = new AtomicBoolean(false);
    private static boolean sIsEnabledReportSampleRatePrint = false;
    private static final AtomicBoolean sInitCmdListFlag = new AtomicBoolean(false);

    static /* synthetic */ int access$000() {
        return getDcId();
    }

    public static String convertListToStr(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.mo162put(str);
                }
            }
        }
        return jSONArray.toString();
    }

    public static List<String> convertStrToList(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                arrayList.add(jSONArray.optString(i3));
            }
        } catch (Throwable th5) {
            QLog.e("QCircleReportHelper_QAR-QCircleAlphaUserReporter", 1, "convertListFromStr exception:", th5);
        }
        return arrayList;
    }

    public static List<String> convertWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        try {
            return Arrays.asList(str.split(DEVICE_SPLIT_DIVISION));
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public static List<FeedCloudCommon$Entry> createBaseEntries(String str) {
        return new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("host_uin", ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()), QCircleReportHelper.newEntry(KEY_PLATFORM, "AND"), QCircleReportHelper.newEntry("version", ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName()), QCircleReportHelper.newEntry("qua", QUA.getQUA3()), QCircleReportHelper.newEntry("network_type", QCircleReportHelper.getNetworkType()), QCircleReportHelper.newEntry("mobile_type", DeviceInfoMonitor.getModel() + "_" + Build.VERSION.RELEASE), QCircleReportHelper.newEntry("client_time", String.valueOf(System.currentTimeMillis())), QCircleReportHelper.newEntry("event_id", str)));
    }

    private static void doClientLogReport(final QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder, final String str) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleAlphaUserReporter.1
            @Override // java.lang.Runnable
            public void run() {
                QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
                qQCircleReport$SingleDcData.dcid.set(QCircleAlphaUserReporter.access$000());
                qQCircleReport$SingleDcData.report_data.addAll(QCircleAlphaUserReporter.createBaseEntries(str));
                ArrayList arrayList = new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("cmd", qCircleAlphaUserReportDataBuilder.cmd), QCircleReportHelper.newEntry(QCircleAlphaUserReporter.KEY_SVR_RET_CODE, qCircleAlphaUserReportDataBuilder.svrRetCode), QCircleReportHelper.newEntry("ret_code", qCircleAlphaUserReportDataBuilder.retCode), QCircleReportHelper.newEntry("info", qCircleAlphaUserReportDataBuilder.info), QCircleReportHelper.newEntry("msg", qCircleAlphaUserReportDataBuilder.f261575msg), QCircleReportHelper.newEntry("time_cost", String.valueOf(qCircleAlphaUserReportDataBuilder.timeCost)), QCircleReportHelper.newEntry("url", qCircleAlphaUserReportDataBuilder.url), QCircleReportHelper.newEntry("rate", String.valueOf(qCircleAlphaUserReportDataBuilder.rate)), QCircleReportHelper.newEntry("type", qCircleAlphaUserReportDataBuilder.type), QCircleReportHelper.newEntry("refer", qCircleAlphaUserReportDataBuilder.refer), QCircleReportHelper.newEntry("attachInfo", qCircleAlphaUserReportDataBuilder.attachInfo), QCircleReportHelper.newEntry("extraInfo", qCircleAlphaUserReportDataBuilder.extraInfo), QCircleReportHelper.newEntry("count", String.valueOf(qCircleAlphaUserReportDataBuilder.count)), QCircleReportHelper.newEntry("state", qCircleAlphaUserReportDataBuilder.state), QCircleReportHelper.newEntry("feed_id", qCircleAlphaUserReportDataBuilder.feedId), QCircleReportHelper.newEntry(QCircleAlphaUserReporter.KEY_USER, qCircleAlphaUserReportDataBuilder.user), QCircleReportHelper.newEntry(QCircleAlphaUserReporter.KEY_GW_RP_TRANSFER, qCircleAlphaUserReportDataBuilder.gwRpTransfer), QCircleReportHelper.newEntry("ext1", qCircleAlphaUserReportDataBuilder.ext1), QCircleReportHelper.newEntry("ext2", qCircleAlphaUserReportDataBuilder.ext2), QCircleReportHelper.newEntry("ext3", qCircleAlphaUserReportDataBuilder.ext3), QCircleReportHelper.newEntry("ext4", qCircleAlphaUserReportDataBuilder.ext4), QCircleReportHelper.newEntry("ext5", qCircleAlphaUserReportDataBuilder.ext5)));
                arrayList.addAll(QCircleReportHelper.convertEntryList(qCircleAlphaUserReportDataBuilder.extras));
                qQCircleReport$SingleDcData.report_data.addAll(arrayList);
                QCircleReporter.getInstance().addQualityReportData(qQCircleReport$SingleDcData, QCircleAlphaUserReporter.needPrintUSRLevelLog(str));
            }
        });
    }

    public static List<String> getCmdList() {
        return sCmdLists;
    }

    private static int getDcId() {
        return 10006;
    }

    public static void initNeedClientReportSuccessRateCmdList(String str) {
        if (!TextUtils.isEmpty(str)) {
            updateCmdList(convertStrToList(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean needPrintUSRLevelLog(String str) {
        return TextUtils.equals(str, KEY_CLIENT_REPORT_CMD_SUCCESS_RATE_EVENT);
    }

    public static void reportCmdSuccessRateEvent(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder) {
        if ("FeedCloudSvr.trpc.circlereport.clientreport.ClientReport.DataReport".equalsIgnoreCase(qCircleAlphaUserReportDataBuilder.cmd)) {
            return;
        }
        boolean K1 = o.K1();
        if (K1 != sIsEnabledReportSampleRatePrint) {
            QLog.d(TAG, 1, "[reportCmdSuccessRateEvent] isEnabledReportSampleRate: " + K1);
            sIsEnabledReportSampleRatePrint = K1;
        }
        if (!K1 && !c.V5()) {
            QLog.e(TAG, 1, "[reportCmdSuccessRateEvent] close req quality report, flow end.");
            return;
        }
        if (o.f1() && sCmdLists.isEmpty()) {
            AtomicBoolean atomicBoolean = sInitCmdListFlag;
            if (!atomicBoolean.get()) {
                atomicBoolean.set(true);
                updateCmdList(convertWhiteList(o.c0(DEF_RATE_CMD_LIST)));
                updateReportSampleRate(K1);
                atomicBoolean.set(false);
            }
        }
        if (K1 && !mHasReportSampleRate.get()) {
            QLog.d(TAG, 1, "[reportCmdSuccessRateEvent] not has report sample rate, flow end.");
            return;
        }
        if (!sCmdLists.contains(qCircleAlphaUserReportDataBuilder.cmd)) {
            QLog.e(TAG, 2, "reportCmdSuccessRateEvent cmd miss hit,input cmdName:" + qCircleAlphaUserReportDataBuilder.cmd);
            return;
        }
        doClientLogReport(qCircleAlphaUserReportDataBuilder, KEY_CLIENT_REPORT_CMD_SUCCESS_RATE_EVENT);
    }

    public static void reportFolderFunnelPeriodEvent(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder) {
        QLog.d(TAG, 1, "reportFolderFunnelPeriodEvent: type=", qCircleAlphaUserReportDataBuilder.type, ",state=", qCircleAlphaUserReportDataBuilder.state, ",refer=", qCircleAlphaUserReportDataBuilder.refer, ",count=", Integer.valueOf(qCircleAlphaUserReportDataBuilder.count), ",attachInfo=", qCircleAlphaUserReportDataBuilder.attachInfo);
        doClientLogReport(qCircleAlphaUserReportDataBuilder, KEY_CLIENT_REPORT_FOLDER_FUNNEL_EVENT);
    }

    public static void reportLaunchPeriodEvent(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder) {
        QLog.d(TAG, 1, "reportLaunchPeriodEvent: type=", qCircleAlphaUserReportDataBuilder.type, ",state=", qCircleAlphaUserReportDataBuilder.state, ",refer=", qCircleAlphaUserReportDataBuilder.refer, ",attachInfo=", qCircleAlphaUserReportDataBuilder.attachInfo);
        doClientLogReport(qCircleAlphaUserReportDataBuilder, KEY_CLIENT_REPORT_LAUNCH_PERIOD_DURATION_EVENT);
    }

    public static void reportLog(QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder) {
        doClientLogReport(qCircleAlphaUserReportDataBuilder, KEY_CLIENT_REPORT_LOG_EVENT);
    }

    public static void updateCmdList(List<String> list) {
        if (list != null && list.size() > 0) {
            List<String> list2 = sCmdLists;
            list2.clear();
            list2.addAll(list);
            QLog.d(TAG, 1, "[updateCmdList] sCmdLists: " + list2);
        }
    }

    private static void updateReportSampleRate(boolean z16) {
        boolean z17;
        if (!z16) {
            return;
        }
        try {
            int A0 = o.A0(10);
            boolean z18 = false;
            if (QCircleHostStubUtil.getCurrentAccountLongUin() != 0 && A0 != 0) {
                int nextInt = new Random().nextInt(100);
                if (RFWApplication.isPublicVersion()) {
                    AtomicBoolean atomicBoolean = mHasReportSampleRate;
                    if (nextInt < A0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    atomicBoolean.set(z17);
                } else {
                    mHasReportSampleRate.set(true);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[updateReportSampleRate] randomInt: ");
                sb5.append(nextInt);
                sb5.append(" | reportSampleRate: ");
                sb5.append(A0);
                sb5.append(" | mHasReportSampleRate: ");
                sb5.append(mHasReportSampleRate.get());
                sb5.append(" | isNotPublicVersion: ");
                if (!RFWApplication.isPublicVersion()) {
                    z18 = true;
                }
                sb5.append(z18);
                QLog.d(TAG, 1, sb5.toString());
                return;
            }
            mHasReportSampleRate.set(false);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[updateReportRate] ex: ", th5);
        }
    }

    public static void reportLog(String str, QCircleAlphaUserReportDataBuilder qCircleAlphaUserReportDataBuilder) {
        doClientLogReport(qCircleAlphaUserReportDataBuilder, str);
    }
}
