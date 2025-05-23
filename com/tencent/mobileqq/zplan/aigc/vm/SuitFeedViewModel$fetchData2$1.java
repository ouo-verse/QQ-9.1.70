package com.tencent.mobileqq.zplan.aigc.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitFeedViewModel$fetchData2$1", f = "SuitFeedViewModel.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitFeedViewModel$fetchData2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SuitFeedViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitFeedViewModel$fetchData2$1(SuitFeedViewModel suitFeedViewModel, Continuation<? super SuitFeedViewModel$fetchData2$1> continuation) {
        super(2, continuation);
        this.this$0 = suitFeedViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitFeedViewModel$fetchData2$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0114 A[Catch: Exception -> 0x0016, TryCatch #0 {Exception -> 0x0016, blocks: (B:5:0x0012, B:6:0x003f, B:8:0x0053, B:10:0x0068, B:13:0x0074, B:15:0x0077, B:16:0x0093, B:19:0x009a, B:22:0x00f3, B:24:0x0114, B:25:0x012f, B:27:0x0122, B:38:0x0025), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0122 A[Catch: Exception -> 0x0016, TryCatch #0 {Exception -> 0x0016, blocks: (B:5:0x0012, B:6:0x003f, B:8:0x0053, B:10:0x0068, B:13:0x0074, B:15:0x0077, B:16:0x0093, B:19:0x009a, B:22:0x00f3, B:24:0x0114, B:25:0x012f, B:27:0x0122, B:38:0x0025), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        boolean z16;
        List e26;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
        int i3;
        MutableLiveData mutableLiveData6;
        List listOf;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        try {
            if (i16 == 0) {
                ResultKt.throwOnFailure(obj);
                ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
                String value = this.this$0.W1().getValue();
                Intrinsics.checkNotNull(value);
                this.label = 1;
                obj = zPlanAIGCRequest.j(value, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i16 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            iu4.h hVar = (iu4.h) obj;
            if (!Intrinsics.areEqual(hVar.f408780a, this.this$0.W1().getValue())) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.this$0.X1());
                iu4.a[] aVarArr = hVar.f408782c;
                if (aVarArr != null) {
                    Intrinsics.checkNotNullExpressionValue(aVarArr, "rsp.activity");
                    if (!(aVarArr.length == 0)) {
                        SuitFeedViewModel suitFeedViewModel = this.this$0;
                        iu4.a aVar = hVar.f408782c[0];
                        Intrinsics.checkNotNullExpressionValue(aVar, "rsp.activity[0]");
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(suitFeedViewModel.d2(aVar));
                        arrayList.addAll(listOf);
                        z16 = true;
                        SuitFeedViewModel suitFeedViewModel2 = this.this$0;
                        boolean z17 = !z16;
                        iu4.b[] bVarArr = hVar.f408781b;
                        Intrinsics.checkNotNullExpressionValue(bVarArr, "rsp.feeds");
                        e26 = suitFeedViewModel2.e2(z17, bVarArr);
                        arrayList.addAll(e26);
                        QLog.d("SuitFeedViewModel", 2, "requestFeedItems currentEtag: " + this.this$0.W1() + "," + hVar.f408780a + "," + hVar.f408781b.length + ", isFinish:" + hVar.f408783d);
                        mutableLiveData2 = this.this$0._finishFlag;
                        mutableLiveData2.postValue(Boxing.boxBoolean(hVar.f408783d != 1));
                        mutableLiveData3 = this.this$0._dataList2;
                        mutableLiveData3.postValue(arrayList);
                        mutableLiveData4 = this.this$0._currentETag;
                        mutableLiveData4.postValue(hVar.f408780a);
                        if (hVar.f408783d != 1) {
                            mutableLiveData6 = this.this$0._fetchStatus;
                            mutableLiveData6.postValue(Boxing.boxInt(2));
                        } else {
                            mutableLiveData5 = this.this$0._fetchStatus;
                            mutableLiveData5.postValue(Boxing.boxInt(0));
                        }
                        SuitFeedViewModel suitFeedViewModel3 = this.this$0;
                        i3 = suitFeedViewModel3.currentPage;
                        suitFeedViewModel3.currentPage = i3 + 1;
                    }
                }
                z16 = false;
                SuitFeedViewModel suitFeedViewModel22 = this.this$0;
                if (!z16) {
                }
                iu4.b[] bVarArr2 = hVar.f408781b;
                Intrinsics.checkNotNullExpressionValue(bVarArr2, "rsp.feeds");
                e26 = suitFeedViewModel22.e2(z17, bVarArr2);
                arrayList.addAll(e26);
                QLog.d("SuitFeedViewModel", 2, "requestFeedItems currentEtag: " + this.this$0.W1() + "," + hVar.f408780a + "," + hVar.f408781b.length + ", isFinish:" + hVar.f408783d);
                mutableLiveData2 = this.this$0._finishFlag;
                mutableLiveData2.postValue(Boxing.boxBoolean(hVar.f408783d != 1));
                mutableLiveData3 = this.this$0._dataList2;
                mutableLiveData3.postValue(arrayList);
                mutableLiveData4 = this.this$0._currentETag;
                mutableLiveData4.postValue(hVar.f408780a);
                if (hVar.f408783d != 1) {
                }
                SuitFeedViewModel suitFeedViewModel32 = this.this$0;
                i3 = suitFeedViewModel32.currentPage;
                suitFeedViewModel32.currentPage = i3 + 1;
            }
        } catch (Exception e16) {
            QLog.d("SuitFeedViewModel", 2, e16.toString());
            mutableLiveData = this.this$0._fetchStatus;
            mutableLiveData.postValue(Boxing.boxInt(3));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitFeedViewModel$fetchData2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
