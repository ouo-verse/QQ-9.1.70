package com.tencent.ecommerce.biz.orders.address;

import com.tencent.ecommerce.biz.orders.address.ECAddressListAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/orders/address/ECAddressManagerFragment$initView$1", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$OnItemClickListener;", "onItemClick", "", "address", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "onItemEditBtnClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAddressManagerFragment$initView$1 implements ECAddressListAdapter.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECAddressManagerFragment f102996a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECAddressManagerFragment$initView$1(ECAddressManagerFragment eCAddressManagerFragment) {
        this.f102996a = eCAddressManagerFragment;
    }

    @Override // com.tencent.ecommerce.biz.orders.address.ECAddressListAdapter.OnItemClickListener
    public void onItemClick(ECAddress address) {
        this.f102996a.Th(address);
        this.f102996a.Uh(address);
    }

    @Override // com.tencent.ecommerce.biz.orders.address.ECAddressListAdapter.OnItemClickListener
    public void onItemEditBtnClick(final ECAddress address) {
        c.e(3, address, new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECAddressManagerFragment$initView$1$onItemEditBtnClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ECAddress eCAddress) {
                invoke2(eCAddress);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ECAddress eCAddress) {
                ECAddressManagerViewModel Wh;
                ECAddressManagerViewModel Wh2;
                if (eCAddress != null) {
                    Wh2 = ECAddressManagerFragment$initView$1.this.f102996a.Wh();
                    Wh2.Z1(eCAddress);
                } else {
                    Wh = ECAddressManagerFragment$initView$1.this.f102996a.Wh();
                    Wh.T1(address);
                }
            }
        });
    }
}
