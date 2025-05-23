package com.tencent.luggage.wxa.co;

import com.tencent.luggage.wxa.jq.e;
import com.tencent.luggage.wxa.jq.g;
import com.tencent.luggage.wxa.zp.h;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f123718a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ boolean f123719b = true;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.co.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6118a implements g, e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f123720a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f123721b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f123722c;

        public C6118a(boolean z16, String str, Runnable runnable) {
            this.f123720a = z16;
            this.f123721b = str;
            this.f123722c = runnable;
        }

        @Override // com.tencent.luggage.wxa.jq.e
        public boolean a() {
            return this.f123720a;
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return this.f123721b;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f123722c.run();
        }
    }

    public void a(Runnable runnable, String str, boolean z16) {
        if (!f123719b && runnable == null) {
            throw new AssertionError();
        }
        h.f146825d.execute(new C6118a(z16, str, runnable));
    }

    public static void a(Runnable runnable, String str) {
        f123718a.a(runnable, str, true);
    }

    public static void a(Runnable runnable, String str, int i3) {
        f123718a.a(runnable, str, true);
    }
}
