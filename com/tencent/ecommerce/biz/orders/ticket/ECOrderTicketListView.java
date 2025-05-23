package com.tencent.ecommerce.biz.orders.ticket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.TicketDetail;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.f;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eRf\u0010\u001b\u001a \u0012\b\u0012\u00060\u0004j\u0002`\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010j\u0004\u0018\u0001`\u00132$\u0010\u0014\u001a \u0012\b\u0012\u00060\u0004j\u0002`\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010j\u0004\u0018\u0001`\u00138\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/biz/orders/ticket/ECOrderTicketListView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/f$n;", "ticketInfoData", "", "shopName", "", "a", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/ecommerce/biz/orders/ticket/a;", "e", "Lcom/tencent/ecommerce/biz/orders/ticket/a;", "adapter", "Lkotlin/Function2;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/TicketIdentifier;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "Lcom/tencent/ecommerce/biz/orders/ticket/TicketItemClickListener;", "value", "f", "Lkotlin/jvm/functions/Function2;", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemClickListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderTicketListView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a adapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function2<? super String, ? super TicketDetail, Unit> onItemClickListener;

    public ECOrderTicketListView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.csy, (ViewGroup) this, true);
        this.adapter = new a();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.o8n);
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new li0.a());
        Unit unit = Unit.INSTANCE;
        this.recyclerView = recyclerView;
    }

    public final void a(f.TicketInfoData ticketInfoData, String shopName) {
        this.adapter.m0(ticketInfoData, shopName);
    }

    public final void setOnItemClickListener(Function2<? super String, ? super TicketDetail, Unit> function2) {
        this.onItemClickListener = function2;
        this.adapter.n0(function2);
    }
}
