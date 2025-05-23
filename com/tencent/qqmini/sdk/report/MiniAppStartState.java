package com.tencent.qqmini.sdk.report;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppStartState {
    public static ConcurrentHashMap<String, StartState> startStateMap = new ConcurrentHashMap<>();
    public static boolean isBaseLibLoaded = false;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class StartState {
        public int baseLibDownload = -1;
        public int baselibLoad = -1;
        public int apkgDownload = -1;
        public int pageSwitch = -1;
        public int processLoad = -1;
    }

    public static int getApkgDownload(String str) {
        return getState(str).apkgDownload;
    }

    public static String getApkgDownloadDesc(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        int apkgDownload = getApkgDownload(str);
        if (apkgDownload == 0) {
            return "apkg_not_download";
        }
        if (apkgDownload != 1) {
            return "unknown";
        }
        return "apkg_download";
    }

    public static int getBaseLibDownload(String str) {
        return getState(str).baseLibDownload;
    }

    public static String getBaseLibDownloadDesc(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        int baseLibDownload = getBaseLibDownload(str);
        if (baseLibDownload == 0) {
            return "baselib_not_download";
        }
        if (baseLibDownload != 1) {
            return "unknown";
        }
        return "baselib_download";
    }

    public static int getBaselibLoad(String str) {
        return getState(str).baselibLoad;
    }

    public static String getBaselibLoadDesc(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        int baselibLoad = getBaselibLoad(str);
        if (baselibLoad == 0) {
            return MiniAppReportManager2.VALUE_SERVICE_NOT_PRELOAD;
        }
        if (baselibLoad != 1) {
            return "unknown";
        }
        return MiniAppReportManager2.VALUE_SERVICE_PRELOAD;
    }

    public static int getPageSwitch(String str) {
        return getState(str).pageSwitch;
    }

    public static String getPageSwitchDesc(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        int pageSwitch = getPageSwitch(str);
        if (pageSwitch == 0) {
            return "hot_start";
        }
        if (pageSwitch != 1) {
            return "unknown";
        }
        return "page_switch";
    }

    public static int getProcessLoad(String str) {
        return getState(str).processLoad;
    }

    public static String getProcessLoadDesc(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        int processLoad = getProcessLoad(str);
        if (processLoad == 0) {
            return MiniAppReportManager2.VALUE_SERVICE_NOT_PRELOAD;
        }
        if (processLoad != 1) {
            return "unknown";
        }
        return MiniAppReportManager2.VALUE_SERVICE_PRELOAD;
    }

    public static StartState getState(String str) {
        if (startStateMap.containsKey(str)) {
            return startStateMap.get(str);
        }
        StartState startState = new StartState();
        startStateMap.put(str, startState);
        return startState;
    }

    public static void removeState(String str) {
        startStateMap.remove(str);
    }

    public static void reset(String str) {
        StartState state = getState(str);
        state.baseLibDownload = -1;
        state.baselibLoad = -1;
        state.apkgDownload = -1;
        state.pageSwitch = -1;
        state.processLoad = -1;
    }

    public static void setApkgDownload(String str, boolean z16) {
        if (z16) {
            getState(str).apkgDownload = 1;
        } else {
            getState(str).apkgDownload = 0;
        }
    }

    public static void setBaseLibDownload(String str, boolean z16) {
        if (z16) {
            getState(str).baseLibDownload = 1;
        } else {
            getState(str).baseLibDownload = 0;
        }
    }

    public static void setBaseLibLoad(String str, boolean z16) {
        if (z16) {
            getState(str).baselibLoad = 1;
        } else {
            getState(str).baselibLoad = 0;
        }
    }

    public static void setProcessLoad(String str, boolean z16) {
        if (z16) {
            getState(str).processLoad = 1;
        } else {
            getState(str).processLoad = 0;
        }
    }

    public static void setSwitchPage(String str, boolean z16) {
        if (z16) {
            getState(str).pageSwitch = 1;
        } else {
            getState(str).pageSwitch = 0;
        }
    }

    public static void updateState(String str, boolean z16) {
        StartState state = getState(str);
        if (state != null && z16) {
            if (state.apkgDownload == -1) {
                state.apkgDownload = 1;
            }
            if (state.baseLibDownload == -1) {
                state.baseLibDownload = 1;
            }
            if (state.baselibLoad == -1) {
                state.baselibLoad = 1;
            }
        }
    }

    public static void reset(String str, boolean z16) {
        StartState state = getState(str);
        if (z16) {
            state.baseLibDownload = 1;
            state.baselibLoad = 1;
            state.apkgDownload = 1;
            state.processLoad = 1;
        } else {
            state.baseLibDownload = 0;
            state.baselibLoad = 0;
            state.apkgDownload = 0;
            state.processLoad = 0;
        }
        if (state.pageSwitch == -1) {
            state.pageSwitch = 0;
        }
    }
}
