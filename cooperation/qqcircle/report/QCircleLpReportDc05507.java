package cooperation.qqcircle.report;

import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qcircle.api.constant.b;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import qqcircle.QQCircleReport$SingleDcData;
import uq3.o;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleLpReportDc05507 {
    public static final String KEY_ACTIONTYPE = "actiontype";
    public static final String KEY_ACTTIME = "acttime";
    public static final String KEY_AUTHOR_UIN = "author_uin";
    public static final String KEY_CLEAR = "clear";
    public static final String KEY_CUBAGE = "cubage";
    public static final String KEY_ERROR_CODE = "errorcode";
    public static final String KEY_EXT_1 = "ext1";
    public static final String KEY_EXT_10 = "ext10";
    public static final String KEY_EXT_11 = "ext11";
    public static final String KEY_EXT_12 = "ext12";
    public static final String KEY_EXT_13 = "ext13";
    public static final String KEY_EXT_14 = "ext14";
    public static final String KEY_EXT_2 = "ext2";
    public static final String KEY_EXT_3 = "ext3";
    public static final String KEY_EXT_4 = "ext4";
    public static final String KEY_EXT_5 = "ext5";
    public static final String KEY_EXT_6 = "ext6";
    public static final String KEY_EXT_7 = "ext7";
    public static final String KEY_EXT_8 = "ext8";
    public static final String KEY_EXT_9 = "ext9";
    public static final String KEY_FEEDID = "feedid";
    public static final String KEY_FEEDTYPE1 = "feedtype1";
    public static final String KEY_FEEDTYPE2 = "feedtype2";
    public static final String KEY_FEEDTYPE3 = "feedtype3";
    public static final String KEY_FEED_TAG = "feed_tag";
    public static final String KEY_FEED_URL = "feeds_url";
    public static final String KEY_FFPAGE_ID = "ffpage_id";
    public static final String KEY_FIRST_FEEDID = "firstFeedID";
    public static final String KEY_FPAGE_ID = "fpage_id";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_IS_AUTO_PLAY = "is_auto_play";
    public static final String KEY_ITEM_DETAIL = "item_detail";
    public static final String KEY_LLOC = "lloc";
    public static final String KEY_LUOMA_TRANSFER = "luoma_transfe";
    public static final String KEY_META_DATA = "meta_data";
    public static final String KEY_MUSIC_ID = "music_id";
    public static final String KEY_PAGE_ID = "page_id";
    public static final String KEY_PIC_INFO = "pic_info";
    public static final String KEY_PLAY_ID = "play_id";
    public static final String KEY_PLAY_SCENE = "play_scene";
    public static final String KEY_PLAY_URL = "play_url";
    public static final String KEY_POSITION_ID = "position_id";
    public static final String KEY_REQUESTID = "requestid";
    public static final String KEY_RULE_ID = "rule_id";
    public static final String KEY_SEAL_TRANSFER = "seal_transfer";
    public static final String KEY_SUBACTIONTYPE = "subactiontype";
    public static final String KEY_TIANJI_TRANSFER = "tianji_transfer";
    public static final String KEY_TMPL_ID = "tmpl_id";
    public static final String KEY_TOUIN = "touin";
    public static final String KEY_VID = "vid";
    public static final String KEY_VIDEO_PLAY_TIME = "video_play_time";
    public static final String KEY_VIDEO_SOLO_TIME = "video_solo_time";
    public static final String KEY_VIDEO_TAG = "video_tag";
    public static final String KEY_VIDEO_TOTAL_TIME = "video_total_time";
    public static final String KEY_VIDEO_TYPE = "video_type";
    public static final String KEY_WIDTH = "width";
    private static final String TAG = "QCircleLpReportDc05507";

    private static void changeReportThreadInner(final DataBuilder dataBuilder, final boolean z16) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleLpReportDc05507.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleLpReportDc05507.reportThreadInner(DataBuilder.this, z16);
            }
        });
    }

    static void doReportInner(DataBuilder dataBuilder, boolean z16) {
        if (QCircleReporter.getInstance().getReportHandler().getLooper().getThread() == Thread.currentThread()) {
            reportThreadInner(dataBuilder, z16);
        } else {
            changeReportThreadInner(dataBuilder, z16);
        }
    }

    private static int getDcId() {
        return LaunchScene.LAUNCH_SCENE_ICGAME_LANDING_PAGE;
    }

    public static boolean isShareAction(int i3, int i16) {
        if (i3 != 25 && i3 != 26 && i3 != 27 && i3 != 28 && i3 != 124 && i3 != 125 && i3 != 127) {
            return false;
        }
        return true;
    }

    private static boolean needReportNow(int i3, int i16) {
        if (i3 == 1 || i3 == 2 || isShareAction(i3, i16)) {
            return true;
        }
        return false;
    }

    public static void report(DataBuilder dataBuilder, boolean z16) {
        if (dataBuilder == null) {
            QLog.e("QCircleReportBean_QCircleLpReportDc05507", 1, "report invalid builder is null!");
            return;
        }
        if (dataBuilder.pageId <= 0) {
            if (o.m1()) {
                int max = Math.max(QCircleReportHelper.getInstance().getCurrentScene(), 0);
                QLog.d("QCircleReportBean_QCircleLpReportDc05507", 1, "[report] invalid pid:" + dataBuilder.pageId + ",try use global pid: " + max + ",actionType: " + dataBuilder.actionType + ",subActionType: " + dataBuilder.subActionType);
                dataBuilder.pageId = max;
            } else {
                QLog.e("QCircleReportBean_QCircleLpReportDc05507", 1, "[report] invalid pid:," + dataBuilder.pageId + ",actionType:" + dataBuilder.actionType + ",subActionType:" + dataBuilder.subActionType);
            }
        }
        doReportInner(dataBuilder, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportThreadInner(DataBuilder dataBuilder, boolean z16) {
        dataBuilder.mergeFrom();
        FeedCloudCommon$Entry[] feedCloudCommon$EntryArr = new FeedCloudCommon$Entry[51];
        feedCloudCommon$EntryArr[0] = QCircleReportHelper.newEntry("touin", dataBuilder.toUin);
        feedCloudCommon$EntryArr[1] = QCircleReportHelper.newEntry("actiontype", String.valueOf(dataBuilder.actionType));
        feedCloudCommon$EntryArr[2] = QCircleReportHelper.newEntry("subactiontype", String.valueOf(dataBuilder.subActionType));
        feedCloudCommon$EntryArr[3] = QCircleReportHelper.newEntry("feedid", dataBuilder.feedId);
        feedCloudCommon$EntryArr[4] = QCircleReportHelper.newEntry("author_uin", dataBuilder.authorUin);
        feedCloudCommon$EntryArr[5] = QCircleReportHelper.newEntry(KEY_PLAY_SCENE, String.valueOf(dataBuilder.playScene));
        feedCloudCommon$EntryArr[6] = QCircleReportHelper.newEntry(KEY_POSITION_ID, String.valueOf(dataBuilder.position + 1));
        feedCloudCommon$EntryArr[7] = QCircleReportHelper.newEntry("feed_tag", dataBuilder.feedTag);
        feedCloudCommon$EntryArr[8] = QCircleReportHelper.newEntry("play_url", dataBuilder.playUrl);
        feedCloudCommon$EntryArr[9] = QCircleReportHelper.newEntry(KEY_VIDEO_TAG, dataBuilder.videoTag);
        feedCloudCommon$EntryArr[10] = QCircleReportHelper.newEntry(KEY_PIC_INFO, dataBuilder.picInfo);
        feedCloudCommon$EntryArr[11] = QCircleReportHelper.newEntry("music_id", dataBuilder.musicId);
        feedCloudCommon$EntryArr[12] = QCircleReportHelper.newEntry(KEY_ITEM_DETAIL, dataBuilder.itemDetail);
        feedCloudCommon$EntryArr[13] = QCircleReportHelper.newEntry("acttime", String.valueOf(dataBuilder.actTime));
        feedCloudCommon$EntryArr[14] = QCircleReportHelper.newEntry("vid", dataBuilder.vid);
        feedCloudCommon$EntryArr[15] = QCircleReportHelper.newEntry("lloc", dataBuilder.lloc);
        feedCloudCommon$EntryArr[16] = QCircleReportHelper.newEntry(KEY_SEAL_TRANSFER, dataBuilder.sealTransfer);
        feedCloudCommon$EntryArr[17] = QCircleReportHelper.newEntry("tmpl_id", dataBuilder.tmplId);
        feedCloudCommon$EntryArr[18] = QCircleReportHelper.newEntry("ext1", dataBuilder.ext1);
        feedCloudCommon$EntryArr[19] = QCircleReportHelper.newEntry("ext2", dataBuilder.ext2);
        feedCloudCommon$EntryArr[20] = QCircleReportHelper.newEntry("ext3", dataBuilder.ext3);
        feedCloudCommon$EntryArr[21] = QCircleReportHelper.newEntry("ext4", dataBuilder.ext4);
        feedCloudCommon$EntryArr[22] = QCircleReportHelper.newEntry("ext5", dataBuilder.ext5);
        feedCloudCommon$EntryArr[23] = QCircleReportHelper.newEntry("ext6", dataBuilder.ext6);
        feedCloudCommon$EntryArr[24] = QCircleReportHelper.newEntry("ext7", dataBuilder.ext7);
        feedCloudCommon$EntryArr[25] = QCircleReportHelper.newEntry("ext8", dataBuilder.ext8);
        feedCloudCommon$EntryArr[26] = QCircleReportHelper.newEntry("ext9", dataBuilder.ext9);
        feedCloudCommon$EntryArr[27] = QCircleReportHelper.newEntry("ext10", dataBuilder.ext10);
        feedCloudCommon$EntryArr[28] = QCircleReportHelper.newEntry("ext11", dataBuilder.ext11);
        feedCloudCommon$EntryArr[29] = QCircleReportHelper.newEntry("ext12", dataBuilder.ext12);
        feedCloudCommon$EntryArr[30] = QCircleReportHelper.newEntry("ext13", dataBuilder.ext13);
        feedCloudCommon$EntryArr[31] = QCircleReportHelper.newEntry("ext14", dataBuilder.ext14);
        feedCloudCommon$EntryArr[32] = QCircleReportHelper.newEntry("meta_data", dataBuilder.metaData);
        feedCloudCommon$EntryArr[33] = QCircleReportHelper.newEntry("rule_id", dataBuilder.ruleId);
        feedCloudCommon$EntryArr[34] = QCircleReportHelper.newEntry(KEY_FEED_URL, dataBuilder.feedUrl);
        feedCloudCommon$EntryArr[35] = QCircleReportHelper.newEntry("requestid", dataBuilder.requestId);
        feedCloudCommon$EntryArr[36] = QCircleReportHelper.newEntry("feedtype1", String.valueOf(dataBuilder.feedType1));
        feedCloudCommon$EntryArr[37] = QCircleReportHelper.newEntry("feedtype2", String.valueOf(dataBuilder.feedType2));
        feedCloudCommon$EntryArr[38] = QCircleReportHelper.newEntry("feedtype3", String.valueOf(dataBuilder.feedType3));
        feedCloudCommon$EntryArr[39] = QCircleReportHelper.newEntry(KEY_VIDEO_TOTAL_TIME, String.valueOf(dataBuilder.videoTotalTime));
        feedCloudCommon$EntryArr[40] = QCircleReportHelper.newEntry("video_type", dataBuilder.videoType);
        feedCloudCommon$EntryArr[41] = QCircleReportHelper.newEntry(KEY_CUBAGE, String.valueOf(dataBuilder.cubage));
        feedCloudCommon$EntryArr[42] = QCircleReportHelper.newEntry("width", String.valueOf(dataBuilder.width));
        feedCloudCommon$EntryArr[43] = QCircleReportHelper.newEntry("height", String.valueOf(dataBuilder.height));
        feedCloudCommon$EntryArr[44] = QCircleReportHelper.newEntry(KEY_CLEAR, String.valueOf(dataBuilder.clear));
        feedCloudCommon$EntryArr[45] = QCircleReportHelper.newEntry(KEY_PLAY_ID, dataBuilder.playId);
        feedCloudCommon$EntryArr[46] = QCircleReportHelper.newEntry(KEY_VIDEO_PLAY_TIME, String.valueOf(dataBuilder.videoPlayTime));
        feedCloudCommon$EntryArr[47] = QCircleReportHelper.newEntry(KEY_VIDEO_SOLO_TIME, String.valueOf(dataBuilder.videoSoloTime));
        feedCloudCommon$EntryArr[48] = QCircleReportHelper.newEntry("is_auto_play", dataBuilder.isAutoPlay ? "1" : "0");
        feedCloudCommon$EntryArr[49] = QCircleReportHelper.newEntry("errorcode", dataBuilder.errorCode);
        feedCloudCommon$EntryArr[50] = QCircleReportHelper.newEntry(KEY_FIRST_FEEDID, dataBuilder.firstFeedId);
        ArrayList arrayList = new ArrayList(Arrays.asList(feedCloudCommon$EntryArr));
        if (dataBuilder.pageId > -1) {
            arrayList.add(QCircleReportHelper.newEntry("page_id", String.valueOf(dataBuilder.pageId)));
        } else {
            arrayList.add(QCircleReportHelper.newEntry("page_id", "0"));
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
        if (dataBuilder.extras != null) {
            arrayList.addAll(QCircleReportHelper.convertEntryList(dataBuilder.extras));
        }
        arrayList.addAll(QCircleReportHelper.getInstance().newBaseEntries());
        QQCircleReport$SingleDcData newSingleDcData = QCircleReportHelper.newSingleDcData(getDcId(), arrayList, null, QCircleReportHelper.getInstance().newSessionEntries(dataBuilder.pageId, dataBuilder.reportInfo));
        if (QCircleReportHelper.getInstance().hasValidSession() || z16) {
            QCircleReporter.getInstance().add(newSingleDcData, needReportNow(dataBuilder.actionType, dataBuilder.subActionType));
            return;
        }
        QLog.w(QCircleReporter.TAG, 1, "QCircleLpReportDc05507 report miss Session: actiontype:" + dataBuilder.actionType + ",subActionType:" + dataBuilder.subActionType + ",add Miss Session report cache list");
        QCircleReporter.getInstance().addMissSessionReportDataCache(newSingleDcData);
    }

    public static void report(DataBuilder dataBuilder) {
        QFSAuthorUinMonitorManager.getInstance().checkFeedAuthorUin(dataBuilder);
        report(dataBuilder, false);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class DataBuilder {
        private long actTime;
        private int actionType;
        private int clear;
        private int cubage;
        private int fPageId;
        private int feedType1;
        private int feedType2;
        private int feedType3;
        private int height;
        private DataBuilder mDataBuilder;
        private int pageId;
        private int playScene;
        private int position;
        private byte[] reportInfo;
        private int subActionType;
        private long videoPlayTime;
        private long videoSoloTime;
        private int videoTotalTime;
        private int width;
        private String toUin = "";
        private String feedId = "";
        private String authorUin = "";
        private int ffPageId = -1;
        private String ruleId = "";
        private String requestId = "";
        private String feedUrl = "";
        private String videoType = "";
        private boolean isAutoPlay = false;
        private String playId = "";
        private String vid = "";
        private String lloc = "";
        private String feedTag = "";
        private String playUrl = "";
        private String errorCode = "";
        private String videoTag = "";
        private String picInfo = "";
        private String musicId = "";
        private String itemDetail = "";
        private String firstFeedId = "";
        private String sealTransferNew = "";
        private String sealTransfer = "";
        private String tmplId = "";
        private String ext1 = "";
        private String ext2 = "";
        private String ext3 = "";
        private String ext4 = "";
        private String ext5 = "";
        private String ext6 = "";
        private String ext7 = "";
        private String ext8 = "";
        private String ext9 = "";
        private String ext10 = "";
        private String ext11 = "";
        private String ext12 = "";
        private String ext13 = "";
        private String ext14 = "";
        private String metaData = "";
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

        public int getClear() {
            return this.clear;
        }

        public int getCubage() {
            return this.cubage;
        }

        public String getErrorCode() {
            return this.errorCode;
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

        public String getFeedUrl() {
            return this.feedUrl;
        }

        public int getFfPageId() {
            return this.ffPageId;
        }

        public String getFirstFeedId() {
            return this.firstFeedId;
        }

        public int getHeight() {
            return this.height;
        }

        public String getItemDetail() {
            return this.itemDetail;
        }

        public String getLloc() {
            return this.lloc;
        }

        public String getMetaData() {
            return this.metaData;
        }

        public String getMusicId() {
            return this.musicId;
        }

        public int getPageId() {
            return this.pageId;
        }

        public String getPicInfo() {
            return this.picInfo;
        }

        public String getPlayId() {
            return this.playId;
        }

        public int getPlayScene() {
            return this.playScene;
        }

        public String getPlayUrl() {
            return this.playUrl;
        }

        public int getPosition() {
            return this.position;
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

        public String getSealTransferNew() {
            return this.sealTransferNew;
        }

        public int getSubActionType() {
            return this.subActionType;
        }

        public String getTmplId() {
            return this.tmplId;
        }

        public String getToUin() {
            return this.toUin;
        }

        public String getVid() {
            return this.vid;
        }

        public long getVideoPlayTime() {
            return this.videoPlayTime;
        }

        public long getVideoSoloTime() {
            return this.videoSoloTime;
        }

        public String getVideoTag() {
            return this.videoTag;
        }

        public int getVideoTotalTime() {
            return this.videoTotalTime;
        }

        public String getVideoType() {
            return this.videoType;
        }

        public int getWidth() {
            return this.width;
        }

        public int getfPageId() {
            return this.fPageId;
        }

        public boolean isAutoPlay() {
            return this.isAutoPlay;
        }

        public void mergeFrom() {
            DataBuilder dataBuilder = this.mDataBuilder;
            if (dataBuilder != null) {
                dataBuilder.mergeFrom();
                DataBuilder dataBuilder2 = this.mDataBuilder;
                this.feedType1 = dataBuilder2.feedType1;
                this.feedType2 = dataBuilder2.feedType2;
                this.feedType3 = dataBuilder2.feedType3;
                setVideoType(dataBuilder2.videoType);
                setTmplId(this.mDataBuilder.tmplId);
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

        public DataBuilder setAutoPlay(boolean z16) {
            this.isAutoPlay = z16;
            return this;
        }

        public DataBuilder setClear(int i3) {
            this.clear = i3;
            return this;
        }

        public DataBuilder setCubage(int i3) {
            this.cubage = i3;
            return this;
        }

        public DataBuilder setErrorCode(String str) {
            this.errorCode = str;
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
            this.extras.putAll(hashMap);
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

        public DataBuilder setFeedUrl(String str) {
            this.feedUrl = str;
            return this;
        }

        public DataBuilder setFfPageId(int i3) {
            this.ffPageId = i3;
            return this;
        }

        public DataBuilder setFirstFeedId(String str) {
            this.firstFeedId = str;
            return this;
        }

        public DataBuilder setHeight(int i3) {
            this.height = i3;
            return this;
        }

        public DataBuilder setIsAutoPlay(boolean z16) {
            this.isAutoPlay = z16;
            return this;
        }

        public DataBuilder setItemDetail(String str) {
            this.itemDetail = str;
            return this;
        }

        public DataBuilder setLloc(String str) {
            this.lloc = str;
            return this;
        }

        public DataBuilder setMetaData(String str) {
            this.metaData = str;
            return this;
        }

        public DataBuilder setMusicId(String str) {
            this.musicId = str;
            return this;
        }

        public DataBuilder setPageId(int i3) {
            this.pageId = i3;
            return this;
        }

        public DataBuilder setPicInfo(String str) {
            this.picInfo = str;
            return this;
        }

        public DataBuilder setPlayId(String str) {
            this.playId = str;
            return this;
        }

        public DataBuilder setPlayScene(int i3) {
            this.playScene = i3;
            return this;
        }

        public DataBuilder setPlayUrl(String str) {
            this.playUrl = str;
            return this;
        }

        public DataBuilder setPosition(int i3) {
            this.position = i3;
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

        public DataBuilder setSealTransfer(String str) {
            this.sealTransfer = str;
            return this;
        }

        public DataBuilder setSealTransferNew(String str) {
            this.sealTransferNew = str;
            return this;
        }

        public DataBuilder setSubActionType(int i3) {
            this.subActionType = i3;
            return this;
        }

        public void setTmplId(String str) {
            this.tmplId = str;
        }

        public DataBuilder setToUin(String str) {
            this.toUin = str;
            return this;
        }

        public DataBuilder setVid(String str) {
            this.vid = str;
            return this;
        }

        public DataBuilder setVideoPlayTime(long j3) {
            this.videoPlayTime = j3;
            return this;
        }

        public DataBuilder setVideoSoloTime(long j3) {
            this.videoSoloTime = j3;
            return this;
        }

        public DataBuilder setVideoTag(String str) {
            this.videoTag = str;
            return this;
        }

        public DataBuilder setVideoTotalTime(int i3) {
            this.videoTotalTime = i3;
            return this;
        }

        public DataBuilder setVideoType(String str) {
            this.videoType = str;
            return this;
        }

        public DataBuilder setWidth(int i3) {
            this.width = i3;
            return this;
        }

        public DataBuilder setfpageid(int i3) {
            this.fPageId = i3;
            return this;
        }

        public void updateDataBuilder(b bVar) {
            if (bVar == null) {
                return;
            }
            setToUin(bVar.U());
            setActionType(bVar.b());
            setSubActionType(bVar.S());
            setFeedType1(bVar.x());
            setFeedType2(bVar.y());
            setFeedType3(bVar.z());
            setFeedId(bVar.v());
            setAuthorUin(bVar.c());
            setPlayScene(bVar.K());
            setPageId(bVar.H());
            setfpageid(bVar.c0());
            setFfPageId(bVar.B());
            setRuleId(bVar.P());
            setRequestId(bVar.O());
            setFeedUrl(bVar.A());
            setPosition(bVar.M());
            setVideoTotalTime(bVar.Z());
            setVideoPlayTime(bVar.W());
            setVideoSoloTime(bVar.X());
            setVideoType(bVar.a0());
            setIsAutoPlay(bVar.d0());
            setCubage(bVar.e());
            setWidth(bVar.b0());
            setHeight(bVar.D());
            setClear(bVar.d());
            setPlayId(bVar.J());
            setActTime(bVar.a());
            setVid(bVar.V());
            setLloc(bVar.F());
            setFeedTag(bVar.w());
            setPlayUrl(bVar.L());
            setErrorCode(bVar.f());
            setVideoTag(bVar.Y());
            setPicInfo(bVar.I());
            setItemDetail(bVar.E());
            setFirstFeedId(bVar.C());
            setSealTransferNew(bVar.R());
            setSealTransfer(bVar.Q());
            setTmplId(bVar.T());
            setExt1(bVar.g());
            setExt2(bVar.m());
            setExt3(bVar.n());
            setExt4(bVar.o());
            setExt5(bVar.p());
            setExt6(bVar.q());
            setExt7(bVar.r());
            setExt8(bVar.s());
            setExt9(bVar.t());
            setExt10(bVar.h());
            setExt11(bVar.i());
            setExt12(bVar.j());
            setExt13(bVar.k());
            setExt14(bVar.l());
            setMetaData(bVar.G());
            setReportInfo(bVar.N());
            this.extras.putAll(bVar.u());
        }

        public DataBuilder(DataBuilder dataBuilder) {
            updateDataBuilder(dataBuilder);
        }

        public void updateDataBuilder(DataBuilder dataBuilder) {
            if (dataBuilder == null) {
                return;
            }
            setToUin(dataBuilder.toUin);
            setActionType(dataBuilder.actionType);
            setSubActionType(dataBuilder.subActionType);
            setFeedType1(dataBuilder.feedType1);
            setFeedType2(dataBuilder.feedType2);
            setFeedType3(dataBuilder.feedType3);
            setFeedId(dataBuilder.feedId);
            setAuthorUin(dataBuilder.authorUin);
            setPlayScene(dataBuilder.playScene);
            setPageId(dataBuilder.pageId);
            setfpageid(dataBuilder.fPageId);
            setFfPageId(dataBuilder.ffPageId);
            setRuleId(dataBuilder.ruleId);
            setRequestId(dataBuilder.requestId);
            setFeedUrl(dataBuilder.feedUrl);
            setPosition(dataBuilder.position);
            setVideoTotalTime(dataBuilder.videoTotalTime);
            setVideoPlayTime(dataBuilder.videoPlayTime);
            setVideoSoloTime(dataBuilder.videoSoloTime);
            setVideoType(dataBuilder.videoType);
            setIsAutoPlay(dataBuilder.isAutoPlay);
            setCubage(dataBuilder.cubage);
            setWidth(dataBuilder.width);
            setHeight(dataBuilder.height);
            setClear(dataBuilder.clear);
            setPlayId(dataBuilder.playId);
            setActTime(dataBuilder.actTime);
            setVid(dataBuilder.vid);
            setLloc(dataBuilder.lloc);
            setFeedTag(dataBuilder.feedTag);
            setPlayUrl(dataBuilder.playUrl);
            setErrorCode(dataBuilder.errorCode);
            setVideoTag(dataBuilder.videoTag);
            setPicInfo(dataBuilder.picInfo);
            setMusicId(dataBuilder.musicId);
            setItemDetail(dataBuilder.itemDetail);
            setFirstFeedId(dataBuilder.firstFeedId);
            setSealTransferNew(dataBuilder.sealTransferNew);
            setSealTransfer(dataBuilder.sealTransfer);
            setTmplId(dataBuilder.tmplId);
            setExt1(dataBuilder.ext1);
            setExt2(dataBuilder.ext2);
            setExt3(dataBuilder.ext3);
            setExt4(dataBuilder.ext4);
            setExt5(dataBuilder.ext5);
            setExt6(dataBuilder.ext6);
            setExt7(dataBuilder.ext7);
            setExt8(dataBuilder.ext8);
            setExt9(dataBuilder.ext9);
            setExt10(dataBuilder.ext10);
            setExt11(dataBuilder.ext11);
            setExt12(dataBuilder.ext12);
            setExt13(dataBuilder.ext13);
            setExt14(dataBuilder.ext14);
            setMetaData(dataBuilder.metaData);
            setReportInfo(dataBuilder.reportInfo);
            this.extras.putAll(dataBuilder.extras);
            this.mDataBuilder = dataBuilder;
        }

        public DataBuilder(b bVar) {
            updateDataBuilder(bVar);
        }
    }
}
