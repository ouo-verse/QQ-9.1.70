package com.tencent.qqperf.monitor.crash.tools;

import android.os.Process;
import com.tencent.mobileqq.app.ThreadLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class m {
    /* JADX WARN: Removed duplicated region for block: B:52:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(StringBuilder sb5) {
        Throwable th5;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String str;
        String str2 = "/proc/" + Process.myPid() + "/task";
        sb5.append("\r\n");
        sb5.append(",threadinfo=");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                String[] list = new File(str2).list();
                HashMap hashMap = new HashMap();
                int i3 = 0;
                bufferedReader2 = null;
                while (true) {
                    try {
                        if (i3 >= list.length) {
                            break;
                        }
                        File file = new File(str2 + "/" + list[i3] + "/status");
                        if (System.currentTimeMillis() - currentTimeMillis > 500) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQCrashReportManager", 2, "get thread info cost larger than 500,return info:", sb5.toString());
                            }
                        } else {
                            if (file.exists()) {
                                bufferedReader = new BufferedReader(new FileReader(file), 64);
                                while (true) {
                                    try {
                                        try {
                                            String readLine = bufferedReader.readLine();
                                            if (readLine != null) {
                                                if (readLine.startsWith("Name")) {
                                                    str = readLine.split(":")[1].trim();
                                                    break;
                                                }
                                            } else {
                                                str = null;
                                                break;
                                            }
                                        } catch (Throwable th6) {
                                            th5 = th6;
                                            if (bufferedReader == null) {
                                                try {
                                                    bufferedReader.close();
                                                    throw th5;
                                                } catch (IOException e16) {
                                                    QLog.e("QQCrashReportManager", 2, "get thread info exception:", e16);
                                                    throw th5;
                                                }
                                            }
                                            throw th5;
                                        }
                                    } catch (Exception e17) {
                                        e = e17;
                                        QLog.e("QQCrashReportManager", 2, "get thread info exception:", e);
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        return;
                                    }
                                }
                                if (hashMap.containsKey(str)) {
                                    hashMap.put(str, Integer.valueOf(((Integer) hashMap.get(str)).intValue() + 1));
                                } else {
                                    hashMap.put(str, 1);
                                }
                                try {
                                    bufferedReader.close();
                                    bufferedReader2 = null;
                                } catch (IOException e18) {
                                    QLog.e("QQCrashReportManager", 2, "get thread info exception:", e18);
                                    bufferedReader2 = bufferedReader;
                                }
                            }
                            i3++;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        bufferedReader = bufferedReader2;
                    } catch (Throwable th7) {
                        th5 = th7;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader == null) {
                        }
                    }
                }
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb5.append((String) entry.getKey());
                    sb5.append("(");
                    sb5.append(entry.getValue());
                    sb5.append(")");
                    sb5.append("|");
                }
                sb5.append(">threadcount=");
                sb5.append(list.length);
                if (ThreadLog.needRecordJob() && list.length > 200) {
                    sb5.append(ThreadManagerV2.reportCurrentState());
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQCrashReportManager", 2, "get thread info cost =", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ", ", sb5.toString());
                }
            } catch (Exception e26) {
                e = e26;
                bufferedReader = null;
            } catch (Throwable th8) {
                th5 = th8;
                bufferedReader = null;
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
        } catch (IOException e27) {
            QLog.e("QQCrashReportManager", 2, "get thread info exception:", e27);
        }
    }
}
