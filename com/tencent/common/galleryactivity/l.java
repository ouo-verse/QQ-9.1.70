package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.ag;

/* compiled from: P */
/* loaded from: classes5.dex */
public class l implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    ImageView f99878a;

    /* renamed from: b, reason: collision with root package name */
    ag f99879b;

    /* renamed from: c, reason: collision with root package name */
    Rect f99880c;

    /* renamed from: d, reason: collision with root package name */
    boolean f99881d;

    /* renamed from: e, reason: collision with root package name */
    boolean f99882e;

    /* renamed from: f, reason: collision with root package name */
    int f99883f;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99881d = false;
        this.f99882e = false;
        this.f99883f = 0;
    }

    private void c(Activity activity) {
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeResource(activity.getResources(), R.drawable.nox);
        } catch (OutOfMemoryError unused) {
            bitmap = null;
        }
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
        }
        ag agVar = new ag(bitmap, (int) (activity.getResources().getDisplayMetrics().density * 12.0f));
        this.f99879b = agVar;
        agVar.setLevel(0);
        this.f99880c = new Rect(0, 0, 0, 0);
    }

    @Override // com.tencent.common.galleryactivity.g
    public void a(Activity activity, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) cVar);
        } else {
            this.f99878a = (ImageView) ((RelativeLayout) cVar.g()).findViewById(R.id.g2h);
            c(activity);
        }
    }

    public void b(Activity activity, ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) imageView);
        } else {
            this.f99878a = imageView;
            c(activity);
        }
    }

    @Override // com.tencent.common.galleryactivity.g
    public void hide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f99881d = false;
        if (this.f99878a.getVisibility() == 0) {
            this.f99878a.setVisibility(4);
        }
    }

    @Override // com.tencent.common.galleryactivity.g
    public boolean isShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f99881d;
    }

    @Override // com.tencent.common.galleryactivity.g
    public boolean isStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f99882e;
    }

    @Override // com.tencent.common.galleryactivity.g
    public void show() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f99881d = true;
        if (this.f99882e && this.f99878a.getVisibility() == 4) {
            if (this.f99880c.width() == 0 || this.f99880c.height() == 0) {
                this.f99880c.set(0, 0, this.f99878a.getWidth(), this.f99878a.getHeight());
                this.f99879b.setBounds(this.f99880c);
                this.f99878a.setImageDrawable(this.f99879b);
            }
            this.f99878a.setVisibility(0);
        }
    }

    @Override // com.tencent.common.galleryactivity.g
    public void start(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        this.f99883f = i3;
        this.f99882e = true;
        if (this.f99881d) {
            if (this.f99880c.width() == 0 || this.f99880c.height() == 0) {
                this.f99880c.set(0, 0, this.f99878a.getWidth(), this.f99878a.getHeight());
                this.f99879b.setBounds(this.f99880c);
                this.f99878a.setImageDrawable(this.f99879b);
            }
            this.f99878a.setVisibility(0);
        }
        if (i3 >= 0 && i3 < 100) {
            this.f99879b.setLevel(i3 * 100);
            this.f99879b.invalidateSelf();
        } else {
            this.f99879b.a();
        }
    }

    @Override // com.tencent.common.galleryactivity.g
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f99883f = 0;
        this.f99882e = false;
        if (this.f99878a.getVisibility() == 0) {
            this.f99878a.setVisibility(4);
        }
    }
}
