package com.tencent.halley.common.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.zip.Checksum;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b implements Checksum {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final long[] f113537a;

    /* renamed from: b, reason: collision with root package name */
    private long f113538b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14272);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f113537a = new long[256];
        for (int i3 = 0; i3 < 256; i3++) {
            long j3 = i3;
            for (int i16 = 0; i16 < 8; i16++) {
                long j16 = j3 & 1;
                j3 >>>= 1;
                if (j16 == 1) {
                    j3 ^= -3932672073523589310L;
                }
            }
            f113537a[i3] = j3;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f113538b = 0L;
        }
    }

    private void a(byte b16) {
        long j3 = ~this.f113538b;
        this.f113538b = ~((j3 >>> 8) ^ f113537a[((int) (b16 ^ j3)) & 255]);
    }

    @Override // java.util.zip.Checksum
    public final long getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.f113538b;
    }

    @Override // java.util.zip.Checksum
    public final void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f113538b = 0L;
        }
    }

    @Override // java.util.zip.Checksum
    public final void update(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            a((byte) (i3 & 255));
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    public final void a(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr, i3);
            return;
        }
        this.f113538b = ~this.f113538b;
        int i16 = 0;
        while (i3 > 0) {
            long[] jArr = f113537a;
            long j3 = this.f113538b;
            this.f113538b = (j3 >>> 8) ^ jArr[((int) (bArr[i16] ^ j3)) & 255];
            i16++;
            i3--;
        }
        this.f113538b = ~this.f113538b;
    }

    @Override // java.util.zip.Checksum
    public final void update(byte[] bArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        while (i16 > 0) {
            a(bArr[i3]);
            i16--;
            i3++;
        }
    }
}
