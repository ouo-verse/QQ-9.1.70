package com.tencent.luggage.wxa.bf;

import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f122521b = new BaseThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    /* renamed from: a, reason: collision with root package name */
    public final d f122522a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f122523a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.p f122524b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f122525c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f122526d;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.bf.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6051a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Throwable f122528a;

            public RunnableC6051a(Throwable th5) {
                this.f122528a = th5;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw this.f122528a;
            }
        }

        public a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.ei.p pVar, JSONObject jSONObject, int i3) {
            this.f122523a = dVar;
            this.f122524b = pVar;
            this.f122525c = jSONObject;
            this.f122526d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f122523a.isRunning()) {
                return;
            }
            try {
                f a16 = b.this.f122522a.a(this.f122523a, this.f122524b, this.f122525c);
                com.tencent.luggage.wxa.xd.d dVar = this.f122523a;
                dVar.a(this.f122526d, b.this.makeReturnJsonWithNativeBuffer(dVar, a16.f144873b, a16.f144872a));
            } catch (Throwable th5) {
                com.tencent.luggage.wxa.tn.w.a("Luggage.BaseNFSApiAsync", th5, "%s.invoke, appId=%s, callbackId=%d", b.this.f122522a.getClass().getName(), this.f122523a.getAppId(), Integer.valueOf(this.f122526d));
                com.tencent.luggage.wxa.tn.c0.a(new RunnableC6051a(th5));
                this.f122523a.a(this.f122526d, b.this.makeReturnJson("fail:internal error"));
            }
        }
    }

    public b(d dVar) {
        this.f122522a = dVar;
        dVar.a(this);
    }

    @Override // com.tencent.luggage.wxa.xd.o
    public boolean canHandleVarianceExecutable() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        invoke(dVar, jSONObject, i3, dVar.getJsRuntime());
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public final void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, com.tencent.luggage.wxa.ei.p pVar) {
        f122521b.submit(new a(dVar, pVar, jSONObject, i3));
    }
}
