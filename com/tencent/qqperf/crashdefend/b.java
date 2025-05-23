package com.tencent.qqperf.crashdefend;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.qqperf.crashdefend.CrashDefendConfigProcessor;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    private static String a(@NonNull CrashDefendConfigProcessor.a aVar) {
        if (aVar == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        if (aVar.f363062d) {
            sb5.append("SW");
        }
        if (aVar.f363063e) {
            sb5.append("_");
            sb5.append("NC");
        }
        if (aVar.f363064f) {
            sb5.append("_");
            sb5.append(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        }
        if (aVar.f363065h) {
            sb5.append("_");
            sb5.append("CC");
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public static synchronized CrashDefendConfigProcessor.a b(Context context) {
        synchronized (b.class) {
            CrashDefendConfigProcessor.a a16 = CrashDefendConfigProcessor.a.a();
            if (context == null) {
                wy3.b.a("CrashDefendFileSaveUtils", "loadSwitchFromFile failed");
                return a16;
            }
            boolean d16 = a16.d();
            boolean e16 = a16.e();
            boolean b16 = a16.b();
            boolean c16 = a16.c();
            try {
                File b17 = wy3.d.c().b(context, "CD/SW/");
                if (b17 != null && b17.exists()) {
                    File[] listFiles = b17.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        File file = listFiles[0];
                        if (file != null && file.exists()) {
                            String name = file.getName();
                            wy3.c.c("CrashDefendFileSaveUtils", "loadSwitchFromFile fileName is " + name);
                            for (String str : name.split("_")) {
                                if ("SW".equalsIgnoreCase(str)) {
                                    d16 = true;
                                } else if ("NC".equalsIgnoreCase(str)) {
                                    e16 = true;
                                } else if (ExifInterface.GPS_MEASUREMENT_IN_PROGRESS.equalsIgnoreCase(str)) {
                                    b16 = true;
                                } else if ("CC".equalsIgnoreCase(str)) {
                                    c16 = true;
                                }
                            }
                        }
                        CrashDefendConfigProcessor.a aVar = new CrashDefendConfigProcessor.a(d16, e16, b16, c16);
                        wy3.c.a("CrashDefendFileSaveUtils", "loadSwitchFromFile end config is " + aVar.toString());
                        return aVar;
                    }
                    wy3.c.g("CrashDefendFileSaveUtils", "loadSwitchFromFile dir.listFiles is empty");
                    CrashDefendConfigProcessor.a aVar2 = new CrashDefendConfigProcessor.a(d16, e16, b16, c16);
                    wy3.c.a("CrashDefendFileSaveUtils", "loadSwitchFromFile end config is " + aVar2.toString());
                    return aVar2;
                }
                wy3.c.g("CrashDefendFileSaveUtils", "loadSwitchFromFile dir is invalied");
                CrashDefendConfigProcessor.a aVar3 = new CrashDefendConfigProcessor.a(d16, e16, b16, c16);
                wy3.c.a("CrashDefendFileSaveUtils", "loadSwitchFromFile end config is " + aVar3.toString());
                return aVar3;
            } catch (Throwable th5) {
                try {
                    wy3.c.d("CrashDefendFileSaveUtils", "loadSwitchFromFile has Exception!", th5);
                    CrashDefendConfigProcessor.a aVar4 = new CrashDefendConfigProcessor.a(d16, e16, b16, c16);
                    wy3.c.a("CrashDefendFileSaveUtils", "loadSwitchFromFile end config is " + aVar4.toString());
                    return aVar4;
                } catch (Throwable unused) {
                    CrashDefendConfigProcessor.a aVar5 = new CrashDefendConfigProcessor.a(d16, e16, b16, c16);
                    wy3.c.a("CrashDefendFileSaveUtils", "loadSwitchFromFile end config is " + aVar5.toString());
                    return aVar5;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized void c(@NonNull Context context, @NonNull CrashDefendConfigProcessor.a aVar) {
        String str;
        String str2;
        synchronized (b.class) {
            if (context != null && aVar != null) {
                File b16 = wy3.d.c().b(context, "CD/SW/");
                if (b16 != null && b16.exists()) {
                    String a16 = a(aVar);
                    boolean z16 = false;
                    try {
                        File[] listFiles = b16.listFiles();
                        if (listFiles != null) {
                            for (File file : listFiles) {
                                if (!a16.equalsIgnoreCase(file.getName())) {
                                    file.delete();
                                }
                            }
                        }
                        File file2 = new File(b16.getAbsolutePath(), a16);
                        if (aVar.f363062d) {
                            if (!file2.exists()) {
                                z16 = file2.createNewFile();
                            }
                        } else if (file2.exists()) {
                            z16 = file2.delete();
                        }
                        str = "CrashDefendFileSaveUtils";
                        str2 = "saveSwitchToFile end result is " + z16;
                    } catch (Throwable th5) {
                        try {
                            wy3.c.d("CrashDefendFileSaveUtils", "saveSwitchToFile failed! name:" + a16, th5);
                            str = "CrashDefendFileSaveUtils";
                            str2 = "saveSwitchToFile end result is false";
                        } catch (Throwable th6) {
                            wy3.b.a("CrashDefendFileSaveUtils", "saveSwitchToFile end result is false");
                            throw th6;
                        }
                    }
                    wy3.b.a(str, str2);
                    return;
                }
                wy3.c.g("CrashDefendFileSaveUtils", "saveSwitchToFile dir is invalied");
                return;
            }
            wy3.b.a("CrashDefendFileSaveUtils", "saveSwitchToFile failed");
        }
    }
}
