package org.tencwebrtc;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes29.dex */
class JniHelper {
    JniHelper() {
    }

    @CalledByNative
    static Object getKey(Map.Entry entry) {
        return entry.getKey();
    }

    @CalledByNative
    static byte[] getStringBytes(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("ISO-8859-1 is unsupported");
        }
    }

    @CalledByNative
    static Object getStringClass() {
        return String.class;
    }

    @CalledByNative
    static Object getValue(Map.Entry entry) {
        return entry.getValue();
    }
}
