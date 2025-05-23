package com.tencent.mobileqq.qrscan.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
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
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ScannerMultiResultSelectView extends RelativeLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private TextView C;
    private TextView D;
    private LottieAnimationView E;
    private FrameLayout F;
    private c G;
    private long H;
    private boolean I;
    private Bitmap J;
    private int K;
    private int L;
    private int M;
    private int N;
    private h P;
    private Runnable Q;

    /* renamed from: d, reason: collision with root package name */
    private boolean f276800d;

    /* renamed from: e, reason: collision with root package name */
    private ScannerResult f276801e;

    /* renamed from: f, reason: collision with root package name */
    private int f276802f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f276803h;

    /* renamed from: i, reason: collision with root package name */
    private View f276804i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f276805m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LottieAnimationView f276807d;

        a(LottieAnimationView lottieAnimationView) {
            this.f276807d = lottieAnimationView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerMultiResultSelectView.this, (Object) lottieAnimationView);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            this.f276807d.clearAnimation();
            this.f276807d.setVisibility(8);
            ScannerMultiResultSelectView.this.E.setVisibility(0);
            ScannerMultiResultSelectView.this.E.playAnimation();
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

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerMultiResultSelectView.this);
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
            } else if (ScannerMultiResultSelectView.this.C.getAlpha() == 0.0f) {
                ScannerMultiResultSelectView.this.C.setVisibility(8);
            } else {
                ScannerMultiResultSelectView.this.C.setVisibility(0);
            }
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

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface c {
        void a(QBarResult qBarResult, int i3, h hVar);

        void b();

        void c(QMiniResult qMiniResult, int i3, h hVar);
    }

    public ScannerMultiResultSelectView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f276800d = false;
        this.H = 0L;
        this.I = false;
        this.M = 0;
        this.N = 4;
        this.Q = new Runnable() { // from class: com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScannerMultiResultSelectView.this);
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
                int childCount = ScannerMultiResultSelectView.this.F.getChildCount();
                if (ScannerMultiResultSelectView.this.I && ScannerMultiResultSelectView.this.K > 0 && ScannerMultiResultSelectView.this.L > 0 && childCount > 0) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = ScannerMultiResultSelectView.this.F.getChildAt(i3);
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
                                Rect D = ScannerMultiResultSelectView.this.D(rectF);
                                layoutParams.topMargin = D.centerY() - ViewUtils.dip2px(27.0f);
                                layoutParams.leftMargin = D.centerX() - ViewUtils.dip2px(27.0f);
                                if (QLog.isColorLevel()) {
                                    QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "mUpdatePointPositionRunnable location\uff1a" + rectF + " locInView:" + D);
                                }
                                childAt.setVisibility(0);
                            }
                        }
                    }
                    ScannerMultiResultSelectView.this.F.requestLayout();
                    ScannerMultiResultSelectView.this.v(1);
                    ScannerMultiResultSelectView.this.A(true);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z16) {
        int childCount = this.F.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.F.getChildAt(i3);
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

    private void C(LottieAnimationView lottieAnimationView) {
        int childCount = this.F.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (this.F.getChildAt(i3) != lottieAnimationView) {
                this.F.getChildAt(i3).setVisibility(8);
            }
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, ((this.K / 2) - ViewUtils.dpToPx(27.0f)) - lottieAnimationView.getX(), 0.0f, ((this.L / 2) - lottieAnimationView.getY()) - ViewUtils.dpToPx(27.0f));
        translateAnimation.setDuration(400L);
        translateAnimation.setAnimationListener(new a(lottieAnimationView));
        lottieAnimationView.startAnimation(translateAnimation);
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect D(RectF rectF) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19 = this.K;
        int i26 = this.L;
        int width = this.J.getWidth();
        int height = this.J.getHeight();
        boolean z16 = false;
        if (!rectF.isEmpty() && height > 0 && width > 0) {
            float f16 = i19;
            float f17 = i26;
            if ((width * 1.0f) / height > (1.0f * f16) / f17) {
                z16 = true;
            }
            if (this.N == 3) {
                z16 = !z16;
            }
            if (z16) {
                int i27 = (i19 * height) / width;
                i18 = (int) (rectF.left * f16);
                i16 = (int) (rectF.right * f16);
                int i28 = (i26 / 2) - (i27 / 2);
                float f18 = i27;
                i3 = ((int) (rectF.top * f18)) + i28;
                i17 = ((int) (rectF.bottom * f18)) + i28;
            } else {
                int i29 = (i26 * width) / height;
                i3 = (int) (rectF.top * f17);
                int i36 = (int) (rectF.bottom * f17);
                int i37 = (i19 / 2) - (i29 / 2);
                float f19 = i29;
                int i38 = ((int) (rectF.left * f19)) + i37;
                i16 = ((int) (rectF.right * f19)) + i37;
                i17 = i36;
                i18 = i38;
            }
            return new Rect(i18, i3, i16, i17);
        }
        return new Rect(0, 0, i19, i26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (QLog.isColorLevel()) {
            QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "updateAfterDecodeBitmap mShowing\uff1a" + this.I + " mBitmap:" + this.J + " mScannerResult:" + this.f276801e);
        }
        if (!this.I) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerMultiResultSelectView.this);
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
                    QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "updateAfterDecodeBitmap mShowing\uff1a" + ScannerMultiResultSelectView.this.I + " mBitmap:" + ScannerMultiResultSelectView.this.J);
                }
                if (!ScannerMultiResultSelectView.this.I) {
                    return;
                }
                if (ScannerMultiResultSelectView.this.J != null) {
                    ScannerMultiResultSelectView.this.F();
                    return;
                }
                if (ScannerMultiResultSelectView.this.G != null && ScannerMultiResultSelectView.this.f276801e != null) {
                    if (ScannerMultiResultSelectView.this.f276801e.l()) {
                        ScannerMultiResultSelectView.this.G.a(ScannerMultiResultSelectView.this.f276801e.f276520d.get(0), ScannerMultiResultSelectView.this.f276802f, ScannerMultiResultSelectView.this.P);
                    } else if (ScannerMultiResultSelectView.this.f276801e.j()) {
                        ScannerMultiResultSelectView.this.G.c(ScannerMultiResultSelectView.this.f276801e.f276521e.get(0), ScannerMultiResultSelectView.this.f276802f, ScannerMultiResultSelectView.this.P);
                    } else {
                        ScannerMultiResultSelectView.this.x();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        int i3;
        this.F.removeAllViews();
        Bitmap bitmap = this.J;
        if (bitmap == null) {
            w();
            return;
        }
        this.f276803h.setImageBitmap(bitmap);
        if ((this.f276802f & 1) != 0 && this.f276801e.l()) {
            Iterator<QBarResult> it = this.f276801e.f276520d.iterator();
            while (it.hasNext()) {
                s().setTag(it.next());
            }
            i3 = 1;
        } else {
            i3 = 0;
        }
        if ((this.f276802f & 2) != 0 && this.f276801e.j()) {
            Iterator<QMiniResult> it5 = this.f276801e.f276521e.iterator();
            while (it5.hasNext()) {
                s().setTag(it5.next());
            }
            i3 |= 2;
        }
        if (i3 == 1) {
            this.C.setText(R.string.f216675yy);
        } else if (i3 == 2) {
            this.C.setText(R.string.f216665yx);
        } else {
            this.C.setText(R.string.f216655yw);
        }
        if (this.K > 0 && this.L > 0) {
            this.Q.run();
        }
        u();
    }

    private View s() {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(getContext());
        lottieAnimationView.setImageAssetsFolder("qr_scan_multi_point/images");
        lottieAnimationView.setAnimation("qr_scan_multi_point/multi_in.json");
        this.F.addView(lottieAnimationView, new FrameLayout.LayoutParams(ViewUtils.dip2px(54.0f), ViewUtils.dip2px(54.0f)));
        lottieAnimationView.setOnClickListener(this);
        lottieAnimationView.setVisibility(8);
        return lottieAnimationView;
    }

    private void t() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.D, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    private void u() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f276804i, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3) {
        float f16 = i3;
        if (f16 == this.C.getAlpha()) {
            return;
        }
        TextView textView = this.C;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, com.tencent.luggage.wxa.c8.c.f123400v, textView.getAlpha(), f16);
        ofFloat.setDuration(300L);
        ofFloat.addListener(new b());
        ofFloat.start();
    }

    private void w() {
        h hVar = this.P;
        if (hVar == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable(hVar) { // from class: com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ h f276806d;

            {
                this.f276806d = hVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScannerMultiResultSelectView.this, (Object) hVar);
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
                    QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "decodeBitmap mShowing\uff1a" + ScannerMultiResultSelectView.this.I);
                }
                try {
                    if (!TextUtils.isEmpty(this.f276806d.f276640d)) {
                        ScannerMultiResultSelectView.this.J = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeBitmapFromFile(this.f276806d.f276640d, ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight());
                    } else if (this.f276806d.f276637a != null) {
                        IScanUtilApi iScanUtilApi = (IScanUtilApi) QRoute.api(IScanUtilApi.class);
                        h hVar2 = this.f276806d;
                        Bitmap decodeBitmapFromYuv = iScanUtilApi.decodeBitmapFromYuv(hVar2.f276637a, hVar2.f276638b, hVar2.f276639c);
                        ScannerMultiResultSelectView scannerMultiResultSelectView = ScannerMultiResultSelectView.this;
                        scannerMultiResultSelectView.J = scannerMultiResultSelectView.z(decodeBitmapFromYuv, 90.0f);
                        this.f276806d.f276637a = null;
                    }
                } catch (Throwable th5) {
                    ScannerMultiResultSelectView.this.J = null;
                    QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "decodeBitmap error:", th5);
                }
                ScannerMultiResultSelectView.this.E();
            }
        }, 16, null, true);
    }

    private void y(RelativeLayout relativeLayout) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fxu, (ViewGroup) this, true);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
        this.f276803h = imageView;
        if (this.N == 3) {
            imageView.setBackgroundColor(0);
            this.f276803h.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        View findViewById = inflate.findViewById(R.id.enc);
        this.f276804i = findViewById;
        findViewById.setBackgroundColor(Color.parseColor("#80000000"));
        this.f276804i.setAlpha(0.0f);
        this.f276805m = (TextView) inflate.findViewById(R.id.cancel);
        TextView textView = (TextView) inflate.findViewById(R.id.jm8);
        this.C = textView;
        textView.setAlpha(0.0f);
        TextView textView2 = (TextView) inflate.findViewById(R.id.yt9);
        this.D = textView2;
        textView2.setAlpha(0.0f);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.efs);
        this.E = lottieAnimationView;
        lottieAnimationView.setImageAssetsFolder("qr_scan_multi_point/images");
        this.E.setAnimation("qr_scan_multi_point/multi_loading.json");
        this.E.setRepeatCount(-1);
        this.E.setVisibility(4);
        this.F = (FrameLayout) inflate.findViewById(R.id.f26160cs);
        relativeLayout.addView(this, new RelativeLayout.LayoutParams(-1, -1));
        this.f276805m.setOnClickListener(this);
        this.f276800d = true;
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            ((RelativeLayout.LayoutParams) this.C.getLayoutParams()).topMargin = ViewUtils.dip2px(60.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap z(Bitmap bitmap, float f16) {
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
                QLog.e("IQRScanConst_ScannerMultiResultSelectView", 1, "rotateBitmap Exception = " + e16);
                return bitmap2;
            } catch (OutOfMemoryError e17) {
                QLog.e("IQRScanConst_ScannerMultiResultSelectView", 1, "rotateBitmap OutOfMemoryError = " + e17);
                return bitmap2;
            }
        }
        return bitmap;
    }

    public void B(RelativeLayout relativeLayout, ScannerResult scannerResult, int i3, h hVar, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, relativeLayout, scannerResult, Integer.valueOf(i3), hVar, Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "show requestType\uff1a" + i3 + " scannerResult:" + scannerResult + " data:" + hVar);
        }
        this.f276801e = scannerResult;
        this.f276802f = i3;
        this.P = hVar;
        this.M = i16;
        this.N = i17;
        if (!this.f276800d) {
            y(relativeLayout);
        }
        F();
        setVisibility(0);
        this.I = true;
        ReportController.o(null, "dc00898", "", "", "0X800B5E1", "0X800B5E1", this.M, 0, "", "", "", "");
    }

    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.I;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else if (this.G != null && System.currentTimeMillis() - this.H >= 1000) {
            this.H = System.currentTimeMillis();
            if (view.getId() == R.id.cancel) {
                x();
                this.G.b();
                ReportController.o(null, "dc00898", "", "", "0X800B5E3", "0X800B5E3", this.M, 0, "", "", "", "");
            } else {
                v(0);
                Object tag = view.getTag();
                if (tag instanceof QBarResult) {
                    A(false);
                    C((LottieAnimationView) view);
                    this.G.a((QBarResult) tag, this.f276802f, this.P);
                    ReportController.o(null, "dc00898", "", "", "0X800B5E2", "0X800B5E2", this.M, 0, "", "", "", "");
                } else if (tag instanceof QMiniResult) {
                    this.G.c((QMiniResult) tag, this.f276802f, this.P);
                    A(false);
                    C((LottieAnimationView) view);
                    ReportController.o(null, "dc00898", "", "", "0X800B5E2", "0X800B5E2", this.M, 0, "", "", "", "");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (measuredWidth != this.K || measuredHeight != this.L) {
                this.K = measuredWidth;
                this.L = measuredHeight;
            }
        }
    }

    public void setMultiSelectListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
        } else {
            this.G = cVar;
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!this.I) {
            return;
        }
        A(false);
        this.f276804i.setAlpha(0.0f);
        this.C.setVisibility(0);
        this.C.setAlpha(0.0f);
        setVisibility(8);
        this.I = false;
        this.f276803h.setImageBitmap(null);
        Bitmap bitmap = this.J;
        if (bitmap != null) {
            bitmap.recycle();
        }
        removeCallbacks(this.Q);
        this.J = null;
        c cVar = this.G;
        if (cVar != null) {
            cVar.b();
        }
    }

    public ScannerMultiResultSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f276800d = false;
        this.H = 0L;
        this.I = false;
        this.M = 0;
        this.N = 4;
        this.Q = new Runnable() { // from class: com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScannerMultiResultSelectView.this);
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
                int childCount = ScannerMultiResultSelectView.this.F.getChildCount();
                if (ScannerMultiResultSelectView.this.I && ScannerMultiResultSelectView.this.K > 0 && ScannerMultiResultSelectView.this.L > 0 && childCount > 0) {
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = ScannerMultiResultSelectView.this.F.getChildAt(i3);
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
                                Rect D = ScannerMultiResultSelectView.this.D(rectF);
                                layoutParams.topMargin = D.centerY() - ViewUtils.dip2px(27.0f);
                                layoutParams.leftMargin = D.centerX() - ViewUtils.dip2px(27.0f);
                                if (QLog.isColorLevel()) {
                                    QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "mUpdatePointPositionRunnable location\uff1a" + rectF + " locInView:" + D);
                                }
                                childAt.setVisibility(0);
                            }
                        }
                    }
                    ScannerMultiResultSelectView.this.F.requestLayout();
                    ScannerMultiResultSelectView.this.v(1);
                    ScannerMultiResultSelectView.this.A(true);
                }
            }
        };
    }

    public ScannerMultiResultSelectView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f276800d = false;
        this.H = 0L;
        this.I = false;
        this.M = 0;
        this.N = 4;
        this.Q = new Runnable() { // from class: com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScannerMultiResultSelectView.this);
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
                int childCount = ScannerMultiResultSelectView.this.F.getChildCount();
                if (ScannerMultiResultSelectView.this.I && ScannerMultiResultSelectView.this.K > 0 && ScannerMultiResultSelectView.this.L > 0 && childCount > 0) {
                    for (int i36 = 0; i36 < childCount; i36++) {
                        View childAt = ScannerMultiResultSelectView.this.F.getChildAt(i36);
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
                                Rect D = ScannerMultiResultSelectView.this.D(rectF);
                                layoutParams.topMargin = D.centerY() - ViewUtils.dip2px(27.0f);
                                layoutParams.leftMargin = D.centerX() - ViewUtils.dip2px(27.0f);
                                if (QLog.isColorLevel()) {
                                    QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "mUpdatePointPositionRunnable location\uff1a" + rectF + " locInView:" + D);
                                }
                                childAt.setVisibility(0);
                            }
                        }
                    }
                    ScannerMultiResultSelectView.this.F.requestLayout();
                    ScannerMultiResultSelectView.this.v(1);
                    ScannerMultiResultSelectView.this.A(true);
                }
            }
        };
    }
}
