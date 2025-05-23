package com.tencent.sqshow.zootopia.brand.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanCardHelper;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.brand.list.view.ZplanBrandItemView;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r84.ZootopiaBrandMallItemData;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002/0BA\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0018\b\u0002\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00040#j\b\u0012\u0004\u0012\u00020\u0004`$\u00a2\u0006\u0004\b,\u0010-J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u001c\u0010\u0012\u001a\u00020\u00112\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\bH\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00040#j\b\u0012\u0004\u0012\u00020\u0004`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00061"}, d2 = {"Lcom/tencent/sqshow/zootopia/brand/list/a;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/sqshow/zootopia/brand/list/a$b;", "", "Lr84/a;", "cardDatas", "", "fillList", "", "getItemCount", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "p", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Loa4/a;", "e", "Loa4/a;", "mapResViewModel", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", h.F, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "dataList", "Lid3/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lid3/d;", "reportHelper", "<init>", "(Landroid/content/Context;Loa4/a;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/util/ArrayList;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends RecyclerView.Adapter<b> {
    private static final int D = ViewUtils.dpToPx(16.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final oa4.a mapResViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ZootopiaBrandMallItemData> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final id3.d reportHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/brand/list/a$b;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/sqshow/zootopia/brand/list/a;Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f370124d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.f370124d = aVar;
        }
    }

    public /* synthetic */ a(Context context, oa4.a aVar, LifecycleOwner lifecycleOwner, ZootopiaSource zootopiaSource, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, aVar, lifecycleOwner, zootopiaSource, (i3 & 16) != 0 ? new ArrayList() : arrayList);
    }

    public final boolean fillList(List<ZootopiaBrandMallItemData> cardDatas) {
        Intrinsics.checkNotNullParameter(cardDatas, "cardDatas");
        this.dataList.clear();
        this.dataList.addAll(cardDatas);
        notifyDataSetChanged();
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        ZootopiaBrandMallItemData zootopiaBrandMallItemData = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(zootopiaBrandMallItemData, "dataList[position]");
        ZootopiaBrandMallItemData zootopiaBrandMallItemData2 = zootopiaBrandMallItemData;
        if (zootopiaBrandMallItemData2.getBrandStore() != null) {
            return 202205;
        }
        if (zootopiaBrandMallItemData2.getCardData() != null) {
            return k84.b.INSTANCE.b(zootopiaBrandMallItemData2.getCardData());
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ZootopiaBrandMallItemData zootopiaBrandMallItemData = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(zootopiaBrandMallItemData, "dataList[position]");
        ZootopiaBrandMallItemData zootopiaBrandMallItemData2 = zootopiaBrandMallItemData;
        View view = holder.itemView;
        if (view instanceof l84.a) {
            ZootopiaCardData cardData = zootopiaBrandMallItemData2.getCardData();
            if (cardData != null) {
                View view2 = holder.itemView;
                if (view2 instanceof ZootopiaBaseCard) {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard");
                    ((ZootopiaBaseCard) view2).j(cardData, position, getItemCount());
                }
                KeyEvent.Callback callback = holder.itemView;
                Intrinsics.checkNotNull(callback, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.card.base.IZootopiaCard");
                ((l84.a) callback).f(cardData, position, getItemCount());
                return;
            }
            return;
        }
        if (view instanceof ZplanBrandItemView) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.brand.list.view.ZplanBrandItemView");
            ((ZplanBrandItemView) view).b(zootopiaBrandMallItemData2.getBrandStore(), zootopiaBrandMallItemData2.getBrandStoreIndex());
            return;
        }
        QLog.e("ZplanBrandListAdapter", 1, "onBindViewHolder " + position + "  error not valid - " + view + " - " + zootopiaBrandMallItemData2);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 202205) {
            ZplanBrandItemView zplanBrandItemView = new ZplanBrandItemView(this.context);
            Context context = zplanBrandItemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            zplanBrandItemView.e(context);
            return new b(this, zplanBrandItemView);
        }
        return new b(this, ((IZPlanCardHelper) QRoute.api(IZPlanCardHelper.class)).createCard(viewType, this.context, this.owner, this.mapResViewModel, this.sourceCurrent));
    }

    public a(Context context, oa4.a mapResViewModel, LifecycleOwner owner, ZootopiaSource sourceCurrent, ArrayList<ZootopiaBrandMallItemData> dataList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.context = context;
        this.mapResViewModel = mapResViewModel;
        this.owner = owner;
        this.sourceCurrent = sourceCurrent;
        this.dataList = dataList;
        this.reportHelper = new id3.d(null, 1, null);
    }
}
