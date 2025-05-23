package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Rect;
import com.tencent.mobileqq.activity.aio.doodle.k;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f178551a;

    /* renamed from: b, reason: collision with root package name */
    private int f178552b;

    /* renamed from: c, reason: collision with root package name */
    private int f178553c;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        int f178554a = 0;

        /* renamed from: b, reason: collision with root package name */
        byte[] f178555b;

        a() {
        }
    }

    public j(int i3) {
        this.f178551a = null;
        this.f178552b = -1;
        this.f178553c = 0;
        if (i3 > 0) {
            this.f178551a = new byte[i3];
            this.f178552b = 0;
            this.f178553c = i3;
        }
    }

    private void a(byte[] bArr, boolean z16) {
        byte[] bArr2;
        if (bArr != null && (bArr2 = this.f178551a) != null) {
            int length = bArr.length;
            if (z16) {
                length += 4;
            }
            int length2 = bArr2.length;
            int i3 = this.f178552b;
            if (length2 > i3 + length) {
                if (z16) {
                    m(bArr.length);
                }
                System.arraycopy(bArr, 0, this.f178551a, this.f178552b, bArr.length);
                this.f178552b += bArr.length;
                return;
            }
            int length3 = (bArr2.length * 2) + length;
            byte[] bArr3 = new byte[length3];
            System.arraycopy(bArr2, 0, bArr3, 0, i3);
            this.f178551a = bArr3;
            this.f178553c = length3;
            if (z16) {
                m(bArr.length);
            }
            System.arraycopy(bArr, 0, this.f178551a, this.f178552b, bArr.length);
            this.f178552b += bArr.length;
        }
    }

    private int e() {
        byte[] bArr = this.f178551a;
        if (bArr != null) {
            int i3 = this.f178552b;
            if (i3 + 4 <= this.f178553c) {
                int b16 = d.b(bArr, i3);
                this.f178552b += 4;
                return b16;
            }
            return -1;
        }
        return -1;
    }

    private final void m(int i3) {
        a(d.f(i3), false);
    }

    public a b() {
        a aVar = new a();
        aVar.f178554a = this.f178552b;
        aVar.f178555b = this.f178551a;
        this.f178551a = null;
        this.f178552b = -1;
        return aVar;
    }

    public float c() {
        int e16 = e();
        byte[] bArr = this.f178551a;
        if (bArr != null) {
            int i3 = this.f178553c;
            int i16 = this.f178552b;
            if (i3 >= i16 + 4 && e16 == 4) {
                int b16 = d.b(bArr, i16);
                this.f178552b += 4;
                return Float.intBitsToFloat(b16);
            }
            return -1.0f;
        }
        return -1.0f;
    }

    public int d() {
        int e16 = e();
        byte[] bArr = this.f178551a;
        if (bArr != null) {
            int i3 = this.f178552b;
            if (i3 + 4 <= this.f178553c && e16 == 4) {
                int b16 = d.b(bArr, i3);
                this.f178552b += 4;
                return b16;
            }
            return -1;
        }
        return -1;
    }

    public long f() {
        int e16 = e();
        byte[] bArr = this.f178551a;
        if (bArr != null) {
            int i3 = this.f178553c;
            int i16 = this.f178552b;
            if (i3 >= i16 + 8 && e16 == 8) {
                long a16 = d.a(bArr, i16);
                this.f178552b += 8;
                return a16;
            }
            return -1L;
        }
        return -1L;
    }

    public final <T> Object g(k.a<T> aVar) {
        e();
        return aVar.a(this);
    }

    public Rect h() {
        int e16 = e();
        if (e16 == -1 || this.f178551a == null || this.f178552b + 16 > this.f178553c || e16 != 16) {
            return null;
        }
        Rect rect = new Rect();
        rect.left = d.b(this.f178551a, this.f178552b);
        int i3 = this.f178552b + 4;
        this.f178552b = i3;
        rect.top = d.b(this.f178551a, i3);
        int i16 = this.f178552b + 4;
        this.f178552b = i16;
        rect.right = d.b(this.f178551a, i16);
        int i17 = this.f178552b + 4;
        this.f178552b = i17;
        rect.bottom = d.b(this.f178551a, i17);
        this.f178552b += 4;
        return rect;
    }

    public final <T> void i(List<T> list, k.a<T> aVar) {
        int size = list.size();
        int e16 = e();
        int i3 = 0;
        while (i3 < size && i3 < e16) {
            if (e() != 0) {
                list.set(i3, aVar.a(this));
            } else {
                list.set(i3, null);
            }
            i3++;
        }
        while (i3 < e16) {
            if (e() != 0) {
                list.add(aVar.a(this));
            } else {
                list.add(null);
            }
            i3++;
        }
        while (i3 < size) {
            list.remove(e16);
            i3++;
        }
    }

    public void j(byte[] bArr, int i3, int i16) {
        this.f178551a = bArr;
        this.f178552b = i3;
        this.f178553c = i16;
    }

    public final void k(float f16) {
        a(d.f(Float.floatToIntBits(f16)), true);
    }

    public final void l(int i3) {
        a(d.f(i3), true);
    }

    public final void n(long j3) {
        a(d.g(j3), true);
    }

    public final void o(k kVar) {
        if (kVar != null) {
            int i3 = this.f178552b;
            m(0);
            kVar.a(this, 0);
            int i16 = (this.f178552b - i3) - 4;
            if (this.f178551a != null) {
                System.arraycopy(d.f(i16), 0, this.f178551a, i3, 4);
            }
        }
    }

    public final void p(Rect rect) {
        if (rect == null) {
            m(-1);
            return;
        }
        byte[] bArr = new byte[16];
        byte[] f16 = d.f(rect.left);
        byte[] f17 = d.f(rect.top);
        byte[] f18 = d.f(rect.right);
        byte[] f19 = d.f(rect.bottom);
        System.arraycopy(f16, 0, bArr, 0, 4);
        System.arraycopy(f17, 0, bArr, 4, 4);
        System.arraycopy(f18, 0, bArr, 8, 4);
        System.arraycopy(f19, 0, bArr, 12, 4);
        a(bArr, true);
    }

    public final <T extends k> void q(List<T> list) {
        if (list == null) {
            m(-1);
            return;
        }
        int size = list.size();
        m(size);
        for (int i3 = 0; i3 < size; i3++) {
            T t16 = list.get(i3);
            if (t16 != null) {
                m(1);
                t16.a(this, 0);
            } else {
                m(0);
            }
        }
    }
}
