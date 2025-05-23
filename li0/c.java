package li0;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.detail.model.TicketDetail;
import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lli0/c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/model/e;", "detail", "", "shopName", "", "position", "", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "ticketNameView", UserInfo.SEX_FEMALE, "deadlineView", "Landroid/view/View;", "G", "Landroid/view/View;", "containerView", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class c extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private TextView ticketNameView;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView deadlineView;

    /* renamed from: G, reason: from kotlin metadata */
    public final View containerView;

    public c(View view) {
        super(view);
        this.containerView = view;
        this.ticketNameView = (TextView) view.findViewById(R.id.oeo);
        this.deadlineView = (TextView) view.findViewById(R.id.oei);
    }

    public final void l(TicketDetail detail, String shopName, int position) {
        this.ticketNameView.setText(detail.name + (position + 1));
        this.deadlineView.setText(this.itemView.getContext().getString(R.string.f169646wu0) + detail.deadlineStr);
    }
}
