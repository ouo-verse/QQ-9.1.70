package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.xd.o1;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class k extends com.tencent.luggage.wxa.xd.a {

    /* renamed from: a, reason: collision with root package name */
    public final Class f145715a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145716a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145717b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f145718c;

        public a(com.tencent.luggage.wxa.ic.d dVar, int i3, JSONObject jSONObject) {
            this.f145716a = dVar;
            this.f145717b = i3;
            this.f145718c = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.v a16 = o1.a(this.f145716a);
            if (a16 == null) {
                this.f145716a.a(this.f145717b, k.this.makeReturnJson("fail:page don't exist"));
                return;
            }
            Object f16 = a16.f(k.this.f145715a);
            if (f16 != null) {
                k.this.a(this.f145716a, this.f145718c, this.f145717b, f16);
            } else if (!a16.isRunning()) {
                this.f145716a.a(this.f145717b, k.this.makeReturnJson("fail:interrupted"));
            } else {
                if (!a16.b()) {
                    this.f145716a.a(this.f145717b, k.this.makeReturnJson("fail:not supported"));
                    return;
                }
                throw new IllegalAccessError(String.format("%s Not Found", k.this.f145715a.getName()));
            }
        }
    }

    public k(Class cls) {
        this.f145715a = cls;
    }

    public abstract void a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3, Object obj);

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        a aVar = new a(dVar, i3, jSONObject);
        if (!(dVar instanceof com.tencent.luggage.wxa.kj.v) && dVar.getRuntime().m1()) {
            dVar.getRuntime().c(aVar);
        } else {
            aVar.run();
        }
    }
}
