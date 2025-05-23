package com.tencent.gamecenter.wadl.sdk.downloader.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b f107412e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f107413a = false;

    /* renamed from: b, reason: collision with root package name */
    private Network f107414b = null;

    /* renamed from: c, reason: collision with root package name */
    private Context f107415c;

    /* renamed from: d, reason: collision with root package name */
    private ConnectivityManager f107416d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a extends ConnectivityManager.NetworkCallback {
        a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            b.this.a(network);
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl_DualNetworkManager", "forceSendRequestByMobileData success");
        }
    }

    b(Context context) {
        this.f107415c = context;
        this.f107416d = (ConnectivityManager) context.getSystemService("connectivity");
    }

    private void a() {
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addCapability(12).addTransportType(0);
        NetworkRequest build = builder.build();
        ConnectivityManager connectivityManager = this.f107416d;
        if (connectivityManager == null) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl_DualNetworkManager", "mConnectivityManager is null");
        } else {
            connectivityManager.requestNetwork(build, new a());
        }
    }

    public static b c() {
        if (f107412e == null) {
            synchronized (b.class) {
                if (f107412e == null) {
                    f107412e = new b(com.tencent.gamecenter.wadl.sdk.common.a.b());
                }
            }
        }
        return f107412e;
    }

    public Network b() {
        return this.f107414b;
    }

    public boolean d() {
        return this.f107413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Network network) {
        this.f107414b = network;
    }

    public void a(boolean z16) {
        this.f107413a = z16;
        if (z16) {
            a();
        } else {
            a((Network) null);
        }
    }
}
