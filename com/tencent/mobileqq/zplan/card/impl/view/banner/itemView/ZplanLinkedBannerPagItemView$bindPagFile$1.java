package com.tencent.mobileqq.zplan.card.impl.view.banner.itemView;

import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanBannerPagView;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanPagHolderView;
import com.tencent.sqshow.widget.RoundFrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import pv4.s;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZplanLinkedBannerPagItemView$bindPagFile$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ s $data;
    final /* synthetic */ String $leftPagFile;
    final /* synthetic */ Function1<Integer, Unit> $pagDelayReadyListener;
    final /* synthetic */ String $rightPagFile;
    final /* synthetic */ ZplanLinkedBannerPagItemView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ZplanLinkedBannerPagItemView$bindPagFile$1(ZplanLinkedBannerPagItemView zplanLinkedBannerPagItemView, String str, String str2, s sVar, Function1<? super Integer, Unit> function1) {
        super(0);
        this.this$0 = zplanLinkedBannerPagItemView;
        this.$leftPagFile = str;
        this.$rightPagFile = str2;
        this.$data = sVar;
        this.$pagDelayReadyListener = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZplanLinkedBannerPagItemView this$0, Function1 function1) {
        RoundFrameLayout roundFrameLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        roundFrameLayout = this$0.placeHolderView;
        if (roundFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeHolderView");
            roundFrameLayout = null;
        }
        roundFrameLayout.setVisibility(8);
        if (function1 != null) {
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ZplanPagHolderView zplanPagHolderView;
        ZplanPagHolderView zplanPagHolderView2;
        ZplanBannerPagView pagView;
        zplanPagHolderView = this.this$0.pagViewHolder;
        if (zplanPagHolderView != null && (pagView = zplanPagHolderView.getPagView()) != null) {
            pagView.u(this.$leftPagFile, this.$rightPagFile, this.$data);
        }
        zplanPagHolderView2 = this.this$0.pagViewHolder;
        if (zplanPagHolderView2 != null) {
            final ZplanLinkedBannerPagItemView zplanLinkedBannerPagItemView = this.this$0;
            final Function1<Integer, Unit> function1 = this.$pagDelayReadyListener;
            zplanPagHolderView2.p(new Runnable() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.itemView.b
                @Override // java.lang.Runnable
                public final void run() {
                    ZplanLinkedBannerPagItemView$bindPagFile$1.b(ZplanLinkedBannerPagItemView.this, function1);
                }
            });
        }
    }
}
