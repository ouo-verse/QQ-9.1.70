package com.tencent.mobileqq.zplan.aio.panel.page;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.zplan.aio.panel.item.Identifying;
import com.tencent.mobileqq.zplan.aio.panel.item.view.ItemView;
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
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.page.PageAdapter$bind$1$3$1", f = "PageAdapter.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class PageAdapter$bind$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Identifying $identifyingData;
    final /* synthetic */ ItemView $this_apply;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageAdapter$bind$1$3$1(ItemView itemView, Identifying identifying, Continuation<? super PageAdapter$bind$1$3$1> continuation) {
        super(2, continuation);
        this.$this_apply = itemView;
        this.$identifyingData = identifying;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageAdapter$bind$1$3$1(this.$this_apply, this.$identifyingData, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        View view;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            View identifyingIcon = this.$this_apply.getIdentifyingIcon();
            Deferred<Drawable> a16 = this.$identifyingData.a();
            this.L$0 = identifyingIcon;
            this.label = 1;
            Object await = a16.await(this);
            if (await == coroutine_suspended) {
                return coroutine_suspended;
            }
            view = identifyingIcon;
            obj = await;
        } else if (i3 == 1) {
            view = (View) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        view.setBackground((Drawable) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PageAdapter$bind$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
