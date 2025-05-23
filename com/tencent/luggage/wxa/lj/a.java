package com.tencent.luggage.wxa.lj;

import com.tencent.luggage.wxa.lj.j;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.lj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC6443a {
        TRADE,
        KOUBEI
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum c {
        NORMAL(-1, -1),
        LBS(R.string.f16380244, R.drawable.f160302og1),
        VOICE(R.string.f16382246, R.drawable.f160304og3),
        CAMERA(R.string.f16381245, R.drawable.f160303og2),
        LOADING(-1, -1);


        /* renamed from: a, reason: collision with root package name */
        public final int f133432a;

        /* renamed from: b, reason: collision with root package name */
        public final int f133433b;

        c(int i3, int i16) {
            this.f133432a = i3;
            this.f133433b = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public enum d {
        HIGH,
        LOW,
        TAIL
    }

    int a();

    j.b a(c cVar);

    int b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f133425a = new C6444a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.lj.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6444a implements a {
            @Override // com.tencent.luggage.wxa.lj.a
            public int a() {
                return Integer.MIN_VALUE;
            }

            @Override // com.tencent.luggage.wxa.lj.a
            public int b() {
                return Integer.MIN_VALUE;
            }

            @Override // com.tencent.luggage.wxa.lj.a
            public j.b a(c cVar) {
                return j.f133495s;
            }
        }

        public static a a(com.tencent.luggage.wxa.ic.g gVar) {
            if (gVar != null && !gVar.t0() && !gVar.w0()) {
                return gVar.I().c();
            }
            return f133425a;
        }

        public static a a(com.tencent.luggage.wxa.ic.g gVar, j.b bVar) {
            return new com.tencent.luggage.wxa.lj.b(gVar, bVar);
        }
    }
}
