package com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply;

import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyProductItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/f;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/b;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/f;", "", "position", "", DomainData.DOMAIN_NAME, "Lkh0/a;", "I", "Lkh0/a;", "delegate", "<init>", "(Lkh0/a;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f extends b<ECAfterSaleApplyProductItem> {

    /* renamed from: I, reason: from kotlin metadata */
    private final kh0.a delegate;

    public f(kh0.a aVar) {
        super(aVar.getItemView());
        this.delegate = aVar;
    }

    @Override // com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.b
    public void n(int position) {
        ECAfterSaleApplyProductItem l3 = l();
        if (l3 != null) {
            this.delegate.a(l3.orderCard);
        }
    }
}
