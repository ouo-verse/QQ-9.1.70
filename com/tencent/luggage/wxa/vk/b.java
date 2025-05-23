package com.tencent.luggage.wxa.vk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public Context f143635a;

    /* renamed from: b, reason: collision with root package name */
    public final IntentFilter f143636b = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: c, reason: collision with root package name */
    public final d f143637c = new d();

    /* renamed from: d, reason: collision with root package name */
    public Intent f143638d = null;

    /* renamed from: e, reason: collision with root package name */
    public final e f143639e = this;

    /* renamed from: f, reason: collision with root package name */
    public C6855b f143640f;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.vk.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6855b extends BroadcastReceiver {
        public C6855b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (b.this.f143639e) {
                b.this.f143638d = intent;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.vk.e
    public synchronized void init(Context context) {
        this.f143638d = null;
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.f143635a = context;
    }

    public final Intent a(Context context) {
        Intent intent = this.f143638d;
        if (intent != null) {
            return intent;
        }
        this.f143640f = new C6855b();
        Intent registerReceiver = context.getApplicationContext().registerReceiver(this.f143640f, this.f143636b);
        this.f143638d = registerReceiver;
        return registerReceiver;
    }

    @Override // com.tencent.luggage.wxa.vk.e
    public synchronized c a() {
        Context context = this.f143635a;
        if (context == null) {
            w.b("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no context");
            return com.tencent.luggage.wxa.vk.a.f143631d;
        }
        Intent a16 = a(context);
        if (a16 == null) {
            w.b("MicroMsg.AppBrandBatteryManagerImplBelow21", "getBatteryInfo no intent got");
            return com.tencent.luggage.wxa.vk.a.f143631d;
        }
        c a17 = this.f143637c.a(a16);
        if (a17 != null) {
            return a17;
        }
        return com.tencent.luggage.wxa.vk.a.f143631d;
    }
}
