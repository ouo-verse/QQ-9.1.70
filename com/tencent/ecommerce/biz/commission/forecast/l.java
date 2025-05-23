package com.tencent.ecommerce.biz.commission.forecast;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u000f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/l;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/commission/forecast/d;", "Lcom/tencent/ecommerce/biz/commission/forecast/e;", "", "newList", "", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "i0", "getItemCount", "getItemViewType", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "dataList", "Lcom/tencent/ecommerce/biz/commission/forecast/ItemOperationListener;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/commission/forecast/ItemOperationListener;", "itemOperationListener", "<init>", "(Lcom/tencent/ecommerce/biz/commission/forecast/ItemOperationListener;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class l extends RecyclerView.Adapter<d<? extends e>> {

    /* renamed from: C, reason: from kotlin metadata */
    private final ItemOperationListener itemOperationListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<e> dataList = new ArrayList();

    public l(ItemOperationListener itemOperationListener) {
        this.itemOperationListener = itemOperationListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.dataList.get(position).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(d<? extends e> holder, int position) {
        holder.l(this.dataList.get(position));
    }

    public final void k0(List<? extends e> newList) {
        this.dataList.clear();
        this.dataList.addAll(newList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public d<e> onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            j jVar = new j(LayoutInflater.from(parent.getContext()).inflate(R.layout.cph, parent, false));
            jVar.m();
            return jVar;
        }
        if (viewType == 3) {
            g gVar = new g(LayoutInflater.from(parent.getContext()).inflate(R.layout.cq6, parent, false));
            gVar.m();
            return gVar;
        }
        if (viewType != 4) {
            a aVar = new a(LayoutInflater.from(parent.getContext()).inflate(R.layout.cpa, parent, false));
            aVar.m();
            return aVar;
        }
        i iVar = new i(LayoutInflater.from(parent.getContext()).inflate(R.layout.csa, parent, false), this.itemOperationListener);
        iVar.m();
        return iVar;
    }
}
