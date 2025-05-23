package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleLpReportDc05502 {
    public static final String KEY_AUTHOR_UIN = "author_uin";
    public static final String KEY_BEGIN_TIME = "begin_time";
    public static final String KEY_CONTAINERSEQ = "containerseq";
    public static final String KEY_END_TIME = "end_time";
    public static final String KEY_EXT_1 = "ext1";
    public static final String KEY_EXT_2 = "ext2";
    public static final String KEY_EXT_3 = "ext3";
    public static final String KEY_EXT_4 = "ext4";
    public static final String KEY_EXT_5 = "ext5";
    public static final String KEY_EXT_6 = "ext6";
    public static final String KEY_EXT_7 = "ext7";
    public static final String KEY_EXT_8 = "ext8";
    public static final String KEY_FEEDID = "feedid";
    public static final String KEY_FEEDTYPE1 = "feedtype1";
    public static final String KEY_FEEDTYPE2 = "feedtype2";
    public static final String KEY_FEEDTYPE3 = "feedtype3";
    public static final String KEY_FEED_TAG = "feed_tag";
    public static final String KEY_FFPAGE_ID = "ffpage_id";
    public static final String KEY_FPAGE_ID = "fpage_id";
    public static final String KEY_INDEX = "index";
    public static final String KEY_ISREADED = "isreaded";
    public static final String KEY_LUOMA_TRANSFER = "luoma_transfe";
    public static final String KEY_PAGE_ID = "page_id";
    public static final String KEY_REQUESTID = "requestid";
    public static final String KEY_RULE_ID = "rule_id";
    public static final String KEY_STAY_TIME = "stay_time";
    public static final String KEY_TIANJI_TRANSFER = "tianji_transfer";
    public static final String KEY_TOUIN = "touin";
    private static final String TAG = "QCircleLpReportDc05502";

    private static void changeReportThreadInner(final DataBuilder dataBuilder) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleLpReportDc05502.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleLpReportDc05502.reportThreadInner(DataBuilder.this);
            }
        });
    }

    static void doReportInner(DataBuilder dataBuilder) {
        if (QCircleReporter.getInstance().getReportHandler().getLooper().getThread() == Thread.currentThread()) {
            reportThreadInner(dataBuilder);
        } else {
            changeReportThreadInner(dataBuilder);
        }
    }

    private static int getDcId() {
        return 5502;
    }

    public static void report(DataBuilder dataBuilder) {
        if (dataBuilder == null) {
            QLog.e("QCircleReportBean_QCircleLpReportDc05502", 1, "report invalid builder is null!");
            return;
        }
        if (dataBuilder.pageId <= 0 && (QLog.isColorLevel() || QLog.isDebugVersion())) {
            QLog.e("QCircleReportBean_QCircleLpReportDc05502", 2, "report invalid pageId," + dataBuilder.pageId + ",fpageId:" + dataBuilder.fPageId);
        }
        doReportInner(dataBuilder);
    }

    static void reportThreadInner(DataBuilder dataBuilder) {
        dataBuilder.mergeFrom();
        ArrayList arrayList = new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("touin", dataBuilder.toUin), QCircleReportHelper.newEntry("index", String.valueOf(dataBuilder.index + 1)), QCircleReportHelper.newEntry("feedid", dataBuilder.feedId), QCircleReportHelper.newEntry("feed_tag", dataBuilder.feedTag), QCircleReportHelper.newEntry("isreaded", "1"), QCircleReportHelper.newEntry("page_id", String.valueOf(dataBuilder.pageId)), QCircleReportHelper.newEntry("fpage_id", String.valueOf(dataBuilder.fPageId)), QCircleReportHelper.newEntry("ffpage_id", String.valueOf(dataBuilder.ffPageId)), QCircleReportHelper.newEntry("requestid", dataBuilder.requestId), QCircleReportHelper.newEntry("rule_id", dataBuilder.ruleId), QCircleReportHelper.newEntry("containerseq", String.valueOf(dataBuilder.containerSeq)), QCircleReportHelper.newEntry(KEY_BEGIN_TIME, String.valueOf(dataBuilder.beginTime)), QCircleReportHelper.newEntry("end_time", String.valueOf(dataBuilder.endTime)), QCircleReportHelper.newEntry("stay_time", String.valueOf(dataBuilder.stayTime)), QCircleReportHelper.newEntry("author_uin", String.valueOf(dataBuilder.authorUin)), QCircleReportHelper.newEntry("feedtype1", String.valueOf(dataBuilder.feedType1)), QCircleReportHelper.newEntry("feedtype2", String.valueOf(dataBuilder.feedType2)), QCircleReportHelper.newEntry("feedtype3", String.valueOf(dataBuilder.feedType3)), QCircleReportHelper.newEntry("ext1", dataBuilder.ext1), QCircleReportHelper.newEntry("ext2", dataBuilder.ext2), QCircleReportHelper.newEntry("ext3", dataBuilder.ext3), QCircleReportHelper.newEntry("ext4", dataBuilder.ext4), QCircleReportHelper.newEntry("ext5", dataBuilder.ext5), QCircleReportHelper.newEntry("ext6", dataBuilder.ext6), QCircleReportHelper.newEntry("ext7", dataBuilder.ext7), QCircleReportHelper.newEntry("ext8", dataBuilder.ext8)));
        if (dataBuilder.extras != null) {
            arrayList.addAll(QCircleReportHelper.convertEntryList(dataBuilder.extras));
        }
        arrayList.addAll(QCircleReportHelper.getInstance().newBaseEntries());
        QCircleReporter.getInstance().add(QCircleReportHelper.newSingleDcData(getDcId(), arrayList, null, QCircleReportHelper.getInstance().newSessionEntries(dataBuilder.pageId, dataBuilder.reportInfo)), true);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class DataBuilder {
        private String authorUin;
        private long beginTime;
        private long endTime;
        private String ext1;
        private String ext2;
        private String ext3;
        private String ext4;
        private String ext5;
        private String ext6;
        private String ext7;
        private String ext8;
        private String feedId;
        private String feedTag;
        private int feedType1;
        private int feedType2;
        private int feedType3;
        private DataBuilder mDataBuilder;
        private int pageId;
        private byte[] reportInfo;
        private String requestId;
        private String ruleId;
        private long stayTime;
        private String toUin;
        private int index = -1;
        private int fPageId = -1;
        private int ffPageId = -1;
        private int containerSeq = -1;
        private HashMap<String, String> extras = new HashMap<>();

        public DataBuilder() {
        }

        public String getAuthorUin() {
            return this.authorUin;
        }

        public long getBeginTime() {
            return this.beginTime;
        }

        public int getContainerSeq() {
            return this.containerSeq;
        }

        public long getEndTime() {
            return this.endTime;
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

        public HashMap<String, String> getExtras() {
            return this.extras;
        }

        public String getFeedId() {
            return this.feedId;
        }

        public String getFeedTag() {
            return this.feedTag;
        }

        public int getFeedType1() {
            return this.feedType1;
        }

        public int getFeedType2() {
            return this.feedType2;
        }

        public int getFeedType3() {
            return this.feedType3;
        }

        public int getFfPageId() {
            return this.ffPageId;
        }

        public int getIndex() {
            return this.index;
        }

        public int getPageId() {
            return this.pageId;
        }

        public byte[] getReportInfo() {
            return this.reportInfo;
        }

        public String getRequestId() {
            return this.requestId;
        }

        public String getRuleId() {
            return this.ruleId;
        }

        public long getStayTime() {
            return this.stayTime;
        }

        public String getToUin() {
            return this.toUin;
        }

        public int getfPageId() {
            return this.fPageId;
        }

        public void mergeFrom() {
            DataBuilder dataBuilder = this.mDataBuilder;
            if (dataBuilder != null) {
                dataBuilder.mergeFrom();
                DataBuilder dataBuilder2 = this.mDataBuilder;
                this.feedType1 = dataBuilder2.feedType1;
                this.feedType2 = dataBuilder2.feedType2;
                this.feedType3 = dataBuilder2.feedType3;
            }
        }

        public DataBuilder setAuthorUin(String str) {
            this.authorUin = str;
            return this;
        }

        public DataBuilder setBeginTime(long j3) {
            this.beginTime = j3;
            return this;
        }

        public DataBuilder setContainerSeq(int i3) {
            this.containerSeq = i3;
            return this;
        }

        public DataBuilder setEndTime(long j3) {
            this.endTime = j3;
            return this;
        }

        public DataBuilder setExt1(String str) {
            this.ext1 = str;
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

        public DataBuilder setExtras(HashMap<String, String> hashMap) {
            this.extras = hashMap;
            return this;
        }

        public DataBuilder setFeedId(String str) {
            this.feedId = str;
            return this;
        }

        public DataBuilder setFeedTag(String str) {
            this.feedTag = str;
            return this;
        }

        public DataBuilder setFeedType1(int i3) {
            this.feedType1 = i3;
            return this;
        }

        public DataBuilder setFeedType2(int i3) {
            this.feedType2 = i3;
            return this;
        }

        public DataBuilder setFeedType3(int i3) {
            this.feedType3 = i3;
            return this;
        }

        public DataBuilder setFfPageId(int i3) {
            this.ffPageId = i3;
            return this;
        }

        public DataBuilder setIndex(int i3) {
            this.index = i3;
            return this;
        }

        public DataBuilder setPageId(int i3) {
            this.pageId = i3;
            return this;
        }

        public DataBuilder setReportInfo(byte[] bArr) {
            this.reportInfo = bArr;
            return this;
        }

        public DataBuilder setRequestId(String str) {
            this.requestId = str;
            return this;
        }

        public DataBuilder setRuleId(String str) {
            this.ruleId = str;
            return this;
        }

        public DataBuilder setStayTime(long j3) {
            this.stayTime = j3;
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

        public void updateDataBuilder(DataBuilder dataBuilder) {
            if (dataBuilder == null) {
                return;
            }
            this.toUin = dataBuilder.toUin;
            this.feedType1 = dataBuilder.feedType1;
            this.feedType2 = dataBuilder.feedType2;
            this.feedType3 = dataBuilder.feedType3;
            this.index = dataBuilder.index;
            this.feedId = dataBuilder.feedId;
            this.feedTag = dataBuilder.feedTag;
            this.pageId = dataBuilder.pageId;
            this.fPageId = dataBuilder.fPageId;
            this.ffPageId = dataBuilder.ffPageId;
            this.ruleId = dataBuilder.ruleId;
            this.containerSeq = dataBuilder.containerSeq;
            this.beginTime = dataBuilder.beginTime;
            this.endTime = dataBuilder.endTime;
            this.stayTime = dataBuilder.stayTime;
            this.authorUin = dataBuilder.authorUin;
            this.requestId = dataBuilder.requestId;
            this.ext1 = dataBuilder.ext1;
            this.ext2 = dataBuilder.ext2;
            this.ext3 = dataBuilder.ext3;
            this.ext4 = dataBuilder.ext4;
            this.ext5 = dataBuilder.ext5;
            this.ext6 = dataBuilder.ext6;
            this.ext7 = dataBuilder.ext7;
            this.ext8 = dataBuilder.ext8;
            this.reportInfo = dataBuilder.reportInfo;
            this.extras.putAll(dataBuilder.extras);
            this.mDataBuilder = dataBuilder;
        }

        public DataBuilder(DataBuilder dataBuilder) {
            updateDataBuilder(dataBuilder);
        }
    }
}
