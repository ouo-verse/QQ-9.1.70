package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel;

import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel.QQStrangerSquareViewModel$doCommentReply$1", f = "QQStrangerSquareViewModel.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSquareViewModel$doCommentReply$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $commentId;
    final /* synthetic */ String $content;
    final /* synthetic */ String $feedId;
    final /* synthetic */ String $openId;
    final /* synthetic */ String $replyId;
    int label;
    final /* synthetic */ QQStrangerSquareViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSquareViewModel$doCommentReply$1(QQStrangerSquareViewModel qQStrangerSquareViewModel, String str, String str2, String str3, String str4, String str5, Continuation<? super QQStrangerSquareViewModel$doCommentReply$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSquareViewModel;
        this.$openId = str;
        this.$feedId = str2;
        this.$commentId = str3;
        this.$replyId = str4;
        this.$content = str5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerSquareViewModel$doCommentReply$1(this.this$0, this.$openId, this.$feedId, this.$commentId, this.$replyId, this.$content, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQStrangerFeedRepository qQStrangerFeedRepository;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            qQStrangerFeedRepository = this.this$0.feedRepository;
            String str = this.$openId;
            String str2 = this.$feedId;
            String str3 = this.$commentId;
            String str4 = this.$replyId;
            String str5 = this.$content;
            this.label = 1;
            obj = qQStrangerFeedRepository.k(str, str2, str3, str4, str5, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.U1().postValue((QQStrangerFeedRepository.b) obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerSquareViewModel$doCommentReply$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
