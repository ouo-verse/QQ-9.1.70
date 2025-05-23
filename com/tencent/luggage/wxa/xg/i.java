package com.tencent.luggage.wxa.xg;

import android.os.Handler;

/* compiled from: P */
/* loaded from: classes9.dex */
public class i {

    /* renamed from: c, reason: collision with root package name */
    public Handler f144934c;

    /* renamed from: d, reason: collision with root package name */
    public c f144935d;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f144932a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f144933b = 1000;

    /* renamed from: e, reason: collision with root package name */
    public b f144936e = new b();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public b() {
        }

        public void a() {
            i.this.f144934c.postDelayed(i.this.f144936e, i.this.f144933b);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i.this.f144935d != null) {
                i.this.f144935d.a();
            }
            if (i.this.f144932a) {
                a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a();
    }

    public i(Handler handler) {
        this.f144934c = handler;
    }

    public void a(int i3) {
        this.f144933b = i3;
    }

    public void b() {
        this.f144932a = false;
    }

    public void a(c cVar) {
        this.f144935d = cVar;
    }

    public void a() {
        if (this.f144932a) {
            return;
        }
        this.f144932a = true;
        this.f144936e.a();
    }
}
