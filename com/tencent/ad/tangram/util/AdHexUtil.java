package com.tencent.ad.tangram.util;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdHexUtil {
    private static final String TAG = "AdHexUtil";
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    @Nullable
    public static String bytes2HexString(@Nullable byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        try {
            char[] cArr = new char[length << 1];
            int i3 = 0;
            for (byte b16 : bArr) {
                int i16 = i3 + 1;
                char[] cArr2 = hexDigits;
                cArr[i3] = cArr2[(b16 >>> 4) & 15];
                i3 = i16 + 1;
                cArr[i16] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        } catch (Throwable th5) {
            AdLog.e(TAG, "bytes2HexString", th5);
            return null;
        }
    }
}
