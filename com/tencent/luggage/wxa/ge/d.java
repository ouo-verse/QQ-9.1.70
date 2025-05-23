package com.tencent.luggage.wxa.ge;

import androidx.core.util.Consumer;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f126692a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.tk.h f126693b = new com.tencent.luggage.wxa.tk.h();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Consumer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f126694a;

        public a(c cVar) {
            this.f126694a = cVar;
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(h hVar) {
            hVar.a(this.f126694a);
        }
    }

    public final void a(String str, c cVar) {
        w.d("MicroMsg.AppBrand.BluetoothAuthorizeStateQuickAccess", "onAuthorizeStateChange, appId: " + str + ", newState: " + cVar);
        if (str == null || cVar == null) {
            return;
        }
        f126693b.a((Object) str, (Consumer) new a(cVar));
    }

    public final void b(String str, h hVar) {
        w.d("MicroMsg.AppBrand.BluetoothAuthorizeStateQuickAccess", "removeListener, appId: " + str);
        if (str == null || hVar == null) {
            return;
        }
        f126693b.c(str, hVar);
    }

    public final void a(String str, h hVar) {
        w.d("MicroMsg.AppBrand.BluetoothAuthorizeStateQuickAccess", "addListener, appId: " + str);
        if (str == null || hVar == null) {
            return;
        }
        f126693b.b(str, hVar);
    }
}
