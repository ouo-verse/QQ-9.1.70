package com.tencent.ecommerce.base.ui;

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
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u001c\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0015j\u0002`\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R*\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0015j\u0002`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/ecommerce/base/ui/k;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/base/ui/a;", "", "Lcom/tencent/ecommerce/base/ui/j;", "options", "", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "i0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "optionList", "Lkotlin/Function2;", "", "Lcom/tencent/ecommerce/base/ui/ItemClick;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "itemClick", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class k extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Function2<String, Integer, Unit> itemClick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<ItemData> optionList = new ArrayList();

    /* JADX WARN: Multi-variable type inference failed */
    public k(Function2<? super String, ? super Integer, Unit> function2) {
        this.itemClick = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.optionList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        holder.p(this.optionList.get(position));
        holder.o();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        return new a(this.itemClick, LayoutInflater.from(parent.getContext()).inflate(R.layout.ctw, parent, false));
    }

    public final void k0(List<ItemData> options) {
        this.optionList.clear();
        List<ItemData> list = options;
        if (!list.isEmpty()) {
            this.optionList.addAll(list);
        }
        notifyDataSetChanged();
    }
}
