package cooperation.qqcircle.report;

import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleLpReportDc05503 {
    public static final String KEY_EXT_1 = "ext1";
    public static final String KEY_EXT_2 = "ext2";
    public static final String KEY_EXT_3 = "ext3";
    public static final String KEY_EXT_4 = "ext4";
    public static final String KEY_EXT_5 = "ext5";
    public static final String KEY_EXT_6 = "ext6";
    public static final String KEY_LOGIN_TIME = "login_time";
    public static final String KEY_PAGE_ID = "page_id";
    public static final String KEY_STAY_TIME = "stay_time";

    static /* synthetic */ int access$000() {
        return getDcId();
    }

    private static int getDcId() {
        return 5503;
    }

    public static void report(long j3, long j16, long j17, int i3) {
        report(j3, j16, j17, "", "", "", "", "", "", i3);
    }

    public static void report(final long j3, final long j16, final long j17, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final int i3) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleLpReportDc05503.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("login_time", String.valueOf(j3)), QCircleReportHelper.newEntry("stay_time", String.valueOf(j16)), QCircleReportHelper.newEntry("page_id", String.valueOf(j17)), QCircleReportHelper.newEntry("ext1", str), QCircleReportHelper.newEntry("ext2", str2), QCircleReportHelper.newEntry("ext3", str3), QCircleReportHelper.newEntry("ext4", str4), QCircleReportHelper.newEntry("ext5", str5), QCircleReportHelper.newEntry("ext6", str6)));
                arrayList.addAll(QCircleReportHelper.getInstance().newBaseEntries());
                QCircleReporter.getInstance().add(QCircleReportHelper.newSingleDcData(QCircleLpReportDc05503.access$000(), arrayList, null, QCircleReportHelper.getInstance().newSessionEntries(i3)), false);
            }
        });
    }
}
