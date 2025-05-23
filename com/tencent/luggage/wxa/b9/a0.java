package com.tencent.luggage.wxa.b9;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Function;
import com.eclipsesource.mmv8.V8Object;
import com.eclipsesource.mmv8.utils.V8ObjectUtils;
import com.tencent.luggage.wxa.tn.e0;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a0 extends v {

    /* renamed from: d, reason: collision with root package name */
    public volatile Looper f122119d;

    /* renamed from: b, reason: collision with root package name */
    public int f122117b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f122118c = new SparseArray();

    /* renamed from: e, reason: collision with root package name */
    public boolean f122120e = false;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f122121f = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements JavaCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f122122a;

        public a(t tVar) {
            this.f122122a = tVar;
        }

        @Override // com.eclipsesource.mmv8.JavaCallback
        public Object invoke(V8Object v8Object, V8Array v8Array) {
            V8Array newV8Array;
            int i3 = 0;
            if (v8Array.length() >= 1 && v8Array.getType(0) == 7) {
                V8Function v8Function = (V8Function) v8Array.getObject(0);
                if (v8Array.length() > 1) {
                    if (v8Array.getType(1) == 1) {
                        i3 = v8Array.getInteger(1);
                    } else if (v8Array.getType(1) == 2) {
                        i3 = (int) v8Array.getDouble(1);
                    } else if (v8Array.getType(1) == 4) {
                        int b16 = a0.b(v8Array.getString(1), Integer.MIN_VALUE);
                        if (b16 == Integer.MIN_VALUE) {
                            return null;
                        }
                        i3 = b16;
                    } else {
                        com.tencent.luggage.wxa.tn.w.h("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters[1] type:%d", Integer.valueOf(v8Array.getType(1)));
                        return null;
                    }
                }
                if (v8Array.length() > 2) {
                    List<? super Object> list = V8ObjectUtils.toList(v8Array);
                    newV8Array = V8ObjectUtils.toV8Array(this.f122122a.j(), (List<? extends Object>) list.subList(1, list.size()));
                } else {
                    newV8Array = this.f122122a.j().newV8Array();
                }
                return Integer.valueOf(a0.this.b(this.f122122a, v8Function, i3, newV8Array));
            }
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters invalid length:%d type[0]:%d", Integer.valueOf(v8Array.length()), Integer.valueOf(v8Array.getType(0)));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements JavaCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f122124a;

        public b(t tVar) {
            this.f122124a = tVar;
        }

        @Override // com.eclipsesource.mmv8.JavaCallback
        public Object invoke(V8Object v8Object, V8Array v8Array) {
            int b16;
            V8Array newV8Array;
            if (v8Array.length() >= 2 && v8Array.getType(0) == 7) {
                V8Function v8Function = (V8Function) v8Array.getObject(0);
                if (v8Array.getType(1) == 1) {
                    b16 = v8Array.getInteger(1);
                } else if (v8Array.getType(1) == 2) {
                    b16 = (int) v8Array.getDouble(1);
                } else if (v8Array.getType(1) == 4) {
                    b16 = a0.b(v8Array.getString(1), Integer.MIN_VALUE);
                    if (b16 == Integer.MIN_VALUE) {
                        return null;
                    }
                } else {
                    com.tencent.luggage.wxa.tn.w.h("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters[1] type:%d", Integer.valueOf(v8Array.getType(1)));
                    return null;
                }
                if (v8Array.length() > 2) {
                    List<? super Object> list = V8ObjectUtils.toList(v8Array);
                    newV8Array = V8ObjectUtils.toV8Array(this.f122124a.j(), (List<? extends Object>) list.subList(1, list.size()));
                } else {
                    newV8Array = this.f122124a.j().newV8Array();
                }
                return Integer.valueOf(a0.this.a(this.f122124a, v8Function, b16, newV8Array));
            }
            com.tencent.luggage.wxa.tn.w.h("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters invalid length:%d type[0]:%d", Integer.valueOf(v8Array.length()), Integer.valueOf(v8Array.getType(0)));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements JavaVoidCallback {
        public c() {
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array.length() >= 1 && v8Array.getType(0) == 1) {
                a0.this.a(v8Array.getInteger(0));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements JavaVoidCallback {
        public d() {
        }

        @Override // com.eclipsesource.mmv8.JavaVoidCallback
        public void invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array.length() >= 1 && v8Array.getType(0) == 1) {
                a0.this.a(v8Array.getInteger(0));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e extends g {

        /* renamed from: i, reason: collision with root package name */
        public final com.tencent.luggage.wxa.tn.e0 f122128i;

        /* renamed from: j, reason: collision with root package name */
        public long f122129j;

        /* renamed from: k, reason: collision with root package name */
        public long f122130k;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements e0.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a0 f122132a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t f122133b;

            public a(a0 a0Var, t tVar) {
                this.f122132a = a0Var;
                this.f122133b = tVar;
            }

            @Override // com.tencent.luggage.wxa.tn.e0.a
            public boolean a() {
                e.this.f122130k = SystemClock.elapsedRealtimeNanos();
                this.f122133b.h().a(e.this);
                return false;
            }
        }

        public e(t tVar, int i3, V8Function v8Function, V8Array v8Array, boolean z16, long j3) {
            super(tVar, i3, v8Function, v8Array, z16, j3);
            this.f122128i = new com.tencent.luggage.wxa.tn.e0(a0.this.f122119d, (e0.a) new a(a0.this, tVar), false);
        }

        @Override // com.tencent.luggage.wxa.b9.a0.g
        public void d() {
            com.tencent.luggage.wxa.tn.e0 e0Var = this.f122128i;
            long j3 = this.f122139e;
            e0Var.a(j3, j3);
        }

        public final void e() {
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long j3 = this.f122129j;
            if (0 == j3) {
                this.f122129j = elapsedRealtimeNanos - this.f122130k;
            } else {
                this.f122129j = ((j3 + elapsedRealtimeNanos) - this.f122130k) / 2;
            }
            long millis = this.f122139e - TimeUnit.NANOSECONDS.toMillis(this.f122129j);
            if (millis <= 0) {
                millis = this.f122139e;
            }
            this.f122128i.a(millis, millis);
        }

        @Override // com.tencent.luggage.wxa.b9.a0.g, java.lang.Runnable
        public void run() {
            if (!c()) {
                return;
            }
            a(this.f122141g);
            if (!c()) {
                return;
            }
            if (!this.f122140f) {
                b();
            } else {
                e();
            }
        }

        @Override // com.tencent.luggage.wxa.b9.a0.f
        public void a() {
            this.f122128i.f();
            super.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g extends f implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        public final long f122139e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f122140f;

        /* renamed from: g, reason: collision with root package name */
        public final V8Array f122141g;

        public g(t tVar, int i3, V8Function v8Function, V8Array v8Array, boolean z16, long j3) {
            super(tVar, i3, v8Function);
            this.f122139e = j3;
            this.f122140f = z16;
            this.f122141g = v8Array;
        }

        @Override // com.tencent.luggage.wxa.b9.a0.f
        public void b() {
            super.b();
            this.f122141g.release();
        }

        public void d() {
            this.f122135a.h().a(this, this.f122139e);
        }

        public void run() {
            if (!c()) {
                return;
            }
            a(this.f122141g);
            if (!c()) {
                return;
            }
            if (this.f122140f) {
                d();
            } else {
                b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public t f122135a;

        /* renamed from: b, reason: collision with root package name */
        public V8Function f122136b;

        /* renamed from: c, reason: collision with root package name */
        public int f122137c;

        public f(t tVar, int i3, V8Function v8Function) {
            this.f122135a = tVar;
            this.f122136b = v8Function;
            this.f122137c = i3;
        }

        public void a(V8Array v8Array) {
            if (this.f122136b.isReleased() || this.f122135a.j().isReleased()) {
                return;
            }
            this.f122136b.call(this.f122135a.j().getGlobalObject(), v8Array);
        }

        void b() {
            a0.this.f122118c.remove(this.f122137c);
            this.f122136b.release();
        }

        boolean c() {
            if (!this.f122136b.isReleased() && !this.f122135a.j().isReleased()) {
                return true;
            }
            return false;
        }

        void a() {
            b();
        }
    }

    public static int b(String str, int i3) {
        if (str == null) {
            return i3;
        }
        try {
            return str.length() <= 0 ? i3 : Integer.decode(str).intValue();
        } catch (NumberFormatException e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.J2V8.V8DirectApiTimer", e16, "", new Object[0]);
            return i3;
        }
    }

    @Override // com.tencent.luggage.wxa.b9.v
    public void a(t tVar, V8Object v8Object) {
        if (!(tVar.h() instanceof com.tencent.luggage.wxa.b9.b)) {
            this.f122119d = Looper.getMainLooper();
        }
        if (!this.f122120e && (tVar.h() instanceof l) && ((l) tVar.h()).q()) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.J2V8.V8DirectApiTimer", "hy: node env do not need java imp timer");
            return;
        }
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.J2V8.V8DirectApiTimer", "hy: not node. need to inject direct timer");
        v8Object.registerJavaMethod(new a(tVar), "setTimeout");
        v8Object.registerJavaMethod(new b(tVar), "setInterval");
        v8Object.registerJavaMethod(new c(), "clearTimeout");
        v8Object.registerJavaMethod(new d(), "clearInterval");
    }

    public final int b(t tVar, V8Function v8Function, int i3, V8Array v8Array) {
        g eVar;
        this.f122117b++;
        if (tVar.h() instanceof com.tencent.luggage.wxa.b9.b) {
            eVar = new g(tVar, this.f122117b, v8Function, v8Array, false, i3);
        } else {
            eVar = new e(tVar, this.f122117b, v8Function, v8Array, false, i3);
        }
        eVar.d();
        this.f122118c.put(this.f122117b, eVar);
        return this.f122117b;
    }

    @Override // com.tencent.luggage.wxa.b9.v
    public void a() {
        for (int i3 = 0; i3 < this.f122118c.size(); i3++) {
            ((f) this.f122118c.valueAt(i3)).a();
        }
        this.f122118c.clear();
        Looper looper = this.f122119d;
        if (looper == null || Looper.getMainLooper() == looper) {
            return;
        }
        looper.quit();
        this.f122119d = null;
    }

    public final int a(t tVar, V8Function v8Function, int i3, V8Array v8Array) {
        g eVar;
        this.f122117b++;
        if (tVar.h() instanceof com.tencent.luggage.wxa.b9.b) {
            eVar = new g(tVar, this.f122117b, v8Function, v8Array, true, i3);
        } else {
            eVar = new e(tVar, this.f122117b, v8Function, v8Array, true, i3);
        }
        eVar.d();
        this.f122118c.put(this.f122117b, eVar);
        return this.f122117b;
    }

    public final void a(int i3) {
        f fVar = (f) this.f122118c.get(i3);
        if (fVar != null) {
            fVar.a();
            this.f122118c.remove(i3);
        }
    }
}
