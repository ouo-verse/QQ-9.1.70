package com.tencent.ecommerce.biz.orders.common.orderListAdapter;

import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0019\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/common/orderListAdapter/a;", "T", "Landroid/widget/BaseAdapter;", "", "data", "", "setData", "", "getCount", "position", "getItem", "(I)Ljava/lang/Object;", "", "getItemId", "", "d", "Ljava/util/List;", "dataList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class a<T> extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<T> dataList = new ArrayList();

    @Override // android.widget.Adapter
    public int getCount() {
        List<T> list = this.dataList;
        if (list == null) {
            return 0;
        }
        Intrinsics.checkNotNull(list);
        return list.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int position) {
        List<T> list = this.dataList;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            if (position < list.size()) {
                List<T> list2 = this.dataList;
                Intrinsics.checkNotNull(list2);
                return list2.get(position);
            }
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public final void setData(List<? extends T> data) {
        List<T> list = this.dataList;
        Intrinsics.checkNotNull(list);
        list.clear();
        if (data != null) {
            List<? extends T> list2 = data;
            if (!list2.isEmpty()) {
                List<T> list3 = this.dataList;
                Intrinsics.checkNotNull(list3);
                list3.addAll(list2);
            }
        }
        notifyDataSetChanged();
    }
}
