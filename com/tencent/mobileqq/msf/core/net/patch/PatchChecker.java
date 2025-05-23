package com.tencent.mobileqq.msf.core.net.patch;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: classes15.dex */
public class PatchChecker {
    static IPatchRedirector $redirector_ = null;
    public static final String PATCH_TYPE_DEX = "dex";

    public PatchChecker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0127  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x011e -> B:42:0x0121). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int checkJarPatchSignature(String str) {
        Certificate[] loadPatchCertificates;
        boolean z16 = false;
        int i3 = 302;
        JarFile jarFile = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                Signature signature = InstalledAppListMonitor.getPackageInfo(BaseApplication.getContext().getPackageManager(), BaseApplication.getContext().getPackageName(), 64).signatures[0];
                JarFile jarFile2 = new JarFile(PatchCommonUtil.getPatchPath(str));
                try {
                    Enumeration<JarEntry> entries = jarFile2.entries();
                    int i16 = 301;
                    while (entries.hasMoreElements()) {
                        JarEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/") && (loadPatchCertificates = loadPatchCertificates(jarFile2, nextElement)) != null && loadPatchCertificates.length == 1) {
                            if (new Signature(loadPatchCertificates[0].getEncoded()).equals(signature)) {
                                i16 = 300;
                            } else {
                                i16 = 301;
                            }
                            QLog.d("PatchLogTag", 1, "PatchChecker checkJarPatchSignature JarEntry=" + nextElement.getName() + ", checkResult=" + i16);
                            if (300 != i16) {
                                break;
                            }
                        }
                    }
                    i3 = i16;
                    try {
                        jarFile2.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                } catch (PackageManager.NameNotFoundException e18) {
                    e = e18;
                    jarFile = jarFile2;
                    QLog.d("PatchLogTag", 1, "PatchChecker checkJarPatchSignature NameNotFoundException=" + e);
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    BaseApplication context = BaseApplication.getContext();
                    if (i3 == 300) {
                    }
                    PatchSharedPreUtil.updatePatchVerifyStatus(context, str, z16);
                    PatchReporter.reportPatchEvent(BaseApplication.getContext(), "", PatchReporter.ACTION_PATCH_CHECK, i3, str);
                    return i3;
                } catch (IOException e19) {
                    e = e19;
                    jarFile = jarFile2;
                    QLog.d("PatchLogTag", 1, "PatchChecker checkJarPatchSignature IOException=" + e);
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    BaseApplication context2 = BaseApplication.getContext();
                    if (i3 == 300) {
                    }
                    PatchSharedPreUtil.updatePatchVerifyStatus(context2, str, z16);
                    PatchReporter.reportPatchEvent(BaseApplication.getContext(), "", PatchReporter.ACTION_PATCH_CHECK, i3, str);
                    return i3;
                } catch (CertificateEncodingException e26) {
                    e = e26;
                    jarFile = jarFile2;
                    QLog.d("PatchLogTag", 1, "PatchChecker checkJarPatchSignature CertificateEncodingException=" + e);
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    BaseApplication context22 = BaseApplication.getContext();
                    if (i3 == 300) {
                    }
                    PatchSharedPreUtil.updatePatchVerifyStatus(context22, str, z16);
                    PatchReporter.reportPatchEvent(BaseApplication.getContext(), "", PatchReporter.ACTION_PATCH_CHECK, i3, str);
                    return i3;
                } catch (Throwable th5) {
                    th = th5;
                    jarFile = jarFile2;
                    QLog.d("PatchLogTag", 1, "PatchChecker checkJarPatchSignature throwable=" + th);
                    if (jarFile != null) {
                        jarFile.close();
                    }
                    BaseApplication context222 = BaseApplication.getContext();
                    if (i3 == 300) {
                    }
                    PatchSharedPreUtil.updatePatchVerifyStatus(context222, str, z16);
                    PatchReporter.reportPatchEvent(BaseApplication.getContext(), "", PatchReporter.ACTION_PATCH_CHECK, i3, str);
                    return i3;
                }
            } catch (PackageManager.NameNotFoundException e27) {
                e = e27;
            } catch (IOException e28) {
                e = e28;
            } catch (CertificateEncodingException e29) {
                e = e29;
            } catch (Throwable th6) {
                th = th6;
            }
            BaseApplication context2222 = BaseApplication.getContext();
            if (i3 == 300) {
                z16 = true;
            }
            PatchSharedPreUtil.updatePatchVerifyStatus(context2222, str, z16);
            PatchReporter.reportPatchEvent(BaseApplication.getContext(), "", PatchReporter.ACTION_PATCH_CHECK, i3, str);
            return i3;
        } catch (Throwable th7) {
            if (jarFile != null) {
                try {
                    jarFile.close();
                } catch (IOException e36) {
                    e36.printStackTrace();
                }
            }
            throw th7;
        }
    }

    public static boolean checkPatchValid(String str, String str2) {
        if (!"dex".equals(str) || 300 != checkJarPatchSignature(str2)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0070: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:113), block:B:49:0x0070 */
    private static Certificate[] loadPatchCertificates(JarFile jarFile, JarEntry jarEntry) {
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        InputStream inputStream2 = null;
        Certificate[] certificateArr = null;
        try {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                } catch (IOException e16) {
                    e = e16;
                    bufferedInputStream = null;
                } catch (RuntimeException e17) {
                    e = e17;
                    bufferedInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    do {
                    } while (bufferedInputStream.read(new byte[4096], 0, 4096) != -1);
                    if (jarEntry != null) {
                        certificateArr = jarEntry.getCertificates();
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                    return certificateArr;
                } catch (IOException e26) {
                    e = e26;
                    QLog.d("PatchLogTag", 1, "PatchChecker loadPatchCertificates IOException=" + e);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return null;
                } catch (RuntimeException e27) {
                    e = e27;
                    QLog.d("PatchLogTag", 1, "PatchChecker loadPatchCertificates RuntimeException=" + e);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return null;
                }
            } catch (IOException e28) {
                e28.printStackTrace();
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
        }
    }
}
