package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.xiaomi.push.ep;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ey extends fh {
    private Thread D;
    private ee E;
    private ef F;
    private byte[] G;

    public ey(XMPushService xMPushService, eq eqVar) {
        super(xMPushService, eqVar);
    }

    private eb U(boolean z16) {
        em emVar = new em();
        if (z16) {
            emVar.k("1");
        }
        byte[] i3 = dz.i();
        if (i3 != null) {
            cz czVar = new cz();
            czVar.l(a.b(i3));
            emVar.n(czVar.h(), null);
        }
        return emVar;
    }

    private void Z() {
        try {
            this.E = new ee(this.f388864u.getInputStream(), this);
            this.F = new ef(this.f388864u.getOutputStream(), this);
            BaseThread baseThread = new BaseThread("Blob Reader (" + this.f388774m + ")") { // from class: com.xiaomi.push.ey.1
                @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        ey.this.E.c();
                    } catch (Exception e16) {
                        ey.this.Q(9, e16);
                    }
                }
            };
            this.D = baseThread;
            baseThread.start();
        } catch (Exception e16) {
            throw new fi("Error to init reader and writer", e16);
        }
    }

    @Override // com.xiaomi.push.fh
    protected synchronized void I() {
        Z();
        this.F.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.fh
    public synchronized void J(int i3, Exception exc) {
        ee eeVar = this.E;
        if (eeVar != null) {
            eeVar.e();
            this.E = null;
        }
        ef efVar = this.F;
        if (efVar != null) {
            try {
                efVar.c();
            } catch (Exception e16) {
                jz4.c.B("SlimConnection shutdown cause exception: " + e16);
            }
            this.F = null;
        }
        this.G = null;
        super.J(i3, exc);
    }

    @Override // com.xiaomi.push.fh
    protected void O(boolean z16) {
        if (this.F != null) {
            eb U = U(z16);
            jz4.c.m("[Slim] SND ping id=" + U.D());
            w(U);
            S();
            return;
        }
        throw new fi("The BlobWriter is null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(eb ebVar) {
        if (ebVar == null) {
            return;
        }
        if (com.xiaomi.push.service.ak.a(ebVar)) {
            eb ebVar2 = new eb();
            ebVar2.h(ebVar.a());
            ebVar2.l("SYNC", "ACK_RTT");
            ebVar2.k(ebVar.D());
            ebVar2.u(ebVar.s());
            ebVar2.i(ebVar.y());
            XMPushService xMPushService = this.f388776o;
            xMPushService.a(new com.xiaomi.push.service.aw(xMPushService, ebVar2));
        }
        if (ebVar.o()) {
            jz4.c.m("[Slim] RCV blob chid=" + ebVar.a() + "; id=" + ebVar.D() + "; errCode=" + ebVar.r() + "; err=" + ebVar.z());
        }
        if (ebVar.a() == 0) {
            if ("PING".equals(ebVar.e())) {
                jz4.c.m("[Slim] RCV ping id=" + ebVar.D());
                T();
            } else if ("CLOSE".equals(ebVar.e())) {
                Q(13, null);
            }
        }
        Iterator<ep.a> it = this.f388768g.values().iterator();
        while (it.hasNext()) {
            it.next().a(ebVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized byte[] X() {
        if (this.G == null && !TextUtils.isEmpty(this.f388771j)) {
            String g16 = com.xiaomi.push.service.ae.g();
            StringBuilder sb5 = new StringBuilder();
            String str = this.f388771j;
            sb5.append(str.substring(str.length() / 2));
            sb5.append(g16.substring(g16.length() / 2));
            this.G = com.xiaomi.push.service.aa.i(this.f388771j.getBytes(), sb5.toString().getBytes());
        }
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(fc fcVar) {
        if (fcVar == null) {
            return;
        }
        Iterator<ep.a> it = this.f388768g.values().iterator();
        while (it.hasNext()) {
            it.next().b(fcVar);
        }
    }

    @Override // com.xiaomi.push.ep
    @Deprecated
    public void l(fc fcVar) {
        w(eb.c(fcVar, null));
    }

    @Override // com.xiaomi.push.ep
    public synchronized void m(am.b bVar) {
        ea.a(bVar, P(), this);
    }

    @Override // com.xiaomi.push.ep
    public synchronized void o(String str, String str2) {
        ea.b(str, str2, this);
    }

    @Override // com.xiaomi.push.ep
    public void p(eb[] ebVarArr) {
        for (eb ebVar : ebVarArr) {
            w(ebVar);
        }
    }

    @Override // com.xiaomi.push.ep
    public boolean q() {
        return true;
    }

    @Override // com.xiaomi.push.ep
    public void w(eb ebVar) {
        ef efVar = this.F;
        if (efVar != null) {
            try {
                int a16 = efVar.a(ebVar);
                this.f388778q = SystemClock.elapsedRealtime();
                String E = ebVar.E();
                if (!TextUtils.isEmpty(E)) {
                    fo.j(this.f388776o, E, a16, false, true, System.currentTimeMillis());
                }
                Iterator<ep.a> it = this.f388769h.values().iterator();
                while (it.hasNext()) {
                    it.next().a(ebVar);
                }
                return;
            } catch (Exception e16) {
                throw new fi(e16);
            }
        }
        throw new fi("the writer is null.");
    }
}
