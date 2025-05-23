package cooperation.qqcircle.report;

import android.os.Build;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.util.NetworkState;
import feedcloud.FeedCloudCommon$Entry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import qqcircle.QQCircleReport$SingleDcData;

/* loaded from: classes28.dex */
public class QCirclePublishQualityReporter {
    public static final String APPID = "appid";
    public static final String ATTACH_INFO = "attach_info";
    public static final String CLIENT_TIME = "client_time";
    public static final String DESC = "desc";
    public static final String DESC_MSG = "desc_msg";
    public static final String DEVICE_MODEL = "device_model";
    public static final String DEVICE_OS_VER = "device_os_ver";
    public static final String EXT1 = "ext1";
    public static final String EXT2 = "ext2";
    public static final String EXT3 = "ext3";
    public static final String EXT4 = "ext4";
    public static final String EXT5 = "ext5";
    public static final String EXT6 = "ext6";
    public static String E_CLEAN_MMKV = "E_CLEAN_MMKV";
    public static String E_DELETE_WINK_EDIT_DRAFT = "E_DELETE_WINK_EDIT_DRAFT";
    public static final String E_DID_LOADING = "E_DID_LOADING";
    public static String E_EXTRACT_VIDEO_COVER = "E_EXTRACT_VIDEO_COVER";
    public static String E_NOTIFICATION_CLICK = "E_NOTIFICATION_CLICK";
    public static String E_NOTIFICATION_SHOW = "E_NOTIFICATION_SHOW";
    public static final String E_PICKER_ENTER = "E_PICKER_ENTER";
    public static final String E_PICKER_EXIT_CANCEL = "E_PICKER_EXIT_CANCEL";
    public static final String E_PICKER_EXIT_NORMAL = "E_PICKER_EXIT_NORMAL";
    public static final String E_PICKER_EXPOSE = "E_PICKER_EXPOSE";
    public static String E_PUBLIC_BREAK = "E_PUBLIC_BREAK";
    public static String E_PUBLIC_CLICK = "E_PUBLIC_CLICK";
    public static String E_PUBLIC_START = "E_PUBLIC_START";
    public static String E_PUBLISH_AUTO_RECOVER_PUBLISH = "E_PUBLISH_AUTO_RECOVER_PUBLISH";
    public static String E_PUBLISH_BACKGROUND = "E_PUBLISH_BACKGROUND";
    public static String E_PUBLISH_CANCEL_UPLOAD = "E_PUBLISH_CANCEL_UPLOAD";
    public static String E_PUBLISH_CLICK_DRAFT = "E_PUBLISH_CLICK_DRAFT";
    public static String E_PUBLISH_CLICK_DRAFT_INTERRUPT = "E_PUBLISH_CLICK_DRAFT_INTERRUPT";
    public static String E_PUBLISH_RETRY_PUBLISH = "E_PUBLISH_RETRY_PUBLISH";
    public static String E_WINK_INDEX_ENTRY = "E_WINK_INDEX_ENTRY";
    public static final String INDEX = "index";
    public static String KEY_AUTO_TEMPLATE_TO_EDIT_PAGE = "key_auto_template_to_edit_page";
    public static final String KEY_CLICK_WEB_TIME = "KEY_CLICK_WEB_TIME";
    public static final String KEY_EVENT_ID = "event_id";
    public static String KEY_EXPORT_PIC = "key_export_pic";
    public static final String KEY_FALSE = "false";
    public static final String KEY_H5_TYPE = "KEY_H5_TYPE";
    public static final String KEY_HOST_UIN = "host_uin";
    public static String KEY_NEXT_STEP_TO_EDIT_PAGE = "key_next_step_to_edit_page";
    public static final String KEY_QUA = "qua";
    public static final String KEY_RET_CODE = "ret_code";
    public static String KEY_SWITCH_TO_CAMERA_TAB = "key_switch_to_camera_tab";
    public static final String KEY_TRUE = "true";
    public static final String NETWORK_TYPE = "network_type";
    public static String P_EXPORT_END = "P_EXPORT_END";
    public static String P_EXPORT_START = "P_EXPORT_START";
    public static String P_JUMP_PAGE_TIME_COST = "P_JUMP_PAGE_TIME_COST";
    public static String P_MATERIAL_COST_END = "P_MATERIAL_COST_END";
    public static String P_MATERIAL_COST_START = "P_MATERIAL_COST_START";
    public static String P_MATERIAL_DOWNLOAD_FINISH = "P_MATERIAL_DOWNLOAD_FINISH";
    public static final String P_PUBLISH_ACTIVITY_RESUME_COST_TIME = "P_PUBLISH_ACTIVITY_RESUME_COST_TIME";
    public static String P_PUBLISH_ALL_COST = "P_PUBLISH_ALL_COST";
    public static String P_UPLOAD_COST = "P_UPLOAD_COST";
    public static final String SAVE = "save";
    private static final String TAG = "[QcirclePublish][PublishUpload]QCirclePublishQualityReporter";
    public static final String TRACEID = "traceid";
    public static String T_CATCH_IMPORTANT_INFO = "T_CATCH_IMPORTANT_INFO";
    public static final String T_PICKER_NO_SO = "T_PICKER_NO_SO";
    public static String T_VIDEO_INFO = "T_VIDEO_INFO";
    private static final String VALUE_APPID = "100036";

    /* loaded from: classes28.dex */
    public static class Scene {
        public static String ERROR_EXPORT_VIDEO = "error_export_video";
        public static String SCENE_COPY_FILE = "scene_copy_file";
        public static String SCENE_KILL_PROCESS_IN_EDITOR = "scene_kill_process_in_editor";
    }

    public static String getTraceId() {
        String str = QCircleHostStubUtil.getCurrentAccount() + "_" + new SimpleDateFormat("MMddHHmmssSSS").format(new Date(System.currentTimeMillis())) + "_" + UUID.randomUUID();
        QLog.d(TAG, 1, "traceId:" + str);
        return str;
    }

    public static void report(int i3, QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        Date date;
        QLog.d(TAG, 1, "report... entity:" + qCirclePublishQualityDataBuilder.toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        if (qCirclePublishQualityDataBuilder.getReportTimeMillis() <= 0) {
            date = new Date(System.currentTimeMillis());
        } else {
            date = new Date(qCirclePublishQualityDataBuilder.getReportTimeMillis());
        }
        String format = simpleDateFormat.format(date);
        ArrayList arrayList = new ArrayList(toEntry(qCirclePublishQualityDataBuilder));
        arrayList.add(QCircleReportHelper.newEntry("host_uin", QCircleHostStubUtil.getCurrentAccount()));
        arrayList.add(QCircleReportHelper.newEntry("qua", QUA.getQUA3()));
        arrayList.add(QCircleReportHelper.newEntry("client_time", format));
        arrayList.add(QCircleReportHelper.newEntry("device_model", QCircleHostStubUtil.getDeviceName()));
        arrayList.add(QCircleReportHelper.newEntry("device_os_ver", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(QCircleReportHelper.newEntry("network_type", NetworkState.getNetworkTypeString()));
        arrayList.add(QCircleReportHelper.newEntry("appid", "100036"));
        reportQualityEvent(i3, arrayList);
    }

    public static void reportQualityEvent(final int i3, final List<FeedCloudCommon$Entry> list) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCirclePublishQualityReporter.1
            @Override // java.lang.Runnable
            public void run() {
                QQCircleReport$SingleDcData qQCircleReport$SingleDcData = new QQCircleReport$SingleDcData();
                qQCircleReport$SingleDcData.dcid.set(i3);
                List list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    qQCircleReport$SingleDcData.report_data.addAll(list);
                }
                QCircleReporter.getInstance().addQualityReportData(qQCircleReport$SingleDcData);
            }
        });
    }

    public static List<FeedCloudCommon$Entry> toEntry(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QCircleReportHelper.newEntry("ext1", qCirclePublishQualityDataBuilder.getExt1()));
        arrayList.add(QCircleReportHelper.newEntry("ext2", qCirclePublishQualityDataBuilder.getExt2()));
        arrayList.add(QCircleReportHelper.newEntry("ext3", qCirclePublishQualityDataBuilder.getExt3()));
        arrayList.add(QCircleReportHelper.newEntry("ext4", qCirclePublishQualityDataBuilder.getExt4()));
        arrayList.add(QCircleReportHelper.newEntry("ext5", qCirclePublishQualityDataBuilder.getExt5()));
        arrayList.add(QCircleReportHelper.newEntry("ext6", qCirclePublishQualityDataBuilder.getExt6()));
        arrayList.add(QCircleReportHelper.newEntry("traceid", qCirclePublishQualityDataBuilder.getTraceId()));
        arrayList.add(QCircleReportHelper.newEntry("event_id", qCirclePublishQualityDataBuilder.getKeyEventId()));
        arrayList.add(QCircleReportHelper.newEntry("ret_code", qCirclePublishQualityDataBuilder.getKeyRetCode()));
        arrayList.add(QCircleReportHelper.newEntry("attach_info", qCirclePublishQualityDataBuilder.getAttachInfo()));
        arrayList.add(QCircleReportHelper.newEntry("desc", qCirclePublishQualityDataBuilder.getDesc()));
        arrayList.add(QCircleReportHelper.newEntry("desc_msg", qCirclePublishQualityDataBuilder.getDesc()));
        return arrayList;
    }

    public static void report(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        QLog.d(TAG, 1, "report... entity:" + qCirclePublishQualityDataBuilder.toString());
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()));
        ArrayList arrayList = new ArrayList(toEntry(qCirclePublishQualityDataBuilder));
        arrayList.add(QCircleReportHelper.newEntry("host_uin", QCircleHostStubUtil.getCurrentAccount()));
        arrayList.add(QCircleReportHelper.newEntry("qua", QUA.getQUA3()));
        arrayList.add(QCircleReportHelper.newEntry("client_time", format));
        arrayList.add(QCircleReportHelper.newEntry("device_model", QCircleHostStubUtil.getDeviceName()));
        arrayList.add(QCircleReportHelper.newEntry("device_os_ver", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(QCircleReportHelper.newEntry("network_type", NetworkState.getNetworkTypeString()));
        arrayList.add(QCircleReportHelper.newEntry("appid", "100036"));
        reportQualityEvent(10008, arrayList);
    }

    public static void report(String str, List<FeedCloudCommon$Entry> list) {
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()));
        ArrayList arrayList = new ArrayList(list);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = (FeedCloudCommon$Entry) arrayList.get(i3);
            QLog.d(TAG, 1, str + " key:", feedCloudCommon$Entry.key.get(), " value:", feedCloudCommon$Entry.value.get());
        }
        arrayList.add(QCircleReportHelper.newEntry("host_uin", QCircleHostStubUtil.getCurrentAccount()));
        arrayList.add(QCircleReportHelper.newEntry("qua", QUA.getQUA3()));
        arrayList.add(QCircleReportHelper.newEntry("client_time", format));
        arrayList.add(QCircleReportHelper.newEntry("device_model", QCircleHostStubUtil.getDeviceName()));
        arrayList.add(QCircleReportHelper.newEntry("device_os_ver", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(QCircleReportHelper.newEntry("event_id", str));
        arrayList.add(QCircleReportHelper.newEntry("network_type", NetworkState.getNetworkTypeString()));
        arrayList.add(QCircleReportHelper.newEntry("appid", "100036"));
        reportQualityEvent(10008, arrayList);
    }

    public static void report(String str, List<FeedCloudCommon$Entry> list, boolean z16) {
        QCircleQualityReporter.reportQualityEvent(10008, str, list, z16);
    }
}
