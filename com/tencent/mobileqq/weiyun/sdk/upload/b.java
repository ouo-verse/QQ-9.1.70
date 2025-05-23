package com.tencent.mobileqq.weiyun.sdk.upload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final int f315259a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f315260b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f315261c;

    /* renamed from: d, reason: collision with root package name */
    private final short f315262d;

    /* renamed from: e, reason: collision with root package name */
    private final long f315263e;

    /* renamed from: f, reason: collision with root package name */
    private long f315264f;

    /* renamed from: g, reason: collision with root package name */
    private short f315265g;

    /* renamed from: h, reason: collision with root package name */
    private long f315266h;

    /* renamed from: i, reason: collision with root package name */
    private int f315267i;

    public b(int i3, byte[] bArr, long j3, byte[] bArr2, long j16) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), bArr, Long.valueOf(j3), bArr2, Long.valueOf(j16));
            return;
        }
        this.f315259a = i3;
        this.f315263e = j3;
        this.f315260b = bArr2;
        this.f315264f = j16;
        this.f315261c = new byte[20];
        if (bArr.length <= 20) {
            this.f315262d = (short) bArr.length;
            for (int i16 = 0; i16 < bArr.length; i16++) {
                this.f315261c[i16] = bArr[i16];
            }
            return;
        }
        throw new IllegalArgumentException("file Hash is too long.");
    }

    public int a(long j3, int i3, byte[] bArr, int i16, int i17) {
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), Integer.valueOf(i3), bArr, Integer.valueOf(i16), Integer.valueOf(i17))).intValue();
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i16, i17);
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            wrap.order(ByteOrder.BIG_ENDIAN);
        }
        wrap.putInt(-1412589450);
        wrap.putInt(this.f315259a);
        wrap.putInt((int) this.f315264f);
        if (this.f315259a == 1000) {
            length = this.f315260b.length + 2 + 34;
        } else {
            length = this.f315260b.length + 2 + 42;
        }
        int i18 = length + i3;
        wrap.putInt(i18);
        int i19 = i18 + 16;
        short length2 = (short) this.f315260b.length;
        wrap.putShort(length2);
        wrap.put(this.f315260b, 0, length2);
        wrap.putShort(this.f315262d);
        wrap.put(this.f315261c);
        wrap.putInt((int) (this.f315263e & 4294967295L));
        wrap.putInt((int) (j3 & 4294967295L));
        wrap.putInt(i3);
        if (this.f315259a == 1007) {
            wrap.putInt((int) ((this.f315263e & (-4294967296L)) >> 32));
            wrap.putInt((int) ((j3 & (-4294967296L)) >> 32));
        }
        return i19 - i3;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.f315259a == 1000) {
            return this.f315260b.length + 2 + 34 + 16;
        }
        return this.f315260b.length + 2 + 42 + 16;
    }

    public short c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Short) iPatchRedirector.redirect((short) 6, (Object) this)).shortValue();
        }
        return this.f315265g;
    }

    public long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.f315266h;
    }

    public int e(boolean z16, byte[] bArr, int i3) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), bArr, Integer.valueOf(i3))).intValue();
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, i3);
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            wrap.order(ByteOrder.BIG_ENDIAN);
        }
        long j16 = wrap.getInt();
        this.f315267i = wrap.getInt();
        wrap.getInt();
        int i16 = wrap.getInt();
        if (j16 != -1412589450) {
            return 100002;
        }
        int i17 = this.f315267i;
        if (i17 != 0) {
            return i17;
        }
        if (z16) {
            if (i16 != 5 && i16 != 9) {
                return 100002;
            }
            this.f315265g = wrap.get();
            long j17 = wrap.getInt();
            if (this.f315259a == 1007) {
                j3 = wrap.getInt();
            } else {
                j3 = 0;
            }
            this.f315266h = (j17 & 4294967295L) + ((j3 << 32) & (-4294967296L));
        }
        return 0;
    }

    public void f(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.f315264f = j3;
        }
    }
}
