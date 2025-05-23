package cooperation.qzone;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes28.dex */
public class QZoneClickReport {
    public static final int ACTION_TYPE_LIVE_READ = 8;
    public static final int RESERVE_TYPE_LIVE_NOT_DOWNLOAD_PLUGIN = 3;
    public static final String RESERVE_TYPE_LIVE_NOT_DOWNLOAD_PTU_SO = "1";
    public static final String RESERVE_TYPE_LIVE_NOT_DOWNLOAD_STL_SO = "2";
    public static final int SUB_ACTION_TYPE_LIVE_NOT_DOWNLOAD = 128;
    public static final String SUB_ACTION_TYPE_LIVE_OS_NOT_SUPPORT = "125";
    public static final int SUB_ACTION_TYPE_LIVE_PLUGIN_MANUL_DOWNLOAD = 129;
    public static final String SUB_ACTION_TYPE_LIVE_PLUS_CLICK = "1";
    private static String TAG = "QZoneClickReport";
    public static boolean isShowToast = false;
    public static int reportAmount;
    public static int reportRate;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class ClickReportConfig {
        public static final int ACTION_PUSH_ARRIVE = 2;
        public static final int ACTION_PUSH_CLEAR_BYAPP = 5;
        public static final int ACTION_PUSH_CLEAR_SYSTEM = 4;
        public static final int ACTION_PUSH_CLICK = 3;
        public static final int ACTION_PUSH_FAKE = 10;
        public static final String ACTION_QZONE_ENTRY_AND_UNREAD = "1";
        public static final String ACTION_TYPE_QQTOQZONE = "637";
        public static final String ACTION_TYPE_QQ_AIO_FEED_CARD = "330";
        public static final int ACTION_TYPE_QQ_SEARCH_FEED_CARD = 464;
        public static final int ACTION_TYPE_QZONE_RECOMMEND_FULLSCREEN = 27;
        public static final int ACTION_TYPE_QZONE_RECOMMEND_FULLSCREEN_MENU = 28;
        public static final int ACTION_TYPE_QZONE_RECOMMEND_FULLSCREEN_YYTAG = 33;
        public static final String ACTION_TYPE_TEMPLATE_SHUOSHUO = "655";
        public static final String ACTION_TYPE_TEMPLATE_SHUOSHUO_FEED = "654";
        public static final String LEBA_EXPOSE_SUB_ACTION = "10";
        public static final String LEBA_QZONE_ACTION = "637";
        public static final String LEBA_QZONE_ENTRR_NO_RED_SUB_ACTION = "13";
        public static final String LEBA_QZONE_ENTRY_ACTIVE_REVERSE_CLICK = "2";
        public static final String LEBA_QZONE_ENTRY_ACTIVE_REVERSE_EXPOSE = "1";
        public static final String LEBA_QZONE_ENTRY_ACTIVE_SUB_ACTION = "11";
        public static final String LEBA_QZONE_ENTRY_NO_RED_REVERSE_CLICK = "2";
        public static final String LEBA_QZONE_ENTRY_NO_RED_REVERSE_EXPOSE = "1";
        public static final String LEBA_QZONE_ENTRY_PASSIVE_REVERSE_CLICK = "2";
        public static final String LEBA_QZONE_ENTRY_PASSIVE_REVERSE_EXPOSE = "1";
        public static final String LEBA_QZONE_ENTRY_PASSIVE_SUB_ACTION = "12";
        public static final int LIVEVIDEO_CLICK_PUSH_SUB = 3;
        public static final int LIVEVIDEO_PUSH_ACTIONTYPE = 322;
        public static final int LIVEVIDEO_PUSH_ARRIVE_RESERVES = 6;
        public static final int LIVEVIDEO_PUSH_ARRIVE_SUB = 2;
        public static final int LIVEVIDEO_PUSH_CLICK_RESERVES = 7;
        public static final int LIVE_ACTION_TYPE = 3;
        public static final int LIVE_ACTION_TYPE_READ_CLICK = 8;
        public static final int LIVE_SUBACTION_TYPE = 7;
        public static final int LIVE_SUBACTION_TYPE_CLICK = 113;
        public static final int LIVE_SUBACTION_TYPE_EXPOSURE = 112;
        public static final String RESERVE10_QQ_AIO_FEED_ENTRY = "1";
        public static final int RESERVES_PIC_TEXT_AUDIO = 1;
        public static final int RESERVES_TEMPLATE_SHUOSHUO_ICON_CLICK = 1;
        public static final String RESERVE_QQ_AIO_FEED_CARD_BLOG = "3";
        public static final String RESERVE_QQ_AIO_FEED_CARD_OHTER = "4";
        public static final String RESERVE_QQ_AIO_FEED_CARD_PHOTO = "1";
        public static final String RESERVE_QQ_AIO_FEED_CARD_SHUOSHUO = "2";
        public static final String RESERVE_QQ_AIO_FEED_ENTRY_CLICK = "2";
        public static final String RESERVE_QQ_AIO_FEED_ENTRY_EXPOSE = "1";
        public static final int RESERVE_QQ_SEARCH_FEED_CARD_BLOG = 3;
        public static final int RESERVE_QQ_SEARCH_FEED_CARD_OHTER = 4;
        public static final int RESERVE_QQ_SEARCH_FEED_CARD_PHOTO = 1;
        public static final int RESERVE_QQ_SEARCH_FEED_CARD_SHUOSHUO = 2;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_CLICK_AVATAR = 2;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_CLICK_CLOSE = 3;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_CLICK_COMMENT = 9;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_CLICK_COMMENT_AREA = 7;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_CLICK_FOLLOW = 11;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_CLICK_FORWARD = 13;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_CLICK_MENU = 10;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_CLICK_PAUSE = 4;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_CLICK_PLAY = 5;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_CLICK_PRAISE = 8;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_CLICK_UNFOLLOW = 12;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_EXPOSURE = 1;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_MENU_CLICK_COLLECT = 5;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_MENU_CLICK_DOWNLOAD = 10;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_MENU_CLICK_FOLLOW = 8;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_MENU_CLICK_QQ = 2;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_MENU_CLICK_QZONE = 1;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_MENU_CLICK_REPORT = 7;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_MENU_CLICK_UNCOLLECT = 6;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_MENU_CLICK_UNFOLLOW = 9;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_MENU_CLICK_WECHAT = 3;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_MENU_CLICK_WECHAT_CIRCLE = 4;
        public static final int RESERVE_QZONE_RECOMMEND_FULLSCREEN_SEEK = 6;
        public static final String REVERSE_DIGIT_RED_DOT = "3";
        public static final String REVERSE_NONE_RED_DOT = "1";
        public static final String REVERSE_NORMAL_RED_DOT = "2";
        public static final String SOURCE_FROM_AIO = "AIO";
        public static final String SOURCE_FROM_DRAWER = "drawerAlbumList";
        public static final String SOURCE_FROM_MAINENTRY = "mainEntrance";
        public static final String SOURCE_FROM_PUSH = "push";
        public static final String SOURCE_FROM_THIRDAPP = "thirdApp";
        public static final String SOURCE_FROM_USERPROFILE = "userSummary";
        public static final String SOURCE_TO_FEEDDETAIL = "detailPage";
        public static final String SOURCE_TO_FRIENDFEED = "activefeed";
        public static final String SOURCE_TO_PHOTOLIST = "QZonePhotoListActivity";
        public static final String SOURCE_TO_PUBLISHMOOD = "QZonePublishMoodActivity";
        public static final String SOURCE_TO_UPLOADPHOTO = "QZoneUploadPhotosActivity";
        public static final String SOURCE_TO_USERHOME = "homePage";
        public static final String SOURCE_TYPE_CLICKACTION = "3";
        public static final String SOURCE_TYPE_OTHER = "6";
        public static final String SOURCE_TYPE_PUSH = "1";
        public static final String SOURCE_TYPE_SCHEMA = "2";
        public static final String SOURCE_TYPE_THIRDAPP = "5";
        public static final String SOURCE_TYPE_VISITOR = "4";
        public static final String SUBACTION_ACTIVE_OPENQZONE = "0";
        public static final String SUBACTION_LEBA_UNDELCOUNT_ACTIVE = "6";
        public static final String SUBACTION_LEBA_UNDELCOUNT_PASSIVE = "5";
        public static final int SUBACTION_PUSH = 0;
        public static final String SUB_ACTIOIN_TEMPLATE_SHUOSHUO_ICON = "27";
        public static final String SUB_ACTION_CLICK_PUBLISH = "6";
        public static final String SUB_ACTION_CLICK_RERECORD = "7";
        public static final String SUB_ACTION_TYPE_EXPOSE = "1";
        public static final String SUB_ACTION_TYPE_FEEDSCLICK = "4";
        public static final String SUB_ACTION_TYPE_FEEDSEXPOURSE = "3";
        public static final String SUB_ACTION_TYPE_QQ_AIO_FEED_CARD_CLICK = "2";
        public static final String SUB_ACTION_TYPE_QQ_AIO_FEED_CARD_EXPOSE = "1";
        public static final String SUB_ACTION_TYPE_QQ_AIO_FEED_ENTRY = "3";
        public static final int SUB_ACTION_TYPE_QQ_SEARCH_FEED_CARD_CLICK = 2;
        public static final int SUB_ACTION_TYPE_QQ_SEARCH_FEED_CARD_EXPOSE = 1;
        public static final int SUB_ACTION_TYPE_QZONE_RECOMMEND_FULLSCREEN_ENTRANCE = 1;
        public static final int SUB_ACTION_TYPE_QZONE_RECOMMEND_FULLSCREEN_YYTAG_CLICK = 2;
        public static final int SUB_ACTION_TYPE_QZONE_RECOMMEND_FULLSCREEN_YYTAG_EXPOSE = 1;
        public static final String SUB_ACTION_TYPE_REPORT_PLAY = "2";
        public static final String SUB_ACTION_TYPE_TYPECLICK = "2";
        public static final String SUB_ACTION_TYPE_TYPEEXPOURSE = "1";
        public static final int TABLE_TYPE_ACTIVE_OPENQZONE = 4;
        public static final int TABLE_TYPE_DC00321 = 5;
        public static final int TABLE_TYPE_PUSH = 1;
        public static final int WEBVIEW_EVENT = 478;
        public static final int WEBVIEW_EVENT_BACK_SUB = 1;
        public static final int WEBVIEW_EVENT_CLOSE_SUB = 2;

        public ClickReportConfig() {
        }
    }

    private static long getLong(String str, long j3) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            QLog.e(TAG, 2, "long string(" + str + ") is ill-format, return default value " + j3);
            return j3;
        }
    }

    public static void report(String str, ReportInfo reportInfo, boolean z16) {
        if (reportInfo == null) {
            return;
        }
        try {
            LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
            lpReportInfo_pf00064.extraInfo = reportInfo.toJSON().toString();
            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, !z16, false);
        } catch (Exception e16) {
            QLog.e("QZoneClickReport", 1, e16, new Object[0]);
        }
    }

    public static void startReportImediately(String str, String str2, String str3) {
        long j3 = getLong(str, 0L);
        if (j3 > 0) {
            ReportInfo reportInfo = new ReportInfo();
            reportInfo.setActionType(str2);
            reportInfo.setToUin(j3);
            reportInfo.setSubactionType(str3);
            startReportImediately(str, reportInfo);
        }
    }

    public static void report(String str, String str2, String str3, String str4, String str5, boolean z16) {
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.toUin = getLong(str, 0L);
        reportInfo.actionType = str2;
        reportInfo.subactionType = str3;
        reportInfo.reserves = str4;
        reportInfo.readSource = str5;
        report(str, reportInfo, z16);
    }

    public static void startReportImediately(String str, ReportInfo reportInfo) {
        if (getLong(str, 0L) <= 0 || reportInfo == null) {
            return;
        }
        try {
            LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
            lpReportInfo_pf00064.extraInfo = reportInfo.toJSON().toString();
            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, true);
        } catch (Exception e16) {
            QLog.e("QZoneClickReport", 1, e16, new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class ReportInfo {
        public String actionType;
        public String appId;
        public String domain_type;
        public String extraInfo;
        public String info;
        public boolean isTemp;
        private Map<String, String> mapReportInfo;
        public int mergenum;
        public int networkType;
        public String pushstatkey;
        public String readSource;
        public String referId;
        public String reserves;
        public String reserves10;
        public String reserves3;
        public String reserves9;
        public ArrayList<String> reservesExt;
        public String sourceFrom;
        public String sourceTo;
        public String sourceType;
        public String subactionType;
        public int tabletype;
        public long time;
        public long toUin;
        private boolean useMapMode;

        public ReportInfo(long j3, String str, String str2, String str3, String str4, String str5, int i3, String str6, ArrayList<String> arrayList) {
            this();
            this.toUin = j3;
            this.appId = str;
            this.referId = str3;
            this.actionType = str4;
            this.subactionType = str5;
            this.tabletype = i3;
            this.reserves = str6;
            this.info = str2;
            this.reservesExt = arrayList;
        }

        public String getActionType() {
            return this.actionType;
        }

        public String getAppId() {
            return this.appId;
        }

        public boolean getIsTemp() {
            return this.isTemp;
        }

        public String getReadSource() {
            return this.readSource;
        }

        public String getReferId() {
            return this.referId;
        }

        public String getReserves() {
            return this.reserves;
        }

        public String getSubactionType() {
            return this.subactionType;
        }

        public long getToUin() {
            return this.toUin;
        }

        public void setActionType(String str) {
            this.actionType = str;
        }

        public void setAppId(String str) {
            this.appId = str;
        }

        public void setIsTemp(boolean z16) {
            this.isTemp = z16;
        }

        public void setReadSource(String str) {
            this.readSource = str;
        }

        public void setReferId(String str) {
            this.referId = str;
        }

        public void setReserves(String str) {
            this.reserves = str;
        }

        public void setSubactionType(String str) {
            this.subactionType = str;
        }

        public void setToUin(long j3) {
            this.toUin = j3;
        }

        public JSONObject toJSON() throws JSONException {
            JSONObject jSONObject;
            if (!TextUtils.isEmpty(this.extraInfo)) {
                jSONObject = new JSONObject(this.extraInfo);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put("touin", this.toUin);
            jSONObject.put("network_type", String.valueOf(this.networkType));
            jSONObject.put("tabletype", this.tabletype);
            if (this.useMapMode) {
                Map<String, String> map = this.mapReportInfo;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : this.mapReportInfo.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } else {
                if (!jSONObject.has("refer")) {
                    jSONObject.put("refer", this.referId);
                }
                jSONObject.put("actiontype", this.actionType);
                jSONObject.put("subactiontype", this.subactionType);
                jSONObject.put("tabletype", this.tabletype);
                jSONObject.put("domain_type", this.domain_type);
                jSONObject.put("reserves", this.reserves);
                jSONObject.put(QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, this.sourceType);
                jSONObject.put("source_from", this.sourceFrom);
                jSONObject.put("source_to", this.sourceTo);
                jSONObject.put("mergenum", this.mergenum);
                jSONObject.put("reserves9", this.reserves9);
                jSONObject.put("reserves3", this.reserves3);
                jSONObject.put("reserves10", this.reserves10);
                ArrayList<String> arrayList = this.reservesExt;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        String str = this.reservesExt.get(i3);
                        if (!TextUtils.isEmpty(str)) {
                            jSONObject.put("reserves" + (i3 + 2), str);
                        }
                    }
                }
            }
            jSONObject.put("read_source", this.readSource);
            jSONObject.put("time", String.valueOf(this.time));
            jSONObject.put("info", this.info);
            jSONObject.put("pushstatkey", this.pushstatkey);
            return jSONObject;
        }

        public ReportInfo(long j3, String str, Map<String, String> map) {
            this();
            this.toUin = j3;
            this.appId = str;
            this.useMapMode = true;
            if (map != null) {
                HashMap hashMap = new HashMap();
                this.mapReportInfo = hashMap;
                hashMap.putAll(map);
            }
        }

        public ReportInfo(long j3, int i3, String str, Map<String, String> map) {
            this();
            this.toUin = j3;
            this.appId = str;
            this.tabletype = i3;
            this.useMapMode = true;
            if (map != null) {
                HashMap hashMap = new HashMap();
                this.mapReportInfo = hashMap;
                hashMap.putAll(map);
            }
        }

        public ReportInfo(String str) {
            this();
            this.readSource = str;
            this.actionType = "12";
        }

        public ReportInfo() {
            this.toUin = 0L;
            this.appId = "0";
            this.referId = "";
            this.actionType = "";
            this.subactionType = "";
            this.reserves = "";
            this.readSource = "0";
            this.isTemp = false;
            this.time = 0L;
            this.info = "";
            this.extraInfo = "";
            this.reserves10 = "";
            this.reserves9 = "";
            this.reserves3 = "";
            this.tabletype = 0;
            this.domain_type = "2";
            this.useMapMode = false;
            this.pushstatkey = "";
            this.sourceType = "";
            this.sourceFrom = "";
            this.sourceTo = "";
            this.mergenum = 0;
            this.networkType = NetworkState.getNetworkType();
            this.time = System.currentTimeMillis();
        }
    }
}
