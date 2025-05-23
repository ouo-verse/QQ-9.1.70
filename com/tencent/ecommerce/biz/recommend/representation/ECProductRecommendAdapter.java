package com.tencent.ecommerce.biz.recommend.representation;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.cache.service.PtsComposerCache;
import com.tencent.ecommerce.biz.recommend.models.ECProductRecommendItemData;
import com.tencent.ecommerce.biz.shophome.ui.view.ECShopCardView;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.pts.core.PTSComposer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003*+,B#\u0012\u0006\u0010\"\u001a\u00020\u0017\u0012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0#\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0014\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u0010\u001a\u00020\nJ\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\r0\r0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006-"}, d2 = {"Lcom/tencent/ecommerce/biz/recommend/representation/ECProductRecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/recommend/representation/ECProductRecommendAdapter$c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "k0", "", "Lcom/tencent/ecommerce/biz/recommend/models/a;", "productList", "setData", "destroy", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "ptsComposerCache", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "D", "Landroidx/recyclerview/widget/AsyncListDiffer;", "asyncDiffer", "E", "Ljava/lang/String;", "pageName", "Lkotlin/Function1;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "onClickListener", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "G", "a", "b", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECProductRecommendAdapter extends RecyclerView.Adapter<c> {

    /* renamed from: E, reason: from kotlin metadata */
    private final String pageName;

    /* renamed from: F, reason: from kotlin metadata */
    private final Function1<String, Unit> onClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<ECProductRecommendItemData> data = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private final PtsComposerCache<ECProductRecommendItemData, String> ptsComposerCache = new PtsComposerCache<>(new Function1<ECProductRecommendItemData, String>() { // from class: com.tencent.ecommerce.biz.recommend.representation.ECProductRecommendAdapter$ptsComposerCache$1
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(ECProductRecommendItemData eCProductRecommendItemData) {
            return eCProductRecommendItemData.id;
        }
    }, new Function1<ECProductRecommendItemData, String>() { // from class: com.tencent.ecommerce.biz.recommend.representation.ECProductRecommendAdapter$ptsComposerCache$2
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(ECProductRecommendItemData eCProductRecommendItemData) {
            return eCProductRecommendItemData.getData();
        }
    }, null, null, 12, null);

    /* renamed from: D, reason: from kotlin metadata */
    private final AsyncListDiffer<ECProductRecommendItemData> asyncDiffer = new AsyncListDiffer<>(this, new b());

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/recommend/representation/ECProductRecommendAdapter$b;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/ecommerce/biz/recommend/models/a;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    private static final class b extends DiffUtil.ItemCallback<ECProductRecommendItemData> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(ECProductRecommendItemData oldItem, ECProductRecommendItemData newItem) {
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(ECProductRecommendItemData oldItem, ECProductRecommendItemData newItem) {
            return Intrinsics.areEqual(oldItem.id, newItem.id);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/recommend/representation/ECProductRecommendAdapter$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/ecommerce/biz/recommend/models/a;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECShopCardView;", "E", "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECShopCardView;", "ecShopCardView", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "ptsComposerCacheManager", "Lkotlin/Function1;", "G", "Lkotlin/jvm/functions/Function1;", "onClickListener", "<init>", "(Lcom/tencent/ecommerce/biz/shophome/ui/view/ECShopCardView;Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;Lkotlin/jvm/functions/Function1;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ECShopCardView ecShopCardView;

        /* renamed from: F, reason: from kotlin metadata */
        private final PtsComposerCache<ECProductRecommendItemData, String> ptsComposerCacheManager;

        /* renamed from: G, reason: from kotlin metadata */
        private final Function1<String, Unit> onClickListener;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f103954e;

            a(String str) {
                this.f103954e = str;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                c.this.onClickListener.invoke(this.f103954e);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(ECShopCardView eCShopCardView, PtsComposerCache<ECProductRecommendItemData, String> ptsComposerCache, Function1<? super String, Unit> function1) {
            super(eCShopCardView);
            this.ecShopCardView = eCShopCardView;
            this.ptsComposerCacheManager = ptsComposerCache;
            this.onClickListener = function1;
        }

        public final void m(ECProductRecommendItemData data) {
            String str;
            PTSComposer g16 = this.ptsComposerCacheManager.g(data);
            if (g16 != null) {
                ECShopCardView.h(this.ecShopCardView, g16, null, 2, null);
            }
            try {
                str = new JSONObject(data.getData()).optString("url");
            } catch (JSONException e16) {
                cg0.a.a("ECProductRecommendAdapter", "setData", "e=" + e16.getMessage());
                str = "";
            }
            this.ecShopCardView.setOnClickListener(new a(str));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECProductRecommendAdapter(String str, Function1<? super String, Unit> function1) {
        this.pageName = str;
        this.onClickListener = function1;
    }

    public final void destroy() {
        PtsComposerCache.i(this.ptsComposerCache, this.pageName, new Function0<List<? extends ECProductRecommendItemData>>() { // from class: com.tencent.ecommerce.biz.recommend.representation.ECProductRecommendAdapter$destroy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECProductRecommendItemData> invoke() {
                List<? extends ECProductRecommendItemData> list;
                list = ECProductRecommendAdapter.this.data;
                return list;
            }
        }, new Function0<List<? extends ECProductRecommendItemData>>() { // from class: com.tencent.ecommerce.biz.recommend.representation.ECProductRecommendAdapter$destroy$2
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECProductRecommendItemData> invoke() {
                List<? extends ECProductRecommendItemData> emptyList;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        }, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.recommend.representation.ECProductRecommendAdapter$destroy$3
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
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, int position) {
        holder.m(this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = e.c(6.0f);
        layoutParams.rightMargin = e.c(6.0f);
        layoutParams.bottomMargin = e.c(12.0f);
        ECShopCardView eCShopCardView = new ECShopCardView(parent.getContext(), e.c(4.0f));
        eCShopCardView.setLayoutParams(layoutParams);
        return new c(eCShopCardView, this.ptsComposerCache, this.onClickListener);
    }

    public final void setData(final List<ECProductRecommendItemData> productList) {
        PtsComposerCache.i(this.ptsComposerCache, this.pageName, new Function0<List<? extends ECProductRecommendItemData>>() { // from class: com.tencent.ecommerce.biz.recommend.representation.ECProductRecommendAdapter$setData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECProductRecommendItemData> invoke() {
                List<? extends ECProductRecommendItemData> list;
                list = ECProductRecommendAdapter.this.data;
                return list;
            }
        }, new Function0<List<? extends ECProductRecommendItemData>>() { // from class: com.tencent.ecommerce.biz.recommend.representation.ECProductRecommendAdapter$setData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECProductRecommendItemData> invoke() {
                return productList;
            }
        }, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.recommend.representation.ECProductRecommendAdapter$setData$3
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
                List list;
                List list2;
                asyncListDiffer = ECProductRecommendAdapter.this.asyncDiffer;
                asyncListDiffer.submitList(productList);
                list = ECProductRecommendAdapter.this.data;
                list.clear();
                list2 = ECProductRecommendAdapter.this.data;
                list2.addAll(productList);
            }
        }, 8, null);
    }
}
