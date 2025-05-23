package com.tencent.qqnt.aio.helper;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.helper.DiscussionChatHelper$deleteDiscuss$2", f = "DiscussionChatHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
final class DiscussionChatHelper$deleteDiscuss$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ com.tencent.mobileqq.app.n $dm;
    final /* synthetic */ String $uin;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscussionChatHelper$deleteDiscuss$2(com.tencent.mobileqq.app.n nVar, String str, Continuation<? super DiscussionChatHelper$deleteDiscuss$2> continuation) {
        super(2, continuation);
        this.$dm = nVar;
        this.$uin = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiscussionChatHelper$deleteDiscuss$2(this.$dm, this.$uin, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z16 = false;
            try {
                boolean d16 = this.$dm.d(this.$uin);
                boolean z17 = d16;
                QLog.i("DiscussionChatHelper", 1, "deleteDiscuss, result=" + z17 + ", uin=" + this.$uin);
                z16 = d16;
            } catch (Exception e16) {
                QLog.e("DiscussionChatHelper", 1, "deleteDiscuss, exception, uin=" + this.$uin, e16);
            }
            return Boxing.boxBoolean(z16);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((DiscussionChatHelper$deleteDiscuss$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
