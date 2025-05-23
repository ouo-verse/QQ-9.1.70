package com.tencent.luggage.wxa.vf;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.r;
import com.tencent.luggage.wxa.vf.b;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements com.tencent.luggage.wxa.vf.b {

    /* renamed from: h, reason: collision with root package name */
    public static final b f143412h = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f143413a;

    /* renamed from: b, reason: collision with root package name */
    public final r f143414b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Function3 f143415c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f143416d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f143417e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f143418f;

    /* renamed from: g, reason: collision with root package name */
    public final c f143419g;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.vf.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6845a extends e.c {
        public C6845a() {
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            Context applicationContext;
            super.onDestroy();
            w.a("MicroMsg.AppBrand.AbsNFCDiscoverable", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            Activity a16 = a.this.f().a();
            if (a16 != null && (applicationContext = a16.getApplicationContext()) != null) {
                applicationContext.unregisterReceiver(a.this.f143419g);
            }
            a.this.j();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            super.onPause(dVar);
            w.a("MicroMsg.AppBrand.AbsNFCDiscoverable", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            a.this.k();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            super.onResume();
            w.a("MicroMsg.AppBrand.AbsNFCDiscoverable", "onResume");
            a.this.l();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z16;
            if (intent != null) {
                int intExtra = intent.getIntExtra("android.nfc.extra.ADAPTER_STATE", -1);
                a aVar = a.this;
                if (-1 == intExtra) {
                    w.f("MicroMsg.AppBrand.AbsNFCDiscoverable", "onReceive#sysNfcSwitchToggleListener, state is invalid");
                    return;
                }
                if (3 == intExtra) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                w.d("MicroMsg.AppBrand.AbsNFCDiscoverable", "onReceive#sysNfcSwitchToggleListener, isNFCEnabled: " + z16);
                if (!z16) {
                    aVar.h().set(false);
                    aVar.b(false);
                    return;
                }
                return;
            }
            w.f("MicroMsg.AppBrand.AbsNFCDiscoverable", "onReceive#sysNfcSwitchToggleListener, state is null");
        }
    }

    public a(String appId, r activityProvider) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(activityProvider, "activityProvider");
        this.f143413a = appId;
        this.f143414b = activityProvider;
        this.f143416d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f143417e = new AtomicBoolean(false);
        c cVar = new c();
        this.f143419g = cVar;
        Activity a16 = activityProvider.a();
        if (a16 != null && (applicationContext = a16.getApplicationContext()) != null) {
            applicationContext.registerReceiver(cVar, new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED"));
        }
        com.tencent.luggage.wxa.ic.e.a(appId, new C6845a());
    }

    @Override // com.tencent.luggage.wxa.vf.b
    public void a(boolean z16) {
    }

    public final void b(boolean z16) {
        this.f143418f = z16;
    }

    @Override // com.tencent.luggage.wxa.vf.b
    public Set c() {
        return this.f143416d;
    }

    public abstract void d();

    public abstract void e();

    public final r f() {
        return this.f143414b;
    }

    public Function3 g() {
        return this.f143415c;
    }

    public final AtomicBoolean h() {
        return this.f143417e;
    }

    public final boolean i() {
        return this.f143418f;
    }

    @Override // com.tencent.luggage.wxa.vf.b
    public final b.a b() {
        if (this.f143417e.get()) {
            return b.a.FAIL_ALREADY_STARTED;
        }
        try {
            d();
            this.f143417e.set(true);
            return b.a.SUCCESS;
        } catch (Exception e16) {
            w.f("MicroMsg.AppBrand.AbsNFCDiscoverable", "startDiscovery failed since " + e16);
            return b.a.FAIL_SYSTEM_INTERNAL_ERROR;
        }
    }

    @Override // com.tencent.luggage.wxa.vf.b
    public void a(Function3 function3) {
        this.f143415c = function3;
    }

    @Override // com.tencent.luggage.wxa.vf.b
    public final b.a a() {
        this.f143418f = false;
        if (!this.f143417e.get()) {
            return b.a.FAIL_NOT_STARTED;
        }
        try {
            e();
            this.f143417e.set(false);
            return b.a.SUCCESS;
        } catch (Exception e16) {
            w.f("MicroMsg.AppBrand.AbsNFCDiscoverable", "stopDiscovery failed since " + e16);
            return b.a.FAIL_SYSTEM_INTERNAL_ERROR;
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }
}
