package com.tencent.mobileqq.medalwall;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.nearby.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MedalGuideView extends FrameLayout implements View.OnClickListener, Handler.Callback, Animation.AnimationListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i0, reason: collision with root package name */
    private static final int[] f245689i0;

    /* renamed from: j0, reason: collision with root package name */
    private static final int[] f245690j0;

    /* renamed from: k0, reason: collision with root package name */
    private static final int[] f245691k0;

    /* renamed from: l0, reason: collision with root package name */
    private static final int[] f245692l0;

    /* renamed from: m0, reason: collision with root package name */
    private static final int[] f245693m0;

    /* renamed from: n0, reason: collision with root package name */
    private static final int[] f245694n0;

    /* renamed from: o0, reason: collision with root package name */
    private static final int[] f245695o0;

    /* renamed from: p0, reason: collision with root package name */
    private static WeakReference<MedalGuideView> f245696p0;
    Button C;
    ImageButton D;
    Drawable E;
    ColorDrawable F;
    boolean G;
    boolean H;
    ArgbEvaluator I;
    int J;
    boolean K;
    com.tencent.mobileqq.medalwall.b L;
    com.tencent.mobileqq.medalwall.b M;
    com.tencent.mobileqq.medalwall.b N;
    boolean P;
    int Q;
    int R;
    int S;
    boolean T;
    String U;
    String V;
    String W;

    /* renamed from: a0, reason: collision with root package name */
    com.tencent.mobileqq.medalwall.a f245697a0;

    /* renamed from: b0, reason: collision with root package name */
    h f245698b0;

    /* renamed from: c0, reason: collision with root package name */
    WeakReference<View> f245699c0;

    /* renamed from: d, reason: collision with root package name */
    WeakReferenceHandler f245700d;

    /* renamed from: d0, reason: collision with root package name */
    WeakReference<QBaseActivity> f245701d0;

    /* renamed from: e, reason: collision with root package name */
    ViewGroup f245702e;

    /* renamed from: e0, reason: collision with root package name */
    MedalWallMng.a f245703e0;

    /* renamed from: f, reason: collision with root package name */
    TextView f245704f;

    /* renamed from: f0, reason: collision with root package name */
    int f245705f0;

    /* renamed from: g0, reason: collision with root package name */
    com.tencent.mobileqq.medalwall.c f245706g0;

    /* renamed from: h, reason: collision with root package name */
    URLImageView f245707h;

    /* renamed from: h0, reason: collision with root package name */
    List<mqq.util.WeakReference<ValueAnimator>> f245708h0;

    /* renamed from: i, reason: collision with root package name */
    TextView f245709i;

    /* renamed from: m, reason: collision with root package name */
    Button f245710m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MedalGuideView.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MedalGuideView.this.c();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MedalGuideView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            MedalGuideView.this.f245707h.setAlpha(((Float) valueAnimator.getAnimatedValue(com.tencent.luggage.wxa.c8.c.f123400v)).floatValue());
            MedalGuideView.this.f245707h.setTranslationY(((Float) valueAnimator.getAnimatedValue(CanvasView.ACTION_TRANSLATE)).floatValue());
            float animatedFraction = valueAnimator.getAnimatedFraction();
            MedalGuideView medalGuideView = MedalGuideView.this;
            if (!medalGuideView.K && animatedFraction >= 0.8857143f) {
                medalGuideView.K = true;
                medalGuideView.f245700d.sendEmptyMessage(4);
                if (QLog.isDevelopLevel()) {
                    QLog.i("MedalWallMng", 4, "send MSG_START_3D_ROTATE");
                }
            }
            if (animatedFraction >= 1.0f) {
                valueAnimator.removeAllUpdateListeners();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MedalGuideView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue(com.tencent.luggage.wxa.c8.c.f123400v)).floatValue();
            MedalGuideView.this.i(floatValue);
            MedalGuideView.this.f245702e.setBackgroundColor(((Integer) MedalGuideView.this.I.evaluate(floatValue, 0, Integer.valueOf(MedalGuideView.this.J))).intValue());
            if (valueAnimator.getAnimatedFraction() >= 1.0f) {
                valueAnimator.removeAllUpdateListeners();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MedalGuideView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            MedalGuideView.this.i(floatValue);
            com.tencent.mobileqq.medalwall.a aVar = MedalGuideView.this.f245697a0;
            if (aVar != null) {
                aVar.j(floatValue);
                if (floatValue <= 0.05f) {
                    MedalGuideView.this.f245697a0.l();
                }
            }
            if (valueAnimator.getAnimatedFraction() >= 1.0f) {
                valueAnimator.removeAllUpdateListeners();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class e implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MedalGuideView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            MedalGuideView medalGuideView = MedalGuideView.this;
            MedalGuideView.this.f245702e.setBackgroundColor(((Integer) medalGuideView.I.evaluate(floatValue, Integer.valueOf(medalGuideView.J), 0)).intValue());
            if (valueAnimator.getAnimatedFraction() >= 1.0f) {
                valueAnimator.removeAllUpdateListeners();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class f implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MedalGuideView.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            MedalGuideView.this.f245707h.setAlpha(((Float) valueAnimator.getAnimatedValue(com.tencent.luggage.wxa.c8.c.f123400v)).floatValue());
            float floatValue = ((Float) valueAnimator.getAnimatedValue("scale")).floatValue();
            MedalGuideView.this.f245707h.setScaleX(floatValue);
            MedalGuideView.this.f245707h.setScaleY(floatValue);
            MedalGuideView.this.f245707h.setTranslationX(((Float) valueAnimator.getAnimatedValue("translationX")).floatValue());
            MedalGuideView.this.f245707h.setTranslationY(((Float) valueAnimator.getAnimatedValue("translationY")).floatValue());
            float animatedFraction = valueAnimator.getAnimatedFraction();
            MedalGuideView medalGuideView = MedalGuideView.this;
            if (!medalGuideView.G && animatedFraction >= 1.0f) {
                medalGuideView.G = true;
                medalGuideView.f245700d.sendEmptyMessage(3);
            }
            if (animatedFraction >= 1.0f) {
                valueAnimator.removeAllUpdateListeners();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class g implements PopupWindow.OnDismissListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MedalGuideView.this);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onDismiss  endOfAnim: %s", Boolean.valueOf(MedalGuideView.this.P)));
            }
            MedalGuideView medalGuideView = MedalGuideView.this;
            medalGuideView.P = true;
            medalGuideView.D.performClick();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class h extends PopupWindow {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private PopupWindow.OnDismissListener f245720a;

        public h(View view, int i3, int i16, boolean z16) {
            super(view, i3, i16, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
            }
        }

        public void a(PopupWindow.OnDismissListener onDismissListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) onDismissListener);
            } else {
                this.f245720a = onDismissListener;
            }
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.dismiss();
            }
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            PopupWindow.OnDismissListener onDismissListener = this.f245720a;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            } else {
                super.dismiss();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73025);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f245689i0 = new int[]{R.drawable.exs, R.drawable.exu, R.drawable.ext};
        f245690j0 = new int[]{R.drawable.exm, R.drawable.exn, R.drawable.exo};
        f245691k0 = new int[]{R.color.a1e, R.color.a1i, R.color.a1g};
        f245692l0 = new int[]{R.color.a1k, R.color.a1m, R.color.a1l};
        f245693m0 = new int[]{R.drawable.adu, R.drawable.adw, R.drawable.adv};
        f245694n0 = new int[]{R.drawable.adx, R.drawable.adz, R.drawable.ady};
        f245695o0 = new int[]{R.drawable.exp, R.drawable.exq, R.drawable.exr};
        f245696p0 = null;
    }

    public MedalGuideView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, "close");
        }
        this.G = true;
        this.f245700d.removeMessages(3);
        com.tencent.mobileqq.medalwall.a aVar = this.f245697a0;
        if (aVar != null) {
            aVar.b();
            this.f245697a0 = null;
        }
        WeakReference<QBaseActivity> weakReference = this.f245701d0;
        if (weakReference != null) {
            weakReference.clear();
            this.f245701d0 = null;
        }
        WeakReference<View> weakReference2 = this.f245699c0;
        if (weakReference2 != null) {
            weakReference2.clear();
            this.f245699c0 = null;
        }
        this.f245703e0 = null;
        h hVar = this.f245698b0;
        if (hVar != null) {
            hVar.b();
            this.f245698b0 = null;
        }
        for (mqq.util.WeakReference<ValueAnimator> weakReference3 : this.f245708h0) {
            ValueAnimator valueAnimator = weakReference3.get();
            if (valueAnimator != null) {
                valueAnimator.cancel();
                valueAnimator.removeAllUpdateListeners();
                weakReference3.clear();
            }
        }
    }

    public static void d() {
        WeakReference<MedalGuideView> weakReference = f245696p0;
        if (weakReference != null) {
            MedalGuideView medalGuideView = weakReference.get();
            if (medalGuideView != null) {
                medalGuideView.c();
            }
            f245696p0.clear();
            f245696p0 = null;
            if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCleanMedalGuide guide: %s", medalGuideView));
            }
        }
    }

    private void f() {
        this.f245700d = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.f245708h0 = new ArrayList();
        View.inflate(getContext(), R.layout.awj, this);
        this.f245702e = (ViewGroup) findViewById(R.id.content);
        this.f245704f = (TextView) findViewById(R.id.title);
        this.f245707h = (URLImageView) findViewById(R.id.eo8);
        this.f245709i = (TextView) findViewById(R.id.eo9);
        Button button = (Button) findViewById(R.id.iqr);
        this.f245710m = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.bxg);
        this.C = button2;
        button2.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) findViewById(R.id.close);
        this.D = imageButton;
        imageButton.setOnClickListener(this);
        this.F = new ColorDrawable(0);
        try {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            DisplayMetrics displayMetrics2 = FontSettingManager.systemMetrics;
            float f16 = displayMetrics.density;
            float f17 = displayMetrics2.density;
            if (f16 != f17) {
                float f18 = f17 / f16;
                if (f18 > 1.0f) {
                    f18 = 1.0f;
                }
                float f19 = f17 * f18;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f245707h.getLayoutParams();
                int i3 = (int) (290.0f * f19);
                layoutParams.width = i3;
                layoutParams.height = i3;
                layoutParams.topMargin = (int) (30.0f * f19);
                this.f245707h.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f245709i.getLayoutParams();
                layoutParams2.topMargin = (int) (20.0f * f19);
                this.f245709i.setLayoutParams(layoutParams2);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f163922cf);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams3.topMargin = (int) (32.0f * f19);
                linearLayout.setLayoutParams(layoutParams3);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.D.getLayoutParams();
                layoutParams4.topMargin = (int) (f19 * 40.0f);
                this.D.setLayoutParams(layoutParams4);
            }
            if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "dm[%f, %d, %f], system[%f, %d, %f]", Float.valueOf(displayMetrics.density), Integer.valueOf(displayMetrics.densityDpi), Float.valueOf(displayMetrics.scaledDensity), Float.valueOf(displayMetrics2.density), Integer.valueOf(displayMetrics2.densityDpi), Float.valueOf(displayMetrics2.scaledDensity)));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.I = new ArgbEvaluator();
        this.J = getResources().getColor(R.color.a1d);
        this.f245707h.setAlpha(0.0f);
        this.f245702e.setBackgroundColor(0);
        i(0.0f);
    }

    private void g(View view) {
        long j3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        long j16;
        int i3;
        int i16;
        MedalInfo medalInfo;
        String str6;
        MedalInfo medalInfo2;
        long j17;
        long j18;
        String str7;
        long j19;
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (this.f245706g0 == null) {
            this.f245706g0 = new com.tencent.mobileqq.medalwall.c(view.getContext(), qQAppInterface);
            String j26 = ((MedalWallMng) qQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).j();
            String str8 = com.tencent.mobileqq.medalwall.c.f245767k;
            int f16 = BaseAIOUtils.f(48.0f, getResources());
            MedalWallMng.a aVar = this.f245703e0;
            if (aVar != null && (medalInfo2 = aVar.f245730a) != null) {
                int i17 = medalInfo2.iLevel;
                if (i17 != 1) {
                    if (i17 != 2) {
                        if (i17 != 3) {
                            j19 = medalInfo2.lObtainTimeLevel1;
                            j3 = medalInfo2.lSeqLevel1;
                            str7 = "";
                            str3 = String.format("%s %s", this.W, str7);
                            String str9 = this.f245703e0.f245733d;
                            str4 = k.b(qQAppInterface.getCurrentAccountUin());
                            MedalInfo medalInfo3 = this.f245703e0.f245730a;
                            i16 = medalInfo3.iId;
                            i3 = medalInfo3.iLevel;
                            str5 = qQAppInterface.getCurrentNickname();
                            str2 = com.tencent.mobileqq.medalwall.c.g(new String[]{i16 + "", i3 + "", str4, str5});
                            str = str9;
                            j16 = j19;
                        } else {
                            j17 = medalInfo2.lObtainTimeLevel3;
                            j18 = medalInfo2.lSeqLevel3;
                            str7 = "III";
                        }
                    } else {
                        j17 = medalInfo2.lObtainTimeLevel2;
                        j18 = medalInfo2.lSeqLevel2;
                        str7 = "II";
                    }
                } else {
                    j17 = medalInfo2.lObtainTimeLevel1;
                    j18 = medalInfo2.lSeqLevel1;
                    str7 = "I";
                }
                j19 = j17;
                j3 = j18;
                str3 = String.format("%s %s", this.W, str7);
                String str92 = this.f245703e0.f245733d;
                str4 = k.b(qQAppInterface.getCurrentAccountUin());
                MedalInfo medalInfo32 = this.f245703e0.f245730a;
                i16 = medalInfo32.iId;
                i3 = medalInfo32.iLevel;
                str5 = qQAppInterface.getCurrentNickname();
                str2 = com.tencent.mobileqq.medalwall.c.g(new String[]{i16 + "", i3 + "", str4, str5});
                str = str92;
                j16 = j19;
            } else {
                j3 = 0;
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
                j16 = 0;
                i3 = 0;
                i16 = 0;
            }
            StringBuilder sb5 = new StringBuilder(j26);
            sb5.append("&uincode=");
            sb5.append(str4);
            sb5.append("&id=");
            sb5.append(i16);
            sb5.append("&level=");
            sb5.append(i3);
            sb5.append("&nick=");
            sb5.append(URLEncoder.encode(str5));
            sb5.append("&en=");
            sb5.append(str2);
            sb5.append("&fromId=");
            sb5.append(1);
            MedalWallMng.a aVar2 = this.f245703e0;
            if (aVar2 != null && (medalInfo = aVar2.f245730a) != null && medalInfo.iId == 0) {
                try {
                    str6 = com.tencent.mobileqq.medalwall.c.k(Long.valueOf(j16 * 1000)).substring(0, 4);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ShareHelper", 2, e16.getMessage(), e16);
                    }
                    str6 = "0";
                }
                sb5.append("&year=");
                sb5.append(str6);
                sb5.append("&seq=");
                sb5.append(j3);
            } else {
                sb5.append("&time=");
                sb5.append(j16);
            }
            if (QLog.isColorLevel()) {
                QLog.i("ShareHelper", 4, "shareUrl:" + sb5.toString());
            }
            this.f245706g0.l(str3, str8, sb5.toString(), str, "QQ\u52cb\u7ae0\u5899", com.tencent.mobileqq.medalwall.c.f(this.f245707h.getDrawable(), f16, f16));
        }
        this.f245706g0.q(new a());
        ThreadManagerV2.post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.medalwall.MedalGuideView.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f245712d;

            {
                this.f245712d = qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MedalGuideView.this, (Object) qQAppInterface);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ReportController.o(this.f245712d, "dc00898", "", "", "0X80088E9", "0X80088E9", MedalGuideView.this.f245705f0, 0, "", "", "", "");
                }
            }
        }, 5, null, false);
    }

    public static void h(MedalWallMng.a aVar, QBaseActivity qBaseActivity, View view, int i3) {
        if (view == null) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "showMedalGuide from: %d, view: %s, activity: %s, medal: %s", Integer.valueOf(i3), view, qBaseActivity, aVar));
        }
        d();
        MedalGuideView medalGuideView = new MedalGuideView(qBaseActivity);
        h hVar = new h(medalGuideView, -1, -1, true);
        medalGuideView.e(aVar, qBaseActivity, view, i3, hVar);
        hVar.setClippingEnabled(false);
        hVar.setOutsideTouchable(true);
        hVar.setBackgroundDrawable(new ColorDrawable(0));
        hVar.showAtLocation(view, 0, 0, 0);
        ThreadManagerV2.post(new Runnable(i3) { // from class: com.tencent.mobileqq.medalwall.MedalGuideView.10
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f245711d;

            {
                this.f245711d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (qQAppInterface == null) {
                    return;
                }
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X80088EA", "0X80088EA", this.f245711d, 0, "", "", "", "");
            }
        }, 5, null, false);
        f245696p0 = new WeakReference<>(medalGuideView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(float f16) {
        this.f245704f.setAlpha(f16);
        this.f245709i.setAlpha(f16);
        this.f245710m.setAlpha(f16);
        this.C.setAlpha(f16);
        this.D.setAlpha(f16);
    }

    private void j() {
        URLDrawable uRLDrawable;
        Resources resources = getResources();
        this.f245704f.setText(R.string.flk);
        TextView textView = this.f245704f;
        int i3 = f245689i0[this.S];
        textView.setCompoundDrawablesWithIntrinsicBounds(i3, 0, i3, 0);
        TextView textView2 = this.f245704f;
        int[] iArr = f245691k0;
        textView2.setTextColor(resources.getColor(iArr[this.S]));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ago);
        obtain.mRequestWidth = dimensionPixelSize;
        obtain.mRequestHeight = dimensionPixelSize;
        Drawable drawable = this.E;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        if (FileUtils.fileExists(this.V)) {
            uRLDrawable = URLDrawable.getDrawable(new File(this.V), obtain);
        } else if (!TextUtils.isEmpty(this.U)) {
            uRLDrawable = URLDrawable.getDrawable(this.U, obtain);
        } else {
            uRLDrawable = null;
        }
        this.f245707h.setImageDrawable(uRLDrawable);
        this.f245709i.setText(this.W);
        if (this.T) {
            this.f245709i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            Drawable drawable2 = getResources().getDrawable(f245690j0[this.S]);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.F.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.f245709i.setCompoundDrawables(this.F, null, drawable2, null);
        }
        this.f245709i.setTextColor(resources.getColor(iArr[this.S]));
        Button button = this.f245710m;
        int[] iArr2 = f245693m0;
        button.setBackgroundResource(iArr2[this.S]);
        Button button2 = this.f245710m;
        int[] iArr3 = f245692l0;
        button2.setTextColor(resources.getColorStateList(iArr3[this.S]));
        this.C.setBackgroundResource(iArr2[this.S]);
        this.C.setTextColor(resources.getColorStateList(iArr3[this.S]));
        this.D.setImageResource(f245694n0[this.S]);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas);
            return;
        }
        if (this.H) {
            this.H = false;
            this.P = false;
            this.f245700d.sendEmptyMessage(1);
            this.f245700d.sendEmptyMessageDelayed(5, 1600L);
        }
        com.tencent.mobileqq.medalwall.a aVar = this.f245697a0;
        if (aVar != null) {
            aVar.c(canvas, 1);
        }
        super.dispatchDraw(canvas);
        com.tencent.mobileqq.medalwall.a aVar2 = this.f245697a0;
        if (aVar2 != null) {
            aVar2.c(canvas, 2);
        }
    }

    public void e(MedalWallMng.a aVar, QBaseActivity qBaseActivity, View view, int i3, h hVar) {
        MedalInfo medalInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, aVar, qBaseActivity, view, Integer.valueOf(i3), hVar);
            return;
        }
        this.f245699c0 = new WeakReference<>(view);
        this.f245701d0 = new WeakReference<>(qBaseActivity);
        this.f245705f0 = i3;
        this.f245703e0 = aVar;
        this.f245698b0 = hVar;
        this.f245706g0 = null;
        if (hVar != null) {
            hVar.a(new g());
        }
        if (aVar != null && (medalInfo = aVar.f245730a) != null) {
            this.Q = medalInfo.iId;
            int i16 = medalInfo.iLevel;
            if (i16 >= 1 && i16 <= 3) {
                this.S = i16 - 1;
                this.T = false;
            } else {
                this.S = 2;
                this.T = true;
            }
            this.R = i16;
            this.W = medalInfo.strName;
            this.V = aVar.f245732c;
            this.U = aVar.f245731b;
        } else {
            this.Q = 0;
            this.S = 2;
            this.W = "";
            this.V = null;
            this.U = null;
            this.T = false;
            this.R = 1;
        }
        this.E = new ColorDrawable(0);
        j();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        float f16;
        float f17;
        float f18;
        float f19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) message)).booleanValue();
        }
        int i16 = message.what;
        if (i16 == 1) {
            if (QLog.isDevelopLevel()) {
                i3 = 4;
                QLog.i("MedalWallMng", 4, "MSG_START_ENTER_ANIM");
            } else {
                i3 = 4;
            }
            this.K = false;
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe ofFloat2 = Keyframe.ofFloat(0.057142857f, 0.0f);
            Keyframe ofFloat3 = Keyframe.ofFloat(0.2f, 1.0f);
            Keyframe ofFloat4 = Keyframe.ofFloat(1.0f, 1.0f);
            Keyframe[] keyframeArr = new Keyframe[i3];
            keyframeArr[0] = ofFloat;
            keyframeArr[1] = ofFloat2;
            keyframeArr[2] = ofFloat3;
            keyframeArr[3] = ofFloat4;
            PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(com.tencent.luggage.wxa.c8.c.f123400v, keyframeArr);
            float y16 = this.f245707h.getY() + this.f245707h.getHeight();
            float y17 = this.f245709i.getY() + this.f245709i.getHeight();
            float f26 = -this.f245707h.getY();
            float f27 = y17 - y16;
            if (f27 < 0.0f) {
                f27 = this.f245707h.getHeight() * 0.3f;
            }
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(ofKeyframe, PropertyValuesHolder.ofKeyframe(CanvasView.ACTION_TRANSLATE, Keyframe.ofFloat(0.0f, f26), Keyframe.ofFloat(0.7714286f, f27), Keyframe.ofFloat(1.0f, 0.0f)));
            this.f245708h0.add(new mqq.util.WeakReference<>(ofPropertyValuesHolder));
            ofPropertyValuesHolder.addUpdateListener(new b());
            ofPropertyValuesHolder.setDuration(700L);
            ofPropertyValuesHolder.start();
            ValueAnimator ofPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe(com.tencent.luggage.wxa.c8.c.f123400v, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.08571429f, 0.0f), Keyframe.ofFloat(1.0f, 1.0f)));
            this.f245708h0.add(new mqq.util.WeakReference<>(ofPropertyValuesHolder2));
            ofPropertyValuesHolder2.addUpdateListener(new c());
            ofPropertyValuesHolder2.setDuration(700L);
            ofPropertyValuesHolder2.start();
        } else {
            if (i16 != 2) {
                if (i16 == 3) {
                    c();
                } else if (i16 == 4) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("MedalWallMng", 4, "MSG_START_3D_ROTATE");
                    }
                    float width = this.f245707h.getWidth() / 2;
                    float height = this.f245707h.getHeight() / 2;
                    com.tencent.mobileqq.medalwall.b bVar = new com.tencent.mobileqq.medalwall.b(0.0f, -15.599999f, width, height, 0.0f, true);
                    this.L = bVar;
                    bVar.setDuration(260L);
                    this.L.setFillAfter(true);
                    this.L.setAnimationListener(this);
                    com.tencent.mobileqq.medalwall.b bVar2 = new com.tencent.mobileqq.medalwall.b(-15.599999f, 9.75f, width, height, 0.0f, false);
                    this.M = bVar2;
                    bVar2.setDuration(260L);
                    this.M.setFillAfter(true);
                    this.M.setAnimationListener(this);
                    com.tencent.mobileqq.medalwall.b bVar3 = new com.tencent.mobileqq.medalwall.b(9.75f, 0.0f, width, height, 0.0f, true);
                    this.N = bVar3;
                    bVar3.setDuration(300L);
                    this.N.setFillAfter(true);
                    this.N.setAnimationListener(this);
                    this.f245707h.startAnimation(this.L);
                    com.tencent.mobileqq.medalwall.a aVar = new com.tencent.mobileqq.medalwall.a(this, 2, 100, f245695o0);
                    this.f245697a0 = aVar;
                    aVar.g(getWidth(), getHeight());
                } else if (i16 == 5) {
                    this.P = true;
                }
                return true;
            }
            ValueAnimator ofPropertyValuesHolder3 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe(com.tencent.luggage.wxa.c8.c.f123400v, Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.26666668f, 0.0f), Keyframe.ofFloat(1.0f, 0.0f)));
            this.f245708h0.add(new mqq.util.WeakReference<>(ofPropertyValuesHolder3));
            ofPropertyValuesHolder3.addUpdateListener(new d());
            long j3 = 600.0f;
            ofPropertyValuesHolder3.setDuration(j3);
            ofPropertyValuesHolder3.start();
            ValueAnimator ofPropertyValuesHolder4 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofKeyframe("bgColor", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.26666668f, 0.0f), Keyframe.ofFloat(0.6666667f, 1.0f), Keyframe.ofFloat(1.0f, 1.0f)));
            this.f245708h0.add(new mqq.util.WeakReference<>(ofPropertyValuesHolder4));
            ofPropertyValuesHolder4.addUpdateListener(new e());
            ofPropertyValuesHolder4.setDuration(j3);
            ofPropertyValuesHolder4.start();
            WeakReference<View> weakReference = this.f245699c0;
            View view = weakReference == null ? null : weakReference.get();
            int max = Math.max(this.f245707h.getWidth(), this.f245707h.getHeight());
            if (view != null) {
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr);
                this.f245707h.getLocationOnScreen(iArr2);
                int min = Math.min(view.getWidth(), view.getHeight());
                f18 = (min == 0 || max == 0) ? 0.2f : min / max;
                int i17 = min / 2;
                iArr[0] = iArr[0] + i17;
                iArr[1] = iArr[1] + i17;
                int i18 = max / 2;
                int i19 = iArr2[0] + i18;
                iArr2[0] = i19;
                int i26 = iArr2[1] + i18;
                iArr2[1] = i26;
                f16 = iArr[0] - i19;
                float f28 = iArr[1] - i26;
                if (QLog.isDevelopLevel()) {
                    int[] iArr3 = new int[2];
                    this.f245707h.getLocationInWindow(iArr3);
                    f19 = f28;
                    QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "icon end anim target[%d, %d], cur[%d, %d], size: %d, curSize: %d curWindowLoc[%d,%d] pivot[%f, %f]", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]), Integer.valueOf(min), Integer.valueOf(max), Integer.valueOf(iArr3[0]), Integer.valueOf(iArr3[1]), Float.valueOf(this.f245707h.getPivotX()), Float.valueOf(this.f245707h.getPivotY())));
                } else {
                    f19 = f28;
                }
                f17 = f19;
            } else {
                float f29 = max / 2.0f;
                f16 = (-this.f245707h.getX()) - f29;
                f17 = (-this.f245707h.getY()) - f29;
                f18 = 0.2f;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "icon end anim [scale: %f, transX: %f, transY: %f]  [%f, %f]", Float.valueOf(f18), Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(this.f245707h.getX()), Float.valueOf(this.f245707h.getY())));
            }
            PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(com.tencent.luggage.wxa.c8.c.f123400v, Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.8666667f, 1.0f), Keyframe.ofFloat(1.0f, 0.0f));
            PropertyValuesHolder ofKeyframe3 = PropertyValuesHolder.ofKeyframe("scale", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.26666668f, 1.0f), Keyframe.ofFloat(0.9f, f18), Keyframe.ofFloat(1.0f, f18));
            Keyframe ofFloat5 = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe ofFloat6 = Keyframe.ofFloat(0.26666668f, 0.0f);
            ofFloat6.setInterpolator(new AccelerateDecelerateInterpolator());
            PropertyValuesHolder ofKeyframe4 = PropertyValuesHolder.ofKeyframe("translationX", ofFloat5, ofFloat6, Keyframe.ofFloat(0.9f, f16), Keyframe.ofFloat(1.0f, f16));
            Keyframe ofFloat7 = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe ofFloat8 = Keyframe.ofFloat(0.26666668f, 0.0f);
            ofFloat8.setInterpolator(new AccelerateDecelerateInterpolator());
            ValueAnimator ofPropertyValuesHolder5 = ValueAnimator.ofPropertyValuesHolder(ofKeyframe2, ofKeyframe3, ofKeyframe4, PropertyValuesHolder.ofKeyframe("translationY", ofFloat7, ofFloat8, Keyframe.ofFloat(0.9f, f17), Keyframe.ofFloat(1.0f, f17)));
            this.f245708h0.add(new mqq.util.WeakReference<>(ofPropertyValuesHolder5));
            ofPropertyValuesHolder5.addUpdateListener(new f());
            ofPropertyValuesHolder5.setDuration(j3);
            ofPropertyValuesHolder5.start();
            this.f245700d.sendEmptyMessageDelayed(3, j3 + 200);
        }
        return true;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) animation);
            return;
        }
        if (animation == this.L) {
            this.f245707h.startAnimation(this.M);
            return;
        }
        if (animation == this.M) {
            this.f245707h.startAnimation(this.N);
        } else if (animation == this.N) {
            this.P = true;
            this.f245700d.removeMessages(5);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) animation);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        QBaseActivity qBaseActivity;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.iqr) {
                g(view);
            } else if (id5 == R.id.bxg) {
                WeakReference<QBaseActivity> weakReference = this.f245701d0;
                if (weakReference == null) {
                    qBaseActivity = null;
                } else {
                    qBaseActivity = weakReference.get();
                }
                if (qBaseActivity != null) {
                    String format = String.format(Locale.getDefault(), "%s&openMedalId=%s&openMedalLevel=%s", ((MedalWallMng) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MEDAL_WALL_MNG)).i(true, qBaseActivity.getAppRuntime().getCurrentAccountUin(), MedalWallMng.M), Integer.valueOf(this.Q), Integer.valueOf(this.R));
                    Intent intent = new Intent(qBaseActivity, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", format);
                    qBaseActivity.startActivity(intent);
                    if (QLog.isColorLevel()) {
                        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "enter medal url: %s", format));
                    }
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.medalwall.MedalGuideView.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MedalGuideView.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            try {
                                ((MedalWallMng) ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.MEDAL_WALL_MNG)).u(1, null);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                    }, 5, null, false);
                }
                c();
            } else if (id5 == R.id.close) {
                if (!this.P) {
                    if (QLog.isColorLevel()) {
                        QLog.i("MedalWallMng", 2, "close when enter animation is not finished yet!");
                    }
                } else if (!this.f245700d.hasMessages(2)) {
                    this.f245700d.sendEmptyMessage(2);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public MedalGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public MedalGuideView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.G = false;
        this.H = true;
        this.I = null;
        this.K = false;
        this.P = false;
        this.f245697a0 = null;
        this.f245698b0 = null;
        this.f245699c0 = null;
        this.f245701d0 = null;
        this.f245703e0 = null;
        f();
    }
}
