package com.tencent.ecommerce.biz.shophome.ui.adapter;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.ecommerce.biz.shophome.model.ECShopCategoryInfo;
import com.tencent.ecommerce.biz.shophome.ui.view.ECCategoryItemClickListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000  *\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\b\u0010\r\u001a\u00020\fH\u0016R2\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u000ej\b\u0012\u0004\u0012\u00020\u0005`\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/adapter/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "Lcom/tencent/ecommerce/biz/shophome/model/b;", "newDataList", "", "setData", "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECCategoryItemClickListener;", "itemClickListener", "k0", "", "getItemCount", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "j0", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "dataList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECCategoryItemClickListener;", "i0", "()Lcom/tencent/ecommerce/biz/shophome/ui/view/ECCategoryItemClickListener;", "setCategoryItemClickListener", "(Lcom/tencent/ecommerce/biz/shophome/ui/view/ECCategoryItemClickListener;)V", "categoryItemClickListener", "<init>", "()V", "D", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class b<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    /* renamed from: C, reason: from kotlin metadata */
    private ECCategoryItemClickListener categoryItemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ArrayList<ECShopCategoryInfo> dataList = new ArrayList<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i0, reason: from getter */
    public final ECCategoryItemClickListener getCategoryItemClickListener() {
        return this.categoryItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<ECShopCategoryInfo> j0() {
        return this.dataList;
    }

    public final void k0(ECCategoryItemClickListener itemClickListener) {
        this.categoryItemClickListener = itemClickListener;
    }

    public final void setData(List<ECShopCategoryInfo> newDataList) {
        DiffUtil.calculateDiff(new c(newDataList, this.dataList)).dispatchUpdatesTo(this);
        this.dataList.clear();
        this.dataList.addAll(newDataList);
    }
}
