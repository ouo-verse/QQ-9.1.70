package com.tencent.luggage.wxa.ef;

import android.os.Looper;
import com.tencent.luggage.wxa.lj.a;
import com.tencent.luggage.wxa.lj.j;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public j.b f124705b;

    /* renamed from: d, reason: collision with root package name */
    public Runnable f124707d;

    /* renamed from: a, reason: collision with root package name */
    public long f124704a = 0;

    /* renamed from: c, reason: collision with root package name */
    public final b0 f124706c = new b0(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f124708a;

        public a(com.tencent.luggage.wxa.ic.g gVar) {
            this.f124708a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f124707d != null) {
                m.this.f124706c.b(m.this.f124707d);
                m.this.f124707d = null;
            }
            if (m.this.f124705b != null) {
                m.this.f124704a = System.currentTimeMillis();
            } else {
                m.this.f124705b = a.b.a(this.f124708a).a(a.c.LBS);
                m.this.f124704a = System.currentTimeMillis();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (m.this.f124705b != null) {
                    m.this.f124705b.c();
                    m.this.f124705b = null;
                }
                m.this.f124707d = null;
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f124705b == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - m.this.f124704a;
            if (currentTimeMillis < 3000) {
                if (m.this.f124707d != null) {
                    m.this.f124706c.b(m.this.f124707d);
                }
                m.this.f124707d = new a();
                m.this.f124706c.a(m.this.f124707d, 3000 - currentTimeMillis);
                return;
            }
            m.this.f124705b.c();
            m.this.f124705b = null;
            m.this.f124707d = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f124707d != null) {
                m.this.f124706c.b(m.this.f124707d);
                m.this.f124707d = null;
            }
            if (m.this.f124705b != null) {
                m.this.f124705b.c();
                m.this.f124705b = null;
            }
        }
    }

    public void b(com.tencent.luggage.wxa.ic.g gVar) {
        w.d("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitle");
        com.tencent.luggage.wxa.tk.l.a(new b());
    }

    public void a(com.tencent.luggage.wxa.ic.g gVar) {
        w.d("MicroMsg.LbsBlinkHelper", "startBlinkSubTitle");
        com.tencent.luggage.wxa.tk.l.a(new a(gVar));
    }

    public void a() {
        w.d("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitleImmediately");
        com.tencent.luggage.wxa.tk.l.a(new c());
    }
}
