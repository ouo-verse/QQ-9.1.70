package com.tencent.ecommerce.biz.orders.address.modifyorderaddress;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.list.IStateListAdapter;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 *2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002+,B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0005H\u0016J\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00020\u00072\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR?\u0010'\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006-"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/modifyorderaddress/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/ecommerce/biz/orders/address/modifyorderaddress/a$b;", "Lcom/tencent/ecommerce/base/list/IStateListAdapter;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "", "dataList", "", "setData", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "holder", "position", "m0", "getItemCount", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "list", "value", BdhLogUtil.LogTag.Tag_Conn, "I", "p0", "(I)V", "selectedIndex", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "D", "Lkotlin/jvm/functions/Function1;", "k0", "()Lkotlin/jvm/functions/Function1;", "o0", "(Lkotlin/jvm/functions/Function1;)V", "onIndexChangedListener", "<init>", "()V", "E", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends RecyclerView.Adapter<b> implements IStateListAdapter<ECAddress> {

    /* renamed from: D, reason: from kotlin metadata */
    private Function1<? super Integer, Unit> onIndexChangedListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final List<ECAddress> list = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private int selectedIndex = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(int i3) {
        int i16 = this.selectedIndex;
        if (i16 != -1) {
            notifyItemChanged(i16);
        }
        this.selectedIndex = i3;
        if (i3 != -1) {
            notifyItemChanged(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.list.size();
    }

    public final Function1<Integer, Unit> k0() {
        return this.onIndexChangedListener;
    }

    public final ECAddress l0() {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.list, this.selectedIndex);
        return (ECAddress) orNull;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        holder.l(position, this.list.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        return new b(LayoutInflater.from(parent.getContext()).inflate(R.layout.cs_, parent, false));
    }

    public final void o0(Function1<? super Integer, Unit> function1) {
        this.onIndexChangedListener = function1;
    }

    @Override // com.tencent.ecommerce.base.list.IStateListAdapter
    public void setData(List<? extends ECAddress> dataList) {
        this.list.clear();
        this.list.addAll(dataList);
        notifyDataSetChanged();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/modifyorderaddress/a$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "", "l", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "checkBox", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "ownerNameTv", "G", "addressZoneTv", "H", "addressInfoTv", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/ecommerce/biz/orders/address/modifyorderaddress/a;Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView checkBox;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView ownerNameTv;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView addressZoneTv;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView addressInfoTv;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
        /* renamed from: com.tencent.ecommerce.biz.orders.address.modifyorderaddress.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes31.dex */
        public static final class ViewOnClickListenerC1064a implements View.OnClickListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f103074e;

            ViewOnClickListenerC1064a(int i3) {
                this.f103074e = i3;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                int i3 = a.this.selectedIndex;
                int i16 = this.f103074e;
                if (i3 != i16) {
                    a.this.p0(i16);
                    Function1<Integer, Unit> k06 = a.this.k0();
                    if (k06 != null) {
                        k06.invoke(Integer.valueOf(this.f103074e));
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public b(View view) {
            super(view);
            this.checkBox = (ImageView) view.findViewById(R.id.nt7);
            this.ownerNameTv = (TextView) view.findViewById(R.id.npu);
            this.addressZoneTv = (TextView) view.findViewById(R.id.npv);
            this.addressInfoTv = (TextView) view.findViewById(R.id.npq);
        }

        public final void l(int position, ECAddress address) {
            List listOf;
            String joinToString$default;
            String substring;
            String str = address.consignee;
            if (str.length() > 7) {
                StringBuilder sb5 = new StringBuilder();
                substring = StringsKt__StringsKt.substring(str, new IntRange(0, 6));
                sb5.append(substring);
                sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                str = sb5.toString();
            }
            this.ownerNameTv.setText(this.itemView.getContext().getString(R.string.wo6, str, address.phoneNumber));
            TextView textView = this.addressZoneTv;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{address.province, address.city, address.district, address.street});
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(listOf, " ", null, null, 0, null, null, 62, null);
            textView.setText(joinToString$default);
            this.addressInfoTv.setText(address.detailAddress);
            this.checkBox.setSelected(position == a.this.selectedIndex);
            this.itemView.setOnClickListener(new ViewOnClickListenerC1064a(position));
        }
    }
}
