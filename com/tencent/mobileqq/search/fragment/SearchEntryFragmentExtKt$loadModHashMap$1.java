package com.tencent.mobileqq.search.fragment;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.search.ac;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.search.fragment.SearchEntryFragmentExtKt$loadModHashMap$1", f = "SearchEntryFragmentExt.kt", i = {}, l = {31, 33}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes18.dex */
public final class SearchEntryFragmentExtKt$loadModHashMap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Map<Integer, String>, Unit> $callback;
    final /* synthetic */ SearchEntryFragment $this_loadModHashMap;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SearchEntryFragmentExtKt$loadModHashMap$1(SearchEntryFragment searchEntryFragment, Function1<? super Map<Integer, String>, Unit> function1, Continuation<? super SearchEntryFragmentExtKt$loadModHashMap$1> continuation) {
        super(2, continuation);
        this.$this_loadModHashMap = searchEntryFragment;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SearchEntryFragmentExtKt$loadModHashMap$1(this.$this_loadModHashMap, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Manager manager;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                manager = peekAppRuntime.getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
            } else {
                manager = null;
            }
            ac acVar = (ac) manager;
            final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            if (acVar != null) {
                QLog.d("SearchEntryFragmentExt", 1, "load history,then get model list");
                final SearchEntryFragment searchEntryFragment = this.$this_loadModHashMap;
                acVar.n(new Function1<Boolean, Void>() { // from class: com.tencent.mobileqq.search.fragment.SearchEntryFragmentExtKt$loadModHashMap$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(@Nullable Boolean bool) {
                        QLog.d("SearchEntryFragmentExt", 1, "got the model");
                        SearchEntryFragment searchEntryFragment2 = SearchEntryFragment.this;
                        Map<Integer, String> result = searchEntryFragment2.getModHashMap(searchEntryFragment2.mModelList);
                        CompletableDeferred<Map<Integer, String>> completableDeferred = CompletableDeferred$default;
                        Intrinsics.checkNotNullExpressionValue(result, "result");
                        completableDeferred.complete(result);
                        return null;
                    }
                });
            } else {
                SearchEntryFragment searchEntryFragment2 = this.$this_loadModHashMap;
                Map<Integer, String> result = searchEntryFragment2.getModHashMap(searchEntryFragment2.mModelList);
                Intrinsics.checkNotNullExpressionValue(result, "result");
                CompletableDeferred$default.complete(result);
            }
            this.label = 1;
            obj = CompletableDeferred$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Function1<Map<Integer, String>, Unit> function1 = this.$callback;
        i.e eVar = i.e.f261783e;
        SearchEntryFragmentExtKt$loadModHashMap$1$2$1 searchEntryFragmentExtKt$loadModHashMap$1$2$1 = new SearchEntryFragmentExtKt$loadModHashMap$1$2$1(function1, (Map) obj, null);
        this.label = 2;
        if (CorountineFunKt.i(eVar, null, null, searchEntryFragmentExtKt$loadModHashMap$1$2$1, this, 6, null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SearchEntryFragmentExtKt$loadModHashMap$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
