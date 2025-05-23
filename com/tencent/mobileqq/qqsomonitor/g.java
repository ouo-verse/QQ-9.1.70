package com.tencent.mobileqq.qqsomonitor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static String a(a aVar) {
        if (aVar == null) {
            return null;
        }
        return new Gson().toJson(aVar);
    }

    public static String b(File file) {
        if (file == null) {
            QLog.d("SoMonitor.Util", 1, "[getCanonicalPath] file is null!");
            return "";
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e16) {
            QLog.e("SoMonitor.Util", 1, "[getCanonicalPath]", e16);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[4096];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    try {
                        int read = fileInputStream.read(bArr, 0, 4096);
                        if (read != -1) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e16) {
                    e = e16;
                    QLog.d("SoMonitor.Util", 1, e, new Object[0]);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                }
            }
            fileInputStream.close();
            return new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (Exception e17) {
            e = e17;
            fileInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return h(str);
    }

    public static boolean e() {
        if (QLog.isColorLevel()) {
            QLog.d("SoMonitor.Util", 1, "processId: " + MobileQQ.sProcessId);
        }
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : str.split(File.separator)) {
            if ("..".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean g(boolean z16, boolean z17) {
        if (z16 && !z17) {
            return true;
        }
        return false;
    }

    public static String h(@NonNull String str) {
        return str.replaceFirst(".*/data/data/com.tencent.mobileqq", "").replaceFirst(".*/data/user/[0-9]+/com.tencent.mobileqq", "");
    }
}
