package com.tencent.luggage.wxa.x0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mobileqq.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e extends com.tencent.luggage.wxa.a1.b {

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.x0.a f144464b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.y0.b f144465c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f144466d = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((g) e.this.b()).a(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements com.tencent.luggage.wxa.a1.c {

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f144469a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f144470b;

            public a(List list, List list2) {
                this.f144469a = list;
                this.f144470b = list2;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isEmpty;
                ((g) e.this.b()).a(this.f144469a, this.f144470b);
                List list = this.f144470b;
                if (list != null) {
                    isEmpty = list.isEmpty();
                } else {
                    isEmpty = this.f144469a.isEmpty();
                }
                if (isEmpty) {
                    ((g) e.this.b()).a();
                } else {
                    ((g) e.this.b()).a(false);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.x0.e$b$b, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC6895b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Throwable f144472a;

            public RunnableC6895b(Throwable th5) {
                this.f144472a = th5;
            }

            @Override // java.lang.Runnable
            public void run() {
                ((g) e.this.b()).a(this.f144472a);
            }
        }

        public b() {
        }

        @Override // com.tencent.luggage.wxa.a1.c
        public void a(List list, List list2) {
            e.this.a(new a(list, list2));
        }

        @Override // com.tencent.luggage.wxa.a1.c
        public void onFailed(Throwable th5) {
            e.this.a(new RunnableC6895b(th5));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements com.tencent.luggage.wxa.y0.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.a1.a f144474a;

        public c(com.tencent.luggage.wxa.a1.a aVar) {
            this.f144474a = aVar;
        }

        @Override // com.tencent.luggage.wxa.y0.c
        public void a(List list) {
            if (com.tencent.luggage.wxa.d1.a.a(this.f144474a, true)) {
                ((g) e.this.b()).a(list);
            } else {
                ((g) e.this.b()).d();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f144476a;

        public d(Runnable runnable) {
            this.f144476a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.c()) {
                this.f144476a.run();
            }
        }
    }

    public e(com.tencent.luggage.wxa.x0.a aVar) {
        this.f144464b = aVar;
    }

    public void d() {
        f().a();
    }

    public void e() {
        this.f144464b.a();
    }

    public com.tencent.luggage.wxa.y0.b f() {
        if (this.f144465c == null) {
            this.f144465c = new com.tencent.luggage.wxa.y0.b();
        }
        return this.f144465c;
    }

    public void a(com.tencent.luggage.wxa.y0.b bVar) {
        this.f144465c = bVar;
    }

    public void a(com.tencent.luggage.wxa.x0.c cVar) {
        if (c()) {
            boolean n3 = cVar.n();
            boolean o16 = cVar.o();
            boolean p16 = cVar.p();
            ArrayList e16 = cVar.e();
            a(new a());
            this.f144464b.a(n3, o16, p16, e16, new b());
        }
    }

    public void a(List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int i3 = 0;
        while (i3 < list.size()) {
            if (!new File(((com.tencent.luggage.wxa.f1.b) list.get(i3)).b()).exists()) {
                list.remove(i3);
                i3--;
            }
            i3++;
        }
        ((g) b()).a(list);
    }

    public void a(Activity activity, com.tencent.luggage.wxa.a1.a aVar, int i3) {
        Context applicationContext = activity.getApplicationContext();
        Intent a16 = f().a(activity, aVar);
        if (a16 == null) {
            Toast.makeText(applicationContext, applicationContext.getString(R.string.f241447rw), 1).show();
        } else {
            activity.startActivityForResult(a16, i3);
        }
    }

    public void a(Context context, Intent intent, com.tencent.luggage.wxa.a1.a aVar) {
        f().a(context, intent, new c(aVar));
    }

    public final void a(Runnable runnable) {
        this.f144466d.post(new d(runnable));
    }
}
