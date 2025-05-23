package com.tencent.tgpa.vendorpd.b;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f376026a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12450);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f376026a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        if (r2 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0033, code lost:
    
        if (r2 == null) goto L28;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0043: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:31:0x0043 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        byte[] bArr = new byte[2048];
        InputStream inputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e16) {
                e = e16;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e17) {
                e = e17;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (inputStream2 != null) {
                }
                throw th;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String b16 = b(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return b16;
            } catch (IOException e18) {
                e = e18;
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e19) {
                e = e19;
                e.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    private static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : bArr) {
            int i3 = b16 & 255;
            if (i3 < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i3));
        }
        return stringBuffer.toString();
    }

    private static String c(String str) {
        if (str.length() != 32) {
            return c("0" + str);
        }
        return str;
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes("utf-8"));
            return c(new BigInteger(1, messageDigest.digest()).toString(16));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static byte[] b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            int i16 = i3 * 2;
            sb5.append(charArray[i16]);
            sb5.append(charArray[i16 + 1]);
            bArr[i3] = (byte) Integer.parseInt(sb5.toString(), 16);
        }
        return bArr;
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            char[] cArr = f376026a;
            sb5.append(cArr[(b16 >> 4) & 15]);
            sb5.append(cArr[b16 & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }
}
