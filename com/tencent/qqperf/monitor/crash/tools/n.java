package com.tencent.qqperf.monitor.crash.tools;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class n {
    static List<File> a(Context context) {
        File file = new File(context.getDir("tombs", 0).getAbsolutePath());
        ArrayList arrayList = new ArrayList();
        if (file.exists() && file.listFiles() != null) {
            for (File file2 : file.listFiles()) {
                if (file2 != null) {
                    long length = file2.length();
                    if (length > 0 && length < PeakConstants.SHORT_VIDEO_DURATION_UPPER_BOUND) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        Iterator<File> it = a(context).iterator();
        while (it.hasNext()) {
            c(it.next());
        }
    }

    static void c(File file) {
        String absolutePath = file.getAbsolutePath();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(absolutePath + "\n");
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb5.append(readLine);
                            sb5.append("\n");
                        } catch (FileNotFoundException e16) {
                            e = e16;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            QLog.i("QQCrashReportManager", 1, "writeTombLog: invoked. " + sb5.toString());
                        } catch (Exception e17) {
                            e = e17;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            QLog.i("QQCrashReportManager", 1, "writeTombLog: invoked. " + sb5.toString());
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (FileNotFoundException e19) {
                    e = e19;
                } catch (Exception e26) {
                    e = e26;
                }
            } catch (IOException e27) {
                e27.printStackTrace();
            }
            QLog.i("QQCrashReportManager", 1, "writeTombLog: invoked. " + sb5.toString());
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
