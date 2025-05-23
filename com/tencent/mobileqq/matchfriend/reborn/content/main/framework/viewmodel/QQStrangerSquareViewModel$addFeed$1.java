package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import java.util.List;
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
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel.QQStrangerSquareViewModel$addFeed$1", f = "QQStrangerSquareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSquareViewModel$addFeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FeedPB$Feed $feed;
    final /* synthetic */ int $index;
    int label;
    final /* synthetic */ QQStrangerSquareViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSquareViewModel$addFeed$1(QQStrangerSquareViewModel qQStrangerSquareViewModel, int i3, FeedPB$Feed feedPB$Feed, Continuation<? super QQStrangerSquareViewModel$addFeed$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSquareViewModel;
        this.$index = i3;
        this.$feed = feedPB$Feed;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerSquareViewModel$addFeed$1(this.this$0, this.$index, this.$feed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        QQStrangerFeedRepository qQStrangerFeedRepository;
        QQStrangerFeedRepository qQStrangerFeedRepository2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            qQStrangerFeedRepository = this.this$0.feedRepository;
            qQStrangerFeedRepository.g(this.$index, this.$feed);
            MutableLiveData<List<FeedPB$Feed>> a26 = this.this$0.a2();
            qQStrangerFeedRepository2 = this.this$0.feedRepository;
            a26.postValue(qQStrangerFeedRepository2.h());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerSquareViewModel$addFeed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
