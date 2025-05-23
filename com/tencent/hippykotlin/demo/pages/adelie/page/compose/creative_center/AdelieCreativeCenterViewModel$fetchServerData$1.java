package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center;

import c45.a;
import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.coroutines.b;
import h25.af;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterViewModel$fetchServerData$1", f = "AdelieCreativeCenterViewModel.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieCreativeCenterViewModel$fetchServerData$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function1<Boolean, Unit> $callback;
    public final /* synthetic */ boolean $isLoadMore;
    public int label;
    public final /* synthetic */ AdelieCreativeCenterViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AdelieCreativeCenterViewModel$fetchServerData$1(AdelieCreativeCenterViewModel adelieCreativeCenterViewModel, boolean z16, Function1<? super Boolean, Unit> function1, Continuation<? super AdelieCreativeCenterViewModel$fetchServerData$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieCreativeCenterViewModel;
        this.$isLoadMore = z16;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieCreativeCenterViewModel$fetchServerData$1(this.this$0, this.$isLoadMore, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieCreativeCenterViewModel$fetchServerData$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.isRequesting.setValue(Boxing.boxBoolean(true));
            AdelieCreativeCenterDataManager adelieCreativeCenterDataManager = AdelieCreativeCenterDataManager.INSTANCE;
            AdelieCreativeCenterViewModel adelieCreativeCenterViewModel = this.this$0;
            a aVar = adelieCreativeCenterViewModel.rspCookie;
            String str = adelieCreativeCenterViewModel.rspDataVersion;
            boolean z16 = this.$isLoadMore;
            this.label = 1;
            obj = adelieCreativeCenterDataManager.fetchCreativeCenterServerData$qecommerce_biz_release(aVar, str, z16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OIDBResponse oIDBResponse = (OIDBResponse) obj;
        if (oIDBResponse.success && oIDBResponse.rsp != 0) {
            StateHolder<PageState> stateHolder = this.this$0.pageState;
            stateHolder._state.setValue(PageState.SUCCESS);
            this.this$0.hasFetchServerData = true;
        } else {
            StateHolder<PageState> stateHolder2 = this.this$0.pageState;
            stateHolder2._state.setValue(PageState.ERROR);
        }
        this.this$0.isRequesting.setValue(Boxing.boxBoolean(false));
        Function1<Boolean, Unit> function1 = this.$callback;
        if (function1 != null) {
            function1.invoke(Boxing.boxBoolean(oIDBResponse.success));
        }
        if (!oIDBResponse.success) {
            return Unit.INSTANCE;
        }
        af afVar = (af) oIDBResponse.rsp;
        if (afVar == null) {
            return Unit.INSTANCE;
        }
        this.this$0.parsePspData(afVar, this.$isLoadMore);
        if (!this.$isLoadMore) {
            this.this$0.updateTurboDisplayIfNeeded();
        }
        return Unit.INSTANCE;
    }
}
