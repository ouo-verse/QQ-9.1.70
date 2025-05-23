package com.tencent.tbs.one.impl.c.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.oskplayer.cache.FileDataSink;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.tbs.one.impl.a.o;
import com.tencent.tbs.one.optional.TBSOneStandaloneService;
import cooperation.qzone.patch.QZonePatchService;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f374658a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f374659b = "DexUtilsLoadMsg";

    /* renamed from: c, reason: collision with root package name */
    private static boolean f374660c = false;

    public static String a() {
        return f374659b + ";" + c.a();
    }

    private static File b(String str, String str2) {
        return new File(str, str2 + ".opt");
    }

    public static void a(boolean z16) {
        f374660c = z16;
        f374659b += ";enable:" + f374660c;
    }

    private static String a(String str, int i3) {
        String str2;
        BufferedReader bufferedReader;
        int i16 = Build.VERSION.SDK_INT;
        if ((i16 != 31 && i16 != 32) || i3 < 29 || str == null) {
            return str;
        }
        File file = new File(str);
        int lastIndexOf = file.getName().lastIndexOf(46);
        if (lastIndexOf != -1) {
            str2 = file.getParent() + File.separator + file.getName().substring(0, lastIndexOf) + ".dir";
        } else {
            str2 = str + ".dir";
        }
        File file2 = new File(str2);
        if (!file2.exists() && !file2.mkdirs()) {
            str2 = file.getParent();
            f374659b += ";mkdirsFailed";
        }
        File file3 = new File(str2, file.getName().replace(".", ""));
        if (!file3.exists()) {
            InputStreamReader inputStreamReader = null;
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), "ln -s " + str + " " + file3.getAbsolutePath()).getInputStream());
                try {
                    bufferedReader = new BufferedReader(inputStreamReader2);
                    do {
                        try {
                        } catch (Throwable th5) {
                            th = th5;
                            inputStreamReader = inputStreamReader2;
                            try {
                                com.tencent.tbs.one.impl.a.g.c("[TBS]", "create PrivateDex failed : " + th);
                                f374659b += ";PrivateDexFailed";
                                return str;
                            } finally {
                                a(bufferedReader);
                                a(inputStreamReader);
                            }
                        }
                    } while (bufferedReader.readLine() != null);
                    a(bufferedReader);
                    a(inputStreamReader2);
                    if (!file3.exists()) {
                        f374659b += ";PrivateDexNotExist";
                        com.tencent.tbs.one.impl.a.g.b("[TBS]", "PrivateDex not exist, after ln -s " + str);
                        return str;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader = null;
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedReader = null;
            }
        }
        return file3.getAbsolutePath();
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    private static File[] a(String str) {
        String[] split = str.split(":");
        File[] fileArr = new File[split.length];
        for (int i3 = 0; i3 < split.length; i3++) {
            fileArr[i3] = new File(split[i3]);
        }
        return fileArr;
    }

    public static void a(String str, String str2, String str3, String str4, ClassLoader classLoader) {
        try {
            new g(str2, str3, str4, classLoader);
            com.tencent.tbs.one.impl.a.d.b(b(str3, str));
        } catch (Exception e16) {
            com.tencent.tbs.one.impl.a.g.c("Failed to optimize dex %s", str2, e16);
        }
    }

    public static void a(File[] fileArr, boolean z16) {
        for (int i3 = 0; i3 < fileArr.length; i3++) {
            File file = fileArr[i3];
            if (file != null) {
                File file2 = new File(file.getAbsolutePath() + FileDataSink.TEMP_FILE);
                if (z16) {
                    if (fileArr[i3].exists()) {
                        fileArr[i3].renameTo(file2);
                    }
                } else if (file2.exists()) {
                    file2.renameTo(fileArr[i3]);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0211  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ClassLoader a(final Context context, File[] fileArr, final String str, final String str2, ClassLoader classLoader, boolean z16, String[] strArr, boolean z17, boolean z18) {
        char c16;
        char c17;
        ClassLoader fVar;
        boolean z19;
        String str3 = "";
        for (File file : fileArr) {
            if (file != null && file.exists()) {
                String absolutePath = file.getAbsolutePath();
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                int i3 = Build.VERSION.SDK_INT;
                if ((i3 == 31 || i3 == 32) && z18) {
                    f374659b += ";SoftLink";
                    absolutePath = a(absolutePath, applicationInfo.targetSdkVersion);
                }
                if (i3 >= 34 && applicationInfo.targetSdkVersion >= 34) {
                    new File(absolutePath).setReadOnly();
                }
                str3 = str3 != "" ? str3 + ":" + absolutePath : absolutePath;
                com.tencent.tbs.one.impl.a.g.a("Creating class loader from: " + str3, new Object[0]);
            }
        }
        File[] a16 = a(str3);
        if (fileArr[0].getAbsolutePath().contains("fusion")) {
            c.a(context, a16, f374660c);
            c.b(context, a16, f374660c);
        }
        com.tencent.tbs.one.impl.a.g.a("DexUtils createClassLoader isSealedClassLoaderDisabled = " + z16 + ", isAsyncDexOptimizationEnabled = " + z17, new Object[0]);
        com.tencent.tbs.one.impl.a.g.a("Creating class loader from %s, optimizedDirectory: %s, librarySearchPath: %s, parent: %s, unsealedPackages: %s, isAsyncDexOptimizationEnabled: %b", fileArr[0].getAbsolutePath(), str, str2, classLoader, strArr, Boolean.valueOf(z17));
        if (z17) {
            if (f374658a == null) {
                int i16 = Build.VERSION.SDK_INT;
                if (i16 > 25) {
                    com.tencent.tbs.one.impl.a.g.a("API level %d does not support dex optimization", Integer.valueOf(i16));
                    z19 = false;
                    c17 = 0;
                } else {
                    String property = System.getProperty("java.vm.version");
                    if (property == null || !property.startsWith("2")) {
                        c17 = 0;
                        com.tencent.tbs.one.impl.a.g.a("VM version %s does not support dex optimization", property);
                        z19 = false;
                    } else {
                        c17 = 0;
                        com.tencent.tbs.one.impl.a.g.a("API level %d and VM version %s supports dex optimization", Integer.valueOf(i16), property);
                        z19 = true;
                    }
                }
                f374658a = Boolean.valueOf(z19);
            } else {
                c17 = 0;
            }
            if (f374658a.booleanValue()) {
                String name = fileArr[c17].getName();
                boolean exists = b(str, name).exists();
                Object[] objArr = new Object[2];
                objArr[c17] = name;
                objArr[1] = exists ? "has" : "has not";
                com.tencent.tbs.one.impl.a.g.a("The dex %s %s optimized", objArr);
                if ((exists && a(str, name)) ? false : true) {
                    if (z16) {
                        fVar = new PathClassLoader(str3, str2, classLoader);
                    } else {
                        fVar = new f(str3, null, str2, classLoader, strArr);
                    }
                    final File file2 = fileArr[0];
                    o.c(new Runnable() { // from class: com.tencent.tbs.one.impl.c.a.d.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.tencent.tbs.one.impl.a.g.a("Starting standalone service to optimize dex %s", file2.getAbsolutePath());
                            Intent intent = new Intent(context, (Class<?>) TBSOneStandaloneService.class);
                            intent.putExtra(TBSOneStandaloneService.IMPL_CLASS_NAME_KEY, b.class.getName());
                            intent.putExtra("dexPath", file2.getAbsolutePath());
                            intent.putExtra("dexName", file2.getName());
                            intent.putExtra("optimizedDirectory", str);
                            intent.putExtra("librarySearchPath", str2);
                            context.startService(intent);
                        }
                    }, 2000L);
                    return fVar;
                }
            } else {
                c16 = c17;
                Object[] objArr2 = new Object[1];
                objArr2[c16] = str3;
                com.tencent.tbs.one.impl.a.g.a("dexFilePath = %s", objArr2);
                if (!z16) {
                    long currentTimeMillis = System.currentTimeMillis();
                    DexClassLoader dexClassLoader = new DexClassLoader(str3, str, str2, classLoader);
                    f374659b += ";" + fileArr[0].getName() + "LoadDex:" + (System.currentTimeMillis() - currentTimeMillis);
                    if (!fileArr[0].getAbsolutePath().contains("fusion") || !f374660c) {
                        return dexClassLoader;
                    }
                    c.a(context, a16, str3, str, str2, classLoader);
                    return dexClassLoader;
                }
                return new f(str3, str, str2, classLoader, strArr);
            }
        }
        c16 = 0;
        Object[] objArr22 = new Object[1];
        objArr22[c16] = str3;
        com.tencent.tbs.one.impl.a.g.a("dexFilePath = %s", objArr22);
        if (!z16) {
        }
    }

    private static boolean a(String str, String str2) {
        int lastIndexOf;
        String name = new File(str2).getName();
        File file = new File(str, ((TextUtils.isEmpty(name) || (lastIndexOf = name.lastIndexOf(46)) <= 0) ? new String[]{name, null} : new String[]{name.substring(0, lastIndexOf), name.substring(lastIndexOf + 1)})[0] + QZonePatchService.PATCH_SUFFIX_DEX);
        if (!file.exists()) {
            com.tencent.tbs.one.impl.a.g.a("The odex file %s does not exist", file.getAbsolutePath());
            return true;
        }
        if (!e.a(file)) {
            com.tencent.tbs.one.impl.a.g.a("The odex file %s is not a elf file", file.getAbsolutePath());
            return true;
        }
        try {
            new e(file);
            com.tencent.tbs.one.impl.a.g.a("The odex file %s is well-kept", file.getAbsolutePath());
            return true;
        } catch (IOException unused) {
            com.tencent.tbs.one.impl.a.g.a("The odex file %s has broken", file.getAbsolutePath());
            return false;
        }
    }
}
