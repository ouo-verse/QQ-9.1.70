package com.tencent.hippy.qq.api;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class TabPreloadItem {
    public static final int MIN_PRE_REQUEST_INTERVAL = 7200;
    public static final int MIN_PRE_UPDATE_INTERVAL = 120;
    public static final String PRELOAD_PROCESS_LOCAL = "local";
    public static final String PRELOAD_PROCESS_MAIN = "main";
    public static final String PRELOAD_PROCESS_TOOL = "tool";
    public static final String PRELOAD_PROCESS_UNKNOWN = "unknown";
    public static final String PRELOAD_TYPE_PREDRAW = "predraw";
    public static final String PRELOAD_TYPE_PRELOAD = "preload";
    public static final String PRELOAD_TYPE_PRELOAD_BASE = "preloadBase";
    private static final String PRELOAD_TYPE_PREREQUEST = "preRequest";
    private static final String PRELOAD_TYPE_PREUPDATE = "predownload";
    public static final String PRELOAD_TYPE_SNAPSHOT = "preNodeSnapshot";
    public static final String TAB_LOGIN = "login";
    public static final String TAB_NAME_CONTACTS = "contacts";
    public static final String TAB_NAME_DRAWER = "drawer";
    public static final String TAB_NAME_DYNAMIC = "dynamic";
    public static final String TAB_NAME_KANDIAN = "kandian";
    public static final String TAB_NAME_MESSAGE = "msgList";
    private static final String TAG = "TabPreloadItem";
    public String adId;
    public AdType adType;
    public String domain;
    public int lifeTime;
    public boolean needCheckPreload;
    public ArrayList<PreRequestData> preRequestList;
    public String preloadFramework;
    public String preloadProcess;
    public PreloadType preloadType;
    public int priority;
    public int preUpdateInterval = 120;
    public PreloadCondition preloadCondition = new PreloadCondition();
    public String bundleName = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.hippy.qq.api.TabPreloadItem$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType;

        static {
            int[] iArr = new int[PreloadType.values().length];
            $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType = iArr;
            try {
                iArr[PreloadType.PRE_UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType[PreloadType.PRE_BASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType[PreloadType.PRE_LOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType[PreloadType.PRE_DRAW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType[PreloadType.PRE_SNAPSHOT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType[PreloadType.PRE_REQUEST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType[PreloadType.NO_PRELOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum AdType {
        UNKNOWN(0),
        MESSAGE_TAB_TOP_BANNER(1),
        MESSAGE_TAB_DIAO_ZUI(2);

        private int mAdType;

        AdType(int i3) {
            this.mAdType = i3;
        }

        public int adTypeValue() {
            return this.mAdType;
        }
    }

    /* loaded from: classes7.dex */
    public static class PreRequestData {
        public String url;

        public static ArrayList<PreRequestData> fromJson(JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            ArrayList<PreRequestData> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject == null) {
                    return null;
                }
                PreRequestData preRequestData = new PreRequestData();
                preRequestData.url = optJSONObject.optString("url");
                if (preRequestData.checkData()) {
                    arrayList.add(preRequestData);
                }
            }
            return arrayList;
        }

        public boolean checkData() {
            return !TextUtils.isEmpty(this.url);
        }

        public String toString() {
            return "{url=" + this.url + '}';
        }
    }

    /* loaded from: classes7.dex */
    public static class PreloadCondition {
        public String redDotPath;

        /* JADX INFO: Access modifiers changed from: private */
        public void fromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.redDotPath = jSONObject.optString("redDotPath");
            }
        }

        private boolean isRedDotShowing(String str) {
            IRedTouchManager iRedTouchManager;
            BusinessInfoCheckUpdate.AppInfo appInfoByPath;
            AppInterface appInterface = HippyUtils.getAppInterface();
            if (appInterface == null || (iRedTouchManager = (IRedTouchManager) appInterface.getRuntimeService(IRedTouchManager.class, "all")) == null || (appInfoByPath = iRedTouchManager.getAppInfoByPath(str)) == null || appInfoByPath.iNewFlag.get() == 0) {
                return false;
            }
            return true;
        }

        public boolean checkCondition() {
            if (!TextUtils.isEmpty(this.redDotPath)) {
                return isRedDotShowing(this.redDotPath);
            }
            return true;
        }

        public boolean hasRedDotCondition() {
            return !TextUtils.isEmpty(this.redDotPath);
        }

        public String toString() {
            return "{redDotPath=" + this.redDotPath + '}';
        }
    }

    /* loaded from: classes7.dex */
    public enum PreloadType {
        NO_PRELOAD,
        PRE_UPDATE,
        PRE_BASE,
        PRE_LOAD,
        PRE_DRAW,
        PRE_SNAPSHOT,
        PRE_REQUEST
    }

    public static AdType convertToAdType(int i3) {
        AdType adType = AdType.MESSAGE_TAB_DIAO_ZUI;
        if (adType.adTypeValue() == i3) {
            return adType;
        }
        AdType adType2 = AdType.MESSAGE_TAB_TOP_BANNER;
        if (adType2.adTypeValue() == i3) {
            return adType2;
        }
        return AdType.UNKNOWN;
    }

    public static PreloadType convertToPreloadType(String str) {
        if (PRELOAD_TYPE_PREUPDATE.equals(str)) {
            return PreloadType.PRE_UPDATE;
        }
        if ("preload".equals(str)) {
            return PreloadType.PRE_LOAD;
        }
        if (PRELOAD_TYPE_PREDRAW.equals(str)) {
            return PreloadType.PRE_DRAW;
        }
        if (PRELOAD_TYPE_PRELOAD_BASE.equals(str)) {
            return PreloadType.PRE_BASE;
        }
        if (PRELOAD_TYPE_SNAPSHOT.equals(str)) {
            return PreloadType.PRE_SNAPSHOT;
        }
        if (PRELOAD_TYPE_PREREQUEST.equals(str)) {
            return PreloadType.PRE_REQUEST;
        }
        return PreloadType.NO_PRELOAD;
    }

    public static TabPreloadItem fromJson(JSONObject jSONObject) {
        TabPreloadItem tabPreloadItem;
        if (jSONObject == null) {
            return null;
        }
        try {
            tabPreloadItem = new TabPreloadItem();
            tabPreloadItem.bundleName = jSONObject.optString("bundleName");
            tabPreloadItem.lifeTime = jSONObject.optInt("lifeTime");
            tabPreloadItem.priority = jSONObject.optInt("priority");
            tabPreloadItem.preloadType = convertToPreloadType(jSONObject.optString(OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE));
            tabPreloadItem.preloadProcess = jSONObject.optString("process");
            tabPreloadItem.preloadFramework = jSONObject.optString("framework", HippyQQConstants.HIPPY_VUE);
            tabPreloadItem.needCheckPreload = jSONObject.optBoolean("needCheckPreload");
            tabPreloadItem.domain = jSONObject.optString("domain");
            tabPreloadItem.preUpdateInterval = jSONObject.optInt("preDownLoadTimeLimit");
            tabPreloadItem.adId = jSONObject.optString("adId");
            tabPreloadItem.adType = convertToAdType(jSONObject.optInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE));
            tabPreloadItem.preloadCondition.fromJson(jSONObject.optJSONObject("condition"));
            tabPreloadItem.preRequestList = PreRequestData.fromJson(jSONObject.optJSONArray("requestList"));
            PreloadType preloadType = tabPreloadItem.preloadType;
            if (preloadType == PreloadType.PRE_REQUEST && tabPreloadItem.preUpdateInterval == 0) {
                tabPreloadItem.preUpdateInterval = 7200;
            }
            if (tabPreloadItem.preUpdateInterval < 120) {
                tabPreloadItem.preUpdateInterval = 120;
            }
            if (preloadType == PreloadType.PRE_BASE) {
                tabPreloadItem.bundleName = "";
                tabPreloadItem.domain = "";
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "fromJson e:" + th5);
        }
        if (!tabPreloadItem.checkData()) {
            return null;
        }
        return tabPreloadItem;
    }

    public static String preloadTypeToString(PreloadType preloadType) {
        switch (AnonymousClass1.$SwitchMap$com$tencent$hippy$qq$api$TabPreloadItem$PreloadType[preloadType.ordinal()]) {
            case 1:
                return PRELOAD_TYPE_PREUPDATE;
            case 2:
                return PRELOAD_TYPE_PRELOAD_BASE;
            case 3:
                return "preload";
            case 4:
                return PRELOAD_TYPE_PREDRAW;
            case 5:
                return PRELOAD_TYPE_SNAPSHOT;
            case 6:
                return PRELOAD_TYPE_PREREQUEST;
            default:
                return "";
        }
    }

    public boolean checkData() {
        PreloadType preloadType = this.preloadType;
        if (preloadType == PreloadType.NO_PRELOAD || preloadType == PreloadType.PRE_SNAPSHOT) {
            return false;
        }
        if ((preloadType != PreloadType.PRE_BASE && TextUtils.isEmpty(this.bundleName)) || TextUtils.isEmpty(this.preloadProcess)) {
            return false;
        }
        if (!this.preloadProcess.equals("main") && !this.preloadProcess.equals("tool") && !this.preloadProcess.equals("local")) {
            return false;
        }
        String str = this.preloadFramework;
        if (str != null && !str.equals(HippyQQConstants.HIPPY_VUE) && !this.preloadFramework.equals("react")) {
            return false;
        }
        return true;
    }

    public boolean checkPreloadCondition() {
        return this.preloadCondition.checkCondition();
    }

    public void fillParameters(OpenHippyInfo openHippyInfo) {
        openHippyInfo.preloadType = this.preloadType;
        openHippyInfo.domain = this.domain;
        openHippyInfo.bundleName = this.bundleName;
        openHippyInfo.framework = this.preloadFramework;
        openHippyInfo.processName = this.preloadProcess;
    }

    public int getProcessId() {
        if ("main".equals(this.preloadProcess)) {
            return 1;
        }
        if ("tool".equals(this.preloadProcess)) {
            return 7;
        }
        if ("local".equals(this.preloadProcess)) {
            return MobileQQ.sProcessId;
        }
        return Integer.MIN_VALUE;
    }

    public boolean hasRedDotCondition() {
        return this.preloadCondition.hasRedDotCondition();
    }

    public boolean isAdPreload() {
        if (!TextUtils.isEmpty(this.adId) && this.adType != AdType.UNKNOWN) {
            return true;
        }
        return false;
    }

    public boolean isPreRequest() {
        if (this.preloadType == PreloadType.PRE_REQUEST) {
            return true;
        }
        return false;
    }

    public boolean isPreUpdate() {
        if (this.preloadType == PreloadType.PRE_UPDATE) {
            return true;
        }
        return false;
    }

    public boolean isPredraw() {
        if (this.preloadType == PreloadType.PRE_DRAW) {
            return true;
        }
        return false;
    }

    public boolean isPreload() {
        if (this.preloadType == PreloadType.PRE_LOAD) {
            return true;
        }
        return false;
    }

    public boolean isPreloadBase() {
        if (this.preloadType == PreloadType.PRE_BASE) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "TabPreloadItem{bundleName=" + this.bundleName + ", lifeTime=" + this.lifeTime + ", preloadType=" + this.preloadType + ", process=" + this.preloadProcess + ", framework=" + this.preloadFramework + ", needCheckPreload=" + this.needCheckPreload + ", domain=" + this.domain + ", updateInterval=" + this.preUpdateInterval + ", adId=" + this.adId + ", adType=" + this.adType + ", condition=" + this.preloadCondition + ", preRequests=" + this.preRequestList + '}';
    }
}
