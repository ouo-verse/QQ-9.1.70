package com.tencent.av.avgesture;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.FileInputStream;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes3.dex */
class SHA1Utils {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    SHA1Utils() {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0042: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:67), block:B:30:0x0042 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getFileSHA1(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream3 != null) {
                }
                throw th;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                byte[] bArr = new byte[65536];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String hexString = toHexString(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                return hexString;
            } catch (Exception e18) {
                e = e18;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e19) {
                        e19.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(bArr.length * 2);
        for (int i3 = 0; i3 < bArr.length; i3++) {
            char[] cArr = HEX_DIGITS;
            sb5.append(cArr[(bArr[i3] & 240) >>> 4]);
            sb5.append(cArr[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }
}
