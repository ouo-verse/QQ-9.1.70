package com.tencent.minibox.loader.core;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.minibox.common.log.LogUtils;
import cooperation.qzone.patch.QZonePatchService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes9.dex */
public class g {
    private static boolean a(File file) {
        byte[] bArr = new byte[1024];
        boolean z16 = false;
        ZipFile zipFile = null;
        q51.a aVar = null;
        try {
            try {
                q51.a aVar2 = new q51.a(file);
                try {
                    Enumeration<? extends ZipEntry> entries = aVar2.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        String name = nextElement.getName();
                        if (name != null && !name.contains("../") && name.endsWith(QZonePatchService.PATCH_SUFFIX_DEX) && !name.equals("classes.dex")) {
                            String substring = name.substring(0, name.indexOf(QZonePatchService.PATCH_SUFFIX_DEX));
                            File file2 = new File(file.getParent(), substring + ".apk");
                            if (file2.exists()) {
                                file2.delete();
                            }
                            file2.createNewFile();
                            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                            zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                            InputStream inputStream = aVar2.getInputStream(nextElement);
                            while (true) {
                                try {
                                    int read = inputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                } finally {
                                }
                            }
                            zipOutputStream.flush();
                            zipOutputStream.finish();
                            p51.a.b(zipOutputStream);
                            p51.a.b(inputStream);
                        }
                    }
                    p51.a.c(aVar2);
                    z16 = true;
                    zipFile = entries;
                } catch (IOException e16) {
                    e = e16;
                    aVar = aVar2;
                    LogUtils.e("PluginUtils", "extract dex failed --->", e);
                    p51.a.c(aVar);
                    zipFile = aVar;
                    return z16;
                } catch (Throwable th5) {
                    th = th5;
                    zipFile = aVar2;
                    p51.a.c(zipFile);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
            return z16;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static boolean b(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            InputStream inputStream = zipFile.getInputStream(zipEntry);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            long crc = zipEntry.getCrc();
            long d16 = p51.a.d(file);
            if (crc != d16) {
                LogUtils.e("PluginUtils", "extractFile failed, crc not same, srcCrc=" + crc + "| dstCrs=" + d16);
                file.delete();
                return false;
            }
            return true;
        } catch (Throwable th5) {
            try {
                fileOutputStream.close();
            } catch (Throwable th6) {
                th5.addSuppressed(th6);
            }
            throw th5;
        }
    }

    private static boolean c(String str, String str2, String str3) throws IOException {
        q51.a aVar = new q51.a(str);
        try {
            Enumeration<? extends ZipEntry> entries = aVar.entries();
            boolean z16 = false;
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                String str4 = File.separator;
                if (!name.endsWith(str4) && !name.contains("..")) {
                    String[] split = name.split(str4);
                    if (split.length >= 2) {
                        String str5 = split[split.length - 1];
                        String str6 = split[split.length - 2];
                        if (str5.endsWith(".so") && TextUtils.equals(str6, str3)) {
                            if (!b(aVar, nextElement, new File(str2 + str4 + str5))) {
                                aVar.close();
                                return false;
                            }
                            z16 = true;
                        }
                    }
                }
            }
            aVar.close();
            return z16;
        } catch (Throwable th5) {
            try {
                aVar.close();
            } catch (Throwable th6) {
                th5.addSuppressed(th6);
            }
            throw th5;
        }
    }

    private static boolean d(d dVar, String str) {
        boolean z16;
        boolean z17;
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(absolutePath + ".tmp");
        try {
            z16 = m51.a.b(dVar.a(), file2);
        } catch (IOException e16) {
            LogUtils.e("PluginUtils", "dexFile.getStream() exception.", e16);
            z16 = false;
        }
        if (!z16) {
            LogUtils.e("PluginUtils", "extractPlugin: copy plugin file failed.");
            return false;
        }
        if (file.exists()) {
            z17 = file.delete();
        } else {
            z17 = true;
        }
        if (!file2.renameTo(file)) {
            LogUtils.e("PluginUtils", "install plugin failed, oldDelRet=" + z17 + ", renameRet=false");
            return false;
        }
        boolean a16 = a(file);
        LogUtils.d("PluginUtils", "install plugin finished, finalRet= " + a16);
        return a16;
    }

    public static boolean e(@NonNull d dVar, @NonNull PluginPathConfig pluginPathConfig) throws IOException {
        String str;
        f(pluginPathConfig.getInstallPath());
        if (!d(dVar, pluginPathConfig.getApkFilePath())) {
            LogUtils.e("PluginUtils", "installPlugin: extractPlugin failed");
            return false;
        }
        if (p51.c.f425348c.b()) {
            str = "arm64-v8a";
        } else {
            str = "armeabi-v7a";
        }
        if (!c(pluginPathConfig.getApkFilePath(), pluginPathConfig.getLibPath(), str)) {
            LogUtils.e("PluginUtils", "installPlugin: extractLibs failed");
            return false;
        }
        return true;
    }

    private static void f(String str) {
        m51.a.d(str);
        new File(str).mkdirs();
    }
}
