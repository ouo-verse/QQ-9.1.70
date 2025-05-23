package org.apache.httpcore.util;

import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.qqlive.common.api.AegisLogger;
import java.io.UnsupportedEncodingException;
import org.apache.httpcore.Consts;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class EncodingUtils {
    EncodingUtils() {
    }

    public static byte[] getAsciiBytes(String str) {
        Args.notNull(str, AegisLogger.INPUT);
        return str.getBytes(Consts.ASCII);
    }

    public static String getAsciiString(byte[] bArr, int i3, int i16) {
        Args.notNull(bArr, AegisLogger.INPUT);
        return new String(bArr, i3, i16, Consts.ASCII);
    }

    public static byte[] getBytes(String str, String str2) {
        Args.notNull(str, AegisLogger.INPUT);
        Args.notEmpty(str2, HttpHeader.RSP.CHARSET);
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static String getString(byte[] bArr, int i3, int i16, String str) {
        Args.notNull(bArr, AegisLogger.INPUT);
        Args.notEmpty(str, HttpHeader.RSP.CHARSET);
        try {
            return new String(bArr, i3, i16, str);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr, i3, i16);
        }
    }

    public static String getAsciiString(byte[] bArr) {
        Args.notNull(bArr, AegisLogger.INPUT);
        return getAsciiString(bArr, 0, bArr.length);
    }

    public static String getString(byte[] bArr, String str) {
        Args.notNull(bArr, AegisLogger.INPUT);
        return getString(bArr, 0, bArr.length, str);
    }
}
