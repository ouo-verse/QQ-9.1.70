package com.tencent.luggage.wxa.l4;

import android.app.Activity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.ok.o;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d implements o {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f133021a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f133022b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f133023c;

        public a(com.tencent.luggage.wxa.ic.g gVar, int i3, Runnable runnable) {
            this.f133021a = gVar;
            this.f133022b = i3;
            this.f133023c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a(this.f133021a, this.f133022b, this.f133023c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f133026a;

        public c(Runnable runnable) {
            this.f133026a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f133026a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public static void a(com.tencent.luggage.wxa.ic.g gVar, int i3, Runnable runnable) {
        if (!ViewCompat.isLaidOut(gVar.K())) {
            gVar.K().setWillNotDraw(true);
            gVar.K().post(new a(gVar, i3, runnable));
        } else {
            Animation loadAnimation = AnimationUtils.loadAnimation(z.c(), i3);
            loadAnimation.setAnimationListener(new b(runnable, gVar));
            gVar.K().startAnimation(loadAnimation);
        }
    }

    public static boolean c(com.tencent.luggage.wxa.bk.e eVar) {
        if (a(eVar) != 1113 && a(eVar) != 1114) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.ok.o
    public void b(com.tencent.luggage.wxa.ic.g gVar, Runnable runnable, com.tencent.luggage.wxa.ic.g gVar2, Runnable runnable2) {
        if (gVar2 == null) {
            return;
        }
        a(gVar2, R.anim.f154492m2, runnable2);
        if (gVar != null) {
            a(gVar, R.anim.f154490m0, runnable);
        }
    }

    public static boolean b(com.tencent.luggage.wxa.bk.e eVar) {
        return a(eVar) == 1023;
    }

    @Override // com.tencent.luggage.wxa.ok.o
    public void b(Activity activity, i iVar) {
        activity.overridePendingTransition(R.anim.f154491m1, R.anim.f154492m2);
    }

    @Override // com.tencent.luggage.wxa.ok.o
    public void a(com.tencent.luggage.wxa.ic.g gVar, Runnable runnable, com.tencent.luggage.wxa.ic.g gVar2, Runnable runnable2) {
        if (gVar == null) {
            return;
        }
        a(gVar, R.anim.m3, new c(runnable));
        if (gVar2 != null) {
            a(gVar2, R.anim.f154490m0, runnable2);
        }
    }

    public static int a(com.tencent.luggage.wxa.bk.e eVar) {
        if (eVar == null) {
            return 0;
        }
        return eVar.f122984c;
    }

    @Override // com.tencent.luggage.wxa.ok.o
    public void a(Activity activity, i iVar) {
        if (activity == null || activity.getIntent() == null) {
            return;
        }
        com.tencent.luggage.wxa.bk.e i3 = iVar instanceof com.tencent.luggage.wxa.j4.d ? ((com.tencent.luggage.wxa.j4.d) iVar).i() : null;
        if (!b(i3) && !c(i3)) {
            if (1090 == a(i3)) {
                activity.overridePendingTransition(R.anim.f154495m6, R.anim.f154494m5);
                return;
            } else {
                activity.overridePendingTransition(R.anim.m3, R.anim.f154494m5);
                return;
            }
        }
        activity.overridePendingTransition(R.anim.m3, R.anim.f154490m0);
    }

    @Override // com.tencent.luggage.wxa.ok.o
    public void a(Activity activity) {
        activity.overridePendingTransition(R.anim.f154491m1, R.anim.f154492m2);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f133024a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f133025b;

        public b(Runnable runnable, com.tencent.luggage.wxa.ic.g gVar) {
            this.f133024a = runnable;
            this.f133025b = gVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Runnable runnable = this.f133024a;
            if (runnable != null) {
                com.tencent.luggage.wxa.zp.h.f146825d.a(runnable);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f133025b.K().setWillNotDraw(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
