package com.qzone.component.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.personalize.model.CustomBannerFeeData;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.util.ar;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QZoneConfigHelper;

/* compiled from: P */
/* loaded from: classes39.dex */
public class YellowDiamondTopBanner extends Banner {
    private Context C;
    private LinearLayout D;
    private ImageView E;
    private TextView F;
    private View G;
    private TextView H;
    protected Animation I;
    protected Animation J;

    /* renamed from: h, reason: collision with root package name */
    private String f46556h;

    /* renamed from: i, reason: collision with root package name */
    private int f46557i;

    /* renamed from: m, reason: collision with root package name */
    private String f46558m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            j.f("YellowDiamondTopBanner", "bannershow, click");
            yo.d.d(YellowDiamondTopBanner.this.f46556h, YellowDiamondTopBanner.this.C, null);
            com.qzone.component.banner.util.a.e(YellowDiamondTopBanner.this.f46557i, true);
            YellowDiamondTopBanner.this.g();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public YellowDiamondTopBanner(Context context) {
        super(context);
        this.C = context;
    }

    private boolean y() {
        return QQTheme.isNowSimpleUI() && (QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_B.equals(((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getExpPostBtnMode()) || QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_POST_BTN_MODE_C.equals(((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getExpPostBtnMode()));
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 500;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 20;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        LayoutInflater.from(getContext()).inflate(R.layout.bjp, (ViewGroup) this, true);
        this.D = (LinearLayout) findViewById(R.id.hea);
        this.E = (ImageView) findViewById(R.id.hed);
        this.F = (TextView) findViewById(R.id.heb);
        this.G = findViewById(R.id.hec);
        this.H = (TextView) findViewById(R.id.hqw);
        this.D.setOnClickListener(new a());
        b bVar = new b();
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154790co);
        this.I = loadAnimation;
        loadAnimation.setAnimationListener(bVar);
        Animation.AnimationListener animationListener = new Animation.AnimationListener() { // from class: com.qzone.component.banner.YellowDiamondTopBanner.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                YellowDiamondTopBanner.this.getHandler().postDelayed(new Runnable() { // from class: com.qzone.component.banner.YellowDiamondTopBanner.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (YellowDiamondTopBanner.this.l()) {
                            YellowDiamondTopBanner yellowDiamondTopBanner = YellowDiamondTopBanner.this;
                            yellowDiamondTopBanner.startAnimation(yellowDiamondTopBanner.I);
                        }
                    }
                }, QZoneConfigHelper.S());
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        };
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f154787cm);
        this.J = loadAnimation2;
        loadAnimation2.setAnimationListener(animationListener);
        setVisibility(8);
        this.f46297e = true;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        if (y()) {
            z16 = false;
        }
        if (this.f46297e) {
            setVisibility(z16 ? 0 : 8);
            if (z16) {
                Animation animation = this.J;
                if (animation != null && this.I != null) {
                    startAnimation(animation);
                }
                this.f46298f = false;
            }
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && getVisibility() == 0;
    }

    public void setBannerImageDrawble(String str) {
        Drawable loadImage = ImageLoader.getInstance().loadImage(str, new ImageLoader.ImageLoadListener() { // from class: com.qzone.component.banner.YellowDiamondTopBanner.4
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str2, final Drawable drawable, ImageLoader.Options options) {
                if (YellowDiamondTopBanner.this.E != null) {
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.component.banner.YellowDiamondTopBanner.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            YellowDiamondTopBanner.this.setCommonState(drawable);
                        }
                    });
                }
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str2, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str2, float f16, ImageLoader.Options options) {
            }
        });
        if (loadImage == null || this.E == null) {
            return;
        }
        setCommonState(loadImage);
    }

    public void setCommonState(Drawable drawable) {
        this.E.setImageDrawable(drawable);
        this.E.setVisibility(0);
        this.f46298f = true;
        c();
        z5.a.f().s(new Handler(Looper.getMainLooper()), LoginData.getInstance().getUin(), this.f46558m, this.f46557i, 1, 1);
        com.qzone.component.banner.util.a.e(this.f46557i, false);
        j.f("YellowDiamondTopBanner", "@banershowupdate BannerData xiugai lp.height =" + this.E.getHeight() + " width = " + this.E.getWidth());
        j.f("YellowDiamondTopBanner", "@banershow test xiugai ");
    }

    public YellowDiamondTopBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = context;
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        CustomBannerFeeData customBannerFeeData;
        if (aVar != null && (customBannerFeeData = aVar.f47134r) != null) {
            this.f46557i = customBannerFeeData.iBannerType;
            this.f46558m = customBannerFeeData.strTraceInfo;
            this.f46556h = customBannerFeeData.strJumpUrl;
            int i3 = customBannerFeeData.iBannerConfType;
            if (i3 == 0) {
                this.F.setVisibility(8);
                this.H.setVisibility(8);
                this.G.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, 0, 0, 0);
                this.E.setLayoutParams(layoutParams);
                setBannerImageDrawble(customBannerFeeData.strBannerUrl);
                this.D.setVisibility(0);
                this.D.setBackgroundColor(getResources().getColor(R.color.ajr));
                return;
            }
            if (i3 != 1) {
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ar.d(20.0f), ar.d(20.0f));
            layoutParams2.setMargins(ar.d(12.0f), 0, 0, 0);
            this.E.setLayoutParams(layoutParams2);
            setBannerImageDrawble(customBannerFeeData.strIconUrl);
            this.F.setText(customBannerFeeData.strText);
            this.H.setText(customBannerFeeData.strButtonText);
            this.F.setVisibility(0);
            this.H.setVisibility(0);
            this.G.setVisibility(0);
            this.D.setVisibility(0);
            this.D.setBackgroundResource(R.drawable.g18);
            this.f46298f = true;
            c();
            return;
        }
        j.f("YellowDiamondTopBanner", "@bannershow data customBannerFeeData is null");
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            YellowDiamondTopBanner.this.g();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
