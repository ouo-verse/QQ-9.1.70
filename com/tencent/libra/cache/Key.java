package com.tencent.libra.cache;

import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface Key {
    public static final Charset CHARSET = Charset.forName("UTF-8");
    public static final String STRING_CHARSET_NAME = "UTF-8";

    boolean equals(Object obj);

    int hashCode();
}
