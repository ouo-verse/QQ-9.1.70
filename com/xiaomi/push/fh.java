package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class fh extends ep {
    protected volatile long A;
    private int B;
    private long C;

    /* renamed from: t, reason: collision with root package name */
    protected Exception f388863t;

    /* renamed from: u, reason: collision with root package name */
    protected Socket f388864u;

    /* renamed from: v, reason: collision with root package name */
    String f388865v;

    /* renamed from: w, reason: collision with root package name */
    private String f388866w;

    /* renamed from: x, reason: collision with root package name */
    protected XMPushService f388867x;

    /* renamed from: y, reason: collision with root package name */
    protected volatile long f388868y;

    /* renamed from: z, reason: collision with root package name */
    protected volatile long f388869z;

    public fh(XMPushService xMPushService, eq eqVar) {
        super(xMPushService, eqVar);
        this.f388863t = null;
        this.f388865v = null;
        this.f388868y = 0L;
        this.f388869z = 0L;
        this.A = 0L;
        this.C = 0L;
        this.f388867x = xMPushService;
    }

    private void K(eq eqVar) {
        M(eqVar.k(), eqVar.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0283 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0287 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0283 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void M(String str, int i3) {
        StringBuilder sb5;
        long j3;
        int i16;
        String str2;
        boolean z16;
        Iterator<String> it;
        String str3;
        ax axVar;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        boolean z17;
        this.f388863t = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int intValue = jz4.c.b("get bucket for host : " + str).intValue();
        ax G = G(str);
        jz4.c.l(Integer.valueOf(intValue));
        if (G != null) {
            arrayList = G.e(true);
        }
        ax x16 = bb.c().x(str);
        if (x16 != null) {
            Iterator<String> it5 = x16.e(true).iterator();
            while (it5.hasNext()) {
                String next = it5.next();
                if (arrayList.indexOf(next) == -1) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        long j16 = 0;
        this.A = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String j17 = au.j(this.f388867x);
        StringBuilder sb6 = new StringBuilder();
        Iterator<String> it6 = arrayList.iterator();
        String str10 = "";
        int i17 = 0;
        while (it6.hasNext()) {
            String next2 = it6.next();
            long currentTimeMillis = System.currentTimeMillis();
            this.f388762a++;
            int i18 = i17 + 1;
            try {
                jz4.c.m("begin to connect to " + next2);
                this.f388864u = H();
                this.f388864u.connect(az.d(next2, i3), 8000);
                jz4.c.m("tcp connected");
                try {
                    this.f388864u.setTcpNoDelay(true);
                    this.f388866w = next2;
                    I();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    this.f388763b = currentTimeMillis2;
                    this.f388772k = j17;
                    if (G != null) {
                        it = it6;
                        sb5 = sb6;
                        str3 = j17;
                        z17 = true;
                        j3 = 0;
                        axVar = G;
                        try {
                            G.s(next2, currentTimeMillis2, 0L);
                        } catch (Exception e16) {
                            e = e16;
                            str4 = str10;
                            str5 = str3;
                            try {
                                this.f388863t = e;
                                jz4.c.B("SMACK: Could not connect to:" + next2);
                                sb5.append("SMACK: Could not connect to ");
                                sb5.append(next2);
                                sb5.append(" port:");
                                sb5.append(i3);
                                sb5.append(" err:");
                                sb5.append(this.f388863t.getClass().getSimpleName());
                                sb5.append("\n");
                                if (!TextUtils.isEmpty(str4)) {
                                    str2 = next2;
                                } else {
                                    str2 = str4 + "|" + next2;
                                }
                                dz.h(next2, this.f388863t);
                                if (axVar == null) {
                                    str7 = str5;
                                    axVar.t(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.f388863t);
                                } else {
                                    str7 = str5;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                jz4.c.B("SMACK: Could not connect to:" + next2);
                                sb5.append("SMACK: Could not connect to ");
                                sb5.append(next2);
                                sb5.append(" port:");
                                sb5.append(i3);
                                sb5.append(" err:");
                                sb5.append(this.f388863t.getClass().getSimpleName());
                                sb5.append("\n");
                                if (!TextUtils.isEmpty(str4)) {
                                    str8 = next2;
                                } else {
                                    str8 = str4 + "|" + next2;
                                }
                                dz.h(next2, this.f388863t);
                                if (axVar == null) {
                                    str9 = str5;
                                    axVar.t(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.f388863t);
                                } else {
                                    str9 = str5;
                                }
                                if (TextUtils.equals(str9, au.j(this.f388867x))) {
                                    str2 = str8;
                                    i16 = i18;
                                    z16 = false;
                                    bb.c().w();
                                    int elapsedRealtime2 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                                    if (z16) {
                                    }
                                } else {
                                    throw th;
                                }
                            }
                            if (TextUtils.equals(str7, au.j(this.f388867x))) {
                                i16 = i18;
                                z16 = false;
                                bb.c().w();
                                int elapsedRealtime22 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                                if (z16) {
                                }
                            } else {
                                str10 = str2;
                                sb6 = sb5;
                                j17 = str7;
                                i17 = i18;
                                it6 = it;
                                j16 = j3;
                                G = axVar;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            try {
                                this.f388863t = new Exception("abnormal exception", th);
                                jz4.c.q(th);
                                jz4.c.B("SMACK: Could not connect to:" + next2);
                                sb5.append("SMACK: Could not connect to ");
                                sb5.append(next2);
                                sb5.append(" port:");
                                sb5.append(i3);
                                sb5.append(" err:");
                                sb5.append(this.f388863t.getClass().getSimpleName());
                                sb5.append("\n");
                                if (!TextUtils.isEmpty(str10)) {
                                    str2 = next2;
                                } else {
                                    str2 = str10 + "|" + next2;
                                }
                                dz.h(next2, this.f388863t);
                                if (axVar != null) {
                                    axVar.t(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.f388863t);
                                }
                                str6 = str3;
                            } catch (Throwable th7) {
                                th = th7;
                                str4 = str10;
                                str5 = str3;
                                jz4.c.B("SMACK: Could not connect to:" + next2);
                                sb5.append("SMACK: Could not connect to ");
                                sb5.append(next2);
                                sb5.append(" port:");
                                sb5.append(i3);
                                sb5.append(" err:");
                                sb5.append(this.f388863t.getClass().getSimpleName());
                                sb5.append("\n");
                                if (!TextUtils.isEmpty(str4)) {
                                }
                                dz.h(next2, this.f388863t);
                                if (axVar == null) {
                                }
                                if (TextUtils.equals(str9, au.j(this.f388867x))) {
                                }
                            }
                            if (!TextUtils.equals(str6, au.j(this.f388867x))) {
                                str7 = str6;
                                str10 = str2;
                                sb6 = sb5;
                                j17 = str7;
                                i17 = i18;
                                it6 = it;
                                j16 = j3;
                                G = axVar;
                            } else {
                                i16 = i18;
                                z16 = false;
                                bb.c().w();
                                int elapsedRealtime222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                                if (z16) {
                                }
                            }
                        }
                    } else {
                        it = it6;
                        sb5 = sb6;
                        str3 = j17;
                        axVar = G;
                        z17 = true;
                        j3 = 0;
                    }
                    this.A = SystemClock.elapsedRealtime();
                    jz4.c.m("connected to " + next2 + " in " + this.f388763b);
                    str2 = str10;
                    z16 = z17;
                    i16 = i18;
                    break;
                } catch (Exception e17) {
                    e = e17;
                    it = it6;
                    sb5 = sb6;
                    axVar = G;
                    j3 = 0;
                    str4 = str10;
                    str5 = j17;
                    this.f388863t = e;
                    jz4.c.B("SMACK: Could not connect to:" + next2);
                    sb5.append("SMACK: Could not connect to ");
                    sb5.append(next2);
                    sb5.append(" port:");
                    sb5.append(i3);
                    sb5.append(" err:");
                    sb5.append(this.f388863t.getClass().getSimpleName());
                    sb5.append("\n");
                    if (!TextUtils.isEmpty(str4)) {
                    }
                    dz.h(next2, this.f388863t);
                    if (axVar == null) {
                    }
                    if (TextUtils.equals(str7, au.j(this.f388867x))) {
                    }
                } catch (Throwable th8) {
                    th = th8;
                    it = it6;
                    sb5 = sb6;
                    str3 = j17;
                    axVar = G;
                    j3 = 0;
                    this.f388863t = new Exception("abnormal exception", th);
                    jz4.c.q(th);
                    jz4.c.B("SMACK: Could not connect to:" + next2);
                    sb5.append("SMACK: Could not connect to ");
                    sb5.append(next2);
                    sb5.append(" port:");
                    sb5.append(i3);
                    sb5.append(" err:");
                    sb5.append(this.f388863t.getClass().getSimpleName());
                    sb5.append("\n");
                    if (!TextUtils.isEmpty(str10)) {
                    }
                    dz.h(next2, this.f388863t);
                    if (axVar != null) {
                    }
                    str6 = str3;
                    if (!TextUtils.equals(str6, au.j(this.f388867x))) {
                    }
                }
            } catch (Exception e18) {
                e = e18;
                it = it6;
                sb5 = sb6;
                axVar = G;
            } catch (Throwable th9) {
                th = th9;
                it = it6;
                sb5 = sb6;
                str3 = j17;
                axVar = G;
            }
        }
        sb5 = sb6;
        j3 = j16;
        i16 = i17;
        str2 = str10;
        z16 = false;
        bb.c().w();
        int elapsedRealtime2222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
        if (z16) {
            if (this.C == j3 || SystemClock.elapsedRealtime() - this.C > 480000) {
                this.C = SystemClock.elapsedRealtime();
                dz.d(0, ei.BATCH_TCP_CONN_FAIL.a(), elapsedRealtime2222, str2, au.v(this.f388867x.getApplicationContext()) ? 1 : 0);
            }
            throw new fi(sb5.toString());
        }
        dz.d(0, ei.BATCH_TCP_CONN_SUCCESS.a(), elapsedRealtime2222, str2, i16);
    }

    @Override // com.xiaomi.push.ep
    public void A(boolean z16) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long currentTimeMillis = System.currentTimeMillis();
        O(z16);
        com.xiaomi.push.service.as.c(this.f388867x).q();
        if (!z16) {
            this.f388867x.a(new XMPushService.j(13) { // from class: com.xiaomi.push.fh.1
                @Override // com.xiaomi.push.service.XMPushService.j
                public void a() {
                    Thread.yield();
                    if (fh.this.D() && !fh.this.r(elapsedRealtime)) {
                        com.xiaomi.push.service.as.c(fh.this.f388867x).m();
                        fh.this.f388867x.a(22, (Exception) null);
                    }
                }

                @Override // com.xiaomi.push.service.XMPushService.j
                public String e() {
                    return "check the ping-pong." + currentTimeMillis;
                }
            }, 10000L);
        }
    }

    public Context F() {
        return this.f388867x;
    }

    ax G(final String str) {
        ax b16 = bb.c().b(str, false);
        if (!b16.u()) {
            fn.c(new Runnable() { // from class: com.xiaomi.push.fh.3
                @Override // java.lang.Runnable
                public void run() {
                    bb.c().b(str, true);
                }
            });
        }
        return b16;
    }

    public Socket H() {
        return new Socket();
    }

    protected abstract void I();

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void J(int i3, Exception exc) {
        if (s() == 2) {
            return;
        }
        h(2, i3, exc);
        this.f388771j = "";
        try {
            this.f388864u.close();
        } catch (Throwable unused) {
        }
        this.f388868y = 0L;
        this.f388869z = 0L;
    }

    protected void L(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.A < MiniBoxNoticeInfo.MIN_5) {
            if (au.t(this.f388867x)) {
                int i3 = this.B + 1;
                this.B = i3;
                if (i3 >= 2) {
                    String d16 = d();
                    jz4.c.m("max short conn time reached, sink down current host:" + d16);
                    N(d16, 0L, exc);
                    this.B = 0;
                    return;
                }
                return;
            }
            return;
        }
        this.B = 0;
    }

    protected void N(String str, long j3, Exception exc) {
        ax b16 = bb.c().b(eq.b(), false);
        if (b16 != null) {
            b16.t(str, j3, 0L, exc);
            bb.c().w();
        }
    }

    protected abstract void O(boolean z16);

    public String P() {
        return this.f388771j;
    }

    public void Q(final int i3, final Exception exc) {
        au.u();
        this.f388867x.a(new XMPushService.j(2) { // from class: com.xiaomi.push.fh.2
            @Override // com.xiaomi.push.service.XMPushService.j
            public void a() {
                fh.this.f388867x.a(i3, exc);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String e() {
                return "shutdown the connection. " + i3 + ", " + exc;
            }
        });
    }

    public synchronized void R() {
        try {
            if (!D() && !B()) {
                h(0, 0, null);
                K(this.f388775n);
                return;
            }
            jz4.c.m("WARNING: current xmpp has connected");
        } catch (IOException e16) {
            throw new fi(e16);
        }
    }

    public void S() {
        this.f388868y = SystemClock.elapsedRealtime();
    }

    public void T() {
        this.f388869z = SystemClock.elapsedRealtime();
    }

    @Override // com.xiaomi.push.ep
    public String d() {
        return this.f388866w;
    }

    @Override // com.xiaomi.push.ep
    public void v(int i3, Exception exc) {
        J(i3, exc);
        if ((exc != null || i3 == 18) && this.A != 0) {
            L(exc);
        }
    }
}
