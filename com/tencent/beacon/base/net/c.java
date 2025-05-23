package com.tencent.beacon.base.net;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.a.b.i;
import com.tencent.beacon.base.net.adapter.AbstractNetAdapter;
import com.tencent.beacon.base.net.adapter.f;
import com.tencent.beacon.base.net.b.e;
import com.tencent.beacon.base.net.call.Callback;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.base.net.call.j;
import com.tencent.rmonitor.base.config.data.k;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class c implements e, e.a, Closeable {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f77730a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f77731b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f77732c = new AtomicInteger();

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.beacon.base.net.a.a f77733d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.beacon.base.net.a.b f77734e;

    /* renamed from: f, reason: collision with root package name */
    private Context f77735f;

    /* renamed from: g, reason: collision with root package name */
    private AbstractNetAdapter f77736g;

    /* renamed from: h, reason: collision with root package name */
    private AbstractNetAdapter f77737h;

    c() {
    }

    public static synchronized c c() {
        c cVar;
        synchronized (c.class) {
            if (f77730a == null) {
                f77730a = new c();
            }
            cVar = f77730a;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "current net connected num: %d", Integer.valueOf(this.f77732c.decrementAndGet()));
    }

    private void g() {
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "current net connected num: %d", Integer.valueOf(this.f77732c.incrementAndGet()));
    }

    public j b(JceRequestEntity jceRequestEntity) {
        return new j(jceRequestEntity);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f77731b.set(true);
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new Object[0]);
    }

    public boolean d() {
        if (this.f77732c.get() >= 5) {
            return true;
        }
        return false;
    }

    public void e() {
        this.f77731b.set(false);
    }

    public void a(Context context, AbstractNetAdapter abstractNetAdapter) {
        this.f77735f = context;
        if (abstractNetAdapter == null) {
            abstractNetAdapter = new com.tencent.beacon.base.net.adapter.b();
        }
        this.f77736g = f.a();
        this.f77737h = abstractNetAdapter;
        this.f77733d = com.tencent.beacon.base.net.a.a.a();
        this.f77734e = com.tencent.beacon.base.net.a.b.a();
        com.tencent.beacon.base.net.b.e.a(context, this);
    }

    @Override // com.tencent.beacon.base.net.b.e.a
    public void b() {
        this.f77731b.set(true);
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "network can't use. close BeaconNet.", new Object[0]);
    }

    public void a(JceRequestEntity jceRequestEntity, Callback<byte[]> callback) {
        if (this.f77731b.get()) {
            callback.onFailure(new d(jceRequestEntity.getType().name(), null, 0, "BeaconNet close."));
            return;
        }
        AbstractNetAdapter a16 = a(jceRequestEntity);
        g();
        a16.request(jceRequestEntity, new a(this, jceRequestEntity, a16 == this.f77736g, callback));
    }

    public void a(com.tencent.beacon.base.net.call.e eVar, Callback<BResponse> callback) {
        if (this.f77731b.get()) {
            callback.onFailure(new d(eVar.h(), null, 0, "BeaconNet close."));
        } else {
            g();
            this.f77737h.request(eVar, new b(this, eVar, callback));
        }
    }

    public com.tencent.beacon.base.net.call.c a(com.tencent.beacon.base.net.call.e eVar) {
        return new com.tencent.beacon.base.net.call.c(eVar);
    }

    @NonNull
    public AbstractNetAdapter a(JceRequestEntity jceRequestEntity) {
        if (jceRequestEntity.getType() == RequestType.EVENT) {
            return com.tencent.beacon.d.b.a().m() ? this.f77736g : this.f77737h;
        }
        return this.f77736g;
    }

    public void a(@NonNull d dVar) {
        if (dVar.f77777a.equals(k.ATTA_CONFIG_KEY) || TextUtils.isEmpty(dVar.f77778b)) {
            return;
        }
        i.e().a(dVar.f77778b, dVar.toString(), dVar.f77781e);
    }

    @Override // com.tencent.beacon.base.net.b.e.a
    public void a() {
        this.f77731b.set(false);
        com.tencent.beacon.base.util.c.a("[BeaconNet]", "network recovery. open BeaconNet.", new Object[0]);
    }
}
