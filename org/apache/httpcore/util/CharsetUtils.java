package org.apache.httpcore.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class CharsetUtils {
    public static Charset get(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException unused) {
            throw new UnsupportedEncodingException(str);
        }
    }

    public static Charset lookup(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException unused) {
            return null;
        }
    }
}
