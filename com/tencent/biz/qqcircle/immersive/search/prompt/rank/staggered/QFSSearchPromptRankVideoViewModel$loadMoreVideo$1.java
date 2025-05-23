package com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered;

import androidx.lifecycle.MutableLiveData;
import circlesearch.CircleSearchExhibition$GetRankingDataRsp;
import com.tencent.biz.qqcircle.immersive.search.prompt.rank.QFSSearchPromptRankDataModel;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.immersive.views.searchprompt.hotrank.template.request.QFSSearchGetRankDataRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered.QFSSearchPromptRankVideoViewModel$loadMoreVideo$1", f = "QFSSearchPromptRankVideoViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class QFSSearchPromptRankVideoViewModel$loadMoreVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ QFSSearchPromptRankVideoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSSearchPromptRankVideoViewModel$loadMoreVideo$1(QFSSearchPromptRankVideoViewModel qFSSearchPromptRankVideoViewModel, Continuation<? super QFSSearchPromptRankVideoViewModel$loadMoreVideo$1> continuation) {
        super(2, continuation);
        this.this$0 = qFSSearchPromptRankVideoViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QFSSearchPromptRankVideoViewModel$loadMoreVideo$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List emptyList;
        MutableLiveData mutableLiveData;
        boolean z16;
        String str;
        boolean z17;
        ByteStringMicro byteStringMicro;
        String str2;
        List emptyList2;
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
                String tag = this.this$0.getTAG();
                z16 = this.this$0.hasMore;
                str = this.this$0.attachInfo;
                QLog.d(tag, 1, "[loadMoreVideo] hasMore=" + z16 + ", attachInfo=" + str);
                z17 = this.this$0.hasMore;
                if (!z17) {
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    QFSSearchPromptRankDataModel qFSSearchPromptRankDataModel = new QFSSearchPromptRankDataModel(true, emptyList2, false, null, 8, null);
                    mutableLiveData2 = this.this$0._appendLiveData;
                    mutableLiveData2.postValue(qFSSearchPromptRankDataModel);
                    return Unit.INSTANCE;
                }
                QFSSearchGetRankDataRequest.a aVar = new QFSSearchGetRankDataRequest.a();
                byteStringMicro = this.this$0.serverParams;
                QFSSearchGetRankDataRequest.a h16 = aVar.h(byteStringMicro.toByteArray());
                str2 = this.this$0.attachInfo;
                QFSSearchGetRankDataRequest.a g16 = h16.g(str2);
                long K0 = QFSVideoView.K0();
                if (K0 > 0) {
                    g16.e("click_id", String.valueOf(K0));
                }
                QFSSearchGetRankDataRequest request = g16.b();
                QFSSearchPromptRankVideoViewModel qFSSearchPromptRankVideoViewModel = this.this$0;
                Intrinsics.checkNotNullExpressionValue(request, "request");
                this.label = 1;
                obj = qFSSearchPromptRankVideoViewModel.f2(request, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.this$0.a2((CircleSearchExhibition$GetRankingDataRsp) obj);
        } catch (Exception e16) {
            QLog.e(this.this$0.getTAG(), 1, "[loadMoreVideo] ", e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            QFSSearchPromptRankDataModel qFSSearchPromptRankDataModel2 = new QFSSearchPromptRankDataModel(false, emptyList, false, null, 8, null);
            mutableLiveData = this.this$0._appendLiveData;
            mutableLiveData.postValue(qFSSearchPromptRankDataModel2);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QFSSearchPromptRankVideoViewModel$loadMoreVideo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
