package nm2;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import km2.g;
import km2.h;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    public float[] a(mm2.c cVar, mm2.b bVar, int i3, int i16) {
        float[] fArr = new float[2];
        int i17 = cVar.f416999d;
        float f16 = i17 * 0.5f;
        if (i3 >= i17) {
            fArr[0] = f16 + (bVar.f416976g * (i3 - i17));
        } else {
            fArr[0] = f16 - (bVar.f416976g * (i17 - i3));
        }
        int i18 = cVar.f417000e;
        float f17 = i18 * 0.5f;
        if (i16 >= i18) {
            fArr[1] = f17 + (bVar.f416977h * (i16 - i18));
        } else {
            fArr[1] = f17 - (bVar.f416977h * (i18 - i16));
        }
        return fArr;
    }

    public g b(com.tencent.mobileqq.richmedia.particlesystem.c cVar, mm2.b bVar) {
        km2.c cVar2 = new km2.c();
        cVar2.c(new h());
        cVar2.c(new km2.d());
        cVar2.c(new km2.a());
        if (bVar.b()) {
            km2.e eVar = new km2.e(cVar.m());
            eVar.c(bVar.f416974e);
            cVar2.c(eVar);
        }
        return cVar2;
    }

    public List<a> c(com.tencent.mobileqq.richmedia.particlesystem.c cVar, mm2.a aVar, int i3, int i16) {
        c cVar2 = this;
        int i17 = i3;
        if (aVar == null) {
            lm2.c.b("EmitterBuilder", "createEmitterFromConfig, data is empty");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<mm2.b> it = aVar.f416969b.iterator();
        while (it.hasNext()) {
            mm2.b next = it.next();
            if (next.I == null) {
                lm2.c.b("EmitterFactory", "createEmitterFromConfig, emitter images is null");
            } else {
                g b16 = cVar2.b(cVar, next);
                float f16 = next.f416976g;
                float f17 = next.f416977h;
                float f18 = next.f416978i;
                float f19 = next.f416979j;
                float f26 = next.f416980k;
                int i18 = next.f416975f;
                Iterator<mm2.b> it5 = it;
                int i19 = 3;
                if (i18 == 1 || i18 == 3) {
                    float f27 = i17;
                    f16 *= f27;
                    float f28 = i16;
                    f17 *= f28;
                    f19 *= f27;
                    f26 *= f28;
                }
                float f29 = f19;
                float f36 = f26;
                lm2.c.b("EmitterFactory", "createEmitterFromConfig: " + f16 + "," + f17 + "," + f29 + "," + f36);
                Iterator<mm2.c> it6 = next.I.iterator();
                while (it6.hasNext()) {
                    mm2.c next2 = it6.next();
                    om2.g d16 = cVar2.d(cVar.k(), next2);
                    if (d16 == null) {
                        lm2.c.b("EmitterFactory", "createEmitterFromConfig, emitter bitmap is null");
                    } else {
                        Iterator<mm2.c> it7 = it6;
                        if (next.f416975f == i19) {
                            float[] a16 = cVar2.a(next2, next, i17, i16);
                            f16 = a16[0];
                            f17 = a16[1];
                        }
                        b bVar = new b();
                        float f37 = f36;
                        float f38 = f18;
                        bVar.C(next.f416984o).B(next.f416983n).A(next.f416985p).j(next2.f416999d).i(next2.f417000e).w(next.f416988s).y(next.f416990u).x(next.f416989t).c(next.f416987r).b(next.f416986q).e(next.f416982m).f(next.f416981l).s(lm2.e.a(next.f416991v)).t(lm2.e.a(next.f416992w)).u(lm2.e.a(next.f416993x)).k(lm2.e.a(next.f416994y)).l(lm2.e.a(next.f416995z)).m(lm2.e.a(next.A)).o(lm2.e.a(next.B)).p(lm2.e.a(next.C)).q(lm2.e.a(next.D)).n(lm2.e.a(next.E)).r(lm2.e.a(next.F)).v(lm2.e.a(next.G)).z(lm2.e.a(next.H)).D(next2.f417003h).g(f16, f17, f18, f29, f37).h(d16).d(b16);
                        e a17 = bVar.a();
                        if (next.a()) {
                            int i26 = next2.f417002g;
                            if (i26 <= 0) {
                                i26 = next.f416973d;
                            }
                            arrayList.add(new f(a17, i26, next.f416971b));
                        } else {
                            arrayList.add(new d(a17, next.f416972c, next.f416971b));
                        }
                        cVar2 = this;
                        f36 = f37;
                        it6 = it7;
                        f18 = f38;
                        i19 = 3;
                        i17 = i3;
                    }
                }
                cVar2 = this;
                it = it5;
                i17 = i3;
            }
        }
        lm2.c.b("EmitterFactory", "createEmitterFromConfig: " + arrayList);
        return arrayList;
    }

    @Nullable
    om2.g d(Context context, mm2.c cVar) {
        om2.g gVar;
        int i3 = cVar.f416996a;
        if (i3 == 1) {
            gVar = om2.h.c(cVar.f416997b);
        } else if (i3 == 2) {
            gVar = om2.h.a(cVar.f416997b);
        } else if (i3 == 3) {
            gVar = om2.h.b(context, cVar.f416997b, cVar.f416999d, cVar.f417000e);
        } else {
            gVar = null;
        }
        if (gVar == null) {
            lm2.c.c("EmitterBuilder", "create bitmap fail, type=" + cVar.f416996a + ", path=" + cVar.f416997b);
            return null;
        }
        return gVar;
    }
}
