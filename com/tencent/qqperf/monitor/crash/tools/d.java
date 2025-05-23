package com.tencent.qqperf.monitor.crash.tools;

import android.annotation.TargetApi;
import android.system.Os;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {
    @TargetApi(21)
    public static String a() {
        int i3;
        Throwable th5;
        StringBuilder sb5;
        StringBuilder sb6 = new StringBuilder();
        int i16 = 0;
        try {
            File file = new File("/proc/self/fd");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                int length = listFiles.length;
                i3 = 0;
                while (i16 < length) {
                    try {
                        try {
                            sb6.append(Os.readlink(listFiles[i16].getPath()) + "\n");
                            i3++;
                        } catch (Throwable th6) {
                            QLog.e("FdinfoRecordHelper", 1, "readlink failed", th6);
                        }
                        i16++;
                    } catch (Throwable th7) {
                        th5 = th7;
                        try {
                            QLog.e("FdinfoRecordHelper", 1, "get fd info failed !!!", th5);
                            sb5 = new StringBuilder();
                        } catch (Throwable unused) {
                            sb5 = new StringBuilder();
                        }
                        sb5.append("Total FD Count = ");
                        sb5.append(i3);
                        sb6.append(sb5.toString());
                        return sb6.toString();
                    }
                }
                i16 = i3;
            }
            sb5 = new StringBuilder();
            sb5.append("Total FD Count = ");
            sb5.append(i16);
        } catch (Throwable th8) {
            i3 = 0;
            th5 = th8;
        }
        sb6.append(sb5.toString());
        return sb6.toString();
    }
}
