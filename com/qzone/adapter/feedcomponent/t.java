package com.qzone.adapter.feedcomponent;

import android.os.Handler;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    IServiceCallback f41924a;

    /* renamed from: b, reason: collision with root package name */
    WeakReference<Handler> f41925b;

    t() {
    }

    public static t b() {
        return new t();
    }

    public static t c(Handler handler) {
        t tVar = new t();
        tVar.f41925b = new WeakReference<>(handler);
        return tVar;
    }

    public Handler a() {
        WeakReference<Handler> weakReference = this.f41925b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void d(s sVar) {
        if (sVar == null || sVar.a() == null) {
            return;
        }
        IServiceCallback iServiceCallback = this.f41924a;
        if (iServiceCallback != null) {
            iServiceCallback.onResult(sVar.a());
            return;
        }
        WeakReference<Handler> weakReference = this.f41925b;
        Handler handler = weakReference == null ? null : weakReference.get();
        if (handler != null) {
            sVar.a().sendToHandler(handler);
        }
    }
}
