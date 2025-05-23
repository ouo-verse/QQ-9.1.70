package com.tencent.mobileqq.qqmatrix.threadleak;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.AppInterface;
import com.tencent.matrix.hook.pthread.PthreadHook;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqmatrix.util.ThreadReportUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqmatrix.threadleak.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C8417a implements Comparator<JSONObject> {
        C8417a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
            try {
                return Integer.parseInt(jSONObject2.getString("count")) - Integer.parseInt(jSONObject.getString("count"));
            } catch (JSONException e16) {
                QLog.e("QQThreadMonitorUtils", 1, "Dump Processing Sorting Error:" + e16.toString());
                return 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements Comparator<Map.Entry<String, Integer>> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry2.getValue().compareTo(entry.getValue());
        }
    }

    private static void a(File file) {
        try {
            if (file.exists()) {
                if (file.delete()) {
                    QLog.d("QQThreadMonitorUtils", 1, "[deleteDumpResultFile] success.");
                } else {
                    QLog.d("QQThreadMonitorUtils", 1, "[deleteDumpResultFile] failed.");
                }
            }
        } catch (SecurityException e16) {
            QLog.e("QQThreadMonitorUtils", 1, "[dumpProcess]: error:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static JSONObject b() {
        String c16 = c();
        String h16 = h(c16);
        a(new File(c16));
        if (TextUtils.isEmpty(h16)) {
            QLog.e("QQThreadMonitorUtils", 1, "Dump failed.");
            return null;
        }
        return i(h16);
    }

    private static String c() {
        String str = MobileQQ.sMobileQQ.getExternalCacheDir() + ("/" + Thread.currentThread().getId()) + "pthread_hook.log";
        PthreadHook.f151479i.g(str);
        return str;
    }

    @RequiresApi(api = 19)
    private static int d(int i3) {
        String readLine;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/" + i3 + "/status", "r");
            do {
                try {
                    readLine = randomAccessFile.readLine();
                    if (readLine == null) {
                        randomAccessFile.close();
                        return 0;
                    }
                } finally {
                }
            } while (!readLine.contains("Threads:"));
            int parseInt = Integer.parseInt(readLine.replace("Threads:", "").trim());
            randomAccessFile.close();
            return parseInt;
        } catch (FileNotFoundException e16) {
            QLog.e("QQThreadMonitorUtils", 1, "[getProcessThreadNum] error:" + e16.getMessage());
            return 0;
        } catch (IOException e17) {
            QLog.e("QQThreadMonitorUtils", 1, "[getProcessThreadNum] error:" + e17.getMessage());
            return 0;
        }
    }

    public static int e() {
        return d(Process.myPid());
    }

    public static String f() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            return firstSimpleAccount.getUin();
        }
        return "-1";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean g(JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            return false;
        }
        try {
            jSONObject.put("TotalThreadNum", i3);
            jSONObject.put("Timestamps", System.currentTimeMillis());
            jSONObject.put("VersionName", com.tencent.mobileqq.qqmatrix.a.c());
            String str = "DefaultModel";
            if (PrivacyPolicyHelper.isUserAllow()) {
                str = DeviceInfoMonitor.getModel();
            }
            jSONObject.put("Brand", Build.BRAND);
            jSONObject.put("Model", str);
            return true;
        } catch (JSONException e16) {
            QLog.e("QQThreadMonitorUtils", 1, "[parcelResult] error:" + e16.getMessage());
            return false;
        }
    }

    protected static String h(String str) {
        StringBuilder sb5;
        StringBuilder sb6 = new StringBuilder();
        if (!new File(str).exists()) {
            QLog.e("QQThreadMonitorUtils", 1, str + " is not exist!");
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb6.append(readLine);
                        sb6.append("\n");
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        bufferedReader = bufferedReader2;
                        QLog.e("QQThreadMonitorUtils", 1, "[parseThreadFile] error:" + e.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return "";
                            } catch (IOException e17) {
                                e = e17;
                                sb5 = new StringBuilder();
                                sb5.append("[parseThreadFile] close BufferedReader Error:");
                                sb5.append(e.getMessage());
                                QLog.e("QQThreadMonitorUtils", 1, sb5.toString());
                                return "";
                            }
                        }
                        return "";
                    } catch (IOException e18) {
                        e = e18;
                        bufferedReader = bufferedReader2;
                        QLog.e("QQThreadMonitorUtils", 1, "[parseThreadFile] error:" + e.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                                return "";
                            } catch (IOException e19) {
                                e = e19;
                                sb5 = new StringBuilder();
                                sb5.append("[parseThreadFile] close BufferedReader Error:");
                                sb5.append(e.getMessage());
                                QLog.e("QQThreadMonitorUtils", 1, sb5.toString());
                                return "";
                            }
                        }
                        return "";
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e26) {
                                QLog.e("QQThreadMonitorUtils", 1, "[parseThreadFile] close BufferedReader Error:" + e26.getMessage());
                            }
                        }
                        throw th;
                    }
                }
                String sb7 = sb6.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException e27) {
                    QLog.e("QQThreadMonitorUtils", 1, "[parseThreadFile] close BufferedReader Error:" + e27.getMessage());
                }
                return sb7;
            } catch (FileNotFoundException e28) {
                e = e28;
            } catch (IOException e29) {
                e = e29;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Nullable
    private static JSONObject i(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("PthreadHook_not_exited");
            if (jSONArray.length() == 0) {
                return null;
            }
            JSONArray k3 = k(jSONArray);
            if (k3.length() == 0) {
                return null;
            }
            JSONArray q16 = q(jSONObject.getJSONArray("PthreadHook_not_released"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("TopCountThreadInfo", k3);
            jSONObject2.put("LeakThreadInfo", q16);
            return jSONObject2;
        } catch (JSONException e16) {
            QLog.e("QQThreadMonitorUtils", 1, "Dump Processing Error:" + e16.toString());
            return null;
        }
    }

    private static void j(List<JSONObject> list) {
        int intValue;
        HashMap hashMap = new HashMap();
        Iterator<JSONObject> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = it.next().getJSONArray("threads");
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String replaceAll = jSONArray.getJSONObject(i3).optString("name").replaceAll("\\d+", QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                    if (hashMap.containsKey(replaceAll)) {
                        Integer num = (Integer) hashMap.get(replaceAll);
                        if (num == null) {
                            intValue = 1;
                        } else {
                            intValue = num.intValue() + 1;
                        }
                        hashMap.put(replaceAll, Integer.valueOf(intValue));
                    } else {
                        hashMap.put(replaceAll, 1);
                    }
                }
            } catch (JSONException e16) {
                QLog.e("QQThreadMonitorUtils", 1, "[processAllThreadNames] error:" + e16.getMessage());
            }
        }
        List arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new b());
        int e17 = com.tencent.mobileqq.qqmatrix.b.b().e();
        if (arrayList.size() > e17) {
            arrayList = arrayList.subList(0, e17);
        }
        m(arrayList);
    }

    private static JSONArray k(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(jSONArray.getJSONObject(i3));
        }
        j(arrayList);
        Collections.sort(arrayList, new C8417a());
        JSONArray jSONArray2 = new JSONArray();
        int e16 = com.tencent.mobileqq.qqmatrix.b.b().e();
        if (arrayList.size() <= e16) {
            return jSONArray2;
        }
        for (int i16 = 0; i16 < e16; i16++) {
            jSONArray2.mo162put(arrayList.get(i16));
        }
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void l(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (appInterface == null) {
                QLog.e("QQThreadMonitorUtils", 1, "[reportResult] appRuntime is null");
                return;
            } else {
                n(jSONObject, appInterface);
                return;
            }
        }
        QLog.e("QQThreadMonitorUtils", 1, "Report failed, due to empty content.");
    }

    private static void m(List<Map.Entry<String, Integer>> list) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Integer> entry : list) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", entry.getKey());
            hashMap.put("count", entry.getValue().toString());
            arrayList.add(hashMap);
        }
        ThreadReportUtil.e(arrayList, "threadCountTopInfo");
    }

    private static void n(JSONObject jSONObject, AppInterface appInterface) {
        QQThreadBusinessHandler qQThreadBusinessHandler = (QQThreadBusinessHandler) appInterface.getBusinessHandler(QQThreadBusinessHandler.f274133d);
        if (qQThreadBusinessHandler != null) {
            try {
                qQThreadBusinessHandler.F2(jSONObject);
            } catch (Exception e16) {
                QLog.e("QQThreadMonitorUtils", 1, "Report failed: " + e16.getMessage());
            }
        }
    }

    public static boolean o() {
        if (System.currentTimeMillis() - QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong(f() + "thread_leak_last_record_time", 0L) >= com.tencent.mobileqq.qqmatrix.b.b().d()) {
            return true;
        }
        return false;
    }

    public static void p() {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong(f() + "thread_leak_last_record_time", System.currentTimeMillis());
    }

    private static JSONArray q(JSONArray jSONArray) {
        boolean z16;
        if (jSONArray != null && jSONArray.length() != 0) {
            JSONArray g16 = com.tencent.mobileqq.qqmatrix.b.b().g();
            JSONArray jSONArray2 = new JSONArray();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    String optString = jSONObject.optString("native");
                    int optInt = jSONObject.optInt("count", 0);
                    int i16 = 0;
                    while (true) {
                        if (i16 < g16.length()) {
                            String string = g16.getString(i16);
                            if (optString.contains(string)) {
                                QLog.d("QQThreadMonitorUtils", 2, "[LeakThread] Match allowlist: " + string);
                                z16 = true;
                                break;
                            }
                            i16++;
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (!z16 && optInt >= 5) {
                        jSONArray2.mo162put(jSONObject);
                    }
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQThreadMonitorUtils", 2, "[removeAllowListItem] Error:" + e16.toString());
                    }
                }
            }
            return jSONArray2;
        }
        return jSONArray;
    }
}
