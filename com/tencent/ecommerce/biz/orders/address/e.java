package com.tencent.ecommerce.biz.orders.address;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.orders.address.ECAddressListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\"\u001a\u00020\u0018\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001c\u0010\r\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001c\u0010\u0011\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u001c\u0010\u0013\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u001c\u0010\u0017\u001a\n \n*\u0004\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001b\u001a\n \n*\u0004\u0018\u00010\u00180\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001d\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\fR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$a;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isSelected", "setSelected", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/TextView;", "addressZone", UserInfo.SEX_FEMALE, "addressInfo", "G", "addressContactPhone", "H", "addressContactName", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "selectedImage", "Landroid/view/View;", "J", "Landroid/view/View;", "editBtn", "K", "defaultAddressLogo", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$OnItemClickListener;", "L", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$OnItemClickListener;", "itemClickListener", "view", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$OnItemClickListener;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final TextView addressZone;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView addressInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private final TextView addressContactPhone;

    /* renamed from: H, reason: from kotlin metadata */
    private final TextView addressContactName;

    /* renamed from: I, reason: from kotlin metadata */
    private final ImageView selectedImage;

    /* renamed from: J, reason: from kotlin metadata */
    private final View editBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private final TextView defaultAddressLogo;

    /* renamed from: L, reason: from kotlin metadata */
    private final ECAddressListAdapter.OnItemClickListener itemClickListener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECAddressListAdapter.ECAddressItemData f103053e;

        a(ECAddressListAdapter.ECAddressItemData eCAddressItemData) {
            this.f103053e = eCAddressItemData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECAddressListAdapter.OnItemClickListener onItemClickListener = e.this.itemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(this.f103053e.getAddress());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECAddressListAdapter.ECAddressItemData f103055e;

        b(ECAddressListAdapter.ECAddressItemData eCAddressItemData) {
            this.f103055e = eCAddressItemData;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECAddressListAdapter.OnItemClickListener onItemClickListener = e.this.itemClickListener;
            if (onItemClickListener != null) {
                onItemClickListener.onItemEditBtnClick(this.f103055e.getAddress());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public e(View view, ECAddressListAdapter.OnItemClickListener onItemClickListener) {
        super(view);
        this.itemClickListener = onItemClickListener;
        this.addressZone = (TextView) view.findViewById(R.id.npm);
        this.addressInfo = (TextView) view.findViewById(R.id.npj);
        this.addressContactPhone = (TextView) view.findViewById(R.id.nuh);
        this.addressContactName = (TextView) view.findViewById(R.id.nug);
        this.selectedImage = (ImageView) view.findViewById(R.id.o0z);
        this.editBtn = view.findViewById(R.id.nxy);
        this.defaultAddressLogo = (TextView) view.findViewById(R.id.f163017nv2);
    }

    public final void m(ECAddressListAdapter.ECAddressItemData data) {
        TextView textView = this.addressZone;
        ECAddress address = data.getAddress();
        textView.setText(address.province + TokenParser.SP + address.city + TokenParser.SP + address.district + TokenParser.SP + address.street);
        this.addressInfo.setText(data.getAddress().detailAddress);
        this.addressContactName.setText(data.getAddress().consignee);
        this.addressContactPhone.setText(data.getAddress().phoneNumber);
        this.defaultAddressLogo.setVisibility(data.getAddress().isDefaultAddress ? 0 : 8);
        setSelected(data.getIsSelected());
        this.itemView.setOnClickListener(new a(data));
        this.editBtn.setOnClickListener(new b(data));
    }

    public final void setSelected(boolean isSelected) {
        this.selectedImage.setVisibility(isSelected ? 0 : 4);
    }
}
