package com.tencent.ecommerce.biz.orders.address;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.ecommerce.biz.orders.address.ECAddressListAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/a;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "getChangePayload", "", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$a;", "a", "Ljava/util/List;", "oldList", "b", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends DiffUtil.Callback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<ECAddressListAdapter.ECAddressItemData> oldList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<ECAddressListAdapter.ECAddressItemData> newList;

    public a(List<ECAddressListAdapter.ECAddressItemData> list, List<ECAddressListAdapter.ECAddressItemData> list2) {
        this.oldList = list;
        this.newList = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return Intrinsics.areEqual(this.oldList.get(oldItemPosition), this.newList.get(newItemPosition));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return this.oldList.get(oldItemPosition).getAddress().id == this.newList.get(newItemPosition).getAddress().id;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        if (Intrinsics.areEqual(this.oldList.get(oldItemPosition).getAddress(), this.newList.get(newItemPosition).getAddress())) {
            return Boolean.valueOf(this.newList.get(newItemPosition).getIsSelected());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.newList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.oldList.size();
    }
}
