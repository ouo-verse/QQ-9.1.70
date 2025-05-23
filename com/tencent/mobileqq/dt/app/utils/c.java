package com.tencent.mobileqq.dt.app.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static synchronized String a(String str) {
        FileChannel fileChannel;
        File file;
        synchronized (c.class) {
            if (str.isEmpty()) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            FileInputStream fileInputStream = null;
            FileChannel fileChannel2 = null;
            try {
                try {
                    file = new File(str);
                } catch (Throwable unused) {
                    fileChannel = null;
                }
            } catch (Throwable unused2) {
            }
            if (file.exists() && file.isFile() && file.canRead() && file.length() > 0 && RFixConstants.APK_PATH.equals(d(file))) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileChannel2 = fileInputStream2.getChannel();
                    ByteBuffer allocate = ByteBuffer.allocate(8192);
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    while (true) {
                        int read = fileChannel2.read(allocate);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(allocate.array(), 0, read);
                        allocate.clear();
                    }
                    for (byte b16 : messageDigest.digest()) {
                        sb5.append(String.format("%02x", Byte.valueOf(b16)));
                    }
                    fileInputStream2.close();
                    fileChannel2.close();
                } catch (Throwable unused3) {
                    FileChannel fileChannel3 = fileChannel2;
                    fileInputStream = fileInputStream2;
                    fileChannel = fileChannel3;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    return sb5.toString();
                }
                return sb5.toString();
            }
            return "";
        }
    }

    public static String b(Certificate certificate) {
        if (certificate == null) {
            return "";
        }
        try {
            byte[] encoded = certificate.getEncoded();
            StringBuilder sb5 = new StringBuilder(encoded.length * 2);
            for (byte b16 : encoded) {
                sb5.append(String.format("%02x", Byte.valueOf(b16)));
            }
            return sb5.toString();
        } catch (CertificateEncodingException unused) {
            return "";
        }
    }

    public static Certificate c(String str) {
        if (str.isEmpty()) {
            return null;
        }
        try {
            JarFile jarFile = new JarFile(new File(str));
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (name.startsWith("META-INF/") && (name.endsWith(".RSA") || name.endsWith(".DSA"))) {
                    Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(jarFile.getInputStream(nextElement));
                    jarFile.close();
                    return generateCertificate;
                }
            }
            jarFile.close();
        } catch (IOException | CertificateException unused) {
        }
        return null;
    }

    public static String d(File file) {
        if (file == null) {
            return "";
        }
        try {
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf != -1 && lastIndexOf != name.length() - 1) {
                return name.substring(lastIndexOf + 1);
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String e(String str) {
        Certificate c16;
        if (!str.isEmpty() && (c16 = c(str)) != null) {
            try {
                return b.a(b(c16));
            } catch (Throwable unused) {
            }
        }
        return "";
    }
}
