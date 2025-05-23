package com.tencent.luggage.wxa.em;

import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import com.eclipsesource.mmv8.V8ScriptEvaluateRequest;
import com.tencent.luggage.wxa.b9.c0;
import com.tencent.luggage.wxa.b9.d0;
import com.tencent.luggage.wxa.b9.t;
import com.tencent.luggage.wxa.c5.e;
import com.tencent.luggage.wxa.em.a;
import com.tencent.luggage.wxa.em.c;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.ic.o;
import com.tencent.luggage.wxa.ic.r0;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.mc.k0;
import com.tencent.luggage.wxa.mc.m;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.y;
import com.tencent.luggage.wxa.xd.h0;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends o {
    public a(l lVar) {
        super(lVar);
    }

    public com.tencent.luggage.wxa.fj.a i() {
        return null;
    }

    public boolean j() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ic.o
    public c0 a() {
        return new C6173a(c());
    }

    @Override // com.tencent.luggage.wxa.ic.o
    public c0.j b(String str) {
        c0.j jVar;
        if (!TextUtils.isEmpty(d().e(str))) {
            jVar = super.b(str);
        } else {
            m.a openReadPartialInfo = k0.b(d().getRuntime()).openReadPartialInfo(str);
            if (openReadPartialInfo == null) {
                Object[] objArr = new Object[2];
                objArr[0] = d() != null ? d().getAppId() : null;
                objArr[1] = str;
                w.h("MicroMsg.AppBrandWorkerContainerLU", "getUsrScript for appId:%s, path:%s, file not found", objArr);
                return null;
            }
            String str2 = d().M() + str;
            jVar = new c0.j(str2, y.a(str, openReadPartialInfo, str2));
        }
        if (jVar == null) {
            return null;
        }
        return new c.f(jVar, r0.a(d().getRuntime(), str, d().M()), d().getAppId(), d().A());
    }

    @Override // com.tencent.luggage.wxa.ic.o
    public c0.j a(String str) {
        V8ScriptEvaluateRequest a16;
        AssetFileDescriptor d16 = j() ? d().i().d(str) : null;
        if (d16 != null) {
            a16 = y.a(d16);
            if (a16 != null) {
                w.d("MicroMsg.AppBrandWorkerContainerLU", "getCommonLibScript(%s), fd:%d, fileOffset:%d, fileLength:%d", str, Integer.valueOf(a16.scriptFd.f32584fd), Long.valueOf(a16.scriptFd.startOffset), Long.valueOf(a16.scriptFd.length));
            } else {
                a16 = y.a(d().i().g(str));
                w.b("MicroMsg.AppBrandWorkerContainerLU", "getCommLibScript(%s), createEvalRequestForAssetFd failed, fallback to createTextEvalRequest", str);
            }
        } else {
            a16 = y.a(d().i().g(str));
            w.b("MicroMsg.AppBrandWorkerContainerLU", "getCommLibScript(%s), fd is null, fallback to createTextEvalRequest", str);
        }
        V8ScriptEvaluateRequest v8ScriptEvaluateRequest = a16;
        String str2 = d().K() + com.tencent.luggage.wxa.ki.a.b(str);
        String str3 = "V" + d().i().w();
        v8ScriptEvaluateRequest.scriptName = str2;
        v8ScriptEvaluateRequest.cacheCategory = str;
        v8ScriptEvaluateRequest.cacheKey = str3;
        return new c.f(str2, v8ScriptEvaluateRequest, (String) null, d().getAppId(), d().A()).a(d().i());
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.em.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6173a extends c {
        public C6173a(d0 d0Var) {
            super(d0Var);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object[]] */
        /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Integer] */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Integer] */
        @Override // com.tencent.luggage.wxa.em.c, com.tencent.luggage.wxa.b9.c0
        public void a(int i3, final t tVar) {
            if ((a.this.d().getRuntime() instanceof e) && ((e) a.this.d().getRuntime()).z1()) {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                int i16 = 2;
                i16 = 2;
                w.d("MicroMsg.AppBrandWorkerContainerLU", "post report coverage task for appId:%s workerId:%d", a.this.d().getAppId(), Integer.valueOf(i3));
                tVar.a("\n        ;(function() {\n            let data = (globalThis || {}).__coverage__ || new Function(\"return this\")().__coverage__;\n            if (typeof data === 'string' || typeof data === 'undefined') {\n                return data;\n            } else {\n                return JSON.stringify(data);\n            }\n        })();\n    ", new t.s() { // from class: m21.a
                    @Override // com.tencent.luggage.wxa.b9.t.s
                    public final void a(String str, t.C6044t c6044t) {
                        a.C6173a.this.a(tVar, countDownLatch, str, c6044t);
                    }
                });
                try {
                    try {
                        countDownLatch.await(3L, TimeUnit.SECONDS);
                        ?? valueOf = Integer.valueOf(i3);
                        w.d("MicroMsg.AppBrandWorkerContainerLU", "post report coverage task for appId:%s workerId:%d latch await end", new Object[]{a.this.d().getAppId(), valueOf});
                        i16 = valueOf;
                    } catch (Exception e16) {
                        w.b("MicroMsg.AppBrandWorkerContainerLU", "post report coverage task for appId:%s workerId:%d latch await failed:%s", a.this.d().getAppId(), Integer.valueOf(i3), e16);
                        ?? valueOf2 = Integer.valueOf(i3);
                        w.d("MicroMsg.AppBrandWorkerContainerLU", "post report coverage task for appId:%s workerId:%d latch await end", new Object[]{a.this.d().getAppId(), valueOf2});
                        i16 = valueOf2;
                    }
                } catch (Throwable th5) {
                    Object[] objArr = new Object[i16];
                    objArr[0] = a.this.d().getAppId();
                    objArr[1] = Integer.valueOf(i3);
                    w.d("MicroMsg.AppBrandWorkerContainerLU", "post report coverage task for appId:%s workerId:%d latch await end", objArr);
                    throw th5;
                }
            }
            super.a(i3, tVar);
        }

        @Override // com.tencent.luggage.wxa.em.c
        public com.tencent.luggage.wxa.fj.a f() {
            com.tencent.luggage.wxa.fj.a i3 = a.this.i();
            if (i3 == null) {
                return super.f();
            }
            return i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(t tVar, CountDownLatch countDownLatch, String str, t.C6044t c6044t) {
            h0.a(a.this.d(), tVar, str);
            countDownLatch.countDown();
        }
    }

    @Override // com.tencent.luggage.wxa.ic.o
    public void a(ArrayList arrayList, String str, boolean z16, String str2) {
        super.a(arrayList, str, z16, str2);
        arrayList.add(new c.f(d().K() + "shared_buffer.js", com.tencent.luggage.wxa.tk.c.b("wxa_library/shared_buffer.js"), (String) null, d().getAppId(), d().A()));
        arrayList.add(new c.f(d().K() + "android.js", com.tencent.luggage.wxa.tk.c.b("wxa_library/android.js"), (String) null, d().getAppId(), d().A()));
        arrayList.add(new c.f(d().K() + "lazy_load.js", com.tencent.luggage.wxa.tk.c.b("wxa_library/lazy_load.js"), (String) null, d().getAppId(), d().A()));
        arrayList.add(a("WAWorker.js"));
        if (StringUtils.equals("wxlib", str2) || e.a.b(d().getRuntime().l0())) {
            return;
        }
        arrayList.add(new c0.j(d().K() + "WASourceMap.js", r0.a(d())));
        arrayList.add(new c0.j(d().K() + "sourcemapSysinfo", r0.a()));
    }
}
