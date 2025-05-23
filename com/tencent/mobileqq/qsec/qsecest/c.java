package com.tencent.mobileqq.qsec.qsecest;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f276835a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20309);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276835a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && !str.startsWith("E_")) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.reset();
                messageDigest.update(str.getBytes("utf-8"));
                return b(messageDigest.digest());
            } catch (Throwable unused) {
                return "E_TH";
            }
        }
        return str;
    }

    public static String b(byte[] bArr) {
        try {
            StringBuilder sb5 = new StringBuilder(bArr.length * 2);
            for (byte b16 : bArr) {
                char[] cArr = f276835a;
                sb5.append(cArr[(b16 >> 4) & 15]);
                sb5.append(cArr[b16 & RegisterType.DOUBLE_HI]);
            }
            return sb5.toString().substring(0, 16);
        } catch (Throwable unused) {
            return null;
        }
    }
}
