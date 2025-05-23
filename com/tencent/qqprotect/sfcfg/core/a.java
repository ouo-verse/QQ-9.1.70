package com.tencent.qqprotect.sfcfg.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.zip.ZipFile, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String str, String str2, byte[] bArr) {
        JarFile jarFile;
        ?? r06 = 0;
        r06 = 0;
        r06 = 0;
        r06 = 0;
        r06 = 0;
        r06 = 0;
        try {
            try {
                jarFile = new JarFile(str);
            } catch (IOException e16) {
                e = e16;
                jarFile = null;
            } catch (OutOfMemoryError e17) {
                e = e17;
                jarFile = null;
            } catch (NoSuchAlgorithmException e18) {
                e = e18;
                jarFile = null;
            } catch (Throwable th5) {
                th = th5;
                if (0 != 0) {
                }
                if (0 == 0) {
                }
            }
            try {
                ZipEntry entry = jarFile.getEntry(str2);
                if (entry == null) {
                    try {
                        jarFile.close();
                        return 2;
                    } catch (IOException unused) {
                        return 2;
                    }
                }
                r06 = jarFile.getInputStream(entry);
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                byte[] bArr2 = new byte[8192];
                while (true) {
                    int read = r06.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr2, 0, read);
                }
                byte[] digest = messageDigest.digest();
                System.arraycopy(digest, 0, bArr, 0, digest.length);
                try {
                    r06.close();
                } catch (IOException unused2) {
                }
                try {
                    jarFile.close();
                } catch (IOException unused3) {
                }
                return 0;
            } catch (IOException e19) {
                e = e19;
                e.printStackTrace();
                if (r06 != 0) {
                    try {
                        r06.close();
                    } catch (IOException unused4) {
                    }
                }
                if (jarFile != null) {
                    try {
                        jarFile.close();
                        return 3;
                    } catch (IOException unused5) {
                        return 3;
                    }
                }
                return 3;
            } catch (OutOfMemoryError e26) {
                e = e26;
                e.printStackTrace();
                if (r06 != 0) {
                    try {
                        r06.close();
                    } catch (IOException unused6) {
                    }
                }
                if (jarFile != null) {
                    try {
                        jarFile.close();
                        return 144;
                    } catch (IOException unused7) {
                        return 144;
                    }
                }
                return 144;
            } catch (NoSuchAlgorithmException e27) {
                e = e27;
                e.printStackTrace();
                if (r06 != 0) {
                    try {
                        r06.close();
                    } catch (IOException unused8) {
                    }
                }
                if (jarFile != null) {
                    try {
                        jarFile.close();
                        return 139;
                    } catch (IOException unused9) {
                        return 139;
                    }
                }
                return 139;
            }
        } catch (Throwable th6) {
            th = th6;
            if (0 != 0) {
                try {
                    r06.close();
                } catch (IOException unused10) {
                }
            }
            if (0 == 0) {
                try {
                    r06.close();
                    throw th;
                } catch (IOException unused11) {
                    throw th;
                }
            }
            throw th;
        }
    }
}
