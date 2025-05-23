package com.tencent.ad.tangram.util;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdMessageDigestUtil {
    private static final String TAG = "AdMessageDigestUtil";

    @Nullable
    private static byte[] digest(String str, byte[] bArr) {
        try {
            return MessageDigest.getInstance(str).digest(bArr);
        } catch (Throwable th5) {
            AdLog.e(TAG, PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME, th5);
            return null;
        }
    }

    @Nullable
    public static String md5(@Nullable String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                String bytes2HexString = AdHexUtil.bytes2HexString(md5(str.getBytes(str2)));
                if (!TextUtils.isEmpty(bytes2HexString) && bytes2HexString.length() == 32) {
                    return bytes2HexString;
                }
                AdLog.e(TAG, "md5 error");
                return null;
            } catch (Throwable th5) {
                AdLog.e(TAG, "md5", th5);
            }
        }
        return null;
    }

    @Nullable
    public static byte[] md5(@Nullable byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            byte[] digest = digest("md5", bArr);
            if (digest != null && digest.length == 16) {
                return digest;
            }
            AdLog.e(TAG, "md5 error");
        }
        return null;
    }
}
