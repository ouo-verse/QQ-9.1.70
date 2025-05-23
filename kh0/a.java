package kh0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ecommerce.biz.aftersale.ui.view.ECAfterSaleDetailProductCardView;
import com.tencent.ecommerce.repo.aftersale.common.ECAfterSaleProductCard;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lkh0/a;", "", "Lcom/tencent/ecommerce/repo/aftersale/common/ECAfterSaleProductCard;", "orderCard", "", "a", "Landroid/view/View;", "Landroid/view/View;", "b", "()Landroid/view/View;", "itemView", "Lcom/tencent/ecommerce/biz/aftersale/ui/view/ECAfterSaleDetailProductCardView;", "Lcom/tencent/ecommerce/biz/aftersale/ui/view/ECAfterSaleDetailProductCardView;", "getOrderCardView", "()Lcom/tencent/ecommerce/biz/aftersale/ui/view/ECAfterSaleDetailProductCardView;", "orderCardView", "c", "getDivider", "divider", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View itemView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ECAfterSaleDetailProductCardView orderCardView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final View divider;

    public a(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cou, viewGroup, false);
        this.itemView = inflate;
        this.orderCardView = (ECAfterSaleDetailProductCardView) inflate.findViewById(R.id.f163049o13);
        this.divider = inflate.findViewById(R.id.f162991nq1);
    }

    public final void a(ECAfterSaleProductCard orderCard) {
        this.orderCardView.a(orderCard);
        this.divider.setVisibility(orderCard.hasDivider ? 0 : 8);
    }

    /* renamed from: b, reason: from getter */
    public final View getItemView() {
        return this.itemView;
    }
}
