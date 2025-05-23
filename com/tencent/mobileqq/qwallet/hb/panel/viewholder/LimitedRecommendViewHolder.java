package com.tencent.mobileqq.qwallet.hb.panel.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.hb.panel.m;
import com.tencent.mobileqq.qwallet.k;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$Promotion;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.mobileqq.qwallet.pb.RedPackSkinExt;
import com.tencent.mobileqq.qwallet.pb.a;
import com.tencent.mobileqq.qwallet.utils.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u001c\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\n \f*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/LimitedRecommendViewHolder;", "Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/a;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", "data", "", "p", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$Promotion;", "o", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "H", "Landroid/widget/ImageView;", "skinBackground", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "skinRemark", "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "panelHost", "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/panel/a;Landroid/view/View;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class LimitedRecommendViewHolder extends a {

    /* renamed from: H, reason: from kotlin metadata */
    private final ImageView skinBackground;

    /* renamed from: I, reason: from kotlin metadata */
    private final TextView skinRemark;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LimitedRecommendViewHolder(@NotNull com.tencent.mobileqq.qwallet.hb.panel.a panelHost, @NotNull View view) {
        super(panelHost, view);
        Intrinsics.checkNotNullParameter(panelHost, "panelHost");
        Intrinsics.checkNotNullParameter(view, "view");
        this.skinBackground = (ImageView) view.findViewById(R.id.f85844q2);
        this.skinRemark = (TextView) view.findViewById(R.id.f86034qk);
    }

    private final void o(final RedPackSkin$Promotion data) {
        boolean z16;
        ImageView skinBackground = this.skinBackground;
        Intrinsics.checkNotNullExpressionValue(skinBackground, "skinBackground");
        i.c(skinBackground, data.h_img.get(), null, null, 12, null);
        String tipText = data.tip.get();
        Intrinsics.checkNotNullExpressionValue(tipText, "tipText");
        if (tipText.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.skinRemark.setVisibility(0);
            this.skinRemark.setText(tipText);
        } else {
            this.skinRemark.setVisibility(8);
        }
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        k.d(itemView, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.viewholder.LimitedRecommendViewHolder$setPromotionData$1
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
                LimitedRecommendViewHolder.this.getPanelHost().a0(data);
                Integer valueOf = Integer.valueOf(data.f278703id.get());
                String str = data.title.get();
                Intrinsics.checkNotNullExpressionValue(str, "data.title.get()");
                m.h("luckycove.op_tuiguang.click", valueOf, "1", str, null, 16, null);
            }
        }, 1, null);
        Integer valueOf = Integer.valueOf(data.f278703id.get());
        String str = data.title.get();
        Intrinsics.checkNotNullExpressionValue(str, "data.title.get()");
        m.h("luckycove.op_tuiguang.expo", valueOf, "1", str, null, 16, null);
        if (data.source.get() == 1) {
            ml2.c.f416921a.a(101, data.adid.get(), data.trace_info.get());
        }
    }

    private final void p(final RedPackSkin$RecommendSkin data) {
        boolean z16;
        ImageView skinBackground = this.skinBackground;
        Intrinsics.checkNotNullExpressionValue(skinBackground, "skinBackground");
        i.c(skinBackground, data.img.get(), null, null, 12, null);
        String tipText = data.tip.get();
        Intrinsics.checkNotNullExpressionValue(tipText, "tipText");
        if (tipText.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.skinRemark.setVisibility(0);
            this.skinRemark.setText(tipText);
        } else {
            this.skinRemark.setVisibility(8);
        }
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        k.d(itemView, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.viewholder.LimitedRecommendViewHolder$setSkinData$1
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
                LimitedRecommendViewHolder.this.getPanelHost().k0(data);
                Integer valueOf = Integer.valueOf(RedPackSkinExt.f(data));
                String str = data.skin.title.get();
                Intrinsics.checkNotNullExpressionValue(str, "data.skin.title.get()");
                m.h("luckycover.op.click", valueOf, "1", str, null, 16, null);
            }
        }, 1, null);
        Integer valueOf = Integer.valueOf(RedPackSkinExt.f(data));
        String str = data.skin.title.get();
        Intrinsics.checkNotNullExpressionValue(str, "data.skin.title.get()");
        m.h("luckycover.op.expo", valueOf, "1", str, null, 16, null);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.viewholder.a
    public void n(@Nullable Object item) {
        com.tencent.mobileqq.qwallet.pb.a aVar = (com.tencent.mobileqq.qwallet.pb.a) l(item);
        if (aVar == null) {
            return;
        }
        if (aVar instanceof a.Skin) {
            p(((a.Skin) aVar).getValue());
        } else if (aVar instanceof a.Promotion) {
            o(((a.Promotion) aVar).getValue());
        }
    }
}
