package km2;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements g {
    private boolean b(com.tencent.mobileqq.richmedia.particlesystem.a aVar) {
        jm2.b bVar = aVar.f281699u;
        if (bVar.f410605b > bVar.f410606c + bVar.f410607d) {
            return true;
        }
        return false;
    }

    private void c(com.tencent.mobileqq.richmedia.particlesystem.a aVar, int i3) {
        float f16;
        jm2.b bVar = aVar.f281699u;
        long j3 = bVar.f410606c;
        long j16 = bVar.f410605b + i3;
        bVar.f410605b = j16;
        if (j16 < j3) {
            return;
        }
        float f17 = (((float) (j16 - j3)) * 1.0f) / ((float) bVar.f410607d);
        if (f17 > 1.0f) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f - f17;
        }
        aVar.f281689k = Math.max(0.0f, f16);
    }

    @Override // km2.g
    public void a(com.tencent.mobileqq.richmedia.particlesystem.a aVar, jm2.a aVar2, int i3) {
        c(aVar, i3);
        jm2.b bVar = aVar.f281699u;
        if (b(aVar)) {
            bVar.f410604a = 3;
        }
    }
}
