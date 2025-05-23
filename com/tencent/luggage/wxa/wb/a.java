package com.tencent.luggage.wxa.wb;

import com.tencent.luggage.wxa.hn.s8;
import com.tencent.luggage.wxa.hn.t8;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6874a {
        int a(c cVar, b bVar, a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(int i3, int i16, String str, a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final C6875a f144157a = C6875a.f144158a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.wb.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6875a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ C6875a f144158a = new C6875a();

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.wb.a$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6876a implements c {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ s8 f144159b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ t8 f144160c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ int f144161d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ String f144162e;

                public C6876a(s8 s8Var, t8 t8Var, int i3, String str) {
                    this.f144159b = s8Var;
                    this.f144160c = t8Var;
                    this.f144161d = i3;
                    this.f144162e = str;
                }

                @Override // com.tencent.luggage.wxa.wb.a.c
                public s8 a() {
                    return this.f144159b;
                }

                @Override // com.tencent.luggage.wxa.wb.a.c
                public t8 b() {
                    return this.f144160c;
                }

                @Override // com.tencent.luggage.wxa.wb.a.c
                public String getUri() {
                    return this.f144162e;
                }
            }

            public final c a(s8 request, t8 response, int i3, String uri) {
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(response, "response");
                Intrinsics.checkNotNullParameter(uri, "uri");
                return new C6876a(request, response, i3, uri);
            }
        }

        s8 a();

        t8 b();

        String getUri();
    }
}
