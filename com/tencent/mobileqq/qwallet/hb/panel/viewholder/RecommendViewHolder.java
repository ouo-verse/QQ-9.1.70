package com.tencent.mobileqq.qwallet.hb.panel.viewholder;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.hb.panel.RecommendSkinView;
import com.tencent.mobileqq.qwallet.hb.panel.m;
import com.tencent.mobileqq.qwallet.hb.panel.viewholder.RecommendViewHolder;
import com.tencent.mobileqq.qwallet.k;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$Promotion;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.mobileqq.qwallet.pb.RedPackSkinExt;
import com.tencent.mobileqq.qwallet.pb.a;
import com.tencent.mobileqq.qwallet.utils.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0003\u0015\u0016\u0017B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/RecommendViewHolder;", "Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/a;", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/RecommendViewHolder$SkinTypeHolder;", "H", "Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/RecommendViewHolder$SkinTypeHolder;", "skinHolder", "Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/RecommendViewHolder$PromotionTypeHolder;", "I", "Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/RecommendViewHolder$PromotionTypeHolder;", "promotionHolder", "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "panelHost", "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/panel/a;Landroid/view/View;)V", "J", "a", "PromotionTypeHolder", "SkinTypeHolder", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class RecommendViewHolder extends a {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final SkinTypeHolder skinHolder;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final PromotionTypeHolder promotionHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u001c\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\n \u0012*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/RecommendViewHolder$PromotionTypeHolder;", "", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$Promotion;", "data", "", "b", "", NodeProps.VISIBLE, "c", "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "a", "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "panelHost", "Landroid/view/View;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "kotlin.jvm.PlatformType", "root", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "promotionImage", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "promotionTitle", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/panel/a;Landroid/view/View;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class PromotionTypeHolder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.qwallet.hb.panel.a panelHost;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final View root;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final ImageView promotionImage;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final TextView promotionTitle;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/viewholder/RecommendViewHolder$PromotionTypeHolder$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes16.dex */
        public static final class a extends ViewOutlineProvider {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ImageView f277628a;

            a(ImageView imageView) {
                this.f277628a = imageView;
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(@Nullable View view, @Nullable Outline outline) {
                if (outline != null) {
                    outline.setRoundRect(0, 0, this.f277628a.getWidth(), this.f277628a.getHeight(), x.c(this.f277628a.getContext(), 6.0f));
                }
            }
        }

        public PromotionTypeHolder(@NotNull com.tencent.mobileqq.qwallet.hb.panel.a panelHost, @NotNull View view) {
            Intrinsics.checkNotNullParameter(panelHost, "panelHost");
            Intrinsics.checkNotNullParameter(view, "view");
            this.panelHost = panelHost;
            this.view = view;
            this.root = view.findViewById(R.id.f71413o3);
            ImageView imageView = (ImageView) view.findViewById(R.id.f71403o2);
            imageView.setOutlineProvider(new a(imageView));
            imageView.setClipToOutline(true);
            this.promotionImage = imageView;
            this.promotionTitle = (TextView) view.findViewById(R.id.f71423o4);
        }

        public final void b(@NotNull final RedPackSkin$Promotion data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ImageView promotionImage = this.promotionImage;
            Intrinsics.checkNotNullExpressionValue(promotionImage, "promotionImage");
            i.c(promotionImage, data.v_img.get(), null, null, 12, null);
            this.promotionTitle.setText(data.title.get());
            k.d(this.view, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.viewholder.RecommendViewHolder$PromotionTypeHolder$setItem$1
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
                    com.tencent.mobileqq.qwallet.hb.panel.a aVar;
                    aVar = RecommendViewHolder.PromotionTypeHolder.this.panelHost;
                    aVar.a0(data);
                    Integer valueOf = Integer.valueOf(data.f278703id.get());
                    String str = data.title.get();
                    Intrinsics.checkNotNullExpressionValue(str, "data.title.get()");
                    m.h("luckycove.op_tuiguang.click", valueOf, "0", str, null, 16, null);
                }
            }, 1, null);
            Integer valueOf = Integer.valueOf(data.f278703id.get());
            String str = data.title.get();
            Intrinsics.checkNotNullExpressionValue(str, "data.title.get()");
            m.h("luckycove.op_tuiguang.expo", valueOf, "0", str, null, 16, null);
            if (data.source.get() == 1) {
                ml2.c.f416921a.a(101, data.adid.get(), data.trace_info.get());
            }
        }

        public final void c(boolean visible) {
            int i3;
            View view = this.root;
            if (visible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u001c\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\n \u0012*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/RecommendViewHolder$SkinTypeHolder;", "", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", "data", "", "b", "", NodeProps.VISIBLE, "c", "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "a", "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "panelHost", "Landroid/view/View;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "kotlin.jvm.PlatformType", "root", "Lcom/tencent/mobileqq/qwallet/hb/panel/RecommendSkinView;", "d", "Lcom/tencent/mobileqq/qwallet/hb/panel/RecommendSkinView;", "recommendView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "skinTitle", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/panel/a;Landroid/view/View;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class SkinTypeHolder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.qwallet.hb.panel.a panelHost;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View view;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final View root;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final RecommendSkinView recommendView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final TextView skinTitle;

        public SkinTypeHolder(@NotNull com.tencent.mobileqq.qwallet.hb.panel.a panelHost, @NotNull View view) {
            Intrinsics.checkNotNullParameter(panelHost, "panelHost");
            Intrinsics.checkNotNullParameter(view, "view");
            this.panelHost = panelHost;
            this.view = view;
            this.root = view.findViewById(R.id.f71473o9);
            this.recommendView = (RecommendSkinView) view.findViewById(R.id.f71483o_);
            this.skinTitle = (TextView) view.findViewById(R.id.f86074qo);
        }

        public final void b(@NotNull final RedPackSkin$RecommendSkin data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.recommendView.setScene(0);
            this.recommendView.A0(data, 1);
            this.skinTitle.setText(data.skin.title.get());
            k.d(this.view, 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.viewholder.RecommendViewHolder$SkinTypeHolder$setItem$1
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
                    com.tencent.mobileqq.qwallet.hb.panel.a aVar;
                    aVar = RecommendViewHolder.SkinTypeHolder.this.panelHost;
                    aVar.k0(data);
                    Integer valueOf = Integer.valueOf(RedPackSkinExt.f(data));
                    String str = data.skin.title.get();
                    Intrinsics.checkNotNullExpressionValue(str, "data.skin.title.get()");
                    m.h("luckycover.op.click", valueOf, "0", str, null, 16, null);
                }
            }, 1, null);
            Integer valueOf = Integer.valueOf(RedPackSkinExt.f(data));
            String str = data.skin.title.get();
            Intrinsics.checkNotNullExpressionValue(str, "data.skin.title.get()");
            m.h("luckycover.op.expo", valueOf, "0", str, null, 16, null);
        }

        public final void c(boolean visible) {
            int i3;
            View view = this.root;
            if (visible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendViewHolder(@NotNull com.tencent.mobileqq.qwallet.hb.panel.a panelHost, @NotNull View view) {
        super(panelHost, view);
        Intrinsics.checkNotNullParameter(panelHost, "panelHost");
        Intrinsics.checkNotNullParameter(view, "view");
        this.skinHolder = new SkinTypeHolder(panelHost, view);
        this.promotionHolder = new PromotionTypeHolder(panelHost, view);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.panel.viewholder.a
    public void n(@Nullable Object item) {
        com.tencent.mobileqq.qwallet.pb.a aVar = (com.tencent.mobileqq.qwallet.pb.a) l(item);
        if (aVar == null) {
            return;
        }
        if (aVar instanceof a.Skin) {
            this.promotionHolder.c(false);
            this.skinHolder.c(true);
            this.skinHolder.b(((a.Skin) aVar).getValue());
        } else if (aVar instanceof a.Promotion) {
            this.skinHolder.c(false);
            this.promotionHolder.c(true);
            this.promotionHolder.b(((a.Promotion) aVar).getValue());
        }
    }
}
