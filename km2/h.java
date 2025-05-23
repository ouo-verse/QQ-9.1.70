package km2;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h implements g {
    private boolean b(com.tencent.mobileqq.richmedia.particlesystem.a aVar, jm2.a aVar2) {
        int i3 = aVar.f281681c;
        int i16 = aVar.f281680b;
        float f16 = aVar.f281683e;
        float f17 = aVar.f281682d;
        float f18 = aVar.f281685g;
        float f19 = aVar.f281686h;
        int i17 = aVar2.i1();
        if (f16 > aVar2.K() && f19 > 0.0f) {
            return true;
        }
        if (f16 + i3 < 0.0f && f19 < 0.0f) {
            return true;
        }
        if (i16 + f17 < 0.0f && f18 < 0.0f) {
            return true;
        }
        if (f17 > i17 && f18 > 0.0f) {
            return true;
        }
        return false;
    }

    private void c(@NonNull com.tencent.mobileqq.richmedia.particlesystem.a aVar, int i3) {
        float f16 = aVar.f281687i;
        float f17 = aVar.f281685g;
        if (f16 != 0.0f) {
            float f18 = (f16 * i3) / 1000.0f;
            aVar.f281685g = f17 + f18;
            f17 = (f18 / 2.0f) + f17;
        }
        aVar.f281682d += (f17 * i3) / 1000.0f;
    }

    private void d(com.tencent.mobileqq.richmedia.particlesystem.a aVar, int i3) {
        float f16 = aVar.f281688j;
        float f17 = aVar.f281686h;
        if (f16 != 0.0f) {
            float f18 = (f16 * i3) / 1000.0f;
            aVar.f281686h = f17 + f18;
            f17 = (f18 / 2.0f) + f17;
        }
        aVar.f281683e += (f17 * i3) / 1000.0f;
    }

    private void e(@NonNull com.tencent.mobileqq.richmedia.particlesystem.a aVar, int i3) {
        float f16 = aVar.f281696r;
        if (f16 != 0.0f) {
            aVar.f281693o += (f16 * i3) / 1000.0f;
        }
        float f17 = aVar.f281697s;
        if (f17 != 0.0f) {
            aVar.f281694p += (f17 * i3) / 1000.0f;
        }
        float f18 = aVar.f281698t;
        if (f18 != 0.0f) {
            aVar.f281695q += (f18 * i3) / 1000.0f;
        }
    }

    private void f(@NonNull com.tencent.mobileqq.richmedia.particlesystem.a aVar, int i3) {
        float f16 = aVar.f281692n;
        if (f16 != 0.0f) {
            aVar.f281691m += (f16 * i3) / 1000.0f;
        }
    }

    @Override // km2.g
    public void a(com.tencent.mobileqq.richmedia.particlesystem.a aVar, jm2.a aVar2, int i3) {
        jm2.b bVar = aVar.f281699u;
        c(aVar, i3);
        d(aVar, i3);
        f(aVar, i3);
        e(aVar, i3);
        if (b(aVar, aVar2)) {
            bVar.f410604a = 3;
        }
    }
}
