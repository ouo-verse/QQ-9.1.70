package com.tencent.luggage.wxa.n;

import com.tencent.luggage.wxa.n.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g implements d {

    /* renamed from: b, reason: collision with root package name */
    public int f134986b;

    /* renamed from: c, reason: collision with root package name */
    public int f134987c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f134988d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f134989e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f134990f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f134991g;

    /* renamed from: h, reason: collision with root package name */
    public ByteBuffer f134992h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f134993i;

    public g() {
        ByteBuffer byteBuffer = d.f134912a;
        this.f134991g = byteBuffer;
        this.f134992h = byteBuffer;
        this.f134986b = -1;
        this.f134987c = -1;
    }

    public void a(int[] iArr) {
        this.f134988d = iArr;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public boolean b() {
        if (this.f134993i && this.f134992h == d.f134912a) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public int c() {
        int[] iArr = this.f134990f;
        if (iArr == null) {
            return this.f134986b;
        }
        return iArr.length;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public int d() {
        return 2;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public void e() {
        this.f134993i = true;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public void flush() {
        this.f134992h = d.f134912a;
        this.f134993i = false;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public boolean isActive() {
        return this.f134989e;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public void reset() {
        flush();
        this.f134991g = d.f134912a;
        this.f134986b = -1;
        this.f134987c = -1;
        this.f134990f = null;
        this.f134989e = false;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public boolean a(int i3, int i16, int i17) {
        boolean z16 = !Arrays.equals(this.f134988d, this.f134990f);
        int[] iArr = this.f134988d;
        this.f134990f = iArr;
        if (iArr == null) {
            this.f134989e = false;
            return z16;
        }
        if (i17 == 2) {
            if (!z16 && this.f134987c == i3 && this.f134986b == i16) {
                return false;
            }
            this.f134987c = i3;
            this.f134986b = i16;
            this.f134989e = i16 != iArr.length;
            int i18 = 0;
            while (true) {
                int[] iArr2 = this.f134990f;
                if (i18 >= iArr2.length) {
                    return true;
                }
                int i19 = iArr2[i18];
                if (i19 < i16) {
                    this.f134989e = (i19 != i18) | this.f134989e;
                    i18++;
                } else {
                    throw new d.a(i3, i16, i17);
                }
            }
        } else {
            throw new d.a(i3, i16, i17);
        }
    }

    @Override // com.tencent.luggage.wxa.n.d
    public void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.f134986b * 2)) * this.f134990f.length * 2;
        if (this.f134991g.capacity() < length) {
            this.f134991g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f134991g.clear();
        }
        while (position < limit) {
            for (int i3 : this.f134990f) {
                this.f134991g.putShort(byteBuffer.getShort((i3 * 2) + position));
            }
            position += this.f134986b * 2;
        }
        byteBuffer.position(limit);
        this.f134991g.flip();
        this.f134992h = this.f134991g;
    }

    @Override // com.tencent.luggage.wxa.n.d
    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.f134992h;
        this.f134992h = d.f134912a;
        return byteBuffer;
    }
}
