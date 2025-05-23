package com.tencent.mobileqq.weather.part;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001&B\u001b\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001e\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/weather/part/WeatherPendantView;", "Landroid/widget/FrameLayout;", "", tl.h.F, "Lcom/tencent/mobileqq/weather/data/o;", "dataItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "", "isMoveToRight", DomainData.DOMAIN_NAME, "e", "k", "l", "j", "i", "Landroid/view/View;", "d", "Landroid/view/View;", "mRootView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mPendantImage", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "f", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "mPendantDrawable", "Z", "mHasExposeReported", "", "I", "mCurrentPos", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherPendantView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mPendantImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private APNGDrawable mPendantDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mHasExposeReported;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile int mCurrentPos;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/weather/part/WeatherPendantView$a;", "", "", "CURRENT_POS_ORIGIN", "I", "CURRENT_POS_RIGHT", "", "ICON_APPEAR_ANIM_DURATION", "J", "MOVE_SIDE_ANIM_DURATION", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.WeatherPendantView$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/weather/part/WeatherPendantView$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeatherPendantView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
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
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                View view = WeatherPendantView.this.mRootView;
                if (view != null) {
                    view.setVisibility(0);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42847);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherPendantView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String jumpUrl, com.tencent.mobileqq.weather.data.o oVar, WeatherPendantView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(jumpUrl, "$jumpUrl");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        gVar.O(context, jumpUrl);
        com.tencent.mobileqq.weather.mvvm.h.f313416a.f(oVar, IndividuationUrlHelper.UrlId.PENDANT_HOME);
        if (this$0.mCurrentPos == 1) {
            com.tencent.mobileqq.weather.util.report.k.f313685a.d();
        } else {
            com.tencent.mobileqq.weather.util.report.k.f313685a.b();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g() {
        Animation animation;
        View view = this.mRootView;
        if (view != null) {
            view.setVisibility(8);
        }
        k();
        this.mPendantDrawable = null;
        View view2 = this.mRootView;
        if (view2 != null && (animation = view2.getAnimation()) != null) {
            animation.cancel();
        }
    }

    private final void h() {
        ImageView imageView;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.i4c, (ViewGroup) this, true);
        this.mRootView = inflate;
        if (inflate == null) {
            QLog.e("WeatherPendantView", 1, "init view error: root view is null");
            return;
        }
        if (inflate != null) {
            imageView = (ImageView) inflate.findViewById(R.id.f121337az);
        } else {
            imageView = null;
        }
        this.mPendantImage = imageView;
    }

    private final void m(com.tencent.mobileqq.weather.data.o dataItem) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new b());
        View view = this.mRootView;
        if (view != null) {
            view.startAnimation(alphaAnimation);
        }
        l();
        if (!this.mHasExposeReported) {
            com.tencent.mobileqq.weather.mvvm.h.f313416a.g(dataItem, IndividuationUrlHelper.UrlId.PENDANT_HOME);
            com.tencent.mobileqq.weather.util.report.k.f313685a.c();
            this.mHasExposeReported = true;
        }
    }

    private final void n(boolean isMoveToRight) {
        float dpToPx;
        final View view = this.mRootView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            final FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            float f16 = layoutParams2.rightMargin;
            if (isMoveToRight) {
                dpToPx = ViewUtils.dpToPx(25.0f) * (-1.0f);
            } else {
                dpToPx = ViewUtils.dpToPx(10.0f);
            }
            final ValueAnimator ofFloat = ValueAnimator.ofFloat(f16, dpToPx);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.weather.part.t
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    WeatherPendantView.o(layoutParams2, view, valueAnimator);
                }
            });
            ofFloat.setDuration(100L);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.weather.part.u
                @Override // java.lang.Runnable
                public final void run() {
                    WeatherPendantView.p(ofFloat);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FrameLayout.LayoutParams layoutParams, View it, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(layoutParams, "$layoutParams");
        Intrinsics.checkNotNullParameter(it, "$it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        layoutParams.rightMargin = (int) ((Float) animatedValue).floatValue();
        it.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ValueAnimator valueAnimator) {
        valueAnimator.start();
    }

    public final void e(@Nullable final com.tencent.mobileqq.weather.data.o dataItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dataItem);
            return;
        }
        if (dataItem == null) {
            g();
            return;
        }
        m(dataItem);
        String g16 = dataItem.g();
        final String f16 = dataItem.f();
        APNGDrawable apngDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable("WeatherPendantView", g16, new ApngOptions());
        this.mPendantDrawable = apngDrawable;
        ImageView imageView = this.mPendantImage;
        if (imageView != null) {
            imageView.setImageDrawable(apngDrawable);
        }
        View view = this.mRootView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WeatherPendantView.f(f16, dataItem, this, view2);
                }
            });
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (this.mCurrentPos == 0) {
                return;
            }
            this.mCurrentPos = 0;
            n(false);
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            if (this.mCurrentPos == 1) {
                return;
            }
            this.mCurrentPos = 1;
            n(true);
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        APNGDrawable aPNGDrawable = this.mPendantDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.stop();
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        APNGDrawable aPNGDrawable = this.mPendantDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.start();
        }
    }
}
