package pm2;

import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    int f426473a = 0;

    /* renamed from: b, reason: collision with root package name */
    a f426474b = null;

    /* renamed from: c, reason: collision with root package name */
    final C11029b f426475c = new C11029b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a extends pm2.a {

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        public final b f426476d;

        /* renamed from: e, reason: collision with root package name */
        public a f426477e = null;

        public a(@NonNull b bVar) {
            this.f426476d = bVar;
        }

        @Override // pm2.a
        public void a() {
            super.a();
            this.f426476d.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: pm2.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static class C11029b {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f426478a = new AtomicBoolean(false);

        C11029b() {
        }

        public void a() {
            do {
            } while (!this.f426478a.compareAndSet(false, true));
        }

        public void b() {
            this.f426478a.set(false);
        }
    }

    public synchronized void a() {
        this.f426475c.a();
        this.f426474b = null;
        this.f426473a = 0;
        this.f426475c.b();
    }

    public pm2.a b() {
        this.f426475c.a();
        try {
            a aVar = this.f426474b;
            if (aVar != null) {
                this.f426474b = aVar.f426477e;
                this.f426473a--;
                return aVar;
            }
            this.f426475c.b();
            return new a(this);
        } finally {
            this.f426475c.b();
        }
    }

    void c(a aVar) {
        if (aVar == null || this.f426473a > 1000) {
            return;
        }
        this.f426475c.a();
        aVar.f426477e = this.f426474b;
        this.f426474b = aVar;
        this.f426473a++;
        this.f426475c.b();
    }
}
