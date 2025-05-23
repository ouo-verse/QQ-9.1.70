package com.tencent.luggage.wxa.b9;

import android.text.TextUtils;
import com.eclipsesource.mmv8.MultiContextNodeJS;
import com.eclipsesource.mmv8.MultiContextV8;
import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Context;
import com.tencent.luggage.wxa.b9.d;
import com.tencent.luggage.wxa.b9.m;
import com.tencent.luggage.wxa.b9.t;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l extends com.tencent.luggage.wxa.b9.a {
    public MultiContextNodeJS B;
    public volatile t C;
    public m D;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.D.p();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements V8.JavaTaskScheduler {
        public b() {
        }

        @Override // com.eclipsesource.mmv8.V8.JavaTaskScheduler
        public void Schedule(Runnable runnable) {
            l.this.D.a(runnable, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements m.a {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.b9.m.a
        public boolean a(boolean z16) {
            return l.this.B.handleMessage(z16);
        }

        @Override // com.tencent.luggage.wxa.b9.m.a
        public void b() {
            if (l.this.B != null) {
                l.this.B.wakeUpUVLoop();
            }
        }

        @Override // com.tencent.luggage.wxa.b9.m.a
        public void a() {
            if (l.this.B != null) {
                l.this.B.closeUVLoop();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements t.r {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.b9.t.r
        public V8Context a() {
            if (l.this.B != null) {
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.NodeJSRuntime", "getMainContext %s", Integer.valueOf(l.this.B.getMainContext().hashCode()));
                return l.this.B.getMainContext();
            }
            throw new IllegalStateException("getMainContext mNodeJS not ready!");
        }
    }

    public l(d.a aVar) {
        super(aVar);
    }

    @Override // com.tencent.luggage.wxa.b9.a
    public void l() {
        super.l();
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd");
        try {
            this.B.release();
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.NodeJSRuntime", "cleanUpRuntimeWhenThreadEnd done");
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.NodeJSRuntime", "cleanUpWhenThreadEnd exp = %s", e16);
        }
    }

    @Override // com.tencent.luggage.wxa.b9.a
    public e s() {
        m a16 = m.a(new c(), k().f122194j);
        this.D = a16;
        return a16;
    }

    @Override // com.tencent.luggage.wxa.b9.a
    public MultiContextV8 t() {
        int i3;
        boolean z16;
        boolean z17;
        m();
        f0 f0Var = f0.f122204b;
        if (f0Var.u()) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        if (!f0Var.x()) {
            int i16 = this.f122096l;
            String str = this.f122092h;
            byte[] bArr = this.f122093i;
            String str2 = this.f122094j;
            if (!TextUtils.isEmpty(str2) && this.f122095k) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.B = MultiContextNodeJS.createMultiContextNodeJS(1, i16, str, bArr, str2, z17, this.f122099o, i3);
        } else {
            synchronized (l.class) {
                int i17 = this.f122096l;
                String str3 = this.f122092h;
                byte[] bArr2 = this.f122093i;
                String str4 = this.f122094j;
                if (!TextUtils.isEmpty(str4) && this.f122095k) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.B = MultiContextNodeJS.createMultiContextNodeJS(1, i17, str3, bArr2, str4, z16, this.f122099o, i3);
            }
        }
        MultiContextNodeJS.CreateStats createStats = this.B.createStats;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.NodeJSRuntime", "prepareV8WhenThreadStart, isolateCreateDurationMills: %d, mainContextCreateDurationMills: %d, nodeEnvCreateDurationMills: %d", Long.valueOf(createStats.isolateCreateDurationMills), Long.valueOf(createStats.mainContextCreateDurationMills), Long.valueOf(createStats.nodeEnvCreateDurationMills));
        a(createStats.isolateCreateDurationMills, createStats.mainContextCreateDurationMills);
        this.B.getRuntime().getV8().setNativeJavaCallback(new a());
        this.B.getRuntime().getV8().setJavaTaskScheduler(new b());
        this.f122093i = null;
        return this.B.getRuntime();
    }

    public t v() {
        if (this.C == null) {
            this.C = new t(this, p(), new d());
        }
        return this.C;
    }

    public static l a(d.a aVar) {
        return new l(aVar);
    }
}
