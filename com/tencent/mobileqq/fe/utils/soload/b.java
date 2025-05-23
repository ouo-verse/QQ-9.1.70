package com.tencent.mobileqq.fe.utils.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f205847a;

    /* renamed from: b, reason: collision with root package name */
    private final int f205848b;

    /* renamed from: c, reason: collision with root package name */
    private final int f205849c;

    /* renamed from: d, reason: collision with root package name */
    private final ByteOrder f205850d;

    /* renamed from: e, reason: collision with root package name */
    private int f205851e;

    b(byte[] bArr, int i3, int i16, ByteOrder byteOrder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), byteOrder);
            return;
        }
        this.f205847a = bArr;
        this.f205848b = i3;
        this.f205849c = i16;
        this.f205850d = byteOrder;
    }

    public static b d(byte[] bArr, int i3, int i16, ByteOrder byteOrder) {
        return new b(bArr, i3, i16, byteOrder);
    }

    @Override // com.tencent.mobileqq.fe.utils.soload.a
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        int a16 = c.a(this.f205847a, this.f205848b + this.f205851e, this.f205850d);
        this.f205851e += 4;
        return a16;
    }

    @Override // com.tencent.mobileqq.fe.utils.soload.a
    public short b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Short) iPatchRedirector.redirect((short) 5, (Object) this)).shortValue();
        }
        short b16 = c.b(this.f205847a, this.f205848b + this.f205851e, this.f205850d);
        this.f205851e += 2;
        return b16;
    }

    @Override // com.tencent.mobileqq.fe.utils.soload.a
    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f205851e += i3;
        }
    }
}
