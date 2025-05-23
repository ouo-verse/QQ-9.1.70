package com.tencent.halley.common.a;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f113265a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15808);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f113265a = "info.3g.qq.com";
        }
    }

    public static boolean a() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean[] zArr = {false};
        d.a().f113264a.execute(new Runnable(zArr, countDownLatch) { // from class: com.tencent.halley.common.a.g.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ boolean[] f113266a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CountDownLatch f113267b;

            {
                this.f113266a = zArr;
                this.f113267b = countDownLatch;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) zArr, (Object) countDownLatch);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    this.f113266a[0] = g.b();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                this.f113267b.countDown();
            }
        });
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        return zArr[0];
    }

    public static boolean b() {
        return a(f113265a);
    }

    private static boolean a(String str) {
        Socket socket = null;
        try {
            Socket socket2 = new Socket();
            try {
                socket2.connect(new InetSocketAddress(str, 80), 5000);
                boolean isConnected = socket2.isConnected();
                try {
                    socket2.close();
                    return isConnected;
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    return isConnected;
                }
            } catch (Throwable th6) {
                th = th6;
                socket = socket2;
                try {
                    th.printStackTrace();
                    return false;
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }
}
