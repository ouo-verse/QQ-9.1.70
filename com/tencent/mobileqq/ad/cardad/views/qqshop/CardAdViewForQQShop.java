package com.tencent.mobileqq.ad.cardad.views.qqshop;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.views.shake.GdtShakeIconView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.ad.cardad.utils.a;
import com.tencent.mobileqq.ad.cardad.utils.d;
import com.tencent.mobileqq.ad.cardad.views.CardAdView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010?\u001a\u00020>\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0004J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0006\u0010\r\u001a\u00020\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010(\u001a\u0004\u0018\u00010\u00158\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00105R\u0016\u00108\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00105R\u0016\u0010;\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00105\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/qqshop/CardAdViewForQQShop;", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "", "O0", "M0", "P0", "Y", "f", "", "defaultRadiusDp", "I0", "q0", "s0", "H0", "l", "j0", "Q0", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "L0", "e0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "k0", "Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "getMButtonShakeIconForQQShop", "()Lcom/tencent/gdtad/views/shake/GdtShakeIconView;", "setMButtonShakeIconForQQShop", "(Lcom/tencent/gdtad/views/shake/GdtShakeIconView;)V", "mButtonShakeIconForQQShop", "Landroid/widget/FrameLayout;", "l0", "Landroid/widget/FrameLayout;", "J0", "()Landroid/widget/FrameLayout;", "setMBigShakeIconContainerForQQShop", "(Landroid/widget/FrameLayout;)V", "mBigShakeIconContainerForQQShop", "m0", "K0", "setMBigShakeIconForQQShop", "mBigShakeIconForQQShop", "Lcom/tencent/mobileqq/ad/cardad/utils/a;", "n0", "Lcom/tencent/mobileqq/ad/cardad/utils/a;", "mQQShopShakeHelper", "Landroid/animation/ValueAnimator;", "o0", "Landroid/animation/ValueAnimator;", "mQQShopShakeFirstTimeAnimator", "p0", "Lcom/tencent/gdtad/inject/GdtThirdProcessorProxy;", "mThirdProcessorProxy", "", "Z", "mIsQQShopShakeFirstTimeShow", "r0", "mHasRegisterShake", "mHasStartBigIconShakeAnim", "t0", "mHasEndBigIconShakeAnim", "Landroid/content/Context;", "context", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "reportCallback", "<init>", "(Landroid/content/Context;Lcom/tencent/gdtad/aditem/GdtAd;Lcom/tencent/mobileqq/ad/cardad/data/aa;)V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class CardAdViewForQQShop extends CardAdView {
    static IPatchRedirector $redirector_;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtShakeIconView mButtonShakeIconForQQShop;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout mBigShakeIconContainerForQQShop;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtShakeIconView mBigShakeIconForQQShop;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.ad.cardad.utils.a mQQShopShakeHelper;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mQQShopShakeFirstTimeAnimator;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtThirdProcessorProxy mThirdProcessorProxy;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsQQShopShakeFirstTimeShow;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mHasRegisterShake;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mHasStartBigIconShakeAnim;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mHasEndBigIconShakeAnim;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/ad/cardad/views/qqshop/CardAdViewForQQShop$a", "Lcom/tencent/mobileqq/ad/cardad/utils/a$b;", "", "onShakeComplete", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements a.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardAdViewForQQShop.this);
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.utils.a.b
        public void onShakeComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                CardAdViewForQQShop cardAdViewForQQShop = CardAdViewForQQShop.this;
                cardAdViewForQQShop.P(cardAdViewForQQShop.I());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/ad/cardad/views/qqshop/CardAdViewForQQShop$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardAdViewForQQShop.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            d.f186735a.k(CardAdViewForQQShop.this.K0());
            FrameLayout J0 = CardAdViewForQQShop.this.J0();
            if (J0 != null) {
                J0.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAdViewForQQShop(@NotNull Context context, @NotNull GdtAd gdtAd, @Nullable aa aaVar) {
        super(context, gdtAd, aaVar);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, gdtAd, aaVar);
        } else {
            this.mIsQQShopShakeFirstTimeShow = true;
        }
    }

    private final void M0() {
        if (!this.mIsQQShopShakeFirstTimeShow) {
            return;
        }
        this.mIsQQShopShakeFirstTimeShow = false;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 1, 2);
        this.mQQShopShakeFirstTimeAnimator = ofInt;
        if (ofInt != null) {
            ofInt.setDuration(2000L);
        }
        ValueAnimator valueAnimator = this.mQQShopShakeFirstTimeAnimator;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.ad.cardad.views.qqshop.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    CardAdViewForQQShop.N0(CardAdViewForQQShop.this, valueAnimator2);
                }
            });
        }
        ValueAnimator valueAnimator2 = this.mQQShopShakeFirstTimeAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(CardAdViewForQQShop this$0, ValueAnimator valueAnimator) {
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (Intrinsics.areEqual(obj, (Object) 0)) {
            if (this$0.mHasStartBigIconShakeAnim) {
                return;
            }
            this$0.mHasStartBigIconShakeAnim = true;
            FrameLayout frameLayout = this$0.mBigShakeIconContainerForQQShop;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            d.f186735a.j(this$0.mBigShakeIconForQQShop);
            return;
        }
        if (!Intrinsics.areEqual(obj, (Object) 2) || this$0.mHasEndBigIconShakeAnim) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new b());
        FrameLayout frameLayout2 = this$0.mBigShakeIconContainerForQQShop;
        if (frameLayout2 != null) {
            frameLayout2.startAnimation(alphaAnimation);
        }
    }

    private final void O0() {
        d dVar = d.f186735a;
        if (d.d(dVar, I(), false, 2, null) < 0.0d) {
            QLog.d(q(), 1, "startShakeForQQShop rect < 0 return");
            return;
        }
        if (this.mHasRegisterShake) {
            return;
        }
        QLog.d(q(), 1, "startShake");
        com.tencent.mobileqq.ad.cardad.utils.a aVar = this.mQQShopShakeHelper;
        if (aVar != null) {
            aVar.e();
        }
        dVar.j(this.mButtonShakeIconForQQShop);
        M0();
        this.mHasRegisterShake = true;
    }

    private final void P0() {
        if (!this.mHasRegisterShake) {
            return;
        }
        QLog.d(q(), 1, "stopShake");
        this.mHasRegisterShake = false;
        com.tencent.mobileqq.ad.cardad.utils.a aVar = this.mQQShopShakeHelper;
        if (aVar != null) {
            aVar.f();
        }
        FrameLayout frameLayout = this.mBigShakeIconContainerForQQShop;
        if (frameLayout != null) {
            frameLayout.clearAnimation();
        }
        d.f186735a.k(this.mButtonShakeIconForQQShop);
    }

    public final void H0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) J().findViewById(R.id.tn6);
        if (relativeLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).topMargin = ViewUtils.dpToPx(19.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float I0(float defaultRadiusDp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, this, Float.valueOf(defaultRadiusDp))).floatValue();
        }
        if (y() < 0.0f) {
            return defaultRadiusDp;
        }
        return ViewUtils.pxToDp(y());
    }

    @Nullable
    protected final FrameLayout J0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mBigShakeIconContainerForQQShop;
    }

    @Nullable
    protected final GdtShakeIconView K0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (GdtShakeIconView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mBigShakeIconForQQShop;
    }

    @Nullable
    public final GdtThirdProcessorProxy L0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (GdtThirdProcessorProxy) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (this.mThirdProcessorProxy == null) {
            this.mThirdProcessorProxy = new GdtThirdProcessorProxy();
        }
        return this.mThirdProcessorProxy;
    }

    public void Q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.Y();
        this.mButtonShakeIconForQQShop = (GdtShakeIconView) J().findViewById(R.id.f164729tm4);
        this.mBigShakeIconContainerForQQShop = (FrameLayout) J().findViewById(R.id.tmo);
        this.mBigShakeIconForQQShop = (GdtShakeIconView) J().findViewById(R.id.tmn);
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.e0();
        if (g()) {
            this.mHasEndBigIconShakeAnim = true;
            d.f186735a.k(this.mBigShakeIconForQQShop);
            FrameLayout frameLayout = this.mBigShakeIconContainerForQQShop;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.f();
        if (this.mQQShopShakeHelper == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.mQQShopShakeHelper = new com.tencent.mobileqq.ad.cardad.utils.a(context);
        }
        com.tencent.mobileqq.ad.cardad.utils.a aVar = this.mQQShopShakeHelper;
        if (aVar != null) {
            aVar.a(g(), D(), new a());
        }
        if (g()) {
            GdtShakeIconView gdtShakeIconView = this.mButtonShakeIconForQQShop;
            if (gdtShakeIconView != null) {
                gdtShakeIconView.setImageResource();
            }
            GdtShakeIconView gdtShakeIconView2 = this.mBigShakeIconForQQShop;
            if (gdtShakeIconView2 != null) {
                gdtShakeIconView2.setImageResource();
            }
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    protected void j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (d.f186735a.f()) {
            TextView t16 = t();
            if (t16 != null) {
                t16.setTextColor(-1);
            }
            TextView s16 = s();
            if (s16 != null) {
                s16.setTextColor(-1);
            }
            TextView x16 = x();
            if (x16 != null) {
                x16.setTextColor(-1);
            }
            Q0();
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        super.onDestroy();
        com.tencent.mobileqq.ad.cardad.utils.a aVar = this.mQQShopShakeHelper;
        if (aVar != null) {
            aVar.c();
        }
        if (g()) {
            GdtShakeIconView gdtShakeIconView = this.mButtonShakeIconForQQShop;
            if (gdtShakeIconView != null) {
                gdtShakeIconView.resetImageResource();
            }
            GdtShakeIconView gdtShakeIconView2 = this.mBigShakeIconForQQShop;
            if (gdtShakeIconView2 != null) {
                gdtShakeIconView2.resetImageResource();
            }
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            if (!g()) {
                return;
            }
            O0();
        }
    }

    @Override // com.tencent.mobileqq.ad.cardad.views.CardAdView
    public void s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            if (!g()) {
                return;
            }
            P0();
        }
    }
}
