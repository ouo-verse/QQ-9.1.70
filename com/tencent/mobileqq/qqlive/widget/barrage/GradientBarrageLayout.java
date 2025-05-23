package com.tencent.mobileqq.qqlive.widget.barrage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 q2\u00020\u0001:\u0001rB\u001d\b\u0007\u0012\u0006\u0010l\u001a\u00020k\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010m\u00a2\u0006\u0004\bo\u0010pJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u001c\u0010\u0017\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u0014\u0010\u001b\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cJ&\u0010#\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002J\u000e\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\nJ0\u0010*\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190&J\u000e\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0019J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0002J\u0016\u00102\u001a\u00020\u00072\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u0002J&\u00103\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002J\u000e\u00104\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\nJ\u0014\u00105\u001a\u00020\u00072\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190&J\u000e\u00106\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0019J\u0016\u00109\u001a\u00020\u00072\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\nJ\u000e\u0010:\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010;\u001a\u00020\u0007J(\u0010@\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0002H\u0014R\u0016\u0010C\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00130F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010HR\u0016\u0010M\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00190&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010HR\u0016\u0010U\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010LR\u0016\u0010X\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010YR\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010LR\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010LR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010]R\u001b\u0010b\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR*\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010i\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "type", "contentLength", "", "O0", "", "L0", "K0", "", "centerViewOffset", "U0", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "I0", "id", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "lp", "Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageView;", "G0", "Lkotlin/Function1;", "action", "M0", "Q0", "", c.f123400v, "R0", "", "singleLine", "setSingleLine", "left", "top", "right", "bottom", "setTextPadding", "textSize", "setTextSizeDp", "", "textColors", "borderColors", NodeProps.BACKGROUND_COLORS, "setColors", "text", IECSearchBar.METHOD_SET_TEXT, "offset", "setTextOffset", "Landroid/graphics/drawable/Drawable;", "drawable", "margin", "setStartIcon", "setSurroundingTextPadding", "setSurroundTextSizeDp", "setSurroundTextColor", "setSurroundText", "topBarrageViewOffset", "bottomBarrageViewOffset", "setSurroundingTextOffset", "S0", "H0", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "d", "Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageView;", "centerView", "e", "centerRightView", "", "f", "Ljava/util/List;", "bottomBarrageViews", "topBarrageViews", "i", UserInfo.SEX_FEMALE, "textSizeDp", "Landroid/graphics/Rect;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Rect;", "surroundingTextPadding", BdhLogUtil.LogTag.Tag_Conn, "surroundTextColors", "D", "surroundingTextSizeDp", "E", "Ljava/lang/String;", "surroundingText", "I", "centerBarrageViewOffset", "G", "H", "Z", "J", "Lkotlin/Lazy;", "N0", "()Landroid/animation/ValueAnimator;", "animator", "Lkotlin/Function0;", "K", "Lkotlin/jvm/functions/Function0;", "P0", "()Lkotlin/jvm/functions/Function0;", "setOnBarrageViewSlideOut", "(Lkotlin/jvm/functions/Function0;)V", "onBarrageViewSlideOut", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "L", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GradientBarrageLayout extends ConstraintLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<String> surroundTextColors;

    /* renamed from: D, reason: from kotlin metadata */
    private float surroundingTextSizeDp;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String surroundingText;

    /* renamed from: F, reason: from kotlin metadata */
    private int centerBarrageViewOffset;

    /* renamed from: G, reason: from kotlin metadata */
    private float topBarrageViewOffset;

    /* renamed from: H, reason: from kotlin metadata */
    private float bottomBarrageViewOffset;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean singleLine;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy animator;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onBarrageViewSlideOut;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GradientBarrageView centerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GradientBarrageView centerRightView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GradientBarrageView> bottomBarrageViews;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GradientBarrageView> topBarrageViews;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float textSizeDp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect surroundingTextPadding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/barrage/GradientBarrageLayout$a;", "", "", "TAG", "Ljava/lang/String;", "", "TYPE_COLORFUL", "I", "TYPE_NORMAL", "TYPE_TWO_COLOR", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.barrage.GradientBarrageLayout$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21867);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientBarrageLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this, (Object) context);
    }

    private final GradientBarrageView G0(int id5, ConstraintLayout.LayoutParams lp5) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GradientBarrageView gradientBarrageView = new GradientBarrageView(context, null, 2, null);
        gradientBarrageView.setId(id5);
        addView(gradientBarrageView, lp5);
        return gradientBarrageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ValueAnimator I0() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, getWidth());
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.qqlive.widget.barrage.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GradientBarrageLayout.J0(GradientBarrageLayout.this, valueAnimator);
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.tencent.mobileqq.qqlive.widget.barrage.GradientBarrageLayout$createAnimator$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GradientBarrageLayout.this);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                } else {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                GradientBarrageView gradientBarrageView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                    return;
                }
                Intrinsics.checkNotNullParameter(animation, "animation");
                gradientBarrageView = GradientBarrageLayout.this.centerView;
                gradientBarrageView.setVisibility(4);
                GradientBarrageLayout.this.M0(GradientBarrageLayout$createAnimator$1$2$onAnimationEnd$1.INSTANCE);
                Function0<Unit> P0 = GradientBarrageLayout.this.P0();
                if (P0 != null) {
                    P0.invoke();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
                } else {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animation) {
                GradientBarrageView gradientBarrageView;
                GradientBarrageView gradientBarrageView2;
                GradientBarrageView gradientBarrageView3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                    return;
                }
                Intrinsics.checkNotNullParameter(animation, "animation");
                gradientBarrageView = GradientBarrageLayout.this.centerView;
                gradientBarrageView.setVisibility(0);
                GradientBarrageLayout.this.M0(GradientBarrageLayout$createAnimator$1$2$onAnimationStart$1.INSTANCE);
                GradientBarrageLayout gradientBarrageLayout = GradientBarrageLayout.this;
                int width = gradientBarrageLayout.getWidth();
                gradientBarrageView2 = GradientBarrageLayout.this.centerView;
                int width2 = (width - gradientBarrageView2.getWidth()) / 2;
                gradientBarrageView3 = GradientBarrageLayout.this.centerView;
                gradientBarrageLayout.centerBarrageViewOffset = width2 + gradientBarrageView3.getWidth();
                GradientBarrageLayout.this.setVisibility(0);
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(GradientBarrageLayout this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(valueAnimator.getAnimatedValue(), "null cannot be cast to non-null type kotlin.Int");
        this$0.U0((-((Integer) r2).intValue()) + this$0.centerBarrageViewOffset);
    }

    private final void K0() {
        ConstraintLayout.LayoutParams Q0 = Q0();
        Q0.startToEnd = R.id.vrs;
        Q0.topToTop = R.id.vrs;
        Q0.bottomToBottom = R.id.vrs;
        Unit unit = Unit.INSTANCE;
        this.centerRightView = G0(R.id.vrr, Q0);
        this.topBarrageViews.clear();
        List<GradientBarrageView> list = this.topBarrageViews;
        ConstraintLayout.LayoutParams Q02 = Q0();
        Q02.startToStart = R.id.vrs;
        Q02.bottomToTop = this.centerView.getId();
        list.add(G0(R.id.vru, Q02));
        List<GradientBarrageView> list2 = this.topBarrageViews;
        ConstraintLayout.LayoutParams Q03 = Q0();
        Q03.startToEnd = R.id.vru;
        Q03.topToTop = R.id.vru;
        list2.add(G0(R.id.vrt, Q03));
        List<GradientBarrageView> list3 = this.topBarrageViews;
        ConstraintLayout.LayoutParams Q04 = Q0();
        Q04.startToEnd = R.id.vrt;
        Q04.topToTop = R.id.vrt;
        list3.add(G0(R.id.vrv, Q04));
        Iterator<T> it = this.topBarrageViews.iterator();
        while (it.hasNext()) {
            ((GradientBarrageView) it.next()).setTranslationX(this.topBarrageViewOffset);
        }
        this.bottomBarrageViews.clear();
        List<GradientBarrageView> list4 = this.bottomBarrageViews;
        ConstraintLayout.LayoutParams Q05 = Q0();
        Q05.startToStart = R.id.vrs;
        Q05.topToBottom = this.centerView.getId();
        Unit unit2 = Unit.INSTANCE;
        list4.add(G0(R.id.vro, Q05));
        List<GradientBarrageView> list5 = this.bottomBarrageViews;
        ConstraintLayout.LayoutParams Q06 = Q0();
        Q06.startToEnd = R.id.vro;
        Q06.topToTop = R.id.vro;
        list5.add(G0(R.id.vrn, Q06));
        List<GradientBarrageView> list6 = this.bottomBarrageViews;
        ConstraintLayout.LayoutParams Q07 = Q0();
        Q07.startToEnd = R.id.vrn;
        Q07.topToTop = R.id.vrn;
        list6.add(G0(R.id.vrp, Q07));
        Iterator<T> it5 = this.bottomBarrageViews.iterator();
        while (it5.hasNext()) {
            ((GradientBarrageView) it5.next()).setTranslationX(this.bottomBarrageViewOffset);
        }
        Rect rect = this.surroundingTextPadding;
        setSurroundingTextPadding(rect.left, rect.top, rect.right, rect.bottom);
        setSurroundTextSizeDp(this.surroundingTextSizeDp);
        setSurroundTextColor(this.surroundTextColors);
        setSurroundText(this.surroundingText);
        setSurroundingTextOffset(this.topBarrageViewOffset, this.bottomBarrageViewOffset);
        requestLayout();
    }

    private final void L0() {
        M0(new Function1<GradientBarrageView, Unit>() { // from class: com.tencent.mobileqq.qqlive.widget.barrage.GradientBarrageLayout$enableSingleLine$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GradientBarrageLayout.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GradientBarrageView gradientBarrageView) {
                invoke2(gradientBarrageView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GradientBarrageView it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GradientBarrageLayout.this.removeView(it);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(Function1<? super GradientBarrageView, Unit> action) {
        GradientBarrageView gradientBarrageView = this.centerRightView;
        if (gradientBarrageView != null) {
            action.invoke(gradientBarrageView);
        }
        Iterator<T> it = this.topBarrageViews.iterator();
        while (it.hasNext()) {
            action.invoke((GradientBarrageView) it.next());
        }
        Iterator<T> it5 = this.bottomBarrageViews.iterator();
        while (it5.hasNext()) {
            action.invoke((GradientBarrageView) it5.next());
        }
    }

    private final ValueAnimator N0() {
        Object value = this.animator.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-animator>(...)");
        return (ValueAnimator) value;
    }

    private final long O0(int type, int contentLength) {
        int i3;
        if (type != 1) {
            if (type != 2) {
                i3 = 8000;
            } else {
                i3 = 7000;
            }
        } else {
            i3 = 6000;
        }
        float f16 = i3;
        return f16 + (((1.0f * f16) / getWidth()) * contentLength);
    }

    private final ConstraintLayout.LayoutParams Q0() {
        return new ConstraintLayout.LayoutParams(-2, -2);
    }

    private final String R0(String str, String str2) {
        int coerceAtLeast;
        StringBuilder sb5 = new StringBuilder();
        sb5.append('#');
        sb5.append(str2);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, str.length() - 6);
        String substring = str.substring(coerceAtLeast);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        sb5.append(substring);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(GradientBarrageLayout this$0, int i3) {
        int width;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.singleLine) {
            width = this$0.centerView.getWidth();
        } else {
            width = this$0.centerView.getWidth() * 2;
        }
        long O0 = this$0.O0(i3, width);
        ValueAnimator N0 = this$0.N0();
        N0.setDuration(O0);
        N0.setIntValues(0, this$0.getWidth() + width);
        this$0.N0().start();
        AegisLogger.INSTANCE.i("unknown|GradientBarrageLayout", "type:" + i3 + ", width:" + this$0.getWidth() + ", centerViewWidth:" + this$0.centerView.getWidth() + ", duration:" + O0);
    }

    private final void U0(float centerViewOffset) {
        this.centerView.setTranslationX(centerViewOffset);
        GradientBarrageView gradientBarrageView = this.centerRightView;
        if (gradientBarrageView != null) {
            gradientBarrageView.setTranslationX(centerViewOffset);
        }
        Iterator<T> it = this.topBarrageViews.iterator();
        while (it.hasNext()) {
            ((GradientBarrageView) it.next()).setTranslationX(1.2f * centerViewOffset);
        }
        Iterator<T> it5 = this.bottomBarrageViews.iterator();
        while (it5.hasNext()) {
            ((GradientBarrageView) it5.next()).setTranslationX(centerViewOffset * 1.2f);
        }
    }

    public final void H0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            N0().cancel();
        }
    }

    @Nullable
    public final Function0<Unit> P0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function0) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.onBarrageViewSlideOut;
    }

    public final void S0(final int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, type);
        } else {
            post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.barrage.b
                @Override // java.lang.Runnable
                public final void run() {
                    GradientBarrageLayout.T0(GradientBarrageLayout.this, type);
                }
            });
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(w3), Integer.valueOf(h16), Integer.valueOf(oldw), Integer.valueOf(oldh));
        } else {
            super.onSizeChanged(w3, h16, oldw, oldh);
        }
    }

    public final void setColors(@NotNull List<String> textColors, @NotNull List<String> borderColors, @NotNull List<String> backgroundColors) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, textColors, borderColors, backgroundColors);
            return;
        }
        Intrinsics.checkNotNullParameter(textColors, "textColors");
        Intrinsics.checkNotNullParameter(borderColors, "borderColors");
        Intrinsics.checkNotNullParameter(backgroundColors, "backgroundColors");
        GradientBarrageView gradientBarrageView = this.centerView;
        GradientBarrageView.setTextColor$default(gradientBarrageView, textColors, null, 2, null);
        GradientBarrageView.setBorderColor$default(gradientBarrageView, borderColors, null, 2, null);
        GradientBarrageView.setBackgroundColor$default(gradientBarrageView, backgroundColors, null, 2, null);
    }

    public final void setOnBarrageViewSlideOut(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) function0);
        } else {
            this.onBarrageViewSlideOut = function0;
        }
    }

    public final void setSingleLine(boolean singleLine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, singleLine);
            return;
        }
        if (this.singleLine == singleLine) {
            return;
        }
        this.singleLine = singleLine;
        if (singleLine) {
            L0();
        } else {
            K0();
        }
    }

    public final void setStartIcon(@NotNull Drawable drawable, int margin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) drawable, margin);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.centerView.setCompoundDrawablePadding(margin);
    }

    public final void setSurroundText(@NotNull String text) {
        int coerceAtLeast;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) text);
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        this.surroundingText = text;
        Iterator<T> it = this.topBarrageViews.iterator();
        while (it.hasNext()) {
            ((GradientBarrageView) it.next()).setText(text);
        }
        Iterator<T> it5 = this.bottomBarrageViews.iterator();
        while (it5.hasNext()) {
            ((GradientBarrageView) it5.next()).setText(text);
        }
        GradientBarrageView gradientBarrageView = this.centerRightView;
        if (gradientBarrageView != null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, text.length() - 8);
            String substring = text.substring(coerceAtLeast);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            gradientBarrageView.setText(substring);
        }
    }

    public final void setSurroundTextColor(@NotNull List<String> textColors) {
        List mutableList;
        Object orNull;
        Object orNull2;
        String R0;
        String R02;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) textColors);
            return;
        }
        Intrinsics.checkNotNullParameter(textColors, "textColors");
        this.surroundTextColors = textColors;
        Iterator<T> it = this.topBarrageViews.iterator();
        while (it.hasNext()) {
            GradientBarrageView.setTextColor$default((GradientBarrageView) it.next(), textColors, null, 2, null);
        }
        Iterator<T> it5 = this.bottomBarrageViews.iterator();
        while (it5.hasNext()) {
            GradientBarrageView.setTextColor$default((GradientBarrageView) it5.next(), textColors, null, 2, null);
        }
        GradientBarrageView gradientBarrageView = this.centerRightView;
        if (gradientBarrageView != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) textColors);
            orNull = CollectionsKt___CollectionsKt.getOrNull(textColors, 0);
            String str = (String) orNull;
            if (str != null && (R02 = R0(str, "00")) != null) {
            }
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(textColors, 1);
            String str2 = (String) orNull2;
            if (str2 != null && (R0 = R0(str2, "80")) != null) {
                mutableList.set(1, R0);
            }
            GradientBarrageView.setTextColor$default(gradientBarrageView, mutableList, null, 2, null);
        }
    }

    public final void setSurroundTextSizeDp(float textSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(textSize));
        } else {
            this.surroundingTextSizeDp = textSize;
            M0(new Function1<GradientBarrageView, Unit>() { // from class: com.tencent.mobileqq.qqlive.widget.barrage.GradientBarrageLayout$setSurroundTextSizeDp$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GradientBarrageLayout.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GradientBarrageView gradientBarrageView) {
                    invoke2(gradientBarrageView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GradientBarrageView it) {
                    float f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    f16 = GradientBarrageLayout.this.surroundingTextSizeDp;
                    it.setTextSize(1, f16);
                }
            });
        }
    }

    public final void setSurroundingTextOffset(float topBarrageViewOffset, float bottomBarrageViewOffset) {
        Object firstOrNull;
        Object firstOrNull2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(topBarrageViewOffset), Float.valueOf(bottomBarrageViewOffset));
            return;
        }
        this.topBarrageViewOffset = topBarrageViewOffset;
        this.bottomBarrageViewOffset = bottomBarrageViewOffset;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.topBarrageViews);
        GradientBarrageView gradientBarrageView = (GradientBarrageView) firstOrNull;
        if (gradientBarrageView != null) {
            gradientBarrageView.setTranslationX(topBarrageViewOffset);
        }
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.bottomBarrageViews);
        GradientBarrageView gradientBarrageView2 = (GradientBarrageView) firstOrNull2;
        if (gradientBarrageView2 != null) {
            gradientBarrageView2.setTranslationX(bottomBarrageViewOffset);
        }
    }

    public final void setSurroundingTextPadding(final int left, final int top, final int right, final int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
        } else {
            this.surroundingTextPadding.set(left, top, right, bottom);
            M0(new Function1<GradientBarrageView, Unit>(left, top, right, bottom) { // from class: com.tencent.mobileqq.qqlive.widget.barrage.GradientBarrageLayout$setSurroundingTextPadding$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $bottom;
                final /* synthetic */ int $left;
                final /* synthetic */ int $right;
                final /* synthetic */ int $top;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$left = left;
                    this.$top = top;
                    this.$right = right;
                    this.$bottom = bottom;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GradientBarrageView gradientBarrageView) {
                    invoke2(gradientBarrageView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GradientBarrageView it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.setPadding(this.$left, this.$top, this.$right, this.$bottom);
                    }
                }
            });
        }
    }

    public final void setText(@NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) text);
        } else {
            Intrinsics.checkNotNullParameter(text, "text");
            this.centerView.setText(text);
        }
    }

    public final void setTextOffset(int offset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, offset);
        } else {
            this.centerBarrageViewOffset = offset;
            this.centerView.setTranslationX(offset);
        }
    }

    public final void setTextPadding(int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
        } else {
            this.centerView.setPadding(left, top, right, bottom);
        }
    }

    public final void setTextSizeDp(float textSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(textSize));
        } else {
            this.textSizeDp = textSize;
            this.centerView.setTextSize(1, textSize);
        }
    }

    public /* synthetic */ GradientBarrageLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GradientBarrageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        List<String> emptyList;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.bottomBarrageViews = new ArrayList();
        this.topBarrageViews = new ArrayList();
        this.textSizeDp = 16.0f;
        this.surroundingTextPadding = new Rect();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.surroundTextColors = emptyList;
        this.surroundingText = "";
        this.singleLine = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ValueAnimator>() { // from class: com.tencent.mobileqq.qqlive.widget.barrage.GradientBarrageLayout$animator$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GradientBarrageLayout.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ValueAnimator invoke() {
                ValueAnimator I0;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ValueAnimator) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                I0 = GradientBarrageLayout.this.I0();
                return I0;
            }
        });
        this.animator = lazy;
        ConstraintLayout.LayoutParams Q0 = Q0();
        Q0.topToTop = 0;
        Q0.bottomToBottom = 0;
        Q0.startToStart = 0;
        Q0.endToEnd = 0;
        Unit unit = Unit.INSTANCE;
        this.centerView = G0(R.id.vrs, Q0);
    }
}
