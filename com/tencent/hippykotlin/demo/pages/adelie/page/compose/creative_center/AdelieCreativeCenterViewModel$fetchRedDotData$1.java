package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center;

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
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterViewModel$fetchRedDotData$1", f = "AdelieCreativeCenterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieCreativeCenterViewModel$fetchRedDotData$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ AdelieRedDotModule $adelieRedDotModule;
    public final /* synthetic */ AdelieCreativeCenterViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieCreativeCenterViewModel$fetchRedDotData$1(AdelieRedDotModule adelieRedDotModule, AdelieCreativeCenterViewModel adelieCreativeCenterViewModel, Continuation<? super AdelieCreativeCenterViewModel$fetchRedDotData$1> continuation) {
        super(2, continuation);
        this.$adelieRedDotModule = adelieRedDotModule;
        this.this$0 = adelieCreativeCenterViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieCreativeCenterViewModel$fetchRedDotData$1(this.$adelieRedDotModule, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdelieCreativeCenterViewModel$fetchRedDotData$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        AdelieRedDotModule adelieRedDotModule = this.$adelieRedDotModule;
        final AdelieCreativeCenterViewModel adelieCreativeCenterViewModel = this.this$0;
        AdelieRedDotModule.getRedDotInfoListFromNet$default(adelieRedDotModule, new Function1<List<? extends AdelieRedDotModule$Companion$RedDotInfo>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterViewModel$fetchRedDotData$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(List<? extends AdelieRedDotModule$Companion$RedDotInfo> list) {
                AdelieCreativeCenterViewModel.this.redDotList.updateValueList(list);
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
