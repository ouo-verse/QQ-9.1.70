package com.tencent.mobileqq.qrscan.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.QMiniResult;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.qrscan.h;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ScannerSingleResultView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    private LottieAnimationView C;
    private FrameLayout D;
    private boolean E;
    private Bitmap F;
    private int G;
    private int H;
    private h I;
    private Runnable J;

    /* renamed from: d, reason: collision with root package name */
    private boolean f276810d;

    /* renamed from: e, reason: collision with root package name */
    private ScannerResult f276811e;

    /* renamed from: f, reason: collision with root package name */
    private int f276812f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f276813h;

    /* renamed from: i, reason: collision with root package name */
    private View f276814i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f276815m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f276817d;

        a(LottieAnimationView lottieAnimationView) {
            this.f276817d = lottieAnimationView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerSingleResultView.this, (Object) lottieAnimationView);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            this.f276817d.clearAnimation();
            this.f276817d.setVisibility(8);
            ScannerSingleResultView.this.C.setVisibility(0);
            ScannerSingleResultView.this.C.playAnimation();
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
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f276819d;

        b(LottieAnimationView lottieAnimationView) {
            this.f276819d = lottieAnimationView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerSingleResultView.this, (Object) lottieAnimationView);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
                return;
            }
            this.f276819d.removeAllAnimatorListeners();
            ScannerSingleResultView.this.x(this.f276819d);
            ScannerSingleResultView.this.q();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            }
        }
    }

    public ScannerSingleResultView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f276810d = false;
        this.E = false;
        this.J = new Runnable() { // from class: com.tencent.mobileqq.qrscan.view.ScannerSingleResultView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScannerSingleResultView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                RectF rectF;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int childCount = ScannerSingleResultView.this.D.getChildCount();
                if (ScannerSingleResultView.this.E && ScannerSingleResultView.this.G > 0 && ScannerSingleResultView.this.H > 0 && childCount > 0) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = ScannerSingleResultView.this.D.getChildAt(i3);
                        if (childAt != null && childAt.getTag() != null) {
                            Object tag = childAt.getTag();
                            if (tag instanceof QBarResult) {
                                rectF = ((QBarResult) tag).f276509h;
                            } else if (tag instanceof QMiniResult) {
                                rectF = ((QMiniResult) tag).f276512f;
                            } else {
                                rectF = null;
                            }
                            if (rectF != null) {
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                                Rect y16 = ScannerSingleResultView.this.y(rectF);
                                layoutParams.topMargin = y16.centerY() - ViewUtils.dip2px(27.0f);
                                layoutParams.leftMargin = y16.centerX() - ViewUtils.dip2px(27.0f);
                                QLog.i("IQRScanConst_ScannerSingleResultView", 1, "mUpdatePointPositionRunnable location\uff1a" + rectF + " locInView:" + y16);
                                childAt.setVisibility(0);
                            }
                        }
                    }
                    ScannerSingleResultView.this.D.requestLayout();
                    ScannerSingleResultView.this.v(true);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.D.removeAllViews();
        Bitmap bitmap = this.F;
        if (bitmap == null) {
            r();
            return;
        }
        this.f276813h.setImageBitmap(bitmap);
        if ((this.f276812f & 1) != 0 && this.f276811e.l()) {
            o().setTag(this.f276811e.f276520d.get(0));
        }
        if ((this.f276812f & 2) != 0 && this.f276811e.j()) {
            o().setTag(this.f276811e.f276521e.get(0));
        }
        if (this.G > 0 && this.H > 0) {
            this.J.run();
        }
        p();
    }

    private View o() {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(getContext());
        lottieAnimationView.setAnimation("qr_scan_multi_point/single_in.json");
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.addAnimatorListener(new b(lottieAnimationView));
        this.D.addView(lottieAnimationView, new FrameLayout.LayoutParams(ViewUtils.dip2px(54.0f), ViewUtils.dip2px(54.0f)));
        lottieAnimationView.setVisibility(8);
        return lottieAnimationView;
    }

    private void p() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f276814i, c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f276815m, c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    private void r() {
        h hVar = this.I;
        if (hVar == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable(hVar) { // from class: com.tencent.mobileqq.qrscan.view.ScannerSingleResultView.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ h f276816d;

            {
                this.f276816d = hVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerSingleResultView.this, (Object) hVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("IQRScanConst_ScannerSingleResultView", 2, "decodeBitmap mShowing\uff1a" + ScannerSingleResultView.this.E);
                }
                if (!ScannerSingleResultView.this.E) {
                    return;
                }
                try {
                    IScanUtilApi iScanUtilApi = (IScanUtilApi) QRoute.api(IScanUtilApi.class);
                    h hVar2 = this.f276816d;
                    Bitmap decodeBitmapFromYuv = iScanUtilApi.decodeBitmapFromYuv(hVar2.f276637a, hVar2.f276638b, hVar2.f276639c);
                    ScannerSingleResultView scannerSingleResultView = ScannerSingleResultView.this;
                    scannerSingleResultView.F = scannerSingleResultView.u(decodeBitmapFromYuv, 90.0f);
                    this.f276816d.f276637a = null;
                } catch (Throwable th5) {
                    ScannerSingleResultView.this.F = null;
                    QLog.i("IQRScanConst_ScannerSingleResultView", 2, "decodeBitmap error:", th5);
                }
                ScannerSingleResultView.this.z();
            }
        }, 16, null, true);
    }

    private void s(RelativeLayout relativeLayout) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fxv, (ViewGroup) this, true);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
        this.f276813h = imageView;
        imageView.setBackgroundColor(0);
        View findViewById = inflate.findViewById(R.id.enc);
        this.f276814i = findViewById;
        findViewById.setBackgroundColor(Color.parseColor("#80000000"));
        this.f276814i.setAlpha(0.0f);
        TextView textView = (TextView) inflate.findViewById(R.id.yt9);
        this.f276815m = textView;
        textView.setAlpha(0.0f);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.efs);
        this.C = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder("qr_scan_multi_point/images");
        this.C.setAnimation("qr_scan_multi_point/single_loading.json");
        this.C.setRepeatCount(-1);
        this.C.setVisibility(4);
        this.D = (FrameLayout) inflate.findViewById(R.id.f26160cs);
        relativeLayout.addView(this, new RelativeLayout.LayoutParams(-1, -1));
        this.f276810d = true;
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            ((RelativeLayout.LayoutParams) this.f276815m.getLayoutParams()).topMargin = ViewUtils.dip2px(60.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap u(Bitmap bitmap, float f16) {
        if (bitmap != null && f16 != 0.0f && f16 != 360.0f) {
            Bitmap bitmap2 = null;
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.setRotate(f16);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
                bitmap.recycle();
                return bitmap2;
            } catch (Exception e16) {
                QLog.e("IQRScanConst_ScannerSingleResultView", 1, "rotateBitmap Exception = " + e16);
                return bitmap2;
            } catch (OutOfMemoryError e17) {
                QLog.e("IQRScanConst_ScannerSingleResultView", 1, "rotateBitmap OutOfMemoryError = " + e17);
                return bitmap2;
            }
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(boolean z16) {
        int childCount = this.D.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.D.getChildAt(i3);
            if (childAt instanceof LottieAnimationView) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) childAt;
                if (z16 && !lottieAnimationView.isAnimating()) {
                    lottieAnimationView.playAnimation();
                } else if (!z16 && lottieAnimationView.isAnimating()) {
                    lottieAnimationView.cancelAnimation();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(LottieAnimationView lottieAnimationView) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, ((this.G / 2) - ViewUtils.dpToPx(27.0f)) - lottieAnimationView.getX(), 0.0f, ((this.H / 2) - lottieAnimationView.getY()) - ViewUtils.dpToPx(27.0f));
        translateAnimation.setDuration(400L);
        translateAnimation.setAnimationListener(new a(lottieAnimationView));
        lottieAnimationView.startAnimation(translateAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect y(RectF rectF) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.G;
        int i26 = this.H;
        int width = this.F.getWidth();
        int height = this.F.getHeight();
        if (!rectF.isEmpty() && height > 0 && width > 0) {
            float f16 = i19;
            float f17 = i26;
            if ((width * 1.0f) / height > (1.0f * f16) / f17) {
                int i27 = (i26 * width) / height;
                i18 = (int) (rectF.top * f17);
                i16 = (int) (rectF.bottom * f17);
                int i28 = (i19 / 2) - (i27 / 2);
                float f18 = i27;
                i3 = ((int) (rectF.left * f18)) + i28;
                i17 = ((int) (rectF.right * f18)) + i28;
            } else {
                int i29 = (i19 * height) / width;
                i3 = (int) (rectF.left * f16);
                int i36 = (int) (rectF.right * f16);
                int i37 = (i26 / 2) - (i29 / 2);
                float f19 = i29;
                int i38 = ((int) (rectF.top * f19)) + i37;
                i16 = ((int) (rectF.bottom * f19)) + i37;
                i17 = i36;
                i18 = i38;
            }
            return new Rect(i3, i18, i17, i16);
        }
        QLog.d("IQRScanConst_ScannerSingleResultView", 1, "transToViewLocation, but location empty = " + rectF.isEmpty());
        return new Rect(0, 0, i19, i26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (QLog.isColorLevel()) {
            QLog.i("IQRScanConst_ScannerSingleResultView", 2, "updateAfterDecodeBitmap mShowing\uff1a" + this.E + " mBitmap:" + this.F + " mScannerResult:" + this.f276811e);
        }
        if (!this.E) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qrscan.view.ScannerSingleResultView.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerSingleResultView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("IQRScanConst_ScannerSingleResultView", 2, "updateAfterDecodeBitmap mShowing\uff1a" + ScannerSingleResultView.this.E + " mBitmap:" + ScannerSingleResultView.this.F);
                }
                if (ScannerSingleResultView.this.E && ScannerSingleResultView.this.F != null) {
                    ScannerSingleResultView.this.A();
                }
            }
        });
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (measuredWidth != this.G || measuredHeight != this.H) {
                this.G = measuredWidth;
                this.H = measuredHeight;
            }
        }
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.E;
    }

    public void w(RelativeLayout relativeLayout, ScannerResult scannerResult, int i3, h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, relativeLayout, scannerResult, Integer.valueOf(i3), hVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("IQRScanConst_ScannerSingleResultView", 2, "show requestType\uff1a" + i3 + " scannerResult:" + scannerResult + " data:" + hVar);
        }
        this.f276811e = scannerResult;
        this.f276812f = i3;
        this.I = hVar;
        if (!this.f276810d) {
            s(relativeLayout);
        }
        A();
        setVisibility(0);
        this.E = true;
    }

    public ScannerSingleResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f276810d = false;
        this.E = false;
        this.J = new Runnable() { // from class: com.tencent.mobileqq.qrscan.view.ScannerSingleResultView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScannerSingleResultView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                RectF rectF;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int childCount = ScannerSingleResultView.this.D.getChildCount();
                if (ScannerSingleResultView.this.E && ScannerSingleResultView.this.G > 0 && ScannerSingleResultView.this.H > 0 && childCount > 0) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = ScannerSingleResultView.this.D.getChildAt(i3);
                        if (childAt != null && childAt.getTag() != null) {
                            Object tag = childAt.getTag();
                            if (tag instanceof QBarResult) {
                                rectF = ((QBarResult) tag).f276509h;
                            } else if (tag instanceof QMiniResult) {
                                rectF = ((QMiniResult) tag).f276512f;
                            } else {
                                rectF = null;
                            }
                            if (rectF != null) {
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                                Rect y16 = ScannerSingleResultView.this.y(rectF);
                                layoutParams.topMargin = y16.centerY() - ViewUtils.dip2px(27.0f);
                                layoutParams.leftMargin = y16.centerX() - ViewUtils.dip2px(27.0f);
                                QLog.i("IQRScanConst_ScannerSingleResultView", 1, "mUpdatePointPositionRunnable location\uff1a" + rectF + " locInView:" + y16);
                                childAt.setVisibility(0);
                            }
                        }
                    }
                    ScannerSingleResultView.this.D.requestLayout();
                    ScannerSingleResultView.this.v(true);
                }
            }
        };
    }

    public ScannerSingleResultView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f276810d = false;
        this.E = false;
        this.J = new Runnable() { // from class: com.tencent.mobileqq.qrscan.view.ScannerSingleResultView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScannerSingleResultView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                RectF rectF;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int childCount = ScannerSingleResultView.this.D.getChildCount();
                if (ScannerSingleResultView.this.E && ScannerSingleResultView.this.G > 0 && ScannerSingleResultView.this.H > 0 && childCount > 0) {
                    for (int i36 = 0; i36 < childCount; i36++) {
                        View childAt = ScannerSingleResultView.this.D.getChildAt(i36);
                        if (childAt != null && childAt.getTag() != null) {
                            Object tag = childAt.getTag();
                            if (tag instanceof QBarResult) {
                                rectF = ((QBarResult) tag).f276509h;
                            } else if (tag instanceof QMiniResult) {
                                rectF = ((QMiniResult) tag).f276512f;
                            } else {
                                rectF = null;
                            }
                            if (rectF != null) {
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                                Rect y16 = ScannerSingleResultView.this.y(rectF);
                                layoutParams.topMargin = y16.centerY() - ViewUtils.dip2px(27.0f);
                                layoutParams.leftMargin = y16.centerX() - ViewUtils.dip2px(27.0f);
                                QLog.i("IQRScanConst_ScannerSingleResultView", 1, "mUpdatePointPositionRunnable location\uff1a" + rectF + " locInView:" + y16);
                                childAt.setVisibility(0);
                            }
                        }
                    }
                    ScannerSingleResultView.this.D.requestLayout();
                    ScannerSingleResultView.this.v(true);
                }
            }
        };
    }
}
