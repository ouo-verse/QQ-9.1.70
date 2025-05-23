package c.t.m.g;

import androidx.annotation.Nullable;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class u3 {
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest(), "");
        } catch (Exception unused) {
            return str;
        }
    }

    @Nullable
    public static byte[] b(byte[] bArr) {
        int read;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[0];
        byte[] bArr3 = new byte[1024];
        int i3 = 0;
        do {
            try {
                read = inflaterInputStream.read(bArr3);
                if (read > 0) {
                    i3 += read;
                    byte[] bArr4 = new byte[i3];
                    System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
                    System.arraycopy(bArr3, 0, bArr4, bArr2.length, read);
                    bArr2 = bArr4;
                }
            } catch (IOException | Exception unused) {
                return null;
            }
        } while (read > 0);
        byteArrayInputStream.close();
        inflaterInputStream.close();
        return bArr2;
    }

    public static String a(byte[] bArr, String str) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            sb5.append(Integer.toHexString(b16 & 255));
            sb5.append(str);
        }
        return sb5.toString();
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr, 0, bArr.length);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception unused) {
            return null;
        }
    }
}
