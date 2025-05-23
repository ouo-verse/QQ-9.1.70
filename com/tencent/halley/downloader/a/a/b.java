package com.tencent.halley.downloader.a.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final LinkedBlockingQueue<HttpURLConnection> f113613a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f113614b;

    /* renamed from: c, reason: collision with root package name */
    private static Thread f113615c;

    /* renamed from: d, reason: collision with root package name */
    private String f113616d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f113617e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11655);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f113613a = new LinkedBlockingQueue<>();
            f113614b = null;
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113616d = "halley-downloader-ConnectionCloser";
        Runnable runnable = new Runnable() { // from class: com.tencent.halley.downloader.a.a.b.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                InputStream inputStream;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.halley.common.utils.d.a("ConnectionCloser", "closeRunnable#RUN", true);
                while (true) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) b.f113613a.take();
                        String host = httpURLConnection.getURL().getHost();
                        try {
                            httpURLConnection.disconnect();
                            boolean z16 = false;
                            try {
                                inputStream = httpURLConnection.getInputStream();
                            } catch (Exception e16) {
                                if (!(e16 instanceof FileNotFoundException)) {
                                    com.tencent.halley.common.utils.d.a("ConnectionCloser", "Exception closeRunnable#getInputStream - ".concat(String.valueOf(host)), (Throwable) e16, true);
                                }
                                try {
                                    inputStream = httpURLConnection.getErrorStream();
                                    z16 = true;
                                } catch (Exception e17) {
                                    com.tencent.halley.common.utils.d.a("ConnectionCloser", "Exception closeRunnable#getErrorStream - ".concat(String.valueOf(host)), (Throwable) e17, true);
                                    inputStream = null;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            com.tencent.halley.common.utils.d.c("ConnectionCloser", "Finish closeRunnable_" + z16 + " - " + host);
                        } catch (Exception e18) {
                            com.tencent.halley.common.utils.d.a("ConnectionCloser", "Exception closeRunnable - ".concat(String.valueOf(host)), (Throwable) e18, true);
                        }
                    } catch (Exception e19) {
                        com.tencent.halley.common.utils.d.c("ConnectionCloser", "Exception loop", e19);
                        return;
                    }
                }
            }
        };
        this.f113617e = runnable;
        BaseThread baseThread = new BaseThread(runnable, this.f113616d);
        f113615c = baseThread;
        baseThread.start();
        com.tencent.halley.common.utils.d.a("ConnectionCloser", "initThread start!!!", true);
    }

    public static b a() {
        if (f113614b == null) {
            synchronized (b.class) {
                if (f113614b == null) {
                    f113614b = new b();
                }
            }
        }
        return f113614b;
    }

    public static void a(HttpURLConnection httpURLConnection) {
        try {
            LinkedBlockingQueue<HttpURLConnection> linkedBlockingQueue = f113613a;
            linkedBlockingQueue.put(httpURLConnection);
            com.tencent.halley.common.utils.d.c("ConnectionCloser", "post close: " + httpURLConnection.getURL().getHost() + ", size = " + linkedBlockingQueue.size());
        } catch (Exception e16) {
            com.tencent.halley.common.utils.d.c("ConnectionCloser", "post close exception, size = " + f113613a.size(), e16);
        }
    }
}
