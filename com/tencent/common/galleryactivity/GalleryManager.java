package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class GalleryManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected c f99833a;

    /* renamed from: b, reason: collision with root package name */
    public f f99834b;

    /* renamed from: c, reason: collision with root package name */
    protected e f99835c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f99836d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f99837e;

    /* renamed from: f, reason: collision with root package name */
    private m f99838f;

    /* renamed from: g, reason: collision with root package name */
    a f99839g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f99840h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f99841i;

    /* renamed from: j, reason: collision with root package name */
    boolean f99842j;

    /* renamed from: k, reason: collision with root package name */
    boolean f99843k;

    /* renamed from: l, reason: collision with root package name */
    ViewGroup f99844l;

    public GalleryManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99840h = false;
        this.f99841i = false;
        this.f99842j = false;
        this.f99843k = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        k b16 = this.f99835c.b();
        if (b16 != null) {
            b16.thubmRect = this.f99834b.u();
        }
        this.f99833a.H();
        if (QLog.isColorLevel()) {
            QLog.d("GalleryComponent", 2, "startImageListScene");
        }
        this.f99833a.v();
        this.f99833a.f99861h.setSelectionToNothing();
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!m() || j().c()) {
            return;
        }
        m mVar = this.f99838f;
        c cVar = this.f99833a;
        if (mVar == cVar) {
            if (this.f99834b == null) {
                f i3 = i(this.f99837e, this.f99835c);
                this.f99834b = i3;
                if (i3 == null) {
                    return;
                }
                i3.o(this);
                this.f99834b.y(this.f99844l);
                this.f99834b.o(this);
            }
            this.f99834b.A();
            this.f99833a.g().post(new Runnable() { // from class: com.tencent.common.galleryactivity.GalleryManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GalleryManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    GalleryManager galleryManager = GalleryManager.this;
                    galleryManager.f99839g.f99860i = true;
                    galleryManager.f99838f = galleryManager.f99834b;
                    GalleryManager.this.x();
                }
            });
            this.f99838f = this.f99834b;
            return;
        }
        if (mVar == this.f99834b) {
            cVar.g().post(new Runnable() { // from class: com.tencent.common.galleryactivity.GalleryManager.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GalleryManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    GalleryManager galleryManager = GalleryManager.this;
                    galleryManager.f99839g.f99860i = false;
                    galleryManager.f99838f = galleryManager.f99833a;
                    GalleryManager.this.w(true);
                }
            });
        }
    }

    public a d(Activity activity, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (a) iPatchRedirector.redirect((short) 14, (Object) this, (Object) activity, (Object) eVar);
        }
        return new i(activity, eVar);
    }

    public AnimationView e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (AnimationView) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        AnimationView animationView = new AnimationView(this.f99837e, null);
        animationView.setId(R.id.f164333s8);
        animationView.setVisibility(4);
        return animationView;
    }

    public RelativeLayout f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f99837e);
        this.f99837e.addContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        return relativeLayout;
    }

    public abstract c g(Activity activity, e eVar);

    public abstract e h(Activity activity);

    public abstract f i(Activity activity, e eVar);

    public a j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f99839g;
    }

    public m k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (m) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f99838f;
    }

    public c l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f99833a;
    }

    public boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    public void n(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        m mVar = this.f99838f;
        if (mVar != null) {
            mVar.i(i3, i16, intent);
        }
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (this.f99838f != null) {
            if (QLog.isColorLevel()) {
                QLog.d("GalleryManager", 2, "onBackEvent, isAnimating: " + this.f99839g.c());
            }
            if (!j().c()) {
                this.f99838f.d();
                return true;
            }
            return true;
        }
        return false;
    }

    public void p(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) configuration);
            return;
        }
        m mVar = this.f99838f;
        if (mVar != null) {
            mVar.j(configuration);
        }
    }

    public void q(Activity activity) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        if (activity == null) {
            return;
        }
        this.f99837e = activity;
        e h16 = h(activity);
        this.f99835c = h16;
        this.f99839g = d(activity, h16);
        if (this.f99833a == null) {
            c g16 = g(activity, this.f99835c);
            this.f99833a = g16;
            g16.o(this);
        }
        if (m()) {
            this.f99844l = f();
        }
        this.f99833a.E(this.f99844l);
        if (this.f99844l == null) {
            this.f99844l = this.f99833a.g();
        }
        ViewGroup viewGroup2 = this.f99844l;
        if (viewGroup2 != null) {
            viewGroup2.addView(e());
        }
        this.f99838f = this.f99833a;
        Intent intent = activity.getIntent();
        if (intent != null) {
            this.f99841i = intent.getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
            this.f99842j = intent.getBooleanExtra("extra.IS_FROM_PROFILE_CARD", false);
            this.f99843k = intent.getBooleanExtra("extra.IS_FROM_QFV_IMAGE_DETIL", false);
        }
        if (ImmersiveUtils.isSupporImmersive() == 1 && (viewGroup = this.f99844l) != null && !this.f99841i && !this.f99842j && !this.f99843k) {
            viewGroup.setSystemUiVisibility(4);
        }
    }

    public void r(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) activity);
            return;
        }
        c cVar = this.f99833a;
        if (cVar != null) {
            cVar.k();
        }
        f fVar = this.f99834b;
        if (fVar != null) {
            fVar.k();
        }
    }

    public boolean s(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        m mVar = this.f99838f;
        if (mVar != null) {
            return mVar.l(i3, keyEvent);
        }
        return false;
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.f99838f.m();
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.f99838f.n();
        }
    }

    public void v(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity);
            return;
        }
        if (!this.f99836d && this.f99838f == this.f99833a) {
            w(false);
        }
        this.f99836d = true;
    }

    protected void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
            return;
        }
        this.f99833a.I();
        if (QLog.isColorLevel()) {
            QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + z16);
        }
        k b16 = this.f99835c.b();
        if (z16) {
            this.f99833a.G();
            this.f99834b.z();
            if (b16 != null) {
                b16.thubmRect = this.f99834b.u();
            }
        } else {
            this.f99833a.F();
        }
        this.f99833a.u(z16);
    }
}
