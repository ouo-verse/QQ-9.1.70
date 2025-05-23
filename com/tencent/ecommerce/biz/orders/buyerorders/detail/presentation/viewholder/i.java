package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.TicketDetail;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000e\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J \u0010\n\u001a\u00020\t2\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00032\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u001e\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001f\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/i;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/viewholder/k;", "", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/TicketIdentifier;", "ids", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "detail", "", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "j0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "_dataList", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "i0", "()Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "getDataList", "()Ljava/util/List;", "dataList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class i extends RecyclerView.Adapter<k> {

    /* renamed from: C, reason: from kotlin metadata */
    private TicketDetail detail;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<String> _dataList = new ArrayList();

    public final List<String> getDataList() {
        List<String> list;
        list = CollectionsKt___CollectionsKt.toList(this._dataList);
        return list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this._dataList.size(), 10);
        return coerceAtMost;
    }

    /* renamed from: i0, reason: from getter */
    public final TicketDetail getDetail() {
        return this.detail;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(k holder, int position) {
        TicketDetail ticketDetail = this.detail;
        if (ticketDetail != null) {
            holder.o(this._dataList.get(position), ticketDetail, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public k onCreateViewHolder(ViewGroup parent, int viewType) {
        return new k(LayoutInflater.from(parent.getContext()).inflate(R.layout.csn, parent, false));
    }

    public final void l0(List<String> ids, TicketDetail detail) {
        this.detail = detail;
        this._dataList.clear();
        this._dataList.addAll(ids);
        notifyDataSetChanged();
    }
}
