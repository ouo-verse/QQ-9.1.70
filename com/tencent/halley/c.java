package com.tencent.halley;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.util.Log;
import com.tencent.halley.common.ParseDnsServerType;
import com.tencent.halley.common.utils.log.IDownloadLogProxy;
import com.tencent.halley.downloader.DownloaderTaskCategory;
import com.tencent.halley.downloader.c.a;
import com.tencent.halley.downloader.c.c;
import com.tencent.halley.downloader.c.g;
import com.tencent.halley.downloader.c.h;
import com.tencent.halley.downloader.c.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@NotProguard
/* loaded from: classes6.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @NotProguard
    /* loaded from: classes6.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (a) iPatchRedirector.redirect((short) 23, (Object) this);
            }
            j.a().f113715e = false;
            j a16 = j.a();
            a16.f113716f = 0;
            Iterator<com.tencent.halley.downloader.task.c> it = a16.f113711a.iterator();
            while (it.hasNext()) {
                it.next().setTaskSpeedLimit(a16.f113716f);
            }
            return this;
        }

        public final a b(boolean z16, ParseDnsServerType parseDnsServerType, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (a) iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(z16), parseDnsServerType, list);
            }
            com.tencent.halley.downloader.c.a a16 = a.C1243a.a();
            a16.f113664c = Boolean.valueOf(z16);
            if (z16) {
                a16.f113665d = parseDnsServerType;
                a16.f113663b.clear();
                a16.f113663b.addAll(list);
                a16.a("0");
            }
            return this;
        }

        public final a c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (a) iPatchRedirector.redirect((short) 22, (Object) this, i3);
            }
            if (!j.a().f113715e) {
                j.a().f113715e = true;
            }
            j a16 = j.a();
            a16.f113716f = i3;
            int size = a16.d().size();
            if (size != 0) {
                a16.a(a16.f113716f / size);
            }
            return this;
        }

        public final a d(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (a) iPatchRedirector.redirect((short) 14, (Object) this, z16);
            }
            com.tencent.halley.downloader.c.b a16 = com.tencent.halley.downloader.c.b.a();
            a16.f113681a = z16;
            if (z16) {
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(12);
                builder.addTransportType(0);
                NetworkRequest build = builder.build();
                ConnectivityManager connectivityManager = a16.f113683c;
                if (connectivityManager != null) {
                    try {
                        connectivityManager.requestNetwork(build, new ConnectivityManager.NetworkCallback() { // from class: com.tencent.halley.downloader.c.b.1
                            static IPatchRedirector $redirector_;

                            public AnonymousClass1() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) b.this);
                                }
                            }

                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public final void onAvailable(Network network) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) network);
                                    return;
                                }
                                super.onAvailable(network);
                                b.this.f113682b = network;
                                com.tencent.halley.common.utils.d.b("DualNetworkManager", "forceSendRequestByMobileData success");
                            }
                        });
                    } catch (Exception e16) {
                        Log.e("DualNetworkManager", "forceSendRequestByMobileData exception", e16);
                    }
                }
            } else {
                a16.f113682b = null;
            }
            return this;
        }

        public final a e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (a) iPatchRedirector.redirect((short) 12, (Object) this, i3);
            }
            int a16 = com.tencent.halley.common.utils.j.a(i3, 0, 3);
            g.a().f113701e = a16;
            com.tencent.halley.downloader.f.a.a().a(a16 * 2);
            return this;
        }

        public final a f(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (a) iPatchRedirector.redirect((short) 15, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            }
            com.tencent.halley.common.utils.d.a(z16, z17);
            return this;
        }

        public final a g(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (a) iPatchRedirector.redirect((short) 10, (Object) this, z16);
            }
            g.a().f113697a = z16;
            return this;
        }

        public final a h(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (a) iPatchRedirector.redirect((short) 11, (Object) this, j3);
            }
            g.a().f113698b = j3;
            return this;
        }

        public final a i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            com.tencent.halley.downloader.a.a.b(i3);
            return this;
        }

        public final a j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            com.tencent.halley.downloader.a.a.a(i3);
            return this;
        }

        public final a k(IDownloadLogProxy iDownloadLogProxy) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (a) iPatchRedirector.redirect((short) 16, (Object) this, (Object) iDownloadLogProxy);
            }
            com.tencent.halley.common.utils.d.a(iDownloadLogProxy);
            return this;
        }

        public final a l(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (a) iPatchRedirector.redirect((short) 13, (Object) this, z16);
            }
            h.a().f113703a = z16;
            return this;
        }

        public final a m(DownloaderTaskCategory downloaderTaskCategory, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloaderTaskCategory, i3);
            }
            com.tencent.halley.downloader.f.a.a().a(downloaderTaskCategory, i3);
            return this;
        }

        public final a n(List<String> list) {
            com.tencent.halley.downloader.c.c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
                cVar = c.a.f113689a;
                cVar.f113687a.clear();
                cVar.f113687a.addAll(list);
                return this;
            }
            return (a) iPatchRedirector.redirect((short) 25, (Object) this, (Object) list);
        }

        public final a o(boolean z16) {
            com.tencent.halley.downloader.c.c cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
                cVar = c.a.f113689a;
                cVar.f113688b = z16;
                return this;
            }
            return (a) iPatchRedirector.redirect((short) 26, (Object) this, z16);
        }
    }

    public static a a() {
        return new a();
    }
}
