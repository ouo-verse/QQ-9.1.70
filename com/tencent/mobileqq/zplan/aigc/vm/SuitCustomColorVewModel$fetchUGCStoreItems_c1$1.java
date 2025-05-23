package com.tencent.mobileqq.zplan.aigc.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel;
import com.tencent.mobileqq.zplan.servlet.p;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import uv4.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel$fetchUGCStoreItems_c1$1", f = "SuitCustomColorVewModel.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitCustomColorVewModel$fetchUGCStoreItems_c1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SuitCustomColorVewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel$fetchUGCStoreItems_c1$1$1", f = "SuitCustomColorVewModel.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.vm.SuitCustomColorVewModel$fetchUGCStoreItems_c1$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SuitCustomColorVewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SuitCustomColorVewModel suitCustomColorVewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = suitCustomColorVewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            u55.d dVar;
            String str;
            MutableLiveData mutableLiveData;
            List mutableList;
            MutableLiveData mutableLiveData2;
            MutableLiveData mutableLiveData3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                QLog.i("SuitCustomColorVewModel", 1, "fetchUGCStoreItems_c1 current page: " + (this.this$0.getCurrentPageC1() + 1));
                dVar = this.this$0.mLastStoreItemRspC1;
                if (dVar != null && !dVar.f438452c) {
                    QLog.i("SuitCustomColorVewModel", 1, "requestNextPage page:" + (this.this$0.getCurrentPageC1() + 1) + " lastRsp.hasMore:" + dVar.f438452c + ", on last page!");
                    return Unit.INSTANCE;
                }
                z zVar = new z();
                zVar.f440474b = "c:1";
                SuitCustomColorVewModel suitCustomColorVewModel = this.this$0;
                suitCustomColorVewModel.o3(suitCustomColorVewModel.getCurrentPageC1() + 1);
                zVar.f440476d = suitCustomColorVewModel.getCurrentPageC1();
                zVar.f440475c = 4;
                zVar.f440478f = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.e().b().getIndex();
                zVar.f440473a = "";
                zVar.f440479g = 1;
                zVar.f440481i = 1;
                zVar.f440482j = "avatar_mall_list";
                str = this.this$0.EXP_ZPLAN_MALL_NEW_DESIGN_TEST_B;
                zVar.f440480h = str;
                p pVar = p.f335428a;
                this.label = 1;
                obj = pVar.c(zVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u55.d dVar2 = (u55.d) obj;
            this.this$0.mLastStoreItemRspC1 = dVar2;
            mutableLiveData = this.this$0._ugcStoreItems;
            zv4.c[] cVarArr = dVar2.f438450a;
            Intrinsics.checkNotNullExpressionValue(cVarArr, "lastStoreItemRsp.storeItems");
            mutableList = ArraysKt___ArraysKt.toMutableList(cVarArr);
            mutableLiveData.postValue(mutableList);
            if (dVar2.f438452c) {
                mutableLiveData3 = this.this$0._fetchStatusC1;
                mutableLiveData3.postValue(Boxing.boxInt(SuitCustomColorVewModel.FetchSuitListStatus.SUCCESS.ordinal()));
            } else {
                mutableLiveData2 = this.this$0._fetchStatusC1;
                mutableLiveData2.postValue(Boxing.boxInt(SuitCustomColorVewModel.FetchSuitListStatus.FINISH.ordinal()));
            }
            QLog.d("SuitCustomColorVewModel", 2, "fetchUGCStoreItems success");
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitCustomColorVewModel$fetchUGCStoreItems_c1$1(SuitCustomColorVewModel suitCustomColorVewModel, Continuation<? super SuitCustomColorVewModel$fetchUGCStoreItems_c1$1> continuation) {
        super(2, continuation);
        this.this$0 = suitCustomColorVewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitCustomColorVewModel$fetchUGCStoreItems_c1$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
                this.label = 1;
                if (TimeoutKt.withTimeoutOrNull(10000L, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (TimeoutCancellationException unused) {
            mutableLiveData2 = this.this$0._fetchStatusC1;
            mutableLiveData2.postValue(Boxing.boxInt(SuitCustomColorVewModel.FetchSuitListStatus.Exception.ordinal()));
            QLog.e("SuitCustomColorVewModel", 2, "fetchUGCStoreItems timed out.");
        } catch (Exception e16) {
            mutableLiveData = this.this$0._fetchStatusC1;
            mutableLiveData.postValue(Boxing.boxInt(SuitCustomColorVewModel.FetchSuitListStatus.Exception.ordinal()));
            QLog.e("SuitCustomColorVewModel", 2, e16.toString());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitCustomColorVewModel$fetchUGCStoreItems_c1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
