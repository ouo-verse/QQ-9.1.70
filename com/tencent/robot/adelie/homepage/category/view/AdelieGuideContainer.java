package com.tencent.robot.adelie.homepage.category.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c24.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqnt.kernel.nativeinterface.RobotGuideInfo;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import java.util.ArrayList;
import java.util.List;
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
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u0001\u0006B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00102\u001a\u00020\u0016\u00a2\u0006\u0004\b3\u00104J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0003J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\u0005H\u0014J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0013J\u0016\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00066"}, d2 = {"Lcom/tencent/robot/adelie/homepage/category/view/AdelieGuideContainer;", "Landroid/widget/LinearLayout;", "", "", "texts", "", "a", "Landroid/view/View;", "view", "e", "Landroid/content/Context;", "context", "g", NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotGuideInfo;", "adelieGuideInfo", "f", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "Lkotlin/Function0;", "onAnimationEnd", "b", "", "screenHeight", "", "progress", "d", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "bannerRobotGuideContainer", "bannerRobotGuideImageContainer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "bannerRobotGuideText", h.F, "Landroid/widget/LinearLayout;", "bannerRobotGuideTextTabs", "Landroid/animation/ObjectAnimator;", "i", "Landroid/animation/ObjectAnimator;", "babyQImageAnimator", "Landroid/animation/AnimatorSet;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/animation/AnimatorSet;", "animatorSet", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Rect;", "viewRect", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieGuideContainer extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Rect viewRect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView bannerRobotGuideContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView bannerRobotGuideImageContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView bannerRobotGuideText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout bannerRobotGuideTextTabs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ObjectAnimator babyQImageAnimator;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnimatorSet animatorSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/adelie/homepage/category/view/AdelieGuideContainer$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f366036d;

        b(Function0<Unit> function0) {
            this.f366036d = function0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            super.onAnimationEnd(animation);
            Function0<Unit> function0 = this.f366036d;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieGuideContainer(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a(List<String> texts) {
        LinearLayout linearLayout = this.bannerRobotGuideTextTabs;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        int a16 = a.a(323);
        int size = texts.size();
        int size2 = texts.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size2; i16++) {
            TextView textView = new TextView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(a.a(8), a.a(2), a.a(8), a.a(2));
            textView.setLayoutParams(layoutParams);
            textView.setText(texts.get(i16));
            textView.setTextColor(-1);
            textView.setTextSize(10.0f);
            textView.measure(0, 0);
            i3 += textView.getMeasuredWidth();
            if (i3 <= a16) {
                LinearLayout linearLayout2 = this.bannerRobotGuideTextTabs;
                if (linearLayout2 != null) {
                    linearLayout2.addView(textView);
                }
                if (i16 < size - 1 && i3 + 0.6d <= a16) {
                    View view = new View(getContext());
                    view.setLayoutParams(new LinearLayout.LayoutParams(a.a(1), a.a(16)));
                    view.setBackgroundColor(1728053247);
                    LinearLayout linearLayout3 = this.bannerRobotGuideTextTabs;
                    if (linearLayout3 != null) {
                        linearLayout3.addView(view);
                    }
                    i3 += a.a(1);
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(AdelieGuideContainer adelieGuideContainer, Rect rect, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        adelieGuideContainer.b(rect, function0);
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    private final void e(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c.f123400v, 1.0f, 0.0f);
        this.babyQImageAnimator = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(300L);
        }
        this.animatorSet.playTogether(this.babyQImageAnimator);
    }

    public final void b(@NotNull Rect rect, @Nullable Function0<Unit> onAnimationEnd) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        ImageView imageView = this.bannerRobotGuideImageContainer;
        if (imageView != null) {
            e(imageView);
        }
        ImageView imageView2 = this.bannerRobotGuideContainer;
        if (imageView2 != null) {
            e(imageView2);
        }
        this.viewRect = rect;
        this.animatorSet.addListener(new b(onAnimationEnd));
        this.animatorSet.start();
    }

    public final void d(int screenHeight, float progress) {
        if (this.viewRect != null) {
            float f16 = (screenHeight - r0.bottom) * progress;
            TextView textView = this.bannerRobotGuideText;
            if (textView != null) {
                textView.setTranslationY(f16);
            }
            LinearLayout linearLayout = this.bannerRobotGuideTextTabs;
            if (linearLayout != null) {
                linearLayout.setTranslationY(f16);
            }
            TextView textView2 = this.bannerRobotGuideText;
            if (textView2 != null) {
                textView2.setAlpha(1.0f - progress);
            }
            LinearLayout linearLayout2 = this.bannerRobotGuideTextTabs;
            if (linearLayout2 != null) {
                linearLayout2.setAlpha(1.0f - progress);
            }
        }
    }

    public final void f(@NotNull RobotGuideInfo adelieGuideInfo) {
        Intrinsics.checkNotNullParameter(adelieGuideInfo, "adelieGuideInfo");
        ImageView imageView = this.bannerRobotGuideContainer;
        if (imageView != null) {
            CommonExKt.h(imageView, adelieGuideInfo.bannerBg, null, null, null, 14, null);
        }
        ImageView imageView2 = this.bannerRobotGuideImageContainer;
        if (imageView2 != null) {
            CommonExKt.h(imageView2, adelieGuideInfo.robotUrl, null, null, null, 14, null);
        }
        TextView textView = this.bannerRobotGuideText;
        if (textView != null) {
            textView.setText(adelieGuideInfo.title);
        }
        ArrayList<String> arrayList = adelieGuideInfo.features;
        Intrinsics.checkNotNullExpressionValue(arrayList, "adelieGuideInfo.features");
        a(arrayList);
    }

    public final void g(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.dsc, (ViewGroup) this, true);
        this.bannerRobotGuideContainer = (ImageView) findViewById(R.id.t2a);
        this.bannerRobotGuideImageContainer = (ImageView) findViewById(R.id.t2_);
        this.bannerRobotGuideText = (TextView) findViewById(R.id.xrk);
        this.bannerRobotGuideTextTabs = (LinearLayout) findViewById(R.id.f919656l);
        FontSettingManager.resetViewSize2Normal(context, this.bannerRobotGuideText);
        FontSettingManager.resetViewSize2Normal(context, this.bannerRobotGuideTextTabs);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.animatorSet.removeAllListeners();
        this.animatorSet.cancel();
        ObjectAnimator objectAnimator = this.babyQImageAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.babyQImageAnimator = null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieGuideContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieGuideContainer(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieGuideContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.animatorSet = new AnimatorSet();
        g(context);
    }
}
