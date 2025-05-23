package com.tencent.ecommerce.biz.shophome.viewmodel;

import androidx.lifecycle.ViewModelKt;
import bj0.ECShopHomeProductRequest;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/ECShopHomeSecondProductViewModel;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "Lbj0/b;", "shopHomeProductRequest", "", "isFirstScreen", "", "x2", "<init>", "()V", "k0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopHomeSecondProductViewModel extends a {
    public final void x2(ECShopHomeProductRequest shopHomeProductRequest, boolean isFirstScreen) {
        L1(shopHomeProductRequest.loadMore);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopHomeSecondProductViewModel$getShopHomeSecondProductListData$1(this, shopHomeProductRequest, isFirstScreen, null), 3, null);
    }

    public static /* synthetic */ void y2(ECShopHomeSecondProductViewModel eCShopHomeSecondProductViewModel, ECShopHomeProductRequest eCShopHomeProductRequest, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        eCShopHomeSecondProductViewModel.x2(eCShopHomeProductRequest, z16);
    }
}
