package com.tencent.hippykotlin.demo.pages.vas_pages.background_shop;

import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.b;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$created$1", f = "BackgroundShopPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class BackgroundShopPage$created$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public final /* synthetic */ BackgroundShopPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundShopPage$created$1(BackgroundShopPage backgroundShopPage, Continuation<? super BackgroundShopPage$created$1> continuation) {
        super(2, continuation);
        this.this$0 = backgroundShopPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BackgroundShopPage$created$1 backgroundShopPage$created$1 = new BackgroundShopPage$created$1(this.this$0, continuation);
        backgroundShopPage$created$1.L$0 = obj;
        return backgroundShopPage$created$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((BackgroundShopPage$created$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        b bVar = (b) this.L$0;
        BackgroundShopRequest backgroundShopRequest = new BackgroundShopRequest();
        BackgroundShopPage backgroundShopPage = this.this$0;
        BuildersKt.b(bVar, null, null, new BackgroundShopPage$created$1$1$1(backgroundShopRequest, backgroundShopPage, null), 3, null);
        BuildersKt.b(bVar, null, null, new BackgroundShopPage$created$1$1$2(backgroundShopRequest, backgroundShopPage, null), 3, null);
        BuildersKt.b(bVar, null, null, new BackgroundShopPage$created$1$1$3(backgroundShopPage, null), 3, null);
        BuildersKt.b(bVar, null, null, new BackgroundShopPage$created$1$1$4(backgroundShopPage, backgroundShopRequest, null), 3, null);
        BuildersKt.b(bVar, null, null, new BackgroundShopPage$created$1$1$5(backgroundShopPage, null), 3, null);
        return Unit.INSTANCE;
    }
}
