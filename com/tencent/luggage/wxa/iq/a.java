package com.tencent.luggage.wxa.iq;

import com.tencent.luggage.wxa.jq.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f130736a = new AtomicBoolean(false);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.iq.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6319a {
        void a(h hVar);
    }

    public abstract InterfaceC6319a a();

    @Override // com.tencent.luggage.wxa.iq.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.jq.c a(h hVar) {
        if (!isShutdown()) {
            if (!hVar.isCancelled()) {
                a().a(hVar);
                return hVar;
            }
            com.tencent.luggage.wxa.zp.d.f146814c.w(getName(), "[BasePool#input] task=%s pool=%s", hVar.getKey() + "#" + hVar.d(), getName());
            return null;
        }
        com.tencent.luggage.wxa.zp.d.f146812a.a(hVar.getKey(), hVar.d(), getName(), true);
        return null;
    }

    @Override // com.tencent.luggage.wxa.iq.d
    public boolean isShutdown() {
        return this.f130736a.get();
    }
}
