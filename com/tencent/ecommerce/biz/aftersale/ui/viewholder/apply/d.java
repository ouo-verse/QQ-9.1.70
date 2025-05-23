package com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply;

import android.view.View;
import com.tencent.ecommerce.base.ui.ECFormRowItem;
import com.tencent.ecommerce.repo.aftersale.apply.OptionValue;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyAmountItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B1\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012 \u0010\u0011\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/d;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/b;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/e;", "", "position", "", DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/base/ui/ECFormRowItem;", "I", "Lcom/tencent/ecommerce/base/ui/ECFormRowItem;", "r", "()Lcom/tencent/ecommerce/base/ui/ECFormRowItem;", "formRowItem", "Landroid/view/View;", "itemView", "Lkotlin/Function2;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/OptionClick;", "optionClick", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "J", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d extends b<com.tencent.ecommerce.repo.aftersale.apply.item.e> {

    /* renamed from: I, reason: from kotlin metadata */
    private final ECFormRowItem formRowItem;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2 f101314e;

        a(Function2 function2) {
            this.f101314e = function2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function2 function2;
            EventCollector.getInstance().onViewClickedBefore(view);
            cg0.a.b("ECAfterSaleApplyOptionHolder", "formRowItem OnClickListener: " + d.this.l());
            com.tencent.ecommerce.repo.aftersale.apply.item.e l3 = d.this.l();
            if (l3 != null && (function2 = this.f101314e) != null) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public d(View view, Function2<? super com.tencent.ecommerce.repo.aftersale.apply.item.e, ? super d, Unit> function2) {
        super(view);
        ECFormRowItem eCFormRowItem = (ECFormRowItem) view.findViewById(R.id.nzt);
        this.formRowItem = eCFormRowItem;
        eCFormRowItem.setOnClickListener(new a(function2));
    }

    @Override // com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.b
    public void n(int position) {
        com.tencent.ecommerce.repo.aftersale.apply.item.e l3 = l();
        if (l3 != null) {
            this.formRowItem.setLeftMainText(l3.getOptionInfo().getKeyText());
            this.formRowItem.setShowArrow(!l3.getOptionInfo().getIsDisable());
            if (l3.getOptionInfo().getSelectedOption() != null) {
                ECFormRowItem eCFormRowItem = this.formRowItem;
                OptionValue selectedOption = l3.getOptionInfo().getSelectedOption();
                eCFormRowItem.setRightText(selectedOption != null ? selectedOption.getText() : null);
            } else if (l3.getOptionInfo().getDefaultValue() != null) {
                ECFormRowItem eCFormRowItem2 = this.formRowItem;
                OptionValue defaultValue = l3.getOptionInfo().getDefaultValue();
                eCFormRowItem2.setRightText(defaultValue != null ? defaultValue.getText() : null);
            } else {
                this.formRowItem.setRightText("\u8bf7\u9009\u62e9");
            }
            if (!(getNextApplyItem() instanceof com.tencent.ecommerce.repo.aftersale.apply.item.e) && !(getNextApplyItem() instanceof ECAfterSaleApplyAmountItem)) {
                this.formRowItem.setDividerType(0);
                q(true);
            } else {
                this.formRowItem.setDividerType(2);
                q(false);
            }
        }
    }

    /* renamed from: r, reason: from getter */
    public final ECFormRowItem getFormRowItem() {
        return this.formRowItem;
    }
}
