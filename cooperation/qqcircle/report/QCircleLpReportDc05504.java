package cooperation.qqcircle.report;

import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublicAccountDc5504ActionType;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.MobileQQ;
import qqcircle.QQCircleReport$SingleDcData;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleLpReportDc05504 {
    public static final String KEY_ACTIONTYPE = "actiontype";
    public static final String KEY_EXT_1 = "ext1";
    public static final String KEY_EXT_10 = "ext10";
    public static final String KEY_EXT_11 = "ext11";
    public static final String KEY_EXT_12 = "ext12";
    public static final String KEY_EXT_13 = "ext13";
    public static final String KEY_EXT_14 = "ext14";
    public static final String KEY_EXT_15 = "ext15";
    public static final String KEY_EXT_16 = "ext16";
    public static final String KEY_EXT_17 = "ext17";
    public static final String KEY_EXT_18 = "ext18";
    public static final String KEY_EXT_2 = "ext2";
    public static final String KEY_EXT_3 = "ext3";
    public static final String KEY_EXT_4 = "ext4";
    public static final String KEY_EXT_5 = "ext5";
    public static final String KEY_EXT_6 = "ext6";
    public static final String KEY_EXT_7 = "ext7";
    public static final String KEY_EXT_8 = "ext8";
    public static final String KEY_EXT_9 = "ext9";
    public static final String KEY_FFPAGE_ID = "ffpage_id";
    public static final String KEY_FPAGE_ID = "fpage_id";
    public static final String KEY_PAGE_ID = "page_id";
    public static final String KEY_SUBACTIONTYPE = "subactiontype";
    public static final String KEY_THR_ACTION = "thr_action";
    public static final String KEY_TOUIN = "touin";
    public static final String KEY_VID = "vid";
    private static final String TAG = "QCircleLpReportDc05504";

    static /* synthetic */ int access$2700() {
        return getDcId();
    }

    static void doReportInner(final DataBuilder dataBuilder) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleLpReportDc05504.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("touin", DataBuilder.this.toUin), QCircleReportHelper.newEntry("actiontype", String.valueOf(DataBuilder.this.actionType)), QCircleReportHelper.newEntry("subactiontype", String.valueOf(DataBuilder.this.subActionType)), QCircleReportHelper.newEntry("thr_action", String.valueOf(DataBuilder.this.thrActionType)), QCircleReportHelper.newEntry("vid", String.valueOf(DataBuilder.this.vid)), QCircleReportHelper.newEntry("ext1", DataBuilder.this.ext1), QCircleReportHelper.newEntry("ext2", DataBuilder.this.ext2), QCircleReportHelper.newEntry("ext3", DataBuilder.this.ext3), QCircleReportHelper.newEntry("ext4", DataBuilder.this.ext4), QCircleReportHelper.newEntry("ext5", DataBuilder.this.ext5), QCircleReportHelper.newEntry("ext6", DataBuilder.this.ext6), QCircleReportHelper.newEntry("ext7", DataBuilder.this.ext7), QCircleReportHelper.newEntry("ext8", DataBuilder.this.ext8), QCircleReportHelper.newEntry("ext9", DataBuilder.this.ext9), QCircleReportHelper.newEntry("ext10", DataBuilder.this.ext10), QCircleReportHelper.newEntry("ext11", DataBuilder.this.ext11), QCircleReportHelper.newEntry("ext12", DataBuilder.this.ext12), QCircleReportHelper.newEntry("ext13", DataBuilder.this.ext13), QCircleReportHelper.newEntry("ext14", DataBuilder.this.ext14), QCircleReportHelper.newEntry("ext15", DataBuilder.this.ext15), QCircleReportHelper.newEntry("ext16", DataBuilder.this.ext16), QCircleReportHelper.newEntry("ext17", DataBuilder.this.ext17), QCircleReportHelper.newEntry("ext18", DataBuilder.this.ext18)));
                if (DataBuilder.this.pageId > -1) {
                    arrayList.add(QCircleReportHelper.newEntry("page_id", String.valueOf(DataBuilder.this.pageId)));
                } else {
                    arrayList.add(QCircleReportHelper.newEntry("page_id", "0"));
                }
                if (DataBuilder.this.fPageId > -1) {
                    arrayList.add(QCircleReportHelper.newEntry("fpage_id", String.valueOf(DataBuilder.this.fPageId)));
                } else {
                    arrayList.add(QCircleReportHelper.newEntry("fpage_id", "0"));
                }
                if (DataBuilder.this.ffPageId > -1) {
                    arrayList.add(QCircleReportHelper.newEntry("ffpage_id", String.valueOf(DataBuilder.this.ffPageId)));
                } else {
                    arrayList.add(QCircleReportHelper.newEntry("ffpage_id", "0"));
                }
                arrayList.addAll(QCircleReportHelper.getInstance().newBaseEntries());
                arrayList.addAll(QCircleReportHelper.convertEntryList(DataBuilder.this.extras));
                QQCircleReport$SingleDcData newSingleDcData = QCircleReportHelper.newSingleDcData(QCircleLpReportDc05504.access$2700(), arrayList, null, QCircleReportHelper.getInstance().newSessionEntries(DataBuilder.this.pageId, DataBuilder.this.feedReportInfo, DataBuilder.this.msgReportInfo, DataBuilder.this.commExtReportInfo));
                if (!QCircleReportHelper.getInstance().hasValidSession() && !QCircleLpReportDc05504.reportWithoutSessionCheck(DataBuilder.this.actionType)) {
                    QLog.w(QCircleReporter.TAG, 1, "QCircleLpReportDc05504 report miss Session: actiontype:" + DataBuilder.this.actionType + ",subActionType:" + DataBuilder.this.subActionType + ",thrActionType:" + DataBuilder.this.thrActionType + ",add Miss Session report cache list");
                    QCircleReporter.getInstance().addMissSessionReportDataCache(newSingleDcData);
                    return;
                }
                QCircleReporter.getInstance().add(newSingleDcData, false);
            }
        });
    }

    private static int getDcId() {
        return 5504;
    }

    public static void report(DataBuilder dataBuilder) {
        if (dataBuilder == null) {
            QLog.e(TAG, 1, "DataBuilder == null");
        } else {
            doReportInner(dataBuilder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean reportWithoutSessionCheck(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 111 || i3 == 150 || QCirclePublicAccountDc5504ActionType.isPublicAccountActionType(i3) || MobileQQ.sProcessId == 9) {
            return true;
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class DataBuilder {
        private int actionType;
        private byte[] commExtReportInfo;
        private String ext1;
        private String ext10;
        private String ext11;
        private String ext12;
        private String ext13;
        private String ext14;
        private String ext15;
        private String ext16;
        private String ext17;
        private String ext18;
        private String ext2;
        private String ext3;
        private String ext4;
        private String ext5;
        private String ext6;
        private String ext7;
        private String ext8;
        private String ext9;
        private byte[] feedReportInfo;
        private byte[] msgReportInfo;
        private int pageId;
        private int subActionType;
        private int thrActionType;
        private String toUin;
        private String vid;
        private int fPageId = -1;
        private int ffPageId = -1;
        private HashMap<String, String> extras = new HashMap<>();

        public DataBuilder() {
        }

        public int getActionType() {
            return this.actionType;
        }

        public byte[] getCommExtReportInfo() {
            return this.commExtReportInfo;
        }

        public String getExt1() {
            return this.ext1;
        }

        public String getExt10() {
            return this.ext10;
        }

        public String getExt11() {
            return this.ext11;
        }

        public String getExt12() {
            return this.ext12;
        }

        public String getExt13() {
            return this.ext13;
        }

        public String getExt14() {
            return this.ext14;
        }

        public String getExt15() {
            return this.ext15;
        }

        public String getExt16() {
            return this.ext16;
        }

        public String getExt17() {
            return this.ext17;
        }

        public String getExt18() {
            return this.ext18;
        }

        public String getExt2() {
            return this.ext2;
        }

        public String getExt3() {
            return this.ext3;
        }

        public String getExt4() {
            return this.ext4;
        }

        public String getExt5() {
            return this.ext5;
        }

        public String getExt6() {
            return this.ext6;
        }

        public String getExt7() {
            return this.ext7;
        }

        public String getExt8() {
            return this.ext8;
        }

        public String getExt9() {
            return this.ext9;
        }

        public HashMap<String, String> getExtras() {
            return this.extras;
        }

        public byte[] getFeedReportInfo() {
            return this.feedReportInfo;
        }

        public int getFfPageId() {
            return this.ffPageId;
        }

        public byte[] getMsgReportInfo() {
            return this.msgReportInfo;
        }

        public int getPageId() {
            return this.pageId;
        }

        public int getSubActionType() {
            return this.subActionType;
        }

        public int getThrActionType() {
            return this.thrActionType;
        }

        public String getToUin() {
            return this.toUin;
        }

        public String getVid() {
            return this.vid;
        }

        public int getfPageId() {
            return this.fPageId;
        }

        public DataBuilder setActionType(int i3) {
            this.actionType = i3;
            return this;
        }

        public DataBuilder setCommonReportInfo(byte[] bArr) {
            this.commExtReportInfo = bArr;
            return this;
        }

        public DataBuilder setExt1(String str) {
            this.ext1 = str;
            return this;
        }

        public DataBuilder setExt10(String str) {
            this.ext10 = str;
            return this;
        }

        public DataBuilder setExt11(String str) {
            this.ext11 = str;
            return this;
        }

        public DataBuilder setExt12(String str) {
            this.ext12 = str;
            return this;
        }

        public DataBuilder setExt13(String str) {
            this.ext13 = str;
            return this;
        }

        public DataBuilder setExt14(String str) {
            this.ext14 = str;
            return this;
        }

        public DataBuilder setExt15(String str) {
            this.ext15 = str;
            return this;
        }

        public DataBuilder setExt16(String str) {
            this.ext16 = str;
            return this;
        }

        public DataBuilder setExt17(String str) {
            this.ext17 = str;
            return this;
        }

        public DataBuilder setExt18(String str) {
            this.ext18 = str;
            return this;
        }

        public DataBuilder setExt2(String str) {
            this.ext2 = str;
            return this;
        }

        public DataBuilder setExt3(String str) {
            this.ext3 = str;
            return this;
        }

        public DataBuilder setExt4(String str) {
            this.ext4 = str;
            return this;
        }

        public DataBuilder setExt5(String str) {
            this.ext5 = str;
            return this;
        }

        public DataBuilder setExt6(String str) {
            this.ext6 = str;
            return this;
        }

        public DataBuilder setExt7(String str) {
            this.ext7 = str;
            return this;
        }

        public DataBuilder setExt8(String str) {
            this.ext8 = str;
            return this;
        }

        public DataBuilder setExt9(String str) {
            this.ext9 = str;
            return this;
        }

        public DataBuilder setExtras(HashMap<String, String> hashMap) {
            this.extras = hashMap;
            return this;
        }

        public DataBuilder setFeedReportInfo(byte[] bArr) {
            this.feedReportInfo = bArr;
            return this;
        }

        public DataBuilder setFfPageId(int i3) {
            this.ffPageId = i3;
            return this;
        }

        public DataBuilder setMsgReportInfo(byte[] bArr) {
            this.msgReportInfo = bArr;
            return this;
        }

        public DataBuilder setPageId(int i3) {
            this.pageId = i3;
            return this;
        }

        public DataBuilder setSubActionType(int i3) {
            this.subActionType = i3;
            return this;
        }

        public DataBuilder setThrActionType(int i3) {
            this.thrActionType = i3;
            return this;
        }

        public DataBuilder setToUin(String str) {
            this.toUin = str;
            return this;
        }

        public DataBuilder setfPageId(int i3) {
            this.fPageId = i3;
            return this;
        }

        public DataBuilder setvid(String str) {
            this.vid = str;
            return this;
        }

        public void updateDataBuilder(DataBuilder dataBuilder) {
            if (dataBuilder == null) {
                return;
            }
            this.toUin = dataBuilder.toUin;
            this.actionType = dataBuilder.actionType;
            this.subActionType = dataBuilder.subActionType;
            this.thrActionType = dataBuilder.thrActionType;
            this.pageId = dataBuilder.pageId;
            this.fPageId = dataBuilder.fPageId;
            this.ffPageId = dataBuilder.ffPageId;
            this.vid = dataBuilder.vid;
            this.ext1 = dataBuilder.ext1;
            this.ext2 = dataBuilder.ext2;
            this.ext3 = dataBuilder.ext3;
            this.ext4 = dataBuilder.ext4;
            this.ext5 = dataBuilder.ext5;
            this.ext6 = dataBuilder.ext6;
            this.ext7 = dataBuilder.ext7;
            this.ext8 = dataBuilder.ext8;
            this.ext9 = dataBuilder.ext9;
            this.ext10 = dataBuilder.ext10;
            this.ext11 = dataBuilder.ext11;
            this.ext12 = dataBuilder.ext12;
            this.ext13 = dataBuilder.ext13;
            this.ext14 = dataBuilder.ext14;
            this.ext15 = dataBuilder.ext15;
            this.ext16 = dataBuilder.ext16;
            this.ext17 = dataBuilder.ext17;
            this.ext18 = dataBuilder.ext18;
            this.feedReportInfo = dataBuilder.feedReportInfo;
            this.msgReportInfo = dataBuilder.msgReportInfo;
            this.commExtReportInfo = dataBuilder.commExtReportInfo;
            HashMap<String, String> hashMap = new HashMap<>();
            this.extras = hashMap;
            hashMap.putAll(dataBuilder.extras);
        }

        public DataBuilder(DataBuilder dataBuilder) {
            updateDataBuilder(dataBuilder);
        }

        public DataBuilder(QCircleLpReportDc05504DataBuilder qCircleLpReportDc05504DataBuilder) {
            updateDataBuilder(qCircleLpReportDc05504DataBuilder);
        }

        public void updateDataBuilder(QCircleLpReportDc05504DataBuilder qCircleLpReportDc05504DataBuilder) {
            if (qCircleLpReportDc05504DataBuilder == null) {
                return;
            }
            this.toUin = qCircleLpReportDc05504DataBuilder.getToUin();
            this.actionType = qCircleLpReportDc05504DataBuilder.getActionType();
            this.subActionType = qCircleLpReportDc05504DataBuilder.getSubActionType();
            this.thrActionType = qCircleLpReportDc05504DataBuilder.getThrActionType();
            this.pageId = qCircleLpReportDc05504DataBuilder.getPageId();
            this.fPageId = qCircleLpReportDc05504DataBuilder.getfPageId();
            this.ffPageId = qCircleLpReportDc05504DataBuilder.getFfPageId();
            this.vid = qCircleLpReportDc05504DataBuilder.getVid();
            this.ext1 = qCircleLpReportDc05504DataBuilder.getExt1();
            this.ext2 = qCircleLpReportDc05504DataBuilder.getExt2();
            this.ext3 = qCircleLpReportDc05504DataBuilder.getExt3();
            this.ext4 = qCircleLpReportDc05504DataBuilder.getExt4();
            this.ext5 = qCircleLpReportDc05504DataBuilder.getExt5();
            this.ext6 = qCircleLpReportDc05504DataBuilder.getExt6();
            this.ext7 = qCircleLpReportDc05504DataBuilder.getExt7();
            this.ext8 = qCircleLpReportDc05504DataBuilder.getExt8();
            this.ext9 = qCircleLpReportDc05504DataBuilder.getExt9();
            this.ext10 = qCircleLpReportDc05504DataBuilder.getExt10();
            this.ext11 = qCircleLpReportDc05504DataBuilder.getExt11();
            this.ext12 = qCircleLpReportDc05504DataBuilder.getExt12();
            this.ext13 = qCircleLpReportDc05504DataBuilder.getExt13();
            this.ext14 = qCircleLpReportDc05504DataBuilder.getExt14();
            this.ext15 = qCircleLpReportDc05504DataBuilder.getExt15();
            this.ext16 = qCircleLpReportDc05504DataBuilder.getExt16();
            this.ext17 = qCircleLpReportDc05504DataBuilder.getExt17();
            this.ext18 = qCircleLpReportDc05504DataBuilder.getExt18();
            this.feedReportInfo = qCircleLpReportDc05504DataBuilder.getFeedReportInfo();
            this.msgReportInfo = qCircleLpReportDc05504DataBuilder.getMsgReportInfo();
            this.commExtReportInfo = qCircleLpReportDc05504DataBuilder.getCommExtReportInfo();
            HashMap<String, String> hashMap = new HashMap<>();
            this.extras = hashMap;
            hashMap.putAll(qCircleLpReportDc05504DataBuilder.getExtras());
        }
    }
}
