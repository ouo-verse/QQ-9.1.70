package com.xiaomi.push.service;

import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.xiaomi.push.cf;
import com.xiaomi.push.cp;
import com.xiaomi.push.cs;
import com.xiaomi.push.cv;
import com.xiaomi.push.cx;
import com.xiaomi.push.cy;
import com.xiaomi.push.cz;
import com.xiaomi.push.da;
import com.xiaomi.push.dz;
import com.xiaomi.push.eb;
import com.xiaomi.push.ei;
import com.xiaomi.push.eq;
import com.xiaomi.push.ez;
import com.xiaomi.push.fa;
import com.xiaomi.push.fb;
import com.xiaomi.push.fc;
import com.xiaomi.push.fo;
import com.xiaomi.push.service.am;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes28.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private XMPushService f389773a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(XMPushService xMPushService) {
        this.f389773a = xMPushService;
    }

    private void b(ez ezVar) {
        String k3 = ezVar.k();
        if (!TextUtils.isEmpty(k3)) {
            String[] split = k3.split(";");
            com.xiaomi.push.ax b16 = com.xiaomi.push.bb.c().b(eq.b(), false);
            if (b16 != null && split.length > 0) {
                b16.o(split);
                this.f389773a.a(20, (Exception) null);
                this.f389773a.a(true);
            }
        }
    }

    private void e(fc fcVar) {
        am.b b16;
        String o16 = fcVar.o();
        String m3 = fcVar.m();
        if (!TextUtils.isEmpty(o16) && !TextUtils.isEmpty(m3) && (b16 = am.c().b(m3, o16)) != null) {
            fo.j(this.f389773a, b16.f389605a, fo.b(fcVar.f()), true, true, System.currentTimeMillis());
        }
    }

    private void f(eb ebVar) {
        am.b b16;
        String F = ebVar.F();
        String num = Integer.toString(ebVar.a());
        if (!TextUtils.isEmpty(F) && !TextUtils.isEmpty(num) && (b16 = am.c().b(num, F)) != null) {
            fo.j(this.f389773a, b16.f389605a, ebVar.x(), true, true, System.currentTimeMillis());
        }
    }

    public void a(eb ebVar) {
        if (5 != ebVar.a()) {
            f(ebVar);
        }
        try {
            d(ebVar);
        } catch (Exception e16) {
            jz4.c.o("handle Blob chid = " + ebVar.a() + " cmd = " + ebVar.e() + " packetid = " + ebVar.D() + " failure ", e16);
        }
    }

    public void c(fc fcVar) {
        if (!"5".equals(fcVar.m())) {
            e(fcVar);
        }
        String m3 = fcVar.m();
        if (TextUtils.isEmpty(m3)) {
            m3 = "1";
            fcVar.p("1");
        }
        if (m3.equals("0")) {
            jz4.c.m("Received wrong packet with chid = 0 : " + fcVar.f());
        }
        if (fcVar instanceof fa) {
            ez b16 = fcVar.b("kick");
            if (b16 != null) {
                String o16 = fcVar.o();
                String f16 = b16.f("type");
                String f17 = b16.f("reason");
                jz4.c.m("kicked by server, chid=" + m3 + " res=" + am.b.e(o16) + " type=" + f16 + " reason=" + f17);
                if ("wait".equals(f16)) {
                    am.b b17 = am.c().b(m3, o16);
                    if (b17 != null) {
                        this.f389773a.a(b17);
                        b17.k(am.c.unbind, 3, 0, f17, f16);
                        return;
                    }
                    return;
                }
                this.f389773a.a(m3, o16, 3, f17, f16);
                am.c().n(m3, o16);
                return;
            }
        } else if (fcVar instanceof fb) {
            fb fbVar = (fb) fcVar;
            if ("redir".equals(fbVar.B())) {
                ez b18 = fbVar.b("hosts");
                if (b18 != null) {
                    b(b18);
                    return;
                }
                return;
            }
        }
        this.f389773a.m459b().j(this.f389773a, m3, fcVar);
    }

    public void d(eb ebVar) {
        String e16 = ebVar.e();
        if (ebVar.a() != 0) {
            String num = Integer.toString(ebVar.a());
            if ("SECMSG".equals(ebVar.e())) {
                if (!ebVar.o()) {
                    this.f389773a.m459b().i(this.f389773a, num, ebVar);
                    return;
                }
                jz4.c.m("Recv SECMSG errCode = " + ebVar.r() + " errStr = " + ebVar.z());
                return;
            }
            if ("BIND".equals(e16)) {
                cs m3 = cs.m(ebVar.p());
                String F = ebVar.F();
                am.b b16 = am.c().b(num, F);
                if (b16 == null) {
                    return;
                }
                if (m3.o()) {
                    jz4.c.m("SMACK: channel bind succeeded, chid=" + ebVar.a());
                    b16.k(am.c.binded, 1, 0, null, null);
                    return;
                }
                String n3 = m3.n();
                if (WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH.equals(n3)) {
                    if ("invalid-sig".equals(m3.q())) {
                        jz4.c.m("SMACK: bind error invalid-sig token = " + b16.f389607c + " sec = " + b16.f389613i);
                        dz.d(0, ei.BIND_INVALID_SIG.a(), 1, null, 0);
                    }
                    b16.k(am.c.unbind, 1, 5, m3.q(), n3);
                    am.c().n(num, F);
                } else if ("cancel".equals(n3)) {
                    b16.k(am.c.unbind, 1, 7, m3.q(), n3);
                    am.c().n(num, F);
                } else if ("wait".equals(n3)) {
                    this.f389773a.a(b16);
                    b16.k(am.c.unbind, 1, 7, m3.q(), n3);
                }
                jz4.c.m("SMACK: channel bind failed, chid=" + num + " reason=" + m3.q());
                return;
            }
            if ("KICK".equals(e16)) {
                cv l3 = cv.l(ebVar.p());
                String F2 = ebVar.F();
                String m16 = l3.m();
                String p16 = l3.p();
                jz4.c.m("kicked by server, chid=" + num + " res= " + am.b.e(F2) + " type=" + m16 + " reason=" + p16);
                if ("wait".equals(m16)) {
                    am.b b17 = am.c().b(num, F2);
                    if (b17 != null) {
                        this.f389773a.a(b17);
                        b17.k(am.c.unbind, 3, 0, p16, m16);
                        return;
                    }
                    return;
                }
                this.f389773a.a(num, F2, 3, p16, m16);
                am.c().n(num, F2);
                return;
            }
            return;
        }
        if ("PING".equals(e16)) {
            byte[] p17 = ebVar.p();
            if (p17 != null && p17.length > 0) {
                cz o16 = cz.o(p17);
                if (o16.q()) {
                    ae.f().j(o16.k());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.f389773a.getPackageName())) {
                this.f389773a.m456a();
            }
            if ("1".equals(ebVar.D())) {
                jz4.c.m("received a server ping");
            } else {
                dz.j();
            }
            this.f389773a.m460b();
            return;
        }
        if ("SYNC".equals(e16)) {
            if ("CONF".equals(ebVar.t())) {
                ae.f().j(cp.m(ebVar.p()));
                return;
            }
            if (TextUtils.equals("U", ebVar.t())) {
                da p18 = da.p(ebVar.p());
                cf.b(this.f389773a).h(p18.q(), p18.v(), new Date(p18.j()), new Date(p18.s()), p18.x() * 1024, p18.A());
                eb ebVar2 = new eb();
                ebVar2.h(0);
                ebVar2.l(ebVar.e(), "UCA");
                ebVar2.k(ebVar.D());
                XMPushService xMPushService = this.f389773a;
                xMPushService.a(new aw(xMPushService, ebVar2));
                return;
            }
            if (TextUtils.equals("P", ebVar.t())) {
                cy m17 = cy.m(ebVar.p());
                eb ebVar3 = new eb();
                ebVar3.h(0);
                ebVar3.l(ebVar.e(), "PCA");
                ebVar3.k(ebVar.D());
                cy cyVar = new cy();
                if (m17.n()) {
                    cyVar.k(m17.j());
                }
                ebVar3.n(cyVar.h(), null);
                XMPushService xMPushService2 = this.f389773a;
                xMPushService2.a(new aw(xMPushService2, ebVar3));
                jz4.c.m("ACK msgP: id = " + ebVar.D());
                return;
            }
            return;
        }
        if ("NOTIFY".equals(ebVar.e())) {
            cx m18 = cx.m(ebVar.p());
            jz4.c.m("notify by server err = " + m18.q() + " desc = " + m18.n());
        }
    }
}
