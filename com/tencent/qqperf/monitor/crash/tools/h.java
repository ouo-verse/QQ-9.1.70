package com.tencent.qqperf.monitor.crash.tools;

import android.app.ActivityManager;
import android.os.Debug;
import androidx.annotation.RequiresApi;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a implements Comparator<Map.Entry<String, Long>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
            return -entry.getValue().compareTo(entry2.getValue());
        }
    }

    private static String a() {
        StringBuilder sb5 = new StringBuilder();
        try {
            ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                sb5.append("\nActivityManager.getMemoryInfo:\n");
                sb5.append("\ntotalMem:" + (memoryInfo.totalMem >> 10) + "kb");
                sb5.append("\nthreshold:" + (memoryInfo.threshold >> 10) + "kb");
                sb5.append("\navailMem:" + (memoryInfo.availMem >> 10) + "kb");
                StringBuilder sb6 = new StringBuilder();
                sb6.append("\nis lowMemory:");
                sb6.append(memoryInfo.lowMemory);
                sb5.append(sb6.toString());
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return sb5.toString();
    }

    public static String b() {
        StringBuilder sb5 = new StringBuilder(10);
        sb5.append(f());
        sb5.append(e(20));
        sb5.append(d());
        sb5.append(a());
        sb5.append(c());
        return sb5.toString();
    }

    @RequiresApi(api = 23)
    private static String c() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int size;
        StringBuilder sb5 = new StringBuilder();
        try {
            ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null && (size = runningAppProcesses.size()) > 0) {
                int[] iArr = new int[size];
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                int i3 = 0;
                int i16 = 0;
                while (it.hasNext()) {
                    iArr[i16] = it.next().pid;
                    i16++;
                }
                Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo(activityManager, iArr);
                sb5.append("\n\nActivityManager.getProcessMemoryInfo:\n");
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    sb5.append("\n ProcessName:" + runningAppProcessInfo.processName + "  Pid:" + runningAppProcessInfo.pid);
                    for (Map.Entry<String, String> entry : processMemoryInfo[i3].getMemoryStats().entrySet()) {
                        sb5.append("   " + entry.getKey());
                        sb5.append(ProgressTracer.SEPARATOR);
                        sb5.append(entry.getValue());
                        sb5.append("kB\n");
                    }
                    i3++;
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return sb5.toString();
    }

    public static String d() {
        StringBuilder sb5 = new StringBuilder(5);
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            Map<String, String> memoryStats = memoryInfo.getMemoryStats();
            sb5.append("\nDebug.getMemoryInfo:\n");
            for (Map.Entry<String, String> entry : memoryStats.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append(entry.getValue());
                sb5.append("kB\n");
            }
        } catch (Throwable unused) {
        }
        return sb5.toString();
    }

    public static String e(int i3) {
        BufferedReader bufferedReader;
        int i16;
        String str;
        StringBuilder sb5 = new StringBuilder(5);
        sb5.append("\n");
        sb5.append("/proc/self/maps info:");
        sb5.append("\n");
        HashMap hashMap = new HashMap();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable unused) {
        }
        try {
            String readLine = bufferedReader.readLine();
            while (true) {
                i16 = 0;
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split(" ");
                String str2 = split[0].split("-")[0];
                String str3 = split[0].split("-")[1];
                int indexOf = readLine.indexOf("[");
                int indexOf2 = readLine.indexOf("/");
                if (indexOf != -1) {
                    str = readLine.substring(indexOf);
                } else if (indexOf2 != -1) {
                    str = readLine.substring(indexOf2);
                } else {
                    str = "null";
                }
                if (!hashMap.containsKey(str)) {
                    hashMap.put(str, Long.valueOf(Long.valueOf(str3, 16).longValue() - Long.valueOf(str2, 16).longValue()));
                } else {
                    hashMap.put(str, Long.valueOf(((Long) hashMap.get(str)).longValue() + (Long.valueOf(str3, 16).longValue() - Long.valueOf(str2, 16).longValue())));
                }
                readLine = bufferedReader.readLine();
            }
            HashMap<String, Long> g16 = g(hashMap);
            if (g16 != null) {
                for (Map.Entry<String, Long> entry : g16.entrySet()) {
                    if (i16 < i3) {
                        sb5.append(entry.getKey());
                        sb5.append(":");
                        sb5.append(entry.getValue());
                        sb5.append("\n");
                        i16++;
                    }
                }
            }
            bufferedReader.close();
        } catch (Throwable th6) {
            th = th6;
            bufferedReader2 = bufferedReader;
            try {
                th.printStackTrace();
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return sb5.toString();
            } catch (Throwable th7) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th7;
            }
        }
    }

    public static String f() {
        BufferedReader bufferedReader;
        StringBuilder sb5 = new StringBuilder(5);
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        try {
            sb5.append("\n /proc/self/status info:\n");
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (readLine.startsWith("VmPeak") || readLine.startsWith("VmSize")) {
                    readLine.replaceAll("\r\n|\r|\n", "");
                    sb5.append(readLine.trim());
                    sb5.append(", ");
                }
            }
            sb5.append("\n");
            bufferedReader.close();
        } catch (Throwable unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return sb5.toString();
        }
        return sb5.toString();
    }

    private static HashMap<String, Long> g(HashMap<String, Long> hashMap) {
        LinkedList<Map.Entry> linkedList = new LinkedList(hashMap.entrySet());
        Collections.sort(linkedList, new a());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : linkedList) {
            linkedHashMap.put((String) entry.getKey(), (Long) entry.getValue());
        }
        return linkedHashMap;
    }
}
