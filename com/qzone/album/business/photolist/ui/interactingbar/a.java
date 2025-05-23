package com.qzone.album.business.photolist.ui.interactingbar;

import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Activity f43572a;

    /* renamed from: b, reason: collision with root package name */
    private BasePhotoModelController f43573b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0344a f43574c;

    /* renamed from: d, reason: collision with root package name */
    private b f43575d;

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.ui.interactingbar.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public interface InterfaceC0344a {
        void a(View view);

        void b(View view, boolean z16);

        void c(View view);

        void d(View view);

        void e(View view);

        void f(View view);

        void g(View view, boolean z16);

        void h(View view);
    }

    public a(Activity activity, BasePhotoModelController basePhotoModelController, InterfaceC0344a interfaceC0344a) {
        this.f43572a = activity;
        this.f43573b = basePhotoModelController;
        this.f43574c = interfaceC0344a;
    }

    public void a() {
        b bVar;
        if (this.f43572a == null || (bVar = this.f43575d) == null || bVar.b() == null) {
            return;
        }
        this.f43575d.b().startAnimation(AnimationUtils.loadAnimation(this.f43572a, R.anim.f155025h2));
    }

    public int b() {
        b bVar = this.f43575d;
        if (bVar == null) {
            return 0;
        }
        return bVar.a();
    }

    public int c() {
        b bVar = this.f43575d;
        if (bVar == null || bVar.c() == null) {
            return 8;
        }
        return this.f43575d.c().getVisibility();
    }

    public void e(boolean z16, Animation.AnimationListener animationListener, long j3) {
        Animation loadAnimation;
        b bVar = this.f43575d;
        if (bVar == null || bVar.c() == null || this.f43572a == null) {
            return;
        }
        View c16 = this.f43575d.c();
        if (c16.getVisibility() == 8) {
            return;
        }
        if (z16 && (loadAnimation = AnimationUtils.loadAnimation(this.f43572a, R.anim.f154788cn)) != null) {
            if (j3 == 0) {
                j3 = this.f43572a.getResources().getInteger(android.R.integer.config_mediumAnimTime);
            }
            loadAnimation.setDuration(j3);
            if (animationListener != null) {
                loadAnimation.setAnimationListener(animationListener);
            }
            c16.startAnimation(loadAnimation);
        }
        c16.setVisibility(8);
        b bVar2 = this.f43575d;
        if (bVar2 instanceof HostAlbumInteractingBarUIContainer) {
            ((HostAlbumInteractingBarUIContainer) bVar2).n();
        }
    }

    public void f(int i3) {
        if (this.f43572a == null || this.f43573b == null || this.f43574c == null) {
            return;
        }
        if (i3 == 0) {
            this.f43575d = new HostAlbumInteractingBarUIContainer(this.f43572a, this.f43573b, this.f43574c);
        } else if (i3 == 1) {
            this.f43575d = new c(this.f43572a, this.f43573b, this.f43574c);
        } else if (i3 != 2) {
            this.f43575d = new HostAlbumInteractingBarUIContainer(this.f43572a, this.f43573b, this.f43574c);
        } else {
            this.f43575d = new e(this.f43572a, this.f43573b, this.f43574c);
        }
        if (this.f43575d.e()) {
            this.f43575d.f();
        }
        this.f43575d.d();
    }

    public boolean g() {
        Animation animation;
        b bVar = this.f43575d;
        return (bVar == null || bVar.b() == null || (animation = this.f43575d.b().getAnimation()) == null || animation.hasEnded()) ? false : true;
    }

    public void i(boolean z16, Animation.AnimationListener animationListener, long j3) {
        Animation loadAnimation;
        b bVar = this.f43575d;
        if (bVar == null || bVar.c() == null || this.f43572a == null) {
            return;
        }
        View c16 = this.f43575d.c();
        if (c16.getVisibility() == 0) {
            return;
        }
        if (z16 && (loadAnimation = AnimationUtils.loadAnimation(this.f43572a, R.anim.f154785cl)) != null) {
            if (j3 == 0) {
                j3 = this.f43572a.getResources().getInteger(android.R.integer.config_mediumAnimTime);
            }
            loadAnimation.setDuration(j3);
            if (animationListener != null) {
                loadAnimation.setAnimationListener(animationListener);
            }
            c16.startAnimation(loadAnimation);
        }
        c16.setVisibility(0);
        b bVar2 = this.f43575d;
        if (bVar2 instanceof HostAlbumInteractingBarUIContainer) {
            ((HostAlbumInteractingBarUIContainer) bVar2).k();
        }
    }

    public void j(int i3) {
        b bVar = this.f43575d;
        if (bVar == null) {
            return;
        }
        bVar.g(i3);
    }

    public void k(boolean z16, int i3) {
        b bVar = this.f43575d;
        if (bVar == null) {
            return;
        }
        bVar.h(z16, i3);
    }

    public void d(boolean z16) {
        e(z16, null, 0L);
    }

    public void h(boolean z16) {
        i(z16, null, 0L);
    }
}
