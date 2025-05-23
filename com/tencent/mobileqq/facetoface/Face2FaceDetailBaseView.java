package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.eh;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class Face2FaceDetailBaseView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    protected float C;
    protected int D;
    protected final int E;
    protected final int F;
    protected Canvas G;
    long H;
    private boolean I;
    protected boolean J;
    protected c K;

    /* renamed from: d, reason: collision with root package name */
    protected View f205680d;

    /* renamed from: e, reason: collision with root package name */
    protected View f205681e;

    /* renamed from: f, reason: collision with root package name */
    protected View f205682f;

    /* renamed from: h, reason: collision with root package name */
    protected View f205683h;

    /* renamed from: i, reason: collision with root package name */
    protected Face2FaceFriendBubbleView f205684i;

    /* renamed from: m, reason: collision with root package name */
    protected View f205685m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceDetailBaseView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Face2FaceDetailBaseView.this.K.a();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceDetailBaseView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            Face2FaceDetailBaseView.this.setVisibility(4);
            Face2FaceDetailBaseView.this.f205684i.n();
            Face2FaceDetailBaseView.this.f205682f.setBackgroundDrawable(null);
            Face2FaceDetailBaseView.this.K.e();
            if (QLog.isColorLevel()) {
                QLog.d("Face2FaceDetailBaseView", 2, "animHide, onAnimationEnd " + hashCode());
            }
            Face2FaceDetailBaseView.this.I = true;
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
            } else if (QLog.isColorLevel()) {
                QLog.d("Face2FaceDetailBaseView", 2, "animHide, onAnimationStart " + hashCode());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface c {
        void a();

        boolean b(com.tencent.mobileqq.facetoface.c cVar, int i3);

        void c(com.tencent.mobileqq.facetoface.c cVar);

        void d();

        void e();

        void f();

        QQAppInterface getApp();

        boolean isTroopMember(String str);
    }

    public Face2FaceDetailBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.C = 1.5f;
        this.D = 0;
        this.E = 8;
        this.F = 10;
        this.H = 0L;
        this.I = true;
        this.J = false;
        h();
    }

    private AnimationSet e(int i3, int i16, float f16, float f17) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -i3, 0.0f, -i16);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f16, 1.0f, f17, 1, 0.0f, 1, 0.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(350L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setInterpolator(new DecelerateInterpolator(this.C));
        return animationSet;
    }

    private AnimationSet f(int i3, int i16, float f16, float f17) {
        TranslateAnimation translateAnimation = new TranslateAnimation(-i3, 0.0f, -i16, 0.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f16, 1.0f, f17, 1.0f, 1, 0.0f, 1, 0.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(350L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setInterpolator(new DecelerateInterpolator(this.C));
        return animationSet;
    }

    private void h() {
        this.G = new Canvas();
        this.D = R.drawable.clu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Face2FaceDetailBaseView", 2, "animHide, isAnimHideEnd=" + this.I);
        }
        if (!this.I) {
            return;
        }
        this.I = false;
        this.J = false;
        View findViewById = this.f205684i.findViewById(R.id.cnp);
        View findViewById2 = this.f205684i.findViewById(R.id.cnq);
        int left = this.f205680d.getLeft() - ((findViewById.getLeft() + findViewById2.getLeft()) + this.f205684i.getLeft());
        int top = this.f205680d.getTop() - ((findViewById.getTop() + findViewById2.getTop()) + this.f205684i.getTop());
        float width = (findViewById.getWidth() * 1.0f) / this.f205680d.getWidth();
        AnimationSet e16 = e(left, top, width, width);
        this.K.f();
        e16.setAnimationListener(new b());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setFillAfter(true);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(150L);
        alphaAnimation2.setFillAfter(true);
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation3.setDuration(150L);
        alphaAnimation3.setFillAfter(true);
        this.f205682f.startAnimation(alphaAnimation);
        this.f205681e.startAnimation(alphaAnimation2);
        this.f205680d.startAnimation(e16);
        this.f205685m.startAnimation(alphaAnimation3);
    }

    protected void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.J = true;
        this.I = true;
        this.f205680d.clearAnimation();
        setVisibility(0);
        View findViewById = this.f205684i.findViewById(R.id.cnp);
        View findViewById2 = this.f205684i.findViewById(R.id.cnq);
        int left = this.f205680d.getLeft() - ((findViewById.getLeft() + findViewById2.getLeft()) + this.f205684i.getLeft());
        int top = this.f205680d.getTop() - ((findViewById.getTop() + findViewById2.getTop()) + this.f205684i.getTop());
        float width = (findViewById.getWidth() * 1.0f) / this.f205680d.getWidth();
        AnimationSet f16 = f(left, top, width, width);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setStartOffset(150L);
        alphaAnimation.setAnimationListener(new a());
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(150L);
        alphaAnimation2.setStartOffset(350L);
        AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation3.setDuration(150L);
        alphaAnimation3.setStartOffset(350L);
        this.f205684i.o();
        this.f205682f.startAnimation(alphaAnimation);
        this.f205680d.startAnimation(f16);
        this.f205681e.startAnimation(alphaAnimation2);
        this.f205685m.startAnimation(alphaAnimation3);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("Face2FaceDetailBaseView", 2, "animShow: totalTime=" + (currentTimeMillis2 - this.H) + ",blurAndVisiableTime:" + (currentTimeMillis - this.H) + ",buildAnimTime:" + (currentTimeMillis2 - currentTimeMillis) + "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void d(View view) {
        String str;
        String str2;
        long currentTimeMillis;
        Bitmap createScaledBitmap;
        Face2FaceDetailBaseView face2FaceDetailBaseView = this;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) face2FaceDetailBaseView, (Object) view);
            return;
        }
        try {
            try {
                currentTimeMillis = System.currentTimeMillis();
            } catch (OutOfMemoryError e16) {
                e = e16;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                long currentTimeMillis2 = System.currentTimeMillis();
                face2FaceDetailBaseView.G.setBitmap(createBitmap);
                view.draw(face2FaceDetailBaseView.G);
                face2FaceDetailBaseView.G.drawColor(Color.parseColor("#70000000"), PorterDuff.Mode.DARKEN);
                long currentTimeMillis3 = System.currentTimeMillis();
                if (createBitmap != null) {
                    try {
                        createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, createBitmap.getWidth() / 10, createBitmap.getHeight() / 10, true);
                        if (!createBitmap.isRecycled()) {
                            createBitmap.recycle();
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str = "blurBackground:";
                        face2FaceDetailBaseView.f205682f.setBackgroundResource(face2FaceDetailBaseView.D);
                        if (QLog.isColorLevel()) {
                            QLog.e("Face2FaceDetailBaseView", 2, str + e.toString());
                            return;
                        }
                        return;
                    }
                } else {
                    createScaledBitmap = null;
                }
                long currentTimeMillis4 = System.currentTimeMillis();
                if (createScaledBitmap != null) {
                    eh.a(createScaledBitmap, 8);
                }
                long currentTimeMillis5 = System.currentTimeMillis();
                if (createScaledBitmap == null) {
                    str = "blurBackground:";
                    try {
                        face2FaceDetailBaseView.f205682f.setBackgroundResource(face2FaceDetailBaseView.D);
                    } catch (Exception e18) {
                        e = e18;
                        face2FaceDetailBaseView = this;
                        face2FaceDetailBaseView.f205682f.setBackgroundResource(face2FaceDetailBaseView.D);
                        if (QLog.isColorLevel()) {
                        }
                    } catch (OutOfMemoryError e19) {
                        e = e19;
                        face2FaceDetailBaseView = this;
                        str2 = str;
                        face2FaceDetailBaseView.f205682f.setBackgroundResource(face2FaceDetailBaseView.D);
                        if (QLog.isColorLevel()) {
                        }
                    }
                } else {
                    str = "blurBackground:";
                    try {
                        face2FaceDetailBaseView.f205682f.setBackgroundDrawable(new BitmapDrawable(getResources(), createScaledBitmap));
                    } catch (Exception e26) {
                        e = e26;
                        face2FaceDetailBaseView.f205682f.setBackgroundResource(face2FaceDetailBaseView.D);
                        if (QLog.isColorLevel()) {
                        }
                    } catch (OutOfMemoryError e27) {
                        e = e27;
                        str2 = str;
                        face2FaceDetailBaseView.f205682f.setBackgroundResource(face2FaceDetailBaseView.D);
                        if (QLog.isColorLevel()) {
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Face2FaceDetailBaseView", 2, "blurBackground, createEmptyBmp=" + (currentTimeMillis2 - currentTimeMillis) + ", drawBmp=" + (currentTimeMillis3 - currentTimeMillis2) + ", scale-recyle=" + (currentTimeMillis4 - currentTimeMillis3) + ", blur=" + (currentTimeMillis5 - currentTimeMillis4) + " total=" + (currentTimeMillis5 - currentTimeMillis));
                }
            } catch (OutOfMemoryError e28) {
                e = e28;
                face2FaceDetailBaseView = this;
                str2 = "blurBackground:";
                face2FaceDetailBaseView.f205682f.setBackgroundResource(face2FaceDetailBaseView.D);
                if (QLog.isColorLevel()) {
                    QLog.e("Face2FaceDetailBaseView", 2, str2 + e.toString());
                }
            }
        } catch (Exception e29) {
            e = e29;
            str = "blurBackground:";
        }
    }

    public View g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f205680d;
    }

    protected abstract void i();

    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.J;
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        b();
        return true;
    }

    public void k(View view, Face2FaceFriendBubbleView face2FaceFriendBubbleView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) face2FaceFriendBubbleView);
            return;
        }
        this.H = System.currentTimeMillis();
        this.K.d();
        this.f205683h = view;
        this.f205684i = face2FaceFriendBubbleView;
        d(view);
        c();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.onFinishInflate();
        i();
        View view = new View(getContext());
        this.f205682f = view;
        addView(view, 0, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void setInfc(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cVar);
        } else {
            this.K = cVar;
        }
    }
}
