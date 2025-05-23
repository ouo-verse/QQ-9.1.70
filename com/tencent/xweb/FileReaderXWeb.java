package com.tencent.xweb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.lq.d;
import com.tencent.luggage.wxa.yq.u;
import com.tencent.mobileqq.R;
import com.tencent.xweb.FileReaderHelper;
import com.tencent.xweb.XFileSdk;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.xwalk.plugin.XWalkPlugin;
import com.tencent.xweb.xwalk.plugin.XWalkPluginManager;
import com.tencent.xweb.xwalk.plugin.XWalkPluginUpdateListener;
import com.tencent.xweb.xwalk.plugin.XWalkPluginUpdater;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileReaderXWeb {

    /* renamed from: a, reason: collision with root package name */
    public static Map f384903a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static Map f384904b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static Map f384905c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public static u.b f384906d = null;

    public static Bitmap f(HashMap hashMap, String str) {
        if (hashMap == null) {
            x0.c("FileReaderXWeb", "getBitmapFromParams params is null");
            return null;
        }
        try {
            Object obj = hashMap.get(str);
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            x0.c("FileReaderXWeb", "getBitmapFromParams value is not bitmap, key: " + str);
            return null;
        } catch (Throwable th5) {
            x0.a("FileReaderXWeb", "getBitmapFromParams error", th5);
            return null;
        }
    }

    public static void finishReadFile(String str, String str2) {
        try {
            if (f384906d != null) {
                x0.d("FileReaderXWeb", "finishReadFile pre updater exist, cancel it");
                f384906d.cancelPluginUpdate();
                f384906d = null;
            }
            String str3 = (String) f384903a.get(str + str2);
            if (str3 == null) {
                return;
            }
            f384903a.remove(str + str2);
            XWalkPlugin plugin = XWalkPluginManager.getPlugin(str3);
            if (plugin instanceof XWalkReaderBasePlugin) {
                x0.d("FileReaderXWeb", "finishReadFile " + str3);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("file_path", str2);
                hashMap.put("token", str);
                ((XWalkReaderBasePlugin) plugin).finishReadFile(hashMap);
            } else {
                x0.c("FileReaderXWeb", "finishReadFile unknown plugin: " + str3);
            }
            a(str, str2);
        } catch (Throwable th5) {
            x0.a("FileReaderXWeb", "finishReadFile error", th5);
        }
    }

    public static Float g(HashMap hashMap, String str) {
        if (hashMap == null) {
            x0.c("FileReaderXWeb", "getFloatFromParams params is null");
            return null;
        }
        try {
            Object obj = hashMap.get(str);
            if (obj instanceof Float) {
                return (Float) obj;
            }
            x0.c("FileReaderXWeb", "getFloatFromParams value is not float, key: " + str);
            return null;
        } catch (Throwable th5) {
            x0.a("FileReaderXWeb", "getFloatFromParams error", th5);
            return null;
        }
    }

    public static XFileSdk.ViewStatus getViewStatus(String str, String str2) {
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty()) {
                    String str3 = (String) f384903a.get(str + str2);
                    if (str3 == null) {
                        x0.c("FileReaderXWeb", "getViewStatus error, not reading");
                        return null;
                    }
                    XWalkPlugin plugin = XWalkPluginManager.getPlugin(str3);
                    if (plugin instanceof XWalkReaderBasePlugin) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("token", str);
                        return ((XWalkReaderBasePlugin) plugin).getViewStatus(hashMap);
                    }
                    x0.c("FileReaderXWeb", "getViewStatus error, unknown plugin: " + str3);
                    return null;
                }
            } catch (Throwable th5) {
                x0.a("FileReaderXWeb", "getViewStatus error", th5);
                return null;
            }
        }
        x0.c("FileReaderXWeb", "getViewStatus error, invalid param");
        return null;
    }

    public static Integer h(HashMap hashMap, String str) {
        if (hashMap == null) {
            x0.c("FileReaderXWeb", "getIntegerFromParams params is null");
            return null;
        }
        try {
            Object obj = hashMap.get(str);
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            x0.c("FileReaderXWeb", "getIntegerFromParams value is not integer, key: " + str);
            return null;
        } catch (Throwable th5) {
            x0.a("FileReaderXWeb", "getIntegerFromParams error", th5);
            return null;
        }
    }

    public static MotionEvent i(HashMap hashMap, String str) {
        if (hashMap == null) {
            x0.c("FileReaderXWeb", "getMotionEventFromParams params is null");
            return null;
        }
        try {
            Object obj = hashMap.get(str);
            if (obj instanceof MotionEvent) {
                return (MotionEvent) obj;
            }
            x0.c("FileReaderXWeb", "getMotionEventFromParams value is not motion event, key: " + str);
            return null;
        } catch (Throwable th5) {
            x0.a("FileReaderXWeb", "getMotionEventFromParams error", th5);
            return null;
        }
    }

    public static boolean isPluginAvailable(String str, boolean z16, boolean z17, int i3) {
        if (z16 && FileReaderCrashDetector.isRecentCrashed(str)) {
            x0.d("FileReaderXWeb", "isPluginAvailable recent crashed");
            return false;
        }
        XWalkPlugin plugin = FileReaderHelper.getPlugin(str);
        if (!(plugin instanceof XWalkReaderBasePlugin)) {
            x0.d("FileReaderXWeb", "isPluginAvailable unSupport format" + str);
            return false;
        }
        XWalkReaderBasePlugin xWalkReaderBasePlugin = (XWalkReaderBasePlugin) plugin;
        int availableVersion = xWalkReaderBasePlugin.getAvailableVersion(true);
        int minSupportRuntimeVersion = xWalkReaderBasePlugin.getMinSupportRuntimeVersion(i3);
        if (availableVersion > 0 && availableVersion >= minSupportRuntimeVersion) {
            x0.d("FileReaderXWeb", "isPluginAvailable has available version");
            return true;
        }
        x0.d("FileReaderXWeb", "isPluginAvailable no available version, depends on canExplicitInstall");
        if (FileReaderHelper.canExplicitInstall(xWalkReaderBasePlugin, z17, minSupportRuntimeVersion) <= 0) {
            return false;
        }
        return true;
    }

    public static String j(HashMap hashMap, String str) {
        if (hashMap == null) {
            x0.c("FileReaderXWeb", "getStringFromParams params is null");
            return null;
        }
        try {
            Object obj = hashMap.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            x0.c("FileReaderXWeb", "getStringFromParams value is not string, key: " + str);
            return null;
        } catch (Throwable th5) {
            x0.a("FileReaderXWeb", "getStringFromParams error", th5);
            return null;
        }
    }

    public static void readFile(String str, String str2, String str3, boolean z16, HashMap<String, String> hashMap, XFileSdk.ViewType viewType, Activity activity, ViewGroup viewGroup, XFileSdk.ActionCallback actionCallback, ValueCallback<Integer> valueCallback) {
        String str4;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("readFile by xweb, fileExt: ");
        if (str2 != null) {
            str4 = str2;
        } else {
            str4 = "null";
        }
        sb5.append(str4);
        x0.d("FileReaderXWeb", sb5.toString());
        String a16 = a(activity, str3, str);
        long reportFileSize = FileReaderHelper.reportFileSize(a16, str2);
        FileReaderHelper.reportPVUV(str2, FileReaderHelper.ReaderType.XWEB.name());
        FileReaderHelper.OpenFileReportData openFileReportData = new FileReaderHelper.OpenFileReportData(FileReaderHelper.getOpenFileScene(hashMap), str2, reportFileSize, "unknown", -1, FileReaderHelper.convertOpenFileFrom(FileReaderHelper.getOpenFileFrom(hashMap)));
        XWalkPlugin plugin = FileReaderHelper.getPlugin(str2);
        if (!(plugin instanceof XWalkReaderBasePlugin)) {
            x0.c("FileReaderXWeb", "readFile unSupport format" + str2);
            if (plugin != null) {
                openFileReportData.readerType = plugin.getPluginName();
                openFileReportData.version = plugin.getAvailableVersion(true);
            }
            openFileReportData.markStart(activity);
            FileReaderHelper.reportOpenFile(openFileReportData);
            b(str2, -1, valueCallback, -7, activity, openFileReportData);
            return;
        }
        XWalkReaderBasePlugin xWalkReaderBasePlugin = (XWalkReaderBasePlugin) plugin;
        int availableVersion = xWalkReaderBasePlugin.getAvailableVersion(true);
        openFileReportData.readerType = xWalkReaderBasePlugin.getPluginName();
        openFileReportData.version = availableVersion;
        openFileReportData.markStart(activity);
        FileReaderHelper.reportOpenFile(openFileReportData);
        c(xWalkReaderBasePlugin, a16, str2, str3, z16, openFileReportData, hashMap, viewType, activity, viewGroup, actionCallback, valueCallback);
    }

    public static boolean requestThumbnail(String str, String str2, int i3) {
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty() && i3 >= 0) {
                    String str3 = (String) f384903a.get(str + str2);
                    if (str3 == null) {
                        x0.c("FileReaderXWeb", "requestThumbnail error, not reading");
                        return false;
                    }
                    XWalkPlugin plugin = XWalkPluginManager.getPlugin(str3);
                    if (plugin instanceof XWalkReaderBasePlugin) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("token", str);
                        hashMap.put(XWalkReaderBasePlugin.PARAM_KEY_THUMBNAIL_INDEX, Integer.valueOf(i3));
                        return ((XWalkReaderBasePlugin) plugin).requestThumbnail(hashMap);
                    }
                    x0.c("FileReaderXWeb", "requestThumbnail error, unknown plugin: " + str3);
                    return false;
                }
            } catch (Throwable th5) {
                x0.a("FileReaderXWeb", "requestThumbnail error", th5);
                return false;
            }
        }
        x0.c("FileReaderXWeb", "requestThumbnail error, invalid param");
        return false;
    }

    public static boolean setDisableDoubleTap(String str, String str2, boolean z16) {
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty()) {
                    String str3 = (String) f384903a.get(str + str2);
                    if (str3 == null) {
                        x0.c("FileReaderXWeb", "setDisableDoubleTap error, not reading");
                        return false;
                    }
                    XWalkPlugin plugin = XWalkPluginManager.getPlugin(str3);
                    if (plugin instanceof XWalkReaderBasePlugin) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("token", str);
                        hashMap.put(XWalkReaderBasePlugin.GENERAL_INVOKE_NAME, XWalkReaderBasePlugin.GENERAL_INVOKE_NAME_SET_DISABLE_DOUBLE_TAP);
                        hashMap.put(XWalkReaderBasePlugin.GENERAL_INVOKE_PARAM_KEY_DISABLE_DOUBLE_TAP, Boolean.valueOf(z16));
                        Object generalInvoke = ((XWalkReaderBasePlugin) plugin).generalInvoke(hashMap);
                        if (!(generalInvoke instanceof Boolean)) {
                            return false;
                        }
                        return ((Boolean) generalInvoke).booleanValue();
                    }
                    x0.c("FileReaderXWeb", "setDisableDoubleTap error, unknown plugin: " + str3);
                    return false;
                }
            } catch (Throwable th5) {
                x0.a("FileReaderXWeb", "setDisableDoubleTap error", th5);
                return false;
            }
        }
        x0.c("FileReaderXWeb", "setDisableDoubleTap error, invalid param");
        return false;
    }

    public static boolean setDisableScroll(String str, String str2, boolean z16) {
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty()) {
                    String str3 = (String) f384903a.get(str + str2);
                    if (str3 == null) {
                        x0.c("FileReaderXWeb", "setDisableScroll error, not reading");
                        return false;
                    }
                    XWalkPlugin plugin = XWalkPluginManager.getPlugin(str3);
                    if (plugin instanceof XWalkReaderBasePlugin) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("token", str);
                        hashMap.put(XWalkReaderBasePlugin.GENERAL_INVOKE_NAME, XWalkReaderBasePlugin.GENERAL_INVOKE_NAME_SET_DISABLE_SCROLL);
                        hashMap.put(XWalkReaderBasePlugin.GENERAL_INVOKE_PARAM_KEY_DISABLE_SCROLL, Boolean.valueOf(z16));
                        Object generalInvoke = ((XWalkReaderBasePlugin) plugin).generalInvoke(hashMap);
                        if (!(generalInvoke instanceof Boolean)) {
                            return false;
                        }
                        return ((Boolean) generalInvoke).booleanValue();
                    }
                    x0.c("FileReaderXWeb", "setDisableScroll error, unknown plugin: " + str3);
                    return false;
                }
            } catch (Throwable th5) {
                x0.a("FileReaderXWeb", "setDisableScroll error", th5);
                return false;
            }
        }
        x0.c("FileReaderXWeb", "setDisableScroll error, invalid param");
        return false;
    }

    public static boolean setTouchEvent(String str, String str2, MotionEvent motionEvent) {
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty() && motionEvent != null) {
                    String str3 = (String) f384903a.get(str + str2);
                    if (str3 == null) {
                        x0.c("FileReaderXWeb", "setTouchEvent error, not reading");
                        return false;
                    }
                    XWalkPlugin plugin = XWalkPluginManager.getPlugin(str3);
                    if (plugin instanceof XWalkReaderBasePlugin) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("token", str);
                        hashMap.put(XWalkReaderBasePlugin.GENERAL_INVOKE_NAME, XWalkReaderBasePlugin.GENERAL_INVOKE_NAME_SET_TOUCH_EVENT);
                        hashMap.put(XWalkReaderBasePlugin.GENERAL_INVOKE_PARAM_KEY_TOUCH_EVENT, motionEvent);
                        Object generalInvoke = ((XWalkReaderBasePlugin) plugin).generalInvoke(hashMap);
                        if (!(generalInvoke instanceof Boolean)) {
                            return false;
                        }
                        return ((Boolean) generalInvoke).booleanValue();
                    }
                    x0.c("FileReaderXWeb", "setTouchEvent error, unknown plugin: " + str3);
                    return false;
                }
            } catch (Throwable th5) {
                x0.a("FileReaderXWeb", "setTouchEvent error", th5);
                return false;
            }
        }
        x0.c("FileReaderXWeb", "setTouchEvent error, invalid param");
        return false;
    }

    public static boolean setViewToStatus(String str, String str2, int i3, float f16, int i16, int i17) {
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty()) {
                    String str3 = (String) f384903a.get(str + str2);
                    if (str3 == null) {
                        x0.c("FileReaderXWeb", "setViewToStatus error, not reading");
                        return false;
                    }
                    XWalkPlugin plugin = XWalkPluginManager.getPlugin(str3);
                    if (plugin instanceof XWalkReaderBasePlugin) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("token", str);
                        hashMap.put(XWalkReaderBasePlugin.PARAM_KEY_SET_INDEX, Integer.valueOf(i3));
                        hashMap.put(XWalkReaderBasePlugin.PARAM_KEY_SET_ZOOM, Float.valueOf(f16));
                        hashMap.put(XWalkReaderBasePlugin.PARAM_KEY_SET_X, Integer.valueOf(i16));
                        hashMap.put(XWalkReaderBasePlugin.PARAM_KEY_SET_Y, Integer.valueOf(i17));
                        return ((XWalkReaderBasePlugin) plugin).setViewToStatus(hashMap);
                    }
                    x0.c("FileReaderXWeb", "setViewToStatus error, unknown plugin: " + str3);
                    return false;
                }
            } catch (Throwable th5) {
                x0.a("FileReaderXWeb", "setViewToStatus error", th5);
                return false;
            }
        }
        x0.c("FileReaderXWeb", "setViewToStatus error, invalid param");
        return false;
    }

    public static void b(final XWalkReaderBasePlugin xWalkReaderBasePlugin, final String str, final String str2, final String str3, final boolean z16, final FileReaderHelper.OpenFileReportData openFileReportData, final HashMap hashMap, final XFileSdk.ViewType viewType, final Activity activity, final ViewGroup viewGroup, final XFileSdk.ActionCallback actionCallback, final ValueCallback valueCallback) {
        boolean z17;
        boolean z18;
        String str4;
        boolean readFile;
        final int availableVersion = xWalkReaderBasePlugin.getAvailableVersion();
        long currentTimeMillis = System.currentTimeMillis();
        long currentProcessMemory = FileReaderHelper.getCurrentProcessMemory(activity);
        if (WebDebugCfg.getInst() != null) {
            z17 = WebDebugCfg.getInst().getDisableFileReaderCache();
            z18 = WebDebugCfg.getInst().getDisableFileReaderEncry();
        } else {
            z17 = false;
            z18 = true;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry != null && entry.getKey() != null && !((String) entry.getKey()).isEmpty() && entry.getValue() != null && !((String) entry.getValue()).isEmpty() && (!XFileSdk.PARAM_KEY_EXTRA_PARAM_CUSTOM_MENU.equals(entry.getKey()) || !CommandCfgPlugin.getInstance().isXFilesHideCustomMenu())) {
                    hashMap2.put((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        HashMap<String, String> cmdPluginParam = CommandCfgPlugin.getInstance().getCmdPluginParam(xWalkReaderBasePlugin.getPluginName());
        if (cmdPluginParam != null) {
            Iterator<Map.Entry<String, String>> it = cmdPluginParam.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if (next != null && next.getKey() != null && !next.getKey().isEmpty() && next.getValue() != null && !next.getValue().isEmpty()) {
                    hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_CONFIG_PARAM_PREFIX + next.getKey(), next.getValue());
                    it = it;
                }
            }
        }
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_DARK_MODE, String.valueOf(XWalkEnvironment.getForceDarkMode()));
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_DISABLE_CACHE, String.valueOf(z17));
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_DISABLE_ENCRY, String.valueOf(z18));
        hashMap2.put("file_path", str);
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_FILE_EXT, str2);
        hashMap2.put("token", str3);
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_TIME_START, String.valueOf(currentTimeMillis));
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_MEMORY_START, String.valueOf(currentProcessMemory));
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_STR_PASSWORD_TITLE, activity.getString(R.string.f242607v1));
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_STR_PASSWORD_WRONG, activity.getString(R.string.f242617v2));
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_STR_PASSWORD_HINT, activity.getString(R.string.f242597v0));
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_STR_BUTTON_CONFIRM, activity.getString(R.string.f242557uw));
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_STR_BUTTON_CANCEL, activity.getString(R.string.f242547uv));
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_STR_OPERATION_COPY, activity.getString(R.string.f242587uz));
        hashMap2.put(XWalkReaderBasePlugin.PARAM_KEY_STR_HINT_COPIED, activity.getString(R.string.f242567ux));
        if (viewType == XFileSdk.ViewType.ReaderView) {
            hashMap2.put("view_type", XWalkReaderBasePlugin.PARAM_VALUE_VIEW_TYPE_READER);
        } else {
            hashMap2.put("view_type", XWalkReaderBasePlugin.PARAM_VALUE_VIEW_TYPE_LIST);
        }
        boolean isXFilesHideBottomBar = CommandCfgPlugin.getInstance().isXFilesHideBottomBar();
        int minSupportRuntimeVersion = xWalkReaderBasePlugin.getMinSupportRuntimeVersion(2);
        boolean z19 = availableVersion < minSupportRuntimeVersion;
        if (viewGroup != null && (isXFilesHideBottomBar || z19)) {
            x0.d("FileReaderXWeb", "innerReadFile, need hide bottom bar, hideByCmd = " + isXFilesHideBottomBar + ", version = " + availableVersion + ", minSupportVersionBottomBar = " + minSupportRuntimeVersion);
            int i3 = 0;
            while (true) {
                if (i3 >= viewGroup.getChildCount()) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != null) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof String) && XFileSdk.VIEW_TAG_BOTTOM_BAR.equalsIgnoreCase((String) tag)) {
                        childAt.setVisibility(8);
                        break;
                    }
                }
                i3++;
            }
        }
        if (actionCallback != null) {
            str4 = "FileReaderXWeb";
            readFile = xWalkReaderBasePlugin.readFile(hashMap2, activity, viewGroup, new ValueCallback<Pair<String, Object>>() { // from class: com.tencent.xweb.FileReaderXWeb.2
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Pair<String, Object> pair) {
                    Object obj;
                    if (pair != null && (obj = pair.first) != null) {
                        Object obj2 = pair.second;
                        if (obj2 instanceof HashMap) {
                            try {
                                HashMap<String, Object> hashMap3 = (HashMap) obj2;
                                if (XWalkReaderBasePlugin.ACTION_CALLBACK_NAME_ON_VIEW_STATUS_CHANGE.equals(obj)) {
                                    Integer h16 = FileReaderXWeb.h(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_VIEW_INDEX);
                                    if (h16 != null) {
                                        Float g16 = FileReaderXWeb.g(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_VIEW_ZOOM);
                                        if (g16 != null) {
                                            Integer h17 = FileReaderXWeb.h(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_VIEW_CUR_WIDTH);
                                            if (h17 != null) {
                                                Integer h18 = FileReaderXWeb.h(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_VIEW_CUR_HEIGHT);
                                                if (h18 != null) {
                                                    Integer h19 = FileReaderXWeb.h(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_VIEW_TRANS_X);
                                                    if (h19 != null) {
                                                        Integer h26 = FileReaderXWeb.h(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_VIEW_TRANS_Y);
                                                        if (h26 == null) {
                                                            x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", viewTransY is null");
                                                            return;
                                                        }
                                                        XFileSdk.ActionCallback.this.onViewStatusChange(h16.intValue(), g16.floatValue(), h17.intValue(), h18.intValue(), h19.intValue(), h26.intValue());
                                                        return;
                                                    }
                                                    x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", viewTransX is null");
                                                    return;
                                                }
                                                x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", viewCurHeight is null");
                                                return;
                                            }
                                            x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", viewCurWidth is null");
                                            return;
                                        }
                                        x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", viewZoom is null");
                                        return;
                                    }
                                    x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", viewIndex is null");
                                    return;
                                }
                                if (XWalkReaderBasePlugin.ACTION_CALLBACK_NAME_ON_PAGE_COUNT_UPDATE.equals(pair.first)) {
                                    Integer h27 = FileReaderXWeb.h(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_TOTAL_COUNT);
                                    if (h27 == null) {
                                        x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", totalCount is null");
                                        return;
                                    }
                                    XFileSdk.ActionCallback.this.onPageCountUpdate(h27.intValue());
                                    return;
                                }
                                if (XWalkReaderBasePlugin.ACTION_CALLBACK_NAME_ON_PAGE_CHANGE.equals(pair.first)) {
                                    Integer h28 = FileReaderXWeb.h(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_PAGE_INDEX);
                                    if (h28 != null) {
                                        Integer h29 = FileReaderXWeb.h(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_PAGE_WIDTH);
                                        if (h29 != null) {
                                            Integer h36 = FileReaderXWeb.h(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_PAGE_HEIGHT);
                                            if (h36 == null) {
                                                x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", pageHeight is null");
                                                return;
                                            }
                                            XFileSdk.ActionCallback.this.onPageChange(h28.intValue(), h29.intValue(), h36.intValue());
                                            return;
                                        }
                                        x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", pageWidth is null");
                                        return;
                                    }
                                    x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", pageIndex is null");
                                    return;
                                }
                                if (XWalkReaderBasePlugin.ACTION_CALLBACK_NAME_ON_THUMBNAIL_LOAD.equals(pair.first)) {
                                    Integer h37 = FileReaderXWeb.h(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_PAGE_INDEX);
                                    Bitmap f16 = FileReaderXWeb.f(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_THUMBNAIL);
                                    if (h37 != null && f16 != null) {
                                        XFileSdk.ActionCallback.this.onThumbnailLoad(h37.intValue(), f16);
                                        return;
                                    }
                                    x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", pageIndex/thumbnail is null");
                                    return;
                                }
                                if (XWalkReaderBasePlugin.ACTION_CALLBACK_NAME_ON_SINGLE_TAP.equals(pair.first)) {
                                    MotionEvent i16 = FileReaderXWeb.i(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_MOTION_EVENT);
                                    if (i16 == null) {
                                        x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", motion event is null");
                                        return;
                                    }
                                    XFileSdk.ActionCallback.this.onSingleTap(i16);
                                    return;
                                }
                                if (XWalkReaderBasePlugin.ACTION_CALLBACK_NAME_ON_DOUBLE_TAP.equals(pair.first)) {
                                    MotionEvent i17 = FileReaderXWeb.i(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_MOTION_EVENT);
                                    if (i17 == null) {
                                        x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", motion event is null");
                                        return;
                                    }
                                    XFileSdk.ActionCallback.this.onDoubleTap(i17);
                                    return;
                                }
                                if (XWalkReaderBasePlugin.ACTION_CALLBACK_NAME_ON_GENERAL_CALLBACK.equals(pair.first)) {
                                    String j3 = FileReaderXWeb.j(hashMap3, XWalkReaderBasePlugin.ACTION_CALLBACK_PARAM_KEY_GENERAL_CALLBACK_NAME);
                                    if (j3 == null) {
                                        x0.c("FileReaderXWeb", "actionCallback " + ((String) pair.first) + ", general callback name is null");
                                        return;
                                    }
                                    XFileSdk.ActionCallback.this.onGeneralCallback(j3, hashMap3);
                                    return;
                                }
                                if (XWalkReaderBasePlugin.ACTION_CALLBACK_NAME_ON_REACH_END.equals(pair.first)) {
                                    XFileSdk.ActionCallback.this.onReachEnd();
                                    return;
                                }
                                if (XWalkReaderBasePlugin.ACTION_CALLBACK_NAME_ON_USER_OPERATED.equals(pair.first)) {
                                    XFileSdk.ActionCallback.this.onUserOperated();
                                    return;
                                }
                                if (XWalkReaderBasePlugin.ACTION_CALLBACK_NAME_ON_USER_CANCEL.equals(pair.first)) {
                                    XFileSdk.ActionCallback.this.onUserCancel();
                                    return;
                                }
                                x0.c("FileReaderXWeb", "actionCallback unknown value: " + ((String) pair.first));
                                return;
                            } catch (Throwable unused) {
                                x0.c("FileReaderXWeb", "actionCallback onReceiveValue error, hashMap invalid");
                                return;
                            }
                        }
                    }
                    x0.c("FileReaderXWeb", "actionCallback onReceiveValue error, value invalid");
                }
            }, new ValueCallback<Integer>() { // from class: com.tencent.xweb.FileReaderXWeb.3
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Integer num) {
                    FileReaderXWeb.b(num.intValue(), availableVersion, xWalkReaderBasePlugin, str, str2, str3, z16, openFileReportData, hashMap, viewType, activity, viewGroup, actionCallback, valueCallback);
                }
            });
        } else {
            str4 = "FileReaderXWeb";
            readFile = xWalkReaderBasePlugin.readFile(hashMap2, activity, viewGroup, null, new ValueCallback<Integer>() { // from class: com.tencent.xweb.FileReaderXWeb.4
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(Integer num) {
                    FileReaderXWeb.b(num.intValue(), availableVersion, xWalkReaderBasePlugin, str, str2, str3, z16, openFileReportData, hashMap, viewType, activity, viewGroup, actionCallback, valueCallback);
                }
            });
        }
        if (readFile) {
            String str5 = (String) f384905c.get(str3 + str);
            if (str5 != null) {
                x0.d(str4, "innerReadFile, record uri");
                f384903a.put(str3 + str5, xWalkReaderBasePlugin.getPluginName());
                return;
            }
            x0.d(str4, "innerReadFile, record path");
            f384903a.put(str3 + str, xWalkReaderBasePlugin.getPluginName());
        }
    }

    public static void c(XWalkReaderBasePlugin xWalkReaderBasePlugin, String str, String str2, String str3, boolean z16, FileReaderHelper.OpenFileReportData openFileReportData, HashMap hashMap, XFileSdk.ViewType viewType, Activity activity, ViewGroup viewGroup, XFileSdk.ActionCallback actionCallback, ValueCallback valueCallback) {
        if (xWalkReaderBasePlugin == null) {
            x0.c("FileReaderXWeb", "readFile failed, plugin is null");
            b(str2, -1, valueCallback, -5, activity, openFileReportData);
            return;
        }
        int availableVersion = xWalkReaderBasePlugin.getAvailableVersion();
        int minSupportRuntimeVersion = xWalkReaderBasePlugin.getMinSupportRuntimeVersion(actionCallback != null ? 1 : 0);
        if (availableVersion > 0 && availableVersion >= minSupportRuntimeVersion) {
            b(xWalkReaderBasePlugin, str, str2, str3, z16, openFileReportData, hashMap, viewType, activity, viewGroup, actionCallback, valueCallback);
            return;
        }
        int canExplicitInstall = FileReaderHelper.canExplicitInstall(xWalkReaderBasePlugin, z16, minSupportRuntimeVersion);
        if (canExplicitInstall > 0) {
            x0.d("FileReaderXWeb", "readFile can explicit install");
            FileReaderHelper.reportExplicitInstall(str2);
            if (openFileReportData != null && "none".equals(openFileReportData.explicitDownloadScene)) {
                openFileReportData.explicitDownloadScene = FileReaderHelper.EXPLICIT_DOWNLOAD_SCENE_NOT_INSTALL;
            }
            if (a(xWalkReaderBasePlugin, str, str2, str3, z16, canExplicitInstall, minSupportRuntimeVersion, openFileReportData, hashMap, viewType, activity, viewGroup, actionCallback, valueCallback)) {
                return;
            }
            FileReaderHelper.reportExplicitInstallStartFailed(str2);
            b(str2, availableVersion, valueCallback, -18, activity, openFileReportData);
            return;
        }
        x0.d("FileReaderXWeb", "readFile can not explicit install, return");
        b(str2, availableVersion, valueCallback, -1, activity, openFileReportData);
    }

    public static boolean a(final XWalkReaderBasePlugin xWalkReaderBasePlugin, final String str, final String str2, final String str3, final boolean z16, int i3, final int i16, final FileReaderHelper.OpenFileReportData openFileReportData, final HashMap hashMap, final XFileSdk.ViewType viewType, final Activity activity, ViewGroup viewGroup, final XFileSdk.ActionCallback actionCallback, final ValueCallback valueCallback) {
        if (f384906d != null) {
            x0.d("FileReaderXWeb", "startExplicitInstall pre updater not finish, cancel it");
            f384906d.cancelPluginUpdate();
            f384906d = null;
        }
        f384906d = new XWalkPluginUpdater();
        if (activity != null && !activity.isDestroyed() && viewGroup != null) {
            RelativeLayout relativeLayout = null;
            for (int i17 = 0; i17 < viewGroup.getChildCount(); i17++) {
                View childAt = viewGroup.getChildAt(i17);
                if (childAt != null) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof String) && XFileSdk.VIEW_TAG_RELATIVE_LAYOUT.equalsIgnoreCase((String) tag)) {
                        relativeLayout = (RelativeLayout) childAt;
                    }
                }
            }
            if (relativeLayout == null) {
                if (viewGroup instanceof RelativeLayout) {
                    relativeLayout = (RelativeLayout) viewGroup;
                } else {
                    x0.c("FileReaderXWeb", "startExplicitInstall layout is null");
                    return false;
                }
            }
            if (openFileReportData != null) {
                try {
                    if (!"none".equals(openFileReportData.explicitDownloadScene) && !FileReaderHelper.EXPLICIT_DOWNLOAD_SCENE_NOT_INSTALL.equals(openFileReportData.explicitDownloadScene)) {
                        x0.d("FileReaderXWeb", "startExplicitInstall remove all views in layout");
                        relativeLayout.removeAllViews();
                    }
                } catch (Throwable th5) {
                    x0.c("FileReaderXWeb", "startExplicitInstall remove all views in layout error: " + th5.getMessage());
                }
            }
            Integer a16 = hashMap != null ? a((String) hashMap.get(XFileSdk.PARAM_KEY_EXTRA_PARAM_DOWNLOAD_TEXT_COLOR)) : null;
            if (a16 == null) {
                a16 = -1140850689;
            }
            TextView textView = new TextView(activity);
            textView.setText(activity.getString(R.string.f242657v6));
            textView.setTextSize(14.0f);
            textView.setTextColor(a16.intValue());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            relativeLayout.addView(textView, layoutParams);
            boolean z17 = i3 == 2 || i3 == 3;
            final WeakReference weakReference = new WeakReference(activity);
            final WeakReference weakReference2 = new WeakReference(viewGroup);
            final WeakReference weakReference3 = new WeakReference(textView);
            final boolean z18 = z17;
            f384906d.setPluginOnlyOneToUpdate(xWalkReaderBasePlugin.getPluginName(), new XWalkPluginUpdateListener() { // from class: com.tencent.xweb.FileReaderXWeb.1
                @Override // com.tencent.xweb.xwalk.plugin.XWalkPluginUpdateListener
                public void onXWalkPluginUpdateCompleted(int i18) {
                    int i19;
                    int i26;
                    x0.d("FileReaderXWeb", "onXWalkPluginUpdateCompleted errorCode = " + i18);
                    u.b unused = FileReaderXWeb.f384906d = null;
                    FileReaderHelper.reportDownloadErrorCode(str2, i18);
                    Activity activity2 = (Activity) weakReference.get();
                    ViewGroup viewGroup2 = (ViewGroup) weakReference2.get();
                    TextView textView2 = (TextView) weakReference3.get();
                    if (i18 == 0) {
                        i19 = 0;
                    } else if (i18 == -1) {
                        i19 = -15;
                    } else if (i18 == -2) {
                        i19 = -19;
                    } else if (i18 == -3) {
                        i19 = -20;
                    } else if (i18 == -4) {
                        i19 = -21;
                    } else if (i18 == -5) {
                        i19 = -22;
                    } else if (i18 == -6) {
                        i19 = -23;
                    } else if (i18 == -7) {
                        i19 = -24;
                    } else if (i18 == -8) {
                        i19 = -25;
                    } else {
                        if (i18 != -9) {
                            if (i18 == -10) {
                                i19 = -27;
                            } else if (i18 == -11) {
                                i19 = -28;
                            }
                        }
                        i19 = -26;
                    }
                    int availableVersion = xWalkReaderBasePlugin.getAvailableVersion(true);
                    if (availableVersion >= i16) {
                        if (activity2 != null && !activity2.isFinishing() && !activity2.isDestroyed() && viewGroup2 != null && textView2 != null) {
                            x0.d("FileReaderXWeb", "onXWalkPluginUpdateCompleted, update success, start read file");
                            textView2.setVisibility(8);
                            FileReaderXWeb.b(xWalkReaderBasePlugin, str, str2, str3, z16, openFileReportData, hashMap, viewType, activity2, viewGroup2, actionCallback, valueCallback);
                            return;
                        } else {
                            x0.c("FileReaderXWeb", "onXWalkPluginUpdateCompleted, update success, view destroyed, return");
                            FileReaderXWeb.b(str2, availableVersion, valueCallback, -14, activity, openFileReportData);
                            return;
                        }
                    }
                    x0.d("FileReaderXWeb", "onXWalkPluginUpdateCompleted, update failed or cancel, version " + availableVersion + " < minVersion " + i16);
                    if (activity2 != null && !activity2.isFinishing() && !activity2.isDestroyed() && viewGroup2 != null && textView2 != null) {
                        if (z18) {
                            textView2.setText(activity2.getString(R.string.f242647v5));
                        } else {
                            textView2.setText(activity2.getString(R.string.f242627v3));
                        }
                    }
                    if (i19 == 0) {
                        x0.d("FileReaderXWeb", "onXWalkPluginUpdateCompleted update is success, but version invalid, change ret");
                        if (availableVersion > 0) {
                            i26 = -11;
                        } else {
                            i26 = -2;
                        }
                    } else {
                        i26 = i19;
                    }
                    FileReaderXWeb.b(str2, availableVersion, valueCallback, i26, activity, openFileReportData);
                }

                @Override // com.tencent.xweb.xwalk.plugin.XWalkPluginUpdateListener
                public void onXWalkPluginUpdateProgress(int i18) {
                    x0.d("FileReaderXWeb", "onXWalkPluginUpdateProgress " + i18);
                    Activity activity2 = (Activity) weakReference.get();
                    TextView textView2 = (TextView) weakReference3.get();
                    if (activity2 != null && !activity2.isDestroyed() && textView2 != null) {
                        textView2.setText(activity2.getString(R.string.f242637v4) + i18 + "%");
                    }
                }

                @Override // com.tencent.xweb.xwalk.plugin.XWalkPluginUpdateListener
                public void onXWalkPluginUpdateStarted() {
                    x0.d("FileReaderXWeb", "onXWalkPluginUpdateStarted");
                }
            });
            HashMap hashMap2 = new HashMap();
            if (z17) {
                hashMap2.put(ConstValue.XWEB_UPDATER_START_CHECK_TYPE, "6");
            } else {
                hashMap2.put(ConstValue.XWEB_UPDATER_START_CHECK_TYPE, "1");
            }
            f384906d.startCheck(XWalkEnvironment.getApplicationContext(), hashMap2);
            return true;
        }
        x0.c("FileReaderXWeb", "startExplicitInstall activity destroyed");
        return false;
    }

    public static Integer a(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (Throwable th5) {
                x0.a("FileReaderXWeb", "parseInteger error", th5);
            }
        }
        return null;
    }

    public static String a(Context context, String str, String str2) {
        if (context != null && str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            if (new File(str2).exists()) {
                x0.d("FileReaderXWeb", "fixFilePath, is file, path = " + str2);
                return str2;
            }
            Uri parse = Uri.parse(str2);
            if (parse != null && parse.getScheme() != null) {
                String c16 = u0.c();
                if (c16.isEmpty()) {
                    x0.c("FileReaderXWeb", "fixFilePath error, tempDir is empty");
                    return str2;
                }
                String str3 = c16 + File.separator + XWalkPluginManager.XFILE_TEMP_FILE_PREFIX + str + "_" + System.currentTimeMillis();
                if (w.a(context, parse, new File(str3))) {
                    x0.d("FileReaderXWeb", "fixFilePath, is uri, uri = " + str2 + ", temp path = " + str3);
                    Map map = f384904b;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str);
                    sb5.append(str2);
                    map.put(sb5.toString(), str3);
                    f384905c.put(str + str3, str2);
                    return str3;
                }
                x0.c("FileReaderXWeb", "fixFilePath, is uri but copy error, uri = " + str2 + ", temp path = " + str3);
                return str2;
            }
            x0.d("FileReaderXWeb", "fixFilePath, unknown, path = " + str2);
            return str2;
        }
        x0.c("FileReaderXWeb", "fixFilePath error, invalid params");
        return str2;
    }

    public static void b(int i3, int i16, XWalkReaderBasePlugin xWalkReaderBasePlugin, String str, String str2, String str3, boolean z16, FileReaderHelper.OpenFileReportData openFileReportData, HashMap hashMap, XFileSdk.ViewType viewType, Activity activity, ViewGroup viewGroup, XFileSdk.ActionCallback actionCallback, ValueCallback valueCallback) {
        if (i3 == 0) {
            FileReaderDownloadLimiter.clear(xWalkReaderBasePlugin.getPluginName());
        }
        if (i3 != -3 && i3 != -13) {
            x0.d("FileReaderXWeb", "processInnerRet ret = " + i3 + ", return");
            b(str2, i16, valueCallback, i3, activity, openFileReportData);
            return;
        }
        int availableVersion = xWalkReaderBasePlugin.getAvailableVersion(true);
        boolean z17 = false;
        boolean equalsIgnoreCase = hashMap != null ? "true".equalsIgnoreCase((String) hashMap.get(XFileSdk.PARAM_KEY_EXTRA_PARAM_CAN_DOWNLOAD_WHEN_PLUGIN_ERROR)) : false;
        int todayDownloadCount = FileReaderDownloadLimiter.getTodayDownloadCount(xWalkReaderBasePlugin.getPluginName());
        int maxDownloadCountWhenPluginError = CommandCfgPlugin.getInstance().getMaxDownloadCountWhenPluginError();
        x0.d("FileReaderXWeb", "processInnerRet, todayDownloadCount = " + todayDownloadCount + ", maxDownloadCount = " + maxDownloadCountWhenPluginError);
        if (todayDownloadCount >= maxDownloadCountWhenPluginError) {
            x0.d("FileReaderXWeb", "processInnerRet, reach max download count, disable download");
        } else {
            z17 = equalsIgnoreCase;
        }
        if (availableVersion <= 0 && z17) {
            x0.d("FileReaderXWeb", "processInnerRet ret = " + i3 + ", invoke or abi not match, try download");
            if (hashMap != null) {
                hashMap.remove(XFileSdk.PARAM_KEY_EXTRA_PARAM_CAN_DOWNLOAD_WHEN_PLUGIN_ERROR);
            }
            if (openFileReportData != null) {
                if (i3 == -3) {
                    openFileReportData.explicitDownloadScene = "invoke_error";
                } else if (i3 == -13) {
                    openFileReportData.explicitDownloadScene = "so_error";
                }
            }
            FileReaderDownloadLimiter.record(xWalkReaderBasePlugin.getPluginName());
            c(xWalkReaderBasePlugin, str, str2, str3, true, openFileReportData, hashMap, viewType, activity, viewGroup, actionCallback, valueCallback);
            return;
        }
        x0.d("FileReaderXWeb", "processInnerRet ret = " + i3 + ", invoke or abi not match, but can not download, return");
        b(str2, i16, valueCallback, i3, activity, openFileReportData);
    }

    public static void a(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            final String str3 = (String) f384904b.get(str + str2);
            if (str3 != null) {
                f384904b.remove(str + str2);
                f384905c.remove(str + str3);
                x0.d("FileReaderXWeb", "cleanTempFile, is uri, delay delete " + str3);
                if (str3.isEmpty()) {
                    return;
                }
                d.a(new Runnable() { // from class: com.tencent.xweb.FileReaderXWeb.5
                    @Override // java.lang.Runnable
                    public void run() {
                        x0.d("FileReaderXWeb", "cleanTempFile, do delete " + str3);
                        w.b(str3);
                    }
                }, 3000L);
                return;
            }
            return;
        }
        x0.c("FileReaderXWeb", "cleanTempFile error, invalid params");
    }

    public static void b(String str, int i3, ValueCallback valueCallback, int i16, Context context, FileReaderHelper.OpenFileReportData openFileReportData) {
        FileReaderHelper.reportXWebErrorCode(str, i3, i16, context, openFileReportData);
        if (valueCallback != null) {
            valueCallback.onReceiveValue(Integer.valueOf(i16));
        }
    }
}
