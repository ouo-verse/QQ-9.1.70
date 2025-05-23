package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$BytesEntry;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import qqcircle.QQCircleReport$SingleDcData;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleLpReportDc05501 {
    public static final String KEY_ACTIONTYPE = "actiontype";
    public static final String KEY_ACTTIME = "acttime";
    public static final String KEY_AUTHOR_UIN = "author_uin";
    public static final String KEY_CONTAINERSEQ = "containerseq";
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
    public static final String KEY_PAGE_ID = "page_id";
    public static final String KEY_REQUESTID = "requestid";
    public static final String KEY_RULE_ID = "rule_id";
    public static final String KEY_SUBACTIONTYPE = "subactiontype";
    public static final String KEY_TOUIN = "touin";
    private static final String TAG = "QCircleLpReportDc05501";

    private static void changeReportThreadInner(final DataBuilder dataBuilder) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleLpReportDc05501.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleLpReportDc05501.reportThreadInner(DataBuilder.this);
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
        return 5501;
    }

    private static boolean isShareAction(int i3, int i16) {
        return QCircleLpReportDc05507.isShareAction(i3, i16);
    }

    private static boolean needReportNow(int i3, int i16) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        if ((i3 == 3 && i16 == 1) || isShareAction(i3, i16)) {
            return true;
        }
        if (i3 == 65 && i16 < 6) {
            return true;
        }
        return false;
    }

    public static void report(DataBuilder dataBuilder) {
        if (dataBuilder == null) {
            QLog.e(TAG, 1, "DataBuilder == null");
            return;
        }
        if (dataBuilder.pageId <= 0) {
            QLog.e("QCircleReportBean_QCircleLpReportDc05501", 1, "report invalid pageId," + dataBuilder.pageId + ",actionType:" + dataBuilder.actionType + ",subActionType:" + dataBuilder.subActionType);
        }
        doReportInner(dataBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportThreadInner(DataBuilder dataBuilder) {
        long j3;
        List<FeedCloudCommon$BytesEntry> newSessionEntries;
        dataBuilder.mergeFrom();
        FeedCloudCommon$Entry[] feedCloudCommon$EntryArr = new FeedCloudCommon$Entry[11];
        feedCloudCommon$EntryArr[0] = QCircleReportHelper.newEntry("touin", dataBuilder.toUin);
        feedCloudCommon$EntryArr[1] = QCircleReportHelper.newEntry("actiontype", String.valueOf(dataBuilder.actionType));
        feedCloudCommon$EntryArr[2] = QCircleReportHelper.newEntry("subactiontype", String.valueOf(dataBuilder.subActionType));
        feedCloudCommon$EntryArr[3] = QCircleReportHelper.newEntry("feedid", dataBuilder.feedId);
        feedCloudCommon$EntryArr[4] = QCircleReportHelper.newEntry("feed_tag", dataBuilder.feedTag);
        feedCloudCommon$EntryArr[5] = QCircleReportHelper.newEntry("isreaded", "1");
        feedCloudCommon$EntryArr[6] = QCircleReportHelper.newEntry("page_id", String.valueOf(dataBuilder.pageId));
        feedCloudCommon$EntryArr[7] = QCircleReportHelper.newEntry("author_uin", dataBuilder.authorUin);
        if (dataBuilder.actTime != 0) {
            j3 = dataBuilder.actTime;
        } else {
            j3 = System.currentTimeMillis();
        }
        feedCloudCommon$EntryArr[8] = QCircleReportHelper.newEntry("acttime", String.valueOf(j3));
        feedCloudCommon$EntryArr[9] = QCircleReportHelper.newEntry("rule_id", dataBuilder.ruleId);
        feedCloudCommon$EntryArr[10] = QCircleReportHelper.newEntry("requestid", dataBuilder.requestId);
        ArrayList arrayList = new ArrayList(Arrays.asList(feedCloudCommon$EntryArr));
        if (dataBuilder.index > -1) {
            arrayList.add(QCircleReportHelper.newEntry("index", String.valueOf(dataBuilder.index + 1)));
        }
        if (dataBuilder.containerSeq > -1) {
            arrayList.add(QCircleReportHelper.newEntry("containerseq", String.valueOf(dataBuilder.containerSeq + 1)));
        }
        if (dataBuilder.fPageId > -1) {
            arrayList.add(QCircleReportHelper.newEntry("fpage_id", String.valueOf(dataBuilder.fPageId)));
        } else {
            arrayList.add(QCircleReportHelper.newEntry("fpage_id", "0"));
        }
        if (dataBuilder.ffPageId > -1) {
            arrayList.add(QCircleReportHelper.newEntry("ffpage_id", String.valueOf(dataBuilder.ffPageId)));
        } else {
            arrayList.add(QCircleReportHelper.newEntry("ffpage_id", "0"));
        }
        arrayList.add(QCircleReportHelper.newEntry("feedtype1", String.valueOf(dataBuilder.feedType1)));
        arrayList.add(QCircleReportHelper.newEntry("feedtype2", String.valueOf(dataBuilder.feedType2)));
        arrayList.add(QCircleReportHelper.newEntry("feedtype3", String.valueOf(dataBuilder.feedType3)));
        arrayList.add(QCircleReportHelper.newEntry("ext1", dataBuilder.ext1));
        arrayList.add(QCircleReportHelper.newEntry("ext2", dataBuilder.ext2));
        arrayList.add(QCircleReportHelper.newEntry("ext3", dataBuilder.ext3));
        arrayList.add(QCircleReportHelper.newEntry("ext4", dataBuilder.ext4));
        arrayList.add(QCircleReportHelper.newEntry("ext5", dataBuilder.ext5));
        arrayList.add(QCircleReportHelper.newEntry("ext6", dataBuilder.ext6));
        arrayList.add(QCircleReportHelper.newEntry("ext7", dataBuilder.ext7));
        arrayList.add(QCircleReportHelper.newEntry("ext8", dataBuilder.ext8));
        arrayList.addAll(QCircleReportHelper.getInstance().newBaseEntries());
        arrayList.addAll(QCircleReportHelper.convertEntryList(dataBuilder.extras));
        if (dataBuilder.reportInfo != null) {
            newSessionEntries = QCircleReportHelper.getInstance().newSessionEntries(dataBuilder.pageId, dataBuilder.reportInfo);
        } else {
            newSessionEntries = QCircleReportHelper.getInstance().newSessionEntries(dataBuilder.pageId);
        }
        QQCircleReport$SingleDcData newSingleDcData = QCircleReportHelper.newSingleDcData(getDcId(), arrayList, null, newSessionEntries);
        if (QCircleReportHelper.getInstance().hasValidSession()) {
            QCircleReporter.getInstance().add(newSingleDcData, needReportNow(dataBuilder.actionType, dataBuilder.subActionType));
            return;
        }
        QLog.w(QCircleReporter.TAG, 1, "QCircleLpReportDc05501 report miss Session: actiontype:" + dataBuilder.actionType + ",subActionType:" + dataBuilder.subActionType + ",add Miss Session report cache list");
        QCircleReporter.getInstance().addMissSessionReportDataCache(newSingleDcData);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class DataBuilder {
        private long actTime;
        private int actionType;
        private String authorUin;
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
        private boolean isReaded;
        private DataBuilder mDataBuilder;
        private int pageId;
        private byte[] reportInfo;
        private String requestId;
        private String ruleId;
        private int subActionType;
        private String toUin;
        private int index = -1;
        private int fPageId = -1;
        private int ffPageId = -1;
        private int containerSeq = -1;
        private HashMap<String, String> extras = new HashMap<>();

        public DataBuilder() {
        }

        public long getActTime() {
            return this.actTime;
        }

        public int getActionType() {
            return this.actionType;
        }

        public String getAuthorUin() {
            return this.authorUin;
        }

        public int getContainerSeq() {
            return this.containerSeq;
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

        public int getSubActionType() {
            return this.subActionType;
        }

        public String getToUin() {
            return this.toUin;
        }

        public int getfPageId() {
            return this.fPageId;
        }

        public boolean isReaded() {
            return this.isReaded;
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

        public DataBuilder setActTime(long j3) {
            this.actTime = j3;
            return this;
        }

        public DataBuilder setActionType(int i3) {
            this.actionType = i3;
            return this;
        }

        public DataBuilder setAuthorUin(String str) {
            this.authorUin = str;
            return this;
        }

        public DataBuilder setContainerSeq(int i3) {
            this.containerSeq = i3;
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

        public DataBuilder setReaded(boolean z16) {
            this.isReaded = z16;
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

        public DataBuilder setSubActionType(int i3) {
            this.subActionType = i3;
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
            this.actionType = dataBuilder.actionType;
            this.subActionType = dataBuilder.subActionType;
            this.index = dataBuilder.index;
            this.feedId = dataBuilder.feedId;
            this.feedTag = dataBuilder.feedTag;
            this.isReaded = dataBuilder.isReaded;
            this.pageId = dataBuilder.pageId;
            this.fPageId = dataBuilder.fPageId;
            this.ffPageId = dataBuilder.ffPageId;
            this.ruleId = dataBuilder.ruleId;
            this.containerSeq = dataBuilder.containerSeq;
            this.actTime = dataBuilder.actTime;
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
            HashMap<String, String> hashMap = new HashMap<>();
            this.extras = hashMap;
            hashMap.putAll(dataBuilder.extras);
            this.mDataBuilder = dataBuilder;
        }

        public DataBuilder(DataBuilder dataBuilder) {
            updateDataBuilder(dataBuilder);
        }
    }
}
