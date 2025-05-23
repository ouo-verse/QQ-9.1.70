package com.tencent.ecommerce.biz.live.ui.viewholder;

import android.view.View;
import com.tencent.ecommerce.repo.live.ActivityStock;
import com.tencent.ecommerce.repo.live.LiveActivity;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0010j\u0002`\u0011\u0012\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0010j\u0002`\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewholder/g;", "Lcom/tencent/ecommerce/biz/live/ui/viewholder/ECNormalBaseLiveItemViewHolder;", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "", "k0", "", "position", "", "isEditable", "", "", "payloads", "t", "Landroid/view/View;", "itemView", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/live/ui/adapter/CustomClick;", "onItemClick", "onActionClick", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class g extends ECNormalBaseLiveItemViewHolder {
    public g(View view, Function1<? super LiveProduct, Unit> function1, Function1<? super LiveProduct, Unit> function12) {
        super(view, function1, function12);
    }

    private final void k0(LiveProduct liveProduct) {
        boolean z16 = false;
        getActionButton().setVisibility(0);
        getActionButton().setText(liveProduct != null ? liveProduct.getButtonTxt() : null);
        getActionButton().setSelected(false);
        if (liveProduct.getStatus() != 2 && !liveProduct.I()) {
            if (liveProduct.getLiveActivity() != null) {
                int i3 = f.f102826a[liveProduct.R().ordinal()];
                if (i3 == 1) {
                    getActionButton().setText(getContext().getString(R.string.wlz));
                } else if (i3 == 2) {
                    LiveActivity liveActivity = liveProduct.getLiveActivity();
                    ActivityStock activityStock = liveActivity != null ? liveActivity.getActivityStock() : null;
                    if (activityStock != null) {
                        if (activityStock.activityRemain > 0 && activityStock.total > 0) {
                            getActionButton().setText(getContext().getString(R.string.wms));
                        } else {
                            getActionButton().setText(getContext().getString(R.string.wmr));
                        }
                    }
                }
            }
            z16 = true;
        }
        getActionButton().setEnabled(z16);
        ei0.d.f396304b.b(getActionButton(), liveProduct);
    }

    @Override // com.tencent.ecommerce.biz.live.ui.viewholder.ECNormalBaseLiveItemViewHolder, com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder
    public void t(int position, LiveProduct liveProduct, boolean isEditable, List<Object> payloads) {
        super.t(position, liveProduct, isEditable, payloads);
        getSelectCheckBox().setVisibility(8);
        getReorderButton().setVisibility(8);
        b0(liveProduct);
        if (liveProduct != null) {
            k0(liveProduct);
        }
    }
}
