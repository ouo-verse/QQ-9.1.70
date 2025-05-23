package com.tencent.state.square.flower;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.service.ImageService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.api.SimpleSquarePagViewListener;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareFlowerMedalUpgradeViewBinding;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.square.resource.PAGLoader;
import com.tencent.state.square.resource.PAGLoaderOption;
import com.tencent.state.utils.AnimationUtils;
import com.tencent.state.utils.ViewUtils;
import com.tencent.state.view.SquareImageView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J4\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0001J\b\u0010\u001b\u001a\u00020\fH\u0002J&\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\u0002J\u0018\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/flower/FlowerMedalTagView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animationContainer", "Ljava/lang/ref/WeakReference;", "imageView", "Lcom/tencent/state/view/SquareImageView;", "bind", "", "isMe", "", "medal", "Lcom/tencent/state/square/flower/data/MedalData;", "ignoreAnimation", NodeProps.ON_CLICK, "Lkotlin/Function0;", "createUpgradeTipsView", "Landroid/view/View;", "medalIconUrl", "", "medalLevel", "", "init", "playMedalTagInAnimation", "playUpgradeTipsOutAnimation", "onDone", "shouldShowUpgradeAnimation", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FlowerMedalTagView extends FrameLayout {
    private static final long MEDAL_TAG_IN_ANIM_DURATION = 200;
    private static final long MEDAL_TAG_IN_DELAY = 300;
    private static final String MEDAL_UPGRADE_TIPS_BG_URL = "https://cdn.meta.qq.com/flower/medal-animation-bg.webp";
    private static final long MEDAL_UPGRADE_TIPS_OUT_ANIM_DURATION = 500;
    private static final long MEDAL_UPGRADE_TIPS_SHOW_DURATION = 4000;
    private static final int PAG_ANIM_HEIGHT_DP = 42;
    private static final String PAG_ANIM_URL = "https://cdn.meta.qq.com/flower/medal-shine.pag";
    private static final int PAG_ANIM_WIDTH_DP = 64;
    private static final String TAG = "FlowerMedalTagView";
    private WeakReference<FrameLayout> animationContainer;
    private SquareImageView imageView;

    public /* synthetic */ FlowerMedalTagView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    private final View createUpgradeTipsView(String medalIconUrl, int medalLevel) {
        VasSquareFlowerMedalUpgradeViewBinding inflate = VasSquareFlowerMedalUpgradeViewBinding.inflate(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFlowerMedalUpgr\u2026utInflater.from(context))");
        if (medalLevel == 1) {
            inflate.tipsText.setText(R.string.f169755xf2);
        } else {
            inflate.tipsText.setText(R.string.f169756xf3);
        }
        FrameLayout mContainer = inflate.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "tipsView.root");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        mContainer.setLayoutParams(layoutParams);
        ImageService.Companion companion = ImageService.INSTANCE;
        ImageLoader loader = companion.getLoader();
        if (loader != null) {
            loader.displayImage(medalIconUrl, new ImageViewAware(inflate.medalIcon), companion.getUniqueImageOptions(medalIconUrl), null, null, null);
        }
        ImageLoader loader2 = companion.getLoader();
        if (loader2 != null) {
            loader2.displayImage(MEDAL_UPGRADE_TIPS_BG_URL, new ImageViewAware(inflate.medalBg), companion.getUniqueImageOptions(MEDAL_UPGRADE_TIPS_BG_URL), null, null, null);
        }
        FrameLayout mContainer2 = inflate.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer2, "tipsView.root");
        mContainer2.setPivotX(0.0f);
        FrameLayout mContainer3 = inflate.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer3, "tipsView.root");
        mContainer3.setPivotY(0.0f);
        FrameLayout mContainer4 = inflate.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer4, "tipsView.root");
        return mContainer4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playMedalTagInAnimation() {
        AnimationUtils.startAlphaAnimation$default(AnimationUtils.INSTANCE, this, true, MEDAL_TAG_IN_ANIM_DURATION, null, 8, null);
        ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ISquarePagView pagView = commonUtils.getPagView(context);
        if (pagView != null) {
            View view = pagView.getView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewExtensionsKt.dip(getContext(), 64), ViewExtensionsKt.dip(getContext(), 42));
            layoutParams.gravity = 17;
            Unit unit = Unit.INSTANCE;
            view.setLayoutParams(layoutParams);
            view.setElevation(0.0f);
            addView(view);
            final WeakReference weakReference = new WeakReference(this);
            final WeakReference weakReference2 = new WeakReference(view);
            pagView.setPagViewListener(new SimpleSquarePagViewListener() { // from class: com.tencent.state.square.flower.FlowerMedalTagView$playMedalTagInAnimation$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(null, 1, null);
                }

                @Override // com.tencent.state.square.api.SimpleSquarePagViewListener, com.tencent.state.square.api.ISquarePagViewListener
                public void onAnimationEnd(ISquarePagView squarePagView) {
                    FlowerMedalTagView flowerMedalTagView;
                    View view2 = (View) weakReference2.get();
                    if (view2 == null || (flowerMedalTagView = (FlowerMedalTagView) weakReference.get()) == null) {
                        return;
                    }
                    flowerMedalTagView.removeView(view2);
                }
            });
            PAGLoader.INSTANCE.playPAG(PAG_ANIM_URL, "1623567916.pag", pagView, new PAGLoaderOption(1));
        }
    }

    public final void init(FrameLayout animationContainer) {
        Intrinsics.checkNotNullParameter(animationContainer, "animationContainer");
        this.animationContainer = new WeakReference<>(animationContainer);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowerMedalTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(8);
        setClipChildren(false);
        setClipToPadding(false);
    }

    private final void playUpgradeTipsOutAnimation(String medalIconUrl, int medalLevel, final Function0<Unit> onDone) {
        FrameLayout frameLayout;
        setAlpha(0.0f);
        final View createUpgradeTipsView = createUpgradeTipsView(medalIconUrl, medalLevel);
        WeakReference<FrameLayout> weakReference = this.animationContainer;
        if (weakReference != null && (frameLayout = weakReference.get()) != null) {
            frameLayout.addView(createUpgradeTipsView);
        }
        SquareBaseKt.getSquareThread().postOnUiDelayed(4000L, new Function0<Unit>() { // from class: com.tencent.state.square.flower.FlowerMedalTagView$playUpgradeTipsOutAnimation$1
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
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(createUpgradeTipsView, c.f123400v, 1.0f, 0.0f).setDuration(500L), ObjectAnimator.ofFloat(createUpgradeTipsView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.1f).setDuration(500L), ObjectAnimator.ofFloat(createUpgradeTipsView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.1f).setDuration(500L));
                animatorSet.start();
                SquareBaseKt.getSquareThread().postOnUiDelayed(300L, new Function0<Unit>() { // from class: com.tencent.state.square.flower.FlowerMedalTagView$playUpgradeTipsOutAnimation$1.2
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
                        onDone.invoke();
                    }
                });
            }
        });
    }

    public final void bind(boolean isMe, final MedalData medal, boolean ignoreAnimation, final Function0<Unit> onClick) {
        if (medal != null) {
            String miniImageUrl = medal.getMiniImageUrl();
            if (!(miniImageUrl == null || miniImageUrl.length() == 0)) {
                setVisibility(0);
                if (this.imageView == null) {
                    SquareImageView squareImageView = new SquareImageView(getContext());
                    squareImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    squareImageView.setElevation(1.0f);
                    addView(squareImageView);
                    Unit unit = Unit.INSTANCE;
                    this.imageView = squareImageView;
                }
                SquareImageView squareImageView2 = this.imageView;
                if (squareImageView2 != null) {
                    squareImageView2.post(new Runnable() { // from class: com.tencent.state.square.flower.FlowerMedalTagView$bind$2
                        @Override // java.lang.Runnable
                        public final void run() {
                            CharSequence trim;
                            SquareImageView squareImageView3;
                            CharSequence trim2;
                            ImageService.Companion companion = ImageService.INSTANCE;
                            ImageLoader loader = companion.getLoader();
                            if (loader != null) {
                                String miniImageUrl2 = medal.getMiniImageUrl();
                                if (miniImageUrl2 != null) {
                                    trim = StringsKt__StringsKt.trim((CharSequence) miniImageUrl2);
                                    String obj = trim.toString();
                                    squareImageView3 = FlowerMedalTagView.this.imageView;
                                    ImageViewAware imageViewAware = new ImageViewAware(squareImageView3);
                                    String miniImageUrl3 = medal.getMiniImageUrl();
                                    if (miniImageUrl3 != null) {
                                        trim2 = StringsKt__StringsKt.trim((CharSequence) miniImageUrl3);
                                        loader.displayImage(obj, imageViewAware, companion.getUniqueImageOptions(trim2.toString()), null, null, null);
                                        return;
                                    }
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                        }
                    });
                }
                if (!ignoreAnimation && shouldShowUpgradeAnimation(isMe, medal)) {
                    playUpgradeTipsOutAnimation(medal.getImageUrl(), medal.getLevel(), new Function0<Unit>() { // from class: com.tencent.state.square.flower.FlowerMedalTagView$bind$3
                        /* JADX INFO: Access modifiers changed from: package-private */
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
                            FlowerMedalTagView.this.playMedalTagInAnimation();
                        }
                    });
                }
                if (onClick != null) {
                    setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.flower.FlowerMedalTagView$bind$4$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            Function0.this.invoke();
                        }
                    });
                    ViewUtils.INSTANCE.expendTouchArea(this, r2, (r12 & 4) != 0 ? r2 : 0, (r12 & 8) != 0 ? r2 : 0, (r12 & 16) != 0 ? ViewExtensionsKt.dip(getContext(), 10) : 0);
                    return;
                }
                return;
            }
        }
        setVisibility(8);
    }

    private final boolean shouldShowUpgradeAnimation(boolean isMe, MedalData medal) {
        if (!isMe) {
            return false;
        }
        String invoke = SKey.Flower.INSTANCE.getPRE_MEDAL_UPGRADE_ANIMATION_LEVEL().invoke(SquareBaseKt.getSquareCommon().getCurrentAccountUin());
        if (IMMKV.DefaultImpls.decodeInt$default(SquareBaseKt.getSquareMMKV(), invoke, -1, null, false, 12, null) == medal.getLevel()) {
            return false;
        }
        IMMKV.DefaultImpls.encodeInt$default(SquareBaseKt.getSquareMMKV(), invoke, medal.getLevel(), null, false, 12, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bind$default(FlowerMedalTagView flowerMedalTagView, boolean z16, MedalData medalData, boolean z17, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        if ((i3 & 8) != 0) {
            function0 = null;
        }
        flowerMedalTagView.bind(z16, medalData, z17, function0);
    }
}
