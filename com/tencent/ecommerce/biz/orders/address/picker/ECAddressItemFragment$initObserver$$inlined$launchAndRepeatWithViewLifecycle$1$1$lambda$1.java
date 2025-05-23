package com.tencent.ecommerce.biz.orders.address.picker;

import ag0.ECLocationInfo;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECCityInfo;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lag0/a;", "location", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/g;", "cityList", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$initObserver$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.address.picker.ECAddressItemFragment$initObserver$2$1", f = "ECAddressItemFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECAddressItemFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1 extends SuspendLambda implements Function3<ECLocationInfo, List<? extends ECCityInfo>, Continuation<? super List<? extends ECCityInfo>>, Object> {
    private /* synthetic */ Object L$0;
    private /* synthetic */ Object L$1;
    int label;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2", "com/tencent/ecommerce/biz/orders/address/picker/ECAddressItemFragment$initObserver$2$1$invokeSuspend$$inlined$sortedBy$1"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Boolean.valueOf(!((ECCityInfo) t16).getIsCurrentLocation()), Boolean.valueOf(!((ECCityInfo) t17).getIsCurrentLocation()));
            return compareValues;
        }
    }

    public final Continuation<Unit> create(ECLocationInfo eCLocationInfo, List<ECCityInfo> list, Continuation<? super List<ECCityInfo>> continuation) {
        ECAddressItemFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1 eCAddressItemFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1 = new ECAddressItemFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1(continuation);
        eCAddressItemFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1.L$0 = eCLocationInfo;
        eCAddressItemFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1.L$1 = list;
        return eCAddressItemFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(ECLocationInfo eCLocationInfo, List<? extends ECCityInfo> list, Continuation<? super List<? extends ECCityInfo>> continuation) {
        return ((ECAddressItemFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1) create(eCLocationInfo, list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List sortedWith;
        Object obj2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ECLocationInfo eCLocationInfo = (ECLocationInfo) this.L$0;
            List list = (List) this.L$1;
            if (eCLocationInfo != null) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    ECCityInfo eCCityInfo = (ECCityInfo) obj2;
                    if (Boxing.boxBoolean(Intrinsics.areEqual(eCCityInfo.getCity(), eCLocationInfo.getCity()) && Intrinsics.areEqual(eCCityInfo.province, eCLocationInfo.getProvince())).booleanValue()) {
                        break;
                    }
                }
                ECCityInfo eCCityInfo2 = (ECCityInfo) obj2;
                if (eCCityInfo2 != null) {
                    eCCityInfo2.c(true);
                }
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new a());
            return sortedWith;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECAddressItemFragment$initObserver$$inlined$launchAndRepeatWithViewLifecycle$1$1$lambda$1(Continuation continuation) {
        super(3, continuation);
    }
}
