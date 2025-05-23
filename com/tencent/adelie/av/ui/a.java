package com.tencent.adelie.av.ui;

import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.adelie.av.ui.b;
import com.tencent.av.ui.m;
import com.tencent.av.utils.QQFrameByFrameAnimation;
import com.tencent.av.utils.al;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private QQFrameByFrameAnimation f61524a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.adelie.av.ui.b f61525b;

    /* renamed from: c, reason: collision with root package name */
    private View f61526c;

    /* renamed from: d, reason: collision with root package name */
    private AdelieAVPanel f61527d;

    /* renamed from: e, reason: collision with root package name */
    private al f61528e = new C0525a();

    public a(View view) {
        this.f61526c = view.findViewById(R.id.rbc);
        this.f61527d = (AdelieAVPanel) view.findViewById(R.id.rbk);
        this.f61525b = new com.tencent.adelie.av.ui.b(view.getContext(), this.f61527d, view.findViewById(R.id.rbv), null, view.findViewById(R.id.rbe), view.findViewById(R.id.f163657ra4), null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.tencent.adelie.av.ui.b bVar = this.f61525b;
        if (bVar != null) {
            bVar.r(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        AdelieAVPanel adelieAVPanel = this.f61527d;
        if (adelieAVPanel != null) {
            adelieAVPanel.setViewEnable(m.l.O, false);
            this.f61527d.setViewEnable(m.l.P, false);
            this.f61527d.setViewEnable(R.id.rba, false);
            this.f61527d.setViewEnable(m.l.f76073s, false);
            this.f61527d.setViewEnable(m.l.f76074t, false);
        }
    }

    private void h() {
        QQFrameByFrameAnimation qQFrameByFrameAnimation = new QQFrameByFrameAnimation();
        this.f61524a = qQFrameByFrameAnimation;
        qQFrameByFrameAnimation.c(100);
        this.f61524a.d(8);
        this.f61524a.e(new int[]{R.drawable.d_d, R.drawable.d_e});
        this.f61524a.b(this.f61528e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f61526c != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AdelieAVAnimCtrl", 2, "setScreenDarken");
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setFillAfter(true);
            this.f61526c.setVisibility(0);
            this.f61526c.startAnimation(alphaAnimation);
        }
    }

    public void d() {
        QQFrameByFrameAnimation qQFrameByFrameAnimation = this.f61524a;
        if (qQFrameByFrameAnimation != null) {
            qQFrameByFrameAnimation.h();
            this.f61524a = null;
        }
        com.tencent.adelie.av.ui.b bVar = this.f61525b;
        if (bVar != null) {
            bVar.p();
            this.f61525b = null;
        }
        this.f61526c = null;
        this.f61527d.l(e.d());
        this.f61527d = null;
    }

    public void e() {
        h();
        this.f61527d.q(this.f61524a);
    }

    public void j(b.d dVar) {
        com.tencent.adelie.av.ui.b bVar = this.f61525b;
        if (bVar != null) {
            bVar.q(dVar);
        }
    }

    public void k() {
        f();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.adelie.av.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    class C0525a extends al {
        C0525a() {
        }

        @Override // com.tencent.av.utils.al
        public void b() {
            a.this.f();
        }

        @Override // com.tencent.av.utils.al
        public void d() {
            a.this.i();
        }

        @Override // com.tencent.av.utils.al
        public void a() {
        }

        @Override // com.tencent.av.utils.al
        public void c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements b.e {
        b() {
        }

        @Override // com.tencent.adelie.av.ui.b.e
        public void b() {
            a.this.g();
        }

        @Override // com.tencent.adelie.av.ui.b.e
        public void a() {
        }
    }
}
