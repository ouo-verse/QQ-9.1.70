package com.tencent.common.galleryactivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimateUtils;
import com.tencent.util.ViscousFluidInterpolator;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class c extends m implements AdapterView.OnItemSelectedListener, Gallery.OnItemRotateListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener, Gallery.OnScollListener, h {
    static IPatchRedirector $redirector_;
    protected RelativeLayout C;
    protected View D;
    protected com.tencent.common.galleryactivity.b E;
    protected Activity F;
    protected g G;
    protected int H;
    h I;
    public boolean J;

    /* renamed from: h, reason: collision with root package name */
    protected Gallery f99861h;

    /* renamed from: i, reason: collision with root package name */
    protected d f99862i;

    /* renamed from: m, reason: collision with root package name */
    protected e f99863m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.common.galleryactivity.h
        public void onEnterAnimationEnd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GalleryComponent", 2, "gallery onEnterAnimationEnd");
            }
            if (c.this.f99861h.getVisibility() != 0) {
                c.this.f99861h.setVisibility(0);
            }
            c.this.onEnterAnimationEnd();
            g gVar = c.this.G;
            if (gVar != null && !gVar.isShow()) {
                c.this.G.show();
            }
        }

        @Override // com.tencent.common.galleryactivity.h
        public void onEnterAnimationStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (c.this.f99886f.j().f99859h) {
                c.this.f99861h.setVisibility(4);
            }
            c.this.onEnterAnimationStart();
            g gVar = c.this.G;
            if (gVar != null && gVar.isShow()) {
                c.this.G.hide();
            }
        }

        @Override // com.tencent.common.galleryactivity.h
        public void onExitAnimationEnd() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            c.this.onExitAnimationEnd();
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("gallery onExitAnimationEnd ");
                if (c.this.f99886f.k() == c.this) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d("GalleryComponent", 2, sb5.toString());
            }
            m k3 = c.this.f99886f.k();
            c cVar = c.this;
            if (k3 == cVar) {
                cVar.F.finish();
            } else {
                cVar.f99861h.setVisibility(0);
                c.this.J();
            }
        }

        @Override // com.tencent.common.galleryactivity.h
        public void onExitAnimationStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (c.this.f99886f.j().f99859h) {
                c.this.f99861h.setVisibility(4);
            }
            com.tencent.common.galleryactivity.b bVar = c.this.E;
            if (bVar != null) {
                bVar.b(4);
            }
            g gVar = c.this.G;
            if (gVar != null && gVar.isShow()) {
                c.this.G.hide();
            }
            c.this.onExitAnimationStart();
            c.this.f99861h.reset();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b extends AnimateUtils.AnimationAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                c.this.f99886f.j().onEnterAnimationEnd();
                c.this.f99886f.j().d();
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                c.this.f99886f.j().onEnterAnimationStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.common.galleryactivity.c$c, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1016c extends AnimateUtils.AnimationAdapter {
        static IPatchRedirector $redirector_;

        C1016c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                c.this.f99886f.j().onExitAnimationEnd();
                c.this.f99886f.j().d();
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                c.this.f99886f.j().onExitAnimationStart();
            }
        }
    }

    public c(Activity activity, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) eVar);
            return;
        }
        this.I = new a();
        this.J = false;
        this.F = activity;
        this.f99863m = eVar;
    }

    protected boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    protected boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    public boolean C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            this.f99886f.j().a(this.I);
        }
    }

    public void E(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewGroup);
            return;
        }
        y();
        RelativeLayout s16 = s();
        this.C = s16;
        if (viewGroup == null) {
            this.F.addContentView(s16, new ViewGroup.LayoutParams(-1, -1));
        } else {
            viewGroup.addView(s16, new ViewGroup.LayoutParams(-1, -1));
        }
        p((ViewGroup) this.C.findViewById(R.id.root));
        this.f99861h = (Gallery) this.F.findViewById(R.id.gallery);
        this.D = this.F.findViewById(R.id.a4f);
        com.tencent.common.galleryactivity.b r16 = r(this.F);
        this.E = r16;
        if (r16 != null) {
            r16.a(this.F, this, this.H);
        }
        g t16 = t();
        this.G = t16;
        if (t16 != null) {
            t16.a(this.F, this);
        }
        d q16 = q(this.F);
        this.f99862i = q16;
        q16.d(this.f99863m);
        g gVar = this.G;
        if (gVar != null) {
            this.f99862i.e(gVar);
            this.G.show();
        }
        this.f99861h.setAdapter((SpinnerAdapter) this.f99862i);
        this.f99861h.setSpacing(this.F.getResources().getDimensionPixelSize(R.dimen.f158920sg));
        this.f99861h.setSelection(this.f99863m.getSelectedIndex());
        this.f99861h.setOnItemSelectedListener(this);
        this.f99861h.setOnItemClickListener(this);
        this.f99861h.setOnItemLongClickListener(this);
        this.f99861h.setOnItemRotateListener(this);
        this.f99861h.setOnScollListener(this);
        this.C.setVisibility(4);
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        } else {
            this.f99886f.j().a(this.I);
        }
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.f99886f.j().a(this.I);
            this.J = true;
        }
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.f99886f.j().a(this.I);
        }
    }

    @TargetApi(11)
    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        if (QLog.isColorLevel()) {
            QLog.d("GalleryComponent", 2, "gallery onstart");
        }
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.C.setVisibility(4);
        if (QLog.isColorLevel()) {
            QLog.d("GalleryComponent", 2, "gallery onstop");
        }
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else {
            this.f99861h.reset();
        }
    }

    @Override // com.tencent.common.galleryactivity.m
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        D();
        if (this.J) {
            this.f99886f.c();
            return true;
        }
        if (B()) {
            f(false, this.f99886f.j().f());
            return true;
        }
        this.I.onExitAnimationEnd();
        return true;
    }

    @Override // com.tencent.common.galleryactivity.m
    public void e(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        super.e(z16, z17);
        if (this.D.getAnimation() != null) {
            this.D.clearAnimation();
        }
        if (this.f99861h.getAnimation() != null) {
            this.f99861h.clearAnimation();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(this.f99886f.j().b());
        alphaAnimation.setFillAfter(true);
        if (z17) {
            this.D.startAnimation(alphaAnimation);
        } else {
            alphaAnimation.setAnimationListener(new b());
            g().startAnimation(alphaAnimation);
        }
    }

    @Override // com.tencent.common.galleryactivity.m
    public void f(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        super.f(z16, z17);
        if (this.D.getAnimation() != null) {
            this.D.clearAnimation();
        }
        if (g().getAnimation() != null) {
            g().clearAnimation();
        }
        if (z17) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setFillAfter(true);
            this.D.startAnimation(alphaAnimation);
            alphaAnimation.setDuration(this.f99886f.j().b());
            return;
        }
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setInterpolator(new ViscousFluidInterpolator());
        alphaAnimation2.setDuration(this.f99886f.j().b());
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, this.f99885e.getWidth() / 2, this.f99885e.getHeight() / 2);
        scaleAnimation.setInterpolator(new DecelerateInterpolator());
        scaleAnimation.setDuration(this.f99886f.j().b());
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.addAnimation(alphaAnimation2);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(new C1016c());
        this.D.startAnimation(alphaAnimation2);
        this.f99861h.startAnimation(animationSet);
    }

    @Override // com.tencent.common.galleryactivity.m
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        }
    }

    public void onEnterAnimationEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        }
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onEnterAnimationStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        }
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onExitAnimationEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        }
    }

    public void onExitAnimationStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AbstractGalleryScene", 2, "onItemClick");
        }
        d();
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 10, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
        g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        if (view == null) {
            return;
        }
        if (this.E != null && C()) {
            this.E.c(adapterView, i3);
        }
        this.f99863m.a(i3);
        if (!z() && (gVar = this.G) != null && !gVar.isShow()) {
            this.G.show();
        }
        this.f99862i.c(view, i3);
        if (QLog.isColorLevel()) {
            QLog.i("AbstractGalleryScene", 2, "AbstractGalleryScene.onItemSelected(): position=" + i3);
        }
    }

    @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) adapterView);
        }
    }

    @Override // com.tencent.widget.Gallery.OnItemRotateListener
    public void onRotateFinished(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void onScrollEnd(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        g gVar = this.G;
        if (gVar != null && !gVar.isShow()) {
            this.G.show();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AbstractGalleryScene", 2, "onScrollEnd:" + i3);
        }
    }

    public void onScrollStart(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        g gVar = this.G;
        if (gVar != null && gVar.isShow()) {
            this.G.hide();
        }
        g gVar2 = this.G;
        if (gVar2 != null && gVar2.isStarted()) {
            this.G.stop();
        }
        if (QLog.isColorLevel()) {
            QLog.d("AbstractGalleryScene", 2, "onScrollStart:" + i3);
        }
    }

    protected abstract d q(Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public com.tencent.common.galleryactivity.b r(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (com.tencent.common.galleryactivity.b) iPatchRedirector.redirect((short) 18, (Object) this, (Object) context);
        }
        return new GalleryPageView();
    }

    protected RelativeLayout s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return (RelativeLayout) LayoutInflater.from(this.F).inflate(R.layout.aze, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (g) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return new l();
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
            return;
        }
        if (A()) {
            e(z16, this.f99886f.j().e());
            return;
        }
        Gallery gallery = this.f99861h;
        if (gallery != null) {
            gallery.setBackgroundColor(-16777216);
        }
        this.I.onEnterAnimationEnd();
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        GalleryManager galleryManager = this.f99886f;
        if (galleryManager.f99840h) {
            galleryManager.f99840h = false;
        } else {
            f(true, galleryManager.f99839g.f());
        }
    }

    public Gallery w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (Gallery) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.f99861h;
    }

    public d x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f99862i;
    }

    public abstract void y();

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f99886f.j().c();
    }
}
