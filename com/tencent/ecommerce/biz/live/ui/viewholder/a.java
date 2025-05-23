package com.tencent.ecommerce.biz.live.ui.viewholder;

import android.view.View;
import com.tencent.ecommerce.repo.live.LiveProduct;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B?\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u000fj\u0002`\u0010\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u000fj\u0002`\u0010\u00a2\u0006\u0004\b\u0013\u0010\u0014J2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/viewholder/a;", "Lcom/tencent/ecommerce/biz/live/ui/viewholder/ECBaseLiveItemViewHolder;", "", "position", "Lcom/tencent/ecommerce/repo/live/q;", "liveProduct", "", "isEditable", "", "", "payloads", "", "t", "Landroid/view/View;", "itemView", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/live/ui/adapter/CustomClick;", "onItemClick", "onActionClick", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "g0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class a extends ECBaseLiveItemViewHolder {
    public a(View view, Function1<? super LiveProduct, Unit> function1, Function1<? super LiveProduct, Unit> function12) {
        super(view, function1, function12);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0049  */
    @Override // com.tencent.ecommerce.biz.live.ui.viewholder.ECBaseLiveItemViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(int position, LiveProduct liveProduct, boolean isEditable, List<Object> payloads) {
        boolean z16;
        String salesTxt;
        boolean isBlank;
        boolean isBlank2;
        super.t(position, liveProduct, isEditable, payloads);
        String indexTxt = liveProduct != null ? liveProduct.getIndexTxt() : null;
        boolean z17 = true;
        if (indexTxt != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(indexTxt);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    getIndexTextView().setText(liveProduct != null ? liveProduct.getIndexTxt() : null);
                }
                getSelectCheckBox().setVisibility(8);
                getReorderButton().setVisibility(8);
                getThirdTitleTextView().setVisibility(8);
                salesTxt = liveProduct == null ? liveProduct.getSalesTxt() : null;
                if (salesTxt != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(salesTxt);
                    if (!isBlank) {
                        z17 = false;
                    }
                }
                if (!z17) {
                    getSecondTitleTextView().setPadding(0, 0, 0, 0);
                    getSecondTitleTextView().setCompoundDrawables(null, null, null, null);
                    getSecondTitleTextView().setCompoundDrawablePadding(ECNormalMasterLiveItemViewHolder.INSTANCE.a());
                    getSecondTitleTextView().setBackground(null);
                    getSecondTitleTextView().setText(liveProduct != null ? liveProduct.getSalesTxt() : null);
                }
                ei0.d.f396304b.g(getItemRoot(), liveProduct);
            }
        }
        z16 = true;
        if (!z16) {
        }
        getSelectCheckBox().setVisibility(8);
        getReorderButton().setVisibility(8);
        getThirdTitleTextView().setVisibility(8);
        if (liveProduct == null) {
        }
        if (salesTxt != null) {
        }
        if (!z17) {
        }
        ei0.d.f396304b.g(getItemRoot(), liveProduct);
    }
}
