package com.tencent.ams.dsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.utility.DKCoreSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DynamicUtils {
    static IPatchRedirector $redirector_ = null;
    private static final Handler HANDLER;
    private static final String PLATFORM_PAD = "2";
    private static final String PLATFORM_PHONE = "1";
    private static final String TAG = "DynamicUtils";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18982);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            HANDLER = new Handler(Looper.getMainLooper());
        }
    }

    public DynamicUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int compareVersion(String str, String str2) {
        int i3;
        int i16;
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (isEmpty && isEmpty2) {
            return 0;
        }
        if (isEmpty) {
            return 1;
        }
        if (isEmpty2) {
            return -1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int max = Math.max(split.length, split2.length);
        for (int i17 = 0; i17 < max; i17++) {
            if (i17 < split.length) {
                i3 = toInteger(split[i17]);
            } else {
                i3 = 0;
            }
            if (i17 < split2.length) {
                i16 = toInteger(split2[i17]);
            } else {
                i16 = 0;
            }
            if (i3 > i16) {
                return 1;
            }
            if (i3 < i16) {
                return -1;
            }
        }
        return 0;
    }

    public static Map<String, String> genGlobalParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("sdkVersion", DKCoreSetting.SDK_VERSION);
        hashMap.put("platform", "android");
        hashMap.put(DKEngine.GlobalKey.OS_NAME, "android");
        Context applicationContext = DKEngine.getApplicationContext();
        if (applicationContext != null) {
            hashMap.put("appName", DeviceUtils.getAppName(applicationContext));
            hashMap.put("appVersion", DeviceUtils.getAppVersion(applicationContext));
        }
        return hashMap;
    }

    public static Activity getActivityFromContext(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static String getApp() {
        String str;
        Map<String, String> globalParams = DKEngine.getGlobalParams();
        if (globalParams == null) {
            str = "";
        } else {
            str = globalParams.get("chid");
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String getAppName() {
        String str;
        Map<String, String> globalParams = DKEngine.getGlobalParams();
        if (globalParams == null) {
            str = null;
        } else {
            str = globalParams.get("appName");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static String getAppVersion() {
        String str;
        Map<String, String> globalParams = DKEngine.getGlobalParams();
        if (globalParams == null) {
            str = "";
        } else {
            str = globalParams.get("appVersion");
        }
        if (TextUtils.isEmpty(str)) {
            str = DeviceUtils.getAppVersion(DKEngine.getApplicationContext());
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static Map<String, String> getCompleteGlobalParams() {
        Map<String, String> globalParams = DKEngine.getGlobalParams();
        DKEngine.DeviceInfoGetter deviceInfoGetter = DKEngine.getDeviceInfoGetter();
        if (globalParams == null) {
            globalParams = genGlobalParams();
        }
        if (deviceInfoGetter == null) {
            return globalParams;
        }
        if (TextUtils.isEmpty(globalParams.get("taid"))) {
            globalParams.put("taid", deviceInfoGetter.getTaid());
        }
        if (TextUtils.isEmpty(globalParams.get("oaid"))) {
            globalParams.put("oaid", deviceInfoGetter.getOaid());
        }
        if (TextUtils.isEmpty(globalParams.get("qimei36"))) {
            globalParams.put("qimei36", deviceInfoGetter.getQimei36());
        }
        if (TextUtils.isEmpty(globalParams.get("guid"))) {
            globalParams.put("guid", deviceInfoGetter.getGuid());
        }
        return globalParams;
    }

    public static Map<String, String> getExtParams() {
        return DKEngine.getExtParams();
    }

    public static String getPackageName() {
        String str;
        Map<String, String> globalParams = DKEngine.getGlobalParams();
        if (globalParams == null) {
            str = null;
        } else {
            str = globalParams.get(DKEngine.GlobalKey.APP_PACKAGE_NAME);
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        Context applicationContext = DKEngine.getApplicationContext();
        if (applicationContext != null) {
            return applicationContext.getPackageName();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String getPlatform() {
        if (DKEngine.DKPlatform.APAD.equalsIgnoreCase(DKEngine.getGlobalParams().get("platform"))) {
            return "2";
        }
        return "1";
    }

    public static String getUUID() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return System.currentTimeMillis() + "_" + Math.random();
        }
    }

    private static boolean isArray(Object obj) {
        if (obj == null) {
            return false;
        }
        Class<?> cls = obj.getClass();
        if (!cls.isArray() || cls.getComponentType() == null) {
            return false;
        }
        return true;
    }

    public static boolean isEmpty(Collection<?> collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public static boolean isNumStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("\\d+");
    }

    public static JSONObject map2Json(Map<String, Object> map) throws JSONException {
        if (map == null) {
            return null;
        }
        Object map2JsonObject = map2JsonObject(map);
        if (!(map2JsonObject instanceof JSONObject)) {
            return null;
        }
        return (JSONObject) map2JsonObject;
    }

    public static Object map2JsonObject(Object obj) {
        DLog.i(TAG, "map2JsonObject: " + obj);
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            Map map = (Map) obj;
            for (String str : map.keySet()) {
                Object map2JsonObject = map2JsonObject(map.get(str));
                DLog.i(TAG, "key: " + str + ", value: " + map2JsonObject);
                try {
                    jSONObject.put(str, map2JsonObject);
                } catch (Throwable th5) {
                    DLog.e(TAG, "put value error.", th5);
                }
            }
            return jSONObject;
        }
        if (isArray(obj)) {
            JSONArray jSONArray = new JSONArray();
            int length = Array.getLength(obj);
            for (int i3 = 0; i3 < length; i3++) {
                Object map2JsonObject2 = map2JsonObject(Array.get(obj, i3));
                DLog.i(TAG, "index: " + i3 + ", value: " + map2JsonObject2);
                jSONArray.mo162put(map2JsonObject2);
            }
            return jSONArray;
        }
        if (obj instanceof Collection) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                Object map2JsonObject3 = map2JsonObject(it.next());
                DLog.i(TAG, "value: " + map2JsonObject3);
                jSONArray2.mo162put(map2JsonObject3);
            }
            return jSONArray2;
        }
        DLog.i(TAG, "value: " + obj);
        return obj;
    }

    public static void removeCallbacks(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        HANDLER.removeCallbacks(runnable);
    }

    public static void runOnAsyncThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            WorkThreadManager.getInstance().getCachedThreadPool().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThread(Runnable runnable, long j3) {
        if (runnable == null) {
            return;
        }
        if (j3 <= 0 && Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            HANDLER.postDelayed(runnable, j3);
        }
    }

    public static void runOnUiThreadAtFrontOfQueue(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HANDLER.postAtFrontOfQueue(runnable);
        } else {
            runnable.run();
        }
    }

    public static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e16) {
                DLog.e(TAG, "close input stream error.", e16);
            }
        }
    }

    public static void safeDisconnect(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e16) {
                DLog.e(TAG, "disconnect error.", e16);
            }
        }
    }

    public static int toInteger(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable th5) {
            DLog.e(TAG, "to integer error.", th5);
            return 0;
        }
    }

    public static void safeClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e16) {
                DLog.e(TAG, "close output stream error.", e16);
            }
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(runnable, 0L);
    }

    public static void safeClose(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Exception e16) {
                DLog.e(TAG, "close random access file error.", e16);
            }
        }
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                DLog.e(TAG, "close reader error.", e16);
            }
        }
    }

    public static void safeClose(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Throwable th5) {
                DLog.e(TAG, "close cursor error.", th5);
            }
        }
    }
}
