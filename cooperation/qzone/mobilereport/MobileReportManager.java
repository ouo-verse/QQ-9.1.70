package cooperation.qzone.mobilereport;

import NS_USER_ACTION_REPORT.ActionInfo;
import NS_USER_ACTION_REPORT.ItemInfo;
import NS_USER_ACTION_REPORT.RuleInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.musicpendant.a;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MobileReportManager {
    private static final String TAG = "MobileReport.Manager";
    public static final String sTraceKey = "h5costreport=1";
    private final ReportActionInfoTask mReportActionInfoTask = new ReportActionInfoTask();
    private final ReportLiveTask mReportLiveTask = new ReportLiveTask();
    private final ReportSchemaInfoTask mReportSchemaLiveTask = new ReportSchemaInfoTask();
    private final ReportLiveHeartTask mReportLiveHeartTask = new ReportLiveHeartTask();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class ItemInfoBuilder {
        private String itemId = "";
        private ArrayList<String> subItemId = null;
        private String itemType = "";
        private String busiInfo = "";
        private ArrayList<ActionInfo> actionInfos = new ArrayList<>();
        private String moduleId = "";
        private String subModuleId = "";
        private String positionId = "";

        public ItemInfoBuilder addActionInfo(ActionInfo actionInfo) {
            this.actionInfos.add(actionInfo);
            return this;
        }

        public ItemInfoBuilder addSubItemId(String str) {
            if (this.subItemId == null) {
                this.subItemId = new ArrayList<>();
            }
            this.subItemId.add(str);
            return this;
        }

        public ItemInfo build() {
            ItemInfo itemInfo = new ItemInfo();
            itemInfo.item_id = this.itemId;
            itemInfo.sub_item_id = this.subItemId;
            itemInfo.action_infos = this.actionInfos;
            itemInfo.busi_info = this.busiInfo;
            itemInfo.module_id = this.moduleId;
            itemInfo.item_type = this.itemType;
            itemInfo.sub_module_id = this.subModuleId;
            itemInfo.position_id = this.positionId;
            return itemInfo;
        }

        public ItemInfoBuilder setBusiInfo(String str) {
            this.busiInfo = str;
            return this;
        }

        public ItemInfoBuilder setItemId(String str) {
            this.itemId = str;
            return this;
        }

        public ItemInfoBuilder setItemType(String str) {
            this.itemType = str;
            return this;
        }

        public ItemInfoBuilder setModuleId(String str) {
            this.moduleId = str;
            return this;
        }

        public ItemInfoBuilder setPositionId(String str) {
            this.positionId = str;
            return this;
        }

        public ItemInfoBuilder setSubModuleId(String str) {
            this.subModuleId = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class NewReportKey {
        final String mAppId;
        final String mItemId;
        final String mItemType;
        final String mPageId;

        NewReportKey(String str, String str2, String str3, String str4) {
            this.mAppId = str;
            this.mPageId = str2;
            this.mItemId = str3;
            this.mItemType = str4;
        }

        public static NewReportKey build(@NonNull BusinessInfoCheckUpdate.AppInfo appInfo) {
            String str = appInfo.buffer.get();
            String str2 = "0";
            String str3 = "";
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    str2 = jSONObject.getString("ad_id");
                    str3 = jSONObject.getString(SsoReporter.POS_ID_KEY);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            return new NewReportKey("vab_red", str3, str2, "5");
        }

        public String buildTraceDetail() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", this.mAppId);
                jSONObject.put("page_id", this.mPageId);
                jSONObject.put("item_id", this.mItemId);
                jSONObject.put("item_type", this.mItemType);
                return "" + jSONObject.toString();
            } catch (Exception e16) {
                QLog.e(MobileReportManager.TAG, 1, "parse json exception " + e16);
                return "";
            }
        }

        public String toString() {
            return "ReportKey{appid=" + this.mAppId + ", pageId=" + this.mPageId + ", mItemId=" + this.mItemId + ", mItemType=" + this.mItemType + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class SingletonInstance {
        private static final MobileReportManager INSTANCE = new MobileReportManager();

        SingletonInstance() {
        }
    }

    public static MobileReportManager getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public static String getNewDefaultReportInfo(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        String str4 = str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) ? "&trace_detail=base64-" : "?trace_detail=base64-";
        try {
            jSONObject.put("appid", str2);
            jSONObject.put("page_id", str3);
            return str4 + a.f(jSONObject.toString());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "json exception" + e16);
            return str4;
        }
    }

    public static String getNewReportInfo(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null) {
            return String.format("&trace_detail=base64-%s", a.f(NewReportKey.build(appInfo).buildTraceDetail()));
        }
        return null;
    }

    public static String getNewTraceDetail(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", str);
            jSONObject.put("page_id", str2);
            jSONObject.put("item_id", str3);
            jSONObject.put("item_type", str4);
            return "&trace_detail=" + a.f(jSONObject.toString());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "json exception " + e16);
            return "&trace_detail=";
        }
    }

    @NonNull
    public static String getStringQboos2H5(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        if (!TextUtils.isEmpty(str2)) {
            String[] split = str2.split("_");
            if (split.length > 2) {
                String str4 = split[0];
                String str5 = split[1];
                return str3 + "trace_num=1&trace_id=" + str + "_" + str5 + "_" + System.currentTimeMillis() + "&trace_detail_adv_pos_id=" + str4 + "&trace_detail_adv_id=" + str5 + "&trace_detail_pattern=" + split[2];
            }
            return "";
        }
        return "";
    }

    @Nullable
    public static String getStringReport2H5(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo != null) {
            ReportKey build = ReportKey.build(appInfo);
            return String.format("&traceId=%s&traceNum=%s&traceDetail=%s", build.traceId, String.valueOf(build.traceNum), URLEncoder.encode(build.buildTraceDetail()));
        }
        return null;
    }

    public static String getStringWithQbossTrace(String str, String str2) {
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str3 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str3 = ContainerUtils.FIELD_DELIMITER;
        }
        sb5.append(getStringQboos2H5(account, str2, str3));
        return sb5.toString();
    }

    public static String getStringWithRedAppinfo(String str, BusinessInfoCheckUpdate.AppInfo appInfo) {
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str)) {
            if (appInfo != null) {
                ReportKey build = ReportKey.build(appInfo);
                str2 = String.format("trace_id=%s&trace_num=%s&trace_detail=%s", build.traceId, String.valueOf(build.traceNum), URLEncoder.encode(build.buildTraceDetail()));
                str3 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str3 = ContainerUtils.FIELD_DELIMITER;
                }
            } else {
                str2 = "";
                str3 = "";
            }
            return str + str3 + str2;
        }
        return str;
    }

    public void qqSetingMeReport(int i3, int i16, String str) {
        ReportKey reportKey = new ReportKey("", 1, "", -1, SearchConstants.PLATFORM, "5");
        ItemInfo build = new ItemInfoBuilder().setItemId("" + i3).setBusiInfo(str).setModuleId("1").setItemType("4").addActionInfo(new ActionInfoBuilder(System.currentTimeMillis(), i16, 1L).build()).build();
        getInstance().reportActionLive(SearchConstants.PLATFORM, "5", build);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "report " + reportKey.toString() + " actionId = " + build.toString());
        }
        this.mReportActionInfoTask.reportByKey(reportKey, build);
    }

    public void reportAction(String str, String str2, String str3, String str4, String str5, int i3, int i16, long j3) {
        reportAction(str, str2, str3, str4, str5, i3, i16, j3, "");
    }

    public void reportActionLive(String str, String str2, String str3, String str4, String str5, int i3, int i16, long j3, String str6) {
        ReportKey reportKey = new ReportKey("", 1, "", -1, str3, str4);
        ItemInfo build = new ItemInfoBuilder().setItemId(str == null ? "" : str).setModuleId(str5).setBusiInfo("{\"roomid\":\"" + str6 + "\"}").addActionInfo(new ActionInfoBuilder(j3, i3, i16).build()).build();
        build.item_type = str2 != null ? str2 : "";
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "report " + reportKey.toString() + " actionId = " + (102 == i3 ? "ITEM_CLICK" : 101 == i3 ? "ITEM_EXPORT" : "UNKONW"));
        }
        this.mReportLiveTask.reportByKey(reportKey, build);
    }

    public void reportActionOfNotice(String str, String str2, String str3, int i3, String str4, String str5, int i16) {
        String str6;
        ReportKey reportKey = new ReportKey("", 1, "", -1, str, str2);
        ItemInfo build = new ItemInfoBuilder().setItemId(str4).setItemType(str5).setModuleId(str3).addActionInfo(new ActionInfoBuilder(System.currentTimeMillis(), i3, i16).build()).build();
        if (QLog.isDebugVersion()) {
            if (102 == i3) {
                str6 = "ITEM_CLICK";
            } else if (101 == i3) {
                str6 = "ITEM_EXPORT";
            } else if (100 == i3) {
                str6 = "PAGE_EXPORT";
            } else {
                str6 = "UNKONW";
            }
            QLog.d(TAG, 2, "report of notice:    itemId=" + str4 + ";" + reportKey.toString() + " actionId = " + str6);
        }
        this.mReportActionInfoTask.reportByKey(reportKey, build);
    }

    public void reportH5DomainClick(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.contains(sTraceKey)) {
            ReportKey reportKey = new ReportKey("", 0, "", 0, "JumpUrlReport", str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("jump_url", str2);
            } catch (Exception e16) {
                QLog.e(TAG, 2, " report exception " + e16);
            }
            ItemInfo build = new ItemInfoBuilder().setItemId(String.valueOf(k15.a.h(str).getString("adId"))).setBusiInfo(jSONObject.toString()).addActionInfo(new ActionInfoBuilder(System.currentTimeMillis(), 152, 1L).build()).build();
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 2, "report " + reportKey.toString() + " opType = 152 url = " + str + " jumpUrl = " + str2);
            }
            this.mReportActionInfoTask.reportByKey(reportKey, build);
        }
    }

    public void reportH5Trace(String str, int i3, long j3, String str2, int i16, String str3) {
        if (!TextUtils.isEmpty(str) && str.contains(sTraceKey)) {
            ReportKey reportKey = new ReportKey("", 0, "", 0, "H5CostReport", str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("coreType", i16);
                jSONObject.put("coreVersion", str3);
                jSONObject.put("errorcode", str2);
            } catch (Exception e16) {
                QLog.e(TAG, 2, " report exception " + e16);
            }
            ItemInfo build = new ItemInfoBuilder().setItemId("").setBusiInfo(jSONObject.toString()).addActionInfo(new ActionInfoBuilder(System.currentTimeMillis(), i3, j3).build()).build();
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 2, "report " + reportKey.toString() + " opType = " + i3 + " url = " + str + " timecost " + j3 + " errorcode " + str2);
            }
            this.mReportActionInfoTask.reportByKey(reportKey, build);
        }
    }

    public void reportRedpoint(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo, int i3) {
        String str;
        if (appInfo == null) {
            return;
        }
        ReportKey build = ReportKey.build(appInfo);
        ItemInfo build2 = new ItemInfoBuilder().setItemId(build.adId).setBusiInfo(appInfo.buffer.get()).addActionInfo(new ActionInfoBuilder(System.currentTimeMillis(), i3).build()).build();
        if (QLog.isDebugVersion()) {
            if (102 == i3) {
                str = "ITEM_CLICK";
            } else if (101 == i3) {
                str = "ITEM_EXPORT";
            } else {
                str = "UNKONW";
            }
            QLog.d(TAG, 2, "report " + build.toString() + " actionId = " + str);
        }
        this.mReportActionInfoTask.reportByKey(build, build2);
    }

    public void reportSchemaInfo(String str, String str2) {
        final ReportKey reportKey = new ReportKey(str, str2);
        final ItemInfo build = new ItemInfoBuilder().build();
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "reportSchemaInfo " + str + " schemaUrl " + str2);
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: cooperation.qzone.mobilereport.MobileReportManager.1
            @Override // java.lang.Runnable
            public void run() {
                MobileReportManager.this.mReportSchemaLiveTask.reportByKey(reportKey, build);
            }
        });
    }

    public void reportAction(String str, String str2, String str3, String str4, String str5, int i3, int i16, long j3, String str6) {
        ReportKey reportKey = new ReportKey("", 1, "", -1, str3, str4);
        ItemInfo build = new ItemInfoBuilder().setItemId(str == null ? "" : str).setModuleId(str5).addActionInfo(new ActionInfoBuilder(j3, i3, i16).build()).setBusiInfo(str6).build();
        build.item_type = str2 != null ? str2 : "";
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "report " + reportKey.toString() + " actionId = " + (102 == i3 ? "ITEM_CLICK" : 101 == i3 ? "ITEM_EXPORT" : "UNKONW"));
        }
        this.mReportActionInfoTask.reportByKey(reportKey, build);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class ActionInfoBuilder {
        private int actionAttr;
        private int actionId;
        private long actionValue;
        private long operTime;

        public ActionInfoBuilder(long j3, int i3) {
            this.operTime = j3;
            this.actionId = i3;
        }

        public ActionInfo build() {
            ActionInfo actionInfo = new ActionInfo();
            actionInfo.oper_time = this.operTime;
            actionInfo.action_id = this.actionId;
            actionInfo.action_value = this.actionValue;
            actionInfo.action_attr = this.actionAttr;
            return actionInfo;
        }

        public ActionInfoBuilder(long j3, int i3, long j16) {
            this.operTime = j3;
            this.actionId = i3;
            this.actionValue = j16;
        }

        public ActionInfoBuilder(long j3, int i3, long j16, int i16) {
            this.operTime = j3;
            this.actionId = i3;
            this.actionValue = j16;
            this.actionAttr = i16;
        }
    }

    public static String getNewReportInfo(String str, BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null || TextUtils.isEmpty(str)) {
            return null;
        }
        NewReportKey build = NewReportKey.build(appInfo);
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return String.format("&trace_detail=base64-%s", a.f(build.buildTraceDetail()));
        }
        return String.format("?trace_detail=base64-%s", a.f(build.buildTraceDetail()));
    }

    public static String getNewDefaultReportInfo(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", str);
            jSONObject.put("page_id", str2);
            return "&trace_detail=base64-" + a.f(jSONObject.toString());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "json exception" + e16);
            return "&trace_detail=base64-";
        }
    }

    public void reportActionLive(String str, String str2, ItemInfo itemInfo) {
        ReportKey reportKey = new ReportKey("", 1, "", -1, str, str2);
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "report " + reportKey.toString() + " actionId = " + itemInfo.toString());
        }
        this.mReportLiveTask.reportByKey(reportKey, itemInfo);
    }

    public void reportAction(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16) {
        reportAction(str, str2, str3, str4, str5, str6, i3, i16, (String) null);
    }

    public void reportAction(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16, String str7) {
        ReportKey reportKey = new ReportKey("", 1, "", -1, str, str2);
        ItemInfo build = new ItemInfoBuilder().setItemId(str5 == null ? "" : str5).setModuleId(str3).addActionInfo(new ActionInfoBuilder(System.currentTimeMillis(), i3, i16).build()).build();
        build.item_type = str6 == null ? "" : str6;
        build.sub_module_id = str4 != null ? str4 : "";
        if (str7 != null) {
            if (build.rule_info == null) {
                build.rule_info = new RuleInfo();
            }
            build.rule_info.str_ruleid = str7;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "report " + reportKey.toString() + " actionId = " + (102 == i3 ? "ITEM_CLICK" : 101 == i3 ? "ITEM_EXPORT" : "UNKONW"));
        }
        this.mReportActionInfoTask.reportByKey(reportKey, build);
    }

    public void reportAction(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, int i16, int i17, String str8, String str9, String str10) {
        ReportKey reportKey;
        if (UserActionReportBuilder.IS_SUPPORT_JSON_TRACE) {
            reportKey = new ReportKey(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + System.currentTimeMillis(), 1, "", -1, str, str2, str3, str5);
        } else {
            reportKey = new ReportKey("", 1, "", -1, str, str2);
        }
        ItemInfo build = new ItemInfoBuilder().setItemId(str5 == null ? "" : str5).addSubItemId(str6).setModuleId(str3).setBusiInfo(str9).addActionInfo(new ActionInfoBuilder(System.currentTimeMillis(), i3, i16, i17).build()).setPositionId(str10).build();
        build.item_type = str7 == null ? "" : str7;
        build.sub_module_id = str4 != null ? str4 : "";
        if (str8 != null) {
            if (build.rule_info == null) {
                build.rule_info = new RuleInfo();
            }
            build.rule_info.str_ruleid = str8;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "report " + reportKey.toString() + " actionId = " + (102 == i3 ? "ITEM_CLICK" : 101 == i3 ? "ITEM_EXPORT" : "UNKONW"));
        }
        this.mReportActionInfoTask.reportByKey(reportKey, build);
    }

    public void reportAction(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, int i16, int i17, String str8, String str9, String str10, String str11) {
        ReportKey reportKey;
        if (UserActionReportBuilder.IS_SUPPORT_JSON_TRACE) {
            reportKey = new ReportKey(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin() + System.currentTimeMillis(), 1, "", -1, str, str2, str3, str5, str11);
        } else {
            reportKey = new ReportKey("", 1, "", -1, str, str2, "", "", str11);
        }
        ItemInfo build = new ItemInfoBuilder().setItemId(str5 == null ? "" : str5).addSubItemId(str6).setModuleId(str3).setBusiInfo(str9).addActionInfo(new ActionInfoBuilder(System.currentTimeMillis(), i3, i16, i17).build()).setPositionId(str10).build();
        build.item_type = str7 == null ? "" : str7;
        build.sub_module_id = str4 != null ? str4 : "";
        if (str8 != null) {
            if (build.rule_info == null) {
                build.rule_info = new RuleInfo();
            }
            build.rule_info.str_ruleid = str8;
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "report " + reportKey.toString() + " actionId = " + (102 == i3 ? "ITEM_CLICK" : 101 == i3 ? "ITEM_EXPORT" : "UNKONW"));
        }
        this.mReportActionInfoTask.reportByKey(reportKey, build);
    }

    public void reportAction(String str, String str2, String str3, int i3, int i16, long j3) {
        reportAction("", (String) null, str, str2, str3, i3, i16, j3);
    }
}
