package com.tencent.mobileqq.winkpublish.util;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c {
    public static String a(File file) {
        int i3;
        if (file == null) {
            return "";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 8192);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream.close();
                byte[] digest = messageDigest.digest();
                char[] cArr2 = new char[32];
                int i16 = 0;
                for (i3 = 0; i3 < 16; i3++) {
                    byte b16 = digest[i3];
                    int i17 = i16 + 1;
                    cArr2[i16] = cArr[(b16 >>> 4) & 15];
                    i16 = i17 + 1;
                    cArr2[i17] = cArr[b16 & RegisterType.DOUBLE_HI];
                }
                return new String(cArr2);
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            return "";
        }
    }
}
