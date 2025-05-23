package com.qq.e.comm.plugin.tangramsplash.interactive.a;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.InteractiveInfo;
import com.qq.e.comm.plugin.base.ad.model.r;
import com.qq.e.comm.plugin.k.aa;
import com.qq.e.comm.plugin.k.ak;
import com.qq.e.comm.plugin.k.at;
import com.qq.e.comm.plugin.tangramsplash.d.f;
import com.qq.e.comm.plugin.tangramsplash.interactive.e;
import com.qq.e.comm.plugin.tangramsplash.interactive.f;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends com.qq.e.comm.plugin.tangramsplash.interactive.a {

    /* renamed from: ae, reason: collision with root package name */
    protected c f40156ae;

    /* renamed from: af, reason: collision with root package name */
    protected b f40157af;

    /* renamed from: ag, reason: collision with root package name */
    protected boolean f40158ag;

    public d(r rVar, com.qq.e.comm.plugin.tangramsplash.interactive.c cVar) {
        super(rVar, cVar);
        this.f40158ag = false;
    }

    private boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return "all".equals(new JSONObject(str).optString("type"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean A() {
        r rVar = this.X;
        if (rVar == null) {
            GDTLogger.i("WriggleAd: isEasterEggSwitchOn, adInfo is null, just return true");
            return true;
        }
        if (f.a(rVar.bP(), "disableShowEasterEggInteractiveList", "")) {
            GDTLogger.i("WriggleAd: isEasterEggSwitchOn, can show by wuji");
            return true;
        }
        GDTLogger.i("WriggleAd: isEasterEggSwitchOn, disable by wuji");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str) {
        r rVar = this.X;
        InteractiveInfo interactiveInfo = this.f40115aa;
        com.qq.e.comm.plugin.tangramsplash.interactive.c cVar = this.Y;
        if (rVar != null && interactiveInfo != null && cVar != null) {
            if ("invalidEasterEgg".equals(str)) {
                com.qq.e.comm.plugin.tangramsplash.report.c.b(1310370, rVar.s(), rVar, interactiveInfo.n(), cVar.f40183b);
                com.qq.e.comm.plugin.tangramsplash.report.a.c(d(), "invalidEasterEgg");
            } else {
                com.qq.e.comm.plugin.tangramsplash.report.a.c(d(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void p() {
        super.p();
        v();
        b bVar = this.f40157af;
        if (bVar != null) {
            bVar.post(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.f40157af.setVisibility(8);
                    d.this.f40157af.a((a) null);
                }
            });
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void w() {
        boolean z16;
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        b bVar = this.f40157af;
        if (bVar != null && z16) {
            bVar.b();
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void x() {
        boolean z16;
        r rVar = this.X;
        if (rVar != null && rVar.ca()) {
            z16 = true;
        } else {
            z16 = false;
        }
        b bVar = this.f40157af;
        if (bVar != null && z16) {
            bVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y() {
        b bVar = this.f40157af;
        if (bVar != null) {
            bVar.setVisibility(8);
        }
        if (this.Z != null) {
            this.Z.a((View) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z() {
        this.f40156ae = new c(this);
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected boolean a() {
        File b16 = at.b(this.X.s(), e.d(this.X));
        if (b16 != null && b16.exists()) {
            if (this.f40115aa.a() >= 0 && this.f40115aa.a() < this.f40115aa.b()) {
                if (this.f40115aa.b() <= (this.Y.f40182a == 1 ? this.X.bq() : this.X.bN())) {
                    b(b16.getAbsolutePath());
                    return true;
                }
            }
            String s16 = this.X.s();
            r rVar = this.X;
            com.qq.e.comm.plugin.tangramsplash.report.c.b(1310371, s16, rVar, rVar.bJ().n(), this.Y.f40183b);
            return false;
        }
        String s17 = this.X.s();
        r rVar2 = this.X;
        com.qq.e.comm.plugin.tangramsplash.report.c.b(1310370, s17, rVar2, rVar2.bJ().n(), this.Y.f40183b);
        return false;
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    protected void b() {
        b bVar = new b(GDTADManager.getInstance().getAppContext());
        this.f40157af = bVar;
        bVar.a(this.f40115aa.m());
        this.f40157af.a(this.f40115aa.j());
        this.f40157af.b(this.f40115aa.k());
        this.f40157af.a(this.f40115aa.l());
        this.f40157af.a(new a() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.a.d.1
            @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.a
            public void a() {
                d dVar = d.this;
                dVar.f40158ag = true;
                dVar.e();
            }

            @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a.a
            public void b() {
                aa.a(new Runnable() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.a.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f.a(500L);
                        d.this.f();
                    }
                }, 100L);
            }
        });
        this.f40157af.a();
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ak.a(this.f40157af.getContext(), 240));
        this.f40157af.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, Integer.MIN_VALUE}));
        layoutParams.gravity = 81;
        a(new f.a() { // from class: com.qq.e.comm.plugin.tangramsplash.interactive.a.d.2
            @Override // com.qq.e.comm.plugin.tangramsplash.interactive.f.a
            public void a(boolean z16) {
                GDTLogger.d("startEnableDrawAfterAdShow\uff1aenable " + z16);
                if (z16) {
                    d.this.h();
                    if (((com.qq.e.comm.plugin.tangramsplash.interactive.a) d.this).Z != null) {
                        ((com.qq.e.comm.plugin.tangramsplash.interactive.a) d.this).Z.a(d.this.f40157af, layoutParams);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void a(String str) {
        boolean d16 = d(str);
        if (this.Z != null) {
            this.Z.b(d16);
        }
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void t() {
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void u() {
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.interactive.a
    public void v() {
    }
}
