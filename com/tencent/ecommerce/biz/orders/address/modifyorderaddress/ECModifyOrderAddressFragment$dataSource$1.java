package com.tencent.ecommerce.biz.orders.address.modifyorderaddress;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.list.BaseListDataSource;
import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.list.f;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.address.IECAddressRepository;
import com.tencent.ecommerce.biz.orders.address.b;
import com.tencent.ecommerce.repo.ServiceLocator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001J'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/orders/address/modifyorderaddress/ECModifyOrderAddressFragment$dataSource$1", "Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "Lcom/tencent/ecommerce/base/list/f;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "l", "(Lcom/tencent/ecommerce/base/list/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECModifyOrderAddressFragment$dataSource$1 extends BaseListDataSource<f, ECAddress, byte[]> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ECModifyOrderAddressFragment f103070b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECModifyOrderAddressFragment$dataSource$1(ECModifyOrderAddressFragment eCModifyOrderAddressFragment) {
        this.f103070b = eCModifyOrderAddressFragment;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.base.list.BaseListDataSource
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(f fVar, Continuation<? super IListRepository.Result<ECAddress, byte[]>> continuation) {
        ECModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1 eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1;
        Object coroutine_suspended;
        int i3;
        ECModifyOrderAddressFragment$dataSource$1 eCModifyOrderAddressFragment$dataSource$1;
        List list;
        List list2;
        ECAddress eCAddress;
        boolean z16;
        ECAddress eCAddress2;
        ECAddress eCAddress3;
        if (continuation instanceof ECModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1) {
            eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1 = (ECModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1) continuation;
            int i16 = eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IECAddressRepository b16 = ServiceLocator.f104891i.b();
                    eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1.L$0 = this;
                    eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1.label = 1;
                    obj = b16.getAllAddresses(eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCModifyOrderAddressFragment$dataSource$1 = this;
                } else if (i3 == 1) {
                    eCModifyOrderAddressFragment$dataSource$1 = (ECModifyOrderAddressFragment$dataSource$1) eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) obj;
                if (list == null) {
                    list2 = new ArrayList();
                    for (Object obj2 : list) {
                        ECAddress eCAddress4 = (ECAddress) obj2;
                        String str = eCAddress4.consignee;
                        eCAddress = eCModifyOrderAddressFragment$dataSource$1.f103070b.exclusiveAddress;
                        if (Intrinsics.areEqual(str, eCAddress != null ? eCAddress.consignee : null)) {
                            String str2 = eCAddress4.phoneNumber;
                            eCAddress2 = eCModifyOrderAddressFragment$dataSource$1.f103070b.exclusiveAddress;
                            if (Intrinsics.areEqual(str2, eCAddress2 != null ? eCAddress2.phoneNumber : null)) {
                                String a16 = b.a(eCAddress4);
                                eCAddress3 = eCModifyOrderAddressFragment$dataSource$1.f103070b.exclusiveAddress;
                                if (Intrinsics.areEqual(a16, eCAddress3 != null ? b.a(eCAddress3) : null)) {
                                    z16 = true;
                                    if (Boxing.boxBoolean(z16).booleanValue()) {
                                        list2.add(obj2);
                                    }
                                }
                            }
                        }
                        z16 = false;
                        if (Boxing.boxBoolean(z16).booleanValue()) {
                        }
                    }
                } else {
                    list2 = null;
                }
                boolean z17 = list2 != null;
                if (list2 == null) {
                    list2 = CollectionsKt__CollectionsKt.emptyList();
                }
                return new IListRepository.Result(z17, list2, false, null);
            }
        }
        eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1 = new ECModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1(this, continuation);
        Object obj3 = eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCModifyOrderAddressFragment$dataSource$1$loadFirstPageFromServer$1.label;
        if (i3 != 0) {
        }
        list = (List) obj3;
        if (list == null) {
        }
        if (list2 != null) {
        }
        if (list2 == null) {
        }
        return new IListRepository.Result(z17, list2, false, null);
    }
}
