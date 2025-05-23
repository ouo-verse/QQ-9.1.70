package com.tencent.luggage.wxa.yq;

import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y;
import com.tencent.xweb.XWebEmbedSetting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d extends a {
    public d(int i3) {
        super(i3);
    }

    public static File b(File file, String str) {
        if (!file.isFile()) {
            x0.d("LibUpdateConfig", "findWithinApk, not file, skip");
            return null;
        }
        try {
            ZipFile zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String name = nextElement.getName();
                    if (name.endsWith(".so") && name.endsWith(str)) {
                        File file2 = new File(XWalkEnvironment.getApplicationContext().getCacheDir(), "expansions/xweb/" + str);
                        if (file2.exists()) {
                            file2.delete();
                        } else {
                            file2.getParentFile().mkdirs();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        try {
                            InputStream inputStream = zipFile.getInputStream(nextElement);
                            try {
                                w.a(inputStream, fileOutputStream);
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                fileOutputStream.close();
                                zipFile.close();
                                return file2;
                            } finally {
                            }
                        } finally {
                        }
                    }
                }
                zipFile.close();
            } finally {
            }
        } catch (Throwable th5) {
            x0.a("LibUpdateConfig", "findWithinApk, error", th5);
        }
        return null;
    }

    public String a(String str) {
        File file = new File(XWebEmbedSetting.getEmbedInstallLibDir());
        if (file.exists() && file.isDirectory()) {
            x0.d("LibUpdateConfig", "findSoLibDir, find within:" + file.getAbsolutePath());
            File a16 = a(file, str);
            if (a16 != null && a16.exists() && a16.isFile()) {
                x0.d("LibUpdateConfig", "findSoLibDir, in native lib dir, so path:" + a16.getAbsolutePath());
                return a16.getParentFile().getAbsolutePath();
            }
        }
        File file2 = new File(XWalkEnvironment.getApplicationContext().getApplicationInfo().sourceDir);
        if (file2.exists() && file2.isFile()) {
            x0.d("LibUpdateConfig", "findSoLibDir, find in source dir:" + file2);
            File b16 = b(file2, str);
            if (b16 != null && b16.exists() && b16.isFile()) {
                x0.d("LibUpdateConfig", "findSoLibDir, in source dir, so path:" + b16.getAbsolutePath());
                return b16.getParentFile().getAbsolutePath();
            }
        }
        List<File> soLibDirs = XWebEmbedSetting.getSoLibDirs();
        if (soLibDirs != null && !soLibDirs.isEmpty()) {
            for (File file3 : soLibDirs) {
                x0.d("LibUpdateConfig", "findSoLibDir, find within:" + file3.getAbsolutePath());
                File a17 = a(file3, str);
                if (a17 != null && a17.exists() && a17.isFile()) {
                    x0.d("LibUpdateConfig", "findSoLibDir, in so lib dir, so path:" + a17.getAbsolutePath());
                    return a17.getParentFile().getAbsolutePath();
                }
            }
        }
        return null;
    }

    public static File a(File file, String str) {
        File file2 = null;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file3 : listFiles) {
                    file2 = a(file3, str);
                    if (file2 != null) {
                        return file2;
                    }
                }
            }
        } else {
            if (file.getAbsolutePath().contains(".apk!/lib")) {
                return b(new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().indexOf(".apk!/lib")) + ".apk"), str);
            }
            if (file.getName().equals(str)) {
                return file;
            }
        }
        return file2;
    }

    @Override // com.tencent.luggage.wxa.yq.a
    public boolean a(String str, String str2) {
        x0.d("LibUpdateConfig", "copyPackageToLocal, fileName:" + str);
        String a16 = a(str);
        if (a16 == null) {
            n0.a(1749L, 25L, 1L);
            x0.a("LibUpdateConfig", "can not find so file");
            return false;
        }
        String str3 = a16 + File.separator + str;
        x0.d("LibUpdateConfig", "copyPackageToLocal, src file path:" + str3);
        if (str3.contains("expansions")) {
            n0.a(1749L, 26L, 1L);
        } else {
            n0.a(1749L, 27L, 1L);
        }
        File file = new File(str3);
        File file2 = new File(b());
        x0.d("LibUpdateConfig", "copyPackageToLocal, dest file path:" + str3);
        if (file2.exists()) {
            if (y.a(file2.getAbsolutePath(), str2)) {
                x0.a("LibUpdateConfig", "copyPackageToLocal, already have file and md5 matched");
                return true;
            }
            x0.a("LibUpdateConfig", "copyPackageToLocal, already have file but md5 not matched");
            file2.delete();
        }
        if (!file.exists()) {
            n0.a(903L, 129L, 1L);
            x0.a("LibUpdateConfig", "copyPackageToLocal, src file not find, path:" + str3);
            return false;
        }
        if (!y.a(file.getAbsolutePath(), str2)) {
            n0.a(903L, 130L, 1L);
            x0.a("LibUpdateConfig", "copyPackageToLocal, src file MD5 not match");
        }
        if (w.a(file, file2)) {
            return true;
        }
        n0.a(903L, 131L, 1L);
        x0.a("LibUpdateConfig", "copyPackageToLocal, copy file failed");
        return false;
    }
}
