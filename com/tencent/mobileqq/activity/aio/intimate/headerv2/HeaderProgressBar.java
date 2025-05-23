package com.tencent.mobileqq.activity.aio.intimate.headerv2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001IB\u0011\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BB\u0019\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010D\u001a\u00020C\u00a2\u0006\u0004\bA\u0010EB!\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010D\u001a\u00020C\u0012\u0006\u0010F\u001a\u00020\n\u00a2\u0006\u0004\bA\u0010GJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0084\u0001\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00112\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u00142\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0013j\b\u0012\u0004\u0012\u00020\u000e`\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0017J\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u001b\u001a\u00020\u0004R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001eR\u0016\u0010%\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0016\u0010'\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001eR\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001eR\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00106R$\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0013j\b\u0012\u0004\u0012\u00020\u0002`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R$\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0013j\b\u0012\u0004\u0012\u00020\u000e`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010=\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/HeaderProgressBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "progress", "", "Q0", "W0", "oldRate", "T0", "O0", "", "type", "setType", "aniType", "", "iconUrl", "progressBottomColor", "Lkotlin/Pair;", "progressRateColor", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "rateArray", "iconUrlArray", "", "needShowProcessBar", "setData", "S0", "N0", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "ivThumb", "e", "ivSolid", "f", "ivRateSolid", tl.h.F, "ivDot1", "i", "ivDot2", "Lcom/airbnb/lottie/LottieAnimationView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/airbnb/lottie/LottieAnimationView;", "mLottieView", BdhLogUtil.LogTag.Tag_Conn, "mDownGradeView", "Landroid/widget/FrameLayout;", "D", "Landroid/widget/FrameLayout;", "mDownLayoutView", "E", UserInfo.SEX_FEMALE, "mRealProcess", "Landroid/animation/AnimatorSet;", "Landroid/animation/AnimatorSet;", "mMoveAnimatorSet", "G", "Ljava/util/ArrayList;", "mLevelRate", "H", "mIconLevelArray", "I", HttpMsg.MTYPE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attr", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class HeaderProgressBar extends ConstraintLayout {
    private static final float K = ViewUtils.dpToPx(5.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ImageView mDownGradeView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private FrameLayout mDownLayoutView;

    /* renamed from: E, reason: from kotlin metadata */
    private float mRealProcess;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet mMoveAnimatorSet;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<Float> mLevelRate;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<String> mIconLevelArray;

    /* renamed from: I, reason: from kotlin metadata */
    private int mType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView ivThumb;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView ivSolid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView ivRateSolid;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView ivDot1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView ivDot2;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LottieAnimationView mLottieView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderProgressBar(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLevelRate = new ArrayList<>();
        this.mIconLevelArray = new ArrayList<>();
        this.mType = -1;
        LayoutInflater.from(getContext()).inflate(R.layout.f_r, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.y98);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_solid)");
        this.ivSolid = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.y7o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_rate_solid)");
        this.ivRateSolid = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.y9u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.iv_thumb)");
        this.ivThumb = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.y2a);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.iv_dot_1)");
        this.ivDot1 = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.y2b);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_dot_2)");
        this.ivDot2 = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.y_e);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.iv_upgrade_lottieView)");
        this.mLottieView = (LottieAnimationView) findViewById6;
        View findViewById7 = findViewById(R.id.y2d);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.iv_downgrade)");
        this.mDownLayoutView = (FrameLayout) findViewById7;
        View findViewById8 = findViewById(R.id.y2e);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.iv_downgrade_image)");
        this.mDownGradeView = (ImageView) findViewById8;
        setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(float oldRate) {
        this.mDownLayoutView.setVisibility(0);
        this.mDownGradeView.setVisibility(0);
        ViewUtils.updateLPWidth(this.mDownLayoutView, (int) (this.ivSolid.getWidth() * oldRate));
        int width = this.ivSolid.getWidth();
        float f16 = this.mRealProcess;
        float f17 = width;
        int i3 = (int) (f16 * f17);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ivThumb, "translationX", 0.0f, (f16 - oldRate) * f17);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(ivThumb, \"transl\u2026s - oldRate) * soldWidth)");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mDownGradeView, "translationX", 0.0f, -40.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(mDownGradeView, \"translationX\", 0f, -40f)");
        ofFloat.addListener(new b());
        ValueAnimator ofInt = ValueAnimator.ofInt((int) (f17 * oldRate), i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HeaderProgressBar.P0(HeaderProgressBar.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.mMoveAnimatorSet = animatorSet;
        he0.b.m(animatorSet, R.anim.f154987uu, 2.5f);
        animatorSet.playTogether(ofFloat, ofFloat2, ofInt);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(HeaderProgressBar this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = this$0.ivRateSolid.getLayoutParams();
        layoutParams.width = intValue;
        this$0.ivRateSolid.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this$0.mDownLayoutView.getLayoutParams();
        layoutParams2.width = intValue;
        this$0.mDownLayoutView.setLayoutParams(layoutParams2);
    }

    private final void Q0(float progress) {
        ViewUtils.updateLPWidth(this.ivRateSolid, (int) (this.ivSolid.getWidth() * progress));
        ViewParent parent = this.ivThumb.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) parent;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.setHorizontalBias(R.id.y9u, progress);
        constraintSet.applyTo(constraintLayout);
        this.ivThumb.setVisibility(0);
        this.ivRateSolid.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(HeaderProgressBar this$0, GradientDrawable gradientDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ivRateSolid.setBackground(gradientDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(final float oldRate) {
        this.mLottieView.setVisibility(0);
        ViewParent parent = this.mLottieView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) parent;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.setHorizontalBias(R.id.y_e, oldRate);
        constraintSet.applyTo(constraintLayout);
        LottieHelper.b(getContext(), "lizi-com.json", null, 0, 0, 8, new LottieHelper.d() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.i
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                HeaderProgressBar.U0(HeaderProgressBar.this, oldRate, lottieDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(final HeaderProgressBar this$0, float f16, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (lottieDrawable == null) {
            QLog.i("HeaderProgressBar", 1, "loadLottieAnimFromAssets return null, lottieAnim:lizi-com.json");
            this$0.Q0(this$0.mRealProcess);
            return;
        }
        this$0.mLottieView.setImageDrawable(lottieDrawable);
        lottieDrawable.playAnimation();
        int width = this$0.ivSolid.getWidth();
        float f17 = this$0.mRealProcess;
        float f18 = width;
        int i3 = (int) (f17 * f18);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.ivThumb, "translationX", 0.0f, (f17 - f16) * f18);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(ivThumb, \"transl\u2026s - oldRate) * soldWidth)");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.mLottieView, "translationX", 0.0f, (this$0.mRealProcess - f16) * f18);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(mLottieView, \"tr\u2026s - oldRate) * soldWidth)");
        ValueAnimator ofInt = ValueAnimator.ofInt((int) (f18 * f16), i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HeaderProgressBar.V0(HeaderProgressBar.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this$0.mMoveAnimatorSet = animatorSet;
        animatorSet.addListener(new c());
        he0.b.m(animatorSet, R.anim.f154987uu, 5.0f);
        animatorSet.playTogether(ofFloat, ofInt, ofFloat2);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V0(HeaderProgressBar this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = this$0.ivRateSolid.getLayoutParams();
        layoutParams.width = intValue;
        this$0.ivRateSolid.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0() {
        boolean z16;
        boolean z17;
        AnimatorSet animatorSet = this.mMoveAnimatorSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            AnimatorSet animatorSet2 = this.mMoveAnimatorSet;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                final int width = this.ivSolid.getWidth();
                int i3 = (int) (this.mRealProcess * width);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ivThumb, "translationX", 0.0f, i3);
                Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(ivThumb, \"transl\u2026nX\", 0f, width.toFloat())");
                final Ref.IntRef intRef = new Ref.IntRef();
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.j
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HeaderProgressBar.X0(HeaderProgressBar.this, intRef, width, valueAnimator);
                    }
                });
                ValueAnimator ofInt = ValueAnimator.ofInt(0, i3);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.k
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        HeaderProgressBar.Y0(HeaderProgressBar.this, valueAnimator);
                    }
                });
                AnimatorSet animatorSet3 = new AnimatorSet();
                this.mMoveAnimatorSet = animatorSet3;
                he0.b.m(animatorSet3, R.anim.f154987uu, 2.5f);
                animatorSet3.playTogether(ofFloat, ofInt);
                animatorSet3.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(HeaderProgressBar this$0, Ref.IntRef currentIndex, int i3, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentIndex, "$currentIndex");
        if (!this$0.mLevelRate.isEmpty() && !this$0.mIconLevelArray.isEmpty() && this$0.mLevelRate.size() == this$0.mIconLevelArray.size()) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            if (currentIndex.element < this$0.mLevelRate.size() && currentIndex.element < this$0.mIconLevelArray.size() && ((int) floatValue) >= ((int) (this$0.mLevelRate.get(currentIndex.element).floatValue() * i3))) {
                ImageView imageView = this$0.ivThumb;
                String str = this$0.mIconLevelArray.get(currentIndex.element);
                Intrinsics.checkNotNullExpressionValue(str, "mIconLevelArray[currentIndex]");
                IntimateHeaderCardUtil.X(imageView, str, new ColorDrawable(0));
                currentIndex.element++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(HeaderProgressBar this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        ViewGroup.LayoutParams layoutParams = this$0.ivRateSolid.getLayoutParams();
        layoutParams.width = intValue;
        this$0.ivRateSolid.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ void setData$default(HeaderProgressBar headerProgressBar, int i3, float f16, int i16, float f17, String str, int i17, Pair pair, ArrayList arrayList, ArrayList arrayList2, boolean z16, int i18, Object obj) {
        boolean z17;
        if ((i18 & 512) != 0) {
            z17 = true;
        } else {
            z17 = z16;
        }
        headerProgressBar.setData(i3, f16, i16, f17, str, i17, pair, arrayList, arrayList2, z17);
    }

    public final void N0() {
        this.ivThumb.setVisibility(4);
        this.ivRateSolid.setVisibility(4);
        this.mLottieView.cancelAnimation();
        AnimatorSet animatorSet = this.mMoveAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.mRealProcess = -1.0f;
        this.mType = -1;
    }

    public final void S0(final int aniType, final float oldRate, @NotNull final String iconUrl) {
        boolean z16;
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        AnimatorSet animatorSet = this.mMoveAnimatorSet;
        boolean z17 = true;
        if (animatorSet != null && animatorSet.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            AnimatorSet animatorSet2 = this.mMoveAnimatorSet;
            if (animatorSet2 == null || !animatorSet2.isStarted()) {
                z17 = false;
            }
            if (!z17) {
                Q0(oldRate);
                AnimatorSet animatorSet3 = this.mMoveAnimatorSet;
                if (animatorSet3 != null) {
                    animatorSet3.cancel();
                }
                this.mLottieView.setVisibility(8);
                this.mDownLayoutView.setVisibility(8);
                this.ivSolid.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.HeaderProgressBar$startAnimation$$inlined$postDelayed$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageView imageView;
                        ArrayList arrayList;
                        ImageView imageView2;
                        ImageView imageView3;
                        int i3 = aniType;
                        if (i3 == 0) {
                            imageView = this.ivThumb;
                            arrayList = this.mIconLevelArray;
                            Object obj = arrayList.get(0);
                            Intrinsics.checkNotNullExpressionValue(obj, "mIconLevelArray[0]");
                            IntimateHeaderCardUtil.X(imageView, (String) obj, new ColorDrawable(0));
                            this.W0();
                            return;
                        }
                        if (i3 == 1) {
                            imageView2 = this.ivThumb;
                            IntimateHeaderCardUtil.X(imageView2, iconUrl, new ColorDrawable(0));
                            this.T0(oldRate);
                        } else if (i3 == 2) {
                            imageView3 = this.ivThumb;
                            IntimateHeaderCardUtil.X(imageView3, iconUrl, new ColorDrawable(0));
                            this.O0(oldRate);
                        }
                    }
                }, 1000L);
            }
        }
    }

    public final void setData(int type, float progress, int aniType, float oldRate, @NotNull String iconUrl, int progressBottomColor, @NotNull Pair<Integer, Integer> progressRateColor, @NotNull ArrayList<Float> rateArray, @NotNull ArrayList<String> iconUrlArray, boolean needShowProcessBar) {
        ConstraintLayout.LayoutParams layoutParams;
        boolean z16;
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(progressRateColor, "progressRateColor");
        Intrinsics.checkNotNullParameter(rateArray, "rateArray");
        Intrinsics.checkNotNullParameter(iconUrlArray, "iconUrlArray");
        if (progress >= 0.0f && progress <= 1.0f && !iconUrlArray.isEmpty() && needShowProcessBar) {
            int i3 = this.mType;
            if (i3 == type) {
                if (progress == this.mRealProcess) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return;
                }
            }
            if (type != i3) {
                ViewGroup.LayoutParams layoutParams2 = this.ivRateSolid.getLayoutParams();
                layoutParams2.width = 0;
                this.ivRateSolid.setLayoutParams(layoutParams2);
                ViewGroup.LayoutParams layoutParams3 = this.ivThumb.getLayoutParams();
                if (layoutParams3 instanceof ConstraintLayout.LayoutParams) {
                    layoutParams = (ConstraintLayout.LayoutParams) layoutParams3;
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    layoutParams.horizontalBias = 0.0f;
                    this.ivThumb.setLayoutParams(layoutParams3);
                }
            }
            this.mLevelRate.clear();
            this.mLevelRate.addAll(rateArray);
            this.mIconLevelArray.clear();
            this.mIconLevelArray.addAll(iconUrlArray);
            this.mType = type;
            this.mRealProcess = progress;
            setVisibility(0);
            this.ivDot1.setVisibility(0);
            this.ivDot2.setVisibility(0);
            ColorStateList colorStateList = getResources().getColorStateList(R.color.qui_common_border_allwhite_strong, getContext().getTheme());
            Intrinsics.checkNotNullExpressionValue(colorStateList, "resources.getColorStateL\u2026te_strong, context.theme)");
            int intValue = progressRateColor.getFirst().intValue();
            int intValue2 = progressRateColor.getSecond().intValue();
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            float f16 = K;
            final GradientDrawable createGradientDrawable = ViewUtils.createGradientDrawable(intValue, null, intValue2, orientation, f16, IntimateHeaderCardUtil.f178990a.j(), colorStateList);
            this.ivSolid.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.l
                @Override // java.lang.Runnable
                public final void run() {
                    HeaderProgressBar.R0(HeaderProgressBar.this, createGradientDrawable);
                }
            });
            this.ivSolid.setBackground(ViewUtils.customRadiusDrawable(ColorStateList.valueOf(progressBottomColor), f16, f16, f16, f16));
            if (IntimateHeaderCardUtil.t()) {
                S0(aniType, oldRate, iconUrl);
                return;
            } else {
                Q0(progress);
                return;
            }
        }
        setVisibility(4);
        this.ivThumb.setVisibility(4);
        this.ivRateSolid.setVisibility(4);
    }

    public final void setType(int type) {
        this.mType = type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderProgressBar(@NotNull Context context, @NotNull AttributeSet attr) {
        super(context, attr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
        this.mLevelRate = new ArrayList<>();
        this.mIconLevelArray = new ArrayList<>();
        this.mType = -1;
        LayoutInflater.from(getContext()).inflate(R.layout.f_r, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.y98);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_solid)");
        this.ivSolid = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.y7o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_rate_solid)");
        this.ivRateSolid = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.y9u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.iv_thumb)");
        this.ivThumb = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.y2a);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.iv_dot_1)");
        this.ivDot1 = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.y2b);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_dot_2)");
        this.ivDot2 = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.y_e);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.iv_upgrade_lottieView)");
        this.mLottieView = (LottieAnimationView) findViewById6;
        View findViewById7 = findViewById(R.id.y2d);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.iv_downgrade)");
        this.mDownLayoutView = (FrameLayout) findViewById7;
        View findViewById8 = findViewById(R.id.y2e);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.iv_downgrade_image)");
        this.mDownGradeView = (ImageView) findViewById8;
        setVisibility(4);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/activity/aio/intimate/headerv2/HeaderProgressBar$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            HeaderProgressBar.this.mDownLayoutView.setVisibility(8);
            HeaderProgressBar.this.mDownGradeView.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/activity/aio/intimate/headerv2/HeaderProgressBar$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            HeaderProgressBar.this.mLottieView.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            HeaderProgressBar.this.mLottieView.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderProgressBar(@NotNull Context context, @NotNull AttributeSet attr, int i3) {
        super(context, attr, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attr, "attr");
        this.mLevelRate = new ArrayList<>();
        this.mIconLevelArray = new ArrayList<>();
        this.mType = -1;
        LayoutInflater.from(getContext()).inflate(R.layout.f_r, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.y98);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_solid)");
        this.ivSolid = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.y7o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_rate_solid)");
        this.ivRateSolid = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.y9u);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.iv_thumb)");
        this.ivThumb = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.y2a);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.iv_dot_1)");
        this.ivDot1 = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.y2b);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_dot_2)");
        this.ivDot2 = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.y_e);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.iv_upgrade_lottieView)");
        this.mLottieView = (LottieAnimationView) findViewById6;
        View findViewById7 = findViewById(R.id.y2d);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.iv_downgrade)");
        this.mDownLayoutView = (FrameLayout) findViewById7;
        View findViewById8 = findViewById(R.id.y2e);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.iv_downgrade_image)");
        this.mDownGradeView = (ImageView) findViewById8;
        setVisibility(4);
    }
}
