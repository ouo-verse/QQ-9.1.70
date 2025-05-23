package com.tencent.mobileqq.zplan.card.impl.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.guide.ZplanGuideManager;
import com.tencent.sqshow.zootopia.guide.i;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import pu4.g;
import pv4.p;
import pv4.s;
import pv4.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u000401\u00122B/\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010,\u001a\u00020\u000e\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u000e8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaVerticalGalleryCard;", "Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaBaseGuideViewCard;", "", "O", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "f", "c", "Landroidx/viewpager2/widget/ViewPager2;", "a0", "Lkotlin/Lazy;", "N", "()Landroidx/viewpager2/widget/ViewPager2;", "mZplanRecommendVgViewPager", "b0", "I", "E", "()I", "groupId", "Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaVerticalGalleryCard$b;", "c0", "Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaVerticalGalleryCard$b;", "M", "()Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaVerticalGalleryCard$b;", "setAdapter", "(Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaVerticalGalleryCard$b;)V", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "d0", "a", "b", "GalleryViewHolder", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaVerticalGalleryCard extends ZootopiaBaseGuideViewCard {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final Lazy mZplanRecommendVgViewPager;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final int groupId;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    public b adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00128FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001e\u001a\u00020\u001a8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010!\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u000bR\u001b\u0010$\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u000b\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaVerticalGalleryCard$GalleryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "E", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "mZplanRecommendItemContainer", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", UserInfo.SEX_FEMALE, "l", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "mCardImage", "Landroid/widget/RelativeLayout;", "G", "o", "()Landroid/widget/RelativeLayout;", "mInfoContainer", "Landroid/widget/TextView;", "H", "r", "()Landroid/widget/TextView;", "mTitleDesc", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mDetailDesc", "Landroid/widget/ImageView;", "J", "getMIconImage", "()Landroid/widget/ImageView;", "mIconImage", "K", "p", "mLeftIconImage", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mRightIconImage", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class GalleryViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final Lazy mZplanRecommendItemContainer;

        /* renamed from: F, reason: from kotlin metadata */
        private final Lazy mCardImage;

        /* renamed from: G, reason: from kotlin metadata */
        private final Lazy mInfoContainer;

        /* renamed from: H, reason: from kotlin metadata */
        private final Lazy mTitleDesc;

        /* renamed from: I, reason: from kotlin metadata */
        private final Lazy mDetailDesc;

        /* renamed from: J, reason: from kotlin metadata */
        private final Lazy mIconImage;

        /* renamed from: K, reason: from kotlin metadata */
        private final Lazy mLeftIconImage;

        /* renamed from: L, reason: from kotlin metadata */
        private final Lazy mRightIconImage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GalleryViewHolder(final View itemView) {
            super(itemView);
            Lazy lazy;
            Lazy lazy2;
            Lazy lazy3;
            Lazy lazy4;
            Lazy lazy5;
            Lazy lazy6;
            Lazy lazy7;
            Lazy lazy8;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoundRelativeLayout>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard$GalleryViewHolder$mZplanRecommendItemContainer$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final RoundRelativeLayout invoke() {
                    return (RoundRelativeLayout) itemView.findViewById(R.id.r7_);
                }
            });
            this.mZplanRecommendItemContainer = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanMediaView>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard$GalleryViewHolder$mCardImage$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ZPlanMediaView invoke() {
                    return (ZPlanMediaView) itemView.findViewById(R.id.pi9);
                }
            });
            this.mCardImage = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard$GalleryViewHolder$mInfoContainer$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final RelativeLayout invoke() {
                    return (RelativeLayout) itemView.findViewById(R.id.q1y);
                }
            });
            this.mInfoContainer = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard$GalleryViewHolder$mTitleDesc$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    return (TextView) itemView.findViewById(R.id.qra);
                }
            });
            this.mTitleDesc = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard$GalleryViewHolder$mDetailDesc$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    return (TextView) itemView.findViewById(R.id.f163360pp4);
                }
            });
            this.mDetailDesc = lazy5;
            lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard$GalleryViewHolder$mIconImage$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ImageView invoke() {
                    return (ImageView) itemView.findViewById(R.id.q0e);
                }
            });
            this.mIconImage = lazy6;
            lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanMediaView>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard$GalleryViewHolder$mLeftIconImage$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ZPlanMediaView invoke() {
                    return (ZPlanMediaView) itemView.findViewById(R.id.q4n);
                }
            });
            this.mLeftIconImage = lazy7;
            lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanMediaView>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard$GalleryViewHolder$mRightIconImage$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ZPlanMediaView invoke() {
                    return (ZPlanMediaView) itemView.findViewById(R.id.qho);
                }
            });
            this.mRightIconImage = lazy8;
        }

        public final ZPlanMediaView l() {
            Object value = this.mCardImage.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardImage>(...)");
            return (ZPlanMediaView) value;
        }

        public final TextView m() {
            Object value = this.mDetailDesc.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mDetailDesc>(...)");
            return (TextView) value;
        }

        public final RelativeLayout o() {
            Object value = this.mInfoContainer.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mInfoContainer>(...)");
            return (RelativeLayout) value;
        }

        public final ZPlanMediaView p() {
            Object value = this.mLeftIconImage.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mLeftIconImage>(...)");
            return (ZPlanMediaView) value;
        }

        public final ZPlanMediaView q() {
            Object value = this.mRightIconImage.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mRightIconImage>(...)");
            return (ZPlanMediaView) value;
        }

        public final TextView r() {
            Object value = this.mTitleDesc.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mTitleDesc>(...)");
            return (TextView) value;
        }

        public final RoundRelativeLayout s() {
            Object value = this.mZplanRecommendItemContainer.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mZplanRecommendItemContainer>(...)");
            return (RoundRelativeLayout) value;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaVerticalGalleryCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ViewPager2>() { // from class: com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard$mZplanRecommendVgViewPager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewPager2 invoke() {
                return (ViewPager2) ZootopiaVerticalGalleryCard.this.findViewById(R.id.r7i);
            }
        });
        this.mZplanRecommendVgViewPager = lazy;
        this.groupId = 8;
    }

    private final ViewPager2 N() {
        Object value = this.mZplanRecommendVgViewPager.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mZplanRecommendVgViewPager>(...)");
        return (ViewPager2) value;
    }

    private final void O() {
        N().setPageTransformer(new c());
        N().setOffscreenPageLimit(2);
        ViewPager2 N = N();
        ViewGroup.LayoutParams layoutParams = N().getLayoutParams();
        int dip2px = ViewUtils.dip2px(235.0f);
        int screenWidth = (int) (ViewUtils.getScreenWidth() * 0.626f);
        layoutParams.height = screenWidth;
        float f16 = screenWidth / dip2px;
        N.setLayoutParams(layoutParams);
        View childAt = N().getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) childAt;
        int screenWidth2 = ((ViewUtils.getScreenWidth() - N().getPaddingLeft()) - N().getPaddingRight()) / 3;
        float f17 = f16 * 15.0f;
        recyclerView.setPadding(screenWidth2, ViewUtils.dip2px(f17), screenWidth2, ViewUtils.dip2px(f17));
        QLog.d("ZootopiaVerticalGalleryCard", 4, "padding:" + screenWidth2);
        recyclerView.setClipToPadding(false);
        N().setClipChildren(true);
        N().setPageTransformer(new c());
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.ZootopiaBaseGuideViewCard
    /* renamed from: E, reason: from getter */
    protected int getGroupId() {
        return this.groupId;
    }

    public final b M() {
        b bVar = this.adapter;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.ZootopiaBaseGuideViewCard, l84.a
    public void f(ZootopiaCardData dataInfo, int position, int totalCount) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        O();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setAdapter(new b(dataInfo, position, context));
        N().setAdapter(M());
        RecyclerView.Adapter adapter = N().getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard.GalleryAdapter");
        int realItemSize = ((b) adapter).getRealItemSize();
        RecyclerView.Adapter adapter2 = N().getAdapter();
        Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard.GalleryAdapter");
        int j06 = ((b) adapter2).j0(LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        if (realItemSize != 0 && j06 != -1) {
            N().setCurrentItem(LockFreeTaskQueueCore.MAX_CAPACITY_MASK - j06, false);
        }
        ((TextView) findViewById(R.id.r9a)).setText(R.string.xpu);
        super.f(dataInfo, position, totalCount);
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        viewParent.setClipChildren(false);
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        View containerView = from.inflate(R.layout.d8y, viewParent);
        J(containerView.findViewById(R.id.r8w));
        Intrinsics.checkNotNullExpressionValue(containerView, "containerView");
        return containerView;
    }

    public final void setAdapter(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.adapter = bVar;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZootopiaVerticalGalleryCard";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005R\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaVerticalGalleryCard$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaVerticalGalleryCard$GalleryViewHolder;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "", "k0", "getItemCount", "itemPos", "j0", "getRealItemSize", "Lcom/tencent/sqshow/zootopia/data/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/data/c;", "getZootopiaCardData", "()Lcom/tencent/sqshow/zootopia/data/c;", "zootopiaCardData", BdhLogUtil.LogTag.Tag_Conn, "I", "getCardPos", "()I", "cardPos", "Landroid/content/Context;", "D", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/card/report/a;", "E", "Lcom/tencent/sqshow/zootopia/card/report/a;", "mCardReporter", "<init>", "(Lcom/tencent/sqshow/zootopia/data/c;ILandroid/content/Context;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.Adapter<GalleryViewHolder> {

        /* renamed from: C, reason: from kotlin metadata */
        private final int cardPos;

        /* renamed from: D, reason: from kotlin metadata */
        private final Context context;

        /* renamed from: E, reason: from kotlin metadata */
        private final com.tencent.sqshow.zootopia.card.report.a mCardReporter;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final ZootopiaCardData zootopiaCardData;

        public b(ZootopiaCardData zootopiaCardData, int i3, Context context) {
            Intrinsics.checkNotNullParameter(zootopiaCardData, "zootopiaCardData");
            Intrinsics.checkNotNullParameter(context, "context");
            this.zootopiaCardData = zootopiaCardData;
            this.cardPos = i3;
            this.context = context;
            this.mCardReporter = new com.tencent.sqshow.zootopia.card.report.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return Integer.MAX_VALUE;
        }

        public final int getRealItemSize() {
            List<s> c16 = this.zootopiaCardData.c();
            if (c16 != null) {
                return c16.size();
            }
            return 0;
        }

        public final int j0(int itemPos) {
            List<s> c16 = this.zootopiaCardData.c();
            int size = c16 != null ? c16.size() : 0;
            if (size == 0) {
                return -1;
            }
            return itemPos % size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.d8z, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026lery_item, parent, false)");
            return new GalleryViewHolder(inflate);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l0(int i3, s sceneIndexModuleDetail, b this$0, GalleryViewHolder holder, String elementType, View view) {
            Intrinsics.checkNotNullParameter(sceneIndexModuleDetail, "$sceneIndexModuleDetail");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(holder, "$holder");
            Intrinsics.checkNotNullParameter(elementType, "$elementType");
            QLog.d("ZootopiaVerticalGalleryCard", 4, "realPos:" + i3 + " url:" + sceneIndexModuleDetail.f427682c);
            com.tencent.sqshow.zootopia.card.report.a aVar = this$0.mCardReporter;
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            aVar.a(view2, this$0.cardPos, i3, elementType, this$0.zootopiaCardData, sceneIndexModuleDetail, (r20 & 64) != 0 ? new HashMap() : null, (r20 & 128) != 0 ? "em_zplan_element" : null);
            i.a.b(ZplanGuideManager.INSTANCE.a(), 6, 8, 0, 4, null);
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = this$0.context;
            String str = sceneIndexModuleDetail.f427682c;
            Intrinsics.checkNotNullExpressionValue(str, "sceneIndexModuleDetail.jumpUrl");
            iSchemeApi.launchScheme(context, str);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onBindViewHolder(final GalleryViewHolder holder, int position) {
            final s sVar;
            boolean z16;
            boolean isBlank;
            String str;
            String str2;
            Intrinsics.checkNotNullParameter(holder, "holder");
            final int j06 = j0(position);
            if (j06 == -1) {
                return;
            }
            QLog.d("ZootopiaVerticalGalleryCard", 4, "onBindViewHolder realPos:" + j06);
            List<s> c16 = this.zootopiaCardData.c();
            if (c16 == null || (sVar = c16.get(j06)) == null) {
                return;
            }
            holder.r().setText("");
            u uVar = sVar.f427683d;
            if (uVar != null && (str2 = uVar.f427702a) != null) {
                holder.r().setText(str2);
            }
            holder.m().setText("");
            u uVar2 = sVar.f427680a;
            if (uVar2 != null && (str = uVar2.f427702a) != null) {
                holder.m().setText(str);
            }
            holder.m().setVisibility(4);
            RelativeLayout o16 = holder.o();
            CharSequence text = holder.r().getText();
            if (text != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(text);
                if (!isBlank) {
                    z16 = false;
                    o16.setVisibility(!z16 ? 4 : 0);
                    holder.s().f316195e = ViewUtils.dip2px(6.0f);
                    final String g16 = a.Companion.g(com.tencent.sqshow.zootopia.card.report.a.INSTANCE, sVar.f427681b, null, 2, null);
                    aa.d(holder.s(), new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ZootopiaVerticalGalleryCard.b.l0(j06, sVar, this, holder, g16, view);
                        }
                    });
                    holder.l().setRadius(6);
                    holder.l().setTag(sVar.f427681b);
                    ZPlanMediaView l3 = holder.l();
                    g gVar = sVar.f427681b;
                    Intrinsics.checkNotNullExpressionValue(gVar, "sceneIndexModuleDetail.material");
                    l3.J(gVar);
                    holder.p().setVisibility(4);
                    holder.q().setVisibility(4);
                    p[] pVarArr = sVar.f427685f;
                    Intrinsics.checkNotNullExpressionValue(pVarArr, "sceneIndexModuleDetail.labels");
                    for (p pVar : pVarArr) {
                        int i3 = pVar.f427652b;
                        if (i3 == 0) {
                            holder.p().setVisibility(0);
                            ZPlanMediaView p16 = holder.p();
                            g gVar2 = pVar.f427651a;
                            Intrinsics.checkNotNullExpressionValue(gVar2, "label.material");
                            p16.e(gVar2);
                        } else if (i3 == 1) {
                            holder.q().setVisibility(0);
                            ZPlanMediaView q16 = holder.q();
                            g gVar3 = pVar.f427651a;
                            Intrinsics.checkNotNullExpressionValue(gVar3, "label.material");
                            q16.e(gVar3);
                        }
                    }
                    com.tencent.sqshow.zootopia.card.report.a aVar = this.mCardReporter;
                    View view = holder.itemView;
                    Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
                    aVar.c(view, this.cardPos, j06, g16, this.zootopiaCardData, sVar, (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : null, (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
                }
            }
            z16 = true;
            o16.setVisibility(!z16 ? 4 : 0);
            holder.s().f316195e = ViewUtils.dip2px(6.0f);
            final String g162 = a.Companion.g(com.tencent.sqshow.zootopia.card.report.a.INSTANCE, sVar.f427681b, null, 2, null);
            aa.d(holder.s(), new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.card.impl.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ZootopiaVerticalGalleryCard.b.l0(j06, sVar, this, holder, g162, view2);
                }
            });
            holder.l().setRadius(6);
            holder.l().setTag(sVar.f427681b);
            ZPlanMediaView l36 = holder.l();
            g gVar4 = sVar.f427681b;
            Intrinsics.checkNotNullExpressionValue(gVar4, "sceneIndexModuleDetail.material");
            l36.J(gVar4);
            holder.p().setVisibility(4);
            holder.q().setVisibility(4);
            p[] pVarArr2 = sVar.f427685f;
            Intrinsics.checkNotNullExpressionValue(pVarArr2, "sceneIndexModuleDetail.labels");
            while (r2 < r1) {
            }
            com.tencent.sqshow.zootopia.card.report.a aVar2 = this.mCardReporter;
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            aVar2.c(view2, this.cardPos, j06, g162, this.zootopiaCardData, sVar, (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : null, (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/ZootopiaVerticalGalleryCard$c;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "Landroid/widget/RelativeLayout;", "infoContainer", "", "position", "Landroid/widget/ImageView;", "iconImage", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "leftIcon", "rightIcon", "", "a", "Landroid/view/View;", "view", "transformPage", "", "I", "pagerWidth", "b", UserInfo.SEX_FEMALE, "horizontalOffsetBase", "<init>", "()V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements ViewPager2.PageTransformer {

        /* renamed from: d, reason: collision with root package name */
        private static float f332052d;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int pagerWidth;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float horizontalOffsetBase;

        private final void a(RelativeLayout infoContainer, float position, ImageView iconImage, ZPlanMediaView leftIcon, ZPlanMediaView rightIcon) {
            infoContainer.setAlpha(1.0f - Math.abs(position));
            iconImage.setAlpha(1.0f - Math.abs(position));
            leftIcon.setAlpha(1.0f - Math.abs(position));
            rightIcon.setAlpha(1.0f - Math.abs(position));
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x01ae  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x01ba  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x01bc  */
        @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void transformPage(View view, float position) {
            boolean z16;
            Intrinsics.checkNotNullParameter(view, "view");
            RelativeLayout infoContainer = (RelativeLayout) view.findViewById(R.id.q1y);
            ImageView iconImage = (ImageView) view.findViewById(R.id.q0e);
            ZPlanMediaView zPlanMediaView = (ZPlanMediaView) view.findViewById(R.id.pi9);
            ZPlanMediaView leftIcon = (ZPlanMediaView) view.findViewById(R.id.q4n);
            ZPlanMediaView rightIcon = (ZPlanMediaView) view.findViewById(R.id.qho);
            int width = view.getWidth();
            int height = view.getHeight() / 2;
            view.setPivotX(width / 2);
            view.setPivotY(height);
            infoContainer.setAlpha(0.0f);
            iconImage.setAlpha(0.0f);
            if (f332052d == 0.0f) {
                f332052d = width / 2.0f;
            }
            if (position == 0.0f) {
                QLog.d("ZootopiaVerticalGalleryCard", 4, "Pos:" + position + " StartPlay");
                Object tag = zPlanMediaView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.trpcprotocol.zplan.common.nano.Material");
                zPlanMediaView.e((g) tag);
                leftIcon.setAlpha(1.0f);
                rightIcon.setAlpha(1.0f);
            } else {
                if (position % ((float) 1) == 0.0f) {
                    QLog.d("ZootopiaVerticalGalleryCard", 4, "Pos:" + position + " StopPlay");
                    zPlanMediaView.stop();
                    leftIcon.setAlpha(0.0f);
                    rightIcon.setAlpha(0.0f);
                }
            }
            view.setClickable(position == 0.0f);
            if (position <= -2.0f) {
                view.setRotationY(0.0f);
            } else if (position > -2.0f && position < -1.0f) {
                float f16 = 2 + position;
                view.setRotationY((15 * Math.abs(f16)) + (0 * (1 - Math.abs(f16))));
            } else if (position <= 0.0f) {
                float f17 = (0.20000005f * position) + 1.2f;
                view.setRotationY(15 * Math.abs(position));
                view.setScaleX(f17);
                view.setScaleY(f17);
                Intrinsics.checkNotNullExpressionValue(infoContainer, "infoContainer");
                Intrinsics.checkNotNullExpressionValue(iconImage, "iconImage");
                Intrinsics.checkNotNullExpressionValue(leftIcon, "leftIcon");
                Intrinsics.checkNotNullExpressionValue(rightIcon, "rightIcon");
                a(infoContainer, position, iconImage, leftIcon, rightIcon);
            } else if (position <= 1.0f) {
                float f18 = ((-0.20000005f) * position) + 1.2f;
                view.setRotationY((-15) * Math.abs(position));
                view.setScaleX(f18);
                view.setScaleY(f18);
                Intrinsics.checkNotNullExpressionValue(infoContainer, "infoContainer");
                Intrinsics.checkNotNullExpressionValue(iconImage, "iconImage");
                Intrinsics.checkNotNullExpressionValue(leftIcon, "leftIcon");
                Intrinsics.checkNotNullExpressionValue(rightIcon, "rightIcon");
                a(infoContainer, position, iconImage, leftIcon, rightIcon);
            } else {
                if (position > 1.0f && position < 2.0f) {
                    float f19 = position - 2;
                    z16 = false;
                    view.setRotationY(((-15) * Math.abs(f19)) + (0 * (1 - Math.abs(f19))));
                } else {
                    z16 = false;
                    view.setRotationY(-0.0f);
                }
                view.setTranslationZ(-Math.abs(position));
                if (this.pagerWidth == 0) {
                    this.pagerWidth = view.getWidth();
                }
                if (this.horizontalOffsetBase != 0.0f ? true : z16) {
                    this.horizontalOffsetBase = f332052d;
                }
                view.setTranslationX((f332052d - this.pagerWidth) * position);
                if (position <= -3.0f && position < 3.0f) {
                    view.setAlpha(1.0f);
                    return;
                } else {
                    view.setAlpha(0.0f);
                }
            }
            z16 = false;
            view.setTranslationZ(-Math.abs(position));
            if (this.pagerWidth == 0) {
            }
            if (this.horizontalOffsetBase != 0.0f ? true : z16) {
            }
            view.setTranslationX((f332052d - this.pagerWidth) * position);
            if (position <= -3.0f) {
            }
            view.setAlpha(0.0f);
        }
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard, l84.a
    public void c() {
    }
}
