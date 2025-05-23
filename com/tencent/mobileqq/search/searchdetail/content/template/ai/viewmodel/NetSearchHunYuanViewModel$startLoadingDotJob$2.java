package com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.searchdetail.content.template.ai.viewmodel.NetSearchHunYuanViewModel$startLoadingDotJob$2", f = "NetSearchHunYuanViewModel.kt", i = {0, 0, 0}, l = {242}, m = "invokeSuspend", n = {"$this$launch", "textArray", "index"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes18.dex */
public final class NetSearchHunYuanViewModel$startLoadingDotJob$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ NetSearchHunYuanViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetSearchHunYuanViewModel$startLoadingDotJob$2(NetSearchHunYuanViewModel netSearchHunYuanViewModel, Continuation<? super NetSearchHunYuanViewModel$startLoadingDotJob$2> continuation) {
        super(2, continuation);
        this.this$0 = netSearchHunYuanViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        NetSearchHunYuanViewModel$startLoadingDotJob$2 netSearchHunYuanViewModel$startLoadingDotJob$2 = new NetSearchHunYuanViewModel$startLoadingDotJob$2(this.this$0, continuation);
        netSearchHunYuanViewModel$startLoadingDotJob$2.L$0 = obj;
        return netSearchHunYuanViewModel$startLoadingDotJob$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        CoroutineScope coroutineScope;
        int i3;
        String[] strArr;
        MutableLiveData mutableLiveData;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                int i17 = this.I$0;
                strArr = (String[]) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                i3 = i17;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            i3 = 0;
            strArr = new String[]{"\u2022", "\u2022\u2022", "\u2022\u2022\u2022"};
        }
        while (CoroutineScopeKt.isActive(coroutineScope)) {
            mutableLiveData = this.this$0._loadingDot;
            mutableLiveData.setValue(strArr[i3]);
            i3 = (i3 + 1) % strArr.length;
            this.L$0 = coroutineScope;
            this.L$1 = strArr;
            this.I$0 = i3;
            this.label = 1;
            if (DelayKt.delay(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NetSearchHunYuanViewModel$startLoadingDotJob$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
