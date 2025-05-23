package com.tencent.aelight.camera.ae.flashshow.autotest;

import com.tencent.aelight.camera.ae.flashshow.autotest.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import hq.a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private a.C10462a f64181a;

    /* renamed from: b, reason: collision with root package name */
    private int f64182b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f64183c;

    /* renamed from: d, reason: collision with root package name */
    private a.InterfaceC0552a f64184d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f64185e;

    public h(a.C10462a c10462a) {
        this.f64183c = false;
        this.f64181a = c10462a;
        if (c10462a.f405876c < 5) {
            c10462a.f405876c = 5;
        }
        if (c10462a.f405877d < 4) {
            c10462a.f405877d = 4;
        }
        this.f64183c = c10462a.f405884k == null;
        this.f64185e = new File(c10462a.f405874a).exists();
    }

    private void c() {
        HashMap<BeautyRealConfig.TYPE, Integer> d16 = this.f64181a.d();
        if (d16 == null || d16.size() == 0) {
            return;
        }
        for (Map.Entry<BeautyRealConfig.TYPE, Integer> entry : d16.entrySet()) {
            this.f64184d.h(entry.getKey(), entry.getValue().intValue());
        }
        QLog.d("LSImageNode", 4, "initBeautyParams: " + d16);
    }

    private void d() {
        a.d dVar = this.f64181a.f405883j;
        if (dVar == null) {
            return;
        }
        this.f64184d.a(dVar.f405902a, dVar.f405903b);
        QLog.d("LSImageNode", 4, "initFaceSoft:" + dVar.f405902a + "," + dVar.f405903b);
    }

    private void e() {
        a.d dVar = this.f64181a.f405886m;
        if (dVar == null) {
            return;
        }
        this.f64184d.c(dVar.f405902a, dVar.f405903b);
        QLog.d("LSImageNode", 4, "initLUT:" + dVar.f405902a + "," + dVar.f405903b);
    }

    private void f() {
        a.c cVar = this.f64181a.f405881h;
        if (cVar == null) {
            return;
        }
        this.f64184d.g(cVar.f405898a, cVar.f405899b, cVar.f405900c);
        QLog.d("LSImageNode", 4, "initLipsLut:" + cVar.f405898a + "," + cVar.f405899b + "," + cVar.f405900c);
    }

    private void g() {
        a.d dVar = this.f64181a.f405882i;
        if (dVar == null) {
            return;
        }
        this.f64184d.d(dVar.f405902a, dVar.f405903b);
        QLog.d("LSImageNode", 4, "initRedCheek:" + dVar.f405902a + "," + dVar.f405903b);
    }

    private void h() {
        String str = this.f64181a.f405885l;
        if (str == null) {
            return;
        }
        this.f64184d.f(str);
        QLog.d("LSImageNode", 4, "initThinFace:" + this.f64181a.f405885l);
    }

    private void j() {
        a.d dVar;
        if (this.f64183c || (dVar = this.f64181a.f405884k) == null) {
            return;
        }
        String str = dVar.f405902a;
        if (str == null) {
            this.f64184d.e(null, dVar.f405903b);
            QLog.d("LSImageNode", 4, "loadMaterial:none," + this.f64181a.f405884k.f405903b);
            this.f64183c = true;
            return;
        }
        VideoMaterial b16 = this.f64184d.b(str);
        if (b16 == null) {
            return;
        }
        this.f64184d.e(b16, this.f64181a.f405884k.f405903b);
        QLog.d("LSImageNode", 4, "loadMaterial:" + b16.getId() + "," + this.f64181a.f405884k.f405903b);
        this.f64183c = true;
    }

    private void o() {
        if (this.f64184d == null) {
            return;
        }
        j();
        if (this.f64182b > 0) {
            return;
        }
        f();
        g();
        d();
        h();
        c();
        e();
        QLog.d("LSImageNode", 4, this.f64181a.f405874a + " \u9996\u6b21\u521d\u59cb\u5316\u5b8c\u6210:" + this.f64181a.f405887n);
    }

    public String a() {
        return this.f64181a.f405874a;
    }

    public String b() {
        return this.f64181a.f405878e;
    }

    public boolean i() {
        return this.f64181a.f405879f;
    }

    public boolean k() {
        return this.f64182b == this.f64181a.f405877d;
    }

    public boolean l() {
        return !this.f64185e || this.f64182b > this.f64181a.f405876c;
    }

    public void m(a.InterfaceC0552a interfaceC0552a) {
        this.f64184d = interfaceC0552a;
    }

    public void n() {
        o();
        this.f64182b++;
    }
}
