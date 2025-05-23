package com.tencent.theme;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
class a {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final byte[] a(ByteBuffer byteBuffer, int i3) {
        byte[] bArr = new byte[i3];
        byteBuffer.get(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void b(ByteBuffer byteBuffer, int i3) throws IOException {
        int i16 = byteBuffer.getInt();
        if (i16 == i3) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i3) + ", read 0x" + Integer.toHexString(i16) + ".");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int[] c(ByteBuffer byteBuffer, int i3) throws IOException {
        int[] iArr = new int[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            iArr[i16] = byteBuffer.getInt();
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void d(ByteBuffer byteBuffer, int i3) {
        byteBuffer.position(byteBuffer.position() + i3);
    }
}
