package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/b;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f;", "oldItem", "newItem", "", "b", "a", "", "c", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
final class b extends DiffUtil.ItemCallback<f> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(f oldItem, f newItem) {
        int i3 = oldItem.viewType;
        if (i3 != newItem.viewType) {
            return false;
        }
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 11:
            case 12:
            case 13:
            case 14:
                return Intrinsics.areEqual(oldItem, newItem);
            case 8:
            case 10:
                return true;
            case 9:
                return Intrinsics.areEqual(((f.RecommendGoodsData) oldItem).id, ((f.RecommendGoodsData) newItem).id);
            default:
                return false;
        }
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(f oldItem, f newItem) {
        if ((oldItem instanceof f.RecommendGoodsData) && (newItem instanceof f.RecommendGoodsData)) {
            return Intrinsics.areEqual(((f.RecommendGoodsData) oldItem).id, ((f.RecommendGoodsData) newItem).id);
        }
        return oldItem.viewType == newItem.viewType;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Object getChangePayload(f oldItem, f newItem) {
        int i3 = oldItem.viewType;
        if (i3 != newItem.viewType) {
            return super.getChangePayload(oldItem, newItem);
        }
        if (i3 == 1) {
            if (((f.OrderStateData) oldItem).stateKey == ((f.OrderStateData) newItem).stateKey && ((!Intrinsics.areEqual(r0.stateTitleStr, r2.stateTitleStr)) || (!Intrinsics.areEqual(r0.stateDescStr, r2.stateDescStr)))) {
                return "header_and_desc";
            }
        }
        return super.getChangePayload(oldItem, newItem);
    }
}
