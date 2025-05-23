package com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager;

import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo;
import com.tencent.kuikly.core.coroutines.b;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchRedDotData$1", f = "AdelieManagerCenterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieManagerCenterViewModel$fetchRedDotData$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ AdelieRedDotModule $adelieRedDotModule;
    public final /* synthetic */ AdelieManagerCenterViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieManagerCenterViewModel$fetchRedDotData$1(AdelieRedDotModule adelieRedDotModule, AdelieManagerCenterViewModel adelieManagerCenterViewModel, Continuation<? super AdelieManagerCenterViewModel$fetchRedDotData$1> continuation) {
        super(2, continuation);
        this.$adelieRedDotModule = adelieRedDotModule;
        this.this$0 = adelieManagerCenterViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieManagerCenterViewModel$fetchRedDotData$1(this.$adelieRedDotModule, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieManagerCenterViewModel$fetchRedDotData$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        AdelieRedDotModule adelieRedDotModule = this.$adelieRedDotModule;
        final AdelieManagerCenterViewModel adelieManagerCenterViewModel = this.this$0;
        AdelieRedDotModule.getRedDotInfoListFromNet$default(adelieRedDotModule, new Function1<List<? extends AdelieRedDotModule$Companion$RedDotInfo>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchRedDotData$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(List<? extends AdelieRedDotModule$Companion$RedDotInfo> list) {
                AdelieManagerCenterViewModel.this.redDotList.updateValueList(list);
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
