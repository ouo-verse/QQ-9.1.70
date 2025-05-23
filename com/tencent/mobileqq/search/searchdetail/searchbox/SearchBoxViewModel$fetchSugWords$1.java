package com.tencent.mobileqq.search.searchdetail.searchbox;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.search.searchdetail.searchbox.l;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SearchTabInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rp2.UnifySearchTabInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.searchdetail.searchbox.SearchBoxViewModel$fetchSugWords$1", f = "SearchBoxViewModel.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class SearchBoxViewModel$fetchSugWords$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ int $querySource;
    final /* synthetic */ UnifySearchTabInfo $tab;
    final /* synthetic */ int $userSource;
    int label;
    final /* synthetic */ SearchBoxViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBoxViewModel$fetchSugWords$1(SearchBoxViewModel searchBoxViewModel, String str, int i3, int i16, UnifySearchTabInfo unifySearchTabInfo, Continuation<? super SearchBoxViewModel$fetchSugWords$1> continuation) {
        super(2, continuation);
        this.this$0 = searchBoxViewModel;
        this.$keyword = str;
        this.$querySource = i3;
        this.$userSource = i16;
        this.$tab = unifySearchTabInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SearchBoxViewModel$fetchSugWords$1(this.this$0, this.$keyword, this.$querySource, this.$userSource, this.$tab, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
        List emptyList;
        MutableLiveData mutableLiveData;
        l lVar;
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
                lVar = this.this$0.repo;
                String str = this.$keyword;
                int i16 = this.$querySource;
                int i17 = this.$userSource;
                UnifySearchTabInfo unifySearchTabInfo = this.$tab;
                Result.Companion companion = Result.INSTANCE;
                SearchTabInfo searchTabInfo = new SearchTabInfo();
                searchTabInfo.tabName = unifySearchTabInfo.getTabName();
                searchTabInfo.tabMask = unifySearchTabInfo.getTabMask();
                Unit unit = Unit.INSTANCE;
                l.ExtensionDataForSearchSuggests extensionDataForSearchSuggests = new l.ExtensionDataForSearchSuggests(i16, i17);
                this.label = 1;
                obj = lVar.c(str, searchTabInfo, extensionDataForSearchSuggests, 1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            m476constructorimpl = Result.m476constructorimpl((List) obj);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("QQSearch.NetDetail.SearchBoxViewModel", 1, " get fetchSugWords failed " + m479exceptionOrNullimpl);
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = emptyList;
        }
        mutableLiveData = this.this$0._netSuggestWord;
        mutableLiveData.postValue((List) m476constructorimpl);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SearchBoxViewModel$fetchSugWords$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
