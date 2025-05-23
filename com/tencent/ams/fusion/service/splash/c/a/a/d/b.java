package com.tencent.ams.fusion.service.splash.c.a.a.d;

import com.tencent.ams.fusion.service.splash.c.a.a.b;
import com.tencent.ams.fusion.service.splash.c.a.a.b.c;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends a implements c.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public pt.b f70447d;

    /* renamed from: e, reason: collision with root package name */
    private final CountDownLatch f70448e;

    /* renamed from: f, reason: collision with root package name */
    private ot.c f70449f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.ams.fusion.service.splash.c.a.a.c.b.b f70450g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f70451h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f70452i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f70453j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.ams.fusion.service.splash.c.a.a.b.c f70454k;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f70448e = new CountDownLatch(1);
        this.f70450g = new com.tencent.ams.fusion.service.splash.c.a.a.c.b.b();
        this.f70452i = false;
        this.f70453j = false;
        this.f70454k = null;
    }

    private void t(int i3, int i16, long j3) {
        ot.b.b(this.f70449f, this.f70450g, i3, j3, i16);
    }

    private boolean u() {
        return v().equalsIgnoreCase(w());
    }

    private String v() {
        return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault()).format(new Date());
    }

    private String w() {
        return com.tencent.ams.fusion.a.c.c("com.tencent.ams.sp.ad_status", "first_play_date", "");
    }

    private void x() {
        SplashOrder splashOrder;
        if (!this.f70451h) {
            pt.b bVar = this.f70447d;
            if (bVar != null && bVar.b() != null) {
                splashOrder = this.f70447d.b().b();
            } else {
                splashOrder = null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(splashOrder);
            this.f70450g.d(arrayList);
            this.f70450g.e(false);
            this.f70448e.countDown();
        }
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.d.a, pt.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f70451h = true;
        com.tencent.ams.fusion.service.splash.c.a.a.b.c cVar = this.f70454k;
        if (cVar != null) {
            cVar.e();
        }
        if (this.f70448e.getCount() == 0 || this.f70450g.a() != null) {
            return;
        }
        t(9, (int) (System.currentTimeMillis() - this.f70446c), WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
        this.f70450g.f(64);
        this.f70448e.countDown();
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
    public void a_() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.f70453j = !this.f70452i;
        if (!this.f70451h && this.f70453j) {
            t(8, (int) (System.currentTimeMillis() - this.f70446c), WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
        }
    }

    @Override // pt.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    @Override // pt.a
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 64;
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (this.f70453j) {
            x();
        }
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
    public void h(com.tencent.ams.fusion.service.resdownload.b bVar, boolean z16, int i3) {
        SplashOrder splashOrder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, bVar, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (z16) {
            this.f70452i = true;
        }
        pt.b bVar2 = this.f70447d;
        if (bVar2 != null && bVar2.b() != null) {
            splashOrder = this.f70447d.b().b();
        } else {
            splashOrder = null;
        }
        m(splashOrder, i3, 158, Integer.MIN_VALUE);
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
    public void i(boolean z16, int i3) {
        SplashOrder splashOrder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        pt.b bVar = this.f70447d;
        if (bVar != null && bVar.b() != null) {
            splashOrder = this.f70447d.b().b();
        } else {
            splashOrder = null;
        }
        m(splashOrder, i3, 157, Integer.MIN_VALUE);
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.d.a
    protected ot.d r() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ot.d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        pt.b s16 = s();
        this.f70447d = s16;
        if (s16 != null && s16.a() != null && this.f70447d.b() != null && this.f70447d.b().b() != null) {
            t(7, (int) (System.currentTimeMillis() - currentTimeMillis), WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
            ot.c a16 = this.f70447d.a();
            this.f70449f = a16;
            if (a16.a() && this.f70449f.d()) {
                com.tencent.ams.fusion.a.f.g("FirstPlaySelectOrderTask exec error, isHotStart");
                this.f70450g.f(4);
            } else if (u()) {
                com.tencent.ams.fusion.a.f.g("FirstPlaySelectOrderTask exec error, hasPlayedToday");
                this.f70450g.f(8);
            } else {
                SplashOrder b16 = this.f70447d.b().b();
                if (b16.bh() == 1 && this.f70449f.c()) {
                    com.tencent.ams.fusion.a.f.g("FirstPlaySelectOrderTask exec error, needFilterOneShot");
                    this.f70450g.f(16);
                    t(1, (int) (System.currentTimeMillis() - currentTimeMillis), WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
                } else if (b16.aA()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(b16);
                    this.f70450g.d(arrayList);
                    this.f70450g.e(false);
                    t(4, (int) (System.currentTimeMillis() - currentTimeMillis), 5L);
                } else {
                    t(6, (int) (System.currentTimeMillis() - currentTimeMillis), 5L);
                    if (this.f70454k == null) {
                        c.b bVar = new c.b();
                        bVar.f70425a = b16;
                        bVar.f70426b = this;
                        bVar.f70427c = this.f70449f.i();
                        bVar.f70428d = this.f70449f.h();
                        this.f70454k = new b.c(bVar);
                    }
                    this.f70454k.f();
                    try {
                        z16 = this.f70448e.await(com.tencent.ams.fusion.service.splash.a.a.d().c(this.f70449f.h()), TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e16) {
                        com.tencent.ams.fusion.a.f.d("FirstPlaySelectOrderTask exec error ", e16);
                        z16 = false;
                    }
                    if (!z16 && b16.aA()) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(b16);
                        this.f70450g.d(arrayList2);
                        this.f70450g.e(false);
                    }
                }
            }
        } else {
            this.f70450g.f(1);
        }
        this.f70450g.b(d());
        if (this.f70450g.a() == null) {
            t(3, (int) (System.currentTimeMillis() - currentTimeMillis), this.f70450g.l());
        } else {
            t(2, (int) (System.currentTimeMillis() - currentTimeMillis), WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
        }
        return this.f70450g;
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
    public void a(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else if (z16) {
            this.f70452i = true;
            this.f70450g.f(32);
            this.f70448e.countDown();
        }
    }

    @Override // com.tencent.ams.fusion.service.splash.c.a.a.b.c.a
    public void a(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else {
            pt.b bVar = this.f70447d;
            m((bVar == null || bVar.b() == null) ? null : this.f70447d.b().b(), i3, 156, Integer.MIN_VALUE);
        }
    }
}
