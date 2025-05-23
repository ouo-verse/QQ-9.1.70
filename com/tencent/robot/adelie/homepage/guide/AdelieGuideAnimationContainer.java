package com.tencent.robot.adelie.homepage.guide;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqnt.kernel.nativeinterface.RobotGuideInfo;
import com.tencent.robot.adelie.homepage.category.view.AdelieGuideContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B7\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020$\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nJ\u001c\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\nR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&\u00a8\u00061"}, d2 = {"Lcom/tencent/robot/adelie/homepage/guide/AdelieGuideAnimationContainer;", "Landroid/widget/LinearLayout;", "", "k", "l", "Landroid/graphics/Bitmap;", "bgBitmap", "i", "Landroid/animation/ValueAnimator;", "adelieGuideAnimator", "Lkotlin/Function0;", "onComplete", "j", "onAnimationEnd", "g", "Landroid/content/Context;", "d", "Landroid/content/Context;", "ctx", "Landroid/graphics/Rect;", "e", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "robotGuideInfo", "Landroidx/constraintlayout/widget/ConstraintLayout;", h.F, "Landroidx/constraintlayout/widget/ConstraintLayout;", "adelieGuideMask", "adelieGuideExpand", "Lcom/tencent/robot/adelie/homepage/category/view/AdelieGuideContainer;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/adelie/homepage/category/view/AdelieGuideContainer;", "adelieGuideContainer", "", BdhLogUtil.LogTag.Tag_Conn, "I", "screenWidth", "D", "screenHeight", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/graphics/Rect;Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;Landroid/util/AttributeSet;I)V", "E", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes25.dex */
public final class AdelieGuideAnimationContainer extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int screenWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private int screenHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context ctx;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect rect;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotGuideInfo robotGuideInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConstraintLayout adelieGuideMask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ConstraintLayout adelieGuideExpand;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieGuideContainer adelieGuideContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/adelie/homepage/guide/AdelieGuideAnimationContainer$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            ConstraintLayout constraintLayout = AdelieGuideAnimationContainer.this.adelieGuideExpand;
            if (constraintLayout != null) {
                constraintLayout.setClipBounds(AdelieGuideAnimationContainer.this.rect);
            }
            ConstraintLayout constraintLayout2 = AdelieGuideAnimationContainer.this.adelieGuideExpand;
            if (constraintLayout2 != null && (viewTreeObserver = constraintLayout2.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/adelie/homepage/guide/AdelieGuideAnimationContainer$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewGroup.LayoutParams layoutParams;
            ViewTreeObserver viewTreeObserver;
            AdelieGuideContainer adelieGuideContainer = AdelieGuideAnimationContainer.this.adelieGuideContainer;
            if (adelieGuideContainer != null) {
                layoutParams = adelieGuideContainer.getLayoutParams();
            } else {
                layoutParams = null;
            }
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = AdelieGuideAnimationContainer.this.rect.top;
            AdelieGuideContainer adelieGuideContainer2 = AdelieGuideAnimationContainer.this.adelieGuideContainer;
            if (adelieGuideContainer2 != null) {
                adelieGuideContainer2.setLayoutParams(layoutParams2);
            }
            AdelieGuideContainer adelieGuideContainer3 = AdelieGuideAnimationContainer.this.adelieGuideContainer;
            if (adelieGuideContainer3 != null) {
                AdelieGuideContainer.c(adelieGuideContainer3, AdelieGuideAnimationContainer.this.rect, null, 2, null);
            }
            AdelieGuideContainer adelieGuideContainer4 = AdelieGuideAnimationContainer.this.adelieGuideContainer;
            if (adelieGuideContainer4 != null && (viewTreeObserver = adelieGuideContainer4.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    public /* synthetic */ AdelieGuideAnimationContainer(Context context, Rect rect, RobotGuideInfo robotGuideInfo, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, rect, robotGuideInfo, (i16 & 8) != 0 ? null : attributeSet, (i16 & 16) != 0 ? 0 : i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ValueAnimator adelieGuideAnimator, AdelieGuideAnimationContainer this$0, Function0 onAnimationEnd, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(adelieGuideAnimator, "$adelieGuideAnimator");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onAnimationEnd, "$onAnimationEnd");
        Object animatedValue = adelieGuideAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        int a16 = this$0.rect.top + c24.a.a(10);
        Rect rect = this$0.rect;
        int i3 = rect.left;
        Rect rect2 = new Rect((int) (i3 + ((-i3) * floatValue)), (int) (a16 + ((-a16) * floatValue)), (int) (rect.right + ((this$0.screenWidth - r3) * floatValue)), (int) (rect.bottom + ((this$0.screenHeight - r1) * floatValue)));
        ConstraintLayout constraintLayout = this$0.adelieGuideExpand;
        if (constraintLayout != null) {
            constraintLayout.setClipBounds(rect2);
        }
        AdelieGuideContainer adelieGuideContainer = this$0.adelieGuideContainer;
        if (adelieGuideContainer != null) {
            adelieGuideContainer.d(this$0.screenHeight, floatValue);
        }
        if (floatValue >= 1.0f) {
            onAnimationEnd.invoke();
        }
    }

    public final void g(@NotNull final ValueAnimator adelieGuideAnimator, @NotNull final Function0<Unit> onAnimationEnd) {
        Intrinsics.checkNotNullParameter(adelieGuideAnimator, "adelieGuideAnimator");
        Intrinsics.checkNotNullParameter(onAnimationEnd, "onAnimationEnd");
        adelieGuideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.adelie.homepage.guide.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AdelieGuideAnimationContainer.h(adelieGuideAnimator, this, onAnimationEnd, valueAnimator);
            }
        });
        adelieGuideAnimator.start();
    }

    public final void i(@NotNull Bitmap bgBitmap) {
        Intrinsics.checkNotNullParameter(bgBitmap, "bgBitmap");
        ConstraintLayout constraintLayout = this.adelieGuideExpand;
        if (constraintLayout != null) {
            constraintLayout.setBackground(new BitmapDrawable(getContext().getResources(), bgBitmap));
        }
    }

    public final void j(@NotNull final ValueAnimator adelieGuideAnimator, @NotNull final Function0<Unit> onComplete) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        ViewTreeObserver viewTreeObserver3;
        Intrinsics.checkNotNullParameter(adelieGuideAnimator, "adelieGuideAnimator");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        ConstraintLayout constraintLayout = this.adelieGuideExpand;
        if (constraintLayout != null && (viewTreeObserver3 = constraintLayout.getViewTreeObserver()) != null) {
            viewTreeObserver3.addOnGlobalLayoutListener(new b());
        }
        ConstraintLayout constraintLayout2 = this.adelieGuideMask;
        if (constraintLayout2 != null && (viewTreeObserver2 = constraintLayout2.getViewTreeObserver()) != null) {
            viewTreeObserver2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.robot.adelie.homepage.guide.AdelieGuideAnimationContainer$initAnimationViewLogic$2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    AdelieGuideAnimationContainer adelieGuideAnimationContainer = AdelieGuideAnimationContainer.this;
                    adelieGuideAnimationContainer.screenWidth = adelieGuideAnimationContainer.getWidth();
                    AdelieGuideAnimationContainer adelieGuideAnimationContainer2 = AdelieGuideAnimationContainer.this;
                    adelieGuideAnimationContainer2.screenHeight = adelieGuideAnimationContainer2.getHeight();
                    AdelieGuideAnimationContainer adelieGuideAnimationContainer3 = AdelieGuideAnimationContainer.this;
                    ValueAnimator valueAnimator = adelieGuideAnimator;
                    final Function0<Unit> function0 = onComplete;
                    adelieGuideAnimationContainer3.g(valueAnimator, new Function0<Unit>() { // from class: com.tencent.robot.adelie.homepage.guide.AdelieGuideAnimationContainer$initAnimationViewLogic$2$onGlobalLayout$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function0.invoke();
                        }
                    });
                    ViewTreeObserver viewTreeObserver4 = AdelieGuideAnimationContainer.this.getViewTreeObserver();
                    if (viewTreeObserver4 != null) {
                        viewTreeObserver4.removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
        AdelieGuideContainer adelieGuideContainer = this.adelieGuideContainer;
        if (adelieGuideContainer != null && (viewTreeObserver = adelieGuideContainer.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new c());
        }
    }

    public final void k() {
        LayoutInflater.from(this.ctx).inflate(R.layout.dsb, (ViewGroup) this, true);
        this.adelieGuideMask = (ConstraintLayout) findViewById(R.id.t28);
        this.adelieGuideExpand = (ConstraintLayout) findViewById(R.id.t29);
        AdelieGuideContainer adelieGuideContainer = (AdelieGuideContainer) findViewById(R.id.t27);
        this.adelieGuideContainer = adelieGuideContainer;
        if (adelieGuideContainer != null) {
            adelieGuideContainer.f(this.robotGuideInfo);
        }
    }

    public final void l() {
        ConstraintLayout constraintLayout = this.adelieGuideMask;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = this.adelieGuideExpand;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieGuideAnimationContainer(@NotNull Context ctx, @NotNull Rect rect, @NotNull RobotGuideInfo robotGuideInfo, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(robotGuideInfo, "robotGuideInfo");
        this.ctx = ctx;
        this.rect = rect;
        this.robotGuideInfo = robotGuideInfo;
        k();
    }
}
