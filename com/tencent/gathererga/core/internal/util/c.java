package com.tencent.gathererga.core.internal.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c {
    static IPatchRedirector $redirector_;

    private static String a(byte[] bArr) {
        String str = "";
        if (bArr == null) {
            return "";
        }
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < bArr.length; i17++) {
            if (i3 > 50000) {
                d.b("findVersionFromData strCount > 20000");
                return str;
            }
            if (bArr[i17] == 0) {
                int i18 = i17 - i16;
                if (i18 >= 8 && i18 <= 20) {
                    try {
                        byte[] bArr2 = new byte[i18];
                        System.arraycopy(bArr, i16, bArr2, 0, i18);
                        i16 = i17 + 1;
                        int i19 = i18 - 1;
                        if ((bArr2[0] & 255) == i19) {
                            byte[] bArr3 = new byte[i19];
                            System.arraycopy(bArr2, 1, bArr3, 0, i19);
                            bArr2 = bArr3;
                        }
                        if (com.tencent.gathererga.core.internal.util.dex.c.a(bArr2)) {
                            String str2 = new String(bArr2, "UTF-8");
                            try {
                                d.a(str2 + ", strcount:" + i3);
                                return str2;
                            } catch (Throwable th5) {
                                th = th5;
                                str = str2;
                                d.c("findVersionFromData got Exception:", th);
                            }
                        } else {
                            i3++;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else {
                    i16 = i17 + 1;
                }
            }
        }
        return str;
    }

    public static String b(Context context, com.tencent.gathererga.core.a aVar) {
        boolean b16;
        boolean a16;
        PackageInfo packageInfo;
        String str;
        if (aVar != null) {
            try {
                b16 = aVar.b();
                a16 = aVar.a();
            } catch (Throwable th5) {
                d.c("WebViewFactory failed!", th5);
            }
        } else {
            b16 = true;
            a16 = true;
        }
        d.a("getChromeInfoVersion visitSystem = " + b16 + " visitDexOrODex = " + a16);
        if (!b16) {
            return QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String c16 = c();
        d.a("getPackageInfo, package name: " + c16);
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), c16, gdt_analysis_event.EVENT_GET_SYSTEM_CHROME_VERSION);
            str = packageInfo.versionName;
            d.a("getPackageInfo, ver: " + str);
        } catch (PackageManager.NameNotFoundException e16) {
            d.c("get webview application info failed! ", e16);
        } catch (Throwable th6) {
            d.c("other fail:", th6);
        }
        if (c16.equals("com.google.android.webview")) {
            d.a("getPackageInfo, chrome ver: " + str + "web cost:" + (System.currentTimeMillis() - currentTimeMillis));
            return str;
        }
        if (c16.equals("com.android.webview") && !TextUtils.isEmpty(str) && (str.contains("-arm64") || packageInfo.versionName.indexOf(".") < 0)) {
            String str2 = str.substring(0, 2) + ".0.0.0";
            d.a("getPackageInfo, chrom ver: " + str2);
            return str2;
        }
        if (c16.equals("com.android.webview") && com.tencent.gathererga.core.internal.util.dex.c.b(packageInfo.versionName)) {
            d.a("16TH chrom ver: " + packageInfo.versionName);
            return packageInfo.versionName;
        }
        if (!a16) {
            return QzoneWebMusicJsPlugin.EVENT_UNKOWN;
        }
        if (packageInfo.applicationInfo != null) {
            d.a("sourceDire: " + packageInfo.applicationInfo.sourceDir);
            String str3 = packageInfo.applicationInfo.sourceDir;
            if (!TextUtils.isEmpty(str3)) {
                ByteBuffer f16 = f(str3);
                if (f16 != null) {
                    d.a("readDexFile cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    String c17 = new com.tencent.gathererga.core.internal.util.dex.c(f16).c();
                    d.a("web ver:" + c17 + "DexParser cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    return c17;
                }
                String a17 = a(g(str3));
                d.a("odex web ver:" + a17 + " web cost:" + (System.currentTimeMillis() - currentTimeMillis));
                return a17;
            }
        } else {
            d.a("applicationInfo is null ");
        }
        return QzoneWebMusicJsPlugin.EVENT_UNKOWN;
    }

    private static String c() {
        int b16 = b.b();
        if (b16 <= 20) {
            d.a("sdk  = " + b16);
            return "com.google.android.webview";
        }
        switch (b16) {
            case 21:
            case 22:
            case 23:
                return d();
            default:
                return e();
        }
    }

    private static String d() {
        try {
            d.a("getWebViewPackageName4Lollipop ");
            return (String) j.a("android.webkit.WebViewFactory", "getWebViewPackageName", null, new Object[0]);
        } catch (Throwable th5) {
            d.c("getWebViewPackageName4Lollipop failed!", th5);
            return "com.google.android.webview";
        }
    }

    private static String e() {
        try {
            d.a("getWebViewPackageName4More ");
            return ((Context) j.a("android.webkit.WebViewFactory", "getWebViewContextAndSetProvider", null, new Object[0])).getApplicationInfo().packageName;
        } catch (Throwable th5) {
            d.c("getWebViewPackageName4N failed!", th5);
            return "com.google.android.webview";
        }
    }

    public static ByteBuffer f(String str) {
        InputStream inputStream;
        ByteBuffer byteBuffer;
        InputStream inputStream2;
        d.a("apkpath: " + str);
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                ZipEntry entry = zipFile2.getEntry("classes.dex");
                if (entry == null) {
                    d.a("zip not found classes.dex ");
                } else {
                    d.a("zip entry: " + entry.toString());
                }
                inputStream2 = zipFile2.getInputStream(entry);
            } catch (Throwable th5) {
                th = th5;
                byteBuffer = null;
                zipFile = zipFile2;
                inputStream = null;
            }
            try {
                int available = inputStream2.available();
                if (available > 10485760) {
                    inputStream2.close();
                    zipFile2.close();
                    try {
                        zipFile2.close();
                        inputStream2.close();
                    } catch (Throwable th6) {
                        d.c("readDexFile got Throwable:", th6);
                    }
                    return null;
                }
                ByteBuffer allocate = ByteBuffer.allocate(available);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read != -1) {
                        allocate.put(bArr, 0, read);
                    } else {
                        try {
                            zipFile2.close();
                            inputStream2.close();
                            return allocate;
                        } catch (Throwable th7) {
                            d.c("readDexFile got Throwable:", th7);
                            return allocate;
                        }
                    }
                }
            } catch (Throwable th8) {
                inputStream = inputStream2;
                th = th8;
                byteBuffer = null;
                zipFile = zipFile2;
                try {
                    d.c("readDexFile got Throwable:", th);
                    if (zipFile != null) {
                        try {
                        } catch (Throwable th9) {
                            return byteBuffer;
                        }
                    }
                    return byteBuffer;
                } finally {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Throwable th92) {
                            d.c("readDexFile got Throwable:", th92);
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        } catch (Throwable th10) {
            th = th10;
            inputStream = null;
            byteBuffer = null;
        }
    }

    public static byte[] g(String str) {
        for (File file : new File(new File(str).getParent() + "/oat/arm").listFiles()) {
            if (file.isFile() && file.getName().endsWith(".odex")) {
                String absolutePath = file.getAbsolutePath();
                byte[] h16 = h(absolutePath);
                if (h16 == null) {
                    d.a("read " + absolutePath + " failed!");
                } else {
                    d.a("find odex file:" + absolutePath + ", odexData-len:" + h16.length);
                    byte[] b16 = com.tencent.gathererga.core.internal.util.odex.a.a(h16).getHeader().b();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("rodata-len ");
                    sb5.append(b16.length);
                    d.a(sb5.toString());
                    return b16;
                }
            }
        }
        return null;
    }

    private static byte[] h(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            if (fileInputStream.available() > 10485760) {
                fileInputStream.close();
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(fileInputStream.available());
            byte[] bArr = new byte[4096];
            int i3 = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    allocate.put(bArr, 0, read);
                    i3 += read;
                } else {
                    fileInputStream.close();
                    d.a("read " + str + " ret:" + i3);
                    return allocate.array();
                }
            }
        } catch (Throwable th5) {
            d.c("readDexFile got Exception:", th5);
            return null;
        }
    }
}
