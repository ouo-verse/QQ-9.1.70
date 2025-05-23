package com.tencent.luggage.wxa.lm;

import com.tencent.luggage.wxa.p9.b;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f133614a = "MicroMsg.Audio.AudioActionListener";

    public static boolean a(com.tencent.luggage.wxa.p9.b bVar) {
        int i3 = bVar.f137428b.f137430a;
        if (i3 != 6) {
            w.a(f133614a, "callback, action:%d", Integer.valueOf(i3));
        }
        switch (bVar.f137428b.f137430a) {
            case 0:
                boolean f16 = i.o().f(bVar.f137428b.f137434e);
                bVar.f137429c.f137437a = f16;
                return f16;
            case 1:
                i o16 = i.o();
                b.a aVar = bVar.f137428b;
                boolean b16 = o16.b(aVar.f137431b, aVar.f137434e);
                bVar.f137429c.f137437a = b16;
                return b16;
            case 2:
                boolean x16 = i.o().x(bVar.f137428b.f137431b);
                bVar.f137429c.f137437a = x16;
                return x16;
            case 3:
                boolean D = i.o().D(bVar.f137428b.f137431b);
                bVar.f137429c.f137437a = D;
                return D;
            case 4:
                i o17 = i.o();
                b.a aVar2 = bVar.f137428b;
                boolean b17 = o17.b(aVar2.f137431b, aVar2.f137433d);
                bVar.f137429c.f137437a = b17;
                return b17;
            case 5:
                boolean j3 = i.o().j(bVar.f137428b.f137431b);
                bVar.f137429c.f137437a = j3;
                return j3;
            case 6:
                bVar.f137429c.f137439c = i.o().o(bVar.f137428b.f137431b);
                return true;
            case 7:
                boolean s16 = i.o().s(bVar.f137428b.f137431b);
                bVar.f137429c.f137437a = s16;
                return s16;
            case 8:
                boolean u16 = i.o().u(bVar.f137428b.f137431b);
                bVar.f137429c.f137437a = u16;
                return u16;
            case 9:
                i.o().e(bVar.f137428b.f137432c);
                return true;
            case 10:
                i o18 = i.o();
                b.a aVar3 = bVar.f137428b;
                bVar.f137428b.f137431b = o18.a(aVar3.f137432c, aVar3.f137431b);
                return true;
            case 11:
                bVar.f137429c.f137438b = i.o().n(bVar.f137428b.f137432c);
                return true;
            case 12:
                i.o().w(bVar.f137428b.f137432c);
                return true;
            case 13:
                boolean p16 = i.o().p(bVar.f137428b.f137431b);
                bVar.f137429c.f137437a = p16;
                return p16;
            case 14:
                boolean E = i.o().E(bVar.f137428b.f137431b);
                bVar.f137429c.f137437a = E;
                return E;
            case 15:
                i.o().g(bVar.f137428b.f137435f);
                return true;
            case 16:
                bVar.f137428b.f137434e = i.o().l(bVar.f137428b.f137431b);
                return true;
            case 17:
                boolean v3 = i.o().v(bVar.f137428b.f137431b);
                bVar.f137429c.f137437a = v3;
                return v3;
            case 18:
                boolean e16 = i.o().e(bVar.f137428b.f137434e);
                bVar.f137429c.f137437a = e16;
                return e16;
            case 19:
                boolean a16 = i.o().a(bVar.f137428b.f137436g);
                bVar.f137429c.f137437a = a16;
                return a16;
            case 20:
                bVar.f137429c.f137440d = i.o().j();
                return true;
            default:
                return true;
        }
    }

    public static com.tencent.luggage.wxa.qb.e a() {
        return i.o().k();
    }
}
