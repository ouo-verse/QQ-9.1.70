package com.tencent.luggage.wxa.uk;

import com.tencent.luggage.wxa.tn.o0;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final Set f142726a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public final o0.b f142727b = new a();

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.xd.d f142728c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements o0.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.tn.o0.b
        public void a(String str, long j3) {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
            com.tencent.luggage.wxa.xd.r.c(i.this.f142728c);
            i.this.a(str, j3);
        }
    }

    public void b() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandUserCaptureScreenMonitor", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        try {
            com.tencent.luggage.wxa.tn.o0.a(com.tencent.luggage.wxa.tn.z.c(), null);
        } catch (SecurityException e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandUserCaptureScreenMonitor", e16, "[NOT CRASH] pause set null callback", new Object[0]);
        }
    }

    public void c() {
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandUserCaptureScreenMonitor", "onResume");
        try {
            com.tencent.luggage.wxa.tn.o0.a(com.tencent.luggage.wxa.tn.z.c(), this.f142727b);
        } catch (SecurityException e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandUserCaptureScreenMonitor", e16, "[NOT CRASH] resume set callback", new Object[0]);
        }
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar) {
        this.f142728c = dVar;
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandUserCaptureScreenMonitor", "init");
        try {
            com.tencent.luggage.wxa.tn.o0.a(com.tencent.luggage.wxa.tn.z.c(), this.f142727b);
        } catch (SecurityException e16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrandUserCaptureScreenMonitor", e16, "[NOT CRASH] init set callback", new Object[0]);
        }
    }

    public void a() {
        this.f142726a.clear();
    }

    public final void a(String str, long j3) {
        Iterator it = this.f142726a.iterator();
        while (it.hasNext()) {
            ((o0.b) it.next()).a(str, j3);
        }
    }
}
