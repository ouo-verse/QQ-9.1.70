package com.tencent.mobileqq.zplan.minihome.repository;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.zplan.minihome.MiniHomeInfoObserver;
import com.tencent.mobileqq.zplan.minihome.ai;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import q55.d;
import r55.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.repository.MiniHomeViewModel$fetchMiniHomeInfo$2", f = "MiniHomeViewModel.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class MiniHomeViewModel$fetchMiniHomeInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<d> $cacheInfo;
    final /* synthetic */ String $uin;
    int label;
    final /* synthetic */ MiniHomeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeViewModel$fetchMiniHomeInfo$2(String str, Ref.ObjectRef<d> objectRef, MiniHomeViewModel miniHomeViewModel, Continuation<? super MiniHomeViewModel$fetchMiniHomeInfo$2> continuation) {
        super(2, continuation);
        this.$uin = str;
        this.$cacheInfo = objectRef;
        this.this$0 = miniHomeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeViewModel$fetchMiniHomeInfo$2(this.$uin, this.$cacheInfo, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        a aVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            MiniHomeInfoObserver miniHomeInfoObserver = MiniHomeInfoObserver.f334284c;
            String str = this.$uin;
            this.label = 1;
            obj = miniHomeInfoObserver.g(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        d dVar = (d) obj;
        if (dVar != null) {
            String str2 = this.$uin;
            Ref.ObjectRef<d> objectRef = this.$cacheInfo;
            MiniHomeViewModel miniHomeViewModel = this.this$0;
            QLog.i("MiniHomeViewModel", 1, "fetchMiniHomeInfoFromNet success, uin: " + str2 + ", rsp: " + dVar);
            d dVar2 = objectRef.element;
            if (dVar2 != null) {
                a aVar2 = dVar2.f428438b;
                String str3 = aVar2 != null ? aVar2.f430773a : null;
                a aVar3 = dVar.f428438b;
                if (Intrinsics.areEqual(str3, aVar3 != null ? aVar3.f430773a : null)) {
                    a aVar4 = objectRef.element.f428438b;
                    String str4 = aVar4 != null ? aVar4.f430773a : null;
                    a aVar5 = dVar.f428438b;
                    QLog.i("MiniHomeViewModel", 1, "hash same, no need update cache. uin: " + str2 + ", cacheHash: " + str4 + ", updatedHash: " + (aVar5 != null ? aVar5.f430773a : null) + ", rsp: " + dVar);
                }
            }
            d dVar3 = objectRef.element;
            String str5 = (dVar3 == null || (aVar = dVar3.f428438b) == null) ? null : aVar.f430773a;
            a aVar6 = dVar.f428438b;
            QLog.i("MiniHomeViewModel", 1, "hash updated, update cache, uin: " + str2 + ", cacheHash: " + str5 + ", updatedHash: " + (aVar6 != null ? aVar6.f430773a : null) + ", rsp: " + dVar);
            mutableLiveData = miniHomeViewModel._miniHomeInfo;
            mutableLiveData.setValue(ai.a(dVar));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MiniHomeViewModel$fetchMiniHomeInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
