package com.tencent.ecommerce.biz.logistics;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.location.IECLocationServiceProxy;
import com.tencent.ecommerce.biz.orders.common.Coordinate;
import com.tencent.ecommerce.biz.orders.common.LogisticsInfo;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.logistics.ECLogisticsTraceViewModel$requestLogisticTraceRoute$1", f = "ECLogisticsTraceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECLogisticsTraceViewModel$requestLogisticTraceRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LogisticsInfo $info;
    final /* synthetic */ Coordinate $receiverAddress;
    final /* synthetic */ Coordinate $senderAddress;
    int label;
    final /* synthetic */ ECLogisticsTraceViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECLogisticsTraceViewModel$requestLogisticTraceRoute$1(ECLogisticsTraceViewModel eCLogisticsTraceViewModel, Coordinate coordinate, Coordinate coordinate2, LogisticsInfo logisticsInfo, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCLogisticsTraceViewModel;
        this.$senderAddress = coordinate;
        this.$receiverAddress = coordinate2;
        this.$info = logisticsInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECLogisticsTraceViewModel$requestLogisticTraceRoute$1(this.this$0, this.$senderAddress, this.$receiverAddress, this.$info, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECLogisticsTraceViewModel$requestLogisticTraceRoute$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int collectionSizeOrDefault;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
            IECLocationServiceProxy locationService = qQEcommerceSdk.getGlobalInternalSdk().getLocationService();
            Application externalApplicationContext = qQEcommerceSdk.getGlobalInternalSdk().getRuntime().getExternalApplicationContext();
            LatLng b16 = com.tencent.ecommerce.biz.orders.common.f.b(this.$senderAddress);
            LatLng b17 = com.tencent.ecommerce.biz.orders.common.f.b(this.$receiverAddress);
            List<Coordinate> c16 = this.$info.c();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = c16.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.ecommerce.biz.orders.common.f.b((Coordinate) it.next()));
            }
            locationService.requestLogisticTraceRoute(externalApplicationContext, b16, b17, arrayList, new Function3<Integer, String, DrivingResultObject, Unit>() { // from class: com.tencent.ecommerce.biz.logistics.ECLogisticsTraceViewModel$requestLogisticTraceRoute$1.2
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, DrivingResultObject drivingResultObject) {
                    invoke(num.intValue(), str, drivingResultObject);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, String str, DrivingResultObject drivingResultObject) {
                    MutableLiveData mutableLiveData;
                    if (drivingResultObject == null) {
                        cg0.a.a("ECLogisticsTraceViewModel", "requestLogisticTraceRoute", "errCode:" + i3 + ", errMsg: " + str);
                    }
                    mutableLiveData = ECLogisticsTraceViewModel$requestLogisticTraceRoute$1.this.this$0._logisticsDrivingResult;
                    mutableLiveData.postValue(drivingResultObject);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
