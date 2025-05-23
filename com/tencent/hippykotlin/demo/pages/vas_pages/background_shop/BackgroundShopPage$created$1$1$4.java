package com.tencent.hippykotlin.demo.pages.vas_pages.background_shop;

import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.TagsItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.ShopItemRequest;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$created$1$1$4", f = "BackgroundShopPage.kt", i = {}, l = {662}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class BackgroundShopPage$created$1$1$4 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ BackgroundShopRequest $this_with;
    public BackgroundShopPage L$0;
    public int label;
    public final /* synthetic */ BackgroundShopPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundShopPage$created$1$1$4(BackgroundShopPage backgroundShopPage, BackgroundShopRequest backgroundShopRequest, Continuation<? super BackgroundShopPage$created$1$1$4> continuation) {
        super(2, continuation);
        this.this$0 = backgroundShopPage;
        this.$this_with = backgroundShopRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BackgroundShopPage$created$1$1$4(this.this$0, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((BackgroundShopPage$created$1$1$4) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        BackgroundShopPage backgroundShopPage;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            KLog.INSTANCE.i("BackgroundShopPage", "tag data!");
            BackgroundShopPage backgroundShopPage2 = this.this$0;
            BackgroundShopRequest backgroundShopRequest = this.$this_with;
            this.L$0 = backgroundShopPage2;
            this.label = 1;
            backgroundShopRequest.getClass();
            Object fetchTags = new ShopItemRequest().fetchTags(backgroundShopPage2, "8", this);
            if (fetchTags == coroutine_suspended) {
                return coroutine_suspended;
            }
            backgroundShopPage = backgroundShopPage2;
            obj = fetchTags;
        } else if (i3 == 1) {
            backgroundShopPage = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        backgroundShopPage.tagsItemData$delegate.setValue(backgroundShopPage, BackgroundShopPage.$$delegatedProperties[2], (TagsItemData) obj);
        KLog.INSTANCE.i("BackgroundShopPage", "tag data! success");
        return Unit.INSTANCE;
    }
}
