package com.tencent.luggage.wxa.j4;

import com.tencent.luggage.wxa.tn.w0;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface l {

    /* renamed from: b, reason: collision with root package name */
    public static final l f130851b = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements l {
        @Override // com.tencent.luggage.wxa.j4.l
        public /* synthetic */ String a() {
            return w21.c.a(this);
        }

        @Override // com.tencent.luggage.wxa.j4.l
        public /* synthetic */ String a(com.tencent.luggage.wxa.ki.a aVar) {
            return w21.c.b(this, aVar);
        }

        @Override // com.tencent.luggage.wxa.j4.l
        public String a(d dVar) {
            return "SessionId@" + hashCode() + "#" + w0.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static l f130852a;
    }

    String a();

    String a(d dVar);

    String a(com.tencent.luggage.wxa.ki.a aVar);
}
