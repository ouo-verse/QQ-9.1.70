package com.tencent.mobileqq.weather.part.briefwarning;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.weather.util.g;
import com.tencent.mobileqq.weather.util.report.s;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001OB\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\bI\u0010JB\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010L\u001a\u0004\u0018\u00010K\u00a2\u0006\u0004\bI\u0010MJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J(\u0010\u000b\u001a\u00020\u00032\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000eJ\b\u0010\u001c\u001a\u00020\u0003H\u0007J\b\u0010\u001d\u001a\u00020\u0003H\u0007J\b\u0010\u001e\u001a\u00020\u0003H\u0007J\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0003R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010*R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010*R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0004\u0010.R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010.R\u0016\u00103\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00107\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00102R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010=R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/weather/part/briefwarning/WeatherBriefWarningView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "", "i", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/weather/part/briefwarning/e;", "Lkotlin/collections/ArrayList;", "warningDataList", "", "isHideWarningDesc", "j", "Landroid/widget/ImageView;", "f", "", "lastIndex", "newIndex", "o", "g", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", h.F, "Lcom/tencent/mobileqq/weather/part/briefwarning/a;", "data", "d", "pagePos", DomainData.DOMAIN_NAME, "onLifecycleResume", "onLifecyclePause", "onLifecycleDestroy", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "Landroid/view/View;", "mRootView", "Landroidx/viewpager/widget/ViewPager;", "e", "Landroidx/viewpager/widget/ViewPager;", "mWarningBanner", "Landroidx/cardview/widget/CardView;", "Landroidx/cardview/widget/CardView;", "mBriefRainContainer", "mWarningContainer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mBriefRainLongText", "mBriefRainDesc", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mBriefRainMoreIcon", "D", "mBriefRainShortText", "E", "mBriefRainIcon", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "mWarningIndicatorContainer", "G", "Z", "mHasWarningData", "H", "mIsResume", "Landroid/os/Handler;", "I", "Landroid/os/Handler;", "mAutoScrollHandler", "Ljava/lang/Runnable;", "J", "Ljava/lang/Runnable;", "mAutoScrollRunnable", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "K", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherBriefWarningView extends FrameLayout implements LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mBriefRainMoreIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mBriefRainShortText;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mBriefRainIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout mWarningIndicatorContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mHasWarningData;

    /* renamed from: H, reason: from kotlin metadata */
    private volatile boolean mIsResume;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private Handler mAutoScrollHandler;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Runnable mAutoScrollRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewPager mWarningBanner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CardView mBriefRainContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CardView mWarningContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mBriefRainLongText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView mBriefRainDesc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/weather/part/briefwarning/WeatherBriefWarningView$a;", "", "", "BANNER_AUTO_LOOP_INTERVAL_MS", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.briefwarning.WeatherBriefWarningView$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43732);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherBriefWarningView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mAutoScrollHandler = new Handler(Looper.getMainLooper());
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(WeatherBriefWarningView this$0, a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g gVar = g.f313646a;
        if (gVar.F()) {
            com.tencent.mobileqq.weather.webpage.f fVar = com.tencent.mobileqq.weather.webpage.f.f313714a;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this.context");
            fVar.p(context, "0");
        } else {
            Context context2 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "this.context");
            gVar.O(context2, gVar.g());
        }
        com.tencent.mobileqq.weather.util.report.f.f313674a.c(aVar.c());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final ImageView f() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.l0_);
        imageView.setColorFilter(-7829368);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(4.0f), ViewUtils.dip2px(4.0f));
        layoutParams.leftMargin = ViewUtils.dip2px(2.0f);
        layoutParams.rightMargin = ViewUtils.dip2px(2.0f);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private final void g() {
        if (com.tencent.mobileqq.weather.util.b.g()) {
            CardView cardView = this.mWarningContainer;
            TextView textView = null;
            if (cardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWarningContainer");
                cardView = null;
            }
            cardView.setCardBackgroundColor(Color.parseColor("#1A1A1A"));
            CardView cardView2 = this.mBriefRainContainer;
            if (cardView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainContainer");
                cardView2 = null;
            }
            cardView2.setCardBackgroundColor(Color.parseColor("#1A1A1A"));
            TextView textView2 = this.mBriefRainLongText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainLongText");
                textView2 = null;
            }
            textView2.setTextColor(-1);
            TextView textView3 = this.mBriefRainShortText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainShortText");
            } else {
                textView = textView3;
            }
            textView.setTextColor(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final LifecycleOwner h(Context context) {
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        return null;
    }

    private final void i() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168898h71, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026rning_layout, this, true)");
        this.mRootView = inflate;
        View view = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.f120827_l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026her_brief_rain_container)");
        this.mBriefRainContainer = (CardView) findViewById;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.f121987cq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026eather_warning_container)");
        this.mWarningContainer = (CardView) findViewById2;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.f121977cp);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026d.weather_warning_banner)");
        this.mWarningBanner = (ViewPager) findViewById3;
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.f120867_p);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R\u2026her_brief_rain_text_long)");
        this.mBriefRainLongText = (TextView) findViewById4;
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.f120877_q);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R\u2026er_brief_rain_text_short)");
        this.mBriefRainShortText = (TextView) findViewById5;
        View view6 = this.mRootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view6 = null;
        }
        View findViewById6 = view6.findViewById(R.id.f120837_m);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R\u2026.weather_brief_rain_desc)");
        this.mBriefRainDesc = (TextView) findViewById6;
        View view7 = this.mRootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view7 = null;
        }
        View findViewById7 = view7.findViewById(R.id.f120847_n);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R\u2026.weather_brief_rain_icon)");
        this.mBriefRainIcon = (ImageView) findViewById7;
        View view8 = this.mRootView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view8 = null;
        }
        View findViewById8 = view8.findViewById(R.id.f120857_o);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R\u2026her_brief_rain_more_icon)");
        this.mBriefRainMoreIcon = (ImageView) findViewById8;
        View view9 = this.mRootView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view = view9;
        }
        View findViewById9 = view.findViewById(R.id.f120637_3);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R\u2026ning_indicator_container)");
        this.mWarningIndicatorContainer = (LinearLayout) findViewById9;
        g();
        com.tencent.mobileqq.ad.cardad.utils.d.f186735a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.weather.part.briefwarning.WeatherBriefWarningView$initView$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeatherBriefWarningView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LifecycleOwner h16;
                Lifecycle lifecycle;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                WeatherBriefWarningView weatherBriefWarningView = WeatherBriefWarningView.this;
                Context context = weatherBriefWarningView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                h16 = weatherBriefWarningView.h(context);
                if (h16 == null || (lifecycle = h16.getLifecycle()) == null) {
                    return;
                }
                lifecycle.addObserver(WeatherBriefWarningView.this);
            }
        });
    }

    private final void j(ArrayList<e> warningDataList, boolean isHideWarningDesc) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        d dVar = new d(context, warningDataList, isHideWarningDesc);
        ViewPager viewPager = this.mWarningBanner;
        ViewPager viewPager2 = null;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWarningBanner");
            viewPager = null;
        }
        viewPager.setAdapter(dVar);
        int size = warningDataList.size();
        LinearLayout linearLayout = this.mWarningIndicatorContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWarningIndicatorContainer");
            linearLayout = null;
        }
        if (size != linearLayout.getChildCount()) {
            LinearLayout linearLayout2 = this.mWarningIndicatorContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWarningIndicatorContainer");
                linearLayout2 = null;
            }
            linearLayout2.removeAllViews();
            if (size > 1) {
                linearLayout2.setVisibility(0);
                for (int i3 = 0; i3 < size; i3++) {
                    linearLayout2.addView(f());
                }
                ViewPager viewPager3 = this.mWarningBanner;
                if (viewPager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWarningBanner");
                    viewPager3 = null;
                }
                int currentItem = viewPager3.getCurrentItem();
                ViewPager viewPager4 = this.mWarningBanner;
                if (viewPager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWarningBanner");
                } else {
                    viewPager2 = viewPager4;
                }
                o(currentItem, viewPager2.getCurrentItem());
            } else {
                linearLayout2.setVisibility(8);
            }
        }
        if (this.mAutoScrollRunnable != null) {
            return;
        }
        this.mAutoScrollRunnable = new Runnable() { // from class: com.tencent.mobileqq.weather.part.briefwarning.c
            @Override // java.lang.Runnable
            public final void run() {
                WeatherBriefWarningView.k(WeatherBriefWarningView.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(WeatherBriefWarningView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.mIsResume) {
            return;
        }
        ViewPager viewPager = this$0.mWarningBanner;
        ViewPager viewPager2 = null;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWarningBanner");
            viewPager = null;
        }
        int currentItem = viewPager.getCurrentItem();
        ViewPager viewPager3 = this$0.mWarningBanner;
        if (viewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWarningBanner");
            viewPager3 = null;
        }
        PagerAdapter adapter = viewPager3.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.weather.part.briefwarning.WeatherWarningBannerAdapter");
        int f373114d = ((d) adapter).getF373114d();
        if (f373114d == 0) {
            return;
        }
        int i3 = (currentItem + 1) % f373114d;
        ViewPager viewPager4 = this$0.mWarningBanner;
        if (viewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWarningBanner");
        } else {
            viewPager2 = viewPager4;
        }
        viewPager2.setCurrentItem(i3, true);
        this$0.o(currentItem, i3);
        Runnable runnable = this$0.mAutoScrollRunnable;
        if (runnable != null) {
            this$0.mAutoScrollHandler.postDelayed(runnable, 3000L);
        }
    }

    private final void o(int lastIndex, int newIndex) {
        boolean z16;
        LinearLayout linearLayout = this.mWarningIndicatorContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWarningIndicatorContainer");
            linearLayout = null;
        }
        boolean z17 = true;
        if (lastIndex >= 0 && lastIndex < linearLayout.getChildCount()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (newIndex < 0 || newIndex >= linearLayout.getChildCount()) {
                z17 = false;
            }
            if (z17) {
                View childAt = linearLayout.getChildAt(lastIndex);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
                ((ImageView) childAt).setColorFilter(-7829368);
                View childAt2 = linearLayout.getChildAt(newIndex);
                Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.ImageView");
                ((ImageView) childAt2).setColorFilter(Color.parseColor("#FF00bFFF"));
            }
        }
    }

    public final void d(@Nullable final a data) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
            return;
        }
        View view = null;
        if (data == null) {
            View view2 = this.mRootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        String b16 = data.b();
        String a16 = data.a();
        if (data.e() && !TextUtils.isEmpty(b16) && !TextUtils.isEmpty(a16)) {
            CardView cardView = this.mBriefRainContainer;
            if (cardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainContainer");
                cardView = null;
            }
            cardView.setVisibility(0);
            TextView textView = this.mBriefRainLongText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainLongText");
                textView = null;
            }
            textView.setText(b16);
            TextView textView2 = this.mBriefRainShortText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainShortText");
                textView2 = null;
            }
            textView2.setText(b16);
            ImageView imageView = this.mBriefRainIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainIcon");
                imageView = null;
            }
            imageView.setImageDrawable(com.tencent.mobileqq.weather.util.b.e(a16));
            CardView cardView2 = this.mBriefRainContainer;
            if (cardView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainContainer");
                cardView2 = null;
            }
            cardView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.briefwarning.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WeatherBriefWarningView.e(WeatherBriefWarningView.this, data, view3);
                }
            });
            z16 = true;
        } else {
            CardView cardView3 = this.mBriefRainContainer;
            if (cardView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainContainer");
                cardView3 = null;
            }
            cardView3.setVisibility(8);
            z16 = false;
        }
        ArrayList<e> d16 = data.d();
        j(d16, z16);
        if (d16.isEmpty()) {
            TextView textView3 = this.mBriefRainShortText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainShortText");
                textView3 = null;
            }
            textView3.setVisibility(8);
            CardView cardView4 = this.mWarningContainer;
            if (cardView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWarningContainer");
                cardView4 = null;
            }
            cardView4.setVisibility(8);
        } else {
            this.mHasWarningData = true;
            CardView cardView5 = this.mWarningContainer;
            if (cardView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWarningContainer");
                cardView5 = null;
            }
            cardView5.setVisibility(0);
        }
        if (z16) {
            TextView textView4 = this.mBriefRainLongText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainLongText");
                textView4 = null;
            }
            textView4.setVisibility(8);
            TextView textView5 = this.mBriefRainDesc;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainDesc");
                textView5 = null;
            }
            textView5.setVisibility(8);
            ImageView imageView2 = this.mBriefRainMoreIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainMoreIcon");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            TextView textView6 = this.mBriefRainShortText;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBriefRainShortText");
            } else {
                view = textView6;
            }
            view.setVisibility(0);
            com.tencent.mobileqq.weather.util.report.f.f313674a.d(data.c());
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            if (!this.mHasWarningData) {
                return;
            }
            this.mIsResume = false;
            this.mAutoScrollHandler.removeCallbacksAndMessages(null);
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.mHasWarningData && !this.mIsResume) {
            this.mIsResume = true;
            Runnable runnable = this.mAutoScrollRunnable;
            if (runnable != null) {
                this.mAutoScrollHandler.postDelayed(runnable, 3000L);
            }
        }
    }

    public final void n(int pagePos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, pagePos);
        } else {
            if (!this.mHasWarningData) {
                return;
            }
            s.f313696a.d(pagePos);
        }
    }

    public final void onDestroy() {
        Lifecycle lifecycle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.mIsResume = false;
        this.mAutoScrollHandler.removeCallbacksAndMessages(null);
        this.mAutoScrollRunnable = null;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner h16 = h(context);
        if (h16 != null && (lifecycle = h16.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onLifecycleDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            QLog.d("WeatherBriefWarningView", 2, "onLifecycleDestroy");
            onDestroy();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onLifecyclePause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QLog.d("WeatherBriefWarningView", 2, "onLifecyclePause");
            l();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onLifecycleResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            QLog.d("WeatherBriefWarningView", 2, "onLifecycleResume");
            m();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherBriefWarningView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.mAutoScrollHandler = new Handler(Looper.getMainLooper());
            i();
        }
    }
}
