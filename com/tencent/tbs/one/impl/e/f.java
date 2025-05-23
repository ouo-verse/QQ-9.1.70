package com.tencent.tbs.one.impl.e;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.k;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.e;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class f {
    private static String a(String str, String str2) {
        return str.substring(str2.length(), str.length() - 3);
    }

    private static void b(File file, File file2) throws TBSOneException {
        File[] listFiles;
        try {
            if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                return;
            }
            for (File file3 : listFiles) {
                com.tencent.tbs.one.impl.a.d.b(file3, new File(file2, file3.getName()));
            }
        } catch (IOException e16) {
            throw new TBSOneException(316, "extractFromUnzipDirToTarget failed,unzip Dir=" + file + ";target=" + file2 + ", error: " + e16.getMessage(), e16);
        }
    }

    public static int c(File file) {
        int i3;
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.tencent.tbs.one.impl.e.f.1
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                return file2.isDirectory();
            }
        });
        if (listFiles == null) {
            return -1;
        }
        int i16 = -1;
        for (File file2 : listFiles) {
            if (g(file2)) {
                try {
                    i3 = Integer.parseInt(file2.getName());
                } catch (Exception e16) {
                    com.tencent.tbs.one.impl.a.g.c("Failed to parse component version from path %s", file2.getAbsolutePath(), e16);
                    i3 = -1;
                }
                if (i3 != -1 && i3 > i16) {
                    i16 = i3;
                }
            }
        }
        return i16;
    }

    public static void d(File file) {
        com.tencent.tbs.one.impl.common.d a16;
        com.tencent.tbs.one.impl.common.d dVar;
        com.tencent.tbs.one.impl.common.d dVar2;
        String name = file.getName();
        boolean z16 = true;
        int i3 = 0;
        com.tencent.tbs.one.impl.a.g.a("[%s] Cleaning useless components", name);
        File b16 = com.tencent.tbs.one.impl.common.f.b(file);
        int i16 = 2;
        if (!b16.exists()) {
            com.tencent.tbs.one.impl.a.g.a("[%s] %s no DEPS file exists", name, "Early out for cleanup useless components,");
            return;
        }
        final k a17 = k.a(com.tencent.tbs.one.impl.common.f.e(b16, ".lock"));
        if (a17 == null) {
            com.tencent.tbs.one.impl.a.g.a("[%s] %s the DEPS installation lock is busy", name, "Early out for cleanup useless components,");
            return;
        }
        File c16 = com.tencent.tbs.one.impl.common.f.c(file);
        final k a18 = k.a(com.tencent.tbs.one.impl.common.f.e(c16, ".lock"));
        Runnable runnable = new Runnable() { // from class: com.tencent.tbs.one.impl.e.f.2
            @Override // java.lang.Runnable
            public final void run() {
                k.this.a();
                k kVar = a18;
                if (kVar != null) {
                    kVar.a();
                }
            }
        };
        if (a18 == null) {
            com.tencent.tbs.one.impl.a.g.a("[%s] %s the update lock is busy", name, "Early out for cleanup useless components,");
            runnable.run();
            return;
        }
        try {
            com.tencent.tbs.one.impl.common.d a19 = com.tencent.tbs.one.impl.common.d.a(b16);
            if (c16.exists()) {
                try {
                    a16 = com.tencent.tbs.one.impl.common.d.a(c16);
                } catch (TBSOneException e16) {
                    com.tencent.tbs.one.impl.a.g.c("[%s] Failed to parse latest DEPS %s", name, " to clean useless components", e16);
                    runnable.run();
                    return;
                }
            } else {
                a16 = null;
            }
            File[] listFiles = com.tencent.tbs.one.impl.common.f.d(file).listFiles();
            if (listFiles == null) {
                runnable.run();
                return;
            }
            int length = listFiles.length;
            int i17 = 0;
            while (i17 < length) {
                File file2 = listFiles[i17];
                String name2 = file2.getName();
                int a26 = a(a19, name2);
                int a27 = a(a16, name2);
                if (a26 == -1 && a27 == -1) {
                    com.tencent.tbs.one.impl.a.d.a(file2, z16);
                } else {
                    File[] listFiles2 = file2.listFiles();
                    if (listFiles2 != null) {
                        int length2 = listFiles2.length;
                        int i18 = i3;
                        while (i18 < length2) {
                            File file3 = listFiles2[i18];
                            if (file3.isDirectory()) {
                                String name3 = file3.getName();
                                if (!name3.equals(String.valueOf(a26)) && !name3.equals(String.valueOf(a27))) {
                                    Object[] objArr = new Object[i16];
                                    objArr[0] = name;
                                    objArr[1] = file3.getAbsolutePath();
                                    com.tencent.tbs.one.impl.a.g.a("[%s] Deleting unreferenced component version directory %s", objArr);
                                    com.tencent.tbs.one.impl.a.d.a(file3, true);
                                }
                                dVar = a19;
                                dVar2 = a16;
                            } else {
                                String name4 = file3.getName();
                                if (name4.endsWith(".incomplete")) {
                                    dVar = a19;
                                    dVar2 = a16;
                                    if (!new File(file3.getParent(), name4.substring(0, name4.length() - 11)).exists()) {
                                        com.tencent.tbs.one.impl.a.g.a("[%s] Deleting unused incomplete flag file %s", name, file3.getAbsolutePath());
                                        com.tencent.tbs.one.impl.a.d.a(file3, false);
                                    }
                                } else {
                                    dVar = a19;
                                    dVar2 = a16;
                                    if (name4.endsWith(".failed")) {
                                        if (System.currentTimeMillis() - file3.lastModified() >= 86400000) {
                                            com.tencent.tbs.one.impl.a.g.a("[%s] Deleting expired failed flag file %s", name, file3.getAbsolutePath());
                                            com.tencent.tbs.one.impl.a.d.a(file3, false);
                                        }
                                    } else {
                                        com.tencent.tbs.one.impl.a.g.a("[%s] Deleting unknown file %s", name, file3.getAbsolutePath());
                                        com.tencent.tbs.one.impl.a.d.a(file3, false);
                                    }
                                }
                            }
                            i18++;
                            a16 = dVar2;
                            a19 = dVar;
                            i16 = 2;
                        }
                    }
                }
                i17++;
                a16 = a16;
                a19 = a19;
                z16 = true;
                i3 = 0;
                i16 = 2;
            }
            runnable.run();
        } catch (TBSOneException e17) {
            com.tencent.tbs.one.impl.a.g.c("[%s] Failed to parse current DEPS %s", name, " to clean useless components", e17);
            runnable.run();
        }
    }

    public static void e(File file) {
        File e16 = com.tencent.tbs.one.impl.common.f.e(file, ".incomplete");
        if (!e16.exists()) {
            com.tencent.tbs.one.impl.a.d.b(e16);
        }
    }

    public static void f(File file) {
        File e16 = com.tencent.tbs.one.impl.common.f.e(file, ".incomplete");
        if (e16.exists()) {
            com.tencent.tbs.one.impl.a.d.c(e16);
        }
    }

    public static boolean g(File file) {
        if (!com.tencent.tbs.one.impl.common.f.e(file, ".incomplete").exists()) {
            return true;
        }
        return false;
    }

    public static void a(File file, File file2) throws TBSOneException {
        File[] listFiles;
        String a16;
        File file3;
        int i3;
        int i16;
        int i17;
        int i18 = 2;
        int i19 = 0;
        int i26 = 1;
        com.tencent.tbs.one.impl.a.g.a("Extracting from installation package %s to %s", file.getAbsolutePath(), file2.getAbsolutePath());
        File file4 = new File(file, "jni");
        File file5 = new File(file, RFixConstants.SO_PATH);
        String[] strArr = Build.SUPPORTED_ABIS;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        if (!arrayList.contains("armeabi")) {
            arrayList.add("armeabi");
            strArr = (String[]) arrayList.toArray(new String[0]);
        }
        int length = strArr.length;
        int i27 = 0;
        while (i27 < length) {
            String str = strArr[i27];
            File file6 = new File(file4, str);
            if (file6.exists() && (listFiles = file6.listFiles()) != null && listFiles.length > 0) {
                Object[] objArr = new Object[i26];
                objArr[i19] = str;
                com.tencent.tbs.one.impl.a.g.a("  ABI: %s", objArr);
                int length2 = listFiles.length;
                int i28 = i19;
                while (i28 < length2) {
                    File file7 = listFiles[i28];
                    String name = file7.getName();
                    if (name.startsWith("libtbs=")) {
                        a16 = new String(Base64.decode(a(name, "libtbs="), i18), com.tencent.tbs.one.impl.common.b.f374813b);
                        if (a16.contains(File.separator)) {
                            a16 = a16.substring(a16.indexOf(File.separatorChar) + 1);
                        }
                    } else {
                        a16 = name.startsWith("libtbs") ? a(name, "libtbs") : name;
                    }
                    File file8 = new File(file2, a16);
                    if (file8.exists()) {
                        i3 = 2;
                        i16 = 0;
                        i17 = 1;
                        com.tencent.tbs.one.impl.a.g.a("    %s -> %s, already exist", name, a16);
                        file3 = file4;
                    } else {
                        file3 = file4;
                        i3 = 2;
                        i16 = 0;
                        i17 = 1;
                        com.tencent.tbs.one.impl.a.g.a("    %s -> %s", name, a16);
                        try {
                            com.tencent.tbs.one.impl.a.d.b(file7, file8);
                        } catch (IOException e16) {
                            throw new TBSOneException(316, "Failed to extract component files in " + file2.getAbsolutePath() + ", error: " + e16.getMessage(), e16);
                        }
                    }
                    i28++;
                    i18 = i3;
                    i19 = i16;
                    i26 = i17;
                    file4 = file3;
                }
            }
            File file9 = file4;
            int i29 = i19;
            int i36 = i26;
            int i37 = i18;
            File file10 = new File(file5, str);
            if (file10.exists()) {
                b(file10, file2);
            }
            i27++;
            i18 = i37;
            i19 = i29;
            i26 = i36;
            file4 = file9;
        }
        b(new File(file, "assets/webkit"), file2);
    }

    public static void b(File file) {
        com.tencent.tbs.one.impl.a.g.a("shareFileIfNeeded,directory=%s", file);
        if (file != null) {
            try {
                if (file.exists()) {
                    file.setReadable(true, false);
                    if (file.isDirectory()) {
                        for (File file2 : file.listFiles()) {
                            b(file2);
                        }
                    }
                }
            } catch (Exception e16) {
                com.tencent.tbs.one.impl.a.g.a("shareFileIfNeeded,exception=%s", Log.getStackTraceString(e16));
            }
        }
    }

    public static MessageDigest a() throws TBSOneException {
        try {
            return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException e16) {
            throw new TBSOneException(106, "Failed to find md5 algorithm, error: " + e16.getMessage(), e16);
        }
    }

    public static void a(MessageDigest messageDigest, File file, String str) throws TBSOneException {
        try {
            com.tencent.tbs.one.impl.a.d.a(new DigestInputStream(new FileInputStream(file), messageDigest), com.tencent.tbs.one.impl.a.j.f374581a);
            String a16 = com.tencent.tbs.one.impl.a.e.a(messageDigest.digest());
            if (a16.equals(str)) {
                return;
            }
            throw new TBSOneException(108, "Failed to verify md5 for component file " + file.getAbsolutePath() + ", expected " + str + " but was " + a16);
        } catch (IOException e16) {
            throw new TBSOneException(107, "Failed to compute md5 for component file " + file.getAbsolutePath() + ", error: " + e16.getMessage(), e16);
        }
    }

    public static void a(File file) {
        try {
            if (file == null) {
                com.tencent.tbs.one.impl.a.g.a("setDirectoryExcutableIfNeeded,dir=null,return", new Object[0]);
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                com.tencent.tbs.one.impl.a.g.a("setDirectoryExcutableIfNeeded,subdir=null,return", new Object[0]);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    file2.setExecutable(true, false);
                    a(file2);
                }
            }
        } catch (Exception e16) {
            com.tencent.tbs.one.impl.a.g.a("setDirectoryExcutableIfNeeded,exception=%s", Log.getStackTraceString(e16));
        }
    }

    public static void a(File file, int i3) throws TBSOneException {
        a(file, i3, false);
    }

    public static void a(File file, int i3, boolean z16) throws TBSOneException {
        com.tencent.tbs.one.impl.common.e a16 = com.tencent.tbs.one.impl.common.e.a(new File(file, "MANIFEST"));
        if (z16) {
            String str = a16.f374838g;
            if (str.equals(IPreloadResource.ABI_64) && !"arm64-v8a".equals(com.tencent.tbs.one.impl.a.e.d())) {
                throw new TBSOneException(322, "Failed to verify cpuType,expected " + com.tencent.tbs.one.impl.a.e.d() + " but was " + str);
            }
            if (str.equals("32") && "arm64-v8a".equals(com.tencent.tbs.one.impl.a.e.d())) {
                throw new TBSOneException(322, "Failed to verify cpuType,expected " + com.tencent.tbs.one.impl.a.e.d() + " but was " + str);
            }
        }
        int i16 = a16.f374832a;
        if (i3 == i16) {
            e.a[] aVarArr = a16.f374836e;
            if (aVarArr != null) {
                MessageDigest messageDigest = null;
                for (e.a aVar : aVarArr) {
                    File file2 = new File(file, aVar.f374841a);
                    if (file2.exists()) {
                        String str2 = aVar.f374842b;
                        if (!TextUtils.isEmpty(str2)) {
                            if (messageDigest == null) {
                                messageDigest = a();
                            }
                            a(messageDigest, file2, str2);
                        }
                    } else {
                        throw new TBSOneException(105, "Failed to find component file " + file2.getAbsolutePath());
                    }
                }
                return;
            }
            return;
        }
        throw new TBSOneException(417, "Failed to verify version code, expected " + i3 + " but was " + i16);
    }

    public static void a(InputStream inputStream, String str, long j3, File file, File file2, l.a aVar) throws TBSOneException {
        l lVar;
        com.tencent.tbs.one.impl.a.g.a("Unzipping from download stream to %s, sdcard backup file is %s", file.getAbsolutePath(), file2);
        MessageDigest a16 = !TextUtils.isEmpty(str) ? a() : null;
        if (a16 != null) {
            lVar = new l(new DigestInputStream(inputStream, a16), j3);
        } else {
            lVar = new l(inputStream, j3);
        }
        lVar.f374588b = aVar;
        com.tencent.tbs.one.impl.a.g.a("installationUtils unzipFromDownloadStream try to unzipStream ", new Object[0]);
        try {
            com.tencent.tbs.one.impl.a.d.a(lVar, file, file2);
            com.tencent.tbs.one.impl.a.g.a("installationUtils unzipFromDownloadStream contentLength: " + j3, new Object[0]);
            if (j3 > 0) {
                long j16 = lVar.f374587a;
                if (j16 != j3) {
                    throw new TBSOneException(221, "Failed to verify download stream length, expected " + j3 + " but was " + j16);
                }
            }
            if (a16 != null) {
                String a17 = com.tencent.tbs.one.impl.a.e.a(a16.digest());
                if (a17.equals(str)) {
                    return;
                }
                throw new TBSOneException(108, "Failed to verify download stream md5, expected " + str + " but was " + a17);
            }
        } catch (IOException e16) {
            throw new TBSOneException(315, "Failed to unzip online component to " + file.getAbsolutePath() + ", error: " + e16.getMessage(), e16);
        }
    }

    public static void a(Context context) {
        com.tencent.tbs.one.impl.a.g.a("Cleaning proc directory", new Object[0]);
        File[] listFiles = com.tencent.tbs.one.impl.common.f.b(context).listFiles();
        if (listFiles == null) {
            com.tencent.tbs.one.impl.a.g.a("Empty proc directory", new Object[0]);
            return;
        }
        int myPid = Process.myPid();
        if (listFiles.length == 1 && listFiles[0].getName().equals(String.valueOf(myPid))) {
            com.tencent.tbs.one.impl.a.g.a("No need to clean", new Object[0]);
            return;
        }
        List<ActivityManager.RunningAppProcessInfo> f16 = com.tencent.tbs.one.impl.a.e.f(context);
        if (f16 == null) {
            com.tencent.tbs.one.impl.a.g.a("Cannot get running process infos, disabled is %s", Boolean.valueOf(com.tencent.tbs.one.impl.a.e.e()));
            return;
        }
        for (File file : listFiles) {
            int intValue = Integer.valueOf(file.getName()).intValue();
            if (intValue != myPid) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = f16.iterator();
                boolean z16 = false;
                while (it.hasNext()) {
                    if (it.next().pid == intValue) {
                        z16 = true;
                    }
                }
                if (!z16) {
                    com.tencent.tbs.one.impl.a.d.a(file, false);
                }
            }
        }
    }

    private static int a(com.tencent.tbs.one.impl.common.d dVar, String str) {
        d.a b16;
        if (dVar == null || (b16 = dVar.b(str)) == null) {
            return -1;
        }
        return b16.f374828c;
    }

    public static int a(int i3, int i16, int i17) {
        return (int) (i16 + ((Math.min(Math.max(0, i3), 100) / 100.0f) * (i17 - i16)));
    }

    public static void a(File file, long j3) {
        File e16 = com.tencent.tbs.one.impl.common.f.e(file, ".failed");
        try {
            if (!e16.exists() && !e16.createNewFile()) {
                com.tencent.tbs.one.impl.a.g.c("Failed to touch file %s, cannot create new file", e16.getAbsolutePath());
                return;
            }
            if (e16.setLastModified(j3)) {
                return;
            }
            com.tencent.tbs.one.impl.a.g.c("Failed to touch file %s, cannot set last modified with %d", e16.getAbsolutePath(), Long.valueOf(j3));
        } catch (IOException e17) {
            com.tencent.tbs.one.impl.a.g.c("Failed to touch file %s", e16.getAbsolutePath(), e17);
        }
    }
}
