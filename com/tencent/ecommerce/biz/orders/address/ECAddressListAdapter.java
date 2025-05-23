package com.tencent.ecommerce.biz.orders.address;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J&\u0010\u000f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011J\u0014\u0010\u0017\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/orders/address/e;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "", "i0", "", "", "payloads", "j0", "getItemCount", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$OnItemClickListener;", "listener", "l0", "", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$a;", "addressList", "setData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$OnItemClickListener;", "itemClickListener", "<init>", "()V", "a", "OnItemClickListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAddressListAdapter extends RecyclerView.Adapter<e> {

    /* renamed from: C, reason: from kotlin metadata */
    private OnItemClickListener itemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<ECAddressItemData> data = new ArrayList();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$OnItemClickListener;", "", "onItemClick", "", "address", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "onItemEditBtnClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface OnItemClickListener {
        void onItemClick(ECAddress address);

        void onItemEditBtnClick(ECAddress address);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(e holder, int position) {
        holder.m(this.data.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(e holder, int position, List<Object> payloads) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }
        Object obj = payloads.get(0);
        if (obj != null) {
            holder.setSelected(((Boolean) obj).booleanValue());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public e onCreateViewHolder(ViewGroup parent, int viewType) {
        return new e(LayoutInflater.from(parent.getContext()).inflate(R.layout.f167321com, parent, false), this.itemClickListener);
    }

    public final void l0(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    public final void setData(List<ECAddressItemData> addressList) {
        DiffUtil.calculateDiff(new a(this.data, addressList)).dispatchUpdatesTo(this);
        this.data.clear();
        this.data.addAll(addressList);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$a;", "", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "", "isSelected", "a", "", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "c", "()Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "setAddress", "(Lcom/tencent/ecommerce/biz/orders/address/ECAddress;)V", "b", "Z", "d", "()Z", "e", "(Z)V", "<init>", "(Lcom/tencent/ecommerce/biz/orders/address/ECAddress;Z)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.address.ECAddressListAdapter$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class ECAddressItemData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private ECAddress address;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isSelected;

        public ECAddressItemData(ECAddress eCAddress, boolean z16) {
            this.address = eCAddress;
            this.isSelected = z16;
        }

        public final ECAddressItemData a(ECAddress address, boolean isSelected) {
            return new ECAddressItemData(address, isSelected);
        }

        /* renamed from: c, reason: from getter */
        public final ECAddress getAddress() {
            return this.address;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final void e(boolean z16) {
            this.isSelected = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ECAddress eCAddress = this.address;
            int hashCode = (eCAddress != null ? eCAddress.hashCode() : 0) * 31;
            boolean z16 = this.isSelected;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public String toString() {
            return "ECAddressItemData(address=" + this.address + ", isSelected=" + this.isSelected + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ECAddressItemData)) {
                return false;
            }
            ECAddressItemData eCAddressItemData = (ECAddressItemData) other;
            return Intrinsics.areEqual(this.address, eCAddressItemData.address) && this.isSelected == eCAddressItemData.isSelected;
        }

        public static /* synthetic */ ECAddressItemData b(ECAddressItemData eCAddressItemData, ECAddress eCAddress, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                eCAddress = eCAddressItemData.address;
            }
            if ((i3 & 2) != 0) {
                z16 = eCAddressItemData.isSelected;
            }
            return eCAddressItemData.a(eCAddress, z16);
        }
    }
}
