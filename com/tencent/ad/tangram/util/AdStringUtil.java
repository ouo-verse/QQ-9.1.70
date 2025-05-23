package com.tencent.ad.tangram.util;

import com.tencent.ad.tangram.log.AdLog;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdStringUtil {
    private static final String TAG = "AdStringUtil";

    public static String newString(byte[] bArr, Charset charset) {
        try {
            return new String(bArr, charset);
        } catch (Throwable th5) {
            AdLog.e(TAG, "[newString]", th5);
            return null;
        }
    }
}
