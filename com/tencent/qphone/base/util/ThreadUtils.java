package com.tencent.qphone.base.util;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ThreadUtils {
    private static final String TAG = "ThreadUtils";

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0122: MOVE (r8 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY]) (LINE:291), block:B:76:0x0121 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0117 A[Catch: IOException -> 0x011b, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x011b, blocks: (B:40:0x0117, B:56:0x0103), top: B:2:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void dumpThreadInfo(StringBuilder sb5) {
        Throwable th5;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String str;
        String str2 = "/proc/" + Process.myPid() + "/task";
        sb5.append(",threadinfo=");
        long currentTimeMillis = System.currentTimeMillis();
        BufferedReader bufferedReader4 = null;
        try {
            try {
                try {
                    String[] list = new File(str2).list();
                    bufferedReader3 = null;
                    int i3 = 0;
                    while (true) {
                        try {
                            if (i3 >= list.length) {
                                break;
                            }
                            File file = new File(str2 + "/" + list[i3] + "/status");
                            if (System.currentTimeMillis() - currentTimeMillis > 500) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "get thread info cost larger than 500,return info:", sb5.toString());
                                }
                            } else {
                                if (file.exists()) {
                                    bufferedReader2 = new BufferedReader(new FileReader(file), 64);
                                    while (true) {
                                        try {
                                            String readLine = bufferedReader2.readLine();
                                            if (readLine != null) {
                                                if (readLine.startsWith("Name")) {
                                                    str = readLine.split(":")[1].trim();
                                                    break;
                                                }
                                            } else {
                                                str = null;
                                                break;
                                            }
                                        } catch (Exception e16) {
                                            e = e16;
                                            QLog.e(TAG, 2, "get thread info exception:", e);
                                            if (bufferedReader2 == null) {
                                                bufferedReader2.close();
                                            }
                                            return;
                                        }
                                    }
                                    sb5.append(str);
                                    sb5.append("|");
                                    try {
                                        bufferedReader2.close();
                                        bufferedReader3 = null;
                                    } catch (IOException e17) {
                                        QLog.e(TAG, 2, "get thread info exception:", e17);
                                        bufferedReader3 = bufferedReader2;
                                    }
                                }
                                i3++;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            bufferedReader4 = bufferedReader3;
                            bufferedReader2 = bufferedReader4;
                            QLog.e(TAG, 2, "get thread info exception:", e);
                            if (bufferedReader2 == null) {
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            bufferedReader4 = bufferedReader3;
                            th5 = th;
                            if (bufferedReader4 == null) {
                            }
                        }
                    }
                    sb5.append(">threadcount=");
                    sb5.append(list.length);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "get thread info cost =", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), ", ", sb5.toString());
                    }
                } catch (Exception e19) {
                    e = e19;
                } catch (Throwable th7) {
                    th = th7;
                }
                if (bufferedReader3 != null) {
                    bufferedReader3.close();
                }
            } catch (Throwable th8) {
                th5 = th8;
                bufferedReader4 = bufferedReader;
                if (bufferedReader4 == null) {
                    try {
                        bufferedReader4.close();
                        throw th5;
                    } catch (IOException e26) {
                        QLog.e(TAG, 2, "get thread info exception:", e26);
                        throw th5;
                    }
                }
                throw th5;
            }
        } catch (IOException e27) {
            QLog.e(TAG, 2, "get thread info exception:", e27);
        }
    }
}
