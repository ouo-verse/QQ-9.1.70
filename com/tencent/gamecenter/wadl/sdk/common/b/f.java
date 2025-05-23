package com.tencent.gamecenter.wadl.sdk.common.b;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static String f107021a = "info.3g.qq.com";

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean[] f107022d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f107023e;

        a(boolean[] zArr, CountDownLatch countDownLatch) {
            this.f107022d = zArr;
            this.f107023e = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f107022d[0] = f.b();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (this.f107023e.getCount() > 0) {
                this.f107023e.countDown();
            }
        }
    }

    public static boolean a() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean[] zArr = {false};
        com.tencent.gamecenter.wadl.sdk.downloader.e.b.a().b(new a(zArr, countDownLatch));
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
        }
        return zArr[0];
    }

    public static boolean b() {
        return a(f107021a, 80, 5000);
    }

    public static boolean a(String str, int i3, int i16) {
        Socket socket;
        boolean z16;
        try {
            socket = new Socket();
        } catch (Throwable th5) {
            th = th5;
            socket = null;
        }
        try {
            socket.connect(new InetSocketAddress(str, i3), i16);
            z16 = socket.isConnected();
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                z16 = false;
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
        return z16;
    }
}
