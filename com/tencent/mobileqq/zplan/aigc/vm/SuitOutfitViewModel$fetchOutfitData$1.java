package com.tencent.mobileqq.zplan.aigc.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel;
import com.tencent.mobileqq.zplan.servlet.j;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel$fetchOutfitData$1", f = "SuitOutfitViewModel.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitOutfitViewModel$fetchOutfitData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $feedID;
    int label;
    final /* synthetic */ SuitOutfitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel$fetchOutfitData$1$1", f = "SuitOutfitViewModel.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel$fetchOutfitData$1$1, reason: invalid class name */
    /* loaded from: classes35.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $feedID;
        int label;
        final /* synthetic */ SuitOutfitViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, SuitOutfitViewModel suitOutfitViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$feedID = str;
            this.this$0 = suitOutfitViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$feedID, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            MutableLiveData mutableLiveData;
            MutableLiveData mutableLiveData2;
            MutableLiveData mutableLiveData3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                j jVar = j.f335411a;
                String str = this.$feedID;
                this.label = 1;
                obj = jVar.g(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bv4.a aVar = (bv4.a) obj;
            mutableLiveData = this.this$0._dressCount;
            mutableLiveData.postValue(Boxing.boxLong(aVar.f29255c.f29267c));
            mutableLiveData2 = this.this$0._outfitInfo;
            mutableLiveData2.postValue(aVar);
            mutableLiveData3 = this.this$0._fetchStatus;
            mutableLiveData3.postValue(SuitOutfitViewModel.Companion.GetFeedStatus.GET_FEED_STATUS_SUCCESS);
            QLog.d("SuitOutfitViewModel", 2, "requestSingleFeedInfo success");
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitOutfitViewModel$fetchOutfitData$1(SuitOutfitViewModel suitOutfitViewModel, String str, Continuation<? super SuitOutfitViewModel$fetchOutfitData$1> continuation) {
        super(2, continuation);
        this.this$0 = suitOutfitViewModel;
        this.$feedID = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitOutfitViewModel$fetchOutfitData$1(this.this$0, this.$feedID, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        boolean contains$default;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$feedID, this.this$0, null);
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
            QLog.e("SuitOutfitViewModel", 2, "requestSingleFeedInfo timed out.");
            mutableLiveData4 = this.this$0._fetchStatus;
            mutableLiveData4.postValue(SuitOutfitViewModel.Companion.GetFeedStatus.GET_FEED_STATUS_NET_ERROR);
        } catch (Exception e16) {
            String obj2 = e16.toString();
            QLog.e("SuitOutfitViewModel", 2, obj2);
            if (!(obj2.length() > 0)) {
                mutableLiveData = this.this$0._fetchStatus;
                mutableLiveData.postValue(SuitOutfitViewModel.Companion.GetFeedStatus.GET_FEED_STATUS_NET_ERROR);
            } else {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) obj2, (CharSequence) "-1000", false, 2, (Object) null);
                if (contains$default) {
                    mutableLiveData3 = this.this$0._fetchStatus;
                    mutableLiveData3.postValue(SuitOutfitViewModel.Companion.GetFeedStatus.GET_FEED_STATUS_IS_DELETED);
                } else {
                    mutableLiveData2 = this.this$0._fetchStatus;
                    mutableLiveData2.postValue(SuitOutfitViewModel.Companion.GetFeedStatus.GET_FEED_STATUS_NET_ERROR);
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitOutfitViewModel$fetchOutfitData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
