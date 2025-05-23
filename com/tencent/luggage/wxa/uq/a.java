package com.tencent.luggage.wxa.uq;

import android.util.Log;
import com.tencent.xweb.location.XWebLocationProxy;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static a f142841b;

    /* renamed from: a, reason: collision with root package name */
    public XWebLocationProxy f142842a;

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f142841b == null) {
                f142841b = new a();
            }
            aVar = f142841b;
        }
        return aVar;
    }

    public boolean b() {
        if (this.f142842a != null) {
            return true;
        }
        return false;
    }

    public void c() {
        XWebLocationProxy xWebLocationProxy = this.f142842a;
        if (xWebLocationProxy != null) {
            xWebLocationProxy.stop();
        }
    }

    public void a(XWebLocationProxy xWebLocationProxy) {
        Log.i("XWebLocationProxyManager", "setLocationProxyImpl: " + xWebLocationProxy);
        this.f142842a = xWebLocationProxy;
    }

    public boolean a(boolean z16) {
        XWebLocationProxy xWebLocationProxy = this.f142842a;
        if (xWebLocationProxy != null) {
            return xWebLocationProxy.start(z16);
        }
        return false;
    }
}
