package com.qzone.jbox2d.collision;

import com.qzone.jbox2d.collision.b;
import com.qzone.jbox2d.common.Sweep;
import com.qzone.jbox2d.common.Transform;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TimeOfImpact {

    /* renamed from: k, reason: collision with root package name */
    public static int f47964k;

    /* renamed from: l, reason: collision with root package name */
    public static int f47965l;

    /* renamed from: m, reason: collision with root package name */
    public static int f47966m;

    /* renamed from: n, reason: collision with root package name */
    public static int f47967n;

    /* renamed from: o, reason: collision with root package name */
    public static int f47968o;

    /* renamed from: a, reason: collision with root package name */
    private final b.d f47969a = new b.d();

    /* renamed from: b, reason: collision with root package name */
    private final c f47970b = new c();

    /* renamed from: c, reason: collision with root package name */
    private final Transform f47971c = new Transform();

    /* renamed from: d, reason: collision with root package name */
    private final Transform f47972d = new Transform();

    /* renamed from: e, reason: collision with root package name */
    private final d f47973e = new d();

    /* renamed from: f, reason: collision with root package name */
    private final h f47974f = new h();

    /* renamed from: g, reason: collision with root package name */
    private final int[] f47975g = new int[2];

    /* renamed from: h, reason: collision with root package name */
    private final Sweep f47976h = new Sweep();

    /* renamed from: i, reason: collision with root package name */
    private final Sweep f47977i = new Sweep();

    /* renamed from: j, reason: collision with root package name */
    private final k7.b f47978j;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public enum TOIOutputState {
        UNKNOWN,
        FAILED,
        OVERLAPPED,
        TOUCHING,
        SEPARATED
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final b.C0398b f47979a = new b.C0398b();

        /* renamed from: b, reason: collision with root package name */
        public final b.C0398b f47980b = new b.C0398b();

        /* renamed from: c, reason: collision with root package name */
        public final Sweep f47981c = new Sweep();

        /* renamed from: d, reason: collision with root package name */
        public final Sweep f47982d = new Sweep();

        /* renamed from: e, reason: collision with root package name */
        public float f47983e;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public TOIOutputState f47984a;

        /* renamed from: b, reason: collision with root package name */
        public float f47985b;
    }

    public TimeOfImpact(k7.b bVar) {
        this.f47978j = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x016e, code lost:
    
        r10 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00df, code lost:
    
        r11 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009e, code lost:
    
        r2 = r16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(b bVar, a aVar) {
        int i3;
        b.C0398b c0398b;
        int i16;
        float f16;
        TimeOfImpact timeOfImpact = this;
        int i17 = 1;
        f47964k++;
        bVar.f47984a = TOIOutputState.UNKNOWN;
        bVar.f47985b = aVar.f47983e;
        b.C0398b c0398b2 = aVar.f47979a;
        b.C0398b c0398b3 = aVar.f47980b;
        timeOfImpact.f47976h.set(aVar.f47981c);
        timeOfImpact.f47977i.set(aVar.f47982d);
        timeOfImpact.f47976h.normalize();
        timeOfImpact.f47977i.normalize();
        float f17 = aVar.f47983e;
        float f18 = c0398b2.f48001c + c0398b3.f48001c;
        float f19 = com.qzone.jbox2d.common.d.f48145m;
        float j3 = com.qzone.jbox2d.common.b.j(f19, f18 - (3.0f * f19));
        float f26 = com.qzone.jbox2d.common.d.f48145m * 0.25f;
        int i18 = 0;
        timeOfImpact.f47969a.f48020b = 0;
        c cVar = timeOfImpact.f47970b;
        cVar.f48030a = aVar.f47979a;
        cVar.f48031b = aVar.f47980b;
        cVar.f48034e = false;
        float f27 = 0.0f;
        float f28 = 0.0f;
        int i19 = 0;
        while (true) {
            timeOfImpact.f47976h.getTransform(timeOfImpact.f47971c, f28);
            timeOfImpact.f47977i.getTransform(timeOfImpact.f47972d, f28);
            c cVar2 = timeOfImpact.f47970b;
            cVar2.f48032c = timeOfImpact.f47971c;
            cVar2.f48033d = timeOfImpact.f47972d;
            timeOfImpact.f47978j.getDistance().a(timeOfImpact.f47973e, timeOfImpact.f47969a, timeOfImpact.f47970b);
            float f29 = timeOfImpact.f47973e.f48037c;
            if (f29 > f27) {
                float f36 = j3 + f26;
                if (f29 < f36) {
                    bVar.f47984a = TOIOutputState.TOUCHING;
                    bVar.f47985b = f28;
                    break;
                }
                float f37 = f28;
                int i26 = i18;
                timeOfImpact.f47974f.c(timeOfImpact.f47969a, c0398b2, timeOfImpact.f47976h, c0398b3, timeOfImpact.f47977i, f37);
                f28 = f17;
                int i27 = i26;
                while (true) {
                    float b16 = timeOfImpact.f47974f.b(timeOfImpact.f47975g, f28);
                    if (b16 > f36) {
                        bVar.f47984a = TOIOutputState.SEPARATED;
                        bVar.f47985b = f17;
                        f28 = f37;
                        break;
                    }
                    float f38 = j3 - f26;
                    if (b16 > f38) {
                        c0398b = c0398b2;
                        i16 = i17;
                        break;
                    }
                    h hVar = timeOfImpact.f47974f;
                    int[] iArr = timeOfImpact.f47975g;
                    f16 = f37;
                    float a16 = hVar.a(iArr[i26], iArr[i17], f16);
                    if (a16 < f38) {
                        bVar.f47984a = TOIOutputState.FAILED;
                        bVar.f47985b = f16;
                        break;
                    }
                    if (a16 <= f36) {
                        bVar.f47984a = TOIOutputState.TOUCHING;
                        bVar.f47985b = f16;
                        break;
                    }
                    float f39 = f16;
                    float f46 = f28;
                    int i28 = i26;
                    while (true) {
                        f37 = f16;
                        float f47 = (i28 & 1) == i17 ? (((j3 - a16) * (f46 - f39)) / (b16 - a16)) + f39 : 0.5f * (f39 + f46);
                        i28++;
                        f47967n++;
                        h hVar2 = timeOfImpact.f47974f;
                        c0398b = c0398b2;
                        int[] iArr2 = timeOfImpact.f47975g;
                        float a17 = hVar2.a(iArr2[i26], iArr2[1], f47);
                        if (com.qzone.jbox2d.common.b.a(a17 - j3) < f26) {
                            f28 = f47;
                            break;
                        }
                        if (a17 > j3) {
                            a16 = a17;
                            f39 = f47;
                        } else {
                            b16 = a17;
                            f46 = f47;
                        }
                        if (i28 == 50) {
                            break;
                        }
                        timeOfImpact = this;
                        f16 = f37;
                        c0398b2 = c0398b;
                        i17 = 1;
                    }
                    f47968o = com.qzone.jbox2d.common.b.k(f47968o, i28);
                    i16 = 1;
                    i27++;
                    if (i27 == com.qzone.jbox2d.common.d.f48142j || i28 == 50) {
                        break;
                    }
                    i17 = 1;
                    c0398b2 = c0398b;
                    timeOfImpact = this;
                }
                f28 = f16;
                c0398b = c0398b2;
                i16 = i17;
                int i29 = i16;
                i3 = i19 + 1;
                f47965l += i16;
                if (i29 != 0) {
                    break;
                }
                if (i3 == 20) {
                    bVar.f47984a = TOIOutputState.FAILED;
                    bVar.f47985b = f28;
                    break;
                }
                i17 = i16;
                i19 = i3;
                i18 = i26;
                c0398b2 = c0398b;
                f27 = 0.0f;
                timeOfImpact = this;
            } else {
                bVar.f47984a = TOIOutputState.OVERLAPPED;
                bVar.f47985b = f27;
                break;
            }
        }
        f47966m = com.qzone.jbox2d.common.b.k(f47966m, i3);
    }
}
