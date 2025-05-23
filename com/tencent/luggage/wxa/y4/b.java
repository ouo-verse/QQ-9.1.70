package com.tencent.luggage.wxa.y4;

import android.animation.ValueAnimator;
import android.content.Context;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.ck.e;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.nj.i;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class b extends p {
    public long S;
    public e T;

    public b(Context context, com.tencent.luggage.wxa.c5.e eVar) {
        super(context, eVar);
        this.S = 0L;
        if (!eVar.Q1()) {
            a(i.WITH_CONFIRM_DIALOG, new com.tencent.luggage.wxa.nj.a());
        }
        a(i.SILENT, new com.tencent.luggage.wxa.nj.b());
        getReporter();
    }

    @Override // com.tencent.luggage.wxa.kj.p
    public p.m0 a(n nVar, n nVar2, k1 k1Var, String str, boolean z16) {
        this.S = System.currentTimeMillis();
        return super.a(nVar, nVar2, k1Var, str, z16);
    }

    @Override // com.tencent.luggage.wxa.kj.p
    public p.m0 b(n nVar, n nVar2) {
        p.m0 b16 = super.b(nVar, nVar2);
        getReporter().a(0L);
        getReporter().a((com.tencent.luggage.wxa.m4.b) nVar2.getCurrentPageView(), (com.tencent.luggage.wxa.m4.b) nVar.getCurrentPageView(), k1.NAVIGATE_BACK);
        return b16;
    }

    public e getReporter() {
        if (this.T == null) {
            this.T = new com.tencent.luggage.wxa.ck.a(getRuntime());
        }
        return this.T;
    }

    @Override // com.tencent.luggage.wxa.kj.p
    public void j() {
        super.j();
        if (getPageCount() > 0) {
            getReporter().d((com.tencent.luggage.wxa.m4.b) getCurrentPage().getCurrentPageView());
        }
    }

    @Override // com.tencent.luggage.wxa.kj.p
    public void k() {
        super.k();
        if (getPageCount() > 0) {
            getReporter().b((com.tencent.luggage.wxa.m4.b) getCurrentPage().getCurrentPageView());
        }
    }

    @Override // com.tencent.luggage.wxa.kj.p
    public void l() {
        super.l();
        if (getPageCount() > 0) {
            getReporter().c((com.tencent.luggage.wxa.m4.b) getCurrentPage().getCurrentPageView());
        }
    }

    @Override // android.view.View
    public final boolean post(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (!ViewCompat.isAttachedToWindow(this) && getRuntime() != null && getRuntime().y1()) {
            c0.a(runnable);
            return true;
        }
        return super.post(runnable);
    }

    @Override // android.view.View
    public final boolean postDelayed(Runnable runnable, long j3) {
        if (runnable == null) {
            return false;
        }
        if (!ViewCompat.isAttachedToWindow(this) && getRuntime() != null && getRuntime().y1()) {
            c0.a(runnable, j3);
            return true;
        }
        return super.postDelayed(runnable, j3);
    }

    @Override // android.view.View
    public final void postOnAnimation(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!ViewCompat.isAttachedToWindow(this) && getRuntime() != null && getRuntime().y1()) {
            c0.a(runnable, ValueAnimator.getFrameDelay());
        } else {
            super.postOnAnimation(runnable);
        }
    }

    @Override // android.view.View
    public final void postOnAnimationDelayed(Runnable runnable, long j3) {
        if (runnable == null) {
            return;
        }
        if (!ViewCompat.isAttachedToWindow(this) && getRuntime() != null && getRuntime().y1()) {
            c0.a(runnable, ValueAnimator.getFrameDelay() + j3);
        } else {
            super.postOnAnimationDelayed(runnable, j3);
        }
    }

    @Override // com.tencent.luggage.wxa.kj.p
    public com.tencent.luggage.wxa.c5.e getRuntime() {
        return (com.tencent.luggage.wxa.c5.e) super.getRuntime();
    }

    @Override // com.tencent.luggage.wxa.kj.p
    public void a(n nVar, n nVar2, k1 k1Var) {
        super.a(nVar, nVar2, k1Var);
        long currentTimeMillis = System.currentTimeMillis() - this.S;
        getReporter().a(currentTimeMillis, k1Var);
        w.d("Luggage.AppBrandPageContainerLU", "onNavigateEnd received, appId:%s, time: %d", getAppId(), Long.valueOf(currentTimeMillis));
        getReporter().a((com.tencent.luggage.wxa.m4.b) nVar2.getCurrentPageView(), nVar == null ? null : (com.tencent.luggage.wxa.m4.b) nVar.getCurrentPageView(), k1Var);
    }
}
