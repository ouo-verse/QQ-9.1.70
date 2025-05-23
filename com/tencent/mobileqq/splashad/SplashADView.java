package com.tencent.mobileqq.splashad;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.viewmodel.newbarrage.widgets.QFSGradientTextView;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.qqcircle.widgets.bc;
import com.tencent.gdtad.basics.adshake.OlympicShakeView;
import com.tencent.gdtad.basics.adshake.OnShakeListener;
import com.tencent.gdtad.basics.flip.FlipView;
import com.tencent.gdtad.basics.twist.TwistView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.splashad.slopeslide.SlopeSlideView;
import com.tencent.mobileqq.util.ar;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SplashADView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: h0, reason: collision with root package name */
    private static SplashADView f288718h0;
    View C;
    Animation D;
    ImageView E;
    View F;
    TextView G;
    ValueAnimator H;
    ImageView I;
    ImageView J;
    SplashGestureTrackView K;
    View L;
    Animation M;
    RelativeLayout N;
    ImageView P;
    OlympicShakeView Q;
    SlopeSlideView R;
    QFSPagAnimView S;
    TwistView T;
    FlipView U;
    public boolean V;
    public boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f288719a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f288720b0;

    /* renamed from: c0, reason: collision with root package name */
    RelativeLayout f288721c0;

    /* renamed from: d, reason: collision with root package name */
    public o43.b f288722d;

    /* renamed from: d0, reason: collision with root package name */
    private f f288723d0;

    /* renamed from: e, reason: collision with root package name */
    private e f288724e;

    /* renamed from: e0, reason: collision with root package name */
    private g f288725e0;

    /* renamed from: f, reason: collision with root package name */
    TextView f288726f;

    /* renamed from: f0, reason: collision with root package name */
    private VideoPlayerCallback f288727f0;

    /* renamed from: g0, reason: collision with root package name */
    private QFSPagAnimView.c f288728g0;

    /* renamed from: h, reason: collision with root package name */
    View f288729h;

    /* renamed from: i, reason: collision with root package name */
    BaseVideoView f288730i;

    /* renamed from: m, reason: collision with root package name */
    TextView f288731m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashADView.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                SplashADView.this.E.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                SplashADView.this.S();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashADView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
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
            } else {
                SplashADView.this.J.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements VideoPlayerCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashADView.this);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onCapFrame(long j3, boolean z16, int i3, int i16, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadComplete(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onDownloadProgress(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), Long.valueOf(j16));
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onFirstFrameRendered(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                SplashADView.this.H();
            } else {
                iPatchRedirector.redirect((short) 9, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onLoopBack(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Long.valueOf(j16));
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayError(long j3, int i3, int i16, int i17, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
                return;
            }
            QLog.d("QSplash@SplashADView", 2, "onPlayError , errorType = " + i16 + ", errorCode=" + i17 + " " + str);
            SplashADView.this.f288725e0.onPlayError();
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onPlayProgress(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Long.valueOf(j16));
            }
        }

        @Override // com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
        public void onStateChange(long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QSplash@SplashADView", 2, "onStateChange , state = " + i3 + ", msgUniseq=" + j3);
            }
            if (i3 == 8) {
                if (SplashADView.this.z()) {
                    SplashADView.this.Q();
                } else {
                    SplashADView.this.f288723d0.a();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements QFSPagAnimView.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashADView.this);
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationCancel(QFSPagAnimView qFSPagAnimView) {
            bc.a(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onAnimationEnd(QFSPagAnimView qFSPagAnimView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) qFSPagAnimView);
            } else {
                QLog.d("QSplash@SplashADView", 1, "onAnimationEnd");
                SplashADView.this.f288723d0.a();
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationRepeat(QFSPagAnimView qFSPagAnimView) {
            bc.c(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onAnimationStart(QFSPagAnimView qFSPagAnimView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) qFSPagAnimView);
            } else {
                QLog.d("QSplash@SplashADView", 1, "onAnimationStart");
                SplashADView.this.H();
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public /* synthetic */ void onAnimationUpdate(QFSPagAnimView qFSPagAnimView) {
            bc.e(this, qFSPagAnimView);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView.c
        public void onPagPlayError(QFSPagAnimView qFSPagAnimView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) qFSPagAnimView, (Object) str);
            } else {
                QLog.d("QSplash@SplashADView", 1, "onPagPlayError");
                SplashADView.this.f288725e0.onPlayError();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface e {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface f {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface g {
        void onPlayError();
    }

    public SplashADView(o43.b bVar, Context context) {
        this(bVar, context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean A(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                this.C.setBackground(SplashADUtil.d(this.f288722d.f422018q, ViewUtils.dpToPx(30.0f)));
                return false;
            }
            return false;
        }
        ValueAnimator valueAnimator = this.H;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.C.setBackground(SplashADUtil.d(this.f288722d.f422019r, ViewUtils.dpToPx(30.0f)));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(ValueAnimator valueAnimator) {
        if (this.C.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.C.getBackground()).setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(Bitmap bitmap) {
        ImageView imageView;
        if (!this.f288719a0 && (imageView = this.P) != null) {
            imageView.setImageBitmap(bitmap);
            QLog.i("QSplash@SplashADView", 1, "finish to set entry static image");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        try {
            if (!this.f288719a0 && this.f288722d != null) {
                QLog.i("QSplash@SplashADView", 1, "local rsc:" + this.f288722d.D);
                if (!TextUtils.isEmpty(this.f288722d.D) && new File(this.f288722d.D).exists()) {
                    final Bitmap b16 = ar.b(this.f288722d.D, BaseAIOUtils.f(288.0f, this.P.getContext().getResources()), BaseAIOUtils.f(67.0f, this.P.getContext().getResources()));
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.splashad.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            SplashADView.this.C(b16);
                        }
                    });
                    return;
                }
                return;
            }
            QLog.i("QSplash@SplashADView", 1, "isResRelease:" + this.f288719a0 + ",mAdEntry:" + this.f288722d);
        } catch (Throwable th5) {
            QLog.e("QSplash@SplashADView", 1, th5, new Object[0]);
        }
    }

    private GradientDrawable E() {
        return k("#26000000");
    }

    private GradientDrawable F(String str) {
        return k(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.splashad.SplashADView.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SplashADView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (SplashADView.this.f288724e != null) {
                    QLog.i("QSplash@SplashADView", 1, "play is ready");
                    SplashADView.this.f288724e.a();
                }
            }
        }, 20L);
        U();
    }

    private Drawable N(String str) {
        return new LayerDrawable(new Drawable[]{F(str), E()});
    }

    private void P() {
        try {
            QLog.i("QSplash@SplashADView", 1, "[setEntryBtnStaticImage]");
            o43.b bVar = this.f288722d;
            if (bVar != null && bVar.B == 1) {
                int i3 = 8;
                this.f288731m.setVisibility(8);
                this.P.setVisibility(0);
                if (!z()) {
                    i3 = 0;
                }
                this.N.setVisibility(i3);
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.splashad.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        SplashADView.this.D();
                    }
                });
            }
        } catch (Throwable th5) {
            QLog.e("QSplash@SplashADView", 1, th5, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        TextView textView;
        int i3 = this.f288722d.B;
        if (i3 == 1) {
            RelativeLayout relativeLayout = this.N;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                return;
            }
            return;
        }
        if (i3 == 2 && (textView = this.f288731m) != null) {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        o43.b bVar = this.f288722d;
        if (bVar != null && bVar.B == 5 && this.E != null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, ViewUtils.dpToPx(20.0f), 0.0f, 0.0f);
            this.D = translateAnimation;
            translateAnimation.setRepeatMode(2);
            this.D.setRepeatCount(-1);
            this.D.setDuration(500L);
            this.D.setFillAfter(true);
            this.D.setInterpolator(new AccelerateDecelerateInterpolator());
            this.E.startAnimation(this.D);
        }
    }

    private GradientDrawable k(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(6.0f));
        gradientDrawable.setColor(SplashADUtil.r(str));
        return gradientDrawable;
    }

    private Drawable l(String str) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{-16842919}, F(str));
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, N(str));
        return stateListDrawable;
    }

    private AlphaAnimation m() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(660L);
        alphaAnimation.setStartOffset(660L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new b());
        return alphaAnimation;
    }

    public static synchronized SplashADView n(o43.b bVar, Context context) {
        SplashADView splashADView;
        synchronized (SplashADView.class) {
            if (f288718h0 == null && bVar != null && context != null) {
                f288718h0 = new SplashADView(bVar, context);
            }
            splashADView = f288718h0;
        }
        return splashADView;
    }

    private boolean p(Context context) {
        String str = "";
        QLog.i("QSplash@SplashADView", 1, "mAdEntry =" + this.f288722d.toString());
        LayoutInflater.from(context).inflate(com.tencent.mobileqq.R.layout.f169092bz2, (ViewGroup) this, true);
        this.f288726f = (TextView) findViewById(com.tencent.mobileqq.R.id.dzp);
        this.K = (SplashGestureTrackView) findViewById(com.tencent.mobileqq.R.id.f87334u3);
        int i3 = this.f288722d.B;
        if (i3 != 5 && i3 != 4) {
            if (i3 == 3) {
                w(context);
            } else if (i3 == 6) {
                t(context);
            } else if (i3 == 9) {
                u(context, true);
            } else if (i3 == 7) {
                x(context);
            } else if (i3 == 8) {
                q(context);
            } else {
                v();
            }
        } else {
            r();
        }
        ((ImageView) findViewById(com.tencent.mobileqq.R.id.f87324u2)).setImageBitmap(SplashADUtil.e(this.f288722d.A));
        o43.b bVar = this.f288722d;
        if (bVar.f422007f == 1 && bVar.f422005d == 0) {
            this.f288726f.setText(HardCodeUtil.qqStr(com.tencent.mobileqq.R.string.tnb));
        }
        this.f288726f.setVisibility(0);
        this.f288721c0 = (RelativeLayout) findViewById(com.tencent.mobileqq.R.id.j0r);
        this.f288729h = findViewById(com.tencent.mobileqq.R.id.bb7);
        if (this.f288722d.W) {
            ((ViewGroup) findViewById(com.tencent.mobileqq.R.id.vst)).setVisibility(0);
            try {
                str = new JSONObject(this.f288722d.X).optString("avatar", "");
            } catch (JSONException e16) {
                QLog.e("QSplash@SplashADView", 1, "exception", e16);
            }
            if (!TextUtils.isEmpty(str)) {
                ((ImageView) findViewById(com.tencent.mobileqq.R.id.vss)).setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(str).a());
            }
            QFSGradientTextView qFSGradientTextView = (QFSGradientTextView) findViewById(com.tencent.mobileqq.R.id.vsu);
            qFSGradientTextView.setText(this.f288722d.Y);
            if (!TextUtils.isEmpty(this.f288722d.Z)) {
                try {
                    qFSGradientTextView.setTextColor(Color.parseColor(this.f288722d.Z));
                } catch (Exception e17) {
                    QLog.e("QSplash@SplashADView", 1, "exception", e17);
                }
                if (QLog.isDebugVersion()) {
                    QLog.i("QSplash@SplashADView", 1, "greetingNickColor = " + this.f288722d.Z);
                }
            }
            ((ImageView) findViewById(com.tencent.mobileqq.R.id.vsv)).setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(this.f288722d.f422002a0).a());
        }
        int i16 = this.f288722d.f422003b;
        if (i16 != 0) {
            if (i16 != 2) {
                if (i16 != 3) {
                    return false;
                }
                return s(context);
            }
            return y(context);
        }
        ImageView imageView = new ImageView(context);
        imageView.setTag("image");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inMutable = true;
        try {
            QLog.i("QSplash@SplashADView", 1, "respath =" + this.f288722d.f422004c);
            imageView.setImageBitmap(com.tencent.mobileqq.util.j.d(this.f288722d.f422004c, options));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f288721c0.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
            return true;
        } catch (OutOfMemoryError e18) {
            QLog.e("QSplash@SplashADView", 1, e18.toString());
            return false;
        }
    }

    private void q(Context context) {
        float f16;
        FlipView flipView = new FlipView(context);
        this.U = flipView;
        flipView.setTitleText(this.f288722d.F);
        this.U.setSubTitleText(this.f288722d.G);
        FlipView flipView2 = this.U;
        int i3 = this.f288722d.S;
        if (i3 > 0) {
            f16 = i3;
        } else {
            f16 = 40.0f;
        }
        flipView2.setTargetRotationThreshold(f16);
        this.U.setReverseRotationThreshold(this.f288722d.R);
        FrameLayout frameLayout = (FrameLayout) findViewById(com.tencent.mobileqq.R.id.vap);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.U.setVisibility(8);
        frameLayout.addView(this.U, layoutParams);
    }

    private void r() {
        this.C = findViewById(com.tencent.mobileqq.R.id.f87354u5);
        ImageView imageView = (ImageView) findViewById(com.tencent.mobileqq.R.id.f87344u4);
        this.E = imageView;
        boolean z16 = true;
        try {
            if (imageView.getViewTreeObserver() != null) {
                this.E.getViewTreeObserver().addOnGlobalLayoutListener(new a());
            }
        } catch (Throwable th5) {
            QLog.e("QSplash@SplashADView", 1, th5, new Object[0]);
        }
        this.F = findViewById(com.tencent.mobileqq.R.id.f87364u6);
        this.G = (TextView) findViewById(com.tencent.mobileqq.R.id.f87374u7);
        this.I = (ImageView) findViewById(com.tencent.mobileqq.R.id.f87414ua);
        this.J = (ImageView) findViewById(com.tencent.mobileqq.R.id.f87404u_);
        this.L = findViewById(com.tencent.mobileqq.R.id.f87424ub);
        o43.b bVar = this.f288722d;
        if (bVar == null) {
            return;
        }
        if (TextUtils.isEmpty(bVar.f422015n)) {
            this.C.setVisibility(8);
            this.I.setVisibility(8);
            return;
        }
        this.G.setText(this.f288722d.f422015n);
        this.G.setTextColor(SplashADUtil.r(this.f288722d.f422016o));
        this.C.setVisibility(0);
        this.C.setBackground(SplashADUtil.d(this.f288722d.f422017p, ViewUtils.dpToPx(30.0f)));
        this.C.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.splashad.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean A;
                A = SplashADView.this.A(view, motionEvent);
                return A;
            }
        });
        o43.b bVar2 = this.f288722d;
        if (bVar2.B == 4) {
            SplashGestureTrackView splashGestureTrackView = this.K;
            if (bVar2.f422022u != 1) {
                z16 = false;
            }
            splashGestureTrackView.c(z16);
            this.I.setImageBitmap(SplashADUtil.e(this.f288722d.f422025x));
            this.J.setImageBitmap(SplashADUtil.e(this.f288722d.f422026y));
        }
        if (this.f288722d.B == 5) {
            this.E.setVisibility(0);
            this.F.setVisibility(0);
            this.G.setMaxWidth(ViewUtils.dpToPx(210.0f));
        }
    }

    private boolean s(Context context) {
        QFSPagAnimView qFSPagAnimView = new QFSPagAnimView(context);
        this.S = qFSPagAnimView;
        qFSPagAnimView.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        this.S.setLayoutParams(layoutParams);
        this.f288721c0.addView(this.S);
        return true;
    }

    private void t(Context context) {
        u(context, false);
    }

    private void u(Context context, boolean z16) {
        String str;
        String str2;
        SlopeSlideView slopeSlideView = new SlopeSlideView(context);
        this.R = slopeSlideView;
        if (z16) {
            str = "\u524d\u503e\u6216\u70b9\u51fb";
        } else {
            str = "\u524d\u503e\u6216\u6ed1\u52a8\u624b\u673a";
        }
        if (!TextUtils.isEmpty(this.f288722d.F)) {
            str = this.f288722d.F;
        }
        slopeSlideView.setTitle(str);
        SlopeSlideView slopeSlideView2 = this.R;
        if (TextUtils.isEmpty(this.f288722d.G)) {
            str2 = "\u8df3\u8f6c\u8be6\u60c5\u9875\u6216\u7b2c\u4e09\u65b9\u5e94\u7528";
        } else {
            str2 = this.f288722d.G;
        }
        slopeSlideView2.setSubTitle(str2);
        this.R.setRotationThreshold(this.f288722d.P);
        this.R.setIconBitmap(SplashADUtil.e(this.f288722d.O));
        this.R.setIsOnlyEnableClick(z16);
        if (z16) {
            View findViewById = findViewById(com.tencent.mobileqq.R.id.f87384u8);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        } else {
            this.R.setHotArea(1, 0.0f, 0.0f, 0.0f, this.f288722d.f422020s);
            this.R.setSlideThresholdWithDp(this.f288722d.f422021t);
            this.R.setStrokeColor(-1);
            SlopeSlideView slopeSlideView3 = this.R;
            boolean z17 = true;
            if (this.f288722d.f422022u != 1) {
                z17 = false;
            }
            slopeSlideView3.setEnableShowStroke(z17);
        }
        ((FrameLayout) findViewById(com.tencent.mobileqq.R.id.f86334rd)).addView(this.R, new FrameLayout.LayoutParams(-1, -1));
    }

    private void v() {
        int i3;
        this.f288731m = (TextView) findViewById(com.tencent.mobileqq.R.id.f87394u9);
        this.N = (RelativeLayout) findViewById(com.tencent.mobileqq.R.id.f75503z5);
        ImageView imageView = (ImageView) findViewById(com.tencent.mobileqq.R.id.y2t);
        this.P = imageView;
        if (this.N != null && imageView != null && this.f288731m != null) {
            QLog.i("QSplash@SplashADView", 1, "[initSplashEntryText], btnType:" + this.f288722d.B + ",id:");
            o43.b bVar = this.f288722d;
            int i16 = bVar.B;
            if (i16 != 0 && i16 != 2) {
                if (i16 == 1) {
                    P();
                }
            } else {
                if (TextUtils.isEmpty(bVar.f422015n)) {
                    this.f288731m.setVisibility(8);
                    this.N.setVisibility(8);
                    return;
                }
                if (z()) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                this.f288731m.setVisibility(i3);
                this.P.setVisibility(8);
                this.N.setVisibility(8);
                this.f288731m.setText(this.f288722d.f422015n);
                this.f288731m.setTextColor(SplashADUtil.r(this.f288722d.f422016o));
                this.f288731m.setBackgroundDrawable(l(this.f288722d.f422017p));
            }
        }
    }

    private void w(Context context) {
        try {
            o43.b bVar = this.f288722d;
            if (bVar != null && !this.f288719a0 && bVar.E == 1) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(com.tencent.mobileqq.R.id.f75503z5);
                this.N = relativeLayout;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                OlympicShakeView olympicShakeView = this.Q;
                if (olympicShakeView != null && olympicShakeView.getParent() != null) {
                    this.Q.stop();
                    ((ViewGroup) this.Q.getParent()).removeView(this.Q);
                }
                this.Q = new OlympicShakeView(context);
                RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(com.tencent.mobileqq.R.id.j0r);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(12);
                relativeLayout2.addView(this.Q, layoutParams);
                OlympicShakeView olympicShakeView2 = this.Q;
                if (olympicShakeView2 == null) {
                    return;
                }
                olympicShakeView2.setTitle(this.f288722d.F);
                this.Q.setSubTitle(this.f288722d.G);
                this.Q.setShakeCircleBgColor(this.f288722d.H);
                OlympicShakeView olympicShakeView3 = this.Q;
                o43.b bVar2 = this.f288722d;
                olympicShakeView3.setShakeValue(bVar2.I / 100.0f, bVar2.J);
                OlympicShakeView olympicShakeView4 = this.Q;
                o43.b bVar3 = this.f288722d;
                olympicShakeView4.setShakeFactor(bVar3.K, bVar3.L, bVar3.M);
                this.Q.setShakeCircleBgShowAlways(false);
                this.Q.setVisibility(0);
            }
        } catch (Throwable th5) {
            this.Q = null;
            QLog.e("QSplash@SplashADView", 1, th5, new Object[0]);
        }
    }

    private void x(Context context) {
        String str;
        String str2;
        int i3;
        float f16;
        int i16 = 1;
        QLog.i("QSplash@SplashADView", 1, "initTwistView ");
        if (this.f288722d == null) {
            return;
        }
        TwistView twistView = this.T;
        if (twistView != null && twistView.getParent() != null) {
            this.T.s();
            ((ViewGroup) this.T.getParent()).removeView(this.T);
        }
        TwistView twistView2 = new TwistView(context);
        this.T = twistView2;
        if (TextUtils.isEmpty(this.f288722d.F)) {
            str = "\u626d\u52a8\u624b\u673a";
        } else {
            str = this.f288722d.F;
        }
        twistView2.setTitle(str);
        TwistView twistView3 = this.T;
        if (TextUtils.isEmpty(this.f288722d.G)) {
            str2 = "\u968f\u624b\u4e00\u626d\uff0c\u83b7\u53d6\u60ca\u559c";
        } else {
            str2 = this.f288722d.G;
        }
        twistView3.setSubTitle(str2);
        int i17 = this.f288722d.E;
        if (i17 == 1) {
            i3 = 0;
        } else {
            i3 = 2;
        }
        if (i17 != 2) {
            i16 = i3;
        }
        this.T.setDirection(i16);
        TwistView twistView4 = this.T;
        int i18 = this.f288722d.Q;
        if (i18 == 0) {
            f16 = 50.0f;
        } else {
            f16 = i18;
        }
        twistView4.setTargetAngle(f16);
        this.T.setReverseAngle(this.f288722d.R);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(com.tencent.mobileqq.R.id.j0r);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        this.T.setVisibility(8);
        relativeLayout.addView(this.T, layoutParams);
        this.T.s();
    }

    private boolean y(Context context) {
        BaseVideoView baseVideoView = (BaseVideoView) QQVideoViewFactory.createBaseVideoViewFS(context, 120L, null, null);
        this.f288730i = baseVideoView;
        baseVideoView.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        this.f288730i.setLayoutParams(layoutParams);
        this.f288730i.setTag("video");
        QLog.i("QSplash@SplashADView", 1, "initVideo addView " + this.f288730i);
        this.f288721c0.addView(this.f288730i);
        return true;
    }

    public void G() {
        ValueAnimator valueAnimator;
        SlopeSlideView slopeSlideView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        int i3 = this.f288722d.B;
        if ((i3 == 4 || i3 == 5) && (valueAnimator = this.H) != null) {
            valueAnimator.end();
        }
        int i16 = this.f288722d.B;
        if ((i16 == 6 || i16 == 9) && (slopeSlideView = this.R) != null) {
            slopeSlideView.stopAnimation();
        }
        OlympicShakeView olympicShakeView = this.Q;
        if (olympicShakeView != null) {
            olympicShakeView.setVisibility(8);
            this.Q.stop();
            this.Q.end();
        }
        TwistView twistView = this.T;
        if (twistView != null) {
            twistView.setVisibility(8);
            this.T.s();
        }
    }

    public void I() {
        SlopeSlideView slopeSlideView;
        FlipView flipView;
        TwistView twistView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        QLog.i("QSplash@SplashADView", 1, "onShow " + this.f288722d.B);
        o43.b bVar = this.f288722d;
        int i3 = bVar.B;
        if (i3 == 4 || i3 == 5) {
            ValueAnimator ofArgb = ValueAnimator.ofArgb(SplashADUtil.r(bVar.f422017p), SplashADUtil.r(this.f288722d.f422018q));
            this.H = ofArgb;
            ofArgb.setDuration(1200L);
            this.H.setStartDelay(660L);
            this.H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.splashad.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SplashADView.this.B(valueAnimator);
                }
            });
            this.H.start();
        }
        if (this.f288722d.B == 4) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -ViewUtils.dpToPx(24.0f));
            this.M = translateAnimation;
            translateAnimation.setRepeatMode(2);
            this.M.setRepeatCount(-1);
            this.M.setDuration(660L);
            this.M.setFillAfter(true);
            this.M.setInterpolator(new AccelerateDecelerateInterpolator());
            this.L.startAnimation(this.M);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
            alphaAnimation.setDuration(660L);
            alphaAnimation.setFillAfter(true);
            this.I.startAnimation(alphaAnimation);
            this.J.setVisibility(4);
            this.J.startAnimation(m());
        }
        int i16 = this.f288722d.B;
        if ((i16 == 6 || i16 == 9) && (slopeSlideView = this.R) != null) {
            slopeSlideView.A();
        }
        o43.b bVar2 = this.f288722d;
        if (bVar2.B == 7 && (twistView = this.T) != null && bVar2.f422003b != 2) {
            twistView.setVisibility(0);
            this.T.r();
        }
        if (this.f288722d.B == 8 && (flipView = this.U) != null) {
            flipView.setVisibility(0);
            this.U.C();
        }
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QFSPagAnimView qFSPagAnimView = this.S;
        if (qFSPagAnimView != null) {
            qFSPagAnimView.setStaticImageMode(true);
            QLog.i("QSplash@SplashADView", 1, "pausePag");
        }
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        BaseVideoView baseVideoView = this.f288730i;
        if (baseVideoView != null) {
            baseVideoView.pause();
            QLog.i("QSplash@SplashADView", 1, "pauseVideo");
        }
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QFSPagAnimView qFSPagAnimView = this.S;
        if (qFSPagAnimView != null && !qFSPagAnimView.z()) {
            this.S.setStaticImageMode(false);
            this.S.setRepeatTimes(1);
            this.S.setPagAnimListener(this.f288728g0);
            this.S.M(this.f288722d.f422008g);
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        BaseVideoView baseVideoView = this.f288730i;
        if (baseVideoView != null && !baseVideoView.isPlaying()) {
            String str = this.f288722d.f422008g;
            QLog.i("QSplash@SplashADView", 1, "videopath =" + this.f288722d.f422008g);
            this.f288720b0 = 1;
            QLog.i("QSplash@SplashADView", 1, "openMediaPlayerByUrl ");
            VideoPlayParam videoPlayParam = new VideoPlayParam();
            videoPlayParam.mVideoPath = str;
            videoPlayParam.mIsMute = true;
            videoPlayParam.mSceneId = 120;
            videoPlayParam.mCallback = this.f288727f0;
            videoPlayParam.mIsLocal = true;
            this.f288730i.setVideoParam(videoPlayParam);
            this.f288730i.play();
        }
    }

    public synchronized void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        if (this.f288719a0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QSplash@SplashADView", 2, "release splash res");
        }
        this.f288719a0 = true;
        f288718h0 = null;
        this.f288720b0 = 0;
        int i3 = this.f288722d.f422003b;
        if (i3 != 2) {
            if (i3 == 3 && this.S != null) {
                J();
                this.S = null;
            }
        } else {
            BaseVideoView baseVideoView = this.f288730i;
            if (baseVideoView != null) {
                baseVideoView.pause();
                this.f288730i.releasePlayer(false);
                this.f288730i = null;
                if (QLog.isColorLevel()) {
                    QLog.i("QSplash@SplashADView", 2, "release splash resvideo");
                }
            }
        }
        if (this.Q != null) {
            this.Q = null;
        }
        if (this.T != null) {
            this.T = null;
        }
    }

    public void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        SplashGestureTrackView splashGestureTrackView = this.K;
        if (splashGestureTrackView != null) {
            splashGestureTrackView.setVisibility(0);
        }
        SlopeSlideView slopeSlideView = this.R;
        if (slopeSlideView != null) {
            slopeSlideView.setVisibility(0);
        }
        OlympicShakeView olympicShakeView = this.Q;
        if (olympicShakeView != null) {
            olympicShakeView.setShakeVibility(0);
        }
        TwistView twistView = this.T;
        if (twistView != null) {
            twistView.setVisibility(0);
            this.T.r();
        }
        FlipView flipView = this.U;
        if (flipView != null) {
            flipView.setVisibility(0);
            this.U.C();
        }
    }

    public void T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        try {
            OlympicShakeView olympicShakeView = this.Q;
            if (olympicShakeView != null) {
                olympicShakeView.start();
            }
        } catch (Throwable th5) {
            QLog.e("QSplash@SplashADView", 1, th5, new Object[0]);
        }
    }

    public void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (this.f288730i != null) {
            QLog.i("QSplash@SplashADView", 1, "startVideo");
            this.f288730i.play();
            this.f288720b0 = 2;
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        SplashGestureTrackView splashGestureTrackView = this.K;
        if (splashGestureTrackView != null) {
            splashGestureTrackView.setVisibility(4);
        }
        SlopeSlideView slopeSlideView = this.R;
        if (slopeSlideView != null) {
            slopeSlideView.setVisibility(4);
        }
        OlympicShakeView olympicShakeView = this.Q;
        if (olympicShakeView != null) {
            olympicShakeView.setShakeVibility(4);
        }
        FlipView flipView = this.U;
        if (flipView != null) {
            flipView.setVisibility(4);
        }
        TwistView twistView = this.T;
        if (twistView != null) {
            twistView.setVisibility(4);
        }
    }

    public void setFlipCardInteractListener(com.tencent.gdtad.basics.flip.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) cVar);
            return;
        }
        FlipView flipView = this.U;
        if (flipView != null) {
            flipView.setInteractiveListener(cVar);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) onClickListener);
            return;
        }
        TextView textView = this.f288731m;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
        this.f288726f.setOnClickListener(onClickListener);
        RelativeLayout relativeLayout = this.N;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(onClickListener);
        }
        View view = this.C;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnCompletionListener(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) fVar);
        } else {
            this.f288723d0 = fVar;
        }
    }

    public void setOnErrorListener(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) gVar);
        } else {
            this.f288725e0 = gVar;
        }
    }

    public void setOnGestureTrackListener(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) nVar);
            return;
        }
        SplashGestureTrackView splashGestureTrackView = this.K;
        if (splashGestureTrackView != null) {
            splashGestureTrackView.setTrackListener(nVar);
        }
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) onShakeListener);
            return;
        }
        OlympicShakeView olympicShakeView = this.Q;
        if (olympicShakeView != null) {
            olympicShakeView.setOnShakeListener(onShakeListener);
        }
    }

    public void setOnSlopeSlideInteractListener(SlopeSlideView.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cVar);
            return;
        }
        SlopeSlideView slopeSlideView = this.R;
        if (slopeSlideView != null) {
            slopeSlideView.setOnSlopeSlideInteractListener(cVar);
        }
    }

    public void setPresenter(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) eVar);
        } else {
            this.f288724e = eVar;
        }
    }

    public void setTwistInteractListener(TwistView.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
            return;
        }
        TwistView twistView = this.T;
        if (twistView != null) {
            twistView.setTwistInteractListener(bVar);
        }
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        o43.b bVar = this.f288722d;
        if (bVar != null && "3".equals(bVar.f422001a)) {
            return true;
        }
        return false;
    }

    public SplashADView(o43.b bVar, Context context, AttributeSet attributeSet) {
        this(bVar, context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, bVar, context, attributeSet);
    }

    public SplashADView(o43.b bVar, Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, bVar, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.V = false;
        this.W = false;
        this.f288719a0 = false;
        this.f288720b0 = 0;
        this.f288727f0 = new c();
        this.f288728g0 = new d();
        this.f288722d = bVar;
        this.V = p(context);
        this.W = true;
        QLog.i("QSplash@SplashADView", 1, "@SplashADView start");
    }
}
