package com.tencent.tmassistant.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AnalysisUtil {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, List<String> list) {
        Context context = GlobalUtil.getInstance().getContext();
        if (context == null || list == null || list.size() == 0) {
            return "";
        }
        try {
            return b(InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 1).applicationInfo.sourceDir, list);
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003b A[LOOP:1: B:9:0x0039->B:10:0x003b, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(String str, List<String> list) {
        ZipFile zipFile;
        int size = list.size();
        int[] iArr = new int[size];
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(str);
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    if (zipFile.getEntry(list.get(i3)) != null) {
                        iArr[i3] = 1;
                    }
                } catch (IOException unused) {
                    zipFile2 = zipFile;
                    if (zipFile2 != null) {
                        zipFile = zipFile2;
                        zipFile.close();
                    }
                    StringBuilder sb5 = new StringBuilder();
                    while (r2 < size) {
                    }
                    return sb5.toString();
                } catch (Throwable th5) {
                    th = th5;
                    zipFile2 = zipFile;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException unused3) {
        } catch (Throwable th6) {
            th = th6;
        }
        try {
            zipFile.close();
        } catch (IOException unused4) {
        }
        StringBuilder sb52 = new StringBuilder();
        for (int i16 = 0; i16 < size; i16++) {
            sb52.append(iArr[i16]);
            sb52.append(",");
        }
        return sb52.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(File file) {
        if (file == null) {
            return 0L;
        }
        System.currentTimeMillis();
        long lastModified = file.lastModified();
        try {
            lastModified = a(file, lastModified);
        } catch (Throwable unused) {
        }
        System.currentTimeMillis();
        return lastModified;
    }

    private static long a(File file, long j3) {
        if (file == null) {
            return j3;
        }
        String currentDay = GlobalUtil.getCurrentDay();
        if (TextUtils.equals(GlobalUtil.getDay(j3), currentDay)) {
            return j3;
        }
        long lastModified = file.lastModified();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return j3;
            }
            for (File file2 : listFiles) {
                long a16 = a(file2, j3);
                if (a16 > lastModified) {
                    lastModified = a16;
                }
                if (TextUtils.equals(GlobalUtil.getDay(lastModified), currentDay)) {
                    return lastModified;
                }
            }
        }
        return lastModified;
    }
}
