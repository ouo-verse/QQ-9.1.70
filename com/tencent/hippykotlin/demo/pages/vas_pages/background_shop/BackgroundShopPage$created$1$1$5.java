package com.tencent.hippykotlin.demo.pages.vas_pages.background_shop;

import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.UserIDRequest;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$created$1$1$5", f = "BackgroundShopPage.kt", i = {}, l = {668}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class BackgroundShopPage$created$1$1$5 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public BackgroundShopPage L$0;
    public int label;
    public final /* synthetic */ BackgroundShopPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundShopPage$created$1$1$5(BackgroundShopPage backgroundShopPage, Continuation<? super BackgroundShopPage$created$1$1$5> continuation) {
        super(2, continuation);
        this.this$0 = backgroundShopPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BackgroundShopPage$created$1$1$5(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((BackgroundShopPage$created$1$1$5) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        BackgroundShopPage backgroundShopPage;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            KLog.INSTANCE.i("BackgroundShopPage", "vip data!");
            BackgroundShopPage backgroundShopPage2 = this.this$0;
            this.L$0 = backgroundShopPage2;
            this.label = 1;
            Object isSuperVip = new UserIDRequest().isSuperVip(backgroundShopPage2, this);
            if (isSuperVip == coroutine_suspended) {
                return coroutine_suspended;
            }
            backgroundShopPage = backgroundShopPage2;
            obj = isSuperVip;
        } else if (i3 == 1) {
            backgroundShopPage = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        backgroundShopPage.isSvip$delegate.setValue(backgroundShopPage, BackgroundShopPage.$$delegatedProperties[5], Boolean.valueOf(((Boolean) obj).booleanValue()));
        KLog.INSTANCE.i("BackgroundShopPage", "vip data! success");
        return Unit.INSTANCE;
    }
}
