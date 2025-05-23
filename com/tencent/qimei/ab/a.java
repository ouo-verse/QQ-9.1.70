package com.tencent.qimei.ab;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f342921a = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19938);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            new Random();
        }
    }

    public static String a(String str) {
        String b16 = b(str);
        if (b16 == null) {
            return b16;
        }
        try {
            return b16.substring(8, 24);
        } catch (Exception e16) {
            com.tencent.qimei.ad.c.a(e16);
            return b16;
        }
    }

    public static String b(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes(Charset.forName("UTF-8")));
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if (i3 < 16) {
                    sb5.append(0);
                }
                sb5.append(Integer.toHexString(i3));
            }
            return sb5.toString();
        } catch (Exception e16) {
            com.tencent.qimei.ad.c.a(e16);
            return str;
        }
    }

    public static String c(String str) {
        FileInputStream fileInputStream;
        String str2 = "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            str2 = byteArrayOutputStream.toString("UTF-8").trim().replaceAll("\\s*|\\t|\\r|\\n", "");
            a(fileInputStream);
            a(byteArrayOutputStream);
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            a(fileInputStream2);
            a(byteArrayOutputStream);
            return str2;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            a(fileInputStream2);
            a(byteArrayOutputStream);
            throw th;
        }
        return str2;
    }

    public static void a(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str2) || str.equals(str2);
    }
}
