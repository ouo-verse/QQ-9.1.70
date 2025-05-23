package com.tencent.tfd.sdk.wxa;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Lyra {
    public static List<String> a(File file) throws IOException {
        ArrayList arrayList = new ArrayList();
        JarFile jarFile = new JarFile(file);
        try {
            Certificate[] a16 = a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), new byte[8192]);
            if (a16 != null) {
                for (Certificate certificate : a16) {
                    arrayList.add(Cepheus.a(certificate.getEncoded()));
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
