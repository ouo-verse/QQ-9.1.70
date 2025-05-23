package com.xiaomi.push;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;

/* compiled from: P */
/* loaded from: classes28.dex */
public class dx implements es {
    private long F;
    private long G;

    /* renamed from: d, reason: collision with root package name */
    XMPushService f388629d;

    /* renamed from: e, reason: collision with root package name */
    ep f388630e;

    /* renamed from: f, reason: collision with root package name */
    private int f388631f;

    /* renamed from: h, reason: collision with root package name */
    private Exception f388632h;

    /* renamed from: m, reason: collision with root package name */
    private long f388634m = 0;
    private long C = 0;
    private long D = 0;
    private long E = 0;

    /* renamed from: i, reason: collision with root package name */
    private String f388633i = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(XMPushService xMPushService) {
        this.F = 0L;
        this.G = 0L;
        this.f388629d = xMPushService;
        c();
        int myUid = Process.myUid();
        try {
            this.G = TrafficStats.getUidRxBytes(myUid);
            this.F = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e16) {
            jz4.c.m("Failed to obtain traffic data during initialization: " + e16);
            this.G = -1L;
            this.F = -1L;
        }
    }

    private void c() {
        this.C = 0L;
        this.E = 0L;
        this.f388634m = 0L;
        this.D = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (au.t(this.f388629d)) {
            this.f388634m = elapsedRealtime;
        }
        if (this.f388629d.m462c()) {
            this.D = elapsedRealtime;
        }
    }

    private synchronized void d() {
        jz4.c.z("stat connpt = " + this.f388633i + " netDuration = " + this.C + " ChannelDuration = " + this.E + " channelConnectedTime = " + this.D);
        ej ejVar = new ej();
        ejVar.f388726a = (byte) 0;
        ejVar.a(ei.CHANNEL_ONLINE_RATE.a());
        ejVar.a(this.f388633i);
        ejVar.d((int) (System.currentTimeMillis() / 1000));
        ejVar.b((int) (this.C / 1000));
        ejVar.c((int) (this.E / 1000));
        dy.f().i(ejVar);
        c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception a() {
        return this.f388632h;
    }

    public synchronized void b() {
        XMPushService xMPushService = this.f388629d;
        if (xMPushService == null) {
            return;
        }
        String j3 = au.j(xMPushService);
        boolean v3 = au.v(this.f388629d);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j16 = this.f388634m;
        if (j16 > 0) {
            this.C += elapsedRealtime - j16;
            this.f388634m = 0L;
        }
        long j17 = this.D;
        if (j17 != 0) {
            this.E += elapsedRealtime - j17;
            this.D = 0L;
        }
        if (v3) {
            if ((!TextUtils.equals(this.f388633i, j3) && this.C > 30000) || this.C > 5400000) {
                d();
            }
            this.f388633i = j3;
            if (this.f388634m == 0) {
                this.f388634m = elapsedRealtime;
            }
            if (this.f388629d.m462c()) {
                this.D = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.es
    public void a(ep epVar) {
        this.f388631f = 0;
        this.f388632h = null;
        this.f388630e = epVar;
        this.f388633i = au.j(this.f388629d);
        dz.c(0, ei.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.es
    public void a(ep epVar, int i3, Exception exc) {
        long j3;
        long j16;
        if (this.f388631f == 0 && this.f388632h == null) {
            this.f388631f = i3;
            this.f388632h = exc;
            dz.k(epVar.d(), exc);
        }
        if (i3 == 22 && this.D != 0) {
            long b16 = epVar.b() - this.D;
            if (b16 < 0) {
                b16 = 0;
            }
            this.E += b16 + (ev.f() / 2);
            this.D = 0L;
        }
        b();
        int myUid = Process.myUid();
        try {
            j3 = TrafficStats.getUidRxBytes(myUid);
            j16 = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e16) {
            jz4.c.m("Failed to obtain traffic data: " + e16);
            j3 = -1;
            j16 = -1L;
        }
        jz4.c.z("Stats rx=" + (j3 - this.G) + ", tx=" + (j16 - this.F));
        this.G = j3;
        this.F = j16;
    }

    @Override // com.xiaomi.push.es
    public void b(ep epVar) {
        b();
        this.D = SystemClock.elapsedRealtime();
        dz.e(0, ei.CONN_SUCCESS.a(), epVar.d(), epVar.a());
    }

    @Override // com.xiaomi.push.es
    public void a(ep epVar, Exception exc) {
        dz.d(0, ei.CHANNEL_CON_FAIL.a(), 1, epVar.d(), au.v(this.f388629d) ? 1 : 0);
        b();
    }
}
