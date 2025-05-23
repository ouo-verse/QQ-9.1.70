package com.tencent.ecommerce.biz.live.ui.viewholder;

import android.view.View;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u000fj\u0002`\u0010\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u000fj\u0002`\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewholder/c;", "Lcom/tencent/ecommerce/biz/live/ui/viewholder/a;", "", "position", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "", "isEditable", "", "", "payloads", "", "t", "Landroid/view/View;", "itemView", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/live/ui/adapter/CustomClick;", "onItemClick", "onActionClick", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class c extends a {
    public c(View view, Function1<? super LiveProduct, Unit> function1, Function1<? super LiveProduct, Unit> function12) {
        super(view, function1, function12);
    }

    @Override // com.tencent.ecommerce.biz.live.ui.viewholder.a, com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder
    public void t(int position, LiveProduct liveProduct, boolean isEditable, List<Object> payloads) {
        boolean z16;
        boolean isBlank;
        super.t(position, liveProduct, isEditable, payloads);
        getActionButton().setVisibility(0);
        if (liveProduct != null && liveProduct.getIsExplaining()) {
            getActionButton().setText(getContext().getText(R.string.wlu));
            getActionButton().setSelected(true);
            getActionButton().setEnabled(true);
        } else {
            getActionButton().setText(getContext().getText(R.string.wlt));
            String statusTxt = liveProduct != null ? liveProduct.getStatusTxt() : null;
            if (statusTxt != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(statusTxt);
                if (!isBlank) {
                    z16 = false;
                    if (!z16 && liveProduct != null && liveProduct.getStatus() == 1 && !liveProduct.I()) {
                        getActionButton().setSelected(false);
                        getActionButton().setEnabled(true);
                    } else {
                        getActionButton().setEnabled(false);
                        getActionButton().setSelected(false);
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
            getActionButton().setEnabled(false);
            getActionButton().setSelected(false);
        }
        ei0.d.f396304b.f(getActionButton(), liveProduct);
    }
}
