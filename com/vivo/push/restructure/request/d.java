package com.vivo.push.restructure.request;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.vivo.push.i;
import com.vivo.push.util.u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, b> f387830a;

    /* renamed from: b, reason: collision with root package name */
    private Integer f387831b;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f387832c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f387833d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static d f387834a = new d(0);
    }

    /* synthetic */ d(byte b16) {
        this();
    }

    private synchronized Integer b() {
        Integer valueOf;
        if (this.f387831b == null) {
            this.f387831b = 0;
        }
        if (this.f387831b.intValue() < 0 || this.f387831b.intValue() >= Integer.MAX_VALUE) {
            this.f387831b = 0;
        }
        valueOf = Integer.valueOf(this.f387831b.intValue() + 1);
        this.f387831b = valueOf;
        return new Integer(valueOf.intValue());
    }

    d() {
        this.f387830a = new ConcurrentHashMap();
        this.f387831b = null;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("request_timer_task\u2014\u2014thread");
        this.f387832c = baseHandlerThread;
        baseHandlerThread.start();
        this.f387833d = new e(this, this.f387832c.getLooper());
    }

    public static d a() {
        return a.f387834a;
    }

    public final void a(b bVar) {
        Integer b16 = b();
        int a16 = a(bVar.a().a(b16.intValue()));
        if (a16 != 0) {
            if (bVar.b() != null) {
                bVar.b().a(a16);
            }
        } else {
            if (bVar.c() <= 0 || bVar.b() == null) {
                return;
            }
            this.f387830a.put(b16, bVar);
            this.f387833d.sendEmptyMessageDelayed(b16.intValue(), bVar.c());
        }
    }

    public final void a(com.vivo.push.restructure.a.a aVar) {
        com.vivo.push.restructure.request.a.a h16;
        int b16;
        com.vivo.push.restructure.request.a.a.a aVar2;
        if (aVar == null || !aVar.g() || (b16 = (h16 = aVar.h()).b()) <= 0) {
            return;
        }
        this.f387833d.removeMessages(b16);
        b remove = this.f387830a.remove(Integer.valueOf(b16));
        if (remove == null || remove.b() == null || remove.a() == null) {
            return;
        }
        if (h16.c() == 0) {
            try {
                aVar2 = new com.vivo.push.restructure.request.a.a.a(aVar.i());
            } catch (JSONException e16) {
                e16.printStackTrace();
                aVar2 = null;
            }
            if (aVar2 != null) {
                remove.b().a((c) remove.a().a(aVar2));
                return;
            } else {
                remove.b().a(8003);
                return;
            }
        }
        remove.b().a(h16.c());
    }

    private static int a(Intent intent) {
        Context b16 = com.vivo.push.restructure.a.a().b();
        if (b16 == null) {
            return 8002;
        }
        i a16 = i.a(b16, "com.vivo.vms.aidlservice");
        if (a16.a() && !"com.vivo.pushservice".equals(b16.getPackageName())) {
            if (a16.a(intent.getExtras())) {
                return 0;
            }
            u.b("RequestManager", "send command error by aidl");
            u.c(b16, "send command error by aidl");
        }
        String k3 = com.vivo.push.restructure.a.a().e().k();
        if (TextUtils.isEmpty(k3)) {
            return 8001;
        }
        Intent intent2 = new Intent("com.vivo.pushservice.action.METHOD");
        intent2.setPackage(k3);
        intent2.setClassName(k3, "com.vivo.push.sdk.service.PushService");
        try {
            com.vivo.push.a.a.a(b16, intent2);
        } catch (Exception e16) {
            u.a("RequestManager", "CommandBridge startService exception: ", e16);
        }
        return 0;
    }
}
