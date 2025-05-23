package com.tencent.common.galleryactivity;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.AdapterView;

/* loaded from: classes5.dex */
public class GalleryPageView extends com.tencent.common.galleryactivity.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    TextView f99845a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f99846b;

    /* renamed from: c, reason: collision with root package name */
    c f99847c;

    /* renamed from: d, reason: collision with root package name */
    public int f99848d;

    /* renamed from: e, reason: collision with root package name */
    Runnable f99849e;

    /* renamed from: f, reason: collision with root package name */
    AlphaAnimation f99850f;

    /* renamed from: g, reason: collision with root package name */
    AlphaAnimation f99851g;

    /* loaded from: classes5.dex */
    class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GalleryPageView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                GalleryPageView.this.f99845a.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else if (!GalleryPageView.this.f99847c.z()) {
                GalleryPageView.this.f99845a.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GalleryPageView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                GalleryPageView.this.f99845a.clearAnimation();
                GalleryPageView.this.f99845a.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    public GalleryPageView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99846b = true;
        this.f99848d = 3;
        this.f99849e = new Runnable() { // from class: com.tencent.common.galleryactivity.GalleryPageView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GalleryPageView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    GalleryPageView galleryPageView = GalleryPageView.this;
                    galleryPageView.f99845a.startAnimation(galleryPageView.f99851g);
                }
            }
        };
        this.f99850f = new AlphaAnimation(0.0f, 1.0f);
        this.f99851g = new AlphaAnimation(1.0f, 0.0f);
    }

    @Override // com.tencent.common.galleryactivity.b
    public void a(Activity activity, c cVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, cVar, Integer.valueOf(i3));
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) cVar.g();
        this.f99845a = new TextView(activity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12, -1);
        layoutParams.addRule(14, -1);
        layoutParams.bottomMargin = ((int) TypedValue.applyDimension(1, this.f99848d, activity.getResources().getDisplayMetrics())) + i3;
        this.f99845a.setTextColor(Color.parseColor("#e6e9e9e9"));
        this.f99845a.setTextSize(2, 15.0f);
        this.f99845a.setId(R.id.cqq);
        relativeLayout.addView(this.f99845a, layoutParams);
        this.f99845a.setVisibility(4);
        this.f99850f.setDuration(300L);
        this.f99851g.setDuration(300L);
        this.f99847c = cVar;
        this.f99850f.setAnimationListener(new a());
        this.f99851g.setAnimationListener(new b());
    }

    @Override // com.tencent.common.galleryactivity.b
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f99845a.setVisibility(i3);
        }
    }

    @Override // com.tencent.common.galleryactivity.b
    public void c(AdapterView adapterView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) adapterView, i3);
            return;
        }
        if (adapterView.getCount() > 1) {
            this.f99845a.setText((i3 + 1) + "/" + adapterView.getCount());
            if (this.f99845a.getVisibility() == 4) {
                this.f99845a.setVisibility(0);
                this.f99845a.startAnimation(this.f99850f);
                if (this.f99846b) {
                    this.f99845a.postDelayed(this.f99849e, 3000L);
                    this.f99846b = false;
                    return;
                } else {
                    this.f99845a.postDelayed(this.f99849e, 2000L);
                    return;
                }
            }
            this.f99845a.removeCallbacks(this.f99849e);
            this.f99845a.clearAnimation();
            this.f99845a.postDelayed(this.f99849e, 2000L);
            return;
        }
        this.f99845a.setVisibility(4);
    }
}
