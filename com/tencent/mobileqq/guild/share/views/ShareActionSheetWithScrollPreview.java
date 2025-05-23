package com.tencent.mobileqq.guild.share.views;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u00020\u0001:\u0001;B\u0019\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/share/views/ShareActionSheetWithScrollPreview;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "", "A0", "Landroid/view/animation/AnimationSet;", "y0", "x0", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "C0", "", "desc", "B0", "Landroid/content/Context;", "J0", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "K0", "Landroid/graphics/Bitmap;", "mPreviewBitmap", "Landroid/view/View;", "L0", "Landroid/view/View;", "mPreviewContainer", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "M0", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "mRoundCornerImageView", "N0", "mContainerForIv", "Lkotlin/Pair;", "", "O0", "Lkotlin/Pair;", "ivContainerInitialPadding", "Landroid/widget/ScrollView;", "P0", "Landroid/widget/ScrollView;", "mScrollView", "Q0", "Ljava/lang/String;", "mImageDecs", "", "R0", "Z", "isDismissing", "Landroid/view/View$OnLayoutChangeListener;", "S0", "Lkotlin/Lazy;", "z0", "()Landroid/view/View$OnLayoutChangeListener;", "onLayoutChangeListener", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;", "param", "<init>", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;Landroid/content/Context;)V", "T0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ShareActionSheetWithScrollPreview extends ShareActionSheetV2 {

    /* renamed from: J0, reason: from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: K0, reason: from kotlin metadata */
    @Nullable
    private Bitmap mPreviewBitmap;

    /* renamed from: L0, reason: from kotlin metadata */
    @NotNull
    private final View mPreviewContainer;

    /* renamed from: M0, reason: from kotlin metadata */
    @NotNull
    private final RoundCornerImageView mRoundCornerImageView;

    /* renamed from: N0, reason: from kotlin metadata */
    @NotNull
    private final View mContainerForIv;

    /* renamed from: O0, reason: from kotlin metadata */
    @NotNull
    private Pair<Integer, Integer> ivContainerInitialPadding;

    /* renamed from: P0, reason: from kotlin metadata */
    @NotNull
    private final ScrollView mScrollView;

    /* renamed from: Q0, reason: from kotlin metadata */
    @Nullable
    private String mImageDecs;

    /* renamed from: R0, reason: from kotlin metadata */
    private boolean isDismissing;

    /* renamed from: S0, reason: from kotlin metadata */
    @NotNull
    private final Lazy onLayoutChangeListener;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/share/views/ShareActionSheetWithScrollPreview$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ShareActionSheetWithScrollPreview.this.isDismissing = false;
            ShareActionSheetWithScrollPreview.this.mRoundCornerImageView.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareActionSheetWithScrollPreview(@Nullable ShareActionSheetV2.Param param, @NotNull Context context) {
        super(param);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.f8v, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n        .i\u2026view_layout, null, false)");
        this.mPreviewContainer = inflate;
        View findViewById = inflate.findViewById(R.id.f7843472);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mPreviewContainer.findVi\u2026d.round_corner_imageview)");
        this.mRoundCornerImageView = (RoundCornerImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.v86);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mPreviewContainer.findViewById(R.id.fl_iv_shadow)");
        this.mContainerForIv = findViewById2;
        this.ivContainerInitialPadding = TuplesKt.to(-1, -1);
        View findViewById3 = inflate.findViewById(R.id.iil);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mPreviewContainer.findViewById(R.id.scrollview)");
        ScrollView scrollView = (ScrollView) findViewById3;
        this.mScrollView = scrollView;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new ShareActionSheetWithScrollPreview$onLayoutChangeListener$2(this));
        this.onLayoutChangeListener = lazy;
        scrollView.setFadingEdgeLength(100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0() {
        Bitmap bitmap;
        int height;
        int coerceAtLeast;
        if (!o.c("refreshPreviewImageView") && (bitmap = this.mPreviewBitmap) != null) {
            Intrinsics.checkNotNull(bitmap);
            if (!bitmap.isRecycled()) {
                int dpToPx = ViewUtils.dpToPx(96.0f);
                if (this.mRoundCornerImageView.getHeight() + dpToPx >= this.mPreviewContainer.getHeight()) {
                    height = 0;
                } else {
                    height = ((this.mPreviewContainer.getHeight() - dpToPx) - this.mRoundCornerImageView.getHeight()) / 2;
                }
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((this.mPreviewContainer.getHeight() - dpToPx) - height) - this.mRoundCornerImageView.getHeight(), 0);
                View view = this.mContainerForIv;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    view.setLayoutParams(layoutParams);
                    if (this.ivContainerInitialPadding.getFirst().intValue() == -1 && this.ivContainerInitialPadding.getSecond().intValue() == -1) {
                        this.ivContainerInitialPadding = TuplesKt.to(Integer.valueOf(this.mContainerForIv.getPaddingTop()), Integer.valueOf(this.mContainerForIv.getPaddingBottom()));
                    }
                    this.mContainerForIv.setPadding(0, this.ivContainerInitialPadding.getFirst().intValue() + height, 0, this.ivContainerInitialPadding.getSecond().intValue() + coerceAtLeast);
                    RoundCornerImageView roundCornerImageView = this.mRoundCornerImageView;
                    roundCornerImageView.f92071e = 1.0f;
                    roundCornerImageView.startAnimation(y0());
                    this.mRoundCornerImageView.setVisibility(0);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(final ShareActionSheetWithScrollPreview this$0, DialogInterface dialogInterface) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionSheet actionSheet = this$0.F;
        if (actionSheet != null && actionSheet.getActionContentView() != null && this$0.F.getActionContentView().getParent() != null && (bitmap = this$0.mPreviewBitmap) != null) {
            Intrinsics.checkNotNull(bitmap);
            if (!bitmap.isRecycled() && this$0.G != null) {
                RelativeLayout actionContentView = this$0.F.getActionContentView();
                ViewGroup rootView = this$0.F.getRootView();
                rootView.setPadding(rootView.getPaddingLeft(), 0, rootView.getPaddingRight(), 0);
                ViewParent parent = actionContentView.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.widget.RelativeLayout");
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                layoutParams.addRule(2, R.id.action_sheet_actionView);
                ((RelativeLayout) parent).addView(this$0.mPreviewContainer, layoutParams);
                this$0.mRoundCornerImageView.setCorner(ViewUtils.dpToPx(8.0f));
                this$0.mRoundCornerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.share.views.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ShareActionSheetWithScrollPreview.E0(view);
                    }
                });
                this$0.mRoundCornerImageView.setContentDescription(this$0.mImageDecs);
                this$0.mRoundCornerImageView.setVisibility(4);
                this$0.mRoundCornerImageView.setImageBitmap(this$0.mPreviewBitmap);
                this$0.mContainerForIv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.share.views.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ShareActionSheetWithScrollPreview.F0(ShareActionSheetWithScrollPreview.this, view);
                    }
                });
                this$0.mPreviewContainer.addOnLayoutChangeListener(this$0.z0());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(ShareActionSheetWithScrollPreview this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(ShareActionSheetWithScrollPreview this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isDismissing) {
            return;
        }
        if (this$0.mRoundCornerImageView.getVisibility() == 0) {
            this$0.isDismissing = true;
            this$0.mRoundCornerImageView.startAnimation(this$0.x0());
        }
        this$0.mPreviewContainer.removeOnLayoutChangeListener(this$0.z0());
    }

    private final AnimationSet x0() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        he0.b.l(alphaAnimation, R.anim.f154975ui);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.6f, 1.0f, 0.6f, 1, 0.5f, 1, 0.5f);
        he0.b.l(scaleAnimation, R.anim.f154975ui);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setAnimationListener(new b());
        return animationSet;
    }

    private final AnimationSet y0() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        he0.b.l(alphaAnimation, R.anim.f154978ul);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.6f, 1.0f, 0.6f, 1.0f, 1, 0.5f, 1, 0.5f);
        he0.b.l(scaleAnimation, R.anim.f154978ul);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setFillAfter(true);
        return animationSet;
    }

    private final View.OnLayoutChangeListener z0() {
        return (View.OnLayoutChangeListener) this.onLayoutChangeListener.getValue();
    }

    public final void B0(@Nullable String desc) {
        this.mImageDecs = desc;
        this.mRoundCornerImageView.setContentDescription(desc);
    }

    public final void C0(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.mPreviewBitmap = bitmap;
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.guild.share.views.a
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ShareActionSheetWithScrollPreview.D0(ShareActionSheetWithScrollPreview.this, dialogInterface);
            }
        });
        setWatchDismissListener(new ActionSheet.WatchDismissActions() { // from class: com.tencent.mobileqq.guild.share.views.b
            @Override // com.tencent.widget.ActionSheet.WatchDismissActions
            public final void onDismissOperations() {
                ShareActionSheetWithScrollPreview.G0(ShareActionSheetWithScrollPreview.this);
            }
        });
    }
}
