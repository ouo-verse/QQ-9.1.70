package com.tencent.local_edit.andserver.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h {
    public static String a(String str, String str2) {
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String b(String str, Charset charset) {
        return a(str, charset.name());
    }

    public static String c(String str, String str2) {
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }
}
