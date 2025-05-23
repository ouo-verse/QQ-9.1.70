package com.tencent.msdk.dns.c.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
final class f extends com.tencent.msdk.dns.c.c.a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends ConnectivityManager.NetworkCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f336230a;

        a(Context context) {
            this.f336230a = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) context);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) network);
                return;
            }
            super.onAvailable(network);
            com.tencent.msdk.dns.base.log.c.c("Network onAvailable(%s)", network);
            f.this.d(this.f336230a);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) network, (Object) networkCapabilities);
            } else {
                super.onCapabilitiesChanged(network, networkCapabilities);
                com.tencent.msdk.dns.base.log.c.c("Network onCapabilitiesChanged(%s)", network);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) network, (Object) linkProperties);
            } else {
                super.onLinkPropertiesChanged(network, linkProperties);
                com.tencent.msdk.dns.base.log.c.c("Network onLinkPropertiesChanged(%s)", network);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network network, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) network, i3);
            } else {
                super.onLosing(network, i3);
                com.tencent.msdk.dns.base.log.c.c("Network onLosing(%s)", network);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) network);
                return;
            }
            super.onLost(network);
            com.tencent.msdk.dns.base.log.c.c("Network onLost(%s)", network);
            f.this.d(this.f336230a);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                super.onUnavailable();
                com.tencent.msdk.dns.base.log.c.c("Network onUnavailable", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(21)
    public f(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(0).addTransportType(1).addTransportType(2).addTransportType(3).build(), new a(applicationContext));
    }
}
