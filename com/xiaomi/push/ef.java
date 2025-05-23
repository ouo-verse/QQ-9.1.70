package com.xiaomi.push;

import android.os.Build;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ef {

    /* renamed from: a, reason: collision with root package name */
    ByteBuffer f388675a = ByteBuffer.allocate(2048);

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f388676b = ByteBuffer.allocate(4);

    /* renamed from: c, reason: collision with root package name */
    private Adler32 f388677c = new Adler32();

    /* renamed from: d, reason: collision with root package name */
    private ey f388678d;

    /* renamed from: e, reason: collision with root package name */
    private OutputStream f388679e;

    /* renamed from: f, reason: collision with root package name */
    private int f388680f;

    /* renamed from: g, reason: collision with root package name */
    private int f388681g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f388682h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(OutputStream outputStream, ey eyVar) {
        this.f388679e = new BufferedOutputStream(outputStream);
        this.f388678d = eyVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f388680f = timeZone.getRawOffset() / 3600000;
        this.f388681g = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(eb ebVar) {
        int x16 = ebVar.x();
        if (x16 > 32768) {
            jz4.c.m("Blob size=" + x16 + " should be less than 32768 Drop blob chid=" + ebVar.a() + " id=" + ebVar.D());
            return 0;
        }
        this.f388675a.clear();
        int i3 = x16 + 8 + 4;
        if (i3 > this.f388675a.capacity() || this.f388675a.capacity() > 4096) {
            this.f388675a = ByteBuffer.allocate(i3);
        }
        this.f388675a.putShort((short) -15618);
        this.f388675a.putShort((short) 5);
        this.f388675a.putInt(x16);
        int position = this.f388675a.position();
        this.f388675a = ebVar.f(this.f388675a);
        if (!"CONN".equals(ebVar.e())) {
            if (this.f388682h == null) {
                this.f388682h = this.f388678d.X();
            }
            com.xiaomi.push.service.aa.j(this.f388682h, this.f388675a.array(), true, position, x16);
        }
        this.f388677c.reset();
        this.f388677c.update(this.f388675a.array(), 0, this.f388675a.position());
        this.f388676b.putInt(0, (int) this.f388677c.getValue());
        this.f388679e.write(this.f388675a.array(), 0, this.f388675a.position());
        this.f388679e.write(this.f388676b.array(), 0, 4);
        this.f388679e.flush();
        int position2 = this.f388675a.position() + 4;
        jz4.c.z("[Slim] Wrote {cmd=" + ebVar.e() + ";chid=" + ebVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void b() {
        ct ctVar = new ct();
        ctVar.l(106);
        ctVar.p(ia.a());
        ctVar.v(ii.d());
        ctVar.A(com.xiaomi.push.service.ae.g());
        ctVar.t(48);
        ctVar.F(this.f388678d.t());
        ctVar.J(this.f388678d.d());
        ctVar.N(Locale.getDefault().toString());
        int i3 = Build.VERSION.SDK_INT;
        ctVar.z(i3);
        ctVar.E(g.b(this.f388678d.F(), "com.xiaomi.xmsf"));
        byte[] h16 = this.f388678d.c().h();
        if (h16 != null) {
            ctVar.o(cp.m(h16));
        }
        eb ebVar = new eb();
        ebVar.h(0);
        ebVar.l("CONN", null);
        ebVar.j(0L, "xiaomi.com", null);
        ebVar.n(ctVar.h(), null);
        a(ebVar);
        jz4.c.m("[slim] open conn: andver=" + i3 + " sdk=48 tz=" + this.f388680f + ":" + this.f388681g + " Model=" + ia.a() + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void c() {
        eb ebVar = new eb();
        ebVar.l("CLOSE", null);
        a(ebVar);
        this.f388679e.close();
    }
}
