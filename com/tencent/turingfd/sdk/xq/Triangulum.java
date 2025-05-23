package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Triangulum {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f383138a = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12951);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i3 = 0; i3 < 256; i3++) {
            bArr2[i3] = bArr[i3 >>> 4];
            bArr3[i3] = bArr[i3 & 15];
        }
    }

    public static boolean a(int i3, int i16) {
        return i3 == i16;
    }

    public static boolean a(long j3, long j16) {
        return j3 == j16;
    }

    public static boolean a(boolean z16, boolean z17) {
        return z16 == z17;
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}
