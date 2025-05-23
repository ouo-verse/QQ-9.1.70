package com.tencent.mobileqq.zplan.aio.panel.page;

import com.tencent.mobileqq.zplan.aio.panel.item.view.ItemView;
import com.tencent.mobileqq.zplan.aio.panel.item.view.ThumbnailIcon;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.page.PageAdapter$bind$1$5", f = "PageAdapter.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class PageAdapter$bind$1$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.zplan.aio.panel.item.b $item;
    final /* synthetic */ ItemView $this_apply;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageAdapter$bind$1$5(ItemView itemView, com.tencent.mobileqq.zplan.aio.panel.item.b bVar, Continuation<? super PageAdapter$bind$1$5> continuation) {
        super(2, continuation);
        this.$this_apply = itemView;
        this.$item = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageAdapter$bind$1$5(this.$this_apply, this.$item, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ThumbnailIcon thumbnailIcon;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            this.$this_apply.getIconView().setLoading(true);
            ThumbnailIcon iconView = this.$this_apply.getIconView();
            Deferred<Boolean> d16 = this.$item.d();
            this.L$0 = iconView;
            this.label = 1;
            Object await = d16.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            thumbnailIcon = iconView;
            obj = await;
        } else if (i3 == 1) {
            thumbnailIcon = (ThumbnailIcon) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        thumbnailIcon.setLoading(!((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PageAdapter$bind$1$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
