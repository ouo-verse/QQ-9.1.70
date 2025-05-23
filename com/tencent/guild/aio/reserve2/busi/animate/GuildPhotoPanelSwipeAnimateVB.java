package com.tencent.guild.aio.reserve2.busi.animate;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.reserve2.busi.animate.GuildPhotoPanelDragAnimateState;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0016\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001b0\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016R$\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/guild/aio/reserve2/busi/animate/GuildPhotoPanelSwipeAnimateVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lqq0/b;", "Lcom/tencent/guild/aio/reserve2/busi/animate/GuildPhotoPanelDragAnimateState;", "Lcom/tencent/guild/aio/reserve2/busi/animate/GuildPhotoPanelDragAnimateState$PhotoPanelAnimateState;", "uiState", "", ICustomDataEditor.NUMBER_PARAM_1, "Lkotlin/Function1;", "Lcom/airbnb/lottie/LottieDrawable;", "cb", "f1", "", "ratio", "", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "Lcom/tencent/guild/aio/reserve2/busi/animate/c;", "d1", "k1", "", "Ljava/lang/Class;", "getObserverStates", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/airbnb/lottie/LottieDrawable;", "getMLottieDrawable", "()Lcom/airbnb/lottie/LottieDrawable;", "setMLottieDrawable", "(Lcom/airbnb/lottie/LottieDrawable;)V", "mLottieDrawable", "Lcom/airbnb/lottie/LottieAnimationView;", "e", "Lcom/airbnb/lottie/LottieAnimationView;", "i1", "()Lcom/airbnb/lottie/LottieAnimationView;", "l1", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "lottieAnimationView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "j1", "()Landroid/widget/TextView;", "m1", "(Landroid/widget/TextView;)V", "sendTipsView", "Landroid/view/ViewGroup;", h.F, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "()V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildPhotoPanelSwipeAnimateVB extends com.tencent.aio.base.mvvm.a<qq0.b, GuildPhotoPanelDragAnimateState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieDrawable mLottieDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public LottieAnimationView lottieAnimationView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView sendTipsView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup parent;

    private final int e1(float ratio) {
        return Color.argb((int) (128 + (76 * ratio)), (int) (3 + (27 * ratio)), (int) (8 + (178 * ratio)), (int) (26 + (226 * ratio)));
    }

    private final void f1(final Function1<? super LottieDrawable, Unit> cb5) {
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable != null) {
            cb5.invoke(lottieDrawable);
        } else {
            LottieCompositionFactory.fromAsset(getMContext(), "photo_list_panel_drag.json").addListener(new LottieListener() { // from class: com.tencent.guild.aio.reserve2.busi.animate.a
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    GuildPhotoPanelSwipeAnimateVB.h1(GuildPhotoPanelSwipeAnimateVB.this, cb5, (LottieComposition) obj);
                }
            }).addFailureListener(new LottieListener() { // from class: com.tencent.guild.aio.reserve2.busi.animate.b
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    GuildPhotoPanelSwipeAnimateVB.g1((Throwable) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(Throwable th5) {
        QLog.e("GuildPhotoPanelSwipeAnimateVB", 1, "loadLottieERR " + th5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(GuildPhotoPanelSwipeAnimateVB this$0, Function1 cb5, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        if (this$0.mLottieDrawable == null) {
            LottieDrawable lottieDrawable = new LottieDrawable();
            this$0.mLottieDrawable = lottieDrawable;
            lottieDrawable.setComposition(lottieComposition);
            LottieDrawable lottieDrawable2 = this$0.mLottieDrawable;
            if (lottieDrawable2 != null) {
                lottieDrawable2.setRepeatCount(-1);
            }
        }
        cb5.invoke(this$0.mLottieDrawable);
    }

    private final void n1(GuildPhotoPanelDragAnimateState.PhotoPanelAnimateState uiState) {
        final float ratio;
        if (uiState.getRatio() > 1.0f) {
            ratio = 1.0f;
        } else {
            ratio = uiState.getRatio();
        }
        ViewGroup viewGroup = null;
        if (uiState.getShow()) {
            View hostView = getHostView();
            ViewGroup.LayoutParams layoutParams = hostView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            ((FrameLayout.LayoutParams) layoutParams).bottomMargin = uiState.getBottomMargin();
            hostView.setBackgroundColor(e1(ratio));
            hostView.setVisibility(0);
            LottieAnimationView i16 = i1();
            i16.setScaleX(ratio);
            i16.setScaleY(ratio);
            f1(new Function1<LottieDrawable, Unit>() { // from class: com.tencent.guild.aio.reserve2.busi.animate.GuildPhotoPanelSwipeAnimateVB$updatePhotoPanelAnimate$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LottieDrawable lottieDrawable) {
                    invoke2(lottieDrawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable LottieDrawable lottieDrawable) {
                    if (ratio >= 1.0f) {
                        if ((lottieDrawable == null || lottieDrawable.isRunning()) ? false : true) {
                            this.i1().setPadding(0, 0, 0, 0);
                            this.i1().setImageDrawable(lottieDrawable);
                            lottieDrawable.start();
                            return;
                        }
                        return;
                    }
                    if (lottieDrawable != null) {
                        lottieDrawable.cancelAnimation();
                    }
                    this.i1().setImageResource(R.drawable.guild_photo_list_panel_dragsend);
                    LottieAnimationView i17 = this.i1();
                    int b16 = com.tencent.guild.aio.util.c.b(8);
                    i17.setPadding(b16, b16, b16, b16);
                }
            });
            TextView j16 = j1();
            if (ratio >= 1.0f) {
                j16.setText(R.string.f1518118p);
            } else {
                j16.setText(R.string.f1518018o);
            }
            ViewGroup viewGroup2 = this.parent;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(HippyNestedScrollComponent.PRIORITY_PARENT);
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setMotionEventSplittingEnabled(false);
            return;
        }
        getHostView().setVisibility(8);
        ViewGroup viewGroup3 = this.parent;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(HippyNestedScrollComponent.PRIORITY_PARENT);
        } else {
            viewGroup = viewGroup3;
        }
        viewGroup.setMotionEventSplittingEnabled(true);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public c createVM() {
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildPhotoPanelDragAnimateState>> getObserverStates() {
        List<Class<? extends GuildPhotoPanelDragAnimateState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildPhotoPanelDragAnimateState.PhotoPanelAnimateState.class);
        return listOf;
    }

    @NotNull
    public final LottieAnimationView i1() {
        LottieAnimationView lottieAnimationView = this.lottieAnimationView;
        if (lottieAnimationView != null) {
            return lottieAnimationView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
        return null;
    }

    @NotNull
    public final TextView j1() {
        TextView textView = this.sendTipsView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sendTipsView");
        return null;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: k1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildPhotoPanelDragAnimateState uiState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        if (uiState instanceof GuildPhotoPanelDragAnimateState.PhotoPanelAnimateState) {
            n1((GuildPhotoPanelDragAnimateState.PhotoPanelAnimateState) uiState);
        }
    }

    public final void l1(@NotNull LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "<set-?>");
        this.lottieAnimationView = lottieAnimationView;
    }

    public final void m1(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.sendTipsView = textView;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        this.parent = createViewParams.b();
        LottieAnimationView lottieAnimationView = new LottieAnimationView(createViewParams.a());
        lottieAnimationView.setId(R.id.wtq);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.tencent.guild.aio.util.c.b(60), com.tencent.guild.aio.util.c.b(60));
        layoutParams.addRule(14);
        layoutParams.addRule(15);
        lottieAnimationView.setLayoutParams(layoutParams);
        l1(lottieAnimationView);
        TextView textView = new TextView(createViewParams.a());
        textView.setId(R.id.wzv);
        textView.setTextColor(-1);
        textView.setTextSize(17.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.tencent.guild.aio.util.c.b(9);
        layoutParams2.addRule(3, i1().getId());
        layoutParams2.addRule(14);
        textView.setLayoutParams(layoutParams2);
        m1(textView);
        RelativeLayout relativeLayout = new RelativeLayout(createViewParams.a());
        relativeLayout.setBackgroundResource(R.color.black);
        relativeLayout.setAlpha(0.6f);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setVisibility(8);
        relativeLayout.addView(j1());
        relativeLayout.addView(i1());
        relativeLayout.setClickable(true);
        return relativeLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.cancelAnimation();
        }
        i1().cancelAnimation();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        this.parent = reuseParam.a();
        getHostView().setVisibility(8);
    }
}
