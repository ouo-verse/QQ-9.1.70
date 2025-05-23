package com.tencent.luggage.wxa.qg;

import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface l extends t {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends a {
        public b(String str, IOException iOException, com.tencent.luggage.wxa.qg.g gVar) {
            super(str, iOException, gVar);
        }

        public b(String str, com.tencent.luggage.wxa.qg.g gVar) {
            super(str, gVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends a {
        public c(String str, com.tencent.luggage.wxa.qg.g gVar) {
            super(str, gVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends a {
        public d(String str, com.tencent.luggage.wxa.qg.g gVar) {
            super(str, gVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends a {

        /* renamed from: b, reason: collision with root package name */
        public final String f138760b;

        /* renamed from: c, reason: collision with root package name */
        public final Map f138761c;

        public e(String str, Map map, com.tencent.luggage.wxa.qg.g gVar) {
            super("Invalid content type: " + str, gVar);
            this.f138760b = str;
            this.f138761c = map;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends a {

        /* renamed from: b, reason: collision with root package name */
        public final int f138762b;

        /* renamed from: c, reason: collision with root package name */
        public final Map f138763c;

        public f(int i3, Map map, com.tencent.luggage.wxa.qg.g gVar) {
            super("Response code: " + i3, gVar);
            this.f138762b = i3;
            this.f138763c = map;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g extends a {
        public g(String str, com.tencent.luggage.wxa.qg.g gVar) {
            super(str, gVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h extends a {
        public h(String str, IOException iOException, com.tencent.luggage.wxa.qg.g gVar) {
            super(str, iOException, gVar);
        }
    }

    Map a();

    com.tencent.luggage.wxa.tg.i b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends IOException {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.qg.g f138759a;

        public a(String str, com.tencent.luggage.wxa.qg.g gVar) {
            super(str);
            this.f138759a = gVar;
        }

        public a(IOException iOException, com.tencent.luggage.wxa.qg.g gVar) {
            super(iOException);
            this.f138759a = gVar;
        }

        public a(String str, IOException iOException, com.tencent.luggage.wxa.qg.g gVar) {
            super(str, iOException);
            this.f138759a = gVar;
        }
    }
}
