package com.tencent.guild.aio.reserve2.busi.chosen.view;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.guild.aio.reserve2.busi.chosen.view.DotAnimIndexView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class DotAnimIndexView$selectPosSmooth$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ViewGroup.MarginLayoutParams $lp;
    final /* synthetic */ Pair<Integer, Integer> $pair;
    final /* synthetic */ DotAnimIndexView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotAnimIndexView$selectPosSmooth$1(DotAnimIndexView dotAnimIndexView, Pair<Integer, Integer> pair, ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(0);
        this.this$0 = dotAnimIndexView;
        this.$pair = pair;
        this.$lp = marginLayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DotAnimIndexView this$0, ViewGroup.MarginLayoutParams marginLayoutParams, ValueAnimator valueAnimator) {
        DotAnimIndexView.Config config;
        vn0.b bVar;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        config = this$0.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
        if (config.h()) {
            if (marginLayoutParams != null) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                marginLayoutParams.leftMargin = ((Integer) animatedValue).intValue();
            }
        } else if (marginLayoutParams != null) {
            Object animatedValue2 = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Int");
            marginLayoutParams.topMargin = ((Integer) animatedValue2).intValue();
        }
        bVar = this$0.binding;
        if (bVar != null) {
            imageView = bVar.f441918c;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            imageView.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DotAnimIndexView dotAnimIndexView = this.this$0;
        int intValue = this.$pair.getFirst().intValue();
        int intValue2 = this.$pair.getSecond().intValue();
        final DotAnimIndexView dotAnimIndexView2 = this.this$0;
        final ViewGroup.MarginLayoutParams marginLayoutParams = this.$lp;
        dotAnimIndexView.m(intValue, intValue2, new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.guild.aio.reserve2.busi.chosen.view.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DotAnimIndexView$selectPosSmooth$1.b(DotAnimIndexView.this, marginLayoutParams, valueAnimator);
            }
        });
    }
}
