package com.tencent.gdtad.config.parser;

import com.google.gson.GsonBuilder;
import com.tencent.gdtad.log.GdtLog;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes6.dex */
final class a {
    public static <T> T a(byte[] bArr, Class<T> cls, T t16) {
        try {
            return (T) new GsonBuilder().disableHtmlEscaping().create().fromJson(new String(bArr, StandardCharsets.UTF_8), (Class) cls);
        } catch (Throwable th5) {
            GdtLog.e("GdtConfigParserUtil", "[build]", th5);
            return t16;
        }
    }
}
