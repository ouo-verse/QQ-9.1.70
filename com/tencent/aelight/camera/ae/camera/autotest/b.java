package com.tencent.aelight.camera.ae.camera.autotest;

import com.tencent.aelight.camera.ae.camera.autotest.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import zp.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private a.C11707a f62210a;

    /* renamed from: b, reason: collision with root package name */
    private int f62211b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f62212c;

    /* renamed from: d, reason: collision with root package name */
    private a.InterfaceC0535a f62213d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f62214e;

    public b(a.C11707a c11707a) {
        this.f62212c = false;
        this.f62210a = c11707a;
        if (c11707a.f452933c < 5) {
            c11707a.f452933c = 5;
        }
        if (c11707a.f452934d < 4) {
            c11707a.f452934d = 4;
        }
        this.f62212c = c11707a.f452941k == null;
        this.f62214e = new File(c11707a.f452931a).exists();
    }

    private void c() {
        HashMap<BeautyRealConfig.TYPE, Integer> d16 = this.f62210a.d();
        if (d16 == null || d16.size() == 0) {
            return;
        }
        for (Map.Entry<BeautyRealConfig.TYPE, Integer> entry : d16.entrySet()) {
            this.f62213d.h(entry.getKey(), entry.getValue().intValue());
        }
        QLog.d("LSImageNode", 4, "initBeautyParams: " + d16);
    }

    private void d() {
        a.d dVar = this.f62210a.f452940j;
        if (dVar == null) {
            return;
        }
        this.f62213d.a(dVar.f452959a, dVar.f452960b);
        QLog.d("LSImageNode", 4, "initFaceSoft:" + dVar.f452959a + "," + dVar.f452960b);
    }

    private void e() {
        a.d dVar = this.f62210a.f452943m;
        if (dVar == null) {
            return;
        }
        this.f62213d.c(dVar.f452959a, dVar.f452960b);
        QLog.d("LSImageNode", 4, "initLUT:" + dVar.f452959a + "," + dVar.f452960b);
    }

    private void f() {
        a.c cVar = this.f62210a.f452938h;
        if (cVar == null) {
            return;
        }
        this.f62213d.g(cVar.f452955a, cVar.f452956b, cVar.f452957c);
        QLog.d("LSImageNode", 4, "initLipsLut:" + cVar.f452955a + "," + cVar.f452956b + "," + cVar.f452957c);
    }

    private void g() {
        a.d dVar = this.f62210a.f452939i;
        if (dVar == null) {
            return;
        }
        this.f62213d.d(dVar.f452959a, dVar.f452960b);
        QLog.d("LSImageNode", 4, "initRedCheek:" + dVar.f452959a + "," + dVar.f452960b);
    }

    private void h() {
        String str = this.f62210a.f452942l;
        if (str == null) {
            return;
        }
        this.f62213d.f(str);
        QLog.d("LSImageNode", 4, "initThinFace:" + this.f62210a.f452942l);
    }

    private void j() {
        a.d dVar;
        if (this.f62212c || (dVar = this.f62210a.f452941k) == null) {
            return;
        }
        String str = dVar.f452959a;
        if (str == null) {
            this.f62213d.e(null, dVar.f452960b);
            QLog.d("LSImageNode", 4, "loadMaterial:none," + this.f62210a.f452941k.f452960b);
            this.f62212c = true;
            return;
        }
        VideoMaterial b16 = this.f62213d.b(str);
        if (b16 == null) {
            return;
        }
        this.f62213d.e(b16, this.f62210a.f452941k.f452960b);
        QLog.d("LSImageNode", 4, "loadMaterial:" + b16.getId() + "," + this.f62210a.f452941k.f452960b);
        this.f62212c = true;
    }

    private void o() {
        if (this.f62213d == null) {
            return;
        }
        j();
        if (this.f62211b > 0) {
            return;
        }
        f();
        g();
        d();
        h();
        c();
        e();
        QLog.d("LSImageNode", 4, this.f62210a.f452931a + " \u9996\u6b21\u521d\u59cb\u5316\u5b8c\u6210:" + this.f62210a.f452944n);
    }

    public String a() {
        return this.f62210a.f452931a;
    }

    public String b() {
        return this.f62210a.f452935e;
    }

    public boolean i() {
        return this.f62210a.f452936f;
    }

    public boolean k() {
        return this.f62211b == this.f62210a.f452934d;
    }

    public boolean l() {
        return !this.f62214e || this.f62211b > this.f62210a.f452933c;
    }

    public void m(a.InterfaceC0535a interfaceC0535a) {
        this.f62213d = interfaceC0535a;
    }

    public void n() {
        o();
        this.f62211b++;
    }
}
