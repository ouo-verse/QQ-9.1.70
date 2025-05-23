package com.qzone.homepage.ui.woo;

import a7.d;
import android.animation.Animator;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.util.ar;
import com.qzone.util.c;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncRichTextView;
import com.qzone.widget.aa;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.widget.f;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ScaleShadowMainBtnDirector extends aa {
    private static final int J = ar.d(5.0f);
    private static final int K = ar.d(2.0f);
    private static final int L = ar.d(8.0f);
    private static boolean M = false;
    private static int N;
    private static int P;
    private static int Q;
    private static int R;
    private static int S;
    private final AsyncRichTextView C;
    private long D;
    private AlphaAnimation E;
    private AlphaAnimation F;
    private boolean G;
    private d H;
    private final Handler I;

    /* renamed from: d, reason: collision with root package name */
    private final LottieAnimationView f47788d;

    /* renamed from: e, reason: collision with root package name */
    private final AsyncImageView f47789e;

    /* renamed from: f, reason: collision with root package name */
    private final ImageView f47790f;

    /* renamed from: h, reason: collision with root package name */
    private int f47791h;

    /* renamed from: i, reason: collision with root package name */
    private int f47792i;

    /* renamed from: m, reason: collision with root package name */
    private final RelativeLayout f47793m;

    public ScaleShadowMainBtnDirector(View view) {
        super(view);
        this.f47791h = 0;
        this.f47792i = 0;
        this.D = 0L;
        this.G = false;
        this.I = new Handler(Looper.getMainLooper());
        h(getResources());
        this.f47788d = (LottieAnimationView) view.findViewById(R.id.f166910j30);
        AsyncImageView asyncImageView = (AsyncImageView) view.findViewById(R.id.j2z);
        this.f47789e = asyncImageView;
        ImageView imageView = (ImageView) view.findViewById(R.id.j2x);
        this.f47790f = imageView;
        this.f47793m = (RelativeLayout) view.findViewById(R.id.m9t);
        AsyncRichTextView asyncRichTextView = (AsyncRichTextView) view.findViewById(R.id.m9s);
        this.C = asyncRichTextView;
        asyncRichTextView.setTextSize(ar.s(26.0f));
        asyncImageView.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20190316181203_A6rnX1y13D.png");
        k(imageView);
        imageView.setContentDescription("\u8e29\u7a7a\u95f4");
        j();
    }

    private void e() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.E = alphaAnimation;
        alphaAnimation.setDuration(100L);
        this.E.setFillAfter(true);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.F = alphaAnimation2;
        alphaAnimation2.setDuration(130L);
        this.F.setFillAfter(true);
    }

    private static void h(Resources resources) {
        if (M) {
            return;
        }
        N = resources.getDimensionPixelSize(R.dimen.ax8);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ax4);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ax7);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.ax6);
        int i3 = N;
        Q = (i3 - dimensionPixelSize2) - dimensionPixelSize2;
        R = (i3 - dimensionPixelOffset) - dimensionPixelOffset;
        int i16 = dimensionPixelSize + J;
        S = i16;
        P = (i3 - i16) - i16;
        M = true;
    }

    private boolean i() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.C.setText(String.valueOf(this.D));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.E == null || this.F == null) {
            e();
        }
        if (this.f47791h == 2) {
            if (this.f47792i == 0) {
                this.f47793m.startAnimation(this.F);
            } else {
                this.f47793m.startAnimation(this.E);
            }
        }
    }

    public int f() {
        return this.f47791h;
    }

    public long g() {
        return this.D;
    }

    public void j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_step_on_zone_guide_animation_20191011.zip");
            jSONObject.put(ShortVideoConstants.IS_AUTO_PLAY, 0);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        d dVar = new d("lottie view", this.f47788d);
        this.H = dVar;
        dVar.r(jSONObject);
        this.f47788d.setRepeatCount(2);
        this.f47788d.addAnimatorListener(new a());
        if (this.f47788d.isAnimating()) {
            this.f47788d.cancelAnimation();
        }
        j.f("MainBtnDirector", "guide anim load complete");
    }

    public void l(float f16, int i3) {
        float f17 = P * f16;
        float f18 = (N - f17) / 2.0f;
        int i16 = (int) (f18 - (J * f16));
        int i17 = (int) (f18 - (K * f16));
        int i18 = (int) (f18 - (L * f16));
        int i19 = (int) (((f17 - (Q * f16)) / 2.0f) + f18);
        int i26 = (int) (f18 + ((f17 - (R * f16)) / 2.0f));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f47790f.getLayoutParams();
        marginLayoutParams.setMargins(i16, i17, i16, i18);
        this.f47790f.setLayoutParams(marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f47788d.getLayoutParams();
        marginLayoutParams2.setMargins(i19, i19, i19, i19);
        this.f47788d.setLayoutParams(marginLayoutParams2);
        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.f47789e.getLayoutParams();
        marginLayoutParams3.setMargins(i26, i26, i26, i26);
        this.f47789e.setLayoutParams(marginLayoutParams3);
        c.a(this.f47788d, i3);
        c.a(this.f47789e, 255 - i3);
    }

    public void m(int i3) {
        this.f47792i = this.f47791h;
        this.f47791h = i3;
        if (i()) {
            r();
        } else {
            this.I.post(new Runnable() { // from class: com.qzone.homepage.ui.woo.ScaleShadowMainBtnDirector.1
                @Override // java.lang.Runnable
                public void run() {
                    ScaleShadowMainBtnDirector.this.r();
                }
            });
        }
    }

    public void n(long j3) {
        long j16 = this.D;
        if (j3 < j16) {
            j3 = j16;
        }
        this.D = j3;
        if (i()) {
            q();
        } else {
            this.I.post(new Runnable() { // from class: com.qzone.homepage.ui.woo.ScaleShadowMainBtnDirector.2
                @Override // java.lang.Runnable
                public void run() {
                    ScaleShadowMainBtnDirector.this.q();
                }
            });
        }
    }

    public void o() {
        if (f() != 0 || this.G) {
            return;
        }
        this.f47788d.playAnimation();
        j.f("MainBtnDirector", "guide anim start");
    }

    public void p() {
        this.G = true;
        if (this.f47788d.isAnimating()) {
            this.f47788d.cancelAnimation();
            j.f("MainBtnDirector", "guide anim break");
        }
    }

    private void k(View view) {
        if (view != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.requestFocusFromTouch();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends f {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AsyncImageView asyncImageView = new AsyncImageView(ScaleShadowMainBtnDirector.this.getContext());
            asyncImageView.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20191011165146_nU6KTXSBjg.png");
            if (asyncImageView.getDrawable() != null) {
                ScaleShadowMainBtnDirector.this.f47788d.setImageDrawable(asyncImageView.getDrawable());
                j.f("MainBtnDirector", "drawable generate success");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
