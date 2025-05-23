package com.tencent.mobileqq.guild.feed.nativepublish.viewbinding;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u0017\u0010!\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R\u0017\u0010$\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R\u001b\u0010(\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0014R\u001b\u0010+\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010\u0014R\u0017\u00101\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b3\u0010\u0014R*\u0010=\u001a\u0002052\u0006\u00106\u001a\u0002058\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010A\u001a\u00020>8F\u00a2\u0006\u0006\u001a\u0004\b?\u0010@\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding;", "Landroidx/viewbinding/ViewBinding;", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "B", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "a", "Landroid/widget/FrameLayout;", "root", "b", "Landroid/view/View;", DomainData.DOMAIN_NAME, "()Landroid/view/View;", "anchorView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "c", "Landroidx/constraintlayout/widget/ConstraintLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroidx/constraintlayout/widget/ConstraintLayout;", "constraintFixFrame", "d", "y", "whiteSheetTopGuideLine", "e", "o", "bottomGuideLine", "f", "w", "whiteSheetBackground", "g", "Lkotlin/Lazy;", "v", "transparentBlackBackground", h.F, "r", "firstLayerConstraintLayout", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "p", "()Landroid/widget/LinearLayout;", "bottomLinearLayout", "j", "u", "panelContainer", "", "value", "k", "Z", "getHasTitleAboveFirstLayer", "()Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Z)V", "hasTitleAboveFirstLayer", "", "t", "()I", "guideLineBottomToFirstLayerTopMarginDynamic", "<init>", "(Landroid/content/Context;)V", "l", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SimplifiedFeedEditorViewBinding implements ViewBinding {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final int f222355m = View.generateViewId();

    /* renamed from: n, reason: collision with root package name */
    private static final int f222356n = View.generateViewId();

    /* renamed from: o, reason: collision with root package name */
    private static final int f222357o = View.generateViewId();

    /* renamed from: p, reason: collision with root package name */
    private static final int f222358p = View.generateViewId();

    /* renamed from: q, reason: collision with root package name */
    private static final int f222359q = View.generateViewId();

    /* renamed from: r, reason: collision with root package name */
    private static final int f222360r = R.id.wcw;

    /* renamed from: s, reason: collision with root package name */
    private static final int f222361s = View.generateViewId();

    /* renamed from: t, reason: collision with root package name */
    private static final int f222362t = View.generateViewId();

    /* renamed from: u, reason: collision with root package name */
    private static final int f222363u = View.generateViewId();

    /* renamed from: v, reason: collision with root package name */
    private static final int f222364v = View.generateViewId();

    /* renamed from: w, reason: collision with root package name */
    private static final int f222365w = View.generateViewId();

    /* renamed from: x, reason: collision with root package name */
    private static final int f222366x = View.generateViewId();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout root;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View anchorView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConstraintLayout constraintFixFrame;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View whiteSheetTopGuideLine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View bottomGuideLine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View whiteSheetBackground;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy transparentBlackBackground;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy firstLayerConstraintLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout bottomLinearLayout;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy panelContainer;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean hasTitleAboveFirstLayer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u0011\u0010\u001a\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0006R\u0011\u0010 \u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0006R\u0011\u0010\"\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0006R\u0011\u0010$\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0006R\u0011\u0010(\u001a\u00020%8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/viewbinding/SimplifiedFeedEditorViewBinding$a;", "", "", "firstLayerRootViewId", "I", "b", "()I", "inputAreaViewId", "e", "inputEditTextViewId", "f", "mediaLayerViewId", "g", "rootBackgroundViewId", "i", "panelContainerViewId", h.F, "titleBarViewId", "j", "k", "titleHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "titleTopToGuideLineMargin", "", "o", "()F", "whiteSheetBackgroundRadius", "p", "whiteSheetGuideLineBottomToFirstLayerTopMargin", DomainData.DOMAIN_NAME, "topPadding", "a", "bottomPreservePadding", "c", "functionBarHeight", "d", "grayFrameBottomToBottomLinearLayoutTopMarginWhenMediaAreaGone", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "l", "()Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "titleLayoutParamInHalfScreen", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ViewUtils.getScreenHeight() / 2;
        }

        public final int b() {
            return SimplifiedFeedEditorViewBinding.f222358p;
        }

        public final int c() {
            return ViewUtils.dpToPx(49.0f);
        }

        public final int d() {
            return ViewUtils.dpToPx(16.0f);
        }

        public final int e() {
            return SimplifiedFeedEditorViewBinding.f222359q;
        }

        public final int f() {
            return SimplifiedFeedEditorViewBinding.f222360r;
        }

        public final int g() {
            return SimplifiedFeedEditorViewBinding.f222361s;
        }

        public final int h() {
            return SimplifiedFeedEditorViewBinding.f222364v;
        }

        public final int i() {
            return SimplifiedFeedEditorViewBinding.f222363u;
        }

        public final int j() {
            return SimplifiedFeedEditorViewBinding.f222365w;
        }

        public final int k() {
            return ViewUtils.dpToPx(44.0f);
        }

        @NotNull
        public final ConstraintLayout.LayoutParams l() {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, k());
            layoutParams.bottomToTop = SimplifiedFeedEditorViewBinding.INSTANCE.b();
            return layoutParams;
        }

        public final int m() {
            return ViewUtils.dpToPx(8.0f);
        }

        public final int n() {
            return RFWImmersiveUtils.getStatusBarHeight();
        }

        public final float o() {
            return ViewUtils.getDensity() * 12.0f;
        }

        public final int p() {
            return ViewUtils.dpToPx(16.0f);
        }

        Companion() {
        }
    }

    public SimplifiedFeedEditorViewBinding(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(f222355m);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setClipChildren(false);
        this.root = frameLayout;
        View view = new View(context);
        view.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 80;
        view.setLayoutParams(layoutParams);
        this.anchorView = view;
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.constraintFixFrame = constraintLayout;
        View view2 = new View(context);
        int i3 = f222362t;
        view2.setId(i3);
        view2.setVisibility(4);
        view2.setLayoutParams(z());
        this.whiteSheetTopGuideLine = view2;
        View view3 = new View(context);
        int i16 = f222366x;
        view3.setId(i16);
        view3.setVisibility(4);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(500, 1);
        layoutParams2.topToBottom = 0;
        Companion companion = INSTANCE;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = companion.a();
        layoutParams2.leftToLeft = 0;
        layoutParams2.rightToRight = 0;
        view3.setLayoutParams(layoutParams2);
        this.bottomGuideLine = view3;
        View view4 = new View(context);
        view4.setId(f222356n);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(context.getColorStateList(R.color.qui_common_bg_bottom_light));
        gradientDrawable.setShape(0);
        float o16 = companion.o();
        gradientDrawable.setCornerRadii(new float[]{o16, o16, o16, o16, 0.0f, 0.0f, 0.0f, 0.0f});
        view4.setBackground(gradientDrawable);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-1, 0);
        layoutParams3.topToBottom = i3;
        int i17 = f222357o;
        layoutParams3.bottomToBottom = i17;
        view4.setLayoutParams(layoutParams3);
        this.whiteSheetBackground = view4;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding$transparentBlackBackground$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                FrameLayout frameLayout2;
                frameLayout2 = SimplifiedFeedEditorViewBinding.this.root;
                return frameLayout2.findViewById(SimplifiedFeedEditorViewBinding.INSTANCE.i());
            }
        });
        this.transparentBlackBackground = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding$firstLayerConstraintLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return SimplifiedFeedEditorViewBinding.this.getConstraintFixFrame().findViewById(SimplifiedFeedEditorViewBinding.INSTANCE.b());
            }
        });
        this.firstLayerConstraintLayout = lazy2;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(i17);
        linearLayout.setOrientation(1);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams4.bottomToTop = i16;
        linearLayout.setLayoutParams(layoutParams4);
        this.bottomLinearLayout = linearLayout;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.viewbinding.SimplifiedFeedEditorViewBinding$panelContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return SimplifiedFeedEditorViewBinding.this.getBottomLinearLayout().findViewById(SimplifiedFeedEditorViewBinding.INSTANCE.h());
            }
        });
        this.panelContainer = lazy3;
        constraintLayout.addView(view2);
        constraintLayout.addView(view3);
        constraintLayout.addView(view4);
        frameLayout.addView(view);
    }

    private final View r() {
        Object value = this.firstLayerConstraintLayout.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-firstLayerConstraintLayout>(...)");
        return (View) value;
    }

    private final ConstraintLayout.LayoutParams s() {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams.bottomToTop = f222357o;
        return layoutParams;
    }

    private final ConstraintLayout.LayoutParams z() {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, 1);
        layoutParams.bottomToTop = f222358p;
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = t();
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        return layoutParams;
    }

    public final void A(boolean z16) {
        if (this.hasTitleAboveFirstLayer != z16) {
            this.hasTitleAboveFirstLayer = z16;
            this.whiteSheetTopGuideLine.setLayoutParams(z());
        } else {
            this.hasTitleAboveFirstLayer = z16;
        }
    }

    public final void B() {
        View r16 = r();
        ViewGroup.LayoutParams layoutParams = r16.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.topToTop = 0;
            Companion companion = INSTANCE;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = companion.n() + companion.k();
            layoutParams2.bottomToTop = f222357o;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
            r16.setLayoutParams(layoutParams2);
            View view = this.whiteSheetTopGuideLine;
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            if (layoutParams3 != null) {
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                layoutParams4.bottomToTop = -1;
                layoutParams4.topToTop = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = 0;
                ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = 0;
                view.setLayoutParams(layoutParams4);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void C() {
        r().setLayoutParams(s());
        this.whiteSheetTopGuideLine.setLayoutParams(z());
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        return this.root;
    }

    @NotNull
    public final View m(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setId(f222358p);
        constraintLayout.setLayoutParams(s());
        return constraintLayout;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final View getAnchorView() {
        return this.anchorView;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final View getBottomGuideLine() {
        return this.bottomGuideLine;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final LinearLayout getBottomLinearLayout() {
        return this.bottomLinearLayout;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final ConstraintLayout getConstraintFixFrame() {
        return this.constraintFixFrame;
    }

    public final int t() {
        if (this.hasTitleAboveFirstLayer) {
            Companion companion = INSTANCE;
            return companion.m() + companion.k();
        }
        return INSTANCE.p();
    }

    @NotNull
    public final View u() {
        Object value = this.panelContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-panelContainer>(...)");
        return (View) value;
    }

    @NotNull
    public final View v() {
        Object value = this.transparentBlackBackground.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-transparentBlackBackground>(...)");
        return (View) value;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final View getWhiteSheetBackground() {
        return this.whiteSheetBackground;
    }

    @NotNull
    /* renamed from: y, reason: from getter */
    public final View getWhiteSheetTopGuideLine() {
        return this.whiteSheetTopGuideLine;
    }
}
