package com.tencent.smtt.sdk.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Properties;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f369485a = 100;

    /* renamed from: b, reason: collision with root package name */
    private static Properties f369486b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f369487c;

    /* renamed from: d, reason: collision with root package name */
    private Context f369488d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.smtt.sdk.plugin.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC9797a {
        boolean a(InputStream inputStream, ZipEntry zipEntry, String str) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context) {
        this.f369488d = context;
        this.f369487c = context.getSharedPreferences("tbs_plugin_cfg", 0);
        a(context);
    }

    protected static void b(String str) {
        Log.e("TbsPlugins", str);
    }

    private File c() {
        return a(b(), "plugins");
    }

    private File d(String str) {
        return a(c(), str);
    }

    private void e(String str) {
        try {
            SharedPreferences.Editor edit = this.f369487c.edit();
            edit.remove(str);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(String str) {
        PluginManager.printDebugLog();
    }

    private File b() {
        return a().getDir("tbs", 0);
    }

    private void c(File file) {
        a(file, false);
    }

    private boolean d(File file) {
        File[] listFiles;
        if (file != null) {
            a("hasFileInDir, dir:" + file.getAbsolutePath());
        }
        return file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0;
    }

    private static synchronized void a(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th5;
        FileInputStream fileInputStream;
        synchronized (a.class) {
            if (f369486b != null) {
                return;
            }
            BufferedInputStream bufferedInputStream2 = null;
            try {
                File file = new File(b(context), "1");
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                    } catch (Throwable th6) {
                        bufferedInputStream = null;
                        th5 = th6;
                    }
                    try {
                        Properties properties = new Properties();
                        f369486b = properties;
                        properties.load(bufferedInputStream);
                        bufferedInputStream2 = bufferedInputStream;
                    } catch (Throwable th7) {
                        th5 = th7;
                        try {
                            th5.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable th8) {
                                    th8.printStackTrace();
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th9) {
                                    th = th9;
                                    th.printStackTrace();
                                }
                            }
                        } finally {
                        }
                    }
                } else {
                    fileInputStream = null;
                }
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Throwable th10) {
                        th10.printStackTrace();
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th11) {
                        th = th11;
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th12) {
                bufferedInputStream = null;
                th5 = th12;
                fileInputStream = null;
            }
        }
    }

    private boolean b(String str, final String str2) throws Exception {
        a("unZipFilesTo, zipFile:" + str + ", dstDir:" + str2);
        return a(str, new InterfaceC9797a() { // from class: com.tencent.smtt.sdk.plugin.a.1
            @Override // com.tencent.smtt.sdk.plugin.a.InterfaceC9797a
            public boolean a(InputStream inputStream, ZipEntry zipEntry, String str3) throws Exception {
                return a.this.a(inputStream, zipEntry, str2, str3);
            }
        });
    }

    private void c(String str, String str2) {
        try {
            SharedPreferences.Editor edit = this.f369487c.edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    private boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        c(file);
        return file.mkdirs();
    }

    private String d(String str, String str2) {
        return this.f369487c.getString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public File c(String str) {
        return new File(b(this.f369488d), str);
    }

    private boolean b(File file, String str, String str2, String str3, String str4) {
        a("extraPluginToDestDir zipFile:" + file.getAbsolutePath() + ", zipFileMD5:" + str + ", unzipDir:" + str2 + ",preparedMD5Key:" + str3 + ",preparedPathKey:" + str4);
        File d16 = d(str2);
        String a16 = a(file);
        boolean z16 = false;
        if (TextUtils.isEmpty(a16)) {
            a("extraPluginToDestDir, file md5 is null");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            a("extraPluginToDestDir, zipFileMD5 is null, use new md5");
            str = a16;
        } else if (!a16.equals(str)) {
            a("md5 not match");
            return false;
        }
        try {
            c(d16);
            z16 = b(file.getAbsolutePath(), d16.getAbsolutePath());
        } catch (Exception e16) {
            e16.printStackTrace();
            b("extraPluginToDestDir:" + e16.toString());
        }
        if (!z16) {
            return z16;
        }
        c(str3, str);
        c(str4, str2);
        return true;
    }

    private String b(File file, String str) {
        String str2;
        int i3 = 1;
        do {
            str2 = str + i3;
            if (!new File(file, str2).exists()) {
                return str2;
            }
            i3++;
        } while (i3 <= f369485a);
        a("getValidChildDirPathName, exceed traversal limit, " + f369485a + ", childDirName:" + str2);
        return "";
    }

    protected Context a() {
        return this.f369488d;
    }

    private File a(File file, String str) {
        if (file == null) {
            return null;
        }
        File file2 = new File(file, str);
        if (file2.isDirectory() || (file2.mkdirs() && file2.isDirectory())) {
            return file2;
        }
        return null;
    }

    private static File b(Context context) {
        return new File(QbSdk.getTbsFolderDir(context), "core_share");
    }

    private boolean a(String str, InterfaceC9797a interfaceC9797a) throws Exception {
        ZipFile zipFile;
        a("iterateZipFiles zipFile:" + str);
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(str);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (name != null && !name.contains("../")) {
                    a("iterateZipFiles, filename:" + name);
                    InputStream inputStream = zipFile.getInputStream(nextElement);
                    try {
                        if (!interfaceC9797a.a(inputStream, nextElement, name)) {
                            b("iterateZipFiles, Failure for handle match entry:" + name);
                            zipFile.close();
                            return false;
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } finally {
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    }
                }
            }
            zipFile.close();
            return true;
        } catch (Throwable th6) {
            th = th6;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                zipFile2.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(InputStream inputStream, ZipEntry zipEntry, String str, String str2) throws Exception {
        a("copyFileIfChanged, dstDir:" + str + ", dstName:" + str2);
        b(new File(str));
        String str3 = str + File.separator + str2;
        File file = new File(str3);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, read);
                    }
                    fileOutputStream2.close();
                    if (!file.setLastModified(zipEntry.getTime())) {
                        b("Couldn't set time for dst file " + file);
                    }
                    if (!a(str3, zipEntry.getSize(), zipEntry.getCrc())) {
                        return true;
                    }
                    b("file is different: " + str3);
                    return false;
                } catch (IOException e16) {
                    e = e16;
                    c(file);
                    throw new IOException("Couldn't write dst file " + file, e);
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private boolean a(String str, long j3, long j16) throws Exception {
        File file = new File(str);
        if (file.length() != j3) {
            b("isFileDifferent, file size doesn't match: " + file.length() + " vs " + j3);
            return true;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                CRC32 crc32 = new CRC32();
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                long value = crc32.getValue();
                if (value != j16) {
                    b("isFileDifferent, " + file.getName() + ": crc = " + value + ", zipCrc = " + j16);
                    fileInputStream2.close();
                    return true;
                }
                fileInputStream2.close();
                a("isFileDifferent,filePath:" + str + ",fileSize:" + j3 + ",zipCrc:" + j16);
                return false;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void a(File file, boolean z16) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            a(file2, z16);
        }
        if (z16) {
            return;
        }
        file.delete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0069: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:35:0x0069 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        MessageDigest messageDigest;
        int i3;
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[32];
        FileInputStream fileInputStream3 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                fileInputStream = new FileInputStream(file);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream3 != null) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                byte[] digest = messageDigest.digest();
                int i16 = 0;
                for (i3 = 0; i3 < 16; i3++) {
                    byte b16 = digest[i3];
                    int i17 = i16 + 1;
                    cArr2[i16] = cArr[(b16 >>> 4) & 15];
                    i16 = i17 + 1;
                    cArr2[i17] = cArr[b16 & RegisterType.DOUBLE_HI];
                }
                String str = new String(cArr2);
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                return str;
            } catch (Exception e18) {
                e = e18;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(File file, String str, String str2, String str3, String str4) {
        String b16 = b(c(), str2);
        if (TextUtils.isEmpty(b16)) {
            a("preparePlugin, unzipDirName in null");
            return false;
        }
        if (file != null && file.exists()) {
            boolean b17 = b(file, str, b16, str3, str4);
            if (!b17) {
                a("preparePlugin, prepare fail.");
                c(d(b16));
            }
            return b17;
        }
        a("preparePlugin, zip file is null or not exist error");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str, String str2, String str3, String str4) {
        String d16 = d(str, "");
        String d17 = d(str2, "");
        if (!"".equals(d16) && !"".equals(d17) && d(d(d16))) {
            String d18 = d(str3, "");
            if (!"".equals(d18) && !TextUtils.isEmpty(d18)) {
                c(d(d18));
                a("remove last plugin," + d18);
            }
            c(str3, d16);
            e(str);
            c(str4, d17);
            e(str2);
            return true;
        }
        a("installPlugin, clean preferences");
        e(str);
        e(str2);
        if (TextUtils.isEmpty(d16)) {
            return false;
        }
        c(d(d16));
        a("installPlugin, delete " + d16);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(String str, String str2) {
        String d16 = d(str2, "");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(d16)) {
            return d16.equals(str);
        }
        a("isInstalled, md5 is empty,pluginMd5:" + str + ", installedPluginMd5:" + d16);
        return false;
    }
}
