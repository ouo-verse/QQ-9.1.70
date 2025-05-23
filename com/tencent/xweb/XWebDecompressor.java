package com.tencent.xweb;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.w;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.pts.utils.PTSFileUtil;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebDecompressor {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.endsWith(".dat") && !str.endsWith(".pak") && !str.endsWith(PTSFileUtil.JS_FORMAT)) {
            return false;
        }
        return true;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith("classes.dex");
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(".so");
    }

    public static boolean decompressDownload7z(String str, String str2) {
        x0.d("XWebDecompressor", "decompressDownload7z, zipFile:" + str + ", destDir:" + str2);
        return true;
    }

    public static boolean decompressDownloadByPatchType(String str, String str2, int i3) {
        if (i3 != 1 && i3 != 2) {
            x0.c("XWebDecompressor", "decompressDownloadByPatchType, error, unknown patchType");
            return false;
        }
        return decompressDownloadZip(str, str2);
    }

    public static boolean decompressDownloadZip(String str, String str2) {
        ZipFile zipFile;
        x0.d("XWebDecompressor", "decompressDownloadZip, zipFile:" + str + ", destDir:" + str2);
        long uptimeMillis = SystemClock.uptimeMillis();
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        String encode = URLEncoder.encode(nextElement.getName(), "UTF-8");
                        if (!encode.contains("../") && !encode.contains("..\\") && !nextElement.isDirectory()) {
                            File file = new File(str2, encode);
                            if (!file.exists()) {
                                File parentFile = file.getParentFile();
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                            } else {
                                file.delete();
                            }
                            w.a(zipFile.getInputStream(nextElement), file);
                            x0.d("XWebDecompressor", "decompress " + encode + " to " + file.getAbsolutePath());
                        }
                    }
                    w.a(zipFile);
                    System.gc();
                    x0.d("XWebDecompressor", "decompressDownloadZip, costTime:" + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
                    return true;
                } catch (IOException e16) {
                    e = e16;
                    zipFile2 = zipFile;
                    x0.a("XWebDecompressor", "decompressDownloadZip, error", e);
                    w.a(zipFile2);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    w.a(zipFile);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
            zipFile = null;
        }
    }

    public static boolean extractResource(String str, String str2, String[] strArr) {
        ZipFile zipFile;
        ZipEntry entry;
        x0.d("XWebDecompressor", "extractResource, libFile:" + str + ", destDir:" + str2);
        long uptimeMillis = SystemClock.uptimeMillis();
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    for (String str3 : strArr) {
                        if (c(str3)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(RFixConstants.SO_PATH);
                            String str4 = File.separator;
                            sb5.append(str4);
                            sb5.append("armeabi");
                            sb5.append(str4);
                            sb5.append(str3);
                            entry = zipFile.getEntry(sb5.toString());
                        } else if (a(str3)) {
                            entry = zipFile.getEntry("assets" + File.separator + str3);
                        } else {
                            entry = zipFile.getEntry(str3);
                        }
                        if (entry == null) {
                            if (b(str3)) {
                                x0.d("XWebDecompressor", "extractResource, " + str3 + " not found, maybe it is new version of package");
                            } else {
                                x0.c("XWebDecompressor", "extractResource, " + str3 + " not found");
                                w.a(zipFile);
                                return false;
                            }
                        } else {
                            File file = new File(str2, str3);
                            w.a(zipFile.getInputStream(entry), file);
                            x0.d("XWebDecompressor", "extract " + str3 + " to " + file.getAbsolutePath());
                        }
                    }
                    w.a(zipFile);
                    System.gc();
                    x0.d("XWebDecompressor", "extractResource, costTime:" + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
                    return true;
                } catch (IOException e16) {
                    e = e16;
                    zipFile2 = zipFile;
                    x0.a("XWebDecompressor", "extractResource, error", e);
                    w.a(zipFile2);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    w.a(zipFile);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
            zipFile = null;
        }
    }
}
