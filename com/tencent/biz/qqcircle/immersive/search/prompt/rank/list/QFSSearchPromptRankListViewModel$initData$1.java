package com.tencent.biz.qqcircle.immersive.search.prompt.rank.list;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import circlesearch.CircleSearchExhibition$RankingPageData;
import com.tencent.biz.qqcircle.immersive.search.prompt.rank.QFSSearchPromptRankDataModel;
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
@DebugMetadata(c = "com.tencent.biz.qqcircle.immersive.search.prompt.rank.list.QFSSearchPromptRankListViewModel$initData$1", f = "QFSSearchPromptRankListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class QFSSearchPromptRankListViewModel$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    int label;
    final /* synthetic */ QFSSearchPromptRankListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSSearchPromptRankListViewModel$initData$1(Bundle bundle, QFSSearchPromptRankListViewModel qFSSearchPromptRankListViewModel, Continuation<? super QFSSearchPromptRankListViewModel$initData$1> continuation) {
        super(2, continuation);
        this.$bundle = bundle;
        this.this$0 = qFSSearchPromptRankListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QFSSearchPromptRankListViewModel$initData$1(this.$bundle, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List emptyList;
        MutableLiveData mutableLiveData;
        byte[] bArr;
        List P1;
        MutableLiveData mutableLiveData2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                Bundle bundle = this.$bundle;
                if (bundle != null) {
                    bArr = bundle.getByteArray("key_rank_page_data");
                } else {
                    bArr = null;
                }
                CircleSearchExhibition$RankingPageData circleSearchExhibition$RankingPageData = new CircleSearchExhibition$RankingPageData();
                circleSearchExhibition$RankingPageData.mergeFrom(bArr);
                QLog.d(this.this$0.getTAG(), 1, "[initData] style=" + circleSearchExhibition$RankingPageData.style);
                QFSSearchPromptRankListViewModel qFSSearchPromptRankListViewModel = this.this$0;
                List<ByteStringMicro> list = circleSearchExhibition$RankingPageData.data.get();
                Intrinsics.checkNotNullExpressionValue(list, "pageData.data.get()");
                P1 = qFSSearchPromptRankListViewModel.P1(list);
                String str = circleSearchExhibition$RankingPageData.completeRankingURL.get();
                Intrinsics.checkNotNullExpressionValue(str, "pageData.completeRankingURL.get()");
                QFSSearchPromptRankDataModel qFSSearchPromptRankDataModel = new QFSSearchPromptRankDataModel(true, P1, false, str);
                mutableLiveData2 = this.this$0._initLiveData;
                mutableLiveData2.postValue(qFSSearchPromptRankDataModel);
            } catch (Exception e16) {
                QLog.e(this.this$0.getTAG(), 1, "[initData] ", e16);
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                QFSSearchPromptRankDataModel qFSSearchPromptRankDataModel2 = new QFSSearchPromptRankDataModel(false, emptyList, false, null, 8, null);
                mutableLiveData = this.this$0._initLiveData;
                mutableLiveData.postValue(qFSSearchPromptRankDataModel2);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((QFSSearchPromptRankListViewModel$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
