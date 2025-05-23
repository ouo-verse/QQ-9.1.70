package com.tencent.turingcam;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: P */
/* loaded from: classes27.dex */
public class pZo7n {
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
    
        if (r3 == null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        ByteArrayInputStream byteArrayInputStream;
        String str2;
        try {
            PackageManager packageManager = context.getPackageManager();
            byteArrayInputStream = new ByteArrayInputStream(InstalledAppListMonitor.getPackageInfo(packageManager, packageManager.getPackagesForUid(context.getPackageManager().getApplicationInfo(str, 0).uid)[0], 64).signatures[0].toByteArray());
            try {
                str2 = LmseU.a(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream)).getEncoded());
            } catch (Throwable unused) {
                str2 = "";
            }
        } catch (Throwable unused2) {
            byteArrayInputStream = null;
        }
        try {
            byteArrayInputStream.close();
        } catch (Throwable unused3) {
            return str2;
        }
    }

    public static List<String> a(File file) {
        ArrayList arrayList = new ArrayList();
        JarFile jarFile = new JarFile(file);
        try {
            Certificate[] a16 = a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), new byte[8192]);
            if (a16 != null) {
                for (Certificate certificate : a16) {
                    arrayList.add(LmseU.a(certificate.getEncoded()));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th5) {
            jarFile.close();
            throw th5;
        }
        jarFile.close();
        return arrayList;
    }

    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = jarFile.getInputStream(jarEntry);
            do {
                try {
                } catch (IOException unused) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } while (inputStream.read(bArr, 0, bArr.length) != -1);
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
            return certificates;
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
