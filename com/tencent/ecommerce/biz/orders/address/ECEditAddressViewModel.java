package com.tencent.ecommerce.biz.orders.address;

import ag0.ECLocationInfo;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\t\u001a\u00020\bJ&\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0004\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECEditAddressViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "Lkotlinx/coroutines/flow/Flow;", "L1", "", "P1", "", "addressId", "M1", "Landroid/content/Context;", "context", "", "keyword", TtmlNode.TAG_REGION, "Lcom/tencent/lbssearch/object/result/SuggestionResultObject;", "N1", "Lag0/a;", "O1", "<init>", "()V", "i", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECEditAddressViewModel extends ViewModel {
    public final Flow<ECAddress> L1(ECAddress address) {
        return FlowKt.flow(new ECEditAddressViewModel$addAddress$1(address, null));
    }

    public final Flow<Boolean> M1(long addressId) {
        return FlowKt.flow(new ECEditAddressViewModel$removeAddress$1(addressId, null));
    }

    public final Flow<SuggestionResultObject> N1(Context context, String keyword, String region) {
        return FlowKt.flow(new ECEditAddressViewModel$requestAddressListWithKeyWord$1(context, keyword, region, null));
    }

    public final Flow<ECLocationInfo> O1() {
        return FlowKt.flow(new ECEditAddressViewModel$requestCurrentLocation$1(null));
    }

    public final Flow<Boolean> P1(ECAddress address) {
        return FlowKt.flow(new ECEditAddressViewModel$update$1(address, null));
    }
}
