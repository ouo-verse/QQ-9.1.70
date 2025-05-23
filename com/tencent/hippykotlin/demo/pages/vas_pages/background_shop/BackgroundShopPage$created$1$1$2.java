package com.tencent.hippykotlin.demo.pages.vas_pages.background_shop;

import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.ItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.TittleItemData;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.vas_pages.background_shop.BackgroundShopPage$created$1$1$2", f = "BackgroundShopPage.kt", i = {}, l = {596}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class BackgroundShopPage$created$1$1$2 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ BackgroundShopRequest $this_with;
    public int label;
    public final /* synthetic */ BackgroundShopPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundShopPage$created$1$1$2(BackgroundShopRequest backgroundShopRequest, BackgroundShopPage backgroundShopPage, Continuation<? super BackgroundShopPage$created$1$1$2> continuation) {
        super(2, continuation);
        this.$this_with = backgroundShopRequest;
        this.this$0 = backgroundShopPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BackgroundShopPage$created$1$1$2(this.$this_with, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((BackgroundShopPage$created$1$1$2) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            KLog.INSTANCE.i("BackgroundShopPage", "first data!");
            BackgroundShopRequest backgroundShopRequest = this.$this_with;
            BackgroundShopPage backgroundShopPage = this.this$0;
            this.label = 1;
            obj = backgroundShopRequest.firstRequest(backgroundShopPage, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List<ItemData> list = (List) obj;
        KLog.INSTANCE.i("BackgroundShopPage", "first data! success");
        if (!list.isEmpty()) {
            BackgroundShopPage.access$getFirstData(this.this$0).clear();
            BackgroundShopPage backgroundShopPage2 = this.this$0;
            int i16 = 0;
            for (ItemData itemData : list) {
                if (itemData instanceof TittleItemData) {
                    i16++;
                }
                if (i16 == 1) {
                    itemData.moduleId = "3";
                } else if (i16 == 2) {
                    itemData.moduleId = "4";
                } else if (i16 == 3) {
                    itemData.moduleId = "5";
                } else if (i16 == 4) {
                    itemData.moduleId = "19";
                } else if (i16 == 5) {
                    itemData.moduleId = "17";
                }
                if (i16 >= 3) {
                    BackgroundShopPage.access$getMoreData(backgroundShopPage2).add(itemData);
                } else {
                    BackgroundShopPage.access$getFirstData(backgroundShopPage2).add(itemData);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
