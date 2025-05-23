package com.qzone.component.banner;

import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.util.ar;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AvatarImageView;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import cooperation.qzone.zipanimate.DrawableLoadedListener;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class BaseBubbleBanner extends Banner implements View.OnClickListener {
    public static String S = "BaseFeedBubbleBanner";
    private RelativeLayout C;
    private PassiveFeedBubbleBannerBg D;
    private TextView E;
    private ImageView F;
    private AsyncImageView G;
    private AsyncImageView H;
    private AvatarImageView I;
    private AsyncImageView J;
    private AvatarImageView K;
    private AsyncImageView L;
    private AvatarImageView M;
    private View N;
    private com.qzone.feed.business.model.a P;
    private boolean Q;
    private Handler R;

    /* renamed from: h, reason: collision with root package name */
    protected Context f46305h;

    /* renamed from: i, reason: collision with root package name */
    protected View f46306i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f46307m;

    public BaseBubbleBanner(Context context) {
        super(context);
        this.Q = false;
        this.f46305h = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable A() {
        return com.tencent.mobileqq.qzone.picload.c.a().l(getResources().getDrawable(R.drawable.gak), getResources().getColor(R.color.qui_common_icon_primary));
    }

    private int B() {
        return getResources().getColor(R.color.qui_common_text_primary);
    }

    private boolean E() {
        return com.tencent.mobileqq.activity.leba.utils.a.d(getContext());
    }

    private void G() {
        PassiveFeedBubbleBannerBg passiveFeedBubbleBannerBg;
        PassiveFeedBubbleBannerBg passiveFeedBubbleBannerBg2;
        if (QQTheme.isNowSimpleUI() && E() && (passiveFeedBubbleBannerBg = this.D) != null && (passiveFeedBubbleBannerBg2 = (PassiveFeedBubbleBannerBg) passiveFeedBubbleBannerBg.findViewById(R.id.hll)) != null) {
            ViewGroup.LayoutParams layoutParams = passiveFeedBubbleBannerBg2.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = ImmersiveUtils.dpToPx(10.0f);
                passiveFeedBubbleBannerBg2.setLayoutParams(layoutParams2);
            }
        }
    }

    private void L(QzmallCustomBubbleSkin qzmallCustomBubbleSkin) {
        int i3;
        if (this.P != null && qzmallCustomBubbleSkin != null && !TextUtils.isEmpty(qzmallCustomBubbleSkin.strBubbleZipUrl)) {
            if (this.P.f47122f.size() != 1) {
                return;
            }
            String str = qzmallCustomBubbleSkin.strBubbleZipUrl;
            QzoneZipAnimateUtil.d(str, "PassiveFeedPush", String.valueOf(str.hashCode()), new AnonymousClass1(qzmallCustomBubbleSkin));
            TextView textView = this.E;
            if (QQTheme.isNowSimpleUI()) {
                i3 = B();
            } else {
                i3 = (int) qzmallCustomBubbleSkin.lTextColor;
            }
            textView.setTextColor(i3);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor((int) qzmallCustomBubbleSkin.lHeadBgColor);
            shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
            int d16 = ar.d(1.0f);
            shapeDrawable.getPaint().setStrokeWidth(d16);
            shapeDrawable.getPaint().setAntiAlias(true);
            shapeDrawable.setPadding(d16, d16, d16, d16);
            this.I.setForeground(shapeDrawable);
            return;
        }
        H();
    }

    protected void D(Context context) {
        View view = this.f46306i;
        if (view != null && context != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.hlv);
            this.f46307m = linearLayout;
            linearLayout.setOnClickListener(this);
            PassiveFeedBubbleBannerBg passiveFeedBubbleBannerBg = (PassiveFeedBubbleBannerBg) this.f46306i.findViewById(R.id.hll);
            this.D = passiveFeedBubbleBannerBg;
            this.C = (RelativeLayout) passiveFeedBubbleBannerBg.findViewById(R.id.hlq);
            this.E = (TextView) this.D.findViewById(R.id.hlx);
            this.F = (ImageView) this.D.findViewById(R.id.hlm);
            this.I = (AvatarImageView) this.C.findViewById(R.id.hln);
            this.G = (AsyncImageView) this.C.findViewById(R.id.hlp);
            this.H = (AsyncImageView) this.C.findViewById(R.id.hlo);
            this.K = (AvatarImageView) this.C.findViewById(R.id.hlr);
            this.J = (AsyncImageView) this.C.findViewById(R.id.hls);
            this.M = (AvatarImageView) this.C.findViewById(R.id.hlt);
            this.L = (AsyncImageView) this.C.findViewById(R.id.hlu);
            this.f46297e = true;
            return;
        }
        QZLog.e(S, 1, this + " init fail, context: " + context + ", container: " + this.f46306i);
    }

    public void K(boolean z16, boolean z17) {
        if (this.N != null) {
            this.N.setBackgroundColor(z17 ? Color.parseColor("#ECECEC") : 0);
            if (this.P != null) {
                this.N.setAlpha(r5.f47124h / 255.0f);
            }
            this.N.setVisibility(z16 ? 0 : 8);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void destroy() {
        z();
    }

    @Override // com.qzone.component.banner.Banner
    public void g() {
        super.g();
        z();
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        View view;
        if (!this.f46297e || (view = this.f46306i) == null) {
            return;
        }
        if (!z16) {
            view.setVisibility(8);
            J(false);
        } else {
            view.setVisibility(0);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        View view = this.f46306i;
        return view != null && view.getVisibility() == 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f46297e) {
            C();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setDefaultBackgroundDrawable(Drawable drawable) {
        PassiveFeedBubbleBannerBg passiveFeedBubbleBannerBg = this.D;
        if (passiveFeedBubbleBannerBg != null) {
            passiveFeedBubbleBannerBg.setDefaultBackgoundDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        LinearLayout linearLayout = this.f46307m;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(onClickListener);
        }
    }

    public void z() {
        if (this.f46305h != null) {
            this.f46305h = null;
        }
        AvatarImageView avatarImageView = this.I;
        if (avatarImageView != null) {
            avatarImageView.setImageDrawable(null);
        }
        AvatarImageView avatarImageView2 = this.K;
        if (avatarImageView2 != null) {
            avatarImageView2.setImageDrawable(null);
        }
        AvatarImageView avatarImageView3 = this.M;
        if (avatarImageView3 != null) {
            avatarImageView3.setImageDrawable(null);
        }
        PassiveFeedBubbleBannerBg passiveFeedBubbleBannerBg = this.D;
        if (passiveFeedBubbleBannerBg != null) {
            passiveFeedBubbleBannerBg.w();
        }
    }

    public void J(boolean z16) {
        K(z16, true);
    }

    private void I(QZoneCountUserInfo qZoneCountUserInfo, ImageView imageView) {
        if (qZoneCountUserInfo != null && qZoneCountUserInfo.iYellowType > 0 && qZoneCountUserInfo.iYellowLevel == 9 && !QQTheme.isNowSimpleUI()) {
            imageView.setImageResource(R.drawable.fyp);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        if (viewStub != null && this.f46305h != null) {
            this.f46306i = viewStub.inflate();
            D(this.f46305h);
            return;
        }
        QZLog.e(S, 1, this + " initView fail, mContext: " + this.f46305h + ", viewStub: " + viewStub);
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        String str;
        boolean z16;
        QZoneCountUserInfo qZoneCountUserInfo;
        PassiveFeedsPush passiveFeedsPush;
        QzmallCustomBubbleSkin qzmallCustomBubbleSkin;
        if (aVar != null && this.f46297e && (str = aVar.f47119c) != null && aVar.f47122f != null) {
            this.P = aVar;
            this.E.setText(str);
            int size = aVar.f47122f.size();
            QZLog.d(S, 1, "avatar_count: " + size);
            Iterator<Pair<QZoneCountUserInfo, String>> it = aVar.f47122f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                QZoneCountUserInfo qZoneCountUserInfo2 = it.next().first;
                if (qZoneCountUserInfo2 != null && qZoneCountUserInfo2.iYellowType > 0 && qZoneCountUserInfo2.iYellowLevel == 9) {
                    z16 = true;
                    break;
                }
            }
            String str2 = null;
            QzmallCustomBubbleSkin qzmallCustomBubbleSkin2 = (!aVar.f47135s || aVar.f47122f.size() != 1 || (passiveFeedsPush = (qZoneCountUserInfo = aVar.f47122f.get(0).first).pushData) == null || (qzmallCustomBubbleSkin = passiveFeedsPush.stBubbleSkin) == null || TextUtils.isEmpty(qzmallCustomBubbleSkin.strBubbleZipUrl)) ? null : qZoneCountUserInfo.pushData.stBubbleSkin;
            boolean z17 = !this.Q;
            if (this.P == null || qzmallCustomBubbleSkin2 == null || TextUtils.isEmpty(qzmallCustomBubbleSkin2.strBubbleZipUrl)) {
                z17 = true;
            }
            if (this.P.f47122f.size() != 1) {
                z17 = true;
            }
            if (z17) {
                if (z16 && !QQTheme.isNowSimpleUI()) {
                    this.F.setImageResource(R.drawable.gal);
                    this.E.setTextColor(getResources().getColor(R.color.a6h));
                    this.I.setSelector(R.drawable.avq);
                    this.K.setSelector(R.drawable.avq);
                    this.M.setSelector(R.drawable.avq);
                } else {
                    this.F.setImageDrawable(A());
                    this.E.setTextColor(B());
                    this.I.setSelector(R.drawable.avp);
                    this.K.setSelector(R.drawable.avp);
                    this.M.setSelector(R.drawable.avp);
                }
            }
            this.D.setHasLv9(z16 && qzmallCustomBubbleSkin2 == null && !QQTheme.isNowSimpleUI());
            PassiveFeedBubbleBannerBg passiveFeedBubbleBannerBg = this.D;
            if (qzmallCustomBubbleSkin2 != null && !QQTheme.isNowSimpleUI()) {
                str2 = qzmallCustomBubbleSkin2.strBubbleZipUrl;
            }
            passiveFeedBubbleBannerBg.setCustomSkin(str2);
            L(qzmallCustomBubbleSkin2);
            G();
            this.I.setVisibility(0);
            this.K.setVisibility(0);
            this.M.setVisibility(0);
            this.G.setVisibility(0);
            this.H.setVisibility(0);
            this.J.setVisibility(0);
            this.L.setVisibility(0);
            if (size == 0) {
                return;
            }
            if (size == 1) {
                if (aVar.f47122f.get(0).first != null) {
                    this.I.j(aVar.f47122f.get(0).first.uin);
                    I(aVar.f47122f.get(0).first, this.H);
                }
                if (z16 && !QQTheme.isNowSimpleUI()) {
                    this.G.setImageResource(R.drawable.fyq);
                    this.G.setVisibility(0);
                } else if (QQTheme.isNowSimpleUI()) {
                    this.G.setVisibility(8);
                    this.H.setVisibility(8);
                } else {
                    this.G.setVisibility(8);
                    this.H.setVisibility(8);
                }
                this.K.setVisibility(8);
                this.J.setVisibility(8);
                this.M.setVisibility(8);
                this.L.setVisibility(8);
            } else if (size == 2) {
                if (aVar.f47122f.get(0).first != null) {
                    this.I.j(aVar.f47122f.get(0).first.uin);
                    I(aVar.f47122f.get(0).first, this.H);
                }
                if (aVar.f47122f.get(1).first != null) {
                    this.K.j(aVar.f47122f.get(1).first.uin);
                    I(aVar.f47122f.get(1).first, this.J);
                }
                this.M.setVisibility(8);
                this.L.setVisibility(8);
                this.I.bringToFront();
                this.H.bringToFront();
                this.G.setVisibility(4);
            } else if (size == 3) {
                if (aVar.f47122f.get(0).first != null) {
                    this.I.j(aVar.f47122f.get(0).first.uin);
                    I(aVar.f47122f.get(0).first, this.H);
                }
                if (aVar.f47122f.get(1).first != null) {
                    this.K.j(aVar.f47122f.get(1).first.uin);
                    I(aVar.f47122f.get(1).first, this.J);
                }
                if (aVar.f47122f.get(2).first != null) {
                    this.M.j(aVar.f47122f.get(2).first.uin);
                    I(aVar.f47122f.get(2).first, this.L);
                }
                this.K.bringToFront();
                this.J.bringToFront();
                this.I.bringToFront();
                this.H.bringToFront();
                this.G.setVisibility(4);
            }
            if (c()) {
                F();
                return;
            }
            return;
        }
        QZLog.e(S, 1, "updateBannerData failed, return, data: " + aVar + ", isBannerInitialized: " + this.f46297e);
    }

    private void H() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
    }

    @Override // com.qzone.component.banner.Banner
    public void f(Message message) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.component.banner.BaseBubbleBanner$1, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass1 implements QzoneZipCacheHelperCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QzmallCustomBubbleSkin f46308a;

        AnonymousClass1(QzmallCustomBubbleSkin qzmallCustomBubbleSkin) {
            this.f46308a = qzmallCustomBubbleSkin;
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResult(boolean z16) {
            QzoneZipAnimateUtil.l("PassiveFeedPush", String.valueOf(this.f46308a.strBubbleZipUrl.hashCode()), "arrow@2x.png", -1, -1, new DrawableLoadedListener() { // from class: com.qzone.component.banner.BaseBubbleBanner.1.1
                @Override // cooperation.qzone.zipanimate.DrawableLoadedListener
                public void onLoaded(final Drawable drawable) {
                    BaseBubbleBanner.this.Q = true;
                    if (BaseBubbleBanner.this.R == null) {
                        BaseBubbleBanner.this.R = new Handler(Looper.getMainLooper());
                    }
                    BaseBubbleBanner.this.R.post(new Runnable() { // from class: com.qzone.component.banner.BaseBubbleBanner.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Drawable drawable2;
                            if (BaseBubbleBanner.this.F == null) {
                                return;
                            }
                            ImageView imageView = BaseBubbleBanner.this.F;
                            if (QQTheme.isNowSimpleUI()) {
                                drawable2 = BaseBubbleBanner.this.A();
                            } else {
                                drawable2 = drawable;
                            }
                            imageView.setImageDrawable(drawable2);
                        }
                    });
                }
            });
        }

        @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
        public void onResultOfNativeRequest(boolean z16, String str, String str2) {
        }
    }
}
