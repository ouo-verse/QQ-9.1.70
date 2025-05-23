package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitAddressViewHolder;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitOrderViewHolder;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitPayInfoViewHolder;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.ECOrderSubmitVirtualProductAccountViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u000f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J,\u0010\u0013\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0016\u0010\u0016\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0017\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/g;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/q;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/p;", "", "newList", "", "n0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "i0", "", "", "payloads", "j0", "getItemViewType", "getItemCount", "m0", "l0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;", "itemOperationListener", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g extends RecyclerView.Adapter<q<? extends p>> {

    /* renamed from: C, reason: from kotlin metadata */
    private final OrderSubmitListItemOperationListener itemOperationListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<p> dataList = new ArrayList();

    public g(OrderSubmitListItemOperationListener orderSubmitListItemOperationListener) {
        this.itemOperationListener = orderSubmitListItemOperationListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.dataList.get(position).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(q<? extends p> holder, int position) {
        holder.m(this.dataList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(q<? extends p> holder, int position, List<Object> payloads) {
        holder.n(this.dataList.get(position), payloads);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(q<? extends p> holder) {
        holder.l();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(q<? extends p> holder) {
        holder.p();
    }

    public final void n0(List<? extends p> newList) {
        DiffUtil.calculateDiff(new f(newList, new ArrayList(this.dataList))).dispatchUpdatesTo(this);
        this.dataList.clear();
        this.dataList.addAll(newList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public q<p> onCreateViewHolder(ViewGroup parent, int viewType) {
        q<p> eCOrderSubmitAddressViewHolder;
        if (viewType == 1) {
            eCOrderSubmitAddressViewHolder = new ECOrderSubmitAddressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cut, parent, false), this.itemOperationListener);
        } else if (viewType == 3) {
            eCOrderSubmitAddressViewHolder = new com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.b(LayoutInflater.from(parent.getContext()).inflate(R.layout.cuu, parent, false));
        } else if (viewType == 4) {
            LinearLayout linearLayout = new LinearLayout(parent.getContext());
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            linearLayout.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6491p));
            eCOrderSubmitAddressViewHolder = new ECOrderSubmitPayInfoViewHolder(linearLayout, this.itemOperationListener);
        } else if (viewType == 5) {
            eCOrderSubmitAddressViewHolder = new ECOrderSubmitVirtualProductAccountViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cux, parent, false), this.itemOperationListener);
        } else if (viewType != 6) {
            eCOrderSubmitAddressViewHolder = new ECOrderSubmitOrderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cuw, parent, false), this.itemOperationListener);
        } else {
            eCOrderSubmitAddressViewHolder = new com.tencent.ecommerce.biz.orders.buyerorders.submit.viewholder.a(LayoutInflater.from(parent.getContext()).inflate(R.layout.f167322cp0, parent, false));
        }
        eCOrderSubmitAddressViewHolder.o();
        return eCOrderSubmitAddressViewHolder;
    }
}
