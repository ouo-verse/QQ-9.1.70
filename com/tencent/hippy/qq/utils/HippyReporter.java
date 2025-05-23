package com.tencent.hippy.qq.utils;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.exception.QQHippyException;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyReporter {
    public static final String EXTRA_KEY_REPORT_ERRMSG = "errmsg";
    public static final String EXTRA_KEY_REPORT_FROM = "reportFrom";
    public static final String HIPPY_REPORT_APP_KEY = "0DOU0VN8VA4YJXF0";
    public static final int OPEN_RESULT_MODULE_INVALID = -4;
    public static final int OPEN_RESULT_NO_JSBUNDLE = -2;
    public static final int OPEN_RESULT_NO_SO = -3;
    public static final int OPEN_RESULT_SUCCESS = 0;
    public static final int OPEN_RESULT_SWITCH_OFF = -1;
    public static final int OPER_TYPE_CHECK_UPDATE = 5;
    public static final int OPER_TYPE_GAMECENTER = 9;
    public static final int OPER_TYPE_JS_EXCEPTION = 1;
    public static final int OPER_TYPE_LOAD_CRASH = 7;
    public static final int OPER_TYPE_LOAD_HIPPY = 3;
    public static final int OPER_TYPE_LOAD_MODULE_JS_EXCEPTION = 4;
    public static final int OPER_TYPE_LOAD_PAGE_TIMEOUT = 6;
    public static final int OPER_TYPE_LOAD_STEP_TIMEOUT = 8;
    public static final int OPER_TYPE_NATIVE_EXCEPTION = 2;
    public static final int OPER_TYPE_PRELOAD_HIPPY = 10;
    public static final int OPER_TYPE_SSO_CHECK_UPDATE = 11;
    public static final int OPER_TYPE_UNUSED_PRELOAD = 12;
    private static final String TAG = "HippyReporter";
    private static HippyReporter sInstance;
    private final String HIPPY_LOAD_TOTAL_COST_NAME = "total";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface EventCode {
        public static final String CHECK_UPDATE_HTTP = "hippy_js_update_old";
        public static final String CHECK_UPDATE_SSO = "hippy_js_update";
        public static final String GET_OFFLINE_PACKAGE = "hippy_offlinePack";
        public static final String HIPPY_CRASH = "hippy_crash";
        public static final String HIPPY_PRERENDER = "hippy_prerender";
        public static final String HIPPY_PRERENDER_SHOW = "hippy_prerender_show";
        public static final String HIPPY_PSKEY = "hippy_pskey";
        public static final String HIPPY_UNUSED_PRELOAD = "hippy_unused_preload";
        public static final String JS_EXCEPTION = "hippy_js_error";
        public static final String LOAD_CRASH = "hippy_load_crash";
        public static final String LOAD_MODULE_JS_EXCEPTION = "hippy_loadmodule_js_error";
        public static final String LOAD_PAGE_TIMEOUT = "hippy_open_timeout";
        public static final String LOAD_STEP_TIMEOUT = "hippy_step_timeout";
        public static final String NATIVE_EXCEPTION = "hippy_sdk_error";
        public static final String OPEN_GAMECENTER = "hippy_gamecenter_enter";
        public static final String OPEN_HIPPY = "hippy_open";
        public static final String PRELOAD_HIPPY = "hippy_preload";
        public static final String WILL_OPEN_HIPPY = "hippy_will_open";
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface RemoveEngineReason {
        public static final String ACCOUNT_CHANGED = "accountChanged";
        public static final String BUS_PRELOAD = "busPreload";
        public static final String CLEAR_CACHE = "clearCache";
        public static final String DEFAULT = "default";
        public static final String INVALID = "invalid";
        public static final String LOGOUT = "logout";
        public static final String LOW_MEMORY = "lowMemory";
        public static final String PRELOAD_ERROR = "PreloadError";
        public static final String TAB_BAR_PRELOAD = "tabBarPreload";
        public static final String THEME_CHANGED = "themeChanged";
    }

    HippyReporter() {
    }

    private void baseReport(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return;
        }
        try {
            getReportHeadData(hashMap);
            String str = hashMap.get("from");
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("reportFrom", str);
            }
            String remove = hashMap.remove("eventCode");
            String remove2 = hashMap.remove("uin");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, remove + " baseReport data:" + hashMap);
            }
            if (!TextUtils.isEmpty(remove)) {
                QQBeaconReport.reportWithAppKey(HIPPY_REPORT_APP_KEY, remove2, remove, true, hashMap, true);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "baseReport e:" + th5);
        }
    }

    private static int getAppPublishStatus() {
        return !HippyDebugUtil.isDebugEnable() ? 1 : 0;
    }

    private Boolean getBooleanFromHashMap(HashMap<String, Object> hashMap, String str, boolean z16) {
        if (hashMap.containsKey(str)) {
            z16 = ((Boolean) hashMap.get(str)).booleanValue();
        }
        return Boolean.valueOf(z16);
    }

    private static int getCpuBit() {
        return 64;
    }

    private static String getCurrentUin() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            return waitAppRuntime.getAccount();
        }
        return "";
    }

    public static HippyReporter getInstance() {
        if (sInstance == null) {
            synchronized (HippyReporter.class) {
                if (sInstance == null) {
                    sInstance = new HippyReporter();
                }
            }
        }
        return sInstance;
    }

    private int getIntFromHashMap(HashMap<String, Object> hashMap, String str, int i3) {
        if (hashMap.containsKey(str)) {
            return ((Integer) hashMap.get(str)).intValue();
        }
        return i3;
    }

    private long getLongFromHashMap(HashMap<String, Long> hashMap, String str, long j3) {
        if (hashMap.containsKey(str)) {
            return hashMap.get(str).longValue();
        }
        return j3;
    }

    private static String getNetTypeName() {
        String[] strArr = AppConstants.NET_TYPE_NAME;
        String str = strArr[0];
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType < strArr.length && netWorkType >= 0) {
            return strArr[netWorkType];
        }
        return str;
    }

    protected static void getReportHeadData(Map<String, String> map) {
        try {
            int cpuBit = getCpuBit();
            String netTypeName = getNetTypeName();
            String currentUin = getCurrentUin();
            String str = ah.M() + "*" + ah.L();
            int appPublishStatus = getAppPublishStatus();
            String Q = ah.Q(BaseApplication.getContext());
            String valueOf = String.valueOf(HippyNetworkUtils.getNetworkState().ordinal());
            if (map != null) {
                map.put("cpu_bit", String.valueOf(cpuBit));
                map.put("qq_ver", Q);
                map.put("is_public", String.valueOf(appPublishStatus));
                map.put("resolution", str);
                map.put("net", netTypeName);
                map.put("uin", currentUin);
                map.put("netState", valueOf);
            }
            putHippySoInfo(map);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getReportHeadData error:" + th5);
        }
    }

    private String getStringFromHashMap(HashMap<String, Object> hashMap, String str) {
        if (hashMap.containsKey(str)) {
            return (String) hashMap.get(str);
        }
        return null;
    }

    private static void putHippySoInfo(Map<String, String> map) {
        HashMap<String, String> libraryVersions = ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).getLibraryVersions();
        if (libraryVersions != null && libraryVersions.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb5 = new StringBuilder();
                for (Map.Entry<String, String> entry : libraryVersions.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                    if (sb5.length() > 0) {
                        sb5.append(Typography.amp);
                    }
                    sb5.append(entry.getKey());
                    sb5.append('=');
                    sb5.append(entry.getValue());
                }
                if (map != null) {
                    map.put(IHippyIPC.BUNDLE_HIPPY_INFO, sb5.toString());
                }
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "putHippySoInfo error:" + e16);
            }
        }
    }

    private void putStepsCostData(HashMap<String, Long> hashMap, JSONObject jSONObject, HashMap<String, String> hashMap2) {
        try {
            for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
                if (!"total".equals(entry.getKey())) {
                    jSONObject.put(entry.getKey(), entry.getValue().longValue());
                    hashMap2.put(entry.getKey(), entry.getValue().toString());
                }
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "putStepsCostData e:" + e16);
        }
    }

    protected String getExceptionMessage(Exception exc) {
        StringBuilder sb5 = new StringBuilder();
        if (exc != null) {
            sb5.append(exc.toString());
            if (exc.getStackTrace() != null) {
                StackTraceElement[] stackTrace = exc.getStackTrace();
                for (int i3 = 0; i3 < stackTrace.length && i3 < 16; i3++) {
                    sb5.append("\n ");
                    sb5.append(stackTrace[i3].toString());
                }
            }
        }
        return sb5.toString();
    }

    protected String operTypeToEventCode(int i3) {
        switch (i3) {
            case 1:
                return EventCode.JS_EXCEPTION;
            case 2:
                return EventCode.NATIVE_EXCEPTION;
            case 3:
                return EventCode.OPEN_HIPPY;
            case 4:
                return EventCode.LOAD_MODULE_JS_EXCEPTION;
            case 5:
                return EventCode.CHECK_UPDATE_HTTP;
            case 6:
                return EventCode.LOAD_PAGE_TIMEOUT;
            case 7:
                return EventCode.LOAD_CRASH;
            case 8:
                return EventCode.LOAD_STEP_TIMEOUT;
            case 9:
                return EventCode.OPEN_GAMECENTER;
            case 10:
                return EventCode.PRELOAD_HIPPY;
            case 11:
                return EventCode.CHECK_UPDATE_SSO;
            case 12:
                return EventCode.HIPPY_UNUSED_PRELOAD;
            default:
                return null;
        }
    }

    public void reportCheckUpdate(String str, int i3, int i16, String str2, long j3, HashMap<String, String> hashMap) {
        long j16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i16 > 0) {
            i16 = (i16 * (-1)) - 10000;
        }
        if (j3 < 0) {
            j3 *= -1;
        }
        try {
            int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(str);
            if (i16 == 0) {
                j16 = j3;
            } else {
                j16 = i16;
            }
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("page", str);
            hashMap2.put("page_ver", String.valueOf(moduleVersion));
            hashMap2.put("ret", String.valueOf(j16));
            hashMap2.put("eventCode", operTypeToEventCode(i3));
            hashMap2.put(EXTRA_KEY_REPORT_ERRMSG, str2);
            hashMap2.put("totaltime", String.valueOf(j3));
            if (hashMap != null) {
                hashMap2.putAll(hashMap);
            }
            baseReport(hashMap2);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportCheckUpdate e:" + th5);
        }
    }

    public void reportException(String str, int i3, int i16, Exception exc, HashMap<String, String> hashMap) {
        if (exc != null && !TextUtils.isEmpty(str)) {
            try {
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("page", str);
                hashMap2.put("page_ver", String.valueOf(i3));
                hashMap2.put("ret", String.valueOf(0));
                hashMap2.put("eventCode", operTypeToEventCode(i16));
                hashMap2.put(EXTRA_KEY_REPORT_ERRMSG, getExceptionMessage(exc));
                if (hashMap != null) {
                    hashMap2.putAll(hashMap);
                }
                baseReport(hashMap2);
                CaughtExceptionReportProxy.e(new QQHippyException(str + "_" + i3 + "_" + i16, exc), "");
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "reportException e:" + th5);
            }
        }
    }

    public void reportGameCenterHippy(int i3, boolean z16) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ret", String.valueOf(i3));
            hashMap.put("eventCode", operTypeToEventCode(9));
            baseReport(hashMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportGameCenterHippy e:" + th5);
        }
    }

    public void reportHippyLoadResult(int i3, String str, int i16, HashMap<String, Object> hashMap, HashMap<String, Long> hashMap2, HashMap<String, String> hashMap3) {
        String stringFromHashMap;
        boolean booleanValue;
        boolean booleanValue2;
        boolean booleanValue3;
        String stringFromHashMap2;
        String stringFromHashMap3;
        int intFromHashMap;
        int intFromHashMap2;
        String stringFromHashMap4;
        String stringFromHashMap5;
        int intFromHashMap3;
        String stringFromHashMap6;
        String stringFromHashMap7;
        String stringFromHashMap8;
        String stringFromHashMap9;
        String stringFromHashMap10;
        long longFromHashMap;
        String stringFromHashMap11;
        String stringFromHashMap12;
        int i17;
        int i18;
        int i19;
        if (hashMap2 != null && hashMap2.size() > 0 && hashMap != null && hashMap.size() > 0) {
            try {
                int intFromHashMap4 = getIntFromHashMap(hashMap, "ret", -1);
                if (intFromHashMap4 > 0) {
                    intFromHashMap4 *= -1;
                }
                int i26 = intFromHashMap4;
                stringFromHashMap = getStringFromHashMap(hashMap, "errMsg");
                booleanValue = getBooleanFromHashMap(hashMap, "isPreload", false).booleanValue();
                booleanValue2 = getBooleanFromHashMap(hashMap, "isPredraw", false).booleanValue();
                booleanValue3 = getBooleanFromHashMap(hashMap, TabPreloadItem.PRELOAD_TYPE_SNAPSHOT, false).booleanValue();
                stringFromHashMap2 = getStringFromHashMap(hashMap, OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE);
                stringFromHashMap3 = getStringFromHashMap(hashMap, "from");
                intFromHashMap = getIntFromHashMap(hashMap, "skeyState", -1);
                intFromHashMap2 = getIntFromHashMap(hashMap, "pskeyState", -1);
                stringFromHashMap4 = getStringFromHashMap(hashMap, "processName");
                stringFromHashMap5 = getStringFromHashMap(hashMap, "isRestored");
                intFromHashMap3 = getIntFromHashMap(hashMap, "updateBusJsState", 201);
                stringFromHashMap6 = getStringFromHashMap(hashMap, HippyQQPreloadEngine.EXTRA_KEY_SWITCH_PROCESS_COST);
                stringFromHashMap7 = getStringFromHashMap(hashMap, "commonssrVer");
                stringFromHashMap8 = getStringFromHashMap(hashMap, "removePreDrawState");
                stringFromHashMap9 = getStringFromHashMap(hashMap, "curLoadStep");
                stringFromHashMap10 = getStringFromHashMap(hashMap, "sign");
                longFromHashMap = getLongFromHashMap(hashMap2, "total", 0L);
                if (i26 != 0) {
                    longFromHashMap = i26;
                }
                stringFromHashMap11 = getStringFromHashMap(hashMap, "coreJsLength");
                stringFromHashMap12 = getStringFromHashMap(hashMap, "busJsLength");
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                HashMap<String, String> hashMap4 = new HashMap<>();
                hashMap4.put("page", str);
                hashMap4.put("page_ver", String.valueOf(i16));
                hashMap4.put("ret", String.valueOf(longFromHashMap));
                hashMap4.put("eventCode", operTypeToEventCode(i3));
                hashMap4.put(EXTRA_KEY_REPORT_ERRMSG, stringFromHashMap);
                hashMap4.put("from", stringFromHashMap3);
                if (booleanValue) {
                    i17 = 1;
                } else {
                    i17 = 0;
                }
                hashMap4.put("isPreload", String.valueOf(i17));
                if (booleanValue2) {
                    i18 = 1;
                } else {
                    i18 = 0;
                }
                hashMap4.put("isPredraw", String.valueOf(i18));
                if (booleanValue3) {
                    i19 = 1;
                } else {
                    i19 = 0;
                }
                hashMap4.put(TabPreloadItem.PRELOAD_TYPE_SNAPSHOT, String.valueOf(i19));
                hashMap4.put(OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE, stringFromHashMap2);
                hashMap4.put("skeyState", String.valueOf(intFromHashMap));
                hashMap4.put("pskeyState", String.valueOf(intFromHashMap2));
                hashMap4.put("processName", stringFromHashMap4);
                hashMap4.put("isRestored", stringFromHashMap5);
                hashMap4.put("updateBusJsState", String.valueOf(intFromHashMap3));
                hashMap4.put(HippyQQPreloadEngine.EXTRA_KEY_SWITCH_PROCESS_COST, stringFromHashMap6);
                hashMap4.put("commonssrVer", stringFromHashMap7);
                hashMap4.put("removePreDrawState", stringFromHashMap8);
                hashMap4.put("curLoadStep", stringFromHashMap9);
                hashMap4.put("sign", stringFromHashMap10);
                if (stringFromHashMap11 != null) {
                    hashMap4.put("coreJsLength", stringFromHashMap11);
                }
                if (stringFromHashMap12 != null) {
                    hashMap4.put("busJsLength", stringFromHashMap12);
                }
                if (hashMap3 != null) {
                    hashMap4.putAll(hashMap3);
                }
                putStepsCostData(hashMap2, new JSONObject(), hashMap4);
                baseReport(hashMap4);
            } catch (Throwable th6) {
                th = th6;
                QLog.e(TAG, 1, "reportHippyLoadResult e:" + th);
            }
        }
    }

    public void reportOper(String str, int i3, int i16, int i17, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("page", str);
            hashMap.put("page_ver", String.valueOf(i3));
            hashMap.put("ret", String.valueOf(i17));
            hashMap.put("oper_type", operTypeToEventCode(i16));
            hashMap.put(EXTRA_KEY_REPORT_ERRMSG, str2);
            baseReport(hashMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportOper e:" + th5);
        }
    }

    public void reportPreDownloadOper(String str, int i3, int i16, int i17, JSONObject jSONObject, String str2) {
        String jSONObject2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("page", str);
            hashMap.put("page_ver", String.valueOf(i3));
            hashMap.put("ret", String.valueOf(i17));
            hashMap.put("eventCode", operTypeToEventCode(i16));
            hashMap.put(EXTRA_KEY_REPORT_ERRMSG, str2);
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                jSONObject2 = jSONObject.toString();
            }
            hashMap.put("oper_data", jSONObject2);
            baseReport(hashMap);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[reportPreDownloadOper] dtReportParams:" + hashMap);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportOper e:" + th5);
        }
    }

    public void reportStepCrash(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ret", String.valueOf(0));
            hashMap.put("eventCode", operTypeToEventCode(7));
            baseReport(hashMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportCrash e:" + th5);
        }
    }

    public void reportStepTimeOut(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ret", String.valueOf(0));
            hashMap.put("eventCode", operTypeToEventCode(8));
            baseReport(hashMap);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportCrash e:" + th5);
        }
    }

    public void reportToDengTa(String str, int i3, String str2, int i16, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("page", str);
            hashMap2.put("page_ver", String.valueOf(i3));
            hashMap2.put("ret", String.valueOf(i16));
            hashMap2.put("eventCode", str2);
            if (hashMap != null) {
                hashMap2.putAll(hashMap);
            }
            baseReport(hashMap2);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportOper e:" + th5);
        }
    }

    public static void reportToDengTa(String str, Map<String, String> map, boolean z16) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (map == null) {
                map = new HashMap<>();
            }
            getReportHeadData(map);
            QQBeaconReport.reportWithAppKey(HIPPY_REPORT_APP_KEY, map.remove("uin"), str, true, map, z16);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "reportToDengTa eventCode:" + str + " data:" + map);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "reportToDengTa e:" + th5);
        }
    }

    public void reportOper(String str, int i3, int i16) {
        reportOper(str, i3, i16, 0, null);
    }
}
