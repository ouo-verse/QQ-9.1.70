package com.tencent.mobileqq.activity.photo.aiocomment;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cl;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class PhotoPreviewAIOCommentGuide {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected b f184140a;

    /* renamed from: b, reason: collision with root package name */
    protected ImageView f184141b;

    /* renamed from: c, reason: collision with root package name */
    protected AlphaAnimation f184142c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f184143d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f184144e;

    /* renamed from: f, reason: collision with root package name */
    protected c f184145f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f184146g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPreviewAIOCommentGuide.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                QLog.d("PhotoPreviewAIOCommentGuide", 1, "hideUserGuide");
                PhotoPreviewAIOCommentGuide.this.f184140a.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b extends LinearLayout implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private float f184148d;

        /* renamed from: e, reason: collision with root package name */
        private float f184149e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f184150f;

        public b(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPreviewAIOCommentGuide.this, (Object) context);
            } else {
                this.f184150f = false;
                a(context);
            }
        }

        private void a(Context context) {
            super.setOnTouchListener(this);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent == null) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f184148d = motionEvent.getX();
                this.f184149e = motionEvent.getY();
                QLog.i("PhotoPreviewAIOCommentGuide", 1, "onTouch down mConsumeStartX=" + this.f184148d + ",mConsumeStartY" + this.f184148d);
                this.f184150f = false;
            } else if (actionMasked == 2) {
                float x16 = motionEvent.getX();
                float y16 = motionEvent.getY();
                float abs = Math.abs(x16 - this.f184148d);
                float abs2 = Math.abs(y16 - this.f184149e);
                if (this.f184149e > y16 && Math.abs(abs) < Math.abs(abs2) && abs2 > ViewUtils.dip2px(30.0f)) {
                    this.f184150f = true;
                }
            } else {
                QLog.i("PhotoPreviewAIOCommentGuide", 1, "onTouch actionMasked=" + actionMasked + ",x=" + motionEvent.getX() + ",y=" + motionEvent.getY() + ",showInputCommentPanel=" + this.f184150f);
                PhotoPreviewAIOCommentGuide.this.c(this.f184150f);
            }
            return true;
        }
    }

    public PhotoPreviewAIOCommentGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184142c = new AlphaAnimation(1.0f, 0.0f);
        this.f184143d = false;
        this.f184144e = false;
        this.f184146g = new Handler();
    }

    protected static String b() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime == null) {
            return "";
        }
        return runtime.getCurrentAccountUin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z16) {
        c cVar;
        if (this.f184140a.getVisibility() == 0) {
            this.f184142c.setDuration(250L);
            this.f184142c.setAnimationListener(new a());
            this.f184140a.startAnimation(this.f184142c);
        }
        this.f184146g.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.aiocomment.PhotoPreviewAIOCommentGuide.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPreviewAIOCommentGuide.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    PhotoPreviewAIOCommentGuide.this.f184140a.setVisibility(8);
                }
            }
        }, 250L);
        if (z16 && (cVar = this.f184145f) != null) {
            cVar.s();
        }
        this.f184144e = false;
    }

    private boolean i(Context context) {
        this.f184140a = new b(context);
        this.f184141b = new ImageView(context);
        this.f184140a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f184140a.setGravity(1);
        this.f184140a.setBackgroundResource(R.color.by);
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setRequestHeight(this.f184141b.getHeight());
        apngOptions.setRequestWidth(this.f184141b.getWidth());
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(PhotoPreviewAIOCommentGuide.class.getName(), "https://static-res.qq.com/static-res/aio/photo/whatsnew_animation.png", apngOptions);
        if (apngURLDrawable != null) {
            this.f184141b.setImageDrawable(apngURLDrawable);
            this.f184141b.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dip2px(150.0f), ViewUtils.dip2px(185.0f)));
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(this.f184141b.getLayoutParams());
            marginLayoutParams.topMargin = ViewUtils.dip2px(270.0f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(marginLayoutParams);
            layoutParams.height = ViewUtils.dip2px(185.0f);
            layoutParams.width = ViewUtils.dip2px(150.0f);
            this.f184141b.setLayoutParams(layoutParams);
            this.f184141b.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f184140a.addView(this.f184141b);
            return true;
        }
        return false;
    }

    protected boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return TextUtils.isEmpty(cl.d(BaseApplication.getContext(), "AIO_PreviewScene_Guide" + b()));
    }

    protected boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f184143d;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f184144e;
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f184143d = z16;
        }
    }

    public void h(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            this.f184145f = cVar;
        }
    }

    public void j(Context context, com.tencent.mobileqq.activity.photo.album.preview.view.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) cVar);
            return;
        }
        if (e() && d() && i(context)) {
            QLog.d("PhotoPreviewAIOCommentGuide", 1, "tryShowGuide");
            cVar.f184364f.addView(this.f184140a);
            this.f184144e = true;
            cl.j(BaseApplication.getContext(), "AIO_PreviewScene_Guide" + b(), "1");
        }
    }
}
