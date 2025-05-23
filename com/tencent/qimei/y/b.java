package com.tencent.qimei.y;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class b extends BroadcastReceiver implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    public static b f343429f;

    /* renamed from: a, reason: collision with root package name */
    public final Map<c, String> f343430a;

    /* renamed from: b, reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f343431b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f343432c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f343433d;

    /* renamed from: e, reason: collision with root package name */
    public ConnectivityManager f343434e;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f343430a = new ConcurrentHashMap();
        this.f343432c = false;
        this.f343433d = false;
    }

    public static b a() {
        if (f343429f == null) {
            synchronized (b.class) {
                if (f343429f == null) {
                    f343429f = new b();
                }
            }
        }
        return f343429f;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
        } else if (!this.f343432c) {
            com.tencent.qimei.t.a.a().a(this);
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"MissingPermission"})
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f343432c = true;
        if (com.tencent.qimei.f.a.b()) {
            Iterator<c> it = this.f343430a.keySet().iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        } else {
            Iterator<c> it5 = this.f343430a.keySet().iterator();
            while (it5.hasNext()) {
                it5.next().d();
            }
        }
        this.f343432c = false;
    }
}
