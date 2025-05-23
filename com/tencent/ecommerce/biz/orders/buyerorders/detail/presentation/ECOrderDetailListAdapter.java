package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.cache.service.PtsComposerCache;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECOrderDetailAccountInfoViewHolder;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECPayDetailViewHolder;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECQShopGoodsDetailViewHolder;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.ECSampleGoodsDetailViewHolder;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.h;
import com.tencent.ecommerce.biz.recommend.models.ECShopRecommendScene;
import com.tencent.ecommerce.biz.shophome.ui.view.ECShopCardView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u00011B\u0017\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020*\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tJ\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001e\u0010\u0014\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J,\u0010\u0018\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016R \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010%\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00030\u00030!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/ECOrderDetailListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/e;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "", "j0", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$g;", "newStateData", "o0", "", "newList", "n0", "destroy", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "k0", "", "", "payloads", "l0", "getItemViewType", "getItemCount", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$j;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "ptsComposerCache", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/AsyncListDiffer;", "asyncDiffer", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "D", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;", "nativeListener", "Lcom/tencent/ecommerce/biz/recommend/models/ECShopRecommendScene;", "E", "Lcom/tencent/ecommerce/biz/recommend/models/ECShopRecommendScene;", "recommendScene", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/a;Lcom/tencent/ecommerce/biz/recommend/models/ECShopRecommendScene;)V", UserInfo.SEX_FEMALE, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderDetailListAdapter extends RecyclerView.Adapter<e<? extends f>> {

    /* renamed from: D, reason: from kotlin metadata */
    private final a nativeListener;

    /* renamed from: E, reason: from kotlin metadata */
    private final ECShopRecommendScene recommendScene;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final PtsComposerCache<f.RecommendGoodsData, String> ptsComposerCache = new PtsComposerCache<>(new Function1<f.RecommendGoodsData, String>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailListAdapter$ptsComposerCache$1
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(f.RecommendGoodsData recommendGoodsData) {
            return recommendGoodsData.id;
        }
    }, new Function1<f.RecommendGoodsData, String>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailListAdapter$ptsComposerCache$2
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(f.RecommendGoodsData recommendGoodsData) {
            return recommendGoodsData.data;
        }
    }, null, null, 12, null);

    /* renamed from: C, reason: from kotlin metadata */
    private final AsyncListDiffer<f> asyncDiffer = new AsyncListDiffer<>(this, new b());

    public ECOrderDetailListAdapter(a aVar, ECShopRecommendScene eCShopRecommendScene) {
        this.nativeListener = aVar;
        this.recommendScene = eCShopRecommendScene;
    }

    private final void j0(e<?> eVar) {
        boolean z16 = !(eVar instanceof h);
        ViewGroup.LayoutParams layoutParams = eVar.itemView.getLayoutParams();
        if (!(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            layoutParams = null;
        }
        StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
        if (layoutParams2 == null) {
            layoutParams2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
        }
        layoutParams2.setFullSpan(z16);
        eVar.itemView.setLayoutParams(layoutParams2);
    }

    public final void destroy() {
        final List<f> currentList = this.asyncDiffer.getCurrentList();
        PtsComposerCache.i(this.ptsComposerCache, com.tencent.ecommerce.biz.recommend.models.b.a(this.recommendScene), new Function0<List<? extends f.RecommendGoodsData>>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailListAdapter$destroy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends f.RecommendGoodsData> invoke() {
                List list = currentList;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof f.RecommendGoodsData) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        }, new Function0<List<? extends f.RecommendGoodsData>>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailListAdapter$destroy$2
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends f.RecommendGoodsData> invoke() {
                List<? extends f.RecommendGoodsData> emptyList;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        }, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailListAdapter$destroy$3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, 8, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.asyncDiffer.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.asyncDiffer.getCurrentList().get(position).viewType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(e<? extends f> holder, int position) {
        j0(holder);
        holder.l(this.asyncDiffer.getCurrentList().get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(e<? extends f> holder, int position, List<Object> payloads) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }
        j0(holder);
        Iterator<T> it = payloads.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual("header_and_desc", it.next()) && this.asyncDiffer.getCurrentList().get(position).viewType == 1) {
                holder.l(this.asyncDiffer.getCurrentList().get(position));
            }
        }
    }

    public final void n0(final List<? extends f> newList) {
        cg0.a.b("ECOrderDetailListAdapter", "update list. size: " + newList.size());
        final List<f> currentList = this.asyncDiffer.getCurrentList();
        PtsComposerCache.i(this.ptsComposerCache, com.tencent.ecommerce.biz.recommend.models.b.a(this.recommendScene), new Function0<List<? extends f.RecommendGoodsData>>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailListAdapter$update$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends f.RecommendGoodsData> invoke() {
                List list = currentList;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof f.RecommendGoodsData) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        }, new Function0<List<? extends f.RecommendGoodsData>>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailListAdapter$update$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends f.RecommendGoodsData> invoke() {
                List list = newList;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof f.RecommendGoodsData) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        }, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailListAdapter$update$3
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
                AsyncListDiffer asyncListDiffer;
                asyncListDiffer = ECOrderDetailListAdapter.this.asyncDiffer;
                asyncListDiffer.submitList(newList);
            }
        }, 8, null);
    }

    public final void o0(f.OrderStateData newStateData) {
        List<f> mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.asyncDiffer.getCurrentList());
        int size = mutableList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (mutableList.get(i3) instanceof f.OrderStateData) {
                mutableList.set(i3, newStateData);
                this.asyncDiffer.submitList(mutableList);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public e<f> onCreateViewHolder(ViewGroup parent, int viewType) {
        e<f> gVar;
        switch (viewType) {
            case 1:
                gVar = new com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.g(LayoutInflater.from(parent.getContext()).inflate(R.layout.csv, parent, false));
                break;
            case 2:
                gVar = new com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.b(LayoutInflater.from(parent.getContext()).inflate(R.layout.csm, parent, false), this.nativeListener);
                break;
            case 3:
                gVar = new ECQShopGoodsDetailViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.csi, parent, false), this.nativeListener);
                break;
            case 4:
                gVar = new ECSampleGoodsDetailViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.csi, parent, false), this.nativeListener);
                break;
            case 5:
                gVar = new com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.a(LayoutInflater.from(parent.getContext()).inflate(R.layout.cse, parent, false), this.nativeListener);
                break;
            case 6:
                gVar = new ECPayDetailViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.csl, parent, false));
                break;
            case 7:
                gVar = new com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.e(LayoutInflater.from(parent.getContext()).inflate(R.layout.csk, parent, false), this.nativeListener);
                break;
            case 8:
                gVar = new g(LayoutInflater.from(parent.getContext()).inflate(R.layout.ctl, parent, false));
                break;
            case 9:
                StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                ECShopCardView eCShopCardView = new ECShopCardView(parent.getContext(), com.tencent.ecommerce.biz.util.e.c(4.0f));
                eCShopCardView.setLayoutParams(layoutParams);
                gVar = new h(eCShopCardView, this.ptsComposerCache, this.nativeListener);
                break;
            case 10:
                ImageView imageView = new ImageView(parent.getContext());
                imageView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(8.0f)));
                imageView.setBackgroundColor(ContextCompat.getColor(parent.getContext(), R.color.f7153h));
                gVar = new c(imageView);
                break;
            case 11:
                gVar = new ECOrderDetailAccountInfoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.csd, parent, false));
                break;
            case 12:
                gVar = new com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.c(LayoutInflater.from(parent.getContext()).inflate(R.layout.f167322cp0, parent, false));
                break;
            case 13:
                gVar = new com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.f(LayoutInflater.from(parent.getContext()).inflate(R.layout.cso, parent, false), this.nativeListener);
                break;
            case 14:
                gVar = new com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder.d(LayoutInflater.from(parent.getContext()).inflate(R.layout.csf, parent, false));
                break;
            default:
                throw new IllegalArgumentException("illegal viewType: " + viewType + " in ECOrderDetailListAdapter");
        }
        gVar.m();
        return gVar;
    }
}
