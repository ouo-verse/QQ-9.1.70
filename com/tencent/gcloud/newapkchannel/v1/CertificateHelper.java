package com.tencent.gcloud.newapkchannel.v1;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CertificateHelper {
    static IPatchRedirector $redirector_;

    public CertificateHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getApkSignInfo(String str) {
        byte[] bArr;
        boolean z16;
        byte[] bArr2 = new byte[8192];
        try {
            JarFile jarFile = new JarFile(str);
            Enumeration<JarEntry> entries = jarFile.entries();
            Certificate[] certificateArr = null;
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/")) {
                    Certificate[] loadCertificates = loadCertificates(jarFile, nextElement, bArr2);
                    if (certificateArr == null) {
                        certificateArr = loadCertificates;
                        z16 = false;
                    } else {
                        z16 = false;
                        for (Certificate certificate : certificateArr) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= loadCertificates.length) {
                                    break;
                                }
                                if (certificate != null && certificate.equals(loadCertificates[i3])) {
                                    z16 = true;
                                    break;
                                }
                                i3++;
                            }
                            if (certificateArr.length != loadCertificates.length) {
                                jarFile.close();
                                return null;
                            }
                        }
                    }
                    if (z16) {
                        break;
                    }
                }
            }
            jarFile.close();
            if (certificateArr != null && certificateArr.length > 0) {
                bArr = certificateArr[0].getEncoded();
            } else {
                bArr = null;
            }
            return getSignValidString(bArr);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static String getSignValidString(byte[] bArr) throws NoSuchAlgorithmException {
        if (bArr == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        messageDigest.update(bArr);
        return toHexString(messageDigest.digest());
    }

    private static Certificate[] loadCertificates(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        try {
            InputStream inputStream = jarFile.getInputStream(jarEntry);
            do {
            } while (inputStream.read(bArr, 0, bArr.length) != -1);
            inputStream.close();
            if (jarEntry == null) {
                return null;
            }
            return jarEntry.getCertificates();
        } catch (Exception e16) {
            e16.printStackTrace();
            System.err.println("Exception reading " + jarEntry.getName() + " in " + jarFile.getName() + MsgSummary.STR_COLON + e16);
            return null;
        }
    }

    private static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (byte b16 : bArr) {
            String num = Integer.toString(b16 & 255, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb5.append(num);
        }
        return sb5.toString();
    }
}
