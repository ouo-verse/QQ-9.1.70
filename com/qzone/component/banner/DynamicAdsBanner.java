package com.qzone.component.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AsyncImageable;
import com.tencent.mobileqq.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DynamicAdsBanner extends NewStyleOperationAdsBanner {

    /* renamed from: w1, reason: collision with root package name */
    public static final String f46332w1 = "com.qzone.component.banner.DynamicAdsBanner";

    /* renamed from: m1, reason: collision with root package name */
    private AsyncImageView f46333m1;

    /* renamed from: n1, reason: collision with root package name */
    private AsyncImageable.AsyncImageListener f46334n1;

    /* renamed from: o1, reason: collision with root package name */
    private boolean f46335o1;

    /* renamed from: p1, reason: collision with root package name */
    private boolean f46336p1;

    /* renamed from: q1, reason: collision with root package name */
    private TranslateAnimation f46337q1;

    /* renamed from: r1, reason: collision with root package name */
    private AlphaAnimation f46338r1;

    /* renamed from: s1, reason: collision with root package name */
    private AsyncImageView f46339s1;

    /* renamed from: t1, reason: collision with root package name */
    private AsyncImageView f46340t1;

    /* renamed from: u1, reason: collision with root package name */
    private Runnable f46341u1;

    /* renamed from: v1, reason: collision with root package name */
    private Runnable f46342v1;

    public DynamicAdsBanner(Context context) {
        super(context);
        this.f46335o1 = false;
        this.f46336p1 = false;
        this.f46341u1 = new Runnable() { // from class: com.qzone.component.banner.DynamicAdsBanner.5
            @Override // java.lang.Runnable
            public void run() {
                DynamicAdsBanner.this.X();
            }
        };
        this.f46342v1 = new Runnable() { // from class: com.qzone.component.banner.DynamicAdsBanner.6
            @Override // java.lang.Runnable
            public void run() {
                DynamicAdsBanner.this.Y();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (W()) {
            c();
        }
    }

    private int T() {
        if (TextUtils.isEmpty(this.F0) || C()) {
            return 0;
        }
        if (TextUtils.isEmpty(this.G0) || this.W0 != 1040) {
            return this.W0 == 1039 ? 1 : 0;
        }
        return 2;
    }

    private AsyncImageView U() {
        AsyncImageView asyncImageView = this.f46339s1;
        AsyncImageView asyncImageView2 = this.C;
        return asyncImageView == asyncImageView2 ? this.f46333m1 : asyncImageView2;
    }

    private AsyncImageView V() {
        AsyncImageView asyncImageView = this.f46340t1;
        AsyncImageView asyncImageView2 = this.f46333m1;
        return asyncImageView == asyncImageView2 ? this.C : asyncImageView2;
    }

    private boolean W() {
        return this.f46335o1 && this.f46336p1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        AsyncImageView asyncImageView = this.f46339s1;
        if (asyncImageView != null) {
            asyncImageView.clearAnimation();
        }
        AsyncImageView U = U();
        this.f46339s1 = U;
        if (U != null) {
            if (U.getVisibility() != 0) {
                this.f46339s1.setVisibility(0);
            }
            this.f46339s1.clearAnimation();
            this.f46339s1.setAlpha(1.0f);
            AlphaAnimation alphaAnimation = this.f46338r1;
            if (alphaAnimation != null) {
                this.f46339s1.startAnimation(alphaAnimation);
            }
        }
        Handler handler = this.f46401j1;
        if (handler != null) {
            handler.removeCallbacks(this.f46342v1);
            this.f46401j1.postDelayed(this.f46342v1, 100L);
            this.f46401j1.removeCallbacks(this.f46341u1);
            this.f46401j1.postDelayed(this.f46341u1, 900L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        AsyncImageView asyncImageView = this.f46340t1;
        if (asyncImageView != null) {
            asyncImageView.clearAnimation();
        }
        AsyncImageView V = V();
        this.f46340t1 = V;
        if (V != null) {
            if (V.getVisibility() != 0) {
                this.f46340t1.setVisibility(0);
            }
            this.f46340t1.clearAnimation();
            this.f46340t1.setAlpha(1.0f);
            TranslateAnimation translateAnimation = this.f46337q1;
            if (translateAnimation != null) {
                this.f46340t1.startAnimation(translateAnimation);
            }
        }
    }

    private void Z() {
        int T = T();
        if (T <= 0 || !W()) {
            return;
        }
        if (this.f46337q1 == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0, -200.0f, 0, 0.0f, 1, 0.0f, 1, 0.0f);
            this.f46337q1 = translateAnimation;
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            this.f46337q1.setDuration(340L);
        }
        if (T == 1) {
            a0();
            return;
        }
        if (this.f46338r1 == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.f46338r1 = alphaAnimation;
            alphaAnimation.setInterpolator(new LinearInterpolator());
            this.f46338r1.setDuration(340L);
            this.f46338r1.setAnimationListener(new a());
        }
        b0();
    }

    private void a0() {
        AsyncImageView asyncImageView = this.C;
        if (asyncImageView != null) {
            asyncImageView.clearAnimation();
            TranslateAnimation translateAnimation = this.f46337q1;
            if (translateAnimation != null) {
                this.C.startAnimation(translateAnimation);
            }
        }
    }

    private void b0() {
        Handler handler = this.f46401j1;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.qzone.component.banner.DynamicAdsBanner.4
                @Override // java.lang.Runnable
                public void run() {
                    DynamicAdsBanner.this.X();
                }
            }, 800L);
        }
    }

    @Override // com.qzone.component.banner.NewStyleOperationAdsBanner
    protected void B() {
        this.f46402k0 = new AsyncImageable.AsyncImageListener() { // from class: com.qzone.component.banner.DynamicAdsBanner.1
            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageLoaded(AsyncImageable asyncImageable) {
                final Drawable drawable;
                Handler handler;
                DynamicAdsBanner dynamicAdsBanner = DynamicAdsBanner.this;
                if (dynamicAdsBanner.f46398i0 == null || !dynamicAdsBanner.f46297e || (drawable = ((AsyncImageView) asyncImageable).getDrawable()) == null || (handler = DynamicAdsBanner.this.f46401j1) == null) {
                    return;
                }
                handler.post(new Runnable() { // from class: com.qzone.component.banner.DynamicAdsBanner.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicAdsBanner.this.D.setVisibility(8);
                        DynamicAdsBanner.this.C.setVisibility(0);
                        DynamicAdsBanner.this.C.setImageDrawable(drawable);
                        DynamicAdsBanner.this.f46335o1 = true;
                        DynamicAdsBanner.this.S();
                    }
                });
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageFailed(AsyncImageable asyncImageable) {
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageStarted(AsyncImageable asyncImageable) {
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageProgress(AsyncImageable asyncImageable, float f16) {
            }
        };
        this.f46334n1 = new AsyncImageable.AsyncImageListener() { // from class: com.qzone.component.banner.DynamicAdsBanner.2
            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageLoaded(AsyncImageable asyncImageable) {
                final Drawable drawable;
                Handler handler;
                DynamicAdsBanner dynamicAdsBanner = DynamicAdsBanner.this;
                if (dynamicAdsBanner.f46398i0 == null || !dynamicAdsBanner.f46297e || (drawable = ((AsyncImageView) asyncImageable).getDrawable()) == null || (handler = DynamicAdsBanner.this.f46401j1) == null) {
                    return;
                }
                handler.post(new Runnable() { // from class: com.qzone.component.banner.DynamicAdsBanner.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicAdsBanner.this.f46333m1.setVisibility(4);
                        DynamicAdsBanner.this.f46333m1.setImageDrawable(drawable);
                        DynamicAdsBanner.this.f46336p1 = true;
                        DynamicAdsBanner.this.S();
                    }
                });
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageFailed(AsyncImageable asyncImageable) {
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageStarted(AsyncImageable asyncImageable) {
            }

            @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
            public void onImageProgress(AsyncImageable asyncImageable, float f16) {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.component.banner.NewStyleOperationAdsBanner
    public void E() {
        super.E();
        this.f46336p1 = false;
        this.f46335o1 = false;
        AsyncImageView asyncImageView = this.C;
        if (asyncImageView != null) {
            asyncImageView.setAsyncImage(null);
            this.C.setImageDrawable(null);
            this.C.setAsyncImageListener(null);
            this.C.setVisibility(8);
        }
        AsyncImageView asyncImageView2 = this.f46333m1;
        if (asyncImageView2 != null) {
            asyncImageView2.setAsyncImageListener(null);
            this.f46333m1.setAsyncImage(null);
            this.f46333m1.setImageDrawable(null);
            this.f46333m1.setVisibility(8);
        }
        AsyncImageView asyncImageView3 = this.f46339s1;
        if (asyncImageView3 != null) {
            asyncImageView3.clearAnimation();
        }
        AsyncImageView asyncImageView4 = this.f46340t1;
        if (asyncImageView4 != null) {
            asyncImageView4.clearAnimation();
        }
        this.f46337q1 = null;
        this.f46338r1 = null;
        this.f46339s1 = null;
        this.f46340t1 = null;
        Handler handler = this.f46401j1;
        if (handler != null) {
            Runnable runnable = this.f46342v1;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
            }
            Runnable runnable2 = this.f46341u1;
            if (runnable2 != null) {
                this.f46401j1.removeCallbacks(runnable2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.component.banner.NewStyleOperationAdsBanner
    public void F() {
        super.F();
        if (TextUtils.isEmpty(this.G0)) {
            this.f46336p1 = true;
        } else {
            this.f46333m1.setAsyncImageListener(this.f46334n1);
            this.f46333m1.setAsyncImage(this.G0);
        }
    }

    @Override // com.qzone.component.banner.NewStyleOperationAdsBanner, com.qzone.component.banner.Banner
    public int d() {
        return 700;
    }

    @Override // com.qzone.component.banner.NewStyleOperationAdsBanner, com.qzone.component.banner.Banner
    public int e() {
        return 26;
    }

    @Override // com.qzone.component.banner.NewStyleOperationAdsBanner, com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        super.h(viewStub);
        RelativeLayout relativeLayout = this.f46394h;
        if (relativeLayout == null) {
            return;
        }
        this.f46333m1 = (AsyncImageView) relativeLayout.findViewById(R.id.fep);
    }

    @Override // com.qzone.component.banner.NewStyleOperationAdsBanner, com.qzone.component.banner.Banner
    public void i(boolean z16) {
        super.i(z16);
        if (this.f46297e && z16) {
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.component.banner.NewStyleOperationAdsBanner
    public void A() {
        BusinessADBannerData businessADBannerData;
        JSONObject optJSONObject;
        super.A();
        com.qzone.feed.business.model.a aVar = this.f46398i0;
        if (aVar == null || (businessADBannerData = aVar.f47123g) == null || TextUtils.isEmpty(businessADBannerData.dynBannerJsonData)) {
            return;
        }
        try {
            com.qzone.feed.business.model.a aVar2 = this.f46398i0;
            if (aVar2.f47131o == 1039) {
                optJSONObject = new JSONObject(this.f46398i0.f47123g.dynBannerJsonData);
            } else {
                JSONArray jSONArray = new JSONArray(aVar2.f47123g.dynBannerJsonData);
                optJSONObject = jSONArray.length() > 0 ? jSONArray.optJSONObject(0) : null;
            }
            if (optJSONObject != null) {
                if (optJSONObject.has("pic_type")) {
                    this.E0 = optJSONObject.optString("pic_type");
                }
                if (optJSONObject.has("picture")) {
                    this.F0 = optJSONObject.optString("picture");
                }
                if (optJSONObject.has("picture2")) {
                    this.G0 = optJSONObject.optString("picture2");
                }
                if (optJSONObject.has("title")) {
                    this.H0 = optJSONObject.optString("title");
                }
                if (optJSONObject.has("sub_title_type")) {
                    this.I0 = optJSONObject.optString("sub_title_type");
                }
                if (optJSONObject.has("nick_pattern")) {
                    this.J0 = optJSONObject.optString("nick_pattern");
                }
                if (optJSONObject.has("end_time")) {
                    this.K0 = optJSONObject.optString("end_time");
                }
                if (optJSONObject.has("content_text")) {
                    this.L0 = optJSONObject.optString("content_text");
                }
                if (optJSONObject.has("corner_mark")) {
                    this.M0 = optJSONObject.optString("corner_mark");
                }
                if (optJSONObject.has(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT)) {
                    this.N0 = optJSONObject.optString(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT);
                }
                if (optJSONObject.has("adv_mark")) {
                    this.O0 = optJSONObject.optString("adv_mark");
                }
                if (optJSONObject.has("bgm_pic_cover_left")) {
                    this.P0 = optJSONObject.optString("bgm_pic_cover_left");
                }
                if (optJSONObject.has("bgm_pic_cover_right")) {
                    this.Q0 = optJSONObject.optString("bgm_pic_cover_right");
                }
                if (optJSONObject.has("floating_gif")) {
                    this.R0 = optJSONObject.optString("floating_gif");
                }
                if (optJSONObject.has("button_gif")) {
                    this.S0 = optJSONObject.optString("button_gif");
                }
                if (optJSONObject.has("button_type")) {
                    this.T0 = optJSONObject.optString("button_type");
                }
                if (optJSONObject.has("url")) {
                    this.U0 = optJSONObject.optString("url");
                }
                if (optJSONObject.has("scheme_url")) {
                    this.V0 = optJSONObject.optString("scheme_url");
                }
            }
        } catch (JSONException e16) {
            j.d(f46332w1, "initBannerData error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (DynamicAdsBanner.this.f46339s1 != null) {
                DynamicAdsBanner.this.f46339s1.setAlpha(0.0f);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
