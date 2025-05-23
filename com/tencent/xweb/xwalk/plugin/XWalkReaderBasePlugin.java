package com.tencent.xweb.xwalk.plugin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.heytap.databaseengine.type.DataTableNameType;
import com.tencent.luggage.wxa.ar.j0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.luggage.wxa.wq.b;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.rdelivery.reshub.FileSuffix;
import com.tencent.xweb.FileReaderCrashDetector;
import com.tencent.xweb.FileReaderHelper;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.XFileSdk;
import com.tencent.xweb.XWebClassLoaderWrapper;
import com.tencent.xweb.internal.ConstValue;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

/* loaded from: classes27.dex */
public abstract class XWalkReaderBasePlugin extends XWalkPlugin {
    public static final String ACTION_CALLBACK_NAME_ON_DOUBLE_TAP = "ac_onDoubleTap";
    public static final String ACTION_CALLBACK_NAME_ON_GENERAL_CALLBACK = "ac_onGeneralCallback";
    public static final String ACTION_CALLBACK_NAME_ON_PAGE_CHANGE = "ac_onPageChange";
    public static final String ACTION_CALLBACK_NAME_ON_PAGE_COUNT_UPDATE = "ac_onPageCountUpdate";
    public static final String ACTION_CALLBACK_NAME_ON_REACH_END = "ac_onReachEnd";
    public static final String ACTION_CALLBACK_NAME_ON_SINGLE_TAP = "ac_onSingleTap";
    public static final String ACTION_CALLBACK_NAME_ON_THUMBNAIL_LOAD = "ac_onThumbnailLoad";
    public static final String ACTION_CALLBACK_NAME_ON_USER_CANCEL = "ac_onUserCancel";
    public static final String ACTION_CALLBACK_NAME_ON_USER_OPERATED = "ac_onUserOperated";
    public static final String ACTION_CALLBACK_NAME_ON_VIEW_STATUS_CHANGE = "ac_onViewStatusChange";
    public static final String ACTION_CALLBACK_PARAM_KEY_GENERAL_CALLBACK_NAME = "ac_generalCallbackName";
    public static final String ACTION_CALLBACK_PARAM_KEY_MOTION_EVENT = "ac_motionEvent";
    public static final String ACTION_CALLBACK_PARAM_KEY_PAGE_HEIGHT = "ac_pageHeight";
    public static final String ACTION_CALLBACK_PARAM_KEY_PAGE_INDEX = "ac_pageIndex";
    public static final String ACTION_CALLBACK_PARAM_KEY_PAGE_WIDTH = "ac_pageWidth";
    public static final String ACTION_CALLBACK_PARAM_KEY_THUMBNAIL = "ac_thumbnail";
    public static final String ACTION_CALLBACK_PARAM_KEY_TOTAL_COUNT = "ac_totalCount";
    public static final String ACTION_CALLBACK_PARAM_KEY_VIEW_CUR_HEIGHT = "ac_curHeight";
    public static final String ACTION_CALLBACK_PARAM_KEY_VIEW_CUR_WIDTH = "ac_curWidth";
    public static final String ACTION_CALLBACK_PARAM_KEY_VIEW_INDEX = "ac_viewIndex";
    public static final String ACTION_CALLBACK_PARAM_KEY_VIEW_TRANS_X = "ac_viewTransX";
    public static final String ACTION_CALLBACK_PARAM_KEY_VIEW_TRANS_Y = "ac_viewTransY";
    public static final String ACTION_CALLBACK_PARAM_KEY_VIEW_ZOOM = "ac_viewZoom";
    public static final String BATCH_METHOD_NAME = "batchConvert";
    public static final String DEX_DIR_NAME = "dex";
    public static final String FINISH_METHOD_NAME = "finishReadFile";
    public static final String GENERAL_INVOKE_METHOD_NAME = "generalInvoke";
    public static final String GENERAL_INVOKE_NAME = "gi_name";
    public static final String GENERAL_INVOKE_NAME_SET_DISABLE_DOUBLE_TAP = "gi_setDisableDoubleTap";
    public static final String GENERAL_INVOKE_NAME_SET_DISABLE_SCROLL = "gi_setDisableScroll";
    public static final String GENERAL_INVOKE_NAME_SET_TOUCH_EVENT = "gi_setTouchEvent";
    public static final String GENERAL_INVOKE_PARAM_KEY_DISABLE_DOUBLE_TAP = "gi_disableDoubleTap";
    public static final String GENERAL_INVOKE_PARAM_KEY_DISABLE_SCROLL = "gi_disableScroll";
    public static final String GENERAL_INVOKE_PARAM_KEY_TOUCH_EVENT = "gi_touchEvent";
    public static final String GET_SUPPORT_METHOD_NAME = "getSupportFormats";
    public static final String GET_VIEW_STATUS_METHOD_NAME = "getViewStatus";
    public static final String PARAM_KEY_BATCH_FILE_NAME = "batch_file_name";
    public static final String PARAM_KEY_BATCH_IN_DIR = "batch_in_dir";
    public static final String PARAM_KEY_BATCH_OUT_DIR = "batch_out_dir";
    public static final String PARAM_KEY_BATCH_REMAINING = "batch_remaining";
    public static final String PARAM_KEY_BATCH_SAVE_FILE = "batch_save_file";
    public static final String PARAM_KEY_CACHE_DIR = "cache_dir";
    public static final String PARAM_KEY_CONFIG_PARAM_PREFIX = "config_param_";
    public static final String PARAM_KEY_DARK_MODE = "dark_mode";
    public static final String PARAM_KEY_DISABLE_CACHE = "disable_cache";
    public static final String PARAM_KEY_DISABLE_ENCRY = "disable_encry";
    public static final String PARAM_KEY_ENV_CHANGED = "env_changed";
    public static final String PARAM_KEY_FILE_EXT = "file_ext";
    public static final String PARAM_KEY_FILE_PASSWORD = "file_password";
    public static final String PARAM_KEY_FILE_PATH = "file_path";
    public static final String PARAM_KEY_GET_INDEX = "get_index";
    public static final String PARAM_KEY_GET_X = "get_x";
    public static final String PARAM_KEY_GET_Y = "get_y";
    public static final String PARAM_KEY_GET_ZOOM = "get_zoom";
    public static final String PARAM_KEY_MEMORY_START = "memory_start";
    public static final String PARAM_KEY_PLUGIN_VERSION = "plugin_version";
    public static final String PARAM_KEY_RES_DIR = "res_dir";
    public static final String PARAM_KEY_SET_INDEX = "set_index";
    public static final String PARAM_KEY_SET_X = "set_x";
    public static final String PARAM_KEY_SET_Y = "set_y";
    public static final String PARAM_KEY_SET_ZOOM = "set_zoom";
    public static final String PARAM_KEY_STR_BUTTON_CANCEL = "str_button_cancel";
    public static final String PARAM_KEY_STR_BUTTON_CONFIRM = "str_button_confirm";
    public static final String PARAM_KEY_STR_HINT_COPIED = "str_hint_copied";
    public static final String PARAM_KEY_STR_OPERATION_COPY = "str_operation_copy";
    public static final String PARAM_KEY_STR_PASSWORD_HINT = "str_password_hint";
    public static final String PARAM_KEY_STR_PASSWORD_TITLE = "str_password_title";
    public static final String PARAM_KEY_STR_PASSWORD_WRONG = "str_password_wrong";
    public static final String PARAM_KEY_THUMBNAIL_INDEX = "thumbnail_index";
    public static final String PARAM_KEY_TIME_START = "time_start";
    public static final String PARAM_KEY_TOKEN = "token";
    public static final String PARAM_KEY_VIEW_TYPE = "view_type";
    public static final String PARAM_VALUE_VIEW_TYPE_LIST = "view_type_list";
    public static final String PARAM_VALUE_VIEW_TYPE_READER = "view_type_reader";
    public static final String READ_METHOD_NAME = "readFile";
    public static final String REQUEST_THUMBNAIL_METHOD_NAME = "requestThumbnail";
    public static final String SET_VIEW_TO_STATUS_METHOD_NAME = "setViewToStatus";

    /* renamed from: e, reason: collision with root package name */
    public Class f385173e = null;

    /* renamed from: f, reason: collision with root package name */
    public Class f385174f = null;

    /* renamed from: g, reason: collision with root package name */
    public int f385175g = -1;

    /* renamed from: h, reason: collision with root package name */
    public ValueCallback f385176h = new ValueCallback<Pair<Integer, String>>() { // from class: com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin.1
        @Override // android.webkit.ValueCallback
        public void onReceiveValue(Pair<Integer, String> pair) {
            if (((Integer) pair.first).intValue() == 0) {
                x0.e(XWalkReaderBasePlugin.this.getPluginName(), (String) pair.second);
                return;
            }
            if (((Integer) pair.first).intValue() == 1) {
                x0.b(XWalkReaderBasePlugin.this.getPluginName(), (String) pair.second);
                return;
            }
            if (((Integer) pair.first).intValue() == 2) {
                x0.d(XWalkReaderBasePlugin.this.getPluginName(), (String) pair.second);
            } else if (((Integer) pair.first).intValue() == 3) {
                x0.f(XWalkReaderBasePlugin.this.getPluginName(), (String) pair.second);
            } else if (((Integer) pair.first).intValue() == 4) {
                x0.c(XWalkReaderBasePlugin.this.getPluginName(), (String) pair.second);
            }
        }
    };

    /* renamed from: i, reason: collision with root package name */
    public ValueCallback f385177i = new ValueCallback<Pair<Integer, String>>() { // from class: com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin.2
        @Override // android.webkit.ValueCallback
        public void onReceiveValue(Pair<Integer, String> pair) {
            if (((Integer) pair.first).intValue() == 0) {
                try {
                    String[] split = ((String) pair.second).split(":");
                    if (split.length == 3) {
                        n0.a(Long.parseLong(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    x0.a(XWalkReaderBasePlugin.this.getPluginName(), "idkeyReport parse failed, value:" + ((String) pair.second) + ", error", th5);
                    return;
                }
            }
            if (((Integer) pair.first).intValue() == 1) {
                try {
                    String[] split2 = ((String) pair.second).split(":");
                    if (split2.length == 2) {
                        int parseInt = Integer.parseInt(split2[0]);
                        String str = split2[1];
                        if (parseInt == 17565 || parseInt == 17564) {
                            str = XWalkReaderBasePlugin.this.getAvailableVersion() + "," + split2[1];
                        }
                        n0.a(parseInt, str);
                    }
                } catch (Throwable th6) {
                    x0.a(XWalkReaderBasePlugin.this.getPluginName(), "setKVLog parse failed, value:" + ((String) pair.second) + ", error", th6);
                }
            }
        }
    };

    public void b() {
        synchronized (this) {
            int availableVersion = getAvailableVersion(true);
            if (this.f385173e == null || this.f385174f == null || this.f385175g != availableVersion) {
                x0.d(getPluginName(), "load class of version " + availableVersion);
                ClassLoader classLoader = XWebClassLoaderWrapper.getClassLoader(getAPKPath(availableVersion), getDexDir(availableVersion), getExtractDir(availableVersion));
                this.f385173e = classLoader.loadClass(getReaderClassPath());
                this.f385174f = classLoader.loadClass(getEnvClassPath());
                this.f385175g = availableVersion;
            }
        }
    }

    public boolean batchConvert(HashMap<String, String> hashMap, Activity activity, ValueCallback<Pair<Integer, String>> valueCallback, ValueCallback<Pair<Integer, String>> valueCallback2, ValueCallback<Integer> valueCallback3) {
        if (hashMap != null && activity != null) {
            int availableVersion = getAvailableVersion(true);
            if (availableVersion <= 0) {
                Toast.makeText(activity, "\u63d2\u4ef6\u672a\u5b89\u88c5", 0).show();
                return false;
            }
            if (availableVersion < getMinSupportRuntimeVersion(0)) {
                Toast.makeText(activity, "\u63d2\u4ef6\u7248\u672c\u4e0d\u7b26\u5408\u8981\u6c42", 0).show();
                return false;
            }
            try {
                hashMap.put(PARAM_KEY_CACHE_DIR, getPrivateCacheDir(availableVersion));
                hashMap.put(PARAM_KEY_RES_DIR, getExtractDir(availableVersion));
                hashMap.put("plugin_version", String.valueOf(availableVersion));
                hashMap.put(PARAM_KEY_DISABLE_CACHE, String.valueOf(false));
                hashMap.put(PARAM_KEY_DISABLE_ENCRY, String.valueOf(true));
                b();
                Method method = this.f385173e.getMethod(BATCH_METHOD_NAME, Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class);
                FrameLayout frameLayout = new FrameLayout(activity);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setBackgroundColor(-7829368);
                activity.setContentView(frameLayout);
                method.setAccessible(true);
                method.invoke(null, activity, frameLayout, this.f385173e.getClassLoader(), hashMap, valueCallback, valueCallback2, valueCallback3);
                return true;
            } catch (Throwable unused) {
                Toast.makeText(activity, "\u53cd\u5c04\u5931\u8d25\uff01", 0).show();
                return false;
            }
        }
        Toast.makeText(activity, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, 0).show();
        return false;
    }

    public final String c() {
        return "display_" + Build.DISPLAY + ",sdk_" + Build.VERSION.SDK_INT + ",release_" + Build.VERSION.RELEASE + ",client_" + XWalkEnvironment.getInitConfig(ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, 0);
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public void checkFiles() {
        int availableVersion = getAvailableVersion();
        if (availableVersion < 0) {
            x0.d(getPluginName(), "checkFiles, not installed");
            return;
        }
        int checkFileListConfig = checkFileListConfig(availableVersion, true, "");
        if (checkFileListConfig != 0) {
            x0.c(getPluginName(), "checkFiles failed, abandon version " + availableVersion);
            n0.b(getPluginName());
            b.a(2, getPluginName(), availableVersion, checkFileListConfig, "");
            String versionDir = getVersionDir(availableVersion);
            setAvailableVersion(-1, true);
            if (versionDir != null && !versionDir.isEmpty()) {
                w.a(versionDir);
            }
        }
    }

    public final String d() {
        if (XWalkEnvironment.getApplicationContext() == null) {
            x0.c(getPluginName(), "getSupportFormat, context is null");
            return "";
        }
        SharedPreferences e16 = y0.e(getPluginName());
        if (e16 == null) {
            x0.c(getPluginName(), "getSupportFormat, sp is null");
            return "";
        }
        return e16.getString("supportFormats", "");
    }

    public final boolean e() {
        if (y0.e(getPluginName()) == null) {
            x0.c(getPluginName(), "recordEnv sp is null");
            return true;
        }
        return !c().equals(r0.getString("lastEnvInfo", ""));
    }

    public final void f() {
        SharedPreferences e16 = y0.e(getPluginName());
        if (e16 == null) {
            x0.c(getPluginName(), "recordEnv sp is null");
            return;
        }
        SharedPreferences.Editor edit = e16.edit();
        if (edit == null) {
            x0.c(getPluginName(), "recordEnv sp is null");
        } else {
            edit.putString("lastEnvInfo", c());
            edit.commit();
        }
    }

    public void finishReadFile(HashMap<String, String> hashMap) {
        Class cls = this.f385173e;
        if (cls == null) {
            x0.c(getPluginName(), "finishReadFile error, loadedReaderClass is null");
            return;
        }
        try {
            Method method = cls.getMethod(FINISH_METHOD_NAME, HashMap.class);
            method.setAccessible(true);
            method.invoke(null, hashMap);
        } catch (Throwable th5) {
            x0.c(getPluginName(), "finishReadFile error: " + th5);
        }
    }

    public Object generalInvoke(HashMap<String, Object> hashMap) {
        Class cls = this.f385173e;
        if (cls == null) {
            x0.c(getPluginName(), "generalInvoke error, loadedReaderClass is null");
            return null;
        }
        try {
            Method method = cls.getMethod(GENERAL_INVOKE_METHOD_NAME, HashMap.class);
            method.setAccessible(true);
            return method.invoke(null, hashMap);
        } catch (Throwable th5) {
            x0.c(getPluginName(), "generalInvoke error: " + th5);
            return null;
        }
    }

    public abstract String getAPKPath(int i3);

    public String getDexDir(int i3) {
        String versionDir = getVersionDir(i3);
        if (versionDir != null && !versionDir.isEmpty()) {
            return versionDir + File.separator + "dex";
        }
        x0.c(getPluginName(), "getDexDir, versionDir is empty");
        return "";
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public String getDownloadFullPath(int i3, boolean z16) {
        String versionDir = getVersionDir(i3);
        if (versionDir != null && !versionDir.isEmpty()) {
            if (!z16) {
                return versionDir + File.separator + getPluginName() + ".zip";
            }
            return versionDir + File.separator + getPluginName() + FileSuffix.PATCH_FILE;
        }
        return "";
    }

    public abstract String getEnvClassPath();

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public List<String> getKeyFilesPath(int i3) {
        String aPKPath = getAPKPath(i3);
        if (aPKPath != null && !aPKPath.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(aPKPath);
            return arrayList;
        }
        return null;
    }

    public abstract int getMinSupportRuntimeVersion(int i3);

    public abstract String getReaderClassPath();

    public XFileSdk.ViewStatus getViewStatus(HashMap<String, Object> hashMap) {
        Class cls = this.f385173e;
        if (cls == null) {
            x0.c(getPluginName(), "getViewStatus error, loadedReaderClass is null");
            return null;
        }
        try {
            Method method = cls.getMethod(GET_VIEW_STATUS_METHOD_NAME, HashMap.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, hashMap);
            if (invoke instanceof HashMap) {
                HashMap hashMap2 = (HashMap) invoke;
                Object obj = hashMap2.get(PARAM_KEY_GET_INDEX);
                Object obj2 = hashMap2.get(PARAM_KEY_GET_ZOOM);
                Object obj3 = hashMap2.get(PARAM_KEY_GET_X);
                Object obj4 = hashMap2.get(PARAM_KEY_GET_Y);
                if ((obj instanceof Integer) && (obj2 instanceof Float) && (obj3 instanceof Integer) && (obj4 instanceof Integer)) {
                    return new XFileSdk.ViewStatus(((Integer) obj).intValue(), ((Float) obj2).floatValue(), ((Integer) obj3).intValue(), ((Integer) obj4).intValue());
                }
                x0.c(getPluginName(), "getViewStatus error, value invalid");
            }
            return null;
        } catch (Throwable th5) {
            x0.c(getPluginName(), "getViewStatus error: " + th5);
            return null;
        }
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public boolean isIgnoreForbidDownloadCode() {
        return false;
    }

    public boolean isSupport(String str, boolean z16) {
        if (getAvailableVersion() < 0) {
            x0.d(getPluginName(), "isSupport, not installed");
            return false;
        }
        String d16 = d();
        if (d16.isEmpty() && z16) {
            try {
                d16 = a((ClassLoader) null);
                a(d16);
            } catch (Throwable th5) {
                x0.c(getPluginName(), "isSupport error: " + th5);
                return false;
            }
        }
        return d16.toLowerCase().contains(str.toLowerCase());
    }

    @Override // com.tencent.xweb.xwalk.plugin.XWalkPlugin
    public int performInstall(j0 j0Var) {
        x0.d(getPluginName(), "performInstall version " + j0Var.f121684l);
        boolean b16 = b(j0Var);
        if (!b16) {
            x0.c(getPluginName(), "performInstall unZipAndCheck failed");
            n0.b(getPluginName(), j0Var.f121678f);
            return -2;
        }
        if (j0Var.f121678f) {
            try {
                b16 = a(j0Var);
            } catch (Throwable th5) {
                x0.a(getPluginName(), "performInstall doPatch error", th5);
            }
            if (!b16) {
                x0.c(getPluginName(), "performInstall doPatch failed, delete all");
                n0.c(getPluginName());
                String versionDir = getVersionDir(j0Var.f121684l);
                if (!versionDir.isEmpty()) {
                    w.a(versionDir);
                    return -3;
                }
                return -3;
            }
        }
        String aPKPath = getAPKPath(j0Var.f121684l);
        String extractDir = getExtractDir(j0Var.f121684l);
        String dexDir = getDexDir(j0Var.f121684l);
        File file = new File(dexDir);
        if (!file.exists()) {
            file.mkdirs();
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                }
            }
        }
        try {
            String a16 = a(XWebClassLoaderWrapper.getClassLoader(aPKPath, dexDir, extractDir));
            a(a16);
            String[] split = a16.split(",");
            WebDebugCfg.getInst().setForceUseOfficeReader(split, FileReaderHelper.UseOfficeReader.none);
            FileReaderCrashDetector.resetCrashInfo(split);
            clearPatchDownloadInfo();
            String privateCacheDir = getPrivateCacheDir(j0Var.f121684l);
            if (privateCacheDir != null && !privateCacheDir.isEmpty()) {
                w.a(privateCacheDir);
            }
            setAvailableVersion(j0Var.f121684l, true);
            x0.d(getPluginName(), "performInstall version " + getAvailableVersion() + " success");
            return 0;
        } catch (Throwable th6) {
            n0.f(getPluginName(), j0Var.f121678f);
            x0.c(getPluginName(), "performInstall error: " + th6);
            return -4;
        }
    }

    public boolean readFile(HashMap<String, String> hashMap, Activity activity, ViewGroup viewGroup, ValueCallback<Pair<String, Object>> valueCallback, final ValueCallback<Integer> valueCallback2) {
        if (hashMap != null && activity != null && viewGroup != null) {
            final String str = hashMap.get(PARAM_KEY_FILE_EXT);
            if (str != null && !str.isEmpty()) {
                int availableVersion = getAvailableVersion();
                if (availableVersion <= 0) {
                    x0.c(getPluginName(), "readFile plugin not installed");
                    a(valueCallback2, -2);
                    return false;
                }
                int minSupportRuntimeVersion = getMinSupportRuntimeVersion(valueCallback != null ? 1 : 0);
                if (availableVersion < minSupportRuntimeVersion) {
                    x0.c(getPluginName(), "readFile plugin version is too old, require: " + minSupportRuntimeVersion);
                    a(valueCallback2, -11);
                    return false;
                }
                x0.d(getPluginName(), "readFile by xweb, plugin version " + availableVersion);
                if (XWalkPluginManager.XWALK_PLUGIN_NAME_PPT.equalsIgnoreCase(getPluginName())) {
                    reportUsingVersion(availableVersion, DataTableNameType.TABLE_DATA_COLLECTION, 100, 150);
                } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_PDF.equalsIgnoreCase(getPluginName())) {
                    reportUsingVersion(availableVersion, 1071, 100, 150);
                } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_WORD.equalsIgnoreCase(getPluginName())) {
                    reportUsingVersion(availableVersion, 1069, 100, 150);
                } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_EXCEL.equalsIgnoreCase(getPluginName())) {
                    reportUsingVersion(availableVersion, 1070, 100, 150);
                } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_OFFICE.equalsIgnoreCase(getPluginName())) {
                    reportUsingVersion(availableVersion, 1544, 100, 150);
                } else if (XWalkPluginManager.XWALK_PLUGIN_NAME_TXT.equalsIgnoreCase(getPluginName())) {
                    reportUsingVersion(availableVersion, 1889, 100, 150);
                } else {
                    x0.c(getPluginName(), "unknown report id");
                }
                try {
                    boolean e16 = e();
                    if (e16) {
                        x0.d(getPluginName(), "readFile, env changed");
                    }
                    hashMap.put(PARAM_KEY_ENV_CHANGED, String.valueOf(e16));
                    hashMap.put(PARAM_KEY_CACHE_DIR, getPrivateCacheDir(availableVersion));
                    hashMap.put(PARAM_KEY_RES_DIR, getExtractDir(availableVersion));
                    hashMap.put("plugin_version", String.valueOf(availableVersion));
                    b();
                    if (valueCallback != null) {
                        Method method = this.f385173e.getMethod(READ_METHOD_NAME, Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class, ValueCallback.class);
                        method.setAccessible(true);
                        FileReaderCrashDetector.onStart(str);
                        method.invoke(null, activity, viewGroup, this.f385173e.getClassLoader(), hashMap, valueCallback, this.f385176h, this.f385177i, new ValueCallback<Integer>() { // from class: com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin.3
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(Integer num) {
                                x0.d(XWalkReaderBasePlugin.this.getPluginName(), "readFile onReceiveValue: " + num);
                                FileReaderCrashDetector.onFinish(str);
                                XWalkReaderBasePlugin.this.f();
                                XWalkReaderBasePlugin.this.a(valueCallback2, num.intValue());
                            }
                        });
                    } else {
                        Method method2 = this.f385173e.getMethod(READ_METHOD_NAME, Activity.class, ViewGroup.class, ClassLoader.class, HashMap.class, ValueCallback.class, ValueCallback.class, ValueCallback.class);
                        method2.setAccessible(true);
                        FileReaderCrashDetector.onStart(str);
                        method2.invoke(null, activity, viewGroup, this.f385173e.getClassLoader(), hashMap, this.f385176h, this.f385177i, new ValueCallback<Integer>() { // from class: com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin.4
                            @Override // android.webkit.ValueCallback
                            public void onReceiveValue(Integer num) {
                                x0.d(XWalkReaderBasePlugin.this.getPluginName(), "readFile onReceiveValue: " + num);
                                FileReaderCrashDetector.onFinish(str);
                                XWalkReaderBasePlugin.this.f();
                                XWalkReaderBasePlugin.this.a(valueCallback2, num.intValue());
                            }
                        });
                    }
                    return true;
                } catch (Throwable th5) {
                    x0.c(getPluginName(), "readFile error: " + th5);
                    FileReaderHelper.reportException(getPluginName() + "_" + str, availableVersion, "invoke error ", th5);
                    a(valueCallback2, -3);
                    return false;
                }
            }
            x0.c(getPluginName(), "readFile fileExt is null");
            a(valueCallback2, -5);
            return false;
        }
        x0.c(getPluginName(), "readFile params is null");
        a(valueCallback2, -5);
        return false;
    }

    public boolean requestThumbnail(HashMap<String, Object> hashMap) {
        Class cls = this.f385173e;
        if (cls == null) {
            x0.c(getPluginName(), "requestThumbnail error, loadedReaderClass is null");
            return false;
        }
        try {
            Method method = cls.getMethod(REQUEST_THUMBNAIL_METHOD_NAME, HashMap.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, hashMap);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Throwable th5) {
            x0.c(getPluginName(), "requestThumbnail error: " + th5);
            return false;
        }
    }

    public boolean setViewToStatus(HashMap<String, Object> hashMap) {
        Class cls = this.f385173e;
        if (cls == null) {
            x0.c(getPluginName(), "setViewToStatus error, loadedReaderClass is null");
            return false;
        }
        try {
            Method method = cls.getMethod(SET_VIEW_TO_STATUS_METHOD_NAME, HashMap.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, hashMap);
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Throwable th5) {
            x0.c(getPluginName(), "setViewToStatus error: " + th5);
            return false;
        }
    }

    public void a(ValueCallback valueCallback, int i3) {
        int availableVersion = getAvailableVersion();
        if (availableVersion > 0 && (i3 == -3 || i3 == -13)) {
            synchronized (this) {
                this.f385173e = null;
                this.f385174f = null;
                this.f385175g = -1;
            }
            x0.c(getPluginName(), "invoke error or abi not match, abandon current version " + availableVersion);
            String versionDir = getVersionDir(availableVersion);
            setAvailableVersion(-1, true);
            if (versionDir != null && !versionDir.isEmpty()) {
                w.a(versionDir);
            }
        }
        if (valueCallback != null) {
            valueCallback.onReceiveValue(Integer.valueOf(i3));
        }
    }

    public final String a(ClassLoader classLoader) {
        Class<?> cls;
        try {
            if (classLoader != null) {
                cls = classLoader.loadClass(getEnvClassPath());
            } else {
                b();
                cls = this.f385174f;
            }
            Method method = cls.getMethod(GET_SUPPORT_METHOD_NAME, new Class[0]);
            method.setAccessible(true);
            String str = (String) method.invoke(null, new Object[0]);
            return str == null ? "" : str;
        } catch (Throwable th5) {
            x0.c(getPluginName(), "loadSupportFormatsFromPlugin error: " + th5);
            return "";
        }
    }

    public final boolean a(String str) {
        if (XWalkEnvironment.getApplicationContext() == null) {
            x0.c(getPluginName(), "saveSupportFormats, context is null");
            return false;
        }
        SharedPreferences e16 = y0.e(getPluginName());
        if (e16 == null) {
            x0.c(getPluginName(), "saveSupportFormats, sp is null");
            return false;
        }
        SharedPreferences.Editor edit = e16.edit();
        edit.putString("supportFormats", str);
        boolean commit = edit.commit();
        x0.d(getPluginName(), "loadSupportFormat, ret = " + commit + ", formats: " + str);
        return commit;
    }
}
