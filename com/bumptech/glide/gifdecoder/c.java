package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f31528b;

    /* renamed from: c, reason: collision with root package name */
    private b f31529c;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f31527a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    private int f31530d = 0;

    private boolean b() {
        if (this.f31529c.f31515b != 0) {
            return true;
        }
        return false;
    }

    private int d() {
        try {
            return this.f31528b.get() & 255;
        } catch (Exception unused) {
            this.f31529c.f31515b = 1;
            return 0;
        }
    }

    private void e() {
        boolean z16;
        this.f31529c.f31517d.f31503a = n();
        this.f31529c.f31517d.f31504b = n();
        this.f31529c.f31517d.f31505c = n();
        this.f31529c.f31517d.f31506d = n();
        int d16 = d();
        boolean z17 = false;
        if ((d16 & 128) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        int pow = (int) Math.pow(2.0d, (d16 & 7) + 1);
        a aVar = this.f31529c.f31517d;
        if ((d16 & 64) != 0) {
            z17 = true;
        }
        aVar.f31507e = z17;
        if (z16) {
            aVar.f31513k = g(pow);
        } else {
            aVar.f31513k = null;
        }
        this.f31529c.f31517d.f31512j = this.f31528b.position();
        r();
        if (b()) {
            return;
        }
        b bVar = this.f31529c;
        bVar.f31516c++;
        bVar.f31518e.add(bVar.f31517d);
    }

    private void f() {
        int d16 = d();
        this.f31530d = d16;
        if (d16 > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                try {
                    i16 = this.f31530d;
                    if (i3 < i16) {
                        i16 -= i3;
                        this.f31528b.get(this.f31527a, i3, i16);
                        i3 += i16;
                    } else {
                        return;
                    }
                } catch (Exception e16) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i3 + " count: " + i16 + " blockSize: " + this.f31530d, e16);
                    }
                    this.f31529c.f31515b = 1;
                    return;
                }
            }
        }
    }

    @Nullable
    private int[] g(int i3) {
        byte[] bArr = new byte[i3 * 3];
        int[] iArr = null;
        try {
            this.f31528b.get(bArr);
            iArr = new int[256];
            int i16 = 0;
            int i17 = 0;
            while (i16 < i3) {
                int i18 = i17 + 1;
                int i19 = i18 + 1;
                int i26 = i19 + 1;
                int i27 = i16 + 1;
                iArr[i16] = ((bArr[i17] & 255) << 16) | (-16777216) | ((bArr[i18] & 255) << 8) | (bArr[i19] & 255);
                i17 = i26;
                i16 = i27;
            }
        } catch (BufferUnderflowException e16) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e16);
            }
            this.f31529c.f31515b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i3) {
        boolean z16 = false;
        while (!z16 && !b() && this.f31529c.f31516c <= i3) {
            int d16 = d();
            if (d16 != 33) {
                if (d16 != 44) {
                    if (d16 != 59) {
                        this.f31529c.f31515b = 1;
                    } else {
                        z16 = true;
                    }
                } else {
                    b bVar = this.f31529c;
                    if (bVar.f31517d == null) {
                        bVar.f31517d = new a();
                    }
                    e();
                }
            } else {
                int d17 = d();
                if (d17 != 1) {
                    if (d17 != 249) {
                        if (d17 != 254) {
                            if (d17 != 255) {
                                q();
                            } else {
                                f();
                                StringBuilder sb5 = new StringBuilder();
                                for (int i16 = 0; i16 < 11; i16++) {
                                    sb5.append((char) this.f31527a[i16]);
                                }
                                if (sb5.toString().equals("NETSCAPE2.0")) {
                                    m();
                                } else {
                                    q();
                                }
                            }
                        } else {
                            q();
                        }
                    } else {
                        this.f31529c.f31517d = new a();
                        j();
                    }
                } else {
                    q();
                }
            }
        }
    }

    private void j() {
        d();
        int d16 = d();
        a aVar = this.f31529c.f31517d;
        int i3 = (d16 & 28) >> 2;
        aVar.f31509g = i3;
        boolean z16 = true;
        if (i3 == 0) {
            aVar.f31509g = 1;
        }
        if ((d16 & 1) == 0) {
            z16 = false;
        }
        aVar.f31508f = z16;
        int n3 = n();
        if (n3 < 2) {
            n3 = 10;
        }
        a aVar2 = this.f31529c.f31517d;
        aVar2.f31511i = n3 * 10;
        aVar2.f31510h = d();
        d();
    }

    private void k() {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < 6; i3++) {
            sb5.append((char) d());
        }
        if (!sb5.toString().startsWith("GIF")) {
            this.f31529c.f31515b = 1;
            return;
        }
        l();
        if (this.f31529c.f31521h && !b()) {
            b bVar = this.f31529c;
            bVar.f31514a = g(bVar.f31522i);
            b bVar2 = this.f31529c;
            bVar2.f31525l = bVar2.f31514a[bVar2.f31523j];
        }
    }

    private void l() {
        boolean z16;
        this.f31529c.f31519f = n();
        this.f31529c.f31520g = n();
        int d16 = d();
        b bVar = this.f31529c;
        if ((d16 & 128) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        bVar.f31521h = z16;
        bVar.f31522i = (int) Math.pow(2.0d, (d16 & 7) + 1);
        this.f31529c.f31523j = d();
        this.f31529c.f31524k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.f31527a;
            if (bArr[0] == 1) {
                this.f31529c.f31526m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f31530d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.f31528b.getShort();
    }

    private void o() {
        this.f31528b = null;
        Arrays.fill(this.f31527a, (byte) 0);
        this.f31529c = new b();
        this.f31530d = 0;
    }

    private void q() {
        int d16;
        do {
            d16 = d();
            this.f31528b.position(Math.min(this.f31528b.position() + d16, this.f31528b.limit()));
        } while (d16 > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f31528b = null;
        this.f31529c = null;
    }

    @NonNull
    public b c() {
        if (this.f31528b != null) {
            if (b()) {
                return this.f31529c;
            }
            k();
            if (!b()) {
                h();
                b bVar = this.f31529c;
                if (bVar.f31516c < 0) {
                    bVar.f31515b = 1;
                }
            }
            return this.f31529c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public c p(@NonNull ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f31528b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f31528b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
