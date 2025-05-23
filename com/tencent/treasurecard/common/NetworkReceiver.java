package com.tencent.treasurecard.common;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.treasurecard.manager.d;
import com.tencent.treasurecard.util.a;
import so4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class NetworkReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static HandlerThread f381172b;

    /* renamed from: c, reason: collision with root package name */
    private static long f381173c;

    /* renamed from: d, reason: collision with root package name */
    private static long f381174d;

    /* renamed from: a, reason: collision with root package name */
    public Handler f381175a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12576);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("treasurecard");
        f381172b = baseHandlerThread;
        baseHandlerThread.start();
        f381173c = 0L;
        f381174d = 0L;
    }

    public NetworkReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f381175a = new Handler(f381172b.getLooper());
        }
    }

    @SuppressLint({"MissingPermission"})
    private void a(Context context, d dVar) {
        this.f381175a.post(new Runnable(context, dVar) { // from class: com.tencent.treasurecard.common.NetworkReceiver.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Context f381178d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ d f381179e;

            {
                this.f381178d = context;
                this.f381179e = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, NetworkReceiver.this, context, dVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                a.d();
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f381178d.getSystemService("connectivity");
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                if (networkInfo2 != null && networkInfo != null) {
                    boolean isConnected = networkInfo2.isConnected();
                    boolean isConnected2 = networkInfo.isConnected();
                    if (!isConnected2 && NetworkReceiver.this.d()) {
                        this.f381179e.f(1001, -1);
                        return;
                    } else {
                        if (!isConnected && isConnected2 && NetworkReceiver.this.c()) {
                            this.f381179e.j().i(null);
                            return;
                        }
                        return;
                    }
                }
                if (NetworkReceiver.this.c()) {
                    this.f381179e.j().i(null);
                }
            }
        });
    }

    private void b(Context context, d dVar) {
        this.f381175a.post(new Runnable(dVar, context) { // from class: com.tencent.treasurecard.common.NetworkReceiver.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ d f381176d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Context f381177e;

            {
                this.f381176d = dVar;
                this.f381177e = context;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, NetworkReceiver.this, dVar, context);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f381176d.j().c(this.f381177e);
                }
            }
        });
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f381174d < 2000) {
            return false;
        }
        f381174d = currentTimeMillis;
        return true;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f381173c < 2000) {
            return false;
        }
        f381173c = currentTimeMillis;
        return true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            return;
        }
        try {
            b i3 = d.i();
            if (!(i3 instanceof d)) {
                return;
            }
            if (context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                Log.e("TcSdkManager", "net permission denied");
            } else if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                a(context, (d) i3);
            } else if (intent.getAction().equals("android.intent.action.SIM_STATE_CHANGED")) {
                b(context, (d) i3);
            }
        } catch (Exception e16) {
            Log.e("TcSdkManager", "error:" + e16.getMessage());
        }
    }
}
