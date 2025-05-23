package com.tencent.ecommerce.biz.orders.common.orderListAdapter;

import ak0.ECSellerOrder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.cache.service.PtsComposerCache;
import com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004./01B'\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010&\u001a\u00020!\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0014\u0010\u0013\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "getItemCount", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "", "onBindViewHolder", "", "getItemId", "", "Lak0/a;", "orders", "setData", "", "Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "ordersOrSeparators", "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/base/cache/service/PtsComposerCache;", "ptsComposerCacheManager", "Landroid/content/Context;", "D", "Landroid/content/Context;", "context", "", "E", "Ljava/lang/String;", WadlProxyConsts.CHANNEL, UserInfo.SEX_FEMALE, "mediaId", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "G", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "ptsListener", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/pts/core/lite/IPTSLiteEventListener;)V", "H", "a", "b", "c", "d", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSellerOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: D, reason: from kotlin metadata */
    private final Context context;

    /* renamed from: E, reason: from kotlin metadata */
    private final String channel;

    /* renamed from: F, reason: from kotlin metadata */
    private final String mediaId;

    /* renamed from: G, reason: from kotlin metadata */
    private final IPTSLiteEventListener ptsListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<b> ordersOrSeparators = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private final PtsComposerCache<ECSellerOrder, Integer> ptsComposerCacheManager = new PtsComposerCache<>(new Function1<ECSellerOrder, Integer>() { // from class: com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter$ptsComposerCacheManager$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(ECSellerOrder eCSellerOrder) {
            return Integer.valueOf(invoke2(eCSellerOrder));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(ECSellerOrder eCSellerOrder) {
            return eCSellerOrder.dataJSONObject.hashCode();
        }
    }, new Function1<ECSellerOrder, String>() { // from class: com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter$ptsComposerCacheManager$2
        @Override // kotlin.jvm.functions.Function1
        public final String invoke(ECSellerOrder eCSellerOrder) {
            return eCSellerOrder.dataJSONObject.toString();
        }
    }, new Function1<Integer, IPTSLiteEventListener>() { // from class: com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter$ptsComposerCacheManager$3
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ IPTSLiteEventListener invoke(Integer num) {
            return invoke(num.intValue());
        }

        public final IPTSLiteEventListener invoke(int i3) {
            IPTSLiteEventListener iPTSLiteEventListener;
            iPTSLiteEventListener = ECSellerOrderAdapter.this.ptsListener;
            return iPTSLiteEventListener;
        }
    }, null, 8, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter$b;", "", "<init>", "()V", "a", "b", "Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter$b$b;", "Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter$b$a;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter$b$a;", "Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lak0/a;", "a", "Lak0/a;", "order", "<init>", "(Lak0/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter$b$a, reason: from toString */
        /* loaded from: classes31.dex */
        public static final /* data */ class OrderItem extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final ECSellerOrder order;

            public int hashCode() {
                ECSellerOrder eCSellerOrder = this.order;
                if (eCSellerOrder != null) {
                    return eCSellerOrder.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "OrderItem(order=" + this.order + ")";
            }

            public OrderItem(ECSellerOrder eCSellerOrder) {
                super(null);
                this.order = eCSellerOrder;
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof OrderItem) && Intrinsics.areEqual(this.order, ((OrderItem) other).order);
                }
                return true;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter$b$b;", "Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "groupTitle", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter$b$b, reason: collision with other inner class name and from toString */
        /* loaded from: classes31.dex */
        public static final /* data */ class SeparatorItem extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            public final String groupTitle;

            public int hashCode() {
                String str = this.groupTitle;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "SeparatorItem(groupTitle=" + this.groupTitle + ")";
            }

            public SeparatorItem(String str) {
                super(null);
                this.groupTitle = str;
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SeparatorItem) && Intrinsics.areEqual(this.groupTitle, ((SeparatorItem) other).groupTitle);
                }
                return true;
            }
        }

        b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/pts/core/itemview/PTSItemView;", "E", "Lcom/tencent/pts/core/itemview/PTSItemView;", "ptsItemView", "<init>", "(Lcom/tencent/pts/core/itemview/PTSItemView;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        public final PTSItemView ptsItemView;

        public c(PTSItemView pTSItemView) {
            super(pTSItemView);
            this.ptsItemView = pTSItemView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/ECSellerOrderAdapter$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "separatorView", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView titleView;

        public d(View view) {
            super(view);
            this.titleView = (TextView) view.findViewById(R.id.f163015nv0);
        }

        public final TextView getTitleView() {
            return this.titleView;
        }
    }

    public ECSellerOrderAdapter(Context context, String str, String str2, IPTSLiteEventListener iPTSLiteEventListener) {
        this.context = context;
        this.channel = str;
        this.mediaId = str2;
        this.ptsListener = iPTSLiteEventListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.ordersOrSeparators.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.ordersOrSeparators.get(position) instanceof b.OrderItem ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof c) {
            b bVar = this.ordersOrSeparators.get(position);
            if (bVar != null) {
                ECSellerOrder eCSellerOrder = ((b.OrderItem) bVar).order;
                PTSComposer g16 = this.ptsComposerCacheManager.g(eCSellerOrder);
                if (g16 != null) {
                    g16.layoutToView(((c) holder).ptsItemView);
                }
                com.tencent.ecommerce.biz.orders.common.d.f103680a.a("order_detail_order_card_exp", eCSellerOrder, this.channel, this.mediaId);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter.ItemData.OrderItem");
            }
        }
        if (holder instanceof d) {
            b bVar2 = this.ordersOrSeparators.get(position);
            if (bVar2 != null) {
                ((d) holder).getTitleView().setText(((b.SeparatorItem) bVar2).groupTitle);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter.ItemData.SeparatorItem");
        }
    }

    public final void setData(final List<ECSellerOrder> orders) {
        PtsComposerCache.i(this.ptsComposerCacheManager, "seller_order", new Function0<List<? extends ECSellerOrder>>() { // from class: com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter$setData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECSellerOrder> invoke() {
                List list;
                int collectionSizeOrDefault;
                List<? extends ECSellerOrder> list2;
                list = ECSellerOrderAdapter.this.ordersOrSeparators;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (obj instanceof ECSellerOrderAdapter.b.OrderItem) {
                        arrayList.add(obj);
                    }
                }
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((ECSellerOrderAdapter.b.OrderItem) it.next()).order);
                }
                list2 = CollectionsKt___CollectionsKt.toList(arrayList2);
                return list2;
            }
        }, new Function0<List<? extends ECSellerOrder>>() { // from class: com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter$setData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends ECSellerOrder> invoke() {
                return orders;
            }
        }, null, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.common.orderListAdapter.ECSellerOrderAdapter$setData$3
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
                List list;
                List list2;
                List list3;
                int collectionSizeOrDefault;
                list = ECSellerOrderAdapter.this.ordersOrSeparators;
                list.clear();
                List list4 = orders;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : list4) {
                    String str = ((ECSellerOrder) obj).createTime;
                    Object obj2 = linkedHashMap.get(str);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(str, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    List list5 = (List) entry.getValue();
                    list2 = ECSellerOrderAdapter.this.ordersOrSeparators;
                    list2.add(new ECSellerOrderAdapter.b.SeparatorItem(str2 + " \uff08\u5171" + list5.size() + "\u5355\uff09"));
                    list3 = ECSellerOrderAdapter.this.ordersOrSeparators;
                    List list6 = list5;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list6, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it = list6.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new ECSellerOrderAdapter.b.OrderItem((ECSellerOrder) it.next()));
                    }
                    list3.addAll(arrayList);
                }
                ECSellerOrderAdapter.this.notifyDataSetChanged();
                cg0.a.b("SellerOrderAdapter", "notify data changed");
            }
        }, 8, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 2) {
            return new c(new PTSItemView(parent.getContext()));
        }
        return new d(LayoutInflater.from(this.context).inflate(R.layout.csr, (ViewGroup) null));
    }
}
