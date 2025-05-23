package com.tencent.mobileqq.mini.entry;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.AttaReporter;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppExposureManager implements Manager {
    public static final String EXPO = "|expo";
    public static final String EXPO_CATEGORY = "|category";
    public static final String EXPO_STORE_ENTRY = "|storeEntry";
    public static final String EXPO_TIAN_SHU = "|tianshu";
    public static final String EXPO_VALID = "|expo_valid";
    public static final String TAG = "MiniAppExposureManager";
    private List<BaseExposureReport> reportItemList = new ArrayList();
    private List<BaseExposureReport> searchItemList = new ArrayList();
    private Map<String, BaseExposureReport> duplicateItemMap = new ConcurrentHashMap();
    private Map<String, BaseExposureReport> reportedItemMap = new ConcurrentHashMap();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static abstract class BaseExposureReport {
        private volatile boolean hasReport = false;

        public void handleReport() {
            if (hasReport()) {
                return;
            }
            report();
            setHasReport(true);
        }

        public boolean hasReport() {
            return this.hasReport;
        }

        public abstract void report();

        public void setHasReport(boolean z16) {
            this.hasReport = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class CommonExposureData extends BaseExposureReport {
        private String actionType;
        private String reserves;
        private String reserves2;
        private String reserves3;
        private String reserves4 = null;
        private String subActionType;

        public CommonExposureData(String str, String str2, String str3, String str4, String str5) {
            this.actionType = str;
            this.subActionType = str2;
            this.reserves = str3;
            this.reserves2 = str4;
            this.reserves3 = str5;
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            MiniProgramLpReportDC04239.report(this.actionType, this.subActionType, this.reserves, this.reserves2, this.reserves3, this.reserves4, false);
        }

        public String toString() {
            return "CommonExposureData, actionType='" + this.actionType + ", subActionType='" + this.subActionType + ", reserves='" + this.reserves + ", reserves2='" + this.reserves2 + ", reserves3='" + this.reserves3 + ", reserves4='" + this.reserves4;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class FriendPlayExpoData extends BaseExposureReport {
        private MiniAppInfo mMiniAppInfo;

        public FriendPlayExpoData(MiniAppInfo miniAppInfo) {
            this.mMiniAppInfo = miniAppInfo;
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            MiniAppInfo miniAppInfo = this.mMiniAppInfo;
            if (miniAppInfo != null) {
                AttaReporter.h("101", miniAppInfo.appId, miniAppInfo.reportData, "0");
            }
        }

        public String toString() {
            return "FriendPlayExpoData, mMiniAppInfo.name:" + this.mMiniAppInfo.name + ", mMiniAppInfo.appId:" + this.mMiniAppInfo.appId;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class MiniAppRedDotExposureData extends BaseExposureReport {
        private String actionType;
        private MiniAppConfig appConfig;
        private int redDotNum;
        private String subActionType;

        public MiniAppRedDotExposureData(MiniAppConfig miniAppConfig, String str, String str2, int i3) {
            this.actionType = str;
            this.subActionType = str2;
            this.appConfig = miniAppConfig;
            this.redDotNum = i3;
        }

        public MiniAppConfig getMiniAppConfig() {
            return this.appConfig;
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            String str;
            MiniAppConfig miniAppConfig = this.appConfig;
            String appType = MiniAppExposureManager.getAppType(miniAppConfig);
            String str2 = this.actionType;
            String str3 = this.subActionType;
            int i3 = this.redDotNum;
            if (i3 > 0) {
                str = String.valueOf(i3);
            } else {
                str = "0";
            }
            MiniProgramLpReportDC04239.exposureReport(miniAppConfig, appType, null, str2, str3, null, str);
        }

        public String toString() {
            return "MiniAppRedDotExposureData, , actionType='" + this.actionType + ", subActionType='" + this.subActionType + ", redDotNum=" + this.redDotNum;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class StoreEntryExposureData extends BaseExposureReport {
        private String gameCenterSrc;

        public StoreEntryExposureData(String str) {
            this.gameCenterSrc = str;
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            MiniAppUtils.reportMiniGameCenterDC00087("1", "969", "9043", "904301", "209625", "8", this.gameCenterSrc);
        }

        public String toString() {
            return "StoreEntryExposureData, gameCenterSrc:" + this.gameCenterSrc;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class TianShuExposureData extends BaseExposureReport {
        protected int actionId;
        protected String appId;
        protected String busiInfo = "";
        protected String itemId;
        protected String pageId;

        public TianShuExposureData(String str, String str2, String str3, int i3) {
            this.appId = str;
            this.pageId = str2;
            this.itemId = str3;
            this.actionId = i3;
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            try {
                TianShuReportData tianShuReportData = new TianShuReportData();
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                String str = "";
                if (runtime != null) {
                    str = runtime.getAccount();
                }
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
                tianShuReportData.mTraceId = str + "_" + serverTimeMillis;
                tianShuReportData.mTraceNum = 1;
                tianShuReportData.mAppId = this.appId;
                tianShuReportData.mPageId = this.pageId;
                tianShuReportData.mItemId = this.itemId;
                tianShuReportData.mActionId = this.actionId;
                tianShuReportData.mActionValue = 1;
                tianShuReportData.mOperTime = serverTimeMillis;
                tianShuReportData.mBusiInfo = this.busiInfo;
                TianShuManager.getInstance().report(tianShuReportData);
                if (QLog.isColorLevel()) {
                    QLog.i("MiniAppExposureManager", 2, "TianShuExposureData, report itemId: " + this.itemId + ", busiInfo: " + this.busiInfo);
                }
            } catch (Exception e16) {
                QLog.e("MiniAppExposureManager", 1, "TianShuExposureData, report exception: " + Log.getStackTraceString(e16));
            }
        }

        public void setBusiInfo(String str) {
            this.busiInfo = str;
        }

        public String toString() {
            return "TianShuExposureData, appId='" + this.appId + ", pageId='" + this.pageId + ", itemId='" + this.itemId + ", actionId=" + this.actionId + ", busiInfo='" + this.busiInfo;
        }
    }

    public MiniAppExposureManager(QQAppInterface qQAppInterface) {
    }

    private synchronized void clearSearchItemData() {
        this.searchItemList.clear();
    }

    public static String getAppType(MiniAppConfig miniAppConfig) {
        if (miniAppConfig == null || !miniAppConfig.isReportTypeMiniGame()) {
            return "0";
        }
        return "1";
    }

    private synchronized List<BaseExposureReport> getSearchItemList() {
        return this.searchItemList;
    }

    public synchronized void addReportItem(BaseExposureReport baseExposureReport) {
        this.reportItemList.add(baseExposureReport);
    }

    public synchronized void addSearchItemAndCheckReport(BaseExposureReport baseExposureReport) {
        this.searchItemList.add(baseExposureReport);
        if (searchReportCheck()) {
            submitSearchReportData();
        }
    }

    public synchronized void clear() {
        this.reportItemList.clear();
        this.reportedItemMap.clear();
        this.duplicateItemMap.clear();
    }

    public synchronized void clearDuplicateItemMap() {
        this.reportedItemMap.putAll(this.duplicateItemMap);
        this.duplicateItemMap.clear();
    }

    public synchronized void clearReportedItemMap() {
        this.reportedItemMap.clear();
    }

    public synchronized List<BaseExposureReport> getReportItemList() {
        return this.reportItemList;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        clear();
        QLog.d("MiniAppExposureManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    public synchronized void putReportDataToMap(String str, BaseExposureReport baseExposureReport) {
        if (str != null && baseExposureReport != null) {
            if (this.reportedItemMap.get(str) != null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MiniAppExposureManager", 2, "putReportDataToMap, key:" + str + ", data:" + baseExposureReport);
            }
            this.duplicateItemMap.put(str, baseExposureReport);
            return;
        }
        QLog.d("MiniAppExposureManager", 2, "key or data is null , putReportDataToMap failed!");
    }

    public boolean searchReportCheck() {
        return this.searchItemList.size() >= 20;
    }

    public synchronized void submitDuplicateItemMapReportData(boolean z16) {
        MiniProgramLpReportDC04239.exposureReport(new ArrayList(this.duplicateItemMap.values()));
        clearDuplicateItemMap();
        if (z16) {
            clear();
        }
    }

    public synchronized void submitSearchReportData() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getSearchItemList());
        MiniProgramLpReportDC04239.exposureReport(arrayList);
        clearSearchItemData();
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class MiniAppExposureData extends BaseExposureReport {
        private MiniAppConfig appConfig;
        private int position;
        private String reserves2;

        public MiniAppExposureData(MiniAppConfig miniAppConfig, int i3) {
            this.appConfig = miniAppConfig;
            this.position = i3;
        }

        public MiniAppConfig getMiniAppConfig() {
            return this.appConfig;
        }

        public int getPosition() {
            return this.position;
        }

        public String getReserves2() {
            return this.reserves2;
        }

        public String toString() {
            return "MiniAppExposureData, appConfig=" + this.appConfig + ", position=" + this.position + ", reserves2='" + this.reserves2;
        }

        public MiniAppExposureData(MiniAppConfig miniAppConfig, int i3, String str) {
            this.appConfig = miniAppConfig;
            this.position = i3;
            this.reserves2 = str;
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class MiniAppModuleExposureData extends BaseExposureReport {
        private String actionType;
        private MiniAppConfig appConfig;
        private String hostScene;
        private String module;
        private String pageId;
        private String reserves;
        private String reserves2;
        private String reserves4;
        private String reserves5;
        private String reserves6;
        private String reserves7;
        private String reserves8;
        private String slotId;
        private String subActionType;
        private String tabTitle;

        public MiniAppModuleExposureData(MiniAppConfig miniAppConfig, String str, String str2) {
            this.actionType = str;
            this.subActionType = str2;
            this.appConfig = miniAppConfig;
        }

        public void dtReport() {
            String str;
            int i3 = this.appConfig.config.engineType;
            if (i3 != 6 && i3 != 0) {
                str = "1";
            } else {
                str = "0";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("applet_appid", this.appConfig.config.appId);
            hashMap.put("applet_type", str);
            hashMap.put(MiniAppDesktopDtReportHelper.DT_MINI_PARENT_EID, this.module);
            hashMap.put(MiniAppDesktopDtReportHelper.DT_MINI_APP_SOURCE, String.valueOf(this.appConfig.config.isWxMiniApp() ? 2 : 1));
            hashMap.put("host_scene", this.hostScene);
            if (!TextUtils.isEmpty(this.tabTitle)) {
                hashMap.put(MiniAppDesktopDtReportHelper.DT_MINI_APPLET_PRIMARY_TAB, this.tabTitle);
            }
            MiniAppDesktopDtReportHelper.INSTANCE.getInstance().miniAppDesktopCommonReport("qq_imp", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET, hashMap, this.pageId);
        }

        public void fillAdId() {
            MiniAppInfo miniAppInfo;
            int i3;
            MiniAppConfig miniAppConfig = this.appConfig;
            if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || (i3 = miniAppInfo.tianshuAdId) == 0) {
                return;
            }
            this.reserves4 = String.valueOf(i3);
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            MiniAppConfig miniAppConfig = this.appConfig;
            MiniProgramLpReportDC04239.exposureReport(miniAppConfig, MiniAppExposureManager.getAppType(miniAppConfig), null, this.actionType, this.subActionType, this.reserves, this.reserves2, this.reserves4, this.reserves5, this.reserves6, this.reserves7, this.reserves8, this.slotId);
            dtReport();
        }

        public void setHostScene(String str) {
            this.hostScene = str;
        }

        public void setModule(String str) {
            this.module = str;
        }

        public void setPageId(String str) {
            this.pageId = str;
        }

        public void setPosition(int i3) {
            this.reserves5 = String.valueOf(i3);
            this.slotId = String.valueOf(i3);
        }

        public void setTabTitle(String str) {
            this.tabTitle = str;
        }

        public String toString() {
            return "MiniAppModuleExposureData, , actionType='" + this.actionType + ", subActionType='" + this.subActionType + ", reserves='" + this.reserves + ", reserves2='" + this.reserves2 + ", reserves4='" + this.reserves4 + ", reserves5='" + this.reserves5 + ", reserves6='" + this.reserves6 + ", reserves7='" + this.reserves7 + ", reserves8='" + this.reserves8;
        }

        public MiniAppModuleExposureData(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4) {
            this.appConfig = miniAppConfig;
            this.actionType = str;
            this.subActionType = str2;
            this.reserves = str3;
            this.reserves2 = str4;
        }

        public void setStartTs(long j3) {
            if (j3 > 0) {
                this.reserves6 = String.valueOf(System.currentTimeMillis() - j3);
            } else {
                this.reserves6 = null;
            }
        }

        public MiniAppModuleExposureData(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6) {
            this.appConfig = miniAppConfig;
            this.actionType = str;
            this.subActionType = str2;
            this.reserves = str3;
            this.reserves2 = str4;
            this.reserves7 = str5;
            this.reserves8 = str6;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class CardModuleExposureData extends BaseExposureReport {
        private String actionType;
        private String reserves;
        private String reserves2;
        private String reserves3;
        private String reserves4;
        private String subActionType;

        public CardModuleExposureData(String str, String str2, String str3, String str4) {
            this.actionType = str;
            this.subActionType = str2;
            this.reserves = str3;
            this.reserves2 = str4;
        }

        @Override // com.tencent.mobileqq.mini.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            MiniProgramLpReportDC04239.report(this.actionType, this.subActionType, this.reserves, this.reserves2, this.reserves3, this.reserves4, false);
        }

        public String toString() {
            return "CardModuleExposureData, actionType='" + this.actionType + ", subActionType='" + this.subActionType + ", reserves='" + this.reserves + ", reserves2='" + this.reserves2 + ", reserves3='" + this.reserves3 + ", reserves4='" + this.reserves4;
        }

        public CardModuleExposureData(String str, String str2, String str3, String str4, String str5, String str6) {
            this.actionType = str;
            this.subActionType = str2;
            this.reserves = str3;
            this.reserves2 = str4;
            this.reserves3 = str5;
            this.reserves4 = str6;
        }
    }
}
