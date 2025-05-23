package com.xiaomi.push.service;

import com.xiaomi.push.dy;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public class ab {

    /* renamed from: f, reason: collision with root package name */
    private static int f389561f = 300000;

    /* renamed from: a, reason: collision with root package name */
    private XMPushService f389562a;

    /* renamed from: d, reason: collision with root package name */
    private int f389565d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f389566e = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f389563b = 500;

    /* renamed from: c, reason: collision with root package name */
    private long f389564c = 0;

    public ab(XMPushService xMPushService) {
        this.f389562a = xMPushService;
    }

    private int a() {
        double d16;
        if (this.f389565d > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i3 = this.f389565d;
        if (i3 > 4) {
            d16 = 60000.0d;
        } else if (i3 > 1) {
            d16 = 10000.0d;
        } else {
            if (this.f389564c == 0) {
                return 0;
            }
            if (System.currentTimeMillis() - this.f389564c < 310000) {
                int i16 = this.f389563b;
                int i17 = f389561f;
                if (i16 >= i17) {
                    return i16;
                }
                int i18 = this.f389566e + 1;
                this.f389566e = i18;
                if (i18 >= 4) {
                    return i17;
                }
                this.f389563b = (int) (i16 * 1.5d);
                return i16;
            }
            this.f389563b = 1000;
            this.f389566e = 0;
            return 0;
        }
        return (int) (random * d16);
    }

    public void b() {
        this.f389564c = System.currentTimeMillis();
        this.f389562a.a(1);
        this.f389565d = 0;
    }

    public void c(boolean z16) {
        if (this.f389562a.m457a()) {
            if (z16) {
                if (!this.f389562a.m458a(1)) {
                    this.f389565d++;
                }
                this.f389562a.a(1);
                jz4.c.n("ReconnectionManager", "-->tryReconnect(): exec ConnectJob");
                XMPushService xMPushService = this.f389562a;
                xMPushService.getClass();
                xMPushService.a(new XMPushService.e());
                return;
            }
            if (this.f389562a.m458a(1)) {
                return;
            }
            int a16 = a();
            this.f389565d++;
            jz4.c.m("schedule reconnect in " + a16 + "ms");
            XMPushService xMPushService2 = this.f389562a;
            xMPushService2.getClass();
            xMPushService2.a(new XMPushService.e(), (long) a16);
            if (this.f389565d == 2 && dy.f().k()) {
                z.e();
            }
            if (this.f389565d == 3) {
                z.b();
                return;
            }
            return;
        }
        jz4.c.z("should not reconnect as no client or network.");
    }
}
