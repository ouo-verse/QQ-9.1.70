package com.tencent.luggage.wxa.s8;

import android.graphics.Rect;
import com.tencent.luggage.wxa.s8.d;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l implements d {

    /* renamed from: c, reason: collision with root package name */
    public int f140189c;

    /* renamed from: d, reason: collision with root package name */
    public int f140190d;

    /* renamed from: e, reason: collision with root package name */
    public int f140191e;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f140187a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public d.a f140188b = new d.a();

    /* renamed from: f, reason: collision with root package name */
    public d.c f140192f = new d.c();

    @Override // com.tencent.luggage.wxa.s8.d
    public void a(int i3, int i16, Rect rect) {
        int i17;
        if (rect == null) {
            return;
        }
        if (i3 > 0 && i16 > 0) {
            d.c a16 = a(i3, i16);
            int i18 = a16.f140128a;
            if (i18 >= 0 && (i17 = a16.f140129b) >= 0) {
                rect.set(i18, i17, (i3 + i18) - 1, (i16 + i17) - 1);
                return;
            } else {
                rect.setEmpty();
                return;
            }
        }
        rect.setEmpty();
    }

    @Override // com.tencent.luggage.wxa.s8.d
    public void init(int i3, int i16) {
        this.f140190d = i3;
        this.f140191e = i16;
        reset();
    }

    @Override // com.tencent.luggage.wxa.s8.d
    public void reset() {
        this.f140189c = 0;
        this.f140188b.a(this.f140187a);
        d.b a16 = this.f140188b.a();
        a16.a(1, 1, this.f140190d - 2);
        this.f140187a.add(a16);
    }

    public final int a(int i3, int i16, int i17) {
        d.b bVar = (d.b) this.f140187a.get(i3);
        int i18 = bVar.f140125a;
        int i19 = bVar.f140126b;
        if (i18 + i16 > this.f140190d - 1) {
            return -1;
        }
        while (i16 > 0) {
            d.b bVar2 = (d.b) this.f140187a.get(i3);
            int i26 = bVar2.f140126b;
            if (i26 > i19) {
                i19 = i26;
            }
            if (i19 + i17 > this.f140191e - 1) {
                return -1;
            }
            i16 -= bVar2.f140127c;
            i3++;
        }
        return i19;
    }

    public final void a() {
        int i3 = 0;
        while (i3 < this.f140187a.size() - 1) {
            d.b bVar = (d.b) this.f140187a.get(i3);
            int i16 = i3 + 1;
            d.b bVar2 = (d.b) this.f140187a.get(i16);
            if (bVar.f140126b == bVar2.f140126b) {
                bVar.f140127c += bVar2.f140127c;
                this.f140188b.a((d.b) this.f140187a.remove(i16));
                i3--;
            }
            i3++;
        }
    }

    public final d.c a(int i3, int i16) {
        int i17;
        d.c a16 = this.f140192f.a(0, 0, i3, i16);
        int i18 = Integer.MAX_VALUE;
        int i19 = Integer.MAX_VALUE;
        int i26 = -1;
        for (int i27 = 0; i27 < this.f140187a.size(); i27++) {
            int a17 = a(i27, i3, i16);
            if (a17 >= 0) {
                d.b bVar = (d.b) this.f140187a.get(i27);
                int i28 = a17 + i16;
                if (i28 < i18 || (i28 == i18 && (i17 = bVar.f140127c) > 0 && i17 < i19)) {
                    int i29 = bVar.f140127c;
                    a16.f140128a = bVar.f140125a;
                    a16.f140129b = a17;
                    i19 = i29;
                    i26 = i27;
                    i18 = i28;
                }
            }
        }
        if (i26 == -1) {
            a16.f140128a = -1;
            a16.f140129b = -1;
            a16.f140130c = 0;
            a16.f140131d = 0;
            return a16;
        }
        d.b a18 = this.f140188b.a();
        a18.f140125a = a16.f140128a;
        a18.f140126b = a16.f140129b + i16;
        a18.f140127c = i3;
        this.f140187a.add(i26, a18);
        while (true) {
            int i36 = i26 + 1;
            if (i36 >= this.f140187a.size()) {
                break;
            }
            d.b bVar2 = (d.b) this.f140187a.get(i36);
            d.b bVar3 = (d.b) this.f140187a.get(i36 - 1);
            int i37 = bVar2.f140125a;
            int i38 = bVar3.f140125a + bVar3.f140127c;
            if (i37 >= i38) {
                break;
            }
            int i39 = i38 - i37;
            bVar2.f140125a = i37 + i39;
            int i46 = bVar2.f140127c - i39;
            bVar2.f140127c = i46;
            if (i46 > 0) {
                break;
            }
            this.f140188b.a((d.b) this.f140187a.remove(i36));
            i26 = i36 - 1;
        }
        a();
        this.f140189c += i3 * i16;
        return a16;
    }
}
