package cooperation.qqcircle.report;

import android.os.Build;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleLpReportDc05494 {
    public static final String KEY_AUTHOR_UIN = "author_uin";
    public static final String KEY_CITY_NAME = "city_name";
    public static final String KEY_COUNTRY_NAME = "country_name";
    public static final String KEY_DEVICE_MAKER = "device_maker";
    public static final String KEY_DEVICE_MODEL = "device_model";
    public static final String KEY_EXT_1 = "ext1";
    public static final String KEY_EXT_2 = "ext2";
    public static final String KEY_EXT_3 = "ext3";
    public static final String KEY_EXT_4 = "ext4";
    public static final String KEY_EXT_5 = "ext5";
    public static final String KEY_EXT_6 = "ext6";
    public static final String KEY_EXT_7 = "ext7";
    public static final String KEY_EXT_8 = "ext8";
    public static final String KEY_FEEDID = "feedid";
    public static final String KEY_FEED_TAG = "feed_tag";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_IP = "ip";
    public static final String KEY_IS_VIDEO = "is_video";
    public static final String KEY_LLOC = "lloc";
    public static final String KEY_ORIG_HEIGHT = "orig_height";
    public static final String KEY_ORIG_PHOTOCUBAGE = "orig_photocubage";
    public static final String KEY_ORIG_WIDTH = "orig_width";
    public static final String KEY_PHOTOCUBAGE = "photocubage";
    public static final String KEY_PHOTO_TAG = "photo_tag";
    public static final String KEY_PICTURE_FORMAT = "picture_format";
    public static final String KEY_PLACE = "place";
    public static final String KEY_PLACE_NAME = "place_name";
    public static final String KEY_PROV_NAME = "prov_name";
    public static final String KEY_SHOOTING_TIME = "shooting_time";
    public static final String KEY_SHOOT_MODEL = "shoot_model";
    public static final String KEY_SHOOT_PLACE = "shoot_place";
    public static final String KEY_SHOOT_PRODUCT = "shoot_product";
    public static final String KEY_TOTAL_UPLOAD_NUM = "total_upload_num";
    public static final String KEY_TOUIN = "touin";
    public static final String KEY_TXTINFO = "txtinfo";
    public static final String KEY_UP_PLACE = "up_place";
    public static final String KEY_UP_SOURCE = "up_source";
    public static final String KEY_UP_TYPE = "up_type";
    public static final String KEY_VID = "vid";
    public static final String KEY_WIDTH = "width";
    private static final String TAG = "QCircleLpReportDc05494";

    static /* synthetic */ int access$000() {
        return getDcId();
    }

    static /* synthetic */ int access$100() {
        return getScene();
    }

    private static int getDcId() {
        return 5494;
    }

    private static int getScene() {
        return 36;
    }

    public static void report(final QCircleTaskReportInfo qCircleTaskReportInfo) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleLpReportDc05494.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("up_source", String.valueOf(QCircleTaskReportInfo.this.up_source)), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_UP_TYPE, String.valueOf(QCircleTaskReportInfo.this.up_type)), QCircleReportHelper.newEntry("is_video", String.valueOf(QCircleTaskReportInfo.this.is_video)), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_TXTINFO, QCircleTaskReportInfo.this.txtinfo), QCircleReportHelper.newEntry("lloc", QCircleTaskReportInfo.this.lloc), QCircleReportHelper.newEntry("vid", QCircleTaskReportInfo.this.vid), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_PHOTOCUBAGE, String.valueOf(QCircleTaskReportInfo.this.clientCompressPicSize)), QCircleReportHelper.newEntry("feedid", QCircleTaskReportInfo.this.feedid), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_TOTAL_UPLOAD_NUM, String.valueOf(QCircleTaskReportInfo.this.total_upload_num)), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_DEVICE_MAKER, Build.BRAND), QCircleReportHelper.newEntry("device_model", DeviceInfoMonitor.getModel()), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_SHOOTING_TIME, QCircleTaskReportInfo.this.shooting_time), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_ORIG_PHOTOCUBAGE, String.valueOf(QCircleTaskReportInfo.this.editedPicSize)), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_PLACE, QCircleTaskReportInfo.this.place), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_UP_PLACE, QCircleTaskReportInfo.this.up_place), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_SHOOT_PRODUCT, QCircleTaskReportInfo.this.shoot_product), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_SHOOT_MODEL, QCircleTaskReportInfo.this.shoot_model), QCircleReportHelper.newEntry("width", String.valueOf(QCircleTaskReportInfo.this.clientCompressPicWidth)), QCircleReportHelper.newEntry("height", String.valueOf(QCircleTaskReportInfo.this.clientCompressPicHeight)), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_ORIG_WIDTH, String.valueOf(QCircleTaskReportInfo.this.editedPicWidth)), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_ORIG_HEIGHT, String.valueOf(QCircleTaskReportInfo.this.editedPicHeight)), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_PICTURE_FORMAT, QCircleTaskReportInfo.this.picture_format), QCircleReportHelper.newEntry("feed_tag", QCircleTaskReportInfo.this.feed_tag), QCircleReportHelper.newEntry("author_uin", String.valueOf(QCircleTaskReportInfo.this.author_uin)), QCircleReportHelper.newEntry(QCircleLpReportDc05494.KEY_SHOOT_PLACE, QCircleTaskReportInfo.this.shoot_place)));
                arrayList.addAll(QCircleReportHelper.getInstance().newBaseEntries());
                QCircleReporter.getInstance().add(QCircleReportHelper.newSingleDcData(QCircleLpReportDc05494.access$000(), arrayList, null, QCircleReportHelper.getInstance().newSessionEntries(QCircleLpReportDc05494.access$100())), false);
            }
        });
    }

    public static void report(ArrayList<QCircleTaskReportInfo> arrayList) {
        if (arrayList == null) {
            QLog.e("QCircleReportHelper_QCircleLpReportDc05494", 2, "taskReportInfos == null");
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            report(arrayList.get(i3));
        }
    }
}
