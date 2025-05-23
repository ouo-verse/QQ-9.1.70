package org.light.report;

import android.os.Environment;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.LightEngine;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightReportManager {
    private static final String TAG = "LightReportManager";
    private static LightReportInterface mExternalReporter;
    private static LightReportInterface mLightReporter;

    public static boolean GeneratePerfReport(final String str) {
        new JSONObject();
        try {
            final String string = new JSONObject(str).getString("MaterialID");
            Log.d("GeneratePerfReport", str);
            if (string == null || string.isEmpty()) {
                string = "perf";
            }
            new BaseThread(new Runnable() { // from class: org.light.report.LightReportManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!Environment.getExternalStorageState().equals("mounted")) {
                        LightLogUtil.e(LightReportManager.TAG, "\u6ca1\u6709SDCARD");
                    }
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    externalStorageDirectory.toString();
                    LightLogUtil.e(LightReportManager.TAG, "\u5f97\u5230\u7684\u6839\u76ee\u5f55\u8def\u5f84:" + externalStorageDirectory);
                    String str2 = externalStorageDirectory + File.separator + string + ".txt";
                    LightLogUtil.i(LightReportManager.TAG, "GeneratePerfReport path:" + str2);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                        fileOutputStream.write(str.getBytes());
                        fileOutputStream.close();
                        LightLogUtil.i(LightReportManager.TAG, "GeneratePerfReport write compeletly.");
                    } catch (FileNotFoundException unused) {
                        LightLogUtil.i(LightReportManager.TAG, "GeneratePerfReport exception:FileNotFoundException");
                    } catch (IOException unused2) {
                        LightLogUtil.i(LightReportManager.TAG, "GeneratePerfReport exception:IOException");
                    }
                }
            }).start();
            return true;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static void LaunchFromApp(String str, String str2) {
        nativeLaunchFromApp(str, str2);
    }

    public static void SetCommonParamsExternal(HashMap<String, String> hashMap) {
        nativeSetCommonParamsExternal(hashMap);
    }

    public static String getShareKey() {
        return nativeGetShareKey();
    }

    public static boolean lightReport(String str, HashMap<String, String> hashMap) throws IOException {
        if (hashMap != null && hashMap.size() != 0) {
            Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
            while (it != null && it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                LightLogUtil.d(TAG, str + "-" + next.getKey() + "-" + next.getValue());
            }
            LightReportInterface lightReportInterface = mLightReporter;
            if (lightReportInterface != null) {
                lightReportInterface.report(str, hashMap);
                LightReportInterface lightReportInterface2 = mExternalReporter;
                if (lightReportInterface2 != null) {
                    lightReportInterface2.report(str, hashMap);
                    return true;
                }
                return true;
            }
            LightLogUtil.e(TAG, "LightReporter is null!");
        }
        return false;
    }

    private static native String nativeGetShareKey();

    private static native void nativeLaunchFromApp(String str, String str2);

    private static native void nativeReportOutsideData(String str, HashMap<String, String> hashMap);

    private static native void nativeSetCommonParamsExternal(HashMap<String, String> hashMap);

    public static void reportOutsideData(String str, HashMap<String, String> hashMap) {
        nativeReportOutsideData(str, hashMap);
    }

    public static void setExternalReporter(LightReportInterface lightReportInterface) {
        LightLogUtil.e(TAG, "setExternalReporter");
        mExternalReporter = lightReportInterface;
    }

    public static void setReportEntry(String str) {
        LightLogUtil.e(TAG, "setReportEntry:" + str);
        LightEngine.setAppEntry(str);
    }

    public static void setReporter(LightReportInterface lightReportInterface) {
        LightLogUtil.e(TAG, "setReporter");
        mLightReporter = lightReportInterface;
    }

    public static float string2Float(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            LightLogUtil.e(TAG, "string2Float exception:" + str);
            return -1.0f;
        }
    }

    public static int string2Int(String str, float f16, boolean z16) {
        if (z16) {
            return (int) (string2Float(str) * f16);
        }
        try {
            return (int) (Integer.parseInt(str) * f16);
        } catch (NumberFormatException unused) {
            LightLogUtil.e(TAG, "string2Int exception:" + str);
            return -1;
        }
    }

    public static long string2Long(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            LightLogUtil.e(TAG, "string2Long exception:" + str);
            return -1L;
        }
    }
}
