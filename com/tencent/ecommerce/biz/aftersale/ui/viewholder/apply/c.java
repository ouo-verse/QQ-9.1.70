package com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply;

import android.view.View;
import com.tencent.ecommerce.base.ui.ECFormRowItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyEntryItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B+\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bj\u0004\u0018\u0001`\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR(\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bj\u0004\u0018\u0001`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/c;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/b;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/b;", "", "position", "", DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/base/ui/ECFormRowItem;", "I", "Lcom/tencent/ecommerce/base/ui/ECFormRowItem;", "formRowItem", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/EntryClick;", "J", "Lkotlin/jvm/functions/Function1;", "entryClick", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "K", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c extends b<ECAfterSaleApplyEntryItem> {

    /* renamed from: I, reason: from kotlin metadata */
    private final ECFormRowItem formRowItem;

    /* renamed from: J, reason: from kotlin metadata */
    private final Function1<ECAfterSaleApplyEntryItem, Unit> entryClick;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1 function1;
            EventCollector.getInstance().onViewClickedBefore(view);
            cg0.a.b("ECAfterSaleApplyEntryHolder", "formRowItem OnClickListener: " + c.this.l());
            ECAfterSaleApplyEntryItem l3 = c.this.l();
            if (l3 != null && (function1 = c.this.entryClick) != null) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(View view, Function1<? super ECAfterSaleApplyEntryItem, Unit> function1) {
        super(view);
        this.entryClick = function1;
        ECFormRowItem eCFormRowItem = (ECFormRowItem) view.findViewById(R.id.nzt);
        this.formRowItem = eCFormRowItem;
        eCFormRowItem.setOnClickListener(new a());
    }

    @Override // com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.b
    public void n(int position) {
        ECAfterSaleApplyEntryItem l3 = l();
        if (l3 != null) {
            this.formRowItem.setLeftMainText(l3.mainTitle);
            this.formRowItem.setLeftSubText(l3.subTitle);
            this.formRowItem.setShowArrow(true);
            if (getNextApplyItem() == null) {
                this.formRowItem.setDividerType(0);
            } else {
                this.formRowItem.setDividerType(2);
            }
            q(false);
        }
    }
}
