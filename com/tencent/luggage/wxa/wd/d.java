package com.tencent.luggage.wxa.wd;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.ka.i;
import com.tencent.luggage.wxa.ka.o;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.zp.h;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final f f144188a;

    /* renamed from: b, reason: collision with root package name */
    public final b f144189b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.wd.e f144190a;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements i {

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.wd.d$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class RunnableC6881a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Parcelable f144193a;

                public RunnableC6881a(Parcelable parcelable) {
                    this.f144193a = parcelable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    d.b(this.f144193a, d.this);
                    d.this.g();
                }
            }

            public a() {
            }

            @Override // com.tencent.luggage.wxa.ka.i
            public void a(Parcelable parcelable) {
                h.f146825d.a(new RunnableC6881a(parcelable));
            }
        }

        public b() {
            this.f144190a = new com.tencent.luggage.wxa.wd.e(new a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c implements com.tencent.luggage.wxa.ka.f {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f144195a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f144196b;

            public a(i iVar, d dVar) {
                this.f144195a = iVar;
                this.f144196b = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                i iVar = this.f144195a;
                if (iVar == null) {
                    return;
                }
                iVar.a(this.f144196b);
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f144198a;

            public b(d dVar) {
                this.f144198a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f144198a.h();
            }
        }

        c() {
        }

        @Override // com.tencent.luggage.wxa.ka.f
        public void a(d dVar, i iVar) {
            dVar.a(new a(iVar, dVar));
            h.f146825d.b(new b(dVar), "MicroMsg.AppBrand.MainProcessTask");
        }
    }

    /* compiled from: P */
    @com.tencent.luggage.wxa.na.a
    /* renamed from: com.tencent.luggage.wxa.wd.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6882d extends c implements com.tencent.luggage.wxa.ka.e<d, Parcelable> {
        C6882d() {
            super();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class e implements r {
        e() {
        }

        @Override // com.tencent.luggage.wxa.ka.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d invoke(d dVar) {
            dVar.h();
            return dVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public transient Runnable f144200a;

        public f() {
            this.f144200a = null;
        }
    }

    public d() {
        this.f144188a = new f();
        this.f144189b = new b();
    }

    public static void b(Parcelable parcelable, d dVar) {
        if (parcelable == null) {
            return;
        }
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        dVar.a(obtain);
        OaidMonitor.parcelRecycle(obtain);
    }

    public void a(Parcel parcel) {
    }

    public final boolean c() {
        Parcelable a16;
        if (!o.a(z.g()) || (a16 = o.a(z.g(), this, e.class)) == null) {
            return false;
        }
        b(a16, this);
        g();
        return true;
    }

    public final boolean d() {
        return com.tencent.luggage.wxa.ta.a.a(getClass(), com.tencent.luggage.wxa.wd.f.class);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public final void f() {
        this.f144189b.f144190a.a((i) null);
    }

    public abstract void h();

    public final void a(Runnable runnable) {
        this.f144188a.f144200a = runnable;
    }

    public final boolean a() {
        Runnable runnable = this.f144188a.f144200a;
        if (runnable == null) {
            return true;
        }
        runnable.run();
        return true;
    }

    public final void b() {
        if (d()) {
            o.a(z.g(), this, C6882d.class, null, "MicroMsg.AppBrand.MainProcessTask");
        } else {
            o.a(z.g(), this, c.class, this.f144189b.f144190a, "MicroMsg.AppBrand.MainProcessTask");
        }
    }

    @Deprecated
    public final void e() {
    }

    public void g() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
    }
}
