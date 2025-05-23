package com.tencent.qqmini.sdk.entry;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppExposureManager {
    public static final String TAG = "MiniAppExposureManager";
    private int desktopPullDownState = 1;
    private List<BaseExposureReport> reportItemList = new ArrayList();
    private Map<String, BaseExposureReport> duplicateItemMap = new HashMap();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface BaseExposureReport {
        void report();
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CardModuleExposureData implements BaseExposureReport {
        private String actionType;
        private String reserves;
        private String reserves2;
        private String subActionType;

        public CardModuleExposureData(String str, String str2, String str3, String str4) {
            this.actionType = str;
            this.subActionType = str2;
            this.reserves = str3;
            this.reserves2 = str4;
        }

        @Override // com.tencent.qqmini.sdk.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            SDKMiniProgramLpReportDC04239.report(this.actionType, this.subActionType, this.reserves, this.reserves2, null, null, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class CommonExposureData implements BaseExposureReport {
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

        @Override // com.tencent.qqmini.sdk.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            SDKMiniProgramLpReportDC04239.report(this.actionType, this.subActionType, this.reserves, this.reserves2, this.reserves3, this.reserves4, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class MiniAppModuleExposureData implements BaseExposureReport {
        private String actionType;
        private MiniAppInfo appConfig;
        private String subActionType;

        public MiniAppModuleExposureData(MiniAppInfo miniAppInfo, String str, String str2) {
            this.actionType = str;
            this.subActionType = str2;
            this.appConfig = miniAppInfo;
        }

        @Override // com.tencent.qqmini.sdk.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            MiniAppInfo miniAppInfo = this.appConfig;
            SDKMiniProgramLpReportDC04239.exposureReport(miniAppInfo, MiniAppExposureManager.getAppType(miniAppInfo), null, this.actionType, this.subActionType, null, null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class MiniAppRedDotExposureData implements BaseExposureReport {
        private String actionType;
        private MiniAppInfo appConfig;
        private int redDotNum;
        private String subActionType;

        public MiniAppRedDotExposureData(MiniAppInfo miniAppInfo, String str, String str2, int i3) {
            this.actionType = str;
            this.subActionType = str2;
            this.appConfig = miniAppInfo;
            this.redDotNum = i3;
        }

        public MiniAppInfo getMiniAppConfig() {
            return this.appConfig;
        }

        @Override // com.tencent.qqmini.sdk.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
            String str;
            MiniAppInfo miniAppInfo = this.appConfig;
            String appType = MiniAppExposureManager.getAppType(miniAppInfo);
            String str2 = this.actionType;
            String str3 = this.subActionType;
            int i3 = this.redDotNum;
            if (i3 > 0) {
                str = String.valueOf(i3);
            } else {
                str = "0";
            }
            SDKMiniProgramLpReportDC04239.exposureReport(miniAppInfo, appType, null, str2, str3, null, str);
        }
    }

    public static String getAppType(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null || !miniAppInfo.isReportTypeMiniGame()) {
            return "0";
        }
        return "1";
    }

    public void addReportItem(BaseExposureReport baseExposureReport) {
        this.reportItemList.add(baseExposureReport);
    }

    public void clear() {
        this.reportItemList.clear();
        this.duplicateItemMap.clear();
    }

    public int getDesktopPullDownState() {
        return this.desktopPullDownState;
    }

    public Map<String, BaseExposureReport> getDuplicateItemMap() {
        return this.duplicateItemMap;
    }

    public List<BaseExposureReport> getReportItemList() {
        return this.reportItemList;
    }

    public void onDestroy() {
        this.reportItemList.clear();
        this.duplicateItemMap.clear();
        QMLog.d("MiniAppExposureManager", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    public void putReportDataToMap(String str, BaseExposureReport baseExposureReport) {
        this.duplicateItemMap.put(str, baseExposureReport);
    }

    public void setDesktopPullDownState(int i3) {
        this.desktopPullDownState = i3;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class MiniAppExposureData implements BaseExposureReport {
        private MiniAppInfo appConfig;
        private int position;
        private String reserves2;

        public MiniAppExposureData(MiniAppInfo miniAppInfo, int i3) {
            this.appConfig = miniAppInfo;
            this.position = i3;
        }

        public MiniAppInfo getMiniAppConfig() {
            return this.appConfig;
        }

        public int getPosition() {
            return this.position;
        }

        public String getReserves2() {
            return this.reserves2;
        }

        public MiniAppExposureData(MiniAppInfo miniAppInfo, int i3, String str) {
            this.appConfig = miniAppInfo;
            this.position = i3;
            this.reserves2 = str;
        }

        @Override // com.tencent.qqmini.sdk.entry.MiniAppExposureManager.BaseExposureReport
        public void report() {
        }
    }
}
