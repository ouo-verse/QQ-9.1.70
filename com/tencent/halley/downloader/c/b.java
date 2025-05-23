package com.tencent.halley.downloader.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f113680d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f113681a;

    /* renamed from: b, reason: collision with root package name */
    public Network f113682b;

    /* renamed from: c, reason: collision with root package name */
    public ConnectivityManager f113683c;

    /* renamed from: e, reason: collision with root package name */
    private Network f113684e;

    /* renamed from: f, reason: collision with root package name */
    private Context f113685f;

    b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f113681a = false;
        this.f113684e = null;
        this.f113682b = null;
        this.f113685f = context;
        this.f113683c = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static b a() {
        if (f113680d == null) {
            synchronized (b.class) {
                if (f113680d == null) {
                    f113680d = new b(com.tencent.halley.common.a.a());
                }
            }
        }
        return f113680d;
    }
}
