package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.rmonitor.base.config.ConfigFetcher;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class au {

    /* renamed from: c, reason: collision with root package name */
    private static int f98112c;

    /* renamed from: d, reason: collision with root package name */
    private static StringBuilder f98113d = new StringBuilder();

    /* renamed from: a, reason: collision with root package name */
    public static String[] f98110a = {"mumu"};

    /* renamed from: b, reason: collision with root package name */
    public static String[] f98111b = {"/system/lib,vbox,ko", "/sys/bus,virtio", "/sys/class/misc,vbox"};

    private static void a(File file, String[] strArr) {
        String absolutePath = file.getAbsolutePath();
        File[] listFiles = file.listFiles();
        av.a("Check file path: ".concat(String.valueOf(absolutePath)), new Object[0]);
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                String name = file2.getName();
                for (int i3 = 1; i3 < strArr.length; i3++) {
                    String lowerCase = strArr[i3].toLowerCase();
                    if (name.contains(lowerCase)) {
                        f98113d.append("file: " + file2.getAbsolutePath() + ", " + lowerCase + ";");
                        f98112c = f98112c + 5;
                    }
                }
            }
            return;
        }
        av.c("File list is zero or null in dir: ".concat(String.valueOf(absolutePath)), new Object[0]);
    }

    public static void b(final Context context) {
        at.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.au.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    av.a("Start to check emulator.", new Object[0]);
                    long j3 = ai.c().V.getLong(Constants.SP_EMULATOR_MODIFY_TIME, -1L);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (j3 == -1 || currentTimeMillis - 259200000 >= j3) {
                        com.tencent.rmonitor.base.config.data.k d16 = ConfigFetcher.g().d("emulator");
                        if (d16 instanceof x) {
                            au.a(((x) d16).f98580a, ((x) d16).f98581b);
                        }
                        au.a(context);
                        ai.c().V.edit().putLong(Constants.SP_EMULATOR_MODIFY_TIME, currentTimeMillis).apply();
                        ai.c().V.edit().putInt(Constants.SP_EMULATOR_CONFIDENCE, au.f98112c).apply();
                        ba.c(Constants.SP_EMULATOR_REASON, au.f98113d.toString());
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
    }

    public static void a(String str, String str2) {
        av.a("Start to parse emulator feature from config.", new Object[0]);
        if (str != null) {
            av.a("Get emulator model feature from config, feature: ".concat(str), new Object[0]);
            f98110a = str.split("%");
        } else {
            av.c("No emulator model feature in config.", new Object[0]);
        }
        if (str2 != null) {
            av.a("Get emulator files feature from config, feature: ".concat(str2), new Object[0]);
            f98111b = str2.split("%");
        } else {
            av.c("No emulator files feature in config", new Object[0]);
        }
    }

    public static void a(Context context) {
        String lowerCase = ai.a(context).i().toLowerCase();
        for (String str : f98110a) {
            if (lowerCase.contains(str)) {
                f98113d.append("model: " + str + ";");
                f98112c = f98112c + 10;
            }
        }
        if (NativeCrashHandler.getInstance().getProperties(TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI).contains(ResourceAttributes.HostArchValues.X86)) {
            f98113d.append("cpu: x86;");
            f98112c += 10;
        }
        for (String str2 : f98111b) {
            String[] split = str2.split(",");
            String str3 = split[0];
            File file = new File(str3);
            if (file.exists()) {
                a(file, split);
            } else {
                av.c("Failed to get path: ".concat(String.valueOf(str3)), new Object[0]);
            }
        }
    }
}
