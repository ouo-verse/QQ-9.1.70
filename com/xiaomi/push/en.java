package com.xiaomi.push;

import com.xiaomi.push.ep;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class en implements ew {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f388745g = false;

    /* renamed from: b, reason: collision with root package name */
    private ep f388747b;

    /* renamed from: a, reason: collision with root package name */
    private SimpleDateFormat f388746a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: c, reason: collision with root package name */
    private b f388748c = null;

    /* renamed from: d, reason: collision with root package name */
    private b f388749d = null;

    /* renamed from: e, reason: collision with root package name */
    private es f388750e = null;

    /* renamed from: f, reason: collision with root package name */
    private final String f388751f = "[Slim] ";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements eu, ex {

        /* renamed from: a, reason: collision with root package name */
        String f388753a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f388754b;

        b(boolean z16) {
            String str;
            this.f388754b = z16;
            if (z16) {
                str = " RCV ";
            } else {
                str = " Sent ";
            }
            this.f388753a = str;
        }

        @Override // com.xiaomi.push.ex
        /* renamed from: a */
        public boolean mo300a(fc fcVar) {
            return true;
        }

        @Override // com.xiaomi.push.eu
        public void b(eb ebVar) {
            if (en.f388745g) {
                jz4.c.z("[Slim] " + en.this.f388746a.format(new Date()) + this.f388753a + ebVar.toString());
            } else {
                jz4.c.z("[Slim] " + en.this.f388746a.format(new Date()) + this.f388753a + " Blob [" + ebVar.e() + "," + ebVar.a() + "," + com.xiaomi.push.service.m.b(ebVar.D()) + "]");
            }
            if (ebVar != null && ebVar.a() == 99999) {
                String e16 = ebVar.e();
                eb ebVar2 = null;
                if (!this.f388754b) {
                    if ("BIND".equals(e16)) {
                        jz4.c.m("build binded result for loopback.");
                        cs csVar = new cs();
                        csVar.l(true);
                        csVar.s("login success.");
                        csVar.p("success");
                        csVar.k("success");
                        eb ebVar3 = new eb();
                        ebVar3.n(csVar.h(), null);
                        ebVar3.m((short) 2);
                        ebVar3.h(99999);
                        ebVar3.l("BIND", null);
                        ebVar3.k(ebVar.D());
                        ebVar3.v(null);
                        ebVar3.B(ebVar.F());
                        ebVar2 = ebVar3;
                    } else if (!"UBND".equals(e16) && "SECMSG".equals(e16)) {
                        eb ebVar4 = new eb();
                        ebVar4.h(99999);
                        ebVar4.l("SECMSG", null);
                        ebVar4.B(ebVar.F());
                        ebVar4.k(ebVar.D());
                        ebVar4.m(ebVar.g());
                        ebVar4.v(ebVar.E());
                        ebVar4.n(ebVar.q(com.xiaomi.push.service.am.c().b(String.valueOf(99999), ebVar.F()).f389613i), null);
                        ebVar2 = ebVar4;
                    }
                }
                if (ebVar2 != null) {
                    for (Map.Entry<eu, ep.a> entry : en.this.f388747b.f().entrySet()) {
                        if (en.this.f388748c != entry.getKey()) {
                            entry.getValue().a(ebVar2);
                        }
                    }
                }
            }
        }

        @Override // com.xiaomi.push.eu
        public void a(fc fcVar) {
            if (en.f388745g) {
                jz4.c.z("[Slim] " + en.this.f388746a.format(new Date()) + this.f388753a + " PKT " + fcVar.f());
                return;
            }
            jz4.c.z("[Slim] " + en.this.f388746a.format(new Date()) + this.f388753a + " PKT [" + fcVar.m() + "," + fcVar.l() + "]");
        }
    }

    public en(ep epVar) {
        this.f388747b = epVar;
        d();
    }

    private void d() {
        this.f388748c = new b(true);
        this.f388749d = new b(false);
        ep epVar = this.f388747b;
        b bVar = this.f388748c;
        epVar.k(bVar, bVar);
        ep epVar2 = this.f388747b;
        b bVar2 = this.f388749d;
        epVar2.z(bVar2, bVar2);
        this.f388750e = new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements es {
        a() {
        }

        @Override // com.xiaomi.push.es
        public void a(ep epVar, int i3, Exception exc) {
            jz4.c.z("[Slim] " + en.this.f388746a.format(new Date()) + " Connection closed (" + en.this.f388747b.hashCode() + ")");
        }

        @Override // com.xiaomi.push.es
        public void b(ep epVar) {
            jz4.c.z("[Slim] " + en.this.f388746a.format(new Date()) + " Connection reconnected (" + en.this.f388747b.hashCode() + ")");
        }

        @Override // com.xiaomi.push.es
        public void a(ep epVar, Exception exc) {
            jz4.c.z("[Slim] " + en.this.f388746a.format(new Date()) + " Reconnection failed due to an exception (" + en.this.f388747b.hashCode() + ")");
            exc.printStackTrace();
        }

        @Override // com.xiaomi.push.es
        public void a(ep epVar) {
            jz4.c.z("[Slim] " + en.this.f388746a.format(new Date()) + " Connection started (" + en.this.f388747b.hashCode() + ")");
        }
    }
}
