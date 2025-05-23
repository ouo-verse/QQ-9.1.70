package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.p;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003B\u001b\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0004X\u0085\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/q;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/p;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "o", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/p;)V", "", "", "payloads", DomainData.DOMAIN_NAME, "(Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/p;Ljava/util/List;)V", "l", "p", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;", "E", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;", "itemOperationListener", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/OrderSubmitListItemOperationListener;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class q<T extends p> extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    protected final OrderSubmitListItemOperationListener itemOperationListener;

    public /* synthetic */ q(View view, OrderSubmitListItemOperationListener orderSubmitListItemOperationListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, (i3 & 2) != 0 ? null : orderSubmitListItemOperationListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context getContext() {
        return this.itemView.getContext();
    }

    public abstract void m(T data);

    public abstract void n(T data, List<? extends Object> payloads);

    public q(View view, OrderSubmitListItemOperationListener orderSubmitListItemOperationListener) {
        super(view);
        this.itemOperationListener = orderSubmitListItemOperationListener;
    }

    public void l() {
    }

    public void o() {
    }

    public void p() {
    }
}
