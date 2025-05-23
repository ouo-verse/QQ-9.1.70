package com.tencent.gathererga.core.internal.util.dex;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(ByteBuffer byteBuffer, int i3) {
        byteBuffer.position(i3);
    }

    public static void b(ByteBuffer byteBuffer, long j3) {
        a(byteBuffer, d.a(j3));
    }

    public static byte[] c(ByteBuffer byteBuffer, int i3) {
        byte[] bArr = new byte[i3];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static short d(ByteBuffer byteBuffer) {
        return (short) (byteBuffer.get() & 255);
    }

    public static long e(ByteBuffer byteBuffer) {
        return byteBuffer.getInt() & 4294967295L;
    }
}
