package com.tencent.luggage.wxa.ck;

import com.tencent.luggage.wxa.kj.k1;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface g extends f {

    /* renamed from: a, reason: collision with root package name */
    public static final g f123598a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements g {
        @Override // com.tencent.luggage.wxa.ck.g
        public b a(com.tencent.luggage.wxa.m4.b bVar) {
            return null;
        }

        @Override // com.tencent.luggage.wxa.ck.g
        public b peek() {
            return null;
        }

        @Override // com.tencent.luggage.wxa.ck.f
        public void a(com.tencent.luggage.wxa.m4.b bVar, com.tencent.luggage.wxa.m4.b bVar2, k1 k1Var) {
        }

        @Override // com.tencent.luggage.wxa.ck.g
        public boolean a(String str) {
            return false;
        }

        @Override // com.tencent.luggage.wxa.ck.f
        public void c(com.tencent.luggage.wxa.m4.b bVar) {
        }

        @Override // com.tencent.luggage.wxa.ck.f
        public void d(com.tencent.luggage.wxa.m4.b bVar) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f123599a;

        /* renamed from: b, reason: collision with root package name */
        public String f123600b;

        /* renamed from: c, reason: collision with root package name */
        public d f123601c;

        /* renamed from: d, reason: collision with root package name */
        public c f123602d;

        public b(com.tencent.luggage.wxa.m4.b bVar) {
            this.f123599a = bVar.hashCode();
            this.f123600b = bVar.B0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f123603a;

        public c(String str) {
            this.f123603a = str;
        }
    }

    b a(com.tencent.luggage.wxa.m4.b bVar);

    boolean a(String str);

    b peek();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f123604a;

        /* renamed from: b, reason: collision with root package name */
        public String f123605b;

        public d(int i3, String str) {
            this.f123604a = i3;
            this.f123605b = str;
        }

        public d(int i3) {
            this(i3, null);
        }
    }
}
