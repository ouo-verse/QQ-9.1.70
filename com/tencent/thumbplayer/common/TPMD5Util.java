package com.tencent.thumbplayer.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import java.security.MessageDigest;

/* loaded from: classes26.dex */
public class TPMD5Util {
    private static final String TAG = "TPMD5Util";

    @Nullable
    public static String getMd5(@NonNull String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes("UTF-8"));
            StringBuilder sb5 = new StringBuilder(40);
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if ((i3 >> 4) == 0) {
                    sb5.append("0");
                    sb5.append(Integer.toHexString(i3));
                } else {
                    sb5.append(Integer.toHexString(i3));
                }
            }
            return sb5.toString();
        } catch (Exception e16) {
            TPLogUtil.e(TAG, e16.toString());
            return null;
        }
    }
}
