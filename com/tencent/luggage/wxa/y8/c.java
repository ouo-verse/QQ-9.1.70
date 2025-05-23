package com.tencent.luggage.wxa.y8;

import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.cp.x;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class c {
    public static final String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i3 = 0;
            for (byte b16 : digest) {
                int i16 = i3 + 1;
                cArr2[i3] = cArr[(b16 >>> 4) & 15];
                i3 = i16 + 1;
                cArr2[i16] = cArr[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String a(InputStream inputStream, int i3) {
        int i16;
        if (inputStream != null && i3 > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                StringBuilder sb5 = new StringBuilder(32);
                byte[] bArr = new byte[i3];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                for (byte b16 : messageDigest.digest()) {
                    sb5.append(Integer.toString((b16 & 255) + 256, 16).substring(1));
                }
                return sb5.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        v vVar = new v(str);
        if (vVar.e()) {
            return a(vVar, RFixConstants.MD5_FILE_BUF_LENGTH);
        }
        return null;
    }

    public static String a(v vVar, int i3) {
        InputStream inputStream;
        long j3;
        InputStream inputStream2 = null;
        if (vVar != null && i3 > 0 && vVar.e()) {
            try {
                inputStream = x.a(vVar);
                j3 = i3;
            } catch (Exception unused) {
                inputStream = null;
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                if (j3 > vVar.s()) {
                    j3 = vVar.s();
                }
                String a16 = a(inputStream, (int) j3);
                inputStream.close();
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                return a16;
            } catch (Exception unused3) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return null;
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return null;
    }
}
