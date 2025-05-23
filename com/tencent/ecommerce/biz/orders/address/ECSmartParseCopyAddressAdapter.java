package com.tencent.ecommerce.biz.orders.address;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB/\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R&\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "", "Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "itemDataList", "Lkotlin/Function2;", "Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter$ItemType;", "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function2;", "selectedCallback", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "a", "ItemType", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSmartParseCopyAddressAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Function2<ItemType, Boolean, Unit> selectedCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<ItemData> itemDataList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter$ItemType;", "", "(Ljava/lang/String;I)V", "Consignee", "Phone", "District", "DetailAddress", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public enum ItemType {
        Consignee,
        Phone,
        District,
        DetailAddress
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020\u0012\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\n \f*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR&\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "o", "Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter$a;", "data", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "titleView", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/CheckBox;", "checkBox", "G", "contentView", "Lkotlin/Function2;", "Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter$ItemType;", "", "H", "Lkotlin/jvm/functions/Function2;", "selectedCallback", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final TextView titleView;

        /* renamed from: F, reason: from kotlin metadata */
        private final CheckBox checkBox;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView contentView;

        /* renamed from: H, reason: from kotlin metadata */
        private final Function2<ItemType, Boolean, Unit> selectedCallback;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a implements CompoundButton.OnCheckedChangeListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ItemData f103043e;

            a(ItemData itemData) {
                this.f103043e = itemData;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                b.this.selectedCallback.invoke(this.f103043e.type, Boolean.valueOf(z16));
                b.this.o();
                EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(View view, Function2<? super ItemType, ? super Boolean, Unit> function2) {
            super(view);
            this.selectedCallback = function2;
            this.titleView = (TextView) view.findViewById(R.id.ocd);
            this.checkBox = (CheckBox) view.findViewById(R.id.nt6);
            this.contentView = (TextView) view.findViewById(R.id.nuq);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void o() {
            Drawable drawable;
            CheckBox checkBox = this.checkBox;
            if (checkBox.isChecked()) {
                drawable = ECSkin.INSTANCE.getDrawable(R.drawable.e6v);
            } else {
                drawable = ECSkin.INSTANCE.getDrawable(R.drawable.e5s);
            }
            checkBox.setBackground(drawable);
        }

        public final void n(ItemData data) {
            this.checkBox.setChecked(data.getIsSelected());
            o();
            this.titleView.setText(data.title);
            this.contentView.setText(data.getContent());
            this.checkBox.setOnCheckedChangeListener(new a(data));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECSmartParseCopyAddressAdapter(List<ItemData> list, Function2<? super ItemType, ? super Boolean, Unit> function2) {
        this.itemDataList = list;
        this.selectedCallback = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.itemDataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        holder.n(this.itemDataList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        return new b(LayoutInflater.from(parent.getContext()).inflate(R.layout.cpt, parent, false), this.selectedCallback);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter$ItemType;", "a", "Lcom/tencent/ecommerce/biz/orders/address/ECSmartParseCopyAddressAdapter$ItemType;", "type", "b", "Z", "()Z", "c", "(Z)V", "isSelected", "Ljava/lang/String;", "title", "d", "()Ljava/lang/String;", "content", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.address.ECSmartParseCopyAddressAdapter$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class ItemData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final ItemType type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isSelected;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String title;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String content;

        /* renamed from: a, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final void c(boolean z16) {
            this.isSelected = z16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ItemType itemType = this.type;
            int hashCode = (itemType != null ? itemType.hashCode() : 0) * 31;
            boolean z16 = this.isSelected;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode + i3) * 31;
            String str = this.title;
            int hashCode2 = (i16 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.content;
            return hashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ItemData(type=" + this.type + ", isSelected=" + this.isSelected + ", title=" + this.title + ", content=" + this.content + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemData)) {
                return false;
            }
            ItemData itemData = (ItemData) other;
            return Intrinsics.areEqual(this.type, itemData.type) && this.isSelected == itemData.isSelected && Intrinsics.areEqual(this.title, itemData.title) && Intrinsics.areEqual(this.content, itemData.content);
        }
    }
}
