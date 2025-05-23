package com.tencent.mobileqq.wink.publish.promotion.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.wink.publish.promotion.viewmodel.PublishPromotionViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PartsStateViewModel;
import com.tencent.mobileqq.winkpublish.model.PromotionParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/winkpublish/model/PromotionParams;", "Lcom/tencent/mobileqq/wink/publish/promotion/viewmodel/PublishPromotionViewModel$PromotionSource;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class PublishPromotionPart$observeLiveData$1 extends Lambda implements Function1<Pair<? extends PromotionParams, ? extends PublishPromotionViewModel.PromotionSource>, Unit> {
    final /* synthetic */ PublishPromotionPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishPromotionPart$observeLiveData$1(PublishPromotionPart publishPromotionPart) {
        super(1);
        this.this$0 = publishPromotionPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PublishPromotionPart this$0, PromotionParams promotionParams, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ea(promotionParams);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PublishPromotionPart this$0, PromotionParams promotionParams, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ea(promotionParams);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends PromotionParams, ? extends PublishPromotionViewModel.PromotionSource> pair) {
        invoke2((Pair<PromotionParams, ? extends PublishPromotionViewModel.PromotionSource>) pair);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<PromotionParams, ? extends PublishPromotionViewModel.PromotionSource> pair) {
        TextView textView;
        RelativeLayout relativeLayout;
        PartsStateViewModel ja5;
        RelativeLayout relativeLayout2;
        TextView textView2;
        TextView textView3;
        boolean ra5;
        ImageView imageView;
        ImageView imageView2;
        TextView textView4;
        PartsStateViewModel ja6;
        ImageView imageView3;
        ImageView imageView4;
        TextView textView5;
        final PromotionParams first = pair.getFirst();
        View view = null;
        if (first != null) {
            relativeLayout2 = this.this$0.selectedItemContainer;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedItemContainer");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(0);
            textView2 = this.this$0.promotionDescView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("promotionDescView");
                textView2 = null;
            }
            textView2.setVisibility(8);
            textView3 = this.this$0.selectedPromotionNameView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectedPromotionNameView");
                textView3 = null;
            }
            textView3.setText(first.getName());
            ra5 = this.this$0.ra(first);
            if (ra5) {
                imageView3 = this.this$0.editItemView;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editItemView");
                    imageView3 = null;
                }
                imageView3.setVisibility(0);
                imageView4 = this.this$0.editItemView;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editItemView");
                    imageView4 = null;
                }
                final PublishPromotionPart publishPromotionPart = this.this$0;
                imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        PublishPromotionPart$observeLiveData$1.c(PublishPromotionPart.this, first, view2);
                    }
                });
                textView5 = this.this$0.selectedPromotionNameView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedPromotionNameView");
                } else {
                    view = textView5;
                }
                final PublishPromotionPart publishPromotionPart2 = this.this$0;
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.publish.promotion.view.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        PublishPromotionPart$observeLiveData$1.d(PublishPromotionPart.this, first, view2);
                    }
                });
            } else {
                imageView = this.this$0.editItemView;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editItemView");
                    imageView = null;
                }
                imageView.setVisibility(8);
                imageView2 = this.this$0.editItemView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editItemView");
                    imageView2 = null;
                }
                imageView2.setOnClickListener(null);
                textView4 = this.this$0.selectedPromotionNameView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectedPromotionNameView");
                    textView4 = null;
                }
                textView4.setOnClickListener(null);
            }
            ja6 = this.this$0.ja();
            ja6.P2(true);
            this.this$0.ba();
            this.this$0.Ea();
            return;
        }
        textView = this.this$0.promotionDescView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promotionDescView");
            textView = null;
        }
        textView.setVisibility(0);
        relativeLayout = this.this$0.selectedItemContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedItemContainer");
        } else {
            view = relativeLayout;
        }
        view.setVisibility(8);
        ja5 = this.this$0.ja();
        ja5.P2(false);
    }
}
