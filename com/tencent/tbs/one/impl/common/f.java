package com.tencent.tbs.one.impl.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.io.File;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class f {
    public static File a(Context context) {
        return new File(context.getApplicationInfo().nativeLibraryDir);
    }

    public static File b(File file) {
        return new File(file, "DEPS");
    }

    public static File c(File file) {
        return new File(file, "DEPS.latest");
    }

    public static File d(File file) {
        return new File(file, "components");
    }

    public static File e(File file, String str) {
        return new File(file.getParent(), file.getName() + str);
    }

    public static File a(File file) {
        return new File(file, "home");
    }

    public static File b(File file, String str) {
        return new File(d(file), str);
    }

    public static File c(File file, String str) {
        String str2 = "libtbs" + str + "DEPS.so";
        File file2 = new File(file, str2);
        if (!file2.exists()) {
            file2 = new File(file, "libtbsDEPS.so");
            if (!file2.exists()) {
                com.tencent.tbs.one.impl.a.g.b("Failed to find DEPS file %s or %s in native library directory", file2.getAbsolutePath(), str2);
            }
        }
        return file2;
    }

    public static File d(File file, String str) {
        return new File(file, str);
    }

    public static File a(File file, String str) {
        return new File(a(file), str);
    }

    public static File b(Context context) {
        return new File(context.getDir("tbs", 0), "proc");
    }

    public static File a(File file, int i3) {
        return new File(new File(file, "proc"), String.valueOf(i3));
    }

    public static String b(Context context, String str) {
        File[] listFiles = d(a(context.getDir("tbs", 0), str)).listFiles();
        StringBuilder sb5 = new StringBuilder();
        if (listFiles != null) {
            for (File file : listFiles) {
                sb5.append(file.getName());
                sb5.append(":");
                sb5.append(com.tencent.tbs.one.impl.e.f.c(file));
            }
        }
        return sb5.toString();
    }

    public static int a(Context context, String str) {
        return context.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", str), 4).getInt("in_use_deps_version", -1);
    }

    public static File a(File file, String str, String str2) {
        String encodeToString = Base64.encodeToString((str + File.separator + str2).getBytes(b.f374813b), 2);
        StringBuilder sb5 = new StringBuilder("libtbs=");
        sb5.append(encodeToString);
        sb5.append(".so");
        String sb6 = sb5.toString();
        File file2 = new File(file, sb6);
        if (!file2.exists()) {
            String str3 = "libtbs" + str2 + ".so";
            file2 = new File(file, str3);
            if (!file2.exists()) {
                file2 = new File(file, str2);
                if (!file2.exists()) {
                    com.tencent.tbs.one.impl.a.g.b("Failed to find component file %s or %s or %s in native library directory", file2.getAbsolutePath(), str3, sb6);
                }
            }
        }
        return file2;
    }

    public static int a(Context context, String str, String str2) {
        File[] listFiles = d(a(context.getDir("tbs", 0), str)).listFiles();
        if (listFiles == null) {
            return -1;
        }
        for (File file : listFiles) {
            if (TextUtils.equals(str2, file.getName())) {
                return com.tencent.tbs.one.impl.e.f.c(file);
            }
        }
        return -1;
    }
}
