package com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply;

import android.view.View;
import android.widget.TextView;
import com.tencent.ecommerce.base.ui.ECFormRowItem;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/e;", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/b;", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", "", "position", "", DomainData.DOMAIN_NAME, "Lcom/tencent/ecommerce/base/ui/ECFormRowItem;", "I", "Lcom/tencent/ecommerce/base/ui/ECFormRowItem;", "getFormRowItem", "()Lcom/tencent/ecommerce/base/ui/ECFormRowItem;", "setFormRowItem", "(Lcom/tencent/ecommerce/base/ui/ECFormRowItem;)V", "formRowItem", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e extends b<com.tencent.ecommerce.repo.aftersale.apply.item.d> {

    /* renamed from: I, reason: from kotlin metadata */
    private ECFormRowItem formRowItem;

    public e(View view) {
        super(view);
        this.formRowItem = (ECFormRowItem) view.findViewById(R.id.nzt);
    }

    @Override // com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.b
    public void n(int position) {
        this.formRowItem.setLeftMainText(getContext().getString(R.string.wfv));
        this.formRowItem.setLeftSubText(getContext().getString(R.string.wfw));
        this.formRowItem.setRightText(getContext().getString(R.string.wfu));
        this.formRowItem.setShowArrow(false);
        this.formRowItem.setDividerType(0);
        TextView rightTextView = this.formRowItem.getRightTextView();
        if (rightTextView != null) {
            rightTextView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6942x));
        }
        q(true);
    }
}
