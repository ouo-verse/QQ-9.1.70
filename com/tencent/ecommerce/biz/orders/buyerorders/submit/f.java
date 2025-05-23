package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.PayType;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/f;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/b;", QCircleDaTongConstant.ElementParamValue.NEW, "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/o;", "", "c", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/r;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/PayType;", "b", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "getChangePayload", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/p;", "Ljava/util/List;", "newList", "oldList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f extends DiffUtil.Callback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<p> newList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<p> oldList;

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends p> list, List<? extends p> list2) {
        this.newList = list;
        this.oldList = list2;
    }

    private final PayType b(PayInfoItemData r16) {
        return r16.selectedPayType;
    }

    private final String c(OrderItemData orderItemData, OrderItemData orderItemData2) {
        if (orderItemData.orderGoodInfo.quantity != orderItemData2.orderGoodInfo.quantity) {
            return "quantity";
        }
        if (!Intrinsics.areEqual(r3.note, r4.note)) {
            return "note";
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        p pVar = this.oldList.get(oldItemPosition);
        p pVar2 = this.newList.get(newItemPosition);
        if ((pVar instanceof PayInfoItemData) && (pVar2 instanceof PayInfoItemData)) {
            return ((PayInfoItemData) pVar).selectedPayType == ((PayInfoItemData) pVar2).selectedPayType;
        }
        return Intrinsics.areEqual(pVar2, pVar);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        p pVar = this.oldList.get(oldItemPosition);
        p pVar2 = this.newList.get(newItemPosition);
        if ((pVar instanceof AddressItemData) && (pVar2 instanceof AddressItemData)) {
            ECAddress eCAddress = ((AddressItemData) pVar).address;
            if (eCAddress == null && ((AddressItemData) pVar2).address == null) {
                return true;
            }
            if (eCAddress != null && ((AddressItemData) pVar2).address != null) {
                return true;
            }
        } else {
            if ((pVar instanceof OrderItemData) && (pVar2 instanceof OrderItemData)) {
                return Intrinsics.areEqual(((OrderItemData) pVar).orderGoodInfo.skuId, ((OrderItemData) pVar2).orderGoodInfo.skuId);
            }
            if ((pVar instanceof PayInfoItemData) && (pVar2 instanceof PayInfoItemData)) {
                return com.tencent.ecommerce.biz.orders.buyerorders.submit.model.i.b(((PayInfoItemData) pVar).a(), ((PayInfoItemData) pVar2).a());
            }
            if ((pVar instanceof ErrorTipsItemData) && (pVar2 instanceof ErrorTipsItemData)) {
                return Intrinsics.areEqual(((ErrorTipsItemData) pVar).msg, ((ErrorTipsItemData) pVar2).msg);
            }
            if ((pVar instanceof AccountInfoItemData) && (pVar2 instanceof AccountInfoItemData)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        p pVar = this.oldList.get(oldItemPosition);
        p pVar2 = this.newList.get(newItemPosition);
        if ((pVar instanceof AddressItemData) && (pVar2 instanceof AddressItemData)) {
            return a((AddressItemData) pVar2);
        }
        if ((pVar instanceof OrderItemData) && (pVar2 instanceof OrderItemData)) {
            return c((OrderItemData) pVar, (OrderItemData) pVar2);
        }
        if ((pVar instanceof PayInfoItemData) && (pVar2 instanceof PayInfoItemData)) {
            return b((PayInfoItemData) pVar2);
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

    private final AddressItemData a(AddressItemData r16) {
        return r16;
    }
}
