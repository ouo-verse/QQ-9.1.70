package com.xingin.xhssharesdk.a;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f389911a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f389912b;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface a {
        int a();
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f389912b = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new c(bArr, 0, 0, false).c(0);
        } catch (m e16) {
            throw new IllegalArgumentException(e16);
        }
    }
}
