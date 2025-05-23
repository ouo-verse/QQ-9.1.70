package com.tencent.ecommerce.biz.orders.ticket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.TicketDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import li0.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016R,\u0010\u0017\u001a\u001a\u0012\b\u0012\u00060\u0005j\u0002`\u00130\u0012j\f\u0012\b\u0012\u00060\u0005j\u0002`\u0013`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR@\u0010&\u001a \u0012\b\u0012\u00060\u0005j\u0002`\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001ej\u0004\u0018\u0001`\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/ticket/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lli0/c;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$n;", "ticketInfoData", "", "shopName", "", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "k0", "getItemCount", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/TicketIdentifier;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "dataList", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "D", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "detail", "Lkotlin/Function2;", "Lcom/tencent/ecommerce/biz/orders/ticket/TicketItemClickListener;", "E", "Lkotlin/jvm/functions/Function2;", "j0", "()Lkotlin/jvm/functions/Function2;", "n0", "(Lkotlin/jvm/functions/Function2;)V", "itemClickListener", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
final class a extends RecyclerView.Adapter<c> {

    /* renamed from: D, reason: from kotlin metadata */
    private TicketDetail detail;

    /* renamed from: E, reason: from kotlin metadata */
    private Function2<? super String, ? super TicketDetail, Unit> itemClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> dataList = new ArrayList<>();

    /* renamed from: C, reason: from kotlin metadata */
    private String shopName = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.ticket.a$a, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class ViewOnClickListenerC1081a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f103892e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TicketDetail f103893f;

        ViewOnClickListenerC1081a(int i3, TicketDetail ticketDetail) {
            this.f103892e = i3;
            this.f103893f = ticketDetail;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Function2<String, TicketDetail, Unit> j06 = a.this.j0();
            if (j06 != 0) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    public final Function2<String, TicketDetail, Unit> j0() {
        return this.itemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, int position) {
        TicketDetail ticketDetail = this.detail;
        if (ticketDetail != null) {
            holder.l(ticketDetail, this.shopName, position);
            holder.containerView.setOnClickListener(new ViewOnClickListenerC1081a(position, ticketDetail));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int viewType) {
        return new c(LayoutInflater.from(parent.getContext()).inflate(R.layout.csx, parent, false));
    }

    public final void m0(f.TicketInfoData ticketInfoData, String shopName) {
        this.detail = ticketInfoData.detail;
        this.shopName = shopName;
        this.dataList.clear();
        this.dataList.addAll(ticketInfoData.a());
        notifyDataSetChanged();
    }

    public final void n0(Function2<? super String, ? super TicketDetail, Unit> function2) {
        this.itemClickListener = function2;
    }
}
