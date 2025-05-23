package com.tencent.biz.qqcircle.immersive.search.prompt.guessword;

import androidx.lifecycle.MutableLiveData;
import circlesearch.CircleSearchExhibition$StPromptResp;
import com.tencent.biz.qqcircle.immersive.request.search.QFSGetSearchPromptRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$StCommonExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.qqcircle.immersive.search.prompt.guessword.QFSSearchPromptGuessWordViewModel$refresh$1", f = "QFSSearchPromptGuessWordViewModel.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class QFSSearchPromptGuessWordViewModel$refresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ QFSSearchPromptGuessWordViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSSearchPromptGuessWordViewModel$refresh$1(QFSSearchPromptGuessWordViewModel qFSSearchPromptGuessWordViewModel, Continuation<? super QFSSearchPromptGuessWordViewModel$refresh$1> continuation) {
        super(2, continuation);
        this.this$0 = qFSSearchPromptGuessWordViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QFSSearchPromptGuessWordViewModel$refresh$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        List<Integer> listOf;
        FeedCloudCommon$StCommonExt P1;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                listOf = CollectionsKt__CollectionsJVMKt.listOf(Boxing.boxInt(1));
                QFSGetSearchPromptRequest.a g16 = new QFSGetSearchPromptRequest.a().g(listOf);
                P1 = this.this$0.P1();
                QFSGetSearchPromptRequest request = g16.f(P1).b();
                QFSSearchPromptGuessWordViewModel qFSSearchPromptGuessWordViewModel = this.this$0;
                Intrinsics.checkNotNullExpressionValue(request, "request");
                this.label = 1;
                obj = qFSSearchPromptGuessWordViewModel.R1(request, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            CircleSearchExhibition$StPromptResp circleSearchExhibition$StPromptResp = (CircleSearchExhibition$StPromptResp) obj;
            QFSSearchPromptGuessWordViewModel qFSSearchPromptGuessWordViewModel2 = this.this$0;
            String str = circleSearchExhibition$StPromptResp.guess_prompt.ext_info.attachInfo.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.guess_prompt.ext_info.attachInfo.get()");
            qFSSearchPromptGuessWordViewModel2.attachInfo = str;
            mutableLiveData2 = this.this$0._guessLiveData;
            mutableLiveData2.postValue(circleSearchExhibition$StPromptResp.guess_prompt);
        } catch (Exception e16) {
            QLog.e(this.this$0.getTAG(), 1, "[refresh] ", e16);
            mutableLiveData = this.this$0._guessLiveData;
            mutableLiveData.postValue(null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QFSSearchPromptGuessWordViewModel$refresh$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
