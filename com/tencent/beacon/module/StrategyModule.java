package com.tencent.beacon.module;

import android.content.Context;
import com.tencent.beacon.base.net.b.e;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.d.a;
import com.tencent.beacon.d.b;
import com.tencent.beacon.d.h;
import com.tencent.beacon.d.i;

/* compiled from: P */
/* loaded from: classes2.dex */
public class StrategyModule implements BeaconModule {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f78085a = new Object();

    /* renamed from: c, reason: collision with root package name */
    private i f78087c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f78089e = false;

    /* renamed from: d, reason: collision with root package name */
    private b f78088d = b.a();

    /* renamed from: b, reason: collision with root package name */
    private a f78086b = a.a();

    public StrategyModule() {
        h.c().a(this.f78086b);
        this.f78087c = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (!this.f78087c.a()) {
            com.tencent.beacon.a.b.a.a().a(this.f78087c);
        }
    }

    public boolean c() {
        boolean z16;
        synchronized (f78085a) {
            z16 = this.f78089e;
        }
        return z16;
    }

    @Override // com.tencent.beacon.module.BeaconModule
    public void a(Context context) {
        c.a("[module] strategy module > TRUE", new Object[0]);
        this.f78087c.b();
        d();
        e.a(context, new e.a() { // from class: com.tencent.beacon.module.StrategyModule.1
            @Override // com.tencent.beacon.base.net.b.e.a
            public void a() {
                synchronized (StrategyModule.this) {
                    if (!StrategyModule.this.c() && !StrategyModule.this.f78087c.a()) {
                        StrategyModule.this.d();
                    }
                }
            }

            @Override // com.tencent.beacon.base.net.b.e.a
            public void b() {
            }
        });
    }

    public b b() {
        return this.f78088d;
    }

    public void a(boolean z16) {
        synchronized (f78085a) {
            this.f78089e = z16;
        }
    }

    public a a() {
        return this.f78086b;
    }
}
