package com.tencent.usq;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f383924a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77619);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f383924a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            char[] cArr = f383924a;
            sb5.append(cArr[(bArr[i3] & 240) >>> 4]);
            sb5.append(cArr[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }

    public static String b(InputStream inputStream) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return a(messageDigest.digest());
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x002d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(String str) {
        BufferedInputStream bufferedInputStream;
        String a16 = com.tencent.mdm.a.a(str);
        if (a16 != null) {
            return a16;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        } catch (IOException e16) {
            e = e16;
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            if (bufferedInputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                String b16 = b(bufferedInputStream);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused) {
                }
                return b16;
            } catch (Throwable th6) {
                th = th6;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException e17) {
            e = e17;
            e.printStackTrace();
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused3) {
                }
            }
            return null;
        }
    }

    public static String d(Context context) {
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 64);
            if (packageInfo == null) {
                return "f2";
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                return "f3";
            }
            Signature signature = signatureArr[0];
            if (signature == null) {
                return "f4";
            }
            byte[] byteArray = signature.toByteArray();
            if (byteArray != null && byteArray.length != 0) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    messageDigest.update(byteArray);
                    return a(messageDigest.digest());
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return "f6";
                }
            }
            return "f5";
        } catch (Exception unused) {
            return "f1";
        }
    }
}
