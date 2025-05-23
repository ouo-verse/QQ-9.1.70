package com.tencent.bugly.common.utils;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class MD5Utils {
    public static final String TAG = "RMonitor_MD5Utils";

    private static String getHashString(MessageDigest messageDigest) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : messageDigest.digest()) {
            sb5.append(Integer.toHexString((b16 >> 4) & 15));
            sb5.append(Integer.toHexString(b16 & RegisterType.DOUBLE_HI));
        }
        return sb5.toString();
    }

    public static String getMD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            return getHashString(messageDigest);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
