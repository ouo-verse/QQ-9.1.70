package com.tencent.qqlive.module.videoreport.sample;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SampleUtils {
    private static final char[] HEX_CHAR_ARR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final int SEED = 1313;

    public static String bytesToHex(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            int i3 = 0;
            for (byte b16 : bArr) {
                int i16 = i3 + 1;
                char[] cArr2 = HEX_CHAR_ARR;
                cArr[i3] = cArr2[(b16 >>> 4) & 15];
                i3 = i16 + 1;
                cArr[i16] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return "";
    }

    public static long getBKDRHashCode(String str) {
        long j3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        for (int i3 = 0; i3 != str.length(); i3++) {
            j3 = (j3 * 1313) + str.charAt(i3);
        }
        return j3 & TTL.MAX_VALUE;
    }
}
