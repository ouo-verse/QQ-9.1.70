package com.tencent.luggage.wxa.yi;

import android.net.Network;
import com.tencent.luggage.wxa.yi.b0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public static final x f145976a = new x();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements b0.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f145977a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145978b;

        public b(a aVar, int i3) {
            this.f145977a = aVar;
            this.f145978b = i3;
        }

        @Override // com.tencent.luggage.wxa.yi.b0.b
        public final void a(Network network) {
            if (network != null) {
                boolean a16 = x.f145976a.a(this.f145978b, network);
                com.tencent.luggage.wxa.tn.w.d("MicroMsg.BindSocketToNetworkLogic", "bindSocketToWifi, bind: " + a16);
                this.f145977a.a(a16);
                return;
            }
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.BindSocketToNetworkLogic", "bindSocketToWifi, network is null");
            this.f145977a.a(false);
        }
    }

    public final void a(int i3, a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.BindSocketToNetworkLogic", "bindSocketToWifi, socketFd: " + i3);
        b0.c.f145843i.a(new b(callback, i3));
    }

    public final boolean a(int i3, Network network) {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.BindSocketToNetworkLogic", "bindSocketToNetwork, socketFd: " + i3 + ", network: " + network);
        return u.f145964b.a(i3, network);
    }
}
