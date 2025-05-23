package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.VersionUtils;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i extends a {
    static IPatchRedirector $redirector_;
    protected View C;
    protected AnimationView D;
    View E;
    View F;
    e G;
    int H;

    /* renamed from: m, reason: collision with root package name */
    Activity f99877m;

    public i(Activity activity, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) eVar);
            return;
        }
        this.f99877m = activity;
        this.G = eVar;
        this.H = activity.getResources().getDisplayMetrics().densityDpi;
    }

    private Drawable h(Rect rect, Rect rect2, Rect rect3, Rect rect4, k kVar, boolean z16) {
        AIORichMediaData aIORichMediaData;
        Rect rect5 = null;
        if (kVar == null) {
            return null;
        }
        Drawable animationDrawable = kVar.getAnimationDrawable();
        Rect thumbRect = kVar.getThumbRect();
        if (thumbRect == null || animationDrawable == null || !kVar.needAnimation(z16)) {
            return null;
        }
        int width = this.C.getWidth();
        int height = this.C.getHeight();
        int intrinsicWidth = animationDrawable.getIntrinsicWidth();
        int intrinsicHeight = animationDrawable.getIntrinsicHeight();
        rect2.set(0, 0, intrinsicWidth, intrinsicHeight);
        rect3.set(thumbRect);
        if (kVar instanceof com.tencent.mobileqq.activity.aio.photo.f) {
            aIORichMediaData = ((com.tencent.mobileqq.activity.aio.photo.f) kVar).f179735d;
        } else {
            aIORichMediaData = null;
        }
        if (!VersionUtils.isHoneycomb() && (animationDrawable instanceof URLDrawable) && (((URLDrawable) animationDrawable).getCurrDrawable() instanceof GifDrawable)) {
            rect5 = j.b(intrinsicWidth, intrinsicHeight, width, height, false, aIORichMediaData);
        }
        if (rect5 == null) {
            rect5 = j.a(intrinsicWidth, intrinsicHeight, width, height, aIORichMediaData);
        }
        rect4.set(rect5);
        return animationDrawable;
    }

    @Override // com.tencent.common.galleryactivity.a
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        boolean z16 = true;
        if (c()) {
            return true;
        }
        if (this.C == null) {
            g();
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        k b16 = this.G.b();
        if (b16 == null) {
            return false;
        }
        Rect startSrcRect = b16.getStartSrcRect();
        Rect rect3 = new Rect();
        Drawable h16 = h(null, rect3, rect, rect2, b16, true);
        this.f99857e = true;
        if (h16 == null) {
            z16 = false;
        }
        this.f99859h = z16;
        if (!z16) {
            this.D.setVisibility(4);
        } else {
            this.D.setVisibility(0);
            this.D.setAnimationListener(this);
            AnimationView animationView = this.D;
            animationView.C = b16.isImgCenterCropMode;
            if (startSrcRect == null) {
                animationView.g(h16, rect, rect2, b16.getCutValue(), this.f99858f);
            } else {
                animationView.h(h16, startSrcRect, rect3, rect, rect2, this.f99858f);
            }
        }
        return this.f99859h;
    }

    @Override // com.tencent.common.galleryactivity.a
    public boolean f() {
        Rect rect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        boolean z16 = true;
        if (c()) {
            return true;
        }
        if (this.C == null) {
            g();
        }
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        k b16 = this.G.b();
        if (b16 != null) {
            rect = b16.getStartSrcRect();
        } else {
            rect = null;
        }
        Rect rect4 = rect;
        Rect rect5 = new Rect();
        Drawable h16 = h(rect4, rect5, rect2, rect3, b16, false);
        this.f99857e = true;
        if (h16 == null) {
            z16 = false;
        }
        this.f99859h = z16;
        if (!z16) {
            this.D.setVisibility(4);
        } else {
            this.D.setVisibility(0);
            this.D.setAnimationListener(this);
            AnimationView animationView = this.D;
            animationView.C = b16.isImgCenterCropMode;
            animationView.e(h16, rect2, rect3, b16.getCutValue(), b16.getStartX(), b16.getStartY(), this.f99858f);
            if (rect4 == null) {
                this.D.e(h16, rect2, rect3, b16.getCutValue(), b16.getStartX(), b16.getStartY(), this.f99858f);
            } else {
                this.D.f(h16, rect4, rect5, rect2, rect3, this.f99858f);
            }
        }
        return this.f99859h;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.C = this.f99877m.findViewById(R.id.gallery);
        this.D = (AnimationView) this.f99877m.findViewById(R.id.f164333s8);
        this.E = this.f99877m.findViewById(R.id.root);
        this.F = this.f99877m.findViewById(R.id.a4f);
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onEnterAnimationEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f99857e = false;
        this.D.setVisibility(4);
        Iterator<h> it = this.f99856d.iterator();
        while (it.hasNext()) {
            it.next().onEnterAnimationEnd();
        }
        this.f99856d.clear();
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onEnterAnimationStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Iterator<h> it = this.f99856d.iterator();
        while (it.hasNext()) {
            it.next().onEnterAnimationStart();
        }
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onExitAnimationEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f99857e = false;
        this.D.setVisibility(4);
        Iterator<h> it = this.f99856d.iterator();
        while (it.hasNext()) {
            it.next().onExitAnimationEnd();
        }
        this.f99856d.clear();
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onExitAnimationStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Iterator<h> it = this.f99856d.iterator();
        while (it.hasNext()) {
            it.next().onExitAnimationStart();
        }
    }
}
